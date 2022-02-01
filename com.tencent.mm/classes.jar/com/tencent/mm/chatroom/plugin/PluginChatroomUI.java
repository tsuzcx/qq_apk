package com.tencent.mm.chatroom.plugin;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PluginChatroomUI
  extends com.tencent.mm.kernel.b.f
  implements a, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.chatroom.e.b fLA;
  private com.tencent.mm.sdk.b.c<nb> fLB;
  private com.tencent.mm.sdk.b.c fLC;
  private com.tencent.mm.sdk.b.c fLD;
  private com.tencent.mm.sdk.b.c fLE;
  private com.tencent.mm.sdk.b.c fLF;
  private i.a fLG;
  private com.tencent.mm.plugin.messenger.foundation.a.g fLH;
  private d fLI;
  private c.a fLJ;
  private com.tencent.mm.chatroom.storage.f fLK;
  private com.tencent.mm.chatroom.c.b fLL;
  private com.tencent.mm.chatroom.storage.b fLM;
  private com.tencent.mm.chatroom.e.c fLz;
  
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
    baseDBFactories.put(Integer.valueOf("GROUPBNINDAPP_TABLE".hashCode()), new PluginChatroomUI.4());
    AppMethodBeat.o(182131);
  }
  
  public PluginChatroomUI()
  {
    AppMethodBeat.i(182125);
    this.fLz = new com.tencent.mm.chatroom.e.c();
    this.fLA = new com.tencent.mm.chatroom.e.b();
    this.fLB = new com.tencent.mm.sdk.b.c() {};
    this.fLC = new com.tencent.mm.sdk.b.c() {};
    this.fLD = new com.tencent.mm.sdk.b.c() {};
    this.fLE = new com.tencent.mm.sdk.b.c() {};
    this.fLF = new com.tencent.mm.sdk.b.c() {};
    this.fLG = new i.a()
    {
      public final void a(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(213420);
        if ((paramAnonymousi == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(213420);
          return;
        }
        if (("delete".equals(paramAnonymousc.vKe)) && (paramAnonymousc.gNE != null))
        {
          paramAnonymousi = paramAnonymousc.gNE.iterator();
          do
          {
            if (!paramAnonymousi.hasNext()) {
              break;
            }
          } while (!aa.i((bu)paramAnonymousi.next()));
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramAnonymousi = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().uR(paramAnonymousc.talker);
            if ((paramAnonymousi == null) || (paramAnonymousi.field_queryState == 0)) {
              break label201;
            }
            paramAnonymousi.field_queryState = 0;
          }
          label201:
          for (boolean bool = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(paramAnonymousi, new String[0]);; bool = false)
          {
            paramAnonymousc = bt.bI(paramAnonymousc.talker, "");
            if (paramAnonymousi == null) {}
            for (paramAnonymousi = "null";; paramAnonymousi = "not_null")
            {
              ad.i("MicroMsg.roomtools.PluginChatroomUI", "onNotifyChange roomName:%s groupTools:%s result:%s", new Object[] { paramAnonymousc, paramAnonymousi, Boolean.valueOf(bool) });
              AppMethodBeat.o(213420);
              return;
            }
            ad.d("MicroMsg.roomtools.PluginChatroomUI", "no need reset");
            AppMethodBeat.o(213420);
            return;
          }
        }
      }
    };
    this.fLH = new com.tencent.mm.plugin.messenger.foundation.a.g()
    {
      public final void a(bu paramAnonymousbu, i.c paramAnonymousc, boolean[] paramAnonymousArrayOfBoolean) {}
      
      public final void a(bu paramAnonymousbu, at paramAnonymousat, boolean paramAnonymousBoolean, i.c paramAnonymousc)
      {
        AppMethodBeat.i(213417);
        if (paramAnonymousBoolean)
        {
          ad.i("MicroMsg.PluginChatroomUI", "new conversation %s", new Object[] { paramAnonymousat.field_username });
          q.yY(paramAnonymousat.field_username);
        }
        AppMethodBeat.o(213417);
      }
      
      public final void b(bu paramAnonymousbu, at paramAnonymousat, boolean paramAnonymousBoolean, i.c paramAnonymousc) {}
    };
    this.fLI = null;
    this.fLJ = null;
    this.fLK = null;
    this.fLL = null;
    this.fLM = null;
    AppMethodBeat.o(182125);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(12506);
    ad.i("MicroMsg.PluginChatroomUI", "[execute]");
    pin(b.Yj());
    if (paramg.akw())
    {
      com.tencent.mm.kernel.g.b(s.class, new com.tencent.mm.chatroom.b.b());
      com.tencent.mm.kernel.g.b(t.class, new com.tencent.mm.chatroom.b.c());
    }
    if ((paramg.akw()) || (paramg.xf(":tools")) || (paramg.xf(":toolsmp")) || (paramg.xg(":appbrand"))) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.c.class, new com.tencent.mm.chatroom.b.a());
    }
    AppMethodBeat.o(12506);
  }
  
  public com.tencent.mm.chatroom.storage.b getGroupBindAppStorage()
  {
    AppMethodBeat.i(213422);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.fLM == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.fLM = new com.tencent.mm.chatroom.storage.b(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.chatroom.storage.b localb = this.fLM;
    AppMethodBeat.o(213422);
    return localb;
  }
  
  public d getGroupTodoStorage()
  {
    AppMethodBeat.i(182128);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.fLI == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.fLI = new d(com.tencent.mm.kernel.g.ajC().gBq);
    }
    d locald = this.fLI;
    AppMethodBeat.o(182128);
    return locald;
  }
  
  public com.tencent.mm.chatroom.storage.f getGroupToolsStorage()
  {
    AppMethodBeat.i(182130);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.fLK == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.fLK = new com.tencent.mm.chatroom.storage.f(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.chatroom.storage.f localf = this.fLK;
    AppMethodBeat.o(182130);
    return localf;
  }
  
  public com.tencent.mm.chatroom.c.b getOpenImMigrateService()
  {
    AppMethodBeat.i(213421);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.chatroom.c.b localb = this.fLL;
    AppMethodBeat.o(213421);
    return localb;
  }
  
  public c.a getRoomTodoMsgService()
  {
    AppMethodBeat.i(182129);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.fLJ == null) {
      this.fLJ = new c.a();
    }
    c.a locala = this.fLJ;
    AppMethodBeat.o(182129);
    return locala;
  }
  
  public void handleChatroomBackup(String paramString)
  {
    AppMethodBeat.i(185972);
    if ((aa.Yh()) && (w.zk(paramString)))
    {
      ad.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup talker:%s", new Object[] { paramString });
      paramString = aa.uN(paramString);
      if (paramString == null)
      {
        ad.d("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup groupTools is null");
        AppMethodBeat.o(185972);
        return;
      }
      if (paramString.field_queryState == 0)
      {
        ad.d("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup groupTools is COL_STATE_NEED_QUERY");
        AppMethodBeat.o(185972);
        return;
      }
      paramString.field_queryState = 0;
      ad.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(paramString, new String[0])) });
    }
    AppMethodBeat.o(185972);
  }
  
  public void handleGroupTodoByReceiverAppMsg(bu parambu)
  {
    AppMethodBeat.i(184788);
    if (w.zk(parambu.field_talker))
    {
      Object localObject = k.b.yr(parambu.field_content);
      if (localObject == null)
      {
        ad.d("MicroMsg.roomTodo.PluginChatroomUI", "content is null");
        AppMethodBeat.o(184788);
        return;
      }
      localObject = (com.tencent.mm.ai.a)((k.b)localObject).ao(com.tencent.mm.ai.a.class);
      if (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject).hyi)) {}
      for (localObject = "related_msgid_" + parambu.field_msgSvrId; ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(parambu.field_talker, (String)localObject) == null; localObject = ((com.tencent.mm.ai.a)localObject).hyi)
      {
        ad.d("MicroMsg.roomTodo.PluginChatroomUI", "groupTodo is null");
        AppMethodBeat.o(184788);
        return;
      }
      bu localbu = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(parambu.field_msgId);
      localbu.tZ((String)localObject);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(localbu.field_msgId, localbu);
      ad.d("MicroMsg.roomTodo.PluginChatroomUI", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(parambu.field_msgSvrId), Long.valueOf(localbu.field_msgId) });
    }
    AppMethodBeat.o(184788);
  }
  
  public void handleGroupToolByReceiverAppMsg(bu parambu)
  {
    AppMethodBeat.i(185971);
    if ((aa.Yh()) && (w.zk(parambu.field_talker)))
    {
      k.b localb = k.b.yr(parambu.field_content);
      if (localb == null)
      {
        ad.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) content is null", new Object[] { parambu.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      com.tencent.mm.chatroom.storage.e locale = aa.uN(parambu.field_talker);
      if (locale == null)
      {
        ad.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is null", new Object[] { parambu.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      if (locale.field_queryState == 0)
      {
        ad.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { parambu.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      GroupToolItem localGroupToolItem = null;
      if ((com.tencent.mm.modelappbrand.a.b(localb)) || (com.tencent.mm.modelappbrand.a.c(localb))) {
        localGroupToolItem = aa.g(parambu);
      }
      if (aa.h(parambu)) {
        localGroupToolItem = new GroupToolItem("roomaa@app.origin", "", parambu.field_createTime);
      }
      if (localGroupToolItem != null)
      {
        locale.a(localGroupToolItem);
        boolean bool = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
        ad.i("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg room:%s result:%s", new Object[] { parambu.field_talker, Boolean.valueOf(bool) });
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
    ad.d("MicroMsg.PluginChatroomUI", "onAccountInitialized");
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.fLG, Looper.getMainLooper());
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("roomtoolstips", this.fLz);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("IMUnionRoom2AssociateRoom", this.fLA);
    this.fLB.alive();
    this.fLC.alive();
    this.fLD.alive();
    this.fLE.alive();
    this.fLF.alive();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().a(getGroupToolsStorage());
    this.fLL = new com.tencent.mm.chatroom.c.b();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a(this.fLH);
    AppMethodBeat.o(182126);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(182127);
    ad.d("MicroMsg.PluginChatroomUI", "onAccountRelease");
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.fLG);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("roomtoolstips", this.fLz);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("IMUnionRoom2AssociateRoom", this.fLA);
    this.fLB.dead();
    this.fLC.dead();
    this.fLD.dead();
    this.fLE.dead();
    this.fLF.dead();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().b(getGroupToolsStorage());
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().b(this.fLH);
    AppMethodBeat.o(182127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.PluginChatroomUI
 * JD-Core Version:    0.7.0.1
 */