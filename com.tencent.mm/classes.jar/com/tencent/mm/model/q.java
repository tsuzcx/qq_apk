package com.tencent.mm.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.p;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.bb.a;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.b.a.cj;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.plugin.newtips.a.d;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.ck;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class q
{
  public static f<String, String> hET;
  
  static
  {
    AppMethodBeat.i(101775);
    hET = new h(100);
    AppMethodBeat.o(101775);
  }
  
  public static boolean B(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219245);
    String str = (String)g.ajC().ajl().get(2, null);
    paramString = yQ(paramString);
    if (paramString == null)
    {
      ad.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
      if (paramBoolean)
      {
        ad.w("MicroMsg.ChatroomMembersLogic", "isInChatRoom temp change");
        AppMethodBeat.o(219245);
        return true;
      }
      AppMethodBeat.o(219245);
      return false;
    }
    if ((paramString.size() == 0) || (!paramString.contains(str)))
    {
      ad.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + paramString.size() + " ");
      AppMethodBeat.o(219245);
      return false;
    }
    AppMethodBeat.o(219245);
    return true;
  }
  
  public static am a(am paramam, byt parambyt)
  {
    AppMethodBeat.i(101767);
    paramam.setUsername(z.a(parambyt.Gcd));
    paramam.sT(z.a(parambyt.Gcd));
    paramam.sU(z.a(parambyt.Gcd));
    paramam.sV(z.a(parambyt.Gbs));
    paramam.kf(parambyt.jdc);
    paramam.sR(z.a(parambyt.GTS));
    paramam.sY(z.a(parambyt.GTT));
    paramam.sX(z.a(parambyt.Gbs));
    paramam.kh(parambyt.GaH);
    paramam.kj(parambyt.jdg);
    paramam.tq(RegionCodeDecoder.bf(parambyt.jdl, parambyt.jdd, parambyt.jde));
    paramam.tk(parambyt.jdf);
    AppMethodBeat.o(101767);
    return paramam;
  }
  
  public static void a(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184634);
    if (!aAi())
    {
      AppMethodBeat.o(184634);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184634);
      return;
    }
    if (ax.aQz("room_upgrade_to_wework").getBoolean(paramString, false))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    ab localab = ((c)g.ab(c.class)).azz().AN(paramString);
    if (localab == null)
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member is null", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    a(paramString, localab.field_roomowner, localab.field_memberCount, localab.field_chatroomStatus, parama);
    AppMethodBeat.o(184634);
  }
  
  public static void a(String paramString, ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(101745);
    paramab.wO(paramBoolean);
    ((c)g.ab(c.class)).azz().update(paramab, new String[0]);
    paramab = u.aAm();
    com.tencent.mm.roomsdk.a.b.aPF(paramString).b(paramString, paramab, paramBoolean).cyR();
    bzm localbzm = new bzm();
    localbzm.FuL = paramString;
    localbzm.nDo = paramab;
    localbzm.GUk = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbzm.yho = i;
      ((l)g.ab(l.class)).azo().c(new k.a(49, localbzm));
      AppMethodBeat.o(101745);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, PluginNewTips.a parama)
  {
    int i = 1;
    AppMethodBeat.i(184635);
    int j;
    if ((w.zk(paramString1)) && ((paramInt2 & 0x20000) != 131072L) && ((paramInt2 & 0x10000) == 65536L))
    {
      ax.aQz("room_upgrade_to_wework").putBoolean(paramString1, true);
      boolean bool = com.tencent.mm.openim.room.a.a.aPB();
      j = aAh();
      ad.i("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom chatRoomName:%s chatroomOwner:%s chatroomStatus:%s isInstallWeWork:%s maxNum:%s", new Object[] { paramString1, bt.bI(paramString2, "null"), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((bool) && (paramInt1 < j) && (bt.lQ(paramString2, u.aAm())))
      {
        com.tencent.mm.plugin.newtips.a.dun();
        com.tencent.mm.plugin.newtips.a.i.b(d.wsz, parama);
        ax.aQz("room_upgrade_to_wework").putBoolean("enter_show", true);
        parama = aj.getResources().getString(2131757109);
        String str = aj.getResources().getString(2131757111);
        paramString2 = new StringBuffer();
        paramString2.append(parama).append(" ");
        paramString2.append("<_wc_custom_link_ href=\"weixin://weixingroupupdate?roomname=").append(paramString1).append("\">").append(str).append("</_wc_custom_link_>");
        parama = new bu();
        parama.kr(0);
        parama.tN(paramString1);
        parama.setStatus(3);
        parama.setContent(paramString2.toString());
        parama.qA(bj.B(paramString1, System.currentTimeMillis() / 1000L));
        parama.setType(10000);
        parama.setFlag(parama.field_flag | 0x8);
        bj.v(parama);
        ae(paramString1, 0);
        AppMethodBeat.o(184635);
        return;
      }
      if (bool) {
        break label370;
      }
    }
    for (;;)
    {
      paramInt2 = i;
      if (!bt.lQ(paramString2, u.aAm())) {
        paramInt2 = i | 0x2;
      }
      i = paramInt2;
      if (paramInt1 >= j) {
        i = paramInt2 | 0x4;
      }
      ae(paramString1, i);
      AppMethodBeat.o(184635);
      return;
      label370:
      i = 0;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101773);
    ak localak = ((c)g.ab(c.class)).azz();
    ab localab = localak.AN(paramString1);
    if (localab == null)
    {
      AppMethodBeat.o(101773);
      return;
    }
    String str = localab.field_chatroomnotice;
    localab.field_oldChatroomVersion = paramInt1;
    localab.field_chatroomnoticePublishTime = paramLong;
    localab.field_chatroomnoticeEditor = paramString3;
    localab.field_chatroomnotice = paramString2;
    localab.field_chatroomStatus = paramInt2;
    localak.replace(localab);
    if ((bt.isNullOrNil(paramString2)) && (!bt.isNullOrNil(str)))
    {
      g.ajD();
      paramString2 = ((l)g.ab(l.class)).azp().Bf(paramString1);
      paramLong = paramString2.ePQ;
      paramString2.qt(0L);
      g.ajD();
      ((l)g.ab(l.class)).azp().af(paramString2);
      ad.i("MicroMsg.ChatroomMembersLogic", "clear room card, oldInfoId %s", new Object[] { Long.valueOf(paramLong) });
      if (paramLong != 0L) {
        ((s)g.ab(s.class)).q(paramString1, paramLong);
      }
    }
    AppMethodBeat.o(101773);
  }
  
  public static boolean a(ab paramab)
  {
    AppMethodBeat.i(101755);
    if (paramab == null)
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
      AppMethodBeat.o(101755);
      return false;
    }
    boolean bool = ((c)g.ab(c.class)).azz().replace(paramab);
    if (bool) {
      aD(paramab.field_chatroomname, paramab.field_roomowner);
    }
    AppMethodBeat.o(101755);
    return bool;
  }
  
  public static boolean a(String paramString, acu paramacu)
  {
    AppMethodBeat.i(101757);
    if ((!yG(paramString)) || (paramacu.fLb == 0))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + paramString + "] listCnt:" + paramacu.fLb);
      AppMethodBeat.o(101757);
      return false;
    }
    ak localak = ((c)g.ab(c.class)).azz();
    paramString = localak.AN(paramString);
    List localList = ab.aSK(paramString.field_memberlist);
    ad.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + localList.size());
    paramacu = paramacu.FuN.iterator();
    while (paramacu.hasNext()) {
      localList.remove(z.a(((ade)paramacu.next()).Gcd));
    }
    ad.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + localList.size());
    paramacu = paramString.hq(localList);
    paramacu.field_displayname = ae(localList);
    paramacu.field_memberCount = localList.size();
    boolean bool = localak.replace(paramString);
    ad.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101757);
    return bool;
  }
  
  public static boolean a(String paramString, ck paramck)
  {
    AppMethodBeat.i(101758);
    if ((!yG(paramString)) || (paramck.fLb == 0))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + paramString + "] listCnt:" + paramck.fLb);
      AppMethodBeat.o(101758);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    bp localbp = ((l)g.ab(l.class)).azp();
    int i = 0;
    while (i < paramck.fLb)
    {
      Object localObject = z.a(((byt)paramck.FuN.get(i)).Gcd);
      if (((byt)paramck.FuN.get(i)).GTR == 0)
      {
        if (bt.isNullOrNil((String)localObject)) {
          ad.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", new Object[] { paramString });
        }
      }
      else
      {
        i += 1;
        continue;
      }
      localObject = localbp.Bf((String)localObject);
      if ((int)((com.tencent.mm.o.b)localObject).gfj != 0)
      {
        ((am)localObject).acG();
        localbp.c(((aw)localObject).field_username, (am)localObject);
      }
      for (;;)
      {
        localArrayList.add(((aw)localObject).field_username);
        break;
        localObject = a((am)localObject, (byt)paramck.FuN.get(i));
        localbp.ag((am)localObject);
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
  
  public static boolean a(String paramString, vv paramvv)
  {
    AppMethodBeat.i(101753);
    if (paramvv == null)
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
      AppMethodBeat.o(101753);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
      AppMethodBeat.o(101753);
      return false;
    }
    if (w.vF(paramString))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[] { paramString });
      AppMethodBeat.o(101753);
      return false;
    }
    String str = z.a(paramvv.FVm);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(101753);
      return false;
    }
    ad.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[] { str, Integer.valueOf(paramvv.FVk.size()) });
    paramString = ((c)g.ab(c.class)).azz().AN(str);
    if ((paramString != null) && (paramvv.FVk.size() > 0) && (paramString.aGo().contains(((vw)paramvv.FVk.get(0)).nDo)))
    {
      str = ((vw)paramvv.FVk.get(0)).nDo;
      com.tencent.mm.k.a.a.b localb = paramString.aSG(str);
      if (localb != null)
      {
        ad.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[] { str, localb.fVj });
        localb.fVl = ((vw)paramvv.FVk.get(0)).FVr;
        a(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(101753);
        return true;
        ad.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[] { str });
      }
    }
    if ((paramString != null) && (paramvv.FVk.size() > 0))
    {
      paramString = new bb();
      paramString.dlV.username = ((vw)paramvv.FVk.get(0)).nDo;
      paramString.dlV.dlW = ((vw)paramvv.FVk.get(0)).FVr;
      hET.put(str + "#" + paramString.dlV.username, paramString.dlV.dlW);
      com.tencent.mm.sdk.b.a.IbL.l(paramString);
      AppMethodBeat.o(101753);
      return false;
    }
    if (paramvv.FVk.size() <= 0) {
      ad.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
    }
    if (paramString != null) {
      ad.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
    }
    AppMethodBeat.o(101753);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, vv paramvv, int paramInt1, int paramInt2, String paramString3, com.tencent.mm.k.a.a.a parama, com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(219246);
    if ((!paramString1.toLowerCase().endsWith("@chatroom")) && (!paramString1.toLowerCase().endsWith("@im.chatroom")) && (!paramString1.toLowerCase().endsWith("@groupcard")) && (!paramString1.toLowerCase().endsWith("@talkroom")))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] listCnt:" + paramvv.fLb);
      AppMethodBeat.o(219246);
      return false;
    }
    bp localbp = ((l)g.ab(l.class)).azp();
    ab localab = ((c)g.ab(c.class)).azz().AN(paramString1);
    if (localab != null) {}
    ArrayList localArrayList;
    long l1;
    boolean bool1;
    vw localvw;
    am localam;
    for (parama.dAm = localab.fpN();; parama.dAm = 0)
    {
      localArrayList = new ArrayList();
      ad.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] memCnt:" + paramvv.fLb);
      l1 = System.currentTimeMillis();
      i = 0;
      bool1 = false;
      for (;;)
      {
        if (i >= paramvv.fLb) {
          break label637;
        }
        localvw = (vw)paramvv.FVk.get(i);
        localam = localbp.Bf(localvw.nDo);
        if (localam != null) {
          break;
        }
        ad.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
        i += 1;
      }
    }
    com.tencent.mm.k.a.a.b localb = new com.tencent.mm.k.a.a.b();
    localb.userName = localvw.nDo;
    localb.fVl = localvw.FVr;
    localb.fVk = localvw.FVq;
    boolean bool2;
    if (paramvv.FVl == 0)
    {
      localb.fVj = localvw.FVn;
      if (!bt.isNullOrNil(localvw.FVp))
      {
        com.tencent.mm.ak.i locali = p.aEx().Dj(localvw.nDo);
        localObject = locali;
        if (locali == null)
        {
          localObject = new com.tencent.mm.ak.i();
          ((com.tencent.mm.ak.i)localObject).username = localvw.nDo;
        }
        ((com.tencent.mm.ak.i)localObject).hMX = localvw.FVo;
        ((com.tencent.mm.ak.i)localObject).hMW = localvw.FVp;
        ((com.tencent.mm.ak.i)localObject).ePj = 3;
        if (bt.isNullOrNil(localvw.FVo)) {
          break label621;
        }
        bool2 = true;
        label424:
        ((com.tencent.mm.ak.i)localObject).eB(bool2);
        p.aEx().b((com.tencent.mm.ak.i)localObject);
      }
    }
    if (localab != null)
    {
      localObject = localab.aSG(localvw.nDo);
      if (localObject != null)
      {
        localb.fVj = ((com.tencent.mm.k.a.a.b)localObject).fVj;
        if (!bt.isNullOrNil(localb.fVl)) {
          break label627;
        }
      }
    }
    label621:
    label627:
    for (Object localObject = ((com.tencent.mm.k.a.a.b)localObject).fVl;; localObject = localb.fVl)
    {
      localb.fVl = ((String)localObject);
      parama.fVg.add(localb);
      ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bB(localvw.FVs, localvw.FVt);
      if ((int)localam.gfj == 0)
      {
        localam.setUsername(localvw.nDo);
        if (localvw.nEt != null) {
          localam.sT(localvw.nEt);
        }
        localam.tc(localvw.FVs);
        localam.tb(localvw.FVt);
        localam.acG();
        localbp.ag(localam);
        bool1 = true;
      }
      localArrayList.add(localam.field_username);
      break;
      bool2 = false;
      break label424;
    }
    label637:
    ad.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + localArrayList.size() + " event: " + paramb + " publish: " + bool1 + " take[" + (System.currentTimeMillis() - l1) + "]ms");
    label827:
    long l2;
    if (bool1)
    {
      com.tencent.mm.roomsdk.a.b.aPF(paramString1).F(paramString1, parama.dAm).cyR();
      localObject = ((c)g.ab(c.class)).azz().AN(paramString1);
      paramb = (com.tencent.mm.sdk.b.b)localObject;
      if (localObject == null) {
        paramb = new ab();
      }
      i = paramb.field_chatroomStatus;
      l1 = System.currentTimeMillis();
      paramb.field_chatroomname = paramString1;
      paramb.field_roomowner = paramString2;
      localObject = paramb.hq(localArrayList);
      ((ab)localObject).field_chatroomStatus = paramInt1;
      ((ab)localObject).field_displayname = ae(localArrayList);
      if (paramvv.FVl == 0) {
        break label1112;
      }
      bool1 = true;
      ((ab)localObject).a(paramString3, parama, bool1).field_memberCount = localArrayList.size();
      if (paramInt2 != -1) {
        paramb.field_chatroomVersion = paramInt2;
      }
      paramInt2 = paramb.field_memberCount;
      if ((aAi()) && (!bt.isNullOrNil(paramString1)))
      {
        if (!ax.aQz("room_upgrade_to_wework").getBoolean(paramString1, false)) {
          break label1118;
        }
        ad.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString1 });
      }
      label907:
      bool1 = a(paramb);
      if ((bool1) && (paramInt1 != i)) {
        w.zo(paramString1);
      }
      l2 = System.currentTimeMillis();
      bool2 = paramb.fpO();
      if (paramb.fpL() != null) {
        break label1130;
      }
      paramInt2 = 0;
      label952:
      if (paramb.fpL() != null) {
        break label1143;
      }
    }
    label1112:
    label1118:
    label1130:
    label1143:
    for (int i = 0;; i = paramb.fpL().fVi)
    {
      ad.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s chatroomStatus:%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2 - l1), Boolean.valueOf(bool2), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt1) });
      if (paramb.fpO())
      {
        ad.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[] { Integer.valueOf(paramb.fpN()) });
        paramString2 = new ba();
        paramString2.dlU.username = paramString1;
        com.tencent.mm.sdk.b.a.IbL.l(paramString2);
      }
      AppMethodBeat.o(219246);
      return bool1;
      if (localab != null) {
        break;
      }
      com.tencent.mm.roomsdk.a.b.aPF(paramString1).F(paramString1, 0).cyR();
      break;
      bool1 = false;
      break label827;
      a(paramString1, paramString2, paramInt2, paramInt1, null);
      break label907;
      paramInt2 = paramb.fpL().dAm;
      break label952;
    }
  }
  
  public static boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    int i = 0;
    int k = 0;
    AppMethodBeat.i(101761);
    ak localak = ((c)g.ab(c.class)).azz();
    ab localab = localak.AO(paramString1);
    if ((paramString1.endsWith("@chatroom")) || (paramString1.endsWith("@im.chatroom"))) {}
    LinkedList localLinkedList;
    int j;
    for (paramString1 = yQ(paramString1);; paramString1 = new LinkedList())
    {
      localLinkedList = new LinkedList();
      if (paramString1 == null) {
        break label231;
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
    if (!bt.isNullOrNil(paramString2)) {
      localab.field_roomowner = paramString2;
    }
    paramString1 = localab.hq(localLinkedList);
    paramString1.field_displayname = ae(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    boolean bool = localak.replace(localab);
    AppMethodBeat.o(101761);
    return bool;
    label231:
    while (i < paramArrayList.size())
    {
      localLinkedList.add(paramArrayList.get(i));
      i += 1;
    }
    if (!bt.isNullOrNil(paramString2)) {
      localab.field_roomowner = paramString2;
    }
    paramString1 = localab.hq(localLinkedList);
    paramString1.field_displayname = ae(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    localab.field_roomowner = paramString2;
    bool = localak.replace(localab);
    ad.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101761);
    return bool;
  }
  
  public static void aAf()
  {
    AppMethodBeat.i(184633);
    PluginNewTips.removeLocalNewTipsCallback(d.wsz);
    AppMethodBeat.o(184633);
  }
  
  public static boolean aAg()
  {
    AppMethodBeat.i(184636);
    boolean bool = ax.aQz("room_upgrade_to_wework").getBoolean("enter_show", false);
    AppMethodBeat.o(184636);
    return bool;
  }
  
  public static int aAh()
  {
    AppMethodBeat.i(184637);
    int i = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("AssociateChatRoomLocalCheckMaxMemberCount", 200);
    AppMethodBeat.o(184637);
    return i;
  }
  
  public static boolean aAi()
  {
    AppMethodBeat.i(219248);
    if (((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("MMForwardUpgradeChatRoomSwitch", 0) == 1)
    {
      AppMethodBeat.o(219248);
      return true;
    }
    AppMethodBeat.o(219248);
    return false;
  }
  
  public static String aC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101754);
    paramString1 = paramString2 + "#" + paramString1;
    if (hET.aN(paramString1))
    {
      paramString1 = (String)hET.get(paramString1);
      AppMethodBeat.o(101754);
      return paramString1;
    }
    AppMethodBeat.o(101754);
    return "";
  }
  
  private static void aD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101756);
    ad.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[] { Integer.valueOf(1) });
    bp localbp = ((l)g.ab(l.class)).azp();
    am localam = localbp.Bf(paramString1);
    if (((int)localam.gfj != 0) && (!bt.isNullOrNil(paramString2)) && (!bt.isNullOrNil(u.aAm())))
    {
      if (!paramString2.equals(u.aAm())) {
        break label103;
      }
      localam.lN(1);
    }
    for (;;)
    {
      localbp.c(paramString1, localam);
      AppMethodBeat.o(101756);
      return;
      label103:
      localam.lN(0);
    }
  }
  
  public static void ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(101774);
    ak localak = ((c)g.ab(c.class)).azz();
    ab localab = localak.AN(paramString);
    if (localab == null)
    {
      AppMethodBeat.o(101774);
      return;
    }
    com.tencent.mm.k.a.a.a locala = localab.fpS();
    locala.type = paramInt;
    localab.a(paramString, locala, false);
    localak.replace(localab);
    AppMethodBeat.o(101774);
  }
  
  public static String ae(List<String> paramList)
  {
    AppMethodBeat.i(101747);
    paramList = e(paramList, -1);
    AppMethodBeat.o(101747);
    return paramList;
  }
  
  private static void ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(184638);
    cj localcj = new cj();
    localcj.lK(paramString);
    localcj.ecy = paramInt;
    localcj.aLk();
    AppMethodBeat.o(184638);
  }
  
  public static String af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101768);
    ak localak = ((c)g.ab(c.class)).azz();
    if (localak == null)
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
      AppMethodBeat.o(101768);
      return null;
    }
    paramString2 = localak.AN(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(101768);
      return null;
    }
    paramString1 = paramString2.zf(paramString1);
    AppMethodBeat.o(101768);
    return paramString1;
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
        break label214;
      }
      localObject2 = ((l)g.ab(l.class)).azp().Bf((String)localObject2);
      localObject2 = (String)localObject1 + ((am)localObject2).adv();
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
      localObject1 = (String)localObject2 + aj.getContext().getString(2131757106);
    }
    label214:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public static boolean f(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(101743);
    paramString = ((c)g.ab(c.class)).azz().AN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101743);
      return false;
    }
    Iterator localIterator = paramString.aGo().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, paramString.zf(str));
    }
    AppMethodBeat.o(101743);
    return true;
  }
  
  private static boolean yG(String paramString)
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
  
  public static boolean yH(String paramString)
  {
    AppMethodBeat.i(101742);
    paramString = ((c)g.ab(c.class)).azz().AN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101742);
      return false;
    }
    boolean bool = paramString.fpR();
    AppMethodBeat.o(101742);
    return bool;
  }
  
  public static boolean yI(String paramString)
  {
    AppMethodBeat.i(101744);
    paramString = ((c)g.ab(c.class)).azz().AP(paramString);
    String str = u.aAm();
    if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(str)) && (paramString.equals(str)))
    {
      AppMethodBeat.o(101744);
      return true;
    }
    AppMethodBeat.o(101744);
    return false;
  }
  
  public static String yJ(String paramString)
  {
    AppMethodBeat.i(101746);
    if ((paramString == null) || (!yG(paramString)))
    {
      AppMethodBeat.o(101746);
      return "";
    }
    List localList = yQ(paramString);
    paramString = "";
    int i = 0;
    String str;
    am localam;
    if ((localList != null) && (i < localList.size()))
    {
      str = (String)localList.get(i);
      if (str.length() <= 0) {
        break label198;
      }
      localam = ((l)g.ab(l.class)).azp().Bf(str);
      if (localam == null)
      {
        str = paramString + str;
        label116:
        paramString = str;
        if (i < localList.size() - 1) {
          paramString = str + aj.getContext().getString(2131757106);
        }
      }
    }
    label198:
    for (;;)
    {
      i += 1;
      break;
      str = paramString + localam.adu();
      break label116;
      AppMethodBeat.o(101746);
      return paramString;
    }
  }
  
  public static boolean yK(String paramString)
  {
    AppMethodBeat.i(101749);
    boolean bool = B(paramString, false);
    AppMethodBeat.o(101749);
    return bool;
  }
  
  public static boolean yL(String paramString)
  {
    AppMethodBeat.i(101750);
    if (!w.zj(paramString))
    {
      AppMethodBeat.o(101750);
      return false;
    }
    if (!((c)g.ab(c.class)).azz().AS(paramString))
    {
      ad.d("MicroMsg.ChatroomMembersLogic", "state is die");
      AppMethodBeat.o(101750);
      return true;
    }
    paramString = ((c)g.ab(c.class)).azz().AR(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(101750);
      return true;
    }
    AppMethodBeat.o(101750);
    return false;
  }
  
  public static boolean yM(String paramString)
  {
    AppMethodBeat.i(101751);
    if (!w.zj(paramString))
    {
      AppMethodBeat.o(101751);
      return false;
    }
    ad.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[] { paramString });
    ak localak = ((c)g.ab(c.class)).azz();
    paramString = localak.AN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101751);
      return false;
    }
    paramString.field_roomflag = 1;
    boolean bool = localak.replace(paramString);
    AppMethodBeat.o(101751);
    return bool;
  }
  
  public static boolean yN(String paramString)
  {
    AppMethodBeat.i(101759);
    if (!paramString.toLowerCase().endsWith("@groupcard"))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + paramString + "]");
      AppMethodBeat.o(101759);
      return false;
    }
    bp localbp = ((l)g.ab(l.class)).azp();
    if (localbp.aTn(paramString)) {
      localbp.aTr(paramString);
    }
    for (;;)
    {
      boolean bool = yP(paramString);
      AppMethodBeat.o(101759);
      return bool;
      ad.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + paramString + "]");
    }
  }
  
  public static boolean yO(String paramString)
  {
    AppMethodBeat.i(101760);
    if (!yG(paramString))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + paramString + "]");
      AppMethodBeat.o(101760);
      return false;
    }
    bp localbp = ((l)g.ab(l.class)).azp();
    if (localbp.aTn(paramString)) {
      localbp.aTr(paramString);
    }
    for (;;)
    {
      boolean bool = yP(paramString);
      AppMethodBeat.o(101760);
      return bool;
      ad.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + paramString + "]");
    }
  }
  
  private static boolean yP(String paramString)
  {
    AppMethodBeat.i(101762);
    boolean bool = ((c)g.ab(c.class)).azz().AT(paramString);
    AppMethodBeat.o(101762);
    return bool;
  }
  
  public static List<String> yQ(String paramString)
  {
    AppMethodBeat.i(101763);
    if (paramString == null)
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
      AppMethodBeat.o(101763);
      return null;
    }
    if (!yG(paramString))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + paramString + "]");
      AppMethodBeat.o(101763);
      return null;
    }
    paramString = ((c)g.ab(c.class)).azz().AR(paramString);
    AppMethodBeat.o(101763);
    return paramString;
  }
  
  public static List<String> yR(String paramString)
  {
    AppMethodBeat.i(101764);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101764);
      return null;
    }
    paramString = ((c)g.ab(c.class)).azz().AR(paramString);
    AppMethodBeat.o(101764);
    return paramString;
  }
  
  public static int yS(String paramString)
  {
    AppMethodBeat.i(101765);
    long l = System.currentTimeMillis();
    try
    {
      ak localak = ((c)g.ab(c.class)).azz();
      if (localak != null)
      {
        int i = localak.AU(paramString);
        return i;
      }
      return 0;
    }
    finally
    {
      ad.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(101765);
    }
  }
  
  public static List<String> yT(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(101766);
    if (!yG(paramString))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101766);
      return null;
    }
    paramString = yQ(paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      AppMethodBeat.o(101766);
      return null;
    }
    String str = (String)g.ajC().ajl().get(2, null);
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
  
  public static String yU(String paramString)
  {
    AppMethodBeat.i(101769);
    paramString = ((c)g.ab(c.class)).azz().AN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101769);
      return null;
    }
    paramString = paramString.field_chatroomnotice;
    AppMethodBeat.o(101769);
    return paramString;
  }
  
  public static boolean yV(String paramString)
  {
    AppMethodBeat.i(219247);
    paramString = ((c)g.ab(c.class)).azz().AN(paramString);
    if (paramString == null)
    {
      ad.w("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo member is null");
      AppMethodBeat.o(219247);
      return false;
    }
    ad.i("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo old:%s new:%s", new Object[] { Integer.valueOf(paramString.field_oldChatroomVersion), Integer.valueOf(paramString.field_chatroomVersion) });
    if (paramString.field_oldChatroomVersion < paramString.field_chatroomVersion)
    {
      AppMethodBeat.o(219247);
      return true;
    }
    AppMethodBeat.o(219247);
    return false;
  }
  
  public static String yW(String paramString)
  {
    AppMethodBeat.i(101771);
    paramString = ((c)g.ab(c.class)).azz().AN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101771);
      return null;
    }
    paramString = paramString.field_chatroomnoticeEditor;
    AppMethodBeat.o(101771);
    return paramString;
  }
  
  public static long yX(String paramString)
  {
    AppMethodBeat.i(101772);
    paramString = ((c)g.ab(c.class)).azz().AN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101772);
      return -1L;
    }
    long l = paramString.field_chatroomnoticePublishTime;
    AppMethodBeat.o(101772);
    return l;
  }
  
  public static void yY(String paramString)
  {
    AppMethodBeat.i(219249);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail username is null");
      AppMethodBeat.o(219249);
      return;
    }
    Object localObject = ((c)g.ab(c.class)).azz().AN(paramString);
    if (localObject != null) {
      if (((ab)localObject).field_oldChatroomVersion >= ((ab)localObject).field_chatroomVersion) {
        break label125;
      }
    }
    label125:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail() %s update, stack:%s", new Object[] { paramString, bt.flS().toString() });
        localObject = new it();
        ((it)localObject).dvr.dvs = paramString;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      AppMethodBeat.o(219249);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.q
 * JD-Core Version:    0.7.0.1
 */