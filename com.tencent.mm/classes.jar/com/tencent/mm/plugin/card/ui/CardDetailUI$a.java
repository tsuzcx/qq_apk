package com.tencent.mm.plugin.card.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import kotlin.g.a.b;

public class CardDetailUI$a
  extends MMBaseAccessibilityConfig
{
  public CardDetailUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(293792);
    root(a.d.whZ).view(a.d.wfE).desc(new b() {}).type(ViewType.Button);
    root(a.d.whZ).view(a.d.wfA).desc(new b() {}).type(ViewType.Button);
    root(a.e.wnx).view(a.d.whE).desc(new b() {});
    root(a.d.whX).view(a.d.who).desc(new b() {}).type(ViewType.Button);
    AppMethodBeat.o(293792);
  }
  
  public final void ne(boolean paramBoolean)
  {
    AppMethodBeat.i(293793);
    ViewSetter localViewSetter = root(a.e.wnq).view(a.d.whg).desc(new b() {});
    if (paramBoolean) {}
    for (ViewType localViewType = ViewType.Button;; localViewType = ViewType.TextView)
    {
      localViewSetter.type(localViewType).clickAs(a.d.wfM);
      AppMethodBeat.o(293793);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI.a
 * JD-Core Version:    0.7.0.1
 */