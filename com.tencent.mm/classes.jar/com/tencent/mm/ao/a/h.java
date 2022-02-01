package com.tencent.mm.ao.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.ao.af;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.protocal.protobuf.bqw;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.evv;
import com.tencent.mm.protocal.protobuf.evw;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.protocal.protobuf.evy;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.qo;
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
  private final Object lGA;
  private com.tencent.mm.b.f<String, Long> lGB;
  private HashSet<a> lGu;
  private HashSet<a> lGv;
  private final Object lGw;
  private com.tencent.mm.b.f<String, Long> lGx;
  private HashSet<a> lGy;
  private HashSet<a> lGz;
  
  public h()
  {
    AppMethodBeat.i(124255);
    this.lGu = new HashSet();
    this.lGv = new HashSet();
    this.lGw = new Object();
    this.lGx = new com.tencent.mm.b.h(64);
    this.lGy = new HashSet();
    this.lGz = new HashSet();
    this.lGA = new Object();
    this.lGB = new com.tencent.mm.b.h(64);
    com.tencent.mm.kernel.h.aHF().kcd.a(1352, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1365, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1353, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1354, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1357, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1356, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1355, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1358, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1367, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1361, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1389, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1315, this);
    AppMethodBeat.o(124255);
  }
  
  public static void Vl(String paramString)
  {
    AppMethodBeat.i(206848);
    paramString = new t(paramString);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(206848);
  }
  
  public static n a(String paramString1, String paramString2, String paramString3, com.tencent.mm.ao.p paramp)
  {
    AppMethodBeat.i(206847);
    paramString1 = new n(paramString1, paramString2, paramString3, paramp);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    AppMethodBeat.o(206847);
    return paramString1;
  }
  
  public static o a(String paramString, bms parambms, com.tencent.mm.ao.p paramp)
  {
    AppMethodBeat.i(124270);
    paramString = new o(paramString, parambms, paramp);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(124270);
    return paramString;
  }
  
  public static u a(String paramString1, String paramString2, LinkedList<String> paramLinkedList, com.tencent.mm.ao.p paramp)
  {
    AppMethodBeat.i(206845);
    paramString1 = new u(paramString1, paramString2, paramLinkedList, paramp);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    AppMethodBeat.o(206845);
    return paramString1;
  }
  
  public static x a(String paramString, nj paramnj, com.tencent.mm.ao.p paramp)
  {
    AppMethodBeat.i(124272);
    paramString = new x(paramString, paramnj, paramp);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(124272);
    return paramString;
  }
  
  public static y a(String paramString1, String paramString2, nm paramnm1, nm paramnm2, com.tencent.mm.ao.p paramp)
  {
    AppMethodBeat.i(124271);
    paramString1 = new y(paramString1, paramString2, paramnm1, paramnm2, paramp);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    AppMethodBeat.o(124271);
    return paramString1;
  }
  
  public static void a(String paramString, com.tencent.mm.ao.p paramp)
  {
    AppMethodBeat.i(124269);
    paramString = new r(paramString, paramp);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(124269);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.ao.p paramp)
  {
    AppMethodBeat.i(124268);
    if (paramp == null)
    {
      AppMethodBeat.o(124268);
      return;
    }
    Object localObject = e.Vf(paramString2);
    if ((localObject == null) || (((k)localObject).field_userId.equals(paramString1)))
    {
      a(paramString2, paramp);
      AppMethodBeat.o(124268);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString1);
    paramString1 = new qo();
    paramString1.RUp = paramString2;
    paramString1.RYT = ((LinkedList)localObject);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = new s(paramString2, paramp);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    AppMethodBeat.o(124268);
  }
  
  private static boolean a(bms parambms, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124275);
    Log.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
    if ((parambms == null) || (parambms.SXD == null) || (Util.isNullOrNil(paramString)))
    {
      Log.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
      AppMethodBeat.o(124275);
      return false;
    }
    Object localObject1 = af.bjx().Va(parambms.SXD.RUi);
    int i;
    if (localObject1 == null)
    {
      Log.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
      localObject1 = new c();
      ((c)localObject1).field_bizChatServId = parambms.SXD.RUi;
      ((c)localObject1).field_brandUserName = paramString;
      i = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (parambms.RUr == null)
      {
        Log.w("MicroMsg.BizChatNetworkMgr", "members==null");
        AppMethodBeat.o(124275);
        return false;
      }
      Object localObject2;
      if ((((c)localObject1).bjN()) || (parambms.SXD.ver > ((c)localObject1).field_chatVersion))
      {
        ((c)localObject1).field_chatType = parambms.SXD.type;
        ((c)localObject1).field_headImageUrl = parambms.SXD.RUj;
        ((c)localObject1).field_chatName = parambms.SXD.name;
        ((c)localObject1).field_chatVersion = parambms.SXD.ver;
        ((c)localObject1).field_needToUpdate = false;
        ((c)localObject1).field_bitFlag = parambms.SXD.RUk;
        ((c)localObject1).field_maxMemberCnt = parambms.SXD.RUl;
        ((c)localObject1).field_ownerUserId = parambms.SXD.RUm;
        ((c)localObject1).field_addMemberUrl = parambms.SXD.RUn;
        ((c)localObject1).field_brandUserName = paramString;
        ((c)localObject1).field_roomflag = parambms.SXD.RUo;
        paramString = new LinkedList();
        localObject2 = parambms.RUr.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add(((nl)((Iterator)localObject2).next()).RUq);
        }
        ((c)localObject1).field_userList = Util.listToString(paramString, ";");
        if (i == 0) {
          break label442;
        }
        af.bjx().a((c)localObject1);
      }
      long l;
      for (;;)
      {
        e.h((c)localObject1);
        if (!paramBoolean) {
          break label511;
        }
        paramString = new qo();
        paramString.RUp = ((c)localObject1).field_brandUserName;
        localObject1 = new LinkedList();
        parambms = parambms.RUr.iterator();
        while (parambms.hasNext())
        {
          localObject2 = (nl)parambms.next();
          l = af.bjz().Vm(((nl)localObject2).RUq);
          if (((nl)localObject2).ver > l) {
            ((LinkedList)localObject1).add(((nl)localObject2).RUq);
          }
        }
        label442:
        af.bjx().b((c)localObject1);
      }
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString.RYT = ((LinkedList)localObject1);
        parambms = new LinkedList();
        parambms.add(paramString);
        parambms = new s(parambms, null);
        com.tencent.mm.kernel.h.aHF().kcd.a(parambms, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(124275);
        return true;
        label511:
        paramString = af.bjz().db;
        l = 0L;
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)paramString).beginTransaction(Thread.currentThread().getId());
        }
        parambms = parambms.RUr.iterator();
        while (parambms.hasNext())
        {
          localObject2 = (nl)parambms.next();
          k localk = af.bjz().gm(((nl)localObject2).RUq);
          if (localk == null)
          {
            localk = new k();
            localk.field_userId = ((nl)localObject2).RUq;
            localk.field_userName = ((nl)localObject2).tsk;
            localk.field_brandUserName = ((c)localObject1).field_brandUserName;
            localk.field_needToUpdate = true;
            af.bjz().a(localk);
          }
          else if (((nl)localObject2).ver > localk.field_UserVersion)
          {
            localk.field_needToUpdate = true;
            af.bjz().b(localk);
          }
        }
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l);
        }
      }
      i = 0;
    }
  }
  
  private static boolean a(nq paramnq, String paramString)
  {
    AppMethodBeat.i(124274);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramnq.RUq)))
    {
      AppMethodBeat.o(124274);
      return false;
    }
    k localk = new k();
    localk.field_userId = paramnq.RUq;
    localk.field_userName = paramnq.tsk;
    localk.field_brandUserName = paramString;
    localk.field_headImageUrl = paramnq.RUj;
    localk.field_profileUrl = paramnq.jEj;
    localk.field_UserVersion = paramnq.ver;
    localk.field_addMemberUrl = paramnq.RUn;
    if (!af.bjz().b(localk)) {
      af.bjz().a(localk);
    }
    paramnq = new c();
    paramnq.field_bizChatServId = localk.field_userId;
    paramnq.field_brandUserName = localk.field_brandUserName;
    paramnq.field_chatName = localk.field_userName;
    paramnq.field_chatType = j.lGD.lGG;
    if (e.e(paramnq) == null)
    {
      AppMethodBeat.o(124274);
      return false;
    }
    AppMethodBeat.o(124274);
    return true;
  }
  
  private void bjP()
  {
    AppMethodBeat.i(124262);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.lGw)
    {
      if (!this.lGv.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      if (this.lGu.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      Iterator localIterator = this.lGu.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        nk localnk = new nk();
        localnk.RUp = a.a(locala);
        localnk.RUi = a.b(locala);
        localLinkedList1.add(localnk);
      }
    }
    if (localLinkedList2.isEmpty())
    {
      AppMethodBeat.o(124262);
      return;
    }
    this.lGv.addAll(this.lGu);
    this.lGu.clear();
    ??? = new q(localLinkedList2);
    com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)???, 0);
    AppMethodBeat.o(124262);
  }
  
  private void bjQ()
  {
    AppMethodBeat.i(124266);
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    synchronized (this.lGA)
    {
      if (!this.lGz.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      if (this.lGy.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      localHashMap = new HashMap();
      localObject6 = this.lGy.iterator();
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
        localObject7 = new qo();
        ((qo)localObject7).RUp = ((String)localObject4);
        ((qo)localObject7).RYT = ((LinkedList)localObject6);
        localLinkedList.add(localObject7);
      }
    }
    this.lGz.addAll(this.lGy);
    this.lGy.clear();
    localObject3 = new s(localLinkedList, null);
    com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject3, 0);
    AppMethodBeat.o(124266);
  }
  
  private void bo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124260);
    long l = System.currentTimeMillis();
    synchronized (this.lGw)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.lGv.contains(paramString2))
      {
        AppMethodBeat.o(124260);
        return;
      }
      this.lGu.add(paramString2);
      this.lGx.put(paramString1, new Long(l));
      bjP();
      AppMethodBeat.o(124260);
      return;
    }
  }
  
  public static void br(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124267);
    paramString1 = new p(paramString1, paramString2);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    AppMethodBeat.o(124267);
  }
  
  public static void d(com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(124258);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramq);
    AppMethodBeat.o(124258);
  }
  
  public static void l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124273);
    paramString1 = new w(paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    AppMethodBeat.o(124273);
  }
  
  public final void b(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124261);
    long l = System.currentTimeMillis();
    synchronized (this.lGw)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (!this.lGv.contains(locala))
        {
          this.lGu.add(locala);
          this.lGx.put(str, new Long(l));
        }
      }
    }
    bjP();
    AppMethodBeat.o(124261);
  }
  
  public final void bn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124259);
    Long localLong = (Long)this.lGx.aX(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bo(paramString1, paramString2);
    }
    AppMethodBeat.o(124259);
  }
  
  public final void bp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124263);
    Long localLong = (Long)this.lGB.aX(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bq(paramString1, paramString2);
    }
    AppMethodBeat.o(124263);
  }
  
  public final void bq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124264);
    long l = System.currentTimeMillis();
    synchronized (this.lGA)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.lGz.contains(paramString2))
      {
        AppMethodBeat.o(124264);
        return;
      }
      this.lGy.add(paramString2);
      this.lGB.put(paramString1, new Long(l));
      bjQ();
      AppMethodBeat.o(124264);
      return;
    }
  }
  
  public final void c(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124265);
    long l = System.currentTimeMillis();
    synchronized (this.lGA)
    {
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (this.lGz.contains(locala))
        {
          AppMethodBeat.o(124265);
          return;
        }
        this.lGy.add(locala);
        this.lGB.put(str, new Long(l));
      }
    }
    bjQ();
    AppMethodBeat.o(124265);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(124256);
    com.tencent.mm.kernel.h.aHF().kcd.b(1352, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1365, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1353, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1354, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1357, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1356, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1355, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1358, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1367, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1361, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1389, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1315, this);
    super.finalize();
    AppMethodBeat.o(124256);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.an.q paramq)
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
      if ((((p)localObject1).rr != null) && (d.c.b(((p)localObject1).rr.lBS) != null))
      {
        ??? = (bqv)d.c.b(((p)localObject1).rr.lBS);
        if ((((p)localObject1).rr == null) || (d.b.b(((p)localObject1).rr.lBR) == null)) {
          break label321;
        }
      }
      for (paramq = (bqu)d.b.b(((p)localObject1).rr.lBR);; paramq = null)
      {
        bool1 = ((p)localObject1).lGQ;
        if ((??? != null) && (???.RUv != null) && (???.RUv.ret == 0)) {
          break label342;
        }
        if ((??? == null) || (???.RUv == null)) {
          break label327;
        }
        Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.RUv.ret) });
        AppMethodBeat.o(124257);
        return;
        ??? = null;
        break;
      }
      Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(124257);
      return;
      a(???.SqS, paramq.RUp, bool1);
      AppMethodBeat.o(124257);
      return;
    case 1365: 
      synchronized (this.lGw)
      {
        this.lGv.clear();
        bjP();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      paramq = (q)paramq;
      if ((paramq.rr != null) && (d.c.b(paramq.rr.lBS) != null)) {
        ??? = (bqt)d.c.b(paramq.rr.lBS);
      }
      while ((??? == null) || (???.RUv == null) || (???.RUv.ret != 0)) {
        if ((??? != null) && (???.RUv != null))
        {
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.RUv.ret) });
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
      ??? = ???.TbS;
      if ((??? == null) || (???.size() == 0))
      {
        Log.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
        AppMethodBeat.o(124257);
        return;
      }
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bms)((Iterator)localObject1).next();
        ??? = ((bms)localObject2).SXD.RUi;
        if ((??? == null) || (paramq.lGR == null)) {}
        for (??? = null;; ??? = (String)paramq.lGR.get(???))
        {
          a((bms)localObject2, ???, false);
          break;
        }
      }
      AppMethodBeat.o(124257);
      return;
    case 1353: 
      localObject1 = (s)paramq;
      localObject2 = (com.tencent.mm.ao.p)((s)localObject1).bnW;
      if (localObject2 == null) {}
      synchronized (this.lGA)
      {
        this.lGz.clear();
        bjQ();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      if ((((s)localObject1).rr != null) && (d.c.b(((s)localObject1).rr.lBS) != null))
      {
        ??? = (bqz)d.c.b(((s)localObject1).rr.lBS);
        paramInt1 = 0;
        if ((??? == null) || (???.RUv == null) || (???.RUv.ret != 0))
        {
          if ((??? == null) || (???.RUv == null)) {
            break label1218;
          }
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.RUv.ret) });
          label824:
          paramInt1 = -1;
        }
        if ((paramInt1 < 0) || (???.RUw != null)) {
          break label3779;
        }
        Log.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
        paramInt1 = -1;
      }
      break;
    }
    label1159:
    label1218:
    label3779:
    for (;;)
    {
      Object localObject3;
      label888:
      Object localObject4;
      label998:
      label1136:
      boolean bool2;
      if (paramInt1 >= 0)
      {
        localObject3 = af.bjz().db;
        long l = 0L;
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)localObject3).beginTransaction(Thread.currentThread().getId());
        }
        paramInt2 = 0;
        if (paramInt2 < ???.RUw.size())
        {
          Log.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[] { ((nq)???.RUw.get(paramInt2)).tsk });
          localObject4 = new k();
          ((k)localObject4).field_userId = ((nq)???.RUw.get(paramInt2)).RUq;
          ((k)localObject4).field_userName = ((nq)???.RUw.get(paramInt2)).tsk;
          paramq = ((k)localObject4).field_userId;
          if ((paramq == null) || (((s)localObject1).lGS == null))
          {
            paramq = null;
            ((k)localObject4).field_brandUserName = paramq;
            ((k)localObject4).field_UserVersion = ((nq)???.RUw.get(paramInt2)).ver;
            ((k)localObject4).field_headImageUrl = ((nq)???.RUw.get(paramInt2)).RUj;
            ((k)localObject4).field_profileUrl = ((nq)???.RUw.get(paramInt2)).jEj;
            ((k)localObject4).field_bitFlag = ((nq)???.RUw.get(paramInt2)).RUk;
            ((k)localObject4).field_addMemberUrl = ((nq)???.RUw.get(paramInt2)).RUn;
            ((k)localObject4).field_needToUpdate = false;
            paramq = af.bjz().gm(((nq)???.RUw.get(paramInt2)).RUq);
            if (paramq != null) {
              break label1249;
            }
            bool1 = false;
            bool2 = ((k)localObject4).jQ(16);
            if (paramq != null) {
              break label1261;
            }
            af.bjz().a((k)localObject4);
            if (bool1 != bool2)
            {
              paramq = af.bjx().Va(((k)localObject4).field_userId);
              if (paramq != null)
              {
                if ((!bool1) || (bool2)) {
                  break label1273;
                }
                af.bjy().Gy(paramq.field_bizChatLocalId);
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
            paramq = (String)((s)localObject1).lGS.get(paramq);
            break label998;
            label1249:
            bool1 = paramq.jQ(16);
            break label1136;
            label1261:
            af.bjz().b((k)localObject4);
            break label1159;
            label1273:
            if ((!bool1) && (bool2)) {
              af.bjy().Gx(paramq.field_bizChatLocalId);
            }
          }
        }
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l);
        }
      }
      if (localObject2 != null) {
        ((com.tencent.mm.ao.p)localObject2).a(paramInt1, (com.tencent.mm.an.q)localObject1);
      }
      AppMethodBeat.o(124257);
      return;
      localObject1 = (r)paramq;
      if ((((r)localObject1).rr != null) && (d.c.b(((r)localObject1).rr.lBS) != null))
      {
        ??? = (bqx)d.c.b(((r)localObject1).rr.lBS);
        label1384:
        if (((r)localObject1).rr != null) {
          break label1530;
        }
        paramq = null;
        label1395:
        if ((??? != null) && (???.RUv != null) && (???.RUv.ret == 0)) {
          break label3774;
        }
        if ((??? == null) || (???.RUv == null)) {
          break label1549;
        }
        Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.RUv.ret) });
      }
      for (paramInt1 = -1;; paramInt1 = 0)
      {
        if (paramInt1 >= 0)
        {
          localObject2 = af.bjz();
          paramq = paramq.RUp;
          ??? = ???.RUs;
          if ((??? == null) || (Util.isNullOrNil(paramq))) {
            Log.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
          }
        }
        else
        {
          ??? = (com.tencent.mm.ao.p)((r)localObject1).bnW;
          if (??? != null) {
            ???.a(paramInt1, (com.tencent.mm.an.q)localObject1);
          }
          AppMethodBeat.o(124257);
          return;
          ??? = null;
          break label1384;
          label1530:
          paramq = (bqw)d.b.b(((r)localObject1).rr.lBR);
          break label1395;
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1452;
        }
        Log.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[] { paramq, ???.RUq, Boolean.valueOf(Util.isNullOrNil(???.RUn)) });
        localObject3 = af.bjA().Vk(paramq);
        if (localObject3 == null)
        {
          localObject3 = new f();
          ((f)localObject3).field_brandUserName = paramq;
          ((f)localObject3).field_userId = ???.RUq;
          af.bjA().a((f)localObject3);
        }
        for (;;)
        {
          localObject3 = new k();
          ((k)localObject3).field_userId = ???.RUq;
          ((k)localObject3).field_userName = ???.tsk;
          ((k)localObject3).field_brandUserName = paramq;
          ((k)localObject3).field_UserVersion = ???.ver;
          ((k)localObject3).field_headImageUrl = ???.RUj;
          ((k)localObject3).field_profileUrl = ???.jEj;
          ((k)localObject3).field_bitFlag = ???.RUk;
          ((k)localObject3).field_needToUpdate = false;
          ((k)localObject3).field_addMemberUrl = ???.RUn;
          if (!((l)localObject2).b((k)localObject3)) {
            ((l)localObject2).a((k)localObject3);
          }
          ((l)localObject2).lFW.put(paramq, ((k)localObject3).field_userId);
          break;
          ((f)localObject3).field_userId = ???.RUq;
          af.bjA().b((f)localObject3);
          Log.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
        }
        ??? = (o)paramq;
        paramq = ???.bjS();
        localObject1 = ???.bjT();
        paramInt1 = 0;
        if ((paramq == null) || (paramq.RUv == null) || (paramq.RUv.ret != 0))
        {
          if ((paramq != null) && (paramq.RUv != null))
          {
            Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramq.RUv.ret) });
            label1884:
            paramInt1 = -1;
          }
        }
        else
        {
          if (paramInt1 < 0) {
            break label3771;
          }
          if (!a(paramq.SqS, ((aei)localObject1).RUp, true)) {
            break label1950;
          }
          paramInt1 = 0;
        }
        for (;;)
        {
          paramq = (com.tencent.mm.ao.p)???.bnW;
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
          paramq = ???.bjU();
          if ((???.rr != null) && (d.b.b(???.rr.lBR) != null)) {
            d.b.b(???.rr.lBR);
          }
          paramInt1 = 0;
          if ((paramq == null) || (paramq.RUv == null) || (paramq.RUv.ret != 0))
          {
            if ((paramq != null) && (paramq.RUv != null))
            {
              Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramq.RUv.ret) });
              paramInt1 = -1;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            if (paramInt1 >= 0)
            {
              paramInt2 = paramInt1;
              if (paramq.SqH == null)
              {
                paramInt2 = paramInt1;
                if (paramq.SqG == null) {
                  paramInt2 = -1;
                }
              }
            }
            if (paramInt2 < 0) {
              break label3766;
            }
            if (paramq.SqH == null) {
              break label2193;
            }
            bool2 = a(paramq.SqH, paramq.RUp);
            bool1 = bool2;
            if (bool2)
            {
              ???.lGP = paramq.SqH.RUq;
              bool1 = bool2;
            }
            label2145:
            if (bool1) {
              break label3766;
            }
          }
          for (paramInt1 = -1;; paramInt1 = paramInt2)
          {
            paramq = (com.tencent.mm.ao.p)???.bnW;
            if (paramq != null) {
              paramq.a(paramInt1, ???);
            }
            AppMethodBeat.o(124257);
            return;
            Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label2063;
            bool2 = a(paramq.SqG, paramq.RUp, true);
            bool1 = bool2;
            if (!bool2) {
              break label2145;
            }
            ???.lGP = paramq.SqG.SXD.RUi;
            bool1 = bool2;
            break label2145;
            ??? = (n)paramq;
            paramq = ???.bjR();
            if ((???.rr != null) && (d.b.b(???.rr.lBR) != null)) {
              d.b.b(???.rr.lBR);
            }
            paramInt1 = 0;
            if ((paramq == null) || (paramq.RUv == null) || (paramq.RUv.ret != 0))
            {
              if ((paramq != null) && (paramq.RUv != null))
              {
                Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramq.RUv.ret) });
                paramInt1 = -1;
              }
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 >= 0)
              {
                paramInt2 = paramInt1;
                if (paramq.SqH == null)
                {
                  paramInt2 = paramInt1;
                  if (paramq.SqG == null) {
                    paramInt2 = -1;
                  }
                }
              }
              if (paramInt2 < 0) {
                break label3761;
              }
              if (paramq.SqH == null) {
                break label2478;
              }
              bool2 = a(paramq.SqH, paramq.RUp);
              bool1 = bool2;
              if (bool2)
              {
                ???.lGP = paramq.SqH.RUq;
                bool1 = bool2;
              }
              label2430:
              if (bool1) {
                break label3761;
              }
            }
            for (paramInt1 = -1;; paramInt1 = paramInt2)
            {
              paramq = (com.tencent.mm.ao.p)???.bnW;
              if (paramq != null) {
                paramq.a(paramInt1, ???);
              }
              AppMethodBeat.o(124257);
              return;
              Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label2348;
              bool2 = a(paramq.SqG, paramq.RUp, true);
              bool1 = bool2;
              if (!bool2) {
                break label2430;
              }
              ???.lGP = paramq.SqG.SXD.RUi;
              bool1 = bool2;
              break label2430;
              Log.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
              localObject1 = (y)paramq;
              if ((((y)localObject1).rr != null) && (d.c.b(((y)localObject1).rr.lBS) != null))
              {
                ??? = (evw)d.c.b(((y)localObject1).rr.lBS);
                if ((((y)localObject1).rr == null) || (d.b.b(((y)localObject1).rr.lBR) == null)) {
                  break label2684;
                }
                paramq = (evv)d.b.b(((y)localObject1).rr.lBR);
              }
              for (;;)
              {
                if ((??? == null) || (???.RUv == null) || (???.RUv.ret != 0))
                {
                  if ((??? != null) && (???.RUv != null))
                  {
                    Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.RUv.ret) });
                    AppMethodBeat.o(124257);
                    return;
                    ??? = null;
                    break;
                    label2684:
                    paramq = null;
                    continue;
                  }
                  Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                  AppMethodBeat.o(124257);
                  return;
                }
              }
              if (a(???.SqS, paramq.RUp, false)) {}
              for (paramInt1 = 0;; paramInt1 = -1)
              {
                ??? = (com.tencent.mm.ao.p)((y)localObject1).bnW;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.an.q)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
              }
              localObject1 = (x)paramq;
              if ((((x)localObject1).rr != null) && (d.c.b(((x)localObject1).rr.lBS) != null))
              {
                ??? = (evy)d.c.b(((x)localObject1).rr.lBS);
                label2801:
                if ((((x)localObject1).rr == null) || (d.b.b(((x)localObject1).rr.lBR) == null)) {
                  break label3176;
                }
                paramq = (evx)d.b.b(((x)localObject1).rr.lBR);
                paramInt1 = 0;
                if ((??? == null) || (???.RUv == null) || (???.RUv.ret != 0) || (???.SXD == null))
                {
                  if ((??? == null) || (???.RUv == null)) {
                    break label3182;
                  }
                  Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.RUv.ret) });
                  label2905:
                  paramInt1 = -1;
                }
                if (paramInt1 < 0) {
                  break label3758;
                }
                localObject2 = af.bjx().Va(???.SXD.RUi);
                if (localObject2 == null)
                {
                  if (localObject2 != null) {
                    break label3193;
                  }
                  bool1 = true;
                  label2939:
                  if (???.SXD != null) {
                    break label3199;
                  }
                  bool2 = true;
                  Log.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null:%s, resp.chat == null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  paramInt1 = -1;
                }
                if ((paramInt1 < 0) || (((((c)localObject2).field_bitFlag == ???.SXD.RUk) || (!((c)localObject2).bjN())) && (???.SXD.ver <= ((c)localObject2).field_chatVersion))) {
                  break label3205;
                }
                ((c)localObject2).field_chatType = ???.SXD.type;
                ((c)localObject2).field_headImageUrl = ???.SXD.RUj;
                ((c)localObject2).field_chatName = ???.SXD.name;
                ((c)localObject2).field_chatVersion = ???.SXD.ver;
                ((c)localObject2).field_needToUpdate = false;
                ((c)localObject2).field_bitFlag = ???.SXD.RUk;
                ((c)localObject2).field_maxMemberCnt = ???.SXD.RUl;
                ((c)localObject2).field_ownerUserId = ???.SXD.RUm;
                ((c)localObject2).field_addMemberUrl = ???.SXD.RUn;
                ((c)localObject2).field_brandUserName = paramq.RUp;
                af.bjx().b((c)localObject2);
              }
              for (;;)
              {
                ??? = (com.tencent.mm.ao.p)((x)localObject1).bnW;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.an.q)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
                ??? = null;
                break label2801;
                label3176:
                paramq = null;
                break label2839;
                label3182:
                Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                break label2905;
                label3193:
                bool1 = false;
                break label2939;
                label3199:
                bool2 = false;
                break label2949;
                paramInt1 = -1;
                continue;
                AppMethodBeat.o(124257);
                return;
                paramq = (t)paramq;
                if ((paramq.rr != null) && (d.c.b(paramq.rr.lBS) != null))
                {
                  ??? = (bvb)d.c.b(paramq.rr.lBS);
                  if ((paramq.rr == null) || (d.b.b(paramq.rr.lBR) == null)) {
                    break label3368;
                  }
                  paramq = (bva)d.b.b(paramq.rr.lBR);
                }
                for (;;)
                {
                  if ((??? == null) || (???.RUv == null) || (???.RUv.ret != 0))
                  {
                    if ((??? != null) && (???.RUv != null))
                    {
                      Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.RUv.ret) });
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
                localObject2 = ???.Tfg;
                localObject3 = af.bjx();
                localObject4 = paramq.RUp;
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
                    localObject4 = af.bjx().Va((String)localObject4);
                    if (localObject4 != null)
                    {
                      ((c)localObject4).field_bitFlag &= 0xFFFFFFF7;
                      af.bjx().b((c)localObject4);
                    }
                  }
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  if (!((List)localObject1).contains(localObject3))
                  {
                    localObject4 = af.bjx().Va((String)localObject3);
                    if (localObject4 == null)
                    {
                      localObject4 = new c();
                      ((c)localObject4).field_bizChatServId = ((String)localObject3);
                      ((c)localObject4).field_brandUserName = paramq.RUp;
                      ((c)localObject4).field_bitFlag |= 0x8;
                      af.bjx().a((c)localObject4);
                    }
                    else
                    {
                      ((c)localObject4).field_bitFlag |= 0x8;
                      af.bjx().b((c)localObject4);
                    }
                  }
                }
                b(???.Tfg, paramq.RUp);
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
    private String fNF;
    private String id;
    
    public a(String paramString1, String paramString2)
    {
      this.fNF = paramString1;
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
      if (((this.fNF == null) && (paramObject.fNF == null)) || ((this.fNF != null) && (this.fNF.equals(paramObject.fNF)) && (((this.id == null) && (paramObject.id == null)) || ((this.id != null) && (this.id.equals(paramObject.id))))))
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
      int i = this.fNF.hashCode();
      int j = this.id.hashCode();
      AppMethodBeat.o(124254);
      return i + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.a.h
 * JD-Core Version:    0.7.0.1
 */