package com.tencent.mm.media.camera.e;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/preload/CameraKitPreload;", "", "()V", "CAMERA_KIT_GL_ENV_PRELOAD", "", "TAG", "cameraPreloadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/media/camera/preload/CameraKitPreloadModel;", "Lcom/tencent/mm/media/camera/CameraKit;", "Lkotlin/collections/HashMap;", "envPreloadMap", "Lcom/tencent/mm/media/camera/render/GLEnvPreloadBuilder;", "clearGlEnvPreload", "", "containsPreloadGlEnv", "", "key", "getCameraPreload", "removeFromPreload", "getFullScreenSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "context", "Landroid/content/Context;", "getGlEnvPreload", "changeToPreloadStatus", "Lcom/tencent/mm/media/camera/preload/CameraKitPreloadStatus;", "getPreloadRender", "T", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Ljava/lang/String;)Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRatioSize", "widthRatio", "", "heightRatio", "removeCameraPreload", "removeGlEnvPreload", "setCameraPreload", "backCamera", "previewSize", "setGlEnvPreload", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a nvP;
  private static final HashMap<String, b<com.tencent.mm.media.camera.f.c>> nvQ;
  private static final HashMap<String, b<com.tencent.mm.media.camera.a>> nvR;
  
  static
  {
    AppMethodBeat.i(237313);
    nvP = new a();
    nvQ = new HashMap();
    nvR = new HashMap();
    AppMethodBeat.o(237313);
  }
  
  public static boolean GM(String paramString)
  {
    AppMethodBeat.i(237266);
    s.u(paramString, "key");
    boolean bool = ((Map)nvQ).containsKey(paramString);
    AppMethodBeat.o(237266);
    return bool;
  }
  
  public static void bop()
  {
    AppMethodBeat.i(237277);
    Log.i("MicroMsg.CameraKitPreload", "clearGlEnvPreload");
    Iterator localIterator = nvQ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      s.s(localObject, "iterator.next()");
      localObject = (Map.Entry)localObject;
      if (((b)((Map.Entry)localObject).getValue()).nvT != c.nvW)
      {
        ((com.tencent.mm.media.camera.f.c)((b)((Map.Entry)localObject).getValue()).nvS).bnO();
        localIterator.remove();
      }
    }
    AppMethodBeat.o(237277);
  }
  
  public static ad dC(Context paramContext)
  {
    AppMethodBeat.i(237299);
    s.u(paramContext, "context");
    paramContext = bg.bf(paramContext);
    if (paramContext.y * 1.0F / paramContext.x > 1.777778F)
    {
      int i = (int)(paramContext.x * 1.777778F);
      paramContext = new ad(paramContext.x, i);
      AppMethodBeat.o(237299);
      return paramContext;
    }
    paramContext = new ad((int)(paramContext.y * 1.777778F), paramContext.y);
    AppMethodBeat.o(237299);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.e.a
 * JD-Core Version:    0.7.0.1
 */