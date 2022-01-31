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
import com.tencent.mm.sdk.platformtools.ab;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

final class a$a
  extends AsyncTask<Void, Void, Integer>
  implements com.davemorrissey.labs.subscaleview.c.b
{
  private final WeakReference<SubsamplingScaleImageView> aqT;
  private final WeakReference<Context> aqU;
  private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aqV;
  private final Uri aqW;
  private final boolean aqX;
  private c aqY;
  private long aqZ;
  private Bitmap bitmap;
  private Exception exception;
  private Rect mRect;
  
  a$a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(115614);
    this.aqZ = -1L;
    this.aqT = new WeakReference(paramSubsamplingScaleImageView);
    this.aqU = new WeakReference(paramContext);
    this.aqV = new WeakReference(paramb);
    this.aqW = paramUri;
    this.aqX = paramBoolean;
    paramSubsamplingScaleImageView = new BitmapFactory.Options();
    paramSubsamplingScaleImageView.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramUri.getPath(), paramSubsamplingScaleImageView);
    this.mRect = new Rect(0, 0, paramSubsamplingScaleImageView.outWidth, paramSubsamplingScaleImageView.outHeight);
    AppMethodBeat.o(115614);
  }
  
  private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView)
  {
    AppMethodBeat.i(115616);
    if ((paramSubsamplingScaleImageView != null) && (this.aqX) && (this.aqZ != -1L))
    {
      ab.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      paramSubsamplingScaleImageView.cP((int)(System.currentTimeMillis() - this.aqZ));
    }
    AppMethodBeat.o(115616);
  }
  
  @SuppressLint({"LongLogTag"})
  private Integer ln()
  {
    AppMethodBeat.i(115615);
    ab.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
    if (this.aqX) {
      this.aqZ = System.currentTimeMillis();
    }
    try
    {
      String str = this.aqW.toString();
      Context localContext = (Context)this.aqU.get();
      Object localObject = (com.davemorrissey.labs.subscaleview.a.b)this.aqV.get();
      SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.aqT.get();
      if ((localContext != null) && (localObject != null) && (localSubsamplingScaleImageView != null))
      {
        localSubsamplingScaleImageView.f("BitmapLoadTask.doInBackground", new Object[0]);
        localObject = (d)((com.davemorrissey.labs.subscaleview.a.b)localObject).ll();
        ((d)localObject).c(localContext, this.aqW);
        this.bitmap = ((d)localObject).b(this.mRect, 1);
        int i = localSubsamplingScaleImageView.h(localContext, str);
        ((d)localObject).recycle();
        a(localSubsamplingScaleImageView);
        AppMethodBeat.o(115615);
        return Integer.valueOf(i);
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      ab.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
      this.exception = localFileNotFoundException;
      this.aqY = new c(1, "tile init file not found");
      a((SubsamplingScaleImageView)this.aqT.get());
      AppMethodBeat.o(115615);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localException, "Failed to load bitmap", new Object[0]);
        this.exception = localException;
        this.aqY = new c(2, "bitmap decode failed");
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localOutOfMemoryError, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
        this.exception = new RuntimeException(localOutOfMemoryError);
        this.aqY = new c(3, "bitmap decode OutOfMemoryError");
        SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.RGB_565);
      }
    }
  }
  
  public final void cancel() {}
  
  public final void lo()
  {
    AppMethodBeat.i(115617);
    executeOnExecutor(((SubsamplingScaleImageView)this.aqT.get()).executor, new Void[0]);
    AppMethodBeat.o(115617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.a.a
 * JD-Core Version:    0.7.0.1
 */