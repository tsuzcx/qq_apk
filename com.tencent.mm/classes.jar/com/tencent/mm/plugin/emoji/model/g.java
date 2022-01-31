package com.tencent.mm.plugin.emoji.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.i;

public final class g
  implements i
{
  public i lhu;
  
  public g(i parami)
  {
    this.lhu = parami;
  }
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(53053);
    if (this.lhu != null) {
      this.lhu.a(paramString, paramView, paramBitmap, paramVarArgs);
    }
    AppMethodBeat.o(53053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.g
 * JD-Core Version:    0.7.0.1
 */