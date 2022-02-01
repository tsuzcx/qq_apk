package com.tencent.mm.plugin.finder.nearby.accessibility;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.f.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/accessibility/FinderNearbyAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.accessibility.base.a
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(339770);
    AppMethodBeat.o(339770);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(339780);
    Object localObject = MMApplicationContext.getContext();
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(f.d.EGm);
    localConfigHelper.view(f.d.nearby_live_convert_root).desc((b)new a(this, (Context)localObject));
    localConfigHelper.view(f.d.finder_avatar).desc(f.h.finder_avatar_desc);
    localObject = root(f.e.EHc);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(f.d.EGx).desc(f.h.finder_live_square_scroll_guide).disableChildren();
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(f.d.EGm).disable();
    AppMethodBeat.o(339780);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(a parama, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.accessibility.a
 * JD-Core Version:    0.7.0.1
 */