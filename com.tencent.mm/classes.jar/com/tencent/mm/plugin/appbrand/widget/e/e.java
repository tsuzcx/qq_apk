package com.tencent.mm.plugin.appbrand.widget.e;

import android.text.Spannable;
import android.text.Spannable.Factory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.g.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/FixedLineHeightSpannableFactory;", "Landroid/text/Spannable$Factory;", "height", "", "(I)V", "getHeight", "()I", "newSpannable", "Landroid/text/Spannable;", "source", "", "plugin-appbrand-integration_release"})
final class e
  extends Spannable.Factory
{
  private final int height;
  
  public e(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final Spannable newSpannable(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(51453);
    paramCharSequence = super.newSpannable(paramCharSequence);
    if (paramCharSequence != null)
    {
      paramCharSequence.setSpan(new a(this.height), 0, paramCharSequence.length(), 18);
      AppMethodBeat.o(51453);
      return paramCharSequence;
    }
    AppMethodBeat.o(51453);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.e
 * JD-Core Version:    0.7.0.1
 */