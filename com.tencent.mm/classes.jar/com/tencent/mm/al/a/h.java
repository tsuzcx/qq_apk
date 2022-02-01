package com.tencent.mm.al.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.al.af;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axh;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.protocal.protobuf.zq;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements com.tencent.mm.ak.g
{
  private HashSet<h.a> hzE;
  private HashSet<h.a> hzF;
  private final Object hzG;
  private com.tencent.mm.b.f<String, Long> hzH;
  private HashSet<h.a> hzI;
  private HashSet<h.a> hzJ;
  private final Object hzK;
  private com.tencent.mm.b.f<String, Long> hzL;
  
  public h()
  {
    AppMethodBeat.i(124255);
    this.hzE = new HashSet();
    this.hzF = new HashSet();
    this.hzG = new Object();
    this.hzH = new com.tencent.mm.b.h(64);
    this.hzI = new HashSet();
    this.hzJ = new HashSet();
    this.hzK = new Object();
    this.hzL = new com.tencent.mm.b.h(64);
    com.tencent.mm.kernel.g.agQ().ghe.a(1352, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1365, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1353, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1354, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1357, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1356, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1355, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1358, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1367, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1361, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1389, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1315, this);
    AppMethodBeat.o(124255);
  }
  
  public static o a(String paramString, apz paramapz, com.tencent.mm.al.o paramo)
  {
    AppMethodBeat.i(124270);
    paramString = new o(paramString, paramapz, paramo);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
    AppMethodBeat.o(124270);
    return paramString;
  }
  
  public static x a(String paramString, mk parammk, com.tencent.mm.al.o paramo)
  {
    AppMethodBeat.i(124272);
    paramString = new x(paramString, parammk, paramo);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
    AppMethodBeat.o(124272);
    return paramString;
  }
  
  public static y a(String paramString1, String paramString2, mn parammn1, mn parammn2, com.tencent.mm.al.o paramo)
  {
    AppMethodBeat.i(124271);
    paramString1 = new y(paramString1, paramString2, parammn1, parammn2, paramo);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString1, 0);
    AppMethodBeat.o(124271);
    return paramString1;
  }
  
  public static void a(String paramString, com.tencent.mm.al.o paramo)
  {
    AppMethodBeat.i(124269);
    paramString = new r(paramString, paramo);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
    AppMethodBeat.o(124269);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.al.o paramo)
  {
    AppMethodBeat.i(124268);
    if (paramo == null)
    {
      AppMethodBeat.o(124268);
      return;
    }
    Object localObject = e.Bu(paramString2);
    if ((localObject == null) || (((k)localObject).field_userId.equals(paramString1)))
    {
      a(paramString2, paramo);
      AppMethodBeat.o(124268);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString1);
    paramString1 = new on();
    paramString1.Ebs = paramString2;
    paramString1.Eev = ((LinkedList)localObject);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = new s(paramString2, paramo);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString1, 0);
    AppMethodBeat.o(124268);
  }
  
  private static boolean a(apz paramapz, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124275);
    ac.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
    if ((paramapz == null) || (paramapz.EIW == null) || (bs.isNullOrNil(paramString)))
    {
      ac.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
      AppMethodBeat.o(124275);
      return false;
    }
    Object localObject1 = af.aCY().Bp(paramapz.EIW.Ebl);
    int i;
    if (localObject1 == null)
    {
      ac.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
      localObject1 = new c();
      ((c)localObject1).field_bizChatServId = paramapz.EIW.Ebl;
      ((c)localObject1).field_brandUserName = paramString;
      i = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (paramapz.Ebu == null)
      {
        ac.w("MicroMsg.BizChatNetworkMgr", "members==null");
        AppMethodBeat.o(124275);
        return false;
      }
      Object localObject2;
      if ((((c)localObject1).aDm()) || (paramapz.EIW.ver > ((c)localObject1).field_chatVersion))
      {
        ((c)localObject1).field_chatType = paramapz.EIW.type;
        ((c)localObject1).field_headImageUrl = paramapz.EIW.Ebm;
        ((c)localObject1).field_chatName = paramapz.EIW.name;
        ((c)localObject1).field_chatVersion = paramapz.EIW.ver;
        ((c)localObject1).field_needToUpdate = false;
        ((c)localObject1).field_bitFlag = paramapz.EIW.Ebn;
        ((c)localObject1).field_maxMemberCnt = paramapz.EIW.Ebo;
        ((c)localObject1).field_ownerUserId = paramapz.EIW.Ebp;
        ((c)localObject1).field_addMemberUrl = paramapz.EIW.Ebq;
        ((c)localObject1).field_brandUserName = paramString;
        ((c)localObject1).field_roomflag = paramapz.EIW.Ebr;
        paramString = new LinkedList();
        localObject2 = paramapz.Ebu.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add(((mm)((Iterator)localObject2).next()).Ebt);
        }
        ((c)localObject1).field_userList = bs.n(paramString, ";");
        if (i == 0) {
          break label442;
        }
        af.aCY().a((c)localObject1);
      }
      long l;
      for (;;)
      {
        e.h((c)localObject1);
        if (!paramBoolean) {
          break label511;
        }
        paramString = new on();
        paramString.Ebs = ((c)localObject1).field_brandUserName;
        localObject1 = new LinkedList();
        paramapz = paramapz.Ebu.iterator();
        while (paramapz.hasNext())
        {
          localObject2 = (mm)paramapz.next();
          l = af.aDa().BB(((mm)localObject2).Ebt);
          if (((mm)localObject2).ver > l) {
            ((LinkedList)localObject1).add(((mm)localObject2).Ebt);
          }
        }
        label442:
        af.aCY().b((c)localObject1);
      }
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString.Eev = ((LinkedList)localObject1);
        paramapz = new LinkedList();
        paramapz.add(paramString);
        paramapz = new s(paramapz, null);
        com.tencent.mm.kernel.g.agQ().ghe.a(paramapz, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(124275);
        return true;
        label511:
        paramString = af.aDa().db;
        l = 0L;
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)paramString).vE(Thread.currentThread().getId());
        }
        paramapz = paramapz.Ebu.iterator();
        while (paramapz.hasNext())
        {
          localObject2 = (mm)paramapz.next();
          k localk = af.aDa().dP(((mm)localObject2).Ebt);
          if (localk == null)
          {
            localk = new k();
            localk.field_userId = ((mm)localObject2).Ebt;
            localk.field_userName = ((mm)localObject2).nYC;
            localk.field_brandUserName = ((c)localObject1).field_brandUserName;
            localk.field_needToUpdate = true;
            af.aDa().a(localk);
          }
          else if (((mm)localObject2).ver > localk.field_UserVersion)
          {
            localk.field_needToUpdate = true;
            af.aDa().b(localk);
          }
        }
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.g.agR().ghG.qL(l);
        }
      }
      i = 0;
    }
  }
  
  private static boolean a(mr parammr, String paramString)
  {
    AppMethodBeat.i(124274);
    if ((bs.isNullOrNil(paramString)) || (bs.isNullOrNil(parammr.Ebt)))
    {
      AppMethodBeat.o(124274);
      return false;
    }
    k localk = new k();
    localk.field_userId = parammr.Ebt;
    localk.field_userName = parammr.nYC;
    localk.field_brandUserName = paramString;
    localk.field_headImageUrl = parammr.Ebm;
    localk.field_profileUrl = parammr.EbB;
    localk.field_UserVersion = parammr.ver;
    localk.field_addMemberUrl = parammr.Ebq;
    if (!af.aDa().b(localk)) {
      af.aDa().a(localk);
    }
    parammr = new c();
    parammr.field_bizChatServId = localk.field_userId;
    parammr.field_brandUserName = localk.field_brandUserName;
    parammr.field_chatName = localk.field_userName;
    parammr.field_chatType = j.hzN.hzQ;
    if (e.e(parammr) == null)
    {
      AppMethodBeat.o(124274);
      return false;
    }
    AppMethodBeat.o(124274);
    return true;
  }
  
  private void aDo()
  {
    AppMethodBeat.i(124262);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.hzG)
    {
      if (!this.hzF.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      if (this.hzE.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      Iterator localIterator = this.hzE.iterator();
      if (localIterator.hasNext())
      {
        h.a locala = (h.a)localIterator.next();
        ml localml = new ml();
        localml.Ebs = h.a.a(locala);
        localml.Ebl = h.a.b(locala);
        localLinkedList1.add(localml);
      }
    }
    if (localLinkedList2.isEmpty())
    {
      AppMethodBeat.o(124262);
      return;
    }
    this.hzF.addAll(this.hzE);
    this.hzE.clear();
    ??? = new q(localLinkedList2);
    com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)???, 0);
    AppMethodBeat.o(124262);
  }
  
  private void aDp()
  {
    AppMethodBeat.i(124266);
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    synchronized (this.hzK)
    {
      if (!this.hzJ.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      if (this.hzI.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      localHashMap = new HashMap();
      localObject6 = this.hzI.iterator();
      if (((Iterator)localObject6).hasNext())
      {
        localObject7 = (h.a)((Iterator)localObject6).next();
        localObject4 = (LinkedList)localHashMap.get(h.a.a((h.a)localObject7));
        Object localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new LinkedList();
          localHashMap.put(h.a.a((h.a)localObject7), localObject1);
        }
        ((LinkedList)localObject1).add(h.a.b((h.a)localObject7));
      }
    }
    Object localObject3 = localHashMap.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      localObject6 = (LinkedList)localHashMap.get(localObject4);
      if ((localObject6 != null) && (!((LinkedList)localObject6).isEmpty()))
      {
        localObject7 = new on();
        ((on)localObject7).Ebs = ((String)localObject4);
        ((on)localObject7).Eev = ((LinkedList)localObject6);
        localLinkedList.add(localObject7);
      }
    }
    this.hzJ.addAll(this.hzI);
    this.hzI.clear();
    localObject3 = new s(localLinkedList, null);
    com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject3, 0);
    AppMethodBeat.o(124266);
  }
  
  private void bf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124260);
    long l = System.currentTimeMillis();
    synchronized (this.hzG)
    {
      paramString2 = new h.a(paramString2, paramString1);
      if (this.hzF.contains(paramString2))
      {
        AppMethodBeat.o(124260);
        return;
      }
      this.hzE.add(paramString2);
      this.hzH.put(paramString1, new Long(l));
      aDo();
      AppMethodBeat.o(124260);
      return;
    }
  }
  
  public static void bi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124267);
    paramString1 = new p(paramString1, paramString2);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString1, 0);
    AppMethodBeat.o(124267);
  }
  
  public static void d(com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(124258);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramn);
    AppMethodBeat.o(124258);
  }
  
  public static void m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124273);
    paramString1 = new w(paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString1, 0);
    AppMethodBeat.o(124273);
  }
  
  public final void b(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124261);
    long l = System.currentTimeMillis();
    synchronized (this.hzG)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        h.a locala = new h.a(paramString, str);
        if (!this.hzF.contains(locala))
        {
          this.hzE.add(locala);
          this.hzH.put(str, new Long(l));
        }
      }
    }
    aDo();
    AppMethodBeat.o(124261);
  }
  
  public final void be(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124259);
    Long localLong = (Long)this.hzH.aJ(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bf(paramString1, paramString2);
    }
    AppMethodBeat.o(124259);
  }
  
  public final void bg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124263);
    Long localLong = (Long)this.hzL.aJ(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bh(paramString1, paramString2);
    }
    AppMethodBeat.o(124263);
  }
  
  public final void bh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124264);
    long l = System.currentTimeMillis();
    synchronized (this.hzK)
    {
      paramString2 = new h.a(paramString2, paramString1);
      if (this.hzJ.contains(paramString2))
      {
        AppMethodBeat.o(124264);
        return;
      }
      this.hzI.add(paramString2);
      this.hzL.put(paramString1, new Long(l));
      aDp();
      AppMethodBeat.o(124264);
      return;
    }
  }
  
  public final void c(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124265);
    long l = System.currentTimeMillis();
    synchronized (this.hzK)
    {
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        h.a locala = new h.a(paramString, str);
        if (this.hzJ.contains(locala))
        {
          AppMethodBeat.o(124265);
          return;
        }
        this.hzI.add(locala);
        this.hzL.put(str, new Long(l));
      }
    }
    aDp();
    AppMethodBeat.o(124265);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(124256);
    com.tencent.mm.kernel.g.agQ().ghe.b(1352, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1365, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1353, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1354, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1357, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1356, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1355, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1358, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1367, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1361, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1389, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1315, this);
    super.finalize();
    AppMethodBeat.o(124256);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(124257);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
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
      if ((((p)localObject1).rr != null) && (((p)localObject1).rr.hvs.hvw != null))
      {
        ??? = (ato)((p)localObject1).rr.hvs.hvw;
        if ((((p)localObject1).rr == null) || (((p)localObject1).rr.hvr.hvw == null)) {
          break label321;
        }
      }
      for (paramn = (atn)((p)localObject1).rr.hvr.hvw;; paramn = null)
      {
        bool1 = ((p)localObject1).hAa;
        if ((??? != null) && (???.Eby != null) && (???.Eby.ret == 0)) {
          break label342;
        }
        if ((??? == null) || (???.Eby == null)) {
          break label327;
        }
        ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.Eby.ret) });
        AppMethodBeat.o(124257);
        return;
        ??? = null;
        break;
      }
      ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(124257);
      return;
      a(???.EtV, paramn.Ebs, bool1);
      AppMethodBeat.o(124257);
      return;
    case 1365: 
      synchronized (this.hzG)
      {
        this.hzF.clear();
        aDo();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      paramn = (q)paramn;
      if ((paramn.rr != null) && (paramn.rr.hvs.hvw != null)) {
        ??? = (atm)paramn.rr.hvs.hvw;
      }
      while ((??? == null) || (???.Eby == null) || (???.Eby.ret != 0)) {
        if ((??? != null) && (???.Eby != null))
        {
          ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.Eby.ret) });
          AppMethodBeat.o(124257);
          return;
          ??? = null;
        }
        else
        {
          ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          AppMethodBeat.o(124257);
          return;
        }
      }
      ??? = ???.EMy;
      if ((??? == null) || (???.size() == 0))
      {
        ac.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
        AppMethodBeat.o(124257);
        return;
      }
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (apz)((Iterator)localObject1).next();
        ??? = ((apz)localObject2).EIW.Ebl;
        if ((??? == null) || (paramn.hAb == null)) {}
        for (??? = null;; ??? = (String)paramn.hAb.get(???))
        {
          a((apz)localObject2, ???, false);
          break;
        }
      }
      AppMethodBeat.o(124257);
      return;
    case 1353: 
      localObject1 = (s)paramn;
      localObject2 = (com.tencent.mm.al.o)((s)localObject1).data;
      if (localObject2 == null) {}
      synchronized (this.hzK)
      {
        this.hzJ.clear();
        aDp();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      if ((((s)localObject1).rr != null) && (((s)localObject1).rr.hvs.hvw != null))
      {
        ??? = (ats)((s)localObject1).rr.hvs.hvw;
        paramInt1 = 0;
        if ((??? == null) || (???.Eby == null) || (???.Eby.ret != 0))
        {
          if ((??? == null) || (???.Eby == null)) {
            break label1218;
          }
          ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.Eby.ret) });
          label824:
          paramInt1 = -1;
        }
        if ((paramInt1 < 0) || (???.Ebz != null)) {
          break label3717;
        }
        ac.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
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
        localObject3 = af.aDa().db;
        long l = 0L;
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)localObject3).vE(Thread.currentThread().getId());
        }
        paramInt2 = 0;
        if (paramInt2 < ???.Ebz.size())
        {
          ac.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[] { ((mr)???.Ebz.get(paramInt2)).nYC });
          localObject4 = new k();
          ((k)localObject4).field_userId = ((mr)???.Ebz.get(paramInt2)).Ebt;
          ((k)localObject4).field_userName = ((mr)???.Ebz.get(paramInt2)).nYC;
          paramn = ((k)localObject4).field_userId;
          if ((paramn == null) || (((s)localObject1).hAc == null))
          {
            paramn = null;
            ((k)localObject4).field_brandUserName = paramn;
            ((k)localObject4).field_UserVersion = ((mr)???.Ebz.get(paramInt2)).ver;
            ((k)localObject4).field_headImageUrl = ((mr)???.Ebz.get(paramInt2)).Ebm;
            ((k)localObject4).field_profileUrl = ((mr)???.Ebz.get(paramInt2)).EbB;
            ((k)localObject4).field_bitFlag = ((mr)???.Ebz.get(paramInt2)).Ebn;
            ((k)localObject4).field_addMemberUrl = ((mr)???.Ebz.get(paramInt2)).Ebq;
            ((k)localObject4).field_needToUpdate = false;
            paramn = af.aDa().dP(((mr)???.Ebz.get(paramInt2)).Ebt);
            if (paramn != null) {
              break label1249;
            }
            bool1 = false;
            bool2 = ((k)localObject4).hc(16);
            if (paramn != null) {
              break label1261;
            }
            af.aDa().a((k)localObject4);
            if (bool1 != bool2)
            {
              paramn = af.aCY().Bp(((k)localObject4).field_userId);
              if (paramn != null)
              {
                if ((!bool1) || (bool2)) {
                  break label1273;
                }
                af.aCZ().pY(paramn.field_bizChatLocalId);
              }
            }
          }
          for (;;)
          {
            paramInt2 += 1;
            break label888;
            ??? = null;
            break;
            ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label824;
            paramn = (String)((s)localObject1).hAc.get(paramn);
            break label998;
            bool1 = paramn.hc(16);
            break label1136;
            af.aDa().b((k)localObject4);
            break label1159;
            label1273:
            if ((!bool1) && (bool2)) {
              af.aCZ().pX(paramn.field_bizChatLocalId);
            }
          }
        }
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.g.agR().ghG.qL(l);
        }
      }
      if (localObject2 != null) {
        ((com.tencent.mm.al.o)localObject2).a(paramInt1, (com.tencent.mm.ak.n)localObject1);
      }
      AppMethodBeat.o(124257);
      return;
      localObject1 = (r)paramn;
      if ((((r)localObject1).rr != null) && (((r)localObject1).rr.hvs.hvw != null))
      {
        ??? = (atq)((r)localObject1).rr.hvs.hvw;
        if (((r)localObject1).rr != null) {
          break label1530;
        }
        paramn = null;
        label1395:
        if ((??? != null) && (???.Eby != null) && (???.Eby.ret == 0)) {
          break label3712;
        }
        if ((??? == null) || (???.Eby == null)) {
          break label1549;
        }
        ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.Eby.ret) });
      }
      label2032:
      label2416:
      label3696:
      for (paramInt1 = -1;; paramInt1 = 0)
      {
        if (paramInt1 >= 0)
        {
          localObject2 = af.aDa();
          paramn = paramn.Ebs;
          ??? = ???.Ebv;
          if ((??? == null) || (bs.isNullOrNil(paramn))) {
            ac.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
          }
        }
        else
        {
          ??? = (com.tencent.mm.al.o)((r)localObject1).data;
          if (??? != null) {
            ???.a(paramInt1, (com.tencent.mm.ak.n)localObject1);
          }
          AppMethodBeat.o(124257);
          return;
          ??? = null;
          break label1384;
          label1530:
          paramn = (atp)((r)localObject1).rr.hvr.hvw;
          break label1395;
          ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1452;
        }
        ac.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[] { paramn, ???.Ebt, Boolean.valueOf(bs.isNullOrNil(???.Ebq)) });
        localObject3 = af.aDb().Bz(paramn);
        if (localObject3 == null)
        {
          localObject3 = new f();
          ((f)localObject3).field_brandUserName = paramn;
          ((f)localObject3).field_userId = ???.Ebt;
          af.aDb().a((f)localObject3);
        }
        for (;;)
        {
          localObject3 = new k();
          ((k)localObject3).field_userId = ???.Ebt;
          ((k)localObject3).field_userName = ???.nYC;
          ((k)localObject3).field_brandUserName = paramn;
          ((k)localObject3).field_UserVersion = ???.ver;
          ((k)localObject3).field_headImageUrl = ???.Ebm;
          ((k)localObject3).field_profileUrl = ???.EbB;
          ((k)localObject3).field_bitFlag = ???.Ebn;
          ((k)localObject3).field_needToUpdate = false;
          ((k)localObject3).field_addMemberUrl = ???.Ebq;
          if (!((l)localObject2).b((k)localObject3)) {
            ((l)localObject2).a((k)localObject3);
          }
          ((l)localObject2).hzg.put(paramn, ((k)localObject3).field_userId);
          break;
          ((f)localObject3).field_userId = ???.Ebt;
          af.aDb().b((f)localObject3);
          ac.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
        }
        ??? = (o)paramn;
        paramn = ???.aDr();
        localObject1 = ???.aDs();
        paramInt1 = 0;
        if ((paramn == null) || (paramn.Eby == null) || (paramn.Eby.ret != 0))
        {
          if ((paramn != null) && (paramn.Eby != null))
          {
            ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.Eby.ret) });
            paramInt1 = -1;
          }
        }
        else
        {
          if (paramInt1 < 0) {
            break label3709;
          }
          if (!a(paramn.EtV, ((zq)localObject1).Ebs, true)) {
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
          paramn = (com.tencent.mm.al.o)???.data;
          if (paramn != null) {
            paramn.a(paramInt1, ???);
          }
          AppMethodBeat.o(124257);
          return;
          ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1884;
          paramInt1 = -1;
          continue;
          ??? = (u)paramn;
          paramn = ???.aDt();
          paramInt1 = 0;
          if ((paramn == null) || (paramn.Eby == null) || (paramn.Eby.ret != 0))
          {
            if ((paramn != null) && (paramn.Eby != null))
            {
              ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.Eby.ret) });
              paramInt1 = -1;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            if (paramInt1 >= 0)
            {
              paramInt2 = paramInt1;
              if (paramn.EtL == null)
              {
                paramInt2 = paramInt1;
                if (paramn.EtK == null) {
                  paramInt2 = -1;
                }
              }
            }
            if (paramInt2 < 0) {
              break label3704;
            }
            if (paramn.EtL == null) {
              break label2162;
            }
            bool2 = a(paramn.EtL, paramn.Ebs);
            bool1 = bool2;
            if (bool2)
            {
              ???.hzZ = paramn.EtL.Ebt;
              bool1 = bool2;
            }
            if (bool1) {
              break label3704;
            }
          }
          for (paramInt1 = -1;; paramInt1 = paramInt2)
          {
            paramn = (com.tencent.mm.al.o)???.data;
            if (paramn != null) {
              paramn.a(paramInt1, ???);
            }
            AppMethodBeat.o(124257);
            return;
            ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label2032;
            bool2 = a(paramn.EtK, paramn.Ebs, true);
            bool1 = bool2;
            if (!bool2) {
              break label2114;
            }
            ???.hzZ = paramn.EtK.EIW.Ebl;
            bool1 = bool2;
            break label2114;
            ??? = (n)paramn;
            paramn = ???.aDq();
            paramInt1 = 0;
            if ((paramn == null) || (paramn.Eby == null) || (paramn.Eby.ret != 0))
            {
              if ((paramn != null) && (paramn.Eby != null))
              {
                ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.Eby.ret) });
                paramInt1 = -1;
              }
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 >= 0)
              {
                paramInt2 = paramInt1;
                if (paramn.EtL == null)
                {
                  paramInt2 = paramInt1;
                  if (paramn.EtK == null) {
                    paramInt2 = -1;
                  }
                }
              }
              if (paramInt2 < 0) {
                break label3699;
              }
              if (paramn.EtL == null) {
                break label2416;
              }
              bool2 = a(paramn.EtL, paramn.Ebs);
              bool1 = bool2;
              if (bool2)
              {
                ???.hzZ = paramn.EtL.Ebt;
                bool1 = bool2;
              }
              if (bool1) {
                break label3699;
              }
            }
            for (paramInt1 = -1;; paramInt1 = paramInt2)
            {
              paramn = (com.tencent.mm.al.o)???.data;
              if (paramn != null) {
                paramn.a(paramInt1, ???);
              }
              AppMethodBeat.o(124257);
              return;
              ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label2286;
              bool2 = a(paramn.EtK, paramn.Ebs, true);
              bool1 = bool2;
              if (!bool2) {
                break label2368;
              }
              ???.hzZ = paramn.EtK.EIW.Ebl;
              bool1 = bool2;
              break label2368;
              ac.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
              localObject1 = (y)paramn;
              if ((((y)localObject1).rr != null) && (((y)localObject1).rr.hvs.hvw != null))
              {
                ??? = (dle)((y)localObject1).rr.hvs.hvw;
                if ((((y)localObject1).rr == null) || (((y)localObject1).rr.hvr.hvw == null)) {
                  break label2622;
                }
                paramn = (dld)((y)localObject1).rr.hvr.hvw;
              }
              for (;;)
              {
                if ((??? == null) || (???.Eby == null) || (???.Eby.ret != 0))
                {
                  if ((??? != null) && (???.Eby != null))
                  {
                    ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.Eby.ret) });
                    AppMethodBeat.o(124257);
                    return;
                    ??? = null;
                    break;
                    paramn = null;
                    continue;
                  }
                  ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                  AppMethodBeat.o(124257);
                  return;
                }
              }
              if (a(???.EtV, paramn.Ebs, false)) {}
              for (paramInt1 = 0;; paramInt1 = -1)
              {
                ??? = (com.tencent.mm.al.o)((y)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.ak.n)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
              }
              localObject1 = (x)paramn;
              if ((((x)localObject1).rr != null) && (((x)localObject1).rr.hvs.hvw != null))
              {
                ??? = (dlg)((x)localObject1).rr.hvs.hvw;
                if ((((x)localObject1).rr == null) || (((x)localObject1).rr.hvr.hvw == null)) {
                  break label3114;
                }
                paramn = (dlf)((x)localObject1).rr.hvr.hvw;
                paramInt1 = 0;
                if ((??? == null) || (???.Eby == null) || (???.Eby.ret != 0) || (???.EIW == null))
                {
                  if ((??? == null) || (???.Eby == null)) {
                    break label3120;
                  }
                  ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.Eby.ret) });
                  paramInt1 = -1;
                }
                if (paramInt1 < 0) {
                  break label3696;
                }
                localObject2 = af.aCY().Bp(???.EIW.Ebl);
                if (localObject2 == null)
                {
                  if (localObject2 != null) {
                    break label3131;
                  }
                  bool1 = true;
                  if (???.EIW != null) {
                    break label3137;
                  }
                  bool2 = true;
                  ac.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null:%s, resp.chat == null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  paramInt1 = -1;
                }
                if ((paramInt1 < 0) || (((((c)localObject2).field_bitFlag == ???.EIW.Ebn) || (!((c)localObject2).aDm())) && (???.EIW.ver <= ((c)localObject2).field_chatVersion))) {
                  break label3143;
                }
                ((c)localObject2).field_chatType = ???.EIW.type;
                ((c)localObject2).field_headImageUrl = ???.EIW.Ebm;
                ((c)localObject2).field_chatName = ???.EIW.name;
                ((c)localObject2).field_chatVersion = ???.EIW.ver;
                ((c)localObject2).field_needToUpdate = false;
                ((c)localObject2).field_bitFlag = ???.EIW.Ebn;
                ((c)localObject2).field_maxMemberCnt = ???.EIW.Ebo;
                ((c)localObject2).field_ownerUserId = ???.EIW.Ebp;
                ((c)localObject2).field_addMemberUrl = ???.EIW.Ebq;
                ((c)localObject2).field_brandUserName = paramn.Ebs;
                af.aCY().b((c)localObject2);
              }
              for (;;)
              {
                ??? = (com.tencent.mm.al.o)((x)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.ak.n)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
                ??? = null;
                break label2739;
                paramn = null;
                break label2777;
                ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
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
                if ((paramn.rr != null) && (paramn.rr.hvs.hvw != null))
                {
                  ??? = (axh)paramn.rr.hvs.hvw;
                  if ((paramn.rr == null) || (paramn.rr.hvr.hvw == null)) {
                    break label3306;
                  }
                  paramn = (axg)paramn.rr.hvr.hvw;
                }
                for (;;)
                {
                  if ((??? == null) || (???.Eby == null) || (???.Eby.ret != 0))
                  {
                    if ((??? != null) && (???.Eby != null))
                    {
                      ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.Eby.ret) });
                      AppMethodBeat.o(124257);
                      return;
                      ??? = null;
                      break;
                      paramn = null;
                      continue;
                    }
                    ac.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.o(124257);
                    return;
                  }
                }
                localObject2 = ???.EPi;
                localObject3 = af.aCY();
                localObject4 = paramn.Ebs;
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
                    localObject4 = af.aCY().Bp((String)localObject4);
                    if (localObject4 != null)
                    {
                      ((c)localObject4).field_bitFlag &= 0xFFFFFFF7;
                      af.aCY().b((c)localObject4);
                    }
                  }
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  if (!((List)localObject1).contains(localObject3))
                  {
                    localObject4 = af.aCY().Bp((String)localObject3);
                    if (localObject4 == null)
                    {
                      localObject4 = new c();
                      ((c)localObject4).field_bizChatServId = ((String)localObject3);
                      ((c)localObject4).field_brandUserName = paramn.Ebs;
                      ((c)localObject4).field_bitFlag |= 0x8;
                      af.aCY().a((c)localObject4);
                    }
                    else
                    {
                      ((c)localObject4).field_bitFlag |= 0x8;
                      af.aCY().b((c)localObject4);
                    }
                  }
                }
                b(???.EPi, paramn.Ebs);
                break;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.h
 * JD-Core Version:    0.7.0.1
 */