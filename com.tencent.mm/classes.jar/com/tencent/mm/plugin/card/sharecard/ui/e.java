package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class e
{
  private ImageView dxD;
  private MMActivity oDq;
  View oJD;
  b oJE;
  protected LinearLayout oJF;
  protected LinearLayout oJG;
  private TextView oJH;
  
  public e(MMActivity paramMMActivity)
  {
    this.oDq = paramMMActivity;
  }
  
  private void bWS()
  {
    AppMethodBeat.i(113085);
    this.oJF.setVisibility(8);
    this.oJG.setVisibility(8);
    AppMethodBeat.o(113085);
  }
  
  private void bWV()
  {
    AppMethodBeat.i(113088);
    this.oJF.setVisibility(8);
    this.oJG.setVisibility(8);
    AppMethodBeat.o(113088);
  }
  
  public final void bWR()
  {
    AppMethodBeat.i(113084);
    if (this.oJD == null)
    {
      this.oJD = View.inflate(this.oDq, 2131493327, null);
      this.dxD = ((ImageView)this.oJD.findViewById(2131296594));
      this.oJH = ((TextView)this.oJD.findViewById(2131304789));
      this.oJF = ((LinearLayout)this.oJD.findViewById(2131301504));
      this.oJG = ((LinearLayout)this.oJD.findViewById(2131301499));
      this.oJF.setVisibility(8);
      this.oJG.setVisibility(8);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(1000L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.dxD.startAnimation(localRotateAnimation);
    }
    updateView();
    AppMethodBeat.o(113084);
  }
  
  public final void bWT()
  {
    AppMethodBeat.i(113086);
    this.oJF.setVisibility(0);
    this.oJG.setVisibility(8);
    AppMethodBeat.o(113086);
  }
  
  public final void bWU()
  {
    AppMethodBeat.i(113087);
    this.oJF.setVisibility(8);
    AppMethodBeat.o(113087);
  }
  
  public final void bWW()
  {
    AppMethodBeat.i(113089);
    bWV();
    this.oJH.setVisibility(8);
    AppMethodBeat.o(113089);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113090);
    Integer localInteger2 = (Integer)am.bWh().getValue("key_share_card_show_type");
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    if ((this.oJE != null) && (b.bWK()) && ((localInteger1.intValue() == 1) || (localInteger1.intValue() == 4)) && (b.bWH()))
    {
      this.oJH.setVisibility(0);
      bWV();
    }
    do
    {
      AppMethodBeat.o(113090);
      return;
      this.oJH.setVisibility(8);
      if (this.oJE == null) {
        break;
      }
      ae.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[] { Boolean.valueOf(b.bWK()), Boolean.valueOf(b.bWL()) });
      if ((!b.bWK()) || (!b.bWL()))
      {
        bWT();
        AppMethodBeat.o(113090);
        return;
      }
    } while ((!b.bWK()) || (!b.bWL()));
    bWS();
    AppMethodBeat.o(113090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.e
 * JD-Core Version:    0.7.0.1
 */