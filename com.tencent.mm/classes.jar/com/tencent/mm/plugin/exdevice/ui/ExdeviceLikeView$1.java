package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ExdeviceLikeView$1
  implements View.OnClickListener
{
  ExdeviceLikeView$1(ExdeviceLikeView paramExdeviceLikeView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(19976);
    if (ExdeviceLikeView.a(this.lMY) != null)
    {
      paramView = ExdeviceLikeView.a(this.lMY);
      ExdeviceLikeView.b(this.lMY);
      if ((!paramView.bqO()) && (ExdeviceLikeView.b(this.lMY) == 0))
      {
        ab.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
        this.lMY.setSelfLikeState(ExdeviceLikeView.ve(ExdeviceLikeView.b(this.lMY)));
        if (ExdeviceLikeView.b(this.lMY) == 1) {
          ExdeviceLikeView.c(this.lMY);
        }
        if (ExdeviceLikeView.a(this.lMY) == null) {
          break label136;
        }
        ExdeviceLikeView.a(this.lMY).iA(ExdeviceLikeView.b(this.lMY));
        AppMethodBeat.o(19976);
        return;
      }
    }
    ab.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
    label136:
    AppMethodBeat.o(19976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView.1
 * JD-Core Version:    0.7.0.1
 */