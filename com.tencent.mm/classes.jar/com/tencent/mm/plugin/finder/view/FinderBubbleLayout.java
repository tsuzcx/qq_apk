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
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderBubbleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "container", "topView", "Landroid/widget/ImageView;", "setBubbleColor", "", "color", "setContent", "resId", "setTopViewMargin", "left", "right", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBubbleLayout
  extends FrameLayout
{
  private final ImageView Gxg;
  private final FrameLayout container;
  
  public FinderBubbleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344892);
    paramContext = LayoutInflater.from(getContext()).inflate(e.f.finder_bubble_layout, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(e.e.bubble_top_view);
    s.s(paramAttributeSet, "root.findViewById(R.id.bubble_top_view)");
    this.Gxg = ((ImageView)paramAttributeSet);
    this.Gxg.setEnabled(false);
    paramContext = paramContext.findViewById(e.e.bubble_container);
    s.s(paramContext, "root.findViewById(R.id.bubble_container)");
    this.container = ((FrameLayout)paramContext);
    AppMethodBeat.o(344892);
  }
  
  public FinderBubbleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344900);
    paramContext = LayoutInflater.from(getContext()).inflate(e.f.finder_bubble_layout, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(e.e.bubble_top_view);
    s.s(paramAttributeSet, "root.findViewById(R.id.bubble_top_view)");
    this.Gxg = ((ImageView)paramAttributeSet);
    this.Gxg.setEnabled(false);
    paramContext = paramContext.findViewById(e.e.bubble_container);
    s.s(paramContext, "root.findViewById(R.id.bubble_container)");
    this.container = ((FrameLayout)paramContext);
    AppMethodBeat.o(344900);
  }
  
  public final void setBubbleColor(int paramInt)
  {
    AppMethodBeat.i(344916);
    this.Gxg.setImageDrawable(bb.m(getContext(), e.g.finder_bubble_arrow, paramInt));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt);
    localGradientDrawable.setCornerRadius(getContext().getResources().getDimension(e.c.Edge_0_5_A));
    this.container.setBackground((Drawable)localGradientDrawable);
    AppMethodBeat.o(344916);
  }
  
  public final void setContent(int paramInt)
  {
    AppMethodBeat.i(344907);
    LayoutInflater.from(getContext()).inflate(paramInt, (ViewGroup)this.container, true);
    AppMethodBeat.o(344907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBubbleLayout
 * JD-Core Version:    0.7.0.1
 */