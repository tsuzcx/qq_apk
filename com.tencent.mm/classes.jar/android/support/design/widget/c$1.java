package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    if ((this.fO.mCancelable) && (this.fO.isShowing()))
    {
      paramView = this.fO;
      if (!paramView.fM)
      {
        if (Build.VERSION.SDK_INT >= 11) {
          break label65;
        }
        paramView.fL = true;
      }
    }
    for (;;)
    {
      paramView.fM = true;
      if (paramView.fL) {
        this.fO.cancel();
      }
      return;
      label65:
      TypedArray localTypedArray = paramView.getContext().obtainStyledAttributes(new int[] { 16843611 });
      paramView.fL = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.c.1
 * JD-Core Version:    0.7.0.1
 */