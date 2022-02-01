package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.Context;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.service.MMService;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService;", "Lcom/tencent/mm/service/MMService;", "()V", "TAG", "", "onCreate", "", "onDestroy", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureService
  extends MMService
{
  public static final EmojiCaptureService.a rrH;
  private final String TAG = "MicroMsg.EmojiCaptureService";
  
  static
  {
    AppMethodBeat.i(420);
    rrH = new EmojiCaptureService.a((byte)0);
    AppMethodBeat.o(420);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(418);
    super.onCreate();
    Log.i(this.TAG, "onCreate: ");
    if (com.tencent.mm.compatible.util.d.oD(26)) {
      startForeground(-2564, a.cd(MMApplicationContext.getContext(), "reminder_channel_id").as(a.ezb()).g((CharSequence)MMApplicationContext.getContext().getString(2131758515)).build());
    }
    Object localObject = EmojiCaptureProxy.rrF;
    EmojiCaptureProxy.a.cJA();
    localObject = EmojiCaptureProxy.rrF;
    localObject = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (localObject != null)
    {
      ((com.tencent.mm.remoteservice.d)localObject).connect((Runnable)EmojiCaptureService.b.rrI);
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
    gxF();
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.rrF;
    EmojiCaptureProxy.a.cJB();
    AppMethodBeat.o(419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService
 * JD-Core Version:    0.7.0.1
 */