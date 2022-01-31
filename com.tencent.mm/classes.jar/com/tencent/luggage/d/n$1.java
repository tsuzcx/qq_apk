package com.tencent.luggage.d;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

final class n$1
  implements SwipeBackLayout.a
{
  n$1(n paramn, boolean[] paramArrayOfBoolean) {}
  
  public final boolean aZ(boolean paramBoolean)
  {
    return false;
  }
  
  public final void g(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(90842);
    Object localObject = this.bzx;
    paramInt = ((e)localObject).byJ.um().indexOf(localObject);
    if (paramInt >= ((e)localObject).byJ.um().size() - 1) {}
    for (localObject = null; localObject == null; localObject = (e)((e)localObject).byJ.um().get(paramInt + 1))
    {
      AppMethodBeat.o(90842);
      return;
    }
    if ((Float.compare(1.0F, paramFloat) <= 0) && (this.bzw[0] == 0))
    {
      localObject = ((e)localObject).getContentView();
      ((View)localObject).clearAnimation();
      ((View)localObject).setTranslationX(0.0F);
      this.bzx.byJ.un().aY(false);
      this.bzw[0] = true;
    }
    d.i("", "scrollPercent %f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(90842);
  }
  
  public final void l(MotionEvent paramMotionEvent) {}
  
  public final void uA()
  {
    AppMethodBeat.i(90841);
    if (this.bzx.byJ.um().size() <= 1) {
      this.bzx.bzt.setEnableGesture(false);
    }
    AppMethodBeat.o(90841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.n.1
 * JD-Core Version:    0.7.0.1
 */