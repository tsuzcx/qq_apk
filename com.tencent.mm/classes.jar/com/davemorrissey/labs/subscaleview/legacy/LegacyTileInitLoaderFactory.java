package com.davemorrissey.labs.subscaleview.legacy;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.model.ILoadable;
import com.davemorrissey.labs.subscaleview.model.ITileInitLoaderFactory;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

public final class LegacyTileInitLoaderFactory
  implements ITileInitLoaderFactory
{
  public final ILoadable newInstance(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, DecoderFactory<? extends ImageRegionDecoder> paramDecoderFactory, Uri paramUri)
  {
    AppMethodBeat.i(157362);
    paramSubsamplingScaleImageView = new LegacyTilesInitTaskWrapper(paramSubsamplingScaleImageView, paramContext, paramDecoderFactory, paramUri);
    AppMethodBeat.o(157362);
    return paramSubsamplingScaleImageView;
  }
  
  static final class LegacyTilesInitTaskWrapper
    extends AsyncTask<Void, Void, int[]>
    implements ILoadable
  {
    private final WeakReference<Context> contextRef;
    private ImageDecodeResult decodeResult;
    private ImageRegionDecoder decoder;
    private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
    private Exception exception;
    private long mStartLoadTime;
    private final Uri source;
    private final WeakReference<SubsamplingScaleImageView> viewRef;
    
    LegacyTilesInitTaskWrapper(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, DecoderFactory<? extends ImageRegionDecoder> paramDecoderFactory, Uri paramUri)
    {
      AppMethodBeat.i(157356);
      this.viewRef = new WeakReference(paramSubsamplingScaleImageView);
      this.contextRef = new WeakReference(paramContext);
      this.decoderFactoryRef = new WeakReference(paramDecoderFactory);
      this.source = paramUri;
      AppMethodBeat.o(157356);
    }
    
    private int[] bZc()
    {
      AppMethodBeat.i(157357);
      Log.d("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask doInBackground");
      this.mStartLoadTime = System.currentTimeMillis();
      try
      {
        Object localObject1 = (Context)this.contextRef.get();
        Object localObject2 = (DecoderFactory)this.decoderFactoryRef.get();
        SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.viewRef.get();
        if ((localObject1 != null) && (localObject2 != null) && (localSubsamplingScaleImageView != null))
        {
          this.decoder = ((ImageRegionDecoder)((DecoderFactory)localObject2).make());
          localObject2 = this.decoder.init((Context)localObject1, this.source);
          int k = ((Point)localObject2).x;
          int m = ((Point)localObject2).y;
          int n = localSubsamplingScaleImageView.getExifOrientation((Context)localObject1, this.source);
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
          onEnd(localSubsamplingScaleImageView);
          AppMethodBeat.o(157357);
          return new int[] { j, i, n };
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Log.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
        this.exception = localFileNotFoundException;
        this.decodeResult = new ImageDecodeResult(1, "tile init file not found");
        onEnd((SubsamplingScaleImageView)this.viewRef.get());
        AppMethodBeat.o(157357);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", localException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
          this.exception = localException;
          this.decodeResult = new ImageDecodeResult(4, "tile init failed");
        }
      }
    }
    
    private void onEnd(SubsamplingScaleImageView paramSubsamplingScaleImageView)
    {
      AppMethodBeat.i(157358);
      if ((paramSubsamplingScaleImageView != null) && (this.mStartLoadTime != -1L)) {
        paramSubsamplingScaleImageView.addTileInitTime((int)(System.currentTimeMillis() - this.mStartLoadTime));
      }
      AppMethodBeat.o(157358);
    }
    
    public final void cancel() {}
    
    public final void startLoad()
    {
      AppMethodBeat.i(157359);
      executeOnExecutor(((SubsamplingScaleImageView)this.viewRef.get()).executor, new Void[0]);
      AppMethodBeat.o(157359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.legacy.LegacyTileInitLoaderFactory
 * JD-Core Version:    0.7.0.1
 */