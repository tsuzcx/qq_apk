package com.tencent.mm.media.camera.instance.camera1;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.d.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.b.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "getCameraNum", "", "hasBackCamera", "", "cameraNum", "hasFrontCamera", "safeSetFocusMode", "parameter", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "selectCameraResolutionWithSize", "size", "Lcom/tencent/mm/media/camera/model/GLSize;", "setFrameRate", "", "p", "mCameraFps", "tryGetResolution", "Landroid/hardware/Camera$Size;", "resolutionSize", "", "previewRatio", "", "limit", "plugin-camera_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final Camera.Size a(List<? extends Camera.Size> paramList, float paramFloat, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(237432);
    double d = 0.1D;
    Object localObject1 = null;
    int i = 0;
    label266:
    label281:
    for (;;)
    {
      Object localObject3;
      int j;
      if (localObject1 == null)
      {
        localObject3 = ((Iterable)paramList).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          Camera.Size localSize = (Camera.Size)localObject1;
          if ((Math.abs(Math.max(localSize.width, localSize.height) * 1.0F / Math.min(localSize.width, localSize.height) - paramFloat) <= d) && (Math.min(localSize.width, localSize.height) >= paramInt))
          {
            j = 1;
            label122:
            if (j == 0) {
              break label246;
            }
            label127:
            localObject1 = (Camera.Size)localObject1;
            i += 1;
            d += 0.5D;
            if (i <= 10) {
              break label281;
            }
          }
        }
      }
      for (;;)
      {
        localObject3 = new StringBuilder("selectCameraResolutionWithSize seekLoopIndex:").append(i).append(" seekDistance:").append(d).append(" bestPreviewSize:[");
        if (localObject1 == null)
        {
          paramList = null;
          label190:
          localObject3 = ((StringBuilder)localObject3).append(paramList).append('x');
          if (localObject1 != null) {
            break label266;
          }
        }
        for (paramList = localObject2;; paramList = Integer.valueOf(((Camera.Size)localObject1).height))
        {
          Log.i("MicroMsg.Camera.Camera1Impl", paramList + "] limit:" + paramInt);
          AppMethodBeat.o(237432);
          return localObject1;
          j = 0;
          break label122;
          label246:
          break;
          localObject1 = null;
          break label127;
          paramList = Integer.valueOf(((Camera.Size)localObject1).width);
          break label190;
        }
      }
    }
  }
  
  public static final boolean a(Camera.Parameters paramParameters, h paramh)
  {
    AppMethodBeat.i(237428);
    s.u(paramh, "size");
    if (paramParameters == null) {}
    try
    {
      Log.e("MicroMsg.Camera.Camera1Impl", "selectCameraResolution camera is null");
      AppMethodBeat.o(237428);
      return false;
    }
    catch (Exception paramParameters)
    {
      int j;
      Log.printErrStackTrace("MicroMsg.Camera.Camera1Impl", (Throwable)paramParameters, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
      AppMethodBeat.o(237428);
      return false;
    }
    int i = paramh.width;
    j = paramh.height;
    float f3 = Math.max(j, i) * 1.0F / Math.min(j, i);
    Object localObject2 = paramParameters.getSupportedPreviewSizes();
    s.s(localObject2, "parameter.supportedPreviewSizes");
    p.a((Iterable)localObject2, (Comparator)new a());
    paramh = ((Iterable)localObject2).iterator();
    while (paramh.hasNext())
    {
      localObject1 = (Camera.Size)paramh.next();
      Log.i("MicroMsg.Camera.Camera1Impl", "support resolution:[" + ((Camera.Size)localObject1).width + ' ' + ((Camera.Size)localObject1).height + ']');
    }
    paramh = null;
    i = 1080;
    while ((i > 0) && (paramh == null))
    {
      paramh = a((List)localObject2, f3, i);
      i -= 150;
    }
    Object localObject1 = paramh;
    float f1;
    if (paramh == null)
    {
      f1 = 100.0F;
      localObject2 = ((Iterable)localObject2).iterator();
    }
    label386:
    for (;;)
    {
      localObject1 = paramh;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Camera.Size)((Iterator)localObject2).next();
        float f2 = Math.abs(Math.max(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height) * 1.0F / Math.min(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height) - f3);
        if (f2 < f1)
        {
          paramh = (h)localObject1;
          f1 = f2;
          break label386;
        }
      }
      else
      {
        if (localObject1 == null)
        {
          Log.e("MicroMsg.Camera.Camera1Impl", "selectCameraResolutionWithSize find null");
          AppMethodBeat.o(237428);
          return false;
        }
        paramParameters.setPreviewSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        AppMethodBeat.o(237428);
        return true;
      }
    }
  }
  
  public static final boolean d(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(237436);
    if (paramParameters == null)
    {
      AppMethodBeat.o(237436);
      return false;
    }
    for (;;)
    {
      try
      {
        List localList = paramParameters.getSupportedFocusModes();
        if (localList != null)
        {
          if (localList.contains("continuous-picture"))
          {
            Log.i("MicroMsg.Camera.Camera1Impl", "support continuous picture");
            paramParameters.setFocusMode("continuous-picture");
          }
        }
        else
        {
          AppMethodBeat.o(237436);
          return true;
        }
        if (localList.contains("continuous-video"))
        {
          Log.i("MicroMsg.Camera.Camera1Impl", "support continuous video");
          paramParameters.setFocusMode("continuous-video");
          continue;
        }
        if (!localList.contains("auto")) {
          break label142;
        }
      }
      catch (Exception paramParameters)
      {
        Log.i("MicroMsg.Camera.Camera1Impl", "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(237436);
        return false;
      }
      Log.i("MicroMsg.Camera.Camera1Impl", "support auto focus");
      paramParameters.setFocusMode("auto");
      continue;
      label142:
      Log.e("MicroMsg.Camera.Camera1Impl", "not support continuous video or auto focus");
    }
  }
  
  public static final boolean tV(int paramInt)
  {
    AppMethodBeat.i(237415);
    if (paramInt > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing == 1)
      {
        AppMethodBeat.o(237415);
        return true;
      }
      if (j >= paramInt)
      {
        AppMethodBeat.o(237415);
        return false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class a<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(237422);
      int i = a.b((Comparable)Integer.valueOf(((Camera.Size)paramT2).width), (Comparable)Integer.valueOf(((Camera.Size)paramT1).width));
      AppMethodBeat.o(237422);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.camera1.d
 * JD-Core Version:    0.7.0.1
 */