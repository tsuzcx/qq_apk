package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.camera2.CameraAccessException;
import android.os.Looper;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.a;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera/CommonCamera1CustomResolution;", "Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "selectNoCropPreviewSize", "", "resolutionLimit", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends d
{
  private final String TAG;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(237590);
    this.TAG = "CommonCamera1ForFinderLive";
    AppMethodBeat.o(237590);
  }
  
  public final boolean ui(int paramInt)
  {
    AppMethodBeat.i(237597);
    try
    {
      bool = bsI();
      localPoint = bsK();
      arrayOfSize = bsJ();
      if (arrayOfSize == null)
      {
        Log.e(this.TAG, "fuck, preview size null!!");
        AppMethodBeat.o(237597);
        return false;
      }
      Arrays.sort(arrayOfSize, new h.a((byte)0));
      Log.i("MicroMsg.MMSightCameraInfo", "findPreviewSizeWithoutCrop supportedPreviewSizes: %s", new Object[] { com.tencent.mm.plugin.mmsight.d.a(arrayOfSize) });
      f1 = localPoint.x / localPoint.y;
      Log.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s ", new Object[] { Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Float.valueOf(f1), Integer.valueOf(paramInt) });
      Log.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(Util.getAvailableMemoryMB(MMApplicationContext.getContext())) });
      localc = new h.c();
      localObject2 = null;
      i = (int)(paramInt * 1.05F) + 64;
      j = arrayOfSize.length;
      paramInt = 0;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      for (;;)
      {
        boolean bool;
        Point localPoint;
        Size[] arrayOfSize;
        float f1;
        h.c localc;
        Object localObject2;
        int i;
        int j;
        Object localObject1;
        Size localSize;
        float f2;
        Log.printErrStackTrace(this.TAG, (Throwable)localCameraAccessException, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", new Object[] { Looper.myLooper(), localCameraAccessException.getMessage() });
        AppMethodBeat.o(237597);
        return false;
        paramInt += 1;
        continue;
        paramInt += 1;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "selectNoCropPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
      AppMethodBeat.o(237597);
    }
    localObject1 = localObject2;
    if (paramInt < j)
    {
      localSize = arrayOfSize[paramInt];
      f2 = localSize.getHeight() / localSize.getWidth();
      if ((localSize.getHeight() <= i) && (localSize.getWidth() <= 2000) && (f2 == f1))
      {
        localObject1 = new Point();
        ((Point)localObject1).x = localSize.getWidth();
        ((Point)localObject1).y = localSize.getHeight();
      }
    }
    else
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        j = arrayOfSize.length;
        paramInt = 0;
        localObject2 = localObject1;
        if (paramInt < j)
        {
          localSize = arrayOfSize[paramInt];
          if ((localSize.getHeight() > i) || (localSize.getWidth() > 2000)) {
            break label813;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new Point();
            ((Point)localObject2).x = localSize.getWidth();
            ((Point)localObject2).y = localSize.getHeight();
          }
        }
      }
      Log.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s ", new Object[] { localObject2 });
      localc.KVD = new Point(((Point)localObject2).x, ((Point)localObject2).y);
      localc.KVC = new Point(((Point)localObject2).x, ((Point)localObject2).y);
      localc.KVE = com.tencent.mm.plugin.mmsight.d.a(localPoint, (Point)localObject2, bool, true);
      localObject1 = new Point(((Point)localObject2).x, ((Point)localObject2).y);
      localc.KVz = ((Point)localObject1);
      localc.KVA = ((Point)localObject2);
      localc.KVB = com.tencent.mm.plugin.mmsight.d.a(localPoint, localc.KVz, bool, true);
      Log.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s ", new Object[] { localObject1, localObject2 });
      localObject1 = localc;
      if (localc.KVz == null)
      {
        Log.e(this.TAG, "fuck, preview size still null!!");
        localObject1 = h.a(arrayOfSize, new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y)), bsn(), bool);
      }
      if (((h.c)localObject1).KVz == null)
      {
        Log.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject1).toString() });
        ((h.c)localObject1).KVz = ((h.c)localObject1).KVC;
        ((h.c)localObject1).KVA = ((h.c)localObject1).KVD;
        ((h.c)localObject1).KVB = ((h.c)localObject1).KVE;
      }
      localObject2 = new Size(((h.c)localObject1).KVz.x, ((h.c)localObject1).KVz.y);
      bss().zWH = ((Size)localObject2).getWidth();
      bss().zWI = ((Size)localObject2).getHeight();
      if (((h.c)localObject1).KVB != null) {
        d(((h.c)localObject1).KVB);
      }
      ew(((Size)localObject2).getWidth(), ((Size)localObject2).getHeight());
      Log.i(this.TAG, "final set camera preview size: " + localObject2 + ", cropSize: " + bsw());
      AppMethodBeat.o(237597);
      return true;
    }
    label813:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.e
 * JD-Core Version:    0.7.0.1
 */