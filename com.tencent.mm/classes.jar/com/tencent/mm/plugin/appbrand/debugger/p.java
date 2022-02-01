package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.v8.V8Inspector;
import com.eclipsesource.v8.V8Inspector.JsInspectorChannelServer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.protocal.protobuf.dnr;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dnt;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.dot;
import com.tencent.mm.protocal.protobuf.dou;
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

public final class p
{
  private static final Map<String, String[]> jhg;
  l chM;
  t jgT;
  v jgW;
  private ag<Integer, Long> jhh;
  private boolean jhi;
  private long jhj;
  private LinkedList<o> jhk;
  private final int jhl;
  private int jhm;
  private long jhn;
  Timer mTimer;
  
  static
  {
    AppMethodBeat.i(147077);
    HashMap localHashMap = new HashMap();
    jhg = localHashMap;
    localHashMap.put("publishHandler", new String[] { "String", "String", "String" });
    jhg.put("invokeHandler", new String[] { "String", "String", "Number" });
    AppMethodBeat.o(147077);
  }
  
  public p()
  {
    AppMethodBeat.i(147049);
    this.jhh = new ag(100);
    this.jhi = false;
    this.jhk = new LinkedList();
    this.jhl = 5000;
    this.jhm = 0;
    this.jhn = 0L;
    V8Inspector.setServer(new V8Inspector.JsInspectorChannelServer()
    {
      public final int notify(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        return 0;
      }
      
      public final int sendData(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(147046);
        p.a(p.this, paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(147046);
        return 0;
      }
    });
    AppMethodBeat.o(147049);
  }
  
  private static int[] GF(String paramString)
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
  
  private void a(dnr paramdnr)
  {
    AppMethodBeat.i(147057);
    if (this.chM.aUf() == paramdnr.EEk)
    {
      AppMethodBeat.o(147057);
      return;
    }
    if (paramdnr.EEk) {
      this.chM.fA(true);
    }
    for (;;)
    {
      this.jgW.aUw();
      this.jgW.aUB();
      AppMethodBeat.o(147057);
      return;
      this.chM.fA(false);
    }
  }
  
  private void a(dns paramdns)
  {
    AppMethodBeat.i(147051);
    ad.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[] { paramdns.EEm, Integer.valueOf(paramdns.EEo) });
    String str = paramdns.EEm;
    LinkedList localLinkedList1 = paramdns.EEn;
    if (!jhg.containsKey(str))
    {
      ad.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
      AppMethodBeat.o(147051);
      return;
    }
    Object localObject = (String[])jhg.get(str);
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
    this.chM.jgn.b((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), GF((String)String.class.cast(localLinkedList2.get(2))));
    localObject = null;
    label394:
    int j;
    if (localObject != null)
    {
      localObject = String.valueOf(localObject);
      if (!bt.isNullOrNil((String)localObject)) {
        W(paramdns.EEo, (String)localObject);
      }
      j = paramdns.computeSize();
      if (localObject != null) {
        break label509;
      }
    }
    label509:
    for (i = 0;; i = ((String)localObject).length())
    {
      q.a(str, localLinkedList1, l, j, i);
      AppMethodBeat.o(147051);
      return;
      localObject = this.chM.jgn.w((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), ((Integer)Integer.class.cast(localLinkedList2.get(2))).intValue());
      break;
      localObject = "";
      break label394;
    }
  }
  
  private static void a(dnu paramdnu)
  {
    AppMethodBeat.i(147059);
    V8Inspector.onReceiveData(paramdnu.EEp, paramdnu.DFl);
    AppMethodBeat.o(147059);
  }
  
