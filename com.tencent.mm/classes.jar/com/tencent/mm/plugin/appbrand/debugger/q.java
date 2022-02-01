package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.v8.V8Inspector;
import com.eclipsesource.v8.V8Inspector.JsInspectorChannelServer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzl;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.protocal.protobuf.dzy;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final Map<String, String[]> kbH;
  m coY;
  private ag<Integer, Long> kbI;
  private boolean kbJ;
  private long kbK;
  private LinkedList<p> kbL;
  private final int kbM;
  private int kbN;
  private long kbO;
  u kbu;
  w kbx;
  Timer mTimer;
  
  static
  {
    AppMethodBeat.i(147077);
    HashMap localHashMap = new HashMap();
    kbH = localHashMap;
    localHashMap.put("publishHandler", new String[] { "String", "String", "String" });
    kbH.put("invokeHandler", new String[] { "String", "String", "Number" });
    AppMethodBeat.o(147077);
  }
  
  public q()
  {
    AppMethodBeat.i(147049);
    this.kbI = new ag(100);
    this.kbJ = false;
    this.kbL = new LinkedList();
    this.kbM = 5000;
    this.kbN = 0;
    this.kbO = 0L;
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
  
  private static int[] Od(String paramString)
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
      ad.e("MicroMsg.RemoteDebugMsgMrg", paramString.getMessage());
      localObject2 = localObject1;
      AppMethodBeat.o(147074);
    }
  }
  
  private void a(dzc paramdzc)
  {
    AppMethodBeat.i(147057);
    if (this.coY.beH() == paramdzc.HMu)
    {
      AppMethodBeat.o(147057);
      return;
    }
    if (paramdzc.HMu) {
      this.coY.gb(true);
    }
    for (;;)
    {
      this.kbx.beY();
      this.kbx.bfd();
      AppMethodBeat.o(147057);
      return;
      this.coY.gb(false);
    }
  }
  
  private void a(dzd paramdzd)
  {
    AppMethodBeat.i(147051);
    ad.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[] { paramdzd.HMw, Integer.valueOf(paramdzd.HMy) });
    String str = paramdzd.HMw;
    LinkedList localLinkedList1 = paramdzd.HMx;
    if (!kbH.containsKey(str))
    {
      ad.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
      AppMethodBeat.o(147051);
      return;
    }
    Object localObject = (String[])kbH.get(str);
    if (localLinkedList1.size() < localObject.length)
    {
      ad.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
      AppMethodBeat.o(147051);
      return;
    }
    LinkedList localLinkedList2 = new LinkedList();
    int i = 0;
    if (i < localObject.length)
    {
      if ("Number".equals(localObject[i])) {
        localLinkedList2.add(Integer.valueOf(bt.getInt((String)localLinkedList1.get(i), 0)));
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
        ad.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
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
    this.coY.kaO.b((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), Od((String)String.class.cast(localLinkedList2.get(2))));
    localObject = null;
    label394:
    int j;
    if (localObject != null)
    {
      localObject = String.valueOf(localObject);
      if (!bt.isNullOrNil((String)localObject)) {
        Z(paramdzd.HMy, (String)localObject);
      }
      j = paramdzd.computeSize();
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
      localObject = this.coY.kaO.y((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), ((Integer)Integer.class.cast(localLinkedList2.get(2))).intValue());
      break;
      localObject = "";
      break label394;
    }
  }
  
  private static void a(dzf paramdzf)
  {
    AppMethodBeat.i(147059);
    V8Inspector.onReceiveData(paramdzf.HMz, paramdzf.GKe);
    AppMethodBeat.o(147059);
  }
  
  private void a(dzl paramdzl)
  {
    AppMethodBeat.i(147058);
    ad.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
    int i = this.coY.kaO.En().aVN().getCurrentPage().getCurrentPageView().aXC();
    if (paramdzl.HMI != i)
    {
      ad.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[] { Integer.valueOf(paramdzl.HMI), Integer.valueOf(i) });
      AppMethodBeat.o(147058);
      return;
    }
    this.coY.kaO.b("remoteDebugCommand", paramdzl.HMH, null);
    AppMethodBeat.o(147058);
  }
  
  private void a(dzn paramdzn)
  {
    AppMethodBeat.i(147061);
    ad.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[] { Integer.valueOf(paramdzn.HMJ) });
    int i = paramdzn.HMJ;
    String str = paramdzn.duy;
    c localc = (c)this.coY.kbj.remove(Integer.valueOf(i));
    if (localc == null)
    {
      AppMethodBeat.o(147061);
      return;
    }
    ValueCallback localValueCallback = localc.kaI;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(str);
    }
    ad.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str);
    r.a(localc, paramdzn.computeSize());
    AppMethodBeat.o(147061);
  }
  
  private void a(dzr paramdzr)
  {
    AppMethodBeat.i(147060);
    dzs localdzs = new dzs();
    localdzs.HMM = paramdzr.HMM;
    localdzs.Fty = r.beW();
    ad.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[] { Integer.valueOf(localdzs.Fty) });
    a(v.a(localdzs, this.coY, "pong"));
    AppMethodBeat.o(147060);
  }
  
  public static void a(dzt paramdzt)
  {
    AppMethodBeat.i(147050);
    paramdzt.HMv = "WeixinJSCore";
    Iterator localIterator = kbH.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((String[])kbH.get(str)).length > 5)
      {
        ad.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
      }
      else
      {
        dzp localdzp = new dzp();
        localdzp.HMw = str;
        int i = 0;
        while (i < ((String[])kbH.get(str)).length)
        {
          localdzp.HMx.add(((String[])kbH.get(str))[i]);
          i += 1;
        }
        paramdzt.HMN.add(localdzp);
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
      if (bt.hj(paramLinkedList))
      {
        AppMethodBeat.o(147065);
        return;
      }
      localObject = new dzv();
      ((dzv)localObject).HMT = this.coY.kaP;
      ((dzv)localObject).HMU = this.coY.beF();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        ((dzv)localObject).HMK.add(localp.kbB);
      }
      localObject = v.a(1006, (a)localObject);
    }
    finally {}
    if ((!this.coY.isBusy()) || (paramBoolean2))
    {
      ad.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
      this.kbu.a((dzh)localObject);
    }
    for (;;)
    {
      if (paramBoolean1) {
        x(paramLinkedList);
      }
      paramLinkedList = this.coY;
      paramLinkedList.kaW = System.currentTimeMillis();
      paramLinkedList.kaY = System.currentTimeMillis();
      if (!this.coY.isBusy()) {
        this.kbN = 0;
      }
      paramLinkedList = new l();
      paramLinkedList.size = ((dzh)localObject).computeSize();
      paramLinkedList.kaJ = System.currentTimeMillis();
      this.coY.kbh.put(((dzh)localObject).uuid, paramLinkedList);
      AppMethodBeat.o(147065);
      break;
      ad.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
    }
  }
  
  private void beO()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(147053);
        i = 0;
        if (i < this.coY.kbi.size())
        {
          int j;
          if (i == 0)
          {
            j = this.coY.beF();
            int k = ((dzi)this.coY.kbi.get(i)).inh;
            if (j - k != 1) {
              dI(j + 1, k - 1);
            }
          }
          else
          {
            j = ((dzi)this.coY.kbi.get(i - 1)).inh;
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
  
  private void beP()
  {
    AppMethodBeat.i(147063);
    long l = System.currentTimeMillis();
    for (;;)
    {
      synchronized (this.coY.mLock)
      {
        if ((this.kbJ) && (l - this.kbK < 32L))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.kbK = l;
        if (bt.hj(this.kbL))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.kbJ = true;
        i = (int)(16L - (System.currentTimeMillis() - this.coY.kaW));
        if (i > 0)
        {
          e.bBp().k(new Runnable()
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
  
  private LinkedList<dzi> w(LinkedList<dzi> paramLinkedList)
  {
    for (;;)
    {
      LinkedList localLinkedList1;
      LinkedList localLinkedList2;
      dzi localdzi;
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
        this.coY.kbi.addAll(paramLinkedList);
        Collections.sort(this.coY.kbi, new Comparator() {});
        i = this.coY.beF();
        paramLinkedList = this.coY.kbi.iterator();
        if (!paramLinkedList.hasNext()) {
          break label167;
        }
        localdzi = (dzi)paramLinkedList.next();
        if (localdzi == null) {
          continue;
        }
        if (localdzi.inh <= i)
        {
          localLinkedList2.add(localdzi);
          continue;
        }
        if (localdzi.inh - i != 1) {
          break label167;
        }
      }
      finally {}
      localLinkedList1.add(localdzi);
      int i = localdzi.inh;
      continue;
      label167:
      this.coY.sj(i);
      this.coY.kbi.removeAll(localLinkedList1);
      this.coY.kbi.removeAll(localLinkedList2);
      ad.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
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
    //   13: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokestatic 492	com/tencent/mm/sdk/platformtools/bt:hj	(Ljava/util/List;)Z
    //   20: ifeq +12 -> 32
    //   23: ldc_w 631
    //   26: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 137	com/tencent/mm/plugin/appbrand/debugger/q:coY	Lcom/tencent/mm/plugin/appbrand/debugger/m;
    //   36: getfield 636	com/tencent/mm/plugin/appbrand/debugger/m:kbg	Ljava/util/LinkedList;
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
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(147052);
    dze localdze = new dze();
    localdze.HMy = paramInt;
    localdze.duy = paramString;
    a(v.a(localdze, this.coY, "callInterfaceResult"));
    AppMethodBeat.o(147052);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(147062);
    if (!this.coY.beJ()) {}
    synchronized (this.coY.mLock)
    {
      if ((System.currentTimeMillis() - this.coY.kaW <= 16L) || (this.kbJ))
      {
        this.kbL.add(paramp);
        beP();
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
    this.kbu = paramu;
    this.coY = paramm;
    this.kbx = paramw;
  }
  
  public final void beQ()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(147067);
      if (this.coY.isBusy())
      {
        AppMethodBeat.o(147067);
        return;
      }
      long l = System.currentTimeMillis();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.coY.kbg.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          p localp = (p)localIterator.next();
          if (l - localp.kaJ > 5000L)
          {
            localp.kaJ = System.currentTimeMillis();
            localLinkedList.add(localp);
            i = localp.kbC + i;
            if ((i >= 65536L) || (localLinkedList.size() > 800))
            {
              ad.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
              a(localLinkedList, false);
              localLinkedList.clear();
            }
          }
        }
        else
        {
          if (!bt.hj(localLinkedList))
          {
            ad.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
            a(localLinkedList, false);
          }
          AppMethodBeat.o(147067);
          break;
        }
      }
    }
    finally {}
  }
  
  public final boolean beR()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(147068);
        long l = System.currentTimeMillis();
        if (l - this.kbO < this.kbN)
        {
          AppMethodBeat.o(147068);
          bool = false;
          return bool;
        }
        this.kbO = l;
        if (this.kbN < 5000)
        {
          this.kbN += 1000;
          LinkedList localLinkedList1 = new LinkedList();
          localObject = this.coY.kbg.iterator();
          if (((Iterator)localObject).hasNext())
          {
            p localp = (p)((Iterator)localObject).next();
            if (l - localp.kaJ <= 5000L) {
              continue;
            }
            localp.kaJ = System.currentTimeMillis();
            localLinkedList1.add(localp);
            a(localLinkedList1, false, true);
            AppMethodBeat.o(147068);
            bool = true;
          }
        }
        else
        {
          this.kbN = 2000;
          continue;
        }
        if (this.coY.kbg.size() <= 0) {
          break label239;
        }
      }
      finally {}
      Object localObject = (p)this.coY.kbg.get(0);
      ((p)localObject).kaJ = System.currentTimeMillis();
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
  
  final void beS()
  {
    AppMethodBeat.i(147070);
    this.coY.setStatus(4);
    this.kbu.Of("quit");
    AppMethodBeat.o(147070);
  }
  
  public final void beT()
  {
    for (;;)
    {
      p localp;
      try
      {
        AppMethodBeat.i(147072);
        ad.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.coY.kbg.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localp = (p)localIterator.next();
        if (localp.kbB == null)
        {
          localLinkedList.add(localp);
          continue;
        }
        if (localp.kbB.inh > this.coY.beG()) {
          continue;
        }
      }
      finally {}
      localCollection.add(localp);
    }
    this.coY.kbg.removeAll(localCollection);
    AppMethodBeat.o(147072);
  }
  
  public final void beU()
  {
    AppMethodBeat.i(147073);
    ad.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    AppMethodBeat.o(147073);
  }
  
  public final void dI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147054);
    ad.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2)
    {
      AppMethodBeat.o(147054);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.kbI.get(Integer.valueOf(paramInt1)) != null) && (l - ((Long)this.kbI.get(Integer.valueOf(paramInt1))).longValue() < 3000L))
    {
      ad.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
      AppMethodBeat.o(147054);
      return;
    }
    this.kbI.put(Integer.valueOf(paramInt1), Long.valueOf(l));
    Object localObject = new eaf();
    ((eaf)localObject).HMT = this.coY.kaP;
    ((eaf)localObject).HNg = paramInt1;
    ((eaf)localObject).HNh = paramInt2;
    localObject = v.a(1005, (a)localObject);
    this.kbu.a((dzh)localObject);
    this.coY.kaZ = System.currentTimeMillis();
    AppMethodBeat.o(147054);
  }
  
  public final void dJ(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      p localp;
      try
      {
        AppMethodBeat.i(147071);
        ad.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.coY.kbg.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localp = (p)localIterator.next();
        if (localp.kbB == null)
        {
          localLinkedList.add(localp);
          continue;
        }
        if (localp.kbB.inh < paramInt1) {
          continue;
        }
      }
      finally {}
      if (localp.kbB.inh <= paramInt2) {
        localCollection.add(localp);
      }
    }
    this.coY.kbg.removeAll(localCollection);
    AppMethodBeat.o(147071);
  }
  
  public final void quit()
  {
    AppMethodBeat.i(147069);
    ad.i("MicroMsg.RemoteDebugMsgMrg", "quit");
    Object localObject = new eae();
    ((eae)localObject).HMT = this.coY.kaP;
    localObject = v.a(1004, (a)localObject);
    this.kbu.a((dzh)localObject);
    AppMethodBeat.o(147069);
  }
  
  final void v(LinkedList<dzi> paramLinkedList)
  {
    AppMethodBeat.i(147055);
    if (bt.hj(paramLinkedList))
    {
      ad.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
      AppMethodBeat.o(147055);
      return;
    }
    Iterator localIterator = w(paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (dzi)localIterator.next();
      byte[] arrayOfByte;
      label83:
      int i;
      if (v.sm(((dzi)localObject).HpZ))
      {
        arrayOfByte = s.F(((dzi)localObject).Gdx.zr);
        localObject = ((dzi)localObject).category;
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
          a((dzd)new dzd().parseFrom(arrayOfByte));
          break;
          arrayOfByte = ((dzi)localObject).Gdx.zr;
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
      a((dzn)new dzn().parseFrom(arrayOfByte));
      continue;
      a((dzr)new dzr().parseFrom(arrayOfByte));
      continue;
      a((dzc)new dzc().parseFrom(arrayOfByte));
      continue;
      a((dzl)new dzl().parseFrom(arrayOfByte));
      continue;
      a((dzf)new dzf().parseFrom(arrayOfByte));
    }
    ad.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.coY.beF()) });
    this.coY.sl(paramLinkedList.size());
    beO();
    AppMethodBeat.o(147055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.q
 * JD-Core Version:    0.7.0.1
 */