package com.tencent.mm.emoji.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/decode/FramePicker;", "", "frameCount", "", "(I)V", "TAG", "", "allFrameValid", "", "getAllFrameValid", "()Z", "setAllFrameValid", "(Z)V", "getFrameCount", "()I", "<set-?>", "frameSum", "getFrameSum", "frameTimeList", "", "getFrameTimeList", "()[I", "findFrameIndex", "time", "setFrameTime", "", "index", "plugin-emojisdk_release"})
public final class c
{
  private final String TAG;
  private final int frameCount;
  private final int[] gUH;
  boolean gUI;
  private int gUJ;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(199862);
    this.frameCount = paramInt;
    this.TAG = "MicroMsg.FramePicker";
    this.gUH = new int[this.frameCount];
    AppMethodBeat.o(199862);
  }
  
  public final void cz(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(199861);
    int i = this.frameCount;
    if ((paramInt1 < 0) || (i <= paramInt1)) {
      Log.i(this.TAG, "setFrameTime: invalid index ".concat(String.valueOf(paramInt1)));
    }
    this.gUJ -= this.gUH[paramInt1];
    this.gUH[paramInt1] = paramInt2;
    this.gUJ += this.gUH[paramInt1];
    int[] arrayOfInt = this.gUH;
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
      this.gUI = bool;
      AppMethodBeat.o(199861);
      return;
      paramInt2 = 0;
      break label101;
      label122:
      paramInt1 += 1;
      break;
      bool = true;
    }
  }
  
  public final int pe(int paramInt)
  {
    int k = -1;
    if (this.frameCount <= 0) {}
    while ((!this.gUI) && (paramInt > this.gUJ)) {
      return k;
    }
    int i = paramInt;
    if (this.gUI) {
      i = paramInt % this.gUJ;
    }
    int j = this.gUH[0];
    paramInt = 0;
    for (;;)
    {
      k = paramInt;
      if (j >= i) {
        break;
      }
      paramInt += 1;
      j += this.gUH[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.c
 * JD-Core Version:    0.7.0.1
 */