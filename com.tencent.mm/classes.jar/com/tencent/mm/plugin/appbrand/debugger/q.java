package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.v8.V8Inspector;
import com.eclipsesource.v8.V8Inspector.JsInspectorChannelServer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.eva;
import com.tencent.mm.protocal.protobuf.evb;
import com.tencent.mm.protocal.protobuf.evc;
import com.tencent.mm.protocal.protobuf.evd;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.evj;
import com.tencent.mm.protocal.protobuf.evl;
import com.tencent.mm.protocal.protobuf.evn;
import com.tencent.mm.protocal.protobuf.evp;
import com.tencent.mm.protocal.protobuf.evq;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.evt;
import com.tencent.mm.protocal.protobuf.evw;
import com.tencent.mm.protocal.protobuf.ewc;
import com.tencent.mm.protocal.protobuf.ewd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;

public final class q
{
  private static final Map<String, String[]> liH;
  m cBt;
  private LruCache<Integer, Long> liI;
  private boolean liJ;
  private long liK;
  private LinkedList<p> liL;
  private final int liM;
  private int liN;
  private long liO;
  u liu;
  w lix;
  Timer mTimer;
  
  static
  {
    AppMethodBeat.i(147077);
    HashMap localHashMap = new HashMap();
    liH = localHashMap;
    localHashMap.put("publishHandler", new String[] { "String", "String", "String" });
    liH.put("invokeHandler", new String[] { "String", "String", "Number" });
    AppMethodBeat.o(147077);
  }
  
  public q()
  {
    AppMethodBeat.i(147049);
    this.liI = new LruCache(100);
    this.liJ = false;
    this.liL = new LinkedList();
    this.liM = 5000;
    this.liN = 0;
    this.liO = 0L;
    V8Inspector.setServer(new V8Inspector.JsInspectorChannelServer()
    {
      public final int notify(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        return 0;
      }
      
      public final int sendData(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(147046);
        q.a(q.this, paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(147046);
        return 0;
      }
    });
    AppMethodBeat.o(147049);
  }
  
  private static int[] XV(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(147074);
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
      Log.e("MicroMsg.RemoteDebugMsgMrg", paramString.getMessage());
      localObject2 = localObject1;
      AppMethodBeat.o(147074);
    }
  }
  
  private void a(eva parameva)
  {
    AppMethodBeat.i(147057);
    if (this.cBt.bAI() == parameva.NsZ)
    {
      AppMethodBeat.o(147057);
      return;
    }
    if (parameva.NsZ) {
      this.cBt.gX(true);
    }
    for (;;)
    {
      this.lix.bAZ();
      this.lix.bBe();
      AppMethodBeat.o(147057);
      return;
      this.cBt.gX(false);
    }
  }
  
