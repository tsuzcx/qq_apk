package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$4
  implements Runnable
{
  a$4(a parama, TextView paramTextView1, ImageView paramImageView1, TextView paramTextView2, RelativeLayout paramRelativeLayout, ImageView paramImageView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(135508);
    int i = this.nuM.getMeasuredWidth() - this.nuL.getMeasuredWidth() >> 1;
    if ((i > 0) && (this.nuL.getVisibility() != 8))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.nuN.getLayoutParams();
      int j = this.nuK.getResources().getDimensionPixelSize(2131165860) - i;
      if (localLayoutParams.leftMargin != j)
      {
        localLayoutParams.leftMargin = j;
        this.nuO.updateViewLayout(this.nuN, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.nuP.getLayoutParams();
      i = this.nuK.getResources().getDimensionPixelSize(2131165861) - i;
      if (localLayoutParams.leftMargin != i)
      {
        localLayoutParams.leftMargin = i;
        this.nuO.updateViewLayout(this.nuP, localLayoutParams);
      }
      AppMethodBeat.o(135508);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.nuN.getLayoutParams();
    i = this.nuK.getResources().getDimensionPixelSize(2131165860);
    if (localLayoutParams.leftMargin != i)
    {
      localLayoutParams.leftMargin = i;
      this.nuO.updateViewLayout(this.nuN, localLayoutParams);
    }
    localLayoutParams = (RelativeLayout.LayoutParams)this.nuP.getLayoutParams();
    i = this.nuK.getResources().getDimensionPixelSize(2131165861);
    if (localLayoutParams.leftMargin != i)
    {
      localLayoutParams.leftMargin = i;
      this.nuO.updateViewLayout(this.nuP, localLayoutParams);
    }
    AppMethodBeat.o(135508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.a.4
 * JD-Core Version:    0.7.0.1
 */