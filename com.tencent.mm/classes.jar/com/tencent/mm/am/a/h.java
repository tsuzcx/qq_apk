package com.tencent.mm.am.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.am.af;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.dfq;
import com.tencent.mm.protocal.protobuf.dfr;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.protocal.protobuf.yw;
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
  implements com.tencent.mm.al.g
{
  private HashSet<a> gZf;
  private HashSet<a> gZg;
  private final Object gZh;
  private com.tencent.mm.b.f<String, Long> gZi;
  private HashSet<a> gZj;
  private HashSet<a> gZk;
  private final Object gZl;
  private com.tencent.mm.b.f<String, Long> gZm;
  
  public h()
  {
    AppMethodBeat.i(124255);
    this.gZf = new HashSet();
    this.gZg = new HashSet();
    this.gZh = new Object();
    this.gZi = new com.tencent.mm.b.h(64);
    this.gZj = new HashSet();
    this.gZk = new HashSet();
    this.gZl = new Object();
    this.gZm = new com.tencent.mm.b.h(64);
    com.tencent.mm.kernel.g.afA().gcy.a(1352, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1365, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1353, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1354, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1357, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1356, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1355, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1358, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1367, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1361, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1389, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1315, this);
    AppMethodBeat.o(124255);
  }
  
  public static o a(String paramString, amv paramamv, com.tencent.mm.am.o paramo)
  {
    AppMethodBeat.i(124270);
    paramString = new o(paramString, paramamv, paramo);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    AppMethodBeat.o(124270);
    return paramString;
  }
  
  public static x a(String paramString, md parammd, com.tencent.mm.am.o paramo)
  {
    AppMethodBeat.i(124272);
    paramString = new x(paramString, parammd, paramo);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    AppMethodBeat.o(124272);
    return paramString;
  }
  
  public static y a(String paramString1, String paramString2, mg parammg1, mg parammg2, com.tencent.mm.am.o paramo)
  {
    AppMethodBeat.i(124271);
    paramString1 = new y(paramString1, paramString2, parammg1, parammg2, paramo);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    AppMethodBeat.o(124271);
    return paramString1;
  }
  
  public static void a(String paramString, com.tencent.mm.am.o paramo)
  {
    AppMethodBeat.i(124269);
    paramString = new r(paramString, paramo);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    AppMethodBeat.o(124269);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.am.o paramo)
  {
    AppMethodBeat.i(124268);
    if (paramo == null)
    {
      AppMethodBeat.o(124268);
      return;
    }
    Object localObject = e.xo(paramString2);
    if ((localObject == null) || (((k)localObject).field_userId.equals(paramString1)))
    {
      a(paramString2, paramo);
      AppMethodBeat.o(124268);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString1);
    paramString1 = new og();
    paramString1.CIQ = paramString2;
    paramString1.CLT = ((LinkedList)localObject);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = new s(paramString2, paramo);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    AppMethodBeat.o(124268);
  }
  
  private static boolean a(amv paramamv, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124275);
    ad.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
    if ((paramamv == null) || (paramamv.DnW == null) || (bt.isNullOrNil(paramString)))
    {
      ad.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
      AppMethodBeat.o(124275);
      return false;
    }
    Object localObject1 = af.awg().xj(paramamv.DnW.CIJ);
    int i;
    if (localObject1 == null)
    {
      ad.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
      localObject1 = new c();
      ((c)localObject1).field_bizChatServId = paramamv.DnW.CIJ;
      ((c)localObject1).field_brandUserName = paramString;
      i = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (paramamv.CIS == null)
      {
        ad.w("MicroMsg.BizChatNetworkMgr", "members==null");
        AppMethodBeat.o(124275);
        return false;
      }
      Object localObject2;
      if ((((c)localObject1).awu()) || (paramamv.DnW.ver > ((c)localObject1).field_chatVersion))
      {
        ((c)localObject1).field_chatType = paramamv.DnW.type;
        ((c)localObject1).field_headImageUrl = paramamv.DnW.CIK;
        ((c)localObject1).field_chatName = paramamv.DnW.name;
        ((c)localObject1).field_chatVersion = paramamv.DnW.ver;
        ((c)localObject1).field_needToUpdate = false;
        ((c)localObject1).field_bitFlag = paramamv.DnW.CIL;
        ((c)localObject1).field_maxMemberCnt = paramamv.DnW.CIM;
        ((c)localObject1).field_ownerUserId = paramamv.DnW.CIN;
        ((c)localObject1).field_addMemberUrl = paramamv.DnW.CIO;
        ((c)localObject1).field_brandUserName = paramString;
        ((c)localObject1).field_roomflag = paramamv.DnW.CIP;
        paramString = new LinkedList();
        localObject2 = paramamv.CIS.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add(((mf)((Iterator)localObject2).next()).CIR);
        }
        ((c)localObject1).field_userList = bt.n(paramString, ";");
        if (i == 0) {
          break label442;
        }
        af.awg().a((c)localObject1);
      }
      long l;
      for (;;)
      {
        e.h((c)localObject1);
        if (!paramBoolean) {
          break label511;
        }
        paramString = new og();
        paramString.CIQ = ((c)localObject1).field_brandUserName;
        localObject1 = new LinkedList();
        paramamv = paramamv.CIS.iterator();
        while (paramamv.hasNext())
        {
          localObject2 = (mf)paramamv.next();
          l = af.awi().xv(((mf)localObject2).CIR);
          if (((mf)localObject2).ver > l) {
            ((LinkedList)localObject1).add(((mf)localObject2).CIR);
          }
        }
        label442:
        af.awg().b((c)localObject1);
      }
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString.CLT = ((LinkedList)localObject1);
        paramamv = new LinkedList();
        paramamv.add(paramString);
        paramamv = new s(paramamv, null);
        com.tencent.mm.kernel.g.afA().gcy.a(paramamv, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(124275);
        return true;
        label511:
        paramString = af.awi().db;
        l = 0L;
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)paramString).rb(Thread.currentThread().getId());
        }
        paramamv = paramamv.CIS.iterator();
        while (paramamv.hasNext())
        {
          localObject2 = (mf)paramamv.next();
          k localk = af.awi().ea(((mf)localObject2).CIR);
          if (localk == null)
          {
            localk = new k();
            localk.field_userId = ((mf)localObject2).CIR;
            localk.field_userName = ((mf)localObject2).nvC;
            localk.field_brandUserName = ((c)localObject1).field_brandUserName;
            localk.field_needToUpdate = true;
            af.awi().a(localk);
          }
          else if (((mf)localObject2).ver > localk.field_UserVersion)
          {
            localk.field_needToUpdate = true;
            af.awi().b(localk);
          }
        }
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.g.afB().gda.mX(l);
        }
      }
      i = 0;
    }
  }
  
  private static boolean a(mk parammk, String paramString)
  {
    AppMethodBeat.i(124274);
    if ((bt.isNullOrNil(paramString)) || (bt.isNullOrNil(parammk.CIR)))
    {
      AppMethodBeat.o(124274);
      return false;
    }
    k localk = new k();
    localk.field_userId = parammk.CIR;
    localk.field_userName = parammk.nvC;
    localk.field_brandUserName = paramString;
    localk.field_headImageUrl = parammk.CIK;
    localk.field_profileUrl = parammk.CIZ;
    localk.field_UserVersion = parammk.ver;
    localk.field_addMemberUrl = parammk.CIO;
    if (!af.awi().b(localk)) {
      af.awi().a(localk);
    }
    parammk = new c();
    parammk.field_bizChatServId = localk.field_userId;
    parammk.field_brandUserName = localk.field_brandUserName;
    parammk.field_chatName = localk.field_userName;
    parammk.field_chatType = j.gZo.gZr;
    if (e.e(parammk) == null)
    {
      AppMethodBeat.o(124274);
      return false;
    }
    AppMethodBeat.o(124274);
    return true;
  }
  
  private void aX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124260);
    long l = System.currentTimeMillis();
    synchronized (this.gZh)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.gZg.contains(paramString2))
      {
        AppMethodBeat.o(124260);
        return;
      }
      this.gZf.add(paramString2);
      this.gZi.put(paramString1, new Long(l));
      aww();
      AppMethodBeat.o(124260);
      return;
    }
  }
  
  private void aww()
  {
    AppMethodBeat.i(124262);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.gZh)
    {
      if (!this.gZg.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      if (this.gZf.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      Iterator localIterator = this.gZf.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        me localme = new me();
        localme.CIQ = a.a(locala);
        localme.CIJ = a.b(locala);
        localLinkedList1.add(localme);
      }
    }
    if (localLinkedList2.isEmpty())
    {
      AppMethodBeat.o(124262);
      return;
    }
    this.gZg.addAll(this.gZf);
    this.gZf.clear();
    ??? = new q(localLinkedList2);
    com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)???, 0);
    AppMethodBeat.o(124262);
  }
  
  private void awx()
  {
    AppMethodBeat.i(124266);
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    synchronized (this.gZl)
    {
      if (!this.gZk.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      if (this.gZj.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      localHashMap = new HashMap();
      localObject6 = this.gZj.iterator();
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
        localObject7 = new og();
        ((og)localObject7).CIQ = ((String)localObject4);
        ((og)localObject7).CLT = ((LinkedList)localObject6);
        localLinkedList.add(localObject7);
      }
    }
    this.gZk.addAll(this.gZj);
    this.gZj.clear();
    localObject3 = new s(localLinkedList, null);
    com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject3, 0);
    AppMethodBeat.o(124266);
  }
  
  public static void ba(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124267);
    paramString1 = new p(paramString1, paramString2);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    AppMethodBeat.o(124267);
  }
  
  public static void d(com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(124258);
    com.tencent.mm.kernel.g.afA().gcy.a(paramn);
    AppMethodBeat.o(124258);
  }
  
  public static void l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124273);
    paramString1 = new w(paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    AppMethodBeat.o(124273);
  }
  
  public final void a(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124261);
    long l = System.currentTimeMillis();
    synchronized (this.gZh)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (!this.gZg.contains(locala))
        {
          this.gZf.add(locala);
          this.gZi.put(str, new Long(l));
        }
      }
    }
    aww();
    AppMethodBeat.o(124261);
  }
  
  public final void aW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124259);
    Long localLong = (Long)this.gZi.aM(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      aX(paramString1, paramString2);
    }
    AppMethodBeat.o(124259);
  }
  
  public final void aY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124263);
    Long localLong = (Long)this.gZm.aM(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      aZ(paramString1, paramString2);
    }
    AppMethodBeat.o(124263);
  }
  
  public final void aZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124264);
    long l = System.currentTimeMillis();
    synchronized (this.gZl)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.gZk.contains(paramString2))
      {
        AppMethodBeat.o(124264);
        return;
      }
      this.gZj.add(paramString2);
      this.gZm.put(paramString1, new Long(l));
      awx();
      AppMethodBeat.o(124264);
      return;
    }
  }
  
  public final void b(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124265);
    long l = System.currentTimeMillis();
    synchronized (this.gZl)
    {
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (this.gZk.contains(locala))
        {
          AppMethodBeat.o(124265);
          return;
        }
        this.gZj.add(locala);
        this.gZm.put(str, new Long(l));
      }
    }
    awx();
    AppMethodBeat.o(124265);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(124256);
    com.tencent.mm.kernel.g.afA().gcy.b(1352, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1365, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1353, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1354, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1357, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1356, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1355, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1358, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1367, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1361, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1389, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1315, this);
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
      if ((((p)localObject1).rr != null) && (((p)localObject1).rr.gUT.gUX != null))
      {
        ??? = (aqk)((p)localObject1).rr.gUT.gUX;
        if ((((p)localObject1).rr == null) || (((p)localObject1).rr.gUS.gUX == null)) {
          break label321;
        }
      }
      for (paramn = (aqj)((p)localObject1).rr.gUS.gUX;; paramn = null)
      {
        bool1 = ((p)localObject1).gZB;
        if ((??? != null) && (???.CIW != null) && (???.CIW.ret == 0)) {
          break label342;
        }
        if ((??? == null) || (???.CIW == null)) {
          break label327;
        }
        ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.CIW.ret) });
        AppMethodBeat.o(124257);
        return;
        ??? = null;
        break;
      }
      ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(124257);
      return;
      a(???.DaY, paramn.CIQ, bool1);
      AppMethodBeat.o(124257);
      return;
    case 1365: 
      synchronized (this.gZh)
      {
        this.gZg.clear();
        aww();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      paramn = (q)paramn;
      if ((paramn.rr != null) && (paramn.rr.gUT.gUX != null)) {
        ??? = (aqi)paramn.rr.gUT.gUX;
      }
      while ((??? == null) || (???.CIW == null) || (???.CIW.ret != 0)) {
        if ((??? != null) && (???.CIW != null))
        {
          ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.CIW.ret) });
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
      ??? = ???.Drw;
      if ((??? == null) || (???.size() == 0))
      {
        ad.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
        AppMethodBeat.o(124257);
        return;
      }
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (amv)((Iterator)localObject1).next();
        ??? = ((amv)localObject2).DnW.CIJ;
        if ((??? == null) || (paramn.gZC == null)) {}
        for (??? = null;; ??? = (String)paramn.gZC.get(???))
        {
          a((amv)localObject2, ???, false);
          break;
        }
      }
      AppMethodBeat.o(124257);
      return;
    case 1353: 
      localObject1 = (s)paramn;
      localObject2 = (com.tencent.mm.am.o)((s)localObject1).data;
      if (localObject2 == null) {}
      synchronized (this.gZl)
      {
        this.gZk.clear();
        awx();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      if ((((s)localObject1).rr != null) && (((s)localObject1).rr.gUT.gUX != null))
      {
        ??? = (aqo)((s)localObject1).rr.gUT.gUX;
        paramInt1 = 0;
        if ((??? == null) || (???.CIW == null) || (???.CIW.ret != 0))
        {
          if ((??? == null) || (???.CIW == null)) {
            break label1218;
          }
          ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.CIW.ret) });
          label824:
          paramInt1 = -1;
        }
        if ((paramInt1 < 0) || (???.CIX != null)) {
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
        localObject3 = af.awi().db;
        long l = 0L;
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)localObject3).rb(Thread.currentThread().getId());
        }
        paramInt2 = 0;
        if (paramInt2 < ???.CIX.size())
        {
          ad.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[] { ((mk)???.CIX.get(paramInt2)).nvC });
          localObject4 = new k();
          ((k)localObject4).field_userId = ((mk)???.CIX.get(paramInt2)).CIR;
          ((k)localObject4).field_userName = ((mk)???.CIX.get(paramInt2)).nvC;
          paramn = ((k)localObject4).field_userId;
          if ((paramn == null) || (((s)localObject1).gZD == null))
          {
            paramn = null;
            ((k)localObject4).field_brandUserName = paramn;
            ((k)localObject4).field_UserVersion = ((mk)???.CIX.get(paramInt2)).ver;
            ((k)localObject4).field_headImageUrl = ((mk)???.CIX.get(paramInt2)).CIK;
            ((k)localObject4).field_profileUrl = ((mk)???.CIX.get(paramInt2)).CIZ;
            ((k)localObject4).field_bitFlag = ((mk)???.CIX.get(paramInt2)).CIL;
            ((k)localObject4).field_addMemberUrl = ((mk)???.CIX.get(paramInt2)).CIO;
            ((k)localObject4).field_needToUpdate = false;
            paramn = af.awi().ea(((mk)???.CIX.get(paramInt2)).CIR);
            if (paramn != null) {
              break label1249;
            }
            bool1 = false;
            bool2 = ((k)localObject4).ht(16);
            if (paramn != null) {
              break label1261;
            }
            af.awi().a((k)localObject4);
            if (bool1 != bool2)
            {
              paramn = af.awg().xj(((k)localObject4).field_userId);
              if (paramn != null)
              {
                if ((!bool1) || (bool2)) {
                  break label1273;
                }
                af.awh().mk(paramn.field_bizChatLocalId);
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
            paramn = (String)((s)localObject1).gZD.get(paramn);
            break label998;
            bool1 = paramn.ht(16);
            break label1136;
            af.awi().b((k)localObject4);
            break label1159;
            label1273:
            if ((!bool1) && (bool2)) {
              af.awh().mj(paramn.field_bizChatLocalId);
            }
          }
        }
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.g.afB().gda.mX(l);
        }
      }
      if (localObject2 != null) {
        ((com.tencent.mm.am.o)localObject2).a(paramInt1, (com.tencent.mm.al.n)localObject1);
      }
      AppMethodBeat.o(124257);
      return;
      localObject1 = (r)paramn;
      if ((((r)localObject1).rr != null) && (((r)localObject1).rr.gUT.gUX != null))
      {
        ??? = (aqm)((r)localObject1).rr.gUT.gUX;
        if (((r)localObject1).rr != null) {
          break label1530;
        }
        paramn = null;
        label1395:
        if ((??? != null) && (???.CIW != null) && (???.CIW.ret == 0)) {
          break label3712;
        }
        if ((??? == null) || (???.CIW == null)) {
          break label1549;
        }
        ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.CIW.ret) });
      }
      label2032:
      label2416:
      label3696:
      for (paramInt1 = -1;; paramInt1 = 0)
      {
        if (paramInt1 >= 0)
        {
          localObject2 = af.awi();
          paramn = paramn.CIQ;
          ??? = ???.CIT;
          if ((??? == null) || (bt.isNullOrNil(paramn))) {
            ad.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
          }
        }
        else
        {
          ??? = (com.tencent.mm.am.o)((r)localObject1).data;
          if (??? != null) {
            ???.a(paramInt1, (com.tencent.mm.al.n)localObject1);
          }
          AppMethodBeat.o(124257);
          return;
          ??? = null;
          break label1384;
          label1530:
          paramn = (aql)((r)localObject1).rr.gUS.gUX;
          break label1395;
          ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1452;
        }
        ad.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[] { paramn, ???.CIR, Boolean.valueOf(bt.isNullOrNil(???.CIO)) });
        localObject3 = af.awj().xt(paramn);
        if (localObject3 == null)
        {
          localObject3 = new f();
          ((f)localObject3).field_brandUserName = paramn;
          ((f)localObject3).field_userId = ???.CIR;
          af.awj().a((f)localObject3);
        }
        for (;;)
        {
          localObject3 = new k();
          ((k)localObject3).field_userId = ???.CIR;
          ((k)localObject3).field_userName = ???.nvC;
          ((k)localObject3).field_brandUserName = paramn;
          ((k)localObject3).field_UserVersion = ???.ver;
          ((k)localObject3).field_headImageUrl = ???.CIK;
          ((k)localObject3).field_profileUrl = ???.CIZ;
          ((k)localObject3).field_bitFlag = ???.CIL;
          ((k)localObject3).field_needToUpdate = false;
          ((k)localObject3).field_addMemberUrl = ???.CIO;
          if (!((l)localObject2).b((k)localObject3)) {
            ((l)localObject2).a((k)localObject3);
          }
          ((l)localObject2).gYH.put(paramn, ((k)localObject3).field_userId);
          break;
          ((f)localObject3).field_userId = ???.CIR;
          af.awj().b((f)localObject3);
          ad.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
        }
        ??? = (o)paramn;
        paramn = ???.awz();
        localObject1 = ???.awA();
        paramInt1 = 0;
        if ((paramn == null) || (paramn.CIW == null) || (paramn.CIW.ret != 0))
        {
          if ((paramn != null) && (paramn.CIW != null))
          {
            ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.CIW.ret) });
            paramInt1 = -1;
          }
        }
        else
        {
          if (paramInt1 < 0) {
            break label3709;
          }
          if (!a(paramn.DaY, ((yv)localObject1).CIQ, true)) {
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
          paramn = (com.tencent.mm.am.o)???.data;
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
          paramn = ???.awB();
          paramInt1 = 0;
          if ((paramn == null) || (paramn.CIW == null) || (paramn.CIW.ret != 0))
          {
            if ((paramn != null) && (paramn.CIW != null))
            {
              ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.CIW.ret) });
              paramInt1 = -1;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            if (paramInt1 >= 0)
            {
              paramInt2 = paramInt1;
              if (paramn.DaO == null)
              {
                paramInt2 = paramInt1;
                if (paramn.DaN == null) {
                  paramInt2 = -1;
                }
              }
            }
            if (paramInt2 < 0) {
              break label3704;
            }
            if (paramn.DaO == null) {
              break label2162;
            }
            bool2 = a(paramn.DaO, paramn.CIQ);
            bool1 = bool2;
            if (bool2)
            {
              ???.gZA = paramn.DaO.CIR;
              bool1 = bool2;
            }
            if (bool1) {
              break label3704;
            }
          }
          for (paramInt1 = -1;; paramInt1 = paramInt2)
          {
            paramn = (com.tencent.mm.am.o)???.data;
            if (paramn != null) {
              paramn.a(paramInt1, ???);
            }
            AppMethodBeat.o(124257);
            return;
            ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label2032;
            bool2 = a(paramn.DaN, paramn.CIQ, true);
            bool1 = bool2;
            if (!bool2) {
              break label2114;
            }
            ???.gZA = paramn.DaN.DnW.CIJ;
            bool1 = bool2;
            break label2114;
            ??? = (n)paramn;
            paramn = ???.awy();
            paramInt1 = 0;
            if ((paramn == null) || (paramn.CIW == null) || (paramn.CIW.ret != 0))
            {
              if ((paramn != null) && (paramn.CIW != null))
              {
                ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.CIW.ret) });
                paramInt1 = -1;
              }
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 >= 0)
              {
                paramInt2 = paramInt1;
                if (paramn.DaO == null)
                {
                  paramInt2 = paramInt1;
                  if (paramn.DaN == null) {
                    paramInt2 = -1;
                  }
                }
              }
              if (paramInt2 < 0) {
                break label3699;
              }
              if (paramn.DaO == null) {
                break label2416;
              }
              bool2 = a(paramn.DaO, paramn.CIQ);
              bool1 = bool2;
              if (bool2)
              {
                ???.gZA = paramn.DaO.CIR;
                bool1 = bool2;
              }
              if (bool1) {
                break label3699;
              }
            }
            for (paramInt1 = -1;; paramInt1 = paramInt2)
            {
              paramn = (com.tencent.mm.am.o)???.data;
              if (paramn != null) {
                paramn.a(paramInt1, ???);
              }
              AppMethodBeat.o(124257);
              return;
              ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label2286;
              bool2 = a(paramn.DaN, paramn.CIQ, true);
              bool1 = bool2;
              if (!bool2) {
                break label2368;
              }
              ???.gZA = paramn.DaN.DnW.CIJ;
              bool1 = bool2;
              break label2368;
              ad.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
              localObject1 = (y)paramn;
              if ((((y)localObject1).rr != null) && (((y)localObject1).rr.gUT.gUX != null))
              {
                ??? = (dfp)((y)localObject1).rr.gUT.gUX;
                if ((((y)localObject1).rr == null) || (((y)localObject1).rr.gUS.gUX == null)) {
                  break label2622;
                }
                paramn = (dfo)((y)localObject1).rr.gUS.gUX;
              }
              for (;;)
              {
                if ((??? == null) || (???.CIW == null) || (???.CIW.ret != 0))
                {
                  if ((??? != null) && (???.CIW != null))
                  {
                    ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.CIW.ret) });
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
              if (a(???.DaY, paramn.CIQ, false)) {}
              for (paramInt1 = 0;; paramInt1 = -1)
              {
                ??? = (com.tencent.mm.am.o)((y)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.al.n)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
              }
              localObject1 = (x)paramn;
              if ((((x)localObject1).rr != null) && (((x)localObject1).rr.gUT.gUX != null))
              {
                ??? = (dfr)((x)localObject1).rr.gUT.gUX;
                if ((((x)localObject1).rr == null) || (((x)localObject1).rr.gUS.gUX == null)) {
                  break label3114;
                }
                paramn = (dfq)((x)localObject1).rr.gUS.gUX;
                paramInt1 = 0;
                if ((??? == null) || (???.CIW == null) || (???.CIW.ret != 0) || (???.DnW == null))
                {
                  if ((??? == null) || (???.CIW == null)) {
                    break label3120;
                  }
                  ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.CIW.ret) });
                  paramInt1 = -1;
                }
                if (paramInt1 < 0) {
                  break label3696;
                }
                localObject2 = af.awg().xj(???.DnW.CIJ);
                if (localObject2 == null)
                {
                  if (localObject2 != null) {
                    break label3131;
                  }
                  bool1 = true;
                  if (???.DnW != null) {
                    break label3137;
                  }
                  bool2 = true;
                  ad.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null:%s, resp.chat == null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  paramInt1 = -1;
                }
                if ((paramInt1 < 0) || (((((c)localObject2).field_bitFlag == ???.DnW.CIL) || (!((c)localObject2).awu())) && (???.DnW.ver <= ((c)localObject2).field_chatVersion))) {
                  break label3143;
                }
                ((c)localObject2).field_chatType = ???.DnW.type;
                ((c)localObject2).field_headImageUrl = ???.DnW.CIK;
                ((c)localObject2).field_chatName = ???.DnW.name;
                ((c)localObject2).field_chatVersion = ???.DnW.ver;
                ((c)localObject2).field_needToUpdate = false;
                ((c)localObject2).field_bitFlag = ???.DnW.CIL;
                ((c)localObject2).field_maxMemberCnt = ???.DnW.CIM;
                ((c)localObject2).field_ownerUserId = ???.DnW.CIN;
                ((c)localObject2).field_addMemberUrl = ???.DnW.CIO;
                ((c)localObject2).field_brandUserName = paramn.CIQ;
                af.awg().b((c)localObject2);
              }
              for (;;)
              {
                ??? = (com.tencent.mm.am.o)((x)localObject1).data;
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
                if ((paramn.rr != null) && (paramn.rr.gUT.gUX != null))
                {
                  ??? = (aub)paramn.rr.gUT.gUX;
                  if ((paramn.rr == null) || (paramn.rr.gUS.gUX == null)) {
                    break label3306;
                  }
                  paramn = (aua)paramn.rr.gUS.gUX;
                }
                for (;;)
                {
                  if ((??? == null) || (???.CIW == null) || (???.CIW.ret != 0))
                  {
                    if ((??? != null) && (???.CIW != null))
                    {
                      ad.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.CIW.ret) });
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
                localObject2 = ???.DtZ;
                localObject3 = af.awg();
                localObject4 = paramn.CIQ;
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
                    localObject4 = af.awg().xj((String)localObject4);
                    if (localObject4 != null)
                    {
                      ((c)localObject4).field_bitFlag &= 0xFFFFFFF7;
                      af.awg().b((c)localObject4);
                    }
                  }
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  if (!((List)localObject1).contains(localObject3))
                  {
                    localObject4 = af.awg().xj((String)localObject3);
                    if (localObject4 == null)
                    {
                      localObject4 = new c();
                      ((c)localObject4).field_bizChatServId = ((String)localObject3);
                      ((c)localObject4).field_brandUserName = paramn.CIQ;
                      ((c)localObject4).field_bitFlag |= 0x8;
                      af.awg().a((c)localObject4);
                    }
                    else
                    {
                      ((c)localObject4).field_bitFlag |= 0x8;
                      af.awg().b((c)localObject4);
                    }
                  }
                }
                a(???.DtZ, paramn.CIQ);
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
    private String drK;
    private String id;
    
    public a(String paramString1, String paramString2)
    {
      this.drK = paramString1;
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
      if (((this.drK == null) && (paramObject.drK == null)) || ((this.drK != null) && (this.drK.equals(paramObject.drK)) && (((this.id == null) && (paramObject.id == null)) || ((this.id != null) && (this.id.equals(paramObject.id))))))
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
      int i = this.drK.hashCode();
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