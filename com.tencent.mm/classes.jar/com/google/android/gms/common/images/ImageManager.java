package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.f.g;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzacd;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object zzaEf = new Object();
  private static HashSet<Uri> zzaEg = new HashSet();
  private static ImageManager zzaEh;
  private static ImageManager zzaEi;
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService zzaEj;
  private final zza zzaEk;
  private final zzacd zzaEl;
  private final Map<zza, ImageManager.ImageReceiver> zzaEm;
  private final Map<Uri, ImageManager.ImageReceiver> zzaEn;
  private final Map<Uri, Long> zzaEo;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.zzaEj = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.zzaEk = new zza(this.mContext);
      this.mContext.registerComponentCallbacks(new ImageManager.zzd(this.zzaEk));
    }
    for (;;)
    {
      this.zzaEl = new zzacd();
      this.zzaEm = new HashMap();
      this.zzaEn = new HashMap();
      this.zzaEo = new HashMap();
      return;
      this.zzaEk = null;
    }
  }
  
  public static ImageManager create(Context paramContext)
  {
    return zzg(paramContext, false);
  }
  
  private Bitmap zza(zza.zza paramzza)
  {
    if (this.zzaEk == null) {
      return null;
    }
    return (Bitmap)this.zzaEk.get(paramzza);
  }
  
  public static ImageManager zzg(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (zzaEi == null) {
        zzaEi = new ImageManager(paramContext, true);
      }
      return zzaEi;
    }
    if (zzaEh == null) {
      zzaEh = new ImageManager(paramContext, false);
    }
    return zzaEh;
  }
  
  public final void loadImage(ImageView paramImageView, int paramInt)
  {
    zza(new zza.zzb(paramImageView, paramInt));
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri)
  {
    zza(new zza.zzb(paramImageView, paramUri));
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramImageView = new zza.zzb(paramImageView, paramUri);
    paramImageView.zzcO(paramInt);
    zza(paramImageView);
  }
  
  public final void loadImage(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    zza(new zza.zzc(paramOnImageLoadedListener, paramUri));
  }
  
  public final void loadImage(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new zza.zzc(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.zzcO(paramInt);
    zza(paramOnImageLoadedListener);
  }
  
  public final void zza(zza paramzza)
  {
    zzc.zzdj("ImageManager.loadImage() must be called in the main thread");
    new ImageManager.zzc(this, paramzza).run();
  }
  
  private static final class zza
    extends g<zza.zza, Bitmap>
  {
    public zza(Context paramContext)
    {
      super();
    }
    
    private static int zzaR(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if ((paramContext.getApplicationInfo().flags & 0x100000) != 0)
      {
        i = 1;
        if (i == 0) {
          break label49;
        }
      }
      label49:
      for (int i = localActivityManager.getLargeMemoryClass();; i = localActivityManager.getMemoryClass())
      {
        return (int)(i * 1048576 * 0.33F);
        i = 0;
        break;
      }
    }
    
    protected final int zza(zza.zza paramzza, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }
    
    protected final void zza(boolean paramBoolean, zza.zza paramzza, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, paramzza, paramBitmap1, paramBitmap2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.7.0.1
 */