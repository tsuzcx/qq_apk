package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

final class zzfn
  implements Runnable
{
  private final String packageName;
  private final int status;
  private final zzfm zzajh;
  private final Throwable zzaji;
  private final byte[] zzajj;
  private final Map<String, List<String>> zzajk;
  
  private zzfn(String paramString, zzfm paramzzfm, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(1453);
    Preconditions.checkNotNull(paramzzfm);
    this.zzajh = paramzzfm;
    this.status = paramInt;
    this.zzaji = paramThrowable;
    this.zzajj = paramArrayOfByte;
    this.packageName = paramString;
    this.zzajk = paramMap;
    AppMethodBeat.o(1453);
  }
  
  public final void run()
  {
    AppMethodBeat.i(1454);
    this.zzajh.zza(this.packageName, this.status, this.zzaji, this.zzajj, this.zzajk);
    AppMethodBeat.o(1454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfn
 * JD-Core Version:    0.7.0.1
 */