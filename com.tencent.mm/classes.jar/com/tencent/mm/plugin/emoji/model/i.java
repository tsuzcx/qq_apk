package com.tencent.mm.plugin.emoji.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.k;

public final class i
  implements k
{
  public k paW;
  
  public i(k paramk)
  {
    this.paW = paramk;
  }
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(108632);
    if (this.paW != null) {
      this.paW.a(paramString, paramView, paramBitmap, paramVarArgs);
    }
    AppMethodBeat.o(108632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.i
 * JD-Core Version:    0.7.0.1
 */