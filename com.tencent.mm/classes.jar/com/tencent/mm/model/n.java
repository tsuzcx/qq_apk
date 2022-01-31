package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.au.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.cb;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class n
{
  public static f<String, String> fkU;
  
  static
  {
    AppMethodBeat.i(5546);
    fkU = new com.tencent.mm.a.h(100);
    AppMethodBeat.o(5546);
  }
  
  public static boolean N(String paramString, int paramInt)
  {
    AppMethodBeat.i(5541);
    paramString = ((c)g.E(c.class)).YJ().oU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(5541);
      return false;
    }
    if (paramString.field_chatroomVersion < paramInt)
    {
      AppMethodBeat.o(5541);
      return true;
    }
    AppMethodBeat.o(5541);
    return false;
  }
  
  public static void O(String paramString, int paramInt)
  {
    AppMethodBeat.i(5545);
    ag localag = ((c)g.E(c.class)).YJ();
    u localu = localag.oU(paramString);
    if (localu == null)
    {
      AppMethodBeat.o(5545);
      return;
    }
    com.tencent.mm.j.a.a.a locala = localu.dwt();
    locala.type = paramInt;
    localu.a(paramString, locala, false);
    localag.replace(localu);
    AppMethodBeat.o(5545);
  }
  
  public static String Q(List<String> paramList)
  {
    AppMethodBeat.i(5518);
    paramList = f(paramList, -1);
    AppMethodBeat.o(5518);
    return paramList;
  }
  
  public static ad a(ad paramad, bcx parambcx)
  {
    AppMethodBeat.i(5538);
    paramad.setUsername(aa.a(parambcx.wOY));
    paramad.jp(aa.a(parambcx.wOY));
    paramad.jq(aa.a(parambcx.wOY));
    paramad.jr(aa.a(parambcx.wOw));
    paramad.hy(parambcx.gwP);
    paramad.jn(aa.a(parambcx.xsT));
    paramad.ju(aa.a(parambcx.xsU));
    paramad.jt(aa.a(parambcx.wOw));
    paramad.hA(parambcx.wNQ);
    paramad.hC(parambcx.gwT);
    paramad.jL(RegionCodeDecoder.aF(parambcx.gwY, parambcx.gwQ, parambcx.gwR));
    paramad.jF(parambcx.gwS);
    AppMethodBeat.o(5538);
    return paramad;
  }
  
  public static void a(String paramString, u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(5517);
    paramu.pS(paramBoolean);
    ((c)g.E(c.class)).YJ().update(paramu, new String[0]);
    paramu = r.Zn();
    com.tencent.mm.roomsdk.a.b.aoI(paramString).c(paramString, paramu, paramBoolean).drn();
    bdq localbdq = new bdq();
    localbdq.wot = paramString;
    localbdq.jJA = paramu;
    localbdq.xtm = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbdq.qsl = i;
      ((j)g.E(j.class)).Yz().c(new j.a(49, localbdq));
      AppMethodBeat.o(5517);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5544);
    ag localag = ((c)g.E(c.class)).YJ();
    paramString1 = localag.oU(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(5544);
      return;
    }
    paramString1.field_chatroomVersion = paramInt1;
    paramString1.field_chatroomnoticePublishTime = paramLong;
    paramString1.field_chatroomnoticeEditor = paramString3;
    paramString1.field_chatroomnotice = paramString2;
    paramString1.field_chatroomStatus = paramInt2;
    localag.replace(paramString1);
    AppMethodBeat.o(5544);
  }
  
  public static boolean a(u paramu)
  {
    AppMethodBeat.i(5526);
    if (paramu == null)
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
      AppMethodBeat.o(5526);
      return false;
    }
    boolean bool = ((c)g.E(c.class)).YJ().replace(paramu);
    if (bool) {
      ae(paramu.field_chatroomname, paramu.field_roomowner);
    }
    AppMethodBeat.o(5526);
    return bool;
  }
  
  public static boolean a(String paramString, cb paramcb)
  {
    AppMethodBeat.i(5529);
    if ((!nj(paramString)) || (paramcb.eeF == 0))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + paramString + "] listCnt:" + paramcb.eeF);
      AppMethodBeat.o(5529);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    bd localbd = ((j)g.E(j.class)).YA();
    int i = 0;
    while (i < paramcb.eeF)
    {
      Object localObject = aa.a(((bcx)paramcb.wov.get(i)).wOY);
      if (((bcx)paramcb.wov.get(i)).xsS == 0)
      {
        if (bo.isNullOrNil((String)localObject)) {
          ab.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", new Object[] { paramString });
        }
      }
      else
      {
        i += 1;
        continue;
      }
      localObject = localbd.arw((String)localObject);
      if ((int)((com.tencent.mm.n.a)localObject).euF != 0)
      {
        ((ad)localObject).Nw();
        localbd.b(((aq)localObject).field_username, (ad)localObject);
      }
      for (;;)
      {
        localArrayList.add(((aq)localObject).field_username);
        break;
        localObject = a((ad)localObject, (bcx)paramcb.wov.get(i));
        localbd.Y((ad)localObject);
      }
    }
    if (!localArrayList.isEmpty())
    {
      boolean bool = a(paramString, localArrayList, null);
      AppMethodBeat.o(5529);
      return bool;
    }
    AppMethodBeat.o(5529);
    return false;
  }
  
  public static boolean a(String paramString, rc paramrc)
  {
    AppMethodBeat.i(5524);
    if (paramrc == null)
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
      AppMethodBeat.o(5524);
      return false;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
      AppMethodBeat.o(5524);
      return false;
    }
    if (t.lA(paramString))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[] { paramString });
      AppMethodBeat.o(5524);
      return false;
    }
    String str = aa.a(paramrc.wJo);
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId is null!");
      AppMethodBeat.o(5524);
      return false;
    }
    ab.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[] { str, Integer.valueOf(paramrc.wJm.size()) });
    paramString = ((c)g.E(c.class)).YJ().oU(str);
    if ((paramString != null) && (paramrc.wJm.size() > 0) && (paramString.afx().contains(((rd)paramrc.wJm.get(0)).jJA)))
    {
      str = ((rd)paramrc.wJm.get(0)).jJA;
      com.tencent.mm.j.a.a.b localb = paramString.aqV(str);
      if (localb != null)
      {
        ab.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[] { str, localb.elx });
        localb.elz = ((rd)paramrc.wJm.get(0)).wJt;
        a(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(5524);
        return true;
        ab.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[] { str });
      }
    }
    if ((paramString != null) && (paramrc.wJm.size() > 0))
    {
      paramString = new au();
      paramString.cof.username = ((rd)paramrc.wJm.get(0)).jJA;
      paramString.cof.cog = ((rd)paramrc.wJm.get(0)).wJt;
      fkU.put(str + "#" + paramString.cof.username, paramString.cof.cog);
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      AppMethodBeat.o(5524);
      return false;
    }
    if (paramrc.wJm.size() <= 0) {
      ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
    }
    if (paramString != null) {
      ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
    }
    AppMethodBeat.o(5524);
    return false;
  }
  
  public static boolean a(String paramString, wq paramwq)
  {
    AppMethodBeat.i(5528);
    if ((!nj(paramString)) || (paramwq.eeF == 0))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + paramString + "] listCnt:" + paramwq.eeF);
      AppMethodBeat.o(5528);
      return false;
    }
    ag localag = ((c)g.E(c.class)).YJ();
    paramString = localag.oU(paramString);
    List localList = u.aqZ(paramString.field_memberlist);
    ab.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + localList.size());
    paramwq = paramwq.wov.iterator();
    while (paramwq.hasNext()) {
      localList.remove(aa.a(((xa)paramwq.next()).wOY));
    }
    ab.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + localList.size());
    paramwq = paramString.ex(localList);
    paramwq.field_displayname = Q(localList);
    paramwq.field_memberCount = localList.size();
    boolean bool = localag.replace(paramString);
    ab.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(bool)));
    AppMethodBeat.o(5528);
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, rc paramrc, int paramInt, String paramString3, com.tencent.mm.j.a.a.a parama, com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(5523);
    if ((!paramString1.toLowerCase().endsWith("@chatroom")) && (!paramString1.toLowerCase().endsWith("@im.chatroom")) && (!paramString1.toLowerCase().endsWith("@groupcard")) && (!paramString1.toLowerCase().endsWith("@talkroom")))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] listCnt:" + paramrc.eeF);
      AppMethodBeat.o(5523);
      return false;
    }
    bd localbd = ((j)g.E(j.class)).YA();
    u localu = ((c)g.E(c.class)).YJ().oU(paramString1);
    if (localu != null) {}
    ArrayList localArrayList;
    boolean bool1;
    long l1;
    rd localrd;
    ad localad;
    for (parama.cAE = localu.dwo();; parama.cAE = 0)
    {
      localArrayList = new ArrayList();
      bool1 = false;
      ab.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] memCnt:" + paramrc.eeF);
      l1 = System.currentTimeMillis();
      i = 0;
      for (;;)
      {
        if (i >= paramrc.eeF) {
          break label592;
        }
        localrd = (rd)paramrc.wJm.get(i);
        localad = localbd.arw(localrd.jJA);
        if (localad != null) {
          break;
        }
        ab.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
        i += 1;
      }
    }
    com.tencent.mm.j.a.a.b localb = new com.tencent.mm.j.a.a.b();
    localb.userName = localrd.jJA;
    localb.elz = localrd.wJt;
    localb.ely = localrd.wJs;
    boolean bool2;
    if (paramrc.wJn == 0)
    {
      localb.elx = localrd.wJp;
      if (!bo.isNullOrNil(localrd.wJr))
      {
        com.tencent.mm.ah.h localh = o.adg().rj(localrd.jJA);
        localObject = localh;
        if (localh == null)
        {
          localObject = new com.tencent.mm.ah.h();
          ((com.tencent.mm.ah.h)localObject).username = localrd.jJA;
        }
        ((com.tencent.mm.ah.h)localObject).fsl = localrd.wJq;
        ((com.tencent.mm.ah.h)localObject).fsk = localrd.wJr;
        ((com.tencent.mm.ah.h)localObject).dqB = 3;
        if (bo.isNullOrNil(localrd.wJq)) {
          break label576;
        }
        bool2 = true;
        label423:
        ((com.tencent.mm.ah.h)localObject).cM(bool2);
        o.adg().b((com.tencent.mm.ah.h)localObject);
      }
    }
    if (localu != null)
    {
      localObject = localu.aqV(localrd.jJA);
      if (localObject != null)
      {
        localb.elx = ((com.tencent.mm.j.a.a.b)localObject).elx;
        if (!bo.isNullOrNil(localb.elz)) {
          break label582;
        }
      }
    }
    label576:
    label582:
    for (Object localObject = ((com.tencent.mm.j.a.a.b)localObject).elz;; localObject = localb.elz)
    {
      localb.elz = ((String)localObject);
      parama.elu.add(localb);
      if ((int)localad.euF == 0)
      {
        localad.setUsername(localrd.jJA);
        if (localrd.jKG != null) {
          localad.jp(localrd.jKG);
        }
        localad.Nw();
        localbd.Y(localad);
        bool1 = true;
      }
      localArrayList.add(localad.field_username);
      break;
      bool2 = false;
      break label423;
    }
    label592:
    ab.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + localArrayList.size() + " event: " + paramb + " publish: " + bool1 + " take[" + (System.currentTimeMillis() - l1) + "]ms");
    label772:
    long l2;
    if (bool1)
    {
      com.tencent.mm.roomsdk.a.b.aoI(paramString1).D(paramString1, parama.cAE).drn();
      localObject = ((c)g.E(c.class)).YJ().oU(paramString1);
      paramb = (com.tencent.mm.sdk.b.b)localObject;
      if (localObject == null) {
        paramb = new u();
      }
      l1 = System.currentTimeMillis();
      paramb.field_chatroomname = paramString1;
      paramb.field_roomowner = paramString2;
      paramString2 = paramb.ex(localArrayList);
      paramString2.field_chatroomStatus = paramInt;
      paramString2.field_displayname = Q(localArrayList);
      if (paramrc.wJn == 0) {
        break label970;
      }
      bool1 = true;
      paramString2.a(paramString3, parama, bool1).field_memberCount = localArrayList.size();
      bool1 = a(paramb);
      l2 = System.currentTimeMillis();
      bool2 = paramb.dwp();
      if (paramb.dwm() != null) {
        break label976;
      }
      paramInt = 0;
      label819:
      if (paramb.dwm() != null) {
        break label988;
      }
    }
    label970:
    label976:
    label988:
    for (int i = 0;; i = paramb.dwm().elw)
    {
      ab.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2 - l1), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if (paramb.dwp())
      {
        ab.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[] { Integer.valueOf(paramb.dwo()) });
        paramString2 = new at();
        paramString2.coe.username = paramString1;
        com.tencent.mm.sdk.b.a.ymk.l(paramString2);
      }
      AppMethodBeat.o(5523);
      return bool1;
      if (localu != null) {
        break;
      }
      com.tencent.mm.roomsdk.a.b.aoI(paramString1).D(paramString1, 0).drn();
      break;
      bool1 = false;
      break label772;
      paramInt = paramb.dwm().cAE;
      break label819;
    }
  }
  
  public static boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    int i = 0;
    int k = 0;
    AppMethodBeat.i(5532);
    ag localag = ((c)g.E(c.class)).YJ();
    u localu = localag.oV(paramString1);
    if ((paramString1.endsWith("@chatroom")) || (paramString1.endsWith("@im.chatroom"))) {}
    LinkedList localLinkedList;
    int j;
    for (paramString1 = nt(paramString1);; paramString1 = new LinkedList())
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
    if (!bo.isNullOrNil(paramString2)) {
      localu.field_roomowner = paramString2;
    }
    paramString1 = localu.ex(localLinkedList);
    paramString1.field_displayname = Q(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    boolean bool = localag.replace(localu);
    AppMethodBeat.o(5532);
    return bool;
    label231:
    while (i < paramArrayList.size())
    {
      localLinkedList.add(paramArrayList.get(i));
      i += 1;
    }
    if (!bo.isNullOrNil(paramString2)) {
      localu.field_roomowner = paramString2;
    }
    paramString1 = localu.ex(localLinkedList);
    paramString1.field_displayname = Q(localLinkedList);
    paramString1.field_memberCount = localLinkedList.size();
    localu.field_roomowner = paramString2;
    bool = localag.replace(localu);
    ab.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(bool)));
    AppMethodBeat.o(5532);
    return bool;
  }
  
  public static String ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5525);
    paramString1 = paramString2 + "#" + paramString1;
    if (fkU.aa(paramString1))
    {
      paramString1 = (String)fkU.get(paramString1);
      AppMethodBeat.o(5525);
      return paramString1;
    }
    AppMethodBeat.o(5525);
    return "";
  }
  
  private static void ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5527);
    ab.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[] { Integer.valueOf(1) });
    bd localbd = ((j)g.E(j.class)).YA();
    ad localad = localbd.arw(paramString1);
    if (((int)localad.euF != 0) && (!bo.isNullOrNil(paramString2)) && (!bo.isNullOrNil(r.Zn())))
    {
      if (!paramString2.equals(r.Zn())) {
        break label102;
      }
      localad.jf(1);
    }
    for (;;)
    {
      localbd.b(paramString1, localad);
      AppMethodBeat.o(5527);
      return;
      label102:
      localad.jf(0);
    }
  }
  
  public static String af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5539);
    ag localag = ((c)g.E(c.class)).YJ();
    if (localag == null)
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
      AppMethodBeat.o(5539);
      return null;
    }
    paramString2 = localag.oU(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(5539);
      return null;
    }
    paramString1 = paramString2.nE(paramString1);
    AppMethodBeat.o(5539);
    return paramString1;
  }
  
  public static String f(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(5519);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(5519);
      return "";
    }
    Object localObject1 = "";
    int i = 0;
    Object localObject2 = localObject1;
    if (i < paramList.size())
    {
      localObject2 = (String)paramList.get(i);
      if (((String)localObject2).length() <= 0) {
        break label213;
      }
      localObject2 = ((j)g.E(j.class)).YA().arw((String)localObject2);
      localObject2 = (String)localObject1 + ((ad)localObject2).Of();
      if ((i == paramInt - 1) && (i < paramList.size())) {
        localObject2 = (String)localObject2 + "...";
      }
    }
    else
    {
      AppMethodBeat.o(5519);
      return localObject2;
    }
    localObject1 = localObject2;
    if (i < paramList.size() - 1) {
      localObject1 = (String)localObject2 + ah.getContext().getString(2131298140);
    }
    label213:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public static boolean f(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(5515);
    paramString = ((c)g.E(c.class)).YJ().oU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(5515);
      return false;
    }
    Iterator localIterator = paramString.afx().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, paramString.nE(str));
    }
    AppMethodBeat.o(5515);
    return true;
  }
  
  private static boolean nj(String paramString)
  {
    AppMethodBeat.i(5513);
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      AppMethodBeat.o(5513);
      return true;
    }
    if (paramString.toLowerCase().endsWith("@im.chatroom"))
    {
      AppMethodBeat.o(5513);
      return true;
    }
    AppMethodBeat.o(5513);
    return false;
  }
  
  public static boolean nk(String paramString)
  {
    AppMethodBeat.i(5514);
    paramString = ((c)g.E(c.class)).YJ().oU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(5514);
      return false;
    }
    boolean bool = paramString.dws();
    AppMethodBeat.o(5514);
    return bool;
  }
  
  public static boolean nl(String paramString)
  {
    AppMethodBeat.i(5516);
    paramString = ((c)g.E(c.class)).YJ().oW(paramString);
    String str = r.Zn();
    if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(str)) && (paramString.equals(str)))
    {
      AppMethodBeat.o(5516);
      return true;
    }
    AppMethodBeat.o(5516);
    return false;
  }
  
  public static String nm(String paramString)
  {
    AppMethodBeat.i(139647);
    if ((paramString == null) || (!nj(paramString)))
    {
      AppMethodBeat.o(139647);
      return "";
    }
    List localList = nt(paramString);
    paramString = "";
    int i = 0;
    String str;
    ad localad;
    if ((localList != null) && (i < localList.size()))
    {
      str = (String)localList.get(i);
      if (str.length() <= 0) {
        break label197;
      }
      localad = ((j)g.E(j.class)).YA().arw(str);
      if (localad == null)
      {
        str = paramString + str;
        label115:
        paramString = str;
        if (i < localList.size() - 1) {
          paramString = str + ah.getContext().getString(2131298140);
        }
      }
    }
    label197:
    for (;;)
    {
      i += 1;
      break;
      str = paramString + localad.Oe();
      break label115;
      AppMethodBeat.o(139647);
      return paramString;
    }
  }
  
  public static boolean nn(String paramString)
  {
    AppMethodBeat.i(5520);
    String str = (String)g.RL().Ru().get(2, null);
    paramString = nt(paramString);
    if (paramString == null)
    {
      ab.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
      AppMethodBeat.o(5520);
      return false;
    }
    if ((paramString.size() == 0) || (!paramString.contains(str)))
    {
      ab.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + paramString.size() + " ");
      AppMethodBeat.o(5520);
      return false;
    }
    AppMethodBeat.o(5520);
    return true;
  }
  
  public static boolean no(String paramString)
  {
    AppMethodBeat.i(5521);
    if (!t.nI(paramString))
    {
      AppMethodBeat.o(5521);
      return false;
    }
    if (!((c)g.E(c.class)).YJ().oZ(paramString))
    {
      ab.d("MicroMsg.ChatroomMembersLogic", "state is die");
      AppMethodBeat.o(5521);
      return true;
    }
    paramString = ((c)g.E(c.class)).YJ().oY(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(5521);
      return true;
    }
    AppMethodBeat.o(5521);
    return false;
  }
  
  public static boolean np(String paramString)
  {
    AppMethodBeat.i(5522);
    if (!t.nI(paramString))
    {
      AppMethodBeat.o(5522);
      return false;
    }
    ab.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[] { paramString });
    ag localag = ((c)g.E(c.class)).YJ();
    paramString = localag.oU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(5522);
      return false;
    }
    paramString.field_roomflag = 1;
    boolean bool = localag.replace(paramString);
    AppMethodBeat.o(5522);
    return bool;
  }
  
  public static boolean nq(String paramString)
  {
    AppMethodBeat.i(5530);
    if (!paramString.toLowerCase().endsWith("@groupcard"))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + paramString + "]");
      AppMethodBeat.o(5530);
      return false;
    }
    bd localbd = ((j)g.E(j.class)).YA();
    if (localbd.ary(paramString)) {
      localbd.arC(paramString);
    }
    for (;;)
    {
      boolean bool = ns(paramString);
      AppMethodBeat.o(5530);
      return bool;
      ab.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + paramString + "]");
    }
  }
  
  public static boolean nr(String paramString)
  {
    AppMethodBeat.i(5531);
    if (!nj(paramString))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + paramString + "]");
      AppMethodBeat.o(5531);
      return false;
    }
    bd localbd = ((j)g.E(j.class)).YA();
    if (localbd.ary(paramString)) {
      localbd.arC(paramString);
    }
    for (;;)
    {
      boolean bool = ns(paramString);
      AppMethodBeat.o(5531);
      return bool;
      ab.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + paramString + "]");
    }
  }
  
  private static boolean ns(String paramString)
  {
    AppMethodBeat.i(5533);
    boolean bool = ((c)g.E(c.class)).YJ().pa(paramString);
    AppMethodBeat.o(5533);
    return bool;
  }
  
  public static List<String> nt(String paramString)
  {
    AppMethodBeat.i(5534);
    if (paramString == null)
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
      AppMethodBeat.o(5534);
      return null;
    }
    if (!nj(paramString))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + paramString + "]");
      AppMethodBeat.o(5534);
      return null;
    }
    paramString = ((c)g.E(c.class)).YJ().oY(paramString);
    AppMethodBeat.o(5534);
    return paramString;
  }
  
  public static List<String> nu(String paramString)
  {
    AppMethodBeat.i(5535);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(5535);
      return null;
    }
    paramString = ((c)g.E(c.class)).YJ().oY(paramString);
    AppMethodBeat.o(5535);
    return paramString;
  }
  
  public static int nv(String paramString)
  {
    AppMethodBeat.i(5536);
    long l = System.currentTimeMillis();
    try
    {
      ag localag = ((c)g.E(c.class)).YJ();
      if (localag != null)
      {
        int i = localag.pb(paramString);
        return i;
      }
      return 0;
    }
    finally
    {
      ab.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(5536);
    }
  }
  
  public static List<String> nw(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(5537);
    if (!nj(paramString))
    {
      ab.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + paramString + "]");
      AppMethodBeat.o(5537);
      return null;
    }
    paramString = nt(paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      AppMethodBeat.o(5537);
      return null;
    }
    String str = (String)g.RL().Ru().get(2, null);
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
        AppMethodBeat.o(5537);
        return null;
        bool = false;
        break;
      }
      i += 1;
    }
    label173:
    AppMethodBeat.o(5537);
    return paramString;
  }
  
  public static String nx(String paramString)
  {
    AppMethodBeat.i(5540);
    paramString = ((c)g.E(c.class)).YJ().oU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(5540);
      return null;
    }
    paramString = paramString.field_chatroomnotice;
    AppMethodBeat.o(5540);
    return paramString;
  }
  
  public static String ny(String paramString)
  {
    AppMethodBeat.i(5542);
    paramString = ((c)g.E(c.class)).YJ().oU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(5542);
      return null;
    }
    paramString = paramString.field_chatroomnoticeEditor;
    AppMethodBeat.o(5542);
    return paramString;
  }
  
  public static long nz(String paramString)
  {
    AppMethodBeat.i(5543);
    paramString = ((c)g.E(c.class)).YJ().oU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(5543);
      return -1L;
    }
    long l = paramString.field_chatroomnoticePublishTime;
    AppMethodBeat.o(5543);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.n
 * JD-Core Version:    0.7.0.1
 */