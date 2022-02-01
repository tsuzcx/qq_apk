package com.tencent.mm.emoji.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/decode/FramePicker;", "", "frameCount", "", "(I)V", "TAG", "", "allFrameValid", "", "getAllFrameValid", "()Z", "setAllFrameValid", "(Z)V", "getFrameCount", "()I", "<set-?>", "frameSum", "getFrameSum", "frameTimeList", "", "getFrameTimeList", "()[I", "findFrameIndex", "time", "setFrameTime", "", "index", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private final String TAG;
  private final int frameCount;
  private final int[] mfl;
  boolean mfm;
  private int mfn;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(242223);
    this.frameCount = paramInt;
    this.TAG = "MicroMsg.FramePicker";
    this.mfl = new int[this.frameCount];
    AppMethodBeat.o(242223);
  }
  
  public final void dG(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(242224);
    int i;
    if (paramInt1 >= 0) {
      if (paramInt1 < this.frameCount)
      {
        i = 1;
        if (i == 0) {
          Log.i(this.TAG, s.X("setFrameTime: invalid index ", Integer.valueOf(paramInt1)));
        }
        this.mfn -= this.mfl[paramInt1];
        this.mfl[paramInt1] = paramInt2;
        this.mfn += this.mfl[paramInt1];
        int[] arrayOfInt = this.mfl;
        i = arrayOfInt.length;
        paramInt1 = 0;
        label91:
        if (paramInt1 >= i) {
          break label143;
        }
        if (arrayOfInt[paramInt1] <= 0) {
          break label131;
        }
        paramInt2 = 1;
        label105:
        if (paramInt2 != 0) {
          break label136;
        }
      }
    }
    for (;;)
    {
      this.mfm = bool;
      AppMethodBeat.o(242224);
      return;
      i = 0;
      break;
      i = 0;
      break;
      label131:
      paramInt2 = 0;
      break label105;
      label136:
      paramInt1 += 1;
      break label91;
      label143:
      bool = true;
    }
  }
  
  public final int rz(int paramInt)
  {
    int k = -1;
    if (this.frameCount <= 0) {}
    while ((!this.mfm) && (paramInt > this.mfn)) {
      return k;
    }
    int i = paramInt;
    if (this.mfm) {
      i = paramInt % this.mfn;
    }
    int j = this.mfl[0];
    paramInt = 0;
    for (;;)
    {
      k = paramInt;
      if (j >= i) {
        break;
      }
      paramInt += 1;
      j += this.mfl[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.c
 * JD-Core Version:    0.7.0.1
 */