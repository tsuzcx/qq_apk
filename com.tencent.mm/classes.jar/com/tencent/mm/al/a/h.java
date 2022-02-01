package com.tencent.mm.al.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.bjo;
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.protocal.protobuf.elp;
import com.tencent.mm.protocal.protobuf.elq;
import com.tencent.mm.protocal.protobuf.elr;
import com.tencent.mm.protocal.protobuf.els;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.protocal.protobuf.nu;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements i
{
  private HashSet<a> iQe;
  private HashSet<a> iQf;
  private final Object iQg;
  private com.tencent.mm.b.f<String, Long> iQh;
  private HashSet<a> iQi;
  private HashSet<a> iQj;
  private final Object iQk;
  private com.tencent.mm.b.f<String, Long> iQl;
  
  public h()
  {
    AppMethodBeat.i(124255);
    this.iQe = new HashSet();
    this.iQf = new HashSet();
    this.iQg = new Object();
    this.iQh = new com.tencent.mm.b.h(64);
    this.iQi = new HashSet();
    this.iQj = new HashSet();
    this.iQk = new Object();
    this.iQl = new com.tencent.mm.b.h(64);
    com.tencent.mm.kernel.g.aAg().hqi.a(1352, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1365, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1353, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1354, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1357, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1356, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1355, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1358, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1367, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1361, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1389, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1315, this);
    AppMethodBeat.o(124255);
  }
  
  public static o a(String paramString, bfs parambfs, com.tencent.mm.al.p paramp)
  {
    AppMethodBeat.i(124270);
    paramString = new o(paramString, parambfs, paramp);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(124270);
    return paramString;
  }
  
  public static x a(String paramString, nt paramnt, com.tencent.mm.al.p paramp)
  {
    AppMethodBeat.i(124272);
    paramString = new x(paramString, paramnt, paramp);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(124272);
    return paramString;
  }
  
  public static y a(String paramString1, String paramString2, nw paramnw1, nw paramnw2, com.tencent.mm.al.p paramp)
  {
    AppMethodBeat.i(124271);
    paramString1 = new y(paramString1, paramString2, paramnw1, paramnw2, paramp);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    AppMethodBeat.o(124271);
    return paramString1;
  }
  
  public static void a(String paramString, com.tencent.mm.al.p paramp)
  {
    AppMethodBeat.i(124269);
    paramString = new r(paramString, paramp);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(124269);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.al.p paramp)
  {
    AppMethodBeat.i(124268);
    if (paramp == null)
    {
      AppMethodBeat.o(124268);
      return;
    }
    Object localObject = e.NJ(paramString2);
    if ((localObject == null) || (((k)localObject).field_userId.equals(paramString1)))
    {
      a(paramString2, paramp);
      AppMethodBeat.o(124268);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString1);
    paramString1 = new qv();
    paramString1.KTt = paramString2;
    paramString1.KXK = ((LinkedList)localObject);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = new s(paramString2, paramp);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    AppMethodBeat.o(124268);
  }
  
  private static boolean a(bfs parambfs, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124275);
    Log.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
    if ((parambfs == null) || (parambfs.LPp == null) || (Util.isNullOrNil(paramString)))
    {
      Log.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
      AppMethodBeat.o(124275);
      return false;
    }
    Object localObject1 = ag.baj().NE(parambfs.LPp.KTl);
    int i;
    if (localObject1 == null)
    {
      Log.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
      localObject1 = new c();
      ((c)localObject1).field_bizChatServId = parambfs.LPp.KTl;
      ((c)localObject1).field_brandUserName = paramString;
      i = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (parambfs.KTv == null)
      {
        Log.w("MicroMsg.BizChatNetworkMgr", "members==null");
        AppMethodBeat.o(124275);
        return false;
      }
      Object localObject2;
      if ((((c)localObject1).bay()) || (parambfs.LPp.ver > ((c)localObject1).field_chatVersion))
      {
        ((c)localObject1).field_chatType = parambfs.LPp.type;
        ((c)localObject1).field_headImageUrl = parambfs.LPp.KTm;
        ((c)localObject1).field_chatName = parambfs.LPp.name;
        ((c)localObject1).field_chatVersion = parambfs.LPp.ver;
        ((c)localObject1).field_needToUpdate = false;
        ((c)localObject1).field_bitFlag = parambfs.LPp.KTn;
        ((c)localObject1).field_maxMemberCnt = parambfs.LPp.KTp;
        ((c)localObject1).field_ownerUserId = parambfs.LPp.KTq;
        ((c)localObject1).field_addMemberUrl = parambfs.LPp.KTr;
        ((c)localObject1).field_brandUserName = paramString;
        ((c)localObject1).field_roomflag = parambfs.LPp.KTs;
        paramString = new LinkedList();
        localObject2 = parambfs.KTv.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add(((nv)((Iterator)localObject2).next()).KTu);
        }
        ((c)localObject1).field_userList = Util.listToString(paramString, ";");
        if (i == 0) {
          break label442;
        }
        ag.baj().a((c)localObject1);
      }
      long l;
      for (;;)
      {
        e.h((c)localObject1);
        if (!paramBoolean) {
          break label511;
        }
        paramString = new qv();
        paramString.KTt = ((c)localObject1).field_brandUserName;
        localObject1 = new LinkedList();
        parambfs = parambfs.KTv.iterator();
        while (parambfs.hasNext())
        {
          localObject2 = (nv)parambfs.next();
          l = ag.bal().NP(((nv)localObject2).KTu);
          if (((nv)localObject2).ver > l) {
            ((LinkedList)localObject1).add(((nv)localObject2).KTu);
          }
        }
        label442:
        ag.baj().b((c)localObject1);
      }
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString.KXK = ((LinkedList)localObject1);
        parambfs = new LinkedList();
        parambfs.add(paramString);
        parambfs = new s(parambfs, null);
        com.tencent.mm.kernel.g.aAg().hqi.a(parambfs, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(124275);
        return true;
        label511:
        paramString = ag.bal().db;
        l = 0L;
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)paramString).beginTransaction(Thread.currentThread().getId());
        }
        parambfs = parambfs.KTv.iterator();
        while (parambfs.hasNext())
        {
          localObject2 = (nv)parambfs.next();
          k localk = ag.bal().fB(((nv)localObject2).KTu);
          if (localk == null)
          {
            localk = new k();
            localk.field_userId = ((nv)localObject2).KTu;
            localk.field_userName = ((nv)localObject2).pWm;
            localk.field_brandUserName = ((c)localObject1).field_brandUserName;
            localk.field_needToUpdate = true;
            ag.bal().a(localk);
          }
          else if (((nv)localObject2).ver > localk.field_UserVersion)
          {
            localk.field_needToUpdate = true;
            ag.bal().b(localk);
          }
        }
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.g.aAh().hqK.endTransaction(l);
        }
      }
      i = 0;
    }
  }
  
  private static boolean a(oa paramoa, String paramString)
  {
    AppMethodBeat.i(124274);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramoa.KTu)))
    {
      AppMethodBeat.o(124274);
      return false;
    }
    k localk = new k();
    localk.field_userId = paramoa.KTu;
    localk.field_userName = paramoa.pWm;
    localk.field_brandUserName = paramString;
    localk.field_headImageUrl = paramoa.KTm;
    localk.field_profileUrl = paramoa.gTH;
    localk.field_UserVersion = paramoa.ver;
    localk.field_addMemberUrl = paramoa.KTr;
    if (!ag.bal().b(localk)) {
      ag.bal().a(localk);
    }
    paramoa = new c();
    paramoa.field_bizChatServId = localk.field_userId;
    paramoa.field_brandUserName = localk.field_brandUserName;
    paramoa.field_chatName = localk.field_userName;
    paramoa.field_chatType = j.iQn.iQq;
    if (e.e(paramoa) == null)
    {
      AppMethodBeat.o(124274);
      return false;
    }
    AppMethodBeat.o(124274);
    return true;
  }
  
  private void baA()
  {
    AppMethodBeat.i(124262);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.iQg)
    {
      if (!this.iQf.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      if (this.iQe.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      Iterator localIterator = this.iQe.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        nu localnu = new nu();
        localnu.KTt = a.a(locala);
        localnu.KTl = a.b(locala);
        localLinkedList1.add(localnu);
      }
    }
    if (localLinkedList2.isEmpty())
    {
      AppMethodBeat.o(124262);
      return;
    }
    this.iQf.addAll(this.iQe);
    this.iQe.clear();
    ??? = new q(localLinkedList2);
    com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)???, 0);
    AppMethodBeat.o(124262);
  }
  
  private void baB()
  {
    AppMethodBeat.i(124266);
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    synchronized (this.iQk)
    {
      if (!this.iQj.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      if (this.iQi.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      localHashMap = new HashMap();
      localObject6 = this.iQi.iterator();
      if (((Iterator)localObject6).hasNext())
      {
        localObject7 = (a)((Iterator)localObject6).next();
        localObject4 = (LinkedList)localHashMap.get(a.a((a)localObject7));
        Object localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new LinkedList();
          localHashMap.put(a.a((a)localObject7), localObject1);
        }
        ((LinkedList)localObject1).add(a.b((a)localObject7));
      }
    }
    Object localObject3 = localHashMap.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      localObject6 = (LinkedList)localHashMap.get(localObject4);
      if ((localObject6 != null) && (!((LinkedList)localObject6).isEmpty()))
      {
        localObject7 = new qv();
        ((qv)localObject7).KTt = ((String)localObject4);
        ((qv)localObject7).KXK = ((LinkedList)localObject6);
        localLinkedList.add(localObject7);
      }
    }
    this.iQj.addAll(this.iQi);
    this.iQi.clear();
    localObject3 = new s(localLinkedList, null);
    com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject3, 0);
    AppMethodBeat.o(124266);
  }
  
  private void bk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124260);
    long l = System.currentTimeMillis();
    synchronized (this.iQg)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.iQf.contains(paramString2))
      {
        AppMethodBeat.o(124260);
        return;
      }
      this.iQe.add(paramString2);
      this.iQh.put(paramString1, new Long(l));
      baA();
      AppMethodBeat.o(124260);
      return;
    }
  }
  
  public static void bn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124267);
    paramString1 = new p(paramString1, paramString2);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    AppMethodBeat.o(124267);
  }
  
  public static void d(com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(124258);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramq);
    AppMethodBeat.o(124258);
  }
  
  public static void k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124273);
    paramString1 = new w(paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    AppMethodBeat.o(124273);
  }
  
  public final void b(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124261);
    long l = System.currentTimeMillis();
    synchronized (this.iQg)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (!this.iQf.contains(locala))
        {
          this.iQe.add(locala);
          this.iQh.put(str, new Long(l));
        }
      }
    }
    baA();
    AppMethodBeat.o(124261);
  }
  
  public final void bj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124259);
    Long localLong = (Long)this.iQh.aT(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bk(paramString1, paramString2);
    }
    AppMethodBeat.o(124259);
  }
  
  public final void bl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124263);
    Long localLong = (Long)this.iQl.aT(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bm(paramString1, paramString2);
    }
    AppMethodBeat.o(124263);
  }
  
  public final void bm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124264);
    long l = System.currentTimeMillis();
    synchronized (this.iQk)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.iQj.contains(paramString2))
      {
        AppMethodBeat.o(124264);
        return;
      }
      this.iQi.add(paramString2);
      this.iQl.put(paramString1, new Long(l));
      baB();
      AppMethodBeat.o(124264);
      return;
    }
  }
  
  public final void c(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124265);
    long l = System.currentTimeMillis();
    synchronized (this.iQk)
    {
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (this.iQj.contains(locala))
        {
          AppMethodBeat.o(124265);
          return;
        }
        this.iQi.add(locala);
        this.iQl.put(str, new Long(l));
      }
    }
    baB();
    AppMethodBeat.o(124265);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(124256);
    com.tencent.mm.kernel.g.aAg().hqi.b(1352, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1365, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1353, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1354, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1357, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1356, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1355, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1358, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1367, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1361, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1389, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1315, this);
    super.finalize();
    AppMethodBeat.o(124256);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(124257);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
      if ((paramq.getType() != 1365) && (paramq.getType() != 1353))
      {
        AppMethodBeat.o(124257);
        return;
      }
    }
    Object localObject1;
    boolean bool1;
    label321:
    label327:
    label342:
    Object localObject2;
    switch (paramq.getType())
    {
    default: 
      AppMethodBeat.o(124257);
      return;
    case 1352: 
      localObject1 = (p)paramq;
      if ((((p)localObject1).rr != null) && (((p)localObject1).rr.iLL.iLR != null))
      {
        ??? = (bjm)((p)localObject1).rr.iLL.iLR;
        if ((((p)localObject1).rr == null) || (((p)localObject1).rr.iLK.iLR == null)) {
          break label321;
        }
      }
      for (paramq = (bjl)((p)localObject1).rr.iLK.iLR;; paramq = null)
      {
        bool1 = ((p)localObject1).iQA;
        if ((??? != null) && (???.KTz != null) && (???.KTz.ret == 0)) {
          break label342;
        }
        if ((??? == null) || (???.KTz == null)) {
          break label327;
        }
        Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.KTz.ret) });
        AppMethodBeat.o(124257);
        return;
        ??? = null;
        break;
      }
      Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(124257);
      return;
      a(???.Lpw, paramq.KTt, bool1);
      AppMethodBeat.o(124257);
      return;
    case 1365: 
      synchronized (this.iQg)
      {
        this.iQf.clear();
        baA();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      paramq = (q)paramq;
      if ((paramq.rr != null) && (paramq.rr.iLL.iLR != null)) {
        ??? = (bjk)paramq.rr.iLL.iLR;
      }
      while ((??? == null) || (???.KTz == null) || (???.KTz.ret != 0)) {
        if ((??? != null) && (???.KTz != null))
        {
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.KTz.ret) });
          AppMethodBeat.o(124257);
          return;
          ??? = null;
        }
        else
        {
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          AppMethodBeat.o(124257);
          return;
        }
      }
      ??? = ???.LTh;
      if ((??? == null) || (???.size() == 0))
      {
        Log.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
        AppMethodBeat.o(124257);
        return;
      }
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bfs)((Iterator)localObject1).next();
        ??? = ((bfs)localObject2).LPp.KTl;
        if ((??? == null) || (paramq.iQB == null)) {}
        for (??? = null;; ??? = (String)paramq.iQB.get(???))
        {
          a((bfs)localObject2, ???, false);
          break;
        }
      }
      AppMethodBeat.o(124257);
      return;
    case 1353: 
      localObject1 = (s)paramq;
      localObject2 = (com.tencent.mm.al.p)((s)localObject1).data;
      if (localObject2 == null) {}
      synchronized (this.iQk)
      {
        this.iQj.clear();
        baB();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      if ((((s)localObject1).rr != null) && (((s)localObject1).rr.iLL.iLR != null))
      {
        ??? = (bjq)((s)localObject1).rr.iLL.iLR;
        paramInt1 = 0;
        if ((??? == null) || (???.KTz == null) || (???.KTz.ret != 0))
        {
          if ((??? == null) || (???.KTz == null)) {
            break label1218;
          }
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.KTz.ret) });
          label824:
          paramInt1 = -1;
        }
        if ((paramInt1 < 0) || (???.KTA != null)) {
          break label3717;
        }
        Log.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
        paramInt1 = -1;
      }
      break;
    }
    label998:
    label1261:
    label2286:
    for (;;)
    {
      Object localObject3;
      label888:
      Object localObject4;
      label1136:
      boolean bool2;
      if (paramInt1 >= 0)
      {
        localObject3 = ag.bal().db;
        long l = 0L;
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)localObject3).beginTransaction(Thread.currentThread().getId());
        }
        paramInt2 = 0;
        if (paramInt2 < ???.KTA.size())
        {
          Log.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[] { ((oa)???.KTA.get(paramInt2)).pWm });
          localObject4 = new k();
          ((k)localObject4).field_userId = ((oa)???.KTA.get(paramInt2)).KTu;
          ((k)localObject4).field_userName = ((oa)???.KTA.get(paramInt2)).pWm;
          paramq = ((k)localObject4).field_userId;
          if ((paramq == null) || (((s)localObject1).iQC == null))
          {
            paramq = null;
            ((k)localObject4).field_brandUserName = paramq;
            ((k)localObject4).field_UserVersion = ((oa)???.KTA.get(paramInt2)).ver;
            ((k)localObject4).field_headImageUrl = ((oa)???.KTA.get(paramInt2)).KTm;
            ((k)localObject4).field_profileUrl = ((oa)???.KTA.get(paramInt2)).gTH;
            ((k)localObject4).field_bitFlag = ((oa)???.KTA.get(paramInt2)).KTn;
            ((k)localObject4).field_addMemberUrl = ((oa)???.KTA.get(paramInt2)).KTr;
            ((k)localObject4).field_needToUpdate = false;
            paramq = ag.bal().fB(((oa)???.KTA.get(paramInt2)).KTu);
            if (paramq != null) {
              break label1249;
            }
            bool1 = false;
            bool2 = ((k)localObject4).iE(16);
            if (paramq != null) {
              break label1261;
            }
            ag.bal().a((k)localObject4);
            if (bool1 != bool2)
            {
              paramq = ag.baj().NE(((k)localObject4).field_userId);
              if (paramq != null)
              {
                if ((!bool1) || (bool2)) {
                  break label1273;
                }
                ag.bak().Aq(paramq.field_bizChatLocalId);
              }
            }
          }
          for (;;)
          {
            paramInt2 += 1;
            break label888;
            ??? = null;
            break;
            Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label824;
            paramq = (String)((s)localObject1).iQC.get(paramq);
            break label998;
            bool1 = paramq.iE(16);
            break label1136;
            ag.bal().b((k)localObject4);
            break label1159;
            label1273:
            if ((!bool1) && (bool2)) {
              ag.bak().Ap(paramq.field_bizChatLocalId);
            }
          }
        }
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.g.aAh().hqK.endTransaction(l);
        }
      }
      if (localObject2 != null) {
        ((com.tencent.mm.al.p)localObject2).a(paramInt1, (com.tencent.mm.ak.q)localObject1);
      }
      AppMethodBeat.o(124257);
      return;
      localObject1 = (r)paramq;
      if ((((r)localObject1).rr != null) && (((r)localObject1).rr.iLL.iLR != null))
      {
        ??? = (bjo)((r)localObject1).rr.iLL.iLR;
        if (((r)localObject1).rr != null) {
          break label1530;
        }
        paramq = null;
        label1395:
        if ((??? != null) && (???.KTz != null) && (???.KTz.ret == 0)) {
          break label3712;
        }
        if ((??? == null) || (???.KTz == null)) {
          break label1549;
        }
        Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.KTz.ret) });
      }
      label2032:
      label2416:
      label3696:
      for (paramInt1 = -1;; paramInt1 = 0)
      {
        if (paramInt1 >= 0)
        {
          localObject2 = ag.bal();
          paramq = paramq.KTt;
          ??? = ???.KTw;
          if ((??? == null) || (Util.isNullOrNil(paramq))) {
            Log.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
          }
        }
        else
        {
          ??? = (com.tencent.mm.al.p)((r)localObject1).data;
          if (??? != null) {
            ???.a(paramInt1, (com.tencent.mm.ak.q)localObject1);
          }
          AppMethodBeat.o(124257);
          return;
          ??? = null;
          break label1384;
          label1530:
          paramq = (bjn)((r)localObject1).rr.iLK.iLR;
          break label1395;
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1452;
        }
        Log.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[] { paramq, ???.KTu, Boolean.valueOf(Util.isNullOrNil(???.KTr)) });
        localObject3 = ag.bam().NO(paramq);
        if (localObject3 == null)
        {
          localObject3 = new f();
          ((f)localObject3).field_brandUserName = paramq;
          ((f)localObject3).field_userId = ???.KTu;
          ag.bam().a((f)localObject3);
        }
        for (;;)
        {
          localObject3 = new k();
          ((k)localObject3).field_userId = ???.KTu;
          ((k)localObject3).field_userName = ???.pWm;
          ((k)localObject3).field_brandUserName = paramq;
          ((k)localObject3).field_UserVersion = ???.ver;
          ((k)localObject3).field_headImageUrl = ???.KTm;
          ((k)localObject3).field_profileUrl = ???.gTH;
          ((k)localObject3).field_bitFlag = ???.KTn;
          ((k)localObject3).field_needToUpdate = false;
          ((k)localObject3).field_addMemberUrl = ???.KTr;
          if (!((l)localObject2).b((k)localObject3)) {
            ((l)localObject2).a((k)localObject3);
          }
          ((l)localObject2).iPG.put(paramq, ((k)localObject3).field_userId);
          break;
          ((f)localObject3).field_userId = ???.KTu;
          ag.bam().b((f)localObject3);
          Log.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
        }
        ??? = (o)paramq;
        paramq = ???.baD();
        localObject1 = ???.baE();
        paramInt1 = 0;
        if ((paramq == null) || (paramq.KTz == null) || (paramq.KTz.ret != 0))
        {
          if ((paramq != null) && (paramq.KTz != null))
          {
            Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramq.KTz.ret) });
            paramInt1 = -1;
          }
        }
        else
        {
          if (paramInt1 < 0) {
            break label3709;
          }
          if (!a(paramq.Lpw, ((aeb)localObject1).KTt, true)) {
            break label1950;
          }
          paramInt1 = 0;
        }
        label2162:
        label3699:
        label3704:
        label3709:
        for (;;)
        {
          paramq = (com.tencent.mm.al.p)???.data;
          if (paramq != null) {
            paramq.a(paramInt1, ???);
          }
          AppMethodBeat.o(124257);
          return;
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1884;
          paramInt1 = -1;
          continue;
          ??? = (u)paramq;
          paramq = ???.baF();
          paramInt1 = 0;
          if ((paramq == null) || (paramq.KTz == null) || (paramq.KTz.ret != 0))
          {
            if ((paramq != null) && (paramq.KTz != null))
            {
              Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramq.KTz.ret) });
              paramInt1 = -1;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            if (paramInt1 >= 0)
            {
              paramInt2 = paramInt1;
              if (paramq.Lpl == null)
              {
                paramInt2 = paramInt1;
                if (paramq.Lpk == null) {
                  paramInt2 = -1;
                }
              }
            }
            if (paramInt2 < 0) {
              break label3704;
            }
            if (paramq.Lpl == null) {
              break label2162;
            }
            bool2 = a(paramq.Lpl, paramq.KTt);
            bool1 = bool2;
            if (bool2)
            {
              ???.iQz = paramq.Lpl.KTu;
              bool1 = bool2;
            }
            if (bool1) {
              break label3704;
            }
          }
          for (paramInt1 = -1;; paramInt1 = paramInt2)
          {
            paramq = (com.tencent.mm.al.p)???.data;
            if (paramq != null) {
              paramq.a(paramInt1, ???);
            }
            AppMethodBeat.o(124257);
            return;
            Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label2032;
            bool2 = a(paramq.Lpk, paramq.KTt, true);
            bool1 = bool2;
            if (!bool2) {
              break label2114;
            }
            ???.iQz = paramq.Lpk.LPp.KTl;
            bool1 = bool2;
            break label2114;
            ??? = (n)paramq;
            paramq = ???.baC();
            paramInt1 = 0;
            if ((paramq == null) || (paramq.KTz == null) || (paramq.KTz.ret != 0))
            {
              if ((paramq != null) && (paramq.KTz != null))
              {
                Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramq.KTz.ret) });
                paramInt1 = -1;
              }
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 >= 0)
              {
                paramInt2 = paramInt1;
                if (paramq.Lpl == null)
                {
                  paramInt2 = paramInt1;
                  if (paramq.Lpk == null) {
                    paramInt2 = -1;
                  }
                }
              }
              if (paramInt2 < 0) {
                break label3699;
              }
              if (paramq.Lpl == null) {
                break label2416;
              }
              bool2 = a(paramq.Lpl, paramq.KTt);
              bool1 = bool2;
              if (bool2)
              {
                ???.iQz = paramq.Lpl.KTu;
                bool1 = bool2;
              }
              if (bool1) {
                break label3699;
              }
            }
            for (paramInt1 = -1;; paramInt1 = paramInt2)
            {
              paramq = (com.tencent.mm.al.p)???.data;
              if (paramq != null) {
                paramq.a(paramInt1, ???);
              }
              AppMethodBeat.o(124257);
              return;
              Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label2286;
              bool2 = a(paramq.Lpk, paramq.KTt, true);
              bool1 = bool2;
              if (!bool2) {
                break label2368;
              }
              ???.iQz = paramq.Lpk.LPp.KTl;
              bool1 = bool2;
              break label2368;
              Log.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
              localObject1 = (y)paramq;
              if ((((y)localObject1).rr != null) && (((y)localObject1).rr.iLL.iLR != null))
              {
                ??? = (elq)((y)localObject1).rr.iLL.iLR;
                if ((((y)localObject1).rr == null) || (((y)localObject1).rr.iLK.iLR == null)) {
                  break label2622;
                }
                paramq = (elp)((y)localObject1).rr.iLK.iLR;
              }
              for (;;)
              {
                if ((??? == null) || (???.KTz == null) || (???.KTz.ret != 0))
                {
                  if ((??? != null) && (???.KTz != null))
                  {
                    Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.KTz.ret) });
                    AppMethodBeat.o(124257);
                    return;
                    ??? = null;
                    break;
                    paramq = null;
                    continue;
                  }
                  Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                  AppMethodBeat.o(124257);
                  return;
                }
              }
              if (a(???.Lpw, paramq.KTt, false)) {}
              for (paramInt1 = 0;; paramInt1 = -1)
              {
                ??? = (com.tencent.mm.al.p)((y)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.ak.q)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
              }
              localObject1 = (x)paramq;
              if ((((x)localObject1).rr != null) && (((x)localObject1).rr.iLL.iLR != null))
              {
                ??? = (els)((x)localObject1).rr.iLL.iLR;
                if ((((x)localObject1).rr == null) || (((x)localObject1).rr.iLK.iLR == null)) {
                  break label3114;
                }
                paramq = (elr)((x)localObject1).rr.iLK.iLR;
                paramInt1 = 0;
                if ((??? == null) || (???.KTz == null) || (???.KTz.ret != 0) || (???.LPp == null))
                {
                  if ((??? == null) || (???.KTz == null)) {
                    break label3120;
                  }
                  Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.KTz.ret) });
                  paramInt1 = -1;
                }
                if (paramInt1 < 0) {
                  break label3696;
                }
                localObject2 = ag.baj().NE(???.LPp.KTl);
                if (localObject2 == null)
                {
                  if (localObject2 != null) {
                    break label3131;
                  }
                  bool1 = true;
                  if (???.LPp != null) {
                    break label3137;
                  }
                  bool2 = true;
                  Log.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null:%s, resp.chat == null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  paramInt1 = -1;
                }
                if ((paramInt1 < 0) || (((((c)localObject2).field_bitFlag == ???.LPp.KTn) || (!((c)localObject2).bay())) && (???.LPp.ver <= ((c)localObject2).field_chatVersion))) {
                  break label3143;
                }
                ((c)localObject2).field_chatType = ???.LPp.type;
                ((c)localObject2).field_headImageUrl = ???.LPp.KTm;
                ((c)localObject2).field_chatName = ???.LPp.name;
                ((c)localObject2).field_chatVersion = ???.LPp.ver;
                ((c)localObject2).field_needToUpdate = false;
                ((c)localObject2).field_bitFlag = ???.LPp.KTn;
                ((c)localObject2).field_maxMemberCnt = ???.LPp.KTp;
                ((c)localObject2).field_ownerUserId = ???.LPp.KTq;
                ((c)localObject2).field_addMemberUrl = ???.LPp.KTr;
                ((c)localObject2).field_brandUserName = paramq.KTt;
                ag.baj().b((c)localObject2);
              }
              for (;;)
              {
                ??? = (com.tencent.mm.al.p)((x)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.ak.q)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
                ??? = null;
                break label2739;
                paramq = null;
                break label2777;
                Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                break label2843;
                bool1 = false;
                break label2877;
                bool2 = false;
                break label2887;
                paramInt1 = -1;
                continue;
                AppMethodBeat.o(124257);
                return;
                paramq = (t)paramq;
                if ((paramq.rr != null) && (paramq.rr.iLL.iLR != null))
                {
                  ??? = (bnl)paramq.rr.iLL.iLR;
                  if ((paramq.rr == null) || (paramq.rr.iLK.iLR == null)) {
                    break label3306;
                  }
                  paramq = (bnk)paramq.rr.iLK.iLR;
                }
                for (;;)
                {
                  if ((??? == null) || (???.KTz == null) || (???.KTz.ret != 0))
                  {
                    if ((??? != null) && (???.KTz != null))
                    {
                      Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.KTz.ret) });
                      AppMethodBeat.o(124257);
                      return;
                      ??? = null;
                      break;
                      paramq = null;
                      continue;
                    }
                    Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.o(124257);
                    return;
                  }
                }
                localObject2 = ???.LVY;
                localObject3 = ag.baj();
                localObject4 = paramq.KTt;
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
                    localObject4 = ag.baj().NE((String)localObject4);
                    if (localObject4 != null)
                    {
                      ((c)localObject4).field_bitFlag &= 0xFFFFFFF7;
                      ag.baj().b((c)localObject4);
                    }
                  }
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  if (!((List)localObject1).contains(localObject3))
                  {
                    localObject4 = ag.baj().NE((String)localObject3);
                    if (localObject4 == null)
                    {
                      localObject4 = new c();
                      ((c)localObject4).field_bizChatServId = ((String)localObject3);
                      ((c)localObject4).field_brandUserName = paramq.KTt;
                      ((c)localObject4).field_bitFlag |= 0x8;
                      ag.baj().a((c)localObject4);
                    }
                    else
                    {
                      ((c)localObject4).field_bitFlag |= 0x8;
                      ag.baj().b((c)localObject4);
                    }
                  }
                }
                b(???.LVY, paramq.KTt);
                break;
              }
            }
          }
        }
      }
    }
  }
  
  public static class a
  {
    private String dUd;
    private String id;
    
    public a(String paramString1, String paramString2)
    {
      this.dUd = paramString1;
      this.id = paramString2;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(124253);
      if (paramObject.getClass() != a.class)
      {
        AppMethodBeat.o(124253);
        return false;
      }
      paramObject = (a)paramObject;
      if (((this.dUd == null) && (paramObject.dUd == null)) || ((this.dUd != null) && (this.dUd.equals(paramObject.dUd)) && (((this.id == null) && (paramObject.id == null)) || ((this.id != null) && (this.id.equals(paramObject.id))))))
      {
        AppMethodBeat.o(124253);
        return true;
      }
      AppMethodBeat.o(124253);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(124254);
      int i = this.dUd.hashCode();
      int j = this.id.hashCode();
      AppMethodBeat.o(124254);
      return i + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.a.h
 * JD-Core Version:    0.7.0.1
 */