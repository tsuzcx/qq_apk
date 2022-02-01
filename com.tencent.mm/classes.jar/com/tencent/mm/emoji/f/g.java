package com.tencent.mm.emoji.f;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getAttrResId", "", "context", "Landroid/content/Context;", "attributeId", "Landroid/view/View;", "setSvgDrawable", "", "Landroid/widget/ImageView;", "resId", "color", "plugin-emojisdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105783);
    s.u(paramImageView, "<this>");
    paramImageView.setImageDrawable(bb.m(paramImageView.getContext(), paramInt1, paramInt2));
    AppMethodBeat.o(105783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.f.g
 * JD-Core Version:    0.7.0.1
 */