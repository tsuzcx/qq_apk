package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.c;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

public final class a
  implements com.davemorrissey.labs.subscaleview.c.a
{
  public final com.davemorrissey.labs.subscaleview.c.b a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(157355);
    paramSubsamplingScaleImageView = new a(paramSubsamplingScaleImageView, paramContext, paramb, paramUri, paramBoolean);
    AppMethodBeat.o(157355);
    return paramSubsamplingScaleImageView;
  }
  
  static final class a
    extends AsyncTask<Void, Void, Integer>
    implements com.davemorrissey.labs.subscaleview.c.b
  {
    private final WeakReference<Context> aLG;
    private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aLH;
    private final Uri aLI;
    private final boolean aLJ;
    private c aLK;
    private long aLL;
    private Bitmap bitmap;
    private Exception exception;
    private final WeakReference<SubsamplingScaleImageView> lo;
    private Rect mRect;
    
    a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri, boolean paramBoolean)
    {
      AppMethodBeat.i(157349);
      this.aLL = -1L;
      this.lo = new WeakReference(paramSubsamplingScaleImageView);
      this.aLG = new WeakReference(paramContext);
      this.aLH = new WeakReference(paramb);
      this.aLI = paramUri;
      this.aLJ = paramBoolean;
      paramSubsamplingScaleImageView = new BitmapFactory.Options();
      paramSubsamplingScaleImageView.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramUri.getPath(), paramSubsamplingScaleImageView);
      this.mRect = new Rect(0, 0, paramSubsamplingScaleImageView.outWidth, paramSubsamplingScaleImageView.outHeight);
      AppMethodBeat.o(157349);
    }
    
    private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView)
    {
      AppMethodBeat.i(157351);
      if ((paramSubsamplingScaleImageView != null) && (this.aLJ) && (this.aLL != -1L))
      {
        ad.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        paramSubsamplingScaleImageView.dA((int)(System.currentTimeMillis() - this.aLL));
      }
      AppMethodBeat.o(157351);
    }
    
    @SuppressLint({"LongLogTag"})
    private Integer pX()
    {
      AppMethodBeat.i(157350);
      ad.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
      if (this.aLJ) {
        this.aLL = System.currentTimeMillis();
      }
      try
      {
        String str = this.aLI.toString();
        Context localContext = (Context)this.aLG.get();
        Object localObject = (com.davemorrissey.labs.subscaleview.a.b)this.aLH.get();
        SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.lo.get();
        if ((localContext != null) && (localObject != null) && (localSubsamplingScaleImageView != null))
        {
          localSubsamplingScaleImageView.f("BitmapLoadTask.doInBackground", new Object[0]);
          localObject = (d)((com.davemorrissey.labs.subscaleview.a.b)localObject).pV();
          ((d)localObject).c(localContext, this.aLI);
          this.bitmap = ((d)localObject).a(this.mRect, 1);
          int i = localSubsamplingScaleImageView.h(localContext, str);
          ((d)localObject).recycle();
          a(localSubsamplingScaleImageView);
          AppMethodBeat.o(157350);
          return Integer.valueOf(i);
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        ad.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
        this.exception = localFileNotFoundException;
        this.aLK = new c(1, "tile init file not found");
        a((SubsamplingScaleImageView)this.lo.get());
        AppMethodBeat.o(157350);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localException, "Failed to load bitmap", new Object[0]);
          this.exception = localException;
          this.aLK = new c(2, "bitmap decode failed");
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localOutOfMemoryError, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
          this.exception = new RuntimeException(localOutOfMemoryError);
          this.aLK = new c(3, "bitmap decode OutOfMemoryError");
          SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.RGB_565);
        }
      }
    }
    
    public final void cancel() {}
    
    public final void pY()
    {
      AppMethodBeat.i(157352);
      executeOnExecutor(((SubsamplingScaleImageView)this.lo.get()).executor, new Void[0]);
      AppMethodBeat.o(157352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.a
 * JD-Core Version:    0.7.0.1
 */