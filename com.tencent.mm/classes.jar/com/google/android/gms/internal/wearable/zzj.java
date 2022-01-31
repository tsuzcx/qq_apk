package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class zzj
  extends zzn<zzj>
{
  public byte[] zzgd;
  public String zzge;
  public double zzgf;
  public float zzgg;
  public long zzgh;
  public int zzgi;
  public int zzgj;
  public boolean zzgk;
  public zzh[] zzgl;
  public zzi[] zzgm;
  public String[] zzgn;
  public long[] zzgo;
  public float[] zzgp;
  public long zzgq;
  
  public zzj()
  {
    AppMethodBeat.i(70698);
    this.zzgd = zzw.zzhy;
    this.zzge = "";
    this.zzgf = 0.0D;
    this.zzgg = 0.0F;
    this.zzgh = 0L;
    this.zzgi = 0;
    this.zzgj = 0;
    this.zzgk = false;
    this.zzgl = zzh.zzh();
    this.zzgm = zzi.zzi();
    this.zzgn = zzw.zzhw;
    this.zzgo = zzw.zzhs;
    this.zzgp = zzw.zzht;
    this.zzgq = 0L;
    this.zzhc = null;
    this.zzhl = -1;
    AppMethodBeat.o(70698);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70699);
    if (paramObject == this)
    {
      AppMethodBeat.o(70699);
      return true;
    }
    if (!(paramObject instanceof zzj))
    {
      AppMethodBeat.o(70699);
      return false;
    }
    paramObject = (zzj)paramObject;
    if (!Arrays.equals(this.zzgd, paramObject.zzgd))
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (this.zzge == null)
    {
      if (paramObject.zzge != null)
      {
        AppMethodBeat.o(70699);
        return false;
      }
    }
    else if (!this.zzge.equals(paramObject.zzge))
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(paramObject.zzgf))
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(paramObject.zzgg))
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (this.zzgh != paramObject.zzgh)
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (this.zzgi != paramObject.zzgi)
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (this.zzgj != paramObject.zzgj)
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (this.zzgk != paramObject.zzgk)
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (!zzr.equals(this.zzgl, paramObject.zzgl))
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (!zzr.equals(this.zzgm, paramObject.zzgm))
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (!zzr.equals(this.zzgn, paramObject.zzgn))
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (!zzr.equals(this.zzgo, paramObject.zzgo))
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (!zzr.equals(this.zzgp, paramObject.zzgp))
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if (this.zzgq != paramObject.zzgq)
    {
      AppMethodBeat.o(70699);
      return false;
    }
    if ((this.zzhc == null) || (this.zzhc.isEmpty()))
    {
      if ((paramObject.zzhc == null) || (paramObject.zzhc.isEmpty()))
      {
        AppMethodBeat.o(70699);
        return true;
      }
      AppMethodBeat.o(70699);
      return false;
    }
    boolean bool = this.zzhc.equals(paramObject.zzhc);
    AppMethodBeat.o(70699);
    return bool;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(70700);
    int n = getClass().getName().hashCode();
    int i1 = Arrays.hashCode(this.zzgd);
    int i;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int j;
    label105:
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    if (this.zzge == null)
    {
      i = 0;
      long l = Double.doubleToLongBits(this.zzgf);
      i2 = (int)(l ^ l >>> 32);
      i3 = Float.floatToIntBits(this.zzgg);
      i4 = (int)(this.zzgh ^ this.zzgh >>> 32);
      i5 = this.zzgi;
      i6 = this.zzgj;
      if (!this.zzgk) {
        break label298;
      }
      j = 1231;
      i7 = zzr.hashCode(this.zzgl);
      i8 = zzr.hashCode(this.zzgm);
      i9 = zzr.hashCode(this.zzgn);
      i10 = zzr.hashCode(this.zzgo);
      i11 = zzr.hashCode(this.zzgp);
      i12 = (int)(this.zzgq ^ this.zzgq >>> 32);
      k = m;
      if (this.zzhc != null) {
        if (!this.zzhc.isEmpty()) {
          break label305;
        }
      }
    }
    label298:
    label305:
    for (int k = m;; k = this.zzhc.hashCode())
    {
      AppMethodBeat.o(70700);
      return (((((((j + ((((((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + k;
      i = this.zzge.hashCode();
      break;
      j = 1237;
      break label105;
    }
  }
  
  public final void zza(zzl paramzzl)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(70701);
    Object localObject;
    if (!Arrays.equals(this.zzgd, zzw.zzhy))
    {
      localObject = this.zzgd;
      paramzzl.zzf(1, 2);
      paramzzl.zzl(localObject.length);
      paramzzl.zzc((byte[])localObject);
    }
    if ((this.zzge != null) && (!this.zzge.equals(""))) {
      paramzzl.zza(2, this.zzge);
    }
    if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(0.0D))
    {
      double d = this.zzgf;
      paramzzl.zzf(3, 1);
      paramzzl.zzb(Double.doubleToLongBits(d));
    }
    if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(0.0F)) {
      paramzzl.zza(4, this.zzgg);
    }
    if (this.zzgh != 0L) {
      paramzzl.zza(5, this.zzgh);
    }
    if (this.zzgi != 0) {
      paramzzl.zzd(6, this.zzgi);
    }
    if (this.zzgj != 0)
    {
      int k = this.zzgj;
      paramzzl.zzf(7, 0);
      paramzzl.zzl(zzl.zzn(k));
    }
    if (this.zzgk)
    {
      boolean bool = this.zzgk;
      paramzzl.zzf(8, 0);
      if (!bool) {
        break label289;
      }
    }
    for (;;)
    {
      paramzzl.zza((byte)i);
      if ((this.zzgl == null) || (this.zzgl.length <= 0)) {
        break;
      }
      i = 0;
      while (i < this.zzgl.length)
      {
        localObject = this.zzgl[i];
        if (localObject != null) {
          paramzzl.zza(9, (zzt)localObject);
        }
        i += 1;
      }
      label289:
      i = 0;
    }
    if ((this.zzgm != null) && (this.zzgm.length > 0))
    {
      i = 0;
      while (i < this.zzgm.length)
      {
        localObject = this.zzgm[i];
        if (localObject != null) {
          paramzzl.zza(10, (zzt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzgn != null) && (this.zzgn.length > 0))
    {
      i = 0;
      while (i < this.zzgn.length)
      {
        localObject = this.zzgn[i];
        if (localObject != null) {
          paramzzl.zza(11, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzgo != null) && (this.zzgo.length > 0))
    {
      i = 0;
      while (i < this.zzgo.length)
      {
        paramzzl.zza(12, this.zzgo[i]);
        i += 1;
      }
    }
    if (this.zzgq != 0L) {
      paramzzl.zza(13, this.zzgq);
    }
    if ((this.zzgp != null) && (this.zzgp.length > 0))
    {
      i = j;
      while (i < this.zzgp.length)
      {
        paramzzl.zza(14, this.zzgp[i]);
        i += 1;
      }
    }
    super.zza(paramzzl);
    AppMethodBeat.o(70701);
  }
  
  protected final int zzg()
  {
    AppMethodBeat.i(70702);
    int j = super.zzg();
    int i = j;
    Object localObject;
    if (!Arrays.equals(this.zzgd, zzw.zzhy))
    {
      localObject = this.zzgd;
      i = zzl.zzk(1);
      k = zzl.zzm(localObject.length);
      i = j + (localObject.length + k + i);
    }
    j = i;
    if (this.zzge != null)
    {
      j = i;
      if (!this.zzge.equals("")) {
        j = i + zzl.zzb(2, this.zzge);
      }
    }
    i = j;
    if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(0.0D)) {
      i = j + (zzl.zzk(3) + 8);
    }
    j = i;
    if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(0.0F)) {
      j = i + (zzl.zzk(4) + 4);
    }
    int k = j;
    if (this.zzgh != 0L) {
      k = j + zzl.zzb(5, this.zzgh);
    }
    i = k;
    if (this.zzgi != 0) {
      i = k + zzl.zze(6, this.zzgi);
    }
    j = i;
    if (this.zzgj != 0)
    {
      j = this.zzgj;
      k = zzl.zzk(7);
      j = i + (zzl.zzm(zzl.zzn(j)) + k);
    }
    i = j;
    if (this.zzgk) {
      i = j + (zzl.zzk(8) + 1);
    }
    j = i;
    if (this.zzgl != null)
    {
      j = i;
      if (this.zzgl.length > 0)
      {
        j = 0;
        while (j < this.zzgl.length)
        {
          localObject = this.zzgl[j];
          k = i;
          if (localObject != null) {
            k = i + zzl.zzb(9, (zzt)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.zzgm != null)
    {
      i = j;
      if (this.zzgm.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.zzgm.length)
        {
          localObject = this.zzgm[j];
          k = i;
          if (localObject != null) {
            k = i + zzl.zzb(10, (zzt)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    int m;
    if (this.zzgn != null)
    {
      j = i;
      if (this.zzgn.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (m = 0; j < this.zzgn.length; m = n)
        {
          localObject = this.zzgn[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + zzl.zzg((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.zzgo != null)
    {
      i = j;
      if (this.zzgo.length > 0)
      {
        k = 0;
        m = 0;
        if (k < this.zzgo.length)
        {
          long l = this.zzgo[k];
          if ((0xFFFFFF80 & l) == 0L) {
            i = 1;
          }
          for (;;)
          {
            m += i;
            k += 1;
            break;
            if ((0xFFFFC000 & l) == 0L) {
              i = 2;
            } else if ((0xFFE00000 & l) == 0L) {
              i = 3;
            } else if ((0xF0000000 & l) == 0L) {
              i = 4;
            } else if ((0x0 & l) == 0L) {
              i = 5;
            } else if ((0x0 & l) == 0L) {
              i = 6;
            } else if ((0x0 & l) == 0L) {
              i = 7;
            } else if ((0x0 & l) == 0L) {
              i = 8;
            } else if ((l & 0x0) == 0L) {
              i = 9;
            } else {
              i = 10;
            }
          }
        }
        i = j + m + this.zzgo.length * 1;
      }
    }
    j = i;
    if (this.zzgq != 0L) {
      j = i + zzl.zzb(13, this.zzgq);
    }
    i = j;
    if (this.zzgp != null)
    {
      i = j;
      if (this.zzgp.length > 0) {
        i = j + this.zzgp.length * 4 + this.zzgp.length * 1;
      }
    }
    AppMethodBeat.o(70702);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzj
 * JD-Core Version:    0.7.0.1
 */