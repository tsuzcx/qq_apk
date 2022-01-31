package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class zztn
  extends zzsa
{
  protected boolean zzabJ;
  protected String zzacL;
  protected String zzacM;
  protected int zzafc;
  protected boolean zzagV;
  protected boolean zzagW;
  protected int zzage;
  
  public zztn(zzsc paramzzsc)
  {
    super(paramzzsc);
  }
  
  private static int zzck(String paramString)
  {
    paramString = paramString.toLowerCase();
    if ("verbose".equals(paramString)) {
      return 0;
    }
    if ("info".equals(paramString)) {
      return 1;
    }
    if ("warning".equals(paramString)) {
      return 2;
    }
    if ("error".equals(paramString)) {
      return 3;
    }
    return -1;
  }
  
  void zza(zzsy paramzzsy)
  {
    zzbP("Loading global XML config values");
    String str;
    if (paramzzsy.zzpG())
    {
      str = paramzzsy.zzmY();
      this.zzacL = str;
      zzb("XML config - app name", str);
    }
    if (paramzzsy.zzpH())
    {
      str = paramzzsy.zzmZ();
      this.zzacM = str;
      zzb("XML config - app version", str);
    }
    int i;
    if (paramzzsy.zzpI())
    {
      i = zzck(paramzzsy.zzpJ());
      if (i >= 0)
      {
        this.zzafc = i;
        zza("XML config - log level", Integer.valueOf(i));
      }
    }
    if (paramzzsy.zzpK())
    {
      i = paramzzsy.zzpL();
      this.zzage = i;
      this.zzagV = true;
      zzb("XML config - dispatch period (sec)", Integer.valueOf(i));
    }
    if (paramzzsy.zzpM())
    {
      boolean bool = paramzzsy.zzpN();
      this.zzabJ = bool;
      this.zzagW = true;
      zzb("XML config - dry run", Boolean.valueOf(bool));
    }
  }
  
  protected void zzmS()
  {
    zzqC();
  }
  
  public String zzmY()
  {
    zzob();
    return this.zzacL;
  }
  
  public String zzmZ()
  {
    zzob();
    return this.zzacM;
  }
  
  public boolean zzpI()
  {
    zzob();
    return false;
  }
  
  public boolean zzpK()
  {
    zzob();
    return this.zzagV;
  }
  
  public boolean zzpM()
  {
    zzob();
    return this.zzagW;
  }
  
  public boolean zzpN()
  {
    zzob();
    return this.zzabJ;
  }
  
  public int zzqB()
  {
    zzob();
    return this.zzage;
  }
  
  protected void zzqC()
  {
    Object localObject1 = getContext();
    try
    {
      localObject1 = ((Context)localObject1).getPackageManager().getApplicationInfo(((Context)localObject1).getPackageName(), 129);
      if (localObject1 == null)
      {
        zzbS("Couldn't get ApplicationInfo to load global config");
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject2;
      do
      {
        int i;
        do
        {
          do
          {
            for (;;)
            {
              zzd("PackageManager doesn't know about the app package", localNameNotFoundException);
              localObject2 = null;
            }
            localObject2 = ((ApplicationInfo)localObject2).metaData;
          } while (localObject2 == null);
          i = ((Bundle)localObject2).getInt("com.google.android.gms.analytics.globalConfigResource");
        } while (i <= 0);
        localObject2 = (zzsy)new zzsx(zznQ()).zzaI(i);
      } while (localObject2 == null);
      zza((zzsy)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zztn
 * JD-Core Version:    0.7.0.1
 */