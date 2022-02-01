package com.tencent.mm.plugin.card.ui.v4;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$HistoryCardListUIAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HistoryCardListUI$b
  extends MMBaseAccessibilityConfig
{
  public HistoryCardListUI$b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(294247);
    AppMethodBeat.o(294247);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(294253);
    root(a.e.wmu).view(a.d.wiJ).desc((b)a.wIU).type(ViewType.Button);
    root(a.e.wmH).view(a.d.wiM).desc((b)b.wIV).type(ViewType.Button);
    AppMethodBeat.o(294253);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    public static final a wIU;
    
    static
    {
      AppMethodBeat.i(294333);
      wIU = new a();
      AppMethodBeat.o(294333);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    public static final b wIV;
    
    static
    {
      AppMethodBeat.i(294334);
      wIV = new b();
      AppMethodBeat.o(294334);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.HistoryCardListUI.b
 * JD-Core Version:    0.7.0.1
 */