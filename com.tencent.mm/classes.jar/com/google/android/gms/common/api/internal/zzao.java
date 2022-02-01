package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

final class zzao
  extends zzbe
{
  zzao(zzam paramzzam, zzbc paramzzbc, BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    super(paramzzbc);
  }
  
  @GuardedBy("mLock")
  public final void zzaq()
  {
    AppMethodBeat.i(11246);
    this.zzia.onReportServiceBinding(new ConnectionResult(16, null));
    AppMethodBeat.o(11246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzao
 * JD-Core Version:    0.7.0.1
 */