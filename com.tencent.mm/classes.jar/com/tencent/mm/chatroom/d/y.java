package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.chatroom.ui.RoomCardUI;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Iterator;
import java.util.List;

public final class y
{
  private static Boolean fNm = null;
  
  public static boolean Yn()
  {
    AppMethodBeat.i(182099);
    if ((j.DEBUG) || (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182099);
      return true;
    }
    boolean bool;
    if (fNm != null)
    {
      bool = fNm.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFg, 1);
    ae.i("MicroMsg.roomTodo.RoomTodoHelp", "getRoomTodoSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (fNm = Boolean.TRUE;; fNm = Boolean.FALSE)
    {
      bool = fNm.booleanValue();
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
      ae.e("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu stoTodo no exist");
      paramc = new Pair(Boolean.FALSE, paramc.field_todoid);
      AppMethodBeat.o(182102);
      return paramc;
    }
    Iterator localIterator = localc.fOh.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().aJ(paramc.field_roomname, ((Long)localObject).longValue());
      ((bv)localObject).uu("");
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(((ei)localObject).field_msgId, (bv)localObject);
    }
    ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
    c.a.a(paramc.field_roomname, 1, d(localc));
    boolean bool = c(localc);
    ae.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu todoId:%s result:%s", new Object[] { paramc.field_todoid, Boolean.valueOf(bool) });
    paramc = new Pair(Boolean.valueOf(bool), paramc.field_todoid);
    AppMethodBeat.o(182102);
    return paramc;
  }
  
