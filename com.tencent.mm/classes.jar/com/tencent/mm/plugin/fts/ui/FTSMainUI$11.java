package com.tencent.mm.plugin.fts.ui;

import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class FTSMainUI$11
  implements g
{
  FTSMainUI$11(FTSMainUI paramFTSMainUI) {}
  
  public final void aWq()
  {
    FTSMainUI.f(this.kCm).kBw.kEk = 1;
  }
  
  public final boolean m(int[] paramArrayOfInt)
  {
    int k = FTSMainUI.t(this.kCm);
    int j = FTSMainUI.u(this.kCm);
    int i = j;
    if (this.kCm.mController.uNh == -3) {
      i = j - u.fv(this.kCm);
    }
    return (paramArrayOfInt[0] >= 0) && (paramArrayOfInt[0] < k) && (paramArrayOfInt[1] >= 0) && (paramArrayOfInt[1] < i);
  }
  
  public final void onClick()
  {
    b localb = FTSMainUI.n(this.kCm);
    k.a(this.kCm.bVk, FTSMainUI.f(this.kCm).getCount(), FTSMainUI.o(this.kCm), localb, 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.11
 * JD-Core Version:    0.7.0.1
 */