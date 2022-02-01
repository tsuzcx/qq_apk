package com.tencent.mm.plugin.emoji.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.k;

public final class q
  implements k
{
  public k xNi;
  
  public q(k paramk)
  {
    this.xNi = paramk;
  }
  
  public final void onImageLoadComplete(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(108632);
    if (this.xNi != null) {
      this.xNi.onImageLoadComplete(paramString, paramView, paramBitmap, paramVarArgs);
    }
    AppMethodBeat.o(108632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.q
 * JD-Core Version:    0.7.0.1
 */