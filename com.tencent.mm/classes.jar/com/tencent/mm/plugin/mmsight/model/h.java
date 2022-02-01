package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private static Point a(ArrayList<Camera.Size> paramArrayList, Point paramPoint, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(89415);
    int i = paramPoint.x;
    int j = paramPoint.y;
    if (j * paramInt % i != 0)
    {
      AppMethodBeat.o(89415);
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
          ad.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          paramArrayList = new Point(i, j);
          AppMethodBeat.o(89415);
          return paramArrayList;
        }
        if (Math.min(paramPoint.width, paramPoint.height) < paramInt)
        {
          AppMethodBeat.o(89415);
          return null;
        }
      }
      AppMethodBeat.o(89415);
      return null;
      i = paramInt;
    }
  }
  
  public static c a(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(186113);
    paramParameters = b(paramParameters, paramPoint, paramInt, paramBoolean);
    AppMethodBeat.o(186113);
    return paramParameters;
  }
  
  public static c a(Size[] paramArrayOfSize, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(89413);
    Arrays.sort(paramArrayOfSize, new h.a((byte)0));
    ad.i("MicroMsg.MMSightCameraInfo", "tryFindPreviewSizeAnyWay supportedPreviewSizes: %s", new Object[] { d.a(paramArrayOfSize) });
    float f = paramPoint.x / paramPoint.y;
    ad.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt) });
    ad.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bt.iJ(aj.getContext())) });
    c localc = new c();
    int i = paramPoint.x;
    int j = paramPoint.y;
    if (j * paramInt % i == 0)
    {
      j = j * paramInt / i;
      if (!paramBoolean) {
        break label531;
      }
      i = paramInt ^ j;
      j ^= i;
      i ^= j;
    }
    for (;;)
    {
      int m = paramArrayOfSize.length;
      int k = 0;
      Object localObject;
      if (k < m)
      {
        localObject = paramArrayOfSize[k];
        if ((((Size)localObject).getWidth() == i) && (((Size)localObject).getHeight() == j))
        {
          ad.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          localObject = new Point(i, j);
          label261:
          localc.tCB = ((Point)localObject);
          if (localc.tCB == null) {
            break label381;
          }
          localc.tCC = d.b(paramPoint, localc.tCB, paramBoolean);
          localc.tCD = d.b(paramPoint, localc.tCB, paramBoolean, true);
        }
      }
      label529:
      for (;;)
      {
        ad.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", new Object[] { localc.tCB, localc.tCC, Integer.valueOf(0) });
        AppMethodBeat.o(89413);
        return localc;
        if (Math.min(((Size)localObject).getWidth(), ((Size)localObject).getHeight()) >= paramInt)
        {
          k += 1;
          break;
        }
        localObject = null;
        break label261;
        label381:
        localObject = new Point();
        Math.min(paramPoint.x, paramPoint.y);
        Math.max(paramPoint.x, paramPoint.y);
        j = paramArrayOfSize.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label529;
          }
          Size localSize = paramArrayOfSize[i];
          ((Point)localObject).x = localSize.getWidth();
          ((Point)localObject).y = localSize.getHeight();
          if ((((Point)localObject).x != ((Point)localObject).y) && (Math.min(((Point)localObject).x, ((Point)localObject).y) <= paramInt) && (Math.max(((Point)localObject).x, ((Point)localObject).y) <= 2000) && (d.b(paramPoint, (Point)localObject, paramBoolean) != null))
          {
            localc.tCB = null;
            break;
          }
          i += 1;
        }
      }
      label531:
      i = paramInt;
    }
  }
  
  public static c b(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(185470);
    Object localObject1 = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject1, new b((byte)0));
    new ArrayList(paramParameters.getSupportedPictureSizes());
    ad.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[] { d.eh((List)localObject1) });
    float f = paramPoint.x / paramPoint.y;
    ad.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(0) });
    ad.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bt.iJ(aj.getContext())) });
    paramParameters = new c();
    paramParameters.tCB = a((ArrayList)localObject1, paramPoint, paramBoolean, paramInt);
    if (paramParameters.tCB != null)
    {
      paramParameters.tCC = d.a(paramPoint, paramParameters.tCB, paramBoolean);
      paramParameters.tCD = d.a(paramPoint, paramParameters.tCB, paramBoolean, true);
      paramInt = 0;
    }
    for (;;)
    {
      ad.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d", new Object[] { paramParameters.tCB, paramParameters.tCC, Integer.valueOf(paramInt) });
      AppMethodBeat.o(185470);
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
            ad.i("MicroMsg.MMSightCameraInfo", "exclude square curSize: %s", new Object[] { localPoint });
          }
          else
          {
            ad.i("MicroMsg.MMSightCameraInfo", "cursize is %s * %s , and isRotate %s, screenRes.x %s, screenRes.y %s", new Object[] { Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Boolean.valueOf(paramBoolean), Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
            if (paramPoint.y > paramPoint.x)
            {
              if (localPoint.y >= localPoint.x) {
                ad.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio  1 and unSupport preview is %s * %s", new Object[] { Integer.valueOf(((Camera.Size)localObject2).height), Integer.valueOf(((Camera.Size)localObject2).width) });
              }
            }
            else if (localPoint.x >= localPoint.y)
            {
              ad.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio 2 and unSupport preview is %s * %s", new Object[] { Integer.valueOf(((Camera.Size)localObject2).height), Integer.valueOf(((Camera.Size)localObject2).width) });
              continue;
            }
            localObject2 = d.a(paramPoint, localPoint, paramBoolean);
            if (localObject2 == null)
            {
              ad.i("MicroMsg.MMSightCameraInfo", "curSize: %s, can not find crop size", new Object[] { localPoint });
            }
            else
            {
              ad.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", new Object[] { localPoint, localObject2 });
              paramParameters.tCF = new Point(((Point)localObject2).x, ((Point)localObject2).y);
              paramParameters.tCE = new Point(localPoint.x, localPoint.y);
              paramParameters.tCG = d.a(paramPoint, localPoint, paramBoolean, true);
              if (Math.min(((Point)localObject2).x, ((Point)localObject2).y) <= paramInt)
              {
                if (Math.min(((Point)localObject2).x, ((Point)localObject2).y) < 0)
                {
                  AppMethodBeat.o(185470);
                  return null;
                }
                localPoint = new Point(localPoint.x, localPoint.y);
                paramParameters.tCB = localPoint;
                paramParameters.tCC = ((Point)localObject2);
                paramParameters.tCD = d.a(paramPoint, paramParameters.tCB, paramBoolean, true);
                paramInt = 1;
                ad.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", new Object[] { localPoint, localObject2, Integer.valueOf(1) });
                break;
              }
            }
          }
        }
      }
      paramInt = 0;
    }
  }
  
  public static c b(Size[] paramArrayOfSize, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(89417);
    Arrays.sort(paramArrayOfSize, new h.a((byte)0));
    ad.i("MicroMsg.MMSightCameraInfo", "findPreviewSizeWithoutCrop supportedPreviewSizes: %s", new Object[] { d.a(paramArrayOfSize) });
    float f = paramPoint.x / paramPoint.y;
    ad.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s ", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt) });
    ad.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bt.iJ(aj.getContext())) });
    c localc = new c();
    Object localObject2 = null;
    int i = (int)(paramInt * 1.05F);
    int j = paramArrayOfSize.length;
    paramInt = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (paramInt < j)
      {
        Size localSize = paramArrayOfSize[paramInt];
        if ((localSize.getHeight() <= i + 64) && (localSize.getWidth() <= 2000))
        {
          localObject1 = new Point();
          ((Point)localObject1).x = localSize.getWidth();
          ((Point)localObject1).y = localSize.getHeight();
        }
      }
      else
      {
        ad.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s ", new Object[] { localObject1 });
        localc.tCF = new Point(((Point)localObject1).x, ((Point)localObject1).y);
        localc.tCE = new Point(((Point)localObject1).x, ((Point)localObject1).y);
        localc.tCG = d.a(paramPoint, (Point)localObject1, paramBoolean, true);
        paramArrayOfSize = new Point(((Point)localObject1).x, ((Point)localObject1).y);
        localc.tCB = paramArrayOfSize;
        localc.tCC = ((Point)localObject1);
        localc.tCD = d.a(paramPoint, localc.tCB, paramBoolean, true);
        ad.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s ", new Object[] { paramArrayOfSize, localObject1 });
        AppMethodBeat.o(89417);
        return localc;
      }
      paramInt += 1;
    }
  }
  
  public static c c(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(186114);
    Object localObject1 = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject1, new b((byte)0));
    ad.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[] { d.eh((List)localObject1) });
    float f = paramPoint.x / paramPoint.y;
    ad.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(0) });
    ad.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bt.iJ(aj.getContext())) });
    paramParameters = new c();
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
        ad.i("MicroMsg.MMSightCameraInfo", "cursize is %s * %s , and isRotate %s, screenRes.x %s, screenRes.y %s", new Object[] { Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Boolean.valueOf(paramBoolean), Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
        if (paramPoint.y > paramPoint.x)
        {
          if (localPoint.y >= localPoint.x) {
            ad.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio  1 and unSupport preview is %s * %s", new Object[] { Integer.valueOf(((Camera.Size)localObject2).height), Integer.valueOf(((Camera.Size)localObject2).width) });
          }
        }
        else if (localPoint.x >= localPoint.y)
        {
          ad.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio 2 and unSupport preview is %s * %s", new Object[] { Integer.valueOf(((Camera.Size)localObject2).height), Integer.valueOf(((Camera.Size)localObject2).width) });
          continue;
        }
        localObject2 = d.a(paramPoint, localPoint, paramBoolean, false);
        if (localObject2 != null)
        {
          ad.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", new Object[] { localPoint, localObject2 });
          paramParameters.tCF = new Point(((Point)localObject2).x, ((Point)localObject2).y);
          paramParameters.tCE = new Point(localPoint.x, localPoint.y);
          paramParameters.tCG = d.a(paramPoint, localPoint, paramBoolean, true);
          localPoint = new Point(localPoint.x, localPoint.y);
          paramParameters.tCB = localPoint;
          paramParameters.tCC = ((Point)localObject2);
          paramParameters.tCD = d.a(paramPoint, paramParameters.tCB, paramBoolean, true);
          ad.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", new Object[] { localPoint, localObject2, Integer.valueOf(1) });
          AppMethodBeat.o(186114);
          return paramParameters;
        }
      }
    }
    ad.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with crop width", new Object[] { paramParameters.tCB, paramParameters.tCC, Integer.valueOf(0) });
    AppMethodBeat.o(186114);
    return paramParameters;
  }
  
  public static c d(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(89414);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new b((byte)0));
    new ArrayList(paramParameters.getSupportedPictureSizes());
    ad.i("MicroMsg.MMSightCameraInfo", "tryFindPreviewSizeAnyWay supportedPreviewSizes: %s", new Object[] { d.eh((List)localObject) });
    float f = paramPoint.x / paramPoint.y;
    ad.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt) });
    ad.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bt.iJ(aj.getContext())) });
    paramParameters = new c();
    paramParameters.tCB = a((ArrayList)localObject, paramPoint, paramBoolean, paramInt);
    if (paramParameters.tCB != null)
    {
      paramParameters.tCC = d.b(paramPoint, paramParameters.tCB, paramBoolean);
      paramParameters.tCD = d.b(paramPoint, paramParameters.tCB, paramBoolean, true);
    }
    for (;;)
    {
      ad.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", new Object[] { paramParameters.tCB, paramParameters.tCC, Integer.valueOf(0) });
      AppMethodBeat.o(89414);
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
        paramParameters.tCB = null;
      }
    }
  }
  
  public static c e(Camera.Parameters paramParameters, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(89416);
    paramParameters = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort(paramParameters, new b((byte)0));
    ad.i("MicroMsg.MMSightCameraInfo", "findPreviewSizeWithoutCrop supportedPreviewSizes: %s", new Object[] { d.eh(paramParameters) });
    float f = paramPoint.x / paramPoint.y;
    ad.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s ", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt) });
    ad.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(bt.iJ(aj.getContext())) });
    c localc = new c();
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
      ad.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s ", new Object[] { paramParameters });
      localc.tCF = new Point(paramParameters.x, paramParameters.y);
      localc.tCE = new Point(paramParameters.x, paramParameters.y);
      localc.tCG = d.a(paramPoint, paramParameters, paramBoolean, true);
      localObject = new Point(paramParameters.x, paramParameters.y);
      localc.tCB = ((Point)localObject);
      localc.tCC = paramParameters;
      localc.tCD = d.a(paramPoint, localc.tCB, paramBoolean, true);
      ad.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s ", new Object[] { localObject, paramParameters });
      AppMethodBeat.o(89416);
      return localc;
      paramParameters = null;
    }
  }
  
  static final class b
    implements Comparator<Camera.Size>
  {}
  
  public static final class c
  {
    public Point tCB;
    public Point tCC;
    public Point tCD;
    public Point tCE;
    public Point tCF;
    public Point tCG;
    
    public final String toString()
    {
      AppMethodBeat.i(89409);
      Object localObject = new StringBuffer();
      if (this.tCB != null) {
        ((StringBuffer)localObject).append(this.tCB.toString() + ",");
      }
      if (this.tCC != null) {
        ((StringBuffer)localObject).append(this.tCC.toString() + ",");
      }
      if (this.tCD != null) {
        ((StringBuffer)localObject).append(this.tCD.toString() + ",");
      }
      if (this.tCE != null) {
        ((StringBuffer)localObject).append(this.tCE.toString() + ",");
      }
      if (this.tCF != null) {
        ((StringBuffer)localObject).append(this.tCF.toString() + ",");
      }
      if (this.tCG != null) {
        ((StringBuffer)localObject).append(this.tCG.toString() + ",");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(89409);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.h
 * JD-Core Version:    0.7.0.1
 */