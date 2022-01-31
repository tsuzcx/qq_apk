package android.support.design.widget;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class h$3
  implements ViewTreeObserver.OnPreDrawListener
{
  h$3(h paramh) {}
  
  public final boolean onPreDraw()
  {
    h localh = this.jL;
    float f = localh.jG.getRotation();
    if (localh.gV != f)
    {
      localh.gV = f;
      if (Build.VERSION.SDK_INT == 19)
      {
        if (localh.gV % 90.0F == 0.0F) {
          break label141;
        }
        if (localh.jG.getLayerType() != 1) {
          localh.jG.setLayerType(1, null);
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (localh.jy != null)
      {
        localObject = localh.jy;
        f = -localh.gV;
        if (((j)localObject).gV != f)
        {
          ((j)localObject).gV = f;
          ((j)localObject).invalidateSelf();
        }
      }
      if (localh.jB != null)
      {
        localObject = localh.jB;
        f = -localh.gV;
        if (f != ((d)localObject).gV)
        {
          ((d)localObject).gV = f;
          ((d)localObject).invalidateSelf();
        }
      }
      return true;
      label141:
      if (localh.jG.getLayerType() != 0) {
        localh.jG.setLayerType(0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.h.3
 * JD-Core Version:    0.7.0.1
 */