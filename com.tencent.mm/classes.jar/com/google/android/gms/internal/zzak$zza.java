package com.google.android.gms.internal;

public final class zzak$zza
  extends zzbxn<zza>
{
  private static volatile zza[] zzlt;
  public String string;
  public int type;
  public boolean zzlA;
  public zza[] zzlB;
  public int[] zzlC;
  public boolean zzlD;
  public zza[] zzlu;
  public zza[] zzlv;
  public zza[] zzlw;
  public String zzlx;
  public String zzly;
  public long zzlz;
  
  public zzak$zza()
  {
    zzM();
  }
  
  public static zza[] zzL()
  {
    if (zzlt == null) {}
    synchronized (zzbxr.zzcuI)
    {
      if (zzlt == null) {
        zzlt = new zza[0];
      }
      return zzlt;
    }
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
      if (this.type != paramObject.type) {
        return false;
      }
      if (this.string == null)
      {
        if (paramObject.string != null) {
          return false;
        }
      }
      else if (!this.string.equals(paramObject.string)) {
        return false;
      }
      if (!zzbxr.equals(this.zzlu, paramObject.zzlu)) {
        return false;
      }
      if (!zzbxr.equals(this.zzlv, paramObject.zzlv)) {
        return false;
      }
      if (!zzbxr.equals(this.zzlw, paramObject.zzlw)) {
        return false;
      }
      if (this.zzlx == null)
      {
        if (paramObject.zzlx != null) {
          return false;
        }
      }
      else if (!this.zzlx.equals(paramObject.zzlx)) {
        return false;
      }
      if (this.zzly == null)
      {
        if (paramObject.zzly != null) {
          return false;
        }
      }
      else if (!this.zzly.equals(paramObject.zzly)) {
        return false;
      }
      if (this.zzlz != paramObject.zzlz) {
        return false;
      }
      if (this.zzlA != paramObject.zzlA) {
        return false;
      }
      if (!zzbxr.equals(this.zzlB, paramObject.zzlB)) {
        return false;
      }
      if (!zzbxr.equals(this.zzlC, paramObject.zzlC)) {
        return false;
      }
      if (this.zzlD != paramObject.zzlD) {
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
    int n = 1231;
    int i2 = 0;
    int i3 = getClass().getName().hashCode();
    int i4 = this.type;
    int i;
    int i5;
    int i6;
    int i7;
    int j;
    label71:
    int k;
    label80:
    int i8;
    int m;
    label107:
    int i9;
    int i10;
    if (this.string == null)
    {
      i = 0;
      i5 = zzbxr.hashCode(this.zzlu);
      i6 = zzbxr.hashCode(this.zzlv);
      i7 = zzbxr.hashCode(this.zzlw);
      if (this.zzlx != null) {
        break label250;
      }
      j = 0;
      if (this.zzly != null) {
        break label261;
      }
      k = 0;
      i8 = (int)(this.zzlz ^ this.zzlz >>> 32);
      if (!this.zzlA) {
        break label272;
      }
      m = 1231;
      i9 = zzbxr.hashCode(this.zzlB);
      i10 = zzbxr.hashCode(this.zzlC);
      if (!this.zzlD) {
        break label280;
      }
      label132:
      i1 = i2;
      if (this.zzcuA != null) {
        if (!this.zzcuA.isEmpty()) {
          break label288;
        }
      }
    }
    label261:
    label272:
    label280:
    label288:
    for (int i1 = i2;; i1 = this.zzcuA.hashCode())
    {
      return ((((m + ((k + (j + ((((i + ((i3 + 527) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31) * 31 + i8) * 31) * 31 + i9) * 31 + i10) * 31 + n) * 31 + i1;
      i = this.string.hashCode();
      break;
      label250:
      j = this.zzlx.hashCode();
      break label71;
      k = this.zzly.hashCode();
      break label80;
      m = 1237;
      break label107;
      n = 1237;
      break label132;
    }
  }
  
  public final zza zzM()
  {
    this.type = 1;
    this.string = "";
    this.zzlu = zzL();
    this.zzlv = zzL();
    this.zzlw = zzL();
    this.zzlx = "";
    this.zzly = "";
    this.zzlz = 0L;
    this.zzlA = false;
    this.zzlB = zzL();
    this.zzlC = zzbxw.zzcuO;
    this.zzlD = false;
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    int j = 0;
    paramzzbxm.zzJ(1, this.type);
    if ((this.string != null) && (!this.string.equals(""))) {
      paramzzbxm.zzq(2, this.string);
    }
    int i;
    zza localzza;
    if ((this.zzlu != null) && (this.zzlu.length > 0))
    {
      i = 0;
      while (i < this.zzlu.length)
      {
        localzza = this.zzlu[i];
        if (localzza != null) {
          paramzzbxm.zza(3, localzza);
        }
        i += 1;
      }
    }
    if ((this.zzlv != null) && (this.zzlv.length > 0))
    {
      i = 0;
      while (i < this.zzlv.length)
      {
        localzza = this.zzlv[i];
        if (localzza != null) {
          paramzzbxm.zza(4, localzza);
        }
        i += 1;
      }
    }
    if ((this.zzlw != null) && (this.zzlw.length > 0))
    {
      i = 0;
      while (i < this.zzlw.length)
      {
        localzza = this.zzlw[i];
        if (localzza != null) {
          paramzzbxm.zza(5, localzza);
        }
        i += 1;
      }
    }
    if ((this.zzlx != null) && (!this.zzlx.equals(""))) {
      paramzzbxm.zzq(6, this.zzlx);
    }
    if ((this.zzly != null) && (!this.zzly.equals(""))) {
      paramzzbxm.zzq(7, this.zzly);
    }
    if (this.zzlz != 0L) {
      paramzzbxm.zzb(8, this.zzlz);
    }
    if (this.zzlD) {
      paramzzbxm.zzg(9, this.zzlD);
    }
    if ((this.zzlC != null) && (this.zzlC.length > 0))
    {
      i = 0;
      while (i < this.zzlC.length)
      {
        paramzzbxm.zzJ(10, this.zzlC[i]);
        i += 1;
      }
    }
    if ((this.zzlB != null) && (this.zzlB.length > 0))
    {
      i = j;
      while (i < this.zzlB.length)
      {
        localzza = this.zzlB[i];
        if (localzza != null) {
          paramzzbxm.zza(11, localzza);
        }
        i += 1;
      }
    }
    if (this.zzlA) {
      paramzzbxm.zzg(12, this.zzlA);
    }
    super.zza(paramzzbxm);
  }
  
  protected final int zzu()
  {
    int m = 0;
    int j = super.zzu() + zzbxm.zzL(1, this.type);
    int i = j;
    if (this.string != null)
    {
      i = j;
      if (!this.string.equals("")) {
        i = j + zzbxm.zzr(2, this.string);
      }
    }
    j = i;
    zza localzza;
    int k;
    if (this.zzlu != null)
    {
      j = i;
      if (this.zzlu.length > 0)
      {
        j = 0;
        while (j < this.zzlu.length)
        {
          localzza = this.zzlu[j];
          k = i;
          if (localzza != null) {
            k = i + zzbxm.zzc(3, localzza);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.zzlv != null)
    {
      i = j;
      if (this.zzlv.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.zzlv.length)
        {
          localzza = this.zzlv[j];
          k = i;
          if (localzza != null) {
            k = i + zzbxm.zzc(4, localzza);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.zzlw != null)
    {
      j = i;
      if (this.zzlw.length > 0)
      {
        j = 0;
        while (j < this.zzlw.length)
        {
          localzza = this.zzlw[j];
          k = i;
          if (localzza != null) {
            k = i + zzbxm.zzc(5, localzza);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.zzlx != null)
    {
      i = j;
      if (!this.zzlx.equals("")) {
        i = j + zzbxm.zzr(6, this.zzlx);
      }
    }
    j = i;
    if (this.zzly != null)
    {
      j = i;
      if (!this.zzly.equals("")) {
        j = i + zzbxm.zzr(7, this.zzly);
      }
    }
    i = j;
    if (this.zzlz != 0L) {
      i = j + zzbxm.zzf(8, this.zzlz);
    }
    j = i;
    if (this.zzlD) {
      j = i + zzbxm.zzh(9, this.zzlD);
    }
    i = j;
    if (this.zzlC != null)
    {
      i = j;
      if (this.zzlC.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.zzlC.length)
        {
          k += zzbxm.zzrf(this.zzlC[i]);
          i += 1;
        }
        i = j + k + this.zzlC.length * 1;
      }
    }
    j = i;
    if (this.zzlB != null)
    {
      j = i;
      if (this.zzlB.length > 0)
      {
        k = m;
        for (;;)
        {
          j = i;
          if (k >= this.zzlB.length) {
            break;
          }
          localzza = this.zzlB[k];
          j = i;
          if (localzza != null) {
            j = i + zzbxm.zzc(11, localzza);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.zzlA) {
      i = j + zzbxm.zzh(12, this.zzlA);
    }
    return i;
  }
  
  public final zza zzx(zzbxl paramzzbxl)
  {
    for (;;)
    {
      int i = paramzzbxl.zzaen();
      int j;
      Object localObject;
      int k;
      switch (i)
      {
      default: 
        if (super.zza(paramzzbxl, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        i = paramzzbxl.zzaer();
        switch (i)
        {
        default: 
          break;
        }
        this.type = i;
        break;
      case 18: 
        this.string = paramzzbxl.readString();
        break;
      case 26: 
        j = zzbxw.zzb(paramzzbxl, 26);
        if (this.zzlu == null) {}
        for (i = 0;; i = this.zzlu.length)
        {
          localObject = new zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlu, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zza();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zza();
        paramzzbxl.zza(localObject[j]);
        this.zzlu = ((zza[])localObject);
        break;
      case 34: 
        j = zzbxw.zzb(paramzzbxl, 34);
        if (this.zzlv == null) {}
        for (i = 0;; i = this.zzlv.length)
        {
          localObject = new zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlv, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zza();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zza();
        paramzzbxl.zza(localObject[j]);
        this.zzlv = ((zza[])localObject);
        break;
      case 42: 
        j = zzbxw.zzb(paramzzbxl, 42);
        if (this.zzlw == null) {}
        for (i = 0;; i = this.zzlw.length)
        {
          localObject = new zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlw, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zza();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zza();
        paramzzbxl.zza(localObject[j]);
        this.zzlw = ((zza[])localObject);
        break;
      case 50: 
        this.zzlx = paramzzbxl.readString();
        break;
      case 58: 
        this.zzly = paramzzbxl.readString();
        break;
      case 64: 
        this.zzlz = paramzzbxl.zzaeq();
        break;
      case 72: 
        this.zzlD = paramzzbxl.zzaet();
        break;
      case 80: 
        int m = zzbxw.zzb(paramzzbxl, 80);
        localObject = new int[m];
        j = 0;
        i = 0;
        if (j < m)
        {
          if (j != 0) {
            paramzzbxl.zzaen();
          }
          int n = paramzzbxl.zzaer();
          switch (n)
          {
          }
          for (;;)
          {
            j += 1;
            break;
            k = i + 1;
            localObject[i] = n;
            i = k;
          }
        }
        if (i == 0) {
          continue;
        }
        if (this.zzlC == null) {}
        for (j = 0;; j = this.zzlC.length)
        {
          if ((j != 0) || (i != m)) {
            break label809;
          }
          this.zzlC = ((int[])localObject);
          break;
        }
        int[] arrayOfInt = new int[j + i];
        if (j != 0) {
          System.arraycopy(this.zzlC, 0, arrayOfInt, 0, j);
        }
        System.arraycopy(localObject, 0, arrayOfInt, j, i);
        this.zzlC = arrayOfInt;
        break;
      case 82: 
        k = paramzzbxl.zzqZ(paramzzbxl.zzaew());
        i = paramzzbxl.getPosition();
        j = 0;
        while (paramzzbxl.zzaeB() > 0) {
          switch (paramzzbxl.zzaer())
          {
          default: 
            break;
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
            j += 1;
          }
        }
        if (j != 0)
        {
          paramzzbxl.zzrb(i);
          if (this.zzlC == null) {}
          for (i = 0;; i = this.zzlC.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlC, 0, localObject, 0, i);
              j = i;
            }
            while (paramzzbxl.zzaeB() > 0)
            {
              i = paramzzbxl.zzaer();
              switch (i)
              {
              default: 
                break;
              case 1: 
              case 2: 
              case 3: 
              case 4: 
              case 5: 
              case 6: 
              case 7: 
              case 8: 
              case 9: 
              case 10: 
              case 11: 
              case 12: 
              case 13: 
              case 14: 
              case 15: 
              case 16: 
              case 17: 
                localObject[j] = i;
                j += 1;
              }
            }
          }
          this.zzlC = ((int[])localObject);
        }
        paramzzbxl.zzra(k);
        break;
      case 90: 
        label809:
        j = zzbxw.zzb(paramzzbxl, 90);
        if (this.zzlB == null) {}
        for (i = 0;; i = this.zzlB.length)
        {
          localObject = new zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzlB, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zza();
            paramzzbxl.zza(localObject[j]);
            paramzzbxl.zzaen();
            j += 1;
          }
        }
        localObject[j] = new zza();
        paramzzbxl.zza(localObject[j]);
        this.zzlB = ((zza[])localObject);
        break;
      }
      this.zzlA = paramzzbxl.zzaet();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzak.zza
 * JD-Core Version:    0.7.0.1
 */