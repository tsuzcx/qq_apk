package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.v8.V8Inspector;
import com.eclipsesource.v8.V8Inspector.JsInspectorChannelServer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.protocal.protobuf.dtn;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.protocal.protobuf.dtr;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.dtv;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.protocal.protobuf.dub;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static final Map<String, String[]> jHv;
  l ceH;
  private final int jHA;
  private int jHB;
  private long jHC;
  t jHi;
  v jHl;
  private af<Integer, Long> jHw;
  private boolean jHx;
  private long jHy;
  private LinkedList<o> jHz;
  Timer mTimer;
  
  static
  {
    AppMethodBeat.i(147077);
    HashMap localHashMap = new HashMap();
    jHv = localHashMap;
    localHashMap.put("publishHandler", new String[] { "String", "String", "String" });
    jHv.put("invokeHandler", new String[] { "String", "String", "Number" });
    AppMethodBeat.o(147077);
  }
  
  public p()
  {
    AppMethodBeat.i(147049);
    this.jHw = new af(100);
    this.jHx = false;
    this.jHz = new LinkedList();
    this.jHA = 5000;
    this.jHB = 0;
    this.jHC = 0L;
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
  
  private static int[] KJ(String paramString)
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
      ac.e("MicroMsg.RemoteDebugMsgMrg", paramString.getMessage());
      localObject2 = localObject1;
      AppMethodBeat.o(147074);
    }
  }
  
  private void a(dti paramdti)
  {
    AppMethodBeat.i(147057);
    if (this.ceH.bbd() == paramdti.Gbx)
    {
      AppMethodBeat.o(147057);
      return;
    }
    if (paramdti.Gbx) {
      this.ceH.fW(true);
    }
    for (;;)
    {
      this.jHl.bbu();
      this.jHl.bbz();
      AppMethodBeat.o(147057);
      return;
      this.ceH.fW(false);
    }
  }
  
  private void a(dtj paramdtj)
  {
    AppMethodBeat.i(147051);
    ac.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[] { paramdtj.Gbz, Integer.valueOf(paramdtj.GbB) });
    String str = paramdtj.Gbz;
    LinkedList localLinkedList1 = paramdtj.GbA;
    if (!jHv.containsKey(str))
    {
      ac.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
      AppMethodBeat.o(147051);
      return;
    }
    Object localObject = (String[])jHv.get(str);
    if (localLinkedList1.size() < localObject.length)
    {
      ac.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
      AppMethodBeat.o(147051);
      return;
    }
    LinkedList localLinkedList2 = new LinkedList();
    int i = 0;
    if (i < localObject.length)
    {
      if ("Number".equals(localObject[i])) {
        localLinkedList2.add(Integer.valueOf(bs.getInt((String)localLinkedList1.get(i), 0)));
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
        ac.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
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
    this.ceH.jGC.b((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), KJ((String)String.class.cast(localLinkedList2.get(2))));
    localObject = null;
    label394:
    int j;
    if (localObject != null)
    {
      localObject = String.valueOf(localObject);
      if (!bs.isNullOrNil((String)localObject)) {
        X(paramdtj.GbB, (String)localObject);
      }
      j = paramdtj.computeSize();
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
      localObject = this.ceH.jGC.x((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), ((Integer)Integer.class.cast(localLinkedList2.get(2))).intValue());
      break;
      localObject = "";
      break label394;
    }
  }
  
  private static void a(dtl paramdtl)
  {
    AppMethodBeat.i(147059);
    V8Inspector.onReceiveData(paramdtl.GbC, paramdtl.FaF);
    AppMethodBeat.o(147059);
  }
  
  private void a(dtr paramdtr)
  {
    AppMethodBeat.i(147058);
    ac.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
    int i = this.ceH.jGC.CO().aSA().getCurrentPage().getCurrentPageView().aUT();
    if (paramdtr.GbL != i)
    {
      ac.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[] { Integer.valueOf(paramdtr.GbL), Integer.valueOf(i) });
      AppMethodBeat.o(147058);
      return;
    }
    this.ceH.jGC.b("remoteDebugCommand", paramdtr.GbK, null);
    AppMethodBeat.o(147058);
  }
  
  private void a(dtt paramdtt)
  {
    AppMethodBeat.i(147061);
    ac.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[] { Integer.valueOf(paramdtt.GbM) });
    int i = paramdtt.GbM;
    String str = paramdtt.diM;
    b localb = (b)this.ceH.jGX.remove(Integer.valueOf(i));
    if (localb == null)
    {
      AppMethodBeat.o(147061);
      return;
    }
    ValueCallback localValueCallback = localb.jGw;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(str);
    }
    ac.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str);
    q.a(localb, paramdtt.computeSize());
    AppMethodBeat.o(147061);
  }
  
  private void a(dtx paramdtx)
  {
    AppMethodBeat.i(147060);
    dty localdty = new dty();
    localdty.GbP = paramdtx.GbP;
    localdty.DOr = q.bbs();
    ac.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[] { Integer.valueOf(localdty.DOr) });
    a(u.a(localdty, this.ceH, "pong"));
    AppMethodBeat.o(147060);
  }
  
  public static void a(dtz paramdtz)
  {
    AppMethodBeat.i(147050);
    paramdtz.Gby = "WeixinJSCore";
    Iterator localIterator = jHv.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((String[])jHv.get(str)).length > 5)
      {
        ac.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
      }
      else
      {
        dtv localdtv = new dtv();
        localdtv.Gbz = str;
        int i = 0;
        while (i < ((String[])jHv.get(str)).length)
        {
          localdtv.GbA.add(((String[])jHv.get(str))[i]);
          i += 1;
        }
        paramdtz.GbQ.add(localdtv);
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
      if (bs.gY(paramLinkedList))
      {
        AppMethodBeat.o(147065);
        return;
      }
      localObject = new dub();
      ((dub)localObject).GbW = this.ceH.jGD;
      ((dub)localObject).GbX = this.ceH.bbb();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        ((dub)localObject).GbN.add(localo.jHp);
      }
      localObject = u.a(1006, (a)localObject);
    }
    finally {}
    if ((!this.ceH.isBusy()) || (paramBoolean2))
    {
      ac.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
      this.jHi.a((dtn)localObject);
    }
    for (;;)
    {
      if (paramBoolean1) {
        x(paramLinkedList);
      }
      paramLinkedList = this.ceH;
      paramLinkedList.jGK = System.currentTimeMillis();
      paramLinkedList.jGM = System.currentTimeMillis();
      if (!this.ceH.isBusy()) {
        this.jHB = 0;
      }
      paramLinkedList = new k();
      paramLinkedList.size = ((dtn)localObject).computeSize();
      paramLinkedList.jGx = System.currentTimeMillis();
      this.ceH.jGV.put(((dtn)localObject).uuid, paramLinkedList);
      AppMethodBeat.o(147065);
      break;
      ac.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
    }
  }
  
  private void bbk()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(147053);
        i = 0;
        if (i < this.ceH.jGW.size())
        {
          int j;
          if (i == 0)
          {
            j = this.ceH.bbb();
            int k = ((dto)this.ceH.jGW.get(i)).hTM;
            if (j - k != 1) {
              dG(j + 1, k - 1);
            }
          }
          else
          {
            j = ((dto)this.ceH.jGW.get(i - 1)).hTM;
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
  
  private void bbl()
  {
    AppMethodBeat.i(147063);
    long l = System.currentTimeMillis();
    for (;;)
    {
      synchronized (this.ceH.mLock)
      {
        if ((this.jHx) && (l - this.jHy < 32L))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.jHy = l;
        if (bs.gY(this.jHz))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.jHx = true;
        i = (int)(16L - (System.currentTimeMillis() - this.ceH.jGK));
        if (i > 0)
        {
          e.bxj().j(new Runnable()
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
  
  private LinkedList<dto> w(LinkedList<dto> paramLinkedList)
  {
    for (;;)
    {
      LinkedList localLinkedList1;
      LinkedList localLinkedList2;
      dto localdto;
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
        this.ceH.jGW.addAll(paramLinkedList);
        Collections.sort(this.ceH.jGW, new Comparator() {});
        i = this.ceH.bbb();
        paramLinkedList = this.ceH.jGW.iterator();
        if (!paramLinkedList.hasNext()) {
          break label167;
        }
        localdto = (dto)paramLinkedList.next();
        if (localdto == null) {
          continue;
        }
        if (localdto.hTM <= i)
        {
          localLinkedList2.add(localdto);
          continue;
        }
        if (localdto.hTM - i != 1) {
          break label167;
        }
      }
      finally {}
      localLinkedList1.add(localdto);
      int i = localdto.hTM;
      continue;
      label167:
      this.ceH.rH(i);
      this.ceH.jGW.removeAll(localLinkedList1);
      this.ceH.jGW.removeAll(localLinkedList2);
      ac.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
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
    //   13: invokestatic 330	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokestatic 493	com/tencent/mm/sdk/platformtools/bs:gY	(Ljava/util/List;)Z
    //   20: ifeq +12 -> 32
    //   23: ldc_w 631
    //   26: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 137	com/tencent/mm/plugin/appbrand/debugger/p:ceH	Lcom/tencent/mm/plugin/appbrand/debugger/l;
    //   36: getfield 636	com/tencent/mm/plugin/appbrand/debugger/l:jGU	Ljava/util/LinkedList;
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
  
  public final void X(int paramInt, String paramString)
  {
    AppMethodBeat.i(147052);
    dtk localdtk = new dtk();
    localdtk.GbB = paramInt;
    localdtk.diM = paramString;
    a(u.a(localdtk, this.ceH, "callInterfaceResult"));
    AppMethodBeat.o(147052);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(147062);
    if (!this.ceH.bbf()) {}
    synchronized (this.ceH.mLock)
    {
      if ((System.currentTimeMillis() - this.ceH.jGK <= 16L) || (this.jHx))
      {
        this.jHz.add(paramo);
        bbl();
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
    this.jHi = paramt;
    this.ceH = paraml;
    this.jHl = paramv;
  }
  
  public final void bbm()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(147067);
      if (this.ceH.isBusy())
      {
        AppMethodBeat.o(147067);
        return;
      }
      long l = System.currentTimeMillis();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.ceH.jGU.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          o localo = (o)localIterator.next();
          if (l - localo.jGx > 5000L)
          {
            localo.jGx = System.currentTimeMillis();
            localLinkedList.add(localo);
            i = localo.jHq + i;
            if ((i >= 65536L) || (localLinkedList.size() > 800))
            {
              ac.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
              a(localLinkedList, false);
              localLinkedList.clear();
            }
          }
        }
        else
        {
          if (!bs.gY(localLinkedList))
          {
            ac.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
            a(localLinkedList, false);
          }
          AppMethodBeat.o(147067);
          break;
        }
      }
    }
    finally {}
  }
  
  public final boolean bbn()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(147068);
        long l = System.currentTimeMillis();
        if (l - this.jHC < this.jHB)
        {
          AppMethodBeat.o(147068);
          bool = false;
          return bool;
        }
        this.jHC = l;
        if (this.jHB < 5000)
        {
          this.jHB += 1000;
          LinkedList localLinkedList1 = new LinkedList();
          localObject = this.ceH.jGU.iterator();
          if (((Iterator)localObject).hasNext())
          {
            o localo = (o)((Iterator)localObject).next();
            if (l - localo.jGx <= 5000L) {
              continue;
            }
            localo.jGx = System.currentTimeMillis();
            localLinkedList1.add(localo);
            a(localLinkedList1, false, true);
            AppMethodBeat.o(147068);
            bool = true;
          }
        }
        else
        {
          this.jHB = 2000;
          continue;
        }
        if (this.ceH.jGU.size() <= 0) {
          break label239;
        }
      }
      finally {}
      Object localObject = (o)this.ceH.jGU.get(0);
      ((o)localObject).jGx = System.currentTimeMillis();
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
  
  final void bbo()
  {
    AppMethodBeat.i(147070);
    this.ceH.setStatus(4);
    this.jHi.KL("quit");
    AppMethodBeat.o(147070);
  }
  
  public final void bbp()
  {
    for (;;)
    {
      o localo;
      try
      {
        AppMethodBeat.i(147072);
        ac.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.ceH.jGU.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localo = (o)localIterator.next();
        if (localo.jHp == null)
        {
          localLinkedList.add(localo);
          continue;
        }
        if (localo.jHp.hTM > this.ceH.bbc()) {
          continue;
        }
      }
      finally {}
      localCollection.add(localo);
    }
    this.ceH.jGU.removeAll(localCollection);
    AppMethodBeat.o(147072);
  }
  
  public final void bbq()
  {
    AppMethodBeat.i(147073);
    ac.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    AppMethodBeat.o(147073);
  }
  
  public final void dG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147054);
    ac.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2)
    {
      AppMethodBeat.o(147054);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.jHw.get(Integer.valueOf(paramInt1)) != null) && (l - ((Long)this.jHw.get(Integer.valueOf(paramInt1))).longValue() < 3000L))
    {
      ac.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
      AppMethodBeat.o(147054);
      return;
    }
    this.jHw.put(Integer.valueOf(paramInt1), Long.valueOf(l));
    Object localObject = new dul();
    ((dul)localObject).GbW = this.ceH.jGD;
    ((dul)localObject).Gcj = paramInt1;
    ((dul)localObject).Gck = paramInt2;
    localObject = u.a(1005, (a)localObject);
    this.jHi.a((dtn)localObject);
    this.ceH.jGN = System.currentTimeMillis();
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
        ac.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.ceH.jGU.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localo = (o)localIterator.next();
        if (localo.jHp == null)
        {
          localLinkedList.add(localo);
          continue;
        }
        if (localo.jHp.hTM < paramInt1) {
          continue;
        }
      }
      finally {}
      if (localo.jHp.hTM <= paramInt2) {
        localCollection.add(localo);
      }
    }
    this.ceH.jGU.removeAll(localCollection);
    AppMethodBeat.o(147071);
  }
  
  public final void quit()
  {
    AppMethodBeat.i(147069);
    ac.i("MicroMsg.RemoteDebugMsgMrg", "quit");
    Object localObject = new duk();
    ((duk)localObject).GbW = this.ceH.jGD;
    localObject = u.a(1004, (a)localObject);
    this.jHi.a((dtn)localObject);
    AppMethodBeat.o(147069);
  }
  
  final void v(LinkedList<dto> paramLinkedList)
  {
    AppMethodBeat.i(147055);
    if (bs.gY(paramLinkedList))
    {
      ac.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
      AppMethodBeat.o(147055);
      return;
    }
    Iterator localIterator = w(paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (dto)localIterator.next();
      byte[] arrayOfByte;
      label83:
      int i;
      if (u.rK(((dto)localObject).FFA))
      {
        arrayOfByte = s.F(((dto)localObject).Ewb.xy);
        localObject = ((dto)localObject).category;
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
          a((dtj)new dtj().parseFrom(arrayOfByte));
          break;
          arrayOfByte = ((dto)localObject).Ewb.xy;
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
      a((dtt)new dtt().parseFrom(arrayOfByte));
      continue;
      a((dtx)new dtx().parseFrom(arrayOfByte));
      continue;
      a((dti)new dti().parseFrom(arrayOfByte));
      continue;
      a((dtr)new dtr().parseFrom(arrayOfByte));
      continue;
      a((dtl)new dtl().parseFrom(arrayOfByte));
    }
    ac.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.ceH.bbb()) });
    this.ceH.rJ(paramLinkedList.size());
    bbk();
    AppMethodBeat.o(147055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.p
 * JD-Core Version:    0.7.0.1
 */