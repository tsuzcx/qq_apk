package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.V8Inspector;
import com.eclipsesource.mmv8.V8Inspector.JsInspectorChannelServer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.protocal.protobuf.ffl;
import com.tencent.mm.protocal.protobuf.ffm;
import com.tencent.mm.protocal.protobuf.ffn;
import com.tencent.mm.protocal.protobuf.ffo;
import com.tencent.mm.protocal.protobuf.ffp;
import com.tencent.mm.protocal.protobuf.ffq;
import com.tencent.mm.protocal.protobuf.ffr;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.ffv;
import com.tencent.mm.protocal.protobuf.ffx;
import com.tencent.mm.protocal.protobuf.ffz;
import com.tencent.mm.protocal.protobuf.fgb;
import com.tencent.mm.protocal.protobuf.fgc;
import com.tencent.mm.protocal.protobuf.fgd;
import com.tencent.mm.protocal.protobuf.fgf;
import com.tencent.mm.protocal.protobuf.fgi;
import com.tencent.mm.protocal.protobuf.fgo;
import com.tencent.mm.protocal.protobuf.fgp;
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
import java.util.concurrent.Future;
import org.json.JSONArray;

public final class s
{
  private static final Map<String, String[]> odp;
  public o cAD;
  w odc;
  y odf;
  private LruCache<Integer, Long> odq;
  private boolean odr;
  private long ods;
  private LinkedList<r> odt;
  private final int odu;
  private int odv;
  private long odw;
  Future<?> odx;
  
  static
  {
    AppMethodBeat.i(147077);
    HashMap localHashMap = new HashMap();
    odp = localHashMap;
    localHashMap.put("publishHandler", new String[] { "String", "String", "String" });
    odp.put("invokeHandler", new String[] { "String", "String", "Number" });
    AppMethodBeat.o(147077);
  }
  
