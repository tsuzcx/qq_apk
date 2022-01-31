package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import com.google.android.gms.common.api.PendingResult;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
  private static TagManager zzbIy;
  private final Context mContext;
  private final DataLayer zzbEZ;
  private final zzt zzbHy;
  private final TagManager.zza zzbIv;
  private final zzdb zzbIw;
  private final ConcurrentMap<String, zzo> zzbIx;
  
  TagManager(Context paramContext, TagManager.zza paramzza, DataLayer paramDataLayer, zzdb paramzzdb)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.zzbIw = paramzzdb;
    this.zzbIv = paramzza;
    this.zzbIx = new ConcurrentHashMap();
    this.zzbEZ = paramDataLayer;
    this.zzbEZ.zza(new TagManager.1(this));
    this.zzbEZ.zza(new zzd(this.mContext));
    this.zzbHy = new zzt();
    zzRD();
    zzRE();
  }
  
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (zzbIy != null) {
        break label68;
      }
      if (paramContext == null)
      {
        zzbo.e("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
      }
    }
    finally {}
    zzbIy = new TagManager(paramContext, new TagManager.2(), new DataLayer(new zzx(paramContext)), zzdc.zzRx());
    label68:
    paramContext = zzbIy;
    return paramContext;
  }
  
  @TargetApi(14)
  private void zzRD()
  {
    int i = Build.VERSION.SDK_INT;
    this.mContext.registerComponentCallbacks(new TagManager.3(this));
  }
  
  private void zzRE()
  {
    zza.zzbS(this.mContext);
  }
  
  private void zzhs(String paramString)
  {
    Iterator localIterator = this.zzbIx.values().iterator();
    while (localIterator.hasNext()) {
      ((zzo)localIterator.next()).zzgU(paramString);
    }
  }
  
  public void dispatch()
  {
    this.zzbIw.dispatch();
  }
  
  public DataLayer getDataLayer()
  {
    return this.zzbEZ;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt)
  {
    paramString = this.zzbIv.zza(this.mContext, this, null, paramString, paramInt, this.zzbHy);
    paramString.zzQj();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.zzbIv.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzbHy);
    paramString.zzQj();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt)
  {
    paramString = this.zzbIv.zza(this.mContext, this, null, paramString, paramInt, this.zzbHy);
    paramString.zzQl();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.zzbIv.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzbHy);
    paramString.zzQl();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt)
  {
    paramString = this.zzbIv.zza(this.mContext, this, null, paramString, paramInt, this.zzbHy);
    paramString.zzQk();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.zzbIv.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzbHy);
    paramString.zzQk();
    return paramString;
  }
  
  public void setVerboseLoggingEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 5)
    {
      zzbo.setLogLevel(i);
      return;
    }
  }
  
  public int zza(zzo paramzzo)
  {
    this.zzbIx.put(paramzzo.getContainerId(), paramzzo);
    return this.zzbIx.size();
  }
  
  public boolean zzb(zzo paramzzo)
  {
    return this.zzbIx.remove(paramzzo.getContainerId()) != null;
  }
  
  boolean zzv(Uri paramUri)
  {
    for (;;)
    {
      zzcj localzzcj;
      boolean bool;
      try
      {
        localzzcj = zzcj.zzRd();
        if (!localzzcj.zzv(paramUri)) {
          break label208;
        }
        paramUri = localzzcj.getContainerId();
        int i = TagManager.4.zzbIA[localzzcj.zzRe().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      paramUri = (zzo)this.zzbIx.get(paramUri);
      if (paramUri != null)
      {
        paramUri.zzgW(null);
        paramUri.refresh();
        continue;
        Iterator localIterator = this.zzbIx.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          zzo localzzo = (zzo)this.zzbIx.get(str);
          if (str.equals(paramUri))
          {
            localzzo.zzgW(localzzcj.zzRf());
            localzzo.refresh();
          }
          else if (localzzo.zzQg() != null)
          {
            localzzo.zzgW(null);
            localzzo.refresh();
          }
        }
        continue;
        label208:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.tagmanager.TagManager
 * JD-Core Version:    0.7.0.1
 */