package com.tencent.mm.an.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.an.af;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.protocal.protobuf.dcj;
import com.tencent.mm.protocal.protobuf.elf;
import com.tencent.mm.protocal.protobuf.frk;
import com.tencent.mm.protocal.protobuf.frl;
import com.tencent.mm.protocal.protobuf.frm;
import com.tencent.mm.protocal.protobuf.frn;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.protocal.protobuf.rz;
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
  implements com.tencent.mm.am.h
{
  private HashSet<h.a> oyb;
  private HashSet<h.a> oyc;
  private final Object oyd;
  private com.tencent.mm.b.f<String, Long> oye;
  private HashSet<h.a> oyf;
  private HashSet<h.a> oyg;
  private final Object oyh;
  private com.tencent.mm.b.f<String, Long> oyi;
  
  public h()
  {
    AppMethodBeat.i(124255);
    this.oyb = new HashSet();
    this.oyc = new HashSet();
    this.oyd = new Object();
    this.oye = new com.tencent.mm.b.h(64);
    this.oyf = new HashSet();
    this.oyg = new HashSet();
    this.oyh = new Object();
    this.oyi = new com.tencent.mm.b.h(64);
    com.tencent.mm.kernel.h.baD().mCm.a(1352, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1365, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1353, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1354, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1357, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1356, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1355, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1358, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1367, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1361, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1389, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1315, this);
    AppMethodBeat.o(124255);
  }
  
  public static void Nk(String paramString)
  {
    AppMethodBeat.i(239517);
    paramString = new t(paramString);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(239517);
  }
  
  public static n a(String paramString1, String paramString2, String paramString3, com.tencent.mm.an.p paramp)
  {
    AppMethodBeat.i(239506);
    paramString1 = new n(paramString1, paramString2, paramString3, paramp);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(239506);
    return paramString1;
  }
  
  public static o a(String paramString, cam paramcam, com.tencent.mm.an.p paramp)
  {
    AppMethodBeat.i(124270);
    paramString = new o(paramString, paramcam, paramp);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(124270);
    return paramString;
  }
  
  public static u a(String paramString1, String paramString2, LinkedList<String> paramLinkedList, com.tencent.mm.an.p paramp)
  {
    AppMethodBeat.i(239504);
    paramString1 = new u(paramString1, paramString2, paramLinkedList, paramp);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(239504);
    return paramString1;
  }
  
  public static x a(String paramString, op paramop, com.tencent.mm.an.p paramp)
  {
    AppMethodBeat.i(124272);
    paramString = new x(paramString, paramop, paramp);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(124272);
    return paramString;
  }
  
  public static y a(String paramString1, String paramString2, os paramos1, os paramos2, com.tencent.mm.an.p paramp)
  {
    AppMethodBeat.i(124271);
    paramString1 = new y(paramString1, paramString2, paramos1, paramos2, paramp);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(124271);
    return paramString1;
  }
  
  public static void a(String paramString, com.tencent.mm.an.p paramp)
  {
    AppMethodBeat.i(124269);
    paramString = new r(paramString, paramp);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(124269);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.an.p paramp)
  {
    AppMethodBeat.i(124268);
    if (paramp == null)
    {
      AppMethodBeat.o(124268);
      return;
    }
    Object localObject = e.Ne(paramString2);
    if ((localObject == null) || (((k)localObject).field_userId.equals(paramString1)))
    {
      a(paramString2, paramp);
      AppMethodBeat.o(124268);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString1);
    paramString1 = new rz();
    paramString1.YRQ = paramString2;
    paramString1.YWT = ((LinkedList)localObject);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = new s(paramString2, paramp);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(124268);
  }
  
  private static boolean a(cam paramcam, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124275);
    Log.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
    if ((paramcam == null) || (paramcam.aajx == null) || (Util.isNullOrNil(paramString)))
    {
      Log.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
      AppMethodBeat.o(124275);
      return false;
    }
    Object localObject1 = af.bHh().MZ(paramcam.aajx.YRJ);
    int i;
    if (localObject1 == null)
    {
      Log.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
      localObject1 = new c();
      ((c)localObject1).field_bizChatServId = paramcam.aajx.YRJ;
      ((c)localObject1).field_brandUserName = paramString;
      i = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (paramcam.YRS == null)
      {
        Log.w("MicroMsg.BizChatNetworkMgr", "members==null");
        AppMethodBeat.o(124275);
        return false;
      }
      Object localObject2;
      if ((((c)localObject1).bHy()) || (paramcam.aajx.ver > ((c)localObject1).field_chatVersion))
      {
        ((c)localObject1).field_chatType = paramcam.aajx.type;
        ((c)localObject1).field_headImageUrl = paramcam.aajx.YRK;
        ((c)localObject1).field_chatName = paramcam.aajx.name;
        ((c)localObject1).field_chatVersion = paramcam.aajx.ver;
        ((c)localObject1).field_needToUpdate = false;
        ((c)localObject1).field_bitFlag = paramcam.aajx.YRL;
        ((c)localObject1).field_maxMemberCnt = paramcam.aajx.YRM;
        ((c)localObject1).field_ownerUserId = paramcam.aajx.YRN;
        ((c)localObject1).field_addMemberUrl = paramcam.aajx.YRO;
        ((c)localObject1).field_brandUserName = paramString;
        ((c)localObject1).field_roomflag = paramcam.aajx.YRP;
        paramString = new LinkedList();
        localObject2 = paramcam.YRS.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add(((or)((Iterator)localObject2).next()).YRR);
        }
        ((c)localObject1).field_userList = Util.listToString(paramString, ";");
        if (i == 0) {
          break label442;
        }
        af.bHh().a((c)localObject1);
      }
      long l;
      for (;;)
      {
        e.h((c)localObject1);
        if (!paramBoolean) {
          break label511;
        }
        paramString = new rz();
        paramString.YRQ = ((c)localObject1).field_brandUserName;
        localObject1 = new LinkedList();
        paramcam = paramcam.YRS.iterator();
        while (paramcam.hasNext())
        {
          localObject2 = (or)paramcam.next();
          l = af.bHj().Nl(((or)localObject2).YRR);
          if (((or)localObject2).ver > l) {
            ((LinkedList)localObject1).add(((or)localObject2).YRR);
          }
        }
        label442:
        af.bHh().b((c)localObject1);
      }
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString.YWT = ((LinkedList)localObject1);
        paramcam = new LinkedList();
        paramcam.add(paramString);
        paramcam = new s(paramcam, null);
        com.tencent.mm.kernel.h.baD().mCm.a(paramcam, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(124275);
        return true;
        label511:
        paramString = af.bHj().db;
        l = 0L;
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)paramString).beginTransaction(Thread.currentThread().getId());
        }
        paramcam = paramcam.YRS.iterator();
        while (paramcam.hasNext())
        {
          localObject2 = (or)paramcam.next();
          k localk = af.bHj().hM(((or)localObject2).YRR);
          if (localk == null)
          {
            localk = new k();
            localk.field_userId = ((or)localObject2).YRR;
            localk.field_userName = ((or)localObject2).wwH;
            localk.field_brandUserName = ((c)localObject1).field_brandUserName;
            localk.field_needToUpdate = true;
            af.bHj().a(localk);
          }
          else if (((or)localObject2).ver > localk.field_UserVersion)
          {
            localk.field_needToUpdate = true;
            af.bHj().b(localk);
          }
        }
        if ((paramString instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.h.baE().mCN.endTransaction(l);
        }
      }
      i = 0;
    }
  }
  
  private static boolean a(ow paramow, String paramString)
  {
    AppMethodBeat.i(124274);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramow.YRR)))
    {
      AppMethodBeat.o(124274);
      return false;
    }
    k localk = new k();
    localk.field_userId = paramow.YRR;
    localk.field_userName = paramow.wwH;
    localk.field_brandUserName = paramString;
    localk.field_headImageUrl = paramow.YRK;
    localk.field_profileUrl = paramow.mef;
    localk.field_UserVersion = paramow.ver;
    localk.field_addMemberUrl = paramow.YRO;
    if (!af.bHj().b(localk)) {
      af.bHj().a(localk);
    }
    paramow = new c();
    paramow.field_bizChatServId = localk.field_userId;
    paramow.field_brandUserName = localk.field_brandUserName;
    paramow.field_chatName = localk.field_userName;
    paramow.field_chatType = j.oyk.oyn;
    if (e.e(paramow) == null)
    {
      AppMethodBeat.o(124274);
      return false;
    }
    AppMethodBeat.o(124274);
    return true;
  }
  
  public static void bC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124267);
    paramString1 = new p(paramString1, paramString2);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(124267);
  }
  
  private void bHB()
  {
    AppMethodBeat.i(124262);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.oyd)
    {
      if (!this.oyc.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      if (this.oyb.isEmpty())
      {
        AppMethodBeat.o(124262);
        return;
      }
      Iterator localIterator = this.oyb.iterator();
      if (localIterator.hasNext())
      {
        h.a locala = (h.a)localIterator.next();
        oq localoq = new oq();
        localoq.YRQ = h.a.a(locala);
        localoq.YRJ = h.a.b(locala);
        localLinkedList1.add(localoq);
      }
    }
    if (localLinkedList2.isEmpty())
    {
      AppMethodBeat.o(124262);
      return;
    }
    this.oyc.addAll(this.oyb);
    this.oyb.clear();
    ??? = new q(localLinkedList2);
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)???, 0);
    AppMethodBeat.o(124262);
  }
  
  private void bHC()
  {
    AppMethodBeat.i(124266);
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    synchronized (this.oyh)
    {
      if (!this.oyg.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      if (this.oyf.isEmpty())
      {
        AppMethodBeat.o(124266);
        return;
      }
      localHashMap = new HashMap();
      localObject6 = this.oyf.iterator();
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
        localObject7 = new rz();
        ((rz)localObject7).YRQ = ((String)localObject4);
        ((rz)localObject7).YWT = ((LinkedList)localObject6);
        localLinkedList.add(localObject7);
      }
    }
    this.oyg.addAll(this.oyf);
    this.oyf.clear();
    localObject3 = new s(localLinkedList, null);
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject3, 0);
    AppMethodBeat.o(124266);
  }
  
  private void bz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124260);
    long l = System.currentTimeMillis();
    synchronized (this.oyd)
    {
      paramString2 = new h.a(paramString2, paramString1);
      if (this.oyc.contains(paramString2))
      {
        AppMethodBeat.o(124260);
        return;
      }
      this.oyb.add(paramString2);
      this.oye.put(paramString1, new Long(l));
      bHB();
      AppMethodBeat.o(124260);
      return;
    }
  }
  
  public static void d(com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(124258);
    com.tencent.mm.kernel.h.baD().mCm.a(paramp);
    AppMethodBeat.o(124258);
  }
  
  public static void o(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124273);
    paramString1 = new w(paramString1, paramString2, paramInt);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(124273);
  }
  
  public final void b(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124261);
    long l = System.currentTimeMillis();
    synchronized (this.oyd)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        h.a locala = new h.a(paramString, str);
        if (!this.oyc.contains(locala))
        {
          this.oyb.add(locala);
          this.oye.put(str, new Long(l));
        }
      }
    }
    bHB();
    AppMethodBeat.o(124261);
  }
  
  public final void bA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124263);
    Long localLong = (Long)this.oyi.ct(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bB(paramString1, paramString2);
    }
    AppMethodBeat.o(124263);
  }
  
  public final void bB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124264);
    long l = System.currentTimeMillis();
    synchronized (this.oyh)
    {
      paramString2 = new h.a(paramString2, paramString1);
      if (this.oyg.contains(paramString2))
      {
        AppMethodBeat.o(124264);
        return;
      }
      this.oyf.add(paramString2);
      this.oyi.put(paramString1, new Long(l));
      bHC();
      AppMethodBeat.o(124264);
      return;
    }
  }
  
  public final void by(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124259);
    Long localLong = (Long)this.oye.ct(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      bz(paramString1, paramString2);
    }
    AppMethodBeat.o(124259);
  }
  
  public final void c(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(124265);
    long l = System.currentTimeMillis();
    synchronized (this.oyh)
    {
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        h.a locala = new h.a(paramString, str);
        if (this.oyg.contains(locala))
        {
          AppMethodBeat.o(124265);
          return;
        }
        this.oyf.add(locala);
        this.oyi.put(str, new Long(l));
      }
    }
    bHC();
    AppMethodBeat.o(124265);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(124256);
    com.tencent.mm.kernel.h.baD().mCm.b(1352, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1365, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1353, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1354, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1357, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1356, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1355, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1358, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1367, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1361, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1389, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1315, this);
    super.finalize();
    AppMethodBeat.o(124256);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(124257);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
      if ((paramp.getType() != 1365) && (paramp.getType() != 1353))
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
    switch (paramp.getType())
    {
    default: 
      AppMethodBeat.o(124257);
      return;
    case 1352: 
      localObject1 = (p)paramp;
      if ((((p)localObject1).rr != null) && (c.c.b(((p)localObject1).rr.otC) != null))
      {
        ??? = (cfm)c.c.b(((p)localObject1).rr.otC);
        if ((((p)localObject1).rr == null) || (c.b.b(((p)localObject1).rr.otB) == null)) {
          break label321;
        }
      }
      for (paramp = (cfl)c.b.b(((p)localObject1).rr.otB);; paramp = null)
      {
        bool1 = ((p)localObject1).oyx;
        if ((??? != null) && (???.YRW != null) && (???.YRW.ret == 0)) {
          break label342;
        }
        if ((??? == null) || (???.YRW == null)) {
          break label327;
        }
        Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.YRW.ret) });
        AppMethodBeat.o(124257);
        return;
        ??? = null;
        break;
      }
      Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      AppMethodBeat.o(124257);
      return;
      a(???.ZpT, paramp.YRQ, bool1);
      AppMethodBeat.o(124257);
      return;
    case 1365: 
      synchronized (this.oyd)
      {
        this.oyc.clear();
        bHB();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      paramp = (q)paramp;
      if ((paramp.rr != null) && (c.c.b(paramp.rr.otC) != null)) {
        ??? = (cfk)c.c.b(paramp.rr.otC);
      }
      while ((??? == null) || (???.YRW == null) || (???.YRW.ret != 0)) {
        if ((??? != null) && (???.YRW != null))
        {
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.YRW.ret) });
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
      ??? = ???.aape;
      if ((??? == null) || (???.size() == 0))
      {
        Log.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
        AppMethodBeat.o(124257);
        return;
      }
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cam)((Iterator)localObject1).next();
        ??? = ((cam)localObject2).aajx.YRJ;
        if ((??? == null) || (paramp.oyy == null)) {}
        for (??? = null;; ??? = (String)paramp.oyy.get(???))
        {
          a((cam)localObject2, ???, false);
          break;
        }
      }
      AppMethodBeat.o(124257);
      return;
    case 1353: 
      localObject1 = (s)paramp;
      localObject2 = (com.tencent.mm.an.p)((s)localObject1).cpt;
      if (localObject2 == null) {}
      synchronized (this.oyh)
      {
        this.oyg.clear();
        bHC();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(124257);
          return;
        }
      }
      if ((((s)localObject1).rr != null) && (c.c.b(((s)localObject1).rr.otC) != null))
      {
        ??? = (cfq)c.c.b(((s)localObject1).rr.otC);
        paramInt1 = 0;
        if ((??? == null) || (???.YRW == null) || (???.YRW.ret != 0))
        {
          if ((??? == null) || (???.YRW == null)) {
            break label1218;
          }
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.YRW.ret) });
          label824:
          paramInt1 = -1;
        }
        if ((paramInt1 < 0) || (???.YRX != null)) {
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
        localObject3 = af.bHj().db;
        long l = 0L;
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          l = ((com.tencent.mm.storagebase.h)localObject3).beginTransaction(Thread.currentThread().getId());
        }
        paramInt2 = 0;
        if (paramInt2 < ???.YRX.size())
        {
          Log.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[] { ((ow)???.YRX.get(paramInt2)).wwH });
          localObject4 = new k();
          ((k)localObject4).field_userId = ((ow)???.YRX.get(paramInt2)).YRR;
          ((k)localObject4).field_userName = ((ow)???.YRX.get(paramInt2)).wwH;
          paramp = ((k)localObject4).field_userId;
          if ((paramp == null) || (((s)localObject1).oyz == null))
          {
            paramp = null;
            ((k)localObject4).field_brandUserName = paramp;
            ((k)localObject4).field_UserVersion = ((ow)???.YRX.get(paramInt2)).ver;
            ((k)localObject4).field_headImageUrl = ((ow)???.YRX.get(paramInt2)).YRK;
            ((k)localObject4).field_profileUrl = ((ow)???.YRX.get(paramInt2)).mef;
            ((k)localObject4).field_bitFlag = ((ow)???.YRX.get(paramInt2)).YRL;
            ((k)localObject4).field_addMemberUrl = ((ow)???.YRX.get(paramInt2)).YRO;
            ((k)localObject4).field_needToUpdate = false;
            paramp = af.bHj().hM(((ow)???.YRX.get(paramInt2)).YRR);
            if (paramp != null) {
              break label1249;
            }
            bool1 = false;
            bool2 = ((k)localObject4).nG(16);
            if (paramp != null) {
              break label1261;
            }
            af.bHj().a((k)localObject4);
            if (bool1 != bool2)
            {
              paramp = af.bHh().MZ(((k)localObject4).field_userId);
              if (paramp != null)
              {
                if ((!bool1) || (bool2)) {
                  break label1273;
                }
                af.bHi().iI(paramp.field_bizChatLocalId);
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
            paramp = (String)((s)localObject1).oyz.get(paramp);
            break label998;
            label1249:
            bool1 = paramp.nG(16);
            break label1136;
            label1261:
            af.bHj().b((k)localObject4);
            break label1159;
            label1273:
            if ((!bool1) && (bool2)) {
              af.bHi().iH(paramp.field_bizChatLocalId);
            }
          }
        }
        if ((localObject3 instanceof com.tencent.mm.storagebase.h)) {
          com.tencent.mm.kernel.h.baE().mCN.endTransaction(l);
        }
      }
      if (localObject2 != null) {
        ((com.tencent.mm.an.p)localObject2).a(paramInt1, (com.tencent.mm.am.p)localObject1);
      }
      AppMethodBeat.o(124257);
      return;
      localObject1 = (r)paramp;
      if ((((r)localObject1).rr != null) && (c.c.b(((r)localObject1).rr.otC) != null))
      {
        ??? = (cfo)c.c.b(((r)localObject1).rr.otC);
        label1384:
        if (((r)localObject1).rr != null) {
          break label1530;
        }
        paramp = null;
        label1395:
        if ((??? != null) && (???.YRW != null) && (???.YRW.ret == 0)) {
          break label3774;
        }
        if ((??? == null) || (???.YRW == null)) {
          break label1549;
        }
        Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.YRW.ret) });
      }
      for (paramInt1 = -1;; paramInt1 = 0)
      {
        if (paramInt1 >= 0)
        {
          localObject2 = af.bHj();
          paramp = paramp.YRQ;
          ??? = ???.YRT;
          if ((??? == null) || (Util.isNullOrNil(paramp))) {
            Log.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
          }
        }
        else
        {
          ??? = (com.tencent.mm.an.p)((r)localObject1).cpt;
          if (??? != null) {
            ???.a(paramInt1, (com.tencent.mm.am.p)localObject1);
          }
          AppMethodBeat.o(124257);
          return;
          ??? = null;
          break label1384;
          label1530:
          paramp = (cfn)c.b.b(((r)localObject1).rr.otB);
          break label1395;
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1452;
        }
        Log.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[] { paramp, ???.YRR, Boolean.valueOf(Util.isNullOrNil(???.YRO)) });
        localObject3 = af.bHk().Nj(paramp);
        if (localObject3 == null)
        {
          localObject3 = new f();
          ((f)localObject3).field_brandUserName = paramp;
          ((f)localObject3).field_userId = ???.YRR;
          af.bHk().a((f)localObject3);
        }
        for (;;)
        {
          localObject3 = new k();
          ((k)localObject3).field_userId = ???.YRR;
          ((k)localObject3).field_userName = ???.wwH;
          ((k)localObject3).field_brandUserName = paramp;
          ((k)localObject3).field_UserVersion = ???.ver;
          ((k)localObject3).field_headImageUrl = ???.YRK;
          ((k)localObject3).field_profileUrl = ???.mef;
          ((k)localObject3).field_bitFlag = ???.YRL;
          ((k)localObject3).field_needToUpdate = false;
          ((k)localObject3).field_addMemberUrl = ???.YRO;
          if (!((l)localObject2).b((k)localObject3)) {
            ((l)localObject2).a((k)localObject3);
          }
          ((l)localObject2).oxD.put(paramp, ((k)localObject3).field_userId);
          break;
          ((f)localObject3).field_userId = ???.YRR;
          af.bHk().b((f)localObject3);
          Log.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
        }
        ??? = (o)paramp;
        paramp = ???.bHE();
        localObject1 = ???.bHF();
        paramInt1 = 0;
        if ((paramp == null) || (paramp.YRW == null) || (paramp.YRW.ret != 0))
        {
          if ((paramp != null) && (paramp.YRW != null))
          {
            Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramp.YRW.ret) });
            label1884:
            paramInt1 = -1;
          }
        }
        else
        {
          if (paramInt1 < 0) {
            break label3771;
          }
          if (!a(paramp.ZpT, ((agu)localObject1).YRQ, true)) {
            break label1950;
          }
          paramInt1 = 0;
        }
        for (;;)
        {
          paramp = (com.tencent.mm.an.p)???.cpt;
          if (paramp != null) {
            paramp.a(paramInt1, ???);
          }
          AppMethodBeat.o(124257);
          return;
          Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1884;
          paramInt1 = -1;
          continue;
          ??? = (u)paramp;
          paramp = ???.bHG();
          if ((???.rr != null) && (c.b.b(???.rr.otB) != null)) {
            c.b.b(???.rr.otB);
          }
          paramInt1 = 0;
          if ((paramp == null) || (paramp.YRW == null) || (paramp.YRW.ret != 0))
          {
            if ((paramp != null) && (paramp.YRW != null))
            {
              Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramp.YRW.ret) });
              paramInt1 = -1;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            if (paramInt1 >= 0)
            {
              paramInt2 = paramInt1;
              if (paramp.ZpH == null)
              {
                paramInt2 = paramInt1;
                if (paramp.ZpG == null) {
                  paramInt2 = -1;
                }
              }
            }
            if (paramInt2 < 0) {
              break label3766;
            }
            if (paramp.ZpH == null) {
              break label2193;
            }
            bool2 = a(paramp.ZpH, paramp.YRQ);
            bool1 = bool2;
            if (bool2)
            {
              ???.oyw = paramp.ZpH.YRR;
              bool1 = bool2;
            }
            label2145:
            if (bool1) {
              break label3766;
            }
          }
          for (paramInt1 = -1;; paramInt1 = paramInt2)
          {
            paramp = (com.tencent.mm.an.p)???.cpt;
            if (paramp != null) {
              paramp.a(paramInt1, ???);
            }
            AppMethodBeat.o(124257);
            return;
            Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label2063;
            bool2 = a(paramp.ZpG, paramp.YRQ, true);
            bool1 = bool2;
            if (!bool2) {
              break label2145;
            }
            ???.oyw = paramp.ZpG.aajx.YRJ;
            bool1 = bool2;
            break label2145;
            ??? = (n)paramp;
            paramp = ???.bHD();
            if ((???.rr != null) && (c.b.b(???.rr.otB) != null)) {
              c.b.b(???.rr.otB);
            }
            paramInt1 = 0;
            if ((paramp == null) || (paramp.YRW == null) || (paramp.YRW.ret != 0))
            {
              if ((paramp != null) && (paramp.YRW != null))
              {
                Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramp.YRW.ret) });
                paramInt1 = -1;
              }
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 >= 0)
              {
                paramInt2 = paramInt1;
                if (paramp.ZpH == null)
                {
                  paramInt2 = paramInt1;
                  if (paramp.ZpG == null) {
                    paramInt2 = -1;
                  }
                }
              }
              if (paramInt2 < 0) {
                break label3761;
              }
              if (paramp.ZpH == null) {
                break label2478;
              }
              bool2 = a(paramp.ZpH, paramp.YRQ);
              bool1 = bool2;
              if (bool2)
              {
                ???.oyw = paramp.ZpH.YRR;
                bool1 = bool2;
              }
              label2430:
              if (bool1) {
                break label3761;
              }
            }
            for (paramInt1 = -1;; paramInt1 = paramInt2)
            {
              paramp = (com.tencent.mm.an.p)???.cpt;
              if (paramp != null) {
                paramp.a(paramInt1, ???);
              }
              AppMethodBeat.o(124257);
              return;
              Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label2348;
              bool2 = a(paramp.ZpG, paramp.YRQ, true);
              bool1 = bool2;
              if (!bool2) {
                break label2430;
              }
              ???.oyw = paramp.ZpG.aajx.YRJ;
              bool1 = bool2;
              break label2430;
              Log.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
              localObject1 = (y)paramp;
              if ((((y)localObject1).rr != null) && (c.c.b(((y)localObject1).rr.otC) != null))
              {
                ??? = (frl)c.c.b(((y)localObject1).rr.otC);
                if ((((y)localObject1).rr == null) || (c.b.b(((y)localObject1).rr.otB) == null)) {
                  break label2684;
                }
                paramp = (frk)c.b.b(((y)localObject1).rr.otB);
              }
              for (;;)
              {
                if ((??? == null) || (???.YRW == null) || (???.YRW.ret != 0))
                {
                  if ((??? != null) && (???.YRW != null))
                  {
                    Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.YRW.ret) });
                    AppMethodBeat.o(124257);
                    return;
                    ??? = null;
                    break;
                    label2684:
                    paramp = null;
                    continue;
                  }
                  Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                  AppMethodBeat.o(124257);
                  return;
                }
              }
              if (a(???.ZpT, paramp.YRQ, false)) {}
              for (paramInt1 = 0;; paramInt1 = -1)
              {
                ??? = (com.tencent.mm.an.p)((y)localObject1).cpt;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.am.p)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
              }
              localObject1 = (x)paramp;
              if ((((x)localObject1).rr != null) && (c.c.b(((x)localObject1).rr.otC) != null))
              {
                ??? = (frn)c.c.b(((x)localObject1).rr.otC);
                label2801:
                if ((((x)localObject1).rr == null) || (c.b.b(((x)localObject1).rr.otB) == null)) {
                  break label3176;
                }
                paramp = (frm)c.b.b(((x)localObject1).rr.otB);
                paramInt1 = 0;
                if ((??? == null) || (???.YRW == null) || (???.YRW.ret != 0) || (???.aajx == null))
                {
                  if ((??? == null) || (???.YRW == null)) {
                    break label3182;
                  }
                  Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.YRW.ret) });
                  label2905:
                  paramInt1 = -1;
                }
                if (paramInt1 < 0) {
                  break label3758;
                }
                localObject2 = af.bHh().MZ(???.aajx.YRJ);
                if (localObject2 == null)
                {
                  if (localObject2 != null) {
                    break label3193;
                  }
                  bool1 = true;
                  label2939:
                  if (???.aajx != null) {
                    break label3199;
                  }
                  bool2 = true;
                  Log.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null:%s, resp.chat == null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  paramInt1 = -1;
                }
                if ((paramInt1 < 0) || (((((c)localObject2).field_bitFlag == ???.aajx.YRL) || (!((c)localObject2).bHy())) && (???.aajx.ver <= ((c)localObject2).field_chatVersion))) {
                  break label3205;
                }
                ((c)localObject2).field_chatType = ???.aajx.type;
                ((c)localObject2).field_headImageUrl = ???.aajx.YRK;
                ((c)localObject2).field_chatName = ???.aajx.name;
                ((c)localObject2).field_chatVersion = ???.aajx.ver;
                ((c)localObject2).field_needToUpdate = false;
                ((c)localObject2).field_bitFlag = ???.aajx.YRL;
                ((c)localObject2).field_maxMemberCnt = ???.aajx.YRM;
                ((c)localObject2).field_ownerUserId = ???.aajx.YRN;
                ((c)localObject2).field_addMemberUrl = ???.aajx.YRO;
                ((c)localObject2).field_brandUserName = paramp.YRQ;
                af.bHh().b((c)localObject2);
              }
              for (;;)
              {
                ??? = (com.tencent.mm.an.p)((x)localObject1).cpt;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.am.p)localObject1);
                }
                AppMethodBeat.o(124257);
                return;
                ??? = null;
                break label2801;
                label3176:
                paramp = null;
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
                paramp = (t)paramp;
                if ((paramp.rr != null) && (c.c.b(paramp.rr.otC) != null))
                {
                  ??? = (cjz)c.c.b(paramp.rr.otC);
                  if ((paramp.rr == null) || (c.b.b(paramp.rr.otB) == null)) {
                    break label3368;
                  }
                  paramp = (cjy)c.b.b(paramp.rr.otB);
                }
                for (;;)
                {
                  if ((??? == null) || (???.YRW == null) || (???.YRW.ret != 0))
                  {
                    if ((??? != null) && (???.YRW != null))
                    {
                      Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.YRW.ret) });
                      AppMethodBeat.o(124257);
                      return;
                      ??? = null;
                      break;
                      paramp = null;
                      continue;
                    }
                    Log.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.o(124257);
                    return;
                  }
                }
                localObject2 = ???.aasA;
                localObject3 = af.bHh();
                localObject4 = paramp.YRQ;
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
                    localObject4 = af.bHh().MZ((String)localObject4);
                    if (localObject4 != null)
                    {
                      ((c)localObject4).field_bitFlag &= 0xFFFFFFF7;
                      af.bHh().b((c)localObject4);
                    }
                  }
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  if (!((List)localObject1).contains(localObject3))
                  {
                    localObject4 = af.bHh().MZ((String)localObject3);
                    if (localObject4 == null)
                    {
                      localObject4 = new c();
                      ((c)localObject4).field_bizChatServId = ((String)localObject3);
                      ((c)localObject4).field_brandUserName = paramp.YRQ;
                      ((c)localObject4).field_bitFlag |= 0x8;
                      af.bHh().a((c)localObject4);
                    }
                    else
                    {
                      ((c)localObject4).field_bitFlag |= 0x8;
                      af.bHh().b((c)localObject4);
                    }
                  }
                }
                b(???.aasA, paramp.YRQ);
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
 * Qualified Name:     com.tencent.mm.an.a.h
 * JD-Core Version:    0.7.0.1
 */