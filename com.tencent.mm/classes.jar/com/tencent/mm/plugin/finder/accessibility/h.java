package com.tencent.mm.plugin.finder.accessibility;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.e.e;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderFlowListAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/IFinderCommonAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a
  implements v
{
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(333983);
    AppMethodBeat.o(333983);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(333991);
    root(e.e.action_option_icon).view(e.e.action_option_icon).desc((b)new a(this));
    AppMethodBeat.o(333991);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.h
 * JD-Core Version:    0.7.0.1
 */