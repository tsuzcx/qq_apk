package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.camera2.CameraAccessException;
import android.os.Looper;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera/CommonCamera1CustomResolution;", "Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "selectNoCropPreviewSize", "", "resolutionLimit", "", "plugin-mediaeditor_release"})
public final class d
  extends c
{
  private final String TAG;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(258092);
    this.TAG = "CommonCamera1ForFinderLive";
    AppMethodBeat.o(258092);
  }
  
  public final boolean uj(int paramInt)
  {
    AppMethodBeat.i(258091);
    try
    {
      boolean bool = aXV();
      Point localPoint = aXX();
      Size[] arrayOfSize = aXW();
      if (arrayOfSize == null)
      {
        Log.e(this.TAG, "fuck, preview size null!!");
        AppMethodBeat.o(258091);
        return false;
      }
      Object localObject2 = h.c(arrayOfSize, localPoint, paramInt, bool);
      Object localObject1 = localObject2;
      if (((h.c)localObject2).EZN == null)
      {
        Log.e(this.TAG, "fuck, preview size still null!!");
        localObject1 = h.a(arrayOfSize, new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y)), aXF(), bool);
      }
      if (((h.c)localObject1).EZN == null)
      {
        Log.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject1).toString() });
        ((h.c)localObject1).EZN = ((h.c)localObject1).EZQ;
        ((h.c)localObject1).EZO = ((h.c)localObject1).EZR;
        ((h.c)localObject1).EZP = ((h.c)localObject1).EZS;
      }
      localObject2 = new Size(((h.c)localObject1).EZN.x, ((h.c)localObject1).EZN.y);
      this.laR.wAw = ((Size)localObject2).getWidth();
      this.laR.wAx = ((Size)localObject2).getHeight();
      if (((h.c)localObject1).EZP != null) {
        this.laW = ((h.c)localObject1).EZP;
      }
      dC(((Size)localObject2).getWidth(), ((Size)localObject2).getHeight());
      Log.i(this.TAG, "final set camera preview size: " + localObject2 + ", cropSize: " + this.laW);
      AppMethodBeat.o(258091);
      return true;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localCameraAccessException, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", new Object[] { Looper.myLooper(), localCameraAccessException.getMessage() });
      AppMethodBeat.o(258091);
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "selectNoCropPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
      AppMethodBeat.o(258091);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.d
 * JD-Core Version:    0.7.0.1
 */