package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.chatroom.ui.RoomCardUI;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.cwn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Iterator;
import java.util.List;

public final class y
{
  private static Boolean fLi = null;
  
  public static boolean Yd()
  {
    AppMethodBeat.i(182099);
    if ((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182099);
      return true;
    }
    boolean bool;
    if (fLi != null)
    {
      bool = fLi.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qya, 1);
    ad.i("MicroMsg.roomTodo.RoomTodoHelp", "getRoomTodoSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (fLi = Boolean.TRUE;; fLi = Boolean.FALSE)
    {
      bool = fLi.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
  }
  
  public static Pair<Boolean, String> a(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(182102);
    com.tencent.mm.chatroom.storage.c localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(paramc.field_roomname, paramc.field_todoid);
    if (localc == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu stoTodo no exist");
      paramc = new Pair(Boolean.FALSE, paramc.field_todoid);
      AppMethodBeat.o(182102);
      return paramc;
    }
    Iterator localIterator = localc.fMd.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aI(paramc.field_roomname, ((Long)localObject).longValue());
      ((bu)localObject).tZ("");
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(((ei)localObject).field_msgId, (bu)localObject);
    }
    ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
    c.a.a(paramc.field_roomname, 1, d(localc));
    boolean bool = c(localc);
    ad.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu todoId:%s result:%s", new Object[] { paramc.field_todoid, Boolean.valueOf(bool) });
    paramc = new Pair(Boolean.valueOf(bool), paramc.field_todoid);
    AppMethodBeat.o(182102);
    return paramc;
  }
  
  public static Pair<Boolean, String> a(bu parambu, k.b paramb)
  {
    AppMethodBeat.i(184782);
    if (parambu == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      parambu = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return parambu;
    }
    if (paramb == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      parambu = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return parambu;
    }
    long l = parambu.field_createTime;
    Object localObject = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
    com.tencent.mm.chatroom.storage.c localc;
    if (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject).hyi))
    {
      localObject = "related_msgid_" + parambu.field_msgSvrId;
      localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(parambu.field_talker, (String)localObject);
      if (localc != null)
      {
        ad.e("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl %s(%s) exist", new Object[] { localObject, Integer.valueOf(localc.field_state) });
        if (localc.field_state != 2) {
          break label571;
        }
        ad.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl delete %s", new Object[] { Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(localc)) });
      }
      localc = new com.tencent.mm.chatroom.storage.c();
      localc.field_todoid = ((String)localObject);
      localc.field_roomname = parambu.field_talker;
      localc.field_username = paramb.hCn;
      localc.field_path = paramb.hCm;
      localc.field_createtime = l;
      localc.field_updatetime = l;
      localc.field_custominfo = "";
      localObject = paramb.title;
      if (!bt.isNullOrNil((String)localObject)) {
        break label594;
      }
      paramb = ((n)g.ab(n.class)).Nt(paramb.hCn);
      if ((paramb == null) || (bt.isNullOrNil(paramb.field_nickname))) {
        break label594;
      }
    }
    label571:
    label594:
    for (paramb = paramb.field_nickname;; paramb = (k.b)localObject)
    {
      localc.field_title = paramb;
      localc.field_creator = com.tencent.mm.util.e.cB(parambu);
      localc.field_manager = u.aAm();
      localc.field_nreply = 0;
      localc.field_related_msgids = parambu.field_msgSvrId;
      boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().f(localc);
      ad.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoBySendSuccess todoId:%s result:%s", new Object[] { localc.field_todoid, Boolean.valueOf(bool) });
      if (bool)
      {
        paramb = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aI(parambu.field_talker, parambu.field_msgSvrId);
        paramb.tZ(localc.field_todoid);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramb.field_msgId, paramb);
        paramb = new nb();
        paramb.dAZ.op = 0;
        paramb.dAZ.dBa = localc.field_todoid;
        paramb.dAZ.dvs = parambu.field_talker;
        com.tencent.mm.sdk.b.a.IbL.a(paramb, Looper.getMainLooper());
      }
      parambu = new Pair(Boolean.valueOf(bool), localc.field_todoid);
      AppMethodBeat.o(184782);
      return parambu;
      localObject = ((com.tencent.mm.ai.a)localObject).hyi;
      break;
      parambu = new Pair(Boolean.TRUE, localc.field_todoid);
      AppMethodBeat.o(184782);
      return parambu;
    }
  }
  
  public static String a(cwn paramcwn)
  {
    AppMethodBeat.i(182105);
    if (paramcwn == null)
    {
      AppMethodBeat.o(182105);
      return "";
    }
    paramcwn = "RoomToolsTodo{TodoId='" + paramcwn.Hon + '\'' + ", Username='" + paramcwn.Username + '\'' + ", Path='" + paramcwn.ujc + '\'' + ", Time=" + paramcwn.qex + ", CustomInfo=" + paramcwn.Hoo + ", Title='" + bt.aRp(paramcwn.Title) + '\'' + ", Creator='" + paramcwn.Hom + '\'' + ", RelatedMsgId=" + paramcwn.Hop + ", Manager='" + paramcwn.Hoq + '\'' + '}';
    AppMethodBeat.o(182105);
    return paramcwn;
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, a parama)
  {
    AppMethodBeat.i(213408);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, true);
    if (paramBoolean) {
      locale.i(paramContext.getString(2131757056), 17, com.tencent.mm.cc.a.fromDPToPix(paramContext, 14));
    }
    for (;;)
    {
      locale.KWY = true;
      locale.KJy = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(182097);
          if (this.fLj)
          {
            paramAnonymousl.c(0, paramContext.getString(2131757054));
            AppMethodBeat.o(182097);
            return;
          }
          paramAnonymousl.a(0, paramContext.getResources().getColor(2131099803), paramContext.getString(2131757053));
          AppMethodBeat.o(182097);
        }
      };
      locale.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          paramAnonymousInt = 1;
          AppMethodBeat.i(182098);
          if ((paramAnonymousMenuItem.getItemId() == 0) && (this.fLk != null))
          {
            int i;
            if (paramBoolean)
            {
              this.fLk.Yf();
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
              this.fLk.Yg();
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
      locale.JXC = new e.b()
      {
        public final void onDismiss()
        {
          int i = 2;
          AppMethodBeat.i(184781);
          if (this.fLl == 2)
          {
            String str = paramString1;
            int j = paramInt2;
            if (paramBoolean) {
              i = 1;
            }
            z.a(str, 1, j, i, paramInt3, paramString2, paramString3);
          }
          if (this.fLl == 1) {
            z.a(paramString1, paramInt2, 3, 1, paramString2, paramString3);
          }
          AppMethodBeat.o(184781);
        }
      };
      locale.cMW();
      AppMethodBeat.o(213408);
      return;
      locale.i(paramContext.getString(2131757055), 17, com.tencent.mm.cc.a.fromDPToPix(paramContext, 14));
    }
  }
  
  public static boolean b(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(182104);
    paramc.field_state = 1;
    paramc.field_updatetime = cf.aCL();
    boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(paramc);
    AppMethodBeat.o(182104);
    return bool;
  }
  
  public static Pair<Boolean, String> c(bu parambu)
  {
    AppMethodBeat.i(182100);
    if (parambu == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      parambu = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return parambu;
    }
    if (parambu.fso())
    {
      localObject1 = new cwn();
      ((cwn)localObject1).Hon = ("related_msgid_" + parambu.field_msgSvrId);
      ((cwn)localObject1).Username = "roomannouncement@app.origin";
      ((cwn)localObject1).ujc = "";
      ((cwn)localObject1).qex = cf.aCN();
      ((cwn)localObject1).Title = aj.getContext().getString(2131757057);
      ((cwn)localObject1).Hom = com.tencent.mm.util.e.cB(parambu);
      ((cwn)localObject1).Hop = parambu.field_msgSvrId;
      ((cwn)localObject1).Hoq = u.aAm();
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(parambu.field_talker, 0, (cwn)localObject1);
      parambu = new Pair(Boolean.TRUE, ((cwn)localObject1).Hon);
      AppMethodBeat.o(182100);
      return parambu;
    }
    Object localObject2 = k.b.yr(parambu.field_content);
    if (localObject2 == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      parambu = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return parambu;
    }
    cwn localcwn = new cwn();
    Object localObject1 = (com.tencent.mm.ai.a)((k.b)localObject2).ao(com.tencent.mm.ai.a.class);
    if ((localObject1 == null) || (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject1).hyi)))
    {
      localcwn.Hon = ("related_msgid_" + parambu.field_msgSvrId);
      localcwn.Username = ((k.b)localObject2).hCn;
      localcwn.ujc = ((k.b)localObject2).hCm;
      localcwn.qex = cf.aCN();
      localObject1 = ((k.b)localObject2).title;
      if (!bt.isNullOrNil((String)localObject1)) {
        break label427;
      }
      localObject2 = ((n)g.ab(n.class)).Nt(((k.b)localObject2).hCn);
      if ((localObject2 == null) || (bt.isNullOrNil(((WxaAttributes)localObject2).field_nickname))) {
        break label427;
      }
      localObject1 = ((WxaAttributes)localObject2).field_nickname;
    }
    label427:
    for (;;)
    {
      localcwn.Title = ((String)localObject1);
      localcwn.Hom = com.tencent.mm.util.e.cB(parambu);
      localcwn.Hop = parambu.field_msgSvrId;
      localcwn.Hoq = u.aAm();
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(parambu.field_talker, 0, localcwn);
      parambu = new Pair(Boolean.TRUE, localcwn.Hon);
      AppMethodBeat.o(182100);
      return parambu;
      localcwn.Hon = ((com.tencent.mm.ai.a)localObject1).hyi;
      break;
    }
  }
  
  public static boolean c(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(213407);
    paramc.field_state = 2;
    paramc.field_updatetime = cf.aCL();
    boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(paramc);
    AppMethodBeat.o(213407);
    return bool;
  }
  
  public static cwn d(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(182106);
    cwn localcwn = new cwn();
    localcwn.Hon = paramc.field_todoid;
    localcwn.Username = paramc.field_username;
    localcwn.ujc = paramc.field_path;
    localcwn.qex = ((int)(paramc.field_createtime / 1000L));
    localcwn.Title = paramc.field_title;
    localcwn.Hom = paramc.field_creator;
    localcwn.Hop = paramc.Yn();
    localcwn.Hoq = paramc.field_manager;
    AppMethodBeat.o(182106);
    return localcwn;
  }
  
  public static String d(bu parambu)
  {
    AppMethodBeat.i(213406);
    if (parambu == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      AppMethodBeat.o(213406);
      return "";
    }
    if (parambu.fso())
    {
      parambu = "related_msgid_" + parambu.field_msgSvrId;
      AppMethodBeat.o(213406);
      return parambu;
    }
    Object localObject = k.b.yr(parambu.field_content);
    if (localObject == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      AppMethodBeat.o(213406);
      return "";
    }
    localObject = (com.tencent.mm.ai.a)((k.b)localObject).ao(com.tencent.mm.ai.a.class);
    if ((localObject == null) || (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject).hyi)))
    {
      parambu = "related_msgid_" + parambu.field_msgSvrId;
      AppMethodBeat.o(213406);
      return parambu;
    }
    parambu = ((com.tencent.mm.ai.a)localObject).hyi;
    AppMethodBeat.o(213406);
    return parambu;
  }
  
  public static Pair<Boolean, String> e(bu parambu)
  {
    AppMethodBeat.i(182101);
    Object localObject1 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(parambu.field_talker, parambu.fkD);
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.chatroom.storage.c)localObject1).fMd.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Long)((Iterator)localObject2).next();
        localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aI(parambu.field_talker, ((Long)localObject3).longValue());
        ((bu)localObject3).tZ("");
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(((ei)localObject3).field_msgId, (bu)localObject3);
      }
      localObject2 = new nb();
      ((nb)localObject2).dAZ.op = 1;
      ((nb)localObject2).dAZ.dBa = parambu.fkD;
      ((nb)localObject2).dAZ.dvs = parambu.field_talker;
      com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
      boolean bool = c((com.tencent.mm.chatroom.storage.c)localObject1);
      ad.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s result:%s", new Object[] { parambu.fkD, Boolean.valueOf(bool) });
      localObject1 = d((com.tencent.mm.chatroom.storage.c)localObject1);
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(parambu.field_talker, 1, (cwn)localObject1);
      parambu = new Pair(Boolean.TRUE, parambu.fkD);
      AppMethodBeat.o(182101);
      return parambu;
    }
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aI(parambu.field_talker, parambu.field_msgSvrId);
    ((bu)localObject1).tZ("");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(((ei)localObject1).field_msgId, (bu)localObject1);
    localObject1 = new cwn();
    ((cwn)localObject1).Hon = parambu.fkD;
    Object localObject2 = k.b.yr(parambu.field_content);
    if (localObject2 == null)
    {
      ((cwn)localObject1).Username = "";
      ((cwn)localObject1).ujc = "";
    }
    for (((cwn)localObject1).Title = "";; ((cwn)localObject1).Title = ((k.b)localObject2).title)
    {
      ((cwn)localObject1).qex = ((int)(parambu.field_createTime / 10000L));
      ((cwn)localObject1).Hom = com.tencent.mm.util.e.cB(parambu);
      ((cwn)localObject1).Hop = parambu.field_msgSvrId;
      ((cwn)localObject1).Hoq = "";
      ad.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s", new Object[] { parambu.fkD });
      break;
      ((cwn)localObject1).Username = ((k.b)localObject2).hCn;
      ((cwn)localObject1).ujc = ((k.b)localObject2).hCm;
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
  
  public static String f(bu parambu)
  {
    AppMethodBeat.i(213409);
    if (parambu == null)
    {
      AppMethodBeat.o(213409);
      return "";
    }
    if (parambu.fso())
    {
      AppMethodBeat.o(213409);
      return "roomannouncement@app.origin";
    }
    parambu = k.b.yr(parambu.field_content);
    if (parambu == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo content is null");
      AppMethodBeat.o(213409);
      return "";
    }
    if ((com.tencent.mm.ai.a)parambu.ao(com.tencent.mm.ai.a.class) == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo appContentAppBrandPiece is null");
      AppMethodBeat.o(213409);
      return "";
    }
    parambu = parambu.hCn;
    AppMethodBeat.o(213409);
    return parambu;
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182107);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "gotoRoomCard roomname is null");
      AppMethodBeat.o(182107);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, RoomCardUI.class);
    localIntent.putExtra("RoomInfo_Id", paramString);
    localIntent.putExtra("room_notice", q.yU(paramString));
    localIntent.putExtra("room_notice_publish_time", q.yX(paramString));
    localIntent.putExtra("room_notice_editor", q.yW(paramString));
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(paramString);
    if (paramString != null)
    {
      localIntent.putExtra("Is_RoomOwner", paramString.field_roomowner.equals(u.aAm()));
      localIntent.putExtra("Is_RoomManager", paramString.aSH(u.aAm()));
    }
    if (paramBoolean) {
      localIntent.setFlags(268435456);
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(182107);
  }
  
  public static Pair<Boolean, String> qL(long paramLong)
  {
    AppMethodBeat.i(182103);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramLong);
    if (bt.isNullOrNil(((ei)localObject).fkD))
    {
      localObject = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182103);
      return localObject;
    }
    com.tencent.mm.chatroom.storage.c localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(((ei)localObject).field_talker, ((ei)localObject).fkD);
    if (localc == null)
    {
      localObject = new Pair(Boolean.FALSE, ((ei)localObject).fkD);
      AppMethodBeat.o(182103);
      return localObject;
    }
    boolean bool;
    if (localc.qN(((ei)localObject).field_msgSvrId))
    {
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(localc);
      nb localnb = new nb();
      localnb.dAZ.op = 1;
      localnb.dAZ.dvs = localc.field_roomname;
      localnb.dAZ.dBa = localc.field_todoid;
      if (bool) {
        com.tencent.mm.sdk.b.a.IbL.a(localnb, Looper.getMainLooper());
      }
      ad.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg delete result:%s", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      if (bool)
      {
        ((bu)localObject).tZ("");
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(((ei)localObject).field_msgId, (bu)localObject);
      }
      localObject = new Pair(Boolean.TRUE, ((ei)localObject).fkD);
      AppMethodBeat.o(182103);
      return localObject;
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(localc);
      ad.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg updateGroupTodo result:%s", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static abstract interface a
  {
    public abstract void Yf();
    
    public abstract void Yg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.y
 * JD-Core Version:    0.7.0.1
 */