package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.Context;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.service.MMService;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService;", "Lcom/tencent/mm/service/MMService;", "()V", "TAG", "", "onCreate", "", "onDestroy", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureService
  extends MMService
{
  public static final a uXn;
  private final String TAG = "MicroMsg.EmojiCaptureService";
  
  static
  {
    AppMethodBeat.i(420);
    uXn = new a((byte)0);
    AppMethodBeat.o(420);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(418);
    super.onCreate();
    Log.i(this.TAG, "onCreate: ");
    if (com.tencent.mm.compatible.util.d.qV(26)) {
      d(-2564, a.cp(MMApplicationContext.getContext(), "reminder_channel_id").bn(a.fkG()).l((CharSequence)MMApplicationContext.getContext().getString(a.i.uSZ)).gr());
    }
    Object localObject = EmojiCaptureProxy.uXl;
    EmojiCaptureProxy.a.cYi();
    localObject = EmojiCaptureProxy.uXl;
    localObject = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (localObject != null)
    {
      ((com.tencent.mm.remoteservice.d)localObject).connect((Runnable)b.uXo);
      AppMethodBeat.o(418);
      return;
    }
    AppMethodBeat.o(418);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(419);
    super.onDestroy();
    Log.i(this.TAG, "onDestroy: ");
    htD();
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.uXl;
    EmojiCaptureProxy.a.cYj();
    AppMethodBeat.o(419);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService$Companion;", "", "()V", "NOTIFY_ID", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b uXo;
    
    static
    {
      AppMethodBeat.i(417);
      uXo = new b();
      AppMethodBeat.o(417);
    }
    
    public final void run()
    {
      AppMethodBeat.i(416);
      AppMethodBeat.o(416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService
 * JD-Core Version:    0.7.0.1
 */