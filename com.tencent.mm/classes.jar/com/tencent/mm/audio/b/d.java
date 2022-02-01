package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Arrays;

public final class d
  extends f
{
  boolean dhU;
  AudioRecord dii;
  c.a dij;
  byte[] diu;
  private int div;
  int diw;
  private AudioRecord.OnRecordPositionUpdateListener dix;
  private HandlerThread mHandlerThread;
  boolean mIsMute;
  
  public d(AudioRecord paramAudioRecord, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129995);
    this.mHandlerThread = null;
    this.diu = null;
    this.dix = new AudioRecord.OnRecordPositionUpdateListener()
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
        if (d.this.dii != null)
        {
          if ((d.this.dhU) || (d.this.diu == null)) {
            d.this.diu = new byte[d.this.diw];
          }
          int j = d.this.dii.read(d.this.diu, 0, d.this.diw);
          ae.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(j)));
          if (d.this.dis != null) {
            d.this.dis.d(j, d.this.diu);
          }
          int i = j;
          if (j > d.this.diu.length) {
            i = d.this.diu.length;
          }
          if ((d.this.mIsMute) && (i > 0)) {
            Arrays.fill(d.this.diu, 0, i, (byte)0);
          }
          if ((d.this.dij != null) && (i > 0)) {
            d.this.dij.u(d.this.diu, i);
          }
        }
        AppMethodBeat.o(129994);
      }
    };
    this.dii = paramAudioRecord;
    this.dij = parama;
    this.dhU = paramBoolean;
    this.div = paramInt1;
    this.diw = paramInt2;
    AppMethodBeat.o(129995);
  }
  
  public final boolean PO()
  {
    AppMethodBeat.i(129996);
    if (this.mHandlerThread != null)
    {
      ae.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
      AppMethodBeat.o(129996);
      return false;
    }
    this.mHandlerThread = com.tencent.e.c.d.hg("RecordModeAsyncCallback_handlerThread", 10);
    this.mHandlerThread.start();
    this.dii.setRecordPositionUpdateListener(this.dix, aq.createFreeHandler(this.mHandlerThread.getLooper()));
    this.dii.setPositionNotificationPeriod(this.div);
    if ((this.dhU) || (this.diu == null)) {
      this.diu = new byte[this.diw];
    }
    int i = this.dii.read(this.diu, 0, this.diw);
    ae.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(i)));
    if ((this.dij != null) && (i > 0)) {
      this.dij.u(this.diu, i);
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
    this.dii.setRecordPositionUpdateListener(null);
    this.dii = null;
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    AppMethodBeat.o(129997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.d
 * JD-Core Version:    0.7.0.1
 */