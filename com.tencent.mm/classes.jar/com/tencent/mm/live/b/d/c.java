package com.tencent.mm.live.b.d;

import android.renderscript.RSInvalidStateException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.blur.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/util/RenderScriptBlurWrapper;", "", "()V", "TAG", "", "blurInstance", "Lcom/tencent/mm/ui/blur/SupportRenderScriptBlur;", "instance", "release", "", "plugin-logic_release"})
public final class c
{
  private static final String TAG = "MicroMsg.RenderScriptBlurWrapper";
  private static f hLp;
  public static final c hLq;
  
  static
  {
    AppMethodBeat.i(207868);
    hLq = new c();
    TAG = "MicroMsg.RenderScriptBlurWrapper";
    AppMethodBeat.o(207868);
  }
  
  public static f aHp()
  {
    AppMethodBeat.i(207866);
    Log.i(TAG, "instance instance:" + hLp);
    if (hLp == null) {
      hLp = new f(MMApplicationContext.getContext());
    }
    f localf = hLp;
    if (localf == null) {
      p.hyc();
    }
    AppMethodBeat.o(207866);
    return localf;
  }
  
  public static void release()
  {
    AppMethodBeat.i(207867);
    Log.i(TAG, "release instance:" + hLp);
    try
    {
      hLp = null;
      AppMethodBeat.o(207867);
      return;
    }
    catch (RSInvalidStateException localRSInvalidStateException)
    {
      Log.w(TAG, "RSInvalidStateException " + localRSInvalidStateException.getMessage());
      AppMethodBeat.o(207867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.d.c
 * JD-Core Version:    0.7.0.1
 */