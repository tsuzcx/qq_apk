package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.map.lib.models.ScatterPlotInfo;
import com.tencent.map.sdk.utilities.visualization.scatterplot.BitmapScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.DotScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import java.util.ArrayList;
import java.util.List;

public class nk
  extends ScatterPlotInfo
  implements mo
{
  ScatterPlotOverlayProvider a;
  
  public nk(Context paramContext, ScatterPlotOverlayProvider paramScatterPlotOverlayProvider)
  {
    AppMethodBeat.i(221631);
    this.a = paramScatterPlotOverlayProvider;
    Object localObject = new ArrayList();
    ((List)localObject).add(paramScatterPlotOverlayProvider.getData());
    setDataList((List)localObject);
    this.visible = paramScatterPlotOverlayProvider.isVisibility();
    this.opacity = paramScatterPlotOverlayProvider.getOpacity();
    this.maxZoom = paramScatterPlotOverlayProvider.getMaxZoom();
    this.minZoom = paramScatterPlotOverlayProvider.getMinZoom();
    this.draw3D = paramScatterPlotOverlayProvider.isEnable3D();
    this.level = paramScatterPlotOverlayProvider.getDisplayLevel();
    this.mType = paramScatterPlotOverlayProvider.getType();
    this.zIndex = paramScatterPlotOverlayProvider.getZIndex();
    if ((paramScatterPlotOverlayProvider instanceof DotScatterPlotOverlayProvider))
    {
      paramContext = (DotScatterPlotOverlayProvider)paramScatterPlotOverlayProvider;
      this.radius = paramContext.getRadius();
      this.colors = paramContext.getColors();
      this.mAnimate = paramContext.isAnimate();
      AppMethodBeat.o(221631);
      return;
    }
    if ((paramScatterPlotOverlayProvider instanceof BitmapScatterPlotOverlayProvider))
    {
      BitmapScatterPlotOverlayProvider localBitmapScatterPlotOverlayProvider = (BitmapScatterPlotOverlayProvider)paramScatterPlotOverlayProvider;
      this.mBitmapWidth = localBitmapScatterPlotOverlayProvider.getWidth();
      this.mBitmapHeight = localBitmapScatterPlotOverlayProvider.getHeight();
      if ((localBitmapScatterPlotOverlayProvider.getBitmaps() != null) && (localBitmapScatterPlotOverlayProvider.getBitmaps().length > 0))
      {
        this.mBitmaps = new Bitmap[localBitmapScatterPlotOverlayProvider.getBitmaps().length];
        int i = 0;
        if (i < localBitmapScatterPlotOverlayProvider.getBitmaps().length)
        {
          paramScatterPlotOverlayProvider = localBitmapScatterPlotOverlayProvider.getBitmaps()[i];
          if (paramScatterPlotOverlayProvider != null)
          {
            localObject = paramScatterPlotOverlayProvider.getBitmap(paramContext);
            paramScatterPlotOverlayProvider = (ScatterPlotOverlayProvider)localObject;
            if (localObject != null) {
              if (this.mBitmapWidth == ((Bitmap)localObject).getWidth())
              {
                paramScatterPlotOverlayProvider = (ScatterPlotOverlayProvider)localObject;
                if (this.mBitmapHeight == ((Bitmap)localObject).getHeight()) {}
              }
              else
              {
                int j = this.mBitmapWidth;
                int k = this.mBitmapHeight;
                int m = ((Bitmap)localObject).getWidth();
                int n = ((Bitmap)localObject).getHeight();
                float f1 = j / m;
                float f2 = k / n;
                paramScatterPlotOverlayProvider = new Matrix();
                paramScatterPlotOverlayProvider.postScale(f1, f2);
                paramScatterPlotOverlayProvider = Bitmap.createBitmap((Bitmap)localObject, 0, 0, m, n, paramScatterPlotOverlayProvider, true);
              }
            }
            this.mBitmaps[i] = paramScatterPlotOverlayProvider;
          }
          for (;;)
          {
            i += 1;
            break;
            this.mBitmaps[i] = null;
          }
        }
      }
    }
    AppMethodBeat.o(221631);
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221640);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
    AppMethodBeat.o(221640);
    return paramBitmap;
  }
  
  private ScatterPlotOverlayProvider a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.nk
 * JD-Core Version:    0.7.0.1
 */