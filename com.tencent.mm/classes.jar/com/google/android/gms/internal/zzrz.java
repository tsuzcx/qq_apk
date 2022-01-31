package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;

public class zzrz
{
  private final zzsc zzadO;
  
  public zzrz(zzsc paramzzsc)
  {
    zzac.zzw(paramzzsc);
    this.zzadO = paramzzsc;
  }
  
  private void zza(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject = null;
    if (this.zzadO != null) {
      localObject = this.zzadO.zzoe();
    }
    if (localObject != null) {
      ((zztd)localObject).zza(paramInt, paramString, paramObject1, paramObject2, paramObject3);
    }
    do
    {
      return;
      localObject = (String)zzsw.zzafl.get();
    } while (!Log.isLoggable((String)localObject, paramInt));
    Log.println(paramInt, (String)localObject, zzc(paramString, paramObject1, paramObject2, paramObject3));
  }
  
  protected static String zzc(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str2 = zzk(paramObject1);
    paramObject2 = zzk(paramObject2);
    paramObject3 = zzk(paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = "";
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str2))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str2);
      paramObject1 = ", ";
    }
    paramString = paramObject1;
    if (!TextUtils.isEmpty(paramObject2))
    {
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(paramObject2);
      paramString = ", ";
    }
    if (!TextUtils.isEmpty(paramObject3))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramObject3);
    }
    return localStringBuilder.toString();
  }
  
  private static String zzk(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof Boolean))
    {
      if (paramObject == Boolean.TRUE) {
        return "true";
      }
      return "false";
    }
    if ((paramObject instanceof Throwable)) {
      return ((Throwable)paramObject).toString();
    }
    return paramObject.toString();
  }
  
  public Context getContext()
  {
    return this.zzadO.getContext();
  }
  
  public void zza(String paramString, Object paramObject)
  {
    zza(2, paramString, paramObject, null, null);
  }
  
  public void zza(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(2, paramString, paramObject1, paramObject2, null);
  }
  
  public void zza(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zza(3, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public void zzb(String paramString, Object paramObject)
  {
    zza(3, paramString, paramObject, null, null);
  }
  
  public void zzb(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(3, paramString, paramObject1, paramObject2, null);
  }
  
  public void zzb(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zza(5, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public void zzbP(String paramString)
  {
    zza(2, paramString, null, null, null);
  }
  
  public void zzbQ(String paramString)
  {
    zza(3, paramString, null, null, null);
  }
  
  public void zzbR(String paramString)
  {
    zza(4, paramString, null, null, null);
  }
  
  public void zzbS(String paramString)
  {
    zza(5, paramString, null, null, null);
  }
  
  public void zzbT(String paramString)
  {
    zza(6, paramString, null, null, null);
  }
  
  public void zzc(String paramString, Object paramObject)
  {
    zza(4, paramString, paramObject, null, null);
  }
  
  public void zzc(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(5, paramString, paramObject1, paramObject2, null);
  }
  
  public void zzd(String paramString, Object paramObject)
  {
    zza(5, paramString, paramObject, null, null);
  }
  
  public void zzd(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(6, paramString, paramObject1, paramObject2, null);
  }
  
  public void zze(String paramString, Object paramObject)
  {
    zza(6, paramString, paramObject, null, null);
  }
  
  public boolean zzkI()
  {
    return Log.isLoggable((String)zzsw.zzafl.get(), 2);
  }
  
  public zzry zzmA()
  {
    return this.zzadO.zzmA();
  }
  
  public zztn zzmB()
  {
    return this.zzadO.zzmB();
  }
  
  protected void zzmR()
  {
    this.zzadO.zzmR();
  }
  
  public GoogleAnalytics zzmu()
  {
    return this.zzadO.zzof();
  }
  
  public zzsc zznQ()
  {
    return this.zzadO;
  }
  
  public zze zznR()
  {
    return this.zzadO.zznR();
  }
  
  public zztd zznS()
  {
    return this.zzadO.zznS();
  }
  
  protected zzsp zznT()
  {
    return this.zzadO.zznT();
  }
  
  public zzh zznU()
  {
    return this.zzadO.zznU();
  }
  
  protected zzst zznV()
  {
    return this.zzadO.zznV();
  }
  
  protected zztg zznW()
  {
    return this.zzadO.zznW();
  }
  
  public zzsk zznX()
  {
    return this.zzadO.zzoi();
  }
  
  public zzrx zznY()
  {
    return this.zzadO.zzoh();
  }
  
  public zzsh zznZ()
  {
    return this.zzadO.zznZ();
  }
  
  public zzss zzoa()
  {
    return this.zzadO.zzoa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzrz
 * JD-Core Version:    0.7.0.1
 */