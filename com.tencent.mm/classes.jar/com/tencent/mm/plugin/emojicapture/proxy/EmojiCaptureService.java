package com.tencent.mm.plugin.emojicapture.proxy;

import android.app.Notification;
import android.content.Context;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.service.MMService;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService;", "Lcom/tencent/mm/service/MMService;", "()V", "TAG", "", "onCreate", "", "onDestroy", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiCaptureService
  extends MMService
{
  public static final EmojiCaptureService.a yjD;
  private final String TAG = "MicroMsg.EmojiCaptureService";
  
  static
  {
    AppMethodBeat.i(420);
    yjD = new EmojiCaptureService.a((byte)0);
    AppMethodBeat.o(420);
  }
  
  private static final void dEB() {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(418);
    super.onCreate();
    Log.i(this.TAG, "onCreate: ");
    if (com.tencent.mm.compatible.util.d.rb(26))
    {
      localObject = a.cA(MMApplicationContext.getContext(), "reminder_channel_id").eb(a.guX()).m((CharSequence)MMApplicationContext.getContext().getString(a.i.yfN)).DA();
      s.s(localObject, "getNotificationBuilder(\n…                 .build()");
      d(-2564, (Notification)localObject);
    }
    Object localObject = EmojiCaptureProxy.yjA;
    EmojiCaptureProxy.a.dEz();
    localObject = EmojiCaptureProxy.yjA;
    localObject = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (localObject != null) {
      ((com.tencent.mm.remoteservice.d)localObject).connect(EmojiCaptureService..ExternalSyntheticLambda0.INSTANCE);
    }
    AppMethodBeat.o(418);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(419);
    super.onDestroy();
    Log.i(this.TAG, "onDestroy: ");
    iUE();
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.yjA;
    EmojiCaptureProxy.a.dEA();
    AppMethodBeat.o(419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService
 * JD-Core Version:    0.7.0.1
 */