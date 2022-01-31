package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.o;
import java.util.concurrent.atomic.AtomicInteger;

public class QualitySessionRuntime
  extends QualitySession
{
  public boolean bAa;
  public o htX;
  public long iIH;
  public long iII;
  public long iIJ;
  public AppStartupPerformanceReportBundle iIK;
  public int iIL;
  public final a.a iIM;
  public final e iIN;
  public AtomicInteger iIO;
  public final h iIP;
  public boolean iIQ;
  public long iIR;
  
  QualitySessionRuntime(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(132708);
    this.iIM = new a.a();
    this.iIN = new e();
    this.iIO = new AtomicInteger(0);
    this.iIP = new h();
    this.iIQ = false;
    this.iIR = 0L;
    AppMethodBeat.o(132708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime
 * JD-Core Version:    0.7.0.1
 */