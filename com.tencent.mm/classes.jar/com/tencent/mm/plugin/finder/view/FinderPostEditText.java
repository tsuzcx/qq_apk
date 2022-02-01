package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.a.m;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "lastSelection", "getLastSelection", "()I", "setLastSelection", "(I)V", "onSelectionChangedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cur", "last", "", "getOnSelectionChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onSelectionChanged", "selStart", "selEnd", "plugin-finder_release"})
public final class FinderPostEditText
  extends MMEditText
{
  private final String TAG = "Finder.FinderPostEditText";
  private int sVe;
  private m<? super Integer, ? super Integer, z> sVf;
  
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
    return this.sVe;
  }
  
  public final m<Integer, Integer, z> getOnSelectionChangedListener()
  {
    return this.sVf;
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168379);
    super.onSelectionChanged(paramInt1, paramInt2);
    ad.i(this.TAG, "onSelectionChanged start " + paramInt1 + ", end " + paramInt2);
    if (this.sVe != paramInt1)
    {
      m localm = this.sVf;
      if (localm != null) {
        localm.p(Integer.valueOf(paramInt1), Integer.valueOf(this.sVe));
      }
      this.sVe = paramInt1;
    }
    AppMethodBeat.o(168379);
  }
  
  public final void setLastSelection(int paramInt)
  {
    this.sVe = paramInt;
  }
  
  public final void setOnSelectionChangedListener(m<? super Integer, ? super Integer, z> paramm)
  {
    this.sVf = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostEditText
 * JD-Core Version:    0.7.0.1
 */