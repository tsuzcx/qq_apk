package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.aoi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class HoneyPaySelectCardTypeUI$a
{
  public TextView lkD;
  public CdnImageView lkt;
  public CdnImageView lmr;
  public TextView lms;
  public TextView lmt;
  public ImageView lmu;
  
  private HoneyPaySelectCardTypeUI$a(HoneyPaySelectCardTypeUI paramHoneyPaySelectCardTypeUI) {}
  
  final void a(View paramView, aoi paramaoi)
  {
    this.lmr = ((CdnImageView)paramView.findViewById(a.f.hpsc_avatar_iv));
    this.lkD = ((TextView)paramView.findViewById(a.f.hpsc_card_type_tv));
    this.lms = ((TextView)paramView.findViewById(a.f.hpsc_card_type_desc_tv));
    this.lmu = ((ImageView)paramView.findViewById(a.f.hpsc_arrow_iv));
    if (!bk.bl(paramaoi.bVO)) {
      this.lmr.dl(paramaoi.bVO, c.R(paramaoi.ilo, paramaoi.tkb));
    }
    for (;;)
    {
      this.lkD.setText(paramaoi.imz);
      this.lms.setText(paramaoi.ioU);
      if (!paramaoi.tkb) {
        break;
      }
      y.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
      paramView.setEnabled(false);
      this.lkD.setEnabled(false);
      this.lms.setEnabled(false);
      this.lmu.setVisibility(8);
      return;
      this.lmr.setImageResource(c.R(paramaoi.ilo, paramaoi.tkb));
    }
    paramView.setOnClickListener(new HoneyPaySelectCardTypeUI.a.2(this, paramaoi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.a
 * JD-Core Version:    0.7.0.1
 */