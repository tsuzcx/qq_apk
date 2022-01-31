package com.tencent.mm.plugin.emojicapture.proxy;

import a.l;
import android.content.Context;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.service.MMService;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService;", "Lcom/tencent/mm/service/MMService;", "()V", "TAG", "", "onCreate", "", "onDestroy", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureService
  extends MMService
{
  public static final a lwK;
  private final String TAG = "MicroMsg.EmojiCaptureService";
  
  static
  {
    AppMethodBeat.i(2842);
    lwK = new a((byte)0);
    AppMethodBeat.o(2842);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(2840);
    super.onCreate();
    ab.i(this.TAG, "onCreate: ");
    if (com.tencent.mm.compatible.util.d.fv(26)) {
      startForeground(-2564, a.br(ah.getContext(), "reminder_channel_id").Y(a.bYt()).f((CharSequence)ah.getContext().getString(2131299115)).build());
    }
    Object localObject = EmojiCaptureProxy.lwI;
    EmojiCaptureProxy.a.boO();
    localObject = EmojiCaptureProxy.lwI;
    localObject = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (localObject != null)
    {
      ((com.tencent.mm.remoteservice.d)localObject).connect((Runnable)b.lwL);
      AppMethodBeat.o(2840);
      return;
    }
    AppMethodBeat.o(2840);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(2841);
    super.onDestroy();
    ab.i(this.TAG, "onDestroy: ");
    duS();
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.lwI;
    EmojiCaptureProxy.a.boP();
    AppMethodBeat.o(2841);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService$Companion;", "", "()V", "NOTIFY_ID", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b lwL;
    
    static
    {
      AppMethodBeat.i(2839);
      lwL = new b();
      AppMethodBeat.o(2839);
    }
    
    public final void run() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService
 * JD-Core Version:    0.7.0.1
 */