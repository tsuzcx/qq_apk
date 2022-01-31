package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg
  extends zzn<zzg>
{
  public zzh[] zzfy;
  
  public zzg()
  {
    AppMethodBeat.i(70678);
    this.zzfy = zzh.zzh();
    this.zzhc = null;
    this.zzhl = -1;
    AppMethodBeat.o(70678);
  }
  
  public static zzg zza(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70683);
    paramArrayOfByte = (zzg)zzt.zza(new zzg(), paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(70683);
    return paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70679);
    if (paramObject == this)
    {
      AppMethodBeat.o(70679);
      return true;
    }
    if (!(paramObject instanceof zzg))
    {
      AppMethodBeat.o(70679);
      return false;
    }
    paramObject = (zzg)paramObject;
    if (!zzr.equals(this.zzfy, paramObject.zzfy))
    {
      AppMethodBeat.o(70679);
      return false;
    }
    if ((this.zzhc == null) || (this.zzhc.isEmpty()))
    {
      if ((paramObject.zzhc == null) || (paramObject.zzhc.isEmpty()))
      {
        AppMethodBeat.o(70679);
        return true;
      }
      AppMethodBeat.o(70679);
      return false;
    }
    boolean bool = this.zzhc.equals(paramObject.zzhc);
    AppMethodBeat.o(70679);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(70680);
    int j = getClass().getName().hashCode();
    int k = zzr.hashCode(this.zzfy);
    if ((this.zzhc == null) || (this.zzhc.isEmpty())) {}
    for (int i = 0;; i = this.zzhc.hashCode())
    {
      AppMethodBeat.o(70680);
      return i + ((j + 527) * 31 + k) * 31;
    }
  }
  
  public final void zza(zzl paramzzl)
  {
    AppMethodBeat.i(70681);
    if ((this.zzfy != null) && (this.zzfy.length > 0))
    {
      int i = 0;
      while (i < this.zzfy.length)
      {
        zzh localzzh = this.zzfy[i];
        if (localzzh != null) {
          paramzzl.zza(1, localzzh);
        }
        i += 1;
      }
    }
    super.zza(paramzzl);
    AppMethodBeat.o(70681);
  }
  
  protected final int zzg()
  {
    AppMethodBeat.i(70682);
    int i = super.zzg();
    int k = i;
    if (this.zzfy != null)
    {
      k = i;
      if (this.zzfy.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.zzfy.length) {
            break;
          }
          zzh localzzh = this.zzfy[j];
          k = i;
          if (localzzh != null) {
            k = i + zzl.zzb(1, localzzh);
          }
          j += 1;
          i = k;
        }
      }
    }
    AppMethodBeat.o(70682);
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzg
 * JD-Core Version:    0.7.0.1
 */