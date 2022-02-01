package com.tencent.mm.emoji.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/decode/FramePicker;", "", "frameCount", "", "(I)V", "TAG", "", "allFrameValid", "", "getAllFrameValid", "()Z", "setAllFrameValid", "(Z)V", "getFrameCount", "()I", "<set-?>", "frameSum", "getFrameSum", "frameTimeList", "", "getFrameTimeList", "()[I", "findFrameIndex", "time", "setFrameTime", "", "index", "plugin-emojisdk_release"})
public final class g
{
  private final String TAG;
  private final int frameCount;
  private final int[] qqL;
  boolean qre;
  private int qrm;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(202400);
    this.frameCount = paramInt;
    this.TAG = "MicroMsg.FramePicker";
    this.qqL = new int[this.frameCount];
    AppMethodBeat.o(202400);
  }
  
  public final int Bx(int paramInt)
  {
    int k = -1;
    if (this.frameCount <= 0) {}
    while ((!this.qre) && (paramInt > this.qrm)) {
      return k;
    }
    int i = paramInt;
    if (this.qre) {
      i = paramInt % this.qrm;
    }
    int j = this.qqL[0];
    paramInt = 0;
    for (;;)
    {
      k = paramInt;
      if (j >= i) {
        break;
      }
      paramInt += 1;
      j += this.qqL[paramInt];
    }
  }
  
  public final void ep(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(202399);
    int i = this.frameCount;
    if ((paramInt1 < 0) || (i <= paramInt1)) {
      ad.i(this.TAG, "setFrameTime: invalid index ".concat(String.valueOf(paramInt1)));
    }
    this.qrm -= this.qqL[paramInt1];
    this.qqL[paramInt1] = paramInt2;
    this.qrm += this.qqL[paramInt1];
    int[] arrayOfInt = this.qqL;
    i = arrayOfInt.length;
    paramInt1 = 0;
    if (paramInt1 < i) {
      if (arrayOfInt[paramInt1] > 0)
      {
        paramInt2 = 1;
        label101:
        if (paramInt2 != 0) {
          break label122;
        }
      }
    }
    for (;;)
    {
      this.qre = bool;
      AppMethodBeat.o(202399);
      return;
      paramInt2 = 0;
      break label101;
      label122:
      paramInt1 += 1;
      break;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.g
 * JD-Core Version:    0.7.0.1
 */