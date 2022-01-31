package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzft
{
  private boolean value;
  private final boolean zzako;
  private boolean zzakp;
  private final String zzny;
  
  public zzft(zzfr paramzzfr, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68960);
    Preconditions.checkNotEmpty(paramString);
    this.zzny = paramString;
    this.zzako = true;
    AppMethodBeat.o(68960);
  }
  
  public final boolean get()
  {
    AppMethodBeat.i(68961);
    if (!this.zzakp)
    {
      this.zzakp = true;
      this.value = zzfr.zza(this.zzakq).getBoolean(this.zzny, this.zzako);
    }
    boolean bool = this.value;
    AppMethodBeat.o(68961);
    return bool;
  }
  
  public final void set(boolean paramBoolean)
  {
    AppMethodBeat.i(68962);
    SharedPreferences.Editor localEditor = zzfr.zza(this.zzakq).edit();
    localEditor.putBoolean(this.zzny, paramBoolean);
    localEditor.apply();
    this.value = paramBoolean;
    AppMethodBeat.o(68962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzft
 * JD-Core Version:    0.7.0.1
 */