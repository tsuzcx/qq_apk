package com.tencent.mm.platformtools;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  public static void cn(View paramView)
  {
    AppMethodBeat.i(16669);
    if (paramView == null)
    {
      AppMethodBeat.o(16669);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      new u();
      if (Build.VERSION.SDK_INT >= 11) {
        paramView.setLayerType(1, null);
      }
    }
    AppMethodBeat.o(16669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.r
 * JD-Core Version:    0.7.0.1
 */