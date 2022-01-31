package com.tencent.mm.ai.a;

import android.database.Cursor;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ai.z;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.protocal.c.acl;
import com.tencent.mm.protocal.c.acm;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.protocal.c.acp;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.afu;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.bzq;
import com.tencent.mm.protocal.c.bzr;
import com.tencent.mm.protocal.c.bzs;
import com.tencent.mm.protocal.c.bzt;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.ip;
import com.tencent.mm.protocal.c.iq;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.protocal.c.js;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rx;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements com.tencent.mm.ah.f
{
  private HashSet<h.a> ehL = new HashSet();
  private HashSet<h.a> ehM = new HashSet();
  private final Object ehN = new Object();
  private com.tencent.mm.a.f<String, Long> ehO = new com.tencent.mm.a.f(64);
  private HashSet<h.a> ehP = new HashSet();
  private HashSet<h.a> ehQ = new HashSet();
  private final Object ehR = new Object();
  private com.tencent.mm.a.f<String, Long> ehS = new com.tencent.mm.a.f(64);
  
  public h()
  {
    com.tencent.mm.kernel.g.DO().dJT.a(1352, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1365, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1353, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1354, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1357, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1356, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1355, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1358, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1367, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1361, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1389, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1315, this);
  }
  
  private void MQ()
  {
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.ehN)
    {
      if (!this.ehM.isEmpty()) {
        return;
      }
      if (this.ehL.isEmpty()) {
        return;
      }
    }
    Iterator localIterator = this.ehL.iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      ip localip = new ip();
      localip.sCO = h.a.a(locala);
      localip.sCI = h.a.b(locala);
      localLinkedList2.add(localip);
    }
    if (localLinkedList2.isEmpty()) {
      return;
    }
    this.ehM.addAll(this.ehL);
    this.ehL.clear();
    ??? = new p(localLinkedList2);
    com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)???, 0);
  }
  
  private void MR()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.ehR)
    {
      if (!this.ehQ.isEmpty()) {
        return;
      }
      if (this.ehP.isEmpty()) {
        return;
      }
    }
    HashMap localHashMap = new HashMap();
    Object localObject5 = this.ehP.iterator();
    Object localObject6;
    Object localObject3;
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (h.a)((Iterator)localObject5).next();
      localObject3 = (LinkedList)localHashMap.get(h.a.a((h.a)localObject6));
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new LinkedList();
        localHashMap.put(h.a.a((h.a)localObject6), localObject2);
      }
      ((LinkedList)localObject2).add(h.a.b((h.a)localObject6));
    }
    Object localObject2 = localHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject5 = (LinkedList)localHashMap.get(localObject3);
      if ((localObject5 != null) && (!((LinkedList)localObject5).isEmpty()))
      {
        localObject6 = new js();
        ((js)localObject6).sCO = ((String)localObject3);
        ((js)localObject6).sEz = ((LinkedList)localObject5);
        localLinkedList.add(localObject6);
      }
    }
    this.ehQ.addAll(this.ehP);
    this.ehP.clear();
    localObject2 = new r(localLinkedList, null);
    com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject2, 0);
  }
  
  public static n a(String paramString, zp paramzp, com.tencent.mm.ai.n paramn)
  {
    paramString = new n(paramString, paramzp, paramn);
    com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
    return paramString;
  }
  
  public static w a(String paramString, io paramio, com.tencent.mm.ai.n paramn)
  {
    paramString = new w(paramString, paramio, paramn);
    com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
    return paramString;
  }
  
  public static x a(String paramString1, String paramString2, ir paramir1, ir paramir2, com.tencent.mm.ai.n paramn)
  {
    paramString1 = new x(paramString1, paramString2, paramir1, paramir2, paramn);
    com.tencent.mm.kernel.g.DO().dJT.a(paramString1, 0);
    return paramString1;
  }
  
  public static void a(String paramString, com.tencent.mm.ai.n paramn)
  {
    paramString = new q(paramString, paramn);
    com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.ai.n paramn)
  {
    if (paramn == null) {
      return;
    }
    Object localObject = e.lu(paramString2);
    if ((localObject == null) || (((j)localObject).field_userId.equals(paramString1)))
    {
      a(paramString2, paramn);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString1);
    paramString1 = new js();
    paramString1.sCO = paramString2;
    paramString1.sEz = ((LinkedList)localObject);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = new r(paramString2, paramn);
    com.tencent.mm.kernel.g.DO().dJT.a(paramString1, 0);
  }
  
  private static boolean a(iv paramiv, String paramString)
  {
    if ((bk.bl(paramString)) || (bk.bl(paramiv.sCP))) {}
    do
    {
      return false;
      j localj = new j();
      localj.field_userId = paramiv.sCP;
      localj.field_userName = paramiv.ipb;
      localj.field_brandUserName = paramString;
      localj.field_headImageUrl = paramiv.sCJ;
      localj.field_profileUrl = paramiv.sCX;
      localj.field_UserVersion = paramiv.ver;
      localj.field_addMemberUrl = paramiv.sCN;
      if (!z.MC().b(localj)) {
        z.MC().a(localj);
      }
      paramiv = new c();
      paramiv.field_bizChatServId = localj.field_userId;
      paramiv.field_brandUserName = localj.field_brandUserName;
      paramiv.field_chatName = localj.field_userName;
      paramiv.field_chatType = 1;
    } while (e.e(paramiv) == null);
    return true;
  }
  
  private static boolean a(zp paramzp, String paramString, boolean paramBoolean)
  {
    y.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
    if ((paramzp == null) || (paramzp.sYQ == null) || (bk.bl(paramString)))
    {
      y.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
      return false;
    }
    Object localObject1 = z.MA().lp(paramzp.sYQ.sCI);
    int i;
    if (localObject1 == null)
    {
      y.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
      localObject1 = new c();
      ((c)localObject1).field_bizChatServId = paramzp.sYQ.sCI;
      ((c)localObject1).field_brandUserName = paramString;
      i = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (paramzp.sCQ == null)
      {
        y.w("MicroMsg.BizChatNetworkMgr", "members==null");
        return false;
      }
      Object localObject2;
      label363:
      Object localObject3;
      String str;
      if ((((c)localObject1).MO()) || (paramzp.sYQ.ver > ((c)localObject1).field_chatVersion))
      {
        ((c)localObject1).field_chatType = paramzp.sYQ.type;
        ((c)localObject1).field_headImageUrl = paramzp.sYQ.sCJ;
        ((c)localObject1).field_chatName = paramzp.sYQ.name;
        ((c)localObject1).field_chatVersion = paramzp.sYQ.ver;
        ((c)localObject1).field_needToUpdate = false;
        ((c)localObject1).field_bitFlag = paramzp.sYQ.sCK;
        ((c)localObject1).field_maxMemberCnt = paramzp.sYQ.sCL;
        ((c)localObject1).field_ownerUserId = paramzp.sYQ.sCM;
        ((c)localObject1).field_addMemberUrl = paramzp.sYQ.sCN;
        ((c)localObject1).field_brandUserName = paramString;
        paramString = new LinkedList();
        localObject2 = paramzp.sCQ.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add(((iq)((Iterator)localObject2).next()).sCP);
        }
        ((c)localObject1).field_userList = bk.c(paramString, ";");
        if (i != 0) {
          z.MA().a((c)localObject1);
        }
      }
      else
      {
        e.h((c)localObject1);
        if (!paramBoolean) {
          break label545;
        }
        paramString = new js();
        paramString.sCO = ((c)localObject1).field_brandUserName;
        localObject1 = new LinkedList();
        paramzp = paramzp.sCQ.iterator();
        if (!paramzp.hasNext()) {
          break label493;
        }
        localObject2 = (iq)paramzp.next();
        localObject3 = z.MC();
        str = ((iq)localObject2).sCP;
        if (!bk.bl(str)) {
          break label456;
        }
        y.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
        i = -1;
      }
      long l;
      for (;;)
      {
        l = i;
        if (((iq)localObject2).ver <= l) {
          break label363;
        }
        ((LinkedList)localObject1).add(((iq)localObject2).sCP);
        break label363;
        z.MA().b((c)localObject1);
        break;
        label456:
        localObject3 = ((k)localObject3).bY(str);
        if (localObject3 != null)
        {
          i = ((j)localObject3).field_UserVersion;
        }
        else
        {
          y.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
          i = -1;
        }
      }
      label493:
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString.sEz = ((LinkedList)localObject1);
        paramzp = new LinkedList();
        paramzp.add(paramString);
        paramzp = new r(paramzp, null);
        com.tencent.mm.kernel.g.DO().dJT.a(paramzp, 0);
      }
      for (;;)
      {
        return true;
        label545:
        paramString = z.MC().dXw;
        l = 0L;
        if ((paramString instanceof com.tencent.mm.cf.h)) {
          l = ((com.tencent.mm.cf.h)paramString).eV(Thread.currentThread().getId());
        }
        paramzp = paramzp.sCQ.iterator();
        while (paramzp.hasNext())
        {
          localObject2 = (iq)paramzp.next();
          localObject3 = z.MC().bY(((iq)localObject2).sCP);
          if (localObject3 == null)
          {
            localObject3 = new j();
            ((j)localObject3).field_userId = ((iq)localObject2).sCP;
            ((j)localObject3).field_userName = ((iq)localObject2).ipb;
            ((j)localObject3).field_brandUserName = ((c)localObject1).field_brandUserName;
            ((j)localObject3).field_needToUpdate = true;
            z.MC().a((j)localObject3);
          }
          else if (((iq)localObject2).ver > ((j)localObject3).field_UserVersion)
          {
            ((j)localObject3).field_needToUpdate = true;
            z.MC().b((j)localObject3);
          }
        }
        if ((paramString instanceof com.tencent.mm.cf.h)) {
          com.tencent.mm.kernel.g.DP().dKu.hI(l);
        }
      }
      i = 0;
    }
  }
  
  public static void ar(String paramString1, String paramString2)
  {
    paramString1 = new o(paramString1, paramString2);
    com.tencent.mm.kernel.g.DO().dJT.a(paramString1, 0);
  }
  
  public static void f(com.tencent.mm.ah.m paramm)
  {
    com.tencent.mm.kernel.g.DO().dJT.c(paramm);
  }
  
  public final void a(LinkedList<String> paramLinkedList, String paramString)
  {
    long l = System.currentTimeMillis();
    synchronized (this.ehN)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        h.a locala = new h.a(paramString, str);
        if (!this.ehM.contains(locala))
        {
          this.ehL.add(locala);
          this.ehO.put(str, new Long(l));
        }
      }
    }
    MQ();
  }
  
  public final void ao(String paramString1, String paramString2)
  {
    ??? = (Long)this.ehO.get(paramString1);
    if ((??? == null) || (((Long)???).longValue() + 5000L < System.currentTimeMillis()))
    {
      long l = System.currentTimeMillis();
      synchronized (this.ehN)
      {
        paramString2 = new h.a(paramString2, paramString1);
        if (this.ehM.contains(paramString2)) {
          return;
        }
        this.ehL.add(paramString2);
        this.ehO.put(paramString1, new Long(l));
        MQ();
        return;
      }
    }
  }
  
  public final void ap(String paramString1, String paramString2)
  {
    Long localLong = (Long)this.ehS.get(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      aq(paramString1, paramString2);
    }
  }
  
  public final void aq(String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    synchronized (this.ehR)
    {
      paramString2 = new h.a(paramString2, paramString1);
      if (this.ehQ.contains(paramString2)) {
        return;
      }
      this.ehP.add(paramString2);
      this.ehS.put(paramString1, new Long(l));
      MR();
      return;
    }
  }
  
  public final void b(LinkedList<String> paramLinkedList, String paramString)
  {
    long l = System.currentTimeMillis();
    synchronized (this.ehR)
    {
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        h.a locala = new h.a(paramString, str);
        if (this.ehQ.contains(locala)) {
          return;
        }
        this.ehP.add(locala);
        this.ehS.put(str, new Long(l));
      }
    }
    MR();
  }
  
  protected final void finalize()
  {
    com.tencent.mm.kernel.g.DO().dJT.b(1352, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1365, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1353, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1354, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1357, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1356, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1355, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1358, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1367, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1361, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1389, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1315, this);
    super.finalize();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ah.m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
      if ((paramm.getType() == 1365) || (paramm.getType() == 1353)) {}
    }
    label223:
    boolean bool2;
    boolean bool1;
    label305:
    label312:
    label489:
    label495:
    label505:
    do
    {
      do
      {
        return;
        switch (paramm.getType())
        {
        case 1358: 
        default: 
          return;
        case 1315: 
          ??? = (m)paramm;
          paramm = ???.MS();
          paramInt1 = 0;
          if ((paramm == null) || (paramm.sCU == null) || (paramm.sCU.ret != 0))
          {
            if ((paramm == null) || (paramm.sCU == null)) {
              break label2304;
            }
            y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramm.sCU.ret) });
            paramInt1 = -1;
          }
          paramInt2 = paramInt1;
          if (paramInt1 >= 0)
          {
            paramInt2 = paramInt1;
            if (paramm.sPR == null)
            {
              paramInt2 = paramInt1;
              if (paramm.sPQ == null) {
                paramInt2 = -1;
              }
            }
          }
          if (paramInt2 < 0) {
            break label3562;
          }
          if (paramm.sPR == null) {
            break label2316;
          }
          bool2 = a(paramm.sPR, paramm.sCO);
          bool1 = bool2;
          if (bool2)
          {
            ???.eia = paramm.sPR.sCP;
            bool1 = bool2;
          }
          if (bool1) {
            break label3562;
          }
          paramInt1 = -1;
          paramm = (com.tencent.mm.ai.n)???.data;
        }
      } while (paramm == null);
      paramm.a(paramInt1, ???);
      return;
      localObject1 = (o)paramm;
      if ((((o)localObject1).dmK != null) && (((o)localObject1).dmK.ecF.ecN != null))
      {
        ??? = (acl)((o)localObject1).dmK.ecF.ecN;
        if ((((o)localObject1).dmK == null) || (((o)localObject1).dmK.ecE.ecN == null)) {
          break label489;
        }
      }
      for (paramm = (ack)((o)localObject1).dmK.ecE.ecN;; paramm = null)
      {
        bool1 = ((o)localObject1).eib;
        if ((??? != null) && (???.sCU != null) && (???.sCU.ret == 0)) {
          break label505;
        }
        if ((??? == null) || (???.sCU == null)) {
          break label495;
        }
        y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.sCU.ret) });
        return;
        ??? = null;
        break;
      }
      y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      return;
      a(???.sPX, paramm.sCO, bool1);
      return;
      for (;;)
      {
        synchronized (this.ehN)
        {
          this.ehM.clear();
          MQ();
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break;
          }
          paramm = (p)paramm;
          if ((paramm.dmK != null) && (paramm.dmK.ecF.ecN != null))
          {
            ??? = (acj)paramm.dmK.ecF.ecN;
            if ((??? != null) && (???.sCU != null) && (???.sCU.ret == 0)) {
              break label674;
            }
            if ((??? == null) || (???.sCU == null)) {
              break label664;
            }
            y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.sCU.ret) });
            return;
          }
        }
        ??? = null;
      }
      y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      return;
      ??? = ???.tbq;
      if ((??? == null) || (???.size() == 0))
      {
        y.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
        return;
      }
      localObject1 = ???.iterator();
    } while (!((Iterator)localObject1).hasNext());
    label664:
    label674:
    Object localObject2 = (zp)((Iterator)localObject1).next();
    ??? = ((zp)localObject2).sYQ.sCI;
    if ((??? == null) || (paramm.eic == null)) {}
    for (??? = null;; ??? = (String)paramm.eic.get(???))
    {
      a((zp)localObject2, ???, false);
      break;
    }
    Object localObject1 = (r)paramm;
    localObject2 = (com.tencent.mm.ai.n)((r)localObject1).data;
    if (localObject2 == null) {}
    label1330:
    label1342:
    label1362:
    label1374:
    label1386:
    label1651:
    label3572:
    label3575:
    label3580:
    for (;;)
    {
      Object localObject3;
      long l;
      Object localObject4;
      synchronized (this.ehR)
      {
        this.ehQ.clear();
        MR();
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        if ((((r)localObject1).dmK != null) && (((r)localObject1).dmK.ecF.ecN != null))
        {
          ??? = (acp)((r)localObject1).dmK.ecF.ecN;
          paramInt1 = 0;
          if ((??? == null) || (???.sCU == null) || (???.sCU.ret != 0))
          {
            if ((??? == null) || (???.sCU == null)) {
              break label1330;
            }
            y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.sCU.ret) });
            paramInt1 = -1;
          }
          if ((paramInt1 < 0) || (???.sCV != null)) {
            break label3580;
          }
          y.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
          paramInt1 = -1;
          if (paramInt1 < 0) {
            break label1431;
          }
          localObject3 = z.MC().dXw;
          l = 0L;
          if ((localObject3 instanceof com.tencent.mm.cf.h)) {
            l = ((com.tencent.mm.cf.h)localObject3).eV(Thread.currentThread().getId());
          }
          paramInt2 = 0;
          if (paramInt2 >= ???.sCV.size()) {
            break label1411;
          }
          y.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[] { ((iv)???.sCV.get(paramInt2)).ipb });
          localObject4 = new j();
          ((j)localObject4).field_userId = ((iv)???.sCV.get(paramInt2)).sCP;
          ((j)localObject4).field_userName = ((iv)???.sCV.get(paramInt2)).ipb;
          paramm = ((j)localObject4).field_userId;
          if ((paramm != null) && (((r)localObject1).eid != null)) {
            break label1342;
          }
          paramm = null;
          ((j)localObject4).field_brandUserName = paramm;
          ((j)localObject4).field_UserVersion = ((iv)???.sCV.get(paramInt2)).ver;
          ((j)localObject4).field_headImageUrl = ((iv)???.sCV.get(paramInt2)).sCJ;
          ((j)localObject4).field_profileUrl = ((iv)???.sCV.get(paramInt2)).sCX;
          ((j)localObject4).field_bitFlag = ((iv)???.sCV.get(paramInt2)).sCK;
          ((j)localObject4).field_addMemberUrl = ((iv)???.sCV.get(paramInt2)).sCN;
          ((j)localObject4).field_needToUpdate = false;
          paramm = z.MC().bY(((iv)???.sCV.get(paramInt2)).sCP);
          if (paramm != null) {
            break label1362;
          }
          bool1 = false;
          bool2 = ((j)localObject4).il(16);
          if (paramm != null) {
            break label1374;
          }
          z.MC().a((j)localObject4);
          if (bool1 != bool2)
          {
            paramm = z.MA().lp(((j)localObject4).field_userId);
            if (paramm != null)
            {
              if ((!bool1) || (bool2)) {
                break label1386;
              }
              z.MB().bP(paramm.field_bizChatLocalId);
            }
          }
          paramInt2 += 1;
        }
      }
      ??? = null;
      continue;
      y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      continue;
      paramm = (String)((r)localObject1).eid.get(paramm);
      continue;
      bool1 = paramm.il(16);
      continue;
      z.MC().b((j)localObject4);
      continue;
      if ((!bool1) && (bool2))
      {
        z.MB().bO(paramm.field_bizChatLocalId);
        continue;
        if ((localObject3 instanceof com.tencent.mm.cf.h)) {
          com.tencent.mm.kernel.g.DP().dKu.hI(l);
        }
        if (localObject2 == null) {
          break;
        }
        ((com.tencent.mm.ai.n)localObject2).a(paramInt1, (com.tencent.mm.ah.m)localObject1);
        return;
        localObject1 = (q)paramm;
        if ((((q)localObject1).dmK != null) && (((q)localObject1).dmK.ecF.ecN != null))
        {
          ??? = (acn)((q)localObject1).dmK.ecF.ecN;
          if (((q)localObject1).dmK != null) {
            break label1632;
          }
          paramm = null;
          if ((??? != null) && (???.sCU != null) && (???.sCU.ret == 0)) {
            break label3575;
          }
          if ((??? == null) || (???.sCU == null)) {
            break label1651;
          }
          y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.sCU.ret) });
        }
        for (paramInt1 = -1;; paramInt1 = 0)
        {
          if (paramInt1 >= 0)
          {
            localObject2 = z.MC();
            paramm = paramm.sCO;
            ??? = ???.sCR;
            if ((??? == null) || (bk.bl(paramm))) {
              y.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
            }
          }
          else
          {
            ??? = (com.tencent.mm.ai.n)((q)localObject1).data;
            if (??? == null) {
              break;
            }
            ???.a(paramInt1, (com.tencent.mm.ah.m)localObject1);
            return;
            ??? = null;
            break label1491;
            paramm = (acm)((q)localObject1).dmK.ecE.ecN;
            break label1502;
            y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label1560;
          }
          y.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[] { paramm, ???.sCP, Boolean.valueOf(bk.bl(???.sCN)) });
          localObject3 = z.MD().lz(paramm);
          if (localObject3 == null)
          {
            localObject3 = new f();
            ((f)localObject3).field_brandUserName = paramm;
            ((f)localObject3).field_userId = ???.sCP;
            z.MD().a((f)localObject3);
          }
          for (;;)
          {
            localObject3 = new j();
            ((j)localObject3).field_userId = ???.sCP;
            ((j)localObject3).field_userName = ???.ipb;
            ((j)localObject3).field_brandUserName = paramm;
            ((j)localObject3).field_UserVersion = ???.ver;
            ((j)localObject3).field_headImageUrl = ???.sCJ;
            ((j)localObject3).field_profileUrl = ???.sCX;
            ((j)localObject3).field_bitFlag = ???.sCK;
            ((j)localObject3).field_needToUpdate = false;
            ((j)localObject3).field_addMemberUrl = ???.sCN;
            if (!((k)localObject2).b((j)localObject3)) {
              ((k)localObject2).a((j)localObject3);
            }
            ((k)localObject2).eho.put(paramm, ((j)localObject3).field_userId);
            break;
            ((f)localObject3).field_userId = ???.sCP;
            z.MD().b((f)localObject3);
            y.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
          }
          ??? = (n)paramm;
          paramm = ???.MT();
          localObject1 = ???.MU();
          paramInt1 = 0;
          if ((paramm == null) || (paramm.sCU == null) || (paramm.sCU.ret != 0))
          {
            if ((paramm != null) && (paramm.sCU != null))
            {
              y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramm.sCU.ret) });
              paramInt1 = -1;
            }
          }
          else
          {
            if (paramInt1 < 0) {
              break label3572;
            }
            if (!a(paramm.sPX, ((rw)localObject1).sCO, true)) {
              break label2049;
            }
            paramInt1 = 0;
          }
          for (;;)
          {
            paramm = (com.tencent.mm.ai.n)???.data;
            if (paramm == null) {
              break;
            }
            paramm.a(paramInt1, ???);
            return;
            y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label1988;
            paramInt1 = -1;
            continue;
            ??? = (t)paramm;
            paramm = ???.MV();
            paramInt1 = 0;
            if ((paramm == null) || (paramm.sCU == null) || (paramm.sCU.ret != 0))
            {
              if ((paramm != null) && (paramm.sCU != null))
              {
                y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramm.sCU.ret) });
                paramInt1 = -1;
              }
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 >= 0)
              {
                paramInt2 = paramInt1;
                if (paramm.sPR == null)
                {
                  paramInt2 = paramInt1;
                  if (paramm.sPQ == null) {
                    paramInt2 = -1;
                  }
                }
              }
              if (paramInt2 < 0) {
                break label3567;
              }
              if (paramm.sPR == null) {
                break label2257;
              }
              bool2 = a(paramm.sPR, paramm.sCO);
              bool1 = bool2;
              if (bool2)
              {
                ???.eia = paramm.sPR.sCP;
                bool1 = bool2;
              }
              if (bool1) {
                break label3567;
              }
            }
            for (paramInt1 = -1;; paramInt1 = paramInt2)
            {
              paramm = (com.tencent.mm.ai.n)???.data;
              if (paramm == null) {
                break;
              }
              paramm.a(paramInt1, ???);
              return;
              y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label2132;
              bool2 = a(paramm.sPQ, paramm.sCO, true);
              bool1 = bool2;
              if (!bool2) {
                break label2214;
              }
              ???.eia = paramm.sPQ.sYQ.sCI;
              bool1 = bool2;
              break label2214;
              y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label223;
              bool2 = a(paramm.sPQ, paramm.sCO, true);
              bool1 = bool2;
              if (!bool2) {
                break label305;
              }
              ???.eia = paramm.sPQ.sYQ.sCI;
              bool1 = bool2;
              break label305;
              y.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
              localObject1 = (x)paramm;
              if ((((x)localObject1).dmK != null) && (((x)localObject1).dmK.ecF.ecN != null))
              {
                ??? = (bzr)((x)localObject1).dmK.ecF.ecN;
                if ((((x)localObject1).dmK == null) || (((x)localObject1).dmK.ecE.ecN == null)) {
                  break label2518;
                }
                paramm = (bzq)((x)localObject1).dmK.ecE.ecN;
              }
              for (;;)
              {
                if ((??? == null) || (???.sCU == null) || (???.sCU.ret != 0))
                {
                  if ((??? != null) && (???.sCU != null))
                  {
                    y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.sCU.ret) });
                    return;
                    ??? = null;
                    break;
                    paramm = null;
                    continue;
                  }
                  y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                  return;
                }
              }
              if (a(???.sPX, paramm.sCO, false)) {}
              for (paramInt1 = 0;; paramInt1 = -1)
              {
                ??? = (com.tencent.mm.ai.n)((x)localObject1).data;
                if (??? == null) {
                  break;
                }
                ???.a(paramInt1, (com.tencent.mm.ah.m)localObject1);
                return;
              }
              localObject1 = (w)paramm;
              if ((((w)localObject1).dmK != null) && (((w)localObject1).dmK.ecF.ecN != null))
              {
                ??? = (bzt)((w)localObject1).dmK.ecF.ecN;
                if ((((w)localObject1).dmK == null) || (((w)localObject1).dmK.ecE.ecN == null)) {
                  break label2995;
                }
                paramm = (bzs)((w)localObject1).dmK.ecE.ecN;
                paramInt1 = 0;
                if ((??? == null) || (???.sCU == null) || (???.sCU.ret != 0) || (???.sYQ == null))
                {
                  if ((??? == null) || (???.sCU == null)) {
                    break label3001;
                  }
                  y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.sCU.ret) });
                  paramInt1 = -1;
                }
                if (paramInt1 < 0) {
                  break label3559;
                }
                localObject2 = z.MA().lp(???.sYQ.sCI);
                if (localObject2 == null)
                {
                  if (localObject2 != null) {
                    break label3013;
                  }
                  bool1 = true;
                  if (???.sYQ != null) {
                    break label3019;
                  }
                  bool2 = true;
                  y.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null:%s, resp.chat == null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  paramInt1 = -1;
                }
                if ((paramInt1 < 0) || (((((c)localObject2).field_bitFlag == ???.sYQ.sCK) || (!((c)localObject2).MO())) && (???.sYQ.ver <= ((c)localObject2).field_chatVersion))) {
                  break label3025;
                }
                ((c)localObject2).field_chatType = ???.sYQ.type;
                ((c)localObject2).field_headImageUrl = ???.sYQ.sCJ;
                ((c)localObject2).field_chatName = ???.sYQ.name;
                ((c)localObject2).field_chatVersion = ???.sYQ.ver;
                ((c)localObject2).field_needToUpdate = false;
                ((c)localObject2).field_bitFlag = ???.sYQ.sCK;
                ((c)localObject2).field_maxMemberCnt = ???.sYQ.sCL;
                ((c)localObject2).field_ownerUserId = ???.sYQ.sCM;
                ((c)localObject2).field_addMemberUrl = ???.sYQ.sCN;
                ((c)localObject2).field_brandUserName = paramm.sCO;
                z.MA().b((c)localObject2);
              }
              for (;;)
              {
                ??? = (com.tencent.mm.ai.n)((w)localObject1).data;
                if (??? == null) {
                  break;
                }
                ???.a(paramInt1, (com.tencent.mm.ah.m)localObject1);
                return;
                ??? = null;
                break label2624;
                paramm = null;
                break label2662;
                y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                break label2729;
                bool1 = false;
                break label2763;
                bool2 = false;
                break label2773;
                paramInt1 = -1;
                continue;
                paramm = (s)paramm;
                if ((paramm.dmK != null) && (paramm.dmK.ecF.ecN != null))
                {
                  ??? = (afu)paramm.dmK.ecF.ecN;
                  if ((paramm.dmK == null) || (paramm.dmK.ecE.ecN == null)) {
                    break label3176;
                  }
                  paramm = (aft)paramm.dmK.ecE.ecN;
                }
                for (;;)
                {
                  if ((??? == null) || (???.sCU == null) || (???.sCU.ret != 0))
                  {
                    if ((??? != null) && (???.sCU != null))
                    {
                      y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.sCU.ret) });
                      return;
                      ??? = null;
                      break;
                      paramm = null;
                      continue;
                    }
                    y.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    return;
                  }
                }
                localObject2 = ???.tdH;
                localObject3 = z.MA();
                localObject4 = paramm.sCO;
                localObject1 = new ArrayList();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("select bizChatServId from BizChatInfo");
                localStringBuilder.append(" where brandUserName = '").append((String)localObject4).append("'");
                localStringBuilder.append(" and (bitFlag & 8) != 0 ");
                localObject3 = ((d)localObject3).rawQuery(localStringBuilder.toString(), new String[0]);
                if (localObject3 != null)
                {
                  if (((Cursor)localObject3).moveToFirst()) {
                    do
                    {
                      ((ArrayList)localObject1).add(((Cursor)localObject3).getString(0));
                    } while (((Cursor)localObject3).moveToNext());
                  }
                  ((Cursor)localObject3).close();
                }
                localObject3 = ((List)localObject1).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (String)((Iterator)localObject3).next();
                  if (!((List)localObject2).contains(localObject4))
                  {
                    localObject4 = z.MA().lp((String)localObject4);
                    if (localObject4 != null)
                    {
                      ((c)localObject4).field_bitFlag &= 0xFFFFFFF7;
                      z.MA().b((c)localObject4);
                    }
                  }
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  if (!((List)localObject1).contains(localObject3))
                  {
                    localObject4 = z.MA().lp((String)localObject3);
                    if (localObject4 == null)
                    {
                      localObject4 = new c();
                      ((c)localObject4).field_bizChatServId = ((String)localObject3);
                      ((c)localObject4).field_brandUserName = paramm.sCO;
                      ((c)localObject4).field_bitFlag |= 0x8;
                      z.MA().a((c)localObject4);
                    }
                    else
                    {
                      ((c)localObject4).field_bitFlag |= 0x8;
                      z.MA().b((c)localObject4);
                    }
                  }
                }
                a(???.tdH, paramm.sCO);
                return;
              }
              paramInt1 = paramInt2;
              break label312;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ai.a.h
 * JD-Core Version:    0.7.0.1
 */