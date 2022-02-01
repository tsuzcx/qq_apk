package com.tencent.mm.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.bn;
import com.tencent.mm.autogen.a.bo;
import com.tencent.mm.autogen.a.bo.a;
import com.tencent.mm.autogen.a.lb;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.hs;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.protocal.protobuf.dc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.protocal.protobuf.dpd;
import com.tencent.mm.protocal.protobuf.dpe;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class v
{
  public static djm ojN;
  public static com.tencent.mm.b.f<String, String> ojO;
  
  static
  {
    AppMethodBeat.i(101775);
    ojN = new djm();
    ojO = new com.tencent.mm.b.h(100);
    AppMethodBeat.o(101775);
  }
  
  public static boolean I(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(241910);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
    paramString = Il(paramString);
    if (paramString == null)
    {
      Log.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
      if (paramBoolean)
      {
        Log.w("MicroMsg.ChatroomMembersLogic", "isInChatRoom temp change");
        AppMethodBeat.o(241910);
        return true;
      }
      AppMethodBeat.o(241910);
      return false;
    }
    if ((paramString.size() == 0) || (!paramString.contains(str)))
    {
      Log.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + paramString.size() + " ");
      AppMethodBeat.o(241910);
      return false;
    }
    AppMethodBeat.o(241910);
    return true;
  }
  
  private static boolean Ib(String paramString)
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
  
  public static boolean Ic(String paramString)
  {
    AppMethodBeat.i(101742);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101742);
      return false;
    }
    boolean bool = paramString.iZn();
    AppMethodBeat.o(101742);
    return bool;
  }
  
  public static boolean Id(String paramString)
  {
    AppMethodBeat.i(101744);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jw(paramString);
    String str = z.bAM();
    if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(str)) && (paramString.equals(str)))
    {
      AppMethodBeat.o(101744);
      return true;
    }
    AppMethodBeat.o(101744);
    return false;
  }
  
  public static String Ie(String paramString)
  {
    AppMethodBeat.i(101746);
    if ((paramString == null) || (!Ib(paramString)))
    {
      AppMethodBeat.o(101746);
      return "";
    }
    List localList = Il(paramString);
    paramString = "";
    int i = 0;
    String str;
    au localau;
    if ((localList != null) && (i < localList.size()))
    {
      str = (String)localList.get(i);
      if (str.length() <= 0) {
        break label192;
      }
      localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str);
      if (localau == null)
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
      str = paramString + localau.aSU();
      break label111;
      AppMethodBeat.o(101746);
      return paramString;
    }
  }
  
  public static boolean If(String paramString)
  {
    AppMethodBeat.i(101749);
    boolean bool = I(paramString, false);
    AppMethodBeat.o(101749);
    return bool;
  }
  
  public static boolean Ig(String paramString)
  {
    AppMethodBeat.i(101750);
    if (!au.bwE(paramString))
    {
      AppMethodBeat.o(101750);
      return false;
    }
    if (!((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jz(paramString))
    {
      Log.d("MicroMsg.ChatroomMembersLogic", "state is die");
      AppMethodBeat.o(101750);
      return true;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jy(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(101750);
      return true;
    }
    AppMethodBeat.o(101750);
    return false;
  }
  
  public static boolean Ih(String paramString)
  {
    AppMethodBeat.i(101751);
    if (!au.bwE(paramString))
    {
      AppMethodBeat.o(101751);
      return false;
    }
    Log.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[] { paramString });
    ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    paramString = localar.Ju(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101751);
      return false;
    }
    paramString.field_roomflag = 1;
    boolean bool = localar.replace(paramString);
    AppMethodBeat.o(101751);
    return bool;
  }
  
  public static boolean Ii(String paramString)
  {
    AppMethodBeat.i(101759);
    if (!paramString.toLowerCase().endsWith("@groupcard"))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + paramString + "]");
      AppMethodBeat.o(101759);
      return false;
    }
    bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
    if (localbx.bxy(paramString)) {
      localbx.bxC(paramString);
    }
    for (;;)
    {
      boolean bool = Ik(paramString);
      AppMethodBeat.o(101759);
      return bool;
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + paramString + "]");
    }
  }
  
  public static boolean Ij(String paramString)
  {
    AppMethodBeat.i(101760);
    if (!Ib(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + paramString + "]");
      AppMethodBeat.o(101760);
      return false;
    }
    bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
    if (localbx.bxy(paramString)) {
      localbx.bxC(paramString);
    }
    for (;;)
    {
      boolean bool = Ik(paramString);
      AppMethodBeat.o(101760);
      return bool;
      Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + paramString + "]");
    }
  }
  
  private static boolean Ik(String paramString)
  {
    AppMethodBeat.i(101762);
    boolean bool = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().JA(paramString);
    AppMethodBeat.o(101762);
    return bool;
  }
  
  public static List<String> Il(String paramString)
  {
    AppMethodBeat.i(101763);
    if (paramString == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
      AppMethodBeat.o(101763);
      return null;
    }
    if (!Ib(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + paramString + "]");
      AppMethodBeat.o(101763);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jy(paramString);
    AppMethodBeat.o(101763);
    return paramString;
  }
  
  public static List<String> Im(String paramString)
  {
    AppMethodBeat.i(101764);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101764);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jy(paramString);
    AppMethodBeat.o(101764);
    return paramString;
  }
  
  public static List<String> Io(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(101766);
    if (!Ib(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101766);
      return null;
    }
    paramString = Il(paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      AppMethodBeat.o(101766);
      return null;
    }
    String str = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
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
  
  public static String Ip(String paramString)
  {
    AppMethodBeat.i(101769);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101769);
      return null;
    }
    paramString = paramString.field_chatroomnotice;
    AppMethodBeat.o(101769);
    return paramString;
  }
  
  public static boolean Iq(String paramString)
  {
    AppMethodBeat.i(241959);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo member is null");
      AppMethodBeat.o(241959);
      return false;
    }
    Log.i("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo old:%s new:%s", new Object[] { Integer.valueOf(paramString.field_oldChatroomVersion), Integer.valueOf(paramString.field_chatroomVersion) });
    if (paramString.field_oldChatroomVersion < paramString.field_chatroomVersion)
    {
      AppMethodBeat.o(241959);
      return true;
    }
    AppMethodBeat.o(241959);
    return false;
  }
  
  public static String Ir(String paramString)
  {
    AppMethodBeat.i(101771);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101771);
      return null;
    }
    paramString = paramString.field_chatroomnoticeEditor;
    AppMethodBeat.o(101771);
    return paramString;
  }
  
  public static long Is(String paramString)
  {
    AppMethodBeat.i(101772);
    long l = System.currentTimeMillis() / 1000L;
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
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
  
  public static void It(String paramString)
  {
    AppMethodBeat.i(241963);
    ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    paramString = localar.Ju(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(241963);
      return;
    }
    if (paramString.field_chatroomNoticeNew != 0)
    {
      paramString.field_chatroomNoticeNew = 0;
      localar.replace(paramString);
    }
    AppMethodBeat.o(241963);
  }
  
  public static void Iu(String paramString)
  {
    AppMethodBeat.i(241978);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail username is null");
      AppMethodBeat.o(241978);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
    if (localObject != null) {
      if (((aj)localObject).field_oldChatroomVersion >= ((aj)localObject).field_chatroomVersion) {
        break label122;
      }
    }
    label122:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail() %s update, stack:%s", new Object[] { paramString, Util.getStack().toString() });
        localObject = new lb();
        ((lb)localObject).hML.hMM = paramString;
        ((lb)localObject).publish();
      }
      AppMethodBeat.o(241978);
      return;
    }
  }
  
  public static boolean Iv(String paramString)
  {
    AppMethodBeat.i(241981);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "username is null ");
      AppMethodBeat.o(241981);
      return false;
    }
    paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if ((paramString != null) && (paramString.aMt()))
    {
      AppMethodBeat.o(241981);
      return true;
    }
    AppMethodBeat.o(241981);
    return false;
  }
  
  public static boolean Iw(String paramString)
  {
    label144:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(241984);
        if ((au.bwE(paramString)) && (((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alQ(paramString)))
        {
          bool1 = true;
          if ((au.bwE(paramString)) && (!I(paramString, false)))
          {
            bool2 = true;
            Log.i("MicroMsg.ChatroomMembersLogic", "isChatroomDismiss = " + bool1 + ", inChatRoom = " + bool2);
            if (bool1) {
              break label144;
            }
            if (!bool2) {
              continue;
            }
            break label144;
            if (i == 0) {
              continue;
            }
            AppMethodBeat.o(241984);
            bool1 = true;
            return bool1;
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        boolean bool2 = false;
        continue;
        int i = 0;
        continue;
        AppMethodBeat.o(241984);
        boolean bool1 = false;
        continue;
        i = 1;
      }
      finally {}
    }
  }
  
  public static au a(au paramau, dof paramdof)
  {
    AppMethodBeat.i(101767);
    paramau.setUsername(com.tencent.mm.platformtools.w.a(paramdof.ZqQ));
    paramau.setNickname(com.tencent.mm.platformtools.w.a(paramdof.ZqQ));
    paramau.AY(com.tencent.mm.platformtools.w.a(paramdof.ZqQ));
    paramau.AZ(com.tencent.mm.platformtools.w.a(paramdof.ZpY));
    paramau.pv(paramdof.pSf);
    paramau.AW(com.tencent.mm.platformtools.w.a(paramdof.aaVg));
    paramau.Bc(com.tencent.mm.platformtools.w.a(paramdof.aaVh));
    paramau.Bb(com.tencent.mm.platformtools.w.a(paramdof.ZpY));
    paramau.py(paramdof.Zpe);
    paramau.pA(paramdof.pSj);
    paramau.Bu(RegionCodeDecoder.bI(paramdof.pSo, paramdof.pSg, paramdof.pSh));
    paramau.Bo(paramdof.pSi);
    AppMethodBeat.o(101767);
    return paramau;
  }
  
  public static String a(List<String> paramList, int paramInt, String paramString)
  {
    AppMethodBeat.i(241898);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(241898);
      return "";
    }
    Object localObject1 = "";
    int i = 0;
    Object localObject2 = localObject1;
    if (i < paramList.size())
    {
      localObject2 = (String)paramList.get(i);
      if (((String)localObject2).length() <= 0) {
        break label250;
      }
      localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject2);
      localObject2 = (String)localObject1 + ((au)localObject2).aSV();
      if ((i == paramInt - 1) && (i < paramList.size())) {
        localObject2 = (String)localObject2 + "...";
      }
    }
    else
    {
      if ((!Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil(paramString)) || (!Iw(paramString))) {
        break label241;
      }
      paramList = bAE();
      AppMethodBeat.o(241898);
      return paramList;
    }
    localObject1 = localObject2;
    if (i < paramList.size() - 1) {
      localObject1 = (String)localObject2 + MMApplicationContext.getContext().getString(b.a.chatroom_sys_msg_invite_split);
    }
    label241:
    label250:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(241898);
      return localObject2;
    }
  }
  
  public static void a(String paramString, int paramInt, au paramau)
  {
    AppMethodBeat.i(241883);
    dpe localdpe = new dpe();
    localdpe.YFn = new etl().btH(paramString);
    localdpe.aWG = paramInt;
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(74, localdpe));
    if ((paramau != null) && (!TextUtils.isEmpty(paramau.field_username))) {
      ab.N(paramau);
    }
    AppMethodBeat.o(241883);
  }
  
  public static void a(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184634);
    if (!bAI())
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
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
    if (localaj == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member is null", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    a(paramString, localaj.field_roomowner, localaj.field_memberCount, localaj.field_chatroomStatus, parama);
    AppMethodBeat.o(184634);
  }
  
  public static void a(String paramString, aj paramaj, boolean paramBoolean)
  {
    AppMethodBeat.i(101745);
    paramaj.KD(paramBoolean);
    ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().update(paramaj, new String[0]);
    paramaj = z.bAM();
    com.tencent.mm.roomsdk.model.b.btW(paramString).b(paramString, paramaj, paramBoolean).blj();
    dpd localdpd = new dpd();
    localdpd.YFk = paramString;
    localdpd.UserName = paramaj;
    localdpd.aaVJ = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localdpd.OzH = i;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(49, localdpd));
      AppMethodBeat.o(101745);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, PluginNewTips.a parama)
  {
    int i = 1;
    AppMethodBeat.i(184635);
    int j;
    if ((au.bwG(paramString1)) && ((paramInt2 & 0x20000) != 131072L) && ((paramInt2 & 0x10000) == 65536L))
    {
      MultiProcessMMKV.getMMKV("room_upgrade_to_wework").putBoolean(paramString1, true);
      boolean bool = com.tencent.mm.openim.room.a.a.bSp();
      j = bAH();
      Log.i("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom chatRoomName:%s chatroomOwner:%s chatroomStatus:%s isInstallWeWork:%s maxNum:%s", new Object[] { paramString1, Util.nullAs(paramString2, "null"), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((bool) && (paramInt1 < j) && (Util.isEqual(paramString2, z.bAM())))
      {
        com.tencent.mm.plugin.newtips.a.gtf();
        com.tencent.mm.plugin.newtips.a.i.b(com.tencent.mm.plugin.newtips.a.d.Msv, parama);
        MultiProcessMMKV.getMMKV("room_upgrade_to_wework").putBoolean("enter_show", true);
        parama = MMApplicationContext.getResources().getString(b.a.chatroom_sys_msg_room_upgrade_to_wework_msg);
        String str = MMApplicationContext.getResources().getString(b.a.chatroom_sys_msg_room_upgrade_to_wework_url_tips);
        paramString2 = new StringBuffer();
        paramString2.append(parama).append(" ");
        paramString2.append("<_wc_custom_link_ href=\"weixin://weixingroupupdate?roomname=").append(paramString1).append("\">").append(str).append("</_wc_custom_link_>");
        parama = new cc();
        parama.pI(0);
        parama.BS(paramString1);
        parama.setStatus(3);
        parama.setContent(paramString2.toString());
        parama.setCreateTime(br.D(paramString1, System.currentTimeMillis() / 1000L));
        parama.setType(10000);
        parama.setFlag(parama.field_flag | 0x8);
        br.B(parama);
        aM(paramString1, 0);
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
      if (!Util.isEqual(paramString2, z.bAM())) {
        paramInt2 = i | 0x2;
      }
      i = paramInt2;
      if (paramInt1 >= j) {
        i = paramInt2 | 0x4;
      }
      aM(paramString1, i);
      AppMethodBeat.o(184635);
      return;
      label372:
      i = 0;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101773);
    ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    aj localaj = localar.Ju(paramString1);
    if (localaj == null)
    {
      AppMethodBeat.o(101773);
      return;
    }
    String str = localaj.field_chatroomnotice;
    localaj.field_oldChatroomVersion = paramInt1;
    localaj.field_chatroomnoticePublishTime = paramLong;
    localaj.field_chatroomnoticeEditor = paramString3;
    if (Util.isNullOrNil(paramString2)) {
      localaj.field_chatroomNoticeNew = 0;
    }
    localaj.field_chatroomnotice = paramString2;
    localaj.field_chatroomStatus = paramInt2;
    localar.replace(localaj);
    if ((Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(str)))
    {
      com.tencent.mm.kernel.h.baF();
      paramString2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString1);
      paramLong = paramString2.kay;
      paramString2.gQ(0L);
      com.tencent.mm.kernel.h.baF();
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().aA(paramString2);
      Log.i("MicroMsg.ChatroomMembersLogic", "clear room card, oldInfoId %s", new Object[] { Long.valueOf(paramLong) });
      if (paramLong != 0L) {
        ((com.tencent.mm.plugin.messenger.foundation.a.w)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.w.class)).p(paramString1, paramLong);
      }
    }
    AppMethodBeat.o(101773);
  }
  
  public static boolean a(aj paramaj)
  {
    AppMethodBeat.i(101755);
    if (paramaj == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
      AppMethodBeat.o(101755);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().replace(paramaj);
    if (bool) {
      aT(paramaj.field_chatroomname, paramaj.field_roomowner);
    }
    AppMethodBeat.o(101755);
    return bool;
  }
  
  public static boolean a(String paramString, aic paramaic)
  {
    AppMethodBeat.i(101757);
    if ((!Ib(paramString)) || (paramaic.lyF == 0))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + paramString + "] listCnt:" + paramaic.lyF);
      AppMethodBeat.o(101757);
      return false;
    }
    ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    aj localaj = localar.Ju(paramString);
    List localList = aj.bvM(localaj.field_memberlist);
    Log.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + localList.size());
    paramaic = paramaic.YFm.iterator();
    while (paramaic.hasNext()) {
      localList.remove(com.tencent.mm.platformtools.w.a(((aim)paramaic.next()).ZqQ));
    }
    Log.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + localList.size());
    paramaic = localaj.mI(localList);
    paramaic.field_displayname = e(localList, paramString);
    paramaic.field_memberCount = localList.size();
    boolean bool = localar.replace(localaj);
    Log.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101757);
    return bool;
  }
  
  public static boolean a(String paramString, dc paramdc)
  {
    AppMethodBeat.i(101758);
    if ((!Ib(paramString)) || (paramdc.lyF == 0))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + paramString + "] listCnt:" + paramdc.lyF);
      AppMethodBeat.o(101758);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
    int i = 0;
    while (i < paramdc.lyF)
    {
      Object localObject = com.tencent.mm.platformtools.w.a(((dof)paramdc.YFm.get(i)).ZqQ);
      if (((dof)paramdc.YFm.get(i)).aaVf == 0)
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
      localObject = localbx.JE((String)localObject);
      if ((int)((com.tencent.mm.contact.d)localObject).maN != 0)
      {
        ((au)localObject).aRJ();
        localbx.d(((az)localObject).field_username, (au)localObject);
      }
      for (;;)
      {
        localArrayList.add(((az)localObject).field_username);
        break;
        localObject = a((au)localObject, (dof)paramdc.YFm.get(i));
        localbx.aB((au)localObject);
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
  
  public static boolean a(String paramString, dph paramdph)
  {
    AppMethodBeat.i(241938);
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
    if ((localaj != null) && (paramdph != null) && (localaj.field_chatroomStatus != paramdph.aaWd) && (paramString.equals(com.tencent.mm.platformtools.w.a(paramdph.ZqL))) && ((paramdph.aaWd & 0x2) == 2L))
    {
      Log.i("MicroMsg.ChatroomMembersLogic", "updateChatroomStatus, cmdMC.ChatroomStatus = " + paramdph.aaWd + ", member.getChatroomStatus() = " + localaj.field_chatroomStatus);
      AppMethodBeat.o(241938);
      return true;
    }
    AppMethodBeat.o(241938);
    return false;
  }
  
  public static boolean a(String paramString, zg paramzg)
  {
    AppMethodBeat.i(101753);
    if (paramzg == null)
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
    if (au.bwE(paramString))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[] { paramString });
      AppMethodBeat.o(101753);
      return false;
    }
    String str = com.tencent.mm.platformtools.w.a(paramzg.ZhM);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(101753);
      return false;
    }
    Log.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[] { str, Integer.valueOf(paramzg.ZhK.size()) });
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(str);
    if ((paramString != null) && (paramzg.ZhK.size() > 0) && (paramString.bHw().contains(((zh)paramzg.ZhK.get(0)).UserName)))
    {
      str = ((zh)paramzg.ZhK.get(0)).UserName;
      com.tencent.mm.h.a.a.b localb = paramString.bvJ(str);
      if (localb != null)
      {
        Log.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[] { str, localb.displayName });
        localb.lPO = ((zh)paramzg.ZhK.get(0)).ZhR;
        a(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(101753);
        return true;
        Log.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[] { str });
      }
    }
    if ((paramString != null) && (paramzg.ZhK.size() > 0))
    {
      paramString = new bo();
      paramString.hBC.username = ((zh)paramzg.ZhK.get(0)).UserName;
      paramString.hBC.hBD = ((zh)paramzg.ZhK.get(0)).ZhR;
      ojO.put(str + "#" + paramString.hBC.username, paramString.hBC.hBD);
      paramString.publish();
      AppMethodBeat.o(101753);
      return false;
    }
    if (paramzg.ZhK.size() <= 0) {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
    }
    if (paramString != null) {
      Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
    }
    AppMethodBeat.o(101753);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, zg paramzg, int paramInt1, int paramInt2, String paramString3, com.tencent.mm.h.a.a.a parama, IEvent paramIEvent)
  {
    AppMethodBeat.i(241926);
    if ((!paramString1.toLowerCase().endsWith("@chatroom")) && (!paramString1.toLowerCase().endsWith("@im.chatroom")) && (!paramString1.toLowerCase().endsWith("@groupcard")) && (!paramString1.toLowerCase().endsWith("@talkroom")))
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] listCnt:" + paramzg.lyF);
      AppMethodBeat.o(241926);
      return false;
    }
    bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString1);
    if (localaj != null) {}
    ArrayList localArrayList;
    long l1;
    boolean bool1;
    zh localzh;
    au localau;
    for (parama.hSm = localaj.iZi();; parama.hSm = 0)
    {
      localArrayList = new ArrayList();
      Log.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] memCnt:" + paramzg.lyF);
      l1 = System.currentTimeMillis();
      i = 0;
      bool1 = false;
      for (;;)
      {
        if (i >= paramzg.lyF) {
          break label633;
        }
        localzh = (zh)paramzg.ZhK.get(i);
        localau = localbx.JE(localzh.UserName);
        if (localau != null) {
          break;
        }
        Log.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
        i += 1;
      }
    }
    com.tencent.mm.h.a.a.b localb = new com.tencent.mm.h.a.a.b();
    localb.userName = localzh.UserName;
    localb.lPO = localzh.ZhR;
    localb.lPN = localzh.ZhQ;
    boolean bool2;
    if (paramzg.ZhL == 0)
    {
      localb.displayName = localzh.ZhN;
      if (!Util.isNullOrNil(localzh.ZhP))
      {
        com.tencent.mm.modelavatar.j localj = q.bFE().LS(localzh.UserName);
        localObject = localj;
        if (localj == null)
        {
          localObject = new com.tencent.mm.modelavatar.j();
          ((com.tencent.mm.modelavatar.j)localObject).username = localzh.UserName;
        }
        ((com.tencent.mm.modelavatar.j)localObject).osN = localzh.ZhO;
        ((com.tencent.mm.modelavatar.j)localObject).osM = localzh.ZhP;
        ((com.tencent.mm.modelavatar.j)localObject).jZY = 3;
        if (Util.isNullOrNil(localzh.ZhO)) {
          break label617;
        }
        bool2 = true;
        label420:
        ((com.tencent.mm.modelavatar.j)localObject).gX(bool2);
        q.bFE().b((com.tencent.mm.modelavatar.j)localObject);
      }
    }
    if (localaj != null)
    {
      localObject = localaj.bvJ(localzh.UserName);
      if (localObject != null)
      {
        localb.displayName = ((com.tencent.mm.h.a.a.b)localObject).displayName;
        if (!Util.isNullOrNil(localb.lPO)) {
          break label623;
        }
      }
    }
    label617:
    label623:
    for (Object localObject = ((com.tencent.mm.h.a.a.b)localObject).lPO;; localObject = localb.lPO)
    {
      localb.lPO = ((String)localObject);
      parama.lPK.add(localb);
      ((e)com.tencent.mm.kernel.h.ax(e.class)).cb(localzh.ZhT, localzh.ZhU);
      if ((int)localau.maN == 0)
      {
        localau.setUsername(localzh.UserName);
        if (localzh.vhX != null) {
          localau.setNickname(localzh.vhX);
        }
        localau.Bg(localzh.ZhT);
        localau.Bf(localzh.ZhU);
        localau.aRJ();
        localbx.aB(localau);
        bool1 = true;
      }
      localArrayList.add(localau.field_username);
      break;
      bool2 = false;
      break label420;
    }
    label633:
    Log.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + localArrayList.size() + " event: " + paramIEvent + " publish: " + bool1 + " take[" + (System.currentTimeMillis() - l1) + "]ms");
    label817:
    long l2;
    if (bool1)
    {
      aK(paramString1, parama.hSm);
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString1);
      paramIEvent = (IEvent)localObject;
      if (localObject == null) {
        paramIEvent = new aj();
      }
      i = paramIEvent.field_chatroomStatus;
      l1 = System.currentTimeMillis();
      if ((paramInt1 & 0x2) != 2L) {
        break label1124;
      }
      paramIEvent.field_chatroomname = paramString1;
      paramIEvent.field_roomowner = paramString2;
      localObject = paramIEvent.mI(localArrayList);
      ((aj)localObject).field_chatroomStatus = paramInt1;
      if (paramzg.ZhL == 0) {
        break label1118;
      }
      bool1 = true;
      ((aj)localObject).a(paramString3, parama, bool1).field_memberCount = localArrayList.size();
      if (Util.isNullOrNil(paramIEvent.getDisplayName(paramString1))) {
        paramIEvent.field_selfDisplayName = bAE();
      }
      if (paramInt2 != -1) {
        paramIEvent.field_chatroomVersion = paramInt2;
      }
      paramInt2 = paramIEvent.field_memberCount;
      if ((bAI()) && (!Util.isNullOrNil(paramString1)))
      {
        if (!MultiProcessMMKV.getMMKV("room_upgrade_to_wework").getBoolean(paramString1, false)) {
          break label1200;
        }
        Log.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString1 });
      }
      label919:
      bool1 = a(paramIEvent);
      if ((bool1) && (paramInt1 != i)) {
        ab.IJ(paramString1);
      }
      l2 = System.currentTimeMillis();
      bool2 = paramIEvent.iZj();
      if (paramIEvent.iZg() != null) {
        break label1212;
      }
      paramInt2 = 0;
      label964:
      if (paramIEvent.iZg() != null) {
        break label1225;
      }
    }
    label1200:
    label1212:
    label1225:
    for (int i = 0;; i = paramIEvent.iZg().lPM)
    {
      Log.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s chatroomStatus:%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2 - l1), Boolean.valueOf(bool2), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt1) });
      if (paramIEvent.iZj())
      {
        Log.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[] { Integer.valueOf(paramIEvent.iZi()) });
        paramString2 = new bn();
        paramString2.hBB.username = paramString1;
        paramString2.publish();
      }
      AppMethodBeat.o(241926);
      return bool1;
      if ((localaj != null) && (!aj.iZk())) {
        break;
      }
      aK(paramString1, 0);
      break;
      label1118:
      bool1 = false;
      break label817;
      label1124:
      paramIEvent.field_chatroomname = paramString1;
      paramIEvent.field_roomowner = paramString2;
      localObject = paramIEvent.mI(localArrayList);
      ((aj)localObject).field_chatroomStatus = paramInt1;
      ((aj)localObject).field_displayname = n(localArrayList, -1);
      if (paramzg.ZhL != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        ((aj)localObject).a(paramString3, parama, bool1).field_memberCount = localArrayList.size();
        break;
      }
      a(paramString1, paramString2, paramInt2, paramInt1, null);
      break label919;
      paramInt2 = paramIEvent.iZg().hSm;
      break label964;
    }
  }
  
  public static boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    int i = 0;
    int k = 0;
    AppMethodBeat.i(101761);
    ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    aj localaj = localar.Jv(paramString1);
    if ((paramString1.endsWith("@chatroom")) || (paramString1.endsWith("@im.chatroom"))) {}
    LinkedList localLinkedList;
    int j;
    for (Object localObject = Il(paramString1);; localObject = new LinkedList())
    {
      localLinkedList = new LinkedList();
      if (localObject == null) {
        break label242;
      }
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= ((List)localObject).size()) {
          break;
        }
        localLinkedList.add((String)((List)localObject).get(i));
        i += 1;
      }
    }
    while (j < paramArrayList.size())
    {
      if (!((List)localObject).contains(paramArrayList.get(j))) {
        localLinkedList.add((String)paramArrayList.get(j));
      }
      j += 1;
    }
    if (!Util.isNullOrNil(paramString2)) {
      localaj.field_roomowner = paramString2;
    }
    paramArrayList = localaj.mI(localLinkedList);
    paramArrayList.field_displayname = e(localLinkedList, paramString1);
    paramArrayList.field_memberCount = localLinkedList.size();
    boolean bool = localar.replace(localaj);
    AppMethodBeat.o(101761);
    return bool;
    label242:
    while (i < paramArrayList.size())
    {
      localLinkedList.add((String)paramArrayList.get(i));
      i += 1;
    }
    if (!Util.isNullOrNil(paramString2)) {
      localaj.field_roomowner = paramString2;
    }
    paramArrayList = localaj.mI(localLinkedList);
    paramArrayList.field_displayname = e(localLinkedList, paramString1);
    paramArrayList.field_memberCount = localLinkedList.size();
    localaj.field_roomowner = paramString2;
    bool = localar.replace(localaj);
    Log.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101761);
    return bool;
  }
  
  private static void aK(String paramString, int paramInt)
  {
    AppMethodBeat.i(241931);
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(15, null)) != 0)
    {
      com.tencent.mm.roomsdk.model.b.btW(paramString).ai(paramString, paramInt).blj();
      AppMethodBeat.o(241931);
      return;
    }
    djl localdjl = new djl();
    localdjl.chatroomName = paramString;
    localdjl.hSm = paramInt;
    ojN.EbY.addFirst(localdjl);
    try
    {
      MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.b.aZP()).encode("detail", ojN.toByteArray());
      Log.i("MicroMsg.ChatroomMembersLogic", "getChatroomMemberDetail " + localdjl.chatroomName + " " + localdjl.hSm);
      AppMethodBeat.o(241931);
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
  
  public static void aL(String paramString, int paramInt)
  {
    AppMethodBeat.i(101774);
    ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    aj localaj = localar.Ju(paramString);
    if (localaj == null)
    {
      AppMethodBeat.o(101774);
      return;
    }
    com.tencent.mm.h.a.a.a locala = localaj.iZo();
    locala.type = paramInt;
    localaj.a(paramString, locala, false);
    localar.replace(localaj);
    AppMethodBeat.o(101774);
  }
  
  private static void aM(String paramString, int paramInt)
  {
    AppMethodBeat.i(184638);
    hs localhs = new hs();
    localhs.rG(paramString);
    localhs.iOR = paramInt;
    localhs.bMH();
    AppMethodBeat.o(184638);
  }
  
  public static String aS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101754);
    paramString1 = paramString2 + "#" + paramString1;
    if (ojO.checkAndUpTime(paramString1))
    {
      paramString1 = (String)ojO.get(paramString1);
      AppMethodBeat.o(101754);
      return paramString1;
    }
    AppMethodBeat.o(101754);
    return "";
  }
  
  private static void aT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101756);
    Log.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[] { Integer.valueOf(1) });
    bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
    au localau = localbx.JE(paramString1);
    if (((int)localau.maN != 0) && (!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(z.bAM())))
    {
      if (!paramString2.equals(z.bAM())) {
        break label102;
      }
      localau.rt(1);
    }
    for (;;)
    {
      localbx.d(paramString1, localau);
      AppMethodBeat.o(101756);
      return;
      label102:
      localau.rt(0);
    }
  }
  
  public static String aq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101768);
    ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    if (localar == null)
    {
      Log.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
      AppMethodBeat.o(101768);
      return null;
    }
    paramString2 = localar.Ju(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(101768);
      return null;
    }
    paramString1 = paramString2.getDisplayName(paramString1);
    AppMethodBeat.o(101768);
    return paramString1;
  }
  
  public static String bAE()
  {
    AppMethodBeat.i(241890);
    String str = MMApplicationContext.getContext().getResources().getString(b.a.address_chatroom_contact_nick);
    AppMethodBeat.o(241890);
    return str;
  }
  
  public static void bAF()
  {
    AppMethodBeat.i(184633);
    PluginNewTips.removeLocalNewTipsCallback(com.tencent.mm.plugin.newtips.a.d.Msv);
    AppMethodBeat.o(184633);
  }
  
  public static boolean bAG()
  {
    AppMethodBeat.i(184636);
    boolean bool = MultiProcessMMKV.getMMKV("room_upgrade_to_wework").getBoolean("enter_show", false);
    AppMethodBeat.o(184636);
    return bool;
  }
  
  public static int bAH()
  {
    AppMethodBeat.i(184637);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("AssociateChatRoomLocalCheckMaxMemberCount", 200);
    AppMethodBeat.o(184637);
    return i;
  }
  
  public static boolean bAI()
  {
    AppMethodBeat.i(241976);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("MMForwardUpgradeChatRoomSwitch", 0) == 1)
    {
      AppMethodBeat.o(241976);
      return true;
    }
    AppMethodBeat.o(241976);
    return false;
  }
  
  public static String e(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(241888);
    paramList = n(paramList, -1);
    if ((Util.isNullOrNil(paramList)) && (Iw(paramString)))
    {
      paramList = bAE();
      AppMethodBeat.o(241888);
      return paramList;
    }
    AppMethodBeat.o(241888);
    return paramList;
  }
  
  public static boolean f(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(101743);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101743);
      return false;
    }
    Iterator localIterator = paramString.bHw().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, paramString.getDisplayName(str));
    }
    AppMethodBeat.o(101743);
    return true;
  }
  
  public static void gS(boolean paramBoolean)
  {
    AppMethodBeat.i(241932);
    Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (ojN.EbY.isEmpty()))
    {
      AppMethodBeat.o(241932);
      return;
    }
    if ((!paramBoolean) && (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(15, null)) == 0))
    {
      AppMethodBeat.o(241932);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(242022);
        Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + v.ojN.EbY.size());
        byte[] arrayOfByte;
        Object localObject;
        if (v.ojN.EbY.isEmpty())
        {
          arrayOfByte = MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.b.aZP()).decodeBytes("detail");
          if (arrayOfByte == null)
          {
            AppMethodBeat.o(242022);
            return;
          }
          localObject = new djm();
        }
        try
        {
          ((djm)localObject).parseFrom(arrayOfByte);
          v.ojN.EbY.addAll(((djm)localObject).EbY);
          if (v.ojN.EbY.isEmpty())
          {
            Log.i("MicroMsg.ChatroomMembersLogic", "getChatroomMemberDetails is null");
            AppMethodBeat.o(242022);
            return;
          }
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            Log.e("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + localIOException2.getMessage());
          }
          Log.i("MicroMsg.ChatroomMembersLogic", "start Conversation:" + v.ojN.EbY.size());
          localObject = new ArrayList();
          Iterator localIterator1 = v.ojN.EbY.iterator();
          djl localdjl;
          while (localIterator1.hasNext())
          {
            localdjl = (djl)localIterator1.next();
            if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(localdjl.chatroomName) != null)
            {
              com.tencent.mm.roomsdk.model.b.btW(localdjl.chatroomName).ai(localdjl.chatroomName, localdjl.hSm).blj();
              ((ArrayList)localObject).add(localdjl);
              Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + localdjl.chatroomName + " " + localdjl.hSm);
            }
          }
          localIterator1 = ((ArrayList)localObject).iterator();
          while (localIterator1.hasNext())
          {
            localdjl = (djl)localIterator1.next();
            v.ojN.EbY.remove(localdjl);
          }
          Log.i("MicroMsg.ChatroomMembersLogic", "delete " + ((ArrayList)localObject).size() + " " + v.ojN.EbY.size());
          try
          {
            MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.b.aZP()).encode("detail", v.ojN.toByteArray());
            Log.i("MicroMsg.ChatroomMembersLogic", "end Conversation");
            ((ArrayList)localObject).clear();
            localIterator1 = v.ojN.EbY.iterator();
            while (localIterator1.hasNext())
            {
              localdjl = (djl)localIterator1.next();
              com.tencent.mm.roomsdk.model.b.btW(localdjl.chatroomName).ai(localdjl.chatroomName, localdjl.hSm).blj();
              ((ArrayList)localObject).add(localdjl);
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
              localdjl = (djl)localIterator2.next();
              v.ojN.EbY.remove(localdjl);
            }
            Log.i("MicroMsg.ChatroomMembersLogic", "delete " + ((ArrayList)localObject).size() + " " + v.ojN.EbY.size());
            try
            {
              MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.b.aZP()).encode("detail", v.ojN.toByteArray());
              AppMethodBeat.o(242022);
              return;
            }
            catch (IOException localIOException1)
            {
              Log.e("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + localIOException1.getMessage());
              AppMethodBeat.o(242022);
            }
          }
        }
      }
    }, "MicroMsg.ChatroomMembersLogic");
    AppMethodBeat.o(241932);
  }
  
  public static int getMembersCountByChatRoomName(String paramString)
  {
    AppMethodBeat.i(101765);
    long l = System.currentTimeMillis();
    try
    {
      ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
      if (localar != null)
      {
        int i = localar.JB(paramString);
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
  
  public static String n(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(101748);
    paramList = a(paramList, paramInt, "");
    AppMethodBeat.o(101748);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.v
 * JD-Core Version:    0.7.0.1
 */