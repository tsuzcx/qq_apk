package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "", "()V", "TAG", "", "dotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "checkDotValid", "", "lastDotInfo", "dotInfo", "duration", "", "checkWebViewId", "getDotList", "getNextDotInfo", "currentTime", "", "parseDotPosInfo", "", "posInfo", "reset", "setDotScriptData", "bundle", "Landroid/os/Bundle;", "shouldDestroyDotNow", "dot", "shouldShowDotNow", "plugin-brandservice_release"})
public final class b
{
  public final String TAG;
  public LinkedList<c> owH;
  
  public b()
  {
    AppMethodBeat.i(7283);
    this.TAG = "MicroMsg.BizVideoDotHelper";
    this.owH = new LinkedList();
    AppMethodBeat.o(7283);
  }
  
  public static boolean a(float paramFloat, c paramc)
  {
    if (paramc == null) {}
    while ((paramc.owM) || (paramc.owP > paramFloat) || (paramFloat > paramc.owI)) {
      return false;
    }
    return true;
  }
  
  public static boolean bTl()
  {
    AppMethodBeat.i(7282);
    if ((!j.DEBUG) && (!j.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(7282);
      return true;
    }
    if (ay.aRW("MicroMsg.BizVideoDetailUI").decodeInt("CheckWebviewId", 1) == 0)
    {
      AppMethodBeat.o(7282);
      return false;
    }
    AppMethodBeat.o(7282);
    return true;
  }
  
  public final c aU(float paramFloat)
  {
    AppMethodBeat.i(7280);
    try
    {
      boolean bool = bu.ht((List)this.owH);
      if (bool) {
        return null;
      }
      Object localObject1 = this.owH.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        c localc = (c)((Iterator)localObject1).next();
        if (paramFloat <= localc.owI) {
          if (paramFloat >= 2.0F)
          {
            double d1 = paramFloat;
            double d2 = localc.owP;
            if (d1 >= d2 - 10.0D) {
              return localc;
            }
          }
        }
      }
      localObject1 = z.Nhr;
      return null;
    }
    finally
    {
      AppMethodBeat.o(7280);
    }
  }
  
  public final boolean b(float paramFloat, c paramc)
  {
    AppMethodBeat.i(7281);
    if (paramc == null)
    {
      AppMethodBeat.o(7281);
      return false;
    }
    if ((paramc.owM) && ((paramFloat < paramc.owP) || (paramFloat > paramc.owQ)))
    {
      AppMethodBeat.o(7281);
      return true;
    }
    if (paramFloat > paramc.owQ)
    {
      AppMethodBeat.o(7281);
      return true;
    }
    if (paramFloat < paramc.owP)
    {
      c localc = aU(paramFloat);
      if ((localc != null) && (localc.id != paramc.id))
      {
        AppMethodBeat.o(7281);
        return true;
      }
    }
    AppMethodBeat.o(7281);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(7279);
    try
    {
      this.owH.clear();
      z localz = z.Nhr;
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