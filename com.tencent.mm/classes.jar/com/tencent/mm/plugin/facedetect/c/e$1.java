package com.tencent.mm.plugin.facedetect.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  implements View.OnClickListener
{
  e$1(e parame, int paramInt1, int paramInt2, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(149);
    if (this.mhC)
    {
      e.a(this.mhI);
      AppMethodBeat.o(149);
      return;
    }
    this.mhI.a(this.val$errType, this.val$errCode, this.ftO, this.mhD);
    AppMethodBeat.o(149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.e.1
 * JD-Core Version:    0.7.0.1
 */