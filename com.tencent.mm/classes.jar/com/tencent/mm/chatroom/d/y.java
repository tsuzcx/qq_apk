package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.chatroom.ui.RoomCardUI;
import com.tencent.mm.chatroom.ui.a.b;
import com.tencent.mm.chatroom.ui.a.i;
import com.tencent.mm.f.a.oq;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.util.g;
import java.util.Iterator;
import java.util.List;

public final class y
{
  private static Boolean iWJ = null;
  
  public static Pair<Boolean, String> ES(long paramLong)
  {
    AppMethodBeat.i(182103);
    Object localObject = ((n)h.ae(n.class)).eSe().Oq(paramLong);
    if (Util.isNullOrNil(((et)localObject).ilu))
    {
      localObject = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182103);
      return localObject;
    }
    c localc = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().am(((et)localObject).field_talker, ((et)localObject).ilu);
    if (localc == null)
    {
      localObject = new Pair(Boolean.FALSE, ((et)localObject).ilu);
      AppMethodBeat.o(182103);
      return localObject;
    }
    boolean bool;
    if (localc.EU(((et)localObject).field_msgSvrId))
    {
      bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().h(localc);
      oq localoq = new oq();
      localoq.fNv.op = 1;
      localoq.fNv.fHp = localc.field_roomname;
      localoq.fNv.fNw = localc.field_todoid;
      if (bool) {
        EventCenter.instance.asyncPublish(localoq, Looper.getMainLooper());
      }
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg delete result:%s", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      if (bool)
      {
        ((ca)localObject).Jy("");
        ((n)h.ae(n.class)).eSe().a(((et)localObject).field_msgId, (ca)localObject);
      }
      localObject = new Pair(Boolean.TRUE, ((et)localObject).ilu);
      AppMethodBeat.o(182103);
      return localObject;
      bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().g(localc);
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg updateGroupTodo result:%s", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static Pair<Boolean, String> a(c paramc)
  {
    AppMethodBeat.i(182102);
    c localc = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().am(paramc.field_roomname, paramc.field_todoid);
    if (localc == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu stoTodo no exist");
      paramc = new Pair(Boolean.FALSE, paramc.field_todoid);
      AppMethodBeat.o(182102);
      return paramc;
    }
    Iterator localIterator = localc.iXE.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      localObject = ((n)h.ae(n.class)).eSe().aL(paramc.field_roomname, ((Long)localObject).longValue());
      ((ca)localObject).Jy("");
      ((n)h.ae(n.class)).eSe().a(((et)localObject).field_msgId, (ca)localObject);
    }
    ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getRoomTodoMsgService();
    c.a.a(paramc.field_roomname, 1, d(localc));
    boolean bool = c(localc);
    Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu todoId:%s result:%s", new Object[] { paramc.field_todoid, Boolean.valueOf(bool) });
    paramc = new Pair(Boolean.valueOf(bool), paramc.field_todoid);
    AppMethodBeat.o(182102);
    return paramc;
  }
  
