package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.widget.ImageView;
import com.google.android.gms.common.images.internal.PostProcessedResourceCache;
import com.google.android.gms.common.internal.Asserts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  public static final int PRIORITY_HIGH = 3;
  public static final int PRIORITY_LOW = 1;
  public static final int PRIORITY_MEDIUM = 2;
  private static final Object zzov;
  private static HashSet<Uri> zzow;
  private static ImageManager zzox;
  private static ImageManager zzoy;
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService zzoz;
  private final ImageManager.zza zzpa;
  private final PostProcessedResourceCache zzpb;
  private final Map<ImageRequest, ImageReceiver> zzpc;
  private final Map<Uri, ImageReceiver> zzpd;
  private final Map<Uri, Long> zzpe;
  
  static
  {
    AppMethodBeat.i(11719);
    zzov = new Object();
    zzow = new HashSet();
    AppMethodBeat.o(11719);
  }
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(11710);
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.zzoz = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.zzpa = new ImageManager.zza(this.mContext);
      this.mContext.registerComponentCallbacks(new zzd(this.zzpa));
    }
    for (;;)
    {
      this.zzpb = new PostProcessedResourceCache();
      this.zzpc = new HashMap();
      this.zzpd = new HashMap();
      this.zzpe = new HashMap();
      AppMethodBeat.o(11710);
      return;
      this.zzpa = null;
    }
  }
  
  public static ImageManager create(Context paramContext)
  {
    AppMethodBeat.i(11708);
    paramContext = create(paramContext, false);
    AppMethodBeat.o(11708);
    return paramContext;
  }
  
  public static ImageManager create(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(11709);
    if (paramBoolean)
    {
      if (zzoy == null) {
        zzoy = new ImageManager(paramContext, true);
      }
      paramContext = zzoy;
      AppMethodBeat.o(11709);
      return paramContext;
    }
    if (zzox == null) {
      zzox = new ImageManager(paramContext, false);
    }
    paramContext = zzox;
    AppMethodBeat.o(11709);
    return paramContext;
  }
  
  private final Bitmap zza(ImageRequest.zza paramzza)
  {
    AppMethodBeat.i(11717);
    if (this.zzpa == null)
    {
      AppMethodBeat.o(11717);
      return null;
    }
    paramzza = (Bitmap)this.zzpa.get(paramzza);
    AppMethodBeat.o(11717);
    return paramzza;
  }
  
  public final void loadImage(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(11712);
    loadImage(new ImageRequest.ImageViewImageRequest(paramImageView, paramInt));
    AppMethodBeat.o(11712);
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri)
  {
    AppMethodBeat.i(11711);
    loadImage(new ImageRequest.ImageViewImageRequest(paramImageView, paramUri));
    AppMethodBeat.o(11711);
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(11713);
    paramImageView = new ImageRequest.ImageViewImageRequest(paramImageView, paramUri);
    paramImageView.setNoDataPlaceholder(paramInt);
    loadImage(paramImageView);
    AppMethodBeat.o(11713);
  }
  
  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    AppMethodBeat.i(11714);
    loadImage(new ImageRequest.ListenerImageRequest(paramOnImageLoadedListener, paramUri));
    AppMethodBeat.o(11714);
  }
  
  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(11715);
    paramOnImageLoadedListener = new ImageRequest.ListenerImageRequest(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.setNoDataPlaceholder(paramInt);
    loadImage(paramOnImageLoadedListener);
    AppMethodBeat.o(11715);
  }
  
  public final void loadImage(ImageRequest paramImageRequest)
  {
    AppMethodBeat.i(11716);
    Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
    new zzc(paramImageRequest).run();
    AppMethodBeat.o(11716);
  }
  
  final class ImageReceiver
    extends ResultReceiver
  {
    private final Uri mUri;
    private final ArrayList<ImageRequest> zzpf;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      AppMethodBeat.i(11695);
      this.mUri = paramUri;
      this.zzpf = new ArrayList();
      AppMethodBeat.o(11695);
    }
    
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(11699);
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zzf(ImageManager.this).execute(new ImageManager.zzb(ImageManager.this, this.mUri, paramBundle));
      AppMethodBeat.o(11699);
    }
    
    public final void zza(ImageRequest paramImageRequest)
    {
      AppMethodBeat.i(11696);
      Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
      this.zzpf.add(paramImageRequest);
      AppMethodBeat.o(11696);
    }
    
    public final void zzb(ImageRequest paramImageRequest)
    {
      AppMethodBeat.i(11697);
      Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.zzpf.remove(paramImageRequest);
      AppMethodBeat.o(11697);
    }
    
    public final void zzco()
    {
      AppMethodBeat.i(11698);
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zzb(ImageManager.this).sendBroadcast(localIntent);
      AppMethodBeat.o(11698);
    }
  }
  
  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
  
  final class zzb
    implements Runnable
  {
    private final Uri mUri;
    private final ParcelFileDescriptor zzph;
    
    public zzb(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.mUri = paramUri;
      this.zzph = paramParcelFileDescriptor;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: sipush 11703
      //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: ldc 42
      //   8: invokestatic 48	com/google/android/gms/common/internal/Asserts:checkNotMainThread	(Ljava/lang/String;)V
      //   11: iconst_0
      //   12: istore_1
      //   13: iconst_0
      //   14: istore_2
      //   15: aconst_null
      //   16: astore_3
      //   17: aconst_null
      //   18: astore 4
      //   20: aload_0
      //   21: getfield 26	com/google/android/gms/common/images/ImageManager$zzb:zzph	Landroid/os/ParcelFileDescriptor;
      //   24: ifnull +23 -> 47
      //   27: aload_0
      //   28: getfield 26	com/google/android/gms/common/images/ImageManager$zzb:zzph	Landroid/os/ParcelFileDescriptor;
      //   31: invokevirtual 54	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
      //   34: invokestatic 60	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;
      //   37: astore_3
      //   38: iload_2
      //   39: istore_1
      //   40: aload_0
      //   41: getfield 26	com/google/android/gms/common/images/ImageManager$zzb:zzph	Landroid/os/ParcelFileDescriptor;
      //   44: invokevirtual 63	android/os/ParcelFileDescriptor:close	()V
      //   47: new 65	java/util/concurrent/CountDownLatch
      //   50: dup
      //   51: iconst_1
      //   52: invokespecial 67	java/util/concurrent/CountDownLatch:<init>	(I)V
      //   55: astore 4
      //   57: aload_0
      //   58: getfield 19	com/google/android/gms/common/images/ImageManager$zzb:zzpg	Lcom/google/android/gms/common/images/ImageManager;
      //   61: invokestatic 71	com/google/android/gms/common/images/ImageManager:zzg	(Lcom/google/android/gms/common/images/ImageManager;)Landroid/os/Handler;
      //   64: new 73	com/google/android/gms/common/images/ImageManager$zze
      //   67: dup
      //   68: aload_0
      //   69: getfield 19	com/google/android/gms/common/images/ImageManager$zzb:zzpg	Lcom/google/android/gms/common/images/ImageManager;
      //   72: aload_0
      //   73: getfield 24	com/google/android/gms/common/images/ImageManager$zzb:mUri	Landroid/net/Uri;
      //   76: aload_3
      //   77: iload_1
      //   78: aload 4
      //   80: invokespecial 76	com/google/android/gms/common/images/ImageManager$zze:<init>	(Lcom/google/android/gms/common/images/ImageManager;Landroid/net/Uri;Landroid/graphics/Bitmap;ZLjava/util/concurrent/CountDownLatch;)V
      //   83: invokevirtual 82	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   86: pop
      //   87: aload 4
      //   89: invokevirtual 85	java/util/concurrent/CountDownLatch:await	()V
      //   92: sipush 11703
      //   95: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   98: return
      //   99: astore_3
      //   100: aload_0
      //   101: getfield 24	com/google/android/gms/common/images/ImageManager$zzb:mUri	Landroid/net/Uri;
      //   104: invokestatic 94	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   107: astore_3
      //   108: new 96	java/lang/StringBuilder
      //   111: dup
      //   112: aload_3
      //   113: invokestatic 94	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   116: invokevirtual 100	java/lang/String:length	()I
      //   119: bipush 34
      //   121: iadd
      //   122: invokespecial 101	java/lang/StringBuilder:<init>	(I)V
      //   125: ldc 103
      //   127: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   130: aload_3
      //   131: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   134: pop
      //   135: iconst_1
      //   136: istore_1
      //   137: aload 4
      //   139: astore_3
      //   140: goto -100 -> 40
      //   143: astore_3
      //   144: aload_0
      //   145: getfield 24	com/google/android/gms/common/images/ImageManager$zzb:mUri	Landroid/net/Uri;
      //   148: invokestatic 94	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   151: astore_3
      //   152: new 96	java/lang/StringBuilder
      //   155: dup
      //   156: aload_3
      //   157: invokestatic 94	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   160: invokevirtual 100	java/lang/String:length	()I
      //   163: bipush 32
      //   165: iadd
      //   166: invokespecial 101	java/lang/StringBuilder:<init>	(I)V
      //   169: ldc 109
      //   171: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   174: aload_3
      //   175: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: pop
      //   179: sipush 11703
      //   182: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   185: return
      //   186: astore 4
      //   188: goto -141 -> 47
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	191	0	this	zzb
      //   12	125	1	bool1	boolean
      //   14	25	2	bool2	boolean
      //   16	61	3	localBitmap	Bitmap
      //   99	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
      //   107	33	3	localObject	Object
      //   143	1	3	localInterruptedException	java.lang.InterruptedException
      //   151	24	3	str	java.lang.String
      //   18	120	4	localCountDownLatch	CountDownLatch
      //   186	1	4	localIOException	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   27	38	99	java/lang/OutOfMemoryError
      //   87	92	143	java/lang/InterruptedException
      //   40	47	186	java/io/IOException
    }
  }
  
  final class zzc
    implements Runnable
  {
    private final ImageRequest zzpi;
    
    public zzc(ImageRequest paramImageRequest)
    {
      this.zzpi = paramImageRequest;
    }
    
    public final void run()
    {
      AppMethodBeat.i(11704);
      Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.zza(ImageManager.this).get(this.zzpi);
      if (localObject1 != null)
      {
        ImageManager.zza(ImageManager.this).remove(this.zzpi);
        ((ImageManager.ImageReceiver)localObject1).zzb(this.zzpi);
      }
      ImageRequest.zza localzza = this.zzpi.zzpk;
      if (localzza.uri == null)
      {
        this.zzpi.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
        AppMethodBeat.o(11704);
        return;
      }
      localObject1 = ImageManager.zza(ImageManager.this, localzza);
      if (localObject1 != null)
      {
        this.zzpi.zza(ImageManager.zzb(ImageManager.this), (Bitmap)localObject1, true);
        AppMethodBeat.o(11704);
        return;
      }
      localObject1 = (Long)ImageManager.zzd(ImageManager.this).get(localzza.uri);
      if (localObject1 != null)
      {
        if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
        {
          this.zzpi.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
          AppMethodBeat.o(11704);
          return;
        }
        ImageManager.zzd(ImageManager.this).remove(localzza.uri);
      }
      this.zzpi.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this));
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).get(localzza.uri);
      localObject1 = ???;
      if (??? == null)
      {
        localObject1 = new ImageManager.ImageReceiver(ImageManager.this, localzza.uri);
        ImageManager.zze(ImageManager.this).put(localzza.uri, localObject1);
      }
      ((ImageManager.ImageReceiver)localObject1).zza(this.zzpi);
      if (!(this.zzpi instanceof ImageRequest.ListenerImageRequest)) {
        ImageManager.zza(ImageManager.this).put(this.zzpi, localObject1);
      }
      synchronized (ImageManager.zzcm())
      {
        if (!ImageManager.zzcn().contains(localzza.uri))
        {
          ImageManager.zzcn().add(localzza.uri);
          ((ImageManager.ImageReceiver)localObject1).zzco();
        }
        AppMethodBeat.o(11704);
        return;
      }
    }
  }
  
  static final class zzd
    implements ComponentCallbacks2
  {
    private final ImageManager.zza zzpa;
    
    public zzd(ImageManager.zza paramzza)
    {
      this.zzpa = paramzza;
    }
    
    public final void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public final void onLowMemory()
    {
      AppMethodBeat.i(11705);
      this.zzpa.evictAll();
      AppMethodBeat.o(11705);
    }
    
    public final void onTrimMemory(int paramInt)
    {
      AppMethodBeat.i(11706);
      if (paramInt >= 60)
      {
        this.zzpa.evictAll();
        AppMethodBeat.o(11706);
        return;
      }
      if (paramInt >= 20) {
        this.zzpa.trimToSize(this.zzpa.size() / 2);
      }
      AppMethodBeat.o(11706);
    }
  }
  
  final class zze
    implements Runnable
  {
    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch zzfd;
    private boolean zzpj;
    
    public zze(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      this.mUri = paramUri;
      this.mBitmap = paramBitmap;
      this.zzpj = paramBoolean;
      this.zzfd = paramCountDownLatch;
    }
    
    public final void run()
    {
      AppMethodBeat.i(11707);
      Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
      int i;
      if (this.mBitmap != null) {
        i = 1;
      }
      while (ImageManager.zzh(ImageManager.this) != null) {
        if (this.zzpj)
        {
          ImageManager.zzh(ImageManager.this).evictAll();
          System.gc();
          this.zzpj = false;
          ImageManager.zzg(ImageManager.this).post(this);
          AppMethodBeat.o(11707);
          return;
          i = 0;
        }
        else if (i != 0)
        {
          ImageManager.zzh(ImageManager.this).put(new ImageRequest.zza(this.mUri), this.mBitmap);
        }
      }
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).remove(this.mUri);
      if (??? != null)
      {
        ??? = ImageManager.ImageReceiver.zza((ImageManager.ImageReceiver)???);
        int k = ((ArrayList)???).size();
        int j = 0;
        if (j < k)
        {
          ImageRequest localImageRequest = (ImageRequest)((ArrayList)???).get(j);
          if (i != 0) {
            localImageRequest.zza(ImageManager.zzb(ImageManager.this), this.mBitmap, false);
          }
          for (;;)
          {
            if (!(localImageRequest instanceof ImageRequest.ListenerImageRequest)) {
              ImageManager.zza(ImageManager.this).remove(localImageRequest);
            }
            j += 1;
            break;
            ImageManager.zzd(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
            localImageRequest.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), false);
          }
        }
      }
      this.zzfd.countDown();
      synchronized (ImageManager.zzcm())
      {
        ImageManager.zzcn().remove(this.mUri);
        AppMethodBeat.o(11707);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.7.0.1
 */