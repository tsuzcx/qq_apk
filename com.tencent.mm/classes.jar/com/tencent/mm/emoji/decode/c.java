package com.tencent.mm.emoji.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/decode/FramePicker;", "", "frameCount", "", "(I)V", "TAG", "", "allFrameValid", "", "getAllFrameValid", "()Z", "setAllFrameValid", "(Z)V", "getFrameCount", "()I", "<set-?>", "frameSum", "getFrameSum", "frameTimeList", "", "getFrameTimeList", "()[I", "findFrameIndex", "time", "setFrameTime", "", "index", "plugin-emojisdk_release"})
public final class c
{
  private final String TAG;
  private final int frameCount;
  private int jFA;
  private final int[] jFy;
  boolean jFz;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(229781);
    this.frameCount = paramInt;
    this.TAG = "MicroMsg.FramePicker";
    this.jFy = new int[this.frameCount];
    AppMethodBeat.o(229781);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(229776);
    int i = this.frameCount;
    if ((paramInt1 < 0) || (i <= paramInt1)) {
      Log.i(this.TAG, "setFrameTime: invalid index ".concat(String.valueOf(paramInt1)));
    }
    this.jFA -= this.jFy[paramInt1];
    this.jFy[paramInt1] = paramInt2;
    this.jFA += this.jFy[paramInt1];
    int[] arrayOfInt = this.jFy;
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
      this.jFz = bool;
      AppMethodBeat.o(229776);
      return;
      paramInt2 = 0;
      break label101;
      label122:
      paramInt1 += 1;
      break;
      bool = true;
    }
  }
  
  public final int rx(int paramInt)
  {
    int k = -1;
    if (this.frameCount <= 0) {}
    while ((!this.jFz) && (paramInt > this.jFA)) {
      return k;
    }
    int i = paramInt;
    if (this.jFz) {
      i = paramInt % this.jFA;
    }
    int j = this.jFy[0];
    paramInt = 0;
    for (;;)
    {
      k = paramInt;
      if (j >= i) {
        break;
      }
      paramInt += 1;
      j += this.jFy[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.c
 * JD-Core Version:    0.7.0.1
 */