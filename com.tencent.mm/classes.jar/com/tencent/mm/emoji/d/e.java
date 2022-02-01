package com.tencent.mm.emoji.d;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"getAttrResId", "", "context", "Landroid/content/Context;", "attributeId", "Landroid/view/View;", "setSvgDrawable", "", "Landroid/widget/ImageView;", "resId", "color", "plugin-emojisdk_release"})
public final class e
{
  public static final void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105783);
    p.h(paramImageView, "$this$setSvgDrawable");
    paramImageView.setImageDrawable(ao.k(paramImageView.getContext(), paramInt1, paramInt2));
    AppMethodBeat.o(105783);
  }
  
  public static final int cm(Context paramContext)
  {
    AppMethodBeat.i(105784);
    if (paramContext == null)
    {
      AppMethodBeat.o(105784);
      return 0;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(2130968965, localTypedValue, true);
    int i = localTypedValue.resourceId;
    AppMethodBeat.o(105784);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.d.e
 * JD-Core Version:    0.7.0.1
 */