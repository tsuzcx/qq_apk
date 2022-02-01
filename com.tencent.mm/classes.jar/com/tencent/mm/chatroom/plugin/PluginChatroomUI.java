package com.tencent.mm.chatroom.plugin;

import android.os.Looper;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.lb;
import com.tencent.mm.autogen.a.qa;
import com.tencent.mm.autogen.a.qc;
import com.tencent.mm.autogen.a.vm;
import com.tencent.mm.autogen.a.vn;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.d.ad;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PluginChatroomUI
  extends com.tencent.mm.kernel.b.f
  implements a, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.chatroom.e.c lzd;
  private com.tencent.mm.chatroom.e.b lze;
  private IListener<qa> lzf;
  private IListener lzg;
  private IListener lzh;
  private IListener lzi;
  private IListener lzj;
  private i.a lzk;
  private com.tencent.mm.plugin.messenger.foundation.a.i lzl;
  private d lzm;
  private c.a lzn;
  private com.tencent.mm.chatroom.storage.f lzo;
  private com.tencent.mm.chatroom.c.b lzp;
  private com.tencent.mm.chatroom.storage.b lzq;
  
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
    this.lzd = new com.tencent.mm.chatroom.e.c();
    this.lze = new com.tencent.mm.chatroom.e.b();
    this.lzf = new IListener(com.tencent.mm.app.f.hfK) {};
    this.lzg = new IListener(com.tencent.mm.app.f.hfK) {};
    this.lzh = new IListener(com.tencent.mm.app.f.hfK) {};
    this.lzi = new IListener(com.tencent.mm.app.f.hfK) {};
    this.lzj = new IListener(com.tencent.mm.app.f.hfK) {};
    this.lzk = new i.a()
    {
      public final void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(241376);
        if ((paramAnonymousi == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(241376);
          return;
        }
        if (("delete".equals(paramAnonymousc.KRm)) && (paramAnonymousc.mZo != null))
        {
          paramAnonymousi = paramAnonymousc.mZo.iterator();
          do
          {
            if (!paramAnonymousi.hasNext()) {
              break;
            }
          } while (!ad.i((cc)paramAnonymousi.next()));
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramAnonymousi = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().Db(paramAnonymousc.talker);
            if ((paramAnonymousi == null) || (paramAnonymousi.field_queryState == 0)) {
              break label201;
            }
            paramAnonymousi.field_queryState = 0;
          }
          label201:
          for (boolean bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(paramAnonymousi, new String[0]);; bool = false)
          {
            paramAnonymousc = Util.nullAs(paramAnonymousc.talker, "");
            if (paramAnonymousi == null) {}
            for (paramAnonymousi = "null";; paramAnonymousi = "not_null")
            {
              Log.i("MicroMsg.roomtools.PluginChatroomUI", "onNotifyChange roomName:%s groupTools:%s result:%s", new Object[] { paramAnonymousc, paramAnonymousi, Boolean.valueOf(bool) });
              AppMethodBeat.o(241376);
              return;
            }
            Log.d("MicroMsg.roomtools.PluginChatroomUI", "no need reset");
            AppMethodBeat.o(241376);
            return;
          }
        }
      }
    };
    this.lzl = new com.tencent.mm.plugin.messenger.foundation.a.i()
    {
      public final void a(cc paramAnonymouscc, i.c paramAnonymousc, boolean[] paramAnonymousArrayOfBoolean) {}
      
      public final void a(cc paramAnonymouscc, bb paramAnonymousbb, boolean paramAnonymousBoolean, i.c paramAnonymousc)
      {
        AppMethodBeat.i(241363);
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.PluginChatroomUI", "new conversation %s", new Object[] { paramAnonymousbb.field_username });
          com.tencent.mm.model.v.Iu(paramAnonymousbb.field_username);
        }
        AppMethodBeat.o(241363);
      }
      
      public final void b(cc paramAnonymouscc, bb paramAnonymousbb, boolean paramAnonymousBoolean, i.c paramAnonymousc) {}
    };
    this.lzm = null;
    this.lzn = null;
    this.lzo = null;
    this.lzp = null;
    this.lzq = null;
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
    pin(b.aMb());
    if (paramg.bbA())
    {
      h.b(w.class, new com.tencent.mm.chatroom.b.b());
      h.b(x.class, new com.tencent.mm.chatroom.b.c());
    }
    if ((paramg.bbA()) || (paramg.FH(":tools")) || (paramg.FH(":toolsmp")) || (paramg.FI(":appbrand"))) {
      h.b(com.tencent.mm.plugin.messenger.foundation.a.e.class, new com.tencent.mm.chatroom.b.a());
    }
    AppMethodBeat.o(12506);
  }
  
  public com.tencent.mm.chatroom.storage.b getGroupBindAppStorage()
  {
    AppMethodBeat.i(241409);
    h.baC().aZJ();
    if (this.lzq == null)
    {
      h.baF();
      this.lzq = new com.tencent.mm.chatroom.storage.b(h.baE().mCN);
    }
    com.tencent.mm.chatroom.storage.b localb = this.lzq;
    AppMethodBeat.o(241409);
    return localb;
  }
  
  public d getGroupTodoStorage()
  {
    AppMethodBeat.i(182128);
    h.baC().aZJ();
    if (this.lzm == null)
    {
      h.baF();
      this.lzm = new d(h.baE().mCN);
    }
    d locald = this.lzm;
    AppMethodBeat.o(182128);
    return locald;
  }
  
  public com.tencent.mm.chatroom.storage.f getGroupToolsStorage()
  {
    AppMethodBeat.i(182130);
    h.baC().aZJ();
    if (this.lzo == null)
    {
      h.baF();
      this.lzo = new com.tencent.mm.chatroom.storage.f(h.baE().mCN);
    }
    com.tencent.mm.chatroom.storage.f localf = this.lzo;
    AppMethodBeat.o(182130);
    return localf;
  }
  
  public com.tencent.mm.chatroom.c.b getOpenImMigrateService()
  {
    AppMethodBeat.i(241404);
    h.baC().aZJ();
    com.tencent.mm.chatroom.c.b localb = this.lzp;
    AppMethodBeat.o(241404);
    return localb;
  }
  
  public c.a getRoomTodoMsgService()
  {
    AppMethodBeat.i(182129);
    h.baC().aZJ();
    if (this.lzn == null) {
      this.lzn = new c.a();
    }
    c.a locala = this.lzn;
    AppMethodBeat.o(182129);
    return locala;
  }
  
  public void handleChatroomBackup(String paramString)
  {
    AppMethodBeat.i(185972);
    if (au.bwG(paramString))
    {
      Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup talker:%s", new Object[] { paramString });
      paramString = ad.CV(paramString);
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
      Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(paramString, new String[0])) });
    }
    AppMethodBeat.o(185972);
  }
  
  public void handleGroupTodoByReceiverAppMsg(cc paramcc)
  {
    AppMethodBeat.i(184788);
    if (au.bwG(paramcc.field_talker))
    {
      Object localObject = k.b.Hf(paramcc.field_content);
      if (localObject == null)
      {
        Log.d("MicroMsg.roomTodo.PluginChatroomUI", "content is null");
        AppMethodBeat.o(184788);
        return;
      }
      localObject = (com.tencent.mm.message.a)((k.b)localObject).aK(com.tencent.mm.message.a.class);
      if (Util.isNullOrNil(((com.tencent.mm.message.a)localObject).nOY)) {}
      for (localObject = "related_msgid_" + paramcc.field_msgSvrId; ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().ar(paramcc.field_talker, (String)localObject) == null; localObject = ((com.tencent.mm.message.a)localObject).nOY)
      {
        Log.d("MicroMsg.roomTodo.PluginChatroomUI", "groupTodo is null");
        AppMethodBeat.o(184788);
        return;
      }
      cc localcc = ((n)h.ax(n.class)).gaZ().sl(paramcc.field_msgId);
      localcc.Ce((String)localObject);
      ((n)h.ax(n.class)).gaZ().a(localcc.field_msgId, localcc);
      Log.d("MicroMsg.roomTodo.PluginChatroomUI", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(paramcc.field_msgSvrId), Long.valueOf(localcc.field_msgId) });
    }
    AppMethodBeat.o(184788);
  }
  
  public void handleGroupToolByReceiverAppMsg(cc paramcc)
  {
    AppMethodBeat.i(185971);
    if (au.bwG(paramcc.field_talker))
    {
      k.b localb = k.b.Hf(paramcc.field_content);
      if (localb == null)
      {
        Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) content is null", new Object[] { paramcc.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      com.tencent.mm.chatroom.storage.e locale = ad.CV(paramcc.field_talker);
      if (locale == null)
      {
        Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is null", new Object[] { paramcc.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      if (locale.field_queryState == 0)
      {
        Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { paramcc.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      GroupToolItem localGroupToolItem = null;
      if ((com.tencent.mm.modelappbrand.b.b(localb)) || (com.tencent.mm.modelappbrand.b.c(localb))) {
        localGroupToolItem = ad.g(paramcc);
      }
      if (ad.h(paramcc)) {
        localGroupToolItem = new GroupToolItem("roomaa@app.origin", "", paramcc.getCreateTime());
      }
      if (localGroupToolItem != null)
      {
        locale.a(localGroupToolItem);
        boolean bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
        Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg room:%s result:%s", new Object[] { paramcc.field_talker, Boolean.valueOf(bool) });
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
    ((n)h.ax(n.class)).gaZ().a(this.lzk, Looper.getMainLooper());
    ((com.tencent.mm.plugin.messenger.foundation.a.v)h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("roomtoolstips", this.lzd);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("IMUnionRoom2AssociateRoom", this.lze);
    this.lzf.alive();
    this.lzg.alive();
    this.lzh.alive();
    this.lzi.alive();
    this.lzj.alive();
    ((n)h.ax(n.class)).bzA().add(getGroupToolsStorage());
    ((n)h.ax(n.class)).bzG().add(getGroupToolsStorage());
    this.lzp = new com.tencent.mm.chatroom.c.b();
    ((n)h.ax(n.class)).bzG().a(this.lzl);
    AppMethodBeat.o(182126);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(182127);
    Log.d("MicroMsg.PluginChatroomUI", "onAccountRelease");
    ((n)h.ax(n.class)).gaZ().a(this.lzk);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("roomtoolstips", this.lzd);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("IMUnionRoom2AssociateRoom", this.lze);
    this.lzf.dead();
    this.lzg.dead();
    this.lzh.dead();
    this.lzi.dead();
    this.lzj.dead();
    ((n)h.ax(n.class)).bzA().remove(getGroupToolsStorage());
    ((n)h.ax(n.class)).bzG().remove(getGroupToolsStorage());
    ((n)h.ax(n.class)).bzG().b(this.lzl);
    AppMethodBeat.o(182127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.PluginChatroomUI
 * JD-Core Version:    0.7.0.1
 */