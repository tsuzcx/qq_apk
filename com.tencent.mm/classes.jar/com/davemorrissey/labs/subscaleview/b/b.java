package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

public final class b
  implements com.davemorrissey.labs.subscaleview.c.c
{
  public final com.davemorrissey.labs.subscaleview.c.b a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri)
  {
    AppMethodBeat.i(157362);
    paramSubsamplingScaleImageView = new a(paramSubsamplingScaleImageView, paramContext, paramb, paramUri);
    AppMethodBeat.o(157362);
    return paramSubsamplingScaleImageView;
  }
  
  static final class a
    extends AsyncTask<Void, Void, int[]>
    implements com.davemorrissey.labs.subscaleview.c.b
  {
    private final WeakReference<Context> aWF;
    private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aWG;
    private final Uri aWH;
    private com.davemorrissey.labs.subscaleview.a.c aWJ;
    private long aWK;
    private d aWL;
    private Exception exception;
    private final WeakReference<SubsamplingScaleImageView> oi;
    
    a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri)
    {
      AppMethodBeat.i(157356);
      this.oi = new WeakReference(paramSubsamplingScaleImageView);
      this.aWF = new WeakReference(paramContext);
      this.aWG = new WeakReference(paramb);
      this.aWH = paramUri;
      AppMethodBeat.o(157356);
    }
    
    private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView)
    {
      AppMethodBeat.i(157358);
      if ((paramSubsamplingScaleImageView != null) && (this.aWK != -1L)) {
        paramSubsamplingScaleImageView.dx((int)(System.currentTimeMillis() - this.aWK));
      }
      AppMethodBeat.o(157358);
    }
    
    @SuppressLint({"LongLogTag"})
    private int[] rK()
    {
      AppMethodBeat.i(157357);
      Log.d("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask doInBackground");
      this.aWK = System.currentTimeMillis();
      try
      {
        Object localObject1 = (Context)this.aWF.get();
        Object localObject2 = (com.davemorrissey.labs.subscaleview.a.b)this.aWG.get();
        SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.oi.get();
        if ((localObject1 != null) && (localObject2 != null) && (localSubsamplingScaleImageView != null))
        {
          this.aWL = ((d)((com.davemorrissey.labs.subscaleview.a.b)localObject2).rG());
          localObject2 = this.aWL.d((Context)localObject1, this.aWH);
          int k = ((Point)localObject2).x;
          int m = ((Point)localObject2).y;
          int n = localSubsamplingScaleImageView.e((Context)localObject1, this.aWH);
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
          AppMethodBeat.o(157357);
          return new int[] { j, i, n };
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Log.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
        this.exception = localFileNotFoundException;
        this.aWJ = new com.davemorrissey.labs.subscaleview.a.c(1, "tile init file not found");
        a((SubsamplingScaleImageView)this.oi.get());
        AppMethodBeat.o(157357);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
          this.exception = localException;
          this.aWJ = new com.davemorrissey.labs.subscaleview.a.c(4, "tile init failed");
        }
      }
    }
    
    public final void cancel() {}
    
    public final void rJ()
    {
      AppMethodBeat.i(157359);
      executeOnExecutor(((SubsamplingScaleImageView)this.oi.get()).executor, new Void[0]);
      AppMethodBeat.o(157359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.b
 * JD-Core Version:    0.7.0.1
 */