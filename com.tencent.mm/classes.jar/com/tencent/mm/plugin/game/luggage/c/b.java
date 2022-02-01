package com.tencent.mm.plugin.game.luggage.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch;", "", "()V", "Companion", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a Ivj;
  private static final String Ivk;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(276959);
    Ivj = new a((byte)0);
    TAG = "MicroMsg.LiteAppIpcEventDispatch";
    Ivk = s.X(MMApplicationContext.getApplicationId(), ":lite");
    AppMethodBeat.o(276959);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch$Companion;", "", "()V", "LITE_PROCESS_NAME", "", "TAG", "dispatchEventFromMMProcess", "", "data", "Landroid/os/Bundle;", "IPCLiteAppDispatchEventTask", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void ay(Bundle paramBundle)
    {
      AppMethodBeat.i(276951);
      s.u(paramBundle, "data");
      Log.i(b.access$getTAG$cp(), "dispatchEventFromMMProcess");
      if (MMApplicationContext.isProcessExist(b.fEw()))
      {
        Log.i(b.access$getTAG$cp(), "process alive");
        j.a(b.fEw(), (Parcelable)paramBundle, a.class, null);
      }
      AppMethodBeat.o(276951);
    }
    
    @a
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch$Companion$IPCLiteAppDispatchEventTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class a
      implements d<Bundle, Bundle>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.b
 * JD-Core Version:    0.7.0.1
 */