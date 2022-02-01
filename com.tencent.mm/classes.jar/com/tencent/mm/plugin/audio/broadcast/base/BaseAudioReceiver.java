package com.tencent.mm.plugin.audio.broadcast.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/broadcast/base/BaseAudioReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "p0", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "plugin-audio_release"})
public final class BaseAudioReceiver
  extends BroadcastReceiver
{
  public static final a oHD;
  
  static
  {
    AppMethodBeat.i(223937);
    oHD = new a((byte)0);
    AppMethodBeat.o(223937);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(223936);
    Log.i("MicroMsg.BaseAudioReceiver", "onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
    paramContext = a.oHC;
    a.cdR();
    AppMethodBeat.o(223936);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/broadcast/base/BaseAudioReceiver$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver
 * JD-Core Version:    0.7.0.1
 */