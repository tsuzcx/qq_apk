package com.tencent.mm.plugin.ipcall.a.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public boolean isStart;
  public c kJR;
  public final Object nNF;
  public int nNG;
  public boolean nNH;
  
  public a()
  {
    AppMethodBeat.i(21800);
    this.kJR = null;
    this.nNF = new Object();
    this.isStart = false;
    this.nNG = 0;
    this.nNH = false;
    AppMethodBeat.o(21800);
  }
  
  public static boolean KM()
  {
    AppMethodBeat.i(156902);
    boolean bool = aw.aaA().elW.isSpeakerphoneOn();
    AppMethodBeat.o(156902);
    return bool;
  }
  
  private void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(21802);
    if ((this.kJR != null) && (this.kJR.ttj)) {
      this.kJR.mJ(paramBoolean);
    }
    AppMethodBeat.o(21802);
  }
  
  public final void iE(boolean paramBoolean)
  {
    AppMethodBeat.i(21801);
    ab.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(this.nNH), Boolean.valueOf(paramBoolean) });
    aw.aaA().bN(paramBoolean);
    i.bJo().iE(paramBoolean);
    if (paramBoolean != this.nNH)
    {
      this.nNH = paramBoolean;
      iF(paramBoolean);
    }
    AppMethodBeat.o(21801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.a
 * JD-Core Version:    0.7.0.1
 */