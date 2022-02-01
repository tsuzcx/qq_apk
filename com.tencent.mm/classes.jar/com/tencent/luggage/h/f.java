package com.tencent.luggage.h;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.skyline.SkylineConfig;
import com.tencent.skyline.SkylineLogic;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/SkylineManager;", "", "()V", "TAG", "", "obtain", "", "id", "", "context", "Landroid/content/Context;", "width", "height", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f evZ;
  
  static
  {
    AppMethodBeat.i(219993);
    evZ = new f();
    AppMethodBeat.o(219993);
  }
  
  public final boolean a(int paramInt1, Context paramContext, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(220003);
      s.u(paramContext, "context");
      SkylineLogic localSkylineLogic = SkylineLogic.INSTANCE;
      SkylineConfig localSkylineConfig = new SkylineConfig();
      localSkylineConfig.setId(paramInt1);
      Object localObject = paramContext.getResources().getDisplayMetrics();
      localSkylineConfig.setWindowWidth(paramInt2 / ((DisplayMetrics)localObject).density);
      localSkylineConfig.setWindowHeight(paramInt3 / ((DisplayMetrics)localObject).density);
      localObject = ah.aiuX;
      boolean bool = localSkylineLogic.createFlutterEngine(paramContext, localSkylineConfig);
      Log.i("SkylineManager", "obtainPreload id:" + paramInt1 + " isOk:" + bool);
      AppMethodBeat.o(220003);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.h.f
 * JD-Core Version:    0.7.0.1
 */