  private void a(evb paramevb)
  {
    AppMethodBeat.i(147051);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[] { paramevb.Ntb, Integer.valueOf(paramevb.Ntd) });
    String str = paramevb.Ntb;
    LinkedList localLinkedList1 = paramevb.Ntc;
    if (!liH.containsKey(str))
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
      AppMethodBeat.o(147051);
      return;
    }
    Object localObject = (String[])liH.get(str);
    if (localLinkedList1.size() < localObject.length)
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
      AppMethodBeat.o(147051);
      return;
    }
    LinkedList localLinkedList2 = new LinkedList();
    int i = 0;
    if (i < localObject.length)
    {
      if ("Number".equals(localObject[i])) {
        localLinkedList2.add(Integer.valueOf(Util.getInt((String)localLinkedList1.get(i), 0)));
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
        Log.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
        AppMethodBeat.o(147051);
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
    this.cBt.lhP.b((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), XV((String)String.class.cast(localLinkedList2.get(2))));
    localObject = null;
    label394:
    int j;
    if (localObject != null)
    {
      localObject = String.valueOf(localObject);
      if (!Util.isNullOrNil((String)localObject)) {
        ad(paramevb.Ntd, (String)localObject);
      }
      j = paramevb.computeSize();
      if (localObject != null) {
        break label509;
      }
    }
    label509:
    for (i = 0;; i = ((String)localObject).length())
    {
      r.a(str, localLinkedList1, l, j, i);
      AppMethodBeat.o(147051);
      return;
      localObject = this.cBt.lhP.y((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), ((Integer)Integer.class.cast(localLinkedList2.get(2))).intValue());
      break;
      localObject = "";
      break label394;
    }
  }
  
  private static void a(evd paramevd)
  {
    AppMethodBeat.i(147059);
    V8Inspector.onReceiveData(paramevd.Nte, paramevd.MiI);
    AppMethodBeat.o(147059);
  }
  
  private void a(evj paramevj)
  {
    AppMethodBeat.i(147058);
    Log.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
    int i = this.cBt.lhP.NP().brh().getCurrentPage().getCurrentPageView().getComponentId();
    if (paramevj.Ntn != i)
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[] { Integer.valueOf(paramevj.Ntn), Integer.valueOf(i) });
      AppMethodBeat.o(147058);
      return;
    }
    this.cBt.lhP.b("remoteDebugCommand", paramevj.Ntm, null);
    AppMethodBeat.o(147058);
  }
  
  private void a(evl paramevl)
  {
    AppMethodBeat.i(147061);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[] { Integer.valueOf(paramevl.Nto) });
    int i = paramevl.Nto;
    String str = paramevl.dNk;
    c localc = (c)this.cBt.lik.remove(Integer.valueOf(i));
    if (localc == null)
    {
      AppMethodBeat.o(147061);
      return;
    }
    ValueCallback localValueCallback = localc.lhF;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(str);
    }
    Log.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str);
    r.a(localc, paramevl.computeSize());
    AppMethodBeat.o(147061);
  }
  
  private void a(evp paramevp)
  {
    AppMethodBeat.i(147060);
    evq localevq = new evq();
    localevq.Ntr = paramevp.Ntr;
    localevq.KFy = r.bAX();
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[] { Integer.valueOf(localevq.KFy) });
    a(v.a(localevq, this.cBt, "pong"));
    AppMethodBeat.o(147060);
  }
  
  public static void a(evr paramevr)
  {
    AppMethodBeat.i(147050);
    paramevr.Nta = "WeixinJSCore";
    Iterator localIterator = liH.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((String[])liH.get(str)).length > 5)
      {
        Log.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
      }
      else
      {
        evn localevn = new evn();
        localevn.Ntb = str;
        int i = 0;
        while (i < ((String[])liH.get(str)).length)
        {
          localevn.Ntc.add(((String[])liH.get(str))[i]);
          i += 1;
        }
        paramevr.Nts.add(localevn);
      }
    }
    AppMethodBeat.o(147050);
  }
  
  private void a(LinkedList<p> paramLinkedList, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(147064);
      a(paramLinkedList, paramBoolean, false);
      AppMethodBeat.o(147064);
      return;
    }
    finally
    {
      paramLinkedList = finally;
      throw paramLinkedList;
    }
  }
  
  private void a(LinkedList<p> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    try
    {
      AppMethodBeat.i(147065);
      if (Util.isNullOrNil(paramLinkedList))
      {
        AppMethodBeat.o(147065);
        return;
      }
      localObject = new evt();
      ((evt)localObject).Nty = this.cBt.lhQ;
      ((evt)localObject).Ntz = this.cBt.bAG();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        ((evt)localObject).Ntp.add(localp.liB);
      }
      localObject = v.a(1006, (a)localObject);
    }
    finally {}
    if ((!this.cBt.isBusy()) || (paramBoolean2))
    {
      Log.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
      this.liu.a((evf)localObject);
    }
    for (;;)
    {
      if (paramBoolean1) {
        x(paramLinkedList);
      }
      paramLinkedList = this.cBt;
      paramLinkedList.lhX = System.currentTimeMillis();
      paramLinkedList.lhZ = System.currentTimeMillis();
      if (!this.cBt.isBusy()) {
        this.liN = 0;
      }
      paramLinkedList = new l();
      paramLinkedList.size = ((evf)localObject).computeSize();
      paramLinkedList.lhG = System.currentTimeMillis();
      this.cBt.lii.put(((evf)localObject).uuid, paramLinkedList);
      AppMethodBeat.o(147065);
      break;
      Log.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
    }
  }
  
  private void bAP()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(147053);
        i = 0;
        if (i < this.cBt.lij.size())
        {
          int j;
          if (i == 0)
          {
            j = this.cBt.bAG();
            int k = ((evg)this.cBt.lij.get(i)).jlm;
            if (j - k != 1) {
              dT(j + 1, k - 1);
            }
          }
          else
          {
            j = ((evg)this.cBt.lij.get(i - 1)).jlm;
            continue;
          }
        }
        else
        {
          AppMethodBeat.o(147053);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  private void bAQ()
  {
    AppMethodBeat.i(147063);
    long l = System.currentTimeMillis();
    for (;;)
    {
      synchronized (this.cBt.mLock)
      {
        if ((this.liJ) && (l - this.liK < 32L))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.liK = l;
        if (Util.isNullOrNil(this.liL))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.liJ = true;
        i = (int)(16L - (System.currentTimeMillis() - this.cBt.lhX));
        if (i > 0)
        {
          f.bZn().j(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(147047);
              LinkedList localLinkedList = new LinkedList();
              synchronized (q.a(q.this).mLock)
              {
                localLinkedList.addAll(q.b(q.this));
                q.b(q.this).clear();
                q.c(q.this);
                q.a(q.this, localLinkedList);
                AppMethodBeat.o(147047);
                return;
              }
            }
          }, i);
          AppMethodBeat.o(147063);
          return;
        }
      }
      int i = 16;
    }
  }
  
  private LinkedList<evg> w(LinkedList<evg> paramLinkedList)
  {
    for (;;)
    {
      LinkedList localLinkedList1;
      LinkedList localLinkedList2;
      evg localevg;
      try
      {
        AppMethodBeat.i(147056);
        if (paramLinkedList == null)
        {
          paramLinkedList = null;
          AppMethodBeat.o(147056);
          return paramLinkedList;
        }
        localLinkedList1 = new LinkedList();
        localLinkedList2 = new LinkedList();
        this.cBt.lij.addAll(paramLinkedList);
        Collections.sort(this.cBt.lij, new Comparator() {});
        i = this.cBt.bAG();
        paramLinkedList = this.cBt.lij.iterator();
        if (!paramLinkedList.hasNext()) {
          break label167;
        }
        localevg = (evg)paramLinkedList.next();
        if (localevg == null) {
          continue;
        }
        if (localevg.jlm <= i)
        {
          localLinkedList2.add(localevg);
          continue;
        }
        if (localevg.jlm - i != 1) {
          break label167;
        }
      }
      finally {}
      localLinkedList1.add(localevg);
      int i = localevg.jlm;
      continue;
      label167:
      this.cBt.wi(i);
      this.cBt.lij.removeAll(localLinkedList1);
      this.cBt.lij.removeAll(localLinkedList2);
      Log.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
      AppMethodBeat.o(147056);
      paramLinkedList = localLinkedList1;
    }
  }
  
  /* Error */
  private void x(LinkedList<p> paramLinkedList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 631
    //   5: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 123
    //   10: ldc_w 633
    //   13: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokestatic 492	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   20: ifeq +12 -> 32
    //   23: ldc_w 631
    //   26: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 137	com/tencent/mm/plugin/appbrand/debugger/q:cBt	Lcom/tencent/mm/plugin/appbrand/debugger/m;
    //   36: getfield 636	com/tencent/mm/plugin/appbrand/debugger/m:lih	Ljava/util/LinkedList;
    //   39: aload_1
    //   40: invokevirtual 614	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   43: pop
    //   44: ldc_w 631
    //   47: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: goto -21 -> 29
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	q
    //   0	58	1	paramLinkedList	LinkedList<p>
    // Exception table:
    //   from	to	target	type
    //   2	29	53	finally
    //   32	50	53	finally
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(147062);
    if (!this.cBt.bAK()) {}
    synchronized (this.cBt.mLock)
    {
      if ((System.currentTimeMillis() - this.cBt.lhX <= 16L) || (this.liJ))
      {
        this.liL.add(paramp);
        bAQ();
        AppMethodBeat.o(147062);
        return;
      }
      ??? = new LinkedList();
      ((LinkedList)???).add(paramp);
      a((LinkedList)???, true);
      AppMethodBeat.o(147062);
      return;
    }
  }
  
  public final void a(u paramu, m paramm, w paramw)
  {
    this.liu = paramu;
    this.cBt = paramm;
    this.lix = paramw;
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(147052);
    evc localevc = new evc();
    localevc.Ntd = paramInt;
    localevc.dNk = paramString;
    a(v.a(localevc, this.cBt, "callInterfaceResult"));
    AppMethodBeat.o(147052);
  }
  
  public final void bAR()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(147067);
      if (this.cBt.isBusy())
      {
        AppMethodBeat.o(147067);
        return;
      }
      long l = System.currentTimeMillis();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.cBt.lih.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          p localp = (p)localIterator.next();
          if (l - localp.lhG > 5000L)
          {
            localp.lhG = System.currentTimeMillis();
            localLinkedList.add(localp);
            i = localp.liC + i;
            if ((i >= 65536L) || (localLinkedList.size() > 800))
            {
              Log.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
              a(localLinkedList, false);
              localLinkedList.clear();
            }
          }
        }
        else
        {
          if (!Util.isNullOrNil(localLinkedList))
          {
            Log.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
            a(localLinkedList, false);
          }
          AppMethodBeat.o(147067);
          break;
        }
      }
    }
    finally {}
  }
  
  public final boolean bAS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(147068);
        long l = System.currentTimeMillis();
        if (l - this.liO < this.liN)
        {
          AppMethodBeat.o(147068);
          bool = false;
          return bool;
        }
        this.liO = l;
        if (this.liN < 5000)
        {
          this.liN += 1000;
          LinkedList localLinkedList1 = new LinkedList();
          localObject = this.cBt.lih.iterator();
          if (((Iterator)localObject).hasNext())
          {
            p localp = (p)((Iterator)localObject).next();
            if (l - localp.lhG <= 5000L) {
              continue;
            }
            localp.lhG = System.currentTimeMillis();
            localLinkedList1.add(localp);
            a(localLinkedList1, false, true);
            AppMethodBeat.o(147068);
            bool = true;
          }
        }
        else
        {
          this.liN = 2000;
          continue;
        }
        if (this.cBt.lih.size() <= 0) {
          break label239;
        }
      }
      finally {}
      Object localObject = (p)this.cBt.lih.get(0);
      ((p)localObject).lhG = System.currentTimeMillis();
      localLinkedList2.add(localObject);
      a(localLinkedList2, false, true);
      AppMethodBeat.o(147068);
      boolean bool = true;
      continue;
      label239:
      AppMethodBeat.o(147068);
      bool = false;
    }
  }
  
  final void bAT()
  {
    AppMethodBeat.i(147070);
    this.cBt.setStatus(4);
    this.liu.XX("quit");
    AppMethodBeat.o(147070);
  }
  
  public final void bAU()
  {
    for (;;)
    {
      p localp;
      try
      {
        AppMethodBeat.i(147072);
        Log.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.cBt.lih.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localp = (p)localIterator.next();
        if (localp.liB == null)
        {
          localLinkedList.add(localp);
          continue;
        }
        if (localp.liB.jlm > this.cBt.bAH()) {
          continue;
        }
      }
      finally {}
      localCollection.add(localp);
    }
    this.cBt.lih.removeAll(localCollection);
    AppMethodBeat.o(147072);
  }
  
  public final void bAV()
  {
    AppMethodBeat.i(147073);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    AppMethodBeat.o(147073);
  }
  
  public final void dT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147054);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2)
    {
      AppMethodBeat.o(147054);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.liI.get(Integer.valueOf(paramInt1)) != null) && (l - ((Long)this.liI.get(Integer.valueOf(paramInt1))).longValue() < 3000L))
    {
      Log.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
      AppMethodBeat.o(147054);
      return;
    }
    this.liI.put(Integer.valueOf(paramInt1), Long.valueOf(l));
    Object localObject = new ewd();
    ((ewd)localObject).Nty = this.cBt.lhQ;
    ((ewd)localObject).NtL = paramInt1;
    ((ewd)localObject).NtM = paramInt2;
    localObject = v.a(1005, (a)localObject);
    this.liu.a((evf)localObject);
    this.cBt.lia = System.currentTimeMillis();
    AppMethodBeat.o(147054);
  }
  
  public final void dU(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      p localp;
      try
      {
        AppMethodBeat.i(147071);
        Log.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.cBt.lih.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localp = (p)localIterator.next();
        if (localp.liB == null)
        {
          localLinkedList.add(localp);
          continue;
        }
        if (localp.liB.jlm < paramInt1) {
          continue;
        }
      }
      finally {}
      if (localp.liB.jlm <= paramInt2) {
        localCollection.add(localp);
      }
    }
    this.cBt.lih.removeAll(localCollection);
    AppMethodBeat.o(147071);
  }
  
  public final void quit()
  {
    AppMethodBeat.i(147069);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "quit");
    Object localObject = new ewc();
    ((ewc)localObject).Nty = this.cBt.lhQ;
    localObject = v.a(1004, (a)localObject);
    this.liu.a((evf)localObject);
    AppMethodBeat.o(147069);
  }
  
  final void v(LinkedList<evg> paramLinkedList)
  {
    AppMethodBeat.i(147055);
    if (Util.isNullOrNil(paramLinkedList))
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
      AppMethodBeat.o(147055);
      return;
    }
    Iterator localIterator = w(paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (evg)localIterator.next();
      byte[] arrayOfByte;
      label83:
      int i;
      if (v.wl(((evg)localObject).MVo))
      {
        arrayOfByte = s.T(((evg)localObject).LrK.zy);
        localObject = ((evg)localObject).category;
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
          a((evb)new evb().parseFrom(arrayOfByte));
          break;
          arrayOfByte = ((evg)localObject).LrK.zy;
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
      a((evl)new evl().parseFrom(arrayOfByte));
      continue;
      a((evp)new evp().parseFrom(arrayOfByte));
      continue;
      a((eva)new eva().parseFrom(arrayOfByte));
      continue;
      a((evj)new evj().parseFrom(arrayOfByte));
      continue;
      a((evd)new evd().parseFrom(arrayOfByte));
    }
    Log.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.cBt.bAG()) });
    this.cBt.wk(paramLinkedList.size());
    bAP();
    AppMethodBeat.o(147055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.q
 * JD-Core Version:    0.7.0.1
 */