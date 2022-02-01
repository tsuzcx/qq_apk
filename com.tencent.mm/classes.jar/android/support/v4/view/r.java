package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

public final class r
{
  Object OC;
  
  private r(Object paramObject)
  {
    this.OC = paramObject;
  }
  
  public static r W(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new r(PointerIcon.getSystemIcon(paramContext, 1002));
    }
    return new r(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.r
 * JD-Core Version:    0.7.0.1
 */