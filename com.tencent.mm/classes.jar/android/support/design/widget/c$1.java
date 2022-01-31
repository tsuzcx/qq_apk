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
    if ((this.gI.mCancelable) && (this.gI.isShowing()))
    {
      paramView = this.gI;
      if (!paramView.gG)
      {
        if (Build.VERSION.SDK_INT >= 11) {
          break label65;
        }
        paramView.gF = true;
      }
    }
    for (;;)
    {
      paramView.gG = true;
      if (paramView.gF) {
        this.gI.cancel();
      }
      return;
      label65:
      TypedArray localTypedArray = paramView.getContext().obtainStyledAttributes(new int[] { 16843611 });
      paramView.gF = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.c.1
 * JD-Core Version:    0.7.0.1
 */