package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.Context;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.service.MMService;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService;", "Lcom/tencent/mm/service/MMService;", "()V", "TAG", "", "onCreate", "", "onDestroy", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureService
  extends MMService
{
  public static final EmojiCaptureService.a qaK;
  private final String TAG = "MicroMsg.EmojiCaptureService";
  
  static
  {
    AppMethodBeat.i(420);
    qaK = new EmojiCaptureService.a((byte)0);
    AppMethodBeat.o(420);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(418);
    super.onCreate();
    ae.i(this.TAG, "onCreate: ");
    if (com.tencent.mm.compatible.util.d.lA(26)) {
      startForeground(-2564, a.bJ(ak.getContext(), "reminder_channel_id").as(a.dzu()).g((CharSequence)ak.getContext().getString(2131758227)).build());
    }
    Object localObject = EmojiCaptureProxy.qaI;
    EmojiCaptureProxy.a.cly();
    localObject = EmojiCaptureProxy.qaI;
    localObject = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (localObject != null)
    {
      ((com.tencent.mm.remoteservice.d)localObject).connect((Runnable)EmojiCaptureService.b.qaL);
      AppMethodBeat.o(418);
      return;
    }
    AppMethodBeat.o(418);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(419);
    super.onDestroy();
    ae.i(this.TAG, "onDestroy: ");
    fqI();
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.qaI;
    EmojiCaptureProxy.a.clz();
    AppMethodBeat.o(419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService
 * JD-Core Version:    0.7.0.1
 */