  public static Pair<Boolean, String> a(ca paramca, k.b paramb)
  {
    AppMethodBeat.i(184782);
    if (paramca == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      paramca = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return paramca;
    }
    if (paramb == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      paramca = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return paramca;
    }
    long l = paramca.field_createTime;
    Object localObject = (com.tencent.mm.aj.a)paramb.ar(com.tencent.mm.aj.a.class);
    c localc;
    if (Util.isNullOrNil(((com.tencent.mm.aj.a)localObject).lkm))
    {
      localObject = "related_msgid_" + paramca.field_msgSvrId;
      localc = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().am(paramca.field_talker, (String)localObject);
      if (localc != null)
      {
        Log.e("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl %s(%s) exist", new Object[] { localObject, Integer.valueOf(localc.field_state) });
        if (localc.field_state != 2) {
          break label597;
        }
        Log.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl delete %s", new Object[] { Boolean.valueOf(((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().h(localc)) });
      }
      localc = new c();
      localc.field_todoid = ((String)localObject);
      localc.field_roomname = paramca.field_talker;
      localc.field_username = paramb.loA;
      localc.field_path = paramb.loz;
      localc.field_createtime = l;
      localc.field_updatetime = l;
      localc.field_custominfo = "";
      localObject = paramb.title;
      if (!Util.isNullOrNil((String)localObject)) {
        break label620;
      }
      WxaAttributes localWxaAttributes = ((q)h.ae(q.class)).aeW(paramb.loA);
      if ((localWxaAttributes == null) || (Util.isNullOrNil(localWxaAttributes.field_nickname))) {
        break label620;
      }
      localObject = localWxaAttributes.field_nickname;
    }
    label597:
    label620:
    for (;;)
    {
      localc.field_title = ((String)localObject);
      localc.field_creator = g.dn(paramca);
      localc.field_manager = com.tencent.mm.model.z.bcZ();
      localc.field_nreply = 0;
      localc.field_related_msgids = paramca.field_msgSvrId;
      localc.field_shareKey = paramb.loG;
      localc.field_shareName = paramca.field_talker;
      boolean bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().f(localc);
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoBySendSuccess todoId:%s result:%s", new Object[] { localc.field_todoid, Boolean.valueOf(bool) });
      if (bool)
      {
        paramb = ((n)h.ae(n.class)).eSe().aL(paramca.field_talker, paramca.field_msgSvrId);
        paramb.Jy(localc.field_todoid);
        ((n)h.ae(n.class)).eSe().a(paramb.field_msgId, paramb);
        paramb = new oq();
        paramb.fNv.op = 0;
        paramb.fNv.fNw = localc.field_todoid;
        paramb.fNv.fHp = paramca.field_talker;
        EventCenter.instance.asyncPublish(paramb, Looper.getMainLooper());
      }
      paramca = new Pair(Boolean.valueOf(bool), localc.field_todoid);
      AppMethodBeat.o(184782);
      return paramca;
      localObject = ((com.tencent.mm.aj.a)localObject).lkm;
      break;
      paramca = new Pair(Boolean.TRUE, localc.field_todoid);
      AppMethodBeat.o(184782);
      return paramca;
    }
  }
  
