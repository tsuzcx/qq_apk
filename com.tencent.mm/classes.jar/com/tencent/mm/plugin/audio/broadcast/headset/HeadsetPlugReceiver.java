package com.tencent.mm.plugin.audio.broadcast.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "isHeadsetPlugState", "", "onReceive", "", "p0", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HeadsetPlugReceiver
  extends BroadcastReceiver
{
  public static final a uUT;
  private int uUU = -1;
  
  static
  {
    AppMethodBeat.i(263788);
    uUT = new a((byte)0);
    AppMethodBeat.o(263788);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(263801);
    int i;
    if (paramIntent == null)
    {
      i = 0;
      if (paramIntent != null) {
        break label97;
      }
    }
    label97:
    for (int j = 0;; j = paramIntent.getIntExtra("microphone", -1))
    {
      Log.i("MicroMsg.HeadsetPlugReceiver", "onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((this.uUU == -1) || (this.uUU != i))
      {
        this.uUU = i;
        if (i != 0) {
          bool = true;
        }
        a.lM(bool);
      }
      AppMethodBeat.o(263801);
      return;
      i = paramIntent.getIntExtra("state", -1);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugReceiver$Companion;", "", "()V", "TAG", "", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver
 * JD-Core Version:    0.7.0.1
 */