package com.tencent.mm.emoji.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/decode/FramePicker;", "", "frameCount", "", "(I)V", "TAG", "", "allFrameValid", "", "getAllFrameValid", "()Z", "setAllFrameValid", "(Z)V", "getFrameCount", "()I", "<set-?>", "frameSum", "getFrameSum", "frameTimeList", "", "getFrameTimeList", "()[I", "findFrameIndex", "time", "setFrameTime", "", "index", "plugin-emojisdk_release"})
public final class c
{
  private final String TAG;
  private final int frameCount;
  private final int[] gic;
  boolean gid;
  private int gie;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(218934);
    this.frameCount = paramInt;
    this.TAG = "MicroMsg.FramePicker";
    this.gic = new int[this.frameCount];
    AppMethodBeat.o(218934);
  }
  
  public final void cw(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(218933);
    int i = this.frameCount;
    if ((paramInt1 < 0) || (i <= paramInt1)) {
      ad.i(this.TAG, "setFrameTime: invalid index ".concat(String.valueOf(paramInt1)));
    }
    this.gie -= this.gic[paramInt1];
    this.gic[paramInt1] = paramInt2;
    this.gie += this.gic[paramInt1];
    int[] arrayOfInt = this.gic;
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
      this.gid = bool;
      AppMethodBeat.o(218933);
      return;
      paramInt2 = 0;
      break label101;
      label122:
      paramInt1 += 1;
      break;
      bool = true;
    }
  }
  
  public final int lU(int paramInt)
  {
    int k = -1;
    if (this.frameCount <= 0) {}
    while ((!this.gid) && (paramInt > this.gie)) {
      return k;
    }
    int i = paramInt;
    if (this.gid) {
      i = paramInt % this.gie;
    }
    int j = this.gic[0];
    paramInt = 0;
    for (;;)
    {
      k = paramInt;
      if (j >= i) {
        break;
      }
      paramInt += 1;
      j += this.gic[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.c
 * JD-Core Version:    0.7.0.1
 */