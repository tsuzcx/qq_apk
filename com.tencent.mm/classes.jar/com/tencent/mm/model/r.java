package com.tencent.mm.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.bb.a;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.b.a.cj;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.plugin.newtips.a.d;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.ck;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class r
{
  public static f<String, String> hHL;
  
  static
  {
    AppMethodBeat.i(101775);
    hHL = new h(100);
    AppMethodBeat.o(101775);
  }
  
  public static boolean B(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(209885);
    String str = (String)g.ajR().ajA().get(2, null);
    paramString = zA(paramString);
    if (paramString == null)
    {
      ae.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
      if (paramBoolean)
      {
        ae.w("MicroMsg.ChatroomMembersLogic", "isInChatRoom temp change");
        AppMethodBeat.o(209885);
        return true;
      }
      AppMethodBeat.o(209885);
      return false;
    }
    if ((paramString.size() == 0) || (!paramString.contains(str)))
    {
      ae.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + paramString.size() + " ");
      AppMethodBeat.o(209885);
      return false;
    }
    AppMethodBeat.o(209885);
    return true;
  }
  
  public static an a(an paraman, bzn parambzn)
  {
    AppMethodBeat.i(101767);
    paraman.setUsername(z.a(parambzn.GuK));
    paraman.to(z.a(parambzn.GuK));
    paraman.tp(z.a(parambzn.GuK));
    paraman.tq(z.a(parambzn.GtZ));
    paraman.kh(parambzn.jfV);
    paraman.tm(z.a(parambzn.Hnt));
    paraman.tt(z.a(parambzn.Hnu));
    paraman.ts(z.a(parambzn.GtZ));
    paraman.kj(parambzn.Gto);
    paraman.kl(parambzn.jfZ);
    paraman.tL(RegionCodeDecoder.bg(parambzn.jge, parambzn.jfW, parambzn.jfX));
    paraman.tF(parambzn.jfY);
    AppMethodBeat.o(101767);
    return paraman;
  }
  
  public static void a(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184634);
    if (!aAy())
    {
      AppMethodBeat.o(184634);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184634);
      return;
    }
    if (ay.aRW("room_upgrade_to_wework").getBoolean(paramString, false))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (localac == null)
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member is null", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    a(paramString, localac.field_roomowner, localac.field_memberCount, localac.field_chatroomStatus, parama);
    AppMethodBeat.o(184634);
  }
  
  public static void a(String paramString, ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(101745);
    paramac.wX(paramBoolean);
    ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().update(paramac, new String[0]);
    paramac = v.aAC();
    com.tencent.mm.roomsdk.a.b.aRc(paramString).b(paramString, paramac, paramBoolean).cAs();
    cag localcag = new cag();
    localcag.FNj = paramString;
    localcag.nIJ = paramac;
    localcag.HnL = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localcag.yxf = i;
      ((l)g.ab(l.class)).azE().d(new k.a(49, localcag));
      AppMethodBeat.o(101745);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, PluginNewTips.a parama)
  {
    int i = 1;
    AppMethodBeat.i(184635);
    int j;
    if ((x.zU(paramString1)) && ((paramInt2 & 0x20000) != 131072L) && ((paramInt2 & 0x10000) == 65536L))
    {
      ay.aRW("room_upgrade_to_wework").putBoolean(paramString1, true);
      boolean bool = com.tencent.mm.openim.room.a.a.aQa();
      j = aAx();
      ae.i("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom chatRoomName:%s chatroomOwner:%s chatroomStatus:%s isInstallWeWork:%s maxNum:%s", new Object[] { paramString1, bu.bI(paramString2, "null"), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((bool) && (paramInt1 < j) && (bu.lX(paramString2, v.aAC())))
      {
        com.tencent.mm.plugin.newtips.a.dxD();
        com.tencent.mm.plugin.newtips.a.i.b(d.wIi, parama);
        ay.aRW("room_upgrade_to_wework").putBoolean("enter_show", true);
        parama = ak.getResources().getString(2131757109);
        String str = ak.getResources().getString(2131757111);
        paramString2 = new StringBuffer();
        paramString2.append(parama).append(" ");
        paramString2.append("<_wc_custom_link_ href=\"weixin://weixingroupupdate?roomname=").append(paramString1).append("\">").append(str).append("</_wc_custom_link_>");
        parama = new bv();
        parama.kt(0);
        parama.ui(paramString1);
        parama.setStatus(3);
        parama.setContent(paramString2.toString());
        parama.qN(bl.B(paramString1, System.currentTimeMillis() / 1000L));
        parama.setType(10000);
        parama.setFlag(parama.field_flag | 0x8);
        bl.v(parama);
        af(paramString1, 0);
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
      if (!bu.lX(paramString2, v.aAC())) {
        paramInt2 = i | 0x2;
      }
      i = paramInt2;
      if (paramInt1 >= j) {
        i = paramInt2 | 0x4;
      }
      af(paramString1, i);
      AppMethodBeat.o(184635);
      return;
      label370:
      i = 0;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101773);
    al localal = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
    ac localac = localal.Bx(paramString1);
    if (localac == null)
    {
      AppMethodBeat.o(101773);
      return;
    }
    String str = localac.field_chatroomnotice;
    localac.field_oldChatroomVersion = paramInt1;
    localac.field_chatroomnoticePublishTime = paramLong;
    localac.field_chatroomnoticeEditor = paramString3;
    localac.field_chatroomnotice = paramString2;
    localac.field_chatroomStatus = paramInt2;
    localal.replace(localac);
    if ((bu.isNullOrNil(paramString2)) && (!bu.isNullOrNil(str)))
    {
      g.ajS();
      paramString2 = ((l)g.ab(l.class)).azF().BH(paramString1);
      paramLong = paramString2.eRB;
      paramString2.qG(0L);
      g.ajS();
      ((l)g.ab(l.class)).azF().am(paramString2);
      ae.i("MicroMsg.ChatroomMembersLogic", "clear room card, oldInfoId %s", new Object[] { Long.valueOf(paramLong) });
      if (paramLong != 0L) {
        ((t)g.ab(t.class)).q(paramString1, paramLong);
      }
    }
    AppMethodBeat.o(101773);
  }
  
  public static boolean a(ac paramac)
  {
    AppMethodBeat.i(101755);
    if (paramac == null)
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
      AppMethodBeat.o(101755);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().replace(paramac);
    if (bool) {
      aE(paramac.field_chatroomname, paramac.field_roomowner);
    }
    AppMethodBeat.o(101755);
    return bool;
  }
  
  public static boolean a(String paramString, add paramadd)
  {
    AppMethodBeat.i(101757);
    if ((!zq(paramString)) || (paramadd.fNf == 0))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + paramString + "] listCnt:" + paramadd.fNf);
      AppMethodBeat.o(101757);
      return false;
    }
    al localal = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
    paramString = localal.Bx(paramString);
    List localList = ac.aUj(paramString.field_memberlist);
    ae.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + localList.size());
    paramadd = paramadd.FNl.iterator();
    while (paramadd.hasNext()) {
      localList.remove(z.a(((adn)paramadd.next()).GuK));
    }
    ae.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + localList.size());
    paramadd = paramString.hA(localList);
    paramadd.field_displayname = ae(localList);
    paramadd.field_memberCount = localList.size();
    boolean bool = localal.replace(paramString);
    ae.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101757);
    return bool;
  }
  
  public static boolean a(String paramString, ck paramck)
  {
    AppMethodBeat.i(101758);
    if ((!zq(paramString)) || (paramck.fNf == 0))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + paramString + "] listCnt:" + paramck.fNf);
      AppMethodBeat.o(101758);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    bq localbq = ((l)g.ab(l.class)).azF();
    int i = 0;
    while (i < paramck.fNf)
    {
      Object localObject = z.a(((bzn)paramck.FNl.get(i)).GuK);
      if (((bzn)paramck.FNl.get(i)).Hns == 0)
      {
        if (bu.isNullOrNil((String)localObject)) {
          ae.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", new Object[] { paramString });
        }
      }
      else
      {
        i += 1;
        continue;
      }
      localObject = localbq.BH((String)localObject);
      if ((int)((com.tencent.mm.contact.c)localObject).ght != 0)
      {
        ((an)localObject).acR();
        localbq.c(((aw)localObject).field_username, (an)localObject);
      }
      for (;;)
      {
        localArrayList.add(((aw)localObject).field_username);
        break;
        localObject = a((an)localObject, (bzn)paramck.FNl.get(i));
        localbq.an((an)localObject);
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
  
  public static boolean a(String paramString, vy paramvy)
  {
    AppMethodBeat.i(101753);
    if (paramvy == null)
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
      AppMethodBeat.o(101753);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
      AppMethodBeat.o(101753);
      return false;
    }
    if (x.wb(paramString))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[] { paramString });
      AppMethodBeat.o(101753);
      return false;
    }
    String str = z.a(paramvy.GnL);
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(101753);
      return false;
    }
    ae.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[] { str, Integer.valueOf(paramvy.GnJ.size()) });
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(str);
    if ((paramString != null) && (paramvy.GnJ.size() > 0) && (paramString.aGE().contains(((vz)paramvy.GnJ.get(0)).nIJ)))
    {
      str = ((vz)paramvy.GnJ.get(0)).nIJ;
      com.tencent.mm.k.a.a.b localb = paramString.aUf(str);
      if (localb != null)
      {
        ae.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[] { str, localb.fXp });
        localb.fXr = ((vz)paramvy.GnJ.get(0)).GnQ;
        a(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(101753);
        return true;
        ae.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[] { str });
      }
    }
    if ((paramString != null) && (paramvy.GnJ.size() > 0))
    {
      paramString = new bb();
      paramString.dmX.username = ((vz)paramvy.GnJ.get(0)).nIJ;
      paramString.dmX.dmY = ((vz)paramvy.GnJ.get(0)).GnQ;
      hHL.put(str + "#" + paramString.dmX.username, paramString.dmX.dmY);
      com.tencent.mm.sdk.b.a.IvT.l(paramString);
      AppMethodBeat.o(101753);
      return false;
    }
    if (paramvy.GnJ.size() <= 0) {
      ae.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
    }
    if (paramString != null) {
      ae.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
    }
    AppMethodBeat.o(101753);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, vy paramvy, int paramInt1, int paramInt2, String paramString3, com.tencent.mm.k.a.a.a parama, com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(209886);
    if ((!paramString1.toLowerCase().endsWith("@chatroom")) && (!paramString1.toLowerCase().endsWith("@im.chatroom")) && (!paramString1.toLowerCase().endsWith("@groupcard")) && (!paramString1.toLowerCase().endsWith("@talkroom")))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] listCnt:" + paramvy.fNf);
      AppMethodBeat.o(209886);
      return false;
    }
    bq localbq = ((l)g.ab(l.class)).azF();
    ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString1);
    if (localac != null) {}
    ArrayList localArrayList;
    long l1;
    boolean bool1;
    vz localvz;
    an localan;
    for (parama.dBr = localac.ftN();; parama.dBr = 0)
    {
      localArrayList = new ArrayList();
      ae.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] memCnt:" + paramvy.fNf);
      l1 = System.currentTimeMillis();
      i = 0;
      bool1 = false;
      for (;;)
      {
        if (i >= paramvy.fNf) {
          break label637;
        }
        localvz = (vz)paramvy.GnJ.get(i);
        localan = localbq.BH(localvz.nIJ);
        if (localan != null) {
          break;
        }
        ae.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
        i += 1;
      }
    }
    com.tencent.mm.k.a.a.b localb = new com.tencent.mm.k.a.a.b();
    localb.userName = localvz.nIJ;
    localb.fXr = localvz.GnQ;
    localb.fXq = localvz.GnP;
    boolean bool2;
    if (paramvy.GnK == 0)
    {
      localb.fXp = localvz.GnM;
      if (!bu.isNullOrNil(localvz.GnO))
      {
        com.tencent.mm.aj.i locali = p.aEN().DL(localvz.nIJ);
        localObject = locali;
        if (locali == null)
        {
          localObject = new com.tencent.mm.aj.i();
          ((com.tencent.mm.aj.i)localObject).username = localvz.nIJ;
        }
        ((com.tencent.mm.aj.i)localObject).hPQ = localvz.GnN;
        ((com.tencent.mm.aj.i)localObject).hPP = localvz.GnO;
        ((com.tencent.mm.aj.i)localObject).eQU = 3;
        if (bu.isNullOrNil(localvz.GnN)) {
          break label621;
        }
        bool2 = true;
        label424:
        ((com.tencent.mm.aj.i)localObject).eD(bool2);
        p.aEN().b((com.tencent.mm.aj.i)localObject);
      }
    }
    if (localac != null)
    {
      localObject = localac.aUf(localvz.nIJ);
      if (localObject != null)
      {
        localb.fXp = ((com.tencent.mm.k.a.a.b)localObject).fXp;
        if (!bu.isNullOrNil(localb.fXr)) {
          break label627;
        }
      }
    }
    label621:
    label627:
    for (Object localObject = ((com.tencent.mm.k.a.a.b)localObject).fXr;; localObject = localb.fXr)
    {
      localb.fXr = ((String)localObject);
      parama.fXm.add(localb);
      ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).bB(localvz.GnR, localvz.GnS);
      if ((int)localan.ght == 0)
      {
        localan.setUsername(localvz.nIJ);
        if (localvz.nJO != null) {
          localan.to(localvz.nJO);
        }
        localan.tx(localvz.GnR);
        localan.tw(localvz.GnS);
        localan.acR();
        localbq.an(localan);
        bool1 = true;
      }
      localArrayList.add(localan.field_username);
      break;
      bool2 = false;
      break label424;
    }
    label637:
    ae.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + localArrayList.size() + " event: " + paramb + " publish: " + bool1 + " take[" + (System.currentTimeMillis() - l1) + "]ms");
    label827:
    long l2;
    if (bool1)
    {
      com.tencent.mm.roomsdk.a.b.aRc(paramString1).G(paramString1, parama.dBr).cAs();
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString1);
      paramb = (com.tencent.mm.sdk.b.b)localObject;
      if (localObject == null) {
        paramb = new ac();
      }
      i = paramb.field_chatroomStatus;
      l1 = System.currentTimeMillis();
      paramb.field_chatroomname = paramString1;
      paramb.field_roomowner = paramString2;
      localObject = paramb.hA(localArrayList);
      ((ac)localObject).field_chatroomStatus = paramInt1;
      ((ac)localObject).field_displayname = ae(localArrayList);
      if (paramvy.GnK == 0) {
        break label1112;
      }
      bool1 = true;
      ((ac)localObject).a(paramString3, parama, bool1).field_memberCount = localArrayList.size();
      if (paramInt2 != -1) {
        paramb.field_chatroomVersion = paramInt2;
      }
      paramInt2 = paramb.field_memberCount;
      if ((aAy()) && (!bu.isNullOrNil(paramString1)))
      {
        if (!ay.aRW("room_upgrade_to_wework").getBoolean(paramString1, false)) {
          break label1118;
        }
        ae.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString1 });
      }
      label907:
      bool1 = a(paramb);
      if ((bool1) && (paramInt1 != i)) {
        x.zY(paramString1);
      }
      l2 = System.currentTimeMillis();
      bool2 = paramb.ftO();
      if (paramb.ftL() != null) {
        break label1130;
      }
      paramInt2 = 0;
      label952:
      if (paramb.ftL() != null) {
        break label1143;
      }
    }
    label1112:
    label1118:
    label1130:
    label1143:
    for (int i = 0;; i = paramb.ftL().fXo)
    {
      ae.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s chatroomStatus:%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2 - l1), Boolean.valueOf(bool2), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt1) });
      if (paramb.ftO())
      {
        ae.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[] { Integer.valueOf(paramb.ftN()) });
        paramString2 = new ba();
        paramString2.dmW.username = paramString1;
        com.tencent.mm.sdk.b.a.IvT.l(paramString2);
      }
      AppMethodBeat.o(209886);
      return bool1;
      if (localac != null) {
        break;
      }
      com.tencent.mm.roomsdk.a.b.aRc(paramString1).G(paramString1, 0).cAs();
      break;
      bool1 = false;
      break label827;
      a(paramString1, paramString2, paramInt2, paramInt1, null);
      break label907;
      paramInt2 = paramb.ftL().dBr;
      break label952;
    }
  }
  
  public static boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    int i = 0;
    int k = 0;
    AppMethodBeat.i(101761);
    al localal = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
    ac localac = localal.By(paramString1);
    if ((paramString1.endsWith("@chatroom")) || (paramString1.endsWith("@im.chatroom"))) {}
    LinkedList localLinkedList;
    int j;
    for (paramString1 = zA(paramString1);; paramString1 = new LinkedList())
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
    if (!bu.isNullOrNil(paramString2)) {
      localac.field_roomowner = paramString2;
    }
    paramString1 = localac.hA(localLinkedList);
    paramString1.field_displayname = ae(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    boolean bool = localal.replace(localac);
    AppMethodBeat.o(101761);
    return bool;
    label231:
    while (i < paramArrayList.size())
    {
      localLinkedList.add(paramArrayList.get(i));
      i += 1;
    }
    if (!bu.isNullOrNil(paramString2)) {
      localac.field_roomowner = paramString2;
    }
    paramString1 = localac.hA(localLinkedList);
    paramString1.field_displayname = ae(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    localac.field_roomowner = paramString2;
    bool = localal.replace(localac);
    ae.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101761);
    return bool;
  }
  
  public static void aAv()
  {
    AppMethodBeat.i(184633);
    PluginNewTips.removeLocalNewTipsCallback(d.wIi);
    AppMethodBeat.o(184633);
  }
  
  public static boolean aAw()
  {
    AppMethodBeat.i(184636);
    boolean bool = ay.aRW("room_upgrade_to_wework").getBoolean("enter_show", false);
    AppMethodBeat.o(184636);
    return bool;
  }
  
  public static int aAx()
  {
    AppMethodBeat.i(184637);
    int i = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("AssociateChatRoomLocalCheckMaxMemberCount", 200);
    AppMethodBeat.o(184637);
    return i;
  }
  
  public static boolean aAy()
  {
    AppMethodBeat.i(209888);
    if (((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("MMForwardUpgradeChatRoomSwitch", 0) == 1)
    {
      AppMethodBeat.o(209888);
      return true;
    }
    AppMethodBeat.o(209888);
    return false;
  }
  
  public static String aD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101754);
    paramString1 = paramString2 + "#" + paramString1;
    if (hHL.aN(paramString1))
    {
      paramString1 = (String)hHL.get(paramString1);
      AppMethodBeat.o(101754);
      return paramString1;
    }
    AppMethodBeat.o(101754);
    return "";
  }
  
  private static void aE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101756);
    ae.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[] { Integer.valueOf(1) });
    bq localbq = ((l)g.ab(l.class)).azF();
    an localan = localbq.BH(paramString1);
    if (((int)localan.ght != 0) && (!bu.isNullOrNil(paramString2)) && (!bu.isNullOrNil(v.aAC())))
    {
      if (!paramString2.equals(v.aAC())) {
        break label103;
      }
      localan.lP(1);
    }
    for (;;)
    {
      localbq.c(paramString1, localan);
      AppMethodBeat.o(101756);
      return;
      label103:
      localan.lP(0);
    }
  }
  
  public static String ae(List<String> paramList)
  {
    AppMethodBeat.i(101747);
    paramList = e(paramList, -1);
    AppMethodBeat.o(101747);
    return paramList;
  }
  
  public static void ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(101774);
    al localal = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
    ac localac = localal.Bx(paramString);
    if (localac == null)
    {
      AppMethodBeat.o(101774);
      return;
    }
    com.tencent.mm.k.a.a.a locala = localac.ftS();
    locala.type = paramInt;
    localac.a(paramString, locala, false);
    localal.replace(localac);
    AppMethodBeat.o(101774);
  }
  
  public static String af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101768);
    al localal = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
    if (localal == null)
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
      AppMethodBeat.o(101768);
      return null;
    }
    paramString2 = localal.Bx(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(101768);
      return null;
    }
    paramString1 = paramString2.zP(paramString1);
    AppMethodBeat.o(101768);
    return paramString1;
  }
  
  private static void af(String paramString, int paramInt)
  {
    AppMethodBeat.i(184638);
    cj localcj = new cj();
    localcj.mb(paramString);
    localcj.edT = paramInt;
    localcj.aLH();
    AppMethodBeat.o(184638);
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
      localObject2 = ((l)g.ab(l.class)).azF().BH((String)localObject2);
      localObject2 = (String)localObject1 + ((an)localObject2).adG();
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
      localObject1 = (String)localObject2 + ak.getContext().getString(2131757106);
    }
    label214:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public static boolean g(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(101743);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101743);
      return false;
    }
    Iterator localIterator = paramString.aGE().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, paramString.zP(str));
    }
    AppMethodBeat.o(101743);
    return true;
  }
  
  public static List<String> zA(String paramString)
  {
    AppMethodBeat.i(101763);
    if (paramString == null)
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
      AppMethodBeat.o(101763);
      return null;
    }
    if (!zq(paramString))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + paramString + "]");
      AppMethodBeat.o(101763);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().BB(paramString);
    AppMethodBeat.o(101763);
    return paramString;
  }
  
  public static List<String> zB(String paramString)
  {
    AppMethodBeat.i(101764);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101764);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().BB(paramString);
    AppMethodBeat.o(101764);
    return paramString;
  }
  
  public static int zC(String paramString)
  {
    AppMethodBeat.i(101765);
    long l = System.currentTimeMillis();
    try
    {
      al localal = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
      if (localal != null)
      {
        int i = localal.BE(paramString);
        return i;
      }
      return 0;
    }
    finally
    {
      ae.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(101765);
    }
  }
  
  public static List<String> zD(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(101766);
    if (!zq(paramString))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101766);
      return null;
    }
    paramString = zA(paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      AppMethodBeat.o(101766);
      return null;
    }
    String str = (String)g.ajR().ajA().get(2, null);
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
  
  public static String zE(String paramString)
  {
    AppMethodBeat.i(101769);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101769);
      return null;
    }
    paramString = paramString.field_chatroomnotice;
    AppMethodBeat.o(101769);
    return paramString;
  }
  
  public static boolean zF(String paramString)
  {
    AppMethodBeat.i(209887);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (paramString == null)
    {
      ae.w("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo member is null");
      AppMethodBeat.o(209887);
      return false;
    }
    ae.i("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo old:%s new:%s", new Object[] { Integer.valueOf(paramString.field_oldChatroomVersion), Integer.valueOf(paramString.field_chatroomVersion) });
    if (paramString.field_oldChatroomVersion < paramString.field_chatroomVersion)
    {
      AppMethodBeat.o(209887);
      return true;
    }
    AppMethodBeat.o(209887);
    return false;
  }
  
  public static String zG(String paramString)
  {
    AppMethodBeat.i(101771);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101771);
      return null;
    }
    paramString = paramString.field_chatroomnoticeEditor;
    AppMethodBeat.o(101771);
    return paramString;
  }
  
  public static long zH(String paramString)
  {
    AppMethodBeat.i(101772);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101772);
      return -1L;
    }
    long l = paramString.field_chatroomnoticePublishTime;
    AppMethodBeat.o(101772);
    return l;
  }
  
  public static void zI(String paramString)
  {
    AppMethodBeat.i(209889);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail username is null");
      AppMethodBeat.o(209889);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (localObject != null) {
      if (((ac)localObject).field_oldChatroomVersion >= ((ac)localObject).field_chatroomVersion) {
        break label125;
      }
    }
    label125:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ae.i("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail() %s update, stack:%s", new Object[] { paramString, bu.fpN().toString() });
        localObject = new iu();
        ((iu)localObject).dww.dwx = paramString;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      AppMethodBeat.o(209889);
      return;
    }
  }
  
  private static boolean zq(String paramString)
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
  
  public static boolean zr(String paramString)
  {
    AppMethodBeat.i(101742);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101742);
      return false;
    }
    boolean bool = paramString.ftR();
    AppMethodBeat.o(101742);
    return bool;
  }
  
  public static boolean zs(String paramString)
  {
    AppMethodBeat.i(101744);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bz(paramString);
    String str = v.aAC();
    if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(str)) && (paramString.equals(str)))
    {
      AppMethodBeat.o(101744);
      return true;
    }
    AppMethodBeat.o(101744);
    return false;
  }
  
  public static String zt(String paramString)
  {
    AppMethodBeat.i(101746);
    if ((paramString == null) || (!zq(paramString)))
    {
      AppMethodBeat.o(101746);
      return "";
    }
    List localList = zA(paramString);
    paramString = "";
    int i = 0;
    String str;
    an localan;
    if ((localList != null) && (i < localList.size()))
    {
      str = (String)localList.get(i);
      if (str.length() <= 0) {
        break label198;
      }
      localan = ((l)g.ab(l.class)).azF().BH(str);
      if (localan == null)
      {
        str = paramString + str;
        label116:
        paramString = str;
        if (i < localList.size() - 1) {
          paramString = str + ak.getContext().getString(2131757106);
        }
      }
    }
    label198:
    for (;;)
    {
      i += 1;
      break;
      str = paramString + localan.adF();
      break label116;
      AppMethodBeat.o(101746);
      return paramString;
    }
  }
  
  public static boolean zu(String paramString)
  {
    AppMethodBeat.i(101749);
    boolean bool = B(paramString, false);
    AppMethodBeat.o(101749);
    return bool;
  }
  
  public static boolean zv(String paramString)
  {
    AppMethodBeat.i(101750);
    if (!x.zT(paramString))
    {
      AppMethodBeat.o(101750);
      return false;
    }
    if (!((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().BC(paramString))
    {
      ae.d("MicroMsg.ChatroomMembersLogic", "state is die");
      AppMethodBeat.o(101750);
      return true;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().BB(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(101750);
      return true;
    }
    AppMethodBeat.o(101750);
    return false;
  }
  
  public static boolean zw(String paramString)
  {
    AppMethodBeat.i(101751);
    if (!x.zT(paramString))
    {
      AppMethodBeat.o(101751);
      return false;
    }
    ae.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[] { paramString });
    al localal = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
    paramString = localal.Bx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101751);
      return false;
    }
    paramString.field_roomflag = 1;
    boolean bool = localal.replace(paramString);
    AppMethodBeat.o(101751);
    return bool;
  }
  
  public static boolean zx(String paramString)
  {
    AppMethodBeat.i(101759);
    if (!paramString.toLowerCase().endsWith("@groupcard"))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + paramString + "]");
      AppMethodBeat.o(101759);
      return false;
    }
    bq localbq = ((l)g.ab(l.class)).azF();
    if (localbq.aUO(paramString)) {
      localbq.aUS(paramString);
    }
    for (;;)
    {
      boolean bool = zz(paramString);
      AppMethodBeat.o(101759);
      return bool;
      ae.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + paramString + "]");
    }
  }
  
  public static boolean zy(String paramString)
  {
    AppMethodBeat.i(101760);
    if (!zq(paramString))
    {
      ae.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + paramString + "]");
      AppMethodBeat.o(101760);
      return false;
    }
    bq localbq = ((l)g.ab(l.class)).azF();
    if (localbq.aUO(paramString)) {
      localbq.aUS(paramString);
    }
    for (;;)
    {
      boolean bool = zz(paramString);
      AppMethodBeat.o(101760);
      return bool;
      ae.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + paramString + "]");
    }
  }
  
  private static boolean zz(String paramString)
  {
    AppMethodBeat.i(101762);
    boolean bool = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().BD(paramString);
    AppMethodBeat.o(101762);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.r
 * JD-Core Version:    0.7.0.1
 */