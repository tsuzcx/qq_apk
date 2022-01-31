package com.google.android.gms.internal;

import java.util.Arrays;

public final class zzbld$zza$zza$zza
  extends zzbxn<zza>
{
  public byte[] zzbVD;
  public String zzbVE;
  public double zzbVF;
  public float zzbVG;
  public long zzbVH;
  public int zzbVI;
  public int zzbVJ;
  public boolean zzbVK;
  public zzbld.zza[] zzbVL;
  public zzbld.zza.zza[] zzbVM;
  public String[] zzbVN;
  public long[] zzbVO;
  public float[] zzbVP;
  public long zzbVQ;
  
  public zzbld$zza$zza$zza()
  {
    zzUF();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
      if (!Arrays.equals(this.zzbVD, paramObject.zzbVD)) {
        return false;
      }
      if (this.zzbVE == null)
      {
        if (paramObject.zzbVE != null) {
          return false;
        }
      }
      else if (!this.zzbVE.equals(paramObject.zzbVE)) {
        return false;
      }
      if (Double.doubleToLongBits(this.zzbVF) != Double.doubleToLongBits(paramObject.zzbVF)) {
        return false;
      }
      if (Float.floatToIntBits(this.zzbVG) != Float.floatToIntBits(paramObject.zzbVG)) {
        return false;
      }
      if (this.zzbVH != paramObject.zzbVH) {
        return false;
      }
      if (this.zzbVI != paramObject.zzbVI) {
        return false;
      }
      if (this.zzbVJ != paramObject.zzbVJ) {
        return false;
      }
      if (this.zzbVK != paramObject.zzbVK) {
        return false;
      }
      if (!zzbxr.equals(this.zzbVL, paramObject.zzbVL)) {
        return false;
      }
      if (!zzbxr.equals(this.zzbVM, paramObject.zzbVM)) {
        return false;
      }
      if (!zzbxr.equals(this.zzbVN, paramObject.zzbVN)) {
        return false;
      }
      if (!zzbxr.equals(this.zzbVO, paramObject.zzbVO)) {
        return false;
      }
      if (!zzbxr.equals(this.zzbVP, paramObject.zzbVP)) {
        return false;
      }
      if (this.zzbVQ != paramObject.zzbVQ) {
        return false;
      }
      if ((this.zzcuA != null) && (!this.zzcuA.isEmpty())) {
        break;
      }
    } while ((paramObject.zzcuA == null) || (paramObject.zzcuA.isEmpty()));
    return false;
    return this.zzcuA.equals(paramObject.zzcuA);
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = Arrays.hashCode(this.zzbVD);
    int i;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int j;
    label100:
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    if (this.zzbVE == null)
    {
      i = 0;
      long l = Double.doubleToLongBits(this.zzbVF);
      i2 = (int)(l ^ l >>> 32);
      i3 = Float.floatToIntBits(this.zzbVG);
      i4 = (int)(this.zzbVH ^ this.zzbVH >>> 32);
      i5 = this.zzbVI;
      i6 = this.zzbVJ;
      if (!this.zzbVK) {
        break label288;
      }
      j = 1231;
      i7 = zzbxr.hashCode(this.zzbVL);
      i8 = zzbxr.hashCode(this.zzbVM);
      i9 = zzbxr.hashCode(this.zzbVN);
      i10 = zzbxr.hashCode(this.zzbVO);
      i11 = zzbxr.hashCode(this.zzbVP);
      i12 = (int)(this.zzbVQ ^ this.zzbVQ >>> 32);
      k = m;
      if (this.zzcuA != null) {
        if (!this.zzcuA.isEmpty()) {
          break label295;
        }
      }
    }
    label288:
    label295:
    for (int k = m;; k = this.zzcuA.hashCode())
    {
      return (((((((j + ((((((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + k;
      i = this.zzbVE.hashCode();
      break;
      j = 1237;
      break label100;
    }
  }
  
  public final zza zzUF()
  {
    this.zzbVD = zzbxw.zzcuV;
    this.zzbVE = "";
    this.zzbVF = 0.0D;
    this.zzbVG = 0.0F;
    this.zzbVH = 0L;
    this.zzbVI = 0;
    this.zzbVJ = 0;
    this.zzbVK = false;
    this.zzbVL = zzbld.zza.zzUB();
    this.zzbVM = zzbld.zza.zza.zzUD();
    this.zzbVN = zzbxw.zzcuT;
    this.zzbVO = zzbxw.zzcuP;
    this.zzbVP = zzbxw.zzcuQ;
    this.zzbVQ = 0L;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    int j = 0;
    if (!Arrays.equals(this.zzbVD, zzbxw.zzcuV)) {
      paramzzbxm.zzb(1, this.zzbVD);
    }
    if ((this.zzbVE != null) && (!this.zzbVE.equals(""))) {
      paramzzbxm.zzq(2, this.zzbVE);
    }
    if (Double.doubleToLongBits(this.zzbVF) != Double.doubleToLongBits(0.0D)) {
      paramzzbxm.zza(3, this.zzbVF);
    }
    if (Float.floatToIntBits(this.zzbVG) != Float.floatToIntBits(0.0F)) {
      paramzzbxm.zzc(4, this.zzbVG);
    }
    if (this.zzbVH != 0L) {
      paramzzbxm.zzb(5, this.zzbVH);
    }
    if (this.zzbVI != 0) {
      paramzzbxm.zzJ(6, this.zzbVI);
    }
    if (this.zzbVJ != 0) {
      paramzzbxm.zzK(7, this.zzbVJ);
    }
    if (this.zzbVK) {
      paramzzbxm.zzg(8, this.zzbVK);
    }
    int i;
    Object localObject;
    if ((this.zzbVL != null) && (this.zzbVL.length > 0))
    {
      i = 0;
      while (i < this.zzbVL.length)
      {
        localObject = this.zzbVL[i];
        if (localObject != null) {
          paramzzbxm.zza(9, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzbVM != null) && (this.zzbVM.length > 0))
    {
      i = 0;
      while (i < this.zzbVM.length)
      {
        localObject = this.zzbVM[i];
        if (localObject != null) {
          paramzzbxm.zza(10, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzbVN != null) && (this.zzbVN.length > 0))
    {
      i = 0;
      while (i < this.zzbVN.length)
      {
        localObject = this.zzbVN[i];
        if (localObject != null) {
          paramzzbxm.zzq(11, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzbVO != null) && (this.zzbVO.length > 0))
    {
      i = 0;
      while (i < this.zzbVO.length)
      {
        paramzzbxm.zzb(12, this.zzbVO[i]);
        i += 1;
      }
    }
    if (this.zzbVQ != 0L) {
      paramzzbxm.zzb(13, this.zzbVQ);
    }
    if ((this.zzbVP != null) && (this.zzbVP.length > 0))
    {
      i = j;
      while (i < this.zzbVP.length)
      {
        paramzzbxm.zzc(14, this.zzbVP[i]);
        i += 1;
      }
    }
    super.zza(paramzzbxm);
  }
  
  public final zza zzaa(zzbxl paramzzbxl)
  {
    for (;;)
    {
      int i = paramzzbxl.zzaen();
      Object localObject;
      switch (i)
      {
      default: 
        if (super.zza(paramzzbxl, i)) {
          continue;
        }
      case 0: 
        return this;
      case 10: 
        this.zzbVD = paramzzbxl.readBytes();
        break;
      case 18: 
        this.zzbVE = paramzzbxl.readString();
        break;
      case 25: 
        this.zzbVF = paramzzbxl.readDouble();
        break;
      case 37: 
        this.zzbVG = paramzzbxl.readFloat();
        break;
      case 40: 
        this.zzbVH = paramzzbxl.zzaeq();
        break;
      case 48: 
        this.zzbVI = paramzzbxl.zzaer();
        break;
      case 56: 
        this.zzbVJ = paramzzbxl.zzaeu();
        break;
      case 64: 
        this.zzbVK = paramzzbxl.zzaet();
        break;
      case 74: 
        j = zzbxw.zzb(paramzzbxl, 74);
        if (this.zzbVL == null) {}
        for (i = 0;; i = this.zzbVL.length)
        {
          localObject = new zzbld.zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbVL, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzbld.zza();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zzbld.zza();
        paramzzbxl.zza(localObject[j]);
        this.zzbVL = ((zzbld.zza[])localObject);
        break;
      case 82: 
        j = zzbxw.zzb(paramzzbxl, 82);
        if (this.zzbVM == null) {}
        for (i = 0;; i = this.zzbVM.length)
        {
          localObject = new zzbld.zza.zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbVM, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzbld.zza.zza();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zzbld.zza.zza();
        paramzzbxl.zza(localObject[j]);
        this.zzbVM = ((zzbld.zza.zza[])localObject);
        break;
      case 90: 
        j = zzbxw.zzb(paramzzbxl, 90);
        if (this.zzbVN == null) {}
        for (i = 0;; i = this.zzbVN.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbVN, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzbxl.readString();
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = paramzzbxl.readString();
        this.zzbVN = ((String[])localObject);
        break;
      case 96: 
        j = zzbxw.zzb(paramzzbxl, 96);
        if (this.zzbVO == null) {}
        for (i = 0;; i = this.zzbVO.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbVO, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzbxl.zzaeq();
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = paramzzbxl.zzaeq();
        this.zzbVO = ((long[])localObject);
        break;
      case 98: 
        k = paramzzbxl.zzqZ(paramzzbxl.zzaew());
        i = paramzzbxl.getPosition();
        j = 0;
        while (paramzzbxl.zzaeB() > 0)
        {
          paramzzbxl.zzaeq();
          j += 1;
        }
        paramzzbxl.zzrb(i);
        if (this.zzbVO == null) {}
        for (i = 0;; i = this.zzbVO.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbVO, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzzbxl.zzaeq();
            j += 1;
          }
        }
        this.zzbVO = ((long[])localObject);
        paramzzbxl.zzra(k);
        break;
      case 104: 
        this.zzbVQ = paramzzbxl.zzaeq();
        break;
      case 117: 
        j = zzbxw.zzb(paramzzbxl, 117);
        if (this.zzbVP == null) {}
        for (i = 0;; i = this.zzbVP.length)
        {
          localObject = new float[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbVP, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzbxl.readFloat();
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = paramzzbxl.readFloat();
        this.zzbVP = ((float[])localObject);
        break;
      }
      i = paramzzbxl.zzaew();
      int k = paramzzbxl.zzqZ(i);
      int j = i / 4;
      if (this.zzbVP == null) {}
      for (i = 0;; i = this.zzbVP.length)
      {
        localObject = new float[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.zzbVP, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length)
        {
          localObject[j] = paramzzbxl.readFloat();
          j += 1;
        }
      }
      this.zzbVP = ((float[])localObject);
      paramzzbxl.zzra(k);
    }
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (!Arrays.equals(this.zzbVD, zzbxw.zzcuV)) {
      i = j + zzbxm.zzc(1, this.zzbVD);
    }
    j = i;
    if (this.zzbVE != null)
    {
      j = i;
      if (!this.zzbVE.equals("")) {
        j = i + zzbxm.zzr(2, this.zzbVE);
      }
    }
    i = j;
    if (Double.doubleToLongBits(this.zzbVF) != Double.doubleToLongBits(0.0D)) {
      i = j + zzbxm.zzb(3, this.zzbVF);
    }
    j = i;
    if (Float.floatToIntBits(this.zzbVG) != Float.floatToIntBits(0.0F)) {
      j = i + zzbxm.zzd(4, this.zzbVG);
    }
    i = j;
    if (this.zzbVH != 0L) {
      i = j + zzbxm.zzf(5, this.zzbVH);
    }
    j = i;
    if (this.zzbVI != 0) {
      j = i + zzbxm.zzL(6, this.zzbVI);
    }
    int k = j;
    if (this.zzbVJ != 0) {
      k = j + zzbxm.zzM(7, this.zzbVJ);
    }
    i = k;
    if (this.zzbVK) {
      i = k + zzbxm.zzh(8, this.zzbVK);
    }
    j = i;
    Object localObject;
    if (this.zzbVL != null)
    {
      j = i;
      if (this.zzbVL.length > 0)
      {
        j = 0;
        while (j < this.zzbVL.length)
        {
          localObject = this.zzbVL[j];
          k = i;
          if (localObject != null) {
            k = i + zzbxm.zzc(9, (zzbxt)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.zzbVM != null)
    {
      i = j;
      if (this.zzbVM.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.zzbVM.length)
        {
          localObject = this.zzbVM[j];
          k = i;
          if (localObject != null) {
            k = i + zzbxm.zzc(10, (zzbxt)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.zzbVN != null)
    {
      j = i;
      if (this.zzbVN.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.zzbVN.length; m = n)
        {
          localObject = this.zzbVN[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + zzbxm.zzkb((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.zzbVO != null)
    {
      i = j;
      if (this.zzbVO.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.zzbVO.length)
        {
          k += zzbxm.zzbf(this.zzbVO[i]);
          i += 1;
        }
        i = j + k + this.zzbVO.length * 1;
      }
    }
    j = i;
    if (this.zzbVQ != 0L) {
      j = i + zzbxm.zzf(13, this.zzbVQ);
    }
    i = j;
    if (this.zzbVP != null)
    {
      i = j;
      if (this.zzbVP.length > 0) {
        i = j + this.zzbVP.length * 4 + this.zzbVP.length * 1;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzbld.zza.zza.zza
 * JD-Core Version:    0.7.0.1
 */