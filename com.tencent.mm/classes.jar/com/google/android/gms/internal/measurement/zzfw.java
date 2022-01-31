package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfw
{
  private String value;
  private boolean zzakp;
  private final String zzakv;
  private final String zzny;
  
  public zzfw(zzfr paramzzfr, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68971);
    Preconditions.checkNotEmpty(paramString1);
    this.zzny = paramString1;
    this.zzakv = null;
    AppMethodBeat.o(68971);
  }
  
  public final void zzbs(String paramString)
  {
    AppMethodBeat.i(68973);
    if (zzka.zzs(paramString, this.value))
    {
      AppMethodBeat.o(68973);
      return;
    }
    SharedPreferences.Editor localEditor = zzfr.zza(this.zzakq).edit();
    localEditor.putString(this.zzny, paramString);
    localEditor.apply();
    this.value = paramString;
    AppMethodBeat.o(68973);
  }
  
  public final String zzjg()
  {
    AppMethodBeat.i(68972);
    if (!this.zzakp)
    {
      this.zzakp = true;
      this.value = zzfr.zza(this.zzakq).getString(this.zzny, null);
    }
    String str = this.value;
    AppMethodBeat.o(68972);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfw
 * JD-Core Version:    0.7.0.1
 */