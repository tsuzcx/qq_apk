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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderBubbleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "container", "topView", "Landroid/widget/ImageView;", "setBubbleColor", "", "color", "setContent", "resId", "setTopViewMargin", "left", "right", "plugin-finder_release"})
public final class FinderBubbleLayout
  extends FrameLayout
{
  private final ImageView Odj;
  private final FrameLayout container;
  
  public FinderBubbleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(221562);
    paramContext = LayoutInflater.from(getContext()).inflate(2131496419, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131300941);
    p.g(paramAttributeSet, "root.findViewById(R.id.bubble_top_view)");
    this.Odj = ((ImageView)paramAttributeSet);
    this.Odj.setEnabled(false);
    paramContext = paramContext.findViewById(2131297983);
    p.g(paramContext, "root.findViewById(R.id.bubble_container)");
    this.container = ((FrameLayout)paramContext);
    AppMethodBeat.o(221562);
  }
  
  public FinderBubbleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(221563);
    paramContext = LayoutInflater.from(getContext()).inflate(2131496419, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131300941);
    p.g(paramAttributeSet, "root.findViewById(R.id.bubble_top_view)");
    this.Odj = ((ImageView)paramAttributeSet);
    this.Odj.setEnabled(false);
    paramContext = paramContext.findViewById(2131297983);
    p.g(paramContext, "root.findViewById(R.id.bubble_container)");
    this.container = ((FrameLayout)paramContext);
    AppMethodBeat.o(221563);
  }
  
  public final void setBubbleColor(int paramInt)
  {
    AppMethodBeat.i(221561);
    this.Odj.setImageDrawable(ao.k(getContext(), 2131691622, paramInt));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt);
    Context localContext = getContext();
    p.g(localContext, "context");
    localGradientDrawable.setCornerRadius(localContext.getResources().getDimension(2131165274));
    this.container.setBackground((Drawable)localGradientDrawable);
    AppMethodBeat.o(221561);
  }
  
  public final void setContent(int paramInt)
  {
    AppMethodBeat.i(221559);
    LayoutInflater.from(getContext()).inflate(paramInt, (ViewGroup)this.container, true);
    AppMethodBeat.o(221559);
  }
  
  public final void setTopViewMargin$255f295(int paramInt)
  {
    AppMethodBeat.i(221560);
    Object localObject = this.Odj.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
      AppMethodBeat.o(221560);
      throw ((Throwable)localObject);
    }
    localObject = (ConstraintLayout.LayoutParams)localObject;
    if (paramInt >= 0)
    {
      ((ConstraintLayout.LayoutParams)localObject).leftMargin = paramInt;
      ((ConstraintLayout.LayoutParams)localObject).leftToLeft = 0;
      ((ConstraintLayout.LayoutParams)localObject).rightToRight = -1;
      this.Odj.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(221560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBubbleLayout
 * JD-Core Version:    0.7.0.1
 */