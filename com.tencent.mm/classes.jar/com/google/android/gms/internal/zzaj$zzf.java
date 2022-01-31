package com.google.android.gms.internal;

public final class zzaj$zzf
  extends zzbxn<zzf>
{
  public String version;
  public String[] zzkD;
  public String[] zzkE;
  public zzak.zza[] zzkF;
  public zzaj.zze[] zzkG;
  public zzaj.zzb[] zzkH;
  public zzaj.zzb[] zzkI;
  public zzaj.zzb[] zzkJ;
  public zzaj.zzg[] zzkK;
  public String zzkL;
  public String zzkM;
  public String zzkN;
  public zzaj.zza zzkO;
  public float zzkP;
  public boolean zzkQ;
  public String[] zzkR;
  public int zzkS;
  
  public zzaj$zzf()
  {
    zzE();
  }
  
  public static zzf zzf(byte[] paramArrayOfByte)
  {
    return (zzf)zzbxt.zza(new zzf(), paramArrayOfByte);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzf)) {
        return false;
      }
      paramObject = (zzf)paramObject;
      if (!zzbxr.equals(this.zzkD, paramObject.zzkD)) {
        return false;
      }
      if (!zzbxr.equals(this.zzkE, paramObject.zzkE)) {
        return false;
      }
      if (!zzbxr.equals(this.zzkF, paramObject.zzkF)) {
        return false;
      }
      if (!zzbxr.equals(this.zzkG, paramObject.zzkG)) {
        return false;
      }
      if (!zzbxr.equals(this.zzkH, paramObject.zzkH)) {
        return false;
      }
      if (!zzbxr.equals(this.zzkI, paramObject.zzkI)) {
        return false;
      }
      if (!zzbxr.equals(this.zzkJ, paramObject.zzkJ)) {
        return false;
      }
      if (!zzbxr.equals(this.zzkK, paramObject.zzkK)) {
        return false;
      }
      if (this.zzkL == null)
      {
        if (paramObject.zzkL != null) {
          return false;
        }
      }
      else if (!this.zzkL.equals(paramObject.zzkL)) {
        return false;
      }
      if (this.zzkM == null)
      {
        if (paramObject.zzkM != null) {
          return false;
        }
      }
      else if (!this.zzkM.equals(paramObject.zzkM)) {
        return false;
      }
      if (this.zzkN == null)
      {
        if (paramObject.zzkN != null) {
          return false;
        }
      }
      else if (!this.zzkN.equals(paramObject.zzkN)) {
        return false;
      }
      if (this.version == null)
      {
        if (paramObject.version != null) {
          return false;
        }
      }
      else if (!this.version.equals(paramObject.version)) {
        return false;
      }
      if (this.zzkO == null)
      {
        if (paramObject.zzkO != null) {
          return false;
        }
      }
      else if (!this.zzkO.equals(paramObject.zzkO)) {
        return false;
      }
      if (Float.floatToIntBits(this.zzkP) != Float.floatToIntBits(paramObject.zzkP)) {
        return false;
      }
      if (this.zzkQ != paramObject.zzkQ) {
        return false;
      }
      if (!zzbxr.equals(this.zzkR, paramObject.zzkR)) {
        return false;
      }
      if (this.zzkS != paramObject.zzkS) {
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
    int i3 = 0;
    int i4 = getClass().getName().hashCode();
    int i5 = zzbxr.hashCode(this.zzkD);
    int i6 = zzbxr.hashCode(this.zzkE);
    int i7 = zzbxr.hashCode(this.zzkF);
    int i8 = zzbxr.hashCode(this.zzkG);
    int i9 = zzbxr.hashCode(this.zzkH);
    int i10 = zzbxr.hashCode(this.zzkI);
    int i11 = zzbxr.hashCode(this.zzkJ);
    int i12 = zzbxr.hashCode(this.zzkK);
    int i;
    int j;
    label105:
    int k;
    label114:
    int m;
    label124:
    int n;
    label134:
    int i13;
    int i1;
    label155:
    int i14;
    int i15;
    if (this.zzkL == null)
    {
      i = 0;
      if (this.zzkM != null) {
        break label318;
      }
      j = 0;
      if (this.zzkN != null) {
        break label329;
      }
      k = 0;
      if (this.version != null) {
        break label340;
      }
      m = 0;
      if (this.zzkO != null) {
        break label352;
      }
      n = 0;
      i13 = Float.floatToIntBits(this.zzkP);
      if (!this.zzkQ) {
        break label364;
      }
      i1 = 1231;
      i14 = zzbxr.hashCode(this.zzkR);
      i15 = this.zzkS;
      i2 = i3;
      if (this.zzcuA != null) {
        if (!this.zzcuA.isEmpty()) {
          break label372;
        }
      }
    }
    label318:
    label329:
    label340:
    label352:
    label364:
    label372:
    for (int i2 = i3;; i2 = this.zzcuA.hashCode())
    {
      return (((i1 + ((n + (m + (k + (j + (i + (((((((((i4 + 527) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31) * 31) * 31) * 31) * 31) * 31 + i13) * 31) * 31 + i14) * 31 + i15) * 31 + i2;
      i = this.zzkL.hashCode();
      break;
      j = this.zzkM.hashCode();
      break label105;
      k = this.zzkN.hashCode();
      break label114;
      m = this.version.hashCode();
      break label124;
      n = this.zzkO.hashCode();
      break label134;
      i1 = 1237;
      break label155;
    }
  }
  
  public final zzf zzE()
  {
    this.zzkD = zzbxw.zzcuT;
    this.zzkE = zzbxw.zzcuT;
    this.zzkF = zzak.zza.zzL();
    this.zzkG = zzaj.zze.zzC();
    this.zzkH = zzaj.zzb.zzx();
    this.zzkI = zzaj.zzb.zzx();
    this.zzkJ = zzaj.zzb.zzx();
    this.zzkK = zzaj.zzg.zzF();
    this.zzkL = "";
    this.zzkM = "";
    this.zzkN = "0";
    this.version = "";
    this.zzkO = null;
    this.zzkP = 0.0F;
    this.zzkQ = false;
    this.zzkR = zzbxw.zzcuT;
    this.zzkS = 0;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    int j = 0;
    int i;
    Object localObject;
    if ((this.zzkE != null) && (this.zzkE.length > 0))
    {
      i = 0;
      while (i < this.zzkE.length)
      {
        localObject = this.zzkE[i];
        if (localObject != null) {
          paramzzbxm.zzq(1, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzkF != null) && (this.zzkF.length > 0))
    {
      i = 0;
      while (i < this.zzkF.length)
      {
        localObject = this.zzkF[i];
        if (localObject != null) {
          paramzzbxm.zza(2, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzkG != null) && (this.zzkG.length > 0))
    {
      i = 0;
      while (i < this.zzkG.length)
      {
        localObject = this.zzkG[i];
        if (localObject != null) {
          paramzzbxm.zza(3, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzkH != null) && (this.zzkH.length > 0))
    {
      i = 0;
      while (i < this.zzkH.length)
      {
        localObject = this.zzkH[i];
        if (localObject != null) {
          paramzzbxm.zza(4, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzkI != null) && (this.zzkI.length > 0))
    {
      i = 0;
      while (i < this.zzkI.length)
      {
        localObject = this.zzkI[i];
        if (localObject != null) {
          paramzzbxm.zza(5, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzkJ != null) && (this.zzkJ.length > 0))
    {
      i = 0;
      while (i < this.zzkJ.length)
      {
        localObject = this.zzkJ[i];
        if (localObject != null) {
          paramzzbxm.zza(6, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzkK != null) && (this.zzkK.length > 0))
    {
      i = 0;
      while (i < this.zzkK.length)
      {
        localObject = this.zzkK[i];
        if (localObject != null) {
          paramzzbxm.zza(7, (zzbxt)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzkL != null) && (!this.zzkL.equals(""))) {
      paramzzbxm.zzq(9, this.zzkL);
    }
    if ((this.zzkM != null) && (!this.zzkM.equals(""))) {
      paramzzbxm.zzq(10, this.zzkM);
    }
    if ((this.zzkN != null) && (!this.zzkN.equals("0"))) {
      paramzzbxm.zzq(12, this.zzkN);
    }
    if ((this.version != null) && (!this.version.equals(""))) {
      paramzzbxm.zzq(13, this.version);
    }
    if (this.zzkO != null) {
      paramzzbxm.zza(14, this.zzkO);
    }
    if (Float.floatToIntBits(this.zzkP) != Float.floatToIntBits(0.0F)) {
      paramzzbxm.zzc(15, this.zzkP);
    }
    if ((this.zzkR != null) && (this.zzkR.length > 0))
    {
      i = 0;
      while (i < this.zzkR.length)
      {
        localObject = this.zzkR[i];
        if (localObject != null) {
          paramzzbxm.zzq(16, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.zzkS != 0) {
      paramzzbxm.zzJ(17, this.zzkS);
    }
    if (this.zzkQ) {
      paramzzbxm.zzg(18, this.zzkQ);
    }
    if ((this.zzkD != null) && (this.zzkD.length > 0))
    {
      i = j;
      while (i < this.zzkD.length)
      {
        localObject = this.zzkD[i];
        if (localObject != null) {
          paramzzbxm.zzq(19, (String)localObject);
        }
        i += 1;
      }
    }
    super.zza(paramzzbxm);
  }
  
  public final zzf zzs(zzbxl paramzzbxl)
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
        j = zzbxw.zzb(paramzzbxl, 10);
        if (this.zzkE == null) {}
        for (i = 0;; i = this.zzkE.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkE, 0, localObject, 0, i);
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
        this.zzkE = ((String[])localObject);
        break;
      case 18: 
        j = zzbxw.zzb(paramzzbxl, 18);
        if (this.zzkF == null) {}
        for (i = 0;; i = this.zzkF.length)
        {
          localObject = new zzak.zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkF, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzak.zza();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zzak.zza();
        paramzzbxl.zza(localObject[j]);
        this.zzkF = ((zzak.zza[])localObject);
        break;
      case 26: 
        j = zzbxw.zzb(paramzzbxl, 26);
        if (this.zzkG == null) {}
        for (i = 0;; i = this.zzkG.length)
        {
          localObject = new zzaj.zze[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkG, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzaj.zze();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zzaj.zze();
        paramzzbxl.zza(localObject[j]);
        this.zzkG = ((zzaj.zze[])localObject);
        break;
      case 34: 
        j = zzbxw.zzb(paramzzbxl, 34);
        if (this.zzkH == null) {}
        for (i = 0;; i = this.zzkH.length)
        {
          localObject = new zzaj.zzb[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkH, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzaj.zzb();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zzaj.zzb();
        paramzzbxl.zza(localObject[j]);
        this.zzkH = ((zzaj.zzb[])localObject);
        break;
      case 42: 
        j = zzbxw.zzb(paramzzbxl, 42);
        if (this.zzkI == null) {}
        for (i = 0;; i = this.zzkI.length)
        {
          localObject = new zzaj.zzb[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkI, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzaj.zzb();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zzaj.zzb();
        paramzzbxl.zza(localObject[j]);
        this.zzkI = ((zzaj.zzb[])localObject);
        break;
      case 50: 
        j = zzbxw.zzb(paramzzbxl, 50);
        if (this.zzkJ == null) {}
        for (i = 0;; i = this.zzkJ.length)
        {
          localObject = new zzaj.zzb[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkJ, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzaj.zzb();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zzaj.zzb();
        paramzzbxl.zza(localObject[j]);
        this.zzkJ = ((zzaj.zzb[])localObject);
        break;
      case 58: 
        j = zzbxw.zzb(paramzzbxl, 58);
        if (this.zzkK == null) {}
        for (i = 0;; i = this.zzkK.length)
        {
          localObject = new zzaj.zzg[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkK, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzaj.zzg();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zzaj.zzg();
        paramzzbxl.zza(localObject[j]);
        this.zzkK = ((zzaj.zzg[])localObject);
        break;
      case 74: 
        this.zzkL = paramzzbxl.readString();
        break;
      case 82: 
        this.zzkM = paramzzbxl.readString();
        break;
      case 98: 
        this.zzkN = paramzzbxl.readString();
        break;
      case 106: 
        this.version = paramzzbxl.readString();
        break;
      case 114: 
        if (this.zzkO == null) {
          this.zzkO = new zzaj.zza();
        }
        paramzzbxl.zza(this.zzkO);
        break;
      case 125: 
        this.zzkP = paramzzbxl.readFloat();
        break;
      case 130: 
        j = zzbxw.zzb(paramzzbxl, 130);
        if (this.zzkR == null) {}
        for (i = 0;; i = this.zzkR.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzkR, 0, localObject, 0, i);
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
        this.zzkR = ((String[])localObject);
        break;
      case 136: 
        this.zzkS = paramzzbxl.zzaer();
        break;
      case 144: 
        this.zzkQ = paramzzbxl.zzaet();
        break;
      }
      int j = zzbxw.zzb(paramzzbxl, 154);
      if (this.zzkD == null) {}
      for (i = 0;; i = this.zzkD.length)
      {
        localObject = new String[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.zzkD, 0, localObject, 0, i);
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
      this.zzkD = ((String[])localObject);
    }
  }
  
  protected final int zzu()
  {
    int i1 = super.zzu();
    int i;
    int k;
    Object localObject;
    int n;
    int m;
    if ((this.zzkE != null) && (this.zzkE.length > 0))
    {
      i = 0;
      j = 0;
      for (k = 0; i < this.zzkE.length; k = m)
      {
        localObject = this.zzkE[i];
        n = j;
        m = k;
        if (localObject != null)
        {
          m = k + 1;
          n = j + zzbxm.zzkb((String)localObject);
        }
        i += 1;
        j = n;
      }
    }
    for (int j = i1 + j + k * 1;; j = i1)
    {
      i = j;
      if (this.zzkF != null)
      {
        i = j;
        if (this.zzkF.length > 0)
        {
          k = 0;
          i = j;
          j = k;
          while (j < this.zzkF.length)
          {
            localObject = this.zzkF[j];
            k = i;
            if (localObject != null) {
              k = i + zzbxm.zzc(2, (zzbxt)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.zzkG != null)
      {
        j = i;
        if (this.zzkG.length > 0)
        {
          j = 0;
          while (j < this.zzkG.length)
          {
            localObject = this.zzkG[j];
            k = i;
            if (localObject != null) {
              k = i + zzbxm.zzc(3, (zzbxt)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzkH != null)
      {
        i = j;
        if (this.zzkH.length > 0)
        {
          k = 0;
          i = j;
          j = k;
          while (j < this.zzkH.length)
          {
            localObject = this.zzkH[j];
            k = i;
            if (localObject != null) {
              k = i + zzbxm.zzc(4, (zzbxt)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.zzkI != null)
      {
        j = i;
        if (this.zzkI.length > 0)
        {
          j = 0;
          while (j < this.zzkI.length)
          {
            localObject = this.zzkI[j];
            k = i;
            if (localObject != null) {
              k = i + zzbxm.zzc(5, (zzbxt)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzkJ != null)
      {
        i = j;
        if (this.zzkJ.length > 0)
        {
          k = 0;
          i = j;
          j = k;
          while (j < this.zzkJ.length)
          {
            localObject = this.zzkJ[j];
            k = i;
            if (localObject != null) {
              k = i + zzbxm.zzc(6, (zzbxt)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.zzkK != null)
      {
        j = i;
        if (this.zzkK.length > 0)
        {
          j = 0;
          while (j < this.zzkK.length)
          {
            localObject = this.zzkK[j];
            k = i;
            if (localObject != null) {
              k = i + zzbxm.zzc(7, (zzbxt)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzkL != null)
      {
        i = j;
        if (!this.zzkL.equals("")) {
          i = j + zzbxm.zzr(9, this.zzkL);
        }
      }
      j = i;
      if (this.zzkM != null)
      {
        j = i;
        if (!this.zzkM.equals("")) {
          j = i + zzbxm.zzr(10, this.zzkM);
        }
      }
      i = j;
      if (this.zzkN != null)
      {
        i = j;
        if (!this.zzkN.equals("0")) {
          i = j + zzbxm.zzr(12, this.zzkN);
        }
      }
      j = i;
      if (this.version != null)
      {
        j = i;
        if (!this.version.equals("")) {
          j = i + zzbxm.zzr(13, this.version);
        }
      }
      k = j;
      if (this.zzkO != null) {
        k = j + zzbxm.zzc(14, this.zzkO);
      }
      i = k;
      if (Float.floatToIntBits(this.zzkP) != Float.floatToIntBits(0.0F)) {
        i = k + zzbxm.zzd(15, this.zzkP);
      }
      j = i;
      if (this.zzkR != null)
      {
        j = i;
        if (this.zzkR.length > 0)
        {
          j = 0;
          k = 0;
          for (m = 0; j < this.zzkR.length; m = n)
          {
            localObject = this.zzkR[j];
            i1 = k;
            n = m;
            if (localObject != null)
            {
              n = m + 1;
              i1 = k + zzbxm.zzkb((String)localObject);
            }
            j += 1;
            k = i1;
          }
          j = i + k + m * 2;
        }
      }
      k = j;
      if (this.zzkS != 0) {
        k = j + zzbxm.zzL(17, this.zzkS);
      }
      i = k;
      if (this.zzkQ) {
        i = k + zzbxm.zzh(18, this.zzkQ);
      }
      j = i;
      if (this.zzkD != null)
      {
        j = i;
        if (this.zzkD.length > 0)
        {
          j = 0;
          k = 0;
          for (m = 0; j < this.zzkD.length; m = n)
          {
            localObject = this.zzkD[j];
            i1 = k;
            n = m;
            if (localObject != null)
            {
              n = m + 1;
              i1 = k + zzbxm.zzkb((String)localObject);
            }
            j += 1;
            k = i1;
          }
          j = i + k + m * 2;
        }
      }
      return j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzaj.zzf
 * JD-Core Version:    0.7.0.1
 */