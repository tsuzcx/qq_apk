package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.support.v4.e.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzdu
  extends zzhg
{
  private final Map<String, Long> zzadf;
  private final Map<String, Integer> zzadg;
  private long zzadh;
  
  public zzdu(zzgl paramzzgl)
  {
    super(paramzzgl);
    AppMethodBeat.i(68491);
    this.zzadg = new a();
    this.zzadf = new a();
    AppMethodBeat.o(68491);
  }
  
  private final void zza(long paramLong, zzie paramzzie)
  {
    AppMethodBeat.i(68496);
    if (paramzzie == null)
    {
      zzge().zzit().log("Not logging ad exposure. No active activity");
      AppMethodBeat.o(68496);
      return;
    }
    if (paramLong < 1000L)
    {
      zzge().zzit().zzg("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      AppMethodBeat.o(68496);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("_xt", paramLong);
    zzif.zza(paramzzie, localBundle, true);
    zzfu().logEvent("am", "_xa", localBundle);
    AppMethodBeat.o(68496);
  }
  
  private final void zza(String paramString, long paramLong)
  {
    AppMethodBeat.i(68493);
    zzab();
    Preconditions.checkNotEmpty(paramString);
    if (this.zzadg.isEmpty()) {
      this.zzadh = paramLong;
    }
    Integer localInteger = (Integer)this.zzadg.get(paramString);
    if (localInteger != null)
    {
      this.zzadg.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
      AppMethodBeat.o(68493);
      return;
    }
    if (this.zzadg.size() >= 100)
    {
      zzge().zzip().log("Too many ads visible");
      AppMethodBeat.o(68493);
      return;
    }
    this.zzadg.put(paramString, Integer.valueOf(1));
    this.zzadf.put(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(68493);
  }
  
  private final void zza(String paramString, long paramLong, zzie paramzzie)
  {
    AppMethodBeat.i(68497);
    if (paramzzie == null)
    {
      zzge().zzit().log("Not logging ad unit exposure. No active activity");
      AppMethodBeat.o(68497);
      return;
    }
    if (paramLong < 1000L)
    {
      zzge().zzit().zzg("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      AppMethodBeat.o(68497);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_ai", paramString);
    localBundle.putLong("_xt", paramLong);
    zzif.zza(paramzzie, localBundle, true);
    zzfu().logEvent("am", "_xu", localBundle);
    AppMethodBeat.o(68497);
  }
  
  private final void zzb(String paramString, long paramLong)
  {
    AppMethodBeat.i(68495);
    zzab();
    Preconditions.checkNotEmpty(paramString);
    Object localObject = (Integer)this.zzadg.get(paramString);
    if (localObject != null)
    {
      zzie localzzie = zzfy().zzkc();
      int i = ((Integer)localObject).intValue() - 1;
      if (i == 0)
      {
        this.zzadg.remove(paramString);
        localObject = (Long)this.zzadf.get(paramString);
        if (localObject == null) {
          zzge().zzim().log("First ad unit exposure time was never set");
        }
        while (this.zzadg.isEmpty()) {
          if (this.zzadh == 0L)
          {
            zzge().zzim().log("First ad exposure time was never set");
            AppMethodBeat.o(68495);
            return;
            long l = ((Long)localObject).longValue();
            this.zzadf.remove(paramString);
            zza(paramString, paramLong - l, localzzie);
          }
          else
          {
            zza(paramLong - this.zzadh, localzzie);
            this.zzadh = 0L;
          }
        }
        AppMethodBeat.o(68495);
        return;
      }
      this.zzadg.put(paramString, Integer.valueOf(i));
      AppMethodBeat.o(68495);
      return;
    }
    zzge().zzim().zzg("Call to endAdUnitExposure for unknown ad unit id", paramString);
    AppMethodBeat.o(68495);
  }
  
  private final void zzl(long paramLong)
  {
    AppMethodBeat.i(68499);
    Iterator localIterator = this.zzadf.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.zzadf.put(str, Long.valueOf(paramLong));
    }
    if (!this.zzadf.isEmpty()) {
      this.zzadh = paramLong;
    }
    AppMethodBeat.o(68499);
  }
  
  public final void beginAdUnitExposure(String paramString)
  {
    AppMethodBeat.i(68492);
    if ((paramString == null) || (paramString.length() == 0))
    {
      zzge().zzim().log("Ad unit id must be a non-empty string");
      AppMethodBeat.o(68492);
      return;
    }
    long l = zzbt().elapsedRealtime();
    zzgd().zzc(new zzdv(this, paramString, l));
    AppMethodBeat.o(68492);
  }
  
  public final void endAdUnitExposure(String paramString)
  {
    AppMethodBeat.i(68494);
    if ((paramString == null) || (paramString.length() == 0))
    {
      zzge().zzim().log("Ad unit id must be a non-empty string");
      AppMethodBeat.o(68494);
      return;
    }
    long l = zzbt().elapsedRealtime();
    zzgd().zzc(new zzdw(this, paramString, l));
    AppMethodBeat.o(68494);
  }
  
  public final void zzk(long paramLong)
  {
    AppMethodBeat.i(68498);
    zzie localzzie = zzfy().zzkc();
    Iterator localIterator = this.zzadf.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zza(str, paramLong - ((Long)this.zzadf.get(str)).longValue(), localzzie);
    }
    if (!this.zzadf.isEmpty()) {
      zza(paramLong - this.zzadh, localzzie);
    }
    zzl(paramLong);
    AppMethodBeat.o(68498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdu
 * JD-Core Version:    0.7.0.1
 */