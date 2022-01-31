package android.support.v7.widget;

import android.view.View;

final class GridLayout$7
  extends GridLayout.a
{
  final String hP()
  {
    return "BASELINE";
  }
  
  public final GridLayout.e hQ()
  {
    return new GridLayout.7.1(this);
  }
  
  public final int l(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getVisibility() == 8) {
      paramInt1 = 0;
    }
    do
    {
      return paramInt1;
      paramInt2 = paramView.getBaseline();
      paramInt1 = paramInt2;
    } while (paramInt2 != -1);
    return -2147483648;
  }
  
  final int z(View paramView, int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.7
 * JD-Core Version:    0.7.0.1
 */