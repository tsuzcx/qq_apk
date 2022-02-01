package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Arrays;

public final class d
  extends f
{
  boolean frV;
  AudioRecord fsj;
  c.a fsk;
  byte[] fsu;
  private int fsv;
  int fsw;
  private AudioRecord.OnRecordPositionUpdateListener fsx;
  private HandlerThread mHandlerThread;
  boolean mIsMute;
  
  public d(AudioRecord paramAudioRecord, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129995);
    this.mHandlerThread = null;
    this.fsu = null;
    this.fsx = new AudioRecord.OnRecordPositionUpdateListener()
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
        if (d.this.fsj != null)
        {
          if ((d.this.frV) || (d.this.fsu == null)) {
            d.this.fsu = new byte[d.this.fsw];
          }
          int j = d.this.fsj.read(d.this.fsu, 0, d.this.fsw);
          Log.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(j)));
          if (d.this.fss != null) {
            d.this.fss.d(j, d.this.fsu);
          }
          int i = j;
          if (j > d.this.fsu.length) {
            i = d.this.fsu.length;
          }
          if ((d.this.mIsMute) && (i > 0)) {
            Arrays.fill(d.this.fsu, 0, i, (byte)0);
          }
          if ((d.this.fsk != null) && (i > 0)) {
            d.this.fsk.w(d.this.fsu, i);
          }
        }
        AppMethodBeat.o(129994);
      }
    };
    this.fsj = paramAudioRecord;
    this.fsk = parama;
    this.frV = paramBoolean;
    this.fsv = paramInt1;
    this.fsw = paramInt2;
    AppMethodBeat.o(129995);
  }
  
  public final boolean aeU()
  {
    AppMethodBeat.i(129996);
    if (this.mHandlerThread != null)
    {
      Log.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
      AppMethodBeat.o(129996);
      return false;
    }
    this.mHandlerThread = com.tencent.e.c.d.ik("RecordModeAsyncCallback_handlerThread", 10);
    this.mHandlerThread.start();
    this.fsj.setRecordPositionUpdateListener(this.fsx, MMHandler.createFreeHandler(this.mHandlerThread.getLooper()));
    this.fsj.setPositionNotificationPeriod(this.fsv);
    if ((this.frV) || (this.fsu == null)) {
      this.fsu = new byte[this.fsw];
    }
    int i = this.fsj.read(this.fsu, 0, this.fsw);
    Log.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(i)));
    if ((this.fsk != null) && (i > 0)) {
      this.fsk.w(this.fsu, i);
    }
    AppMethodBeat.o(129996);
    return true;
  }
  
  public final void dE(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(129997);
    this.fsj.setRecordPositionUpdateListener(null);
    this.fsj = null;
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    AppMethodBeat.o(129997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.b.d
 * JD-Core Version:    0.7.0.1
 */