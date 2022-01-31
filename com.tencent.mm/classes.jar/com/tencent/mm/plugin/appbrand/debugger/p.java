package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.v8.V8Inspector;
import com.eclipsesource.v8.V8Inspector.JsInspectorChannelServer;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.protobuf.cts;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cug;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import org.json.JSONArray;

public final class p
{
  private static final Map<String, String[]> hmd;
  l bER;
  s hlO;
  u hlR;
  private ae<Integer, Long> hme;
  private boolean hmf;
  private long hmg;
  private LinkedList<o> hmh;
  private final int hmi;
  private int hmj;
  private long hmk;
  Timer mTimer;
  
  static
  {
    AppMethodBeat.i(101889);
    HashMap localHashMap = new HashMap();
    hmd = localHashMap;
    localHashMap.put("publishHandler", new String[] { "String", "String", "String" });
    hmd.put("invokeHandler", new String[] { "String", "String", "Number" });
    AppMethodBeat.o(101889);
  }
  
  public p()
  {
    AppMethodBeat.i(101861);
    this.hme = new ae(100);
    this.hmf = false;
    this.hmh = new LinkedList();
    this.hmi = 5000;
    this.hmj = 0;
    this.hmk = 0L;
    V8Inspector.setServer(new V8Inspector.JsInspectorChannelServer()
    {
      public final int notify(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        return 0;
      }
      
      public final int sendData(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(101858);
        p.a(p.this, paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(101858);
        return 0;
      }
    });
    AppMethodBeat.o(101861);
  }
  
  private static int[] AO(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(101886);
    localObject2 = new int[0];
    Object localObject1 = localObject2;
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      localObject1 = localObject2;
      paramString = new int[localJSONArray.length()];
      for (;;)
      {
        localObject1 = paramString;
        localObject2 = paramString;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject1 = paramString;
        paramString[i] = localJSONArray.getInt(i);
        i += 1;
      }
      return localObject2;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.RemoteDebugMsgMrg", paramString.getMessage());
      localObject2 = localObject1;
      AppMethodBeat.o(101886);
    }
  }
  
  private void a(ctq paramctq)
  {
    AppMethodBeat.i(101869);
    if (this.bER.ayX() == paramctq.ycE)
    {
      AppMethodBeat.o(101869);
      return;
    }
    if (paramctq.ycE) {
      this.bER.dS(true);
    }
    for (;;)
    {
      this.hlR.azp();
      this.hlR.azu();
      AppMethodBeat.o(101869);
      return;
      this.bER.dS(false);
    }
  }
  
  private void a(ctr paramctr)
  {
    AppMethodBeat.i(101863);
    ab.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[] { paramctr.ycG, Integer.valueOf(paramctr.ycI) });
    String str = paramctr.ycG;
    LinkedList localLinkedList1 = paramctr.ycH;
    if (!hmd.containsKey(str))
    {
      ab.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
      AppMethodBeat.o(101863);
      return;
    }
    Object localObject = (String[])hmd.get(str);
    if (localLinkedList1.size() < localObject.length)
    {
      ab.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
      AppMethodBeat.o(101863);
      return;
    }
    LinkedList localLinkedList2 = new LinkedList();
    int i = 0;
    if (i < localObject.length)
    {
      if ("Number".equals(localObject[i])) {
        localLinkedList2.add(Integer.valueOf((String)localLinkedList1.get(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        if ("Boolean".equals(localObject[i])) {
          localLinkedList2.add(Boolean.valueOf((String)localLinkedList1.get(i)));
        } else {
          localLinkedList2.add(localLinkedList1.get(i));
        }
      }
    }
    long l = System.currentTimeMillis();
    i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        ab.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
        AppMethodBeat.o(101863);
        return;
        if (str.equals("publishHandler"))
        {
          i = 0;
          continue;
          if (str.equals("invokeHandler")) {
            i = 1;
          }
        }
        break;
      }
    }
    this.bER.hlj.b((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), AO((String)String.class.cast(localLinkedList2.get(2))));
    localObject = null;
    label390:
    int j;
    if (localObject != null)
    {
      localObject = String.valueOf(localObject);
      if (!bo.isNullOrNil((String)localObject)) {
        O(paramctr.ycI, (String)localObject);
      }
      j = paramctr.computeSize();
      if (localObject != null) {
        break label505;
      }
    }
    label505:
    for (i = 0;; i = ((String)localObject).length())
    {
      q.a(str, localLinkedList1, l, j, i);
      AppMethodBeat.o(101863);
      return;
      localObject = this.bER.hlj.q((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), ((Integer)Integer.class.cast(localLinkedList2.get(2))).intValue());
      break;
      localObject = "";
      break label390;
    }
  }
  
