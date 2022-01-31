package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class CardConsumeSuccessUI$2
  implements View.OnClickListener
{
  CardConsumeSuccessUI$2(CardConsumeSuccessUI paramCardConsumeSuccessUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88118);
    if (paramView.getId() == 2131822052)
    {
      CardConsumeSuccessUI.a(this.krj);
      AppMethodBeat.o(88118);
      return;
    }
    if (paramView.getId() == 2131822054)
    {
      paramView = new Intent();
      paramView.putExtra("KLabel_range_index", this.krj.kre);
      paramView.putExtra("Klabel_name_list", CardConsumeSuccessUI.b(this.krj));
      paramView.putExtra("Kother_user_name_list", CardConsumeSuccessUI.c(this.krj));
      paramView.putExtra("k_sns_label_ui_title", this.krj.getString(2131298041));
      paramView.putExtra("k_sns_label_ui_style", 0);
      paramView.putExtra("KLabel_is_filter_private", true);
      d.b(this.krj, "sns", ".ui.SnsLabelUI", paramView, 1);
    }
    AppMethodBeat.o(88118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI.2
 * JD-Core Version:    0.7.0.1
 */