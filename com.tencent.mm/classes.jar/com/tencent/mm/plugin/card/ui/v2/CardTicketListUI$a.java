package com.tencent.mm.plugin.card.ui.v2;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI$CardTicketListUIAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CardTicketListUI$a
  extends MMBaseAccessibilityConfig
{
  public CardTicketListUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(294002);
    AppMethodBeat.o(294002);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(294007);
    root(a.e.wni).view(a.d.wjo).desc((b)a.wGL).type(ViewType.Button);
    root(a.e.wnM).view(a.d.wiM).desc((b)b.wGM).type(ViewType.Button);
    AppMethodBeat.o(294007);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    public static final a wGL;
    
    static
    {
      AppMethodBeat.i(293992);
      wGL = new a();
      AppMethodBeat.o(293992);
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
    public static final b wGM;
    
    static
    {
      AppMethodBeat.i(294000);
      wGM = new b();
      AppMethodBeat.o(294000);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.a
 * JD-Core Version:    0.7.0.1
 */