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
  byte[] hwK;
  private int hwL;
  int hwM;
  private AudioRecord.OnRecordPositionUpdateListener hwN;
  boolean hwj;
  AudioRecord hwx;
  c.a hwy;
  private HandlerThread mHandlerThread;
  boolean mIsMute;
  
  public d(AudioRecord paramAudioRecord, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129995);
    this.mHandlerThread = null;
    this.hwK = null;
    this.hwN = new AudioRecord.OnRecordPositionUpdateListener()
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
        if (d.this.hwx != null)
        {
          if ((d.this.hwj) || (d.this.hwK == null)) {
            d.this.hwK = new byte[d.this.hwM];
          }
          int j = d.this.hwx.read(d.this.hwK, 0, d.this.hwM);
          Log.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(j)));
          if (d.this.hwI != null) {
            d.this.hwI.d(j, d.this.hwK);
          }
          int i = j;
          if (j > d.this.hwK.length) {
            i = d.this.hwK.length;
          }
          if ((d.this.mIsMute) && (i > 0)) {
            Arrays.fill(d.this.hwK, 0, i, (byte)0);
          }
          if ((d.this.hwy != null) && (i > 0)) {
            d.this.hwy.u(d.this.hwK, i);
          }
        }
        AppMethodBeat.o(129994);
      }
    };
    this.hwx = paramAudioRecord;
    this.hwy = parama;
    this.hwj = paramBoolean;
    this.hwL = paramInt1;
    this.hwM = paramInt2;
    AppMethodBeat.o(129995);
  }
  
  public final boolean aGR()
  {
    AppMethodBeat.i(129996);
    if (this.mHandlerThread != null)
    {
      Log.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
      AppMethodBeat.o(129996);
      return false;
    }
    this.mHandlerThread = com.tencent.threadpool.c.d.jw("RecordModeAsyncCallback_handlerThread", 10);
    this.mHandlerThread.start();
    this.hwx.setRecordPositionUpdateListener(this.hwN, MMHandler.createFreeHandler(this.mHandlerThread.getLooper()));
    this.hwx.setPositionNotificationPeriod(this.hwL);
    if ((this.hwj) || (this.hwK == null)) {
      this.hwK = new byte[this.hwM];
    }
    int i = this.hwx.read(this.hwK, 0, this.hwM);
    Log.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(i)));
    if ((this.hwy != null) && (i > 0)) {
      this.hwy.u(this.hwK, i);
    }
    AppMethodBeat.o(129996);
    return true;
  }
  
  public final void eq(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(129997);
    this.hwx.setRecordPositionUpdateListener(null);
    this.hwx = null;
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    AppMethodBeat.o(129997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.b.d
 * JD-Core Version:    0.7.0.1
 */