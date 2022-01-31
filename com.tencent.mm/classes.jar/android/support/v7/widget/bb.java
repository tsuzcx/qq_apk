package android.support.v7.widget;

import android.os.Build.VERSION;
import android.view.View;

public final class bb
{
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramView.setTooltipText(paramCharSequence);
      return;
    }
    bc.a(paramView, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bb
 * JD-Core Version:    0.7.0.1
 */