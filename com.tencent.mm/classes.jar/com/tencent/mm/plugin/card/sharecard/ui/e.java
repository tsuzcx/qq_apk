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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public final class e
{
  private ImageView dkL;
  private MMActivity nTt;
  View nZH;
  b nZI;
  protected LinearLayout nZJ;
  protected LinearLayout nZK;
  private TextView nZL;
  
  public e(MMActivity paramMMActivity)
  {
    this.nTt = paramMMActivity;
  }
  
  private void bQY()
  {
    AppMethodBeat.i(113085);
    this.nZJ.setVisibility(8);
    this.nZK.setVisibility(8);
    AppMethodBeat.o(113085);
  }
  
  private void bRb()
  {
    AppMethodBeat.i(113088);
    this.nZJ.setVisibility(8);
    this.nZK.setVisibility(8);
    AppMethodBeat.o(113088);
  }
  
  public final void bQX()
  {
    AppMethodBeat.i(113084);
    if (this.nZH == null)
    {
      this.nZH = View.inflate(this.nTt, 2131493327, null);
      this.dkL = ((ImageView)this.nZH.findViewById(2131296594));
      this.nZL = ((TextView)this.nZH.findViewById(2131304789));
      this.nZJ = ((LinearLayout)this.nZH.findViewById(2131301504));
      this.nZK = ((LinearLayout)this.nZH.findViewById(2131301499));
      this.nZJ.setVisibility(8);
      this.nZK.setVisibility(8);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(1000L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.dkL.startAnimation(localRotateAnimation);
    }
    cL();
    AppMethodBeat.o(113084);
  }
  
  public final void bQZ()
  {
    AppMethodBeat.i(113086);
    this.nZJ.setVisibility(0);
    this.nZK.setVisibility(8);
    AppMethodBeat.o(113086);
  }
  
  public final void bRa()
  {
    AppMethodBeat.i(113087);
    this.nZJ.setVisibility(8);
    AppMethodBeat.o(113087);
  }
  
  public final void bRc()
  {
    AppMethodBeat.i(113089);
    bRb();
    this.nZL.setVisibility(8);
    AppMethodBeat.o(113089);
  }
  
  public final void cL()
  {
    AppMethodBeat.i(113090);
    Integer localInteger2 = (Integer)am.bQn().getValue("key_share_card_show_type");
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    if ((this.nZI != null) && (b.bQQ()) && ((localInteger1.intValue() == 1) || (localInteger1.intValue() == 4)) && (b.bQN()))
    {
      this.nZL.setVisibility(0);
      bRb();
    }
    do
    {
      AppMethodBeat.o(113090);
      return;
      this.nZL.setVisibility(8);
      if (this.nZI == null) {
        break;
      }
      ac.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[] { Boolean.valueOf(b.bQQ()), Boolean.valueOf(b.bQR()) });
      if ((!b.bQQ()) || (!b.bQR()))
      {
        bQZ();
        AppMethodBeat.o(113090);
        return;
      }
    } while ((!b.bQQ()) || (!b.bQR()));
    bQY();
    AppMethodBeat.o(113090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.e
 * JD-Core Version:    0.7.0.1
 */