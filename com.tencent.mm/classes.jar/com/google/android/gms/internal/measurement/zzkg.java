package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzkg
  extends zzaby<zzkg>
{
  public Integer zzarz;
  public Boolean zzasa;
  public String zzasb;
  public String zzasc;
  public String zzasd;
  
  public zzkg()
  {
    AppMethodBeat.i(2186);
    this.zzarz = null;
    this.zzasa = null;
    this.zzasb = null;
    this.zzasc = null;
    this.zzasd = null;
    this.zzbww = null;
    this.zzbxh = -1;
    AppMethodBeat.o(2186);
  }
  
  private final zzkg zzd(zzabv paramzzabv)
  {
    AppMethodBeat.i(2191);
    for (;;)
    {
      int i = paramzzabv.zzuw();
      switch (i)
      {
      default: 
        if (!super.zza(paramzzabv, i))
        {
          AppMethodBeat.o(2191);
          return this;
        }
        break;
      case 0: 
        AppMethodBeat.o(2191);
        return this;
      case 8: 
        int j = paramzzabv.getPosition();
        int k;
        try
        {
          k = paramzzabv.zzuy();
          if ((k < 0) || (k > 4)) {
            break label148;
          }
          this.zzarz = Integer.valueOf(k);
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          paramzzabv.zzam(j);
          zza(paramzzabv, i);
        }
        continue;
        IllegalArgumentException localIllegalArgumentException2 = new IllegalArgumentException(46 + k + " is not a valid enum ComparisonType");
        AppMethodBeat.o(2191);
        throw localIllegalArgumentException2;
      case 16: 
        this.zzasa = Boolean.valueOf(paramzzabv.zzux());
        break;
      case 26: 
        this.zzasb = paramzzabv.readString();
        break;
      case 34: 
        this.zzasc = paramzzabv.readString();
        break;
      case 42: 
        label148:
        this.zzasd = paramzzabv.readString();
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2187);
    if (paramObject == this)
    {
      AppMethodBeat.o(2187);
      return true;
    }
    if (!(paramObject instanceof zzkg))
    {
      AppMethodBeat.o(2187);
      return false;
    }
    paramObject = (zzkg)paramObject;
    if (this.zzarz == null)
    {
      if (paramObject.zzarz != null)
      {
        AppMethodBeat.o(2187);
        return false;
      }
    }
    else if (!this.zzarz.equals(paramObject.zzarz))
    {
      AppMethodBeat.o(2187);
      return false;
    }
    if (this.zzasa == null)
    {
      if (paramObject.zzasa != null)
      {
        AppMethodBeat.o(2187);
        return false;
      }
    }
    else if (!this.zzasa.equals(paramObject.zzasa))
    {
      AppMethodBeat.o(2187);
      return false;
    }
    if (this.zzasb == null)
    {
      if (paramObject.zzasb != null)
      {
        AppMethodBeat.o(2187);
        return false;
      }
    }
    else if (!this.zzasb.equals(paramObject.zzasb))
    {
      AppMethodBeat.o(2187);
      return false;
    }
    if (this.zzasc == null)
    {
      if (paramObject.zzasc != null)
      {
        AppMethodBeat.o(2187);
        return false;
      }
    }
    else if (!this.zzasc.equals(paramObject.zzasc))
    {
      AppMethodBeat.o(2187);
      return false;
    }
    if (this.zzasd == null)
    {
      if (paramObject.zzasd != null)
      {
        AppMethodBeat.o(2187);
        return false;
      }
    }
    else if (!this.zzasd.equals(paramObject.zzasd))
    {
      AppMethodBeat.o(2187);
      return false;
    }
    if ((this.zzbww == null) || (this.zzbww.isEmpty()))
    {
      if ((paramObject.zzbww == null) || (paramObject.zzbww.isEmpty()))
      {
        AppMethodBeat.o(2187);
        return true;
      }
      AppMethodBeat.o(2187);
      return false;
    }
    boolean bool = this.zzbww.equals(paramObject.zzbww);
    AppMethodBeat.o(2187);
    return bool;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    AppMethodBeat.i(2188);
    int i3 = getClass().getName().hashCode();
    int i;
    int j;
    label39:
    int k;
    label48:
    int m;
    label58:
    int n;
    if (this.zzarz == null)
    {
      i = 0;
      if (this.zzasa != null) {
        break label150;
      }
      j = 0;
      if (this.zzasb != null) {
        break label161;
      }
      k = 0;
      if (this.zzasc != null) {
        break label172;
      }
      m = 0;
      if (this.zzasd != null) {
        break label184;
      }
      n = 0;
      label68:
      i1 = i2;
      if (this.zzbww != null) {
        if (!this.zzbww.isEmpty()) {
          break label196;
        }
      }
    }
    label150:
    label161:
    label172:
    label184:
    label196:
    for (int i1 = i2;; i1 = this.zzbww.hashCode())
    {
      AppMethodBeat.o(2188);
      return (n + (m + (k + (j + (i + (i3 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i1;
      i = this.zzarz.intValue();
      break;
      j = this.zzasa.hashCode();
      break label39;
      k = this.zzasb.hashCode();
      break label48;
      m = this.zzasc.hashCode();
      break label58;
      n = this.zzasd.hashCode();
      break label68;
    }
  }
  
  protected final int zza()
  {
    AppMethodBeat.i(2190);
    int j = super.zza();
    int i = j;
    if (this.zzarz != null) {
      i = j + zzabw.zzf(1, this.zzarz.intValue());
    }
    j = i;
    if (this.zzasa != null)
    {
      this.zzasa.booleanValue();
      j = i + (zzabw.zzaq(2) + 1);
    }
    i = j;
    if (this.zzasb != null) {
      i = j + zzabw.zzc(3, this.zzasb);
    }
    j = i;
    if (this.zzasc != null) {
      j = i + zzabw.zzc(4, this.zzasc);
    }
    i = j;
    if (this.zzasd != null) {
      i = j + zzabw.zzc(5, this.zzasd);
    }
    AppMethodBeat.o(2190);
    return i;
  }
  
  public final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(2189);
    if (this.zzarz != null) {
      paramzzabw.zze(1, this.zzarz.intValue());
    }
    if (this.zzasa != null) {
      paramzzabw.zza(2, this.zzasa.booleanValue());
    }
    if (this.zzasb != null) {
      paramzzabw.zzb(3, this.zzasb);
    }
    if (this.zzasc != null) {
      paramzzabw.zzb(4, this.zzasc);
    }
    if (this.zzasd != null) {
      paramzzabw.zzb(5, this.zzasd);
    }
    super.zza(paramzzabw);
    AppMethodBeat.o(2189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkg
 * JD-Core Version:    0.7.0.1
 */