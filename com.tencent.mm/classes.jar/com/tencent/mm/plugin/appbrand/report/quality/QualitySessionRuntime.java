package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fj;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.atomic.AtomicInteger;

public class QualitySessionRuntime
  extends QualitySession
{
  public boolean cbn;
  public o joZ;
  public long ltB;
  public long ltC;
  public long ltD;
  public long ltE;
  public long ltF;
  public long ltG;
  public AppStartupPerformanceReportBundle ltH;
  public int ltI;
  public final a.a ltJ;
  public final e ltK;
  public AtomicInteger ltL;
  public final l ltM;
  public i ltN;
  public i ltO;
  public long ltP;
  public long ltQ;
  public long ltR;
  public volatile fj ltS;
  public volatile boolean ltT;
  public volatile boolean ltU;
  public volatile boolean ltV;
  private Boolean ltW;
  
  QualitySessionRuntime(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(48233);
    this.ltJ = new a.a();
    this.ltK = new e();
    this.ltL = new AtomicInteger(0);
    this.ltM = new l();
    this.ltN = i.ltf;
    this.ltO = i.ltf;
    this.ltP = 0L;
    this.ltS = new fj();
    this.ltT = false;
    this.ltU = false;
    this.ltV = false;
    AppMethodBeat.o(48233);
  }
  
  private Long bmU()
  {
    int j = 1;
    AppMethodBeat.i(196104);
    if (this.cbn)
    {
      switch (1.ltX[this.ltN.ordinal()])
      {
      default: 
        AppMethodBeat.o(196104);
        return null;
      case 1: 
        AppMethodBeat.o(196104);
        return Long.valueOf(0L);
      case 2: 
        AppMethodBeat.o(196104);
        return Long.valueOf(1L);
      }
      AppMethodBeat.o(196104);
      return Long.valueOf(2L);
    }
    int i;
    if (this.ltN == i.ltg) {
      i = 1;
    }
    for (;;)
    {
      if (this.ltO == i.ltg) {}
      for (;;)
      {
        long l = i * 10 + 100 + j;
        AppMethodBeat.o(196104);
        return Long.valueOf(l);
        if (this.ltN != i.lth) {
          break label169;
        }
        i = 2;
        break;
        if (this.ltN == i.lth) {
          j = 2;
        } else {
          j = 0;
        }
      }
      label169:
      i = 0;
    }
  }
  
  public final long bmT()
  {
    AppMethodBeat.i(48231);
    Long localLong = bmU();
    if (localLong != null)
    {
      ad.i("MicroMsg.QualitySessionRuntime", "calculateReportPreloadType: preloadType = [%d]", new Object[] { localLong });
      long l = localLong.longValue();
      AppMethodBeat.o(48231);
      return l;
    }
    AppMethodBeat.o(48231);
    return -1L;
  }
  
  /* Error */
  public final boolean bmV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 153
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 155	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltW	Ljava/lang/Boolean;
    //   11: ifnonnull +14 -> 25
    //   14: iconst_0
    //   15: istore_1
    //   16: ldc 153
    //   18: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 155	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltW	Ljava/lang/Boolean;
    //   29: invokevirtual 160	java/lang/Boolean:booleanValue	()Z
    //   32: istore_1
    //   33: ldc 153
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
  public final void bmW()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 155	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltW	Ljava/lang/Boolean;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getstatic 164	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   18: putfield 155	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltW	Ljava/lang/Boolean;
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
  
  public final long bmX()
  {
    AppMethodBeat.i(196105);
    switch (1.iRi[this.joZ.iDK.iQP.aQO().ordinal()])
    {
    default: 
      AppMethodBeat.o(196105);
      return 0L;
    case 1: 
      AppMethodBeat.o(196105);
      return 0L;
    case 2: 
      AppMethodBeat.o(196105);
      return 1L;
    }
    AppMethodBeat.o(196105);
    return 2L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime
 * JD-Core Version:    0.7.0.1
 */