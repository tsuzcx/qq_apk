package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;

final class d$1
  implements AudioRecord.OnRecordPositionUpdateListener
{
  d$1(d paramd) {}
  
  public final void onMarkerReached(AudioRecord paramAudioRecord) {}
  
  public final void onPeriodicNotification(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(55745);
    if (this.cjQ.mIsPause)
    {
      AppMethodBeat.o(55745);
      return;
    }
    if (this.cjQ.cjC != null)
    {
      if ((this.cjQ.cjo) || (this.cjQ.cjM == null)) {
        this.cjQ.cjM = new byte[this.cjQ.cjO];
      }
      int j = this.cjQ.cjC.read(this.cjQ.cjM, 0, this.cjQ.cjO);
      ab.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(j)));
      if (this.cjQ.cjK != null) {
        this.cjQ.cjK.d(j, this.cjQ.cjM);
      }
      int i = j;
      if (j > this.cjQ.cjM.length) {
        i = this.cjQ.cjM.length;
      }
      if ((this.cjQ.mIsMute) && (i > 0)) {
        Arrays.fill(this.cjQ.cjM, 0, i, (byte)0);
      }
      if ((this.cjQ.cjD != null) && (i > 0)) {
        this.cjQ.cjD.s(this.cjQ.cjM, i);
      }
    }
    AppMethodBeat.o(55745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.d.1
 * JD-Core Version:    0.7.0.1
 */