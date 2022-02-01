package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.RoomCardUI;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.util.d;
import java.util.Iterator;
import java.util.List;

public final class y
{
  private static Boolean fsI = null;
  
  public static boolean VM()
  {
    AppMethodBeat.i(182099);
    if ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(182099);
      return true;
    }
    boolean bool;
    if (fsI != null)
    {
      bool = fsI.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTu, 1);
    ac.i("MicroMsg.roomTodo.RoomTodoHelp", "getRoomTodoSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (fsI = Boolean.TRUE;; fsI = Boolean.FALSE)
    {
      bool = fsI.booleanValue();
      AppMethodBeat.o(182099);
      return bool;
    }
  }
  
  public static Pair<Boolean, String> a(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(182102);
    com.tencent.mm.chatroom.storage.a locala = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().af(parama.field_roomname, parama.field_todoid);
    if (locala == null)
    {
      ac.e("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu stoTodo no exist");
      parama = new Pair(Boolean.FALSE, parama.field_todoid);
      AppMethodBeat.o(182102);
      return parama;
    }
    Iterator localIterator = locala.ftm.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      localObject = ((k)g.ab(k.class)).dcr().aF(parama.field_roomname, ((Long)localObject).longValue());
      ((bo)localObject).rn("");
      ((k)g.ab(k.class)).dcr().a(((dy)localObject).field_msgId, (bo)localObject);
    }
    ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
    c.a.a(parama.field_roomname, 1, d(locala));
    boolean bool = c(locala);
    ac.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu todoId:%s result:%s", new Object[] { parama.field_todoid, Boolean.valueOf(bool) });
    parama = new Pair(Boolean.valueOf(bool), parama.field_todoid);
    AppMethodBeat.o(182102);
    return parama;
  }
  
  public static Pair<Boolean, String> a(bo parambo, k.b paramb)
  {
    AppMethodBeat.i(184782);
    if (parambo == null)
    {
      ac.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      parambo = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return parambo;
    }
    if (paramb == null)
    {
      ac.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      parambo = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(184782);
      return parambo;
    }
    long l = parambo.field_createTime;
    Object localObject = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
    com.tencent.mm.chatroom.storage.a locala;
    if (bs.isNullOrNil(((com.tencent.mm.ah.a)localObject).hga))
    {
      localObject = "related_msgid_" + parambo.field_msgSvrId;
      locala = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().af(parambo.field_talker, (String)localObject);
      if (locala != null)
      {
        ac.e("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl %s(%s) exist", new Object[] { localObject, Integer.valueOf(locala.field_state) });
        if (locala.field_state != 2) {
          break label571;
        }
        ac.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl delete %s", new Object[] { Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(locala)) });
      }
      locala = new com.tencent.mm.chatroom.storage.a();
      locala.field_todoid = ((String)localObject);
      locala.field_roomname = parambo.field_talker;
      locala.field_username = paramb.hke;
      locala.field_path = paramb.hkd;
      locala.field_createtime = l;
      locala.field_updatetime = l;
      locala.field_custominfo = "";
      localObject = paramb.title;
      if (!bs.isNullOrNil((String)localObject)) {
        break label594;
      }
      paramb = ((m)g.ab(m.class)).Ka(paramb.hke);
      if ((paramb == null) || (bs.isNullOrNil(paramb.field_nickname))) {
        break label594;
      }
    }
    label571:
    label594:
    for (paramb = paramb.field_nickname;; paramb = (k.b)localObject)
    {
      locala.field_title = paramb;
      locala.field_creator = d.cv(parambo);
      locala.field_manager = u.axw();
      locala.field_nreply = 0;
      locala.field_related_msgids = parambo.field_msgSvrId;
      boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().f(locala);
      ac.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoBySendSuccess todoId:%s result:%s", new Object[] { locala.field_todoid, Boolean.valueOf(bool) });
      if (bool)
      {
        paramb = ((k)g.ab(k.class)).dcr().aF(parambo.field_talker, parambo.field_msgSvrId);
        paramb.rn(locala.field_todoid);
        ((k)g.ab(k.class)).dcr().a(paramb.field_msgId, paramb);
        paramb = new mt();
        paramb.dpm.op = 0;
        paramb.dpm.dpn = locala.field_todoid;
        paramb.dpm.djF = parambo.field_talker;
        com.tencent.mm.sdk.b.a.GpY.a(paramb, Looper.getMainLooper());
      }
      parambo = new Pair(Boolean.valueOf(bool), locala.field_todoid);
      AppMethodBeat.o(184782);
      return parambo;
      localObject = ((com.tencent.mm.ah.a)localObject).hga;
      break;
      parambo = new Pair(Boolean.TRUE, locala.field_todoid);
      AppMethodBeat.o(184782);
      return parambo;
    }
  }
  
  public static String a(crg paramcrg)
  {
    AppMethodBeat.i(182105);
    if (paramcrg == null)
    {
      AppMethodBeat.o(182105);
      return "";
    }
    paramcrg = "RoomToolsTodo{TodoId='" + paramcrg.FDY + '\'' + ", Username='" + paramcrg.Username + '\'' + ", Path='" + paramcrg.tlT + '\'' + ", Time=" + paramcrg.pAS + ", CustomInfo=" + paramcrg.FDZ + ", Title='" + bs.aLJ(paramcrg.Title) + '\'' + ", Creator='" + paramcrg.FDX + '\'' + ", RelatedMsgId=" + paramcrg.FEa + ", Manager='" + paramcrg.FEb + '\'' + '}';
    AppMethodBeat.o(182105);
    return paramcrg;
  }
  
  public static void a(Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, a parama)
  {
    AppMethodBeat.i(197036);
    e locale = new e(paramContext, 1, true);
    if (paramBoolean) {
      locale.m(paramContext.getString(2131757056), 17, com.tencent.mm.cc.a.fromDPToPix(paramContext, 14));
    }
    for (;;)
    {
      locale.JfK = true;
      locale.ISu = new y.1(paramBoolean, paramContext);
      locale.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          paramAnonymousInt = 1;
          AppMethodBeat.i(182098);
          if ((paramAnonymousMenuItem.getItemId() == 0) && (this.fsK != null))
          {
            int i;
            if (paramBoolean)
            {
              this.fsK.VO();
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
              this.fsK.VP();
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
      locale.Ihj = new e.b()
      {
        public final void onDismiss()
        {
          int i = 2;
          AppMethodBeat.i(184781);
          if (this.fsL == 2)
          {
            String str = paramString1;
            int j = paramInt2;
            if (paramBoolean) {
              i = 1;
            }
            z.a(str, 1, j, i, paramInt3, paramString2, paramString3);
          }
          if (this.fsL == 1) {
            z.a(paramString1, paramInt2, 3, 1, paramString2, paramString3);
          }
          AppMethodBeat.o(184781);
        }
      };
      locale.cED();
      AppMethodBeat.o(197036);
      return;
      locale.m(paramContext.getString(2131757055), 17, com.tencent.mm.cc.a.fromDPToPix(paramContext, 14));
    }
  }
  
  public static boolean b(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(182104);
    parama.field_state = 1;
    parama.field_updatetime = ce.azI();
    boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(parama);
    AppMethodBeat.o(182104);
    return bool;
  }
  
  public static Pair<Boolean, String> c(bo parambo)
  {
    AppMethodBeat.i(182100);
    if (parambo == null)
    {
      ac.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      parambo = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return parambo;
    }
    if (parambo.fch())
    {
      localObject1 = new crg();
      ((crg)localObject1).FDY = ("related_msgid_" + parambo.field_msgSvrId);
      ((crg)localObject1).Username = "roomannouncement@app.origin";
      ((crg)localObject1).tlT = "";
      ((crg)localObject1).pAS = ce.azK();
      ((crg)localObject1).Title = ai.getContext().getString(2131757057);
      ((crg)localObject1).FDX = d.cv(parambo);
      ((crg)localObject1).FEa = parambo.field_msgSvrId;
      ((crg)localObject1).FEb = u.axw();
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(parambo.field_talker, 0, (crg)localObject1);
      parambo = new Pair(Boolean.TRUE, ((crg)localObject1).FDY);
      AppMethodBeat.o(182100);
      return parambo;
    }
    Object localObject2 = k.b.vA(parambo.field_content);
    if (localObject2 == null)
    {
      ac.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      parambo = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182100);
      return parambo;
    }
    crg localcrg = new crg();
    Object localObject1 = (com.tencent.mm.ah.a)((k.b)localObject2).ao(com.tencent.mm.ah.a.class);
    if ((localObject1 == null) || (bs.isNullOrNil(((com.tencent.mm.ah.a)localObject1).hga)))
    {
      localcrg.FDY = ("related_msgid_" + parambo.field_msgSvrId);
      localcrg.Username = ((k.b)localObject2).hke;
      localcrg.tlT = ((k.b)localObject2).hkd;
      localcrg.pAS = ce.azK();
      localObject1 = ((k.b)localObject2).title;
      if (!bs.isNullOrNil((String)localObject1)) {
        break label427;
      }
      localObject2 = ((m)g.ab(m.class)).Ka(((k.b)localObject2).hke);
      if ((localObject2 == null) || (bs.isNullOrNil(((WxaAttributes)localObject2).field_nickname))) {
        break label427;
      }
      localObject1 = ((WxaAttributes)localObject2).field_nickname;
    }
    label427:
    for (;;)
    {
      localcrg.Title = ((String)localObject1);
      localcrg.FDX = d.cv(parambo);
      localcrg.FEa = parambo.field_msgSvrId;
      localcrg.FEb = u.axw();
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(parambo.field_talker, 0, localcrg);
      parambo = new Pair(Boolean.TRUE, localcrg.FDY);
      AppMethodBeat.o(182100);
      return parambo;
      localcrg.FDY = ((com.tencent.mm.ah.a)localObject1).hga;
      break;
    }
  }
  
  public static boolean c(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(197035);
    parama.field_state = 2;
    parama.field_updatetime = ce.azI();
    boolean bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(parama);
    AppMethodBeat.o(197035);
    return bool;
  }
  
  public static crg d(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(182106);
    crg localcrg = new crg();
    localcrg.FDY = parama.field_todoid;
    localcrg.Username = parama.field_username;
    localcrg.tlT = parama.field_path;
    localcrg.pAS = ((int)(parama.field_createtime / 1000L));
    localcrg.Title = parama.field_title;
    localcrg.FDX = parama.field_creator;
    localcrg.FEa = parama.VT();
    localcrg.FEb = parama.field_manager;
    AppMethodBeat.o(182106);
    return localcrg;
  }
  
  public static String d(bo parambo)
  {
    AppMethodBeat.i(197034);
    if (parambo == null)
    {
      ac.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
      AppMethodBeat.o(197034);
      return "";
    }
    if (parambo.fch())
    {
      parambo = "related_msgid_" + parambo.field_msgSvrId;
      AppMethodBeat.o(197034);
      return parambo;
    }
    Object localObject = k.b.vA(parambo.field_content);
    if (localObject == null)
    {
      ac.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
      AppMethodBeat.o(197034);
      return "";
    }
    localObject = (com.tencent.mm.ah.a)((k.b)localObject).ao(com.tencent.mm.ah.a.class);
    if ((localObject == null) || (bs.isNullOrNil(((com.tencent.mm.ah.a)localObject).hga)))
    {
      parambo = "related_msgid_" + parambo.field_msgSvrId;
      AppMethodBeat.o(197034);
      return parambo;
    }
    parambo = ((com.tencent.mm.ah.a)localObject).hga;
    AppMethodBeat.o(197034);
    return parambo;
  }
  
  public static Pair<Boolean, String> e(bo parambo)
  {
    AppMethodBeat.i(182101);
    Object localObject1 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().af(parambo.field_talker, parambo.eSo);
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.chatroom.storage.a)localObject1).ftm.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Long)((Iterator)localObject2).next();
        localObject3 = ((k)g.ab(k.class)).dcr().aF(parambo.field_talker, ((Long)localObject3).longValue());
        ((bo)localObject3).rn("");
        ((k)g.ab(k.class)).dcr().a(((dy)localObject3).field_msgId, (bo)localObject3);
      }
      localObject2 = new mt();
      ((mt)localObject2).dpm.op = 1;
      ((mt)localObject2).dpm.dpn = parambo.eSo;
      ((mt)localObject2).dpm.djF = parambo.field_talker;
      com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
      boolean bool = c((com.tencent.mm.chatroom.storage.a)localObject1);
      ac.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s result:%s", new Object[] { parambo.eSo, Boolean.valueOf(bool) });
      localObject1 = d((com.tencent.mm.chatroom.storage.a)localObject1);
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
      c.a.a(parambo.field_talker, 1, (crg)localObject1);
      parambo = new Pair(Boolean.TRUE, parambo.eSo);
      AppMethodBeat.o(182101);
      return parambo;
    }
    localObject1 = ((k)g.ab(k.class)).dcr().aF(parambo.field_talker, parambo.field_msgSvrId);
    ((bo)localObject1).rn("");
    ((k)g.ab(k.class)).dcr().a(((dy)localObject1).field_msgId, (bo)localObject1);
    localObject1 = new crg();
    ((crg)localObject1).FDY = parambo.eSo;
    Object localObject2 = k.b.vA(parambo.field_content);
    if (localObject2 == null)
    {
      ((crg)localObject1).Username = "";
      ((crg)localObject1).tlT = "";
    }
    for (((crg)localObject1).Title = "";; ((crg)localObject1).Title = ((k.b)localObject2).title)
    {
      ((crg)localObject1).pAS = ((int)(parambo.field_createTime / 10000L));
      ((crg)localObject1).FDX = d.cv(parambo);
      ((crg)localObject1).FEa = parambo.field_msgSvrId;
      ((crg)localObject1).FEb = "";
      ac.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s", new Object[] { parambo.eSo });
      break;
      ((crg)localObject1).Username = ((k.b)localObject2).hke;
      ((crg)localObject1).tlT = ((k.b)localObject2).hkd;
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
  
  public static String f(bo parambo)
  {
    AppMethodBeat.i(197037);
    if (parambo == null)
    {
      AppMethodBeat.o(197037);
      return "";
    }
    if (parambo.fch())
    {
      AppMethodBeat.o(197037);
      return "roomannouncement@app.origin";
    }
    parambo = k.b.vA(parambo.field_content);
    if (parambo == null)
    {
      ac.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo content is null");
      AppMethodBeat.o(197037);
      return "";
    }
    if ((com.tencent.mm.ah.a)parambo.ao(com.tencent.mm.ah.a.class) == null)
    {
      ac.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo appContentAppBrandPiece is null");
      AppMethodBeat.o(197037);
      return "";
    }
    parambo = parambo.hke;
    AppMethodBeat.o(197037);
    return parambo;
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182107);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.roomTodo.RoomTodoHelp", "gotoRoomCard roomname is null");
      AppMethodBeat.o(182107);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, RoomCardUI.class);
    localIntent.putExtra("RoomInfo_Id", paramString);
    localIntent.putExtra("room_notice", q.wd(paramString));
    localIntent.putExtra("room_notice_publish_time", q.wf(paramString));
    localIntent.putExtra("room_notice_editor", q.we(paramString));
    paramString = ((c)g.ab(c.class)).awK().xN(paramString);
    if (paramString != null)
    {
      localIntent.putExtra("Is_RoomOwner", paramString.field_roomowner.equals(u.axw()));
      localIntent.putExtra("Is_RoomManager", paramString.aMU(u.axw()));
    }
    if (paramBoolean) {
      localIntent.setFlags(268435456);
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(182107);
  }
  
  public static Pair<Boolean, String> oL(long paramLong)
  {
    AppMethodBeat.i(182103);
    Object localObject = ((k)g.ab(k.class)).dcr().vP(paramLong);
    if (bs.isNullOrNil(((dy)localObject).eSo))
    {
      localObject = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(182103);
      return localObject;
    }
    com.tencent.mm.chatroom.storage.a locala = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().af(((dy)localObject).field_talker, ((dy)localObject).eSo);
    if (locala == null)
    {
      localObject = new Pair(Boolean.FALSE, ((dy)localObject).eSo);
      AppMethodBeat.o(182103);
      return localObject;
    }
    boolean bool;
    if (locala.oN(((dy)localObject).field_msgSvrId))
    {
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(locala);
      mt localmt = new mt();
      localmt.dpm.op = 1;
      localmt.dpm.djF = locala.field_roomname;
      localmt.dpm.dpn = locala.field_todoid;
      if (bool) {
        com.tencent.mm.sdk.b.a.GpY.a(localmt, Looper.getMainLooper());
      }
      ac.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg delete result:%s", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      if (bool)
      {
        ((bo)localObject).rn("");
        ((k)g.ab(k.class)).dcr().a(((dy)localObject).field_msgId, (bo)localObject);
      }
      localObject = new Pair(Boolean.TRUE, ((dy)localObject).eSo);
      AppMethodBeat.o(182103);
      return localObject;
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().g(locala);
      ac.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg updateGroupTodo result:%s", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static abstract interface a
  {
    public abstract void VO();
    
    public abstract void VP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.y
 * JD-Core Version:    0.7.0.1
 */