package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mc;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.q;
import java.util.concurrent.atomic.AtomicInteger;

public class QualitySessionRuntime
  extends QualitySession
{
  public boolean cuy;
  public q kGW;
  public j nLA;
  public long nLB;
  public long nLC;
  public long nLD;
  public volatile mc nLE;
  public volatile boolean nLF;
  public volatile boolean nLG;
  public volatile boolean nLH;
  private Boolean nLI;
  public long nLn;
  public long nLo;
  public long nLp;
  public long nLq;
  public long nLr;
  public long nLs;
  public AppStartupPerformanceReportBundle nLt;
  public int nLu;
  public final b.a nLv;
  public final f nLw;
  public AtomicInteger nLx;
  public final m nLy;
  public j nLz;
  
  QualitySessionRuntime(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(48233);
    this.nLv = new b.a();
    this.nLw = new f();
    this.nLx = new AtomicInteger(0);
    this.nLy = new m();
    this.nLz = j.nKR;
    this.nLA = j.nKR;
    this.nLB = 0L;
    this.nLE = new mc();
    this.nLF = false;
    this.nLG = false;
    this.nLH = false;
    AppMethodBeat.o(48233);
  }
  
  public final long bVg()
  {
    int j = 1;
    AppMethodBeat.i(48231);
    if (this.kGW.OS()) {}
    for (int k = 2;; k = 1)
    {
      int i;
      if (this.nLz == j.nKS) {
        i = 1;
      }
      for (;;)
      {
        long l;
        if (this.cuy)
        {
          l = k * 100 + i * 10 + 0;
          AppMethodBeat.o(48231);
          return l;
          if (this.nLz == j.nKT) {
            i = 2;
          }
        }
        else
        {
          if (this.nLA == j.nKS) {}
          for (;;)
          {
            l = k * 100 + i * 10 + j;
            AppMethodBeat.o(48231);
            return l;
            if (this.nLA == j.nKT) {
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
  public final boolean bVh()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 123
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 125	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLI	Ljava/lang/Boolean;
    //   11: ifnonnull +14 -> 25
    //   14: iconst_0
    //   15: istore_1
    //   16: ldc 123
    //   18: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 125	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLI	Ljava/lang/Boolean;
    //   29: invokevirtual 130	java/lang/Boolean:booleanValue	()Z
    //   32: istore_1
    //   33: ldc 123
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
  public final void bVi()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 125	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLI	Ljava/lang/Boolean;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getstatic 134	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   18: putfield 125	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLI	Ljava/lang/Boolean;
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
  
  public final long bVj()
  {
    AppMethodBeat.i(227413);
    switch (1.kRf[this.kGW.kAH.kQM.bwY().ordinal()])
    {
    default: 
      AppMethodBeat.o(227413);
      return 0L;
    case 1: 
      AppMethodBeat.o(227413);
      return 0L;
    case 2: 
      AppMethodBeat.o(227413);
      return 1L;
    }
    AppMethodBeat.o(227413);
    return 2L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime
 * JD-Core Version:    0.7.0.1
 */