  public s()
  {
    AppMethodBeat.i(147049);
    this.odq = new LruCache(100);
    this.odr = false;
    this.odt = new LinkedList();
    this.odu = 5000;
    this.odv = 0;
    this.odw = 0L;
    V8Inspector.setServer(new V8Inspector.JsInspectorChannelServer()
    {
      public final int notify(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        return 0;
      }
      
      public final int sendData(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(147046);
        s locals = s.this;
        Log.d("MicroMsg.RemoteDebugMsgMrg", "onDevToolsResult op_id:%d, payload:%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        ffp localffp = new ffp();
        localffp.UGb = paramAnonymousLong;
        localffp.Tsy = paramAnonymousString;
        locals.a(x.a(localffp, locals.cAD, "chromeDevtoolsResult"));
        AppMethodBeat.o(147046);
        return 0;
      }
    });
    AppMethodBeat.o(147049);
  }
  
  private void a(ffl paramffl)
  {
    AppMethodBeat.i(147057);
    if (this.cAD.bMd() == paramffl.UFW)
    {
      AppMethodBeat.o(147057);
      return;
    }
    if (paramffl.UFW) {
      this.cAD.hO(true);
    }
    for (;;)
    {
      this.odf.bMu();
      this.odf.bMz();
      AppMethodBeat.o(147057);
      return;
      this.cAD.hO(false);
    }
  }
  
  private void a(ffm paramffm)
  {
    AppMethodBeat.i(147051);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[] { paramffm.UFY, Integer.valueOf(paramffm.UGa) });
    String str = paramffm.UFY;
    LinkedList localLinkedList1 = paramffm.UFZ;
    if (!odp.containsKey(str))
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
      AppMethodBeat.o(147051);
      return;
    }
    Object localObject = (String[])odp.get(str);
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
    this.cAD.ocx.b((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), afI((String)String.class.cast(localLinkedList2.get(2))));
    localObject = null;
    label393:
    int j;
    if (localObject != null)
    {
      localObject = String.valueOf(localObject);
      if (!Util.isNullOrNil((String)localObject)) {
        af(paramffm.UGa, (String)localObject);
      }
      j = paramffm.computeSize();
      if (localObject != null) {
        break label508;
      }
    }
    label508:
    for (i = 0;; i = ((String)localObject).length())
    {
      t.a(str, localLinkedList1, l, j, i);
      AppMethodBeat.o(147051);
      return;
      localObject = this.cAD.ocx.B((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), ((Integer)Integer.class.cast(localLinkedList2.get(2))).intValue());
      break;
      localObject = "";
      break label393;
    }
  }
  
  private static void a(ffo paramffo)
  {
    AppMethodBeat.i(147059);
    Log.d("MicroMsg.RemoteDebugMsgMrg", "onDevTools op_id:%d, payload:%s", new Object[] { Long.valueOf(paramffo.UGb), paramffo.Tsy });
    V8Inspector.onReceiveData(paramffo.UGb, paramffo.Tsy);
    AppMethodBeat.o(147059);
  }
  
  private void a(ffq paramffq)
  {
    AppMethodBeat.i(246432);
    Log.d("MicroMsg.RemoteDebugMsgMrg", "onCustomMsg method:%s, payload:%s", new Object[] { paramffq.method, paramffq.Tsy });
    paramffq = "typeof DebuggerConnection.onCustomMessage === 'function' && DebuggerConnection.onCustomMessage('" + paramffq.method + "', '" + com.tencent.mm.plugin.appbrand.utils.t.anl(paramffq.Tsy) + "')";
    this.cAD.ocx.getJsRuntime().evaluateJavascript(paramffq, null);
    AppMethodBeat.o(246432);
  }
  
  private void a(ffv paramffv)
  {
    AppMethodBeat.i(147058);
    Log.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp, param:%s", new Object[] { paramffv.UGk });
    int i = this.cAD.ocx.QM().bBX().getCurrentPage().getCurrentPageView().getComponentId();
    if ((paramffv.UGl != i) && (this.cAD.ocD.cBI != 1))
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[] { Integer.valueOf(paramffv.UGl), Integer.valueOf(i) });
      AppMethodBeat.o(147058);
      return;
    }
    this.cAD.ocx.b("remoteDebugCommand", paramffv.UGk, null);
    AppMethodBeat.o(147058);
  }
  
  private void a(ffx paramffx)
  {
    AppMethodBeat.i(147061);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[] { Integer.valueOf(paramffx.UGm) });
    int i = paramffx.UGm;
    String str = paramffx.fGw;
    c localc = (c)this.cAD.ocS.remove(Integer.valueOf(i));
    if (localc == null)
    {
      AppMethodBeat.o(147061);
      return;
    }
    ValueCallback localValueCallback = localc.ocn;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(str);
    }
    Log.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str);
    t.a(localc, paramffx.computeSize());
    AppMethodBeat.o(147061);
  }
  
  private void a(fgb paramfgb)
  {
    AppMethodBeat.i(147060);
    fgc localfgc = new fgc();
    localfgc.UGp = paramfgb.UGp;
    localfgc.RGP = t.bMs();
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[] { Integer.valueOf(localfgc.RGP) });
    a(x.a(localfgc, this.cAD, "pong"));
    AppMethodBeat.o(147060);
  }
  
  public static void a(fgd paramfgd)
  {
    AppMethodBeat.i(147050);
    paramfgd.UFX = "WeixinJSCore";
    Iterator localIterator = odp.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((String[])odp.get(str)).length > 5)
      {
        Log.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
      }
      else
      {
        ffz localffz = new ffz();
        localffz.UFY = str;
        int i = 0;
        while (i < ((String[])odp.get(str)).length)
        {
          localffz.UFZ.add(((String[])odp.get(str))[i]);
          i += 1;
        }
        paramfgd.UGq.add(localffz);
      }
    }
    AppMethodBeat.o(147050);
  }
  
  private void a(LinkedList<r> paramLinkedList, boolean paramBoolean)
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
  
  private void a(LinkedList<r> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
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
      localObject = new fgf();
      ((fgf)localObject).UGw = this.cAD.ocy;
      ((fgf)localObject).UGx = this.cAD.bMb();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        r localr = (r)localIterator.next();
        ((fgf)localObject).UGn.add(localr.odj);
      }
      localObject = x.a(1006, (a)localObject);
    }
    finally {}
    if ((!this.cAD.isBusy()) || (paramBoolean2))
    {
      Log.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
      this.odc.a((ffr)localObject);
    }
    for (;;)
    {
      if (paramBoolean1) {
        y(paramLinkedList);
      }
      paramLinkedList = this.cAD;
      paramLinkedList.ocF = System.currentTimeMillis();
      paramLinkedList.ocH = System.currentTimeMillis();
      if (!this.cAD.isBusy()) {
        this.odv = 0;
      }
      paramLinkedList = new n();
      paramLinkedList.size = ((ffr)localObject).computeSize();
      paramLinkedList.oco = System.currentTimeMillis();
      this.cAD.ocQ.put(((ffr)localObject).uuid, paramLinkedList);
      AppMethodBeat.o(147065);
      break;
      Log.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
    }
  }
  
  private static int[] afI(String paramString)
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
  
  private void bMk()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(147053);
        i = 0;
        if (i < this.cAD.ocR.size())
        {
          int j;
          if (i == 0)
          {
            j = this.cAD.bMb();
            int k = ((ffs)this.cAD.ocR.get(i)).mbp;
            if (j - k != 1) {
              es(j + 1, k - 1);
            }
          }
          else
          {
            j = ((ffs)this.cAD.ocR.get(i - 1)).mbp;
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
  
  private void bMl()
  {
    AppMethodBeat.i(147063);
    long l = System.currentTimeMillis();
    for (;;)
    {
      synchronized (this.cAD.mLock)
      {
        if ((this.odr) && (l - this.ods < 32L))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.ods = l;
        if (Util.isNullOrNil(this.odt))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.odr = true;
        i = (int)(16L - (System.currentTimeMillis() - this.cAD.ocF));
        if (i > 0)
        {
          h.clV().i(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(147047);
              LinkedList localLinkedList = new LinkedList();
              synchronized (s.a(s.this).mLock)
              {
                localLinkedList.addAll(s.b(s.this));
                s.b(s.this).clear();
                s.c(s.this);
                s.a(s.this, localLinkedList);
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
  
  private LinkedList<ffs> x(LinkedList<ffs> paramLinkedList)
  {
    for (;;)
    {
      LinkedList localLinkedList1;
      LinkedList localLinkedList2;
      ffs localffs;
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
        this.cAD.ocR.addAll(paramLinkedList);
        Collections.sort(this.cAD.ocR, new Comparator() {});
        i = this.cAD.bMb();
        paramLinkedList = this.cAD.ocR.iterator();
        if (!paramLinkedList.hasNext()) {
          break label167;
        }
        localffs = (ffs)paramLinkedList.next();
        if (localffs == null) {
          continue;
        }
        if (localffs.mbp <= i)
        {
          localLinkedList2.add(localffs);
          continue;
        }
        if (localffs.mbp - i != 1) {
          break label167;
        }
      }
      finally {}
      localLinkedList1.add(localffs);
      int i = localffs.mbp;
      continue;
      label167:
      this.cAD.zv(i);
      this.cAD.ocR.removeAll(localLinkedList1);
      this.cAD.ocR.removeAll(localLinkedList2);
      Log.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
      AppMethodBeat.o(147056);
      paramLinkedList = localLinkedList1;
    }
  }
  
  /* Error */
  private void y(LinkedList<r> paramLinkedList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 671
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 144
    //   10: ldc_w 673
    //   13: invokestatic 437	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokestatic 521	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   20: ifeq +12 -> 32
    //   23: ldc_w 671
    //   26: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 108	com/tencent/mm/plugin/appbrand/debugger/s:cAD	Lcom/tencent/mm/plugin/appbrand/debugger/o;
    //   36: getfield 676	com/tencent/mm/plugin/appbrand/debugger/o:ocP	Ljava/util/LinkedList;
    //   39: aload_1
    //   40: invokevirtual 654	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   43: pop
    //   44: ldc_w 671
    //   47: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: goto -21 -> 29
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	s
    //   0	58	1	paramLinkedList	LinkedList<r>
    // Exception table:
    //   from	to	target	type
    //   2	29	53	finally
    //   32	50	53	finally
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(147062);
    if (!this.cAD.bMf()) {}
    synchronized (this.cAD.mLock)
    {
      if ((System.currentTimeMillis() - this.cAD.ocF <= 16L) || (this.odr))
      {
        this.odt.add(paramr);
        bMl();
        AppMethodBeat.o(147062);
        return;
      }
      ??? = new LinkedList();
      ((LinkedList)???).add(paramr);
      a((LinkedList)???, true);
      AppMethodBeat.o(147062);
      return;
    }
  }
  
  public final void a(w paramw, o paramo, y paramy)
  {
    this.odc = paramw;
    this.cAD = paramo;
    this.odf = paramy;
  }
  
  public final void af(int paramInt, String paramString)
  {
    AppMethodBeat.i(147052);
    ffn localffn = new ffn();
    localffn.UGa = paramInt;
    localffn.fGw = paramString;
    a(x.a(localffn, this.cAD, "callInterfaceResult"));
    AppMethodBeat.o(147052);
  }
  
  public final void bMm()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(147067);
      if (this.cAD.isBusy())
      {
        AppMethodBeat.o(147067);
        return;
      }
      long l = System.currentTimeMillis();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.cAD.ocP.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          r localr = (r)localIterator.next();
          if (l - localr.oco > 5000L)
          {
            localr.oco = System.currentTimeMillis();
            localLinkedList.add(localr);
            i = localr.odk + i;
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
  
  public final boolean bMn()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(147068);
        long l = System.currentTimeMillis();
        if (l - this.odw < this.odv)
        {
          AppMethodBeat.o(147068);
          bool = false;
          return bool;
        }
        this.odw = l;
        if (this.odv < 5000)
        {
          this.odv += 1000;
          LinkedList localLinkedList1 = new LinkedList();
          localObject = this.cAD.ocP.iterator();
          if (((Iterator)localObject).hasNext())
          {
            r localr = (r)((Iterator)localObject).next();
            if (l - localr.oco <= 5000L) {
              continue;
            }
            localr.oco = System.currentTimeMillis();
            localLinkedList1.add(localr);
            a(localLinkedList1, false, true);
            AppMethodBeat.o(147068);
            bool = true;
          }
        }
        else
        {
          this.odv = 2000;
          continue;
        }
        if (this.cAD.ocP.size() <= 0) {
          break label239;
        }
      }
      finally {}
      Object localObject = (r)this.cAD.ocP.get(0);
      ((r)localObject).oco = System.currentTimeMillis();
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
  
  final void bMo()
  {
    AppMethodBeat.i(147070);
    this.cAD.setStatus(4);
    this.odc.afK("quit");
    AppMethodBeat.o(147070);
  }
  
  public final void bMp()
  {
    for (;;)
    {
      r localr;
      try
      {
        AppMethodBeat.i(147072);
        Log.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.cAD.ocP.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localr = (r)localIterator.next();
        if (localr.odj == null)
        {
          localLinkedList.add(localr);
          continue;
        }
        if (localr.odj.mbp > this.cAD.bMc()) {
          continue;
        }
      }
      finally {}
      localCollection.add(localr);
    }
    this.cAD.ocP.removeAll(localCollection);
    AppMethodBeat.o(147072);
  }
  
  public final void bMq()
  {
    AppMethodBeat.i(147073);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
    if (this.odx != null) {
      this.odx.cancel(false);
    }
    AppMethodBeat.o(147073);
  }
  
  public final void es(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147054);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2)
    {
      AppMethodBeat.o(147054);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.odq.get(Integer.valueOf(paramInt1)) != null) && (l - ((Long)this.odq.get(Integer.valueOf(paramInt1))).longValue() < 3000L))
    {
      Log.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
      AppMethodBeat.o(147054);
      return;
    }
    this.odq.put(Integer.valueOf(paramInt1), Long.valueOf(l));
    Object localObject = new fgp();
    ((fgp)localObject).UGw = this.cAD.ocy;
    ((fgp)localObject).UGJ = paramInt1;
    ((fgp)localObject).UGK = paramInt2;
    localObject = x.a(1005, (a)localObject);
    this.odc.a((ffr)localObject);
    this.cAD.ocI = System.currentTimeMillis();
    AppMethodBeat.o(147054);
  }
  
  public final void et(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      r localr;
      try
      {
        AppMethodBeat.i(147071);
        Log.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.cAD.ocP.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localr = (r)localIterator.next();
        if (localr.odj == null)
        {
          localLinkedList.add(localr);
          continue;
        }
        if (localr.odj.mbp < paramInt1) {
          continue;
        }
      }
      finally {}
      if (localr.odj.mbp <= paramInt2) {
        localCollection.add(localr);
      }
    }
    this.cAD.ocP.removeAll(localCollection);
    AppMethodBeat.o(147071);
  }
  
  public final void quit()
  {
    AppMethodBeat.i(147069);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "quit");
    Object localObject = new fgo();
    ((fgo)localObject).UGw = this.cAD.ocy;
    localObject = x.a(1004, (a)localObject);
    this.odc.a((ffr)localObject);
    AppMethodBeat.o(147069);
  }
  
  final void w(LinkedList<ffs> paramLinkedList)
  {
    AppMethodBeat.i(147055);
    if (Util.isNullOrNil(paramLinkedList))
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
      AppMethodBeat.o(147055);
      return;
    }
    Iterator localIterator = x(paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ffs)localIterator.next();
      byte[] arrayOfByte;
      label83:
      int i;
      if (x.zy(((ffs)localObject).UhB))
      {
        arrayOfByte = com.tencent.mm.b.s.aa(((ffs)localObject).Sth.UH);
        localObject = ((ffs)localObject).idV;
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
          a((ffm)new ffm().parseFrom(arrayOfByte));
          break;
          arrayOfByte = ((ffs)localObject).Sth.UH;
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
                    if (((String)localObject).equals("chromeDevtools"))
                    {
                      i = 5;
                      continue;
                      if (((String)localObject).equals("customMessage")) {
                        i = 6;
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      a((ffx)new ffx().parseFrom(arrayOfByte));
      continue;
      a((fgb)new fgb().parseFrom(arrayOfByte));
      continue;
      a((ffl)new ffl().parseFrom(arrayOfByte));
      continue;
      a((ffv)new ffv().parseFrom(arrayOfByte));
      continue;
      a((ffo)new ffo().parseFrom(arrayOfByte));
      continue;
      a((ffq)new ffq().parseFrom(arrayOfByte));
    }
    Log.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.cAD.bMb()) });
    this.cAD.zx(paramLinkedList.size());
    bMk();
    AppMethodBeat.o(147055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s
 * JD-Core Version:    0.7.0.1
 */