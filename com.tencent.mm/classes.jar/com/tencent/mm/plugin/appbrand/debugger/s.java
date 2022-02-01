package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.V8Inspector;
import com.eclipsesource.mmv8.V8Inspector.JsInspectorChannelServer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.protocal.protobuf.gbx;
import com.tencent.mm.protocal.protobuf.gby;
import com.tencent.mm.protocal.protobuf.gbz;
import com.tencent.mm.protocal.protobuf.gca;
import com.tencent.mm.protocal.protobuf.gcb;
import com.tencent.mm.protocal.protobuf.gcc;
import com.tencent.mm.protocal.protobuf.gcd;
import com.tencent.mm.protocal.protobuf.gce;
import com.tencent.mm.protocal.protobuf.gch;
import com.tencent.mm.protocal.protobuf.gcj;
import com.tencent.mm.protocal.protobuf.gcl;
import com.tencent.mm.protocal.protobuf.gcn;
import com.tencent.mm.protocal.protobuf.gco;
import com.tencent.mm.protocal.protobuf.gcp;
import com.tencent.mm.protocal.protobuf.gcr;
import com.tencent.mm.protocal.protobuf.gcu;
import com.tencent.mm.protocal.protobuf.gda;
import com.tencent.mm.protocal.protobuf.gdb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
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
  private static final Map<String, String[]> reh;
  public o esY;
  w rdS;
  y rdV;
  private LruCache<Integer, Long> rei;
  private boolean rej;
  private long rek;
  private LinkedList<r> rel;
  private final int rem;
  private int ren;
  private long reo;
  Future<?> rep;
  
  static
  {
    AppMethodBeat.i(147077);
    HashMap localHashMap = new HashMap();
    reh = localHashMap;
    localHashMap.put("publishHandler", new String[] { "String", "String", "String" });
    reh.put("invokeHandler", new String[] { "String", "String", "Number" });
    AppMethodBeat.o(147077);
  }
  
  public s()
  {
    AppMethodBeat.i(147049);
    this.rei = new LruCache(100);
    this.rej = false;
    this.rel = new LinkedList();
    this.rem = 5000;
    this.ren = 0;
    this.reo = 0L;
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
        gcb localgcb = new gcb();
        localgcb.acal = paramAnonymousLong;
        localgcb.aaGI = paramAnonymousString;
        locals.a(x.a(localgcb, locals.esY, "chromeDevtoolsResult"));
        AppMethodBeat.o(147046);
        return 0;
      }
    });
    AppMethodBeat.o(147049);
  }
  
  private LinkedList<gce> A(LinkedList<gce> paramLinkedList)
  {
    for (;;)
    {
      LinkedList localLinkedList1;
      LinkedList localLinkedList2;
      gce localgce;
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
        this.esY.rdH.addAll(paramLinkedList);
        Collections.sort(this.esY.rdH, new Comparator() {});
        i = this.esY.clB();
        paramLinkedList = this.esY.rdH.iterator();
        if (!paramLinkedList.hasNext()) {
          break label165;
        }
        localgce = (gce)paramLinkedList.next();
        if (localgce == null) {
          continue;
        }
        if (localgce.oUj <= i)
        {
          localLinkedList2.add(localgce);
          continue;
        }
        if (localgce.oUj - i != 1) {
          break label165;
        }
      }
      finally {}
      localLinkedList1.add(localgce);
      int i = localgce.oUj;
      continue;
      label165:
      this.esY.zK(i);
      this.esY.rdH.removeAll(localLinkedList1);
      this.esY.rdH.removeAll(localLinkedList2);
      Log.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
      AppMethodBeat.o(147056);
      paramLinkedList = localLinkedList1;
    }
  }
  
  /* Error */
  private void B(LinkedList<r> paramLinkedList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 182
    //   4: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 160
    //   9: ldc 184
    //   11: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokestatic 193	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   18: ifeq +11 -> 29
    //   21: ldc 182
    //   23: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 109	com/tencent/mm/plugin/appbrand/debugger/s:esY	Lcom/tencent/mm/plugin/appbrand/debugger/o;
    //   33: getfield 196	com/tencent/mm/plugin/appbrand/debugger/o:rdF	Ljava/util/LinkedList;
    //   36: aload_1
    //   37: invokevirtual 118	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   40: pop
    //   41: ldc 182
    //   43: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -20 -> 26
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	s
    //   0	54	1	paramLinkedList	LinkedList<r>
    // Exception table:
    //   from	to	target	type
    //   2	26	49	finally
    //   29	46	49	finally
  }
  
  private static int[] Yh(String paramString)
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
  
  private void a(gbx paramgbx)
  {
    AppMethodBeat.i(147057);
    if (this.esY.clD() == paramgbx.acag)
    {
      AppMethodBeat.o(147057);
      return;
    }
    if (paramgbx.acag) {
      this.esY.iL(true);
    }
    for (;;)
    {
      this.rdV.clU();
      this.rdV.clZ();
      AppMethodBeat.o(147057);
      return;
      this.esY.iL(false);
    }
  }
  
  private void a(gby paramgby)
  {
    AppMethodBeat.i(147051);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[] { paramgby.acai, Integer.valueOf(paramgby.acak) });
    String str = paramgby.acai;
    LinkedList localLinkedList = paramgby.acaj;
    if (!reh.containsKey(str))
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
      AppMethodBeat.o(147051);
      return;
    }
    Object localObject = (String[])reh.get(str);
    if (localLinkedList.size() < localObject.length)
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
      AppMethodBeat.o(147051);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < localObject.length)
    {
      if ("Number".equals(localObject[i])) {
        localArrayList.add(Integer.valueOf(Util.getInt((String)localLinkedList.get(i), 0)));
      }
      for (;;)
      {
        i += 1;
        break;
        if ("Boolean".equals(localObject[i])) {
          localArrayList.add(Boolean.valueOf((String)localLinkedList.get(i)));
        } else {
          localArrayList.add(localLinkedList.get(i));
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
    this.esY.rdo.b((String)String.class.cast(localArrayList.get(0)), (String)String.class.cast(localArrayList.get(1)), Yh((String)String.class.cast(localArrayList.get(2))));
    localObject = null;
    label398:
    int j;
    if (localObject != null)
    {
      localObject = String.valueOf(localObject);
      if (!Util.isNullOrNil((String)localObject)) {
        ao(paramgby.acak, (String)localObject);
      }
      j = paramgby.computeSize();
      if (localObject != null) {
        break label548;
      }
    }
    label548:
    for (i = 0;; i = ((String)localObject).length())
    {
      t.a(str, localLinkedList, l, j, i);
      AppMethodBeat.o(147051);
      return;
      if (localArrayList.size() >= 4) {}
      for (localObject = (String)String.class.cast(localArrayList.get(3));; localObject = "")
      {
        localObject = this.esY.rdo.d((String)String.class.cast(localArrayList.get(0)), (String)String.class.cast(localArrayList.get(1)), (String)localObject, ((Integer)Integer.class.cast(localArrayList.get(2))).intValue());
        break;
      }
      localObject = "";
      break label398;
    }
  }
  
  private static void a(gca paramgca)
  {
    AppMethodBeat.i(147059);
    Log.d("MicroMsg.RemoteDebugMsgMrg", "onDevTools op_id:%d, payload:%s", new Object[] { Long.valueOf(paramgca.acal), paramgca.aaGI });
    V8Inspector.onReceiveData(paramgca.acal, paramgca.aaGI);
    AppMethodBeat.o(147059);
  }
  
  private void a(gcc paramgcc)
  {
    AppMethodBeat.i(319698);
    Log.d("MicroMsg.RemoteDebugMsgMrg", "onCustomMsg method:%s, payload:%s", new Object[] { paramgcc.method, paramgcc.aaGI });
    paramgcc = "typeof DebuggerConnection.onCustomMessage === 'function' && DebuggerConnection.onCustomMessage('" + paramgcc.method + "', '" + com.tencent.mm.plugin.appbrand.utils.y.agF(paramgcc.aaGI) + "')";
    this.esY.rdo.getJsRuntime().evaluateJavascript(paramgcc, null);
    AppMethodBeat.o(319698);
  }
  
  private void a(gch paramgch)
  {
    AppMethodBeat.i(147058);
    Log.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp, param:%s", new Object[] { paramgch.rRQ });
    int i = this.esY.rdo.aqZ().getPageContainer().getCurrentPage().getCurrentPageView().getComponentId();
    if ((paramgch.acau != i) && (this.esY.rdu.eul != 1))
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[] { Integer.valueOf(paramgch.acau), Integer.valueOf(i) });
      AppMethodBeat.o(147058);
      return;
    }
    this.esY.rdo.b("remoteDebugCommand", paramgch.rRQ, null);
    AppMethodBeat.o(147058);
  }
  
  private void a(gcj paramgcj)
  {
    AppMethodBeat.i(147061);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[] { Integer.valueOf(paramgcj.acav) });
    int i = paramgcj.acav;
    String str = paramgcj.hLS;
    c localc = (c)this.esY.rdI.remove(Integer.valueOf(i));
    if (localc == null)
    {
      AppMethodBeat.o(147061);
      return;
    }
    ValueCallback localValueCallback = localc.rdf;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(str);
    }
    Log.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str);
    t.a(localc, paramgcj.computeSize());
    AppMethodBeat.o(147061);
  }
  
  private void a(gcn paramgcn)
  {
    AppMethodBeat.i(147060);
    gco localgco = new gco();
    localgco.acay = paramgcn.acay;
    localgco.YDR = t.clS();
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[] { Integer.valueOf(localgco.YDR) });
    a(x.a(localgco, this.esY, "pong"));
    AppMethodBeat.o(147060);
  }
  
  public static void a(gcp paramgcp)
  {
    AppMethodBeat.i(147050);
    paramgcp.acah = "WeixinJSCore";
    Iterator localIterator = reh.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((String[])reh.get(str)).length > 5)
      {
        Log.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
      }
      else
      {
        gcl localgcl = new gcl();
        localgcl.acai = str;
        int i = 0;
        while (i < ((String[])reh.get(str)).length)
        {
          localgcl.acaj.add(((String[])reh.get(str))[i]);
          i += 1;
        }
        paramgcp.acaz.add(localgcl);
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
      localObject = new gcr();
      ((gcr)localObject).acaF = this.esY.rdp;
      ((gcr)localObject).acaG = this.esY.clB();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        r localr = (r)localIterator.next();
        ((gcr)localObject).acaw.add(localr.rea);
      }
      localObject = x.a(1006, (a)localObject);
    }
    finally {}
    if ((!this.esY.isBusy()) || (paramBoolean2))
    {
      Log.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
      this.rdS.a((gcd)localObject);
    }
    for (;;)
    {
      if (paramBoolean1) {
        B(paramLinkedList);
      }
      paramLinkedList = this.esY;
      paramLinkedList.rdv = System.currentTimeMillis();
      paramLinkedList.rdx = System.currentTimeMillis();
      if (!this.esY.isBusy()) {
        this.ren = 0;
      }
      paramLinkedList = new n();
      paramLinkedList.size = ((gcd)localObject).computeSize();
      paramLinkedList.rdg = System.currentTimeMillis();
      this.esY.rdG.put(((gcd)localObject).uuid, paramLinkedList);
      AppMethodBeat.o(147065);
      break;
      Log.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
    }
  }
  
  private void clK()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(147053);
        i = 0;
        if (i < this.esY.rdH.size())
        {
          int j;
          if (i == 0)
          {
            j = this.esY.clB();
            int k = ((gce)this.esY.rdH.get(i)).oUj;
            if (j - k != 1) {
              fl(j + 1, k - 1);
            }
          }
          else
          {
            j = ((gce)this.esY.rdH.get(i - 1)).oUj;
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
  
  private void clL()
  {
    AppMethodBeat.i(147063);
    long l = System.currentTimeMillis();
    for (;;)
    {
      synchronized (this.esY.mLock)
      {
        if ((this.rej) && (l - this.rek < 32L))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.rek = l;
        if (Util.isNullOrNil(this.rel))
        {
          AppMethodBeat.o(147063);
          return;
        }
        this.rej = true;
        i = (int)(16L - (System.currentTimeMillis() - this.esY.rdv));
        if (i > 0)
        {
          l.cNm().j(new Runnable()
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
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(147062);
    if (!this.esY.clF()) {}
    synchronized (this.esY.mLock)
    {
      if ((System.currentTimeMillis() - this.esY.rdv <= 16L) || (this.rej))
      {
        this.rel.add(paramr);
        clL();
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
    this.rdS = paramw;
    this.esY = paramo;
    this.rdV = paramy;
  }
  
  public final void ao(int paramInt, String paramString)
  {
    AppMethodBeat.i(147052);
    gbz localgbz = new gbz();
    localgbz.acak = paramInt;
    localgbz.hLS = paramString;
    a(x.a(localgbz, this.esY, "callInterfaceResult"));
    AppMethodBeat.o(147052);
  }
  
  public final void clM()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(147067);
      if (this.esY.isBusy())
      {
        AppMethodBeat.o(147067);
        return;
      }
      long l = System.currentTimeMillis();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.esY.rdF.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          r localr = (r)localIterator.next();
          if (l - localr.rdg > 5000L)
          {
            localr.rdg = System.currentTimeMillis();
            localLinkedList.add(localr);
            i = localr.reb + i;
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
  
  public final boolean clN()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(147068);
        long l = System.currentTimeMillis();
        if (l - this.reo < this.ren)
        {
          AppMethodBeat.o(147068);
          bool = false;
          return bool;
        }
        this.reo = l;
        if (this.ren < 5000)
        {
          this.ren += 1000;
          LinkedList localLinkedList1 = new LinkedList();
          localObject = this.esY.rdF.iterator();
          if (((Iterator)localObject).hasNext())
          {
            r localr = (r)((Iterator)localObject).next();
            if (l - localr.rdg <= 5000L) {
              continue;
            }
            localr.rdg = System.currentTimeMillis();
            localLinkedList1.add(localr);
            a(localLinkedList1, false, true);
            AppMethodBeat.o(147068);
            bool = true;
          }
        }
        else
        {
          this.ren = 2000;
          continue;
        }
        if (this.esY.rdF.size() <= 0) {
          break label239;
        }
      }
      finally {}
      Object localObject = (r)this.esY.rdF.get(0);
      ((r)localObject).rdg = System.currentTimeMillis();
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
  
  final void clO()
  {
    AppMethodBeat.i(147070);
    this.esY.setStatus(4);
    this.rdS.Yj("quit");
    AppMethodBeat.o(147070);
  }
  
  public final void clP()
  {
    for (;;)
    {
      r localr;
      try
      {
        AppMethodBeat.i(147072);
        Log.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.esY.rdF.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localr = (r)localIterator.next();
        if (localr.rea == null)
        {
          localLinkedList.add(localr);
          continue;
        }
        if (localr.rea.oUj > this.esY.clC()) {
          continue;
        }
      }
      finally {}
      localCollection.add(localr);
    }
    this.esY.rdF.removeAll(localCollection);
    AppMethodBeat.o(147072);
  }
  
  public final void clQ()
  {
    AppMethodBeat.i(147073);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
    if (this.rep != null) {
      this.rep.cancel(false);
    }
    AppMethodBeat.o(147073);
  }
  
  public final void fl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147054);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2)
    {
      AppMethodBeat.o(147054);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.rei.get(Integer.valueOf(paramInt1)) != null) && (l - ((Long)this.rei.get(Integer.valueOf(paramInt1))).longValue() < 3000L))
    {
      Log.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
      AppMethodBeat.o(147054);
      return;
    }
    this.rei.put(Integer.valueOf(paramInt1), Long.valueOf(l));
    Object localObject = new gdb();
    ((gdb)localObject).acaF = this.esY.rdp;
    ((gdb)localObject).acaS = paramInt1;
    ((gdb)localObject).acaT = paramInt2;
    localObject = x.a(1005, (a)localObject);
    this.rdS.a((gcd)localObject);
    this.esY.rdy = System.currentTimeMillis();
    AppMethodBeat.o(147054);
  }
  
  public final void fm(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      r localr;
      try
      {
        AppMethodBeat.i(147071);
        Log.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.esY.rdF.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localr = (r)localIterator.next();
        if (localr.rea == null)
        {
          localLinkedList.add(localr);
          continue;
        }
        if (localr.rea.oUj < paramInt1) {
          continue;
        }
      }
      finally {}
      if (localr.rea.oUj <= paramInt2) {
        localCollection.add(localr);
      }
    }
    this.esY.rdF.removeAll(localCollection);
    AppMethodBeat.o(147071);
  }
  
  public final void quit()
  {
    AppMethodBeat.i(147069);
    Log.i("MicroMsg.RemoteDebugMsgMrg", "quit");
    Object localObject = new gda();
    ((gda)localObject).acaF = this.esY.rdp;
    localObject = x.a(1004, (a)localObject);
    this.rdS.a((gcd)localObject);
    AppMethodBeat.o(147069);
  }
  
  final void z(LinkedList<gce> paramLinkedList)
  {
    AppMethodBeat.i(147055);
    if (Util.isNullOrNil(paramLinkedList))
    {
      Log.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
      AppMethodBeat.o(147055);
      return;
    }
    Iterator localIterator = A(paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (gce)localIterator.next();
      byte[] arrayOfByte;
      label83:
      int i;
      if (x.zN(((gce)localObject).YCv))
      {
        arrayOfByte = com.tencent.mm.b.s.aa(((gce)localObject).Zsu.Op);
        localObject = ((gce)localObject).kDf;
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
          a((gby)new gby().parseFrom(arrayOfByte));
          break;
          arrayOfByte = ((gce)localObject).Zsu.Op;
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
      a((gcj)new gcj().parseFrom(arrayOfByte));
      continue;
      a((gcn)new gcn().parseFrom(arrayOfByte));
      continue;
      a((gbx)new gbx().parseFrom(arrayOfByte));
      continue;
      a((gch)new gch().parseFrom(arrayOfByte));
      continue;
      a((gca)new gca().parseFrom(arrayOfByte));
      continue;
      a((gcc)new gcc().parseFrom(arrayOfByte));
    }
    Log.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.esY.clB()) });
    this.esY.zM(paramLinkedList.size());
    clK();
    AppMethodBeat.o(147055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s
 * JD-Core Version:    0.7.0.1
 */