package com.tencent.mm.am.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.am.ag;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.dqv;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.protocal.protobuf.dqx;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.protocal.protobuf.na;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.ps;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements com.tencent.mm.al.f
{
  private HashSet<a> hRZ;
  private HashSet<a> hSa;
  private final Object hSb;
  private com.tencent.mm.b.f<String, Long> hSc;
  private HashSet<a> hSd;
  private HashSet<a> hSe;
  private final Object hSf;
  private com.tencent.mm.b.f<String, Long> hSg;
  
  public h()
  {
    AppMethodBeat.i(124255);
    this.hRZ = new HashSet();
    this.hSa = new HashSet();
    this.hSb = new Object();
    this.hSc = new com.tencent.mm.b.h(64);
    this.hSd = new HashSet();
    this.hSe = new HashSet();
    this.hSf = new Object();
    this.hSg = new com.tencent.mm.b.h(64);
    com.tencent.mm.kernel.g.ajB().gAO.a(1352, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1365, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1353, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1354, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1357, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1356, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1355, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1358, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1367, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1361, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1389, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1315, this);
    AppMethodBeat.o(124255);
  }
  
  public static o a(String paramString, att paramatt, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(124270);
    paramString = new o(paramString, paramatt, paramp);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    AppMethodBeat.o(124270);
    return paramString;
  }
  
  public static x a(String paramString, mz parammz, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(124272);
    paramString = new x(paramString, parammz, paramp);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    AppMethodBeat.o(124272);
    return paramString;
  }
  
  public static y a(String paramString1, String paramString2, nc paramnc1, nc paramnc2, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(124271);
    paramString1 = new y(paramString1, paramString2, paramnc1, paramnc2, paramp);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString1, 0);
    AppMethodBeat.o(124271);
    return paramString1;
  }
  
  public static void a(String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(124269);
    paramString = new r(paramString, paramp);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    AppMethodBeat.o(124269);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(124268);
    if (paramp == null)
    {
      AppMethodBeat.o(124268);
      return;
    }
    Object localObject = e.Et(paramString2);
    if ((localObject == null) || (((k)localObject).field_userId.equals(paramString1)))
    {
      a(paramString2, paramp);
      AppMethodBeat.o(124268);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString1);
    paramString1 = new ps();
    paramString1.FHb = paramString2;
    paramString1.FKU = ((LinkedList)localObject);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = new s(paramString2, paramp);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString1, 0);
    AppMethodBeat.o(124268);
  }
  
  private static boolean a(att paramatt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124275);
    ad.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
    if ((paramatt == null) || (paramatt.GrN == null) || (bt.isNullOrNil(paramString)))
    {
      ad.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
      AppMethodBeat.o(124275);
      return false;
    }
    Object localObject1 = ag.aGb().Eo(paramatt.GrN.FGU);
    int i;
    if (localObject1 == null)
    {
      ad.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
      localObject1 = new c();
      ((c)localObject1).field_bizChatServId = paramatt.GrN.FGU;
      ((c)localObject1).field_brandUserName = paramString;
      i = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (paramatt.FHd == null)
      {
        ad.w("MicroMsg.BizChatNetworkMgr", "members==null");
        AppMethodBeat.o(124275);
        return false;
      }
      Object localObject2;
      if ((((c)localObject1).aGp()) || (paramatt.GrN.ver > ((c)localObject1).field_chatVersion))
      {
        ((c)localObject1).field_chatType = paramatt.GrN.type;
        ((c)localObject1).field_headImageUrl = paramatt.GrN.FGV;
        ((c)localObject1).field_chatName = paramatt.GrN.name;
        ((c)localObject1).field_chatVersion = paramatt.GrN.ver;
        ((c)localObject1).field_needToUpdate = false;
        ((c)localObject1).field_bitFlag = paramatt.GrN.FGW;
        ((c)localObject1).field_maxMemberCnt = paramatt.GrN.FGX;
        ((c)localObject1).field_ownerUserId = paramatt.GrN.FGY;
        ((c)localObject1).field_addMemberUrl = paramatt.GrN.FGZ;
        ((c)localObject1).field_brandUserName = paramString;
        ((c)localObject1).field_roomflag = paramatt.GrN.FHa;
        paramString = new LinkedList();
        localObject2 = paramatt.FHd.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add(((nb)((Iterator)localObject2).next()).FHc);
        }
        ((c)localObject1).field_userList = bt.m(paramString, ";");
        if (i == 0) {
          break label442;
        }
        ag.aGb().a((c)localObject1);
      }
      long l;
      for (;;)
      {
        e.h((c)localObject1);
        if (!paramBoolean) {
          break label511;
        }
        paramString = new ps();
        paramString.FHb = ((c)localObject1).field_brandUserName;
        localObject1 = new LinkedList();
        paramatt = paramatt.FHd.iterator();
        while (paramatt.hasNext())
        {
          localObject2 = (nb)paramatt.next();
          l = ag.aGd().EA(((nb)localObject2).FHc);
          if (((nb)localObject2).ver > l) {
            ((LinkedList)localObject1).add(((nb)localObject2).FHc);
          }
        }
        label442:
        ag.aGb().b((c)localObject1);
      }
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString.FKU = ((LinkedList)localObject1);
        paramatt = new LinkedList();
        paramatt.add(paramString);
        paramatt = new s(paramatt, null);
        com.tencent.mm.kernel.g.ajB().gAO.a(paramatt, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(124275);
        return true;
        label511:
        paramString = ag.aGd().db;
        l = 0L;
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)paramString).xO(Thread.currentThread().getId());
        }
        paramatt = paramatt.FHd.iterator();
        while (paramatt.hasNext())
        {
          localObject2 = (nb)paramatt.next();
          k localk = ag.aGd().eK(((nb)localObject2).FHc);
          if (localk == null)
          {
            localk = new k();
            localk.field_userId = ((nb)localObject2).FHc;
            localk.field_userName = ((nb)localObject2).oBW;
            localk.field_brandUserName = ((c)localObject1).field_brandUserName;
            localk.field_needToUpdate = true;
            ag.aGd().a(localk);
          }
          else if (((nb)localObject2).ver > localk.field_UserVersion)
          {
            localk.field_needToUpdate = true;
            ag.aGd().b(localk);
          }
        }
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.g.ajC().gBq.sJ(l);
        }
      }
      i = 0;
    }
  }
  
  private static boolean a(ng paramng, String paramString)
  {
    AppMethodBeat.i(124274);
    if ((bt.isNullOrNil(paramString)) || (bt.isNullOrNil(paramng.FHc)))
    {
      AppMethodBeat.o(124274);
      return false;
    }
    k localk = new k();
    localk.field_userId = paramng.FHc;
    localk.field_userName = paramng.oBW;
    localk.field_brandUserName = paramString;
    localk.field_headImageUrl = paramng.FGV;
    localk.field_profileUrl = paramng.FHk;
    localk.field_UserVersion = paramng.ver;
    localk.field_addMemberUrl = paramng.FGZ;
    if (!ag.aGd().b(localk)) {
      ag.aGd().a(localk);
    }
    paramng = new c();
    paramng.field_bizChatServId = localk.field_userId;
    paramng.field_brandUserName = localk.field_brandUserName;
    paramng.field_chatName = localk.field_userName;
    paramng.field_chatType = j.hSi.hSl;
    if (e.e(paramng) == null)
    {
      AppMethodBeat.o(124274);
      return false;
    }
    AppMethodBeat.o(124274);
    return true;
  }
  
  private void aGr()
  {
    AppMethodBeat.i(124262);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.hSb)
    {
      if (!this.hSa.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      if (this.hRZ.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      Iterator localIterator = this.hRZ.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        na localna = new na();
        localna.FHb = a.a(locala);
        localna.FGU = a.b(locala);
        localLinkedList1.add(localna);
      }
    }
    if (localLinkedList2.isEmpty())
    {
      AppMethodBeat.o(124262);
      return;
    }
    this.hSa.addAll(this.hRZ);
    this.hRZ.clear();
    ??? = new q(localLinkedList2);
    com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)???, 0);
    AppMethodBeat.o(124262);
  }
  
  private void aGs()
  {
    AppMethodBeat.i(124266);
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    synchronized (this.hSf)
    {
      if (!this.hSe.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      if (this.hSd.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      localHashMap = new HashMap();
      localObject6 = this.hSd.iterator();
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
        localObject7 = new ps();
        ((ps)localObject7).FHb = ((String)localObject4);
        ((ps)localObject7).FKU = ((LinkedList)localObject6);
        localLinkedList.add(localObject7);
      }
    }
    this.hSe.addAll(this.hSd);
    this.hSd.clear();
    localObject3 = new s(localLinkedList, null);
    com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject3, 0);
    AppMethodBeat.o(124266);
  }
  
  private void bg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124260);
    long l = System.currentTimeMillis();
    synchronized (this.hSb)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.hSa.contains(paramString2))
      {
        AppMethodBeat.o(124260);
        return;
      }
      this.hRZ.add(paramString2);
      this.hSc.put(paramString1, new Long(l));
      aGr();
      AppMethodBeat.o(124260);
      return;
    }
  }
  
  public static void bj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124267);
    paramString1 = new p(paramString1, paramString2);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString1, 0);
    AppMethodBeat.o(124267);
  }
  
  public static void d(com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(124258);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramn);
    AppMethodBeat.o(124258);
  }
  
  public static void l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124273);
    paramString1 = new w(paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString1, 0);
    AppMethodBeat.o(124273);
  }
  
  public final void b(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124261);
    long l = System.currentTimeMillis();
    synchronized (this.hSb)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (!this.hSa.contains(locala))
        {
          this.hRZ.add(locala);
          this.hSc.put(str, new Long(l));
        }
      }
    }
    aGr();
    AppMethodBeat.o(124261);
  }
  
  public final void bf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124259);
    Long localLong = (Long)this.hSc.aL(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bg(paramString1, paramString2);
    }
    AppMethodBeat.o(124259);
  }
  
  public final void bh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124263);
    Long localLong = (Long)this.hSg.aL(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bi(paramString1, paramString2);
    }
    AppMethodBeat.o(124263);
  }
  
  public final void bi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124264);
    long l = System.currentTimeMillis();
    synchronized (this.hSf)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.hSe.contains(paramString2))
      {
        AppMethodBeat.o(124264);
        return;
      }
      this.hSd.add(paramString2);
      this.hSg.put(paramString1, new Long(l));
      aGs();
      AppMethodBeat.o(124264);
      return;
    }
  }
  
  public final void c(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124265);
    long l = System.currentTimeMillis();
    synchronized (this.hSf)
    {
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (this.hSe.contains(locala))
        {
          AppMethodBeat.o(124265);
          return;
        }
        this.hSd.add(locala);
        this.hSg.put(str, new Long(l));
      }
    }
    aGs();
    AppMethodBeat.o(124265);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(124256);
    com.tencent.mm.kernel.g.ajB().gAO.b(1352, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1365, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1353, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1354, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1357, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1356, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1355, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1358, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1367, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1361, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1389, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1315, this);
    super.finalize();
    AppMethodBeat.o(124256);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(124257);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
      if ((paramn.getType() != 1365) && (paramn.getType() != 1353))
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
    switch (paramn.getType())
    {
    default: 
      AppMethodBeat.o(124257);
      return;
    case 1352: 
      localObject1 = (p)paramn;
      if ((((p)localObject1).rr != null) && (((p)localObject1).rr.hNL.hNQ != null))
      {
        ??? = (axm)((p)localObject1).rr.hNL.hNQ;
        if ((((p)localObject1).rr == null) || (((p)localObject1).rr.hNK.hNQ == null)) {
          break label321;
        }
      }
      for (paramn = (axl)((p)localObject1).rr.hNK.hNQ;; paramn = null)
      {
        bool1 = ((p)localObject1).hSv;
        if ((??? != null) && (???.FHh != null) && (???.FHh.ret == 0)) {
          break label342;
        }
        if ((??? == null) || (???.FHh == null)) {
          break label327;
        }
        ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FHh.ret) });
        AppMethodBeat.o(124257);
        return;
        ??? = null;
        break;
      }
      ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(124257);
      return;
      a(???.Gbn, paramn.FHb, bool1);
      AppMethodBeat.o(124257);
      return;
    case 1365: 
      synchronized (this.hSb)
      {
        this.hSa.clear();
        aGr();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      paramn = (q)paramn;
      if ((paramn.rr != null) && (paramn.rr.hNL.hNQ != null)) {
        ??? = (axk)paramn.rr.hNL.hNQ;
      }
      while ((??? == null) || (???.FHh == null) || (???.FHh.ret != 0)) {
        if ((??? != null) && (???.FHh != null))
        {
          ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FHh.ret) });
          AppMethodBeat.o(124257);
          return;
          ??? = null;
        }
        else
        {
          ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          AppMethodBeat.o(124257);
          return;
        }
      }
      ??? = ???.GvC;
      if ((??? == null) || (???.size() == 0))
      {
        ad.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
        AppMethodBeat.o(124257);
        return;
      }
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (att)((Iterator)localObject1).next();
        ??? = ((att)localObject2).GrN.FGU;
        if ((??? == null) || (paramn.hSw == null)) {}
        for (??? = null;; ??? = (String)paramn.hSw.get(???))
        {
          a((att)localObject2, ???, false);
          break;
        }
      }
      AppMethodBeat.o(124257);
      return;
    case 1353: 
      localObject1 = (s)paramn;
      localObject2 = (com.tencent.mm.am.p)((s)localObject1).data;
      if (localObject2 == null) {}
      synchronized (this.hSf)
      {
        this.hSe.clear();
        aGs();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      if ((((s)localObject1).rr != null) && (((s)localObject1).rr.hNL.hNQ != null))
      {
        ??? = (axq)((s)localObject1).rr.hNL.hNQ;
        paramInt1 = 0;
        if ((??? == null) || (???.FHh == null) || (???.FHh.ret != 0))
        {
          if ((??? == null) || (???.FHh == null)) {
            break label1218;
          }
          ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FHh.ret) });
          label824:
          paramInt1 = -1;
        }
        if ((paramInt1 < 0) || (???.FHi != null)) {
          break label3717;
        }
        ad.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
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
        localObject3 = ag.aGd().db;
        long l = 0L;
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)localObject3).xO(Thread.currentThread().getId());
        }
        paramInt2 = 0;
        if (paramInt2 < ???.FHi.size())
        {
          ad.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[] { ((ng)???.FHi.get(paramInt2)).oBW });
          localObject4 = new k();
          ((k)localObject4).field_userId = ((ng)???.FHi.get(paramInt2)).FHc;
          ((k)localObject4).field_userName = ((ng)???.FHi.get(paramInt2)).oBW;
          paramn = ((k)localObject4).field_userId;
          if ((paramn == null) || (((s)localObject1).hSx == null))
          {
            paramn = null;
            ((k)localObject4).field_brandUserName = paramn;
            ((k)localObject4).field_UserVersion = ((ng)???.FHi.get(paramInt2)).ver;
            ((k)localObject4).field_headImageUrl = ((ng)???.FHi.get(paramInt2)).FGV;
            ((k)localObject4).field_profileUrl = ((ng)???.FHi.get(paramInt2)).FHk;
            ((k)localObject4).field_bitFlag = ((ng)???.FHi.get(paramInt2)).FGW;
            ((k)localObject4).field_addMemberUrl = ((ng)???.FHi.get(paramInt2)).FGZ;
            ((k)localObject4).field_needToUpdate = false;
            paramn = ag.aGd().eK(((ng)???.FHi.get(paramInt2)).FHc);
            if (paramn != null) {
              break label1249;
            }
            bool1 = false;
            bool2 = ((k)localObject4).hj(16);
            if (paramn != null) {
              break label1261;
            }
            ag.aGd().a((k)localObject4);
            if (bool1 != bool2)
            {
              paramn = ag.aGb().Eo(((k)localObject4).field_userId);
              if (paramn != null)
              {
                if ((!bool1) || (bool2)) {
                  break label1273;
                }
                ag.aGc().rX(paramn.field_bizChatLocalId);
              }
            }
          }
          for (;;)
          {
            paramInt2 += 1;
            break label888;
            ??? = null;
            break;
            ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label824;
            paramn = (String)((s)localObject1).hSx.get(paramn);
            break label998;
            bool1 = paramn.hj(16);
            break label1136;
            ag.aGd().b((k)localObject4);
            break label1159;
            label1273:
            if ((!bool1) && (bool2)) {
              ag.aGc().rW(paramn.field_bizChatLocalId);
            }
          }
        }
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.g.ajC().gBq.sJ(l);
        }
      }
      if (localObject2 != null) {
        ((com.tencent.mm.am.p)localObject2).a(paramInt1, (com.tencent.mm.al.n)localObject1);
      }
      AppMethodBeat.o(124257);
      return;
      localObject1 = (r)paramn;
      if ((((r)localObject1).rr != null) && (((r)localObject1).rr.hNL.hNQ != null))
      {
        ??? = (axo)((r)localObject1).rr.hNL.hNQ;
        if (((r)localObject1).rr != null) {
          break label1530;
        }
        paramn = null;
        label1395:
        if ((??? != null) && (???.FHh != null) && (???.FHh.ret == 0)) {
          break label3712;
        }
        if ((??? == null) || (???.FHh == null)) {
          break label1549;
        }
        ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FHh.ret) });
      }
      label2032:
      label2416:
      label3696:
      for (paramInt1 = -1;; paramInt1 = 0)
      {
        if (paramInt1 >= 0)
        {
          localObject2 = ag.aGd();
          paramn = paramn.FHb;
          ??? = ???.FHe;
          if ((??? == null) || (bt.isNullOrNil(paramn))) {
            ad.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
          }
        }
        else
        {
          ??? = (com.tencent.mm.am.p)((r)localObject1).data;
          if (??? != null) {
            ???.a(paramInt1, (com.tencent.mm.al.n)localObject1);
          }
          AppMethodBeat.o(124257);
          return;
          ??? = null;
          break label1384;
          label1530:
          paramn = (axn)((r)localObject1).rr.hNK.hNQ;
          break label1395;
          ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1452;
        }
        ad.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[] { paramn, ???.FHc, Boolean.valueOf(bt.isNullOrNil(???.FGZ)) });
        localObject3 = ag.aGe().Ey(paramn);
        if (localObject3 == null)
        {
          localObject3 = new f();
          ((f)localObject3).field_brandUserName = paramn;
          ((f)localObject3).field_userId = ???.FHc;
          ag.aGe().a((f)localObject3);
        }
        for (;;)
        {
          localObject3 = new k();
          ((k)localObject3).field_userId = ???.FHc;
          ((k)localObject3).field_userName = ???.oBW;
          ((k)localObject3).field_brandUserName = paramn;
          ((k)localObject3).field_UserVersion = ???.ver;
          ((k)localObject3).field_headImageUrl = ???.FGV;
          ((k)localObject3).field_profileUrl = ???.FHk;
          ((k)localObject3).field_bitFlag = ???.FGW;
          ((k)localObject3).field_needToUpdate = false;
          ((k)localObject3).field_addMemberUrl = ???.FGZ;
          if (!((l)localObject2).b((k)localObject3)) {
            ((l)localObject2).a((k)localObject3);
          }
          ((l)localObject2).hRB.put(paramn, ((k)localObject3).field_userId);
          break;
          ((f)localObject3).field_userId = ???.FHc;
          ag.aGe().b((f)localObject3);
          ad.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
        }
        ??? = (o)paramn;
        paramn = ???.aGu();
        localObject1 = ???.aGv();
        paramInt1 = 0;
        if ((paramn == null) || (paramn.FHh == null) || (paramn.FHh.ret != 0))
        {
          if ((paramn != null) && (paramn.FHh != null))
          {
            ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.FHh.ret) });
            paramInt1 = -1;
          }
        }
        else
        {
          if (paramInt1 < 0) {
            break label3709;
          }
          if (!a(paramn.Gbn, ((abq)localObject1).FHb, true)) {
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
          paramn = (com.tencent.mm.am.p)???.data;
          if (paramn != null) {
            paramn.a(paramInt1, ???);
          }
          AppMethodBeat.o(124257);
          return;
          ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1884;
          paramInt1 = -1;
          continue;
          ??? = (u)paramn;
          paramn = ???.aGw();
          paramInt1 = 0;
          if ((paramn == null) || (paramn.FHh == null) || (paramn.FHh.ret != 0))
          {
            if ((paramn != null) && (paramn.FHh != null))
            {
              ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.FHh.ret) });
              paramInt1 = -1;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            if (paramInt1 >= 0)
            {
              paramInt2 = paramInt1;
              if (paramn.Gbd == null)
              {
                paramInt2 = paramInt1;
                if (paramn.Gbc == null) {
                  paramInt2 = -1;
                }
              }
            }
            if (paramInt2 < 0) {
              break label3704;
            }
            if (paramn.Gbd == null) {
              break label2162;
            }
            bool2 = a(paramn.Gbd, paramn.FHb);
            bool1 = bool2;
            if (bool2)
            {
              ???.hSu = paramn.Gbd.FHc;
              bool1 = bool2;
            }
            if (bool1) {
              break label3704;
            }
          }
          for (paramInt1 = -1;; paramInt1 = paramInt2)
          {
            paramn = (com.tencent.mm.am.p)???.data;
            if (paramn != null) {
              paramn.a(paramInt1, ???);
            }
            AppMethodBeat.o(124257);
            return;
            ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label2032;
            bool2 = a(paramn.Gbc, paramn.FHb, true);
            bool1 = bool2;
            if (!bool2) {
              break label2114;
            }
            ???.hSu = paramn.Gbc.GrN.FGU;
            bool1 = bool2;
            break label2114;
            ??? = (n)paramn;
            paramn = ???.aGt();
            paramInt1 = 0;
            if ((paramn == null) || (paramn.FHh == null) || (paramn.FHh.ret != 0))
            {
              if ((paramn != null) && (paramn.FHh != null))
              {
                ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.FHh.ret) });
                paramInt1 = -1;
              }
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 >= 0)
              {
                paramInt2 = paramInt1;
                if (paramn.Gbd == null)
                {
                  paramInt2 = paramInt1;
                  if (paramn.Gbc == null) {
                    paramInt2 = -1;
                  }
                }
              }
              if (paramInt2 < 0) {
                break label3699;
              }
              if (paramn.Gbd == null) {
                break label2416;
              }
              bool2 = a(paramn.Gbd, paramn.FHb);
              bool1 = bool2;
              if (bool2)
              {
                ???.hSu = paramn.Gbd.FHc;
                bool1 = bool2;
              }
              if (bool1) {
                break label3699;
              }
            }
            for (paramInt1 = -1;; paramInt1 = paramInt2)
            {
              paramn = (com.tencent.mm.am.p)???.data;
              if (paramn != null) {
                paramn.a(paramInt1, ???);
              }
              AppMethodBeat.o(124257);
              return;
              ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label2286;
              bool2 = a(paramn.Gbc, paramn.FHb, true);
              bool1 = bool2;
              if (!bool2) {
                break label2368;
              }
              ???.hSu = paramn.Gbc.GrN.FGU;
              bool1 = bool2;
              break label2368;
              ad.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
              localObject1 = (y)paramn;
              if ((((y)localObject1).rr != null) && (((y)localObject1).rr.hNL.hNQ != null))
              {
                ??? = (dqv)((y)localObject1).rr.hNL.hNQ;
                if ((((y)localObject1).rr == null) || (((y)localObject1).rr.hNK.hNQ == null)) {
                  break label2622;
                }
                paramn = (dqu)((y)localObject1).rr.hNK.hNQ;
              }
              for (;;)
              {
                if ((??? == null) || (???.FHh == null) || (???.FHh.ret != 0))
                {
                  if ((??? != null) && (???.FHh != null))
                  {
                    ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FHh.ret) });
                    AppMethodBeat.o(124257);
                    return;
                    ??? = null;
                    break;
                    paramn = null;
                    continue;
                  }
                  ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                  AppMethodBeat.o(124257);
                  return;
                }
              }
              if (a(???.Gbn, paramn.FHb, false)) {}
              for (paramInt1 = 0;; paramInt1 = -1)
              {
                ??? = (com.tencent.mm.am.p)((y)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.al.n)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
              }
              localObject1 = (x)paramn;
              if ((((x)localObject1).rr != null) && (((x)localObject1).rr.hNL.hNQ != null))
              {
                ??? = (dqx)((x)localObject1).rr.hNL.hNQ;
                if ((((x)localObject1).rr == null) || (((x)localObject1).rr.hNK.hNQ == null)) {
                  break label3114;
                }
                paramn = (dqw)((x)localObject1).rr.hNK.hNQ;
                paramInt1 = 0;
                if ((??? == null) || (???.FHh == null) || (???.FHh.ret != 0) || (???.GrN == null))
                {
                  if ((??? == null) || (???.FHh == null)) {
                    break label3120;
                  }
                  ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FHh.ret) });
                  paramInt1 = -1;
                }
                if (paramInt1 < 0) {
                  break label3696;
                }
                localObject2 = ag.aGb().Eo(???.GrN.FGU);
                if (localObject2 == null)
                {
                  if (localObject2 != null) {
                    break label3131;
                  }
                  bool1 = true;
                  if (???.GrN != null) {
                    break label3137;
                  }
                  bool2 = true;
                  ad.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null:%s, resp.chat == null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  paramInt1 = -1;
                }
                if ((paramInt1 < 0) || (((((c)localObject2).field_bitFlag == ???.GrN.FGW) || (!((c)localObject2).aGp())) && (???.GrN.ver <= ((c)localObject2).field_chatVersion))) {
                  break label3143;
                }
                ((c)localObject2).field_chatType = ???.GrN.type;
                ((c)localObject2).field_headImageUrl = ???.GrN.FGV;
                ((c)localObject2).field_chatName = ???.GrN.name;
                ((c)localObject2).field_chatVersion = ???.GrN.ver;
                ((c)localObject2).field_needToUpdate = false;
                ((c)localObject2).field_bitFlag = ???.GrN.FGW;
                ((c)localObject2).field_maxMemberCnt = ???.GrN.FGX;
                ((c)localObject2).field_ownerUserId = ???.GrN.FGY;
                ((c)localObject2).field_addMemberUrl = ???.GrN.FGZ;
                ((c)localObject2).field_brandUserName = paramn.FHb;
                ag.aGb().b((c)localObject2);
              }
              for (;;)
              {
                ??? = (com.tencent.mm.am.p)((x)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.al.n)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
                ??? = null;
                break label2739;
                paramn = null;
                break label2777;
                ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                break label2843;
                bool1 = false;
                break label2877;
                bool2 = false;
                break label2887;
                paramInt1 = -1;
                continue;
                AppMethodBeat.o(124257);
                return;
                paramn = (t)paramn;
                if ((paramn.rr != null) && (paramn.rr.hNL.hNQ != null))
                {
                  ??? = (bbj)paramn.rr.hNL.hNQ;
                  if ((paramn.rr == null) || (paramn.rr.hNK.hNQ == null)) {
                    break label3306;
                  }
                  paramn = (bbi)paramn.rr.hNK.hNQ;
                }
                for (;;)
                {
                  if ((??? == null) || (???.FHh == null) || (???.FHh.ret != 0))
                  {
                    if ((??? != null) && (???.FHh != null))
                    {
                      ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FHh.ret) });
                      AppMethodBeat.o(124257);
                      return;
                      ??? = null;
                      break;
                      paramn = null;
                      continue;
                    }
                    ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.o(124257);
                    return;
                  }
                }
                localObject2 = ???.Gyt;
                localObject3 = ag.aGb();
                localObject4 = paramn.FHb;
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
                    localObject4 = ag.aGb().Eo((String)localObject4);
                    if (localObject4 != null)
                    {
                      ((c)localObject4).field_bitFlag &= 0xFFFFFFF7;
                      ag.aGb().b((c)localObject4);
                    }
                  }
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  if (!((List)localObject1).contains(localObject3))
                  {
                    localObject4 = ag.aGb().Eo((String)localObject3);
                    if (localObject4 == null)
                    {
                      localObject4 = new c();
                      ((c)localObject4).field_bizChatServId = ((String)localObject3);
                      ((c)localObject4).field_brandUserName = paramn.FHb;
                      ((c)localObject4).field_bitFlag |= 0x8;
                      ag.aGb().a((c)localObject4);
                    }
                    else
                    {
                      ((c)localObject4).field_bitFlag |= 0x8;
                      ag.aGb().b((c)localObject4);
                    }
                  }
                }
                b(???.Gyt, paramn.FHb);
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
    private String dBi;
    private String id;
    
    public a(String paramString1, String paramString2)
    {
      this.dBi = paramString1;
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
      if (((this.dBi == null) && (paramObject.dBi == null)) || ((this.dBi != null) && (this.dBi.equals(paramObject.dBi)) && (((this.id == null) && (paramObject.id == null)) || ((this.id != null) && (this.id.equals(paramObject.id))))))
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
      int i = this.dBi.hashCode();
      int j = this.id.hashCode();
      AppMethodBeat.o(124254);
      return i + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.h
 * JD-Core Version:    0.7.0.1
 */