  public static String a(dzx paramdzx)
  {
    AppMethodBeat.i(182105);
    if (paramdzx == null)
    {
      AppMethodBeat.o(182105);
      return "";
    }
    paramdzx = "RoomToolsTodo{TodoId='" + paramdzx.Ufg + '\'' + ", Username='" + paramdzx.Username + '\'' + ", Path='" + paramdzx.CqK + '\'' + ", Time=" + paramdzx.vhF + ", CustomInfo=" + paramdzx.Ufh + ", Title='" + Util.secPrint(paramdzx.fwr) + '\'' + ", Creator='" + paramdzx.Uff + '\'' + ", RelatedMsgId=" + paramdzx.Ufi + ", Manager='" + paramdzx.Ufj + '\'' + '}';
    AppMethodBeat.o(182105);
    return paramdzx;
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, a parama)
  {
    AppMethodBeat.i(186339);
    e locale = new e(paramContext, 1, true);
    if (paramBoolean) {
      locale.j(paramContext.getString(a.i.jeZ), 17, com.tencent.mm.ci.a.fromDPToPix(paramContext, 14));
    }
    for (;;)
    {
      locale.Ynb = true;
      locale.ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(182097);
          if (this.iWK)
          {
            paramAnonymouso.d(0, paramContext.getString(a.i.jeX));
            AppMethodBeat.o(182097);
            return;
          }
          paramAnonymouso.a(0, paramContext.getResources().getColor(a.b.Red), paramContext.getString(a.i.jeW));
          AppMethodBeat.o(182097);
        }
      };
      locale.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          paramAnonymousInt = 1;
          AppMethodBeat.i(182098);
          if ((paramAnonymousMenuItem.getItemId() == 0) && (this.iWL != null))
          {
            int i;
            if (paramBoolean)
            {
              this.iWL.asd();
              if (paramInt1 != 2) {
                break label106;
              }
              paramAnonymousMenuItem = paramString1;
              i = paramInt2;
              if (!paramBoolean) {
                break label101;
              }
            }
            for (;;)
            {
              z.a(paramAnonymousMenuItem, 2, i, paramAnonymousInt, paramInt3, paramString2, paramString3);
              AppMethodBeat.o(182098);
              return;
              this.iWL.ase();
              break;
              label101:
              paramAnonymousInt = 2;
            }
            label106:
            if (paramInt1 == 1) {
              z.a(paramString1, paramInt2, 3, 2, paramString2, paramString3);
            }
          }
          AppMethodBeat.o(182098);
        }
      };
      locale.XbB = new e.b()
      {
        public final void onDismiss()
        {
          int i = 2;
          AppMethodBeat.i(184781);
          if (this.iWM == 2)
          {
            String str = paramString1;
            int j = paramInt2;
            if (paramBoolean) {
              i = 1;
            }
            z.a(str, 1, j, i, paramInt3, paramString2, paramString3);
          }
          if (this.iWM == 1) {
            z.a(paramString1, paramInt2, 3, 1, paramString2, paramString3);
          }
          AppMethodBeat.o(184781);
        }
      };
      locale.eik();
      AppMethodBeat.o(186339);
      return;
      locale.j(paramContext.getString(a.i.jeY), 17, com.tencent.mm.ci.a.fromDPToPix(paramContext, 14));
    }
  }
  
  public static boolean asb()
  {
    AppMethodBeat.i(182099);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182099);
      return true;
    }
    boolean bool;
    if (iWJ != null)
    {
      bool = iWJ.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFo, 1);
    Log.i("MicroMsg.roomTodo.RoomTodoHelp", "getRoomTodoSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (iWJ = Boolean.TRUE;; iWJ = Boolean.FALSE)
    {
      bool = iWJ.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
  }
  
  public static boolean b(c paramc)
  {
    AppMethodBeat.i(182104);
    paramc.field_state = 1;
    paramc.field_updatetime = cm.bfD();
    boolean bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().g(paramc);
    AppMethodBeat.o(182104);
    return bool;
  }
  
  public static Pair<Boolean, String> c(ca paramca)
  {
    AppMethodBeat.i(182100);
    if (paramca == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      paramca = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return paramca;
    }
    if (paramca.hAl())
    {
      localObject = new dzx();
      ((dzx)localObject).Ufg = ("related_msgid_" + paramca.field_msgSvrId);
      ((dzx)localObject).Username = "roomannouncement@app.origin";
      ((dzx)localObject).CqK = "";
      ((dzx)localObject).vhF = cm.bfF();
      ((dzx)localObject).fwr = MMApplicationContext.getContext().getString(a.i.etU);
      ((dzx)localObject).Uff = g.dn(paramca);
      ((dzx)localObject).Ufi = paramca.field_msgSvrId;
      ((dzx)localObject).Ufj = com.tencent.mm.model.z.bcZ();
      ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(paramca.field_talker, 0, (dzx)localObject);
      paramca = new Pair(Boolean.TRUE, ((dzx)localObject).Ufg);
      AppMethodBeat.o(182100);
      return paramca;
    }
    k.b localb = k.b.OQ(paramca.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      paramca = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return paramca;
    }
    dzx localdzx = new dzx();
    Object localObject = (com.tencent.mm.aj.a)localb.ar(com.tencent.mm.aj.a.class);
    if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.aj.a)localObject).lkm)))
    {
      localdzx.Ufg = ("related_msgid_" + paramca.field_msgSvrId);
      localdzx.Username = localb.loA;
      localdzx.CqK = localb.loz;
      localdzx.vhF = cm.bfF();
      localObject = localb.title;
      if (!Util.isNullOrNil((String)localObject)) {
        break label449;
      }
      WxaAttributes localWxaAttributes = ((q)h.ae(q.class)).aeW(localb.loA);
      if ((localWxaAttributes == null) || (Util.isNullOrNil(localWxaAttributes.field_nickname))) {
        break label449;
      }
      localObject = localWxaAttributes.field_nickname;
    }
    label449:
    for (;;)
    {
      localdzx.fwr = ((String)localObject);
      localdzx.Uff = g.dn(paramca);
      localdzx.Ufi = paramca.field_msgSvrId;
      localdzx.Ufj = com.tencent.mm.model.z.bcZ();
      localdzx.Ufk = localb.loG;
      localdzx.Ufl = paramca.field_talker;
      ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(paramca.field_talker, 0, localdzx);
      paramca = new Pair(Boolean.TRUE, localdzx.Ufg);
      AppMethodBeat.o(182100);
      return paramca;
      localdzx.Ufg = ((com.tencent.mm.aj.a)localObject).lkm;
      break;
    }
  }
  
  public static boolean c(c paramc)
  {
    AppMethodBeat.i(186331);
    paramc.field_state = 2;
    paramc.field_updatetime = cm.bfD();
    boolean bool = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().g(paramc);
    AppMethodBeat.o(186331);
    return bool;
  }
  
  public static dzx d(c paramc)
  {
    AppMethodBeat.i(182106);
    dzx localdzx = new dzx();
    localdzx.Ufg = paramc.field_todoid;
    localdzx.Username = paramc.field_username;
    localdzx.CqK = paramc.field_path;
    localdzx.vhF = ((int)(paramc.field_createtime / 1000L));
    localdzx.fwr = paramc.field_title;
    localdzx.Uff = paramc.field_creator;
    localdzx.Ufi = paramc.asl();
    localdzx.Ufj = paramc.field_manager;
    localdzx.Ufh = com.tencent.mm.cd.b.bss(paramc.field_custominfo);
    localdzx.Ufk = paramc.field_shareKey;
    localdzx.Ufl = paramc.field_shareName;
    AppMethodBeat.o(182106);
    return localdzx;
  }
  
  public static String d(ca paramca)
  {
    AppMethodBeat.i(186325);
    if (paramca == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      AppMethodBeat.o(186325);
      return "";
    }
    if (paramca.hAl())
    {
      paramca = "related_msgid_" + paramca.field_msgSvrId;
      AppMethodBeat.o(186325);
      return paramca;
    }
    Object localObject = k.b.OQ(paramca.field_content);
    if (localObject == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      AppMethodBeat.o(186325);
      return "";
    }
    localObject = (com.tencent.mm.aj.a)((k.b)localObject).ar(com.tencent.mm.aj.a.class);
    if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.aj.a)localObject).lkm)))
    {
      paramca = "related_msgid_" + paramca.field_msgSvrId;
      AppMethodBeat.o(186325);
      return paramca;
    }
    paramca = ((com.tencent.mm.aj.a)localObject).lkm;
    AppMethodBeat.o(186325);
    return paramca;
  }
  
  public static Pair<Boolean, String> e(ca paramca)
  {
    AppMethodBeat.i(182101);
    Object localObject1 = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().am(paramca.field_talker, paramca.ilu);
    if (localObject1 != null)
    {
      localObject2 = ((c)localObject1).iXE.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Long)((Iterator)localObject2).next();
        localObject3 = ((n)h.ae(n.class)).eSe().aL(paramca.field_talker, ((Long)localObject3).longValue());
        ((ca)localObject3).Jy("");
        ((n)h.ae(n.class)).eSe().a(((et)localObject3).field_msgId, (ca)localObject3);
      }
      localObject2 = new oq();
      ((oq)localObject2).fNv.op = 1;
      ((oq)localObject2).fNv.fNw = paramca.ilu;
      ((oq)localObject2).fNv.fHp = paramca.field_talker;
      EventCenter.instance.asyncPublish((IEvent)localObject2, Looper.getMainLooper());
      boolean bool = c((c)localObject1);
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s result:%s", new Object[] { paramca.ilu, Boolean.valueOf(bool) });
      localObject1 = d((c)localObject1);
      ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(paramca.field_talker, 1, (dzx)localObject1);
      paramca = new Pair(Boolean.TRUE, paramca.ilu);
      AppMethodBeat.o(182101);
      return paramca;
    }
    localObject1 = ((n)h.ae(n.class)).eSe().aL(paramca.field_talker, paramca.field_msgSvrId);
    ((ca)localObject1).Jy("");
    ((n)h.ae(n.class)).eSe().a(((et)localObject1).field_msgId, (ca)localObject1);
    localObject1 = new dzx();
    ((dzx)localObject1).Ufg = paramca.ilu;
    Object localObject2 = k.b.OQ(paramca.field_content);
    if (localObject2 == null)
    {
      ((dzx)localObject1).Username = "";
      ((dzx)localObject1).CqK = "";
    }
    for (((dzx)localObject1).fwr = "";; ((dzx)localObject1).fwr = ((k.b)localObject2).title)
    {
      ((dzx)localObject1).vhF = ((int)(paramca.field_createTime / 10000L));
      ((dzx)localObject1).Uff = g.dn(paramca);
      ((dzx)localObject1).Ufi = paramca.field_msgSvrId;
      ((dzx)localObject1).Ufj = "";
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s", new Object[] { paramca.ilu });
      break;
      ((dzx)localObject1).Username = ((k.b)localObject2).loA;
      ((dzx)localObject1).CqK = ((k.b)localObject2).loz;
    }
  }
  
  public static boolean e(c paramc)
  {
    if (paramc == null) {}
    while (paramc.field_state == 2) {
      return false;
    }
    return true;
  }
  
  public static String f(ca paramca)
  {
    AppMethodBeat.i(186342);
    if (paramca == null)
    {
      AppMethodBeat.o(186342);
      return "";
    }
    if (paramca.hAl())
    {
      AppMethodBeat.o(186342);
      return "roomannouncement@app.origin";
    }
    paramca = k.b.OQ(paramca.field_content);
    if (paramca == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo content is null");
      AppMethodBeat.o(186342);
      return "";
    }
    if ((com.tencent.mm.aj.a)paramca.ar(com.tencent.mm.aj.a.class) == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo appContentAppBrandPiece is null");
      AppMethodBeat.o(186342);
      return "";
    }
    paramca = paramca.loA;
    AppMethodBeat.o(186342);
    return paramca;
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182107);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "gotoRoomCard roomname is null");
      AppMethodBeat.o(182107);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, RoomCardUI.class);
    localIntent.putExtra("RoomInfo_Id", paramString);
    localIntent.putExtra("room_notice", v.Pw(paramString));
    localIntent.putExtra("room_notice_publish_time", v.Pz(paramString));
    localIntent.putExtra("room_notice_editor", v.Py(paramString));
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      localIntent.putExtra("from_scene", i);
      paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
      if (paramString != null)
      {
        localIntent.putExtra("Is_RoomOwner", paramString.field_roomowner.equals(com.tencent.mm.model.z.bcZ()));
        localIntent.putExtra("Is_RoomManager", paramString.bvA(com.tencent.mm.model.z.bcZ()));
      }
      localIntent.putExtra("room_member_count", paramString.field_memberCount);
      if (paramBoolean) {
        localIntent.setFlags(268435456);
      }
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(182107);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void asd();
    
    public abstract void ase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.y
 * JD-Core Version:    0.7.0.1
 */