  private static void a(ctt paramctt)
  {
    AppMethodBeat.i(101871);
    V8Inspector.onReceiveData(paramctt.ycJ, paramctt.xly);
    AppMethodBeat.o(101871);
  }
  
  private void a(ctz paramctz)
  {
    AppMethodBeat.i(101870);
    ab.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
    int i = this.bER.hlj.wj().atj().getCurrentPage().getCurrentPageView().hashCode();
    if (paramctz.ycT != i)
    {
      ab.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[] { Integer.valueOf(paramctz.ycT), Integer.valueOf(i) });
      AppMethodBeat.o(101870);
      return;
    }
    this.bER.hlj.b("remoteDebugCommand", paramctz.ycS, null);
    AppMethodBeat.o(101870);
  }
  
  private void a(cub paramcub)
  {
    AppMethodBeat.i(101873);
    ab.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[] { Integer.valueOf(paramcub.ycU) });
    int i = paramcub.ycU;
    String str = paramcub.cvF;
    b localb = (b)this.bER.hlE.remove(Integer.valueOf(i));
    if (localb == null)
    {
      AppMethodBeat.o(101873);
      return;
    }
    ValueCallback localValueCallback = localb.hla;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(str);
    }
    ab.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str);
    q.a(localb, paramcub.computeSize());
    AppMethodBeat.o(101873);
  }
  
  private void a(cuf paramcuf)
  {
    AppMethodBeat.i(101872);
    cug localcug = new cug();
    localcug.ycX = paramcuf.ycX;
    localcug.ycY = q.azn();
    ab.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[] { Integer.valueOf(localcug.ycY) });
    a(t.a(localcug, this.bER, "pong"));
    AppMethodBeat.o(101872);
  }
  
  public static void a(cuh paramcuh)
  {
    AppMethodBeat.i(101862);
    paramcuh.ycF = "WeixinJSCore";
    Iterator localIterator = hmd.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((String[])hmd.get(str)).length > 5)
      {
        ab.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
      }
      else
      {
        cud localcud = new cud();
        localcud.ycG = str;
        int i = 0;
        while (i < ((String[])hmd.get(str)).length)
        {
          localcud.ycH.add(((String[])hmd.get(str))[i]);
          i += 1;
        }
        paramcuh.ycZ.add(localcud);
      }
    }
    AppMethodBeat.o(101862);
  }
  
  private void a(LinkedList<o> paramLinkedList, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(101876);
      a(paramLinkedList, paramBoolean, false);
      AppMethodBeat.o(101876);
      return;
    }
    finally
    {
      paramLinkedList = finally;
      throw paramLinkedList;
    }
  }
  
  private void a(LinkedList<o> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    try
    {
      AppMethodBeat.i(101877);
      if (bo.es(paramLinkedList))
      {
        AppMethodBeat.o(101877);
        return;
      }
      localObject = new cuj();
      ((cuj)localObject).ydg = this.bER.hlk;
      ((cuj)localObject).ydh = this.bER.ayV();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        ((cuj)localObject).ycV.add(localo.hlV);
      }
      localObject = t.a(1006, (a)localObject);
    }
    finally {}
    if ((!this.bER.isBusy()) || (paramBoolean2))
    {
      ab.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
      this.hlO.a((ctv)localObject);
    }
    for (;;)
    {
      if (paramBoolean1) {
        w(paramLinkedList);
      }
      paramLinkedList = this.bER;
      paramLinkedList.hlr = System.currentTimeMillis();
      paramLinkedList.hlt = System.currentTimeMillis();
      if (!this.bER.isBusy()) {
        this.hmj = 0;
      }
      paramLinkedList = new k();
      paramLinkedList.size = ((ctv)localObject).computeSize();
      paramLinkedList.hlb = System.currentTimeMillis();
      this.bER.hlC.put(((ctv)localObject).eAx, paramLinkedList);
      AppMethodBeat.o(101877);
      break;
      ab.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
    }
  }
  
  private void azf()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(101865);
        i = 0;
        if (i < this.bER.hlD.size())
        {
          int j;
          if (i == 0)
          {
            j = this.bER.ayV();
            int k = ((ctw)this.bER.hlD.get(i)).fQD;
            if (j - k != 1) {
              da(j + 1, k - 1);
            }
          }
          else
          {
            j = ((ctw)this.bER.hlD.get(i - 1)).fQD;
            continue;
          }
        }
        else
        {
          AppMethodBeat.o(101865);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  private void azg()
  {
    AppMethodBeat.i(101875);
    long l = System.currentTimeMillis();
    for (;;)
    {
      synchronized (this.bER.mLock)
      {
        if ((this.hmf) && (l - this.hmg < 32L))
        {
          AppMethodBeat.o(101875);
          return;
        }
        this.hmg = l;
        if (bo.es(this.hmh))
        {
          AppMethodBeat.o(101875);
          return;
        }
        this.hmf = true;
        i = (int)(16L - (System.currentTimeMillis() - this.bER.hlr));
        if (i > 0)
        {
          e.aNS().o(new p.3(this), i);
          AppMethodBeat.o(101875);
          return;
        }
      }
      int i = 16;
    }
  }
  
  private LinkedList<ctw> v(LinkedList<ctw> paramLinkedList)
  {
    for (;;)
    {
      LinkedList localLinkedList1;
      LinkedList localLinkedList2;
      ctw localctw;
      try
      {
        AppMethodBeat.i(101868);
        if (paramLinkedList == null)
        {
          paramLinkedList = null;
          AppMethodBeat.o(101868);
          return paramLinkedList;
        }
        localLinkedList1 = new LinkedList();
        localLinkedList2 = new LinkedList();
        this.bER.hlD.addAll(paramLinkedList);
        Collections.sort(this.bER.hlD, new p.2(this));
        i = this.bER.ayV();
        paramLinkedList = this.bER.hlD.iterator();
        if (!paramLinkedList.hasNext()) {
          break label167;
        }
        localctw = (ctw)paramLinkedList.next();
        if (localctw == null) {
          continue;
        }
        if (localctw.fQD <= i)
        {
          localLinkedList2.add(localctw);
          continue;
        }
        if (localctw.fQD - i != 1) {
          break label167;
        }
      }
      finally {}
      localLinkedList1.add(localctw);
      int i = localctw.fQD;
      continue;
      label167:
      this.bER.nA(i);
      this.bER.hlD.removeAll(localLinkedList1);
      this.bER.hlD.removeAll(localLinkedList2);
      ab.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
      AppMethodBeat.o(101868);
      paramLinkedList = localLinkedList1;
    }
  }
  
  /* Error */
  private void w(LinkedList<o> paramLinkedList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 625
    //   5: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 117
    //   10: ldc_w 627
    //   13: invokestatic 324	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokestatic 483	com/tencent/mm/sdk/platformtools/bo:es	(Ljava/util/List;)Z
    //   20: ifeq +12 -> 32
    //   23: ldc_w 625
    //   26: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 131	com/tencent/mm/plugin/appbrand/debugger/p:bER	Lcom/tencent/mm/plugin/appbrand/debugger/l;
    //   36: getfield 630	com/tencent/mm/plugin/appbrand/debugger/l:hlB	Ljava/util/LinkedList;
    //   39: aload_1
    //   40: invokevirtual 606	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   43: pop
    //   44: ldc_w 625
    //   47: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: goto -21 -> 29
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	p
    //   0	58	1	paramLinkedList	LinkedList<o>
    // Exception table:
    //   from	to	target	type
    //   2	29	53	finally
    //   32	50	53	finally
  }
  
  public final void O(int paramInt, String paramString)
  {
    AppMethodBeat.i(101864);
    cts localcts = new cts();
    localcts.ycI = paramInt;
    localcts.cvF = paramString;
    a(t.a(localcts, this.bER, "callInterfaceResult"));
    AppMethodBeat.o(101864);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(101874);
    if (!this.bER.aza()) {}
    synchronized (this.bER.mLock)
    {
      if ((System.currentTimeMillis() - this.bER.hlr <= 16L) || (this.hmf))
      {
        this.hmh.add(paramo);
        azg();
        AppMethodBeat.o(101874);
        return;
      }
      ??? = new LinkedList();
      ((LinkedList)???).add(paramo);
      a((LinkedList)???, true);
      AppMethodBeat.o(101874);
      return;
    }
  }
  
  public final void a(s params, l paraml, u paramu)
  {
    this.hlO = params;
    this.bER = paraml;
    this.hlR = paramu;
  }
  
  public final void azh()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(101879);
      if (this.bER.isBusy())
      {
        AppMethodBeat.o(101879);
        return;
      }
      long l = System.currentTimeMillis();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.bER.hlB.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          o localo = (o)localIterator.next();
          if (l - localo.hlb > 5000L)
          {
            localo.hlb = System.currentTimeMillis();
            localLinkedList.add(localo);
            i = localo.hlW + i;
            if ((i >= 65536L) || (localLinkedList.size() > 800))
            {
              ab.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
              a(localLinkedList, false);
              localLinkedList.clear();
            }
          }
        }
        else
        {
          if (!bo.es(localLinkedList))
          {
            ab.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
            a(localLinkedList, false);
          }
          AppMethodBeat.o(101879);
          break;
        }
      }
    }
    finally {}
  }
  
  public final boolean azi()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(101880);
        long l = System.currentTimeMillis();
        if (l - this.hmk < this.hmj)
        {
          AppMethodBeat.o(101880);
          bool = false;
          return bool;
        }
        this.hmk = l;
        if (this.hmj < 5000)
        {
          this.hmj += 1000;
          LinkedList localLinkedList1 = new LinkedList();
          localObject = this.bER.hlB.iterator();
          if (((Iterator)localObject).hasNext())
          {
            o localo = (o)((Iterator)localObject).next();
            if (l - localo.hlb <= 5000L) {
              continue;
            }
            localo.hlb = System.currentTimeMillis();
            localLinkedList1.add(localo);
            a(localLinkedList1, false, true);
            AppMethodBeat.o(101880);
            bool = true;
          }
        }
        else
        {
          this.hmj = 2000;
          continue;
        }
        if (this.bER.hlB.size() <= 0) {
          break label239;
        }
      }
      finally {}
      Object localObject = (o)this.bER.hlB.get(0);
      ((o)localObject).hlb = System.currentTimeMillis();
      localLinkedList2.add(localObject);
      a(localLinkedList2, false, true);
      AppMethodBeat.o(101880);
      boolean bool = true;
      continue;
      label239:
      AppMethodBeat.o(101880);
      bool = false;
    }
  }
  
  final void azj()
  {
    AppMethodBeat.i(101882);
    this.bER.setStatus(4);
    this.hlO.AQ("quit");
    AppMethodBeat.o(101882);
  }
  
  public final void azk()
  {
    for (;;)
    {
      o localo;
      try
      {
        AppMethodBeat.i(101884);
        ab.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.bER.hlB.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localo = (o)localIterator.next();
        if (localo.hlV == null)
        {
          localLinkedList.add(localo);
          continue;
        }
        if (localo.hlV.fQD > this.bER.ayW()) {
          continue;
        }
      }
      finally {}
      localCollection.add(localo);
    }
    this.bER.hlB.removeAll(localCollection);
    AppMethodBeat.o(101884);
  }
  
  public final void azl()
  {
    AppMethodBeat.i(101885);
    ab.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    AppMethodBeat.o(101885);
  }
  
  public final void da(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101866);
    ab.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2)
    {
      AppMethodBeat.o(101866);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.hme.get(Integer.valueOf(paramInt1)) != null) && (l - ((Long)this.hme.get(Integer.valueOf(paramInt1))).longValue() < 3000L))
    {
      ab.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
      AppMethodBeat.o(101866);
      return;
    }
    this.hme.put(Integer.valueOf(paramInt1), Long.valueOf(l));
    Object localObject = new cut();
    ((cut)localObject).ydg = this.bER.hlk;
    ((cut)localObject).ydt = paramInt1;
    ((cut)localObject).ydu = paramInt2;
    localObject = t.a(1005, (a)localObject);
    this.hlO.a((ctv)localObject);
    this.bER.hlu = System.currentTimeMillis();
    AppMethodBeat.o(101866);
  }
  
  public final void db(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      o localo;
      try
      {
        AppMethodBeat.i(101883);
        ab.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.bER.hlB.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localo = (o)localIterator.next();
        if (localo.hlV == null)
        {
          localLinkedList.add(localo);
          continue;
        }
        if (localo.hlV.fQD < paramInt1) {
          continue;
        }
      }
      finally {}
      if (localo.hlV.fQD <= paramInt2) {
        localCollection.add(localo);
      }
    }
    this.bER.hlB.removeAll(localCollection);
    AppMethodBeat.o(101883);
  }
  
  public final void quit()
  {
    AppMethodBeat.i(101881);
    ab.i("MicroMsg.RemoteDebugMsgMrg", "quit");
    Object localObject = new cus();
    ((cus)localObject).ydg = this.bER.hlk;
    localObject = t.a(1004, (a)localObject);
    this.hlO.a((ctv)localObject);
    AppMethodBeat.o(101881);
  }
  
  final void u(LinkedList<ctw> paramLinkedList)
  {
    AppMethodBeat.i(101867);
    if (bo.es(paramLinkedList))
    {
      ab.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
      AppMethodBeat.o(101867);
      return;
    }
    Iterator localIterator = v(paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ctw)localIterator.next();
      byte[] arrayOfByte;
      label83:
      int i;
      if (t.nD(((ctw)localObject).xKQ))
      {
        arrayOfByte = com.tencent.mm.a.r.A(((ctw)localObject).wPX.pW);
        localObject = ((ctw)localObject).category;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        }
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          a((ctr)new ctr().parseFrom(arrayOfByte));
          break;
          arrayOfByte = ((ctw)localObject).wPX.pW;
          break label83;
          if (((String)localObject).equals("callInterface"))
          {
            i = 0;
            continue;
            if (((String)localObject).equals("evaluateJavascriptResult"))
            {
              i = 1;
              continue;
              if (((String)localObject).equals("ping"))
              {
                i = 2;
                continue;
                if (((String)localObject).equals("breakpoint"))
                {
                  i = 3;
                  continue;
                  if (((String)localObject).equals("domOp"))
                  {
                    i = 4;
                    continue;
                    if (((String)localObject).equals("chromeDevtools")) {
                      i = 5;
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      a((cub)new cub().parseFrom(arrayOfByte));
      continue;
      a((cuf)new cuf().parseFrom(arrayOfByte));
      continue;
      a((ctq)new ctq().parseFrom(arrayOfByte));
      continue;
      a((ctz)new ctz().parseFrom(arrayOfByte));
      continue;
      a((ctt)new ctt().parseFrom(arrayOfByte));
    }
    ab.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.bER.ayV()) });
    this.bER.nC(paramLinkedList.size());
    azf();
    AppMethodBeat.o(101867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.p
 * JD-Core Version:    0.7.0.1
 */