package com.tencent.mm.plugin.game.luggage.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch;", "", "()V", "Companion", "luggage-game_release"})
public final class b
{
  private static final String TAG = "MicroMsg.LiteAppIpcEventDispatch";
  private static final String xxk;
  public static final a xxl;
  
  static
  {
    AppMethodBeat.i(187038);
    xxl = new a((byte)0);
    TAG = "MicroMsg.LiteAppIpcEventDispatch";
    xxk = MMApplicationContext.getApplicationId() + ":lite";
    AppMethodBeat.o(187038);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch$Companion;", "", "()V", "LITE_PROCESS_NAME", "", "TAG", "dispatchEventFromMMProcess", "", "data", "Landroid/os/Bundle;", "IPCLiteAppDispatchEventTask", "luggage-game_release"})
  public static final class a
  {
    public static void am(Bundle paramBundle)
    {
      AppMethodBeat.i(187037);
      p.h(paramBundle, "data");
      Log.i(b.access$getTAG$cp(), "dispatchEventFromMMProcess");
      if (MMApplicationContext.isProcessExist(b.dTv()))
      {
        Log.i(b.access$getTAG$cp(), "process alive");
        h.a(b.dTv(), (Parcelable)paramBundle, a.class, null);
      }
      AppMethodBeat.o(187037);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch$Companion$IPCLiteAppDispatchEventTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "luggage-game_release"})
    static final class a
      implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.b
 * JD-Core Version:    0.7.0.1
 */