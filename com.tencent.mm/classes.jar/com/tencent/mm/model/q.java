package com.tencent.mm.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.b.f;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.az.a;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.plugin.newtips.a.d;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class q
{
  public static f<String, String> hmF;
  
  static
  {
    AppMethodBeat.i(101775);
    hmF = new com.tencent.mm.b.h(100);
    AppMethodBeat.o(101775);
  }
  
  public static boolean B(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(209958);
    String str = (String)g.agR().agA().get(2, null);
    paramString = vZ(paramString);
    if (paramString == null)
    {
      ac.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
      if (paramBoolean)
      {
        ac.w("MicroMsg.ChatroomMembersLogic", "isInChatRoom temp change");
        AppMethodBeat.o(209958);
        return true;
      }
      AppMethodBeat.o(209958);
      return false;
    }
    if ((paramString.size() == 0) || (!paramString.contains(str)))
    {
      ac.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + paramString.size() + " ");
      AppMethodBeat.o(209958);
      return false;
    }
    AppMethodBeat.o(209958);
    return true;
  }
  
  public static boolean GN(String paramString)
  {
    AppMethodBeat.i(210530);
    paramString = ((c)g.ab(c.class)).awK().xN(paramString);
    if (paramString == null)
    {
      ac.w("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo member is null");
      AppMethodBeat.o(210530);
      return false;
    }
    ac.i("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo old:%s new:%s", new Object[] { Integer.valueOf(paramString.field_oldChatroomVersion), Integer.valueOf(paramString.field_chatroomVersion) });
    if (paramString.field_oldChatroomVersion < paramString.field_chatroomVersion)
    {
      AppMethodBeat.o(210530);
      return true;
    }
    AppMethodBeat.o(210530);
    return false;
  }
  
  public static void IJ(String paramString)
  {
    AppMethodBeat.i(210531);
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail username is null");
      AppMethodBeat.o(210531);
      return;
    }
    Object localObject = ((c)g.ab(c.class)).awK().xN(paramString);
    if (localObject != null) {
      if (((x)localObject).field_oldChatroomVersion >= ((x)localObject).field_chatroomVersion) {
        break label120;
      }
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ac.i("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail() %s update, stack:%s", new Object[] { paramString, com.tencent.mm.sdk.platformtools.bs.eWi().toString() });
        localObject = new il();
        ((il)localObject).djE.djF = paramString;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
      AppMethodBeat.o(210531);
      return;
    }
  }
  
  public static com.tencent.mm.storage.ai a(com.tencent.mm.storage.ai paramai, bue parambue)
  {
    AppMethodBeat.i(101767);
    paramai.setUsername(z.a(parambue.EuJ));
    paramai.qj(z.a(parambue.EuJ));
    paramai.qk(z.a(parambue.EuJ));
    paramai.ql(z.a(parambue.EtZ));
    paramai.jH(parambue.iJT);
    paramai.qh(z.a(parambue.Fkk));
    paramai.qo(z.a(parambue.Fkl));
    paramai.qn(z.a(parambue.EtZ));
    paramai.jJ(parambue.Etq);
    paramai.jL(parambue.iJX);
    paramai.qG(RegionCodeDecoder.aW(parambue.iKc, parambue.iJU, parambue.iJV));
    paramai.qA(parambue.iJW);
    AppMethodBeat.o(101767);
    return paramai;
  }
  
  public static void a(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184634);
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184634);
      return;
    }
    if (aw.aKT("room_upgrade_to_wework").getBoolean(paramString, false))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    x localx = ((c)g.ab(c.class)).awK().xN(paramString);
    if (localx == null)
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member is null", new Object[] { paramString });
      AppMethodBeat.o(184634);
      return;
    }
    a(paramString, localx.field_roomowner, localx.field_memberCount, localx.field_chatroomStatus, parama);
    AppMethodBeat.o(184634);
  }
  
  public static void a(String paramString, x paramx, boolean paramBoolean)
  {
    AppMethodBeat.i(101745);
    paramx.wc(paramBoolean);
    ((c)g.ab(c.class)).awK().update(paramx, new String[0]);
    paramx = u.axw();
    com.tencent.mm.roomsdk.a.b.aJZ(paramString).b(paramString, paramx, paramBoolean).csU();
    bux localbux = new bux();
    localbux.DPx = paramString;
    localbux.ncR = paramx;
    localbux.FkC = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbux.wTE = i;
      ((k)g.ab(k.class)).awA().c(new j.a(49, localbux));
      AppMethodBeat.o(101745);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, PluginNewTips.a parama)
  {
    int i = 1;
    AppMethodBeat.i(184635);
    int j;
    if ((w.wp(paramString1)) && ((paramInt2 & 0x20000) != 131072L) && ((paramInt2 & 0x10000) == 65536L))
    {
      aw.aKT("room_upgrade_to_wework").putBoolean(paramString1, true);
      boolean bool = com.tencent.mm.openim.room.a.a.aMo();
      j = axs();
      ac.i("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom chatRoomName:%s chatroomOwner:%s chatroomStatus:%s isInstallWeWork:%s maxNum:%s", new Object[] { paramString1, com.tencent.mm.sdk.platformtools.bs.bG(paramString2, "null"), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((bool) && (paramInt1 < j) && (com.tencent.mm.sdk.platformtools.bs.lr(paramString2, u.axw())))
      {
        com.tencent.mm.plugin.newtips.a.dkb();
        com.tencent.mm.plugin.newtips.a.i.b(d.vnh, parama);
        aw.aKT("room_upgrade_to_wework").putBoolean("enter_show", true);
        parama = com.tencent.mm.sdk.platformtools.ai.getResources().getString(2131757109);
        String str = com.tencent.mm.sdk.platformtools.ai.getResources().getString(2131757111);
        paramString2 = new StringBuffer();
        paramString2.append(parama).append(" ");
        paramString2.append("<_wc_custom_link_ href=\"weixin://weixingroupupdate?roomname=").append(paramString1).append("\">").append(str).append("</_wc_custom_link_>");
        parama = new bo();
        parama.jT(0);
        parama.re(paramString1);
        parama.setStatus(3);
        parama.setContent(paramString2.toString());
        parama.oA(bi.z(paramString1, System.currentTimeMillis() / 1000L));
        parama.setType(10000);
        parama.setFlag(parama.field_flag | 0x8);
        bi.u(parama);
        ab(paramString1, 0);
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
      if (!com.tencent.mm.sdk.platformtools.bs.lr(paramString2, u.axw())) {
        paramInt2 = i | 0x2;
      }
      i = paramInt2;
      if (paramInt1 >= j) {
        i = paramInt2 | 0x4;
      }
      ab(paramString1, i);
      AppMethodBeat.o(184635);
      return;
      label372:
      i = 0;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101773);
    aj localaj = ((c)g.ab(c.class)).awK();
    x localx = localaj.xN(paramString1);
    if (localx == null)
    {
      AppMethodBeat.o(101773);
      return;
    }
    String str = localx.field_chatroomnotice;
    localx.field_oldChatroomVersion = paramInt1;
    localx.field_chatroomnoticePublishTime = paramLong;
    localx.field_chatroomnoticeEditor = paramString3;
    localx.field_chatroomnotice = paramString2;
    localx.field_chatroomStatus = paramInt2;
    localaj.replace(localx);
    if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString2)) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(str)))
    {
      g.agS();
      paramString2 = ((k)g.ab(k.class)).awB().aNt(paramString1);
      paramLong = paramString2.eys;
      paramString2.ot(0L);
      g.agS();
      ((k)g.ab(k.class)).awB().af(paramString2);
      ac.i("MicroMsg.ChatroomMembersLogic", "clear room card, oldInfoId %s", new Object[] { Long.valueOf(paramLong) });
      if (paramLong != 0L)
      {
        paramString2 = ((k)g.ab(k.class)).dcr().vP(paramLong);
        if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString2.eSo)) {
          ((r)g.ab(r.class)).aa(paramString1, paramString2.eSo);
        }
      }
    }
    AppMethodBeat.o(101773);
  }
  
  public static boolean a(x paramx)
  {
    AppMethodBeat.i(101755);
    if (paramx == null)
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
      AppMethodBeat.o(101755);
      return false;
    }
    boolean bool = ((c)g.ab(c.class)).awK().replace(paramx);
    if (bool) {
      aC(paramx.field_chatroomname, paramx.field_roomowner);
    }
    AppMethodBeat.o(101755);
    return bool;
  }
  
  public static boolean a(String paramString, aau paramaau)
  {
    AppMethodBeat.i(101757);
    if ((!vP(paramString)) || (paramaau.fsB == 0))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + paramString + "] listCnt:" + paramaau.fsB);
      AppMethodBeat.o(101757);
      return false;
    }
    aj localaj = ((c)g.ab(c.class)).awK();
    paramString = localaj.xN(paramString);
    List localList = x.aMX(paramString.field_memberlist);
    ac.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + localList.size());
    paramaau = paramaau.DPz.iterator();
    while (paramaau.hasNext()) {
      localList.remove(z.a(((abe)paramaau.next()).EuJ));
    }
    ac.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + localList.size());
    paramaau = paramString.he(localList);
    paramaau.field_displayname = ad(localList);
    paramaau.field_memberCount = localList.size();
    boolean bool = localaj.replace(paramString);
    ac.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101757);
    return bool;
  }
  
  public static boolean a(String paramString, cj paramcj)
  {
    AppMethodBeat.i(101758);
    if ((!vP(paramString)) || (paramcj.fsB == 0))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + paramString + "] listCnt:" + paramcj.fsB);
      AppMethodBeat.o(101758);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    bj localbj = ((k)g.ab(k.class)).awB();
    int i = 0;
    while (i < paramcj.fsB)
    {
      Object localObject = z.a(((bue)paramcj.DPz.get(i)).EuJ);
      if (((bue)paramcj.DPz.get(i)).Fkj == 0)
      {
        if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject)) {
          ac.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", new Object[] { paramString });
        }
      }
      else
      {
        i += 1;
        continue;
      }
      localObject = localbj.aNt((String)localObject);
      if ((int)((com.tencent.mm.n.b)localObject).fLJ != 0)
      {
        ((com.tencent.mm.storage.ai)localObject).aae();
        localbj.c(((av)localObject).field_username, (com.tencent.mm.storage.ai)localObject);
      }
      for (;;)
      {
        localArrayList.add(((av)localObject).field_username);
        break;
        localObject = a((com.tencent.mm.storage.ai)localObject, (bue)paramcj.DPz.get(i));
        localbj.ag((com.tencent.mm.storage.ai)localObject);
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
  
  public static boolean a(String paramString, ua paramua)
  {
    AppMethodBeat.i(101753);
    if (paramua == null)
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
      AppMethodBeat.o(101753);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
      AppMethodBeat.o(101753);
      return false;
    }
    if (w.sQ(paramString))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[] { paramString });
      AppMethodBeat.o(101753);
      return false;
    }
    String str = z.a(paramua.Eod);
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(str))
    {
      AppMethodBeat.o(101753);
      return false;
    }
    ac.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[] { str, Integer.valueOf(paramua.Eob.size()) });
    paramString = ((c)g.ab(c.class)).awK().xN(str);
    if ((paramString != null) && (paramua.Eob.size() > 0) && (paramString.aDl().contains(((ub)paramua.Eob.get(0)).ncR)))
    {
      str = ((ub)paramua.Eob.get(0)).ncR;
      com.tencent.mm.j.a.a.b localb = paramString.aMT(str);
      if (localb != null)
      {
        ac.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[] { str, localb.fBV });
        localb.fBX = ((ub)paramua.Eob.get(0)).Eoi;
        a(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(101753);
        return true;
        ac.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[] { str });
      }
    }
    if ((paramString != null) && (paramua.Eob.size() > 0))
    {
      paramString = new az();
      paramString.daB.username = ((ub)paramua.Eob.get(0)).ncR;
      paramString.daB.daC = ((ub)paramua.Eob.get(0)).Eoi;
      hmF.put(str + "#" + paramString.daB.username, paramString.daB.daC);
      com.tencent.mm.sdk.b.a.GpY.l(paramString);
      AppMethodBeat.o(101753);
      return false;
    }
    if (paramua.Eob.size() <= 0) {
      ac.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
    }
    if (paramString != null) {
      ac.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
    }
    AppMethodBeat.o(101753);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, ua paramua, int paramInt1, int paramInt2, String paramString3, com.tencent.mm.j.a.a.a parama, com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(210529);
    if ((!paramString1.toLowerCase().endsWith("@chatroom")) && (!paramString1.toLowerCase().endsWith("@im.chatroom")) && (!paramString1.toLowerCase().endsWith("@groupcard")) && (!paramString1.toLowerCase().endsWith("@talkroom")))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] listCnt:" + paramua.fsB);
      AppMethodBeat.o(210529);
      return false;
    }
    bj localbj = ((k)g.ab(k.class)).awB();
    x localx = ((c)g.ab(c.class)).awK().xN(paramString1);
    if (localx != null) {}
    ArrayList localArrayList;
    long l1;
    boolean bool1;
    ub localub;
    com.tencent.mm.storage.ai localai;
    for (parama.doy = localx.eZL();; parama.doy = 0)
    {
      localArrayList = new ArrayList();
      ac.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] memCnt:" + paramua.fsB);
      l1 = System.currentTimeMillis();
      i = 0;
      bool1 = false;
      for (;;)
      {
        if (i >= paramua.fsB) {
          break label637;
        }
        localub = (ub)paramua.Eob.get(i);
        localai = localbj.aNt(localub.ncR);
        if (localai != null) {
          break;
        }
        ac.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
        i += 1;
      }
    }
    com.tencent.mm.j.a.a.b localb = new com.tencent.mm.j.a.a.b();
    localb.userName = localub.ncR;
    localb.fBX = localub.Eoi;
    localb.fBW = localub.Eoh;
    boolean bool2;
    if (paramua.Eoc == 0)
    {
      localb.fBV = localub.Eoe;
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(localub.Eog))
      {
        com.tencent.mm.aj.i locali = p.aBw().Ak(localub.ncR);
        localObject = locali;
        if (locali == null)
        {
          localObject = new com.tencent.mm.aj.i();
          ((com.tencent.mm.aj.i)localObject).username = localub.ncR;
        }
        ((com.tencent.mm.aj.i)localObject).huF = localub.Eof;
        ((com.tencent.mm.aj.i)localObject).huE = localub.Eog;
        ((com.tencent.mm.aj.i)localObject).exK = 3;
        if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(localub.Eof)) {
          break label621;
        }
        bool2 = true;
        label424:
        ((com.tencent.mm.aj.i)localObject).ez(bool2);
        p.aBw().b((com.tencent.mm.aj.i)localObject);
      }
    }
    if (localx != null)
    {
      localObject = localx.aMT(localub.ncR);
      if (localObject != null)
      {
        localb.fBV = ((com.tencent.mm.j.a.a.b)localObject).fBV;
        if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(localb.fBX)) {
          break label627;
        }
      }
    }
    label621:
    label627:
    for (Object localObject = ((com.tencent.mm.j.a.a.b)localObject).fBX;; localObject = localb.fBX)
    {
      localb.fBX = ((String)localObject);
      parama.fBS.add(localb);
      ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bA(localub.Eoj, localub.Eok);
      if ((int)localai.fLJ == 0)
      {
        localai.setUsername(localub.ncR);
        if (localub.ndW != null) {
          localai.qj(localub.ndW);
        }
        localai.qs(localub.Eoj);
        localai.qr(localub.Eok);
        localai.aae();
        localbj.ag(localai);
        bool1 = true;
      }
      localArrayList.add(localai.field_username);
      break;
      bool2 = false;
      break label424;
    }
    label637:
    ac.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + localArrayList.size() + " event: " + paramb + " publish: " + bool1 + " take[" + (System.currentTimeMillis() - l1) + "]ms");
    label820:
    long l2;
    if (bool1)
    {
      com.tencent.mm.roomsdk.a.b.aJZ(paramString1).D(paramString1, parama.doy).csU();
      localObject = ((c)g.ab(c.class)).awK().xN(paramString1);
      paramb = (com.tencent.mm.sdk.b.b)localObject;
      if (localObject == null) {
        paramb = new x();
      }
      l1 = System.currentTimeMillis();
      paramb.field_chatroomname = paramString1;
      paramb.field_roomowner = paramString2;
      localObject = paramb.he(localArrayList);
      ((x)localObject).field_chatroomStatus = paramInt1;
      ((x)localObject).field_displayname = ad(localArrayList);
      if (paramua.Eoc == 0) {
        break label1086;
      }
      bool1 = true;
      ((x)localObject).a(paramString3, parama, bool1).field_memberCount = localArrayList.size();
      if (paramInt2 != -1) {
        paramb.field_chatroomVersion = paramInt2;
      }
      paramInt2 = paramb.field_memberCount;
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString1))
      {
        if (!aw.aKT("room_upgrade_to_wework").getBoolean(paramString1, false)) {
          break label1092;
        }
        ac.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", new Object[] { paramString1 });
      }
      label896:
      bool1 = a(paramb);
      l2 = System.currentTimeMillis();
      bool2 = paramb.eZM();
      if (paramb.eZJ() != null) {
        break label1104;
      }
      paramInt2 = 0;
      label926:
      if (paramb.eZJ() != null) {
        break label1117;
      }
    }
    label1086:
    label1092:
    label1104:
    label1117:
    for (int i = 0;; i = paramb.eZJ().fBU)
    {
      ac.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s chatroomStatus:%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2 - l1), Boolean.valueOf(bool2), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt1) });
      if (paramb.eZM())
      {
        ac.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[] { Integer.valueOf(paramb.eZL()) });
        paramString2 = new ay();
        paramString2.daA.username = paramString1;
        com.tencent.mm.sdk.b.a.GpY.l(paramString2);
      }
      AppMethodBeat.o(210529);
      return bool1;
      if (localx != null) {
        break;
      }
      com.tencent.mm.roomsdk.a.b.aJZ(paramString1).D(paramString1, 0).csU();
      break;
      bool1 = false;
      break label820;
      a(paramString1, paramString2, paramInt2, paramInt1, null);
      break label896;
      paramInt2 = paramb.eZJ().doy;
      break label926;
    }
  }
  
  public static boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    int i = 0;
    int k = 0;
    AppMethodBeat.i(101761);
    aj localaj = ((c)g.ab(c.class)).awK();
    x localx = localaj.xO(paramString1);
    if ((paramString1.endsWith("@chatroom")) || (paramString1.endsWith("@im.chatroom"))) {}
    LinkedList localLinkedList;
    int j;
    for (paramString1 = vZ(paramString1);; paramString1 = new LinkedList())
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
    if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString2)) {
      localx.field_roomowner = paramString2;
    }
    paramString1 = localx.he(localLinkedList);
    paramString1.field_displayname = ad(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    boolean bool = localaj.replace(localx);
    AppMethodBeat.o(101761);
    return bool;
    label231:
    while (i < paramArrayList.size())
    {
      localLinkedList.add(paramArrayList.get(i));
      i += 1;
    }
    if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString2)) {
      localx.field_roomowner = paramString2;
    }
    paramString1 = localx.he(localLinkedList);
    paramString1.field_displayname = ad(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    localx.field_roomowner = paramString2;
    bool = localaj.replace(localx);
    ac.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(bool)));
    AppMethodBeat.o(101761);
    return bool;
  }
  
  public static String aB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101754);
    paramString1 = paramString2 + "#" + paramString1;
    if (hmF.aL(paramString1))
    {
      paramString1 = (String)hmF.get(paramString1);
      AppMethodBeat.o(101754);
      return paramString1;
    }
    AppMethodBeat.o(101754);
    return "";
  }
  
  private static void aC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101756);
    ac.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[] { Integer.valueOf(1) });
    bj localbj = ((k)g.ab(k.class)).awB();
    com.tencent.mm.storage.ai localai = localbj.aNt(paramString1);
    if (((int)localai.fLJ != 0) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString2)) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(u.axw())))
    {
      if (!paramString2.equals(u.axw())) {
        break label103;
      }
      localai.lo(1);
    }
    for (;;)
    {
      localbj.c(paramString1, localai);
      AppMethodBeat.o(101756);
      return;
      label103:
      localai.lo(0);
    }
  }
  
  public static void aa(String paramString, int paramInt)
  {
    AppMethodBeat.i(101774);
    aj localaj = ((c)g.ab(c.class)).awK();
    x localx = localaj.xN(paramString);
    if (localx == null)
    {
      AppMethodBeat.o(101774);
      return;
    }
    com.tencent.mm.j.a.a.a locala = localx.eZQ();
    locala.type = paramInt;
    localx.a(paramString, locala, false);
    localaj.replace(localx);
    AppMethodBeat.o(101774);
  }
  
  private static void ab(String paramString, int paramInt)
  {
    AppMethodBeat.i(184638);
    com.tencent.mm.g.b.a.bs localbs = new com.tencent.mm.g.b.a.bs();
    localbs.jO(paramString);
    localbs.dNj = paramInt;
    localbs.aHZ();
    AppMethodBeat.o(184638);
  }
  
  public static String ad(List<String> paramList)
  {
    AppMethodBeat.i(101747);
    paramList = e(paramList, -1);
    AppMethodBeat.o(101747);
    return paramList;
  }
  
  public static String ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101768);
    aj localaj = ((c)g.ab(c.class)).awK();
    if (localaj == null)
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
      AppMethodBeat.o(101768);
      return null;
    }
    paramString2 = localaj.xN(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(101768);
      return null;
    }
    paramString1 = paramString2.wk(paramString1);
    AppMethodBeat.o(101768);
    return paramString1;
  }
  
  public static void axq()
  {
    AppMethodBeat.i(184633);
    PluginNewTips.removeLocalNewTipsCallback(d.vnh);
    AppMethodBeat.o(184633);
  }
  
  public static boolean axr()
  {
    AppMethodBeat.i(184636);
    boolean bool = aw.aKT("room_upgrade_to_wework").getBoolean("enter_show", false);
    AppMethodBeat.o(184636);
    return bool;
  }
  
  public static int axs()
  {
    AppMethodBeat.i(184637);
    int i = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("AssociateChatRoomLocalCheckMaxMemberCount", 200);
    AppMethodBeat.o(184637);
    return i;
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
      localObject2 = ((k)g.ab(k.class)).awB().aNt((String)localObject2);
      localObject2 = (String)localObject1 + ((com.tencent.mm.storage.ai)localObject2).aaS();
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
      localObject1 = (String)localObject2 + com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757106);
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
    paramString = ((c)g.ab(c.class)).awK().xN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101743);
      return false;
    }
    Iterator localIterator = paramString.aDl().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, paramString.wk(str));
    }
    AppMethodBeat.o(101743);
    return true;
  }
  
  private static boolean vP(String paramString)
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
  
  public static boolean vQ(String paramString)
  {
    AppMethodBeat.i(101742);
    paramString = ((c)g.ab(c.class)).awK().xN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101742);
      return false;
    }
    boolean bool = paramString.eZP();
    AppMethodBeat.o(101742);
    return bool;
  }
  
  public static boolean vR(String paramString)
  {
    AppMethodBeat.i(101744);
    paramString = ((c)g.ab(c.class)).awK().xP(paramString);
    String str = u.axw();
    if ((!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString)) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(str)) && (paramString.equals(str)))
    {
      AppMethodBeat.o(101744);
      return true;
    }
    AppMethodBeat.o(101744);
    return false;
  }
  
  public static String vS(String paramString)
  {
    AppMethodBeat.i(101746);
    if ((paramString == null) || (!vP(paramString)))
    {
      AppMethodBeat.o(101746);
      return "";
    }
    List localList = vZ(paramString);
    paramString = "";
    int i = 0;
    String str;
    com.tencent.mm.storage.ai localai;
    if ((localList != null) && (i < localList.size()))
    {
      str = (String)localList.get(i);
      if (str.length() <= 0) {
        break label198;
      }
      localai = ((k)g.ab(k.class)).awB().aNt(str);
      if (localai == null)
      {
        str = paramString + str;
        label116:
        paramString = str;
        if (i < localList.size() - 1) {
          paramString = str + com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757106);
        }
      }
    }
    label198:
    for (;;)
    {
      i += 1;
      break;
      str = paramString + localai.aaR();
      break label116;
      AppMethodBeat.o(101746);
      return paramString;
    }
  }
  
  public static boolean vT(String paramString)
  {
    AppMethodBeat.i(101749);
    boolean bool = B(paramString, false);
    AppMethodBeat.o(101749);
    return bool;
  }
  
  public static boolean vU(String paramString)
  {
    AppMethodBeat.i(101750);
    if (!w.wo(paramString))
    {
      AppMethodBeat.o(101750);
      return false;
    }
    if (!((c)g.ab(c.class)).awK().xS(paramString))
    {
      ac.d("MicroMsg.ChatroomMembersLogic", "state is die");
      AppMethodBeat.o(101750);
      return true;
    }
    paramString = ((c)g.ab(c.class)).awK().xR(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(101750);
      return true;
    }
    AppMethodBeat.o(101750);
    return false;
  }
  
  public static boolean vV(String paramString)
  {
    AppMethodBeat.i(101751);
    if (!w.wo(paramString))
    {
      AppMethodBeat.o(101751);
      return false;
    }
    ac.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[] { paramString });
    aj localaj = ((c)g.ab(c.class)).awK();
    paramString = localaj.xN(paramString);
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
  
  public static boolean vW(String paramString)
  {
    AppMethodBeat.i(101759);
    if (!paramString.toLowerCase().endsWith("@groupcard"))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + paramString + "]");
      AppMethodBeat.o(101759);
      return false;
    }
    bj localbj = ((k)g.ab(k.class)).awB();
    if (localbj.aNw(paramString)) {
      localbj.aNA(paramString);
    }
    for (;;)
    {
      boolean bool = vY(paramString);
      AppMethodBeat.o(101759);
      return bool;
      ac.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + paramString + "]");
    }
  }
  
  public static boolean vX(String paramString)
  {
    AppMethodBeat.i(101760);
    if (!vP(paramString))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + paramString + "]");
      AppMethodBeat.o(101760);
      return false;
    }
    bj localbj = ((k)g.ab(k.class)).awB();
    if (localbj.aNw(paramString)) {
      localbj.aNA(paramString);
    }
    for (;;)
    {
      boolean bool = vY(paramString);
      AppMethodBeat.o(101760);
      return bool;
      ac.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + paramString + "]");
    }
  }
  
  private static boolean vY(String paramString)
  {
    AppMethodBeat.i(101762);
    boolean bool = ((c)g.ab(c.class)).awK().xT(paramString);
    AppMethodBeat.o(101762);
    return bool;
  }
  
  public static List<String> vZ(String paramString)
  {
    AppMethodBeat.i(101763);
    if (paramString == null)
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
      AppMethodBeat.o(101763);
      return null;
    }
    if (!vP(paramString))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + paramString + "]");
      AppMethodBeat.o(101763);
      return null;
    }
    paramString = ((c)g.ab(c.class)).awK().xR(paramString);
    AppMethodBeat.o(101763);
    return paramString;
  }
  
  public static List<String> wa(String paramString)
  {
    AppMethodBeat.i(101764);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101764);
      return null;
    }
    paramString = ((c)g.ab(c.class)).awK().xR(paramString);
    AppMethodBeat.o(101764);
    return paramString;
  }
  
  public static int wb(String paramString)
  {
    AppMethodBeat.i(101765);
    long l = System.currentTimeMillis();
    try
    {
      aj localaj = ((c)g.ab(c.class)).awK();
      if (localaj != null)
      {
        int i = localaj.xU(paramString);
        return i;
      }
      return 0;
    }
    finally
    {
      ac.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(101765);
    }
  }
  
  public static List<String> wc(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(101766);
    if (!vP(paramString))
    {
      ac.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(101766);
      return null;
    }
    paramString = vZ(paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      AppMethodBeat.o(101766);
      return null;
    }
    String str = (String)g.agR().agA().get(2, null);
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
  
  public static String wd(String paramString)
  {
    AppMethodBeat.i(101769);
    paramString = ((c)g.ab(c.class)).awK().xN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101769);
      return null;
    }
    paramString = paramString.field_chatroomnotice;
    AppMethodBeat.o(101769);
    return paramString;
  }
  
  public static String we(String paramString)
  {
    AppMethodBeat.i(101771);
    paramString = ((c)g.ab(c.class)).awK().xN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101771);
      return null;
    }
    paramString = paramString.field_chatroomnoticeEditor;
    AppMethodBeat.o(101771);
    return paramString;
  }
  
  public static long wf(String paramString)
  {
    AppMethodBeat.i(101772);
    paramString = ((c)g.ab(c.class)).awK().xN(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.q
 * JD-Core Version:    0.7.0.1
 */