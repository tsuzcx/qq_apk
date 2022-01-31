package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  implements View.OnClickListener
{
  c$2(c paramc, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(122);
    if (this.mhC)
    {
      paramView = this.mhB;
      paramView.buc();
      paramView.isRetry = true;
      AppMethodBeat.o(122);
      return;
    }
    this.mhB.a(this.val$errType, this.val$errCode, this.ftO, this.mhD);
    AppMethodBeat.o(122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.c.2
 * JD-Core Version:    0.7.0.1
 */