package com.tencent.mm.plugin.appbrand.weishi;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.b;
import com.tencent.mm.svg.a.a;

final class b$1
  implements b.b
{
  b$1(b paramb) {}
  
  public final void a(ImageView paramImageView, View paramView)
  {
    AppMethodBeat.i(133623);
    if (paramImageView != null)
    {
      paramImageView.clearColorFilter();
      paramImageView.setImageDrawable(a.g(this.jaf.getContext().getResources(), 2131230916));
    }
    if (paramView != null) {
      paramView.setBackground(null);
    }
    AppMethodBeat.o(133623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.b.1
 * JD-Core Version:    0.7.0.1
 */