package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.Context;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.service.MMService;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService;", "Lcom/tencent/mm/service/MMService;", "()V", "TAG", "", "onCreate", "", "onDestroy", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureService
  extends MMService
{
  public static final EmojiCaptureService.a pqz;
  private final String TAG = "MicroMsg.EmojiCaptureService";
  
  static
  {
    AppMethodBeat.i(420);
    pqz = new EmojiCaptureService.a((byte)0);
    AppMethodBeat.o(420);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(418);
    super.onCreate();
    ac.i(this.TAG, "onCreate: ");
    if (com.tencent.mm.compatible.util.d.kZ(26)) {
      startForeground(-2564, a.bE(ai.getContext(), "reminder_channel_id").as(a.dlN()).g((CharSequence)ai.getContext().getString(2131758227)).build());
    }
    Object localObject = EmojiCaptureProxy.pqx;
    EmojiCaptureProxy.a.cfF();
    localObject = EmojiCaptureProxy.pqx;
    localObject = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (localObject != null)
    {
      ((com.tencent.mm.remoteservice.d)localObject).connect((Runnable)EmojiCaptureService.b.pqA);
      AppMethodBeat.o(418);
      return;
    }
    AppMethodBeat.o(418);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(419);
    super.onDestroy();
    ac.i(this.TAG, "onDestroy: ");
    eXd();
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.pqx;
    EmojiCaptureProxy.a.cfG();
    AppMethodBeat.o(419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService
 * JD-Core Version:    0.7.0.1
 */