package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hb;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.atomic.AtomicInteger;

public class QualitySessionRuntime
  extends QualitySession
{
  public boolean bYk;
  public o jPl;
  public long lVA;
  public AppStartupPerformanceReportBundle lVB;
  public int lVC;
  public final a.a lVD;
  public final e lVE;
  public AtomicInteger lVF;
  public final l lVG;
  public i lVH;
  public i lVI;
  public long lVJ;
  public long lVK;
  public long lVL;
  public volatile hb lVM;
  public volatile boolean lVN;
  public volatile boolean lVO;
  public volatile boolean lVP;
  private Boolean lVQ;
  public long lVv;
  public long lVw;
  public long lVx;
  public long lVy;
  public long lVz;
  
  QualitySessionRuntime(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(48233);
    this.lVD = new a.a();
    this.lVE = new e();
    this.lVF = new AtomicInteger(0);
    this.lVG = new l();
    this.lVH = i.lUZ;
    this.lVI = i.lUZ;
    this.lVJ = 0L;
    this.lVM = new hb();
    this.lVN = false;
    this.lVO = false;
    this.lVP = false;
    AppMethodBeat.o(48233);
  }
  
  private Long btQ()
  {
    int j = 1;
    AppMethodBeat.i(186946);
    int i;
    if (this.lVH == i.lVa) {
      i = 1;
    }
    for (;;)
    {
      long l;
      if (this.bYk)
      {
        l = i * 10 + 100 + 0;
        AppMethodBeat.o(186946);
        return Long.valueOf(l);
        if (this.lVH == i.lVb) {
          i = 2;
        }
      }
      else
      {
        if (this.lVI == i.lVa) {}
        for (;;)
        {
          l = i * 10 + 100 + j;
          AppMethodBeat.o(186946);
          return Long.valueOf(l);
          if (this.lVH == i.lVb) {
            j = 2;
          } else {
            j = 0;
          }
        }
      }
      i = 0;
    }
  }
  
  public final long btP()
  {
    AppMethodBeat.i(48231);
    Long localLong = btQ();
    if (localLong != null)
    {
      ac.i("MicroMsg.QualitySessionRuntime", "calculateReportPreloadType: preloadType = [%d]", new Object[] { localLong });
      long l = localLong.longValue();
      AppMethodBeat.o(48231);
      return l;
    }
    AppMethodBeat.o(48231);
    return -1L;
  }
  
  /* Error */
  public final boolean btR()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 143
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 145	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVQ	Ljava/lang/Boolean;
    //   11: ifnonnull +14 -> 25
    //   14: iconst_0
    //   15: istore_1
    //   16: ldc 143
    //   18: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 145	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVQ	Ljava/lang/Boolean;
    //   29: invokevirtual 150	java/lang/Boolean:booleanValue	()Z
    //   32: istore_1
    //   33: ldc 143
    //   35: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: goto -17 -> 21
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	QualitySessionRuntime
    //   15	18	1	bool	boolean
    //   41	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	41	finally
    //   16	21	41	finally
    //   25	38	41	finally
  }
  
  /* Error */
  public final void btS()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVQ	Ljava/lang/Boolean;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getstatic 154	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   18: putfield 145	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVQ	Ljava/lang/Boolean;
    //   21: goto -10 -> 11
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	QualitySessionRuntime
    //   6	2	1	localBoolean	Boolean
    //   24	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	24	finally
    //   14	21	24	finally
  }
  
  public final long btT()
  {
    AppMethodBeat.i(186947);
    switch (1.jrs[this.jPl.jdK.jqZ.aXJ().ordinal()])
    {
    default: 
      AppMethodBeat.o(186947);
      return 0L;
    case 1: 
      AppMethodBeat.o(186947);
      return 0L;
    case 2: 
      AppMethodBeat.o(186947);
      return 1L;
    }
    AppMethodBeat.o(186947);
    return 2L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime
 * JD-Core Version:    0.7.0.1
 */