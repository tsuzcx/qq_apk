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
  boolean dgS;
  AudioRecord dhg;
  c.a dhh;
  byte[] dhr;
  private int dhs;
  int dht;
  private AudioRecord.OnRecordPositionUpdateListener dhu;
  private HandlerThread mHandlerThread;
  boolean mIsMute;
  
  public d(AudioRecord paramAudioRecord, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129995);
    this.mHandlerThread = null;
    this.dhr = null;
    this.dhu = new AudioRecord.OnRecordPositionUpdateListener()
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
        if (d.this.dhg != null)
        {
          if ((d.this.dgS) || (d.this.dhr == null)) {
            d.this.dhr = new byte[d.this.dht];
          }
          int j = d.this.dhg.read(d.this.dhr, 0, d.this.dht);
          ad.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(j)));
          if (d.this.dhp != null) {
            d.this.dhp.d(j, d.this.dhr);
          }
          int i = j;
          if (j > d.this.dhr.length) {
            i = d.this.dhr.length;
          }
          if ((d.this.mIsMute) && (i > 0)) {
            Arrays.fill(d.this.dhr, 0, i, (byte)0);
          }
          if ((d.this.dhh != null) && (i > 0)) {
            d.this.dhh.u(d.this.dhr, i);
          }
        }
        AppMethodBeat.o(129994);
      }
    };
    this.dhg = paramAudioRecord;
    this.dhh = parama;
    this.dgS = paramBoolean;
    this.dhs = paramInt1;
    this.dht = paramInt2;
    AppMethodBeat.o(129995);
  }
  
  public final boolean PP()
  {
    AppMethodBeat.i(129996);
    if (this.mHandlerThread != null)
    {
      ad.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
      AppMethodBeat.o(129996);
      return false;
    }
    this.mHandlerThread = com.tencent.e.c.d.gX("RecordModeAsyncCallback_handlerThread", 10);
    this.mHandlerThread.start();
    this.dhg.setRecordPositionUpdateListener(this.dhu, ap.createFreeHandler(this.mHandlerThread.getLooper()));
    this.dhg.setPositionNotificationPeriod(this.dhs);
    if ((this.dgS) || (this.dhr == null)) {
      this.dhr = new byte[this.dht];
    }
    int i = this.dhg.read(this.dhr, 0, this.dht);
    ad.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(i)));
    if ((this.dhh != null) && (i > 0)) {
      this.dhh.u(this.dhr, i);
    }
    AppMethodBeat.o(129996);
    return true;
  }
  
  public final void cw(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(129997);
    this.dhg.setRecordPositionUpdateListener(null);
    this.dhg = null;
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    AppMethodBeat.o(129997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.b.d
 * JD-Core Version:    0.7.0.1
 */