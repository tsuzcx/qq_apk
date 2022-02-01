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
import com.tencent.mm.sdk.platformtools.ac;
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
    private c aMA;
    private long aMB;
    private final WeakReference<Context> aMw;
    private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aMx;
    private final Uri aMy;
    private final boolean aMz;
    private Bitmap bitmap;
    private Exception exception;
    private Rect mRect;
    private final WeakReference<SubsamplingScaleImageView> mn;
    
    a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri, boolean paramBoolean)
    {
      AppMethodBeat.i(157349);
      this.aMB = -1L;
      this.mn = new WeakReference(paramSubsamplingScaleImageView);
      this.aMw = new WeakReference(paramContext);
      this.aMx = new WeakReference(paramb);
      this.aMy = paramUri;
      this.aMz = paramBoolean;
      paramSubsamplingScaleImageView = new BitmapFactory.Options();
      paramSubsamplingScaleImageView.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramUri.getPath(), paramSubsamplingScaleImageView);
      this.mRect = new Rect(0, 0, paramSubsamplingScaleImageView.outWidth, paramSubsamplingScaleImageView.outHeight);
      AppMethodBeat.o(157349);
    }
    
    private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView)
    {
      AppMethodBeat.i(157351);
      if ((paramSubsamplingScaleImageView != null) && (this.aMz) && (this.aMB != -1L))
      {
        ac.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        paramSubsamplingScaleImageView.dz((int)(System.currentTimeMillis() - this.aMB));
      }
      AppMethodBeat.o(157351);
    }
    
    @SuppressLint({"LongLogTag"})
    private Integer qh()
    {
      AppMethodBeat.i(157350);
      ac.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
      if (this.aMz) {
        this.aMB = System.currentTimeMillis();
      }
      try
      {
        String str = this.aMy.toString();
        Context localContext = (Context)this.aMw.get();
        Object localObject = (com.davemorrissey.labs.subscaleview.a.b)this.aMx.get();
        SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.mn.get();
        if ((localContext != null) && (localObject != null) && (localSubsamplingScaleImageView != null))
        {
          localSubsamplingScaleImageView.f("BitmapLoadTask.doInBackground", new Object[0]);
          localObject = (d)((com.davemorrissey.labs.subscaleview.a.b)localObject).qf();
          ((d)localObject).c(localContext, this.aMy);
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
        ac.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
        this.exception = localFileNotFoundException;
        this.aMA = new c(1, "tile init file not found");
        a((SubsamplingScaleImageView)this.mn.get());
        AppMethodBeat.o(157350);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localException, "Failed to load bitmap", new Object[0]);
          this.exception = localException;
          this.aMA = new c(2, "bitmap decode failed");
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localOutOfMemoryError, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
          this.exception = new RuntimeException(localOutOfMemoryError);
          this.aMA = new c(3, "bitmap decode OutOfMemoryError");
          SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.RGB_565);
        }
      }
    }
    
    public final void cancel() {}
    
    public final void qi()
    {
      AppMethodBeat.i(157352);
      executeOnExecutor(((SubsamplingScaleImageView)this.mn.get()).executor, new Void[0]);
      AppMethodBeat.o(157352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.a
 * JD-Core Version:    0.7.0.1
 */