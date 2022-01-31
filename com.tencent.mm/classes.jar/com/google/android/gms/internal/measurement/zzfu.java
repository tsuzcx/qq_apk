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
    AppMethodBeat.i(68963);
    Preconditions.checkNotEmpty(paramString);
    this.zzny = paramString;
    this.zzakr = paramLong;
    AppMethodBeat.o(68963);
  }
  
  public final long get()
  {
    AppMethodBeat.i(68964);
    if (!this.zzakp)
    {
      this.zzakp = true;
      this.value = zzfr.zza(this.zzakq).getLong(this.zzny, this.zzakr);
    }
    long l = this.value;
    AppMethodBeat.o(68964);
    return l;
  }
  
  public final void set(long paramLong)
  {
    AppMethodBeat.i(68965);
    SharedPreferences.Editor localEditor = zzfr.zza(this.zzakq).edit();
    localEditor.putLong(this.zzny, paramLong);
    localEditor.apply();
    this.value = paramLong;
    AppMethodBeat.o(68965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfu
 * JD-Core Version:    0.7.0.1
 */