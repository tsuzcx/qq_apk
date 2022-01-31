package com.tencent.mm.f.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends f
{
  boolean bCA;
  AudioRecord bCO;
  c.a bCP;
  byte[] bCY = null;
  private int bCZ;
  int bDa;
  private AudioRecord.OnRecordPositionUpdateListener bDb = new d.1(this);
  private HandlerThread mHandlerThread = null;
  boolean mIsMute;
  
  public d(AudioRecord paramAudioRecord, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.bCO = paramAudioRecord;
    this.bCP = parama;
    this.bCA = paramBoolean;
    this.bCZ = paramInt1;
    this.bDa = paramInt2;
  }
  
  public final void aZ(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    this.bCO.setRecordPositionUpdateListener(null);
    this.bCO = null;
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
  }
  
  public final boolean uq()
  {
    if (this.mHandlerThread != null)
    {
      y.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
      return false;
    }
    this.mHandlerThread = e.ds("RecordModeAsyncCallback_handlerThread", 10);
    this.mHandlerThread.start();
    this.bCO.setRecordPositionUpdateListener(this.bDb, ah.fetchFreeHandler(this.mHandlerThread.getLooper()));
    this.bCO.setPositionNotificationPeriod(this.bCZ);
    if ((this.bCA) || (this.bCY == null)) {
      this.bCY = new byte[this.bDa];
    }
    int i = this.bCO.read(this.bCY, 0, this.bDa);
    y.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: " + i);
    if ((this.bCP != null) && (i > 0)) {
      this.bCP.r(this.bCY, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.d
 * JD-Core Version:    0.7.0.1
 */