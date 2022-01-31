package com.tencent.luggage.e;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.j.c;
import java.util.LinkedList;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

final class n$1
  implements SwipeBackLayout.a
{
  n$1(n paramn, boolean[] paramArrayOfBoolean) {}
  
  public final boolean aK(boolean paramBoolean)
  {
    return false;
  }
  
  public final void e(int paramInt, float paramFloat)
  {
    Object localObject = this.biY;
    paramInt = ((e)localObject).bil.getPageStack().indexOf(localObject);
    if (paramInt >= ((e)localObject).bil.getPageStack().size() - 1) {}
    for (localObject = null; localObject == null; localObject = (e)((e)localObject).bil.getPageStack().get(paramInt + 1)) {
      return;
    }
    if ((Float.compare(1.0F, paramFloat) <= 0) && (this.biX[0] == 0))
    {
      localObject = ((e)localObject).getContentView();
      ((View)localObject).clearAnimation();
      ((View)localObject).setTranslationX(0.0F);
      this.biY.bil.qj().aJ(false);
      this.biX[0] = true;
    }
    c.i("", "scrollPercent %f", new Object[] { Float.valueOf(paramFloat) });
  }
  
  public final void l(MotionEvent paramMotionEvent) {}
  
  public final void qs()
  {
    if (this.biY.bil.getPageStack().size() <= 1) {
      this.biY.biU.setEnableGesture(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.e.n.1
 * JD-Core Version:    0.7.0.1
 */