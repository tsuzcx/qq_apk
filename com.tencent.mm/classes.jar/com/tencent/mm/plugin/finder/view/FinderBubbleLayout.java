package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderBubbleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "container", "topView", "Landroid/widget/ImageView;", "setBubbleColor", "", "color", "setContent", "resId", "setTopViewMargin", "left", "right", "plugin-finder_release"})
public final class FinderBubbleLayout
  extends FrameLayout
{
  private final FrameLayout container;
  private final ImageView tdv;
  
  public FinderBubbleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205677);
    paramContext = LayoutInflater.from(getContext()).inflate(2131496419, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131300941);
    p.g(paramAttributeSet, "root.findViewById(R.id.bubble_top_view)");
    this.tdv = ((ImageView)paramAttributeSet);
    this.tdv.setEnabled(false);
    paramContext = paramContext.findViewById(2131297983);
    p.g(paramContext, "root.findViewById(R.id.bubble_container)");
    this.container = ((FrameLayout)paramContext);
    AppMethodBeat.o(205677);
  }
  
  public FinderBubbleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205678);
    paramContext = LayoutInflater.from(getContext()).inflate(2131496419, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131300941);
    p.g(paramAttributeSet, "root.findViewById(R.id.bubble_top_view)");
    this.tdv = ((ImageView)paramAttributeSet);
    this.tdv.setEnabled(false);
    paramContext = paramContext.findViewById(2131297983);
    p.g(paramContext, "root.findViewById(R.id.bubble_container)");
    this.container = ((FrameLayout)paramContext);
    AppMethodBeat.o(205678);
  }
  
  public final void setBubbleColor(int paramInt)
  {
    AppMethodBeat.i(205676);
    this.tdv.setImageDrawable(ao.k(getContext(), 2131691622, paramInt));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt);
    Context localContext = getContext();
    p.g(localContext, "context");
    localGradientDrawable.setCornerRadius(localContext.getResources().getDimension(2131165274));
    this.container.setBackground((Drawable)localGradientDrawable);
    AppMethodBeat.o(205676);
  }
  
  public final void setContent(int paramInt)
  {
    AppMethodBeat.i(205674);
    LayoutInflater.from(getContext()).inflate(paramInt, (ViewGroup)this.container, true);
    AppMethodBeat.o(205674);
  }
  
  public final void setTopViewMargin$255f295(int paramInt)
  {
    AppMethodBeat.i(205675);
    Object localObject = this.tdv.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
      AppMethodBeat.o(205675);
      throw ((Throwable)localObject);
    }
    localObject = (ConstraintLayout.LayoutParams)localObject;
    if (paramInt >= 0)
    {
      ((ConstraintLayout.LayoutParams)localObject).leftMargin = paramInt;
      ((ConstraintLayout.LayoutParams)localObject).leftToLeft = 0;
      ((ConstraintLayout.LayoutParams)localObject).rightToRight = -1;
      this.tdv.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(205675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBubbleLayout
 * JD-Core Version:    0.7.0.1
 */