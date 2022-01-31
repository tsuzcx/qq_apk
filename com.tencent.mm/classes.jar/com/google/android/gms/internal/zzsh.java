package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzh;

public class zzsh
  extends zzsa
{
  private final zzrk zzacl = new zzrk();
  
  zzsh(zzsc paramzzsc)
  {
    super(paramzzsc);
  }
  
  protected void zzmS()
  {
    zznU().zzmP().zza(this.zzacl);
    zzmw();
  }
  
  public void zzmw()
  {
    Object localObject = zzmB();
    String str = ((zztn)localObject).zzmY();
    if (str != null) {
      this.zzacl.setAppName(str);
    }
    localObject = ((zztn)localObject).zzmZ();
    if (localObject != null) {
      this.zzacl.setAppVersion((String)localObject);
    }
  }
  
  public zzrk zzoy()
  {
    zzob();
    return this.zzacl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzsh
 * JD-Core Version:    0.7.0.1
 */