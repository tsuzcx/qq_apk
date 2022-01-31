package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.b;
import com.tencent.mm.svg.a.a;

final class z$9$1
  implements b.b
{
  z$9$1(z.9 param9) {}
  
  public final void a(ImageView paramImageView, View paramView)
  {
    AppMethodBeat.i(143504);
    if (paramImageView != null)
    {
      paramImageView.clearColorFilter();
      paramImageView.setImageDrawable(a.g(this.ixJ.ixG.getContext().getResources(), 2131230916));
    }
    if (paramView != null) {
      paramView.setBackground(null);
    }
    AppMethodBeat.o(143504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z.9.1
 * JD-Core Version:    0.7.0.1
 */