package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/pref/FinderBlackListPreference;", "Lcom/tencent/mm/ui/base/preference/PreferenceTitleCategory;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "plugin-finder_release"})
public final class FinderBlackListPreference
  extends PreferenceTitleCategory
{
  public FinderBlackListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(221010);
    setLayoutResource(b.g.finder_preference_black_list_text);
    AppMethodBeat.o(221010);
  }
  
  public FinderBlackListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(221008);
    setLayoutResource(b.g.finder_preference_black_list_text);
    AppMethodBeat.o(221008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.pref.FinderBlackListPreference
 * JD-Core Version:    0.7.0.1
 */