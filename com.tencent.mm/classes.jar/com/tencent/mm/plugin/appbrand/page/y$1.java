package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import java.lang.ref.WeakReference;

final class y$1
  extends ae
{
  y$1(y paramy) {}
  
  public final void ajc()
  {
    y localy = this.gVq;
    y.b localb = localy.me(localy.gVp);
    float[] arrayOfFloat = localy.gVm;
    if ((localb == null) || (localb.gVz == null) || (arrayOfFloat == null)) {}
    for (;;)
    {
      if (this.gVq.gVo != null)
      {
        this.gVq.gVo.ajc();
        this.gVq.gVo = null;
      }
      return;
      View localView = (View)localb.gVz.get();
      if (localView != null)
      {
        if (localy.gVp != localy.gVl)
        {
          Object localObject = localy.me(localy.gVl);
          if ((localObject != null) && (((y.b)localObject).gVz != null))
          {
            localObject = (View)((y.b)localObject).gVz.get();
            if (localObject != null) {
              localy.b(localy.gVl, arrayOfFloat, ((View)localObject).getVisibility(), Boolean.valueOf(localb.gVB));
            }
          }
        }
        int i = localy.gVp;
        localy.gVl = -1;
        localy.gVp = -1;
        localy.b(i, arrayOfFloat, localView.getVisibility(), Boolean.valueOf(localb.gVB));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y.1
 * JD-Core Version:    0.7.0.1
 */