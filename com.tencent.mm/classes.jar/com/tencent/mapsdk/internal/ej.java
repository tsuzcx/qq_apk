package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.view.View;

public abstract class ej
  implements el
{
  public Rect a()
  {
    View[] arrayOfView = b();
    Rect localRect = new Rect();
    int j = arrayOfView.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfView[i];
      if (localObject == null) {}
      int k;
      int m;
      for (localObject = new Rect();; localObject = new Rect(k, m, ((View)localObject).getMeasuredWidth() + k, m + ((View)localObject).getMeasuredHeight()))
      {
        localRect.union((Rect)localObject);
        i += 1;
        break;
        int[] arrayOfInt = new int[2];
        ((View)localObject).getLocationInWindow(arrayOfInt);
        k = arrayOfInt[0];
        m = arrayOfInt[1];
      }
    }
    return localRect;
  }
  
  public abstract View[] b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ej
 * JD-Core Version:    0.7.0.1
 */