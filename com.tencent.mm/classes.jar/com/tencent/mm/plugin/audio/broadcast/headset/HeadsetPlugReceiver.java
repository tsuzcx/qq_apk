package com.tencent.mm.plugin.audio.broadcast.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "isHeadsetPlugState", "", "onReceive", "", "p0", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "plugin-audio_release"})
public final class HeadsetPlugReceiver
  extends BroadcastReceiver
{
  public static final a mRb;
  private int mRa = -1;
  
  static
  {
    AppMethodBeat.i(198344);
    mRb = new a((byte)0);
    AppMethodBeat.o(198344);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(198343);
    int i;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("state", -1);
      if (paramIntent == null) {
        break label103;
      }
    }
    label103:
    for (int j = paramIntent.getIntExtra("microphone", -1);; j = 0)
    {
      ac.i("MicroMsg.HeadsetPlugReceiver", "onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((this.mRa == -1) || (this.mRa != i))
      {
        this.mRa = i;
        if (i != 0) {
          bool = true;
        }
        a.ig(bool);
      }
      AppMethodBeat.o(198343);
      return;
      i = 0;
      break;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugReceiver$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver
 * JD-Core Version:    0.7.0.1
 */