package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private static Point a(ArrayList<Camera.Size> paramArrayList, Point paramPoint, boolean paramBoolean, int paramInt)
  {
    int i = paramPoint.x;
    int j = paramPoint.y;
    if (j * paramInt % i != 0) {
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
          y.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          return new Point(i, j);
        }
        if (Math.min(paramPoint.width, paramPoint.height) < paramInt) {
          return null;
        }
      }
      return null;
      i = paramInt;
    }
  }
  
  public static g.b a(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    return b(paramParameters, paramPoint, paramInt, paramBoolean);
  }
  
  public static g.b b(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject1, new g.a((byte)0));
    new ArrayList(paramParameters.getSupportedPictureSizes());
    y.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[] { d.bQ((List)localObject1) });
    float f = paramPoint.x / paramPoint.y;
    y.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(0) });
    y.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bk.fQ(ae.getContext())) });
    paramParameters = new g.b();
    paramParameters.jkk = a((ArrayList)localObject1, paramPoint, paramBoolean, paramInt);
    if (paramParameters.jkk != null)
    {
      paramParameters.mhq = d.a(paramPoint, paramParameters.jkk, paramBoolean);
      paramParameters.mhr = d.a(paramPoint, paramParameters.jkk, paramBoolean, true);
      paramInt = 0;
    }
    for (;;)
    {
      y.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d", new Object[] { paramParameters.jkk, paramParameters.mhq, Integer.valueOf(paramInt) });
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
            y.i("MicroMsg.MMSightCameraInfo", "exclude square curSize: %s", new Object[] { localPoint });
          }
          else
          {
            localObject2 = d.a(paramPoint, localPoint, paramBoolean);
            if (localObject2 == null)
            {
              y.i("MicroMsg.MMSightCameraInfo", "curSize: %s, can not find crop size", new Object[] { localPoint });
            }
            else
            {
              y.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", new Object[] { localPoint, localObject2 });
              paramParameters.mht = new Point(((Point)localObject2).x, ((Point)localObject2).y);
              paramParameters.mhs = new Point(localPoint.x, localPoint.y);
              paramParameters.mhu = d.a(paramPoint, localPoint, paramBoolean, true);
              if (Math.min(((Point)localObject2).x, ((Point)localObject2).y) <= paramInt)
              {
                if (Math.min(((Point)localObject2).x, ((Point)localObject2).y) < 0) {
                  return null;
                }
                localPoint = new Point(localPoint.x, localPoint.y);
                paramParameters.jkk = localPoint;
                paramParameters.mhq = ((Point)localObject2);
                paramParameters.mhr = d.a(paramPoint, paramParameters.jkk, paramBoolean, true);
                y.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", new Object[] { localPoint, localObject2, Integer.valueOf(1) });
                paramInt = 1;
                break;
              }
            }
          }
        }
      }
      paramInt = 0;
    }
  }
  
  public static g.b c(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new g.a((byte)0));
    new ArrayList(paramParameters.getSupportedPictureSizes());
    y.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[] { d.bQ((List)localObject) });
    float f = paramPoint.x / paramPoint.y;
    y.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt) });
    y.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bk.fQ(ae.getContext())) });
    paramParameters = new g.b();
    paramParameters.jkk = a((ArrayList)localObject, paramPoint, paramBoolean, paramInt);
    if (paramParameters.jkk != null)
    {
      paramParameters.mhq = d.b(paramPoint, paramParameters.jkk, paramBoolean);
      paramParameters.mhr = d.b(paramPoint, paramParameters.jkk, paramBoolean, true);
    }
    for (;;)
    {
      y.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", new Object[] { paramParameters.jkk, paramParameters.mhq, Integer.valueOf(0) });
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
        paramParameters.jkk = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.g
 * JD-Core Version:    0.7.0.1
 */