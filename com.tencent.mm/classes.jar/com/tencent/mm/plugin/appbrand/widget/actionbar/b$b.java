package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$b
  implements b.d
{
  private b$b(b paramb) {}
  
  public final void a(ImageView paramImageView, View paramView1, View paramView2)
  {
    AppMethodBeat.i(178641);
    if (paramImageView != null)
    {
      paramImageView.setImageResource(2131689602);
      paramImageView.setColorFilter(this.mYZ.mLQ, PorterDuff.Mode.SRC_ATOP);
      paramView2 = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
      paramView2.width = this.mYZ.getContext().getResources().getDimensionPixelSize(2131165740);
      paramView2.height = this.mYZ.getContext().getResources().getDimensionPixelSize(2131165739);
      paramView2.leftMargin = this.mYZ.getContext().getResources().getDimensionPixelSize(2131165747);
      paramView2.rightMargin = this.mYZ.getContext().getResources().getDimensionPixelSize(2131165749);
      paramImageView.setLayoutParams(paramView2);
    }
    if (paramView1 != null)
    {
      paramImageView = (ViewGroup.MarginLayoutParams)paramView1.getLayoutParams();
      paramImageView.leftMargin = 0;
      paramImageView.rightMargin = 0;
      paramView1.setLayoutParams(paramImageView);
    }
    AppMethodBeat.o(178641);
  }
  
  public final int bvI()
  {
    return 2131165747;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.b
 * JD-Core Version:    0.7.0.1
 */