package com.tencent.mm.plugin.finder.accessibility;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.e.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderModifyNameAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends a
{
  public m(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(333966);
    AppMethodBeat.o(333966);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(333979);
    root(e.e.scroll_container).view(e.e.finder_modify_name_container).desc(e.e.finder_edit).disableChildren();
    focusFirst(e.e.finder_modify_title);
    focusOrder().next(e.e.finder_modify_title).next(e.e.finder_modify_name_container).next(e.e.finder_modify_btn);
    AppMethodBeat.o(333979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.m
 * JD-Core Version:    0.7.0.1
 */