package com.google.android.gms.internal;

public final class zzbxz$zzb
  extends zzbxn<zzb>
{
  public String zzcvH;
  public String zzcvI;
  public long zzcvJ;
  public String zzcvK;
  public int zzcvL;
  public int zzcvM;
  public String zzcvN;
  public String zzcvO;
  public String zzcvP;
  public String zzcvQ;
  public String zzcvR;
  public int zzcvS;
  public zzbxz.zza[] zzcvT;
  
  public zzbxz$zzb()
  {
    zzafj();
  }
  
  public static zzb zzak(byte[] paramArrayOfByte)
  {
    return (zzb)zzbxt.zza(new zzb(), paramArrayOfByte);
  }
  
  public final void zza(zzbxm paramzzbxm)
  {
    if ((this.zzcvH != null) && (!this.zzcvH.equals(""))) {
      paramzzbxm.zzq(1, this.zzcvH);
    }
    if ((this.zzcvI != null) && (!this.zzcvI.equals(""))) {
      paramzzbxm.zzq(2, this.zzcvI);
    }
    if (this.zzcvJ != 0L) {
      paramzzbxm.zzb(3, this.zzcvJ);
    }
    if ((this.zzcvK != null) && (!this.zzcvK.equals(""))) {
      paramzzbxm.zzq(4, this.zzcvK);
    }
    if (this.zzcvL != 0) {
      paramzzbxm.zzJ(5, this.zzcvL);
    }
    if (this.zzcvM != 0) {
      paramzzbxm.zzJ(6, this.zzcvM);
    }
    if ((this.zzcvN != null) && (!this.zzcvN.equals(""))) {
      paramzzbxm.zzq(7, this.zzcvN);
    }
    if ((this.zzcvO != null) && (!this.zzcvO.equals(""))) {
      paramzzbxm.zzq(8, this.zzcvO);
    }
    if ((this.zzcvP != null) && (!this.zzcvP.equals(""))) {
      paramzzbxm.zzq(9, this.zzcvP);
    }
    if ((this.zzcvQ != null) && (!this.zzcvQ.equals(""))) {
      paramzzbxm.zzq(10, this.zzcvQ);
    }
    if ((this.zzcvR != null) && (!this.zzcvR.equals(""))) {
      paramzzbxm.zzq(11, this.zzcvR);
    }
    if (this.zzcvS != 0) {
      paramzzbxm.zzJ(12, this.zzcvS);
    }
    if ((this.zzcvT != null) && (this.zzcvT.length > 0))
    {
      int i = 0;
      while (i < this.zzcvT.length)
      {
        zzbxz.zza localzza = this.zzcvT[i];
        if (localzza != null) {
          paramzzbxm.zza(13, localzza);
        }
        i += 1;
      }
    }
    super.zza(paramzzbxm);
  }
  
  public final zzb zzaW(zzbxl paramzzbxl)
  {
    for (;;)
    {
      int i = paramzzbxl.zzaen();
      switch (i)
      {
      default: 
        if (super.zza(paramzzbxl, i)) {
          continue;
        }
      case 0: 
        return this;
      case 10: 
        this.zzcvH = paramzzbxl.readString();
        break;
      case 18: 
        this.zzcvI = paramzzbxl.readString();
        break;
      case 24: 
        this.zzcvJ = paramzzbxl.zzaeq();
        break;
      case 34: 
        this.zzcvK = paramzzbxl.readString();
        break;
      case 40: 
        this.zzcvL = paramzzbxl.zzaer();
        break;
      case 48: 
        this.zzcvM = paramzzbxl.zzaer();
        break;
      case 58: 
        this.zzcvN = paramzzbxl.readString();
        break;
      case 66: 
        this.zzcvO = paramzzbxl.readString();
        break;
      case 74: 
        this.zzcvP = paramzzbxl.readString();
        break;
      case 82: 
        this.zzcvQ = paramzzbxl.readString();
        break;
      case 90: 
        this.zzcvR = paramzzbxl.readString();
        break;
      case 96: 
        i = paramzzbxl.zzaer();
        switch (i)
        {
        default: 
          break;
        }
        this.zzcvS = i;
        break;
      }
      int j = zzbxw.zzb(paramzzbxl, 106);
      if (this.zzcvT == null) {}
      zzbxz.zza[] arrayOfzza;
      for (i = 0;; i = this.zzcvT.length)
      {
        arrayOfzza = new zzbxz.zza[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.zzcvT, 0, arrayOfzza, 0, i);
          j = i;
        }
        while (j < arrayOfzza.length - 1)
        {
          arrayOfzza[j] = new zzbxz.zza();
          paramzzbxl.zza(arrayOfzza[j]);
          paramzzbxl.zzaen();
          j += 1;
        }
      }
      arrayOfzza[j] = new zzbxz.zza();
      paramzzbxl.zza(arrayOfzza[j]);
      this.zzcvT = arrayOfzza;
    }
  }
  
  public final zzb zzafj()
  {
    this.zzcvH = "";
    this.zzcvI = "";
    this.zzcvJ = 0L;
    this.zzcvK = "";
    this.zzcvL = 0;
    this.zzcvM = 0;
    this.zzcvN = "";
    this.zzcvO = "";
    this.zzcvP = "";
    this.zzcvQ = "";
    this.zzcvR = "";
    this.zzcvS = 0;
    this.zzcvT = zzbxz.zza.zzafh();
    this.zzcuA = null;
    this.zzcuJ = -1;
    return this;
  }
  
  protected final int zzu()
  {
    int j = super.zzu();
    int i = j;
    if (this.zzcvH != null)
    {
      i = j;
      if (!this.zzcvH.equals("")) {
        i = j + zzbxm.zzr(1, this.zzcvH);
      }
    }
    j = i;
    if (this.zzcvI != null)
    {
      j = i;
      if (!this.zzcvI.equals("")) {
        j = i + zzbxm.zzr(2, this.zzcvI);
      }
    }
    i = j;
    if (this.zzcvJ != 0L) {
      i = j + zzbxm.zzf(3, this.zzcvJ);
    }
    j = i;
    if (this.zzcvK != null)
    {
      j = i;
      if (!this.zzcvK.equals("")) {
        j = i + zzbxm.zzr(4, this.zzcvK);
      }
    }
    i = j;
    if (this.zzcvL != 0) {
      i = j + zzbxm.zzL(5, this.zzcvL);
    }
    j = i;
    if (this.zzcvM != 0) {
      j = i + zzbxm.zzL(6, this.zzcvM);
    }
    i = j;
    if (this.zzcvN != null)
    {
      i = j;
      if (!this.zzcvN.equals("")) {
        i = j + zzbxm.zzr(7, this.zzcvN);
      }
    }
    j = i;
    if (this.zzcvO != null)
    {
      j = i;
      if (!this.zzcvO.equals("")) {
        j = i + zzbxm.zzr(8, this.zzcvO);
      }
    }
    i = j;
    if (this.zzcvP != null)
    {
      i = j;
      if (!this.zzcvP.equals("")) {
        i = j + zzbxm.zzr(9, this.zzcvP);
      }
    }
    j = i;
    if (this.zzcvQ != null)
    {
      j = i;
      if (!this.zzcvQ.equals("")) {
        j = i + zzbxm.zzr(10, this.zzcvQ);
      }
    }
    int k = j;
    if (this.zzcvR != null)
    {
      k = j;
      if (!this.zzcvR.equals("")) {
        k = j + zzbxm.zzr(11, this.zzcvR);
      }
    }
    i = k;
    if (this.zzcvS != 0) {
      i = k + zzbxm.zzL(12, this.zzcvS);
    }
    j = i;
    if (this.zzcvT != null)
    {
      j = i;
      if (this.zzcvT.length > 0)
      {
        j = 0;
        while (j < this.zzcvT.length)
        {
          zzbxz.zza localzza = this.zzcvT[j];
          k = i;
          if (localzza != null) {
            k = i + zzbxm.zzc(13, localzza);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxz.zzb
 * JD-Core Version:    0.7.0.1
 */