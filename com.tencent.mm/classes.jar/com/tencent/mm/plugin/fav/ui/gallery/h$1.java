package com.tencent.mm.plugin.fav.ui.gallery;

import android.support.v7.widget.GridLayoutManager.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class h$1
  extends GridLayoutManager.b
{
  h$1(h paramh) {}
  
  public final int bF(int paramInt)
  {
    AppMethodBeat.i(74590);
    if (((f.c)this.mCP.iVH.get(paramInt)).type == 2147483647)
    {
      AppMethodBeat.o(74590);
      return 4;
    }
    AppMethodBeat.o(74590);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h.1
 * JD-Core Version:    0.7.0.1
 */