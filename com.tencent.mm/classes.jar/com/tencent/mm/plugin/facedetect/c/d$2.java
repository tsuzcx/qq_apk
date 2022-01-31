package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$2
  implements View.OnClickListener
{
  d$2(d paramd, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135);
    if (this.mhC)
    {
      paramView = this.mhH;
      paramView.buc();
      paramView.isRetry = true;
      AppMethodBeat.o(135);
      return;
    }
    this.mhH.a(this.val$errType, this.val$errCode, this.ftO, this.mhD);
    AppMethodBeat.o(135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d.2
 * JD-Core Version:    0.7.0.1
 */