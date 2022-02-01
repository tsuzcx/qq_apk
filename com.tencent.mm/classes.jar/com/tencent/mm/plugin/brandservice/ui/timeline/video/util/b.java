package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "", "()V", "TAG", "", "dotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "checkDotValid", "", "lastDotInfo", "dotInfo", "duration", "", "checkWebViewId", "getDotList", "getNextDotInfo", "currentTime", "", "parseDotPosInfo", "", "posInfo", "reset", "setDotScriptData", "bundle", "Landroid/os/Bundle;", "shouldDestroyDotNow", "dot", "shouldShowDotNow", "plugin-brandservice_release"})
public final class b
{
  public final String TAG;
  public LinkedList<c> nNF;
  
  public b()
  {
    AppMethodBeat.i(7283);
    this.TAG = "MicroMsg.BizVideoDotHelper";
    this.nNF = new LinkedList();
    AppMethodBeat.o(7283);
  }
  
  public static boolean a(float paramFloat, c paramc)
  {
    if (paramc == null) {}
    while ((paramc.nNK) || (paramc.nNN > paramFloat) || (paramFloat > paramc.nNG)) {
      return false;
    }
    return true;
  }
  
  public static boolean bNz()
  {
    AppMethodBeat.i(7282);
    if ((!h.DEBUG) && (!h.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(7282);
      return true;
    }
    if (aw.aKT("MicroMsg.BizVideoDetailUI").decodeInt("CheckWebviewId", 1) == 0)
    {
      AppMethodBeat.o(7282);
      return false;
    }
    AppMethodBeat.o(7282);
    return true;
  }
  
  public final c aR(float paramFloat)
  {
    AppMethodBeat.i(7280);
    try
    {
      boolean bool = bs.gY((List)this.nNF);
      if (bool) {
        return null;
      }
      Object localObject1 = this.nNF.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        c localc = (c)((Iterator)localObject1).next();
        if (paramFloat <= localc.nNG) {
          if (paramFloat >= 2.0F)
          {
            double d1 = paramFloat;
            double d2 = localc.nNN;
            if (d1 >= d2 - 10.0D) {
              return localc;
            }
          }
        }
      }
      localObject1 = y.KTp;
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
    if ((paramc.nNK) && ((paramFloat < paramc.nNN) || (paramFloat > paramc.nNO)))
    {
      AppMethodBeat.o(7281);
      return true;
    }
    if (paramFloat > paramc.nNO)
    {
      AppMethodBeat.o(7281);
      return true;
    }
    if (paramFloat < paramc.nNN)
    {
      c localc = aR(paramFloat);
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
      this.nNF.clear();
      y localy = y.KTp;
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