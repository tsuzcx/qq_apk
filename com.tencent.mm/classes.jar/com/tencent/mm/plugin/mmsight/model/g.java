package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private static Point a(ArrayList<Camera.Size> paramArrayList, Point paramPoint, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(76517);
    int i = paramPoint.x;
    int j = paramPoint.y;
    if (j * paramInt % i != 0)
    {
      AppMethodBeat.o(76517);
      return null;
    }
    j = j * paramInt / i;
    if (paramBoolean)
    {
      i = paramInt ^ j;
      j = i ^ j;
      i ^= j;
    }
    for (;;)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramPoint = (Camera.Size)paramArrayList.next();
        if ((paramPoint.width == i) && (paramPoint.height == j))
        {
          ab.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          paramArrayList = new Point(i, j);
          AppMethodBeat.o(76517);
          return paramArrayList;
        }
        if (Math.min(paramPoint.width, paramPoint.height) < paramInt)
        {
          AppMethodBeat.o(76517);
          return null;
        }
      }
      AppMethodBeat.o(76517);
      return null;
      i = paramInt;
    }
  }
  
  public static g.b a(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(76514);
    Object localObject1 = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject1, new g.a((byte)0));
    new ArrayList(paramParameters.getSupportedPictureSizes());
    ab.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[] { d.co((List)localObject1) });
    float f = paramPoint.x / paramPoint.y;
    ab.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(0) });
    ab.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bo.hg(ah.getContext())) });
    paramParameters = new g.b();
    paramParameters.oHu = a((ArrayList)localObject1, paramPoint, paramBoolean, paramInt);
    if (paramParameters.oHu != null)
    {
      paramParameters.oHv = d.a(paramPoint, paramParameters.oHu, paramBoolean);
      paramParameters.oHw = d.a(paramPoint, paramParameters.oHu, paramBoolean, true);
      paramInt = 0;
    }
    for (;;)
    {
      ab.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d", new Object[] { paramParameters.oHu, paramParameters.oHv, Integer.valueOf(paramInt) });
      AppMethodBeat.o(76514);
      return paramParameters;
      Point localPoint = new Point();
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Camera.Size)((Iterator)localObject1).next();
          localPoint.x = ((Camera.Size)localObject2).width;
          localPoint.y = ((Camera.Size)localObject2).height;
          if (localPoint.x == localPoint.y)
          {
            ab.i("MicroMsg.MMSightCameraInfo", "exclude square curSize: %s", new Object[] { localPoint });
          }
          else
          {
            ab.i("MicroMsg.MMSightCameraInfo", "cursize is %s * %s , and isRotate %s, screenRes.x %s, screenRes.y %s", new Object[] { Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Boolean.valueOf(paramBoolean), Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
            if (paramPoint.y > paramPoint.x)
            {
              if (localPoint.y >= localPoint.x) {
                ab.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio  1 and unSupport preview is %s * %s", new Object[] { Integer.valueOf(((Camera.Size)localObject2).height), Integer.valueOf(((Camera.Size)localObject2).width) });
              }
            }
            else if (localPoint.x >= localPoint.y)
            {
              ab.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio 2 and unSupport preview is %s * %s", new Object[] { Integer.valueOf(((Camera.Size)localObject2).height), Integer.valueOf(((Camera.Size)localObject2).width) });
              continue;
            }
            localObject2 = d.a(paramPoint, localPoint, paramBoolean);
            if (localObject2 == null)
            {
              ab.i("MicroMsg.MMSightCameraInfo", "curSize: %s, can not find crop size", new Object[] { localPoint });
            }
            else
            {
              ab.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", new Object[] { localPoint, localObject2 });
              paramParameters.oHy = new Point(((Point)localObject2).x, ((Point)localObject2).y);
              paramParameters.oHx = new Point(localPoint.x, localPoint.y);
              paramParameters.oHz = d.a(paramPoint, localPoint, paramBoolean, true);
              if (Math.min(((Point)localObject2).x, ((Point)localObject2).y) <= paramInt)
              {
                if (Math.min(((Point)localObject2).x, ((Point)localObject2).y) < 0)
                {
                  AppMethodBeat.o(76514);
                  return null;
                }
                localPoint = new Point(localPoint.x, localPoint.y);
                paramParameters.oHu = localPoint;
                paramParameters.oHv = ((Point)localObject2);
                paramParameters.oHw = d.a(paramPoint, paramParameters.oHu, paramBoolean, true);
                paramInt = 1;
                ab.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", new Object[] { localPoint, localObject2, Integer.valueOf(1) });
                break;
              }
            }
          }
        }
      }
      paramInt = 0;
    }
  }
  
  public static g.b b(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(76515);
    Object localObject1 = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject1, new g.a((byte)0));
    ab.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[] { d.co((List)localObject1) });
    float f = paramPoint.x / paramPoint.y;
    ab.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(0) });
    ab.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bo.hg(ah.getContext())) });
    paramParameters = new g.b();
    Point localPoint = new Point();
    paramInt = (int)(paramInt * 1.05F);
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Camera.Size)((Iterator)localObject1).next();
      if (((Camera.Size)localObject2).height <= paramInt + 64)
      {
        localPoint.x = ((Camera.Size)localObject2).width;
        localPoint.y = ((Camera.Size)localObject2).height;
        ab.i("MicroMsg.MMSightCameraInfo", "cursize is %s * %s , and isRotate %s, screenRes.x %s, screenRes.y %s", new Object[] { Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Boolean.valueOf(paramBoolean), Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
        if (paramPoint.y > paramPoint.x)
        {
          if (localPoint.y >= localPoint.x) {
            ab.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio  1 and unSupport preview is %s * %s", new Object[] { Integer.valueOf(((Camera.Size)localObject2).height), Integer.valueOf(((Camera.Size)localObject2).width) });
          }
        }
        else if (localPoint.x >= localPoint.y)
        {
          ab.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio 2 and unSupport preview is %s * %s", new Object[] { Integer.valueOf(((Camera.Size)localObject2).height), Integer.valueOf(((Camera.Size)localObject2).width) });
          continue;
        }
        localObject2 = d.a(paramPoint, localPoint, paramBoolean, false);
        if (localObject2 != null)
        {
          ab.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", new Object[] { localPoint, localObject2 });
          paramParameters.oHy = new Point(((Point)localObject2).x, ((Point)localObject2).y);
          paramParameters.oHx = new Point(localPoint.x, localPoint.y);
          paramParameters.oHz = d.a(paramPoint, localPoint, paramBoolean, true);
          localPoint = new Point(localPoint.x, localPoint.y);
          paramParameters.oHu = localPoint;
          paramParameters.oHv = ((Point)localObject2);
          paramParameters.oHw = d.a(paramPoint, paramParameters.oHu, paramBoolean, true);
          ab.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", new Object[] { localPoint, localObject2, Integer.valueOf(1) });
          AppMethodBeat.o(76515);
          return paramParameters;
        }
      }
    }
    ab.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with crop width", new Object[] { paramParameters.oHu, paramParameters.oHv, Integer.valueOf(0) });
    AppMethodBeat.o(76515);
    return paramParameters;
  }
  
  public static g.b c(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(76516);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new g.a((byte)0));
    new ArrayList(paramParameters.getSupportedPictureSizes());
    ab.i("MicroMsg.MMSightCameraInfo", "tryFindPreviewSizeAnyWay supportedPreviewSizes: %s", new Object[] { d.co((List)localObject) });
    float f = paramPoint.x / paramPoint.y;
    ab.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt) });
    ab.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bo.hg(ah.getContext())) });
    paramParameters = new g.b();
    paramParameters.oHu = a((ArrayList)localObject, paramPoint, paramBoolean, paramInt);
    if (paramParameters.oHu != null)
    {
      paramParameters.oHv = d.b(paramPoint, paramParameters.oHu, paramBoolean);
      paramParameters.oHw = d.b(paramPoint, paramParameters.oHu, paramBoolean, true);
    }
    for (;;)
    {
      ab.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", new Object[] { paramParameters.oHu, paramParameters.oHv, Integer.valueOf(0) });
      AppMethodBeat.o(76516);
      return paramParameters;
      Point localPoint = new Point();
      Math.min(paramPoint.x, paramPoint.y);
      Math.max(paramPoint.x, paramPoint.y);
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
        localPoint.x = localSize.width;
        localPoint.y = localSize.height;
        if ((localPoint.x == localPoint.y) || (Math.min(localPoint.x, localPoint.y) > paramInt) || (Math.max(localPoint.x, localPoint.y) > 2000) || (d.b(paramPoint, localPoint, paramBoolean) == null)) {
          break;
        }
        paramParameters.oHu = null;
      }
    }
  }
  
  public static g.b d(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(76518);
    paramParameters = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort(paramParameters, new g.a((byte)0));
    ab.i("MicroMsg.MMSightCameraInfo", "findPreviewSizeWithoutCrop supportedPreviewSizes: %s", new Object[] { d.co(paramParameters) });
    float f = paramPoint.x / paramPoint.y;
    ab.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s ", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt) });
    ab.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bo.hg(ah.getContext())) });
    g.b localb = new g.b();
    paramInt = (int)(paramInt * 1.05F);
    paramParameters = paramParameters.iterator();
    Object localObject;
    while (paramParameters.hasNext())
    {
      localObject = (Camera.Size)paramParameters.next();
      if ((((Camera.Size)localObject).height <= paramInt + 64) && (((Camera.Size)localObject).width <= 2000))
      {
        paramParameters = new Point();
        paramParameters.x = ((Camera.Size)localObject).width;
        paramParameters.y = ((Camera.Size)localObject).height;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s ", new Object[] { paramParameters });
      localb.oHy = new Point(paramParameters.x, paramParameters.y);
      localb.oHx = new Point(paramParameters.x, paramParameters.y);
      localb.oHz = d.a(paramPoint, paramParameters, paramBoolean, true);
      localObject = new Point(paramParameters.x, paramParameters.y);
      localb.oHu = ((Point)localObject);
      localb.oHv = paramParameters;
      localb.oHw = d.a(paramPoint, localb.oHu, paramBoolean, true);
      ab.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s ", new Object[] { localObject, paramParameters });
      AppMethodBeat.o(76518);
      return localb;
      paramParameters = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.g
 * JD-Core Version:    0.7.0.1
 */