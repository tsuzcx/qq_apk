package com.tencent.mm.plugin.finder.accessibility;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderPoiFeedAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "forceFocus", "Lcom/tencent/mm/accessibility/base/ViewSetter;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends a
{
  public n(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(334030);
    AppMethodBeat.o(334030);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(334039);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(e.e.ll_header_root);
    localConfigHelper.view(e.e.poi_navigation_icon).desc(e.h.finder_poi_navigation).expand(12, 12, 12, 12);
    Iterator localIterator = ((Iterable)p.listOf(new Integer[] { Integer.valueOf(e.e.poi_title), Integer.valueOf(e.e.poi_type), Integer.valueOf(e.e.poi_open_time), Integer.valueOf(e.e.poi_tel), Integer.valueOf(e.e.poi_video), Integer.valueOf(e.e.video_count) })).iterator();
    while (localIterator.hasNext())
    {
      ViewSetter localViewSetter = localConfigHelper.view(((Number)localIterator.next()).intValue());
      s.u(localViewSetter, "<this>");
      localViewSetter.desc((b)a.Atq);
    }
    AppMethodBeat.o(334039);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    public static final a Atq;
    
    static
    {
      AppMethodBeat.i(334127);
      Atq = new a();
      AppMethodBeat.o(334127);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.n
 * JD-Core Version:    0.7.0.1
 */