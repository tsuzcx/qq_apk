package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.if;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.o;
import java.util.concurrent.atomic.AtomicInteger;

public class QualitySessionRuntime
  extends QualitySession
{
  public boolean ciC;
  public o jCo;
  public long mvA;
  public long mvB;
  public volatile if mvC;
  public volatile boolean mvD;
  public volatile boolean mvE;
  public volatile boolean mvF;
  private Boolean mvG;
  public long mvl;
  public long mvm;
  public long mvn;
  public long mvo;
  public long mvp;
  public long mvq;
  public AppStartupPerformanceReportBundle mvr;
  public int mvs;
  public final a.a mvt;
  public final e mvu;
  public AtomicInteger mvv;
  public final l mvw;
  public i mvx;
  public i mvy;
  public long mvz;
  
  QualitySessionRuntime(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(48233);
    this.mvt = new a.a();
    this.mvu = new e();
    this.mvv = new AtomicInteger(0);
    this.mvw = new l();
    this.mvx = i.muP;
    this.mvy = i.muP;
    this.mvz = 0L;
    this.mvC = new if();
    this.mvD = false;
    this.mvE = false;
    this.mvF = false;
    AppMethodBeat.o(48233);
  }
  
  public final long bxU()
  {
    int j = 1;
    AppMethodBeat.i(48231);
    int i;
    if (this.mvx == i.muQ) {
      i = 1;
    }
    for (;;)
    {
      long l;
      if (this.ciC)
      {
        l = i * 10 + 100 + 0;
        AppMethodBeat.o(48231);
        return l;
        if (this.mvx == i.muR) {
          i = 2;
        }
      }
      else
      {
        if (this.mvy == i.muQ) {}
        for (;;)
        {
          l = i * 10 + 100 + j;
          AppMethodBeat.o(48231);
          return l;
          if (this.mvy == i.muR) {
            j = 2;
          } else {
            j = 0;
          }
        }
      }
      i = 0;
    }
  }
  
  /* Error */
  public final boolean bxV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 114
    //   4: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 116	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvG	Ljava/lang/Boolean;
    //   11: ifnonnull +14 -> 25
    //   14: iconst_0
    //   15: istore_1
    //   16: ldc 114
    //   18: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 116	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvG	Ljava/lang/Boolean;
    //   29: invokevirtual 121	java/lang/Boolean:booleanValue	()Z
    //   32: istore_1
    //   33: ldc 114
    //   35: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   41	4	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	14	41	finally
    //   16	21	41	finally
    //   25	38	41	finally
  }
  
  /* Error */
  public final void bxW()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 116	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvG	Ljava/lang/Boolean;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getstatic 125	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   18: putfield 116	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvG	Ljava/lang/Boolean;
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
    //   24	4	1	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	7	24	finally
    //   14	21	24	finally
  }
  
  public final long bxX()
  {
    AppMethodBeat.i(188744);
    switch (QualitySessionRuntime.1.jLm[this.jCo.jwS.jKT.bbg().ordinal()])
    {
    default: 
      AppMethodBeat.o(188744);
      return 0L;
    case 1: 
      AppMethodBeat.o(188744);
      return 0L;
    case 2: 
      AppMethodBeat.o(188744);
      return 1L;
    }
    AppMethodBeat.o(188744);
    return 2L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime
 * JD-Core Version:    0.7.0.1
 */