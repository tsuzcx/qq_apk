package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.a.m;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "lastSelection", "getLastSelection", "()I", "setLastSelection", "(I)V", "onSelectionChangedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cur", "last", "", "getOnSelectionChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onSelectionChanged", "selStart", "selEnd", "plugin-finder_release"})
public final class FinderPostEditText
  extends MMEditText
{
  private final String TAG = "Finder.FinderPostEditText";
  private int rYj;
  private m<? super Integer, ? super Integer, y> rYk;
  
  public FinderPostEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FinderPostEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final int getLastSelection()
  {
    return this.rYj;
  }
  
  public final m<Integer, Integer, y> getOnSelectionChangedListener()
  {
    return this.rYk;
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168379);
    super.onSelectionChanged(paramInt1, paramInt2);
    ac.i(this.TAG, "onSelectionChanged start " + paramInt1 + ", end " + paramInt2);
    if (this.rYj != paramInt1)
    {
      m localm = this.rYk;
      if (localm != null) {
        localm.n(Integer.valueOf(paramInt1), Integer.valueOf(this.rYj));
      }
      this.rYj = paramInt1;
    }
    AppMethodBeat.o(168379);
  }
  
  public final void setLastSelection(int paramInt)
  {
    this.rYj = paramInt;
  }
  
  public final void setOnSelectionChangedListener(m<? super Integer, ? super Integer, y> paramm)
  {
    this.rYk = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostEditText
 * JD-Core Version:    0.7.0.1
 */