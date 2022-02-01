package com.tencent.mm.chatroom.plugin;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PluginChatroomUI
  extends com.tencent.mm.kernel.b.f
  implements a, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.chatroom.e.c fsZ;
  private com.tencent.mm.chatroom.e.b fta;
  private com.tencent.mm.sdk.b.c<mt> ftb;
  private com.tencent.mm.sdk.b.c ftc;
  private com.tencent.mm.sdk.b.c ftd;
  private com.tencent.mm.sdk.b.c fte;
  private com.tencent.mm.sdk.b.c ftf;
  private h.a ftg;
  private com.tencent.mm.chatroom.storage.b fth;
  private c.a fti;
  private d ftj;
  private com.tencent.mm.chatroom.c.b ftk;
  private com.tencent.mm.plugin.messenger.foundation.a.f iOx;
  
  static
  {
    AppMethodBeat.i(182131);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("GROUPTOODO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.chatroom.storage.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("GROUPTOOLS_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    AppMethodBeat.o(182131);
  }
  
  public PluginChatroomUI()
  {
    AppMethodBeat.i(182125);
    this.fsZ = new com.tencent.mm.chatroom.e.c();
    this.fta = new com.tencent.mm.chatroom.e.b();
    this.ftb = new com.tencent.mm.sdk.b.c() {};
    this.ftc = new com.tencent.mm.sdk.b.c() {};
    this.ftd = new com.tencent.mm.sdk.b.c() {};
    this.fte = new com.tencent.mm.sdk.b.c() {};
    this.ftf = new com.tencent.mm.sdk.b.c() {};
    this.ftg = new h.a()
    {
      public final void a(h paramAnonymoush, h.c paramAnonymousc)
      {
        AppMethodBeat.i(185970);
        if ((paramAnonymoush == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(185970);
          return;
        }
        if (("delete".equals(paramAnonymousc.uHb)) && (paramAnonymousc.gtT != null))
        {
          paramAnonymoush = paramAnonymousc.gtT.iterator();
          do
          {
            if (!paramAnonymoush.hasNext()) {
              break;
            }
          } while (!aa.i((bo)paramAnonymoush.next()));
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramAnonymoush = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().sb(paramAnonymousc.talker);
            if ((paramAnonymoush == null) || (paramAnonymoush.field_queryState == 0)) {
              break label201;
            }
            paramAnonymoush.field_queryState = 0;
          }
          label201:
          for (boolean bool = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(paramAnonymoush, new String[0]);; bool = false)
          {
            paramAnonymousc = bs.bG(paramAnonymousc.talker, "");
            if (paramAnonymoush == null) {}
            for (paramAnonymoush = "null";; paramAnonymoush = "not_null")
            {
              ac.i("MicroMsg.roomtools.PluginChatroomUI", "onNotifyChange roomName:%s groupTools:%s result:%s", new Object[] { paramAnonymousc, paramAnonymoush, Boolean.valueOf(bool) });
              AppMethodBeat.o(185970);
              return;
            }
            ac.d("MicroMsg.roomtools.PluginChatroomUI", "no need reset");
            AppMethodBeat.o(185970);
            return;
          }
        }
      }
    };
    this.iOx = new PluginChatroomUI.9(this);
    this.fth = null;
    this.fti = null;
    this.ftj = null;
    this.ftk = null;
    AppMethodBeat.o(182125);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(12506);
    ac.i("MicroMsg.PluginChatroomUI", "[execute]");
    pin(b.VS());
    if (paramg.ahL())
    {
      com.tencent.mm.kernel.g.b(r.class, new com.tencent.mm.chatroom.b.a());
      com.tencent.mm.kernel.g.b(s.class, new com.tencent.mm.chatroom.b.b());
    }
    AppMethodBeat.o(12506);
  }
  
  public com.tencent.mm.chatroom.storage.b getGroupTodoStorage()
  {
    AppMethodBeat.i(182128);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.fth == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.fth = new com.tencent.mm.chatroom.storage.b(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.chatroom.storage.b localb = this.fth;
    AppMethodBeat.o(182128);
    return localb;
  }
  
  public d getGroupToolsStorage()
  {
    AppMethodBeat.i(182130);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.ftj == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.ftj = new d(com.tencent.mm.kernel.g.agR().ghG);
    }
    d locald = this.ftj;
    AppMethodBeat.o(182130);
    return locald;
  }
  
  public com.tencent.mm.chatroom.c.b getOpenImMigrateService()
  {
    AppMethodBeat.i(197045);
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.chatroom.c.b localb = this.ftk;
    AppMethodBeat.o(197045);
    return localb;
  }
  
  public c.a getRoomTodoMsgService()
  {
    AppMethodBeat.i(182129);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.fti == null) {
      this.fti = new c.a();
    }
    c.a locala = this.fti;
    AppMethodBeat.o(182129);
    return locala;
  }
  
  public void handleChatroomBackup(String paramString)
  {
    AppMethodBeat.i(185972);
    if ((aa.VQ()) && (w.wp(paramString)))
    {
      ac.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup talker:%s", new Object[] { paramString });
      paramString = aa.rZ(paramString);
      if (paramString == null)
      {
        ac.d("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup groupTools is null");
        AppMethodBeat.o(185972);
        return;
      }
      if (paramString.field_queryState == 0)
      {
        ac.d("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup groupTools is COL_STATE_NEED_QUERY");
        AppMethodBeat.o(185972);
        return;
      }
      paramString.field_queryState = 0;
      ac.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(paramString, new String[0])) });
    }
    AppMethodBeat.o(185972);
  }
  
  public void handleGroupTodoByReceiverAppMsg(bo parambo)
  {
    AppMethodBeat.i(184788);
    if (w.wp(parambo.field_talker))
    {
      Object localObject = k.b.vA(parambo.field_content);
      if (localObject == null)
      {
        ac.d("MicroMsg.roomTodo.PluginChatroomUI", "content is null");
        AppMethodBeat.o(184788);
        return;
      }
      localObject = (com.tencent.mm.ah.a)((k.b)localObject).ao(com.tencent.mm.ah.a.class);
      if (bs.isNullOrNil(((com.tencent.mm.ah.a)localObject).hga)) {}
      for (localObject = "related_msgid_" + parambo.field_msgSvrId; ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupTodoStorage().af(parambo.field_talker, (String)localObject) == null; localObject = ((com.tencent.mm.ah.a)localObject).hga)
      {
        ac.d("MicroMsg.roomTodo.PluginChatroomUI", "groupTodo is null");
        AppMethodBeat.o(184788);
        return;
      }
      bo localbo = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(parambo.field_msgId);
      localbo.rn((String)localObject);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(localbo.field_msgId, localbo);
      ac.d("MicroMsg.roomTodo.PluginChatroomUI", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(parambo.field_msgSvrId), Long.valueOf(localbo.field_msgId) });
    }
    AppMethodBeat.o(184788);
  }
  
  public void handleGroupToolByReceiverAppMsg(bo parambo)
  {
    AppMethodBeat.i(185971);
    if ((aa.VQ()) && (w.wp(parambo.field_talker)))
    {
      k.b localb = k.b.vA(parambo.field_content);
      if (localb == null)
      {
        ac.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) content is null", new Object[] { parambo.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      com.tencent.mm.chatroom.storage.c localc = aa.rZ(parambo.field_talker);
      if (localc == null)
      {
        ac.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is null", new Object[] { parambo.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      if (localc.field_queryState == 0)
      {
        ac.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { parambo.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      GroupToolItem localGroupToolItem = null;
      if ((com.tencent.mm.modelappbrand.a.b(localb)) || (com.tencent.mm.modelappbrand.a.c(localb))) {
        localGroupToolItem = aa.g(parambo);
      }
      if (aa.h(parambo)) {
        localGroupToolItem = new GroupToolItem("roomaa@app.origin", "", parambo.field_createTime);
      }
      if (localGroupToolItem != null)
      {
        localc.b(localGroupToolItem);
        boolean bool = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc, new String[0]);
        ac.i("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg room:%s result:%s", new Object[] { parambo.field_talker, Boolean.valueOf(bool) });
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
    ac.d("MicroMsg.PluginChatroomUI", "onAccountInitialized");
    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(this.ftg, Looper.getMainLooper());
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("roomtoolstips", this.fsZ);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("IMUnionRoom2AssociateRoom", this.fta);
    this.ftb.alive();
    this.ftc.alive();
    this.ftd.alive();
    this.fte.alive();
    this.ftf.alive();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().a(getGroupToolsStorage());
    this.ftk = new com.tencent.mm.chatroom.c.b();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().a(this.iOx);
    AppMethodBeat.o(182126);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(182127);
    ac.d("MicroMsg.PluginChatroomUI", "onAccountRelease");
    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(this.ftg);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("roomtoolstips", this.fsZ);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("IMUnionRoom2AssociateRoom", this.fta);
    this.ftb.dead();
    this.ftc.dead();
    this.ftd.dead();
    this.fte.dead();
    this.ftf.dead();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().b(getGroupToolsStorage());
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().b(this.iOx);
    AppMethodBeat.o(182127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.PluginChatroomUI
 * JD-Core Version:    0.7.0.1
 */