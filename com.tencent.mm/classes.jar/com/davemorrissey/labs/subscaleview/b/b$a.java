package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.c;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.mm.sdk.platformtools.y;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

final class b$a
  extends AsyncTask<Void, Void, int[]>
  implements com.davemorrissey.labs.subscaleview.c.b
{
  private final WeakReference<SubsamplingScaleImageView> aoA;
  private final WeakReference<Context> aoB;
  private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aoC;
  private c aoE;
  private long aoF;
  private d aoG;
  private Exception exception;
  private final Uri source;
  
  b$a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri)
  {
    this.aoA = new WeakReference(paramSubsamplingScaleImageView);
    this.aoB = new WeakReference(paramContext);
    this.aoC = new WeakReference(paramb);
    this.source = paramUri;
  }
  
  private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView)
  {
    if ((paramSubsamplingScaleImageView != null) && (this.aoF != -1L)) {
      paramSubsamplingScaleImageView.cv((int)(System.currentTimeMillis() - this.aoF));
    }
  }
  
  @SuppressLint({"LongLogTag"})
  private int[] jv()
  {
    y.d("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask doInBackground");
    this.aoF = System.currentTimeMillis();
    try
    {
      Object localObject1 = this.source.toString();
      Context localContext = (Context)this.aoB.get();
      Object localObject2 = (com.davemorrissey.labs.subscaleview.a.b)this.aoC.get();
      SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.aoA.get();
      if ((localContext != null) && (localObject2 != null) && (localSubsamplingScaleImageView != null))
      {
        this.aoG = ((d)((com.davemorrissey.labs.subscaleview.a.b)localObject2).jr());
        localObject2 = this.aoG.c(localContext, this.source);
        int k = ((Point)localObject2).x;
        int m = ((Point)localObject2).y;
        int n = localSubsamplingScaleImageView.h(localContext, (String)localObject1);
        int j = k;
        int i = m;
        if (localSubsamplingScaleImageView.getsRegion() != null)
        {
          localObject1 = localSubsamplingScaleImageView.getsRegion();
          ((Rect)localObject1).left = Math.max(0, ((Rect)localObject1).left);
          ((Rect)localObject1).top = Math.max(0, ((Rect)localObject1).top);
          ((Rect)localObject1).right = Math.min(k, ((Rect)localObject1).right);
          ((Rect)localObject1).bottom = Math.min(m, ((Rect)localObject1).bottom);
          j = ((Rect)localObject1).width();
          i = ((Rect)localObject1).height();
          localSubsamplingScaleImageView.setsRegion((Rect)localObject1);
        }
        a(localSubsamplingScaleImageView);
        return new int[] { j, i, n };
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      y.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
      this.exception = localFileNotFoundException;
      this.aoE = new c(1, "tile init file not found");
      a((SubsamplingScaleImageView)this.aoA.get());
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
        this.exception = localException;
        this.aoE = new c(4, "tile init failed");
      }
    }
  }
  
  public final void ju()
  {
    executeOnExecutor(((SubsamplingScaleImageView)this.aoA.get()).aqE, new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.b.a
 * JD-Core Version:    0.7.0.1
 */