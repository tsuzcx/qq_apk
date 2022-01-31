package com.tencent.mm.aj.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.aj.z;
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.protocal.protobuf.kq;
import com.tencent.mm.protocal.protobuf.kr;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements com.tencent.mm.ai.f
{
  private HashSet<h.a> fxP;
  private HashSet<h.a> fxQ;
  private final Object fxR;
  private com.tencent.mm.a.f<String, Long> fxS;
  private HashSet<h.a> fxT;
  private HashSet<h.a> fxU;
  private final Object fxV;
  private com.tencent.mm.a.f<String, Long> fxW;
  
  public h()
  {
    AppMethodBeat.i(11569);
    this.fxP = new HashSet();
    this.fxQ = new HashSet();
    this.fxR = new Object();
    this.fxS = new com.tencent.mm.a.h(64);
    this.fxT = new HashSet();
    this.fxU = new HashSet();
    this.fxV = new Object();
    this.fxW = new com.tencent.mm.a.h(64);
    com.tencent.mm.kernel.g.RK().eHt.a(1352, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1365, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1353, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1354, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1357, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1356, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1355, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1358, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1367, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1361, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1389, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1315, this);
    AppMethodBeat.o(11569);
  }
  
  public static n a(String paramString, aeh paramaeh, com.tencent.mm.aj.n paramn)
  {
    AppMethodBeat.i(11584);
    paramString = new n(paramString, paramaeh, paramn);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
    AppMethodBeat.o(11584);
    return paramString;
  }
  
  public static w a(String paramString, kp paramkp, com.tencent.mm.aj.n paramn)
  {
    AppMethodBeat.i(11586);
    paramString = new w(paramString, paramkp, paramn);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
    AppMethodBeat.o(11586);
    return paramString;
  }
  
  public static x a(String paramString1, String paramString2, ks paramks1, ks paramks2, com.tencent.mm.aj.n paramn)
  {
    AppMethodBeat.i(11585);
    paramString1 = new x(paramString1, paramString2, paramks1, paramks2, paramn);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString1, 0);
    AppMethodBeat.o(11585);
    return paramString1;
  }
  
  public static void a(String paramString, com.tencent.mm.aj.n paramn)
  {
    AppMethodBeat.i(11583);
    paramString = new q(paramString, paramn);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
    AppMethodBeat.o(11583);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.aj.n paramn)
  {
    AppMethodBeat.i(11582);
    if (paramn == null)
    {
      AppMethodBeat.o(11582);
      return;
    }
    Object localObject = e.sq(paramString2);
    if ((localObject == null) || (((j)localObject).field_userId.equals(paramString1)))
    {
      a(paramString2, paramn);
      AppMethodBeat.o(11582);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString1);
    paramString1 = new md();
    paramString1.wyh = paramString2;
    paramString1.wAF = ((LinkedList)localObject);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = new r(paramString2, paramn);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString1, 0);
    AppMethodBeat.o(11582);
  }
  
  private static boolean a(aeh paramaeh, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(11589);
    ab.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
    if ((paramaeh == null) || (paramaeh.wXl == null) || (bo.isNullOrNil(paramString)))
    {
      ab.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
      AppMethodBeat.o(11589);
      return false;
    }
    Object localObject1 = z.afk().sl(paramaeh.wXl.wyb);
    int i;
    if (localObject1 == null)
    {
      ab.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
      localObject1 = new c();
      ((c)localObject1).field_bizChatServId = paramaeh.wXl.wyb;
      ((c)localObject1).field_brandUserName = paramString;
      i = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (paramaeh.wyj == null)
      {
        ab.w("MicroMsg.BizChatNetworkMgr", "members==null");
        AppMethodBeat.o(11589);
        return false;
      }
      Object localObject2;
      if ((((c)localObject1).afy()) || (paramaeh.wXl.ver > ((c)localObject1).field_chatVersion))
      {
        ((c)localObject1).field_chatType = paramaeh.wXl.type;
        ((c)localObject1).field_headImageUrl = paramaeh.wXl.wyc;
        ((c)localObject1).field_chatName = paramaeh.wXl.name;
        ((c)localObject1).field_chatVersion = paramaeh.wXl.ver;
        ((c)localObject1).field_needToUpdate = false;
        ((c)localObject1).field_bitFlag = paramaeh.wXl.wyd;
        ((c)localObject1).field_maxMemberCnt = paramaeh.wXl.wye;
        ((c)localObject1).field_ownerUserId = paramaeh.wXl.wyf;
        ((c)localObject1).field_addMemberUrl = paramaeh.wXl.wyg;
        ((c)localObject1).field_brandUserName = paramString;
        paramString = new LinkedList();
        localObject2 = paramaeh.wyj.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add(((kr)((Iterator)localObject2).next()).wyi);
        }
        ((c)localObject1).field_userList = bo.d(paramString, ";");
        if (i == 0) {
          break label433;
        }
        z.afk().a((c)localObject1);
      }
      long l;
      for (;;)
      {
        e.h((c)localObject1);
        if (!paramBoolean) {
          break label503;
        }
        paramString = new md();
        paramString.wyh = ((c)localObject1).field_brandUserName;
        localObject1 = new LinkedList();
        paramaeh = paramaeh.wyj.iterator();
        while (paramaeh.hasNext())
        {
          localObject2 = (kr)paramaeh.next();
          l = z.afm().sx(((kr)localObject2).wyi);
          if (((kr)localObject2).ver > l) {
            ((LinkedList)localObject1).add(((kr)localObject2).wyi);
          }
        }
        label433:
        z.afk().b((c)localObject1);
      }
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString.wAF = ((LinkedList)localObject1);
        paramaeh = new LinkedList();
        paramaeh.add(paramString);
        paramaeh = new r(paramaeh, null);
        com.tencent.mm.kernel.g.RK().eHt.a(paramaeh, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(11589);
        return true;
        label503:
        paramString = z.afm().db;
        l = 0L;
        if ((paramString instanceof com.tencent.mm.cg.h)) {
          l = ((com.tencent.mm.cg.h)paramString).kr(Thread.currentThread().getId());
        }
        paramaeh = paramaeh.wyj.iterator();
        while (paramaeh.hasNext())
        {
          localObject2 = (kr)paramaeh.next();
          j localj = z.afm().df(((kr)localObject2).wyi);
          if (localj == null)
          {
            localj = new j();
            localj.field_userId = ((kr)localObject2).wyi;
            localj.field_userName = ((kr)localObject2).kqi;
            localj.field_brandUserName = ((c)localObject1).field_brandUserName;
            localj.field_needToUpdate = true;
            z.afm().a(localj);
          }
          else if (((kr)localObject2).ver > localj.field_UserVersion)
          {
            localj.field_needToUpdate = true;
            z.afm().b(localj);
          }
        }
        if ((paramString instanceof com.tencent.mm.cg.h)) {
          com.tencent.mm.kernel.g.RL().eHS.nY(l);
        }
      }
      i = 0;
    }
  }
  
  private static boolean a(kw paramkw, String paramString)
  {
    AppMethodBeat.i(11588);
    if ((bo.isNullOrNil(paramString)) || (bo.isNullOrNil(paramkw.wyi)))
    {
      AppMethodBeat.o(11588);
      return false;
    }
    j localj = new j();
    localj.field_userId = paramkw.wyi;
    localj.field_userName = paramkw.kqi;
    localj.field_brandUserName = paramString;
    localj.field_headImageUrl = paramkw.wyc;
    localj.field_profileUrl = paramkw.wyq;
    localj.field_UserVersion = paramkw.ver;
    localj.field_addMemberUrl = paramkw.wyg;
    if (!z.afm().b(localj)) {
      z.afm().a(localj);
    }
    paramkw = new c();
    paramkw.field_bizChatServId = localj.field_userId;
    paramkw.field_brandUserName = localj.field_brandUserName;
    paramkw.field_chatName = localj.field_userName;
    paramkw.field_chatType = 1;
    if (e.e(paramkw) == null)
    {
      AppMethodBeat.o(11588);
      return false;
    }
    AppMethodBeat.o(11588);
    return true;
  }
  
  private void aI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11574);
    long l = System.currentTimeMillis();
    synchronized (this.fxR)
    {
      paramString2 = new h.a(paramString2, paramString1);
      if (this.fxQ.contains(paramString2))
      {
        AppMethodBeat.o(11574);
        return;
      }
      this.fxP.add(paramString2);
      this.fxS.put(paramString1, new Long(l));
      afA();
      AppMethodBeat.o(11574);
      return;
    }
  }
  
  public static void aL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11581);
    paramString1 = new o(paramString1, paramString2);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString1, 0);
    AppMethodBeat.o(11581);
  }
  
  private void afA()
  {
    AppMethodBeat.i(11576);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.fxR)
    {
      if (!this.fxQ.isEmpty())
      {
        AppMethodBeat.o(11576);
        return;
      }
      if (this.fxP.isEmpty())
      {
        AppMethodBeat.o(11576);
        return;
      }
      Iterator localIterator = this.fxP.iterator();
      if (localIterator.hasNext())
      {
        h.a locala = (h.a)localIterator.next();
        kq localkq = new kq();
        localkq.wyh = h.a.a(locala);
        localkq.wyb = h.a.b(locala);
        localLinkedList1.add(localkq);
      }
    }
    if (localLinkedList2.isEmpty())
    {
      AppMethodBeat.o(11576);
      return;
    }
    this.fxQ.addAll(this.fxP);
    this.fxP.clear();
    ??? = new p(localLinkedList2);
    com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)???, 0);
    AppMethodBeat.o(11576);
  }
  
  private void afB()
  {
    AppMethodBeat.i(11580);
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    synchronized (this.fxV)
    {
      if (!this.fxU.isEmpty())
      {
        AppMethodBeat.o(11580);
        return;
      }
      if (this.fxT.isEmpty())
      {
        AppMethodBeat.o(11580);
        return;
      }
      localHashMap = new HashMap();
      localObject6 = this.fxT.iterator();
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
        localObject7 = new md();
        ((md)localObject7).wyh = ((String)localObject4);
        ((md)localObject7).wAF = ((LinkedList)localObject6);
        localLinkedList.add(localObject7);
      }
    }
    this.fxU.addAll(this.fxT);
    this.fxT.clear();
    localObject3 = new r(localLinkedList, null);
    com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject3, 0);
    AppMethodBeat.o(11580);
  }
  
  public static void d(com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(11572);
    com.tencent.mm.kernel.g.RK().eHt.a(paramm);
    AppMethodBeat.o(11572);
  }
  
  public static void h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(11587);
    paramString1 = new v(paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString1, 0);
    AppMethodBeat.o(11587);
  }
  
  public final void a(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(11575);
    long l = System.currentTimeMillis();
    synchronized (this.fxR)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        h.a locala = new h.a(paramString, str);
        if (!this.fxQ.contains(locala))
        {
          this.fxP.add(locala);
          this.fxS.put(str, new Long(l));
        }
      }
    }
    afA();
    AppMethodBeat.o(11575);
  }
  
  public final void aH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11573);
    Long localLong = (Long)this.fxS.Y(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      aI(paramString1, paramString2);
    }
    AppMethodBeat.o(11573);
  }
  
  public final void aJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11577);
    Long localLong = (Long)this.fxW.Y(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      aK(paramString1, paramString2);
    }
    AppMethodBeat.o(11577);
  }
  
  public final void aK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11578);
    long l = System.currentTimeMillis();
    synchronized (this.fxV)
    {
      paramString2 = new h.a(paramString2, paramString1);
      if (this.fxU.contains(paramString2))
      {
        AppMethodBeat.o(11578);
        return;
      }
      this.fxT.add(paramString2);
      this.fxW.put(paramString1, new Long(l));
      afB();
      AppMethodBeat.o(11578);
      return;
    }
  }
  
  public final void b(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(11579);
    long l = System.currentTimeMillis();
    synchronized (this.fxV)
    {
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        h.a locala = new h.a(paramString, str);
        if (this.fxU.contains(locala))
        {
          AppMethodBeat.o(11579);
          return;
        }
        this.fxT.add(locala);
        this.fxW.put(str, new Long(l));
      }
    }
    afB();
    AppMethodBeat.o(11579);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(11570);
    com.tencent.mm.kernel.g.RK().eHt.b(1352, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1365, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1353, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1354, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1357, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1356, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1355, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1358, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1367, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1361, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1389, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1315, this);
    super.finalize();
    AppMethodBeat.o(11570);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(11571);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
      if ((paramm.getType() != 1365) && (paramm.getType() != 1353))
      {
        AppMethodBeat.o(11571);
        return;
      }
    }
    Object localObject1;
    boolean bool1;
    label321:
    label327:
    label342:
    Object localObject2;
    switch (paramm.getType())
    {
    default: 
      AppMethodBeat.o(11571);
      return;
    case 1352: 
      localObject1 = (o)paramm;
      if ((((o)localObject1).rr != null) && (((o)localObject1).rr.fsW.fta != null))
      {
        ??? = (ahd)((o)localObject1).rr.fsW.fta;
        if ((((o)localObject1).rr == null) || (((o)localObject1).rr.fsV.fta == null)) {
          break label321;
        }
      }
      for (paramm = (ahc)((o)localObject1).rr.fsV.fta;; paramm = null)
      {
        bool1 = ((o)localObject1).fyf;
        if ((??? != null) && (???.wyn != null) && (???.wyn.ret == 0)) {
          break label342;
        }
        if ((??? == null) || (???.wyn == null)) {
          break label327;
        }
        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.wyn.ret) });
        AppMethodBeat.o(11571);
        return;
        ??? = null;
        break;
      }
      ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(11571);
      return;
      a(???.wOs, paramm.wyh, bool1);
      AppMethodBeat.o(11571);
      return;
    case 1365: 
      synchronized (this.fxR)
      {
        this.fxQ.clear();
        afA();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(11571);
          return;
        }
      }
      paramm = (p)paramm;
      if ((paramm.rr != null) && (paramm.rr.fsW.fta != null)) {
        ??? = (ahb)paramm.rr.fsW.fta;
      }
      while ((??? == null) || (???.wyn == null) || (???.wyn.ret != 0)) {
        if ((??? != null) && (???.wyn != null))
        {
          ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.wyn.ret) });
          AppMethodBeat.o(11571);
          return;
          ??? = null;
        }
        else
        {
          ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          AppMethodBeat.o(11571);
          return;
        }
      }
      ??? = ???.wZH;
      if ((??? == null) || (???.size() == 0))
      {
        ab.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
        AppMethodBeat.o(11571);
        return;
      }
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aeh)((Iterator)localObject1).next();
        ??? = ((aeh)localObject2).wXl.wyb;
        if ((??? == null) || (paramm.fyg == null)) {}
        for (??? = null;; ??? = (String)paramm.fyg.get(???))
        {
          a((aeh)localObject2, ???, false);
          break;
        }
      }
      AppMethodBeat.o(11571);
      return;
    case 1353: 
      localObject1 = (r)paramm;
      localObject2 = (com.tencent.mm.aj.n)((r)localObject1).data;
      if (localObject2 == null) {}
      synchronized (this.fxV)
      {
        this.fxU.clear();
        afB();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(11571);
          return;
        }
      }
      if ((((r)localObject1).rr != null) && (((r)localObject1).rr.fsW.fta != null))
      {
        ??? = (ahh)((r)localObject1).rr.fsW.fta;
        paramInt1 = 0;
        if ((??? == null) || (???.wyn == null) || (???.wyn.ret != 0))
        {
          if ((??? == null) || (???.wyn == null)) {
            break label1218;
          }
          ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.wyn.ret) });
          label824:
          paramInt1 = -1;
        }
        if ((paramInt1 < 0) || (???.wyo != null)) {
          break label3717;
        }
        ab.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
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
        localObject3 = z.afm().db;
        long l = 0L;
        if ((localObject3 instanceof com.tencent.mm.cg.h)) {
          l = ((com.tencent.mm.cg.h)localObject3).kr(Thread.currentThread().getId());
        }
        paramInt2 = 0;
        if (paramInt2 < ???.wyo.size())
        {
          ab.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[] { ((kw)???.wyo.get(paramInt2)).kqi });
          localObject4 = new j();
          ((j)localObject4).field_userId = ((kw)???.wyo.get(paramInt2)).wyi;
          ((j)localObject4).field_userName = ((kw)???.wyo.get(paramInt2)).kqi;
          paramm = ((j)localObject4).field_userId;
          if ((paramm == null) || (((r)localObject1).fyh == null))
          {
            paramm = null;
            ((j)localObject4).field_brandUserName = paramm;
            ((j)localObject4).field_UserVersion = ((kw)???.wyo.get(paramInt2)).ver;
            ((j)localObject4).field_headImageUrl = ((kw)???.wyo.get(paramInt2)).wyc;
            ((j)localObject4).field_profileUrl = ((kw)???.wyo.get(paramInt2)).wyq;
            ((j)localObject4).field_bitFlag = ((kw)???.wyo.get(paramInt2)).wyd;
            ((j)localObject4).field_addMemberUrl = ((kw)???.wyo.get(paramInt2)).wyg;
            ((j)localObject4).field_needToUpdate = false;
            paramm = z.afm().df(((kw)???.wyo.get(paramInt2)).wyi);
            if (paramm != null) {
              break label1249;
            }
            bool1 = false;
            bool2 = ((j)localObject4).kY(16);
            if (paramm != null) {
              break label1261;
            }
            z.afm().a((j)localObject4);
            if (bool1 != bool2)
            {
              paramm = z.afk().sl(((j)localObject4).field_userId);
              if (paramm != null)
              {
                if ((!bool1) || (bool2)) {
                  break label1273;
                }
                z.afl().gK(paramm.field_bizChatLocalId);
              }
            }
          }
          for (;;)
          {
            paramInt2 += 1;
            break label888;
            ??? = null;
            break;
            ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label824;
            paramm = (String)((r)localObject1).fyh.get(paramm);
            break label998;
            bool1 = paramm.kY(16);
            break label1136;
            z.afm().b((j)localObject4);
            break label1159;
            label1273:
            if ((!bool1) && (bool2)) {
              z.afl().gJ(paramm.field_bizChatLocalId);
            }
          }
        }
        if ((localObject3 instanceof com.tencent.mm.cg.h)) {
          com.tencent.mm.kernel.g.RL().eHS.nY(l);
        }
      }
      if (localObject2 != null) {
        ((com.tencent.mm.aj.n)localObject2).a(paramInt1, (com.tencent.mm.ai.m)localObject1);
      }
      AppMethodBeat.o(11571);
      return;
      localObject1 = (q)paramm;
      if ((((q)localObject1).rr != null) && (((q)localObject1).rr.fsW.fta != null))
      {
        ??? = (ahf)((q)localObject1).rr.fsW.fta;
        if (((q)localObject1).rr != null) {
          break label1530;
        }
        paramm = null;
        label1395:
        if ((??? != null) && (???.wyn != null) && (???.wyn.ret == 0)) {
          break label3712;
        }
        if ((??? == null) || (???.wyn == null)) {
          break label1549;
        }
        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.wyn.ret) });
      }
      label2032:
      label2416:
      label3696:
      for (paramInt1 = -1;; paramInt1 = 0)
      {
        if (paramInt1 >= 0)
        {
          localObject2 = z.afm();
          paramm = paramm.wyh;
          ??? = ???.wyk;
          if ((??? == null) || (bo.isNullOrNil(paramm))) {
            ab.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
          }
        }
        else
        {
          ??? = (com.tencent.mm.aj.n)((q)localObject1).data;
          if (??? != null) {
            ???.a(paramInt1, (com.tencent.mm.ai.m)localObject1);
          }
          AppMethodBeat.o(11571);
          return;
          ??? = null;
          break label1384;
          label1530:
          paramm = (ahe)((q)localObject1).rr.fsV.fta;
          break label1395;
          ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1452;
        }
        ab.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[] { paramm, ???.wyi, Boolean.valueOf(bo.isNullOrNil(???.wyg)) });
        localObject3 = z.afn().sv(paramm);
        if (localObject3 == null)
        {
          localObject3 = new f();
          ((f)localObject3).field_brandUserName = paramm;
          ((f)localObject3).field_userId = ???.wyi;
          z.afn().a((f)localObject3);
        }
        for (;;)
        {
          localObject3 = new j();
          ((j)localObject3).field_userId = ???.wyi;
          ((j)localObject3).field_userName = ???.kqi;
          ((j)localObject3).field_brandUserName = paramm;
          ((j)localObject3).field_UserVersion = ???.ver;
          ((j)localObject3).field_headImageUrl = ???.wyc;
          ((j)localObject3).field_profileUrl = ???.wyq;
          ((j)localObject3).field_bitFlag = ???.wyd;
          ((j)localObject3).field_needToUpdate = false;
          ((j)localObject3).field_addMemberUrl = ???.wyg;
          if (!((k)localObject2).b((j)localObject3)) {
            ((k)localObject2).a((j)localObject3);
          }
          ((k)localObject2).fxs.put(paramm, ((j)localObject3).field_userId);
          break;
          ((f)localObject3).field_userId = ???.wyi;
          z.afn().b((f)localObject3);
          ab.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
        }
        ??? = (n)paramm;
        paramm = ???.afD();
        localObject1 = ???.afE();
        paramInt1 = 0;
        if ((paramm == null) || (paramm.wyn == null) || (paramm.wyn.ret != 0))
        {
          if ((paramm != null) && (paramm.wyn != null))
          {
            ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramm.wyn.ret) });
            paramInt1 = -1;
          }
        }
        else
        {
          if (paramInt1 < 0) {
            break label3709;
          }
          if (!a(paramm.wOs, ((vr)localObject1).wyh, true)) {
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
          paramm = (com.tencent.mm.aj.n)???.data;
          if (paramm != null) {
            paramm.a(paramInt1, ???);
          }
          AppMethodBeat.o(11571);
          return;
          ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1884;
          paramInt1 = -1;
          continue;
          ??? = (t)paramm;
          paramm = ???.afF();
          paramInt1 = 0;
          if ((paramm == null) || (paramm.wyn == null) || (paramm.wyn.ret != 0))
          {
            if ((paramm != null) && (paramm.wyn != null))
            {
              ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramm.wyn.ret) });
              paramInt1 = -1;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            if (paramInt1 >= 0)
            {
              paramInt2 = paramInt1;
              if (paramm.wOk == null)
              {
                paramInt2 = paramInt1;
                if (paramm.wOj == null) {
                  paramInt2 = -1;
                }
              }
            }
            if (paramInt2 < 0) {
              break label3704;
            }
            if (paramm.wOk == null) {
              break label2162;
            }
            bool2 = a(paramm.wOk, paramm.wyh);
            bool1 = bool2;
            if (bool2)
            {
              ???.fye = paramm.wOk.wyi;
              bool1 = bool2;
            }
            if (bool1) {
              break label3704;
            }
          }
          for (paramInt1 = -1;; paramInt1 = paramInt2)
          {
            paramm = (com.tencent.mm.aj.n)???.data;
            if (paramm != null) {
              paramm.a(paramInt1, ???);
            }
            AppMethodBeat.o(11571);
            return;
            ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label2032;
            bool2 = a(paramm.wOj, paramm.wyh, true);
            bool1 = bool2;
            if (!bool2) {
              break label2114;
            }
            ???.fye = paramm.wOj.wXl.wyb;
            bool1 = bool2;
            break label2114;
            ??? = (m)paramm;
            paramm = ???.afC();
            paramInt1 = 0;
            if ((paramm == null) || (paramm.wyn == null) || (paramm.wyn.ret != 0))
            {
              if ((paramm != null) && (paramm.wyn != null))
              {
                ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramm.wyn.ret) });
                paramInt1 = -1;
              }
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 >= 0)
              {
                paramInt2 = paramInt1;
                if (paramm.wOk == null)
                {
                  paramInt2 = paramInt1;
                  if (paramm.wOj == null) {
                    paramInt2 = -1;
                  }
                }
              }
              if (paramInt2 < 0) {
                break label3699;
              }
              if (paramm.wOk == null) {
                break label2416;
              }
              bool2 = a(paramm.wOk, paramm.wyh);
              bool1 = bool2;
              if (bool2)
              {
                ???.fye = paramm.wOk.wyi;
                bool1 = bool2;
              }
              if (bool1) {
                break label3699;
              }
            }
            for (paramInt1 = -1;; paramInt1 = paramInt2)
            {
              paramm = (com.tencent.mm.aj.n)???.data;
              if (paramm != null) {
                paramm.a(paramInt1, ???);
              }
              AppMethodBeat.o(11571);
              return;
              ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label2286;
              bool2 = a(paramm.wOj, paramm.wyh, true);
              bool1 = bool2;
              if (!bool2) {
                break label2368;
              }
              ???.fye = paramm.wOj.wXl.wyb;
              bool1 = bool2;
              break label2368;
              ab.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
              localObject1 = (x)paramm;
              if ((((x)localObject1).rr != null) && (((x)localObject1).rr.fsW.fta != null))
              {
                ??? = (cmp)((x)localObject1).rr.fsW.fta;
                if ((((x)localObject1).rr == null) || (((x)localObject1).rr.fsV.fta == null)) {
                  break label2622;
                }
                paramm = (cmo)((x)localObject1).rr.fsV.fta;
              }
              for (;;)
              {
                if ((??? == null) || (???.wyn == null) || (???.wyn.ret != 0))
                {
                  if ((??? != null) && (???.wyn != null))
                  {
                    ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.wyn.ret) });
                    AppMethodBeat.o(11571);
                    return;
                    ??? = null;
                    break;
                    paramm = null;
                    continue;
                  }
                  ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                  AppMethodBeat.o(11571);
                  return;
                }
              }
              if (a(???.wOs, paramm.wyh, false)) {}
              for (paramInt1 = 0;; paramInt1 = -1)
              {
                ??? = (com.tencent.mm.aj.n)((x)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.ai.m)localObject1);
                }
                AppMethodBeat.o(11571);
                return;
              }
              localObject1 = (w)paramm;
              if ((((w)localObject1).rr != null) && (((w)localObject1).rr.fsW.fta != null))
              {
                ??? = (cmr)((w)localObject1).rr.fsW.fta;
                if ((((w)localObject1).rr == null) || (((w)localObject1).rr.fsV.fta == null)) {
                  break label3114;
                }
                paramm = (cmq)((w)localObject1).rr.fsV.fta;
                paramInt1 = 0;
                if ((??? == null) || (???.wyn == null) || (???.wyn.ret != 0) || (???.wXl == null))
                {
                  if ((??? == null) || (???.wyn == null)) {
                    break label3120;
                  }
                  ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.wyn.ret) });
                  paramInt1 = -1;
                }
                if (paramInt1 < 0) {
                  break label3696;
                }
                localObject2 = z.afk().sl(???.wXl.wyb);
                if (localObject2 == null)
                {
                  if (localObject2 != null) {
                    break label3131;
                  }
                  bool1 = true;
                  if (???.wXl != null) {
                    break label3137;
                  }
                  bool2 = true;
                  ab.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null:%s, resp.chat == null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  paramInt1 = -1;
                }
                if ((paramInt1 < 0) || (((((c)localObject2).field_bitFlag == ???.wXl.wyd) || (!((c)localObject2).afy())) && (???.wXl.ver <= ((c)localObject2).field_chatVersion))) {
                  break label3143;
                }
                ((c)localObject2).field_chatType = ???.wXl.type;
                ((c)localObject2).field_headImageUrl = ???.wXl.wyc;
                ((c)localObject2).field_chatName = ???.wXl.name;
                ((c)localObject2).field_chatVersion = ???.wXl.ver;
                ((c)localObject2).field_needToUpdate = false;
                ((c)localObject2).field_bitFlag = ???.wXl.wyd;
                ((c)localObject2).field_maxMemberCnt = ???.wXl.wye;
                ((c)localObject2).field_ownerUserId = ???.wXl.wyf;
                ((c)localObject2).field_addMemberUrl = ???.wXl.wyg;
                ((c)localObject2).field_brandUserName = paramm.wyh;
                z.afk().b((c)localObject2);
              }
              for (;;)
              {
                ??? = (com.tencent.mm.aj.n)((w)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.ai.m)localObject1);
                }
                AppMethodBeat.o(11571);
                return;
                ??? = null;
                break label2739;
                paramm = null;
                break label2777;
                ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                break label2843;
                bool1 = false;
                break label2877;
                bool2 = false;
                break label2887;
                paramInt1 = -1;
                continue;
                AppMethodBeat.o(11571);
                return;
                paramm = (s)paramm;
                if ((paramm.rr != null) && (paramm.rr.fsW.fta != null))
                {
                  ??? = (akl)paramm.rr.fsW.fta;
                  if ((paramm.rr == null) || (paramm.rr.fsV.fta == null)) {
                    break label3306;
                  }
                  paramm = (akk)paramm.rr.fsV.fta;
                }
                for (;;)
                {
                  if ((??? == null) || (???.wyn == null) || (???.wyn.ret != 0))
                  {
                    if ((??? != null) && (???.wyn != null))
                    {
                      ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.wyn.ret) });
                      AppMethodBeat.o(11571);
                      return;
                      ??? = null;
                      break;
                      paramm = null;
                      continue;
                    }
                    ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.o(11571);
                    return;
                  }
                }
                localObject2 = ???.xbF;
                localObject3 = z.afk();
                localObject4 = paramm.wyh;
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
                    localObject4 = z.afk().sl((String)localObject4);
                    if (localObject4 != null)
                    {
                      ((c)localObject4).field_bitFlag &= 0xFFFFFFF7;
                      z.afk().b((c)localObject4);
                    }
                  }
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  if (!((List)localObject1).contains(localObject3))
                  {
                    localObject4 = z.afk().sl((String)localObject3);
                    if (localObject4 == null)
                    {
                      localObject4 = new c();
                      ((c)localObject4).field_bizChatServId = ((String)localObject3);
                      ((c)localObject4).field_brandUserName = paramm.wyh;
                      ((c)localObject4).field_bitFlag |= 0x8;
                      z.afk().a((c)localObject4);
                    }
                    else
                    {
                      ((c)localObject4).field_bitFlag |= 0x8;
                      z.afk().b((c)localObject4);
                    }
                  }
                }
                a(???.xbF, paramm.wyh);
                break;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.a.h
 * JD-Core Version:    0.7.0.1
 */