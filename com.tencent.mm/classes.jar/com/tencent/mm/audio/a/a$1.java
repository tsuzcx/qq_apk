package com.tencent.mm.audio.a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$1
  implements b.a
{
  a$1(a parama) {}
  
  public final void gz(int paramInt)
  {
    AppMethodBeat.i(116448);
    ab.i("MicroMsg.SceneVoicePlayer", "on audio focus chage: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == -2) || (paramInt == -3))
    {
      if (this.ciw.isPlaying())
      {
        ab.v("MicroMsg.SceneVoicePlayer", "alvinluo current fileName: %s, lastFileName: %s", new Object[] { a.a(this.ciw), a.access$100() });
        if ((a.a(this.ciw) == null) || (a.a(this.ciw).equals(a.access$100())))
        {
          if (bo.hl(((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVN, 0), 0))
          {
            if ((paramInt == -3) && (d.fv(26)))
            {
              ab.i("MicroMsg.SceneVoicePlayer", "focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
              AppMethodBeat.o(116448);
            }
          }
          else {
            ab.i("MicroMsg.SceneVoicePlayer", "no shield");
          }
          this.ciw.bw(false);
          AppMethodBeat.o(116448);
        }
      }
    }
    else
    {
      if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3))
      {
        this.ciw.Eo();
        AppMethodBeat.o(116448);
        return;
      }
      if (paramInt == -1) {
        this.ciw.stop(false);
      }
    }
    AppMethodBeat.o(116448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.a.a.1
 * JD-Core Version:    0.7.0.1
 */