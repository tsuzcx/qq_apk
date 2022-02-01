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
import com.tencent.mm.vfs.u;
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
    private final WeakReference<SubsamplingScaleImageView> aFW;
    private final WeakReference<Context> aFX;
    private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aFY;
    private final Uri aFZ;
    private final boolean aGa;
    private c aGb;
    private long aGc;
    private Bitmap bitmap;
    private Exception exception;
    private Rect mRect;
    
    a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri, boolean paramBoolean)
    {
      AppMethodBeat.i(157349);
      this.aGc = -1L;
      this.aFW = new WeakReference(paramSubsamplingScaleImageView);
      this.aFX = new WeakReference(paramContext);
      this.aFY = new WeakReference(paramb);
      this.aFZ = paramUri;
      this.aGa = paramBoolean;
      paramb = new BitmapFactory.Options();
      paramb.inJustDecodeBounds = true;
      for (;;)
      {
        try
        {
          localInputStream = u.q(paramUri);
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
      if ((paramSubsamplingScaleImageView != null) && (this.aGa) && (this.aGc != -1L))
      {
        Log.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        paramSubsamplingScaleImageView.dM((int)(System.currentTimeMillis() - this.aGc));
      }
      AppMethodBeat.o(157351);
    }
    
    @SuppressLint({"LongLogTag"})
    private Integer pw()
    {
      AppMethodBeat.i(157350);
      Log.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
      if (this.aGa) {
        this.aGc = System.currentTimeMillis();
      }
      try
      {
        Context localContext = (Context)this.aFX.get();
        Object localObject = (com.davemorrissey.labs.subscaleview.a.b)this.aFY.get();
        SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.aFW.get();
        if ((localContext != null) && (localObject != null) && (localSubsamplingScaleImageView != null))
        {
          localSubsamplingScaleImageView.h("BitmapLoadTask.doInBackground", new Object[0]);
          localObject = (d)((com.davemorrissey.labs.subscaleview.a.b)localObject).pu();
          ((d)localObject).b(localContext, this.aFZ);
          this.bitmap = ((d)localObject).a(this.mRect, 1);
          int i = localSubsamplingScaleImageView.c(localContext, this.aFZ);
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
        this.aGb = new c(1, "tile init file not found");
        a((SubsamplingScaleImageView)this.aFW.get());
        AppMethodBeat.o(157350);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localException, "Failed to load bitmap", new Object[0]);
          this.exception = localException;
          this.aGb = new c(2, "bitmap decode failed");
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localOutOfMemoryError, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
          this.exception = new RuntimeException(localOutOfMemoryError);
          this.aGb = new c(3, "bitmap decode OutOfMemoryError");
          SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.RGB_565);
        }
      }
    }
    
    public final void cancel() {}
    
    public final void px()
    {
      AppMethodBeat.i(157352);
      executeOnExecutor(((SubsamplingScaleImageView)this.aFW.get()).executor, new Void[0]);
      AppMethodBeat.o(157352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.a
 * JD-Core Version:    0.7.0.1
 */