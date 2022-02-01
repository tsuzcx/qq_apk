package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.v8.V8Inspector;
import com.eclipsesource.v8.V8Inspector.JsInspectorChannelServer;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.protocal.protobuf.eau;
import com.tencent.mm.protocal.protobuf.eav;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebg;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.ebk;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.ebv;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static final Map<String, String[]> keY;
  m cpc;
  u keL;
  w keO;
  private ah<Integer, Long> keZ;
  private boolean kfa;
  private long kfb;
  private LinkedList<p> kfc;
  private final int kfd;
  private int kfe;
  private long kff;
  Timer mTimer;
  
  static
  {
    AppMethodBeat.i(147077);
    HashMap localHashMap = new HashMap();
    keY = localHashMap;
    localHashMap.put("publishHandler", new String[] { "String", "String", "String" });
    keY.put("invokeHandler", new String[] { "String", "String", "Number" });
    AppMethodBeat.o(147077);
  }
  
  public q()
  {
    AppMethodBeat.i(147049);
    this.keZ = new ah(100);
    this.kfa = false;
    this.kfc = new LinkedList();
    this.kfd = 5000;
    this.kfe = 0;
    this.kff = 0L;
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
  
  private static int[] OK(String paramString)
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
      ae.e("MicroMsg.RemoteDebugMsgMrg", paramString.getMessage());
      localObject2 = localObject1;
      AppMethodBeat.o(147074);
    }
  }
  
  private void a(eat parameat)
  {
    AppMethodBeat.i(147057);
    if (this.cpc.bfp() == parameat.IgB)
    {
      AppMethodBeat.o(147057);
      return;
    }
    if (parameat.IgB) {
      this.cpc.ga(true);
    }
    for (;;)
    {
      this.keO.bfG();
      this.keO.bfL();
      AppMethodBeat.o(147057);
      return;
      this.cpc.ga(false);
    }
  }
  
  private void a(eau parameau)
  {
    AppMethodBeat.i(147051);
    ae.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[] { parameau.IgD, Integer.valueOf(parameau.IgF) });
    String str = parameau.IgD;
    LinkedList localLinkedList1 = parameau.IgE;
    if (!keY.containsKey(str))
    {
      ae.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
      AppMethodBeat.o(147051);
      return;
    }
    Object localObject = (String[])keY.get(str);
    if (localLinkedList1.size() < localObject.length)
    {
      ae.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
      AppMethodBeat.o(147051);
      return;
    }
    LinkedList localLinkedList2 = new LinkedList();
    int i = 0;
    if (i < localObject.length)
    {
      if ("Number".equals(localObject[i])) {
        localLinkedList2.add(Integer.valueOf(bu.getInt((String)localLinkedList1.get(i), 0)));
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
        ae.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
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
    this.cpc.kee.b((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), OK((String)String.class.cast(localLinkedList2.get(2))));
    localObject = null;
    label394:
    int j;
    if (localObject != null)
    {
      localObject = String.valueOf(localObject);
      if (!bu.isNullOrNil((String)localObject)) {
        Z(parameau.IgF, (String)localObject);
      }
      j = parameau.computeSize();
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
      localObject = this.cpc.kee.y((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), ((Integer)Integer.class.cast(localLinkedList2.get(2))).intValue());
      break;
      localObject = "";
      break label394;
    }
  }
  
  private static void a(eaw parameaw)
  {
    AppMethodBeat.i(147059);
    V8Inspector.onReceiveData(parameaw.IgG, parameaw.HdF);
    AppMethodBeat.o(147059);
  }
  
  private void a(ebc paramebc)
  {
    AppMethodBeat.i(147058);
    ae.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
    int i = this.cpc.kee.Eq().aWm().getCurrentPage().getCurrentPageView().aXX();
    if (paramebc.IgP != i)
    {
      ae.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[] { Integer.valueOf(paramebc.IgP), Integer.valueOf(i) });
      AppMethodBeat.o(147058);
      return;
    }
    this.cpc.kee.b("remoteDebugCommand", paramebc.IgO, null);
    AppMethodBeat.o(147058);
  }
  
  private void a(ebe paramebe)
  {
    AppMethodBeat.i(147061);
    ae.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[] { Integer.valueOf(paramebe.IgQ) });
    int i = paramebe.IgQ;
    String str = paramebe.dvD;
    c localc = (c)this.cpc.keA.remove(Integer.valueOf(i));
    if (localc == null)
    {
      AppMethodBeat.o(147061);
      return;
    }
    ValueCallback localValueCallback = localc.kdY;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(str);
    }
    ae.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str);
    r.a(localc, paramebe.computeSize());
    AppMethodBeat.o(147061);
  }
  
  private void a(ebi paramebi)
  {
    AppMethodBeat.i(147060);
    ebj localebj = new ebj();
    localebj.IgT = paramebi.IgT;
    localebj.FLW = r.bfE();
    ae.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[] { Integer.valueOf(localebj.FLW) });
    a(v.a(localebj, this.cpc, "pong"));
    AppMethodBeat.o(147060);
  }
  
  public static void a(ebk paramebk)
  {
    AppMethodBeat.i(147050);
    paramebk.IgC = "WeixinJSCore";
    Iterator localIterator = keY.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((String[])keY.get(str)).length > 5)
      {
        ae.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
      }
      else
      {
        ebg localebg = new ebg();
        localebg.IgD = str;
        int i = 0;
        while (i < ((String[])keY.get(str)).length)
        {
          localebg.IgE.add(((String[])keY.get(str))[i]);
          i += 1;
        }
        paramebk.IgU.add(localebg);
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
      if (bu.ht(paramLinkedList))
      {
        AppMethodBeat.o(147065);
        return;
      }
      localObject = new ebm();
      ((ebm)localObject).Iha = this.cpc.kef;
      ((ebm)localObject).Ihb = this.cpc.bfn();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        ((ebm)localObject).IgR.add(localp.keS);
      }
      localObject = v.a(1006, (a)localObject);
    }
    finally {}
    if ((!this.cpc.isBusy()) || (paramBoolean2))
    {
      ae.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
      this.keL.a((eay)localObject);
    }
    for (;;)
    {
      if (paramBoolean1) {
        x(paramLinkedList);
      }
      paramLinkedList = this.cpc;
      paramLinkedList.kem = System.currentTimeMillis();
      paramLinkedList.keo = System.currentTimeMillis();
      if (!this.cpc.isBusy()) {
        this.kfe = 0;
      }
      paramLinkedList = new l();
      paramLinkedList.size = ((eay)localObject).computeSize();
      paramLinkedList.kdZ = System.currentTimeMillis();
      this.cpc.kex.put(((eay)localObject).uuid, paramLinkedList);
      AppMethodBeat.o(147065);
      break;
      ae.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
    }
  }
  
  private void bfw()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(147053);
        i = 0;
        if (i < this.cpc.kez.size())
        {
          int j;
          if (i == 0)
          {
            j = this.cpc.bfn();
            int k = ((eaz)this.cpc.kez.get(i)).iqb;
            if (j - k != 1) {
              dI(j + 1, k - 1);
            }
          }
          else
          {
            j = ((eaz)this.cpc.kez.get(i - 1)).iqb;
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
  
  private void bfx()
  {
    AppMethodBeat.i(147063);
    long l = System.currentTimeMillis();
    for (;;)
    {
      synchronized (this.cpc.mLock)
      {
        if ((this.kfa) && (l - this.kfb < 32L))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.kfb = l;
        if (bu.ht(this.kfc))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.kfa = true;
        i = (int)(16L - (System.currentTimeMillis() - this.cpc.kem));
        if (i > 0)
        {
          f.bCj().k(new Runnable()
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
  
  private LinkedList<eaz> w(LinkedList<eaz> paramLinkedList)
  {
    for (;;)
    {
      LinkedList localLinkedList1;
      LinkedList localLinkedList2;
      eaz localeaz;
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
        this.cpc.kez.addAll(paramLinkedList);
        Collections.sort(this.cpc.kez, new Comparator() {});
        i = this.cpc.bfn();
        paramLinkedList = this.cpc.kez.iterator();
        if (!paramLinkedList.hasNext()) {
          break label167;
        }
        localeaz = (eaz)paramLinkedList.next();
        if (localeaz == null) {
          continue;
        }
        if (localeaz.iqb <= i)
        {
          localLinkedList2.add(localeaz);
          continue;
        }
        if (localeaz.iqb - i != 1) {
          break label167;
        }
      }
      finally {}
      localLinkedList1.add(localeaz);
      int i = localeaz.iqb;
      continue;
      label167:
      this.cpc.sm(i);
      this.cpc.kez.removeAll(localLinkedList1);
      this.cpc.kez.removeAll(localLinkedList2);
      ae.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
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
    //   13: invokestatic 329	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokestatic 492	com/tencent/mm/sdk/platformtools/bu:ht	(Ljava/util/List;)Z
    //   20: ifeq +12 -> 32
    //   23: ldc_w 631
    //   26: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 137	com/tencent/mm/plugin/appbrand/debugger/q:cpc	Lcom/tencent/mm/plugin/appbrand/debugger/m;
    //   36: getfield 636	com/tencent/mm/plugin/appbrand/debugger/m:kew	Ljava/util/LinkedList;
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
    eav localeav = new eav();
    localeav.IgF = paramInt;
    localeav.dvD = paramString;
    a(v.a(localeav, this.cpc, "callInterfaceResult"));
    AppMethodBeat.o(147052);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(147062);
    if (!this.cpc.bfr()) {}
    synchronized (this.cpc.mLock)
    {
      if ((System.currentTimeMillis() - this.cpc.kem <= 16L) || (this.kfa))
      {
        this.kfc.add(paramp);
        bfx();
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
    this.keL = paramu;
    this.cpc = paramm;
    this.keO = paramw;
  }
  
  final void bfA()
  {
    AppMethodBeat.i(147070);
    this.cpc.setStatus(4);
    this.keL.OM("quit");
    AppMethodBeat.o(147070);
  }
  
  public final void bfB()
  {
    for (;;)
    {
      p localp;
      try
      {
        AppMethodBeat.i(147072);
        ae.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.cpc.kew.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localp = (p)localIterator.next();
        if (localp.keS == null)
        {
          localLinkedList.add(localp);
          continue;
        }
        if (localp.keS.iqb > this.cpc.bfo()) {
          continue;
        }
      }
      finally {}
      localCollection.add(localp);
    }
    this.cpc.kew.removeAll(localCollection);
    AppMethodBeat.o(147072);
  }
  
  public final void bfC()
  {
    AppMethodBeat.i(147073);
    ae.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    AppMethodBeat.o(147073);
  }
  
  public final void bfy()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(147067);
      if (this.cpc.isBusy())
      {
        AppMethodBeat.o(147067);
        return;
      }
      long l = System.currentTimeMillis();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.cpc.kew.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          p localp = (p)localIterator.next();
          if (l - localp.kdZ > 5000L)
          {
            localp.kdZ = System.currentTimeMillis();
            localLinkedList.add(localp);
            i = localp.keT + i;
            if ((i >= 65536L) || (localLinkedList.size() > 800))
            {
              ae.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
              a(localLinkedList, false);
              localLinkedList.clear();
            }
          }
        }
        else
        {
          if (!bu.ht(localLinkedList))
          {
            ae.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
            a(localLinkedList, false);
          }
          AppMethodBeat.o(147067);
          break;
        }
      }
    }
    finally {}
  }
  
  public final boolean bfz()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(147068);
        long l = System.currentTimeMillis();
        if (l - this.kff < this.kfe)
        {
          AppMethodBeat.o(147068);
          bool = false;
          return bool;
        }
        this.kff = l;
        if (this.kfe < 5000)
        {
          this.kfe += 1000;
          LinkedList localLinkedList1 = new LinkedList();
          localObject = this.cpc.kew.iterator();
          if (((Iterator)localObject).hasNext())
          {
            p localp = (p)((Iterator)localObject).next();
            if (l - localp.kdZ <= 5000L) {
              continue;
            }
            localp.kdZ = System.currentTimeMillis();
            localLinkedList1.add(localp);
            a(localLinkedList1, false, true);
            AppMethodBeat.o(147068);
            bool = true;
          }
        }
        else
        {
          this.kfe = 2000;
          continue;
        }
        if (this.cpc.kew.size() <= 0) {
          break label239;
        }
      }
      finally {}
      Object localObject = (p)this.cpc.kew.get(0);
      ((p)localObject).kdZ = System.currentTimeMillis();
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
  
  public final void dI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147054);
    ae.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2)
    {
      AppMethodBeat.o(147054);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.keZ.get(Integer.valueOf(paramInt1)) != null) && (l - ((Long)this.keZ.get(Integer.valueOf(paramInt1))).longValue() < 3000L))
    {
      ae.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
      AppMethodBeat.o(147054);
      return;
    }
    this.keZ.put(Integer.valueOf(paramInt1), Long.valueOf(l));
    Object localObject = new ebw();
    ((ebw)localObject).Iha = this.cpc.kef;
    ((ebw)localObject).Ihn = paramInt1;
    ((ebw)localObject).Iho = paramInt2;
    localObject = v.a(1005, (a)localObject);
    this.keL.a((eay)localObject);
    this.cpc.kep = System.currentTimeMillis();
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
        ae.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.cpc.kew.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localp = (p)localIterator.next();
        if (localp.keS == null)
        {
          localLinkedList.add(localp);
          continue;
        }
        if (localp.keS.iqb < paramInt1) {
          continue;
        }
      }
      finally {}
      if (localp.keS.iqb <= paramInt2) {
        localCollection.add(localp);
      }
    }
    this.cpc.kew.removeAll(localCollection);
    AppMethodBeat.o(147071);
  }
  
  public final void quit()
  {
    AppMethodBeat.i(147069);
    ae.i("MicroMsg.RemoteDebugMsgMrg", "quit");
    Object localObject = new ebv();
    ((ebv)localObject).Iha = this.cpc.kef;
    localObject = v.a(1004, (a)localObject);
    this.keL.a((eay)localObject);
    AppMethodBeat.o(147069);
  }
  
  final void v(LinkedList<eaz> paramLinkedList)
  {
    AppMethodBeat.i(147055);
    if (bu.ht(paramLinkedList))
    {
      ae.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
      AppMethodBeat.o(147055);
      return;
    }
    Iterator localIterator = w(paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (eaz)localIterator.next();
      byte[] arrayOfByte;
      label83:
      int i;
      if (v.sp(((eaz)localObject).HJB))
      {
        arrayOfByte = s.F(((eaz)localObject).Gwe.zr);
        localObject = ((eaz)localObject).category;
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
          a((eau)new eau().parseFrom(arrayOfByte));
          break;
          arrayOfByte = ((eaz)localObject).Gwe.zr;
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
      a((ebe)new ebe().parseFrom(arrayOfByte));
      continue;
      a((ebi)new ebi().parseFrom(arrayOfByte));
      continue;
      a((eat)new eat().parseFrom(arrayOfByte));
      continue;
      a((ebc)new ebc().parseFrom(arrayOfByte));
      continue;
      a((eaw)new eaw().parseFrom(arrayOfByte));
    }
    ae.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.cpc.bfn()) });
    this.cpc.so(paramLinkedList.size());
    bfw();
    AppMethodBeat.o(147055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.q
 * JD-Core Version:    0.7.0.1
 */