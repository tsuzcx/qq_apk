package com.tencent.mm.plugin.game.luggage.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch;", "", "()V", "Companion", "luggage-game_release"})
public final class b
{
  private static final String CBt;
  public static final a CBu;
  private static final String TAG = "MicroMsg.LiteAppIpcEventDispatch";
  
  static
  {
    AppMethodBeat.i(231438);
    CBu = new a((byte)0);
    TAG = "MicroMsg.LiteAppIpcEventDispatch";
    CBt = MMApplicationContext.getApplicationId() + ":lite";
    AppMethodBeat.o(231438);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch$Companion;", "", "()V", "LITE_PROCESS_NAME", "", "TAG", "dispatchEventFromMMProcess", "", "data", "Landroid/os/Bundle;", "IPCLiteAppDispatchEventTask", "luggage-game_release"})
  public static final class a
  {
    public static void ag(Bundle paramBundle)
    {
      AppMethodBeat.i(232072);
      p.k(paramBundle, "data");
      Log.i(b.access$getTAG$cp(), "dispatchEventFromMMProcess");
      if (MMApplicationContext.isProcessExist(b.ewE()))
      {
        Log.i(b.access$getTAG$cp(), "process alive");
        j.a(b.ewE(), (Parcelable)paramBundle, a.class, null);
      }
      AppMethodBeat.o(232072);
    }
    
    @a
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch$Companion$IPCLiteAppDispatchEventTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "luggage-game_release"})
    static final class a
      implements d<Bundle, Bundle>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.b
 * JD-Core Version:    0.7.0.1
 */