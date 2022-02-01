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
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardHomePageV3UIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CardHomePageV3UI$c
  extends MMBaseAccessibilityConfig
{
  public CardHomePageV3UI$c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(293926);
    AppMethodBeat.o(293926);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(293934);
    root(a.e.wmW).view(a.d.wio).desc(a.d.wim).type(ViewType.Button);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.e.wmY);
    localConfigHelper.view(a.d.wiM).desc((b)a.wHp).type(ViewType.Button);
    localConfigHelper.disable(a.d.wiG);
    AppMethodBeat.o(293934);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    public static final a wHp;
    
    static
    {
      AppMethodBeat.i(293948);
      wHp = new a();
      AppMethodBeat.o(293948);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI.c
 * JD-Core Version:    0.7.0.1
 */