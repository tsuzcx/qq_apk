package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.pa;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.t;
import java.util.concurrent.atomic.AtomicInteger;

public class QualitySessionRuntime
  extends QualitySession
{
  public boolean csz;
  public t nAH;
  public long qNA;
  public long qNB;
  public long qNC;
  public long qND;
  public long qNE;
  public long qNF;
  public AppStartupPerformanceReportBundle qNG;
  public int qNH;
  public final b.a qNI;
  public final f qNJ;
  public AtomicInteger qNK;
  public final m qNL;
  public j qNM;
  public j qNN;
  public long qNO;
  public long qNP;
  public long qNQ;
  public volatile pa qNR;
  public volatile boolean qNS;
  public volatile boolean qNT;
  public volatile boolean qNU;
  public volatile boolean qNV;
  private Boolean qNW;
  
  QualitySessionRuntime(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(48233);
    this.qNI = new b.a();
    this.qNJ = new f();
    this.qNK = new AtomicInteger(0);
    this.qNL = new m();
    this.qNM = j.qNd;
    this.qNN = j.qNd;
    this.qNO = 0L;
    this.qNR = new pa();
    this.qNS = false;
    this.qNT = false;
    this.qNU = false;
    this.qNV = false;
    AppMethodBeat.o(48233);
  }
  
  public final long cir()
  {
    int j = 1;
    AppMethodBeat.i(48231);
    if (this.nAH.So()) {}
    for (int k = 2;; k = 1)
    {
      int i;
      if (this.qNM == j.qNe) {
        i = 1;
      }
      for (;;)
      {
        long l;
        if (this.csz)
        {
          l = k * 100 + i * 10 + 0;
          AppMethodBeat.o(48231);
          return l;
          if (this.qNM == j.qNf) {
            i = 2;
          }
        }
        else
        {
          if (this.qNN == j.qNe) {}
          for (;;)
          {
            l = k * 100 + i * 10 + j;
            AppMethodBeat.o(48231);
            return l;
            if (this.qNN == j.qNf) {
              j = 2;
            } else {
              j = 0;
            }
          }
        }
        i = 0;
      }
    }
  }
  
  /* Error */
  public final boolean cis()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 126
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 128	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNW	Ljava/lang/Boolean;
    //   11: ifnonnull +14 -> 25
    //   14: iconst_0
    //   15: istore_1
    //   16: ldc 126
    //   18: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 128	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNW	Ljava/lang/Boolean;
    //   29: invokevirtual 133	java/lang/Boolean:booleanValue	()Z
    //   32: istore_1
    //   33: ldc 126
    //   35: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public final void cit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 128	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNW	Ljava/lang/Boolean;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getstatic 137	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   18: putfield 128	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNW	Ljava/lang/Boolean;
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
  
  public final long ciu()
  {
    AppMethodBeat.i(259197);
    switch (1.nLn[this.nAH.ntR.nKU.bIg().ordinal()])
    {
    default: 
      AppMethodBeat.o(259197);
      return 0L;
    case 1: 
      AppMethodBeat.o(259197);
      return 0L;
    case 2: 
      AppMethodBeat.o(259197);
      return 1L;
    }
    AppMethodBeat.o(259197);
    return 2L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime
 * JD-Core Version:    0.7.0.1
 */