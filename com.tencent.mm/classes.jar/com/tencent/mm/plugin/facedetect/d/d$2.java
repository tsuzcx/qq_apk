package com.tencent.mm.plugin.facedetect.d;

import android.os.CountDownTimer;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  extends CountDownTimer
{
  d$2(d paramd)
  {
    super(9223372036854775807L, 1000L);
  }
  
  public final void onFinish()
  {
    y.i("MicroMsg.NumberFaceMotion", "hy: on count number finished");
  }
  
  public final void onTick(long paramLong)
  {
    y.i("MicroMsg.NumberFaceMotion", "hy: on ticked");
    if (this.jPM.inQ)
    {
      y.w("MicroMsg.NumberFaceMotion", "hy: isEnd. trigger cancel");
      cancel();
      return;
    }
    if (this.jPM.jPz)
    {
      y.i("MicroMsg.NumberFaceMotion", "hy: suspend.");
      return;
    }
    y.i("MicroMsg.NumberFaceMotion", "hy: mCurrentShowedIndexInItem: %d, mItemDatas[mCurrentGroupDataIndex].length() - 1: %d, mCurrentGroupDataIndex: %d, mItemDatas.length - 1 : %d", new Object[] { Integer.valueOf(this.jPM.jPu), Integer.valueOf(this.jPM.jPs[this.jPM.jPt].length() - 1), Integer.valueOf(this.jPM.jPt), Integer.valueOf(this.jPM.jPs.length - 1) });
    if (this.jPM.jPu < this.jPM.jPs[this.jPM.jPt].length() - 1)
    {
      d locald = this.jPM;
      locald.jPu += 1;
      this.jPM.jPJ.sendEmptyMessage(0);
      return;
    }
    y.i("MicroMsg.NumberFaceMotion", "hy: last number in group");
    ai.l(this.jPM.jPL, 1500L);
    this.jPM.inQ = true;
    cancel();
    this.jPM.inQ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d.2
 * JD-Core Version:    0.7.0.1
 */