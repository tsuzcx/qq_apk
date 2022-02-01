package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/pref/FinderBlackListPreference;", "Lcom/tencent/mm/ui/base/preference/PreferenceTitleCategory;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBlackListPreference
  extends PreferenceTitleCategory
{
  public FinderBlackListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(330655);
    setLayoutResource(e.f.finder_preference_black_list_text);
    AppMethodBeat.o(330655);
  }
  
  public FinderBlackListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(330645);
    setLayoutResource(e.f.finder_preference_black_list_text);
    AppMethodBeat.o(330645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.pref.FinderBlackListPreference
 * JD-Core Version:    0.7.0.1
 */