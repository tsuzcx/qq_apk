package com.tencent.mm.plugin.audio.broadcast.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/broadcast/base/BaseAudioReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "p0", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "plugin-audio_release"})
public final class BaseAudioReceiver
  extends BroadcastReceiver
{
  public static final a nwN;
  
  static
  {
    AppMethodBeat.i(201044);
    nwN = new a((byte)0);
    AppMethodBeat.o(201044);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(201043);
    ae.i("MicroMsg.BaseAudioReceiver", "onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
    paramContext = a.nwM;
    a.bHp();
    AppMethodBeat.o(201043);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/broadcast/base/BaseAudioReceiver$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver
 * JD-Core Version:    0.7.0.1
 */