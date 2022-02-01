package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Arrays;

public final class d
  extends f
{
  byte[] cYF;
  private int cYG;
  int cYH;
  private AudioRecord.OnRecordPositionUpdateListener cYI;
  boolean cYg;
  AudioRecord cYu;
  c.a cYv;
  private HandlerThread mHandlerThread;
  boolean mIsMute;
  
  public d(AudioRecord paramAudioRecord, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129995);
    this.mHandlerThread = null;
    this.cYF = null;
    this.cYI = new AudioRecord.OnRecordPositionUpdateListener()
    {
      public final void onMarkerReached(AudioRecord paramAnonymousAudioRecord) {}
      
      public final void onPeriodicNotification(AudioRecord paramAnonymousAudioRecord)
      {
        AppMethodBeat.i(129994);
        if (d.this.mIsPause)
        {
          AppMethodBeat.o(129994);
          return;
        }
        if (d.this.cYu != null)
        {
          if ((d.this.cYg) || (d.this.cYF == null)) {
            d.this.cYF = new byte[d.this.cYH];
          }
          int j = d.this.cYu.read(d.this.cYF, 0, d.this.cYH);
          ad.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(j)));
          if (d.this.cYD != null) {
            d.this.cYD.d(j, d.this.cYF);
          }
          int i = j;
          if (j > d.this.cYF.length) {
            i = d.this.cYF.length;
          }
          if ((d.this.mIsMute) && (i > 0)) {
            Arrays.fill(d.this.cYF, 0, i, (byte)0);
          }
          if ((d.this.cYv != null) && (i > 0)) {
            d.this.cYv.w(d.this.cYF, i);
          }
        }
        AppMethodBeat.o(129994);
      }
    };
    this.cYu = paramAudioRecord;
    this.cYv = parama;
    this.cYg = paramBoolean;
    this.cYG = paramInt1;
    this.cYH = paramInt2;
    AppMethodBeat.o(129995);
  }
  
  public final boolean Ok()
  {
    AppMethodBeat.i(129996);
    if (this.mHandlerThread != null)
    {
      ad.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
      AppMethodBeat.o(129996);
      return false;
    }
    this.mHandlerThread = com.tencent.e.c.d.gv("RecordModeAsyncCallback_handlerThread", 10);
    this.mHandlerThread.start();
    this.cYu.setRecordPositionUpdateListener(this.cYI, ap.createFreeHandler(this.mHandlerThread.getLooper()));
    this.cYu.setPositionNotificationPeriod(this.cYG);
    if ((this.cYg) || (this.cYF == null)) {
      this.cYF = new byte[this.cYH];
    }
    int i = this.cYu.read(this.cYF, 0, this.cYH);
    ad.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(i)));
    if ((this.cYv != null) && (i > 0)) {
      this.cYv.w(this.cYF, i);
    }
    AppMethodBeat.o(129996);
    return true;
  }
  
  public final void ct(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(129997);
    this.cYu.setRecordPositionUpdateListener(null);
    this.cYu = null;
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    AppMethodBeat.o(129997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.d
 * JD-Core Version:    0.7.0.1
 */