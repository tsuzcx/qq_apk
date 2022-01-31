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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public final class e
{
  private ImageView cxy;
  private MMActivity jpX;
  View kro;
  b krp;
  protected LinearLayout krq;
  protected LinearLayout krr;
  private TextView krs;
  
  public e(MMActivity paramMMActivity)
  {
    this.jpX = paramMMActivity;
  }
  
  private void bcN()
  {
    AppMethodBeat.i(88151);
    this.krq.setVisibility(8);
    this.krr.setVisibility(8);
    AppMethodBeat.o(88151);
  }
  
  private void bcQ()
  {
    AppMethodBeat.i(88154);
    this.krq.setVisibility(8);
    this.krr.setVisibility(8);
    AppMethodBeat.o(88154);
  }
  
  public final void bJ()
  {
    AppMethodBeat.i(88156);
    Integer localInteger2 = (Integer)am.bci().getValue("key_share_card_show_type");
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    if ((this.krp != null) && (b.bcF()) && ((localInteger1.intValue() == 1) || (localInteger1.intValue() == 4)) && (b.bcC()))
    {
      this.krs.setVisibility(0);
      bcQ();
    }
    do
    {
      AppMethodBeat.o(88156);
      return;
      this.krs.setVisibility(8);
      if (this.krp == null) {
        break;
      }
      ab.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[] { Boolean.valueOf(b.bcF()), Boolean.valueOf(b.bcG()) });
      if ((!b.bcF()) || (!b.bcG()))
      {
        bcO();
        AppMethodBeat.o(88156);
        return;
      }
    } while ((!b.bcF()) || (!b.bcG()));
    bcN();
    AppMethodBeat.o(88156);
  }
  
  public final void bcM()
  {
    AppMethodBeat.i(88150);
    if (this.kro == null)
    {
      this.kro = View.inflate(this.jpX, 2130968976, null);
      this.cxy = ((ImageView)this.kro.findViewById(2131822312));
      this.krs = ((TextView)this.kro.findViewById(2131822310));
      this.krq = ((LinearLayout)this.kro.findViewById(2131822311));
      this.krr = ((LinearLayout)this.kro.findViewById(2131822313));
      this.krq.setVisibility(8);
      this.krr.setVisibility(8);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(1000L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.cxy.startAnimation(localRotateAnimation);
    }
    bJ();
    AppMethodBeat.o(88150);
  }
  
  public final void bcO()
  {
    AppMethodBeat.i(88152);
    this.krq.setVisibility(0);
    this.krr.setVisibility(8);
    AppMethodBeat.o(88152);
  }
  
  public final void bcP()
  {
    AppMethodBeat.i(88153);
    this.krq.setVisibility(8);
    AppMethodBeat.o(88153);
  }
  
  public final void bcR()
  {
    AppMethodBeat.i(88155);
    bcQ();
    this.krs.setVisibility(8);
    AppMethodBeat.o(88155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.e
 * JD-Core Version:    0.7.0.1
 */