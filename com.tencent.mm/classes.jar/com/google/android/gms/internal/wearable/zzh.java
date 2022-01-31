package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh
  extends zzn<zzh>
{
  private static volatile zzh[] zzfz;
  public String name;
  public zzi zzga;
  
  public zzh()
  {
    AppMethodBeat.i(70685);
    this.name = "";
    this.zzga = null;
    this.zzhc = null;
    this.zzhl = -1;
    AppMethodBeat.o(70685);
  }
  
  public static zzh[] zzh()
  {
    if (zzfz == null) {}
    synchronized (zzr.zzhk)
    {
      if (zzfz == null) {
        zzfz = new zzh[0];
      }
      return zzfz;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70686);
    if (paramObject == this)
    {
      AppMethodBeat.o(70686);
      return true;
    }
    if (!(paramObject instanceof zzh))
    {
      AppMethodBeat.o(70686);
      return false;
    }
    paramObject = (zzh)paramObject;
    if (this.name == null)
    {
      if (paramObject.name != null)
      {
        AppMethodBeat.o(70686);
        return false;
      }
    }
    else if (!this.name.equals(paramObject.name))
    {
      AppMethodBeat.o(70686);
      return false;
    }
    if (this.zzga == null)
    {
      if (paramObject.zzga != null)
      {
        AppMethodBeat.o(70686);
        return false;
      }
    }
    else if (!this.zzga.equals(paramObject.zzga))
    {
      AppMethodBeat.o(70686);
      return false;
    }
    if ((this.zzhc == null) || (this.zzhc.isEmpty()))
    {
      if ((paramObject.zzhc == null) || (paramObject.zzhc.isEmpty()))
      {
        AppMethodBeat.o(70686);
        return true;
      }
      AppMethodBeat.o(70686);
      return false;
    }
    boolean bool = this.zzhc.equals(paramObject.zzhc);
    AppMethodBeat.o(70686);
    return bool;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(70687);
    int n = getClass().getName().hashCode();
    int i;
    zzi localzzi;
    int j;
    if (this.name == null)
    {
      i = 0;
      localzzi = this.zzga;
      if (localzzi != null) {
        break label103;
      }
      j = 0;
      label42:
      k = m;
      if (this.zzhc != null) {
        if (!this.zzhc.isEmpty()) {
          break label112;
        }
      }
    }
    label103:
    label112:
    for (int k = m;; k = this.zzhc.hashCode())
    {
      AppMethodBeat.o(70687);
      return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      i = this.name.hashCode();
      break;
      j = localzzi.hashCode();
      break label42;
    }
  }
  
  public final void zza(zzl paramzzl)
  {
    AppMethodBeat.i(70688);
    paramzzl.zza(1, this.name);
    if (this.zzga != null) {
      paramzzl.zza(2, this.zzga);
    }
    super.zza(paramzzl);
    AppMethodBeat.o(70688);
  }
  
  protected final int zzg()
  {
    AppMethodBeat.i(70689);
    int j = super.zzg() + zzl.zzb(1, this.name);
    int i = j;
    if (this.zzga != null) {
      i = j + zzl.zzb(2, this.zzga);
    }
    AppMethodBeat.o(70689);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzh
 * JD-Core Version:    0.7.0.1
 */