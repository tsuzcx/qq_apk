package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "", "()V", "TAG", "", "dotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "checkDotValid", "", "lastDotInfo", "dotInfo", "duration", "", "checkWebViewId", "getDotList", "getNextDotInfo", "currentTime", "", "parseDotPosInfo", "", "posInfo", "reset", "setDotScriptData", "bundle", "Landroid/os/Bundle;", "shouldDestroyDotNow", "dot", "shouldShowDotNow", "plugin-brandservice_release"})
public final class b
{
  public final String TAG;
  public LinkedList<c> pKl;
  
  public b()
  {
    AppMethodBeat.i(7283);
    this.TAG = "MicroMsg.BizVideoDotHelper";
    this.pKl = new LinkedList();
    AppMethodBeat.o(7283);
  }
  
  public static boolean a(float paramFloat, c paramc)
  {
    if (paramc == null) {}
    while ((paramc.pKq) || (paramc.pKt > paramFloat) || (paramFloat > paramc.pKm)) {
      return false;
    }
    return true;
  }
  
  public static boolean cqW()
  {
    AppMethodBeat.i(7282);
    if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(7282);
      return true;
    }
    if (MultiProcessMMKV.getMMKV("MicroMsg.BizVideoDetailUI").decodeInt("CheckWebviewId", 1) == 0)
    {
      AppMethodBeat.o(7282);
      return false;
    }
    AppMethodBeat.o(7282);
    return true;
  }
  
  public final boolean b(float paramFloat, c paramc)
  {
    AppMethodBeat.i(7281);
    if (paramc == null)
    {
      AppMethodBeat.o(7281);
      return false;
    }
    if ((paramc.pKq) && ((paramFloat < paramc.pKt) || (paramFloat > paramc.pKu)))
    {
      AppMethodBeat.o(7281);
      return true;
    }
    if (paramFloat > paramc.pKu)
    {
      AppMethodBeat.o(7281);
      return true;
    }
    if (paramFloat < paramc.pKt)
    {
      c localc = bb(paramFloat);
      if ((localc != null) && (localc.id != paramc.id))
      {
        AppMethodBeat.o(7281);
        return true;
      }
    }
    AppMethodBeat.o(7281);
    return false;
  }
  
  public final c bb(float paramFloat)
  {
    AppMethodBeat.i(7280);
    try
    {
      boolean bool = Util.isNullOrNil((List)this.pKl);
      if (bool) {
        return null;
      }
      Object localObject1 = this.pKl.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        c localc = (c)((Iterator)localObject1).next();
        if (paramFloat <= localc.pKm) {
          if (paramFloat >= 2.0F)
          {
            double d1 = paramFloat;
            double d2 = localc.pKt;
            if (d1 >= d2 - 10.0D) {
              return localc;
            }
          }
        }
      }
      localObject1 = x.SXb;
      return null;
    }
    finally
    {
      AppMethodBeat.o(7280);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(7279);
    try
    {
      this.pKl.clear();
      x localx = x.SXb;
      return;
    }
    finally
    {
      AppMethodBeat.o(7279);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b
 * JD-Core Version:    0.7.0.1
 */