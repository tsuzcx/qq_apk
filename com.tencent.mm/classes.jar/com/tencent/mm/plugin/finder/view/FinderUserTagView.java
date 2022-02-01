package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderUserTagView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderUserTagView
  extends AppCompatTextView
{
  public FinderUserTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168426);
    paramContext = new ViewGroup.MarginLayoutParams(-2, -2);
    setLayoutParams((ViewGroup.LayoutParams)paramContext);
    paramContext.rightMargin = ((int)getContext().getResources().getDimension(e.c.Edge_A));
    setTextColor(getContext().getResources().getColor(e.b.BW_0_Alpha_0_5));
    setTextSize(0, getContext().getResources().getDimension(e.c.SmallTextSize));
    AppMethodBeat.o(168426);
  }
  
  public FinderUserTagView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168427);
    paramContext = new ViewGroup.MarginLayoutParams(-2, -2);
    setLayoutParams((ViewGroup.LayoutParams)paramContext);
    paramContext.rightMargin = ((int)getContext().getResources().getDimension(e.c.Edge_A));
    setTextColor(getContext().getResources().getColor(e.b.BW_0_Alpha_0_5));
    setTextSize(0, getContext().getResources().getDimension(e.c.SmallTextSize));
    AppMethodBeat.o(168427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderUserTagView
 * JD-Core Version:    0.7.0.1
 */