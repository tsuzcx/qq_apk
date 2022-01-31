package com.tencent.mm.plugin.game.luggage.d;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class f$5
  implements Runnable
{
  f$5(f paramf, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void run()
  {
    AppMethodBeat.i(154160);
    b localb = (b)f.c(this.nkM).get(this.hpA);
    if (localb == null)
    {
      AppMethodBeat.o(154160);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localb.Qz.getLayoutParams();
    localLayoutParams.width = this.val$width;
    localLayoutParams.height = this.val$height;
    localb.Qz.setLayoutParams(localLayoutParams);
    localb.Qz.setX(this.nkO + f.g(this.nkM).getX());
    localb.Qz.setY(this.nkP + f.h(this.nkM).getY());
    AppMethodBeat.o(154160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.f.5
 * JD-Core Version:    0.7.0.1
 */