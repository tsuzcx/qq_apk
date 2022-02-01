package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzi
  extends zzn<zzi>
{
  private static volatile zzi[] zzgb;
  public int type;
  public zzj zzgc;
  
  public zzi()
  {
    AppMethodBeat.i(100674);
    this.type = 1;
    this.zzgc = null;
    this.zzhc = null;
    this.zzhl = -1;
    AppMethodBeat.o(100674);
  }
  
  private final zzi zzb(zzk paramzzk)
  {
    AppMethodBeat.i(100679);
    for (;;)
    {
      int i = paramzzk.zzj();
      switch (i)
      {
      default: 
        if (!super.zza(paramzzk, i))
        {
          AppMethodBeat.o(100679);
          return this;
        }
        break;
      case 0: 
        AppMethodBeat.o(100679);
        return this;
      case 8: 
        int j = paramzzk.getPosition();
        int k;
        try
        {
          k = paramzzk.zzk();
          if ((k <= 0) || (k > 15)) {
            break label116;
          }
          this.type = k;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          paramzzk.zzg(j);
          zza(paramzzk, i);
        }
        continue;
        IllegalArgumentException localIllegalArgumentException2 = new IllegalArgumentException(36 + k + " is not a valid enum Type");
        AppMethodBeat.o(100679);
        throw localIllegalArgumentException2;
      case 18: 
        label116:
        if (this.zzgc == null) {
          this.zzgc = new zzj();
        }
        paramzzk.zza(this.zzgc);
      }
    }
  }
  
  public static zzi[] zzi()
  {
    if (zzgb == null) {}
    synchronized (zzr.zzhk)
    {
      if (zzgb == null) {
        zzgb = new zzi[0];
      }
      return zzgb;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(100675);
    if (paramObject == this)
    {
      AppMethodBeat.o(100675);
      return true;
    }
    if (!(paramObject instanceof zzi))
    {
      AppMethodBeat.o(100675);
      return false;
    }
    paramObject = (zzi)paramObject;
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(100675);
      return false;
    }
    if (this.zzgc == null)
    {
      if (paramObject.zzgc != null)
      {
        AppMethodBeat.o(100675);
        return false;
      }
    }
    else if (!this.zzgc.equals(paramObject.zzgc))
    {
      AppMethodBeat.o(100675);
      return false;
    }
    if ((this.zzhc == null) || (this.zzhc.isEmpty()))
    {
      if ((paramObject.zzhc == null) || (paramObject.zzhc.isEmpty()))
      {
        AppMethodBeat.o(100675);
        return true;
      }
      AppMethodBeat.o(100675);
      return false;
    }
    boolean bool = this.zzhc.equals(paramObject.zzhc);
    AppMethodBeat.o(100675);
    return bool;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(100676);
    int m = getClass().getName().hashCode();
    int n = this.type;
    zzj localzzj = this.zzgc;
    int i;
    if (localzzj == null)
    {
      i = 0;
      j = k;
      if (this.zzhc != null) {
        if (!this.zzhc.isEmpty()) {
          break label96;
        }
      }
    }
    label96:
    for (int j = k;; j = this.zzhc.hashCode())
    {
      AppMethodBeat.o(100676);
      return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
      i = localzzj.hashCode();
      break;
    }
  }
  
  public final void zza(zzl paramzzl)
  {
    AppMethodBeat.i(100677);
    paramzzl.zzd(1, this.type);
    if (this.zzgc != null) {
      paramzzl.zza(2, this.zzgc);
    }
    super.zza(paramzzl);
    AppMethodBeat.o(100677);
  }
  
  protected final int zzg()
  {
    AppMethodBeat.i(100678);
    int j = super.zzg() + zzl.zze(1, this.type);
    int i = j;
    if (this.zzgc != null) {
      i = j + zzl.zzb(2, this.zzgc);
    }
    AppMethodBeat.o(100678);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzi
 * JD-Core Version:    0.7.0.1
 */