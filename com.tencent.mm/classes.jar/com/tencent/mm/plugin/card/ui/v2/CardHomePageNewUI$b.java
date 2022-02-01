package com.tencent.mm.plugin.card.ui.v2;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.t;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "linkColor", "", "bgColor", "listener", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CardHomePageNewUI$b
  extends t
{
  public CardHomePageNewUI$b(int paramInt1, int paramInt2, n paramn)
  {
    super(paramInt2, paramn);
    AppMethodBeat.i(112407);
    this.mClickListener = localObject;
    AppMethodBeat.o(112407);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112406);
    s.u(paramView, "widget");
    if (this.mClickListener != null) {
      this.mClickListener.a(paramView, null);
    }
    AppMethodBeat.o(112406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.b
 * JD-Core Version:    0.7.0.1
 */