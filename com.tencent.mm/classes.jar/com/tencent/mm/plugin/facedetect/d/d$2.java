package com.tencent.mm.plugin.facedetect.d;

import android.os.CountDownTimer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;

final class d$2
  extends CountDownTimer
{
  d$2(d paramd)
  {
    super(9223372036854775807L, 1000L);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(311);
    ab.i("MicroMsg.NumberFaceMotion", "hy: on count number finished");
    AppMethodBeat.o(311);
  }
  
  public final void onTick(long paramLong)
  {
    AppMethodBeat.i(310);
    ab.i("MicroMsg.NumberFaceMotion", "hy: on ticked");
    if (this.mkc.eRq)
    {
      ab.w("MicroMsg.NumberFaceMotion", "hy: isEnd. trigger cancel");
      cancel();
      AppMethodBeat.o(310);
      return;
    }
    if (this.mkc.mjP)
    {
      ab.i("MicroMsg.NumberFaceMotion", "hy: suspend.");
      AppMethodBeat.o(310);
      return;
    }
    ab.i("MicroMsg.NumberFaceMotion", "hy: mCurrentShowedIndexInItem: %d, mItemDatas[mCurrentGroupDataIndex].length() - 1: %d, mCurrentGroupDataIndex: %d, mItemDatas.length - 1 : %d", new Object[] { Integer.valueOf(this.mkc.mjK), Integer.valueOf(this.mkc.mjI[this.mkc.mjJ].length() - 1), Integer.valueOf(this.mkc.mjJ), Integer.valueOf(this.mkc.mjI.length - 1) });
    if (this.mkc.mjK < this.mkc.mjI[this.mkc.mjJ].length() - 1)
    {
      d locald = this.mkc;
      locald.mjK += 1;
      this.mkc.mjZ.sendEmptyMessage(0);
      AppMethodBeat.o(310);
      return;
    }
    ab.i("MicroMsg.NumberFaceMotion", "hy: last number in group");
    al.p(this.mkc.mkb, 1500L);
    this.mkc.eRq = true;
    cancel();
    this.mkc.eRq = true;
    AppMethodBeat.o(310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d.2
 * JD-Core Version:    0.7.0.1
 */