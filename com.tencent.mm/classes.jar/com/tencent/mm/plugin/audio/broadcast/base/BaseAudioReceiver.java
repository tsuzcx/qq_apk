package com.tencent.mm.plugin.audio.broadcast.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/broadcast/base/BaseAudioReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "p0", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "plugin-audio_release"})
public final class BaseAudioReceiver
  extends BroadcastReceiver
{
  public static final a nru;
  
  static
  {
    AppMethodBeat.i(199732);
    nru = new a((byte)0);
    AppMethodBeat.o(199732);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199731);
    ad.i("MicroMsg.BaseAudioReceiver", "onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
    paramContext = a.nrt;
    a.bGt();
    AppMethodBeat.o(199731);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/broadcast/base/BaseAudioReceiver$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver
 * JD-Core Version:    0.7.0.1
 */