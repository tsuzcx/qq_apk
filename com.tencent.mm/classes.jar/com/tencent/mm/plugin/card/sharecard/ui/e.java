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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class e
{
  private ImageView dnd;
  private MMActivity nqt;
  View nwH;
  b nwI;
  protected LinearLayout nwJ;
  protected LinearLayout nwK;
  private TextView nwL;
  
  public e(MMActivity paramMMActivity)
  {
    this.nqt = paramMMActivity;
  }
  
  private void bJL()
  {
    AppMethodBeat.i(113085);
    this.nwJ.setVisibility(8);
    this.nwK.setVisibility(8);
    AppMethodBeat.o(113085);
  }
  
  private void bJO()
  {
    AppMethodBeat.i(113088);
    this.nwJ.setVisibility(8);
    this.nwK.setVisibility(8);
    AppMethodBeat.o(113088);
  }
  
  public final void bJK()
  {
    AppMethodBeat.i(113084);
    if (this.nwH == null)
    {
      this.nwH = View.inflate(this.nqt, 2131493327, null);
      this.dnd = ((ImageView)this.nwH.findViewById(2131296594));
      this.nwL = ((TextView)this.nwH.findViewById(2131304789));
      this.nwJ = ((LinearLayout)this.nwH.findViewById(2131301504));
      this.nwK = ((LinearLayout)this.nwH.findViewById(2131301499));
      this.nwJ.setVisibility(8);
      this.nwK.setVisibility(8);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(1000L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.dnd.startAnimation(localRotateAnimation);
    }
    cE();
    AppMethodBeat.o(113084);
  }
  
  public final void bJM()
  {
    AppMethodBeat.i(113086);
    this.nwJ.setVisibility(0);
    this.nwK.setVisibility(8);
    AppMethodBeat.o(113086);
  }
  
  public final void bJN()
  {
    AppMethodBeat.i(113087);
    this.nwJ.setVisibility(8);
    AppMethodBeat.o(113087);
  }
  
  public final void bJP()
  {
    AppMethodBeat.i(113089);
    bJO();
    this.nwL.setVisibility(8);
    AppMethodBeat.o(113089);
  }
  
  public final void cE()
  {
    AppMethodBeat.i(113090);
    Integer localInteger2 = (Integer)am.bJa().getValue("key_share_card_show_type");
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    if ((this.nwI != null) && (b.bJD()) && ((localInteger1.intValue() == 1) || (localInteger1.intValue() == 4)) && (b.bJA()))
    {
      this.nwL.setVisibility(0);
      bJO();
    }
    do
    {
      AppMethodBeat.o(113090);
      return;
      this.nwL.setVisibility(8);
      if (this.nwI == null) {
        break;
      }
      ad.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[] { Boolean.valueOf(b.bJD()), Boolean.valueOf(b.bJE()) });
      if ((!b.bJD()) || (!b.bJE()))
      {
        bJM();
        AppMethodBeat.o(113090);
        return;
      }
    } while ((!b.bJD()) || (!b.bJE()));
    bJL();
    AppMethodBeat.o(113090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.e
 * JD-Core Version:    0.7.0.1
 */