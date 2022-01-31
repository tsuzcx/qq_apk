package com.tencent.mm.f.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;

final class d$1
  implements AudioRecord.OnRecordPositionUpdateListener
{
  d$1(d paramd) {}
  
  public final void onMarkerReached(AudioRecord paramAudioRecord) {}
  
  public final void onPeriodicNotification(AudioRecord paramAudioRecord)
  {
    if (this.bDc.mIsPause) {}
    int i;
    do
    {
      do
      {
        return;
      } while (this.bDc.bCO == null);
      if ((this.bDc.bCA) || (this.bDc.bCY == null)) {
        this.bDc.bCY = new byte[this.bDc.bDa];
      }
      int j = this.bDc.bCO.read(this.bDc.bCY, 0, this.bDc.bDa);
      y.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: " + j);
      if (this.bDc.bCW != null) {
        this.bDc.bCW.d(j, this.bDc.bCY);
      }
      i = j;
      if (j > this.bDc.bCY.length) {
        i = this.bDc.bCY.length;
      }
      if ((this.bDc.mIsMute) && (i > 0)) {
        Arrays.fill(this.bDc.bCY, 0, i, (byte)0);
      }
    } while ((this.bDc.bCP == null) || (i <= 0));
    this.bDc.bCP.r(this.bDc.bCY, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.d.1
 * JD-Core Version:    0.7.0.1
 */