package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzfh
  implements Runnable
{
  zzfh(zzfg paramzzfg, int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  public final void run()
  {
    AppMethodBeat.i(68899);
    zzfr localzzfr = this.zzajc.zzacw.zzgf();
    if (!localzzfr.isInitialized())
    {
      this.zzajc.zza(6, "Persisted config not initialized. Not logging error/warn");
      AppMethodBeat.o(68899);
      return;
    }
    if (zzfg.zza(this.zzajc) == 0)
    {
      if (!this.zzajc.zzgg().zzds()) {
        break label241;
      }
      zzfg.zza(this.zzajc, 'C');
    }
    for (;;)
    {
      if (zzfg.zzb(this.zzajc) < 0L) {
        zzfg.zza(this.zzajc, 12451L);
      }
      char c1 = "01VDIWEA?".charAt(this.zzaix);
      char c2 = zzfg.zza(this.zzajc);
      long l = zzfg.zzb(this.zzajc);
      Object localObject = zzfg.zza(true, this.zzaiy, this.zzaiz, this.zzaja, this.zzajb);
      String str = String.valueOf(localObject).length() + 24 + "2" + c1 + c2 + l + ":" + (String)localObject;
      localObject = str;
      if (str.length() > 1024) {
        localObject = this.zzaiy.substring(0, 1024);
      }
      localzzfr.zzajt.zzc((String)localObject, 1L);
      AppMethodBeat.o(68899);
      return;
      label241:
      zzfg.zza(this.zzajc, 'c');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfh
 * JD-Core Version:    0.7.0.1
 */