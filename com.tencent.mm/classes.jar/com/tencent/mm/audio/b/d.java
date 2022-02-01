package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.Arrays;

public final class d
  extends f
{
  boolean cVC;
  AudioRecord cVQ;
  c.a cVR;
  byte[] cWb;
  private int cWc;
  int cWd;
  private AudioRecord.OnRecordPositionUpdateListener cWe;
  private HandlerThread mHandlerThread;
  boolean mIsMute;
  
  public d(AudioRecord paramAudioRecord, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129995);
    this.mHandlerThread = null;
    this.cWb = null;
    this.cWe = new AudioRecord.OnRecordPositionUpdateListener()
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
        if (d.this.cVQ != null)
        {
          if ((d.this.cVC) || (d.this.cWb == null)) {
            d.this.cWb = new byte[d.this.cWd];
          }
          int j = d.this.cVQ.read(d.this.cWb, 0, d.this.cWd);
          ac.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(j)));
          if (d.this.cVZ != null) {
            d.this.cVZ.d(j, d.this.cWb);
          }
          int i = j;
          if (j > d.this.cWb.length) {
            i = d.this.cWb.length;
          }
          if ((d.this.mIsMute) && (i > 0)) {
            Arrays.fill(d.this.cWb, 0, i, (byte)0);
          }
          if ((d.this.cVR != null) && (i > 0)) {
            d.this.cVR.u(d.this.cWb, i);
          }
        }
        AppMethodBeat.o(129994);
      }
    };
    this.cVQ = paramAudioRecord;
    this.cVR = parama;
    this.cVC = paramBoolean;
    this.cWc = paramInt1;
    this.cWd = paramInt2;
    AppMethodBeat.o(129995);
  }
  
  public final boolean Og()
  {
    AppMethodBeat.i(129996);
    if (this.mHandlerThread != null)
    {
      ac.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
      AppMethodBeat.o(129996);
      return false;
    }
    this.mHandlerThread = com.tencent.e.c.d.gz("RecordModeAsyncCallback_handlerThread", 10);
    this.mHandlerThread.start();
    this.cVQ.setRecordPositionUpdateListener(this.cWe, ao.createFreeHandler(this.mHandlerThread.getLooper()));
    this.cVQ.setPositionNotificationPeriod(this.cWc);
    if ((this.cVC) || (this.cWb == null)) {
      this.cWb = new byte[this.cWd];
    }
    int i = this.cVQ.read(this.cWb, 0, this.cWd);
    ac.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(i)));
    if ((this.cVR != null) && (i > 0)) {
      this.cVR.u(this.cWb, i);
    }
    AppMethodBeat.o(129996);
    return true;
  }
  
  public final void cu(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(129997);
    this.cVQ.setRecordPositionUpdateListener(null);
    this.cVQ = null;
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    AppMethodBeat.o(129997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.d
 * JD-Core Version:    0.7.0.1
 */