package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class j$2
  implements MediaPlayer.OnErrorListener
{
  j$2(j paramj) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.SpeexPlayer", "onError");
    if ((this.eKM.bBs != null) && (this.eKM.eKt)) {
      this.eKM.bBs.zE();
    }
    if (this.eKM.eKA != null) {
      this.eKM.eKA.onError();
    }
    try
    {
      this.eKM.status = -1;
      this.eKM.Te();
      try
      {
        j.a(this.eKM);
        return false;
      }
      catch (InterruptedException paramMediaPlayer)
      {
        y.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bk.j(paramMediaPlayer) });
        return false;
      }
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      y.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + this.eKM.fileName + "] ErrMsg[" + paramMediaPlayer.getStackTrace() + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.j.2
 * JD-Core Version:    0.7.0.1
 */