package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

public final class o
{
  Object Gb;
  
  private o(Object paramObject)
  {
    this.Gb = paramObject;
  }
  
  public static o S(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new o(PointerIcon.getSystemIcon(paramContext, 1002));
    }
    return new o(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.o
 * JD-Core Version:    0.7.0.1
 */