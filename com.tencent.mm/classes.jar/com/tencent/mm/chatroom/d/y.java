package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.chatroom.ui.RoomCardUI;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Iterator;
import java.util.List;

public final class y
{
  private static Boolean gsx = null;
  
  public static Pair<Boolean, String> a(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(182102);
    com.tencent.mm.chatroom.storage.c localc = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(paramc.field_roomname, paramc.field_todoid);
    if (localc == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu stoTodo no exist");
      paramc = new Pair(Boolean.FALSE, paramc.field_todoid);
      AppMethodBeat.o(182102);
      return paramc;
    }
    Iterator localIterator = localc.gts.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      localObject = ((l)g.af(l.class)).eiy().aJ(paramc.field_roomname, ((Long)localObject).longValue());
      ((ca)localObject).CK("");
      ((l)g.af(l.class)).eiy().a(((eo)localObject).field_msgId, (ca)localObject);
    }
    ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getRoomTodoMsgService();
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
    Object localObject = (com.tencent.mm.ag.a)paramb.as(com.tencent.mm.ag.a.class);
    com.tencent.mm.chatroom.storage.c localc;
    if (Util.isNullOrNil(((com.tencent.mm.ag.a)localObject).ivd))
    {
      localObject = "related_msgid_" + paramca.field_msgSvrId;
      localc = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(paramca.field_talker, (String)localObject);
      if (localc != null)
      {
        Log.e("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl %s(%s) exist", new Object[] { localObject, Integer.valueOf(localc.field_state) });
        if (localc.field_state != 2) {
          break label594;
        }
        Log.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl delete %s", new Object[] { Boolean.valueOf(((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().h(localc)) });
      }
      localc = new com.tencent.mm.chatroom.storage.c();
      localc.field_todoid = ((String)localObject);
      localc.field_roomname = paramca.field_talker;
      localc.field_username = paramb.izi;
      localc.field_path = paramb.izh;
      localc.field_createtime = l;
      localc.field_updatetime = l;
      localc.field_custominfo = "";
      localObject = paramb.title;
      if (!Util.isNullOrNil((String)localObject)) {
        break label617;
      }
      WxaAttributes localWxaAttributes = ((q)g.af(q.class)).Xk(paramb.izi);
      if ((localWxaAttributes == null) || (Util.isNullOrNil(localWxaAttributes.field_nickname))) {
        break label617;
      }
      localObject = localWxaAttributes.field_nickname;
    }
    label594:
    label617:
    for (;;)
    {
      localc.field_title = ((String)localObject);
      localc.field_creator = com.tencent.mm.util.e.cT(paramca);
      localc.field_manager = com.tencent.mm.model.z.aTY();
      localc.field_nreply = 0;
      localc.field_related_msgids = paramca.field_msgSvrId;
      localc.field_shareKey = paramb.izo;
      localc.field_shareName = paramca.field_talker;
      boolean bool = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().f(localc);
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoBySendSuccess todoId:%s result:%s", new Object[] { localc.field_todoid, Boolean.valueOf(bool) });
      if (bool)
      {
        paramb = ((l)g.af(l.class)).eiy().aJ(paramca.field_talker, paramca.field_msgSvrId);
        paramb.CK(localc.field_todoid);
        ((l)g.af(l.class)).eiy().a(paramb.field_msgId, paramb);
        paramb = new nt();
        paramb.dTT.op = 0;
        paramb.dTT.dTU = localc.field_todoid;
        paramb.dTT.dOe = paramca.field_talker;
        EventCenter.instance.asyncPublish(paramb, Looper.getMainLooper());
      }
      paramca = new Pair(Boolean.valueOf(bool), localc.field_todoid);
      AppMethodBeat.o(184782);
      return paramca;
      localObject = ((com.tencent.mm.ag.a)localObject).ivd;
      break;
      paramca = new Pair(Boolean.TRUE, localc.field_todoid);
      AppMethodBeat.o(184782);
      return paramca;
    }
  }
  
  public static String a(dqb paramdqb)
  {
    AppMethodBeat.i(182105);
    if (paramdqb == null)
    {
      AppMethodBeat.o(182105);
      return "";
    }
    paramdqb = "RoomToolsTodo{TodoId='" + paramdqb.MSY + '\'' + ", Username='" + paramdqb.Username + '\'' + ", Path='" + paramdqb.xut + '\'' + ", Time=" + paramdqb.rBX + ", CustomInfo=" + paramdqb.MSZ + ", Title='" + Util.secPrint(paramdqb.Title) + '\'' + ", Creator='" + paramdqb.MSX + '\'' + ", RelatedMsgId=" + paramdqb.MTa + ", Manager='" + paramdqb.MTb + '\'' + '}';
    AppMethodBeat.o(182105);
    return paramdqb;
  }
  
  public static void a(Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, a parama)
  {
    AppMethodBeat.i(194035);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, true);
    if (paramBoolean) {
      locale.j(paramContext.getString(2131757253), 17, com.tencent.mm.cb.a.fromDPToPix(paramContext, 14));
    }
    for (;;)
    {
      locale.QOp = true;
      locale.HLX = new y.1(paramBoolean, paramContext);
      locale.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          paramAnonymousInt = 1;
          AppMethodBeat.i(182098);
          if ((paramAnonymousMenuItem.getItemId() == 0) && (this.gsz != null))
          {
            int i;
            if (paramBoolean)
            {
              this.gsz.amc();
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
              this.gsz.amd();
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
      locale.PGl = new e.b()
      {
        public final void onDismiss()
        {
          int i = 2;
          AppMethodBeat.i(184781);
          if (this.gsA == 2)
          {
            String str = paramString1;
            int j = paramInt2;
            if (paramBoolean) {
              i = 1;
            }
            z.a(str, 1, j, i, paramInt3, paramString2, paramString3);
          }
          if (this.gsA == 1) {
            z.a(paramString1, paramInt2, 3, 1, paramString2, paramString3);
          }
          AppMethodBeat.o(184781);
        }
      };
      locale.dGm();
      AppMethodBeat.o(194035);
      return;
      locale.j(paramContext.getString(2131757252), 17, com.tencent.mm.cb.a.fromDPToPix(paramContext, 14));
    }
  }
  
  public static boolean ama()
  {
    AppMethodBeat.i(182099);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182099);
      return true;
    }
    boolean bool;
    if (gsx != null)
    {
      bool = gsx.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYq, 1);
    Log.i("MicroMsg.roomTodo.RoomTodoHelp", "getRoomTodoSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (gsx = Boolean.TRUE;; gsx = Boolean.FALSE)
    {
      bool = gsx.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
  }
  
  public static boolean b(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(182104);
    paramc.field_state = 1;
    paramc.field_updatetime = cl.aWz();
    boolean bool = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().g(paramc);
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
    if (paramca.gDV())
    {
      localObject = new dqb();
      ((dqb)localObject).MSY = ("related_msgid_" + paramca.field_msgSvrId);
      ((dqb)localObject).Username = "roomannouncement@app.origin";
      ((dqb)localObject).xut = "";
      ((dqb)localObject).rBX = cl.aWB();
      ((dqb)localObject).Title = MMApplicationContext.getContext().getString(2131757254);
      ((dqb)localObject).MSX = com.tencent.mm.util.e.cT(paramca);
      ((dqb)localObject).MTa = paramca.field_msgSvrId;
      ((dqb)localObject).MTb = com.tencent.mm.model.z.aTY();
      ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(paramca.field_talker, 0, (dqb)localObject);
      paramca = new Pair(Boolean.TRUE, ((dqb)localObject).MSY);
      AppMethodBeat.o(182100);
      return paramca;
    }
    k.b localb = k.b.HD(paramca.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      paramca = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return paramca;
    }
    dqb localdqb = new dqb();
    Object localObject = (com.tencent.mm.ag.a)localb.as(com.tencent.mm.ag.a.class);
    if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.ag.a)localObject).ivd)))
    {
      localdqb.MSY = ("related_msgid_" + paramca.field_msgSvrId);
      localdqb.Username = localb.izi;
      localdqb.xut = localb.izh;
      localdqb.rBX = cl.aWB();
      localObject = localb.title;
      if (!Util.isNullOrNil((String)localObject)) {
        break label447;
      }
      WxaAttributes localWxaAttributes = ((q)g.af(q.class)).Xk(localb.izi);
      if ((localWxaAttributes == null) || (Util.isNullOrNil(localWxaAttributes.field_nickname))) {
        break label447;
      }
      localObject = localWxaAttributes.field_nickname;
    }
    label447:
    for (;;)
    {
      localdqb.Title = ((String)localObject);
      localdqb.MSX = com.tencent.mm.util.e.cT(paramca);
      localdqb.MTa = paramca.field_msgSvrId;
      localdqb.MTb = com.tencent.mm.model.z.aTY();
      localdqb.MTc = localb.izo;
      localdqb.MTd = paramca.field_talker;
      ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(paramca.field_talker, 0, localdqb);
      paramca = new Pair(Boolean.TRUE, localdqb.MSY);
      AppMethodBeat.o(182100);
      return paramca;
      localdqb.MSY = ((com.tencent.mm.ag.a)localObject).ivd;
      break;
    }
  }
  
  public static boolean c(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(194034);
    paramc.field_state = 2;
    paramc.field_updatetime = cl.aWz();
    boolean bool = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().g(paramc);
    AppMethodBeat.o(194034);
    return bool;
  }
  
  public static dqb d(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(182106);
    dqb localdqb = new dqb();
    localdqb.MSY = paramc.field_todoid;
    localdqb.Username = paramc.field_username;
    localdqb.xut = paramc.field_path;
    localdqb.rBX = ((int)(paramc.field_createtime / 1000L));
    localdqb.Title = paramc.field_title;
    localdqb.MSX = paramc.field_creator;
    localdqb.MTa = paramc.amk();
    localdqb.MTb = paramc.field_manager;
    localdqb.MSZ = com.tencent.mm.bw.b.bfZ(paramc.field_custominfo);
    localdqb.MTc = paramc.field_shareKey;
    localdqb.MTd = paramc.field_shareName;
    AppMethodBeat.o(182106);
    return localdqb;
  }
  
  public static String d(ca paramca)
  {
    AppMethodBeat.i(194033);
    if (paramca == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      AppMethodBeat.o(194033);
      return "";
    }
    if (paramca.gDV())
    {
      paramca = "related_msgid_" + paramca.field_msgSvrId;
      AppMethodBeat.o(194033);
      return paramca;
    }
    Object localObject = k.b.HD(paramca.field_content);
    if (localObject == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      AppMethodBeat.o(194033);
      return "";
    }
    localObject = (com.tencent.mm.ag.a)((k.b)localObject).as(com.tencent.mm.ag.a.class);
    if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.ag.a)localObject).ivd)))
    {
      paramca = "related_msgid_" + paramca.field_msgSvrId;
      AppMethodBeat.o(194033);
      return paramca;
    }
    paramca = ((com.tencent.mm.ag.a)localObject).ivd;
    AppMethodBeat.o(194033);
    return paramca;
  }
  
  public static Pair<Boolean, String> e(ca paramca)
  {
    AppMethodBeat.i(182101);
    Object localObject1 = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(paramca.field_talker, paramca.fRe);
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.chatroom.storage.c)localObject1).gts.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Long)((Iterator)localObject2).next();
        localObject3 = ((l)g.af(l.class)).eiy().aJ(paramca.field_talker, ((Long)localObject3).longValue());
        ((ca)localObject3).CK("");
        ((l)g.af(l.class)).eiy().a(((eo)localObject3).field_msgId, (ca)localObject3);
      }
      localObject2 = new nt();
      ((nt)localObject2).dTT.op = 1;
      ((nt)localObject2).dTT.dTU = paramca.fRe;
      ((nt)localObject2).dTT.dOe = paramca.field_talker;
      EventCenter.instance.asyncPublish((IEvent)localObject2, Looper.getMainLooper());
      boolean bool = c((com.tencent.mm.chatroom.storage.c)localObject1);
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s result:%s", new Object[] { paramca.fRe, Boolean.valueOf(bool) });
      localObject1 = d((com.tencent.mm.chatroom.storage.c)localObject1);
      ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(paramca.field_talker, 1, (dqb)localObject1);
      paramca = new Pair(Boolean.TRUE, paramca.fRe);
      AppMethodBeat.o(182101);
      return paramca;
    }
    localObject1 = ((l)g.af(l.class)).eiy().aJ(paramca.field_talker, paramca.field_msgSvrId);
    ((ca)localObject1).CK("");
    ((l)g.af(l.class)).eiy().a(((eo)localObject1).field_msgId, (ca)localObject1);
    localObject1 = new dqb();
    ((dqb)localObject1).MSY = paramca.fRe;
    Object localObject2 = k.b.HD(paramca.field_content);
    if (localObject2 == null)
    {
      ((dqb)localObject1).Username = "";
      ((dqb)localObject1).xut = "";
    }
    for (((dqb)localObject1).Title = "";; ((dqb)localObject1).Title = ((k.b)localObject2).title)
    {
      ((dqb)localObject1).rBX = ((int)(paramca.field_createTime / 10000L));
      ((dqb)localObject1).MSX = com.tencent.mm.util.e.cT(paramca);
      ((dqb)localObject1).MTa = paramca.field_msgSvrId;
      ((dqb)localObject1).MTb = "";
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s", new Object[] { paramca.fRe });
      break;
      ((dqb)localObject1).Username = ((k.b)localObject2).izi;
      ((dqb)localObject1).xut = ((k.b)localObject2).izh;
    }
  }
  
  public static boolean e(com.tencent.mm.chatroom.storage.c paramc)
  {
    if (paramc == null) {}
    while (paramc.field_state == 2) {
      return false;
    }
    return true;
  }
  
  public static String f(ca paramca)
  {
    AppMethodBeat.i(194036);
    if (paramca == null)
    {
      AppMethodBeat.o(194036);
      return "";
    }
    if (paramca.gDV())
    {
      AppMethodBeat.o(194036);
      return "roomannouncement@app.origin";
    }
    paramca = k.b.HD(paramca.field_content);
    if (paramca == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo content is null");
      AppMethodBeat.o(194036);
      return "";
    }
    if ((com.tencent.mm.ag.a)paramca.as(com.tencent.mm.ag.a.class) == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo appContentAppBrandPiece is null");
      AppMethodBeat.o(194036);
      return "";
    }
    paramca = paramca.izi;
    AppMethodBeat.o(194036);
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
    localIntent.putExtra("room_notice", v.Ig(paramString));
    localIntent.putExtra("room_notice_publish_time", v.Ij(paramString));
    localIntent.putExtra("room_notice_editor", v.Ii(paramString));
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (paramString != null)
    {
      localIntent.putExtra("Is_RoomOwner", paramString.field_roomowner.equals(com.tencent.mm.model.z.aTY()));
      localIntent.putExtra("Is_RoomManager", paramString.bjf(com.tencent.mm.model.z.aTY()));
    }
    if (paramBoolean) {
      localIntent.setFlags(268435456);
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(182107);
  }
  
  public static Pair<Boolean, String> yQ(long paramLong)
  {
    AppMethodBeat.i(182103);
    Object localObject = ((l)g.af(l.class)).eiy().Hb(paramLong);
    if (Util.isNullOrNil(((eo)localObject).fRe))
    {
      localObject = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182103);
      return localObject;
    }
    com.tencent.mm.chatroom.storage.c localc = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(((eo)localObject).field_talker, ((eo)localObject).fRe);
    if (localc == null)
    {
      localObject = new Pair(Boolean.FALSE, ((eo)localObject).fRe);
      AppMethodBeat.o(182103);
      return localObject;
    }
    boolean bool;
    if (localc.yS(((eo)localObject).field_msgSvrId))
    {
      bool = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().h(localc);
      nt localnt = new nt();
      localnt.dTT.op = 1;
      localnt.dTT.dOe = localc.field_roomname;
      localnt.dTT.dTU = localc.field_todoid;
      if (bool) {
        EventCenter.instance.asyncPublish(localnt, Looper.getMainLooper());
      }
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg delete result:%s", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      if (bool)
      {
        ((ca)localObject).CK("");
        ((l)g.af(l.class)).eiy().a(((eo)localObject).field_msgId, (ca)localObject);
      }
      localObject = new Pair(Boolean.TRUE, ((eo)localObject).fRe);
      AppMethodBeat.o(182103);
      return localObject;
      bool = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().g(localc);
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg updateGroupTodo result:%s", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static abstract interface a
  {
    public abstract void amc();
    
    public abstract void amd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.y
 * JD-Core Version:    0.7.0.1
 */