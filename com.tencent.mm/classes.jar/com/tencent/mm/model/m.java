package com.tencent.mm.model;

import android.content.Context;
import com.tencent.mm.a.f;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.a.aq;
import com.tencent.mm.h.a.ar;
import com.tencent.mm.h.a.ar.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.protocal.c.axa;
import com.tencent.mm.protocal.c.bt;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.c.ob;
import com.tencent.mm.protocal.c.sq;
import com.tencent.mm.protocal.c.sz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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

public final class m
{
  public static f<String, String> dUL = new f(100);
  
  public static boolean G(String paramString, int paramInt)
  {
    paramString = ((c)g.r(c.class)).FF().in(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.field_chatroomVersion < paramInt;
  }
  
  public static void H(String paramString, int paramInt)
  {
    af localaf = ((c)g.r(c.class)).FF();
    u localu = localaf.in(paramString);
    if (localu == null) {
      return;
    }
    com.tencent.mm.k.a.a.a locala = localu.ctT();
    locala.type = paramInt;
    localu.a(paramString, locala, false);
    localaf.a(localu);
  }
  
  public static String J(List<String> paramList)
  {
    return c(paramList, -1);
  }
  
  public static String O(String paramString1, String paramString2)
  {
    paramString1 = paramString2 + "#" + paramString1;
    if (dUL.bR(paramString1)) {
      return (String)dUL.get(paramString1);
    }
    return "";
  }
  
  public static String P(String paramString1, String paramString2)
  {
    af localaf = ((c)g.r(c.class)).FF();
    if (localaf == null)
    {
      y.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
      return null;
    }
    paramString2 = localaf.in(paramString2);
    if (paramString2 == null) {
      return null;
    }
    return paramString2.gV(paramString1);
  }
  
  public static ad a(ad paramad, awi paramawi)
  {
    paramad.setUsername(aa.a(paramawi.sQx));
    paramad.dk(aa.a(paramawi.sQx));
    paramad.dl(aa.a(paramawi.sQx));
    paramad.dm(aa.a(paramawi.sQb));
    paramad.fm(paramawi.ffh);
    paramad.df(aa.a(paramawi.tsS));
    paramad.dp(aa.a(paramawi.tsT));
    paramad.jdMethod_do(aa.a(paramawi.sQb));
    paramad.fp(paramawi.sPx);
    paramad.fr(paramawi.ffl);
    paramad.dF(RegionCodeDecoder.ao(paramawi.ffq, paramawi.ffi, paramawi.ffj));
    paramad.dz(paramawi.ffk);
    return paramad;
  }
  
  public static void a(String paramString, u paramu, boolean paramBoolean)
  {
    paramu.mB(paramBoolean);
    ((c)g.r(c.class)).FF().c(paramu, new String[0]);
    paramu = q.Gj();
    com.tencent.mm.roomsdk.a.b.YK(paramString).c(paramString, paramu, paramBoolean).cpz();
    axa localaxa = new axa();
    localaxa.svm = paramString;
    localaxa.hPY = paramu;
    localaxa.ttm = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localaxa.nFj = i;
      ((j)g.r(j.class)).Fv().b(new i.a(49, localaxa));
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    af localaf = ((c)g.r(c.class)).FF();
    paramString1 = localaf.in(paramString1);
    if (paramString1 == null) {
      return;
    }
    paramString1.field_chatroomVersion = paramInt1;
    paramString1.field_chatroomnoticePublishTime = paramLong;
    paramString1.field_chatroomnoticeEditor = paramString3;
    paramString1.field_chatroomnotice = paramString2;
    paramString1.field_chatroomStatus = paramInt2;
    localaf.a(paramString1);
  }
  
  public static boolean a(u paramu)
  {
    if (paramu == null)
    {
      y.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
      return false;
    }
    boolean bool = ((c)g.r(c.class)).FF().a(paramu);
    String str;
    bd localbd;
    ad localad;
    if (bool)
    {
      str = paramu.field_chatroomname;
      paramu = paramu.field_roomowner;
      y.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[] { Integer.valueOf(1) });
      localbd = ((j)g.r(j.class)).Fw();
      localad = localbd.abl(str);
      if (((int)localad.dBe != 0) && (!bk.bl(paramu)) && (!bk.bl(q.Gj())))
      {
        if (!paramu.equals(q.Gj())) {
          break label143;
        }
        localad.gS(1);
      }
    }
    for (;;)
    {
      localbd.a(str, localad);
      return bool;
      label143:
      localad.gS(0);
    }
  }
  
