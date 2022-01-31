package com.tencent.matrix.trace.f;

import android.view.View;
import android.view.ViewGroup;

public final class b
{
  public static void a(a parama, int paramInt, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int i = paramInt + 1;
      if (i > parama.bsO) {
        parama.bsO = i;
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        if (j > 0)
        {
          paramInt = 0;
          while (paramInt < j)
          {
            View localView = paramView.getChildAt(paramInt);
            if ((localView == null) || (localView.getVisibility() != 8))
            {
              parama.bsN += 1;
              a(parama, i, localView);
            }
            paramInt += 1;
          }
        }
      }
    }
  }
  
  public static final class a
  {
    public int bsN = 0;
    public int bsO = 0;
    public String mActivityName = "";
    
    public final String toString()
    {
      return "ViewCount:" + this.bsN + ",ViewDeep:" + this.bsO + ",mActivityName:" + this.mActivityName;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.f.b
 * JD-Core Version:    0.7.0.1
 */