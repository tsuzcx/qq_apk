package com.tencent.mm.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.ay.a;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.plugin.newtips.a.d;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.protocal.protobuf.bqg;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class q
{
  public static f<String, String> gMf;
  
  static
  {
    AppMethodBeat.i(101775);
    gMf = new h(100);
    AppMethodBeat.o(101775);
  }
  
  public static boolean A(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(192597);
    String str = (String)g.afB().afk().get(2, null);
    paramString = rW(paramString);
    if (paramString == null)
    {
      ad.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
      if (paramBoolean)
      {
        ad.w("MicroMsg.ChatroomMembersLogic", "isInChatRoom temp change");
        AppMethodBeat.o(192597);
        return true;
      }
      AppMethodBeat.o(192597);
      return false;
    }
    if ((paramString.size() == 0) || (!paramString.contains(str)))
    {
      ad.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + paramString.size() + " ");
      AppMethodBeat.o(192597);
      return false;
    }
    AppMethodBeat.o(192597);
    return true;
  }
  
  public static boolean U(String paramString, int paramInt)
  {
    AppMethodBeat.i(101770);
    paramString = ((c)g.ab(c.class)).apV().tH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101770);
      return false;
    }
    if (paramString.field_chatroomVersion < paramInt)
    {
      AppMethodBeat.o(101770);
      return true;
    }
    AppMethodBeat.o(101770);
    return false;
  }
  
  public static void V(String paramString, int paramInt)
  {
    AppMethodBeat.i(101774);
    aj localaj = ((c)g.ab(c.class)).apV();
    com.tencent.mm.storage.w localw = localaj.tH(paramString);
    if (localw == null)
    {
      AppMethodBeat.o(101774);
      return;
    }
    com.tencent.mm.j.a.a.a locala = localw.eKt();
    locala.type = paramInt;
    localw.a(paramString, locala, false);
    localaj.replace(localw);
    AppMethodBeat.o(101774);
  }
  
  private static void W(String paramString, int paramInt)
  {
    AppMethodBeat.i(184638);
    as localas = new as();
    localas.hK(paramString);
    localas.dMI = paramInt;
    localas.aBj();
    AppMethodBeat.o(184638);
  }
  
  public static af a(af paramaf, bpn parambpn)
  {
    AppMethodBeat.i(101767);
    paramaf.setUsername(z.a(parambpn.DbD));
    paramaf.nd(z.a(parambpn.DbD));
    paramaf.ne(z.a(parambpn.DbD));
    paramaf.nf(z.a(parambpn.Dbc));
    paramaf.jJ(parambpn.ijM);
    paramaf.nb(z.a(parambpn.DNT));
    paramaf.ni(z.a(parambpn.DNU));
    paramaf.nh(z.a(parambpn.Dbc));
    paramaf.jL(parambpn.Dat);
    paramaf.jN(parambpn.ijQ);
    paramaf.nA(RegionCodeDecoder.aT(parambpn.ijV, parambpn.ijN, parambpn.ijO));
    paramaf.nu(parambpn.ijP);
    AppMethodBeat.o(101767);
    return paramaf;
  }
  
  public static void a(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184634);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184634);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.ax.aFC("room_upgrade_to_wework").getBoolean(paramString, false))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    com.tencent.mm.storage.w localw = ((c)g.ab(c.class)).apV().tH(paramString);
    if (localw == null)
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member is null", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    a(paramString, localw.field_roomowner, localw.field_memberCount, localw.field_chatroomStatus, parama);
    AppMethodBeat.o(184634);
  }
  
  public static void a(String paramString, com.tencent.mm.storage.w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(101745);
    paramw.va(paramBoolean);
    ((c)g.ab(c.class)).apV().update(paramw, new String[0]);
    paramw = u.aqG();
    com.tencent.mm.roomsdk.a.b.aEI(paramString).b(paramString, paramw, paramBoolean).eDp();
    bqg localbqg = new bqg();
    localbqg.Cxb = paramString;
    localbqg.mAQ = paramw;
    localbqg.DOl = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbqg.vJA = i;
      ((k)g.ab(k.class)).apL().c(new j.a(49, localbqg));
      AppMethodBeat.o(101745);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, PluginNewTips.a parama)
  {
    int i = 1;
    AppMethodBeat.i(184635);
    int j;
    if ((w.sm(paramString1)) && ((0x20000 & paramInt2) != 131072) && ((paramInt2 & 0x10000) == 65536))
    {
      com.tencent.mm.sdk.platformtools.ax.aFC("room_upgrade_to_wework").putBoolean(paramString1, true);
      boolean bool = com.tencent.mm.openim.room.a.a.aFx();
      j = aqC();
      ad.i("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom chatRoomName:%s chatroomOwner:%s chatroomStatus:%s isInstallWeWork:%s maxNum:%s", new Object[] { paramString1, bt.by(paramString2, "null"), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((bool) && (paramInt1 < j) && (bt.kU(paramString2, u.aqG())))
      {
        com.tencent.mm.plugin.newtips.a.cWs();
        com.tencent.mm.plugin.newtips.a.i.b(d.uej, parama);
        com.tencent.mm.sdk.platformtools.ax.aFC("room_upgrade_to_wework").putBoolean("enter_show", true);
        parama = com.tencent.mm.sdk.platformtools.aj.getResources().getString(2131757109);
        String str = com.tencent.mm.sdk.platformtools.aj.getResources().getString(2131757111);
        paramString2 = new StringBuffer();
        paramString2.append(parama).append(" ");
        paramString2.append("<_wc_custom_link_ href=\"weixin://weixingroupupdate?roomname=").append(paramString1).append("\">").append(str).append("</_wc_custom_link_>");
        parama = new bl();
        parama.jV(0);
        parama.nY(paramString1);
        parama.setStatus(3);
        parama.setContent(paramString2.toString());
        parama.kY(bi.y(paramString1, System.currentTimeMillis() / 1000L));
        parama.setType(10000);
        parama.setFlag(parama.field_flag | 0x8);
        bi.u(parama);
        W(paramString1, 0);
        AppMethodBeat.o(184635);
        return;
      }
      if (bool) {
        break label368;
      }
    }
    for (;;)
    {
      paramInt2 = i;
      if (!bt.kU(paramString2, u.aqG())) {
        paramInt2 = i | 0x2;
      }
      i = paramInt2;
      if (paramInt1 >= j) {
        i = paramInt2 | 0x4;
      }
      W(paramString1, i);
      AppMethodBeat.o(184635);
      return;
      label368:
      i = 0;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101773);
    aj localaj = ((c)g.ab(c.class)).apV();
    paramString1 = localaj.tH(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(101773);
      return;
    }
    paramString1.field_chatroomVersion = paramInt1;
    paramString1.field_chatroomnoticePublishTime = paramLong;
    paramString1.field_chatroomnoticeEditor = paramString3;
    paramString1.field_chatroomnotice = paramString2;
    paramString1.field_chatroomStatus = paramInt2;
    localaj.replace(paramString1);
    AppMethodBeat.o(101773);
  }
  
  public static boolean a(com.tencent.mm.storage.w paramw)
  {
    AppMethodBeat.i(101755);
    if (paramw == null)
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
      AppMethodBeat.o(101755);
      return false;
    }
    boolean bool = ((c)g.ab(c.class)).apV().replace(paramw);
    if (bool) {
      au(paramw.field_chatroomname, paramw.field_roomowner);
    }
    AppMethodBeat.o(101755);
    return bool;
  }
  
  public static boolean a(String paramString, ch paramch)
  {
    AppMethodBeat.i(101758);
    if ((!rM(paramString)) || (paramch.fpb == 0))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + paramString + "] listCnt:" + paramch.fpb);
      AppMethodBeat.o(101758);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    bg localbg = ((k)g.ab(k.class)).apM();
    int i = 0;
    while (i < paramch.fpb)
    {
      Object localObject = z.a(((bpn)paramch.Cxd.get(i)).DbD);
      if (((bpn)paramch.Cxd.get(i)).DNS == 0)
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
      localObject = localbg.aHY((String)localObject);
      if ((int)((com.tencent.mm.n.b)localObject).fId != 0)
      {
        ((af)localObject).Zj();
        localbg.c(((au)localObject).field_username, (af)localObject);
      }
      for (;;)
      {
        localArrayList.add(((au)localObject).field_username);
        break;
        localObject = a((af)localObject, (bpn)paramch.Cxd.get(i));
        localbg.af((af)localObject);
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
  
  public static boolean a(String paramString, tq paramtq)
  {
    AppMethodBeat.i(101753);
    if (paramtq == null)
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
    if (w.pF(paramString))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[] { paramString });
      AppMethodBeat.o(101753);
      return false;
    }
    String str = z.a(paramtq.CVt);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(101753);
      return false;
    }
    ad.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[] { str, Integer.valueOf(paramtq.CVr.size()) });
    paramString = ((c)g.ab(c.class)).apV().tH(str);
    if ((paramString != null) && (paramtq.CVr.size() > 0) && (paramString.awt().contains(((tr)paramtq.CVr.get(0)).mAQ)))
    {
      str = ((tr)paramtq.CVr.get(0)).mAQ;
      com.tencent.mm.j.a.a.b localb = paramString.aHy(str);
      if (localb != null)
      {
        ad.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[] { str, localb.fyo });
        localb.fyq = ((tr)paramtq.CVr.get(0)).CVy;
        a(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(101753);
        return true;
        ad.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[] { str });
      }
    }
    if ((paramString != null) && (paramtq.CVr.size() > 0))
    {
      paramString = new ay();
      paramString.ddd.username = ((tr)paramtq.CVr.get(0)).mAQ;
      paramString.ddd.dde = ((tr)paramtq.CVr.get(0)).CVy;
      gMf.put(str + "#" + paramString.ddd.username, paramString.ddd.dde);
      com.tencent.mm.sdk.b.a.ESL.l(paramString);
      AppMethodBeat.o(101753);
      return false;
    }
    if (paramtq.CVr.size() <= 0) {
      ad.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
    }
    if (paramString != null) {
      ad.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
    }
    AppMethodBeat.o(101753);
    return false;
  }
  
  public static boolean a(String paramString, zv paramzv)
  {
    AppMethodBeat.i(101757);
    if ((!rM(paramString)) || (paramzv.fpb == 0))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + paramString + "] listCnt:" + paramzv.fpb);
      AppMethodBeat.o(101757);
      return false;
    }
    aj localaj = ((c)g.ab(c.class)).apV();
    paramString = localaj.tH(paramString);
    List localList = com.tencent.mm.storage.w.aHC(paramString.field_memberlist);
    ad.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + localList.size());
    paramzv = paramzv.Cxd.iterator();
    while (paramzv.hasNext()) {
      localList.remove(z.a(((aaf)paramzv.next()).DbD));
    }
    ad.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + localList.size());
    paramzv = paramString.gR(localList);
    paramzv.field_displayname = ag(localList);
    paramzv.field_memberCount = localList.size();
    boolean bool = localaj.replace(paramString);
    ad.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101757);
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, tq paramtq, int paramInt, String paramString3, com.tencent.mm.j.a.a.a parama, com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(101752);
    if ((!paramString1.toLowerCase().endsWith("@chatroom")) && (!paramString1.toLowerCase().endsWith("@im.chatroom")) && (!paramString1.toLowerCase().endsWith("@groupcard")) && (!paramString1.toLowerCase().endsWith("@talkroom")))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] listCnt:" + paramtq.fpb);
      AppMethodBeat.o(101752);
      return false;
    }
    bg localbg = ((k)g.ab(k.class)).apM();
    com.tencent.mm.storage.w localw = ((c)g.ab(c.class)).apV().tH(paramString1);
    if (localw != null) {}
    ArrayList localArrayList;
    long l1;
    boolean bool1;
    tr localtr;
    af localaf;
    for (parama.dqN = localw.eKo();; parama.dqN = 0)
    {
      localArrayList = new ArrayList();
      ad.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] memCnt:" + paramtq.fpb);
      l1 = System.currentTimeMillis();
      i = 0;
      bool1 = false;
      for (;;)
      {
        if (i >= paramtq.fpb) {
          break label637;
        }
        localtr = (tr)paramtq.CVr.get(i);
        localaf = localbg.aHY(localtr.mAQ);
        if (localaf != null) {
          break;
        }
        ad.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
        i += 1;
      }
    }
    com.tencent.mm.j.a.a.b localb = new com.tencent.mm.j.a.a.b();
    localb.userName = localtr.mAQ;
    localb.fyq = localtr.CVy;
    localb.fyp = localtr.CVx;
    boolean bool2;
    if (paramtq.CVs == 0)
    {
      localb.fyo = localtr.CVu;
      if (!bt.isNullOrNil(localtr.CVw))
      {
        com.tencent.mm.ak.i locali = p.auF().we(localtr.mAQ);
        localObject = locali;
        if (locali == null)
        {
          localObject = new com.tencent.mm.ak.i();
          ((com.tencent.mm.ak.i)localObject).username = localtr.mAQ;
        }
        ((com.tencent.mm.ak.i)localObject).gUg = localtr.CVv;
        ((com.tencent.mm.ak.i)localObject).gUf = localtr.CVw;
        ((com.tencent.mm.ak.i)localObject).evo = 3;
        if (bt.isNullOrNil(localtr.CVv)) {
          break label621;
        }
        bool2 = true;
        label424:
        ((com.tencent.mm.ak.i)localObject).ee(bool2);
        p.auF().b((com.tencent.mm.ak.i)localObject);
      }
    }
    if (localw != null)
    {
      localObject = localw.aHy(localtr.mAQ);
      if (localObject != null)
      {
        localb.fyo = ((com.tencent.mm.j.a.a.b)localObject).fyo;
        if (!bt.isNullOrNil(localb.fyq)) {
          break label627;
        }
      }
    }
    label621:
    label627:
    for (Object localObject = ((com.tencent.mm.j.a.a.b)localObject).fyq;; localObject = localb.fyq)
    {
      localb.fyq = ((String)localObject);
      parama.fyl.add(localb);
      ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bs(localtr.CVz, localtr.CVA);
      if ((int)localaf.fId == 0)
      {
        localaf.setUsername(localtr.mAQ);
        if (localtr.mBV != null) {
          localaf.nd(localtr.mBV);
        }
        localaf.nm(localtr.CVz);
        localaf.nl(localtr.CVA);
        localaf.Zj();
        localbg.af(localaf);
        bool1 = true;
      }
      localArrayList.add(localaf.field_username);
      break;
      bool2 = false;
      break label424;
    }
    label637:
    ad.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + localArrayList.size() + " event: " + paramb + " publish: " + bool1 + " take[" + (System.currentTimeMillis() - l1) + "]ms");
    label820:
    label883:
    long l2;
    if (bool1)
    {
      com.tencent.mm.roomsdk.a.b.aEI(paramString1).D(paramString1, parama.dqN).eDp();
      localObject = ((c)g.ab(c.class)).apV().tH(paramString1);
      paramb = (com.tencent.mm.sdk.b.b)localObject;
      if (localObject == null) {
        paramb = new com.tencent.mm.storage.w();
      }
      l1 = System.currentTimeMillis();
      paramb.field_chatroomname = paramString1;
      paramb.field_roomowner = paramString2;
      localObject = paramb.gR(localArrayList);
      ((com.tencent.mm.storage.w)localObject).field_chatroomStatus = paramInt;
      ((com.tencent.mm.storage.w)localObject).field_displayname = ag(localArrayList);
      if (paramtq.CVs == 0) {
        break label1063;
      }
      bool1 = true;
      ((com.tencent.mm.storage.w)localObject).a(paramString3, parama, bool1).field_memberCount = localArrayList.size();
      i = paramb.field_memberCount;
      if (!bt.isNullOrNil(paramString1))
      {
        if (!com.tencent.mm.sdk.platformtools.ax.aFC("room_upgrade_to_wework").getBoolean(paramString1, false)) {
          break label1069;
        }
        ad.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString1 });
      }
      bool1 = a(paramb);
      l2 = System.currentTimeMillis();
      bool2 = paramb.eKp();
      if (paramb.eKm() != null) {
        break label1081;
      }
      paramInt = 0;
      label912:
      if (paramb.eKm() != null) {
        break label1093;
      }
    }
    label1063:
    label1069:
    label1081:
    label1093:
    for (int i = 0;; i = paramb.eKm().fyn)
    {
      ad.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2 - l1), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if (paramb.eKp())
      {
        ad.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[] { Integer.valueOf(paramb.eKo()) });
        paramString2 = new com.tencent.mm.g.a.ax();
        paramString2.ddc.username = paramString1;
        com.tencent.mm.sdk.b.a.ESL.l(paramString2);
      }
      AppMethodBeat.o(101752);
      return bool1;
      if (localw != null) {
        break;
      }
      com.tencent.mm.roomsdk.a.b.aEI(paramString1).D(paramString1, 0).eDp();
      break;
      bool1 = false;
      break label820;
      a(paramString1, paramString2, i, paramInt, null);
      break label883;
      paramInt = paramb.eKm().dqN;
      break label912;
    }
  }
  
  public static boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    int i = 0;
    int k = 0;
    AppMethodBeat.i(101761);
    aj localaj = ((c)g.ab(c.class)).apV();
    com.tencent.mm.storage.w localw = localaj.tI(paramString1);
    if ((paramString1.endsWith("@chatroom")) || (paramString1.endsWith("@im.chatroom"))) {}
    LinkedList localLinkedList;
    int j;
    for (paramString1 = rW(paramString1);; paramString1 = new LinkedList())
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
      localw.field_roomowner = paramString2;
    }
    paramString1 = localw.gR(localLinkedList);
    paramString1.field_displayname = ag(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    boolean bool = localaj.replace(localw);
    AppMethodBeat.o(101761);
    return bool;
    label231:
    while (i < paramArrayList.size())
    {
      localLinkedList.add(paramArrayList.get(i));
      i += 1;
    }
    if (!bt.isNullOrNil(paramString2)) {
      localw.field_roomowner = paramString2;
    }
    paramString1 = localw.gR(localLinkedList);
    paramString1.field_displayname = ag(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    localw.field_roomowner = paramString2;
    bool = localaj.replace(localw);
    ad.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101761);
    return bool;
  }
  
  public static String ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101768);
    aj localaj = ((c)g.ab(c.class)).apV();
    if (localaj == null)
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
      AppMethodBeat.o(101768);
      return null;
    }
    paramString2 = localaj.tH(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(101768);
      return null;
    }
    paramString1 = paramString2.sh(paramString1);
    AppMethodBeat.o(101768);
    return paramString1;
  }
  
  public static String ag(List<String> paramList)
  {
    AppMethodBeat.i(101747);
    paramList = e(paramList, -1);
    AppMethodBeat.o(101747);
    return paramList;
  }
  
  public static void aqA()
  {
    AppMethodBeat.i(184633);
    PluginNewTips.removeLocalNewTipsCallback(d.uej);
    AppMethodBeat.o(184633);
  }
  
  public static boolean aqB()
  {
    AppMethodBeat.i(184636);
    boolean bool = com.tencent.mm.sdk.platformtools.ax.aFC("room_upgrade_to_wework").getBoolean("enter_show", false);
    AppMethodBeat.o(184636);
    return bool;
  }
  
  public static int aqC()
  {
    AppMethodBeat.i(184637);
    int i = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("AssociateChatRoomLocalCheckMaxMemberCount", 200);
    AppMethodBeat.o(184637);
    return i;
  }
  
  public static String at(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101754);
    paramString1 = paramString2 + "#" + paramString1;
    if (gMf.aO(paramString1))
    {
      paramString1 = (String)gMf.get(paramString1);
      AppMethodBeat.o(101754);
      return paramString1;
    }
    AppMethodBeat.o(101754);
    return "";
  }
  
  private static void au(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101756);
    ad.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[] { Integer.valueOf(1) });
    bg localbg = ((k)g.ab(k.class)).apM();
    af localaf = localbg.aHY(paramString1);
    if (((int)localaf.fId != 0) && (!bt.isNullOrNil(paramString2)) && (!bt.isNullOrNil(u.aqG())))
    {
      if (!paramString2.equals(u.aqG())) {
        break label103;
      }
      localaf.lt(1);
    }
    for (;;)
    {
      localbg.c(paramString1, localaf);
      AppMethodBeat.o(101756);
      return;
      label103:
      localaf.lt(0);
    }
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
      localObject2 = ((k)g.ab(k.class)).apM().aHY((String)localObject2);
      localObject2 = (String)localObject1 + ((af)localObject2).ZX();
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
      localObject1 = (String)localObject2 + com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131757106);
    }
    label214:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public static boolean e(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(101743);
    paramString = ((c)g.ab(c.class)).apV().tH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101743);
      return false;
    }
    Iterator localIterator = paramString.awt().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, paramString.sh(str));
    }
    AppMethodBeat.o(101743);
    return true;
  }
  
  private static boolean rM(String paramString)
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
  
  public static boolean rN(String paramString)
  {
    AppMethodBeat.i(101742);
    paramString = ((c)g.ab(c.class)).apV().tH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101742);
      return false;
    }
    boolean bool = paramString.eKs();
    AppMethodBeat.o(101742);
    return bool;
  }
  
  public static boolean rO(String paramString)
  {
    AppMethodBeat.i(101744);
    paramString = ((c)g.ab(c.class)).apV().tJ(paramString);
    String str = u.aqG();
    if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(str)) && (paramString.equals(str)))
    {
      AppMethodBeat.o(101744);
      return true;
    }
    AppMethodBeat.o(101744);
    return false;
  }
  
  public static String rP(String paramString)
  {
    AppMethodBeat.i(101746);
    if ((paramString == null) || (!rM(paramString)))
    {
      AppMethodBeat.o(101746);
      return "";
    }
    List localList = rW(paramString);
    paramString = "";
    int i = 0;
    String str;
    af localaf;
    if ((localList != null) && (i < localList.size()))
    {
      str = (String)localList.get(i);
      if (str.length() <= 0) {
        break label198;
      }
      localaf = ((k)g.ab(k.class)).apM().aHY(str);
      if (localaf == null)
      {
        str = paramString + str;
        label116:
        paramString = str;
        if (i < localList.size() - 1) {
          paramString = str + com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131757106);
        }
      }
    }
    label198:
    for (;;)
    {
      i += 1;
      break;
      str = paramString + localaf.ZW();
      break label116;
      AppMethodBeat.o(101746);
      return paramString;
    }
  }
  
  public static boolean rQ(String paramString)
  {
    AppMethodBeat.i(101749);
    boolean bool = A(paramString, false);
    AppMethodBeat.o(101749);
    return bool;
  }
  
  public static boolean rR(String paramString)
  {
    AppMethodBeat.i(101750);
    if (!w.sl(paramString))
    {
      AppMethodBeat.o(101750);
      return false;
    }
    if (!((c)g.ab(c.class)).apV().tM(paramString))
    {
      ad.d("MicroMsg.ChatroomMembersLogic", "state is die");
      AppMethodBeat.o(101750);
      return true;
    }
    paramString = ((c)g.ab(c.class)).apV().tL(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(101750);
      return true;
    }
    AppMethodBeat.o(101750);
    return false;
  }
  
  public static boolean rS(String paramString)
  {
    AppMethodBeat.i(101751);
    if (!w.sl(paramString))
    {
      AppMethodBeat.o(101751);
      return false;
    }
    ad.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[] { paramString });
    aj localaj = ((c)g.ab(c.class)).apV();
    paramString = localaj.tH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101751);
      return false;
    }
    paramString.field_roomflag = 1;
    boolean bool = localaj.replace(paramString);
    AppMethodBeat.o(101751);
    return bool;
  }
  
  public static boolean rT(String paramString)
  {
    AppMethodBeat.i(101759);
    if (!paramString.toLowerCase().endsWith("@groupcard"))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + paramString + "]");
      AppMethodBeat.o(101759);
      return false;
    }
    bg localbg = ((k)g.ab(k.class)).apM();
    if (localbg.aIb(paramString)) {
      localbg.aIf(paramString);
    }
    for (;;)
    {
      boolean bool = rV(paramString);
      AppMethodBeat.o(101759);
      return bool;
      ad.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + paramString + "]");
    }
  }
  
  public static boolean rU(String paramString)
  {
    AppMethodBeat.i(101760);
    if (!rM(paramString))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + paramString + "]");
      AppMethodBeat.o(101760);
      return false;
    }
    bg localbg = ((k)g.ab(k.class)).apM();
    if (localbg.aIb(paramString)) {
      localbg.aIf(paramString);
    }
    for (;;)
    {
      boolean bool = rV(paramString);
      AppMethodBeat.o(101760);
      return bool;
      ad.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + paramString + "]");
    }
  }
  
  private static boolean rV(String paramString)
  {
    AppMethodBeat.i(101762);
    boolean bool = ((c)g.ab(c.class)).apV().tN(paramString);
    AppMethodBeat.o(101762);
    return bool;
  }
  
  public static List<String> rW(String paramString)
  {
    AppMethodBeat.i(101763);
    if (paramString == null)
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
      AppMethodBeat.o(101763);
      return null;
    }
    if (!rM(paramString))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + paramString + "]");
      AppMethodBeat.o(101763);
      return null;
    }
    paramString = ((c)g.ab(c.class)).apV().tL(paramString);
    AppMethodBeat.o(101763);
    return paramString;
  }
  
  public static List<String> rX(String paramString)
  {
    AppMethodBeat.i(101764);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101764);
      return null;
    }
    paramString = ((c)g.ab(c.class)).apV().tL(paramString);
    AppMethodBeat.o(101764);
    return paramString;
  }
  
  public static int rY(String paramString)
  {
    AppMethodBeat.i(101765);
    long l = System.currentTimeMillis();
    try
    {
      aj localaj = ((c)g.ab(c.class)).apV();
      if (localaj != null)
      {
        int i = localaj.tO(paramString);
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
  
  public static List<String> rZ(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(101766);
    if (!rM(paramString))
    {
      ad.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101766);
      return null;
    }
    paramString = rW(paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      AppMethodBeat.o(101766);
      return null;
    }
    String str = (String)g.afB().afk().get(2, null);
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
  
  public static String sa(String paramString)
  {
    AppMethodBeat.i(101769);
    paramString = ((c)g.ab(c.class)).apV().tH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101769);
      return null;
    }
    paramString = paramString.field_chatroomnotice;
    AppMethodBeat.o(101769);
    return paramString;
  }
  
  public static String sb(String paramString)
  {
    AppMethodBeat.i(101771);
    paramString = ((c)g.ab(c.class)).apV().tH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101771);
      return null;
    }
    paramString = paramString.field_chatroomnoticeEditor;
    AppMethodBeat.o(101771);
    return paramString;
  }
  
  public static long sc(String paramString)
  {
    AppMethodBeat.i(101772);
    paramString = ((c)g.ab(c.class)).apV().tH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101772);
      return -1L;
    }
    long l = paramString.field_chatroomnoticePublishTime;
    AppMethodBeat.o(101772);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.q
 * JD-Core Version:    0.7.0.1
 */