  public static boolean a(String paramString, bt parambt)
  {
    if ((!gB(paramString)) || (parambt.dne == 0)) {
      y.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + paramString + "] listCnt:" + parambt.dne);
    }
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = new ArrayList();
      bd localbd = ((j)g.r(j.class)).Fw();
      int i = 0;
      while (i < parambt.dne)
      {
        Object localObject = aa.a(((awi)parambt.svo.get(i)).sQx);
        if (((awi)parambt.svo.get(i)).tsR == 0)
        {
          if (bk.bl((String)localObject)) {
            y.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", new Object[] { paramString });
          }
        }
        else
        {
          i += 1;
          continue;
        }
        localObject = localbd.abl((String)localObject);
        if ((int)((com.tencent.mm.n.a)localObject).dBe != 0)
        {
          ((ad)localObject).AG();
          localbd.a(((ao)localObject).field_username, (ad)localObject);
        }
        for (;;)
        {
          localArrayList.add(((ao)localObject).field_username);
          break;
          localObject = a((ad)localObject, (awi)parambt.svo.get(i));
          localbd.V((ad)localObject);
        }
      }
    } while (localArrayList.isEmpty());
    return a(paramString, localArrayList, null);
  }
  
  public static boolean a(String paramString, oa paramoa)
  {
    if (paramoa == null)
    {
      y.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
      return false;
    }
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
      return false;
    }
    if (s.fn(paramString))
    {
      y.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[] { paramString });
      return false;
    }
    String str = aa.a(paramoa.sLB);
    if (bk.bl(str))
    {
      y.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId is null!");
      return false;
    }
    y.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[] { str, Integer.valueOf(paramoa.sLz.size()) });
    paramString = ((c)g.r(c.class)).FF().in(str);
    if ((paramString != null) && (paramoa.sLz.size() > 0) && (paramString.MN().contains(((ob)paramoa.sLz.get(0)).hPY)))
    {
      str = ((ob)paramoa.sLz.get(0)).hPY;
      com.tencent.mm.k.a.a.b localb = paramString.aaL(str);
      if (localb != null)
      {
        y.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[] { str, localb.dtK });
        localb.dtM = ((ob)paramoa.sLz.get(0)).sLG;
        a(paramString);
      }
      for (;;)
      {
        return true;
        y.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[] { str });
      }
    }
    if ((paramString != null) && (paramoa.sLz.size() > 0))
    {
      paramString = new ar();
      paramString.bGQ.username = ((ob)paramoa.sLz.get(0)).hPY;
      paramString.bGQ.bGR = ((ob)paramoa.sLz.get(0)).sLG;
      dUL.put(str + "#" + paramString.bGQ.username, paramString.bGQ.bGR);
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      return false;
    }
    if (paramoa.sLz.size() <= 0) {
      y.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
    }
    if (paramString != null) {
      y.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
    }
    return false;
  }
  
  public static boolean a(String paramString, sq paramsq)
  {
    if ((!gB(paramString)) || (paramsq.dne == 0))
    {
      y.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + paramString + "] listCnt:" + paramsq.dne);
      return false;
    }
    af localaf = ((c)g.r(c.class)).FF();
    paramString = localaf.in(paramString);
    List localList = u.aaO(paramString.field_memberlist);
    y.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + localList.size());
    paramsq = paramsq.svo.iterator();
    while (paramsq.hasNext()) {
      localList.remove(aa.a(((sz)paramsq.next()).sQx));
    }
    y.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + localList.size());
    paramString.jdMethod_do(localList).field_displayname = J(localList);
    boolean bool = localaf.a(paramString);
    y.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember " + bool);
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, oa paramoa, int paramInt, String paramString3, com.tencent.mm.k.a.a.a parama, com.tencent.mm.sdk.b.b paramb)
  {
    if ((!paramString1.toLowerCase().endsWith("@chatroom")) && (!paramString1.toLowerCase().endsWith("@im.chatroom")) && (!paramString1.toLowerCase().endsWith("@groupcard")) && (!paramString1.toLowerCase().endsWith("@talkroom")))
    {
      y.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] listCnt:" + paramoa.dne);
      return false;
    }
    bd localbd = ((j)g.r(j.class)).Fw();
    u localu = ((c)g.r(c.class)).FF().in(paramString1);
    if (localu != null) {}
    ArrayList localArrayList;
    boolean bool1;
    long l1;
    ob localob;
    ad localad;
    for (parama.bSZ = localu.ctN();; parama.bSZ = 0)
    {
      localArrayList = new ArrayList();
      bool1 = false;
      y.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] memCnt:" + paramoa.dne);
      l1 = System.currentTimeMillis();
      i = 0;
      for (;;)
      {
        if (i >= paramoa.dne) {
          break label555;
        }
        localob = (ob)paramoa.sLz.get(i);
        localad = localbd.abl(localob.hPY);
        if (localad != null) {
          break;
        }
        y.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
        i += 1;
      }
    }
    com.tencent.mm.k.a.a.b localb = new com.tencent.mm.k.a.a.b();
    localb.userName = localob.hPY;
    localb.dtM = localob.sLG;
    localb.dtL = localob.sLF;
    Object localObject;
    if (paramoa.sLA == 0)
    {
      localb.dtK = localob.sLC;
      if (!bk.bl(localob.sLE))
      {
        com.tencent.mm.ag.h localh = o.Kh().kp(localob.hPY);
        localObject = localh;
        if (localh == null)
        {
          localObject = new com.tencent.mm.ag.h();
          ((com.tencent.mm.ag.h)localObject).username = localob.hPY;
        }
        ((com.tencent.mm.ag.h)localObject).ebT = localob.sLD;
        ((com.tencent.mm.ag.h)localObject).ebS = localob.sLE;
        ((com.tencent.mm.ag.h)localObject).cCq = 3;
        if (bk.bl(localob.sLD)) {
          break label549;
        }
      }
    }
    label549:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((com.tencent.mm.ag.h)localObject).bK(bool2);
      o.Kh().a((com.tencent.mm.ag.h)localObject);
      if (localu != null)
      {
        localObject = localu.aaL(localob.hPY);
        if (localObject != null)
        {
          localb.dtK = ((com.tencent.mm.k.a.a.b)localObject).dtK;
          localb.dtM = ((com.tencent.mm.k.a.a.b)localObject).dtM;
        }
      }
      parama.dtH.add(localb);
      if ((int)localad.dBe == 0)
      {
        localad.setUsername(localob.hPY);
        if (localob.hRf != null) {
          localad.dk(localob.hRf);
        }
        localad.AG();
        localbd.V(localad);
        bool1 = true;
      }
      localArrayList.add(localad.field_username);
      break;
    }
    label555:
    y.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + localArrayList.size() + " event: " + paramb + " publish: " + bool1 + " take[" + (System.currentTimeMillis() - l1) + "]ms");
    label735:
    long l2;
    if (bool1)
    {
      com.tencent.mm.roomsdk.a.b.YK(paramString1).y(paramString1, parama.bSZ).cpz();
      localObject = ((c)g.r(c.class)).FF().in(paramString1);
      paramb = (com.tencent.mm.sdk.b.b)localObject;
      if (localObject == null) {
        paramb = new u();
      }
      l1 = System.currentTimeMillis();
      paramb.field_chatroomname = paramString1;
      paramb.field_roomowner = paramString2;
      paramString2 = paramb.jdMethod_do(localArrayList);
      paramString2.field_chatroomStatus = paramInt;
      paramString2.field_displayname = J(localArrayList);
      if (paramoa.sLA == 0) {
        break label927;
      }
      bool1 = true;
      paramString2.a(paramString3, parama, bool1);
      bool1 = a(paramb);
      l2 = System.currentTimeMillis();
      bool2 = paramb.ctO();
      if (paramb.unm != null) {
        break label933;
      }
      paramInt = 0;
      label775:
      if (paramb.unm != null) {
        break label945;
      }
    }
    label927:
    label933:
    label945:
    for (int i = 0;; i = paramb.unm.dtJ)
    {
      y.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2 - l1), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if (paramb.ctO())
      {
        y.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[] { Integer.valueOf(paramb.ctN()) });
        paramString2 = new aq();
        paramString2.bGP.username = paramString1;
        com.tencent.mm.sdk.b.a.udP.m(paramString2);
      }
      return bool1;
      if (localu != null)
      {
        u.ctP();
        break;
      }
      com.tencent.mm.roomsdk.a.b.YK(paramString1).y(paramString1, 0).cpz();
      break;
      bool1 = false;
      break label735;
      paramInt = paramb.unm.bSZ;
      break label775;
    }
  }
  
  public static boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    int i = 0;
    int k = 0;
    af localaf = ((c)g.r(c.class)).FF();
    u localu = localaf.io(paramString1);
    if ((paramString1.endsWith("@chatroom")) || (paramString1.endsWith("@im.chatroom"))) {}
    LinkedList localLinkedList;
    int j;
    for (paramString1 = gK(paramString1);; paramString1 = new LinkedList())
    {
      localLinkedList = new LinkedList();
      if (paramString1 == null) {
        break label202;
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
    if (!bk.bl(paramString2)) {
      localu.field_roomowner = paramString2;
    }
    localu.jdMethod_do(localLinkedList).field_displayname = J(localLinkedList);
    return localaf.a(localu);
    label202:
    while (i < paramArrayList.size())
    {
      localLinkedList.add(paramArrayList.get(i));
      i += 1;
    }
    if (!bk.bl(paramString2)) {
      localu.field_roomowner = paramString2;
    }
    localu.jdMethod_do(localLinkedList).field_displayname = J(localLinkedList);
    localu.field_roomowner = paramString2;
    boolean bool = localaf.a(localu);
    y.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName " + bool);
    return bool;
  }
  
  public static String c(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      localObject2 = "";
    }
    Object localObject1;
    int i;
    do
    {
      return localObject2;
      localObject1 = "";
      i = 0;
      localObject2 = localObject1;
    } while (i >= paramList.size());
    Object localObject2 = (String)paramList.get(i);
    if (((String)localObject2).length() > 0)
    {
      localObject2 = ((j)g.r(j.class)).Fw().abl((String)localObject2);
      localObject2 = (String)localObject1 + ((ad)localObject2).Bq();
      if ((i == paramInt - 1) && (i < paramList.size())) {
        return (String)localObject2 + "...";
      }
      localObject1 = localObject2;
      if (i < paramList.size() - 1) {
        localObject1 = (String)localObject2 + ae.getContext().getString(b.a.chatroom_sys_msg_invite_split);
      }
    }
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public static boolean e(String paramString, Map<String, String> paramMap)
  {
    paramString = ((c)g.r(c.class)).FF().in(paramString);
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = paramString.MN().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, paramString.gV(str));
    }
    return true;
  }
  
  private static boolean gB(String paramString)
  {
    if (paramString.toLowerCase().endsWith("@chatroom")) {}
    while (paramString.toLowerCase().endsWith("@im.chatroom")) {
      return true;
    }
    return false;
  }
  
  public static boolean gC(String paramString)
  {
    paramString = ((c)g.r(c.class)).FF().in(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.ctS();
  }
  
  public static boolean gD(String paramString)
  {
    paramString = ((c)g.r(c.class)).FF().ip(paramString);
    String str = q.Gj();
    return (!bk.bl(paramString)) && (!bk.bl(str)) && (paramString.equals(str));
  }
  
  public static boolean gE(String paramString)
  {
    String str = (String)g.DP().Dz().get(2, null);
    paramString = gK(paramString);
    if (paramString == null)
    {
      y.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
      return false;
    }
    if ((paramString.size() == 0) || (!paramString.contains(str)))
    {
      y.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + paramString.size() + " ");
      return false;
    }
    return true;
  }
  
  public static boolean gF(String paramString)
  {
    if (!s.gZ(paramString)) {
      return false;
    }
    if (!((c)g.r(c.class)).FF().is(paramString))
    {
      y.d("MicroMsg.ChatroomMembersLogic", "state is die");
      return true;
    }
    paramString = ((c)g.r(c.class)).FF().ir(paramString);
    return (paramString == null) || (paramString.size() == 0);
  }
  
  public static boolean gG(String paramString)
  {
    if (!s.gZ(paramString)) {
      return false;
    }
    y.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[] { paramString });
    af localaf = ((c)g.r(c.class)).FF();
    paramString = localaf.in(paramString);
    if (paramString == null) {
      return false;
    }
    paramString.field_roomflag = 1;
    return localaf.a(paramString);
  }
  
  public static boolean gH(String paramString)
  {
    if (!paramString.toLowerCase().endsWith("@groupcard"))
    {
      y.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + paramString + "]");
      return false;
    }
    bd localbd = ((j)g.r(j.class)).Fw();
    if (localbd.abn(paramString)) {
      localbd.abr(paramString);
    }
    for (;;)
    {
      return gJ(paramString);
      y.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + paramString + "]");
    }
  }
  
  public static boolean gI(String paramString)
  {
    if (!gB(paramString))
    {
      y.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + paramString + "]");
      return false;
    }
    bd localbd = ((j)g.r(j.class)).Fw();
    if (localbd.abn(paramString)) {
      localbd.abr(paramString);
    }
    for (;;)
    {
      return gJ(paramString);
      y.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + paramString + "]");
    }
  }
  
  private static boolean gJ(String paramString)
  {
    return ((c)g.r(c.class)).FF().it(paramString);
  }
  
  public static List<String> gK(String paramString)
  {
    if (paramString == null)
    {
      y.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
      return null;
    }
    if (!gB(paramString))
    {
      y.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + paramString + "]");
      return null;
    }
    return ((c)g.r(c.class)).FF().ir(paramString);
  }
  
  public static List<String> gL(String paramString)
  {
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      y.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + paramString + "]");
      return null;
    }
    return ((c)g.r(c.class)).FF().ir(paramString);
  }
  
  public static int gM(String paramString)
  {
    List localList = gK(paramString);
    if (localList == null)
    {
      y.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: get room:[" + paramString + "] members count fail");
      return 0;
    }
    return localList.size();
  }
  
  public static List<String> gN(String paramString)
  {
    int i = 0;
    if (!gB(paramString))
    {
      y.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + paramString + "]");
      return null;
    }
    paramString = gK(paramString);
    if ((paramString == null) || (paramString.size() <= 0)) {
      return null;
    }
    String str = (String)g.DP().Dz().get(2, null);
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
          return paramString;
        }
        return null;
        bool = false;
        break;
      }
      i += 1;
    }
    return paramString;
  }
  
  public static String gO(String paramString)
  {
    paramString = ((c)g.r(c.class)).FF().in(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.field_chatroomnotice;
  }
  
  public static String gP(String paramString)
  {
    paramString = ((c)g.r(c.class)).FF().in(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.field_chatroomnoticeEditor;
  }
  
  public static long gQ(String paramString)
  {
    paramString = ((c)g.r(c.class)).FF().in(paramString);
    if (paramString == null) {
      return -1L;
    }
    return paramString.field_chatroomnoticePublishTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.m
 * JD-Core Version:    0.7.0.1
 */