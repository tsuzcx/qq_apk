package com.tencent.mm.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.f.a.bg;
import com.tencent.mm.f.a.bh;
import com.tencent.mm.f.a.bh.a;
import com.tencent.mm.f.a.jz;
import com.tencent.mm.f.b.a.fx;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.cxa;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.protocal.protobuf.xn;
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
  public static csk lsp;
  public static com.tencent.mm.b.f<String, String> lsq;
  
  static
  {
    AppMethodBeat.i(101775);
    lsp = new csk();
    lsq = new com.tencent.mm.b.h(100);
    AppMethodBeat.o(101775);
  }
  
  public static boolean E(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(258996);
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null);
    paramString = Ps(paramString);
    if (paramString == null)
    {
      Log.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
      if (paramBoolean)
      {
        Log.w("MicroMsg.ChatroomMembersLogic", "isInChatRoom temp change");
        AppMethodBeat.o(258996);
        return true;
      }
      AppMethodBeat.o(258996);
      return false;
    }
    if ((paramString.size() == 0) || (!paramString.contains(str)))
    {
      Log.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + paramString.size() + " ");
      AppMethodBeat.o(258996);
      return false;
    }
    AppMethodBeat.o(258996);
    return true;
  }
  
  public static void PA(String paramString)
  {
    AppMethodBeat.i(259022);
    aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    paramString = localaq.Rw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(259022);
      return;
    }
    if (paramString.field_chatroomNoticeNew != 0)
    {
      paramString.field_chatroomNoticeNew = 0;
      localaq.replace(paramString);
    }
    AppMethodBeat.o(259022);
  }
  
  public static void PB(String paramString)
  {
    AppMethodBeat.i(259031);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail username is null");
      AppMethodBeat.o(259031);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
    if (localObject != null) {
      if (((ah)localObject).field_oldChatroomVersion >= ((ah)localObject).field_chatroomVersion) {
        break label120;
      }
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail() %s update, stack:%s", new Object[] { paramString, Util.getStack().toString() });
        localObject = new jz();
        ((jz)localObject).fHo.fHp = paramString;
        EventCenter.instance.publish((IEvent)localObject);
      }
      AppMethodBeat.o(259031);
      return;
    }
  }
  
  private static boolean Pi(String paramString)
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
  
  public static boolean Pj(String paramString)
  {
    AppMethodBeat.i(101742);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101742);
      return false;
    }
    boolean bool = paramString.hxI();
    AppMethodBeat.o(101742);
    return bool;
  }
  
  public static boolean Pk(String paramString)
  {
    AppMethodBeat.i(101744);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Ry(paramString);
    String str = z.bcZ();
    if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(str)) && (paramString.equals(str)))
    {
      AppMethodBeat.o(101744);
      return true;
    }
    AppMethodBeat.o(101744);
    return false;
  }
  
  public static String Pl(String paramString)
  {
    AppMethodBeat.i(101746);
    if ((paramString == null) || (!Pi(paramString)))
    {
      AppMethodBeat.o(101746);
      return "";
    }
    List localList = Ps(paramString);
    paramString = "";
    int i = 0;
    String str;
    as localas;
    if ((localList != null) && (i < localList.size()))
    {
      str = (String)localList.get(i);
      if (str.length() <= 0) {
        break label192;
      }
      localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(str);
      if (localas == null)
      {
        str = paramString + str;
        label111:
        paramString = str;
        if (i < localList.size() - 1) {
          paramString = str + MMApplicationContext.getContext().getString(b.a.chatroom_sys_msg_invite_split);
        }
      }
    }
    label192:
    for (;;)
    {
      i += 1;
      break;
      str = paramString + localas.ayr();
      break label111;
      AppMethodBeat.o(101746);
      return paramString;
    }
  }
  
  public static boolean Pm(String paramString)
  {
    AppMethodBeat.i(101749);
    boolean bool = E(paramString, false);
    AppMethodBeat.o(101749);
    return bool;
  }
  
  public static boolean Pn(String paramString)
  {
    AppMethodBeat.i(101750);
    if (!ab.PO(paramString))
    {
      AppMethodBeat.o(101750);
      return false;
    }
    if (!((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().RB(paramString))
    {
      Log.d("MicroMsg.ChatroomMembersLogic", "state is die");
      AppMethodBeat.o(101750);
      return true;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().RA(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(101750);
      return true;
    }
    AppMethodBeat.o(101750);
    return false;
  }
  
  public static boolean Po(String paramString)
  {
    AppMethodBeat.i(101751);
    if (!ab.PO(paramString))
    {
      AppMethodBeat.o(101751);
      return false;
    }
    Log.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[] { paramString });
    aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    paramString = localaq.Rw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101751);
      return false;
    }
    paramString.field_roomflag = 1;
    boolean bool = localaq.replace(paramString);
    AppMethodBeat.o(101751);
    return bool;
  }
  
  public static boolean Pp(String paramString)
  {
    AppMethodBeat.i(101759);
    if (!paramString.toLowerCase().endsWith("@groupcard"))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + paramString + "]");
      AppMethodBeat.o(101759);
      return false;
    }
    bv localbv = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL();
    if (localbv.bwl(paramString)) {
      localbv.bwp(paramString);
    }
    for (;;)
    {
      boolean bool = Pr(paramString);
      AppMethodBeat.o(101759);
      return bool;
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + paramString + "]");
    }
  }
  
  public static boolean Pq(String paramString)
  {
    AppMethodBeat.i(101760);
    if (!Pi(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + paramString + "]");
      AppMethodBeat.o(101760);
      return false;
    }
    bv localbv = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL();
    if (localbv.bwl(paramString)) {
      localbv.bwp(paramString);
    }
    for (;;)
    {
      boolean bool = Pr(paramString);
      AppMethodBeat.o(101760);
      return bool;
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + paramString + "]");
    }
  }
  
  private static boolean Pr(String paramString)
  {
    AppMethodBeat.i(101762);
    boolean bool = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().RC(paramString);
    AppMethodBeat.o(101762);
    return bool;
  }
  
  public static List<String> Ps(String paramString)
  {
    AppMethodBeat.i(101763);
    if (paramString == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
      AppMethodBeat.o(101763);
      return null;
    }
    if (!Pi(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + paramString + "]");
      AppMethodBeat.o(101763);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().RA(paramString);
    AppMethodBeat.o(101763);
    return paramString;
  }
  
  public static List<String> Pt(String paramString)
  {
    AppMethodBeat.i(101764);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101764);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().RA(paramString);
    AppMethodBeat.o(101764);
    return paramString;
  }
  
  public static int Pu(String paramString)
  {
    AppMethodBeat.i(101765);
    long l = System.currentTimeMillis();
    try
    {
      aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
      if (localaq != null)
      {
        int i = localaq.RD(paramString);
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
  
  public static List<String> Pv(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(101766);
    if (!Pi(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101766);
      return null;
    }
    paramString = Ps(paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      AppMethodBeat.o(101766);
      return null;
    }
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null);
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
          break label173;
        }
        AppMethodBeat.o(101766);
        return null;
        bool = false;
        break;
      }
      i += 1;
    }
    label173:
    AppMethodBeat.o(101766);
    return paramString;
  }
  
  public static String Pw(String paramString)
  {
    AppMethodBeat.i(101769);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101769);
      return null;
    }
    paramString = paramString.field_chatroomnotice;
    AppMethodBeat.o(101769);
    return paramString;
  }
  
  public static boolean Px(String paramString)
  {
    AppMethodBeat.i(259017);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo member is null");
      AppMethodBeat.o(259017);
      return false;
    }
    Log.i("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo old:%s new:%s", new Object[] { Integer.valueOf(paramString.field_oldChatroomVersion), Integer.valueOf(paramString.field_chatroomVersion) });
    if (paramString.field_oldChatroomVersion < paramString.field_chatroomVersion)
    {
      AppMethodBeat.o(259017);
      return true;
    }
    AppMethodBeat.o(259017);
    return false;
  }
  
  public static String Py(String paramString)
  {
    AppMethodBeat.i(101771);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101771);
      return null;
    }
    paramString = paramString.field_chatroomnoticeEditor;
    AppMethodBeat.o(101771);
    return paramString;
  }
  
  public static long Pz(String paramString)
  {
    AppMethodBeat.i(101772);
    long l = System.currentTimeMillis() / 1000L;
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101772);
      return -1L;
    }
    if (paramString.field_chatroomnoticePublishTime == 0L)
    {
      AppMethodBeat.o(101772);
      return l;
    }
    l = paramString.field_chatroomnoticePublishTime;
    AppMethodBeat.o(101772);
    return l;
  }
  
  public static as a(as paramas, cxa paramcxa)
  {
    AppMethodBeat.i(101767);
    paramas.setUsername(com.tencent.mm.platformtools.z.a(paramcxa.SrM));
    paramas.setNickname(com.tencent.mm.platformtools.z.a(paramcxa.SrM));
    paramas.It(com.tencent.mm.platformtools.z.a(paramcxa.SrM));
    paramas.Iu(com.tencent.mm.platformtools.z.a(paramcxa.SqX));
    paramas.pw(paramcxa.mVy);
    paramas.Ir(com.tencent.mm.platformtools.z.a(paramcxa.TFz));
    paramas.Ix(com.tencent.mm.platformtools.z.a(paramcxa.TFA));
    paramas.Iw(com.tencent.mm.platformtools.z.a(paramcxa.SqX));
    paramas.pz(paramcxa.Sqi);
    paramas.pB(paramcxa.mVC);
    paramas.IP(RegionCodeDecoder.bl(paramcxa.mVH, paramcxa.mVz, paramcxa.mVA));
    paramas.IJ(paramcxa.mVB);
    AppMethodBeat.o(101767);
    return paramas;
  }
  
  public static void a(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184634);
    if (!bcV())
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
    ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
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
    paramah.ET(paramBoolean);
    ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().update(paramah, new String[0]);
    paramah = z.bcZ();
    com.tencent.mm.roomsdk.a.b.btX(paramString).b(paramString, paramah, paramBoolean).aRu();
    cxy localcxy = new cxy();
    localcxy.RIi = paramString;
    localcxy.UserName = paramah;
    localcxy.TGd = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localcxy.Iza = i;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(49, localcxy));
      AppMethodBeat.o(101745);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, PluginNewTips.a parama)
  {
    int i = 1;
    AppMethodBeat.i(184635);
    int j;
    if ((ab.PP(paramString1)) && ((paramInt2 & 0x20000) != 131072L) && ((paramInt2 & 0x10000) == 65536L))
    {
      MultiProcessMMKV.getMMKV("room_upgrade_to_wework").putBoolean(paramString1, true);
      boolean bool = com.tencent.mm.openim.room.a.a.buq();
      j = bcU();
      Log.i("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom chatRoomName:%s chatroomOwner:%s chatroomStatus:%s isInstallWeWork:%s maxNum:%s", new Object[] { paramString1, Util.nullAs(paramString2, "null"), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((bool) && (paramInt1 < j) && (Util.isEqual(paramString2, z.bcZ())))
      {
        com.tencent.mm.plugin.newtips.a.fiO();
        com.tencent.mm.plugin.newtips.a.i.b(com.tencent.mm.plugin.newtips.a.d.Gww, parama);
        MultiProcessMMKV.getMMKV("room_upgrade_to_wework").putBoolean("enter_show", true);
        parama = MMApplicationContext.getResources().getString(b.a.chatroom_sys_msg_room_upgrade_to_wework_msg);
        String str = MMApplicationContext.getResources().getString(b.a.chatroom_sys_msg_room_upgrade_to_wework_url_tips);
        paramString2 = new StringBuffer();
        paramString2.append(parama).append(" ");
        paramString2.append("<_wc_custom_link_ href=\"weixin://weixingroupupdate?roomname=").append(paramString1).append("\">").append(str).append("</_wc_custom_link_>");
        parama = new ca();
        parama.pJ(0);
        parama.Jm(paramString1);
        parama.setStatus(3);
        parama.setContent(paramString2.toString());
        parama.setCreateTime(bq.z(paramString1, System.currentTimeMillis() / 1000L));
        parama.setType(10000);
        parama.setFlag(parama.field_flag | 0x8);
        bq.z(parama);
        aA(paramString1, 0);
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
      if (!Util.isEqual(paramString2, z.bcZ())) {
        paramInt2 = i | 0x2;
      }
      i = paramInt2;
      if (paramInt1 >= j) {
        i = paramInt2 | 0x4;
      }
      aA(paramString1, i);
      AppMethodBeat.o(184635);
      return;
      label372:
      i = 0;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101773);
    aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    ah localah = localaq.Rw(paramString1);
    if (localah == null)
    {
      AppMethodBeat.o(101773);
      return;
    }
    String str = localah.field_chatroomnotice;
    localah.field_oldChatroomVersion = paramInt1;
    localah.field_chatroomnoticePublishTime = paramLong;
    localah.field_chatroomnoticeEditor = paramString3;
    if (Util.isNullOrNil(paramString2)) {
      localah.field_chatroomNoticeNew = 0;
    }
    localah.field_chatroomnotice = paramString2;
    localah.field_chatroomStatus = paramInt2;
    localaq.replace(localah);
    if ((Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(str)))
    {
      com.tencent.mm.kernel.h.aHH();
      paramString2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString1);
      paramLong = paramString2.hDD;
      paramString2.EA(0L);
      com.tencent.mm.kernel.h.aHH();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().au(paramString2);
      Log.i("MicroMsg.ChatroomMembersLogic", "clear room card, oldInfoId %s", new Object[] { Long.valueOf(paramLong) });
      if (paramLong != 0L) {
        ((w)com.tencent.mm.kernel.h.ae(w.class)).o(paramString1, paramLong);
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
    boolean bool = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().replace(paramah);
    if (bool) {
      aJ(paramah.field_chatroomname, paramah.field_roomowner);
    }
    AppMethodBeat.o(101755);
    return bool;
  }
  
  public static boolean a(String paramString, afp paramafp)
  {
    AppMethodBeat.i(101757);
    if ((!Pi(paramString)) || (paramafp.iWB == 0))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + paramString + "] listCnt:" + paramafp.iWB);
      AppMethodBeat.o(101757);
      return false;
    }
    aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    paramString = localaq.Rw(paramString);
    List localList = ah.bvC(paramString.field_memberlist);
    Log.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + localList.size());
    paramafp = paramafp.RIk.iterator();
    while (paramafp.hasNext()) {
      localList.remove(com.tencent.mm.platformtools.z.a(((afz)paramafp.next()).SrM));
    }
    Log.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + localList.size());
    paramafp = paramString.jw(localList);
    paramafp.field_displayname = al(localList);
    paramafp.field_memberCount = localList.size();
    boolean bool = localaq.replace(paramString);
    Log.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101757);
    return bool;
  }
  
  public static boolean a(String paramString, cs paramcs)
  {
    AppMethodBeat.i(101758);
    if ((!Pi(paramString)) || (paramcs.iWB == 0))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + paramString + "] listCnt:" + paramcs.iWB);
      AppMethodBeat.o(101758);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    bv localbv = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL();
    int i = 0;
    while (i < paramcs.iWB)
    {
      Object localObject = com.tencent.mm.platformtools.z.a(((cxa)paramcs.RIk.get(i)).SrM);
      if (((cxa)paramcs.RIk.get(i)).TFy == 0)
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
      localObject = localbv.RG((String)localObject);
      if ((int)((com.tencent.mm.contact.d)localObject).jxt != 0)
      {
        ((as)localObject).axj();
        localbv.c(((ax)localObject).field_username, (as)localObject);
      }
      for (;;)
      {
        localArrayList.add(((ax)localObject).field_username);
        break;
        localObject = a((as)localObject, (cxa)paramcs.RIk.get(i));
        localbv.av((as)localObject);
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
  
  public static boolean a(String paramString, xm paramxm)
  {
    AppMethodBeat.i(101753);
    if (paramxm == null)
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
    if (ab.Lj(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[] { paramString });
      AppMethodBeat.o(101753);
      return false;
    }
    String str = com.tencent.mm.platformtools.z.a(paramxm.SjG);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(101753);
      return false;
    }
    Log.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[] { str, Integer.valueOf(paramxm.SjE.size()) });
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(str);
    if ((paramString != null) && (paramxm.SjE.size() > 0) && (paramString.bjL().contains(((xn)paramxm.SjE.get(0)).UserName)))
    {
      str = ((xn)paramxm.SjE.get(0)).UserName;
      com.tencent.mm.k.a.a.b localb = paramString.bvz(str);
      if (localb != null)
      {
        Log.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[] { str, localb.jmB });
        localb.jmD = ((xn)paramxm.SjE.get(0)).SjL;
        a(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(101753);
        return true;
        Log.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[] { str });
      }
    }
    if ((paramString != null) && (paramxm.SjE.size() > 0))
    {
      paramString = new bh();
      paramString.fxa.username = ((xn)paramxm.SjE.get(0)).UserName;
      paramString.fxa.fxb = ((xn)paramxm.SjE.get(0)).SjL;
      lsq.put(str + "#" + paramString.fxa.username, paramString.fxa.fxb);
      EventCenter.instance.publish(paramString);
      AppMethodBeat.o(101753);
      return false;
    }
    if (paramxm.SjE.size() <= 0) {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
    }
    if (paramString != null) {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
    }
    AppMethodBeat.o(101753);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, xm paramxm, int paramInt1, int paramInt2, String paramString3, com.tencent.mm.k.a.a.a parama, IEvent paramIEvent)
  {
    AppMethodBeat.i(258997);
    if ((!paramString1.toLowerCase().endsWith("@chatroom")) && (!paramString1.toLowerCase().endsWith("@im.chatroom")) && (!paramString1.toLowerCase().endsWith("@groupcard")) && (!paramString1.toLowerCase().endsWith("@talkroom")))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] listCnt:" + paramxm.iWB);
      AppMethodBeat.o(258997);
      return false;
    }
    bv localbv = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL();
    ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString1);
    if (localah != null) {}
    ArrayList localArrayList;
    long l1;
    boolean bool1;
    xn localxn;
    as localas;
    for (parama.fMC = localah.hxE();; parama.fMC = 0)
    {
      localArrayList = new ArrayList();
      Log.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] memCnt:" + paramxm.iWB);
      l1 = System.currentTimeMillis();
      i = 0;
      bool1 = false;
      for (;;)
      {
        if (i >= paramxm.iWB) {
          break label634;
        }
        localxn = (xn)paramxm.SjE.get(i);
        localas = localbv.RG(localxn.UserName);
        if (localas != null) {
          break;
        }
        Log.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
        i += 1;
      }
    }
    com.tencent.mm.k.a.a.b localb = new com.tencent.mm.k.a.a.b();
    localb.userName = localxn.UserName;
    localb.jmD = localxn.SjL;
    localb.jmC = localxn.SjK;
    boolean bool2;
    if (paramxm.SjF == 0)
    {
      localb.jmB = localxn.SjH;
      if (!Util.isNullOrNil(localxn.SjJ))
      {
        com.tencent.mm.am.j localj = q.bhP().TS(localxn.UserName);
        localObject = localj;
        if (localj == null)
        {
          localObject = new com.tencent.mm.am.j();
          ((com.tencent.mm.am.j)localObject).username = localxn.UserName;
        }
        ((com.tencent.mm.am.j)localObject).lBe = localxn.SjI;
        ((com.tencent.mm.am.j)localObject).lBd = localxn.SjJ;
        ((com.tencent.mm.am.j)localObject).hDc = 3;
        if (Util.isNullOrNil(localxn.SjI)) {
          break label618;
        }
        bool2 = true;
        label421:
        ((com.tencent.mm.am.j)localObject).gg(bool2);
        q.bhP().b((com.tencent.mm.am.j)localObject);
      }
    }
    if (localah != null)
    {
      localObject = localah.bvz(localxn.UserName);
      if (localObject != null)
      {
        localb.jmB = ((com.tencent.mm.k.a.a.b)localObject).jmB;
        if (!Util.isNullOrNil(localb.jmD)) {
          break label624;
        }
      }
    }
    label618:
    label624:
    for (Object localObject = ((com.tencent.mm.k.a.a.b)localObject).jmD;; localObject = localb.jmD)
    {
      localb.jmD = ((String)localObject);
      parama.jmy.add(localb);
      ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bQ(localxn.SjN, localxn.SjO);
      if ((int)localas.jxt == 0)
      {
        localas.setUsername(localxn.UserName);
        if (localxn.rWI != null) {
          localas.setNickname(localxn.rWI);
        }
        localas.IB(localxn.SjN);
        localas.IA(localxn.SjO);
        localas.axj();
        localbv.av(localas);
        bool1 = true;
      }
      localArrayList.add(localas.field_username);
      break;
      bool2 = false;
      break label421;
    }
    label634:
    Log.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + localArrayList.size() + " event: " + paramIEvent + " publish: " + bool1 + " take[" + (System.currentTimeMillis() - l1) + "]ms");
    label815:
    long l2;
    if (bool1)
    {
      ay(paramString1, parama.fMC);
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString1);
      paramIEvent = (IEvent)localObject;
      if (localObject == null) {
        paramIEvent = new ah();
      }
      i = paramIEvent.field_chatroomStatus;
      l1 = System.currentTimeMillis();
      paramIEvent.field_chatroomname = paramString1;
      paramIEvent.field_roomowner = paramString2;
      localObject = paramIEvent.jw(localArrayList);
      ((ah)localObject).field_chatroomStatus = paramInt1;
      ((ah)localObject).field_displayname = al(localArrayList);
      if (paramxm.SjF == 0) {
        break label1093;
      }
      bool1 = true;
      ((ah)localObject).a(paramString3, parama, bool1).field_memberCount = localArrayList.size();
      if (paramInt2 != -1) {
        paramIEvent.field_chatroomVersion = paramInt2;
      }
      paramInt2 = paramIEvent.field_memberCount;
      if ((bcV()) && (!Util.isNullOrNil(paramString1)))
      {
        if (!MultiProcessMMKV.getMMKV("room_upgrade_to_wework").getBoolean(paramString1, false)) {
          break label1099;
        }
        Log.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString1 });
      }
      label897:
      bool1 = a(paramIEvent);
      if ((bool1) && (paramInt1 != i)) {
        ab.PU(paramString1);
      }
      l2 = System.currentTimeMillis();
      bool2 = paramIEvent.hxF();
      if (paramIEvent.hxC() != null) {
        break label1111;
      }
      paramInt2 = 0;
      label942:
      if (paramIEvent.hxC() != null) {
        break label1124;
      }
    }
    label1093:
    label1099:
    label1111:
    label1124:
    for (int i = 0;; i = paramIEvent.hxC().jmA)
    {
      Log.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s chatroomStatus:%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2 - l1), Boolean.valueOf(bool2), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt1) });
      if (paramIEvent.hxF())
      {
        Log.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[] { Integer.valueOf(paramIEvent.hxE()) });
        paramString2 = new bg();
        paramString2.fwZ.username = paramString1;
        EventCenter.instance.publish(paramString2);
      }
      AppMethodBeat.o(258997);
      return bool1;
      if (localah != null) {
        break;
      }
      ay(paramString1, 0);
      break;
      bool1 = false;
      break label815;
      a(paramString1, paramString2, paramInt2, paramInt1, null);
      break label897;
      paramInt2 = paramIEvent.hxC().fMC;
      break label942;
    }
  }
  
  public static boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    int i = 0;
    int k = 0;
    AppMethodBeat.i(101761);
    aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    ah localah = localaq.Rx(paramString1);
    if ((paramString1.endsWith("@chatroom")) || (paramString1.endsWith("@im.chatroom"))) {}
    LinkedList localLinkedList;
    int j;
    for (paramString1 = Ps(paramString1);; paramString1 = new LinkedList())
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
    paramString1 = localah.jw(localLinkedList);
    paramString1.field_displayname = al(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    boolean bool = localaq.replace(localah);
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
    paramString1 = localah.jw(localLinkedList);
    paramString1.field_displayname = al(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    localah.field_roomowner = paramString2;
    bool = localaq.replace(localah);
    Log.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101761);
    return bool;
  }
  
  private static void aA(String paramString, int paramInt)
  {
    AppMethodBeat.i(184638);
    fx localfx = new fx();
    localfx.vm(paramString);
    localfx.gBQ = paramInt;
    localfx.bpa();
    AppMethodBeat.o(184638);
  }
  
  public static String aI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101754);
    paramString1 = paramString2 + "#" + paramString1;
    if (lsq.checkAndUpTime(paramString1))
    {
      paramString1 = (String)lsq.get(paramString1);
      AppMethodBeat.o(101754);
      return paramString1;
    }
    AppMethodBeat.o(101754);
    return "";
  }
  
  private static void aJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101756);
    Log.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[] { Integer.valueOf(1) });
    bv localbv = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL();
    as localas = localbv.RG(paramString1);
    if (((int)localas.jxt != 0) && (!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(z.bcZ())))
    {
      if (!paramString2.equals(z.bcZ())) {
        break label102;
      }
      localas.rl(1);
    }
    for (;;)
    {
      localbv.c(paramString1, localas);
      AppMethodBeat.o(101756);
      return;
      label102:
      localas.rl(0);
    }
  }
  
  public static String al(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101768);
    aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    if (localaq == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
      AppMethodBeat.o(101768);
      return null;
    }
    paramString2 = localaq.Rw(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(101768);
      return null;
    }
    paramString1 = paramString2.PJ(paramString1);
    AppMethodBeat.o(101768);
    return paramString1;
  }
  
  public static String al(List<String> paramList)
  {
    AppMethodBeat.i(101747);
    paramList = e(paramList, -1);
    AppMethodBeat.o(101747);
    return paramList;
  }
  
  private static void ay(String paramString, int paramInt)
  {
    AppMethodBeat.i(258998);
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(15, null)) != 0)
    {
      com.tencent.mm.roomsdk.a.b.btX(paramString).Z(paramString, paramInt).aRu();
      AppMethodBeat.o(258998);
      return;
    }
    csj localcsj = new csj();
    localcsj.chatroomName = paramString;
    localcsj.fMC = paramInt;
    lsp.zeT.addFirst(localcsj);
    try
    {
      MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.b.aGP()).encode("detail", lsp.toByteArray());
      Log.i("MicroMsg.ChatroomMembersLogic", "getChatroomMemberDetail " + localcsj.chatroomName + " " + localcsj.fMC);
      AppMethodBeat.o(258998);
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
  
  public static void az(String paramString, int paramInt)
  {
    AppMethodBeat.i(101774);
    aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    ah localah = localaq.Rw(paramString);
    if (localah == null)
    {
      AppMethodBeat.o(101774);
      return;
    }
    com.tencent.mm.k.a.a.a locala = localah.hxJ();
    locala.type = paramInt;
    localah.a(paramString, locala, false);
    localaq.replace(localah);
    AppMethodBeat.o(101774);
  }
  
  public static void bcS()
  {
    AppMethodBeat.i(184633);
    PluginNewTips.removeLocalNewTipsCallback(com.tencent.mm.plugin.newtips.a.d.Gww);
    AppMethodBeat.o(184633);
  }
  
  public static boolean bcT()
  {
    AppMethodBeat.i(184636);
    boolean bool = MultiProcessMMKV.getMMKV("room_upgrade_to_wework").getBoolean("enter_show", false);
    AppMethodBeat.o(184636);
    return bool;
  }
  
  public static int bcU()
  {
    AppMethodBeat.i(184637);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("AssociateChatRoomLocalCheckMaxMemberCount", 200);
    AppMethodBeat.o(184637);
    return i;
  }
  
  public static boolean bcV()
  {
    AppMethodBeat.i(259029);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("MMForwardUpgradeChatRoomSwitch", 0) == 1)
    {
      AppMethodBeat.o(259029);
      return true;
    }
    AppMethodBeat.o(259029);
    return false;
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
        break label211;
      }
      localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject2);
      localObject2 = (String)localObject1 + ((as)localObject2).ays();
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
      localObject1 = (String)localObject2 + MMApplicationContext.getContext().getString(b.a.chatroom_sys_msg_invite_split);
    }
    label211:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public static boolean f(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(101743);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101743);
      return false;
    }
    Iterator localIterator = paramString.bjL().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, paramString.PJ(str));
    }
    AppMethodBeat.o(101743);
    return true;
  }
  
  public static void gb(boolean paramBoolean)
  {
    AppMethodBeat.i(258999);
    Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (lsp.zeT.isEmpty()))
    {
      AppMethodBeat.o(258999);
      return;
    }
    if ((!paramBoolean) && (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(15, null)) == 0))
    {
      AppMethodBeat.o(258999);
      return;
    }
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258868);
        Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + v.lsp.zeT.size());
        byte[] arrayOfByte;
        Object localObject;
        if (v.lsp.zeT.isEmpty())
        {
          arrayOfByte = MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.b.aGP()).decodeBytes("detail");
          if (arrayOfByte == null)
          {
            AppMethodBeat.o(258868);
            return;
          }
          localObject = new csk();
        }
        try
        {
          ((csk)localObject).parseFrom(arrayOfByte);
          v.lsp.zeT.addAll(((csk)localObject).zeT);
          if (v.lsp.zeT.isEmpty())
          {
            Log.i("MicroMsg.ChatroomMembersLogic", "getChatroomMemberDetails is null");
            AppMethodBeat.o(258868);
            return;
          }
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            Log.e("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + localIOException2.getMessage());
          }
          Log.i("MicroMsg.ChatroomMembersLogic", "start Conversation:" + v.lsp.zeT.size());
          localObject = new ArrayList();
          Iterator localIterator1 = v.lsp.zeT.iterator();
          csj localcsj;
          while (localIterator1.hasNext())
          {
            localcsj = (csj)localIterator1.next();
            if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(localcsj.chatroomName) != null)
            {
              com.tencent.mm.roomsdk.a.b.btX(localcsj.chatroomName).Z(localcsj.chatroomName, localcsj.fMC).aRu();
              ((ArrayList)localObject).add(localcsj);
              Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + localcsj.chatroomName + " " + localcsj.fMC);
            }
          }
          localIterator1 = ((ArrayList)localObject).iterator();
          while (localIterator1.hasNext())
          {
            localcsj = (csj)localIterator1.next();
            v.lsp.zeT.remove(localcsj);
          }
          Log.i("MicroMsg.ChatroomMembersLogic", "delete " + ((ArrayList)localObject).size() + " " + v.lsp.zeT.size());
          try
          {
            MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.b.aGP()).encode("detail", v.lsp.toByteArray());
            Log.i("MicroMsg.ChatroomMembersLogic", "end Conversation");
            ((ArrayList)localObject).clear();
            localIterator1 = v.lsp.zeT.iterator();
            while (localIterator1.hasNext())
            {
              localcsj = (csj)localIterator1.next();
              com.tencent.mm.roomsdk.a.b.btX(localcsj.chatroomName).Z(localcsj.chatroomName, localcsj.fMC).aRu();
              ((ArrayList)localObject).add(localcsj);
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
              localcsj = (csj)localIterator2.next();
              v.lsp.zeT.remove(localcsj);
            }
            Log.i("MicroMsg.ChatroomMembersLogic", "delete " + ((ArrayList)localObject).size() + " " + v.lsp.zeT.size());
            try
            {
              MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.b.aGP()).encode("detail", v.lsp.toByteArray());
              AppMethodBeat.o(258868);
              return;
            }
            catch (IOException localIOException1)
            {
              Log.e("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + localIOException1.getMessage());
              AppMethodBeat.o(258868);
            }
          }
        }
      }
    }, "MicroMsg.ChatroomMembersLogic");
    AppMethodBeat.o(258999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.v
 * JD-Core Version:    0.7.0.1
 */