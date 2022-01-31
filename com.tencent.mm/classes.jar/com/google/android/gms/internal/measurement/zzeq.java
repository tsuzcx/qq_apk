package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzeq
{
  final String name;
  final long zzafr;
  final long zzafs;
  final long zzaft;
  final long zzafu;
  final Long zzafv;
  final Long zzafw;
  final Boolean zzafx;
  final String zzti;
  
  zzeq(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Long paramLong5, Long paramLong6, Boolean paramBoolean)
  {
    AppMethodBeat.i(68725);
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    if (paramLong1 >= 0L)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      if (paramLong2 < 0L) {
        break label126;
      }
      bool = true;
      label43:
      Preconditions.checkArgument(bool);
      if (paramLong4 < 0L) {
        break label132;
      }
    }
    label132:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.zzti = paramString1;
      this.name = paramString2;
      this.zzafr = paramLong1;
      this.zzafs = paramLong2;
      this.zzaft = paramLong3;
      this.zzafu = paramLong4;
      this.zzafv = paramLong5;
      this.zzafw = paramLong6;
      this.zzafx = paramBoolean;
      AppMethodBeat.o(68725);
      return;
      bool = false;
      break;
      label126:
      bool = false;
      break label43;
    }
  }
  
  final zzeq zza(Long paramLong1, Long paramLong2, Boolean paramBoolean)
  {
    AppMethodBeat.i(68729);
    if ((paramBoolean != null) && (!paramBoolean.booleanValue())) {
      paramBoolean = null;
    }
    for (;;)
    {
      paramLong1 = new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, this.zzaft, this.zzafu, paramLong1, paramLong2, paramBoolean);
      AppMethodBeat.o(68729);
      return paramLong1;
    }
  }
  
  final zzeq zzac(long paramLong)
  {
    AppMethodBeat.i(68727);
    zzeq localzzeq = new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, paramLong, this.zzafu, this.zzafv, this.zzafw, this.zzafx);
    AppMethodBeat.o(68727);
    return localzzeq;
  }
  
  final zzeq zzad(long paramLong)
  {
    AppMethodBeat.i(68728);
    zzeq localzzeq = new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, this.zzaft, paramLong, this.zzafv, this.zzafw, this.zzafx);
    AppMethodBeat.o(68728);
    return localzzeq;
  }
  
  final zzeq zzie()
  {
    AppMethodBeat.i(68726);
    zzeq localzzeq = new zzeq(this.zzti, this.name, this.zzafr + 1L, this.zzafs + 1L, this.zzaft, this.zzafu, this.zzafv, this.zzafw, this.zzafx);
    AppMethodBeat.o(68726);
    return localzzeq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzeq
 * JD-Core Version:    0.7.0.1
 */