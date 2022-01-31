package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class d
  extends f
{
  AudioRecord cjC;
  c.a cjD;
  byte[] cjM;
  private int cjN;
  int cjO;
  private AudioRecord.OnRecordPositionUpdateListener cjP;
  boolean cjo;
  private HandlerThread mHandlerThread;
  boolean mIsMute;
  
  public d(AudioRecord paramAudioRecord, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55746);
    this.mHandlerThread = null;
    this.cjM = null;
    this.cjP = new d.1(this);
    this.cjC = paramAudioRecord;
    this.cjD = parama;
    this.cjo = paramBoolean;
    this.cjN = paramInt1;
    this.cjO = paramInt2;
    AppMethodBeat.o(55746);
  }
  
  public final boolean EC()
  {
    AppMethodBeat.i(55747);
    if (this.mHandlerThread != null)
    {
      ab.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
      AppMethodBeat.o(55747);
      return false;
    }
    this.mHandlerThread = com.tencent.mm.sdk.g.d.ey("RecordModeAsyncCallback_handlerThread", 10);
    this.mHandlerThread.start();
    this.cjC.setRecordPositionUpdateListener(this.cjP, ak.fetchFreeHandler(this.mHandlerThread.getLooper()));
    this.cjC.setPositionNotificationPeriod(this.cjN);
    if ((this.cjo) || (this.cjM == null)) {
      this.cjM = new byte[this.cjO];
    }
    int i = this.cjC.read(this.cjM, 0, this.cjO);
    ab.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(i)));
    if ((this.cjD != null) && (i > 0)) {
      this.cjD.s(this.cjM, i);
    }
    AppMethodBeat.o(55747);
    return true;
  }
  
  public final void bB(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(55748);
    this.cjC.setRecordPositionUpdateListener(null);
    this.cjC = null;
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    AppMethodBeat.o(55748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.b.d
 * JD-Core Version:    0.7.0.1
 */