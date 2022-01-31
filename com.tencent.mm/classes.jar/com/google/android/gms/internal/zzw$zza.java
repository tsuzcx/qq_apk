package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

class zzw$zza
{
  public String zza;
  public long zzaA;
  public String zzaB;
  public long zzb;
  public long zzc;
  public long zzd;
  public long zze;
  public Map<String, String> zzf;
  
  private zzw$zza() {}
  
  public zzw$zza(String paramString, zzb.zza paramzza)
  {
    this.zzaB = paramString;
    this.zzaA = paramzza.data.length;
    this.zza = paramzza.zza;
    this.zzb = paramzza.zzb;
    this.zzc = paramzza.zzc;
    this.zzd = paramzza.zzd;
    this.zze = paramzza.zze;
    this.zzf = paramzza.zzf;
  }
  
  public static zza zzf(InputStream paramInputStream)
  {
    zza localzza = new zza();
    if (zzw.zzb(paramInputStream) != 538247942) {
      throw new IOException();
    }
    localzza.zzaB = zzw.zzd(paramInputStream);
    localzza.zza = zzw.zzd(paramInputStream);
    if (localzza.zza.equals("")) {
      localzza.zza = null;
    }
    localzza.zzb = zzw.zzc(paramInputStream);
    localzza.zzc = zzw.zzc(paramInputStream);
    localzza.zzd = zzw.zzc(paramInputStream);
    localzza.zze = zzw.zzc(paramInputStream);
    localzza.zzf = zzw.zze(paramInputStream);
    return localzza;
  }
  
  public boolean zza(OutputStream paramOutputStream)
  {
    try
    {
      zzw.zza(paramOutputStream, 538247942);
      zzw.zza(paramOutputStream, this.zzaB);
      if (this.zza == null) {}
      for (String str = "";; str = this.zza)
      {
        zzw.zza(paramOutputStream, str);
        zzw.zza(paramOutputStream, this.zzb);
        zzw.zza(paramOutputStream, this.zzc);
        zzw.zza(paramOutputStream, this.zzd);
        zzw.zza(paramOutputStream, this.zze);
        zzw.zza(this.zzf, paramOutputStream);
        paramOutputStream.flush();
        return true;
      }
      return false;
    }
    catch (IOException paramOutputStream)
    {
      zzt.zzb("%s", new Object[] { paramOutputStream.toString() });
    }
  }
  
  public zzb.zza zzb(byte[] paramArrayOfByte)
  {
    zzb.zza localzza = new zzb.zza();
    localzza.data = paramArrayOfByte;
    localzza.zza = this.zza;
    localzza.zzb = this.zzb;
    localzza.zzc = this.zzc;
    localzza.zzd = this.zzd;
    localzza.zze = this.zze;
    localzza.zzf = this.zzf;
    return localzza;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzw.zza
 * JD-Core Version:    0.7.0.1
 */