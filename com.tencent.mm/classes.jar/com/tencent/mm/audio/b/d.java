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
  byte[] dzF;
  private int dzG;
  int dzH;
  private AudioRecord.OnRecordPositionUpdateListener dzI;
  boolean dzg;
  AudioRecord dzu;
  c.a dzv;
  private HandlerThread mHandlerThread;
  boolean mIsMute;
  
  public d(AudioRecord paramAudioRecord, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129995);
    this.mHandlerThread = null;
    this.dzF = null;
    this.dzI = new AudioRecord.OnRecordPositionUpdateListener()
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
        if (d.this.dzu != null)
        {
          if ((d.this.dzg) || (d.this.dzF == null)) {
            d.this.dzF = new byte[d.this.dzH];
          }
          int j = d.this.dzu.read(d.this.dzF, 0, d.this.dzH);
          Log.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(j)));
          if (d.this.dzD != null) {
            d.this.dzD.d(j, d.this.dzF);
          }
          int i = j;
          if (j > d.this.dzF.length) {
            i = d.this.dzF.length;
          }
          if ((d.this.mIsMute) && (i > 0)) {
            Arrays.fill(d.this.dzF, 0, i, (byte)0);
          }
          if ((d.this.dzv != null) && (i > 0)) {
            d.this.dzv.w(d.this.dzF, i);
          }
        }
        AppMethodBeat.o(129994);
      }
    };
    this.dzu = paramAudioRecord;
    this.dzv = parama;
    this.dzg = paramBoolean;
    this.dzG = paramInt1;
    this.dzH = paramInt2;
    AppMethodBeat.o(129995);
  }
  
  public final boolean aai()
  {
    AppMethodBeat.i(129996);
    if (this.mHandlerThread != null)
    {
      Log.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
      AppMethodBeat.o(129996);
      return false;
    }
    this.mHandlerThread = com.tencent.f.c.d.hA("RecordModeAsyncCallback_handlerThread", 10);
    this.mHandlerThread.start();
    this.dzu.setRecordPositionUpdateListener(this.dzI, MMHandler.createFreeHandler(this.mHandlerThread.getLooper()));
    this.dzu.setPositionNotificationPeriod(this.dzG);
    if ((this.dzg) || (this.dzF == null)) {
      this.dzF = new byte[this.dzH];
    }
    int i = this.dzu.read(this.dzF, 0, this.dzH);
    Log.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(i)));
    if ((this.dzv != null) && (i > 0)) {
      this.dzv.w(this.dzF, i);
    }
    AppMethodBeat.o(129996);
    return true;
  }
  
  public final void de(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(129997);
    this.dzu.setRecordPositionUpdateListener(null);
    this.dzu = null;
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    AppMethodBeat.o(129997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.d
 * JD-Core Version:    0.7.0.1
 */