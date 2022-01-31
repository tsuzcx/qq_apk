package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class HoneyPaySelectCardTypeUI$a
{
  public CdnImageView nHP;
  public TextView nHZ;
  public CdnImageView nJN;
  public TextView nJO;
  public TextView nJP;
  public ImageView nJQ;
  
  private HoneyPaySelectCardTypeUI$a(HoneyPaySelectCardTypeUI paramHoneyPaySelectCardTypeUI) {}
  
  final void a(View paramView, aua paramaua)
  {
    AppMethodBeat.i(41955);
    this.nJN = ((CdnImageView)paramView.findViewById(2131825074));
    this.nHZ = ((TextView)paramView.findViewById(2131825075));
    this.nJO = ((TextView)paramView.findViewById(2131825076));
    this.nJQ = ((ImageView)paramView.findViewById(2131825077));
    if (!bo.isNullOrNil(paramaua.cDz)) {
      this.nJN.eq(paramaua.cDz, c.Z(paramaua.iFL, paramaua.xiS));
    }
    for (;;)
    {
      this.nHZ.setText(paramaua.knv);
      this.nJO.setText(paramaua.kqb);
      if (!paramaua.xiS) {
        break;
      }
      ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
      paramView.setEnabled(false);
      this.nHZ.setEnabled(false);
      this.nJO.setEnabled(false);
      this.nJQ.setVisibility(8);
      AppMethodBeat.o(41955);
      return;
      this.nJN.setImageResource(c.Z(paramaua.iFL, paramaua.xiS));
    }
    paramView.setOnClickListener(new HoneyPaySelectCardTypeUI.a.2(this, paramaua));
    AppMethodBeat.o(41955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.a
 * JD-Core Version:    0.7.0.1
 */