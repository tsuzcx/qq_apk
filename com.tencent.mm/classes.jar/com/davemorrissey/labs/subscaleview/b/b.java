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
import com.tencent.mm.sdk.platformtools.ac;
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
    private com.davemorrissey.labs.subscaleview.a.c aMA;
    private long aMB;
    private d aMC;
    private final WeakReference<Context> aMw;
    private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aMx;
    private final Uri aMy;
    private Exception exception;
    private final WeakReference<SubsamplingScaleImageView> mn;
    
    a(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, com.davemorrissey.labs.subscaleview.a.b<? extends d> paramb, Uri paramUri)
    {
      AppMethodBeat.i(157356);
      this.mn = new WeakReference(paramSubsamplingScaleImageView);
      this.aMw = new WeakReference(paramContext);
      this.aMx = new WeakReference(paramb);
      this.aMy = paramUri;
      AppMethodBeat.o(157356);
    }
    
    private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView)
    {
      AppMethodBeat.i(157358);
      if ((paramSubsamplingScaleImageView != null) && (this.aMB != -1L)) {
        paramSubsamplingScaleImageView.dy((int)(System.currentTimeMillis() - this.aMB));
      }
      AppMethodBeat.o(157358);
    }
    
    @SuppressLint({"LongLogTag"})
    private int[] qj()
    {
      AppMethodBeat.i(157357);
      ac.d("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask doInBackground");
      this.aMB = System.currentTimeMillis();
      try
      {
        Object localObject1 = this.aMy.toString();
        Context localContext = (Context)this.aMw.get();
        Object localObject2 = (com.davemorrissey.labs.subscaleview.a.b)this.aMx.get();
        SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.mn.get();
        if ((localContext != null) && (localObject2 != null) && (localSubsamplingScaleImageView != null))
        {
          this.aMC = ((d)((com.davemorrissey.labs.subscaleview.a.b)localObject2).qf());
          localObject2 = this.aMC.c(localContext, this.aMy);
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
          AppMethodBeat.o(157357);
          return new int[] { j, i, n };
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        ac.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
        this.exception = localFileNotFoundException;
        this.aMA = new com.davemorrissey.labs.subscaleview.a.c(1, "tile init file not found");
        a((SubsamplingScaleImageView)this.mn.get());
        AppMethodBeat.o(157357);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
          this.exception = localException;
          this.aMA = new com.davemorrissey.labs.subscaleview.a.c(4, "tile init failed");
        }
      }
    }
    
    public final void cancel() {}
    
    public final void qi()
    {
      AppMethodBeat.i(157359);
      executeOnExecutor(((SubsamplingScaleImageView)this.mn.get()).executor, new Void[0]);
      AppMethodBeat.o(157359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.b
 * JD-Core Version:    0.7.0.1
 */