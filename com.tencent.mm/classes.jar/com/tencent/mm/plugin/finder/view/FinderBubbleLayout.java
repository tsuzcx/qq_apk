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
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderBubbleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "container", "topView", "Landroid/widget/ImageView;", "setBubbleColor", "", "color", "setContent", "resId", "setTopViewMargin", "left", "right", "plugin-finder_release"})
public final class FinderBubbleLayout
  extends FrameLayout
{
  private final FrameLayout container;
  private final ImageView wjQ;
  
  public FinderBubbleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254670);
    paramContext = LayoutInflater.from(getContext()).inflate(2131494214, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131297855);
    p.g(paramAttributeSet, "root.findViewById(R.id.bubble_top_view)");
    this.wjQ = ((ImageView)paramAttributeSet);
    this.wjQ.setEnabled(false);
    paramContext = paramContext.findViewById(2131297853);
    p.g(paramContext, "root.findViewById(R.id.bubble_container)");
    this.container = ((FrameLayout)paramContext);
    AppMethodBeat.o(254670);
  }
  
  public FinderBubbleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254671);
    paramContext = LayoutInflater.from(getContext()).inflate(2131494214, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131297855);
    p.g(paramAttributeSet, "root.findViewById(R.id.bubble_top_view)");
    this.wjQ = ((ImageView)paramAttributeSet);
    this.wjQ.setEnabled(false);
    paramContext = paramContext.findViewById(2131297853);
    p.g(paramContext, "root.findViewById(R.id.bubble_container)");
    this.container = ((FrameLayout)paramContext);
    AppMethodBeat.o(254671);
  }
  
  public final void setBubbleColor(int paramInt)
  {
    AppMethodBeat.i(254669);
    this.wjQ.setImageDrawable(ar.m(getContext(), 2131690229, paramInt));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt);
    Context localContext = getContext();
    p.g(localContext, "context");
    localGradientDrawable.setCornerRadius(localContext.getResources().getDimension(2131165277));
    this.container.setBackground((Drawable)localGradientDrawable);
    AppMethodBeat.o(254669);
  }
  
  public final void setContent(int paramInt)
  {
    AppMethodBeat.i(254668);
    LayoutInflater.from(getContext()).inflate(paramInt, (ViewGroup)this.container, true);
    AppMethodBeat.o(254668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBubbleLayout
 * JD-Core Version:    0.7.0.1
 */