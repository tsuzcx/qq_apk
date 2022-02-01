package com.tencent.mm.plugin.appbrand.ab;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.c;
import com.tencent.mm.svg.a.a;

final class b$1
  implements b.c
{
  b$1(b paramb) {}
  
  public final void a(ImageView paramImageView, View paramView1, View paramView2)
  {
    AppMethodBeat.i(49334);
    if (paramImageView != null)
    {
      paramImageView.clearColorFilter();
      paramImageView.setImageDrawable(a.g(this.mRB.getContext().getResources(), 2131689682));
      paramView2 = paramImageView.getLayoutParams();
      paramView2.height = -1;
      paramView2.width = -2;
      paramImageView.setLayoutParams(paramView2);
    }
    if (paramView1 != null) {
      paramView1.setBackground(null);
    }
    AppMethodBeat.o(49334);
  }
  
  public final int buX()
  {
    return mTY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.b.1
 * JD-Core Version:    0.7.0.1
 */