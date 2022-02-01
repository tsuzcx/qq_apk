package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "", "()V", "TAG", "", "dotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "checkDotValid", "", "lastDotInfo", "dotInfo", "duration", "", "checkWebViewId", "getDotList", "getNextDotInfo", "currentTime", "", "parseDotPosInfo", "", "posInfo", "reset", "setDotScriptData", "bundle", "Landroid/os/Bundle;", "shouldDestroyDotNow", "dot", "shouldShowDotNow", "plugin-brandservice_release"})
public final class b
{
  public final String TAG;
  public LinkedList<c> oql;
  
  public b()
  {
    AppMethodBeat.i(7283);
    this.TAG = "MicroMsg.BizVideoDotHelper";
    this.oql = new LinkedList();
    AppMethodBeat.o(7283);
  }
  
  public static boolean a(float paramFloat, c paramc)
  {
    if (paramc == null) {}
    while ((paramc.oqq) || (paramc.oqt > paramFloat) || (paramFloat > paramc.oqm)) {
      return false;
    }
    return true;
  }
  
  public static boolean bRZ()
  {
    AppMethodBeat.i(7282);
    if ((!i.DEBUG) && (!i.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(7282);
      return true;
    }
    if (ax.aQz("MicroMsg.BizVideoDetailUI").decodeInt("CheckWebviewId", 1) == 0)
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
      boolean bool = bt.hj((List)this.oql);
      if (bool) {
        return null;
      }
      Object localObject1 = this.oql.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        c localc = (c)((Iterator)localObject1).next();
        if (paramFloat <= localc.oqm) {
          if (paramFloat >= 2.0F)
          {
            double d1 = paramFloat;
            double d2 = localc.oqt;
            if (d1 >= d2 - 10.0D) {
              return localc;
            }
          }
        }
      }
      localObject1 = z.MKo;
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
    if ((paramc.oqq) && ((paramFloat < paramc.oqt) || (paramFloat > paramc.oqu)))
    {
      AppMethodBeat.o(7281);
      return true;
    }
    if (paramFloat > paramc.oqu)
    {
      AppMethodBeat.o(7281);
      return true;
    }
    if (paramFloat < paramc.oqt)
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
      this.oql.clear();
      z localz = z.MKo;
      return;
    }
    finally
    {
      AppMethodBeat.o(7279);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b
 * JD-Core Version:    0.7.0.1
 */