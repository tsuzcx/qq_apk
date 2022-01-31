package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.tencent.magicbrush.engine.JsInspector;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.protocal.c.cgf;
import com.tencent.mm.protocal.c.cgg;
import com.tencent.mm.protocal.c.cgh;
import com.tencent.mm.protocal.c.cgi;
import com.tencent.mm.protocal.c.cgk;
import com.tencent.mm.protocal.c.cgl;
import com.tencent.mm.protocal.c.cgo;
import com.tencent.mm.protocal.c.cgq;
import com.tencent.mm.protocal.c.cgs;
import com.tencent.mm.protocal.c.cgu;
import com.tencent.mm.protocal.c.cgv;
import com.tencent.mm.protocal.c.cgw;
import com.tencent.mm.protocal.c.cgy;
import com.tencent.mm.protocal.c.chh;
import com.tencent.mm.protocal.c.chi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import org.json.JSONArray;

public final class n
{
  private static final Map<String, String[]> fSD;
  private ab<Integer, Long> fSE = new ab(100);
  private boolean fSF = false;
  private long fSG;
  private LinkedList<m> fSH = new LinkedList();
  private final int fSI = 5000;
  private int fSJ = 0;
  private long fSK = 0L;
  j fSm;
  q fSo;
  s fSq;
  Timer mTimer;
  
  static
  {
    HashMap localHashMap = new HashMap();
    fSD = localHashMap;
    localHashMap.put("publishHandler", new String[] { "String", "String", "String" });
    fSD.put("invokeHandler", new String[] { "String", "String", "Number" });
  }
  
  public n()
  {
    JsInspector.a(new n.1(this));
  }
  
