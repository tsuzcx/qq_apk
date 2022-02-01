package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.mgr.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class e
{
  private ImageView hNV;
  private MMActivity wry;
  View wxL;
  b wxM;
  protected LinearLayout wxN;
  protected LinearLayout wxO;
  private TextView wxP;
  
  public e(MMActivity paramMMActivity)
  {
    this.wry = paramMMActivity;
  }
  
  private void dlC()
  {
    AppMethodBeat.i(113085);
    this.wxN.setVisibility(8);
    this.wxO.setVisibility(8);
    AppMethodBeat.o(113085);
  }
  
  private void dlF()
  {
    AppMethodBeat.i(113088);
    this.wxN.setVisibility(8);
    this.wxO.setVisibility(8);
    AppMethodBeat.o(113088);
  }
  
  public final void ddX()
  {
    AppMethodBeat.i(113089);
    dlF();
    this.wxP.setVisibility(8);
    AppMethodBeat.o(113089);
  }
  
  public final void dlB()
  {
    AppMethodBeat.i(113084);
    if (this.wxL == null)
    {
      this.wxL = View.inflate(this.wry, a.e.wnv, null);
      this.hNV = ((ImageView)this.wxL.findViewById(a.d.album_next_progress));
      this.wxP = ((TextView)this.wxL.findViewById(a.d.wlu));
      this.wxN = ((LinearLayout)this.wxL.findViewById(a.d.loading_more_state));
      this.wxO = ((LinearLayout)this.wxL.findViewById(a.d.loading_end));
      this.wxN.setVisibility(8);
      this.wxO.setVisibility(8);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(1000L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.hNV.startAnimation(localRotateAnimation);
    }
    updateView();
    AppMethodBeat.o(113084);
  }
  
  public final void dlD()
  {
    AppMethodBeat.i(113086);
    this.wxN.setVisibility(0);
    this.wxO.setVisibility(8);
    AppMethodBeat.o(113086);
  }
  
  public final void dlE()
  {
    AppMethodBeat.i(113087);
    this.wxN.setVisibility(8);
    AppMethodBeat.o(113087);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113090);
    Integer localInteger2 = (Integer)am.dkO().getValue("key_share_card_show_type");
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    if ((this.wxM != null) && (b.dlu()) && ((localInteger1.intValue() == 1) || (localInteger1.intValue() == 4)) && (b.dlr()))
    {
      this.wxP.setVisibility(0);
      dlF();
    }
    do
    {
      AppMethodBeat.o(113090);
      return;
      this.wxP.setVisibility(8);
      if (this.wxM == null) {
        break;
      }
      Log.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[] { Boolean.valueOf(b.dlu()), Boolean.valueOf(b.dlv()) });
      if ((!b.dlu()) || (!b.dlv()))
      {
        dlD();
        AppMethodBeat.o(113090);
        return;
      }
    } while ((!b.dlu()) || (!b.dlv()));
    dlC();
    AppMethodBeat.o(113090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.e
 * JD-Core Version:    0.7.0.1
 */