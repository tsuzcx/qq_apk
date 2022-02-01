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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI$CouponAndGiftCardListV4UIAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CouponAndGiftCardListV4UI$a
  extends MMBaseAccessibilityConfig
{
  public CouponAndGiftCardListV4UI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(294256);
    AppMethodBeat.o(294256);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(294262);
    root(a.e.wmu).view(a.d.wiJ).desc((b)a.wIv).type(ViewType.Button);
    root(a.e.wmH).view(a.d.wiM).desc((b)b.wIw).type(ViewType.Button);
    AppMethodBeat.o(294262);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    public static final a wIv;
    
    static
    {
      AppMethodBeat.i(294296);
      wIv = new a();
      AppMethodBeat.o(294296);
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
    public static final b wIw;
    
    static
    {
      AppMethodBeat.i(294298);
      wIw = new b();
      AppMethodBeat.o(294298);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListV4UI.a
 * JD-Core Version:    0.7.0.1
 */