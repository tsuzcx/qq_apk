package com.tencent.mm.chatroom.plugin;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.chatroom.c.b.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.c.1;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.b.f;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginChatroomUI
  extends f
  implements a, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c fpA;
  private com.tencent.mm.sdk.b.c fpB;
  private com.tencent.mm.sdk.b.c fpC;
  private com.tencent.mm.sdk.b.c fpD;
  private h.a fpE;
  private com.tencent.mm.chatroom.storage.b fpF;
  private b.a fpG;
  private d fpH;
  private com.tencent.mm.chatroom.e.b fpy;
  private com.tencent.mm.sdk.b.c<mk> fpz;
  
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
    this.fpy = new com.tencent.mm.chatroom.e.b();
    this.fpz = new com.tencent.mm.sdk.b.c() {};
    this.fpA = new com.tencent.mm.sdk.b.c() {};
    this.fpB = new com.tencent.mm.sdk.b.c() {};
    this.fpC = new com.tencent.mm.sdk.b.c() {};
    this.fpD = new com.tencent.mm.sdk.b.c() {};
    this.fpE = new h.a()
    {
      public final void a(h paramAnonymoush, h.c paramAnonymousc)
      {
        AppMethodBeat.i(185970);
        if ((paramAnonymoush == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(185970);
          return;
        }
        if (("delete".equals(paramAnonymousc.tyD)) && (paramAnonymousc.tyE != null))
        {
          paramAnonymoush = paramAnonymousc.tyE.iterator();
          do
          {
            if (!paramAnonymoush.hasNext()) {
              break;
            }
          } while (!aa.i((bl)paramAnonymoush.next()));
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramAnonymoush = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().oQ(paramAnonymousc.talker);
            if ((paramAnonymoush == null) || (paramAnonymoush.field_queryState == 0)) {
              break label201;
            }
            paramAnonymoush.field_queryState = 0;
          }
          label201:
          for (boolean bool = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(paramAnonymoush, new String[0]);; bool = false)
          {
            paramAnonymousc = bt.by(paramAnonymousc.talker, "");
            if (paramAnonymoush == null) {}
            for (paramAnonymoush = "null";; paramAnonymoush = "not_null")
            {
              ad.i("MicroMsg.roomtools.PluginChatroomUI", "onNotifyChange roomName:%s groupTools:%s result:%s", new Object[] { paramAnonymousc, paramAnonymoush, Boolean.valueOf(bool) });
              AppMethodBeat.o(185970);
              return;
            }
            ad.d("MicroMsg.roomtools.PluginChatroomUI", "no need reset");
            AppMethodBeat.o(185970);
            return;
          }
        }
      }
    };
    this.fpF = null;
    this.fpG = null;
    this.fpH = null;
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
    pin(b.UW());
    if (paramg.agu())
    {
      com.tencent.mm.kernel.g.b(r.class, new com.tencent.mm.chatroom.b.a());
      com.tencent.mm.kernel.g.b(s.class, new com.tencent.mm.chatroom.b.b());
    }
    AppMethodBeat.o(12506);
  }
  
  public com.tencent.mm.chatroom.storage.b getGroupTodoStorage()
  {
    AppMethodBeat.i(182128);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.fpF == null)
    {
      com.tencent.mm.kernel.g.afC();
      this.fpF = new com.tencent.mm.chatroom.storage.b(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.chatroom.storage.b localb = this.fpF;
    AppMethodBeat.o(182128);
    return localb;
  }
  
  public d getGroupToolsStorage()
  {
    AppMethodBeat.i(182130);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.fpH == null)
    {
      com.tencent.mm.kernel.g.afC();
      this.fpH = new d(com.tencent.mm.kernel.g.afB().gda);
    }
    d locald = this.fpH;
    AppMethodBeat.o(182130);
    return locald;
  }
  
  public b.a getRoomTodoMsgService()
  {
    AppMethodBeat.i(182129);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.fpG == null) {
      this.fpG = new b.a();
    }
    b.a locala = this.fpG;
    AppMethodBeat.o(182129);
    return locala;
  }
  
  public void handleChatroomBackup(String paramString)
  {
    AppMethodBeat.i(185972);
    if ((aa.UU()) && (w.sm(paramString)))
    {
      ad.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup talker:%s", new Object[] { paramString });
      paramString = aa.oO(paramString);
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
  
  public void handleGroupTodoByReceiverAppMsg(bl parambl)
  {
    AppMethodBeat.i(184788);
    if (w.sm(parambl.field_talker))
    {
      Object localObject = k.b.rx(parambl.field_content);
      if (localObject == null)
      {
        ad.d("MicroMsg.roomTodo.PluginChatroomUI", "content is null");
        AppMethodBeat.o(184788);
        return;
      }
      localObject = (com.tencent.mm.ai.a)((k.b)localObject).ao(com.tencent.mm.ai.a.class);
      if (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject).gFz)) {}
      for (localObject = "related_msgid_" + parambl.field_msgSvrId; ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ac(parambl.field_talker, (String)localObject) == null; localObject = ((com.tencent.mm.ai.a)localObject).gFz)
      {
        ad.d("MicroMsg.roomTodo.PluginChatroomUI", "groupTodo is null");
        AppMethodBeat.o(184788);
        return;
      }
      bl localbl = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(parambl.field_msgId);
      localbl.oh((String)localObject);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(localbl.field_msgId, localbl);
      ad.d("MicroMsg.roomTodo.PluginChatroomUI", "update msgSvrid:%s msgId:%s", new Object[] { Long.valueOf(parambl.field_msgSvrId), Long.valueOf(localbl.field_msgId) });
    }
    AppMethodBeat.o(184788);
  }
  
  public void handleGroupToolByReceiverAppMsg(bl parambl)
  {
    AppMethodBeat.i(185971);
    if ((aa.UU()) && (w.sm(parambl.field_talker)))
    {
      k.b localb = k.b.rx(parambl.field_content);
      if (localb == null)
      {
        ad.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) content is null", new Object[] { parambl.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      com.tencent.mm.chatroom.storage.c localc = aa.oO(parambl.field_talker);
      if (localc == null)
      {
        ad.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is null", new Object[] { parambl.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      if (localc.field_queryState == 0)
      {
        ad.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { parambl.field_talker });
        AppMethodBeat.o(185971);
        return;
      }
      GroupToolItem localGroupToolItem = null;
      if ((com.tencent.mm.modelappbrand.a.b(localb)) || (com.tencent.mm.modelappbrand.a.c(localb))) {
        localGroupToolItem = aa.g(parambl);
      }
      if (aa.h(parambl)) {
        localGroupToolItem = new GroupToolItem("roomaa@app.origin", "", parambl.field_createTime);
      }
      if (localGroupToolItem != null)
      {
        if (localc.fpN.contains(localGroupToolItem)) {
          localc.fpN.remove(localGroupToolItem);
        }
        localc.fpN.add(localGroupToolItem);
        Collections.sort(localc.fpN, new c.1(localc));
        if (localc.fpN.size() > 20) {
          localc.fpN.remove(localc.fpN.size() - 1);
        }
        localc.field_recentUseToolList = com.tencent.mm.chatroom.storage.c.X(localc.fpN);
        boolean bool = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc, new String[0]);
        ad.i("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg room:%s result:%s", new Object[] { parambl.field_talker, Boolean.valueOf(bool) });
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
    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(this.fpE, Looper.getMainLooper());
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("roomtoolstips", this.fpy);
    this.fpz.alive();
    this.fpA.alive();
    this.fpB.alive();
    this.fpC.alive();
    this.fpD.alive();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().a(getGroupToolsStorage());
    AppMethodBeat.o(182126);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(182127);
    ad.d("MicroMsg.PluginChatroomUI", "onAccountRelease");
    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(this.fpE);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("roomtoolstips", this.fpy);
    this.fpz.dead();
    this.fpA.dead();
    this.fpB.dead();
    this.fpC.dead();
    this.fpD.dead();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().b(getGroupToolsStorage());
    AppMethodBeat.o(182127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.PluginChatroomUI
 * JD-Core Version:    0.7.0.1
 */