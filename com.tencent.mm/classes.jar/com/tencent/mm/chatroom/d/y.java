package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.RoomCardUI;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.util.d;
import java.util.Iterator;
import java.util.List;

public final class y
{
  private static Boolean fpi = null;
  
  public static boolean UQ()
  {
    AppMethodBeat.i(182099);
    if ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182099);
      return true;
    }
    boolean bool;
    if (fpi != null)
    {
      bool = fpi.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.ppJ, 1);
    ad.i("MicroMsg.roomTodo.RoomTodoHelp", "getRoomTodoSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (fpi = Boolean.TRUE;; fpi = Boolean.FALSE)
    {
      bool = fpi.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
  }
  
  public static Pair<Boolean, String> a(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(182102);
    com.tencent.mm.chatroom.storage.a locala = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ac(parama.field_roomname, parama.field_todoid);
    if (locala == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu stoTodo no exist");
      parama = new Pair(Boolean.FALSE, parama.field_todoid);
      AppMethodBeat.o(182102);
      return parama;
    }
    Iterator localIterator = locala.fpJ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      localObject = ((k)g.ab(k.class)).cOI().aD(parama.field_roomname, ((Long)localObject).longValue());
      ((bl)localObject).oh("");
      ((k)g.ab(k.class)).cOI().a(((du)localObject).field_msgId, (bl)localObject);
    }
    ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
    com.tencent.mm.chatroom.c.b.a.a(parama.field_roomname, 1, d(locala));
    boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(locala);
    ad.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu todoId:%s result:%s", new Object[] { parama.field_todoid, Boolean.valueOf(bool) });
    parama = new Pair(Boolean.valueOf(bool), parama.field_todoid);
    AppMethodBeat.o(182102);
    return parama;
  }
  
  public static Pair<Boolean, String> a(bl parambl, k.b paramb)
  {
    AppMethodBeat.i(184782);
    if (parambl == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      parambl = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return parambl;
    }
    if (paramb == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      parambl = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return parambl;
    }
    long l = parambl.field_createTime;
    Object localObject = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
    com.tencent.mm.chatroom.storage.a locala;
    if (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject).gFz))
    {
      localObject = "related_msgid_" + parambl.field_msgSvrId;
      locala = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ac(parambl.field_talker, (String)localObject);
      if (locala != null)
      {
        ad.e("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl %s(%s) exist", new Object[] { localObject, Integer.valueOf(locala.field_state) });
        if (locala.field_state != 2) {
          break label571;
        }
        ad.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl delete %s", new Object[] { Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(locala)) });
      }
      locala = new com.tencent.mm.chatroom.storage.a();
      locala.field_todoid = ((String)localObject);
      locala.field_roomname = parambl.field_talker;
      locala.field_username = paramb.gJE;
      locala.field_path = paramb.gJD;
      locala.field_createtime = l;
      locala.field_updatetime = l;
      locala.field_custominfo = "";
      localObject = paramb.title;
      if (!bt.isNullOrNil((String)localObject)) {
        break label594;
      }
      paramb = ((m)g.ab(m.class)).FW(paramb.gJE);
      if ((paramb == null) || (bt.isNullOrNil(paramb.field_nickname))) {
        break label594;
      }
    }
    label571:
    label594:
    for (paramb = paramb.field_nickname;; paramb = (k.b)localObject)
    {
      locala.field_title = paramb;
      locala.field_creator = d.cs(parambl);
      locala.field_manager = u.aqG();
      locala.field_nreply = 0;
      locala.field_related_msgids = parambl.field_msgSvrId;
      boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().f(locala);
      ad.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoBySendSuccess todoId:%s result:%s", new Object[] { locala.field_todoid, Boolean.valueOf(bool) });
      if (bool)
      {
        paramb = ((k)g.ab(k.class)).cOI().aD(parambl.field_talker, parambl.field_msgSvrId);
        paramb.oh(locala.field_todoid);
        ((k)g.ab(k.class)).cOI().a(paramb.field_msgId, paramb);
        paramb = new mk();
        paramb.drB.op = 0;
        paramb.drB.drC = locala.field_todoid;
        paramb.drB.dlX = parambl.field_talker;
        com.tencent.mm.sdk.b.a.ESL.a(paramb, Looper.getMainLooper());
      }
      parambl = new Pair(Boolean.valueOf(bool), locala.field_todoid);
      AppMethodBeat.o(184782);
      return parambl;
      localObject = ((com.tencent.mm.ai.a)localObject).gFz;
      break;
      parambl = new Pair(Boolean.TRUE, locala.field_todoid);
      AppMethodBeat.o(184782);
      return parambl;
    }
  }
  
  public static String a(clz paramclz)
  {
    AppMethodBeat.i(182105);
    if (paramclz == null)
    {
      AppMethodBeat.o(182105);
      return "";
    }
    paramclz = "RoomToolsTodo{TodoId='" + paramclz.EgZ + '\'' + ", Username='" + paramclz.Username + '\'' + ", Path='" + paramclz.sdZ + '\'' + ", Time=" + paramclz.oXH + ", CustomInfo=" + paramclz.Eha + ", Title='" + bt.aGs(paramclz.Title) + '\'' + ", Creator='" + paramclz.EgY + '\'' + ", RelatedMsgId=" + paramclz.Ehb + ", Manager='" + paramclz.Ehc + '\'' + '}';
    AppMethodBeat.o(182105);
    return paramclz;
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, a parama)
  {
    AppMethodBeat.i(196570);
    e locale = new e(paramContext, 1, true);
    if (paramBoolean) {
      locale.l(paramContext.getString(2131757056), 17, com.tencent.mm.cd.a.fromDPToPix(paramContext, 14));
    }
    for (;;)
    {
      locale.HFn = true;
      locale.HrX = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(182097);
          if (this.fpj)
          {
            paramAnonymousl.c(0, paramContext.getString(2131757054));
            AppMethodBeat.o(182097);
            return;
          }
          paramAnonymousl.a(0, paramContext.getResources().getColor(2131099803), paramContext.getString(2131757053));
          AppMethodBeat.o(182097);
        }
      };
      locale.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          paramAnonymousInt = 1;
          AppMethodBeat.i(182098);
          if ((paramAnonymousMenuItem.getItemId() == 0) && (this.fpk != null))
          {
            int i;
            if (paramBoolean)
            {
              this.fpk.US();
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
              this.fpk.UT();
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
      locale.GHn = new e.b()
      {
        public final void onDismiss()
        {
          int i = 2;
          AppMethodBeat.i(184781);
          if (this.fpl == 2)
          {
            String str = paramString1;
            int j = paramInt2;
            if (paramBoolean) {
              i = 1;
            }
            z.a(str, 1, j, i, paramInt3, paramString2, paramString3);
          }
          if (this.fpl == 1) {
            z.a(paramString1, paramInt2, 3, 1, paramString2, paramString3);
          }
          AppMethodBeat.o(184781);
        }
      };
      locale.csG();
      AppMethodBeat.o(196570);
      return;
      locale.l(paramContext.getString(2131757055), 17, com.tencent.mm.cd.a.fromDPToPix(paramContext, 14));
    }
  }
  
  public static boolean b(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(182104);
    parama.field_state = 1;
    parama.field_updatetime = ce.asR();
    boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(parama);
    AppMethodBeat.o(182104);
    return bool;
  }
  
  public static Pair<Boolean, String> c(bl parambl)
  {
    AppMethodBeat.i(182100);
    if (parambl == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      parambl = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return parambl;
    }
    if (parambl.eMC())
    {
      localObject1 = new clz();
      ((clz)localObject1).EgZ = ("related_msgid_" + parambl.field_msgSvrId);
      ((clz)localObject1).Username = "roomannouncement@app.origin";
      ((clz)localObject1).sdZ = "";
      ((clz)localObject1).oXH = ce.asT();
      ((clz)localObject1).Title = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131757057);
      ((clz)localObject1).EgY = d.cs(parambl);
      ((clz)localObject1).Ehb = parambl.field_msgSvrId;
      ((clz)localObject1).Ehc = u.aqG();
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      com.tencent.mm.chatroom.c.b.a.a(parambl.field_talker, 0, (clz)localObject1);
      parambl = new Pair(Boolean.TRUE, ((clz)localObject1).EgZ);
      AppMethodBeat.o(182100);
      return parambl;
    }
    Object localObject2 = k.b.rx(parambl.field_content);
    if (localObject2 == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      parambl = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return parambl;
    }
    clz localclz = new clz();
    Object localObject1 = (com.tencent.mm.ai.a)((k.b)localObject2).ao(com.tencent.mm.ai.a.class);
    if ((localObject1 == null) || (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject1).gFz)))
    {
      localclz.EgZ = ("related_msgid_" + parambl.field_msgSvrId);
      localclz.Username = ((k.b)localObject2).gJE;
      localclz.sdZ = ((k.b)localObject2).gJD;
      localclz.oXH = ce.asT();
      localObject1 = ((k.b)localObject2).title;
      if (!bt.isNullOrNil((String)localObject1)) {
        break label427;
      }
      localObject2 = ((m)g.ab(m.class)).FW(((k.b)localObject2).gJE);
      if ((localObject2 == null) || (bt.isNullOrNil(((WxaAttributes)localObject2).field_nickname))) {
        break label427;
      }
      localObject1 = ((WxaAttributes)localObject2).field_nickname;
    }
    label427:
    for (;;)
    {
      localclz.Title = ((String)localObject1);
      localclz.EgY = d.cs(parambl);
      localclz.Ehb = parambl.field_msgSvrId;
      localclz.Ehc = u.aqG();
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      com.tencent.mm.chatroom.c.b.a.a(parambl.field_talker, 0, localclz);
      parambl = new Pair(Boolean.TRUE, localclz.EgZ);
      AppMethodBeat.o(182100);
      return parambl;
      localclz.EgZ = ((com.tencent.mm.ai.a)localObject1).gFz;
      break;
    }
  }
  
  public static boolean c(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(196569);
    parama.field_state = 2;
    parama.field_updatetime = ce.asR();
    boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(parama);
    AppMethodBeat.o(196569);
    return bool;
  }
  
  public static clz d(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(182106);
    clz localclz = new clz();
    localclz.EgZ = parama.field_todoid;
    localclz.Username = parama.field_username;
    localclz.sdZ = parama.field_path;
    localclz.oXH = ((int)(parama.field_createtime / 1000L));
    localclz.Title = parama.field_title;
    localclz.EgY = parama.field_creator;
    localclz.Ehb = parama.UX();
    localclz.Ehc = parama.field_manager;
    AppMethodBeat.o(182106);
    return localclz;
  }
  
  public static String d(bl parambl)
  {
    AppMethodBeat.i(196568);
    if (parambl == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      AppMethodBeat.o(196568);
      return "";
    }
    if (parambl.eMC())
    {
      parambl = "related_msgid_" + parambl.field_msgSvrId;
      AppMethodBeat.o(196568);
      return parambl;
    }
    Object localObject = k.b.rx(parambl.field_content);
    if (localObject == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      AppMethodBeat.o(196568);
      return "";
    }
    localObject = (com.tencent.mm.ai.a)((k.b)localObject).ao(com.tencent.mm.ai.a.class);
    if ((localObject == null) || (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject).gFz)))
    {
      parambl = "related_msgid_" + parambl.field_msgSvrId;
      AppMethodBeat.o(196568);
      return parambl;
    }
    parambl = ((com.tencent.mm.ai.a)localObject).gFz;
    AppMethodBeat.o(196568);
    return parambl;
  }
  
  public static Pair<Boolean, String> e(bl parambl)
  {
    AppMethodBeat.i(182101);
    Object localObject1 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ac(parambl.field_talker, parambl.ePg);
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.chatroom.storage.a)localObject1).fpJ.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Long)((Iterator)localObject2).next();
        localObject3 = ((k)g.ab(k.class)).cOI().aD(parambl.field_talker, ((Long)localObject3).longValue());
        ((bl)localObject3).oh("");
        ((k)g.ab(k.class)).cOI().a(((du)localObject3).field_msgId, (bl)localObject3);
      }
      localObject2 = new mk();
      ((mk)localObject2).drB.op = 1;
      ((mk)localObject2).drB.drC = parambl.ePg;
      ((mk)localObject2).drB.dlX = parambl.field_talker;
      com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
      boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h((com.tencent.mm.chatroom.storage.a)localObject1);
      ad.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s result:%s", new Object[] { parambl.ePg, Boolean.valueOf(bool) });
      localObject1 = d((com.tencent.mm.chatroom.storage.a)localObject1);
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      com.tencent.mm.chatroom.c.b.a.a(parambl.field_talker, 1, (clz)localObject1);
      parambl = new Pair(Boolean.TRUE, parambl.ePg);
      AppMethodBeat.o(182101);
      return parambl;
    }
    localObject1 = ((k)g.ab(k.class)).cOI().aD(parambl.field_talker, parambl.field_msgSvrId);
    ((bl)localObject1).oh("");
    ((k)g.ab(k.class)).cOI().a(((du)localObject1).field_msgId, (bl)localObject1);
    localObject1 = new clz();
    ((clz)localObject1).EgZ = parambl.ePg;
    Object localObject2 = k.b.rx(parambl.field_content);
    if (localObject2 == null)
    {
      ((clz)localObject1).Username = "";
      ((clz)localObject1).sdZ = "";
    }
    for (((clz)localObject1).Title = "";; ((clz)localObject1).Title = ((k.b)localObject2).title)
    {
      ((clz)localObject1).oXH = ((int)(parambl.field_createTime / 10000L));
      ((clz)localObject1).EgY = d.cs(parambl);
      ((clz)localObject1).Ehb = parambl.field_msgSvrId;
      ((clz)localObject1).Ehc = "";
      ad.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s", new Object[] { parambl.ePg });
      break;
      ((clz)localObject1).Username = ((k.b)localObject2).gJE;
      ((clz)localObject1).sdZ = ((k.b)localObject2).gJD;
    }
  }
  
  public static boolean e(com.tencent.mm.chatroom.storage.a parama)
  {
    if (parama == null) {}
    while (parama.field_state == 2) {
      return false;
    }
    return true;
  }
  
  public static String f(bl parambl)
  {
    AppMethodBeat.i(196571);
    if (parambl == null)
    {
      AppMethodBeat.o(196571);
      return "";
    }
    if (parambl.eMC())
    {
      AppMethodBeat.o(196571);
      return "roomannouncement@app.origin";
    }
    parambl = k.b.rx(parambl.field_content);
    if (parambl == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo content is null");
      AppMethodBeat.o(196571);
      return "";
    }
    if ((com.tencent.mm.ai.a)parambl.ao(com.tencent.mm.ai.a.class) == null)
    {
      ad.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo appContentAppBrandPiece is null");
      AppMethodBeat.o(196571);
      return "";
    }
    parambl = parambl.gJE;
    AppMethodBeat.o(196571);
    return parambl;
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
    localIntent.putExtra("room_notice", q.sa(paramString));
    localIntent.putExtra("room_notice_publish_time", q.sc(paramString));
    localIntent.putExtra("room_notice_editor", q.sb(paramString));
    paramString = ((c)g.ab(c.class)).apV().tH(paramString);
    if (paramString != null)
    {
      localIntent.putExtra("Is_RoomOwner", paramString.field_roomowner.equals(u.aqG()));
      localIntent.putExtra("Is_RoomManager", paramString.aHz(u.aqG()));
    }
    if (paramBoolean) {
      localIntent.setFlags(268435456);
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.adn(), "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(182107);
  }
  
  public static Pair<Boolean, String> lj(long paramLong)
  {
    AppMethodBeat.i(182103);
    Object localObject = ((k)g.ab(k.class)).cOI().rm(paramLong);
    if (bt.isNullOrNil(((du)localObject).ePg))
    {
      localObject = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182103);
      return localObject;
    }
    com.tencent.mm.chatroom.storage.a locala = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ac(((du)localObject).field_talker, ((du)localObject).ePg);
    if (locala == null)
    {
      localObject = new Pair(Boolean.FALSE, ((du)localObject).ePg);
      AppMethodBeat.o(182103);
      return localObject;
    }
    boolean bool;
    if (locala.lk(((du)localObject).field_msgSvrId))
    {
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(locala);
      mk localmk = new mk();
      localmk.drB.op = 1;
      localmk.drB.dlX = locala.field_roomname;
      localmk.drB.drC = locala.field_todoid;
      if (bool) {
        com.tencent.mm.sdk.b.a.ESL.a(localmk, Looper.getMainLooper());
      }
      ad.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg delete result:%s", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      if (bool)
      {
        ((bl)localObject).oh("");
        ((k)g.ab(k.class)).cOI().a(((du)localObject).field_msgId, (bl)localObject);
      }
      localObject = new Pair(Boolean.TRUE, ((du)localObject).ePg);
      AppMethodBeat.o(182103);
      return localObject;
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(locala);
      ad.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg updateGroupTodo result:%s", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static abstract interface a
  {
    public abstract void US();
    
    public abstract void UT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.y
 * JD-Core Version:    0.7.0.1
 */