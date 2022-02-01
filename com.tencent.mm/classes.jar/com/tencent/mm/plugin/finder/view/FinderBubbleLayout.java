package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderBubbleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "container", "topView", "Landroid/widget/ImageView;", "setBubbleColor", "", "color", "setContent", "resId", "setTopViewMargin", "left", "right", "plugin-finder_release"})
public final class FinderBubbleLayout
  extends FrameLayout
{
  private final ImageView AUK;
  private final FrameLayout container;
  
  public FinderBubbleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(228384);
    paramContext = LayoutInflater.from(getContext()).inflate(b.g.finder_bubble_layout, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(b.f.bubble_top_view);
    p.j(paramAttributeSet, "root.findViewById(R.id.bubble_top_view)");
    this.AUK = ((ImageView)paramAttributeSet);
    this.AUK.setEnabled(false);
    paramContext = paramContext.findViewById(b.f.bubble_container);
    p.j(paramContext, "root.findViewById(R.id.bubble_container)");
    this.container = ((FrameLayout)paramContext);
    AppMethodBeat.o(228384);
  }
  
  public FinderBubbleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(228388);
    paramContext = LayoutInflater.from(getContext()).inflate(b.g.finder_bubble_layout, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(b.f.bubble_top_view);
    p.j(paramAttributeSet, "root.findViewById(R.id.bubble_top_view)");
    this.AUK = ((ImageView)paramAttributeSet);
    this.AUK.setEnabled(false);
    paramContext = paramContext.findViewById(b.f.bubble_container);
    p.j(paramContext, "root.findViewById(R.id.bubble_container)");
    this.container = ((FrameLayout)paramContext);
    AppMethodBeat.o(228388);
  }
  
  public final void setBubbleColor(int paramInt)
  {
    AppMethodBeat.i(228381);
    this.AUK.setImageDrawable(au.o(getContext(), b.i.finder_bubble_arrow, paramInt));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt);
    Context localContext = getContext();
    p.j(localContext, "context");
    localGradientDrawable.setCornerRadius(localContext.getResources().getDimension(b.d.Edge_0_5_A));
    this.container.setBackground((Drawable)localGradientDrawable);
    AppMethodBeat.o(228381);
  }
  
  public final void setContent(int paramInt)
  {
    AppMethodBeat.i(228379);
    LayoutInflater.from(getContext()).inflate(paramInt, (ViewGroup)this.container, true);
    AppMethodBeat.o(228379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBubbleLayout
 * JD-Core Version:    0.7.0.1
 */