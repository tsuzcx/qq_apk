package com.tencent.mm.chatroom.plugin;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.f.a.oq;
import com.tencent.mm.f.a.os;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.x;
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
  private com.tencent.mm.chatroom.e.c iXa;
  private com.tencent.mm.chatroom.e.b iXb;
  private IListener<oq> iXc;
  private IListener iXd;
  private IListener iXe;
  private IListener iXf;
  private IListener iXg;
  private i.a iXh;
  private com.tencent.mm.plugin.messenger.foundation.a.i iXi;
  private d iXj;
  private c.a iXk;
  private com.tencent.mm.chatroom.storage.f iXl;
  private com.tencent.mm.chatroom.c.b iXm;
  private com.tencent.mm.chatroom.storage.b iXn;
  
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
    this.iXa = new com.tencent.mm.chatroom.e.c();
    this.iXb = new com.tencent.mm.chatroom.e.b();
    this.iXc = new IListener() {};
    this.iXd = new PluginChatroomUI.6(this);
    this.iXe = new PluginChatroomUI.7(this);
    this.iXf = new PluginChatroomUI.8(this);
    this.iXg = new IListener() {};
    this.iXh = new i.a()
    {
      public final void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(188414);
        if ((paramAnonymousi == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(188414);
          return;
        }
        if (("delete".equals(paramAnonymousc.EVM)) && (paramAnonymousc.kvM != null))
        {
          paramAnonymousi = paramAnonymousc.kvM.iterator();
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
            paramAnonymousi = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().Kv(paramAnonymousc.talker);
            if ((paramAnonymousi == null) || (paramAnonymousi.field_queryState == 0)) {
              break label201;
            }
            paramAnonymousi.field_queryState = 0;
          }
          label201:
          for (boolean bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(paramAnonymousi, new String[0]);; bool = false)
          {
            paramAnonymousc = Util.nullAs(paramAnonymousc.talker, "");
            if (paramAnonymousi == null) {}
            for (paramAnonymousi = "null";; paramAnonymousi = "not_null")
            {
              Log.i("MicroMsg.roomtools.PluginChatroomUI", "onNotifyChange roomName:%s groupTools:%s result:%s", new Object[] { paramAnonymousc, paramAnonymousi, Boolean.valueOf(bool) });
              AppMethodBeat.o(188414);
              return;
            }
            Log.d("MicroMsg.roomtools.PluginChatroomUI", "no need reset");
            AppMethodBeat.o(188414);
            return;
          }
        }
      }
    };
    this.iXi = new PluginChatroomUI.2(this);
    this.iXj = null;
    this.iXk = null;
    this.iXl = null;
    this.iXm = null;
    this.iXn = null;
    AppMethodBeat.o(182125);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(12506);
    Log.i("MicroMsg.PluginChatroomUI", "[execute]");
    pin(b.ash());
    if (paramg.aIE())
    {
      h.b(w.class, new com.tencent.mm.chatroom.b.b());
      h.b(x.class, new com.tencent.mm.chatroom.b.c());
    }
    if ((paramg.aIE()) || (paramg.MY(":tools")) || (paramg.MY(":toolsmp")) || (paramg.MZ(":appbrand"))) {
      h.b(com.tencent.mm.plugin.messenger.foundation.a.e.class, new com.tencent.mm.chatroom.b.a());
    }
    AppMethodBeat.o(12506);
  }
  
  public com.tencent.mm.chatroom.storage.b getGroupBindAppStorage()
  {
    AppMethodBeat.i(187222);
    h.aHE().aGH();
    if (this.iXn == null)
    {
      h.aHH();
      this.iXn = new com.tencent.mm.chatroom.storage.b(h.aHG().kcF);
    }
    com.tencent.mm.chatroom.storage.b localb = this.iXn;
    AppMethodBeat.o(187222);
    return localb;
  }
  
  public d getGroupTodoStorage()
  {
    AppMethodBeat.i(182128);
    h.aHE().aGH();
    if (this.iXj == null)
    {
      h.aHH();
      this.iXj = new d(h.aHG().kcF);
    }
    d locald = this.iXj;
    AppMethodBeat.o(182128);
    return locald;
  }
  
  public com.tencent.mm.chatroom.storage.f getGroupToolsStorage()
  {
    AppMethodBeat.i(182130);
    h.aHE().aGH();
    if (this.iXl == null)
    {
      h.aHH();
      this.iXl = new com.tencent.mm.chatroom.storage.f(h.aHG().kcF);
    }
    com.tencent.mm.chatroom.storage.f localf = this.iXl;
    AppMethodBeat.o(182130);
    return localf;
  }
  
  public com.tencent.mm.chatroom.c.b getOpenImMigrateService()
  {
    AppMethodBeat.i(187216);
    h.aHE().aGH();
    com.tencent.mm.chatroom.c.b localb = this.iXm;
    AppMethodBeat.o(187216);
    return localb;
  }
  
  public c.a getRoomTodoMsgService()
  {
    AppMethodBeat.i(182129);
    h.aHE().aGH();
    if (this.iXk == null) {
      this.iXk = new c.a();
    }
    c.a locala = this.iXk;
    AppMethodBeat.o(182129);
    return locala;
  }
  
  public void handleChatroomBackup(String paramString)
  {
    AppMethodBeat.i(185972);
    if ((aa.asf()) && (ab.PP(paramString)))
    {
      Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup talker:%s", new Object[] { paramString });
      paramString = aa.Kq(paramString);
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
      Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(paramString, new String[0])) });
    }
    AppMethodBeat.o(185972);
  }
  
  public void handleGroupTodoByReceiverAppMsg(ca paramca)
  {
    AppMethodBeat.i(184788);
    if (ab.PP(paramca.field_talker))
    {
      Object localObject = k.b.OQ(paramca.field_content);
      if (localObject == null)
      {
        Log.d("MicroMsg.roomTodo.PluginChatroomUI", "content is null");
        AppMethodBeat.o(184788);
        return;
      }
      localObject = (com.tencent.mm.aj.a)((k.b)localObject).ar(com.tencent.mm.aj.a.class);
      if (Util.isNullOrNil(((com.tencent.mm.aj.a)localObject).lkm)) {}
      for (localObject = "related_msgid_" + paramca.field_msgSvrId; ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().am(paramca.field_talker, (String)localObject) == null; localObject = ((com.tencent.mm.aj.a)localObject).lkm)
      {
        Log.d("MicroMsg.roomTodo.PluginChatroomUI", "groupTodo is null");
        AppMethodBeat.o(184788);
        return;
      }
      ca localca = ((n)h.ae(n.class)).eSe().Oq(paramca.field_msgId);
      localca.Jy((String)localObject);
      ((n)h.ae(n.class)).eSe().a(localca.field_msgId, localca);
      Log.d("MicroMsg.roomTodo.PluginChatroomUI", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(paramca.field_msgSvrId), Long.valueOf(localca.field_msgId) });
    }
    AppMethodBeat.o(184788);
  }
  
  public void handleGroupToolByReceiverAppMsg(ca paramca)
  {
    AppMethodBeat.i(185971);
    if ((aa.asf()) && (ab.PP(paramca.field_talker)))
    {
      k.b localb = k.b.OQ(paramca.field_content);
      if (localb == null)
      {
        Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) content is null", new Object[] { paramca.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      com.tencent.mm.chatroom.storage.e locale = aa.Kq(paramca.field_talker);
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
        boolean bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
        Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg room:%s result:%s", new Object[] { paramca.field_talker, Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(185971);
  }
  
  public String name()
  {
    return "ui-chatroom";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(182126);
    Log.d("MicroMsg.PluginChatroomUI", "onAccountInitialized");
    ((n)h.ae(n.class)).eSe().a(this.iXh, Looper.getMainLooper());
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("roomtoolstips", this.iXa);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("IMUnionRoom2AssociateRoom", this.iXb);
    this.iXc.alive();
    this.iXd.alive();
    this.iXe.alive();
    this.iXf.alive();
    this.iXg.alive();
    ((n)h.ae(n.class)).bbL().add(getGroupToolsStorage());
    ((n)h.ae(n.class)).bbR().add(getGroupToolsStorage());
    this.iXm = new com.tencent.mm.chatroom.c.b();
    ((n)h.ae(n.class)).bbR().a(this.iXi);
    AppMethodBeat.o(182126);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(182127);
    Log.d("MicroMsg.PluginChatroomUI", "onAccountRelease");
    ((n)h.ae(n.class)).eSe().a(this.iXh);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("roomtoolstips", this.iXa);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("IMUnionRoom2AssociateRoom", this.iXb);
    this.iXc.dead();
    this.iXd.dead();
    this.iXe.dead();
    this.iXf.dead();
    this.iXg.dead();
    ((n)h.ae(n.class)).bbL().remove(getGroupToolsStorage());
    ((n)h.ae(n.class)).bbR().remove(getGroupToolsStorage());
    ((n)h.ae(n.class)).bbR().b(this.iXi);
    AppMethodBeat.o(182127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.PluginChatroomUI
 * JD-Core Version:    0.7.0.1
 */