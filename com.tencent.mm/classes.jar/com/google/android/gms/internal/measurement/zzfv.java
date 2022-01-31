package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;

public final class zzfv
{
  private final long zzabj;
  @VisibleForTesting
  private final String zzaks;
  private final String zzakt;
  private final String zzaku;
  
  private zzfv(zzfr paramzzfr, String paramString, long paramLong)
  {
    AppMethodBeat.i(68966);
    Preconditions.checkNotEmpty(paramString);
    if (paramLong > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.zzaks = String.valueOf(paramString).concat(":start");
      this.zzakt = String.valueOf(paramString).concat(":count");
      this.zzaku = String.valueOf(paramString).concat(":value");
      this.zzabj = paramLong;
      AppMethodBeat.o(68966);
      return;
    }
  }
  
  private final void zzfh()
  {
    AppMethodBeat.i(68967);
    this.zzakq.zzab();
    long l = this.zzakq.zzbt().currentTimeMillis();
    SharedPreferences.Editor localEditor = zzfr.zza(this.zzakq).edit();
    localEditor.remove(this.zzakt);
    localEditor.remove(this.zzaku);
    localEditor.putLong(this.zzaks, l);
    localEditor.apply();
    AppMethodBeat.o(68967);
  }
  
  private final long zzfj()
  {
    AppMethodBeat.i(68970);
    long l = zzfr.zza(this.zzakq).getLong(this.zzaks, 0L);
    AppMethodBeat.o(68970);
    return l;
  }
  
  public final void zzc(String paramString, long paramLong)
  {
    AppMethodBeat.i(68968);
    this.zzakq.zzab();
    if (zzfj() == 0L) {
      zzfh();
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramLong = zzfr.zza(this.zzakq).getLong(this.zzakt, 0L);
    if (paramLong <= 0L)
    {
      paramString = zzfr.zza(this.zzakq).edit();
      paramString.putString(this.zzaku, str);
      paramString.putLong(this.zzakt, 1L);
      paramString.apply();
      AppMethodBeat.o(68968);
      return;
    }
    if ((this.zzakq.zzgb().zzlc().nextLong() & 0xFFFFFFFF) < 9223372036854775807L / (paramLong + 1L)) {}
    for (int i = 1;; i = 0)
    {
      paramString = zzfr.zza(this.zzakq).edit();
      if (i != 0) {
        paramString.putString(this.zzaku, str);
      }
      paramString.putLong(this.zzakt, paramLong + 1L);
      paramString.apply();
      AppMethodBeat.o(68968);
      return;
    }
  }
  
  public final Pair<String, Long> zzfi()
  {
    AppMethodBeat.i(68969);
    this.zzakq.zzab();
    this.zzakq.zzab();
    long l = zzfj();
    if (l == 0L) {
      zzfh();
    }
    for (l = 0L; l < this.zzabj; l = Math.abs(l - this.zzakq.zzbt().currentTimeMillis()))
    {
      AppMethodBeat.o(68969);
      return null;
    }
    if (l > this.zzabj << 1)
    {
      zzfh();
      AppMethodBeat.o(68969);
      return null;
    }
    Object localObject = zzfr.zza(this.zzakq).getString(this.zzaku, null);
    l = zzfr.zza(this.zzakq).getLong(this.zzakt, 0L);
    zzfh();
    if ((localObject == null) || (l <= 0L))
    {
      localObject = zzfr.zzajs;
      AppMethodBeat.o(68969);
      return localObject;
    }
    localObject = new Pair(localObject, Long.valueOf(l));
    AppMethodBeat.o(68969);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfv
 * JD-Core Version:    0.7.0.1
 */