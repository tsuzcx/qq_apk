package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.SystemClock;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.model.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  implements f.a, HeadsetPlugReceiver.a
{
  boolean bSr = false;
  com.tencent.mm.compatible.util.b eLi = new com.tencent.mm.compatible.util.b(ae.getContext());
  com.tencent.mm.plugin.voip.model.b iEF = null;
  final Object iEG = new Object();
  HeadsetPlugReceiver iEH = new HeadsetPlugReceiver();
  boolean iEI = false;
  boolean iEJ = false;
  private int iEK;
  g.a iEL = new g.a();
  boolean iEM = false;
  
  public final int a(a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (this.iEG)
    {
      if (this.bSr)
      {
        y.d("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, already start");
        return -1;
      }
      y.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.iEF == null)
      {
        this.iEF = new com.tencent.mm.plugin.voip.model.b();
        this.iEF.z(paramInt1, paramInt2, paramInt3, 0);
      }
      this.iEF.t(ae.getContext(), false);
      this.iEF.pNy = parama;
      this.iEL.dzS = SystemClock.elapsedRealtime();
      paramInt1 = this.iEF.bPD();
      y.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlaying cost: " + this.iEL.zJ());
      y.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "set start play");
      this.bSr = true;
      y.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      return paramInt1;
    }
  }
  
  final boolean eG(boolean paramBoolean)
  {
    boolean bool2 = false;
    y.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    f.yi().bn(paramBoolean);
    boolean bool1 = bool2;
    if (this.iEF != null)
    {
      bool1 = bool2;
      if (this.iEF.pNn) {
        bool1 = this.iEF.jQ(paramBoolean);
      }
    }
    return bool1;
  }
  
  public final void eH(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (this.iEI != paramBoolean)
    {
      this.iEI = paramBoolean;
      y.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "onHeadsetState: isHeadsetPlugged: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(this.iEI), Boolean.valueOf(this.iEJ) });
      if (this.iEI) {
        break label81;
      }
      paramBoolean = bool2;
      if (!this.iEJ) {
        break label86;
      }
      paramBoolean = bool1;
    }
    label81:
    label86:
    for (;;)
    {
      this.iEM &= eG(paramBoolean);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public final void ew(int paramInt)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "onBluetoothHeadsetStateChange, status: %d, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.bSr) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.iEK = paramInt;
      return;
      this.iEJ = true;
      f.yi().yk();
      continue;
      if (paramInt != this.iEK)
      {
        this.iEJ = true;
        this.iEM &= eG(false);
        continue;
        if (paramInt != this.iEK)
        {
          this.iEJ = false;
          this.iEM &= eG(true);
          continue;
          if (paramInt != this.iEK)
          {
            this.iEJ = false;
            f.yi().yl();
            this.iEM &= eG(true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.d
 * JD-Core Version:    0.7.0.1
 */