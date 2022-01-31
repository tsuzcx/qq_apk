package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaj.zzf;
import com.google.android.gms.internal.zzaj.zzi;
import com.google.android.gms.internal.zzaj.zzj;
import com.google.android.gms.internal.zzak.zza;
import com.google.android.gms.internal.zzbjf;
import com.google.android.gms.internal.zzbjf.zzc;
import com.google.android.gms.internal.zzbjf.zzg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container
{
  private final Context mContext;
  private final String zzbEY;
  private final DataLayer zzbEZ;
  private zzcx zzbFa;
  private Map<String, Container.FunctionCallMacroCallback> zzbFb = new HashMap();
  private Map<String, Container.FunctionCallTagCallback> zzbFc = new HashMap();
  private volatile long zzbFd;
  private volatile String zzbFe = "";
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzaj.zzj paramzzj)
  {
    this.mContext = paramContext;
    this.zzbEZ = paramDataLayer;
    this.zzbEY = paramString;
    this.zzbFd = paramLong;
    zza(paramzzj.zzlr);
    if (paramzzj.zzlq != null) {
      zza(paramzzj.zzlq);
    }
  }
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzbjf.zzc paramzzc)
  {
    this.mContext = paramContext;
    this.zzbEZ = paramDataLayer;
    this.zzbEY = paramString;
    this.zzbFd = paramLong;
    zza(paramzzc);
  }
  
  private zzcx zzQf()
  {
    try
    {
      zzcx localzzcx = this.zzbFa;
      return localzzcx;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void zza(zzaj.zzf paramzzf)
  {
    if (paramzzf == null) {
      throw new NullPointerException();
    }
    try
    {
      zzbjf.zzc localzzc = zzbjf.zzb(paramzzf);
      zza(localzzc);
      return;
    }
    catch (zzbjf.zzg localzzg)
    {
      paramzzf = String.valueOf(paramzzf);
      String str = String.valueOf(localzzg.toString());
      zzbo.e(String.valueOf(paramzzf).length() + 46 + String.valueOf(str).length() + "Not loading resource: " + paramzzf + " because it is invalid: " + str);
    }
  }
  
  private void zza(zzbjf.zzc paramzzc)
  {
    this.zzbFe = paramzzc.getVersion();
    zzaj localzzaj = zzgV(this.zzbFe);
    zza(new zzcx(this.mContext, paramzzc, this.zzbEZ, new Container.zza(this, null), new Container.zzb(this, null), localzzaj));
    if (getBoolean("_gtm.loadEventEnabled")) {
      this.zzbEZ.pushEvent("gtm.load", DataLayer.mapOf(new Object[] { "gtm.id", this.zzbEY }));
    }
  }
  
  private void zza(zzcx paramzzcx)
  {
    try
    {
      this.zzbFa = paramzzcx;
      return;
    }
    finally
    {
      paramzzcx = finally;
      throw paramzzcx;
    }
  }
  
  private void zza(zzaj.zzi[] paramArrayOfzzi)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfzzi.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfzzi[i]);
      i += 1;
    }
    zzQf().zzQ(localArrayList);
  }
  
  public boolean getBoolean(String paramString)
  {
    zzcx localzzcx = zzQf();
    if (localzzcx == null)
    {
      zzbo.e("getBoolean called for closed container.");
      return zzdl.zzRN().booleanValue();
    }
    try
    {
      boolean bool = zzdl.zzi((zzak.zza)localzzcx.zzhq(paramString).getObject()).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(paramString.getMessage());
      zzbo.e(String.valueOf(paramString).length() + 66 + "Calling getBoolean() threw an exception: " + paramString + " Returning default value.");
    }
    return zzdl.zzRN().booleanValue();
  }
  
  public String getContainerId()
  {
    return this.zzbEY;
  }
  
  public double getDouble(String paramString)
  {
    zzcx localzzcx = zzQf();
    if (localzzcx == null)
    {
      zzbo.e("getDouble called for closed container.");
      return zzdl.zzRM().doubleValue();
    }
    try
    {
      double d = zzdl.zzh((zzak.zza)localzzcx.zzhq(paramString).getObject()).doubleValue();
      return d;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(paramString.getMessage());
      zzbo.e(String.valueOf(paramString).length() + 65 + "Calling getDouble() threw an exception: " + paramString + " Returning default value.");
    }
    return zzdl.zzRM().doubleValue();
  }
  
  public long getLastRefreshTime()
  {
    return this.zzbFd;
  }
  
  public long getLong(String paramString)
  {
    zzcx localzzcx = zzQf();
    if (localzzcx == null)
    {
      zzbo.e("getLong called for closed container.");
      return zzdl.zzRL().longValue();
    }
    try
    {
      long l = zzdl.zzg((zzak.zza)localzzcx.zzhq(paramString).getObject()).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(paramString.getMessage());
      zzbo.e(String.valueOf(paramString).length() + 63 + "Calling getLong() threw an exception: " + paramString + " Returning default value.");
    }
    return zzdl.zzRL().longValue();
  }
  
  public String getString(String paramString)
  {
    zzcx localzzcx = zzQf();
    if (localzzcx == null)
    {
      zzbo.e("getString called for closed container.");
      return zzdl.zzRP();
    }
    try
    {
      paramString = zzdl.zze((zzak.zza)localzzcx.zzhq(paramString).getObject());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(paramString.getMessage());
      zzbo.e(String.valueOf(paramString).length() + 65 + "Calling getString() threw an exception: " + paramString + " Returning default value.");
    }
    return zzdl.zzRP();
  }
  
  public boolean isDefault()
  {
    return getLastRefreshTime() == 0L;
  }
  
  public void registerFunctionCallMacroCallback(String paramString, Container.FunctionCallMacroCallback paramFunctionCallMacroCallback)
  {
    if (paramFunctionCallMacroCallback == null) {
      throw new NullPointerException("Macro handler must be non-null");
    }
    synchronized (this.zzbFb)
    {
      this.zzbFb.put(paramString, paramFunctionCallMacroCallback);
      return;
    }
  }
  
  public void registerFunctionCallTagCallback(String paramString, Container.FunctionCallTagCallback paramFunctionCallTagCallback)
  {
    if (paramFunctionCallTagCallback == null) {
      throw new NullPointerException("Tag callback must be non-null");
    }
    synchronized (this.zzbFc)
    {
      this.zzbFc.put(paramString, paramFunctionCallTagCallback);
      return;
    }
  }
  
  void release()
  {
    this.zzbFa = null;
  }
  
  public void unregisterFunctionCallMacroCallback(String paramString)
  {
    synchronized (this.zzbFb)
    {
      this.zzbFb.remove(paramString);
      return;
    }
  }
  
  public void unregisterFunctionCallTagCallback(String paramString)
  {
    synchronized (this.zzbFc)
    {
      this.zzbFc.remove(paramString);
      return;
    }
  }
  
  public String zzQe()
  {
    return this.zzbFe;
  }
  
  Container.FunctionCallMacroCallback zzgS(String paramString)
  {
    synchronized (this.zzbFb)
    {
      paramString = (Container.FunctionCallMacroCallback)this.zzbFb.get(paramString);
      return paramString;
    }
  }
  
  public Container.FunctionCallTagCallback zzgT(String paramString)
  {
    synchronized (this.zzbFc)
    {
      paramString = (Container.FunctionCallTagCallback)this.zzbFc.get(paramString);
      return paramString;
    }
  }
  
  public void zzgU(String paramString)
  {
    zzQf().zzgU(paramString);
  }
  
  zzaj zzgV(String paramString)
  {
    zzcj.zzRd().zzRe().equals(zzcj.zza.zzbHn);
    return new zzbw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.Container
 * JD-Core Version:    0.7.0.1
 */