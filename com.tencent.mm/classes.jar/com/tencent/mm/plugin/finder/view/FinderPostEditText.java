package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.a.m;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "lastSelection", "getLastSelection", "()I", "setLastSelection", "(I)V", "onSelectionChangedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cur", "last", "", "getOnSelectionChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onSelectionChanged", "selStart", "selEnd", "plugin-finder_release"})
public final class FinderPostEditText
  extends MMEditText
{
  private final String TAG = "Finder.FinderPostEditText";
  private int tgu;
  private m<? super Integer, ? super Integer, z> tgv;
  
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
    return this.tgu;
  }
  
  public final m<Integer, Integer, z> getOnSelectionChangedListener()
  {
    return this.tgv;
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168379);
    super.onSelectionChanged(paramInt1, paramInt2);
    ae.i(this.TAG, "onSelectionChanged start " + paramInt1 + ", end " + paramInt2);
    if (this.tgu != paramInt1)
    {
      m localm = this.tgv;
      if (localm != null) {
        localm.p(Integer.valueOf(paramInt1), Integer.valueOf(this.tgu));
      }
      this.tgu = paramInt1;
    }
    AppMethodBeat.o(168379);
  }
  
  public final void setLastSelection(int paramInt)
  {
    this.tgu = paramInt;
  }
  
  public final void setOnSelectionChangedListener(m<? super Integer, ? super Integer, z> paramm)
  {
    this.tgv = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostEditText
 * JD-Core Version:    0.7.0.1
 */