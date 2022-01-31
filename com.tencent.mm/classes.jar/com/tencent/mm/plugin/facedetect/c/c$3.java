package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$3
  implements View.OnClickListener
{
  c$3(c paramc, int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(123);
    this.mhB.a(this.val$errType, this.val$errCode, this.ftO, this.mhD);
    AppMethodBeat.o(123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.c.3
 * JD-Core Version:    0.7.0.1
 */