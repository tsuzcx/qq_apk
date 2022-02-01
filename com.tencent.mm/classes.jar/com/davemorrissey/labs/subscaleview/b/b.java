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
import com.tencent.mm.sdk.platformtools.ae;
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
    private final WeakReference<Context> aWN;
    private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aWO;
    private final Uri aWP;
    private com.davemorrissey.labs.subscaleview.a.c aWR;
    private long aWS;
    private d aWT;
    private Exception exception;
    private final WeakReference<SubsamplingScaleImageView> og;
    
    a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri)
    {
      AppMethodBeat.i(157356);
      this.og = new WeakReference(paramSubsamplingScaleImageView);
      this.aWN = new WeakReference(paramContext);
      this.aWO = new WeakReference(paramb);
      this.aWP = paramUri;
      AppMethodBeat.o(157356);
    }
    
    private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView)
    {
      AppMethodBeat.i(157358);
      if ((paramSubsamplingScaleImageView != null) && (this.aWS != -1L)) {
        paramSubsamplingScaleImageView.dC((int)(System.currentTimeMillis() - this.aWS));
      }
      AppMethodBeat.o(157358);
    }
    
    @SuppressLint({"LongLogTag"})
    private int[] rH()
    {
      AppMethodBeat.i(157357);
      ae.d("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask doInBackground");
      this.aWS = System.currentTimeMillis();
      try
      {
        Object localObject1 = (Context)this.aWN.get();
        Object localObject2 = (com.davemorrissey.labs.subscaleview.a.b)this.aWO.get();
        SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.og.get();
        if ((localObject1 != null) && (localObject2 != null) && (localSubsamplingScaleImageView != null))
        {
          this.aWT = ((d)((com.davemorrissey.labs.subscaleview.a.b)localObject2).rD());
          localObject2 = this.aWT.c((Context)localObject1, this.aWP);
          int k = ((Point)localObject2).x;
          int m = ((Point)localObject2).y;
          int n = localSubsamplingScaleImageView.d((Context)localObject1, this.aWP);
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
        ae.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
        this.exception = localFileNotFoundException;
        this.aWR = new com.davemorrissey.labs.subscaleview.a.c(1, "tile init file not found");
        a((SubsamplingScaleImageView)this.og.get());
        AppMethodBeat.o(157357);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
          this.exception = localException;
          this.aWR = new com.davemorrissey.labs.subscaleview.a.c(4, "tile init failed");
        }
      }
    }
    
    public final void cancel() {}
    
    public final void rG()
    {
      AppMethodBeat.i(157359);
      executeOnExecutor(((SubsamplingScaleImageView)this.og.get()).executor, new Void[0]);
      AppMethodBeat.o(157359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.b
 * JD-Core Version:    0.7.0.1
 */