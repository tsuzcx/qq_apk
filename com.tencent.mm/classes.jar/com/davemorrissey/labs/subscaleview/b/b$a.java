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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

final class b$a
  extends AsyncTask<Void, Void, int[]>
  implements com.davemorrissey.labs.subscaleview.c.b
{
  private final WeakReference<SubsamplingScaleImageView> aqT;
  private final WeakReference<Context> aqU;
  private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aqV;
  private final Uri aqW;
  private c aqY;
  private long aqZ;
  private d ara;
  private Exception exception;
  
  b$a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri)
  {
    AppMethodBeat.i(115621);
    this.aqT = new WeakReference(paramSubsamplingScaleImageView);
    this.aqU = new WeakReference(paramContext);
    this.aqV = new WeakReference(paramb);
    this.aqW = paramUri;
    AppMethodBeat.o(115621);
  }
  
  private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView)
  {
    AppMethodBeat.i(115623);
    if ((paramSubsamplingScaleImageView != null) && (this.aqZ != -1L)) {
      paramSubsamplingScaleImageView.cO((int)(System.currentTimeMillis() - this.aqZ));
    }
    AppMethodBeat.o(115623);
  }
  
  @SuppressLint({"LongLogTag"})
  private int[] lp()
  {
    AppMethodBeat.i(115622);
    ab.d("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask doInBackground");
    this.aqZ = System.currentTimeMillis();
    try
    {
      Object localObject1 = this.aqW.toString();
      Context localContext = (Context)this.aqU.get();
      Object localObject2 = (com.davemorrissey.labs.subscaleview.a.b)this.aqV.get();
      SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.aqT.get();
      if ((localContext != null) && (localObject2 != null) && (localSubsamplingScaleImageView != null))
      {
        this.ara = ((d)((com.davemorrissey.labs.subscaleview.a.b)localObject2).ll());
        localObject2 = this.ara.c(localContext, this.aqW);
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
        AppMethodBeat.o(115622);
        return new int[] { j, i, n };
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      ab.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
      this.exception = localFileNotFoundException;
      this.aqY = new c(1, "tile init file not found");
      a((SubsamplingScaleImageView)this.aqT.get());
      AppMethodBeat.o(115622);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
        this.exception = localException;
        this.aqY = new c(4, "tile init failed");
      }
    }
  }
  
  public final void cancel() {}
  
  public final void lo()
  {
    AppMethodBeat.i(115624);
    executeOnExecutor(((SubsamplingScaleImageView)this.aqT.get()).executor, new Void[0]);
    AppMethodBeat.o(115624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.b.a
 * JD-Core Version:    0.7.0.1
 */