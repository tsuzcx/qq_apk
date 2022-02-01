package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfu
{
  private long value;
  private boolean zzakp;
  private final long zzakr;
  private final String zzny;
  
  public zzfu(zzfr paramzzfr, String paramString, long paramLong)
  {
    AppMethodBeat.i(1486);
    Preconditions.checkNotEmpty(paramString);
    this.zzny = paramString;
    this.zzakr = paramLong;
    AppMethodBeat.o(1486);
  }
  
  public final long get()
  {
    AppMethodBeat.i(1487);
    if (!this.zzakp)
    {
      this.zzakp = true;
      this.value = zzfr.zza(this.zzakq).getLong(this.zzny, this.zzakr);
    }
    long l = this.value;
    AppMethodBeat.o(1487);
    return l;
  }
  
  public final void set(long paramLong)
  {
    AppMethodBeat.i(1488);
    SharedPreferences.Editor localEditor = zzfr.zza(this.zzakq).edit();
    localEditor.putLong(this.zzny, paramLong);
    localEditor.apply();
    this.value = paramLong;
    AppMethodBeat.o(1488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfu
 * JD-Core Version:    0.7.0.1
 */