  public static Pair<Boolean, String> a(bv parambv, k.b paramb)
  {
    AppMethodBeat.i(184782);
    if (parambv == null)
    {
      ae.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      parambv = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return parambv;
    }
    if (paramb == null)
    {
      ae.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      parambv = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return parambv;
    }
    long l = parambv.field_createTime;
    Object localObject = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
    com.tencent.mm.chatroom.storage.c localc;
    if (bu.isNullOrNil(((com.tencent.mm.ah.a)localObject).hAW))
    {
      localObject = "related_msgid_" + parambv.field_msgSvrId;
      localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(parambv.field_talker, (String)localObject);
      if (localc != null)
      {
        ae.e("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl %s(%s) exist", new Object[] { localObject, Integer.valueOf(localc.field_state) });
        if (localc.field_state != 2) {
          break label595;
        }
        ae.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl delete %s", new Object[] { Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(localc)) });
      }
      localc = new com.tencent.mm.chatroom.storage.c();
      localc.field_todoid = ((String)localObject);
      localc.field_roomname = parambv.field_talker;
      localc.field_username = paramb.hFc;
      localc.field_path = paramb.hFb;
      localc.field_createtime = l;
      localc.field_updatetime = l;
      localc.field_custominfo = "";
      localObject = paramb.title;
      if (!bu.isNullOrNil((String)localObject)) {
        break label618;
      }
      WxaAttributes localWxaAttributes = ((o)g.ab(o.class)).Ob(paramb.hFc);
      if ((localWxaAttributes == null) || (bu.isNullOrNil(localWxaAttributes.field_nickname))) {
        break label618;
      }
      localObject = localWxaAttributes.field_nickname;
    }
    label595:
    label618:
    for (;;)
    {
      localc.field_title = ((String)localObject);
      localc.field_creator = com.tencent.mm.util.e.cA(parambv);
      localc.field_manager = v.aAC();
      localc.field_nreply = 0;
      localc.field_related_msgids = parambv.field_msgSvrId;
      localc.field_shareKey = paramb.hFi;
      localc.field_shareName = parambv.field_talker;
      boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().f(localc);
      ae.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoBySendSuccess todoId:%s result:%s", new Object[] { localc.field_todoid, Boolean.valueOf(bool) });
      if (bool)
      {
        paramb = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().aJ(parambv.field_talker, parambv.field_msgSvrId);
        paramb.uu(localc.field_todoid);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramb.field_msgId, paramb);
        paramb = new nc();
        paramb.dCe.op = 0;
        paramb.dCe.dCf = localc.field_todoid;
        paramb.dCe.dwx = parambv.field_talker;
        com.tencent.mm.sdk.b.a.IvT.a(paramb, Looper.getMainLooper());
      }
      parambv = new Pair(Boolean.valueOf(bool), localc.field_todoid);
      AppMethodBeat.o(184782);
      return parambv;
      localObject = ((com.tencent.mm.ah.a)localObject).hAW;
      break;
      parambv = new Pair(Boolean.TRUE, localc.field_todoid);
      AppMethodBeat.o(184782);
      return parambv;
    }
  }
  
  public static String a(cxh paramcxh)
  {
    AppMethodBeat.i(182105);
    if (paramcxh == null)
    {
      AppMethodBeat.o(182105);
      return "";
    }
    paramcxh = "RoomToolsTodo{TodoId='" + paramcxh.HHN + '\'' + ", Username='" + paramcxh.Username + '\'' + ", Path='" + paramcxh.uuA + '\'' + ", Time=" + paramcxh.qlc + ", CustomInfo=" + paramcxh.HHO + ", Title='" + bu.aSM(paramcxh.Title) + '\'' + ", Creator='" + paramcxh.HHM + '\'' + ", RelatedMsgId=" + paramcxh.HHP + ", Manager='" + paramcxh.HHQ + '\'' + '}';
    AppMethodBeat.o(182105);
    return paramcxh;
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, a parama)
  {
    AppMethodBeat.i(217121);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, true);
    if (paramBoolean) {
      locale.i(paramContext.getString(2131757056), 17, com.tencent.mm.cb.a.fromDPToPix(paramContext, 14));
    }
    for (;;)
    {
      locale.Ltw = true;
      locale.LfS = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(182097);
          if (this.fNn)
          {
            paramAnonymousl.d(0, paramContext.getString(2131757054));
            AppMethodBeat.o(182097);
            return;
          }
          paramAnonymousl.a(0, paramContext.getResources().getColor(2131099803), paramContext.getString(2131757053));
          AppMethodBeat.o(182097);
        }
      };
      locale.LfT = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          paramAnonymousInt = 1;
          AppMethodBeat.i(182098);
          if ((paramAnonymousMenuItem.getItemId() == 0) && (this.fNo != null))
          {
            int i;
            if (paramBoolean)
            {
              this.fNo.Yp();
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
              this.fNo.Yq();
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
      locale.KtV = new e.b()
      {
        public final void onDismiss()
        {
          int i = 2;
          AppMethodBeat.i(184781);
          if (this.fNp == 2)
          {
            String str = paramString1;
            int j = paramInt2;
            if (paramBoolean) {
              i = 1;
            }
            z.a(str, 1, j, i, paramInt3, paramString2, paramString3);
          }
          if (this.fNp == 1) {
            z.a(paramString1, paramInt2, 3, 1, paramString2, paramString3);
          }
          AppMethodBeat.o(184781);
        }
      };
      locale.cPF();
      AppMethodBeat.o(217121);
      return;
      locale.i(paramContext.getString(2131757055), 17, com.tencent.mm.cb.a.fromDPToPix(paramContext, 14));
    }
  }
  
  public static boolean b(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(182104);
    paramc.field_state = 1;
    paramc.field_updatetime = ch.aDb();
    boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(paramc);
    AppMethodBeat.o(182104);
    return bool;
  }
  
  public static Pair<Boolean, String> c(bv parambv)
  {
    AppMethodBeat.i(182100);
    if (parambv == null)
    {
      ae.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      parambv = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return parambv;
    }
    if (parambv.fwp())
    {
      localObject = new cxh();
      ((cxh)localObject).HHN = ("related_msgid_" + parambv.field_msgSvrId);
      ((cxh)localObject).Username = "roomannouncement@app.origin";
      ((cxh)localObject).uuA = "";
      ((cxh)localObject).qlc = ch.aDd();
      ((cxh)localObject).Title = ak.getContext().getString(2131757057);
      ((cxh)localObject).HHM = com.tencent.mm.util.e.cA(parambv);
      ((cxh)localObject).HHP = parambv.field_msgSvrId;
      ((cxh)localObject).HHQ = v.aAC();
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(parambv.field_talker, 0, (cxh)localObject);
      parambv = new Pair(Boolean.TRUE, ((cxh)localObject).HHN);
      AppMethodBeat.o(182100);
      return parambv;
    }
    k.b localb = k.b.zb(parambv.field_content);
    if (localb == null)
    {
      ae.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      parambv = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return parambv;
    }
    cxh localcxh = new cxh();
    Object localObject = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
    if ((localObject == null) || (bu.isNullOrNil(((com.tencent.mm.ah.a)localObject).hAW)))
    {
      localcxh.HHN = ("related_msgid_" + parambv.field_msgSvrId);
      localcxh.Username = localb.hFc;
      localcxh.uuA = localb.hFb;
      localcxh.qlc = ch.aDd();
      localObject = localb.title;
      if (!bu.isNullOrNil((String)localObject)) {
        break label447;
      }
      WxaAttributes localWxaAttributes = ((o)g.ab(o.class)).Ob(localb.hFc);
      if ((localWxaAttributes == null) || (bu.isNullOrNil(localWxaAttributes.field_nickname))) {
        break label447;
      }
      localObject = localWxaAttributes.field_nickname;
    }
    label447:
    for (;;)
    {
      localcxh.Title = ((String)localObject);
      localcxh.HHM = com.tencent.mm.util.e.cA(parambv);
      localcxh.HHP = parambv.field_msgSvrId;
      localcxh.HHQ = v.aAC();
      localcxh.HHR = localb.hFi;
      localcxh.HHS = parambv.field_talker;
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(parambv.field_talker, 0, localcxh);
      parambv = new Pair(Boolean.TRUE, localcxh.HHN);
      AppMethodBeat.o(182100);
      return parambv;
      localcxh.HHN = ((com.tencent.mm.ah.a)localObject).hAW;
      break;
    }
  }
  
  public static boolean c(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(217120);
    paramc.field_state = 2;
    paramc.field_updatetime = ch.aDb();
    boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(paramc);
    AppMethodBeat.o(217120);
    return bool;
  }
  
  public static cxh d(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(182106);
    cxh localcxh = new cxh();
    localcxh.HHN = paramc.field_todoid;
    localcxh.Username = paramc.field_username;
    localcxh.uuA = paramc.field_path;
    localcxh.qlc = ((int)(paramc.field_createtime / 1000L));
    localcxh.Title = paramc.field_title;
    localcxh.HHM = paramc.field_creator;
    localcxh.HHP = paramc.Yx();
    localcxh.HHQ = paramc.field_manager;
    localcxh.HHO = com.tencent.mm.bw.b.aPw(paramc.field_custominfo);
    localcxh.HHR = paramc.field_shareKey;
    localcxh.HHS = paramc.field_shareName;
    AppMethodBeat.o(182106);
    return localcxh;
  }
  
  public static String d(bv parambv)
  {
    AppMethodBeat.i(217119);
    if (parambv == null)
    {
      ae.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      AppMethodBeat.o(217119);
      return "";
    }
    if (parambv.fwp())
    {
      parambv = "related_msgid_" + parambv.field_msgSvrId;
      AppMethodBeat.o(217119);
      return parambv;
    }
    Object localObject = k.b.zb(parambv.field_content);
    if (localObject == null)
    {
      ae.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      AppMethodBeat.o(217119);
      return "";
    }
    localObject = (com.tencent.mm.ah.a)((k.b)localObject).ao(com.tencent.mm.ah.a.class);
    if ((localObject == null) || (bu.isNullOrNil(((com.tencent.mm.ah.a)localObject).hAW)))
    {
      parambv = "related_msgid_" + parambv.field_msgSvrId;
      AppMethodBeat.o(217119);
      return parambv;
    }
    parambv = ((com.tencent.mm.ah.a)localObject).hAW;
    AppMethodBeat.o(217119);
    return parambv;
  }
  
  public static Pair<Boolean, String> e(bv parambv)
  {
    AppMethodBeat.i(182101);
    Object localObject1 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(parambv.field_talker, parambv.fmA);
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.chatroom.storage.c)localObject1).fOh.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Long)((Iterator)localObject2).next();
        localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().aJ(parambv.field_talker, ((Long)localObject3).longValue());
        ((bv)localObject3).uu("");
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(((ei)localObject3).field_msgId, (bv)localObject3);
      }
      localObject2 = new nc();
      ((nc)localObject2).dCe.op = 1;
      ((nc)localObject2).dCe.dCf = parambv.fmA;
      ((nc)localObject2).dCe.dwx = parambv.field_talker;
      com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
      boolean bool = c((com.tencent.mm.chatroom.storage.c)localObject1);
      ae.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s result:%s", new Object[] { parambv.fmA, Boolean.valueOf(bool) });
      localObject1 = d((com.tencent.mm.chatroom.storage.c)localObject1);
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(parambv.field_talker, 1, (cxh)localObject1);
      parambv = new Pair(Boolean.TRUE, parambv.fmA);
      AppMethodBeat.o(182101);
      return parambv;
    }
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().aJ(parambv.field_talker, parambv.field_msgSvrId);
    ((bv)localObject1).uu("");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(((ei)localObject1).field_msgId, (bv)localObject1);
    localObject1 = new cxh();
    ((cxh)localObject1).HHN = parambv.fmA;
    Object localObject2 = k.b.zb(parambv.field_content);
    if (localObject2 == null)
    {
      ((cxh)localObject1).Username = "";
      ((cxh)localObject1).uuA = "";
    }
    for (((cxh)localObject1).Title = "";; ((cxh)localObject1).Title = ((k.b)localObject2).title)
    {
      ((cxh)localObject1).qlc = ((int)(parambv.field_createTime / 10000L));
      ((cxh)localObject1).HHM = com.tencent.mm.util.e.cA(parambv);
      ((cxh)localObject1).HHP = parambv.field_msgSvrId;
      ((cxh)localObject1).HHQ = "";
      ae.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s", new Object[] { parambv.fmA });
      break;
      ((cxh)localObject1).Username = ((k.b)localObject2).hFc;
      ((cxh)localObject1).uuA = ((k.b)localObject2).hFb;
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
  
  public static String f(bv parambv)
  {
    AppMethodBeat.i(217122);
    if (parambv == null)
    {
      AppMethodBeat.o(217122);
      return "";
    }
    if (parambv.fwp())
    {
      AppMethodBeat.o(217122);
      return "roomannouncement@app.origin";
    }
    parambv = k.b.zb(parambv.field_content);
    if (parambv == null)
    {
      ae.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo content is null");
      AppMethodBeat.o(217122);
      return "";
    }
    if ((com.tencent.mm.ah.a)parambv.ao(com.tencent.mm.ah.a.class) == null)
    {
      ae.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo appContentAppBrandPiece is null");
      AppMethodBeat.o(217122);
      return "";
    }
    parambv = parambv.hFc;
    AppMethodBeat.o(217122);
    return parambv;
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182107);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.roomTodo.RoomTodoHelp", "gotoRoomCard roomname is null");
      AppMethodBeat.o(182107);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, RoomCardUI.class);
    localIntent.putExtra("RoomInfo_Id", paramString);
    localIntent.putExtra("room_notice", r.zE(paramString));
    localIntent.putExtra("room_notice_publish_time", r.zH(paramString));
    localIntent.putExtra("room_notice_editor", r.zG(paramString));
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (paramString != null)
    {
      localIntent.putExtra("Is_RoomOwner", paramString.field_roomowner.equals(v.aAC()));
      localIntent.putExtra("Is_RoomManager", paramString.aUg(v.aAC()));
    }
    if (paramBoolean) {
      localIntent.setFlags(268435456);
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahE(), "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(182107);
  }
  
  public static Pair<Boolean, String> qY(long paramLong)
  {
    AppMethodBeat.i(182103);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramLong);
    if (bu.isNullOrNil(((ei)localObject).fmA))
    {
      localObject = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182103);
      return localObject;
    }
    com.tencent.mm.chatroom.storage.c localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(((ei)localObject).field_talker, ((ei)localObject).fmA);
    if (localc == null)
    {
      localObject = new Pair(Boolean.FALSE, ((ei)localObject).fmA);
      AppMethodBeat.o(182103);
      return localObject;
    }
    boolean bool;
    if (localc.ra(((ei)localObject).field_msgSvrId))
    {
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(localc);
      nc localnc = new nc();
      localnc.dCe.op = 1;
      localnc.dCe.dwx = localc.field_roomname;
      localnc.dCe.dCf = localc.field_todoid;
      if (bool) {
        com.tencent.mm.sdk.b.a.IvT.a(localnc, Looper.getMainLooper());
      }
      ae.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg delete result:%s", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      if (bool)
      {
        ((bv)localObject).uu("");
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(((ei)localObject).field_msgId, (bv)localObject);
      }
      localObject = new Pair(Boolean.TRUE, ((ei)localObject).fmA);
      AppMethodBeat.o(182103);
      return localObject;
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(localc);
      ae.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg updateGroupTodo result:%s", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static abstract interface a
  {
    public abstract void Yp();
    
    public abstract void Yq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.y
 * JD-Core Version:    0.7.0.1
 */