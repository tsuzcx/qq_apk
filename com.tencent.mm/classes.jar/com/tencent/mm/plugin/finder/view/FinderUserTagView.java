package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderUserTagView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "plugin-finder_release"})
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
    p.j(paramAttributeSet, "context");
    paramContext.rightMargin = ((int)paramAttributeSet.getResources().getDimension(b.d.Edge_A));
    paramContext = getContext();
    p.j(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(b.c.BW_0_Alpha_0_5));
    paramContext = getContext();
    p.j(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(b.d.SmallTextSize));
    AppMethodBeat.o(168426);
  }
  
  public FinderUserTagView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168427);
    paramContext = new ViewGroup.MarginLayoutParams(-2, -2);
    setLayoutParams((ViewGroup.LayoutParams)paramContext);
    paramAttributeSet = getContext();
    p.j(paramAttributeSet, "context");
    paramContext.rightMargin = ((int)paramAttributeSet.getResources().getDimension(b.d.Edge_A));
    paramContext = getContext();
    p.j(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(b.c.BW_0_Alpha_0_5));
    paramContext = getContext();
    p.j(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(b.d.SmallTextSize));
    AppMethodBeat.o(168427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderUserTagView
 * JD-Core Version:    0.7.0.1
 */