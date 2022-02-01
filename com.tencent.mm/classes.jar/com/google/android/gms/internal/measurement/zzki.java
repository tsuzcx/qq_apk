package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzki
  extends zzaby<zzki>
{
  public Integer zzash;
  public String zzasi;
  public Boolean zzasj;
  public String[] zzask;
  
  public zzki()
  {
    AppMethodBeat.i(2199);
    this.zzash = null;
    this.zzasi = null;
    this.zzasj = null;
    this.zzask = zzach.zzbxq;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2199);
  }
  
  private final zzki zze(zzabv paramzzabv)
  {
    AppMethodBeat.i(2204);
    for (;;)
    {
      int i = paramzzabv.zzuw();
      int j;
      label141:
      Object localObject;
      switch (i)
      {
      default: 
        if (!super.zza(paramzzabv, i))
        {
          AppMethodBeat.o(2204);
          return this;
        }
        break;
      case 0: 
        AppMethodBeat.o(2204);
        return this;
      case 8: 
        j = paramzzabv.getPosition();
        int k;
        try
        {
          k = paramzzabv.zzuy();
          if ((k < 0) || (k > 6)) {
            break label141;
          }
          this.zzash = Integer.valueOf(k);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          paramzzabv.zzam(j);
          zza(paramzzabv, i);
        }
        continue;
        localObject = new IllegalArgumentException(41 + k + " is not a valid enum MatchType");
        AppMethodBeat.o(2204);
        throw ((Throwable)localObject);
      case 18: 
        this.zzasi = paramzzabv.readString();
        break;
      case 24: 
        this.zzasj = Boolean.valueOf(paramzzabv.zzux());
        break;
      case 34: 
        j = zzach.zzb(paramzzabv, 34);
        if (this.zzask == null) {}
        for (i = 0;; i = this.zzask.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzask, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzabv.readString();
            paramzzabv.zzuw();
            j += 1;
          }
        }
        localObject[j] = paramzzabv.readString();
        this.zzask = ((String[])localObject);
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2200);
    if (paramObject == this)
    {
      AppMethodBeat.o(2200);
      return true;
    }
    if (!(paramObject instanceof zzki))
    {
      AppMethodBeat.o(2200);
      return false;
    }
    paramObject = (zzki)paramObject;
    if (this.zzash == null)
    {
      if (paramObject.zzash != null)
      {
        AppMethodBeat.o(2200);
        return false;
      }
    }
    else if (!this.zzash.equals(paramObject.zzash))
    {
      AppMethodBeat.o(2200);
      return false;
    }
    if (this.zzasi == null)
    {
      if (paramObject.zzasi != null)
      {
        AppMethodBeat.o(2200);
        return false;
      }
    }
    else if (!this.zzasi.equals(paramObject.zzasi))
    {
      AppMethodBeat.o(2200);
      return false;
    }
    if (this.zzasj == null)
    {
      if (paramObject.zzasj != null)
      {
        AppMethodBeat.o(2200);
        return false;
      }
    }
    else if (!this.zzasj.equals(paramObject.zzasj))
    {
      AppMethodBeat.o(2200);
      return false;
    }
    if (!zzacc.equals(this.zzask, paramObject.zzask))
    {
      AppMethodBeat.o(2200);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2200);
        return true;
      }
      AppMethodBeat.o(2200);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2200);
    return bool;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(2201);
    int i1 = getClass().getName().hashCode();
    int i;
    int j;
    label39:
    int k;
    label48:
    int i2;
    if (this.zzash == null)
    {
      i = 0;
      if (this.zzasi != null) {
        break label133;
      }
      j = 0;
      if (this.zzasj != null) {
        break label144;
      }
      k = 0;
      i2 = zzacc.hashCode(this.zzask);
      m = n;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label155;
        }
      }
    }
    label133:
    label144:
    label155:
    for (int m = n;; m = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2201);
      return ((k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + i2) * 31 + m;
      i = this.zzash.intValue();
      break;
      j = this.zzasi.hashCode();
      break label39;
      k = this.zzasj.hashCode();
      break label48;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(2203);
    int j = super.zza();
    int i = j;
    if (this.zzash != null) {
      i = j + zzabw.zzf(1, this.zzash.intValue());
    }
    j = i;
    if (this.zzasi != null) {
      j = i + zzabw.zzc(2, this.zzasi);
    }
    i = j;
    if (this.zzasj != null)
    {
      this.zzasj.booleanValue();
      i = j + (zzabw.zzaq(3) + 1);
    }
    j = i;
    int k;
    int m;
    if (this.zzask != null)
    {
      j = i;
      if (this.zzask.length > 0)
      {
        k = 0;
        j = 0;
        m = 0;
        if (k < this.zzask.length)
        {
          String str = this.zzask[k];
          if (str == null) {
            break label166;
          }
          m += 1;
          j = zzabw.zzfm(str) + j;
        }
      }
    }
    label166:
    for (;;)
    {
      k += 1;
      break;
      j = i + j + m * 1;
      AppMethodBeat.o(2203);
      return j;
    }
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(2202);
    if (this.zzash != null) {
      paramzzabw.zze(1, this.zzash.intValue());
    }
    if (this.zzasi != null) {
      paramzzabw.zzb(2, this.zzasi);
    }
    if (this.zzasj != null) {
      paramzzabw.zza(3, this.zzasj.booleanValue());
    }
    if ((this.zzask != null) && (this.zzask.length > 0))
    {
      int i = 0;
      while (i < this.zzask.length)
      {
        String str = this.zzask[i];
        if (str != null) {
          paramzzabw.zzb(4, str);
        }
        i += 1;
      }
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzki
 * JD-Core Version:    0.7.0.1
 */