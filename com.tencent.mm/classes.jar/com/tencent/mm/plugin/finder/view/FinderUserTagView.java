package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderUserTagView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "plugin-finder_release"})
public final class FinderUserTagView
  extends AppCompatTextView
{
  public FinderUserTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168426);
    paramContext = new ViewGroup.MarginLayoutParams(-2, -2);
    setLayoutParams((ViewGroup.LayoutParams)paramContext);
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    paramContext.rightMargin = ((int)paramAttributeSet.getResources().getDimension(2131165314));
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099665));
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165587));
    AppMethodBeat.o(168426);
  }
  
  public FinderUserTagView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168427);
    paramContext = new ViewGroup.MarginLayoutParams(-2, -2);
    setLayoutParams((ViewGroup.LayoutParams)paramContext);
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    paramContext.rightMargin = ((int)paramAttributeSet.getResources().getDimension(2131165314));
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099665));
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165587));
    AppMethodBeat.o(168427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderUserTagView
 * JD-Core Version:    0.7.0.1
 */