package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;

final class CardConsumeSuccessUI$2
  implements View.OnClickListener
{
  CardConsumeSuccessUI$2(CardConsumeSuccessUI paramCardConsumeSuccessUI) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == a.d.accept_btn) {
      CardConsumeSuccessUI.a(this.iqb);
    }
    while (paramView.getId() != a.d.success_share_tv) {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("KLabel_range_index", this.iqb.ipW);
    paramView.putExtra("Klabel_name_list", CardConsumeSuccessUI.b(this.iqb));
    paramView.putExtra("Kother_user_name_list", CardConsumeSuccessUI.c(this.iqb));
    paramView.putExtra("k_sns_label_ui_title", this.iqb.getString(a.g.card_share_card_private_setting_title));
    paramView.putExtra("k_sns_label_ui_style", 0);
    paramView.putExtra("KLabel_is_filter_private", true);
    d.b(this.iqb, "sns", ".ui.SnsLabelUI", paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI.2
 * JD-Core Version:    0.7.0.1
 */