package com.tencent.mm.chatroom.plugin;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PluginChatroomUI
  extends com.tencent.mm.kernel.b.f
  implements a, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.chatroom.e.c fND;
  private com.tencent.mm.chatroom.e.b fNE;
  private com.tencent.mm.sdk.b.c<nc> fNF;
  private com.tencent.mm.sdk.b.c fNG;
  private com.tencent.mm.sdk.b.c fNH;
  private com.tencent.mm.sdk.b.c fNI;
  private com.tencent.mm.sdk.b.c fNJ;
  private i.a fNK;
  private com.tencent.mm.plugin.messenger.foundation.a.g fNL;
  private d fNM;
  private c.a fNN;
  private com.tencent.mm.chatroom.storage.f fNO;
  private com.tencent.mm.chatroom.c.b fNP;
  private com.tencent.mm.chatroom.storage.b fNQ;
  
  static
  {
    AppMethodBeat.i(182131);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("GROUPTOODO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("GROUPTOOLS_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.chatroom.storage.f.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("GROUPBNINDAPP_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.chatroom.storage.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(182131);
  }
  
  public PluginChatroomUI()
  {
    AppMethodBeat.i(182125);
    this.fND = new com.tencent.mm.chatroom.e.c();
    this.fNE = new com.tencent.mm.chatroom.e.b();
    this.fNF = new com.tencent.mm.sdk.b.c() {};
    this.fNG = new com.tencent.mm.sdk.b.c() {};
    this.fNH = new com.tencent.mm.sdk.b.c() {};
    this.fNI = new com.tencent.mm.sdk.b.c() {};
    this.fNJ = new com.tencent.mm.sdk.b.c() {};
    this.fNK = new i.a()
    {
      public final void a(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(217133);
        if ((paramAnonymousi == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(217133);
          return;
        }
        if (("delete".equals(paramAnonymousc.vWi)) && (paramAnonymousc.gQn != null))
        {
          paramAnonymousi = paramAnonymousc.gQn.iterator();
          do
          {
            if (!paramAnonymousi.hasNext()) {
              break;
            }
          } while (!aa.i((bv)paramAnonymousi.next()));
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramAnonymousi = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().vn(paramAnonymousc.talker);
            if ((paramAnonymousi == null) || (paramAnonymousi.field_queryState == 0)) {
              break label201;
            }
            paramAnonymousi.field_queryState = 0;
          }
          label201:
          for (boolean bool = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(paramAnonymousi, new String[0]);; bool = false)
          {
            paramAnonymousc = bu.bI(paramAnonymousc.talker, "");
            if (paramAnonymousi == null) {}
            for (paramAnonymousi = "null";; paramAnonymousi = "not_null")
            {
              ae.i("MicroMsg.roomtools.PluginChatroomUI", "onNotifyChange roomName:%s groupTools:%s result:%s", new Object[] { paramAnonymousc, paramAnonymousi, Boolean.valueOf(bool) });
              AppMethodBeat.o(217133);
              return;
            }
            ae.d("MicroMsg.roomtools.PluginChatroomUI", "no need reset");
            AppMethodBeat.o(217133);
            return;
          }
        }
      }
    };
    this.fNL = new com.tencent.mm.plugin.messenger.foundation.a.g()
    {
      public final void a(bv paramAnonymousbv, i.c paramAnonymousc, boolean[] paramAnonymousArrayOfBoolean) {}
      
      public final void a(bv paramAnonymousbv, au paramAnonymousau, boolean paramAnonymousBoolean, i.c paramAnonymousc)
      {
        AppMethodBeat.i(217130);
        if (paramAnonymousBoolean)
        {
          ae.i("MicroMsg.PluginChatroomUI", "new conversation %s", new Object[] { paramAnonymousau.field_username });
          r.zI(paramAnonymousau.field_username);
        }
        AppMethodBeat.o(217130);
      }
      
      public final void b(bv paramAnonymousbv, au paramAnonymousau, boolean paramAnonymousBoolean, i.c paramAnonymousc) {}
    };
    this.fNM = null;
    this.fNN = null;
    this.fNO = null;
    this.fNP = null;
    this.fNQ = null;
    AppMethodBeat.o(182125);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(12506);
    ae.i("MicroMsg.PluginChatroomUI", "[execute]");
    pin(b.Yt());
    if (paramg.akL())
    {
      com.tencent.mm.kernel.g.b(t.class, new com.tencent.mm.chatroom.b.b());
      com.tencent.mm.kernel.g.b(u.class, new com.tencent.mm.chatroom.b.c());
    }
    if ((paramg.akL()) || (paramg.xO(":tools")) || (paramg.xO(":toolsmp")) || (paramg.xP(":appbrand"))) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.c.class, new com.tencent.mm.chatroom.b.a());
    }
    AppMethodBeat.o(12506);
  }
  
  public com.tencent.mm.chatroom.storage.b getGroupBindAppStorage()
  {
    AppMethodBeat.i(217135);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.fNQ == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.fNQ = new com.tencent.mm.chatroom.storage.b(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.chatroom.storage.b localb = this.fNQ;
    AppMethodBeat.o(217135);
    return localb;
  }
  
  public d getGroupTodoStorage()
  {
    AppMethodBeat.i(182128);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.fNM == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.fNM = new d(com.tencent.mm.kernel.g.ajR().gDX);
    }
    d locald = this.fNM;
    AppMethodBeat.o(182128);
    return locald;
  }
  
  public com.tencent.mm.chatroom.storage.f getGroupToolsStorage()
  {
    AppMethodBeat.i(182130);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.fNO == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.fNO = new com.tencent.mm.chatroom.storage.f(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.chatroom.storage.f localf = this.fNO;
    AppMethodBeat.o(182130);
    return localf;
  }
  
  public com.tencent.mm.chatroom.c.b getOpenImMigrateService()
  {
    AppMethodBeat.i(217134);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.chatroom.c.b localb = this.fNP;
    AppMethodBeat.o(217134);
    return localb;
  }
  
  public c.a getRoomTodoMsgService()
  {
    AppMethodBeat.i(182129);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.fNN == null) {
      this.fNN = new c.a();
    }
    c.a locala = this.fNN;
    AppMethodBeat.o(182129);
    return locala;
  }
  
  public void handleChatroomBackup(String paramString)
  {
    AppMethodBeat.i(185972);
    if ((aa.Yr()) && (x.zU(paramString)))
    {
      ae.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup talker:%s", new Object[] { paramString });
      paramString = aa.vi(paramString);
      if (paramString == null)
      {
        ae.d("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup groupTools is null");
        AppMethodBeat.o(185972);
        return;
      }
      if (paramString.field_queryState == 0)
      {
        ae.d("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup groupTools is COL_STATE_NEED_QUERY");
        AppMethodBeat.o(185972);
        return;
      }
      paramString.field_queryState = 0;
      ae.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(paramString, new String[0])) });
    }
    AppMethodBeat.o(185972);
  }
  
  public void handleGroupTodoByReceiverAppMsg(bv parambv)
  {
    AppMethodBeat.i(184788);
    if (x.zU(parambv.field_talker))
    {
      Object localObject = k.b.zb(parambv.field_content);
      if (localObject == null)
      {
        ae.d("MicroMsg.roomTodo.PluginChatroomUI", "content is null");
        AppMethodBeat.o(184788);
        return;
      }
      localObject = (com.tencent.mm.ah.a)((k.b)localObject).ao(com.tencent.mm.ah.a.class);
      if (bu.isNullOrNil(((com.tencent.mm.ah.a)localObject).hAW)) {}
      for (localObject = "related_msgid_" + parambv.field_msgSvrId; ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(parambv.field_talker, (String)localObject) == null; localObject = ((com.tencent.mm.ah.a)localObject).hAW)
      {
        ae.d("MicroMsg.roomTodo.PluginChatroomUI", "groupTodo is null");
        AppMethodBeat.o(184788);
        return;
      }
      bv localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(parambv.field_msgId);
      localbv.uu((String)localObject);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(localbv.field_msgId, localbv);
      ae.d("MicroMsg.roomTodo.PluginChatroomUI", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(parambv.field_msgSvrId), Long.valueOf(localbv.field_msgId) });
    }
    AppMethodBeat.o(184788);
  }
  
  public void handleGroupToolByReceiverAppMsg(bv parambv)
  {
    AppMethodBeat.i(185971);
    if ((aa.Yr()) && (x.zU(parambv.field_talker)))
    {
      k.b localb = k.b.zb(parambv.field_content);
      if (localb == null)
      {
        ae.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) content is null", new Object[] { parambv.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      com.tencent.mm.chatroom.storage.e locale = aa.vi(parambv.field_talker);
      if (locale == null)
      {
        ae.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is null", new Object[] { parambv.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      if (locale.field_queryState == 0)
      {
        ae.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { parambv.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      GroupToolItem localGroupToolItem = null;
      if ((com.tencent.mm.modelappbrand.a.b(localb)) || (com.tencent.mm.modelappbrand.a.c(localb))) {
        localGroupToolItem = aa.g(parambv);
      }
      if (aa.h(parambv)) {
        localGroupToolItem = new GroupToolItem("roomaa@app.origin", "", parambv.field_createTime);
      }
      if (localGroupToolItem != null)
      {
        locale.a(localGroupToolItem);
        boolean bool = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
        ae.i("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg room:%s result:%s", new Object[] { parambv.field_talker, Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(185971);
  }
  
  public String name()
  {
    return "ui-chatroom";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(182126);
    ae.d("MicroMsg.PluginChatroomUI", "onAccountInitialized");
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.fNK, Looper.getMainLooper());
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("roomtoolstips", this.fND);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("IMUnionRoom2AssociateRoom", this.fNE);
    this.fNF.alive();
    this.fNG.alive();
    this.fNH.alive();
    this.fNI.alive();
    this.fNJ.alive();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().a(getGroupToolsStorage());
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a(getGroupToolsStorage());
    this.fNP = new com.tencent.mm.chatroom.c.b();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a(this.fNL);
    AppMethodBeat.o(182126);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(182127);
    ae.d("MicroMsg.PluginChatroomUI", "onAccountRelease");
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.fNK);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("roomtoolstips", this.fND);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("IMUnionRoom2AssociateRoom", this.fNE);
    this.fNF.dead();
    this.fNG.dead();
    this.fNH.dead();
    this.fNI.dead();
    this.fNJ.dead();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().b(getGroupToolsStorage());
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().b(getGroupToolsStorage());
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().b(this.fNL);
    AppMethodBeat.o(182127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.PluginChatroomUI
 * JD-Core Version:    0.7.0.1
 */