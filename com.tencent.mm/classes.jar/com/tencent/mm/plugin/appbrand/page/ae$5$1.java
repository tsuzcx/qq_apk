package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.c;
import com.tencent.mm.svg.a.a;

final class ae$5$1
  implements b.c
{
  ae$5$1(ae.5 param5) {}
  
  public final void a(ImageView paramImageView, View paramView1, View paramView2)
  {
    AppMethodBeat.i(221300);
    if (paramImageView != null)
    {
      paramImageView.clearColorFilter();
      paramImageView.setImageDrawable(a.g(this.nbD.mcH.getContext().getResources(), 2131689682));
      paramView2 = paramImageView.getLayoutParams();
      paramView2.height = -1;
      paramView2.width = -2;
      paramImageView.setLayoutParams(paramView2);
    }
    if (paramView1 != null) {
      paramView1.setBackground(null);
    }
    AppMethodBeat.o(221300);
  }
  
  public final int buX()
  {
    return mTY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.5.1
 * JD-Core Version:    0.7.0.1
 */