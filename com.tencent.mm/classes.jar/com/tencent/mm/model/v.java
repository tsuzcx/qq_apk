package com.tencent.mm.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.bd.a;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.b.a.eu;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.plugin.newtips.a.d;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class v
{
  public static cjp iCu;
  public static com.tencent.mm.b.f<String, String> iCv;
  
  static
  {
    AppMethodBeat.i(101775);
    iCu = new cjp();
    iCv = new com.tencent.mm.b.h(100);
    AppMethodBeat.o(101775);
  }
  
  public static boolean C(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(194522);
    String str = (String)g.aAh().azQ().get(2, null);
    paramString = Ic(paramString);
    if (paramString == null)
    {
      Log.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
      if (paramBoolean)
      {
        Log.w("MicroMsg.ChatroomMembersLogic", "isInChatRoom temp change");
        AppMethodBeat.o(194522);
        return true;
      }
      AppMethodBeat.o(194522);
      return false;
    }
    if ((paramString.size() == 0) || (!paramString.contains(str)))
    {
      Log.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + paramString.size() + " ");
      AppMethodBeat.o(194522);
      return false;
    }
    AppMethodBeat.o(194522);
    return true;
  }
  
  private static boolean HS(String paramString)
  {
    AppMethodBeat.i(101741);
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      AppMethodBeat.o(101741);
      return true;
    }
    if (paramString.toLowerCase().endsWith("@im.chatroom"))
    {
      AppMethodBeat.o(101741);
      return true;
    }
    AppMethodBeat.o(101741);
    return false;
  }
  
  public static boolean HT(String paramString)
  {
    AppMethodBeat.i(101742);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101742);
      return false;
    }
    boolean bool = paramString.gBx();
    AppMethodBeat.o(101742);
    return bool;
  }
  
  public static boolean HU(String paramString)
  {
    AppMethodBeat.i(101744);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kf(paramString);
    String str = z.aTY();
    if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(str)) && (paramString.equals(str)))
    {
      AppMethodBeat.o(101744);
      return true;
    }
    AppMethodBeat.o(101744);
    return false;
  }
  
  public static String HV(String paramString)
  {
    AppMethodBeat.i(101746);
    if ((paramString == null) || (!HS(paramString)))
    {
      AppMethodBeat.o(101746);
      return "";
    }
    List localList = Ic(paramString);
    paramString = "";
    int i = 0;
    String str;
    as localas;
    if ((localList != null) && (i < localList.size()))
    {
      str = (String)localList.get(i);
      if (str.length() <= 0) {
        break label191;
      }
      localas = ((l)g.af(l.class)).aSN().Kn(str);
      if (localas == null)
      {
        str = paramString + str;
        label111:
        paramString = str;
        if (i < localList.size() - 1) {
          paramString = str + MMApplicationContext.getContext().getString(2131757307);
        }
      }
    }
    label191:
    for (;;)
    {
      i += 1;
      break;
      str = paramString + localas.arI();
      break label111;
      AppMethodBeat.o(101746);
      return paramString;
    }
  }
  
  public static boolean HW(String paramString)
  {
    AppMethodBeat.i(101749);
    boolean bool = C(paramString, false);
    AppMethodBeat.o(101749);
    return bool;
  }
  
  public static boolean HX(String paramString)
  {
    AppMethodBeat.i(101750);
    if (!ab.Iw(paramString))
    {
      AppMethodBeat.o(101750);
      return false;
    }
    if (!((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ki(paramString))
    {
      Log.d("MicroMsg.ChatroomMembersLogic", "state is die");
      AppMethodBeat.o(101750);
      return true;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(101750);
      return true;
    }
    AppMethodBeat.o(101750);
    return false;
  }
  
  public static boolean HY(String paramString)
  {
    AppMethodBeat.i(101751);
    if (!ab.Iw(paramString))
    {
      AppMethodBeat.o(101751);
      return false;
    }
    Log.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[] { paramString });
    ap localap = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
    paramString = localap.Kd(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101751);
      return false;
    }
    paramString.field_roomflag = 1;
    boolean bool = localap.replace(paramString);
    AppMethodBeat.o(101751);
    return bool;
  }
  
  public static boolean HZ(String paramString)
  {
    AppMethodBeat.i(101759);
    if (!paramString.toLowerCase().endsWith("@groupcard"))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + paramString + "]");
      AppMethodBeat.o(101759);
      return false;
    }
    bv localbv = ((l)g.af(l.class)).aSN();
    if (localbv.bjN(paramString)) {
      localbv.aNa(paramString);
    }
    for (;;)
    {
      boolean bool = Ib(paramString);
      AppMethodBeat.o(101759);
      return bool;
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + paramString + "]");
    }
  }
  
  public static boolean Ia(String paramString)
  {
    AppMethodBeat.i(101760);
    if (!HS(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + paramString + "]");
      AppMethodBeat.o(101760);
      return false;
    }
    bv localbv = ((l)g.af(l.class)).aSN();
    if (localbv.bjN(paramString)) {
      localbv.aNa(paramString);
    }
    for (;;)
    {
      boolean bool = Ib(paramString);
      AppMethodBeat.o(101760);
      return bool;
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + paramString + "]");
    }
  }
  
  private static boolean Ib(String paramString)
  {
    AppMethodBeat.i(101762);
    boolean bool = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kj(paramString);
    AppMethodBeat.o(101762);
    return bool;
  }
  
  public static List<String> Ic(String paramString)
  {
    AppMethodBeat.i(101763);
    if (paramString == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
      AppMethodBeat.o(101763);
      return null;
    }
    if (!HS(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + paramString + "]");
      AppMethodBeat.o(101763);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(paramString);
    AppMethodBeat.o(101763);
    return paramString;
  }
  
  public static List<String> Id(String paramString)
  {
    AppMethodBeat.i(101764);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101764);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(paramString);
    AppMethodBeat.o(101764);
    return paramString;
  }
  
  public static int Ie(String paramString)
  {
    AppMethodBeat.i(101765);
    long l = System.currentTimeMillis();
    try
    {
      ap localap = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
      if (localap != null)
      {
        int i = localap.Kk(paramString);
        return i;
      }
      return 0;
    }
    finally
    {
      Log.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(101765);
    }
  }
  
  public static List<String> If(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(101766);
    if (!HS(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101766);
      return null;
    }
    paramString = Ic(paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      AppMethodBeat.o(101766);
      return null;
    }
    String str = (String)g.aAh().azQ().get(2, null);
    boolean bool;
    if ((str != null) && (str.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
    }
    for (;;)
    {
      if (i < paramString.size())
      {
        if (((String)paramString.get(i)).equals(str)) {
          paramString.remove(i);
        }
      }
      else
      {
        if (paramString.size() > 0) {
          break label172;
        }
        AppMethodBeat.o(101766);
        return null;
        bool = false;
        break;
      }
      i += 1;
    }
    label172:
    AppMethodBeat.o(101766);
    return paramString;
  }
  
  public static String Ig(String paramString)
  {
    AppMethodBeat.i(101769);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101769);
      return null;
    }
    paramString = paramString.field_chatroomnotice;
    AppMethodBeat.o(101769);
    return paramString;
  }
  
  public static boolean Ih(String paramString)
  {
    AppMethodBeat.i(194526);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo member is null");
      AppMethodBeat.o(194526);
      return false;
    }
    Log.i("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo old:%s new:%s", new Object[] { Integer.valueOf(paramString.field_oldChatroomVersion), Integer.valueOf(paramString.field_chatroomVersion) });
    if (paramString.field_oldChatroomVersion < paramString.field_chatroomVersion)
    {
      AppMethodBeat.o(194526);
      return true;
    }
    AppMethodBeat.o(194526);
    return false;
  }
  
  public static String Ii(String paramString)
  {
    AppMethodBeat.i(101771);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101771);
      return null;
    }
    paramString = paramString.field_chatroomnoticeEditor;
    AppMethodBeat.o(101771);
    return paramString;
  }
  
  public static long Ij(String paramString)
  {
    AppMethodBeat.i(101772);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101772);
      return -1L;
    }
    long l = paramString.field_chatroomnoticePublishTime;
    AppMethodBeat.o(101772);
    return l;
  }
  
  public static void Ik(String paramString)
  {
    AppMethodBeat.i(194528);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail username is null");
      AppMethodBeat.o(194528);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (localObject != null) {
      if (((ah)localObject).field_oldChatroomVersion >= ((ah)localObject).field_chatroomVersion) {
        break label125;
      }
    }
    label125:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail() %s update, stack:%s", new Object[] { paramString, Util.getStack().toString() });
        localObject = new jj();
        ((jj)localObject).dOd.dOe = paramString;
        EventCenter.instance.publish((IEvent)localObject);
      }
      AppMethodBeat.o(194528);
      return;
    }
  }
  
  public static as a(as paramas, coo paramcoo)
  {
    AppMethodBeat.i(101767);
    paramas.setUsername(com.tencent.mm.platformtools.z.a(paramcoo.Lqp));
    paramas.setNickname(com.tencent.mm.platformtools.z.a(paramcoo.Lqp));
    paramas.BF(com.tencent.mm.platformtools.z.a(paramcoo.Lqp));
    paramas.BG(com.tencent.mm.platformtools.z.a(paramcoo.LpB));
    paramas.nj(paramcoo.kdY);
    paramas.BD(com.tencent.mm.platformtools.z.a(paramcoo.MuI));
    paramas.BJ(com.tencent.mm.platformtools.z.a(paramcoo.MuJ));
    paramas.BI(com.tencent.mm.platformtools.z.a(paramcoo.LpB));
    paramas.nl(paramcoo.LoM);
    paramas.nn(paramcoo.kec);
    paramas.Cb(RegionCodeDecoder.bq(paramcoo.keh, paramcoo.kdZ, paramcoo.kea));
    paramas.BV(paramcoo.keb);
    AppMethodBeat.o(101767);
    return paramas;
  }
  
  public static void a(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184634);
    if (!aTU())
    {
      AppMethodBeat.o(184634);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184634);
      return;
    }
    if (MultiProcessMMKV.getMMKV("room_upgrade_to_wework").getBoolean(paramString, false))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (localah == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member is null", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    a(paramString, localah.field_roomowner, localah.field_memberCount, localah.field_chatroomStatus, parama);
    AppMethodBeat.o(184634);
  }
  
  public static void a(String paramString, ah paramah, boolean paramBoolean)
  {
    AppMethodBeat.i(101745);
    paramah.AL(paramBoolean);
    ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().update(paramah, new String[0]);
    paramah = z.aTY();
    com.tencent.mm.roomsdk.a.b.bhF(paramString).b(paramString, paramah, paramBoolean).aJu();
    cpi localcpi = new cpi();
    localcpi.KGO = paramString;
    localcpi.UserName = paramah;
    localcpi.Mvf = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localcpi.Cyb = i;
      ((l)g.af(l.class)).aSM().d(new k.a(49, localcpi));
      AppMethodBeat.o(101745);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, PluginNewTips.a parama)
  {
    int i = 1;
    AppMethodBeat.i(184635);
    int j;
    if ((ab.Ix(paramString1)) && ((paramInt2 & 0x20000) != 131072L) && ((paramInt2 & 0x10000) == 65536L))
    {
      MultiProcessMMKV.getMMKV("room_upgrade_to_wework").putBoolean(paramString1, true);
      boolean bool = com.tencent.mm.openim.room.a.a.bkC();
      j = aTT();
      Log.i("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom chatRoomName:%s chatroomOwner:%s chatroomStatus:%s isInstallWeWork:%s maxNum:%s", new Object[] { paramString1, Util.nullAs(paramString2, "null"), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((bool) && (paramInt1 < j) && (Util.isEqual(paramString2, z.aTY())))
      {
        com.tencent.mm.plugin.newtips.a.exl();
        com.tencent.mm.plugin.newtips.a.i.b(d.ADs, parama);
        MultiProcessMMKV.getMMKV("room_upgrade_to_wework").putBoolean("enter_show", true);
        parama = MMApplicationContext.getResources().getString(2131757313);
        String str = MMApplicationContext.getResources().getString(2131757315);
        paramString2 = new StringBuffer();
        paramString2.append(parama).append(" ");
        paramString2.append("<_wc_custom_link_ href=\"weixin://weixingroupupdate?roomname=").append(paramString1).append("\">").append(str).append("</_wc_custom_link_>");
        parama = new ca();
        parama.nv(0);
        parama.Cy(paramString1);
        parama.setStatus(3);
        parama.setContent(paramString2.toString());
        parama.setCreateTime(bp.C(paramString1, System.currentTimeMillis() / 1000L));
        parama.setType(10000);
        parama.setFlag(parama.field_flag | 0x8);
        bp.x(parama);
        ai(paramString1, 0);
        AppMethodBeat.o(184635);
        return;
      }
      if (bool) {
        break label372;
      }
    }
    for (;;)
    {
      paramInt2 = i;
      if (!Util.isEqual(paramString2, z.aTY())) {
        paramInt2 = i | 0x2;
      }
      i = paramInt2;
      if (paramInt1 >= j) {
        i = paramInt2 | 0x4;
      }
      ai(paramString1, i);
      AppMethodBeat.o(184635);
      return;
      label372:
      i = 0;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101773);
    ap localap = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
    ah localah = localap.Kd(paramString1);
    if (localah == null)
    {
      AppMethodBeat.o(101773);
      return;
    }
    String str = localah.field_chatroomnotice;
    localah.field_oldChatroomVersion = paramInt1;
    localah.field_chatroomnoticePublishTime = paramLong;
    localah.field_chatroomnoticeEditor = paramString3;
    localah.field_chatroomnotice = paramString2;
    localah.field_chatroomStatus = paramInt2;
    localap.replace(localah);
    if ((Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(str)))
    {
      g.aAi();
      paramString2 = ((l)g.af(l.class)).aSN().Kn(paramString1);
      paramLong = paramString2.fve;
      paramString2.yz(0L);
      g.aAi();
      ((l)g.af(l.class)).aSN().ao(paramString2);
      Log.i("MicroMsg.ChatroomMembersLogic", "clear room card, oldInfoId %s", new Object[] { Long.valueOf(paramLong) });
      if (paramLong != 0L) {
        ((t)g.af(t.class)).r(paramString1, paramLong);
      }
    }
    AppMethodBeat.o(101773);
  }
  
  public static boolean a(ah paramah)
  {
    AppMethodBeat.i(101755);
    if (paramah == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
      AppMethodBeat.o(101755);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().replace(paramah);
    if (bool) {
      aG(paramah.field_chatroomname, paramah.field_roomowner);
    }
    AppMethodBeat.o(101755);
    return bool;
  }
  
  public static boolean a(String paramString, afg paramafg)
  {
    AppMethodBeat.i(101757);
    if ((!HS(paramString)) || (paramafg.gsq == 0))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + paramString + "] listCnt:" + paramafg.gsq);
      AppMethodBeat.o(101757);
      return false;
    }
    ap localap = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
    paramString = localap.Kd(paramString);
    List localList = ah.bji(paramString.field_memberlist);
    Log.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + localList.size());
    paramafg = paramafg.KGQ.iterator();
    while (paramafg.hasNext()) {
      localList.remove(com.tencent.mm.platformtools.z.a(((afq)paramafg.next()).Lqp));
    }
    Log.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + localList.size());
    paramafg = paramString.iE(localList);
    paramafg.field_displayname = an(localList);
    paramafg.field_memberCount = localList.size();
    boolean bool = localap.replace(paramString);
    Log.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101757);
    return bool;
  }
  
  public static boolean a(String paramString, ct paramct)
  {
    AppMethodBeat.i(101758);
    if ((!HS(paramString)) || (paramct.gsq == 0))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + paramString + "] listCnt:" + paramct.gsq);
      AppMethodBeat.o(101758);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    bv localbv = ((l)g.af(l.class)).aSN();
    int i = 0;
    while (i < paramct.gsq)
    {
      Object localObject = com.tencent.mm.platformtools.z.a(((coo)paramct.KGQ.get(i)).Lqp);
      if (((coo)paramct.KGQ.get(i)).MuH == 0)
      {
        if (Util.isNullOrNil((String)localObject)) {
          Log.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", new Object[] { paramString });
        }
      }
      else
      {
        i += 1;
        continue;
      }
      localObject = localbv.Kn((String)localObject);
      if ((int)((com.tencent.mm.contact.c)localObject).gMZ != 0)
      {
        ((as)localObject).aqP();
        localbv.c(((ax)localObject).field_username, (as)localObject);
      }
      for (;;)
      {
        localArrayList.add(((ax)localObject).field_username);
        break;
        localObject = a((as)localObject, (coo)paramct.KGQ.get(i));
        localbv.ap((as)localObject);
      }
    }
    if (!localArrayList.isEmpty())
    {
      boolean bool = a(paramString, localArrayList, null);
      AppMethodBeat.o(101758);
      return bool;
    }
    AppMethodBeat.o(101758);
    return false;
  }
  
  public static boolean a(String paramString, xg paramxg)
  {
    AppMethodBeat.i(101753);
    if (paramxg == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
      AppMethodBeat.o(101753);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
      AppMethodBeat.o(101753);
      return false;
    }
    if (ab.Eq(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[] { paramString });
      AppMethodBeat.o(101753);
      return false;
    }
    String str = com.tencent.mm.platformtools.z.a(paramxg.Lip);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(101753);
      return false;
    }
    Log.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[] { str, Integer.valueOf(paramxg.Lin.size()) });
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(str);
    if ((paramString != null) && (paramxg.Lin.size() > 0) && (paramString.bax().contains(((xh)paramxg.Lin.get(0)).UserName)))
    {
      str = ((xh)paramxg.Lin.get(0)).UserName;
      com.tencent.mm.k.a.a.b localb = paramString.bje(str);
      if (localb != null)
      {
        Log.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[] { str, localb.gCv });
        localb.gCx = ((xh)paramxg.Lin.get(0)).Liu;
        a(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(101753);
        return true;
        Log.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[] { str });
      }
    }
    if ((paramString != null) && (paramxg.Lin.size() > 0))
    {
      paramString = new bd();
      paramString.dEm.username = ((xh)paramxg.Lin.get(0)).UserName;
      paramString.dEm.dEn = ((xh)paramxg.Lin.get(0)).Liu;
      iCv.put(str + "#" + paramString.dEm.username, paramString.dEm.dEn);
      EventCenter.instance.publish(paramString);
      AppMethodBeat.o(101753);
      return false;
    }
    if (paramxg.Lin.size() <= 0) {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
    }
    if (paramString != null) {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
    }
    AppMethodBeat.o(101753);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, xg paramxg, int paramInt1, int paramInt2, String paramString3, com.tencent.mm.k.a.a.a parama, IEvent paramIEvent)
  {
    AppMethodBeat.i(194523);
    if ((!paramString1.toLowerCase().endsWith("@chatroom")) && (!paramString1.toLowerCase().endsWith("@im.chatroom")) && (!paramString1.toLowerCase().endsWith("@groupcard")) && (!paramString1.toLowerCase().endsWith("@talkroom")))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] listCnt:" + paramxg.gsq);
      AppMethodBeat.o(194523);
      return false;
    }
    bv localbv = ((l)g.af(l.class)).aSN();
    ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString1);
    if (localah != null) {}
    ArrayList localArrayList;
    long l1;
    boolean bool1;
    xh localxh;
    as localas;
    for (parama.dTg = localah.gBt();; parama.dTg = 0)
    {
      localArrayList = new ArrayList();
      Log.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] memCnt:" + paramxg.gsq);
      l1 = System.currentTimeMillis();
      i = 0;
      bool1 = false;
      for (;;)
      {
        if (i >= paramxg.gsq) {
          break label633;
        }
        localxh = (xh)paramxg.Lin.get(i);
        localas = localbv.Kn(localxh.UserName);
        if (localas != null) {
          break;
        }
        Log.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
        i += 1;
      }
    }
    com.tencent.mm.k.a.a.b localb = new com.tencent.mm.k.a.a.b();
    localb.userName = localxh.UserName;
    localb.gCx = localxh.Liu;
    localb.gCw = localxh.Lit;
    boolean bool2;
    if (paramxg.Lio == 0)
    {
      localb.gCv = localxh.Liq;
      if (!Util.isNullOrNil(localxh.Lis))
      {
        com.tencent.mm.aj.i locali = p.aYB().Mx(localxh.UserName);
        localObject = locali;
        if (locali == null)
        {
          localObject = new com.tencent.mm.aj.i();
          ((com.tencent.mm.aj.i)localObject).username = localxh.UserName;
        }
        ((com.tencent.mm.aj.i)localObject).iKX = localxh.Lir;
        ((com.tencent.mm.aj.i)localObject).iKW = localxh.Lis;
        ((com.tencent.mm.aj.i)localObject).fuz = 3;
        if (Util.isNullOrNil(localxh.Lir)) {
          break label617;
        }
        bool2 = true;
        label420:
        ((com.tencent.mm.aj.i)localObject).fv(bool2);
        p.aYB().b((com.tencent.mm.aj.i)localObject);
      }
    }
    if (localah != null)
    {
      localObject = localah.bje(localxh.UserName);
      if (localObject != null)
      {
        localb.gCv = ((com.tencent.mm.k.a.a.b)localObject).gCv;
        if (!Util.isNullOrNil(localb.gCx)) {
          break label623;
        }
      }
    }
    label617:
    label623:
    for (Object localObject = ((com.tencent.mm.k.a.a.b)localObject).gCx;; localObject = localb.gCx)
    {
      localb.gCx = ((String)localObject);
      parama.gCs.add(localb);
      ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).bM(localxh.Liw, localxh.Lix);
      if ((int)localas.gMZ == 0)
      {
        localas.setUsername(localxh.UserName);
        if (localxh.oUJ != null) {
          localas.setNickname(localxh.oUJ);
        }
        localas.BN(localxh.Liw);
        localas.BM(localxh.Lix);
        localas.aqP();
        localbv.ap(localas);
        bool1 = true;
      }
      localArrayList.add(localas.field_username);
      break;
      bool2 = false;
      break label420;
    }
    label633:
    Log.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + localArrayList.size() + " event: " + paramIEvent + " publish: " + bool1 + " take[" + (System.currentTimeMillis() - l1) + "]ms");
    label814:
    long l2;
    if (bool1)
    {
      ag(paramString1, parama.dTg);
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString1);
      paramIEvent = (IEvent)localObject;
      if (localObject == null) {
        paramIEvent = new ah();
      }
      i = paramIEvent.field_chatroomStatus;
      l1 = System.currentTimeMillis();
      paramIEvent.field_chatroomname = paramString1;
      paramIEvent.field_roomowner = paramString2;
      localObject = paramIEvent.iE(localArrayList);
      ((ah)localObject).field_chatroomStatus = paramInt1;
      ((ah)localObject).field_displayname = an(localArrayList);
      if (paramxg.Lio == 0) {
        break label1092;
      }
      bool1 = true;
      ((ah)localObject).a(paramString3, parama, bool1).field_memberCount = localArrayList.size();
      if (paramInt2 != -1) {
        paramIEvent.field_chatroomVersion = paramInt2;
      }
      paramInt2 = paramIEvent.field_memberCount;
      if ((aTU()) && (!Util.isNullOrNil(paramString1)))
      {
        if (!MultiProcessMMKV.getMMKV("room_upgrade_to_wework").getBoolean(paramString1, false)) {
          break label1098;
        }
        Log.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString1 });
      }
      label896:
      bool1 = a(paramIEvent);
      if ((bool1) && (paramInt1 != i)) {
        ab.IC(paramString1);
      }
      l2 = System.currentTimeMillis();
      bool2 = paramIEvent.gBu();
      if (paramIEvent.gBr() != null) {
        break label1110;
      }
      paramInt2 = 0;
      label941:
      if (paramIEvent.gBr() != null) {
        break label1123;
      }
    }
    label1092:
    label1098:
    label1110:
    label1123:
    for (int i = 0;; i = paramIEvent.gBr().gCu)
    {
      Log.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s chatroomStatus:%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2 - l1), Boolean.valueOf(bool2), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt1) });
      if (paramIEvent.gBu())
      {
        Log.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[] { Integer.valueOf(paramIEvent.gBt()) });
        paramString2 = new bc();
        paramString2.dEl.username = paramString1;
        EventCenter.instance.publish(paramString2);
      }
      AppMethodBeat.o(194523);
      return bool1;
      if (localah != null) {
        break;
      }
      ag(paramString1, 0);
      break;
      bool1 = false;
      break label814;
      a(paramString1, paramString2, paramInt2, paramInt1, null);
      break label896;
      paramInt2 = paramIEvent.gBr().dTg;
      break label941;
    }
  }
  
  public static boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    int i = 0;
    int k = 0;
    AppMethodBeat.i(101761);
    ap localap = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
    ah localah = localap.Ke(paramString1);
    if ((paramString1.endsWith("@chatroom")) || (paramString1.endsWith("@im.chatroom"))) {}
    LinkedList localLinkedList;
    int j;
    for (paramString1 = Ic(paramString1);; paramString1 = new LinkedList())
    {
      localLinkedList = new LinkedList();
      if (paramString1 == null) {
        break label229;
      }
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= paramString1.size()) {
          break;
        }
        localLinkedList.add(paramString1.get(i));
        i += 1;
      }
    }
    while (j < paramArrayList.size())
    {
      if (!paramString1.contains(paramArrayList.get(j))) {
        localLinkedList.add(paramArrayList.get(j));
      }
      j += 1;
    }
    if (!Util.isNullOrNil(paramString2)) {
      localah.field_roomowner = paramString2;
    }
    paramString1 = localah.iE(localLinkedList);
    paramString1.field_displayname = an(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    boolean bool = localap.replace(localah);
    AppMethodBeat.o(101761);
    return bool;
    label229:
    while (i < paramArrayList.size())
    {
      localLinkedList.add(paramArrayList.get(i));
      i += 1;
    }
    if (!Util.isNullOrNil(paramString2)) {
      localah.field_roomowner = paramString2;
    }
    paramString1 = localah.iE(localLinkedList);
    paramString1.field_displayname = an(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    localah.field_roomowner = paramString2;
    bool = localap.replace(localah);
    Log.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101761);
    return bool;
  }
  
  public static String aF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101754);
    paramString1 = paramString2 + "#" + paramString1;
    if (iCv.checkAndUpTime(paramString1))
    {
      paramString1 = (String)iCv.get(paramString1);
      AppMethodBeat.o(101754);
      return paramString1;
    }
    AppMethodBeat.o(101754);
    return "";
  }
  
  private static void aG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101756);
    Log.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[] { Integer.valueOf(1) });
    bv localbv = ((l)g.af(l.class)).aSN();
    as localas = localbv.Kn(paramString1);
    if (((int)localas.gMZ != 0) && (!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(z.aTY())))
    {
      if (!paramString2.equals(z.aTY())) {
        break label102;
      }
      localas.oS(1);
    }
    for (;;)
    {
      localbv.c(paramString1, localas);
      AppMethodBeat.o(101756);
      return;
      label102:
      localas.oS(0);
    }
  }
  
  public static void aTR()
  {
    AppMethodBeat.i(184633);
    PluginNewTips.removeLocalNewTipsCallback(d.ADs);
    AppMethodBeat.o(184633);
  }
  
  public static boolean aTS()
  {
    AppMethodBeat.i(184636);
    boolean bool = MultiProcessMMKV.getMMKV("room_upgrade_to_wework").getBoolean("enter_show", false);
    AppMethodBeat.o(184636);
    return bool;
  }
  
  public static int aTT()
  {
    AppMethodBeat.i(184637);
    int i = ((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("AssociateChatRoomLocalCheckMaxMemberCount", 200);
    AppMethodBeat.o(184637);
    return i;
  }
  
  public static boolean aTU()
  {
    AppMethodBeat.i(194527);
    if (((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("MMForwardUpgradeChatRoomSwitch", 0) == 1)
    {
      AppMethodBeat.o(194527);
      return true;
    }
    AppMethodBeat.o(194527);
    return false;
  }
  
  private static void ag(String paramString, int paramInt)
  {
    AppMethodBeat.i(194524);
    if (Util.nullAsNil((Integer)g.aAh().azQ().get(15, null)) != 0)
    {
      com.tencent.mm.roomsdk.a.b.bhF(paramString).H(paramString, paramInt).aJu();
      AppMethodBeat.o(194524);
      return;
    }
    cjo localcjo = new cjo();
    localcjo.chatroomName = paramString;
    localcjo.dTg = paramInt;
    iCu.Mpi.addFirst(localcjo);
    try
    {
      MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.a.azs()).encode("detail", iCu.toByteArray());
      Log.i("MicroMsg.ChatroomMembersLogic", "getChatroomMemberDetail " + localcjo.chatroomName + " " + localcjo.dTg);
      AppMethodBeat.o(194524);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.ChatroomMembersLogic", "getChatroomMemberDetail " + paramString.getMessage());
      }
    }
  }
  
  public static String ah(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101768);
    ap localap = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
    if (localap == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
      AppMethodBeat.o(101768);
      return null;
    }
    paramString2 = localap.Kd(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(101768);
      return null;
    }
    paramString1 = paramString2.getDisplayName(paramString1);
    AppMethodBeat.o(101768);
    return paramString1;
  }
  
  public static void ah(String paramString, int paramInt)
  {
    AppMethodBeat.i(101774);
    ap localap = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
    ah localah = localap.Kd(paramString);
    if (localah == null)
    {
      AppMethodBeat.o(101774);
      return;
    }
    com.tencent.mm.k.a.a.a locala = localah.gBy();
    locala.type = paramInt;
    localah.a(paramString, locala, false);
    localap.replace(localah);
    AppMethodBeat.o(101774);
  }
  
  private static void ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(184638);
    eu localeu = new eu();
    localeu.rS(paramString);
    localeu.eEu = paramInt;
    localeu.bfK();
    AppMethodBeat.o(184638);
  }
  
  public static String an(List<String> paramList)
  {
    AppMethodBeat.i(101747);
    paramList = e(paramList, -1);
    AppMethodBeat.o(101747);
    return paramList;
  }
  
  public static String e(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(101748);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(101748);
      return "";
    }
    Object localObject1 = "";
    int i = 0;
    Object localObject2 = localObject1;
    if (i < paramList.size())
    {
      localObject2 = (String)paramList.get(i);
      if (((String)localObject2).length() <= 0) {
        break label210;
      }
      localObject2 = ((l)g.af(l.class)).aSN().Kn((String)localObject2);
      localObject2 = (String)localObject1 + ((as)localObject2).arJ();
      if ((i == paramInt - 1) && (i < paramList.size())) {
        localObject2 = (String)localObject2 + "...";
      }
    }
    else
    {
      AppMethodBeat.o(101748);
      return localObject2;
    }
    localObject1 = localObject2;
    if (i < paramList.size() - 1) {
      localObject1 = (String)localObject2 + MMApplicationContext.getContext().getString(2131757307);
    }
    label210:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public static void fr(boolean paramBoolean)
  {
    AppMethodBeat.i(194525);
    Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (iCu.Mpi.isEmpty()))
    {
      AppMethodBeat.o(194525);
      return;
    }
    if ((!paramBoolean) && (Util.nullAsNil((Integer)g.aAh().azQ().get(15, null)) == 0))
    {
      AppMethodBeat.o(194525);
      return;
    }
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194521);
        Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + v.iCu.Mpi.size());
        byte[] arrayOfByte;
        Object localObject;
        if (v.iCu.Mpi.isEmpty())
        {
          arrayOfByte = MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.a.azs()).decodeBytes("detail");
          if (arrayOfByte == null)
          {
            AppMethodBeat.o(194521);
            return;
          }
          localObject = new cjp();
        }
        try
        {
          ((cjp)localObject).parseFrom(arrayOfByte);
          v.iCu.Mpi.addAll(((cjp)localObject).Mpi);
          if (v.iCu.Mpi.isEmpty())
          {
            Log.i("MicroMsg.ChatroomMembersLogic", "getChatroomMemberDetails is null");
            AppMethodBeat.o(194521);
            return;
          }
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            Log.e("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + localIOException2.getMessage());
          }
          Log.i("MicroMsg.ChatroomMembersLogic", "start Conversation:" + v.iCu.Mpi.size());
          localObject = new ArrayList();
          Iterator localIterator1 = v.iCu.Mpi.iterator();
          cjo localcjo;
          while (localIterator1.hasNext())
          {
            localcjo = (cjo)localIterator1.next();
            if (((l)g.af(l.class)).aST().bjY(localcjo.chatroomName) != null)
            {
              com.tencent.mm.roomsdk.a.b.bhF(localcjo.chatroomName).H(localcjo.chatroomName, localcjo.dTg).aJu();
              ((ArrayList)localObject).add(localcjo);
              Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + localcjo.chatroomName + " " + localcjo.dTg);
            }
          }
          localIterator1 = ((ArrayList)localObject).iterator();
          while (localIterator1.hasNext())
          {
            localcjo = (cjo)localIterator1.next();
            v.iCu.Mpi.remove(localcjo);
          }
          Log.i("MicroMsg.ChatroomMembersLogic", "delete " + ((ArrayList)localObject).size() + " " + v.iCu.Mpi.size());
          try
          {
            MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.a.azs()).encode("detail", v.iCu.toByteArray());
            Log.i("MicroMsg.ChatroomMembersLogic", "end Conversation");
            ((ArrayList)localObject).clear();
            localIterator1 = v.iCu.Mpi.iterator();
            while (localIterator1.hasNext())
            {
              localcjo = (cjo)localIterator1.next();
              com.tencent.mm.roomsdk.a.b.bhF(localcjo.chatroomName).H(localcjo.chatroomName, localcjo.dTg).aJu();
              ((ArrayList)localObject).add(localcjo);
            }
          }
          catch (IOException localIOException3)
          {
            for (;;)
            {
              Log.e("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + localIOException3.getMessage());
            }
            Iterator localIterator2 = ((ArrayList)localObject).iterator();
            while (localIterator2.hasNext())
            {
              localcjo = (cjo)localIterator2.next();
              v.iCu.Mpi.remove(localcjo);
            }
            Log.i("MicroMsg.ChatroomMembersLogic", "delete " + ((ArrayList)localObject).size() + " " + v.iCu.Mpi.size());
            try
            {
              MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.a.azs()).encode("detail", v.iCu.toByteArray());
              AppMethodBeat.o(194521);
              return;
            }
            catch (IOException localIOException1)
            {
              Log.e("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + localIOException1.getMessage());
              AppMethodBeat.o(194521);
            }
          }
        }
      }
    }, "MicroMsg.ChatroomMembersLogic");
    AppMethodBeat.o(194525);
  }
  
  public static boolean g(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(101743);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101743);
      return false;
    }
    Iterator localIterator = paramString.bax().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, paramString.getDisplayName(str));
    }
    AppMethodBeat.o(101743);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.v
 * JD-Core Version:    0.7.0.1
 */