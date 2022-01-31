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
import com.tencent.mm.sdk.platformtools.y;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

final class a$a
  extends AsyncTask<Void, Void, Integer>
  implements com.davemorrissey.labs.subscaleview.c.b
{
  private final WeakReference<SubsamplingScaleImageView> aoA;
  private final WeakReference<Context> aoB;
  private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aoC;
  private final boolean aoD;
  private c aoE;
  private long aoF = -1L;
  private Bitmap bitmap;
  private Exception exception;
  private Rect mRect;
  private final Uri source;
  
  a$a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri, boolean paramBoolean)
  {
    this.aoA = new WeakReference(paramSubsamplingScaleImageView);
    this.aoB = new WeakReference(paramContext);
    this.aoC = new WeakReference(paramb);
    this.source = paramUri;
    this.aoD = paramBoolean;
    paramSubsamplingScaleImageView = new BitmapFactory.Options();
    paramSubsamplingScaleImageView.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramUri.getPath(), paramSubsamplingScaleImageView);
    this.mRect = new Rect(0, 0, paramSubsamplingScaleImageView.outWidth, paramSubsamplingScaleImageView.outHeight);
  }
  
  private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView)
  {
    if ((paramSubsamplingScaleImageView != null) && (this.aoD) && (this.aoF != -1L))
    {
      y.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      paramSubsamplingScaleImageView.cw((int)(System.currentTimeMillis() - this.aoF));
    }
  }
  
  @SuppressLint({"LongLogTag"})
  private Integer jt()
  {
    y.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
    if (this.aoD) {
      this.aoF = System.currentTimeMillis();
    }
    try
    {
      String str = this.source.toString();
      Context localContext = (Context)this.aoB.get();
      Object localObject = (com.davemorrissey.labs.subscaleview.a.b)this.aoC.get();
      SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.aoA.get();
      if ((localContext != null) && (localObject != null) && (localSubsamplingScaleImageView != null))
      {
        localSubsamplingScaleImageView.i("BitmapLoadTask.doInBackground", new Object[0]);
        localObject = (d)((com.davemorrissey.labs.subscaleview.a.b)localObject).jr();
        ((d)localObject).c(localContext, this.source);
        this.bitmap = ((d)localObject).b(this.mRect, 1);
        int i = localSubsamplingScaleImageView.h(localContext, str);
        ((d)localObject).recycle();
        a(localSubsamplingScaleImageView);
        return Integer.valueOf(i);
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      y.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
      this.exception = localFileNotFoundException;
      this.aoE = new c(1, "tile init file not found");
      a((SubsamplingScaleImageView)this.aoA.get());
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localException, "Failed to load bitmap", new Object[0]);
        this.exception = localException;
        this.aoE = new c(2, "bitmap decode failed");
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localOutOfMemoryError, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
        this.exception = new RuntimeException(localOutOfMemoryError);
        this.aoE = new c(3, "bitmap decode OutOfMemoryError");
        SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.RGB_565);
      }
    }
  }
  
  public final void ju()
  {
    executeOnExecutor(((SubsamplingScaleImageView)this.aoA.get()).aqE, new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.a.a
 * JD-Core Version:    0.7.0.1
 */