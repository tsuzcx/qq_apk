package com.tencent.mm.chatroom.plugin;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PluginChatroomUI
  extends com.tencent.mm.kernel.b.f
  implements a, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.chatroom.e.c gsO;
  private com.tencent.mm.chatroom.e.b gsP;
  private IListener<nt> gsQ;
  private IListener gsR;
  private IListener gsS;
  private IListener gsT;
  private IListener gsU;
  private i.a gsV;
  private com.tencent.mm.plugin.messenger.foundation.a.g gsW;
  private d gsX;
  private c.a gsY;
  private com.tencent.mm.chatroom.storage.f gsZ;
  private com.tencent.mm.chatroom.c.b gta;
  private com.tencent.mm.chatroom.storage.b gtb;
  
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
    this.gsO = new com.tencent.mm.chatroom.e.c();
    this.gsP = new com.tencent.mm.chatroom.e.b();
    this.gsQ = new IListener() {};
    this.gsR = new PluginChatroomUI.6(this);
    this.gsS = new PluginChatroomUI.7(this);
    this.gsT = new PluginChatroomUI.8(this);
    this.gsU = new IListener() {};
    this.gsV = new i.a()
    {
      public final void a(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(194047);
        if ((paramAnonymousi == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(194047);
          return;
        }
        if (("delete".equals(paramAnonymousc.zqn)) && (paramAnonymousc.hIs != null))
        {
          paramAnonymousi = paramAnonymousc.hIs.iterator();
          do
          {
            if (!paramAnonymousi.hasNext()) {
              break;
            }
          } while (!aa.i((ca)paramAnonymousi.next()));
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramAnonymousi = ((PluginChatroomUI)com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(paramAnonymousc.talker);
            if ((paramAnonymousi == null) || (paramAnonymousi.field_queryState == 0)) {
              break label201;
            }
            paramAnonymousi.field_queryState = 0;
          }
          label201:
          for (boolean bool = ((PluginChatroomUI)com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(paramAnonymousi, new String[0]);; bool = false)
          {
            paramAnonymousc = Util.nullAs(paramAnonymousc.talker, "");
            if (paramAnonymousi == null) {}
            for (paramAnonymousi = "null";; paramAnonymousi = "not_null")
            {
              Log.i("MicroMsg.roomtools.PluginChatroomUI", "onNotifyChange roomName:%s groupTools:%s result:%s", new Object[] { paramAnonymousc, paramAnonymousi, Boolean.valueOf(bool) });
              AppMethodBeat.o(194047);
              return;
            }
            Log.d("MicroMsg.roomtools.PluginChatroomUI", "no need reset");
            AppMethodBeat.o(194047);
            return;
          }
        }
      }
    };
    this.gsW = new PluginChatroomUI.2(this);
    this.gsX = null;
    this.gsY = null;
    this.gsZ = null;
    this.gta = null;
    this.gtb = null;
    AppMethodBeat.o(182125);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(12506);
    Log.i("MicroMsg.PluginChatroomUI", "[execute]");
    pin(b.amg());
    if (paramg.aBb())
    {
      com.tencent.mm.kernel.g.b(t.class, new com.tencent.mm.chatroom.b.b());
      com.tencent.mm.kernel.g.b(u.class, new com.tencent.mm.chatroom.b.c());
    }
    if ((paramg.aBb()) || (paramg.FY(":tools")) || (paramg.FY(":toolsmp")) || (paramg.FZ(":appbrand"))) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.c.class, new com.tencent.mm.chatroom.b.a());
    }
    AppMethodBeat.o(12506);
  }
  
  public com.tencent.mm.chatroom.storage.b getGroupBindAppStorage()
  {
    AppMethodBeat.i(194049);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.gtb == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.gtb = new com.tencent.mm.chatroom.storage.b(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.chatroom.storage.b localb = this.gtb;
    AppMethodBeat.o(194049);
    return localb;
  }
  
  public d getGroupTodoStorage()
  {
    AppMethodBeat.i(182128);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.gsX == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.gsX = new d(com.tencent.mm.kernel.g.aAh().hqK);
    }
    d locald = this.gsX;
    AppMethodBeat.o(182128);
    return locald;
  }
  
  public com.tencent.mm.chatroom.storage.f getGroupToolsStorage()
  {
    AppMethodBeat.i(182130);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.gsZ == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.gsZ = new com.tencent.mm.chatroom.storage.f(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.chatroom.storage.f localf = this.gsZ;
    AppMethodBeat.o(182130);
    return localf;
  }
  
  public com.tencent.mm.chatroom.c.b getOpenImMigrateService()
  {
    AppMethodBeat.i(194048);
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.chatroom.c.b localb = this.gta;
    AppMethodBeat.o(194048);
    return localb;
  }
  
  public c.a getRoomTodoMsgService()
  {
    AppMethodBeat.i(182129);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.gsY == null) {
      this.gsY = new c.a();
    }
    c.a locala = this.gsY;
    AppMethodBeat.o(182129);
    return locala;
  }
  
  public void handleChatroomBackup(String paramString)
  {
    AppMethodBeat.i(185972);
    if ((aa.ame()) && (ab.Ix(paramString)))
    {
      Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup talker:%s", new Object[] { paramString });
      paramString = aa.Dz(paramString);
      if (paramString == null)
      {
        Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup groupTools is null");
        AppMethodBeat.o(185972);
        return;
      }
      if (paramString.field_queryState == 0)
      {
        Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup groupTools is COL_STATE_NEED_QUERY");
        AppMethodBeat.o(185972);
        return;
      }
      paramString.field_queryState = 0;
      Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(paramString, new String[0])) });
    }
    AppMethodBeat.o(185972);
  }
  
  public void handleGroupTodoByReceiverAppMsg(ca paramca)
  {
    AppMethodBeat.i(184788);
    if (ab.Ix(paramca.field_talker))
    {
      Object localObject = k.b.HD(paramca.field_content);
      if (localObject == null)
      {
        Log.d("MicroMsg.roomTodo.PluginChatroomUI", "content is null");
        AppMethodBeat.o(184788);
        return;
      }
      localObject = (com.tencent.mm.ag.a)((k.b)localObject).as(com.tencent.mm.ag.a.class);
      if (Util.isNullOrNil(((com.tencent.mm.ag.a)localObject).ivd)) {}
      for (localObject = "related_msgid_" + paramca.field_msgSvrId; ((PluginChatroomUI)com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(paramca.field_talker, (String)localObject) == null; localObject = ((com.tencent.mm.ag.a)localObject).ivd)
      {
        Log.d("MicroMsg.roomTodo.PluginChatroomUI", "groupTodo is null");
        AppMethodBeat.o(184788);
        return;
      }
      ca localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(paramca.field_msgId);
      localca.CK((String)localObject);
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(localca.field_msgId, localca);
      Log.d("MicroMsg.roomTodo.PluginChatroomUI", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(paramca.field_msgSvrId), Long.valueOf(localca.field_msgId) });
    }
    AppMethodBeat.o(184788);
  }
  
  public void handleGroupToolByReceiverAppMsg(ca paramca)
  {
    AppMethodBeat.i(185971);
    if ((aa.ame()) && (ab.Ix(paramca.field_talker)))
    {
      k.b localb = k.b.HD(paramca.field_content);
      if (localb == null)
      {
        Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) content is null", new Object[] { paramca.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      com.tencent.mm.chatroom.storage.e locale = aa.Dz(paramca.field_talker);
      if (locale == null)
      {
        Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is null", new Object[] { paramca.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      if (locale.field_queryState == 0)
      {
        Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { paramca.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      GroupToolItem localGroupToolItem = null;
      if ((com.tencent.mm.modelappbrand.a.b(localb)) || (com.tencent.mm.modelappbrand.a.c(localb))) {
        localGroupToolItem = aa.g(paramca);
      }
      if (aa.h(paramca)) {
        localGroupToolItem = new GroupToolItem("roomaa@app.origin", "", paramca.field_createTime);
      }
      if (localGroupToolItem != null)
      {
        locale.a(localGroupToolItem);
        boolean bool = ((PluginChatroomUI)com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
        Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg room:%s result:%s", new Object[] { paramca.field_talker, Boolean.valueOf(bool) });
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
    Log.d("MicroMsg.PluginChatroomUI", "onAccountInitialized");
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.gsV, Looper.getMainLooper());
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("roomtoolstips", this.gsO);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("IMUnionRoom2AssociateRoom", this.gsP);
    this.gsQ.alive();
    this.gsR.alive();
    this.gsS.alive();
    this.gsT.alive();
    this.gsU.alive();
    ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().add(getGroupToolsStorage());
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().add(getGroupToolsStorage());
    this.gta = new com.tencent.mm.chatroom.c.b();
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().a(this.gsW);
    AppMethodBeat.o(182126);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(182127);
    Log.d("MicroMsg.PluginChatroomUI", "onAccountRelease");
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.gsV);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("roomtoolstips", this.gsO);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("IMUnionRoom2AssociateRoom", this.gsP);
    this.gsQ.dead();
    this.gsR.dead();
    this.gsS.dead();
    this.gsT.dead();
    this.gsU.dead();
    ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().remove(getGroupToolsStorage());
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().remove(getGroupToolsStorage());
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().b(this.gsW);
    AppMethodBeat.o(182127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.PluginChatroomUI
 * JD-Core Version:    0.7.0.1
 */