  public static void a(cgw paramcgw)
  {
    paramcgw.tVo = "WeixinJSCore";
    Iterator localIterator = fSD.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((String[])fSD.get(str)).length > 5)
      {
        y.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
      }
      else
      {
        cgs localcgs = new cgs();
        localcgs.tVp = str;
        int i = 0;
        while (i < ((String[])fSD.get(str)).length)
        {
          localcgs.tVq.add(((String[])fSD.get(str))[i]);
          i += 1;
        }
        paramcgw.tVJ.add(localcgs);
      }
    }
  }
  
  private void a(LinkedList<m> paramLinkedList, boolean paramBoolean)
  {
    try
    {
      a(paramLinkedList, paramBoolean, false);
      return;
    }
    finally
    {
      paramLinkedList = finally;
      throw paramLinkedList;
    }
  }
  
  private void a(LinkedList<m> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    try
    {
      boolean bool = bk.dk(paramLinkedList);
      if (bool) {
        return;
      }
      localObject = new cgy();
      ((cgy)localObject).tVQ = this.fSm.fRJ;
      ((cgy)localObject).tVR = this.fSm.aeA();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        ((cgy)localObject).tVF.add(localm.fSu);
      }
      localObject = r.a(1006, (com.tencent.mm.bv.a)localObject);
    }
    finally {}
    if ((!this.fSm.isBusy()) || (paramBoolean2))
    {
      y.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
      this.fSo.a((cgk)localObject);
    }
    for (;;)
    {
      if (paramBoolean1) {
        w(paramLinkedList);
      }
      int i = ((cgk)localObject).uC;
      paramLinkedList = this.fSm;
      paramLinkedList.fRQ = System.currentTimeMillis();
      paramLinkedList.fRS = System.currentTimeMillis();
      if (!this.fSm.isBusy()) {
        this.fSJ = 0;
      }
      paramLinkedList = new i();
      paramLinkedList.size = ((cgk)localObject).btq();
      paramLinkedList.fRE = System.currentTimeMillis();
      this.fSm.fSb.put(((cgk)localObject).dCX, paramLinkedList);
      break;
      y.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
    }
  }
  
  private void aeG()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.fSm.fSc.size())
        {
          int j;
          if (i == 0)
          {
            j = this.fSm.aeA();
            int k = ((cgl)this.fSm.fSc.get(i)).eAK;
            if (j - k != 1) {
              bP(j + 1, k - 1);
            }
          }
          else
          {
            j = ((cgl)this.fSm.fSc.get(i - 1)).eAK;
            continue;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  private static int[] sO(String paramString)
  {
    int i = 0;
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
      y.e("MicroMsg.RemoteDebugMsgMrg", paramString.getMessage());
      localObject2 = localObject1;
    }
  }
  
  private LinkedList<cgl> v(LinkedList<cgl> paramLinkedList)
  {
    if (paramLinkedList == null) {}
    LinkedList localLinkedList1;
    for (paramLinkedList = null;; paramLinkedList = localLinkedList1)
    {
      return paramLinkedList;
      LinkedList localLinkedList2;
      int i;
      for (;;)
      {
        cgl localcgl;
        try
        {
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          this.fSm.fSc.addAll(paramLinkedList);
          Collections.sort(this.fSm.fSc, new n.2(this));
          i = this.fSm.aeA();
          paramLinkedList = this.fSm.fSc.iterator();
          if (!paramLinkedList.hasNext()) {
            break;
          }
          localcgl = (cgl)paramLinkedList.next();
          if (localcgl == null) {
            continue;
          }
          if (localcgl.eAK <= i)
          {
            localLinkedList2.add(localcgl);
            continue;
          }
          if (localcgl.eAK - i != 1) {
            break;
          }
        }
        finally {}
        localLinkedList1.add(localcgl);
        i = localcgl.eAK;
      }
      this.fSm.kD(i);
      this.fSm.fSc.removeAll(localLinkedList1);
      this.fSm.fSc.removeAll(localLinkedList2);
      y.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
    }
  }
  
  /* Error */
  private void w(LinkedList<m> paramLinkedList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 151
    //   4: ldc_w 355
    //   7: invokestatic 285	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_1
    //   11: invokestatic 186	com/tencent/mm/sdk/platformtools/bk:dk	(Ljava/util/List;)Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifeq +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 90	com/tencent/mm/plugin/appbrand/debugger/n:fSm	Lcom/tencent/mm/plugin/appbrand/debugger/j;
    //   26: getfield 358	com/tencent/mm/plugin/appbrand/debugger/j:fSa	Ljava/util/LinkedList;
    //   29: aload_1
    //   30: invokevirtual 335	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   33: pop
    //   34: goto -15 -> 19
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	n
    //   0	42	1	paramLinkedList	LinkedList<m>
    //   14	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	37	finally
    //   22	34	37	finally
  }
  
  public final void B(int paramInt, String paramString)
  {
    cgh localcgh = new cgh();
    localcgh.tVr = paramInt;
    localcgh.bOn = paramString;
    a(r.a(localcgh, this.fSm, "callInterfaceResult"));
  }
  
  public final void a(m arg1)
  {
    int i;
    if (!this.fSm.aeE())
    {
      synchronized (this.fSm.mLock)
      {
        if ((System.currentTimeMillis() - this.fSm.fRQ > 16L) && (!this.fSF)) {
          break label177;
        }
        this.fSH.add(???);
        long l = System.currentTimeMillis();
        synchronized (this.fSm.mLock)
        {
          if ((this.fSF) && (l - this.fSG < 32L)) {
            return;
          }
          this.fSG = l;
          if (!bk.dk(this.fSH)) {}
        }
      }
      this.fSF = true;
      i = (int)(16L - (System.currentTimeMillis() - this.fSm.fRQ));
      if (i <= 0) {
        break label204;
      }
    }
    for (;;)
    {
      c.DS().k(new n.3(this), i);
      break;
      label177:
      ??? = new LinkedList();
      ((LinkedList)???).add(???);
      a((LinkedList)???, true);
      return;
      label204:
      i = 16;
    }
  }
  
  public final void aeH()
  {
    int i = 0;
    try
    {
      boolean bool = this.fSm.isBusy();
      if (bool) {
        return;
      }
      long l = System.currentTimeMillis();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.fSm.fSa.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          m localm = (m)localIterator.next();
          if (l - localm.fRE > 5000L)
          {
            localm.fRE = System.currentTimeMillis();
            localLinkedList.add(localm);
            i = localm.fSv + i;
            if ((i >= 65536L) || (localLinkedList.size() > 800))
            {
              y.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
              a(localLinkedList, false);
              localLinkedList.clear();
            }
          }
        }
        else
        {
          if (bk.dk(localLinkedList)) {
            break;
          }
          y.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
          a(localLinkedList, false);
          break;
        }
      }
    }
    finally {}
  }
  
  public final boolean aeI()
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.fSK;
        int i = this.fSJ;
        if (l1 - l2 < i)
        {
          bool = false;
          return bool;
        }
        this.fSK = l1;
        if (this.fSJ < 5000)
        {
          this.fSJ += 1000;
          LinkedList localLinkedList1 = new LinkedList();
          localObject = this.fSm.fSa.iterator();
          if (((Iterator)localObject).hasNext())
          {
            m localm = (m)((Iterator)localObject).next();
            if (l1 - localm.fRE <= 5000L) {
              continue;
            }
            localm.fRE = System.currentTimeMillis();
            localLinkedList1.add(localm);
            a(localLinkedList1, false, true);
            bool = true;
          }
        }
        else
        {
          this.fSJ = 2000;
          continue;
        }
        if (this.fSm.fSa.size() <= 0) {
          break label225;
        }
      }
      finally {}
      Object localObject = (m)this.fSm.fSa.get(0);
      ((m)localObject).fRE = System.currentTimeMillis();
      localLinkedList2.add(localObject);
      a(localLinkedList2, false, true);
      boolean bool = true;
      continue;
      label225:
      bool = false;
    }
  }
  
  public final void aeJ()
  {
    for (;;)
    {
      m localm;
      try
      {
        y.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.fSm.fSa.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localm = (m)localIterator.next();
        if (localm.fSu == null)
        {
          localLinkedList.add(localm);
          continue;
        }
        if (localm.fSu.eAK > this.fSm.aeB()) {
          continue;
        }
      }
      finally {}
      localCollection.add(localm);
    }
    this.fSm.fSa.removeAll(localCollection);
  }
  
  public final void aeK()
  {
    y.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
  }
  
  public final void bP(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2) {
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.fSE.get(Integer.valueOf(paramInt1)) != null) && (l - ((Long)this.fSE.get(Integer.valueOf(paramInt1))).longValue() < 3000L))
    {
      y.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
      return;
    }
    this.fSE.put(Integer.valueOf(paramInt1), Long.valueOf(l));
    Object localObject = new chi();
    ((chi)localObject).tVQ = this.fSm.fRJ;
    ((chi)localObject).tWd = paramInt1;
    ((chi)localObject).tWe = paramInt2;
    localObject = r.a(1005, (com.tencent.mm.bv.a)localObject);
    this.fSo.a((cgk)localObject);
    this.fSm.fRT = System.currentTimeMillis();
  }
  
  public final void bQ(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      m localm;
      try
      {
        y.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.fSm.fSa.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localm = (m)localIterator.next();
        if (localm.fSu == null)
        {
          localLinkedList.add(localm);
          continue;
        }
        if (localm.fSu.eAK < paramInt1) {
          continue;
        }
      }
      finally {}
      if (localm.fSu.eAK <= paramInt2) {
        localCollection.add(localm);
      }
    }
    this.fSm.fSa.removeAll(localCollection);
  }
  
  public final void quit()
  {
    y.i("MicroMsg.RemoteDebugMsgMrg", "quit");
    Object localObject = new chh();
    ((chh)localObject).tVQ = this.fSm.fRJ;
    localObject = r.a(1004, (com.tencent.mm.bv.a)localObject);
    this.fSo.a((cgk)localObject);
  }
  
  final void u(LinkedList<cgl> paramLinkedList)
  {
    if (bk.dk(paramLinkedList))
    {
      y.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
      return;
    }
    Iterator localIterator = v(paramLinkedList).iterator();
    label26:
    while (localIterator.hasNext())
    {
      Object localObject2 = (cgl)localIterator.next();
      if (r.kF(((cgl)localObject2).tGT))
      {
        localObject1 = com.tencent.mm.a.q.r(((cgl)localObject2).sRj.oY);
        label72:
        localObject2 = ((cgl)localObject2).category;
        i = -1;
        switch (((String)localObject2).hashCode())
        {
        }
      }
      Object localObject3;
      Object localObject4;
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          localObject2 = (cgg)new cgg().aH((byte[])localObject1);
          y.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[] { ((cgg)localObject2).tVp, Integer.valueOf(((cgg)localObject2).tVr) });
          localObject3 = ((cgg)localObject2).tVp;
          localObject4 = ((cgg)localObject2).tVq;
          if (fSD.containsKey(localObject3)) {
            break label382;
          }
          y.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
          break;
          localObject1 = ((cgl)localObject2).sRj.oY;
          break label72;
          if (((String)localObject2).equals("callInterface"))
          {
            i = 0;
            continue;
            if (((String)localObject2).equals("evaluateJavascriptResult"))
            {
              i = 1;
              continue;
              if (((String)localObject2).equals("ping"))
              {
                i = 2;
                continue;
                if (((String)localObject2).equals("breakpoint"))
                {
                  i = 3;
                  continue;
                  if (((String)localObject2).equals("domOp"))
                  {
                    i = 4;
                    continue;
                    if (((String)localObject2).equals("chromeDevtools")) {
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
      label382:
      localObject1 = (String[])fSD.get(localObject3);
      if (((LinkedList)localObject4).size() < localObject1.length)
      {
        y.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
      }
      else
      {
        LinkedList localLinkedList = new LinkedList();
        i = 0;
        if (i < localObject1.length)
        {
          if ("Number".equals(localObject1[i])) {
            localLinkedList.add(Integer.valueOf((String)((LinkedList)localObject4).get(i)));
          }
          for (;;)
          {
            i += 1;
            break;
            if ("Boolean".equals(localObject1[i])) {
              localLinkedList.add(Boolean.valueOf((String)((LinkedList)localObject4).get(i)));
            } else {
              localLinkedList.add(((LinkedList)localObject4).get(i));
            }
          }
        }
        long l = System.currentTimeMillis();
        i = -1;
        switch (((String)localObject3).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            y.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
            break label26;
            if (((String)localObject3).equals("publishHandler"))
            {
              i = 0;
              continue;
              if (((String)localObject3).equals("invokeHandler")) {
                i = 1;
              }
            }
            break;
          }
        }
        this.fSm.fRI.a((String)String.class.cast(localLinkedList.get(0)), (String)String.class.cast(localLinkedList.get(1)), sO((String)String.class.cast(localLinkedList.get(2))));
        localObject1 = null;
        label683:
        localObject1 = String.valueOf(localObject1);
        if (!bk.bl((String)localObject1)) {
          B(((cgg)localObject2).tVr, (String)localObject1);
        }
        int j = ((cgg)localObject2).btq();
        if (localObject1 == null) {}
        for (i = 0;; i = ((String)localObject1).length())
        {
          o.a((String)localObject3, (LinkedList)localObject4, l, j, i);
          break;
          localObject1 = this.fSm.fRI.n((String)String.class.cast(localLinkedList.get(0)), (String)String.class.cast(localLinkedList.get(1)), ((Integer)Integer.class.cast(localLinkedList.get(2))).intValue());
          break label683;
        }
        localObject1 = (cgq)new cgq().aH((byte[])localObject1);
        y.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[] { Integer.valueOf(((cgq)localObject1).tVE) });
        i = ((cgq)localObject1).tVE;
        localObject2 = ((cgq)localObject1).bOn;
        localObject3 = (a)this.fSm.fSd.remove(Integer.valueOf(i));
        if (localObject3 != null)
        {
          localObject4 = ((a)localObject3).fRD;
          if (localObject4 != null) {
            ((ValueCallback)localObject4).onReceiveValue(localObject2);
          }
          y.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + (String)localObject2);
          o.a((a)localObject3, ((cgq)localObject1).btq());
          continue;
          localObject1 = (cgu)new cgu().aH((byte[])localObject1);
          localObject2 = new cgv();
          ((cgv)localObject2).tVH = ((cgu)localObject1).tVH;
          ((cgv)localObject2).tVI = o.aeM();
          y.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[] { Integer.valueOf(((cgv)localObject2).tVI) });
          a(r.a((com.tencent.mm.bv.a)localObject2, this.fSm, "pong"));
          continue;
          localObject1 = (cgf)new cgf().aH((byte[])localObject1);
          if (this.fSm.aeC() != ((cgf)localObject1).tVn)
          {
            if (((cgf)localObject1).tVn) {
              this.fSm.cO(true);
            }
            for (;;)
            {
              this.fSq.aeO();
              this.fSq.aeR();
              break;
              this.fSm.cO(false);
            }
            localObject1 = (cgo)new cgo().aH((byte[])localObject1);
            y.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
            i = this.fSm.fRI.getRuntime().Zz().getCurrentPage().getCurrentPageView().hashCode();
            if (((cgo)localObject1).tVD != i)
            {
              y.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[] { Integer.valueOf(((cgo)localObject1).tVD), Integer.valueOf(i) });
            }
            else
            {
              this.fSm.fRI.a("remoteDebugCommand", ((cgo)localObject1).tVC, null);
              continue;
              localObject1 = (cgi)new cgi().aH((byte[])localObject1);
              JsInspector.b(((cgi)localObject1).tVs, ((cgi)localObject1).tmf);
            }
          }
        }
      }
    }
    y.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.fSm.aeA()) });
    Object localObject1 = this.fSm;
    int i = paramLinkedList.size();
    ((j)localObject1).fSf += i;
    aeG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.n
 * JD-Core Version:    0.7.0.1
 */