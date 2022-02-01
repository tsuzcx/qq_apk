package com.tencent.mm.live.b.d;

import android.renderscript.RSInvalidStateException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.blur.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/util/RenderScriptBlurWrapper;", "", "()V", "TAG", "", "blurInstance", "Lcom/tencent/mm/ui/blur/SupportRenderScriptBlur;", "instance", "release", "", "plugin-logic_release"})
public final class c
{
  private static final String TAG = "MicroMsg.RenderScriptBlurWrapper";
  private static f kyJ;
  public static final c kyK;
  
  static
  {
    AppMethodBeat.i(194829);
    kyK = new c();
    TAG = "MicroMsg.RenderScriptBlurWrapper";
    AppMethodBeat.o(194829);
  }
  
  public static f aPp()
  {
    AppMethodBeat.i(194819);
    Log.i(TAG, "instance instance:" + kyJ);
    if (kyJ == null) {
      kyJ = new f(MMApplicationContext.getContext());
    }
    f localf = kyJ;
    if (localf == null) {
      p.iCn();
    }
    AppMethodBeat.o(194819);
    return localf;
  }
  
  public static void release()
  {
    AppMethodBeat.i(194825);
    Log.i(TAG, "release instance:" + kyJ);
    try
    {
      f localf = kyJ;
      if (localf != null) {
        localf.destroy();
      }
      kyJ = null;
      AppMethodBeat.o(194825);
      return;
    }
    catch (RSInvalidStateException localRSInvalidStateException)
    {
      Log.w(TAG, "RSInvalidStateException " + localRSInvalidStateException.getMessage());
      AppMethodBeat.o(194825);
      return;
    }
    catch (Exception localException)
    {
      Log.w(TAG, "Exception " + localException.getMessage());
      AppMethodBeat.o(194825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.d.c
 * JD-Core Version:    0.7.0.1
 */