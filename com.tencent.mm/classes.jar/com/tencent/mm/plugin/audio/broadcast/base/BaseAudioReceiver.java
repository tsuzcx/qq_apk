package com.tencent.mm.plugin.audio.broadcast.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/broadcast/base/BaseAudioReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "p0", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "plugin-audio_release"})
public final class BaseAudioReceiver
  extends BroadcastReceiver
{
  public static final a mQV;
  
  static
  {
    AppMethodBeat.i(198334);
    mQV = new a((byte)0);
    AppMethodBeat.o(198334);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(198333);
    ac.i("MicroMsg.BaseAudioReceiver", "onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
    paramContext = a.mQU;
    a.bCo();
    AppMethodBeat.o(198333);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/broadcast/base/BaseAudioReceiver$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver
 * JD-Core Version:    0.7.0.1
 */