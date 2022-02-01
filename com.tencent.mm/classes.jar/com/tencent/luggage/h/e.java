package com.tencent.luggage.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.skyline.SkylineConfig;
import com.tencent.skyline.SkylineLogic;
import com.tencent.skyline.jni.INativeHandler;
import com.tencent.skyline.jni.ISkylineLibraryLoader;
import com.tencent.skyline.jni.SkylineLibraryLoader;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/SkylineLogic;", "", "()V", "TAG", "", "initJsEngine", "", "isolatePtr", "", "contextPtr", "initLoader", "context", "Landroid/content/Context;", "initNativeHandler", "nativeHandler", "Lcom/tencent/skyline/jni/INativeHandler;", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e evY;
  
  static
  {
    AppMethodBeat.i(220008);
    evY = new e();
    AppMethodBeat.o(220008);
  }
  
  private static final void bs(Context paramContext)
  {
    AppMethodBeat.i(220000);
    s.u(paramContext, "$context");
    SkylineLogic.INSTANCE.init(paramContext);
    long l = System.currentTimeMillis();
    Log.i("SkylineLogic", "init createFlutterEngine start");
    SkylineLogic localSkylineLogic = SkylineLogic.INSTANCE;
    SkylineConfig localSkylineConfig = new SkylineConfig();
    localSkylineConfig.setId(0);
    localSkylineConfig.setWindowWidth(0.0D);
    localSkylineConfig.setWindowHeight(0.0D);
    ah localah = ah.aiuX;
    localSkylineLogic.createFlutterEngine(paramContext, localSkylineConfig);
    Log.i("SkylineLogic", s.X("init createFlutterEngine end, cost:", Long.valueOf(System.currentTimeMillis() - l)));
    AppMethodBeat.o(220000);
  }
  
  public final void br(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(220020);
      s.u(paramContext, "context");
      SkylineLibraryLoader.initXWebLibraryLoader((ISkylineLibraryLoader)new e.a());
      h.ahAA.bk(new e..ExternalSyntheticLambda0(paramContext));
      AppMethodBeat.o(220020);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void initJsEngine(long paramLong1, long paramLong2)
  {
    try
    {
      AppMethodBeat.i(220030);
      Log.i("SkylineLogic", "initJsEngine isolatePtr:" + paramLong1 + " contextPtr:" + paramLong2);
      SkylineLogic.INSTANCE.initJsEngine(paramLong1, paramLong2);
      AppMethodBeat.o(220030);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void initNativeHandler(INativeHandler paramINativeHandler)
  {
    try
    {
      AppMethodBeat.i(220026);
      s.u(paramINativeHandler, "nativeHandler");
      Log.i("SkylineLogic", "initNativeHandler");
      SkylineLogic.INSTANCE.initNativeHandler(paramINativeHandler);
      AppMethodBeat.o(220026);
      return;
    }
    finally
    {
      paramINativeHandler = finally;
      throw paramINativeHandler;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.h.e
 * JD-Core Version:    0.7.0.1
 */