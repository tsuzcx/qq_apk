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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class e
{
  private ImageView dPk;
  private MMActivity pQZ;
  View pXr;
  b pXs;
  protected LinearLayout pXt;
  protected LinearLayout pXu;
  private TextView pXv;
  
  public e(MMActivity paramMMActivity)
  {
    this.pQZ = paramMMActivity;
  }
  
  private void cuJ()
  {
    AppMethodBeat.i(113085);
    this.pXt.setVisibility(8);
    this.pXu.setVisibility(8);
    AppMethodBeat.o(113085);
  }
  
  private void cuM()
  {
    AppMethodBeat.i(113088);
    this.pXt.setVisibility(8);
    this.pXu.setVisibility(8);
    AppMethodBeat.o(113088);
  }
  
  public final void cnh()
  {
    AppMethodBeat.i(113089);
    cuM();
    this.pXv.setVisibility(8);
    AppMethodBeat.o(113089);
  }
  
  public final void cuI()
  {
    AppMethodBeat.i(113084);
    if (this.pXr == null)
    {
      this.pXr = View.inflate(this.pQZ, 2131493418, null);
      this.dPk = ((ImageView)this.pXr.findViewById(2131296671));
      this.pXv = ((TextView)this.pXr.findViewById(2131307871));
      this.pXt = ((LinearLayout)this.pXr.findViewById(2131303707));
      this.pXu = ((LinearLayout)this.pXr.findViewById(2131303700));
      this.pXt.setVisibility(8);
      this.pXu.setVisibility(8);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(1000L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.dPk.startAnimation(localRotateAnimation);
    }
    updateView();
    AppMethodBeat.o(113084);
  }
  
  public final void cuK()
  {
    AppMethodBeat.i(113086);
    this.pXt.setVisibility(0);
    this.pXu.setVisibility(8);
    AppMethodBeat.o(113086);
  }
  
  public final void cuL()
  {
    AppMethodBeat.i(113087);
    this.pXt.setVisibility(8);
    AppMethodBeat.o(113087);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113090);
    Integer localInteger2 = (Integer)am.ctV().getValue("key_share_card_show_type");
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    if ((this.pXs != null) && (b.cuB()) && ((localInteger1.intValue() == 1) || (localInteger1.intValue() == 4)) && (b.cuy()))
    {
      this.pXv.setVisibility(0);
      cuM();
    }
    do
    {
      AppMethodBeat.o(113090);
      return;
      this.pXv.setVisibility(8);
      if (this.pXs == null) {
        break;
      }
      Log.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[] { Boolean.valueOf(b.cuB()), Boolean.valueOf(b.cuC()) });
      if ((!b.cuB()) || (!b.cuC()))
      {
        cuK();
        AppMethodBeat.o(113090);
        return;
      }
    } while ((!b.cuB()) || (!b.cuC()));
    cuJ();
    AppMethodBeat.o(113090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.e
 * JD-Core Version:    0.7.0.1
 */