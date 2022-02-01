package com.tencent.mm.plugin.ai.data.business.trigger.edge;

import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.mmdata.rpt.bl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ai.data.business.finder.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public abstract class a
  implements com.tencent.mm.plugin.ai.data.business.trigger.c
{
  protected final String TAG;
  private IListener<gh> qlY = new AbsEdgeTrigger.1(this, f.hfK);
  protected c.a qnB;
  protected c.a qnC;
  protected c.a qnD;
  protected long qnE = 0L;
  protected d qnF = new d();
  private bl qnG = new bl();
  
  private a(String paramString)
  {
    this.TAG = paramString;
  }
  
  public a(String paramString, c.a parama1, c.a parama2, c.a parama3)
  {
    this(paramString);
    this.qnB = parama1;
    this.qnC = parama2;
    this.qnD = parama3;
    bZN();
  }
  
  /* Error */
  private String TO(String paramString)
  {
    // Byte code:
    //   0: invokestatic 76	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   3: lstore_2
    //   4: ldc 78
    //   6: invokestatic 84	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   9: checkcast 78	com/tencent/mm/plugin/expt/b/a
    //   12: aload_0
    //   13: getfield 35	com/tencent/mm/plugin/ai/data/business/trigger/edge/a:qnF	Lcom/tencent/mm/plugin/ai/data/business/trigger/edge/d;
    //   16: getfield 87	com/tencent/mm/plugin/ai/data/business/trigger/edge/d:qnS	Ljava/lang/String;
    //   19: aload_1
    //   20: invokeinterface 91 3 0
    //   25: astore 5
    //   27: aload 5
    //   29: ifnull +90 -> 119
    //   32: aload 5
    //   34: invokeinterface 97 1 0
    //   39: ifne +80 -> 119
    //   42: new 99	java/lang/StringBuffer
    //   45: dup
    //   46: invokespecial 100	java/lang/StringBuffer:<init>	()V
    //   49: astore 4
    //   51: aload 5
    //   53: invokeinterface 104 1 0
    //   58: astore 5
    //   60: aload 5
    //   62: invokeinterface 109 1 0
    //   67: ifeq +101 -> 168
    //   70: aload 4
    //   72: aload 5
    //   74: invokeinterface 113 1 0
    //   79: checkcast 115	java/lang/String
    //   82: invokevirtual 119	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   85: ldc 121
    //   87: invokevirtual 119	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   90: pop
    //   91: goto -31 -> 60
    //   94: astore 4
    //   96: aload_0
    //   97: getfield 53	com/tencent/mm/plugin/ai/data/business/trigger/edge/a:TAG	Ljava/lang/String;
    //   100: aload 4
    //   102: ldc 123
    //   104: iconst_1
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: aload 4
    //   112: invokevirtual 127	java/lang/Exception:toString	()Ljava/lang/String;
    //   115: aastore
    //   116: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: ldc 135
    //   121: astore 4
    //   123: aload_0
    //   124: getfield 53	com/tencent/mm/plugin/ai/data/business/trigger/edge/a:TAG	Ljava/lang/String;
    //   127: ldc 137
    //   129: iconst_4
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: getfield 35	com/tencent/mm/plugin/ai/data/business/trigger/edge/a:qnF	Lcom/tencent/mm/plugin/ai/data/business/trigger/edge/d;
    //   139: getfield 140	com/tencent/mm/plugin/ai/data/business/trigger/edge/d:qnQ	Ljava/lang/String;
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: lload_2
    //   146: invokestatic 144	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   149: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   152: aastore
    //   153: dup
    //   154: iconst_2
    //   155: aload_1
    //   156: aastore
    //   157: dup
    //   158: iconst_3
    //   159: aload 4
    //   161: aastore
    //   162: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload 4
    //   167: areturn
    //   168: aload 4
    //   170: invokevirtual 155	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   173: astore 4
    //   175: goto -52 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	a
    //   0	178	1	paramString	String
    //   3	143	2	l	long
    //   49	22	4	localStringBuffer	java.lang.StringBuffer
    //   94	17	4	localException	Exception
    //   121	53	4	str	String
    //   25	48	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	27	94	java/lang/Exception
    //   32	60	94	java/lang/Exception
    //   60	91	94	java/lang/Exception
    //   168	175	94	java/lang/Exception
  }
  
  private void bZN()
  {
    long l = Util.currentTicks();
    Object localObject1;
    if (BuildInfo.IS_ARM64) {
      localObject1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(this.qnB, "");
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(this.qnD, "");
      }
      try
      {
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject1 = this.qnF.TP((String)localObject2);
          if (localObject1 != null)
          {
            localObject1 = M((JSONObject)localObject1);
            Log.i(this.TAG, "reset control [%s] parseLog[%s] cost[%d]", new Object[] { this.qnF, localObject1, Long.valueOf(Util.ticksToNow(l)) });
            return;
            localObject1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(this.qnC, "");
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str = "";
          continue;
          str = null;
        }
      }
    }
  }
  
  abstract String M(JSONObject paramJSONObject);
  
  public void aoW()
  {
    this.qlY.alive();
  }
  
  protected final boolean cau()
  {
    long l = Util.currentTicks();
    if ((Util.isNullOrNil(this.qnF.qnP)) || (Util.isNullOrNil(this.qnF.qnQ))) {
      return false;
    }
    if (Util.isNullOrNil(this.qnF.qnS)) {
      this.qnF.qnS = e.bZM().cz(this.qnF.qnP, this.qnF.qnQ);
    }
    if (!Util.isNullOrNil(this.qnF.qnS)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d(this.TAG, "check edge runtime is ready? [%b] cost [%d]", new Object[] { Boolean.valueOf(bool), Long.valueOf(Util.ticksToNow(l)) });
      return bool;
    }
  }
  
  abstract boolean dH(Object paramObject);
  
  abstract String dI(Object paramObject);
  
  protected final void dJ(Object paramObject)
  {
    long l1 = Util.currentTicks();
    if (!cau()) {}
    long l2;
    do
    {
      do
      {
        return;
      } while ((Util.milliSecondsToNow(this.qnE) <= this.qnF.qnR) || (!dH(paramObject)));
      this.qnE = Util.nowMilliSecond();
      str = dI(paramObject);
      l2 = Util.ticksToNow(l1);
    } while (Util.isNullOrNil(str));
    String str = TO(str);
    long l3 = Util.ticksToNow(l1);
    long l4 = t(str, paramObject);
    long l5 = Util.ticksToNow(l1);
    paramObject = this.qnG;
    paramObject.irG = paramObject.F("JsMd5", this.qnF.qnQ, true);
    paramObject.irH = l2;
    paramObject.irI = (l3 - l2);
    paramObject.irJ = (l5 - l3);
    paramObject.irK = l5;
    paramObject.irL = l4;
    paramObject.bMH();
    Log.i(this.TAG, "handle enter event cost[%d] step[%d %d %d]", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l5) });
  }
  
  abstract long t(String paramString, Object paramObject);
  
  public void unRegister()
  {
    this.qlY.dead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.edge.a
 * JD-Core Version:    0.7.0.1
 */