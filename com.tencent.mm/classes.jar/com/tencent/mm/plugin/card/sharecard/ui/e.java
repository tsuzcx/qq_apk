package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public final class e
{
  private ImageView bQf;
  private MMActivity hxN;
  View iqg;
  b iqh;
  protected LinearLayout iqi;
  protected LinearLayout iqj;
  private TextView iqk;
  
  public e(MMActivity paramMMActivity)
  {
    this.hxN = paramMMActivity;
  }
  
  private void aBd()
  {
    this.iqi.setVisibility(8);
    this.iqj.setVisibility(8);
  }
  
  public final void aBa()
  {
    if (this.iqg == null)
    {
      this.iqg = View.inflate(this.hxN, a.e.card_othercity_footer, null);
      this.bQf = ((ImageView)this.iqg.findViewById(a.d.album_next_progress));
      this.iqk = ((TextView)this.iqg.findViewById(a.d.show_other_city));
      this.iqi = ((LinearLayout)this.iqg.findViewById(a.d.loading_more_state));
      this.iqj = ((LinearLayout)this.iqg.findViewById(a.d.loading_end));
      this.iqi.setVisibility(8);
      this.iqj.setVisibility(8);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(1000L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.bQf.startAnimation(localRotateAnimation);
    }
    aZ();
  }
  
  public final void aBb()
  {
    this.iqi.setVisibility(0);
    this.iqj.setVisibility(8);
  }
  
  public final void aBc()
  {
    this.iqi.setVisibility(8);
  }
  
  public final void aBe()
  {
    aBd();
    this.iqk.setVisibility(8);
  }
  
  public final void aZ()
  {
    Integer localInteger2 = (Integer)am.aAx().getValue("key_share_card_show_type");
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    if ((this.iqh != null) && (b.aAU()) && ((localInteger1.intValue() == 1) || (localInteger1.intValue() == 4)) && (b.aAR()))
    {
      this.iqk.setVisibility(0);
      aBd();
    }
    do
    {
      return;
      this.iqk.setVisibility(8);
      if (this.iqh == null) {
        break;
      }
      y.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[] { Boolean.valueOf(b.aAU()), Boolean.valueOf(b.aAV()) });
      if ((!b.aAU()) || (!b.aAV()))
      {
        aBb();
        return;
      }
    } while ((!b.aAU()) || (!b.aAV()));
    this.iqi.setVisibility(8);
    this.iqj.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.e
 * JD-Core Version:    0.7.0.1
 */