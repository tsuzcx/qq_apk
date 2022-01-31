package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.google.android.gms.common.images.internal.PostProcessedResourceCache;
import com.google.android.gms.common.internal.Asserts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
  private final Map<ImageRequest, ImageManager.ImageReceiver> zzpc;
  private final Map<Uri, ImageManager.ImageReceiver> zzpd;
  private final Map<Uri, Long> zzpe;
  
  static
  {
    AppMethodBeat.i(61227);
    zzov = new Object();
    zzow = new HashSet();
    AppMethodBeat.o(61227);
  }
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(61218);
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.zzoz = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.zzpa = new ImageManager.zza(this.mContext);
      this.mContext.registerComponentCallbacks(new ImageManager.zzd(this.zzpa));
    }
    for (;;)
    {
      this.zzpb = new PostProcessedResourceCache();
      this.zzpc = new HashMap();
      this.zzpd = new HashMap();
      this.zzpe = new HashMap();
      AppMethodBeat.o(61218);
      return;
      this.zzpa = null;
    }
  }
  
  public static ImageManager create(Context paramContext)
  {
    AppMethodBeat.i(61216);
    paramContext = create(paramContext, false);
    AppMethodBeat.o(61216);
    return paramContext;
  }
  
  public static ImageManager create(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(61217);
    if (paramBoolean)
    {
      if (zzoy == null) {
        zzoy = new ImageManager(paramContext, true);
      }
      paramContext = zzoy;
      AppMethodBeat.o(61217);
      return paramContext;
    }
    if (zzox == null) {
      zzox = new ImageManager(paramContext, false);
    }
    paramContext = zzox;
    AppMethodBeat.o(61217);
    return paramContext;
  }
  
  private final Bitmap zza(ImageRequest.zza paramzza)
  {
    AppMethodBeat.i(61225);
    if (this.zzpa == null)
    {
      AppMethodBeat.o(61225);
      return null;
    }
    paramzza = (Bitmap)this.zzpa.get(paramzza);
    AppMethodBeat.o(61225);
    return paramzza;
  }
  
  public final void loadImage(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(61220);
    loadImage(new ImageRequest.ImageViewImageRequest(paramImageView, paramInt));
    AppMethodBeat.o(61220);
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri)
  {
    AppMethodBeat.i(61219);
    loadImage(new ImageRequest.ImageViewImageRequest(paramImageView, paramUri));
    AppMethodBeat.o(61219);
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(61221);
    paramImageView = new ImageRequest.ImageViewImageRequest(paramImageView, paramUri);
    paramImageView.setNoDataPlaceholder(paramInt);
    loadImage(paramImageView);
    AppMethodBeat.o(61221);
  }
  
  public final void loadImage(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    AppMethodBeat.i(61222);
    loadImage(new ImageRequest.ListenerImageRequest(paramOnImageLoadedListener, paramUri));
    AppMethodBeat.o(61222);
  }
  
  public final void loadImage(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(61223);
    paramOnImageLoadedListener = new ImageRequest.ListenerImageRequest(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.setNoDataPlaceholder(paramInt);
    loadImage(paramOnImageLoadedListener);
    AppMethodBeat.o(61223);
  }
  
  public final void loadImage(ImageRequest paramImageRequest)
  {
    AppMethodBeat.i(61224);
    Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
    new ImageManager.zzc(this, paramImageRequest).run();
    AppMethodBeat.o(61224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.7.0.1
 */