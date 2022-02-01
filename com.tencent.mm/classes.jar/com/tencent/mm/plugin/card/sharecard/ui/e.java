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
  private ImageView dwy;
  View oDb;
  b oDc;
  protected LinearLayout oDd;
  protected LinearLayout oDe;
  private TextView oDf;
  private MMActivity owO;
  
  public e(MMActivity paramMMActivity)
  {
    this.owO = paramMMActivity;
  }
  
  private void bVD()
  {
    AppMethodBeat.i(113085);
    this.oDd.setVisibility(8);
    this.oDe.setVisibility(8);
    AppMethodBeat.o(113085);
  }
  
  private void bVG()
  {
    AppMethodBeat.i(113088);
    this.oDd.setVisibility(8);
    this.oDe.setVisibility(8);
    AppMethodBeat.o(113088);
  }
  
  public final void bVC()
  {
    AppMethodBeat.i(113084);
    if (this.oDb == null)
    {
      this.oDb = View.inflate(this.owO, 2131493327, null);
      this.dwy = ((ImageView)this.oDb.findViewById(2131296594));
      this.oDf = ((TextView)this.oDb.findViewById(2131304789));
      this.oDd = ((LinearLayout)this.oDb.findViewById(2131301504));
      this.oDe = ((LinearLayout)this.oDb.findViewById(2131301499));
      this.oDd.setVisibility(8);
      this.oDe.setVisibility(8);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(1000L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.dwy.startAnimation(localRotateAnimation);
    }
    updateView();
    AppMethodBeat.o(113084);
  }
  
  public final void bVE()
  {
    AppMethodBeat.i(113086);
    this.oDd.setVisibility(0);
    this.oDe.setVisibility(8);
    AppMethodBeat.o(113086);
  }
  
  public final void bVF()
  {
    AppMethodBeat.i(113087);
    this.oDd.setVisibility(8);
    AppMethodBeat.o(113087);
  }
  
  public final void bVH()
  {
    AppMethodBeat.i(113089);
    bVG();
    this.oDf.setVisibility(8);
    AppMethodBeat.o(113089);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113090);
    Integer localInteger2 = (Integer)am.bUS().getValue("key_share_card_show_type");
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    if ((this.oDc != null) && (b.bVv()) && ((localInteger1.intValue() == 1) || (localInteger1.intValue() == 4)) && (b.bVs()))
    {
      this.oDf.setVisibility(0);
      bVG();
    }
    do
    {
      AppMethodBeat.o(113090);
      return;
      this.oDf.setVisibility(8);
      if (this.oDc == null) {
        break;
      }
      ad.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[] { Boolean.valueOf(b.bVv()), Boolean.valueOf(b.bVw()) });
      if ((!b.bVv()) || (!b.bVw()))
      {
        bVE();
        AppMethodBeat.o(113090);
        return;
      }
    } while ((!b.bVv()) || (!b.bVw()));
    bVD();
    AppMethodBeat.o(113090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.e
 * JD-Core Version:    0.7.0.1
 */