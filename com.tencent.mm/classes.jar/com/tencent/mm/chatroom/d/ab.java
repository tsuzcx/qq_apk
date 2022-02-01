package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qa;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.chatroom.ui.RoomCardUI;
import com.tencent.mm.chatroom.ui.a.b;
import com.tencent.mm.chatroom.ui.a.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.etd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.util.g;
import java.util.Iterator;
import java.util.List;

public final class ab
{
  private static Boolean lyN = null;
  
  public static Pair<Boolean, String> a(c paramc)
  {
    AppMethodBeat.i(182102);
    c localc = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().ar(paramc.field_roomname, paramc.field_todoid);
    if (localc == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu stoTodo no exist");
      paramc = new Pair(Boolean.FALSE, paramc.field_todoid);
      AppMethodBeat.o(182102);
      return paramc;
    }
    Iterator localIterator = localc.lzA.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      localObject = ((n)h.ax(n.class)).gaZ().aU(paramc.field_roomname, ((Long)localObject).longValue());
      ((cc)localObject).Ce("");
      ((n)h.ax(n.class)).gaZ().a(((fi)localObject).field_msgId, (cc)localObject);
    }
    ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getRoomTodoMsgService();
    c.a.a(paramc.field_roomname, 1, d(localc));
    boolean bool = c(localc);
    Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu todoId:%s result:%s", new Object[] { paramc.field_todoid, Boolean.valueOf(bool) });
    paramc = new Pair(Boolean.valueOf(bool), paramc.field_todoid);
    AppMethodBeat.o(182102);
    return paramc;
  }
  
  public static Pair<Boolean, String> a(cc paramcc, k.b paramb)
  {
    AppMethodBeat.i(184782);
    if (paramcc == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      paramcc = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return paramcc;
    }
    if (paramb == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      paramcc = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return paramcc;
    }
    long l = paramcc.getCreateTime();
    Object localObject = (com.tencent.mm.message.a)paramb.aK(com.tencent.mm.message.a.class);
    c localc;
    if (Util.isNullOrNil(((com.tencent.mm.message.a)localObject).nOY))
    {
      localObject = "related_msgid_" + paramcc.field_msgSvrId;
      localc = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().ar(paramcc.field_talker, (String)localObject);
      if (localc != null)
      {
        Log.e("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl %s(%s) exist", new Object[] { localObject, Integer.valueOf(localc.field_state) });
        if (localc.field_state != 2) {
          break label591;
        }
        Log.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl delete %s", new Object[] { Boolean.valueOf(((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().h(localc)) });
      }
      localc = new c();
      localc.field_todoid = ((String)localObject);
      localc.field_roomname = paramcc.field_talker;
      localc.field_username = paramb.nTD;
      localc.field_path = paramb.nTC;
      localc.field_createtime = l;
      localc.field_updatetime = l;
      localc.field_custominfo = "";
      localObject = paramb.title;
      if (!Util.isNullOrNil((String)localObject)) {
        break label614;
      }
      WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.s)h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(paramb.nTD);
      if ((localWxaAttributes == null) || (Util.isNullOrNil(localWxaAttributes.field_nickname))) {
        break label614;
      }
      localObject = localWxaAttributes.field_nickname;
    }
    label591:
    label614:
    for (;;)
    {
      localc.field_title = ((String)localObject);
      localc.field_creator = g.dP(paramcc);
      localc.field_manager = z.bAM();
      localc.field_nreply = 0;
      localc.field_related_msgids = paramcc.field_msgSvrId;
      localc.field_shareKey = paramb.nTJ;
      localc.field_shareName = paramcc.field_talker;
      boolean bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().f(localc);
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoBySendSuccess todoId:%s result:%s", new Object[] { localc.field_todoid, Boolean.valueOf(bool) });
      if (bool)
      {
        paramb = ((n)h.ax(n.class)).gaZ().aU(paramcc.field_talker, paramcc.field_msgSvrId);
        paramb.Ce(localc.field_todoid);
        ((n)h.ax(n.class)).gaZ().a(paramb.field_msgId, paramb);
        paramb = new qa();
        paramb.hTi.op = 0;
        paramb.hTi.hTj = localc.field_todoid;
        paramb.hTi.hMM = paramcc.field_talker;
        paramb.asyncPublish(Looper.getMainLooper());
      }
      paramcc = new Pair(Boolean.valueOf(bool), localc.field_todoid);
      AppMethodBeat.o(184782);
      return paramcc;
      localObject = ((com.tencent.mm.message.a)localObject).nOY;
      break;
      paramcc = new Pair(Boolean.TRUE, localc.field_todoid);
      AppMethodBeat.o(184782);
      return paramcc;
    }
  }
  
  public static String a(etd parametd)
  {
    AppMethodBeat.i(182105);
    if (parametd == null)
    {
      AppMethodBeat.o(182105);
      return "";
    }
    parametd = "RoomToolsTodo{TodoId='" + parametd.abwt + '\'' + ", Username='" + parametd.Username + '\'' + ", Path='" + parametd.IcT + '\'' + ", Time=" + parametd.crm + ", CustomInfo=" + parametd.abwu + ", Title='" + Util.secPrint(parametd.hAP) + '\'' + ", Creator='" + parametd.abws + '\'' + ", RelatedMsgId=" + parametd.abwv + ", Manager='" + parametd.abww + '\'' + '}';
    AppMethodBeat.o(182105);
    return parametd;
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, a parama)
  {
    AppMethodBeat.i(241492);
    f localf = new f(paramContext, 1, true);
    if (paramBoolean) {
      localf.h(paramContext.getString(a.i.lHk), 17, com.tencent.mm.cd.a.fromDPToPix(paramContext, 14));
    }
    for (;;)
    {
      localf.ageZ = true;
      localf.Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(182097);
          if (this.lyO)
          {
            paramAnonymouss.c(0, paramContext.getString(a.i.lHi));
            AppMethodBeat.o(182097);
            return;
          }
          paramAnonymouss.a(0, paramContext.getResources().getColor(a.b.Red), paramContext.getString(a.i.lHh));
          AppMethodBeat.o(182097);
        }
      };
      localf.GAC = new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          paramAnonymousInt = 1;
          AppMethodBeat.i(182098);
          if ((paramAnonymousMenuItem.getItemId() == 0) && (ab.this != null))
          {
            int i;
            if (paramBoolean)
            {
              ab.this.aLZ();
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
              ac.a(paramAnonymousMenuItem, 2, i, paramAnonymousInt, paramInt3, paramString2, paramString3);
              AppMethodBeat.o(182098);
              return;
              ab.this.aMa();
              break;
              label101:
              paramAnonymousInt = 2;
            }
            label106:
            if (paramInt1 == 1) {
              ac.a(paramString1, paramInt2, 3, 2, paramString2, paramString3);
            }
          }
          AppMethodBeat.o(182098);
        }
      };
      localf.aeLi = new f.b()
      {
        public final void onDismiss()
        {
          int i = 2;
          AppMethodBeat.i(184781);
          if (this.lyQ == 2)
          {
            String str = paramString1;
            int j = paramInt2;
            if (paramBoolean) {
              i = 1;
            }
            ac.a(str, 1, j, i, paramInt3, paramString2, paramString3);
          }
          if (this.lyQ == 1) {
            ac.a(paramString1, paramInt2, 3, 1, paramString2, paramString3);
          }
          AppMethodBeat.o(184781);
        }
      };
      localf.dDn();
      AppMethodBeat.o(241492);
      return;
      localf.h(paramContext.getString(a.i.lHj), 17, com.tencent.mm.cd.a.fromDPToPix(paramContext, 14));
    }
  }
  
  public static boolean aLX()
  {
    AppMethodBeat.i(182099);
    AppMethodBeat.o(182099);
    return true;
  }
  
  public static boolean b(c paramc)
  {
    AppMethodBeat.i(182104);
    paramc.field_state = 1;
    paramc.field_updatetime = cn.bDv();
    boolean bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().g(paramc);
    AppMethodBeat.o(182104);
    return bool;
  }
  
  public static Pair<Boolean, String> c(cc paramcc)
  {
    AppMethodBeat.i(182100);
    if (paramcc == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      paramcc = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return paramcc;
    }
    if (paramcc.jcs())
    {
      localObject = new etd();
      ((etd)localObject).abwt = ("related_msgid_" + paramcc.field_msgSvrId);
      ((etd)localObject).Username = "roomannouncement@app.origin";
      ((etd)localObject).IcT = "";
      ((etd)localObject).crm = cn.getSyncServerTimeSecond();
      ((etd)localObject).hAP = MMApplicationContext.getContext().getString(a.i.gws);
      ((etd)localObject).abws = g.dP(paramcc);
      ((etd)localObject).abwv = paramcc.field_msgSvrId;
      ((etd)localObject).abww = z.bAM();
      ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(paramcc.field_talker, 0, (etd)localObject);
      paramcc = new Pair(Boolean.TRUE, ((etd)localObject).abwt);
      AppMethodBeat.o(182100);
      return paramcc;
    }
    k.b localb = k.b.Hf(paramcc.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      paramcc = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return paramcc;
    }
    etd localetd = new etd();
    Object localObject = (com.tencent.mm.message.a)localb.aK(com.tencent.mm.message.a.class);
    if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.message.a)localObject).nOY)))
    {
      localetd.abwt = ("related_msgid_" + paramcc.field_msgSvrId);
      localetd.Username = localb.nTD;
      localetd.IcT = localb.nTC;
      localetd.crm = cn.getSyncServerTimeSecond();
      localObject = localb.title;
      if (!Util.isNullOrNil((String)localObject)) {
        break label447;
      }
      WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.s)h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(localb.nTD);
      if ((localWxaAttributes == null) || (Util.isNullOrNil(localWxaAttributes.field_nickname))) {
        break label447;
      }
      localObject = localWxaAttributes.field_nickname;
    }
    label447:
    for (;;)
    {
      localetd.hAP = ((String)localObject);
      localetd.abws = g.dP(paramcc);
      localetd.abwv = paramcc.field_msgSvrId;
      localetd.abww = z.bAM();
      localetd.abwx = localb.nTJ;
      localetd.abwy = paramcc.field_talker;
      ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(paramcc.field_talker, 0, localetd);
      paramcc = new Pair(Boolean.TRUE, localetd.abwt);
      AppMethodBeat.o(182100);
      return paramcc;
      localetd.abwt = ((com.tencent.mm.message.a)localObject).nOY;
      break;
    }
  }
  
  public static boolean c(c paramc)
  {
    AppMethodBeat.i(241473);
    paramc.field_state = 2;
    paramc.field_updatetime = cn.bDv();
    boolean bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().g(paramc);
    AppMethodBeat.o(241473);
    return bool;
  }
  
  public static etd d(c paramc)
  {
    AppMethodBeat.i(182106);
    etd localetd = new etd();
    localetd.abwt = paramc.field_todoid;
    localetd.Username = paramc.field_username;
    localetd.IcT = paramc.field_path;
    localetd.crm = ((int)(paramc.field_createtime / 1000L));
    localetd.hAP = paramc.field_title;
    localetd.abws = paramc.field_creator;
    localetd.abwv = paramc.aMf();
    localetd.abww = paramc.field_manager;
    localetd.abwu = com.tencent.mm.bx.b.bsj(paramc.field_custominfo);
    localetd.abwx = paramc.field_shareKey;
    localetd.abwy = paramc.field_shareName;
    AppMethodBeat.o(182106);
    return localetd;
  }
  
  public static String d(cc paramcc)
  {
    AppMethodBeat.i(241457);
    if (paramcc == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      AppMethodBeat.o(241457);
      return "";
    }
    if (paramcc.jcs())
    {
      paramcc = "related_msgid_" + paramcc.field_msgSvrId;
      AppMethodBeat.o(241457);
      return paramcc;
    }
    Object localObject = k.b.Hf(paramcc.field_content);
    if (localObject == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      AppMethodBeat.o(241457);
      return "";
    }
    localObject = (com.tencent.mm.message.a)((k.b)localObject).aK(com.tencent.mm.message.a.class);
    if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.message.a)localObject).nOY)))
    {
      paramcc = "related_msgid_" + paramcc.field_msgSvrId;
      AppMethodBeat.o(241457);
      return paramcc;
    }
    paramcc = ((com.tencent.mm.message.a)localObject).nOY;
    AppMethodBeat.o(241457);
    return paramcc;
  }
  
  public static Pair<Boolean, String> e(cc paramcc)
  {
    AppMethodBeat.i(182101);
    Object localObject1 = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().ar(paramcc.field_talker, paramcc.kLt);
    if (localObject1 != null)
    {
      localObject2 = ((c)localObject1).lzA.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Long)((Iterator)localObject2).next();
        localObject3 = ((n)h.ax(n.class)).gaZ().aU(paramcc.field_talker, ((Long)localObject3).longValue());
        ((cc)localObject3).Ce("");
        ((n)h.ax(n.class)).gaZ().a(((fi)localObject3).field_msgId, (cc)localObject3);
      }
      localObject2 = new qa();
      ((qa)localObject2).hTi.op = 1;
      ((qa)localObject2).hTi.hTj = paramcc.kLt;
      ((qa)localObject2).hTi.hMM = paramcc.field_talker;
      ((qa)localObject2).asyncPublish(Looper.getMainLooper());
      boolean bool = c((c)localObject1);
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s result:%s", new Object[] { paramcc.kLt, Boolean.valueOf(bool) });
      localObject1 = d((c)localObject1);
      ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(paramcc.field_talker, 1, (etd)localObject1);
      paramcc = new Pair(Boolean.TRUE, paramcc.kLt);
      AppMethodBeat.o(182101);
      return paramcc;
    }
    localObject1 = ((n)h.ax(n.class)).gaZ().aU(paramcc.field_talker, paramcc.field_msgSvrId);
    ((cc)localObject1).Ce("");
    ((n)h.ax(n.class)).gaZ().a(((fi)localObject1).field_msgId, (cc)localObject1);
    localObject1 = new etd();
    ((etd)localObject1).abwt = paramcc.kLt;
    Object localObject2 = k.b.Hf(paramcc.field_content);
    if (localObject2 == null)
    {
      ((etd)localObject1).Username = "";
      ((etd)localObject1).IcT = "";
    }
    for (((etd)localObject1).hAP = "";; ((etd)localObject1).hAP = ((k.b)localObject2).title)
    {
      ((etd)localObject1).crm = ((int)(paramcc.getCreateTime() / 10000L));
      ((etd)localObject1).abws = g.dP(paramcc);
      ((etd)localObject1).abwv = paramcc.field_msgSvrId;
      ((etd)localObject1).abww = "";
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s", new Object[] { paramcc.kLt });
      break;
      ((etd)localObject1).Username = ((k.b)localObject2).nTD;
      ((etd)localObject1).IcT = ((k.b)localObject2).nTC;
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
  
  public static String f(cc paramcc)
  {
    AppMethodBeat.i(241499);
    if (paramcc == null)
    {
      AppMethodBeat.o(241499);
      return "";
    }
    if (paramcc.jcs())
    {
      AppMethodBeat.o(241499);
      return "roomannouncement@app.origin";
    }
    paramcc = k.b.Hf(paramcc.field_content);
    if (paramcc == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo content is null");
      AppMethodBeat.o(241499);
      return "";
    }
    if ((com.tencent.mm.message.a)paramcc.aK(com.tencent.mm.message.a.class) == null)
    {
      Log.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo appContentAppBrandPiece is null");
      AppMethodBeat.o(241499);
      return "";
    }
    paramcc = paramcc.nTD;
    AppMethodBeat.o(241499);
    return paramcc;
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
    localIntent.putExtra("room_notice", v.Ip(paramString));
    localIntent.putExtra("room_notice_publish_time", v.Is(paramString));
    localIntent.putExtra("room_notice_editor", v.Ir(paramString));
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      localIntent.putExtra("from_scene", i);
      paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
      if (paramString != null)
      {
        localIntent.putExtra("Is_RoomOwner", paramString.field_roomowner.equals(z.bAM()));
        localIntent.putExtra("Is_RoomManager", paramString.bvK(z.bAM()));
      }
      localIntent.putExtra("room_member_count", paramString.field_memberCount);
      if (paramBoolean) {
        localIntent.setFlags(268435456);
      }
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(182107);
      return;
    }
  }
  
  public static Pair<Boolean, String> hj(long paramLong)
  {
    AppMethodBeat.i(182103);
    Object localObject = ((n)h.ax(n.class)).gaZ().sl(paramLong);
    if (Util.isNullOrNil(((fi)localObject).kLt))
    {
      localObject = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182103);
      return localObject;
    }
    c localc = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().ar(((fi)localObject).field_talker, ((fi)localObject).kLt);
    if (localc == null)
    {
      localObject = new Pair(Boolean.FALSE, ((fi)localObject).kLt);
      AppMethodBeat.o(182103);
      return localObject;
    }
    boolean bool;
    if (localc.hl(((fi)localObject).field_msgSvrId))
    {
      bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().h(localc);
      qa localqa = new qa();
      localqa.hTi.op = 1;
      localqa.hTi.hMM = localc.field_roomname;
      localqa.hTi.hTj = localc.field_todoid;
      if (bool) {
        localqa.asyncPublish(Looper.getMainLooper());
      }
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg delete result:%s", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      if (bool)
      {
        ((cc)localObject).Ce("");
        ((n)h.ax(n.class)).gaZ().a(((fi)localObject).field_msgId, (cc)localObject);
      }
      localObject = new Pair(Boolean.TRUE, ((fi)localObject).kLt);
      AppMethodBeat.o(182103);
      return localObject;
      bool = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().g(localc);
      Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg updateGroupTodo result:%s", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static abstract interface a
  {
    public abstract void aLZ();
    
    public abstract void aMa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.ab
 * JD-Core Version:    0.7.0.1
 */