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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
    private final WeakReference<Context> aWF;
    private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aWG;
    private final Uri aWH;
    private final boolean aWI;
    private c aWJ;
    private long aWK;
    private Bitmap bitmap;
    private Exception exception;
    private Rect mRect;
    private final WeakReference<SubsamplingScaleImageView> oi;
    
    a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri, boolean paramBoolean)
    {
      AppMethodBeat.i(157349);
      this.aWK = -1L;
      this.oi = new WeakReference(paramSubsamplingScaleImageView);
      this.aWF = new WeakReference(paramContext);
      this.aWG = new WeakReference(paramb);
      this.aWH = paramUri;
      this.aWI = paramBoolean;
      paramb = new BitmapFactory.Options();
      paramb.inJustDecodeBounds = true;
      for (;;)
      {
        try
        {
          localInputStream = s.b(paramUri, null);
          paramSubsamplingScaleImageView = localObject;
        }
        catch (IOException paramSubsamplingScaleImageView)
        {
          InputStream localInputStream;
          try
          {
            localInputStream.close();
            AppMethodBeat.o(157349);
            throw paramContext;
            paramSubsamplingScaleImageView = paramSubsamplingScaleImageView;
            Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", paramSubsamplingScaleImageView, "Unable to read file: %s", new Object[] { paramUri.toString() });
          }
          catch (Throwable localThrowable)
          {
            paramSubsamplingScaleImageView.addSuppressed(localThrowable);
            continue;
          }
          localInputStream.close();
          continue;
        }
        try
        {
          BitmapFactory.decodeStream(localInputStream, null, paramb);
          if (localInputStream != null) {
            localInputStream.close();
          }
          this.mRect = new Rect(0, 0, paramb.outWidth, paramb.outHeight);
          AppMethodBeat.o(157349);
          return;
        }
        catch (Throwable paramContext)
        {
          paramSubsamplingScaleImageView = paramContext;
          AppMethodBeat.o(157349);
          paramSubsamplingScaleImageView = paramContext;
          throw paramContext;
        }
        finally
        {
          if (localInputStream != null) {
            if (paramSubsamplingScaleImageView == null) {
              continue;
            }
          }
        }
      }
    }
    
    private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView)
    {
      AppMethodBeat.i(157351);
      if ((paramSubsamplingScaleImageView != null) && (this.aWI) && (this.aWK != -1L))
      {
        Log.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        paramSubsamplingScaleImageView.dy((int)(System.currentTimeMillis() - this.aWK));
      }
      AppMethodBeat.o(157351);
    }
    
    @SuppressLint({"LongLogTag"})
    private Integer rI()
    {
      AppMethodBeat.i(157350);
      Log.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
      if (this.aWI) {
        this.aWK = System.currentTimeMillis();
      }
      try
      {
        Context localContext = (Context)this.aWF.get();
        Object localObject = (com.davemorrissey.labs.subscaleview.a.b)this.aWG.get();
        SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.oi.get();
        if ((localContext != null) && (localObject != null) && (localSubsamplingScaleImageView != null))
        {
          localSubsamplingScaleImageView.h("BitmapLoadTask.doInBackground", new Object[0]);
          localObject = (d)((com.davemorrissey.labs.subscaleview.a.b)localObject).rG();
          ((d)localObject).d(localContext, this.aWH);
          this.bitmap = ((d)localObject).a(this.mRect, 1);
          int i = localSubsamplingScaleImageView.e(localContext, this.aWH);
          ((d)localObject).recycle();
          a(localSubsamplingScaleImageView);
          AppMethodBeat.o(157350);
          return Integer.valueOf(i);
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
        this.exception = localFileNotFoundException;
        this.aWJ = new c(1, "tile init file not found");
        a((SubsamplingScaleImageView)this.oi.get());
        AppMethodBeat.o(157350);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localException, "Failed to load bitmap", new Object[0]);
          this.exception = localException;
          this.aWJ = new c(2, "bitmap decode failed");
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localOutOfMemoryError, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
          this.exception = new RuntimeException(localOutOfMemoryError);
          this.aWJ = new c(3, "bitmap decode OutOfMemoryError");
          SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.RGB_565);
        }
      }
    }
    
    public final void cancel() {}
    
    public final void rJ()
    {
      AppMethodBeat.i(157352);
      executeOnExecutor(((SubsamplingScaleImageView)this.oi.get()).executor, new Void[0]);
      AppMethodBeat.o(157352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.a
 * JD-Core Version:    0.7.0.1
 */