package com.tencent.mm.plugin.collect.model.voice;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$a
  implements Runnable
{
  private b$a(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(41026);
    try
    {
      this.kOz.mText = this.kOz.mText.replaceAll("[^0-9a-zA-Z一-龥.?!,;:。？！，、；：@%&/]+", "");
      ab.d("MicroMsg.OfflineVoice.InnerSynthesizer", "mText = %s  mVolume = %s mSpeed = %s", new Object[] { this.kOz.mText, Float.valueOf(this.kOz.mVolume), Float.valueOf(this.kOz.Dq) });
      int i = this.kOz.kOv.readmoney(this.kOz.mText.getBytes("UTF-8"), this.kOz.kOy, this.kOz.kOx, this.kOz.mVolume, this.kOz.Dq);
      if (i != -1)
      {
        byte[] arrayOfByte = new byte[i];
        System.arraycopy(this.kOz.kOy, 0, arrayOfByte, 0, i);
        if (!this.kOz.kOw)
        {
          Message localMessage = this.kOz.mHandler.obtainMessage(0);
          Bundle localBundle = new Bundle();
          localBundle.putByteArray("data", arrayOfByte);
          localMessage.setData(localBundle);
          this.kOz.mHandler.sendMessage(localMessage);
        }
        AppMethodBeat.o(41026);
        return;
      }
      this.kOz.mHandler.sendMessage(this.kOz.mHandler.obtainMessage(-1));
      AppMethodBeat.o(41026);
      return;
    }
    catch (Exception localException)
    {
      ab.i("MicroMsg.OfflineVoice.InnerSynthesizer", "SynthesizerRunnable Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      this.kOz.mHandler.sendMessage(this.kOz.mHandler.obtainMessage(-1));
      AppMethodBeat.o(41026);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.b.a
 * JD-Core Version:    0.7.0.1
 */