  private void a(doa paramdoa)
  {
    AppMethodBeat.i(147058);
    ad.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
    int i = this.chM.jgn.Dl().aLK().getCurrentPage().getCurrentPageView().aOd();
    if (paramdoa.EEy != i)
    {
      ad.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[] { Integer.valueOf(paramdoa.EEy), Integer.valueOf(i) });
      AppMethodBeat.o(147058);
      return;
    }
    this.chM.jgn.b("remoteDebugCommand", paramdoa.EEx, null);
    AppMethodBeat.o(147058);
  }
  
  private void a(doc paramdoc)
  {
    AppMethodBeat.i(147061);
    ad.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[] { Integer.valueOf(paramdoc.EEz) });
    int i = paramdoc.EEz;
    String str = paramdoc.dld;
    b localb = (b)this.chM.jgI.remove(Integer.valueOf(i));
    if (localb == null)
    {
      AppMethodBeat.o(147061);
      return;
    }
    ValueCallback localValueCallback = localb.jgh;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(str);
    }
    ad.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str);
    q.a(localb, paramdoc.computeSize());
    AppMethodBeat.o(147061);
  }
  
  private void a(dog paramdog)
  {
    AppMethodBeat.i(147060);
    doh localdoh = new doh();
    localdoh.EEC = paramdog.EEC;
    localdoh.CvW = q.aUu();
    ad.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[] { Integer.valueOf(localdoh.CvW) });
    a(u.a(localdoh, this.chM, "pong"));
    AppMethodBeat.o(147060);
  }
  
  public static void a(doi paramdoi)
  {
    AppMethodBeat.i(147050);
    paramdoi.EEl = "WeixinJSCore";
    Iterator localIterator = jhg.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((String[])jhg.get(str)).length > 5)
      {
        ad.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
      }
      else
      {
        doe localdoe = new doe();
        localdoe.EEm = str;
        int i = 0;
        while (i < ((String[])jhg.get(str)).length)
        {
          localdoe.EEn.add(((String[])jhg.get(str))[i]);
          i += 1;
        }
        paramdoi.EED.add(localdoe);
      }
    }
    AppMethodBeat.o(147050);
  }
  
  private void a(LinkedList<o> paramLinkedList, boolean paramBoolean)
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
  
  private void a(LinkedList<o> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    try
    {
      AppMethodBeat.i(147065);
      if (bt.gL(paramLinkedList))
      {
        AppMethodBeat.o(147065);
        return;
      }
      localObject = new dok();
      ((dok)localObject).EEK = this.chM.jgo;
      ((dok)localObject).EEL = this.chM.aUd();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        ((dok)localObject).EEA.add(localo.jha);
      }
      localObject = u.a(1006, (a)localObject);
    }
    finally {}
    if ((!this.chM.isBusy()) || (paramBoolean2))
    {
      ad.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
      this.jgT.a((dnw)localObject);
    }
    for (;;)
    {
      if (paramBoolean1) {
        x(paramLinkedList);
      }
      paramLinkedList = this.chM;
      paramLinkedList.jgv = System.currentTimeMillis();
      paramLinkedList.jgx = System.currentTimeMillis();
      if (!this.chM.isBusy()) {
        this.jhm = 0;
      }
      paramLinkedList = new k();
      paramLinkedList.size = ((dnw)localObject).computeSize();
      paramLinkedList.jgi = System.currentTimeMillis();
      this.chM.jgG.put(((dnw)localObject).uuid, paramLinkedList);
      AppMethodBeat.o(147065);
      break;
      ad.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
    }
  }
  
  private void aUm()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(147053);
        i = 0;
        if (i < this.chM.jgH.size())
        {
          int j;
          if (i == 0)
          {
            j = this.chM.aUd();
            int k = ((dnx)this.chM.jgH.get(i)).htk;
            if (j - k != 1) {
              dG(j + 1, k - 1);
            }
          }
          else
          {
            j = ((dnx)this.chM.jgH.get(i - 1)).htk;
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
  
  private void aUn()
  {
    AppMethodBeat.i(147063);
    long l = System.currentTimeMillis();
    for (;;)
    {
      synchronized (this.chM.mLock)
      {
        if ((this.jhi) && (l - this.jhj < 32L))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.jhj = l;
        if (bt.gL(this.jhk))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.jhi = true;
        i = (int)(16L - (System.currentTimeMillis() - this.chM.jgv));
        if (i > 0)
        {
          e.bqm().j(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(147047);
              LinkedList localLinkedList = new LinkedList();
              synchronized (p.a(p.this).mLock)
              {
                localLinkedList.addAll(p.b(p.this));
                p.b(p.this).clear();
                p.c(p.this);
                p.a(p.this, localLinkedList);
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
  
  private LinkedList<dnx> w(LinkedList<dnx> paramLinkedList)
  {
    for (;;)
    {
      LinkedList localLinkedList1;
      LinkedList localLinkedList2;
      dnx localdnx;
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
        this.chM.jgH.addAll(paramLinkedList);
        Collections.sort(this.chM.jgH, new Comparator() {});
        i = this.chM.aUd();
        paramLinkedList = this.chM.jgH.iterator();
        if (!paramLinkedList.hasNext()) {
          break label167;
        }
        localdnx = (dnx)paramLinkedList.next();
        if (localdnx == null) {
          continue;
        }
        if (localdnx.htk <= i)
        {
          localLinkedList2.add(localdnx);
          continue;
        }
        if (localdnx.htk - i != 1) {
          break label167;
        }
      }
      finally {}
      localLinkedList1.add(localdnx);
      int i = localdnx.htk;
      continue;
      label167:
      this.chM.qU(i);
      this.chM.jgH.removeAll(localLinkedList1);
      this.chM.jgH.removeAll(localLinkedList2);
      ad.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
      AppMethodBeat.o(147056);
      paramLinkedList = localLinkedList1;
    }
  }
  
  /* Error */
  private void x(LinkedList<o> paramLinkedList)
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
    //   17: invokestatic 492	com/tencent/mm/sdk/platformtools/bt:gL	(Ljava/util/List;)Z
    //   20: ifeq +12 -> 32
    //   23: ldc_w 631
    //   26: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 137	com/tencent/mm/plugin/appbrand/debugger/p:chM	Lcom/tencent/mm/plugin/appbrand/debugger/l;
    //   36: getfield 636	com/tencent/mm/plugin/appbrand/debugger/l:jgF	Ljava/util/LinkedList;
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
    //   0	58	0	this	p
    //   0	58	1	paramLinkedList	LinkedList<o>
    // Exception table:
    //   from	to	target	type
    //   2	29	53	finally
    //   32	50	53	finally
  }
  
  public final void W(int paramInt, String paramString)
  {
    AppMethodBeat.i(147052);
    dnt localdnt = new dnt();
    localdnt.EEo = paramInt;
    localdnt.dld = paramString;
    a(u.a(localdnt, this.chM, "callInterfaceResult"));
    AppMethodBeat.o(147052);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(147062);
    if (!this.chM.aUh()) {}
    synchronized (this.chM.mLock)
    {
      if ((System.currentTimeMillis() - this.chM.jgv <= 16L) || (this.jhi))
      {
        this.jhk.add(paramo);
        aUn();
        AppMethodBeat.o(147062);
        return;
      }
      ??? = new LinkedList();
      ((LinkedList)???).add(paramo);
      a((LinkedList)???, true);
      AppMethodBeat.o(147062);
      return;
    }
  }
  
  public final void a(t paramt, l paraml, v paramv)
  {
    this.jgT = paramt;
    this.chM = paraml;
    this.jgW = paramv;
  }
  
  public final void aUo()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(147067);
      if (this.chM.isBusy())
      {
        AppMethodBeat.o(147067);
        return;
      }
      long l = System.currentTimeMillis();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.chM.jgF.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          o localo = (o)localIterator.next();
          if (l - localo.jgi > 5000L)
          {
            localo.jgi = System.currentTimeMillis();
            localLinkedList.add(localo);
            i = localo.jhb + i;
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
          if (!bt.gL(localLinkedList))
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
  
  public final boolean aUp()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(147068);
        long l = System.currentTimeMillis();
        if (l - this.jhn < this.jhm)
        {
          AppMethodBeat.o(147068);
          bool = false;
          return bool;
        }
        this.jhn = l;
        if (this.jhm < 5000)
        {
          this.jhm += 1000;
          LinkedList localLinkedList1 = new LinkedList();
          localObject = this.chM.jgF.iterator();
          if (((Iterator)localObject).hasNext())
          {
            o localo = (o)((Iterator)localObject).next();
            if (l - localo.jgi <= 5000L) {
              continue;
            }
            localo.jgi = System.currentTimeMillis();
            localLinkedList1.add(localo);
            a(localLinkedList1, false, true);
            AppMethodBeat.o(147068);
            bool = true;
          }
        }
        else
        {
          this.jhm = 2000;
          continue;
        }
        if (this.chM.jgF.size() <= 0) {
          break label239;
        }
      }
      finally {}
      Object localObject = (o)this.chM.jgF.get(0);
      ((o)localObject).jgi = System.currentTimeMillis();
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
  
  final void aUq()
  {
    AppMethodBeat.i(147070);
    this.chM.setStatus(4);
    this.jgT.GH("quit");
    AppMethodBeat.o(147070);
  }
  
  public final void aUr()
  {
    for (;;)
    {
      o localo;
      try
      {
        AppMethodBeat.i(147072);
        ad.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.chM.jgF.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localo = (o)localIterator.next();
        if (localo.jha == null)
        {
          localLinkedList.add(localo);
          continue;
        }
        if (localo.jha.htk > this.chM.aUe()) {
          continue;
        }
      }
      finally {}
      localCollection.add(localo);
    }
    this.chM.jgF.removeAll(localCollection);
    AppMethodBeat.o(147072);
  }
  
  public final void aUs()
  {
    AppMethodBeat.i(147073);
    ad.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    AppMethodBeat.o(147073);
  }
  
  public final void dG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147054);
    ad.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2)
    {
      AppMethodBeat.o(147054);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.jhh.get(Integer.valueOf(paramInt1)) != null) && (l - ((Long)this.jhh.get(Integer.valueOf(paramInt1))).longValue() < 3000L))
    {
      ad.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
      AppMethodBeat.o(147054);
      return;
    }
    this.jhh.put(Integer.valueOf(paramInt1), Long.valueOf(l));
    Object localObject = new dou();
    ((dou)localObject).EEK = this.chM.jgo;
    ((dou)localObject).EEX = paramInt1;
    ((dou)localObject).EEY = paramInt2;
    localObject = u.a(1005, (a)localObject);
    this.jgT.a((dnw)localObject);
    this.chM.jgy = System.currentTimeMillis();
    AppMethodBeat.o(147054);
  }
  
  public final void dH(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      o localo;
      try
      {
        AppMethodBeat.i(147071);
        ad.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.chM.jgF.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localo = (o)localIterator.next();
        if (localo.jha == null)
        {
          localLinkedList.add(localo);
          continue;
        }
        if (localo.jha.htk < paramInt1) {
          continue;
        }
      }
      finally {}
      if (localo.jha.htk <= paramInt2) {
        localCollection.add(localo);
      }
    }
    this.chM.jgF.removeAll(localCollection);
    AppMethodBeat.o(147071);
  }
  
  public final void quit()
  {
    AppMethodBeat.i(147069);
    ad.i("MicroMsg.RemoteDebugMsgMrg", "quit");
    Object localObject = new dot();
    ((dot)localObject).EEK = this.chM.jgo;
    localObject = u.a(1004, (a)localObject);
    this.jgT.a((dnw)localObject);
    AppMethodBeat.o(147069);
  }
  
  final void v(LinkedList<dnx> paramLinkedList)
  {
    AppMethodBeat.i(147055);
    if (bt.gL(paramLinkedList))
    {
      ad.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
      AppMethodBeat.o(147055);
      return;
    }
    Iterator localIterator = w(paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (dnx)localIterator.next();
      byte[] arrayOfByte;
      label83:
      int i;
      if (u.qX(((dnx)localObject).EiC))
      {
        arrayOfByte = s.H(((dnx)localObject).DcU.wA);
        localObject = ((dnx)localObject).category;
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
          a((dns)new dns().parseFrom(arrayOfByte));
          break;
          arrayOfByte = ((dnx)localObject).DcU.wA;
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
      a((doc)new doc().parseFrom(arrayOfByte));
      continue;
      a((dog)new dog().parseFrom(arrayOfByte));
      continue;
      a((dnr)new dnr().parseFrom(arrayOfByte));
      continue;
      a((doa)new doa().parseFrom(arrayOfByte));
      continue;
      a((dnu)new dnu().parseFrom(arrayOfByte));
    }
    ad.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.chM.aUd()) });
    this.chM.qW(paramLinkedList.size());
    aUm();
    AppMethodBeat.o(147055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.p
 * JD-Core Version:    0.7.0.1
 */