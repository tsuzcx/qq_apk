package com.tencent.mm.emoji.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/decode/FramePicker;", "", "frameCount", "", "(I)V", "TAG", "", "allFrameValid", "", "getAllFrameValid", "()Z", "setAllFrameValid", "(Z)V", "getFrameCount", "()I", "<set-?>", "frameSum", "getFrameSum", "frameTimeList", "", "getFrameTimeList", "()[I", "findFrameIndex", "time", "setFrameTime", "", "index", "plugin-emojisdk_release"})
public final class c
{
  private final String TAG;
  private final int[] fOC;
  boolean fOD;
  private int fOE;
  private final int frameCount;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(209815);
    this.frameCount = paramInt;
    this.TAG = "MicroMsg.FramePicker";
    this.fOC = new int[this.frameCount];
    AppMethodBeat.o(209815);
  }
  
  public final void cu(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(209814);
    int i = this.frameCount;
    if ((paramInt1 < 0) || (i <= paramInt1)) {
      ac.i(this.TAG, "setFrameTime: invalid index ".concat(String.valueOf(paramInt1)));
    }
    this.fOE -= this.fOC[paramInt1];
    this.fOC[paramInt1] = paramInt2;
    this.fOE += this.fOC[paramInt1];
    int[] arrayOfInt = this.fOC;
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
      this.fOD = bool;
      AppMethodBeat.o(209814);
      return;
      paramInt2 = 0;
      break label101;
      label122:
      paramInt1 += 1;
      break;
      bool = true;
    }
  }
  
  public final int lv(int paramInt)
  {
    int k = -1;
    if (this.frameCount <= 0) {}
    while ((!this.fOD) && (paramInt > this.fOE)) {
      return k;
    }
    int i = paramInt;
    if (this.fOD) {
      i = paramInt % this.fOE;
    }
    int j = this.fOC[0];
    paramInt = 0;
    for (;;)
    {
      k = paramInt;
      if (j >= i) {
        break;
      }
      paramInt += 1;
      j += this.fOC[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.c
 * JD-Core Version:    0.7.0.1
 */