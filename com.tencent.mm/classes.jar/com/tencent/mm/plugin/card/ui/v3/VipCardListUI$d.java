package com.tencent.mm.plugin.card.ui.v3;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardListUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VipCardListUI$d
  extends MMBaseAccessibilityConfig
{
  public VipCardListUI$d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(293837);
    AppMethodBeat.o(293837);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(293840);
    root(a.e.wna).view(a.d.wja).desc(a.d.wjb).type(ViewType.Button);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.e.wnb);
    localConfigHelper.view(a.d.wiT).desc((b)a.wHZ).type(ViewType.Button);
    localConfigHelper.disable(a.d.wiG);
    AppMethodBeat.o(293840);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    public static final a wHZ;
    
    static
    {
      AppMethodBeat.i(293943);
      wHZ = new a();
      AppMethodBeat.o(293943);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.VipCardListUI.d
 * JD-Core Version:    0.7.0.1
 */