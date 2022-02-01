package com.tencent.mm.emoji.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/decode/FramePicker;", "", "frameCount", "", "(I)V", "TAG", "", "allFrameValid", "", "getAllFrameValid", "()Z", "setAllFrameValid", "(Z)V", "getFrameCount", "()I", "<set-?>", "frameSum", "getFrameSum", "frameTimeList", "", "getFrameTimeList", "()[I", "findFrameIndex", "time", "setFrameTime", "", "index", "plugin-emojisdk_release"})
public final class c
{
  private final String TAG;
  private final int frameCount;
  private final int[] gku;
  boolean gkv;
  private int gkw;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(188543);
    this.frameCount = paramInt;
    this.TAG = "MicroMsg.FramePicker";
    this.gku = new int[this.frameCount];
    AppMethodBeat.o(188543);
  }
  
  public final void cw(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(188542);
    int i = this.frameCount;
    if ((paramInt1 < 0) || (i <= paramInt1)) {
      ae.i(this.TAG, "setFrameTime: invalid index ".concat(String.valueOf(paramInt1)));
    }
    this.gkw -= this.gku[paramInt1];
    this.gku[paramInt1] = paramInt2;
    this.gkw += this.gku[paramInt1];
    int[] arrayOfInt = this.gku;
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
      this.gkv = bool;
      AppMethodBeat.o(188542);
      return;
      paramInt2 = 0;
      break label101;
      label122:
      paramInt1 += 1;
      break;
      bool = true;
    }
  }
  
  public final int lW(int paramInt)
  {
    int k = -1;
    if (this.frameCount <= 0) {}
    while ((!this.gkv) && (paramInt > this.gkw)) {
      return k;
    }
    int i = paramInt;
    if (this.gkv) {
      i = paramInt % this.gkw;
    }
    int j = this.gku[0];
    paramInt = 0;
    for (;;)
    {
      k = paramInt;
      if (j >= i) {
        break;
      }
      paramInt += 1;
      j += this.gku[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.c
 * JD-Core Version:    0.7.0.1
 */