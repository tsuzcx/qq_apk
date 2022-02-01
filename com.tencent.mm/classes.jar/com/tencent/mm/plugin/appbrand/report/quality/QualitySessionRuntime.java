package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.st;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.w;
import java.util.concurrent.atomic.AtomicInteger;

public class QualitySessionRuntime
  extends QualitySession
{
  public boolean ekt;
  public w qxC;
  public long tSA;
  public volatile st tSB;
  public volatile boolean tSC;
  public volatile boolean tSD;
  public volatile boolean tSE;
  public volatile boolean tSF;
  private Boolean tSG;
  public long tSk;
  public long tSl;
  public long tSm;
  public long tSn;
  public long tSo;
  public long tSp;
  public AppStartupPerformanceReportBundle tSq;
  public int tSr;
  public final b.a tSs;
  public final e tSt;
  public AtomicInteger tSu;
  public final l tSv;
  public i tSw;
  public i tSx;
  public long tSy;
  public long tSz;
  
  QualitySessionRuntime(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(48233);
    this.tSs = new b.a();
    this.tSt = new e();
    this.tSu = new AtomicInteger(0);
    this.tSv = new l();
    this.tSw = i.tRN;
    this.tSx = i.tRN;
    this.tSy = 0L;
    this.tSC = false;
    this.tSD = false;
    this.tSE = false;
    this.tSF = false;
    this.tSB = new st();
    this.tSB.jzF = 2L;
    this.tSB.jys = 2L;
    this.tSB.jzG = 2L;
    AppMethodBeat.o(48233);
  }
  
  public final long cJi()
  {
    int j = 1;
    AppMethodBeat.i(48231);
    if (this.qxC.asE()) {}
    for (int k = 2;; k = 1)
    {
      int i;
      if (this.tSw == i.tRO) {
        i = 1;
      }
      for (;;)
      {
        long l;
        if (this.ekt)
        {
          l = k * 100 + i * 10 + 0;
          AppMethodBeat.o(48231);
          return l;
          if (this.tSw == i.tRP) {
            i = 2;
          }
        }
        else
        {
          if (this.tSx == i.tRO) {}
          for (;;)
          {
            l = k * 100 + i * 10 + j;
            AppMethodBeat.o(48231);
            return l;
            if (this.tSx == i.tRP) {
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
  public final boolean cJj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 137
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 139	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSG	Ljava/lang/Boolean;
    //   11: ifnonnull +14 -> 25
    //   14: iconst_0
    //   15: istore_1
    //   16: ldc 137
    //   18: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 139	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSG	Ljava/lang/Boolean;
    //   29: invokevirtual 144	java/lang/Boolean:booleanValue	()Z
    //   32: istore_1
    //   33: ldc 137
    //   35: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public final void cJk()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 139	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSG	Ljava/lang/Boolean;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getstatic 148	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   18: putfield 139	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSG	Ljava/lang/Boolean;
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
  
  public final long cJl()
  {
    AppMethodBeat.i(321417);
    switch (1.qKW[this.qxC.qsB.qKC.chD().ordinal()])
    {
    default: 
      AppMethodBeat.o(321417);
      return 0L;
    case 1: 
      AppMethodBeat.o(321417);
      return 0L;
    case 2: 
      AppMethodBeat.o(321417);
      return 1L;
    }
    AppMethodBeat.o(321417);
    return 2L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime
 * JD-Core Version:    0.7.0.1
 */