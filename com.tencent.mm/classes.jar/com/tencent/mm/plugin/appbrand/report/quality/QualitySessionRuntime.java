package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.p;
import java.util.concurrent.atomic.AtomicInteger;

public class QualitySessionRuntime
  extends QualitySession
{
  public boolean ciE;
  public p jFm;
  public volatile boolean mAA;
  public volatile boolean mAB;
  public volatile boolean mAC;
  private Boolean mAD;
  public long mAi;
  public long mAj;
  public long mAk;
  public long mAl;
  public long mAm;
  public long mAn;
  public AppStartupPerformanceReportBundle mAo;
  public int mAp;
  public final a.a mAq;
  public final e mAr;
  public AtomicInteger mAs;
  public final l mAt;
  public i mAu;
  public i mAv;
  public long mAw;
  public long mAx;
  public long mAy;
  public volatile ih mAz;
  
  QualitySessionRuntime(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(48233);
    this.mAq = new a.a();
    this.mAr = new e();
    this.mAs = new AtomicInteger(0);
    this.mAt = new l();
    this.mAu = i.mzM;
    this.mAv = i.mzM;
    this.mAw = 0L;
    this.mAz = new ih();
    this.mAA = false;
    this.mAB = false;
    this.mAC = false;
    AppMethodBeat.o(48233);
  }
  
  public final long byN()
  {
    int j = 1;
    AppMethodBeat.i(48231);
    int i;
    if (this.mAu == i.mzN) {
      i = 1;
    }
    for (;;)
    {
      long l;
      if (this.ciE)
      {
        l = i * 10 + 100 + 0;
        AppMethodBeat.o(48231);
        return l;
        if (this.mAu == i.mzO) {
          i = 2;
        }
      }
      else
      {
        if (this.mAv == i.mzN) {}
        for (;;)
        {
          l = i * 10 + 100 + j;
          AppMethodBeat.o(48231);
          return l;
          if (this.mAv == i.mzO) {
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
  public final boolean byO()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 116
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 118	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAD	Ljava/lang/Boolean;
    //   11: ifnonnull +14 -> 25
    //   14: iconst_0
    //   15: istore_1
    //   16: ldc 116
    //   18: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 118	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAD	Ljava/lang/Boolean;
    //   29: invokevirtual 123	java/lang/Boolean:booleanValue	()Z
    //   32: istore_1
    //   33: ldc 116
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
  public final void byP()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAD	Ljava/lang/Boolean;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getstatic 127	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   18: putfield 118	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAD	Ljava/lang/Boolean;
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
  
  public final long byQ()
  {
    AppMethodBeat.i(222962);
    switch (1.jOy[this.jFm.jzQ.jOf.bbI().ordinal()])
    {
    default: 
      AppMethodBeat.o(222962);
      return 0L;
    case 1: 
      AppMethodBeat.o(222962);
      return 0L;
    case 2: 
      AppMethodBeat.o(222962);
      return 1L;
    }
    AppMethodBeat.o(222962);
    return 2L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime
 * JD-Core Version:    0.7.0.1
 */