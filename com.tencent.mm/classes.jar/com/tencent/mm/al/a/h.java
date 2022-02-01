package com.tencent.mm.al.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.al.ag;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.aye;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements com.tencent.mm.ak.f
{
  private HashSet<a> hUR;
  private HashSet<a> hUS;
  private final Object hUT;
  private com.tencent.mm.b.f<String, Long> hUU;
  private HashSet<a> hUV;
  private HashSet<a> hUW;
  private final Object hUX;
  private com.tencent.mm.b.f<String, Long> hUY;
  
  public h()
  {
    AppMethodBeat.i(124255);
    this.hUR = new HashSet();
    this.hUS = new HashSet();
    this.hUT = new Object();
    this.hUU = new com.tencent.mm.b.h(64);
    this.hUV = new HashSet();
    this.hUW = new HashSet();
    this.hUX = new Object();
    this.hUY = new com.tencent.mm.b.h(64);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1352, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1365, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1353, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1354, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1357, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1356, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1355, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1358, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1367, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1361, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1389, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1315, this);
    AppMethodBeat.o(124255);
  }
  
  public static o a(String paramString, auj paramauj, com.tencent.mm.al.p paramp)
  {
    AppMethodBeat.i(124270);
    paramString = new o(paramString, paramauj, paramp);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
    AppMethodBeat.o(124270);
    return paramString;
  }
  
  public static x a(String paramString, nb paramnb, com.tencent.mm.al.p paramp)
  {
    AppMethodBeat.i(124272);
    paramString = new x(paramString, paramnb, paramp);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
    AppMethodBeat.o(124272);
    return paramString;
  }
  
  public static y a(String paramString1, String paramString2, ne paramne1, ne paramne2, com.tencent.mm.al.p paramp)
  {
    AppMethodBeat.i(124271);
    paramString1 = new y(paramString1, paramString2, paramne1, paramne2, paramp);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString1, 0);
    AppMethodBeat.o(124271);
    return paramString1;
  }
  
  public static void a(String paramString, com.tencent.mm.al.p paramp)
  {
    AppMethodBeat.i(124269);
    paramString = new r(paramString, paramp);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
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
    Object localObject = e.EV(paramString2);
    if ((localObject == null) || (((k)localObject).field_userId.equals(paramString1)))
    {
      a(paramString2, paramp);
      AppMethodBeat.o(124268);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString1);
    paramString1 = new pu();
    paramString1.FZx = paramString2;
    paramString1.Gdt = ((LinkedList)localObject);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = new s(paramString2, paramp);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString1, 0);
    AppMethodBeat.o(124268);
  }
  
  private static boolean a(auj paramauj, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124275);
    ae.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
    if ((paramauj == null) || (paramauj.GLl == null) || (bu.isNullOrNil(paramString)))
    {
      ae.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
      AppMethodBeat.o(124275);
      return false;
    }
    Object localObject1 = ag.aGr().EQ(paramauj.GLl.FZq);
    int i;
    if (localObject1 == null)
    {
      ae.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
      localObject1 = new c();
      ((c)localObject1).field_bizChatServId = paramauj.GLl.FZq;
      ((c)localObject1).field_brandUserName = paramString;
      i = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (paramauj.FZz == null)
      {
        ae.w("MicroMsg.BizChatNetworkMgr", "members==null");
        AppMethodBeat.o(124275);
        return false;
      }
      Object localObject2;
      if ((((c)localObject1).aGF()) || (paramauj.GLl.ver > ((c)localObject1).field_chatVersion))
      {
        ((c)localObject1).field_chatType = paramauj.GLl.type;
        ((c)localObject1).field_headImageUrl = paramauj.GLl.FZr;
        ((c)localObject1).field_chatName = paramauj.GLl.name;
        ((c)localObject1).field_chatVersion = paramauj.GLl.ver;
        ((c)localObject1).field_needToUpdate = false;
        ((c)localObject1).field_bitFlag = paramauj.GLl.FZs;
        ((c)localObject1).field_maxMemberCnt = paramauj.GLl.FZt;
        ((c)localObject1).field_ownerUserId = paramauj.GLl.FZu;
        ((c)localObject1).field_addMemberUrl = paramauj.GLl.FZv;
        ((c)localObject1).field_brandUserName = paramString;
        ((c)localObject1).field_roomflag = paramauj.GLl.FZw;
        paramString = new LinkedList();
        localObject2 = paramauj.FZz.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add(((nd)((Iterator)localObject2).next()).FZy);
        }
        ((c)localObject1).field_userList = bu.m(paramString, ";");
        if (i == 0) {
          break label442;
        }
        ag.aGr().a((c)localObject1);
      }
      long l;
      for (;;)
      {
        e.h((c)localObject1);
        if (!paramBoolean) {
          break label511;
        }
        paramString = new pu();
        paramString.FZx = ((c)localObject1).field_brandUserName;
        localObject1 = new LinkedList();
        paramauj = paramauj.FZz.iterator();
        while (paramauj.hasNext())
        {
          localObject2 = (nd)paramauj.next();
          l = ag.aGt().Fc(((nd)localObject2).FZy);
          if (((nd)localObject2).ver > l) {
            ((LinkedList)localObject1).add(((nd)localObject2).FZy);
          }
        }
        label442:
        ag.aGr().b((c)localObject1);
      }
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString.Gdt = ((LinkedList)localObject1);
        paramauj = new LinkedList();
        paramauj.add(paramString);
        paramauj = new s(paramauj, null);
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramauj, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(124275);
        return true;
        label511:
        paramString = ag.aGt().db;
        l = 0L;
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)paramString).yi(Thread.currentThread().getId());
        }
        paramauj = paramauj.FZz.iterator();
        while (paramauj.hasNext())
        {
          localObject2 = (nd)paramauj.next();
          k localk = ag.aGt().eP(((nd)localObject2).FZy);
          if (localk == null)
          {
            localk = new k();
            localk.field_userId = ((nd)localObject2).FZy;
            localk.field_userName = ((nd)localObject2).oIy;
            localk.field_brandUserName = ((c)localObject1).field_brandUserName;
            localk.field_needToUpdate = true;
            ag.aGt().a(localk);
          }
          else if (((nd)localObject2).ver > localk.field_UserVersion)
          {
            localk.field_needToUpdate = true;
            ag.aGt().b(localk);
          }
        }
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.g.ajR().gDX.sW(l);
        }
      }
      i = 0;
    }
  }
  
  private static boolean a(ni paramni, String paramString)
  {
    AppMethodBeat.i(124274);
    if ((bu.isNullOrNil(paramString)) || (bu.isNullOrNil(paramni.FZy)))
    {
      AppMethodBeat.o(124274);
      return false;
    }
    k localk = new k();
    localk.field_userId = paramni.FZy;
    localk.field_userName = paramni.oIy;
    localk.field_brandUserName = paramString;
    localk.field_headImageUrl = paramni.FZr;
    localk.field_profileUrl = paramni.FZG;
    localk.field_UserVersion = paramni.ver;
    localk.field_addMemberUrl = paramni.FZv;
    if (!ag.aGt().b(localk)) {
      ag.aGt().a(localk);
    }
    paramni = new c();
    paramni.field_bizChatServId = localk.field_userId;
    paramni.field_brandUserName = localk.field_brandUserName;
    paramni.field_chatName = localk.field_userName;
    paramni.field_chatType = j.hVa.hVd;
    if (e.e(paramni) == null)
    {
      AppMethodBeat.o(124274);
      return false;
    }
    AppMethodBeat.o(124274);
    return true;
  }
  
  private void aGH()
  {
    AppMethodBeat.i(124262);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.hUT)
    {
      if (!this.hUS.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      if (this.hUR.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      Iterator localIterator = this.hUR.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        nc localnc = new nc();
        localnc.FZx = a.a(locala);
        localnc.FZq = a.b(locala);
        localLinkedList1.add(localnc);
      }
    }
    if (localLinkedList2.isEmpty())
    {
      AppMethodBeat.o(124262);
      return;
    }
    this.hUS.addAll(this.hUR);
    this.hUR.clear();
    ??? = new q(localLinkedList2);
    com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)???, 0);
    AppMethodBeat.o(124262);
  }
  
  private void aGI()
  {
    AppMethodBeat.i(124266);
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    synchronized (this.hUX)
    {
      if (!this.hUW.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      if (this.hUV.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      localHashMap = new HashMap();
      localObject6 = this.hUV.iterator();
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
        localObject7 = new pu();
        ((pu)localObject7).FZx = ((String)localObject4);
        ((pu)localObject7).Gdt = ((LinkedList)localObject6);
        localLinkedList.add(localObject7);
      }
    }
    this.hUW.addAll(this.hUV);
    this.hUV.clear();
    localObject3 = new s(localLinkedList, null);
    com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject3, 0);
    AppMethodBeat.o(124266);
  }
  
  private void bg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124260);
    long l = System.currentTimeMillis();
    synchronized (this.hUT)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.hUS.contains(paramString2))
      {
        AppMethodBeat.o(124260);
        return;
      }
      this.hUR.add(paramString2);
      this.hUU.put(paramString1, new Long(l));
      aGH();
      AppMethodBeat.o(124260);
      return;
    }
  }
  
  public static void bj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124267);
    paramString1 = new p(paramString1, paramString2);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString1, 0);
    AppMethodBeat.o(124267);
  }
  
  public static void d(com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(124258);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramn);
    AppMethodBeat.o(124258);
  }
  
  public static void l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124273);
    paramString1 = new w(paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString1, 0);
    AppMethodBeat.o(124273);
  }
  
  public final void b(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124261);
    long l = System.currentTimeMillis();
    synchronized (this.hUT)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (!this.hUS.contains(locala))
        {
          this.hUR.add(locala);
          this.hUU.put(str, new Long(l));
        }
      }
    }
    aGH();
    AppMethodBeat.o(124261);
  }
  
  public final void bf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124259);
    Long localLong = (Long)this.hUU.aL(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bg(paramString1, paramString2);
    }
    AppMethodBeat.o(124259);
  }
  
  public final void bh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124263);
    Long localLong = (Long)this.hUY.aL(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bi(paramString1, paramString2);
    }
    AppMethodBeat.o(124263);
  }
  
  public final void bi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124264);
    long l = System.currentTimeMillis();
    synchronized (this.hUX)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.hUW.contains(paramString2))
      {
        AppMethodBeat.o(124264);
        return;
      }
      this.hUV.add(paramString2);
      this.hUY.put(paramString1, new Long(l));
      aGI();
      AppMethodBeat.o(124264);
      return;
    }
  }
  
  public final void c(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124265);
    long l = System.currentTimeMillis();
    synchronized (this.hUX)
    {
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (this.hUW.contains(locala))
        {
          AppMethodBeat.o(124265);
          return;
        }
        this.hUV.add(locala);
        this.hUY.put(str, new Long(l));
      }
    }
    aGI();
    AppMethodBeat.o(124265);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(124256);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1352, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1365, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1353, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1354, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1357, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1356, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1355, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1358, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1367, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1361, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1389, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1315, this);
    super.finalize();
    AppMethodBeat.o(124256);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(124257);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
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
      if ((((p)localObject1).rr != null) && (((p)localObject1).rr.hQE.hQJ != null))
      {
        ??? = (ayc)((p)localObject1).rr.hQE.hQJ;
        if ((((p)localObject1).rr == null) || (((p)localObject1).rr.hQD.hQJ == null)) {
          break label321;
        }
      }
      for (paramn = (ayb)((p)localObject1).rr.hQD.hQJ;; paramn = null)
      {
        bool1 = ((p)localObject1).hVn;
        if ((??? != null) && (???.FZD != null) && (???.FZD.ret == 0)) {
          break label342;
        }
        if ((??? == null) || (???.FZD == null)) {
          break label327;
        }
        ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FZD.ret) });
        AppMethodBeat.o(124257);
        return;
        ??? = null;
        break;
      }
      ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(124257);
      return;
      a(???.GtU, paramn.FZx, bool1);
      AppMethodBeat.o(124257);
      return;
    case 1365: 
      synchronized (this.hUT)
      {
        this.hUS.clear();
        aGH();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      paramn = (q)paramn;
      if ((paramn.rr != null) && (paramn.rr.hQE.hQJ != null)) {
        ??? = (aya)paramn.rr.hQE.hQJ;
      }
      while ((??? == null) || (???.FZD == null) || (???.FZD.ret != 0)) {
        if ((??? != null) && (???.FZD != null))
        {
          ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FZD.ret) });
          AppMethodBeat.o(124257);
          return;
          ??? = null;
        }
        else
        {
          ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          AppMethodBeat.o(124257);
          return;
        }
      }
      ??? = ???.GPb;
      if ((??? == null) || (???.size() == 0))
      {
        ae.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
        AppMethodBeat.o(124257);
        return;
      }
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (auj)((Iterator)localObject1).next();
        ??? = ((auj)localObject2).GLl.FZq;
        if ((??? == null) || (paramn.hVo == null)) {}
        for (??? = null;; ??? = (String)paramn.hVo.get(???))
        {
          a((auj)localObject2, ???, false);
          break;
        }
      }
      AppMethodBeat.o(124257);
      return;
    case 1353: 
      localObject1 = (s)paramn;
      localObject2 = (com.tencent.mm.al.p)((s)localObject1).data;
      if (localObject2 == null) {}
      synchronized (this.hUX)
      {
        this.hUW.clear();
        aGI();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      if ((((s)localObject1).rr != null) && (((s)localObject1).rr.hQE.hQJ != null))
      {
        ??? = (ayg)((s)localObject1).rr.hQE.hQJ;
        paramInt1 = 0;
        if ((??? == null) || (???.FZD == null) || (???.FZD.ret != 0))
        {
          if ((??? == null) || (???.FZD == null)) {
            break label1218;
          }
          ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FZD.ret) });
          label824:
          paramInt1 = -1;
        }
        if ((paramInt1 < 0) || (???.FZE != null)) {
          break label3717;
        }
        ae.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
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
        localObject3 = ag.aGt().db;
        long l = 0L;
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)localObject3).yi(Thread.currentThread().getId());
        }
        paramInt2 = 0;
        if (paramInt2 < ???.FZE.size())
        {
          ae.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[] { ((ni)???.FZE.get(paramInt2)).oIy });
          localObject4 = new k();
          ((k)localObject4).field_userId = ((ni)???.FZE.get(paramInt2)).FZy;
          ((k)localObject4).field_userName = ((ni)???.FZE.get(paramInt2)).oIy;
          paramn = ((k)localObject4).field_userId;
          if ((paramn == null) || (((s)localObject1).hVp == null))
          {
            paramn = null;
            ((k)localObject4).field_brandUserName = paramn;
            ((k)localObject4).field_UserVersion = ((ni)???.FZE.get(paramInt2)).ver;
            ((k)localObject4).field_headImageUrl = ((ni)???.FZE.get(paramInt2)).FZr;
            ((k)localObject4).field_profileUrl = ((ni)???.FZE.get(paramInt2)).FZG;
            ((k)localObject4).field_bitFlag = ((ni)???.FZE.get(paramInt2)).FZs;
            ((k)localObject4).field_addMemberUrl = ((ni)???.FZE.get(paramInt2)).FZv;
            ((k)localObject4).field_needToUpdate = false;
            paramn = ag.aGt().eP(((ni)???.FZE.get(paramInt2)).FZy);
            if (paramn != null) {
              break label1249;
            }
            bool1 = false;
            bool2 = ((k)localObject4).hk(16);
            if (paramn != null) {
              break label1261;
            }
            ag.aGt().a((k)localObject4);
            if (bool1 != bool2)
            {
              paramn = ag.aGr().EQ(((k)localObject4).field_userId);
              if (paramn != null)
              {
                if ((!bool1) || (bool2)) {
                  break label1273;
                }
                ag.aGs().sk(paramn.field_bizChatLocalId);
              }
            }
          }
          for (;;)
          {
            paramInt2 += 1;
            break label888;
            ??? = null;
            break;
            ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label824;
            paramn = (String)((s)localObject1).hVp.get(paramn);
            break label998;
            bool1 = paramn.hk(16);
            break label1136;
            ag.aGt().b((k)localObject4);
            break label1159;
            label1273:
            if ((!bool1) && (bool2)) {
              ag.aGs().sj(paramn.field_bizChatLocalId);
            }
          }
        }
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.g.ajR().gDX.sW(l);
        }
      }
      if (localObject2 != null) {
        ((com.tencent.mm.al.p)localObject2).a(paramInt1, (com.tencent.mm.ak.n)localObject1);
      }
      AppMethodBeat.o(124257);
      return;
      localObject1 = (r)paramn;
      if ((((r)localObject1).rr != null) && (((r)localObject1).rr.hQE.hQJ != null))
      {
        ??? = (aye)((r)localObject1).rr.hQE.hQJ;
        if (((r)localObject1).rr != null) {
          break label1530;
        }
        paramn = null;
        label1395:
        if ((??? != null) && (???.FZD != null) && (???.FZD.ret == 0)) {
          break label3712;
        }
        if ((??? == null) || (???.FZD == null)) {
          break label1549;
        }
        ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FZD.ret) });
      }
      label2032:
      label2416:
      label3696:
      for (paramInt1 = -1;; paramInt1 = 0)
      {
        if (paramInt1 >= 0)
        {
          localObject2 = ag.aGt();
          paramn = paramn.FZx;
          ??? = ???.FZA;
          if ((??? == null) || (bu.isNullOrNil(paramn))) {
            ae.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
          }
        }
        else
        {
          ??? = (com.tencent.mm.al.p)((r)localObject1).data;
          if (??? != null) {
            ???.a(paramInt1, (com.tencent.mm.ak.n)localObject1);
          }
          AppMethodBeat.o(124257);
          return;
          ??? = null;
          break label1384;
          label1530:
          paramn = (ayd)((r)localObject1).rr.hQD.hQJ;
          break label1395;
          ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1452;
        }
        ae.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[] { paramn, ???.FZy, Boolean.valueOf(bu.isNullOrNil(???.FZv)) });
        localObject3 = ag.aGu().Fa(paramn);
        if (localObject3 == null)
        {
          localObject3 = new f();
          ((f)localObject3).field_brandUserName = paramn;
          ((f)localObject3).field_userId = ???.FZy;
          ag.aGu().a((f)localObject3);
        }
        for (;;)
        {
          localObject3 = new k();
          ((k)localObject3).field_userId = ???.FZy;
          ((k)localObject3).field_userName = ???.oIy;
          ((k)localObject3).field_brandUserName = paramn;
          ((k)localObject3).field_UserVersion = ???.ver;
          ((k)localObject3).field_headImageUrl = ???.FZr;
          ((k)localObject3).field_profileUrl = ???.FZG;
          ((k)localObject3).field_bitFlag = ???.FZs;
          ((k)localObject3).field_needToUpdate = false;
          ((k)localObject3).field_addMemberUrl = ???.FZv;
          if (!((l)localObject2).b((k)localObject3)) {
            ((l)localObject2).a((k)localObject3);
          }
          ((l)localObject2).hUt.put(paramn, ((k)localObject3).field_userId);
          break;
          ((f)localObject3).field_userId = ???.FZy;
          ag.aGu().b((f)localObject3);
          ae.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
        }
        ??? = (o)paramn;
        paramn = ???.aGK();
        localObject1 = ???.aGL();
        paramInt1 = 0;
        if ((paramn == null) || (paramn.FZD == null) || (paramn.FZD.ret != 0))
        {
          if ((paramn != null) && (paramn.FZD != null))
          {
            ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.FZD.ret) });
            paramInt1 = -1;
          }
        }
        else
        {
          if (paramInt1 < 0) {
            break label3709;
          }
          if (!a(paramn.GtU, ((abz)localObject1).FZx, true)) {
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
          paramn = (com.tencent.mm.al.p)???.data;
          if (paramn != null) {
            paramn.a(paramInt1, ???);
          }
          AppMethodBeat.o(124257);
          return;
          ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1884;
          paramInt1 = -1;
          continue;
          ??? = (u)paramn;
          paramn = ???.aGM();
          paramInt1 = 0;
          if ((paramn == null) || (paramn.FZD == null) || (paramn.FZD.ret != 0))
          {
            if ((paramn != null) && (paramn.FZD != null))
            {
              ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.FZD.ret) });
              paramInt1 = -1;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            if (paramInt1 >= 0)
            {
              paramInt2 = paramInt1;
              if (paramn.GtK == null)
              {
                paramInt2 = paramInt1;
                if (paramn.GtJ == null) {
                  paramInt2 = -1;
                }
              }
            }
            if (paramInt2 < 0) {
              break label3704;
            }
            if (paramn.GtK == null) {
              break label2162;
            }
            bool2 = a(paramn.GtK, paramn.FZx);
            bool1 = bool2;
            if (bool2)
            {
              ???.hVm = paramn.GtK.FZy;
              bool1 = bool2;
            }
            if (bool1) {
              break label3704;
            }
          }
          for (paramInt1 = -1;; paramInt1 = paramInt2)
          {
            paramn = (com.tencent.mm.al.p)???.data;
            if (paramn != null) {
              paramn.a(paramInt1, ???);
            }
            AppMethodBeat.o(124257);
            return;
            ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label2032;
            bool2 = a(paramn.GtJ, paramn.FZx, true);
            bool1 = bool2;
            if (!bool2) {
              break label2114;
            }
            ???.hVm = paramn.GtJ.GLl.FZq;
            bool1 = bool2;
            break label2114;
            ??? = (n)paramn;
            paramn = ???.aGJ();
            paramInt1 = 0;
            if ((paramn == null) || (paramn.FZD == null) || (paramn.FZD.ret != 0))
            {
              if ((paramn != null) && (paramn.FZD != null))
              {
                ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramn.FZD.ret) });
                paramInt1 = -1;
              }
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 >= 0)
              {
                paramInt2 = paramInt1;
                if (paramn.GtK == null)
                {
                  paramInt2 = paramInt1;
                  if (paramn.GtJ == null) {
                    paramInt2 = -1;
                  }
                }
              }
              if (paramInt2 < 0) {
                break label3699;
              }
              if (paramn.GtK == null) {
                break label2416;
              }
              bool2 = a(paramn.GtK, paramn.FZx);
              bool1 = bool2;
              if (bool2)
              {
                ???.hVm = paramn.GtK.FZy;
                bool1 = bool2;
              }
              if (bool1) {
                break label3699;
              }
            }
            for (paramInt1 = -1;; paramInt1 = paramInt2)
            {
              paramn = (com.tencent.mm.al.p)???.data;
              if (paramn != null) {
                paramn.a(paramInt1, ???);
              }
              AppMethodBeat.o(124257);
              return;
              ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label2286;
              bool2 = a(paramn.GtJ, paramn.FZx, true);
              bool1 = bool2;
              if (!bool2) {
                break label2368;
              }
              ???.hVm = paramn.GtJ.GLl.FZq;
              bool1 = bool2;
              break label2368;
              ae.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
              localObject1 = (y)paramn;
              if ((((y)localObject1).rr != null) && (((y)localObject1).rr.hQE.hQJ != null))
              {
                ??? = (drs)((y)localObject1).rr.hQE.hQJ;
                if ((((y)localObject1).rr == null) || (((y)localObject1).rr.hQD.hQJ == null)) {
                  break label2622;
                }
                paramn = (drr)((y)localObject1).rr.hQD.hQJ;
              }
              for (;;)
              {
                if ((??? == null) || (???.FZD == null) || (???.FZD.ret != 0))
                {
                  if ((??? != null) && (???.FZD != null))
                  {
                    ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FZD.ret) });
                    AppMethodBeat.o(124257);
                    return;
                    ??? = null;
                    break;
                    paramn = null;
                    continue;
                  }
                  ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                  AppMethodBeat.o(124257);
                  return;
                }
              }
              if (a(???.GtU, paramn.FZx, false)) {}
              for (paramInt1 = 0;; paramInt1 = -1)
              {
                ??? = (com.tencent.mm.al.p)((y)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.ak.n)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
              }
              localObject1 = (x)paramn;
              if ((((x)localObject1).rr != null) && (((x)localObject1).rr.hQE.hQJ != null))
              {
                ??? = (dru)((x)localObject1).rr.hQE.hQJ;
                if ((((x)localObject1).rr == null) || (((x)localObject1).rr.hQD.hQJ == null)) {
                  break label3114;
                }
                paramn = (drt)((x)localObject1).rr.hQD.hQJ;
                paramInt1 = 0;
                if ((??? == null) || (???.FZD == null) || (???.FZD.ret != 0) || (???.GLl == null))
                {
                  if ((??? == null) || (???.FZD == null)) {
                    break label3120;
                  }
                  ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FZD.ret) });
                  paramInt1 = -1;
                }
                if (paramInt1 < 0) {
                  break label3696;
                }
                localObject2 = ag.aGr().EQ(???.GLl.FZq);
                if (localObject2 == null)
                {
                  if (localObject2 != null) {
                    break label3131;
                  }
                  bool1 = true;
                  if (???.GLl != null) {
                    break label3137;
                  }
                  bool2 = true;
                  ae.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null:%s, resp.chat == null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  paramInt1 = -1;
                }
                if ((paramInt1 < 0) || (((((c)localObject2).field_bitFlag == ???.GLl.FZs) || (!((c)localObject2).aGF())) && (???.GLl.ver <= ((c)localObject2).field_chatVersion))) {
                  break label3143;
                }
                ((c)localObject2).field_chatType = ???.GLl.type;
                ((c)localObject2).field_headImageUrl = ???.GLl.FZr;
                ((c)localObject2).field_chatName = ???.GLl.name;
                ((c)localObject2).field_chatVersion = ???.GLl.ver;
                ((c)localObject2).field_needToUpdate = false;
                ((c)localObject2).field_bitFlag = ???.GLl.FZs;
                ((c)localObject2).field_maxMemberCnt = ???.GLl.FZt;
                ((c)localObject2).field_ownerUserId = ???.GLl.FZu;
                ((c)localObject2).field_addMemberUrl = ???.GLl.FZv;
                ((c)localObject2).field_brandUserName = paramn.FZx;
                ag.aGr().b((c)localObject2);
              }
              for (;;)
              {
                ??? = (com.tencent.mm.al.p)((x)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.ak.n)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
                ??? = null;
                break label2739;
                paramn = null;
                break label2777;
                ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
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
                if ((paramn.rr != null) && (paramn.rr.hQE.hQJ != null))
                {
                  ??? = (bbz)paramn.rr.hQE.hQJ;
                  if ((paramn.rr == null) || (paramn.rr.hQD.hQJ == null)) {
                    break label3306;
                  }
                  paramn = (bby)paramn.rr.hQD.hQJ;
                }
                for (;;)
                {
                  if ((??? == null) || (???.FZD == null) || (???.FZD.ret != 0))
                  {
                    if ((??? != null) && (???.FZD != null))
                    {
                      ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.FZD.ret) });
                      AppMethodBeat.o(124257);
                      return;
                      ??? = null;
                      break;
                      paramn = null;
                      continue;
                    }
                    ae.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.o(124257);
                    return;
                  }
                }
                localObject2 = ???.GRT;
                localObject3 = ag.aGr();
                localObject4 = paramn.FZx;
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
                    localObject4 = ag.aGr().EQ((String)localObject4);
                    if (localObject4 != null)
                    {
                      ((c)localObject4).field_bitFlag &= 0xFFFFFFF7;
                      ag.aGr().b((c)localObject4);
                    }
                  }
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  if (!((List)localObject1).contains(localObject3))
                  {
                    localObject4 = ag.aGr().EQ((String)localObject3);
                    if (localObject4 == null)
                    {
                      localObject4 = new c();
                      ((c)localObject4).field_bizChatServId = ((String)localObject3);
                      ((c)localObject4).field_brandUserName = paramn.FZx;
                      ((c)localObject4).field_bitFlag |= 0x8;
                      ag.aGr().a((c)localObject4);
                    }
                    else
                    {
                      ((c)localObject4).field_bitFlag |= 0x8;
                      ag.aGr().b((c)localObject4);
                    }
                  }
                }
                b(???.GRT, paramn.FZx);
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
    private String dCn;
    private String id;
    
    public a(String paramString1, String paramString2)
    {
      this.dCn = paramString1;
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
      if (((this.dCn == null) && (paramObject.dCn == null)) || ((this.dCn != null) && (this.dCn.equals(paramObject.dCn)) && (((this.id == null) && (paramObject.id == null)) || ((this.id != null) && (this.id.equals(paramObject.id))))))
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
      int i = this.dCn.hashCode();
      int j = this.id.hashCode();
      AppMethodBeat.o(124254);
      return i + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.h
 * JD-Core Version:    0.7.0.1
 */