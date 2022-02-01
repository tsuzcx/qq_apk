package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.Context;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.service.MMService;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService;", "Lcom/tencent/mm/service/MMService;", "()V", "TAG", "", "onCreate", "", "onDestroy", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureService
  extends MMService
{
  public static final a oNf;
  private final String TAG = "MicroMsg.EmojiCaptureService";
  
  static
  {
    AppMethodBeat.i(420);
    oNf = new a((byte)0);
    AppMethodBeat.o(420);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(418);
    super.onCreate();
    ad.i(this.TAG, "onCreate: ");
    if (com.tencent.mm.compatible.util.d.lf(26)) {
      startForeground(-2564, a.bD(aj.getContext(), "reminder_channel_id").as(a.cYf()).g((CharSequence)aj.getContext().getString(2131758227)).build());
    }
    Object localObject = EmojiCaptureProxy.oNd;
    EmojiCaptureProxy.a.aba();
    localObject = EmojiCaptureProxy.oNd;
    localObject = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (localObject != null)
    {
      ((com.tencent.mm.remoteservice.d)localObject).connect((Runnable)EmojiCaptureService.b.oNg);
      AppMethodBeat.o(418);
      return;
    }
    AppMethodBeat.o(418);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(419);
    super.onDestroy();
    ad.i(this.TAG, "onDestroy: ");
    eHH();
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.oNd;
    EmojiCaptureProxy.a.bYs();
    AppMethodBeat.o(419);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService$Companion;", "", "()V", "NOTIFY_ID", "", "plugin-emojicapture_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService
 * JD-Core Version:    0.7.0.1
 */