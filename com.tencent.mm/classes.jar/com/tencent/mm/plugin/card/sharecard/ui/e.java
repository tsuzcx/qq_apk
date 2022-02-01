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
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class e
{
  private ImageView fIv;
  private MMActivity tmY;
  View tto;
  b ttp;
  protected LinearLayout ttq;
  protected LinearLayout ttr;
  private TextView tts;
  
  public e(MMActivity paramMMActivity)
  {
    this.tmY = paramMMActivity;
  }
  
  private void cIl()
  {
    AppMethodBeat.i(113085);
    this.ttq.setVisibility(8);
    this.ttr.setVisibility(8);
    AppMethodBeat.o(113085);
  }
  
  private void cIo()
  {
    AppMethodBeat.i(113088);
    this.ttq.setVisibility(8);
    this.ttr.setVisibility(8);
    AppMethodBeat.o(113088);
  }
  
  public final void cAT()
  {
    AppMethodBeat.i(113089);
    cIo();
    this.tts.setVisibility(8);
    AppMethodBeat.o(113089);
  }
  
  public final void cIk()
  {
    AppMethodBeat.i(113084);
    if (this.tto == null)
    {
      this.tto = View.inflate(this.tmY, a.e.tiY, null);
      this.fIv = ((ImageView)this.tto.findViewById(a.d.album_next_progress));
      this.tts = ((TextView)this.tto.findViewById(a.d.tgU));
      this.ttq = ((LinearLayout)this.tto.findViewById(a.d.loading_more_state));
      this.ttr = ((LinearLayout)this.tto.findViewById(a.d.loading_end));
      this.ttq.setVisibility(8);
      this.ttr.setVisibility(8);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(1000L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.fIv.startAnimation(localRotateAnimation);
    }
    updateView();
    AppMethodBeat.o(113084);
  }
  
  public final void cIm()
  {
    AppMethodBeat.i(113086);
    this.ttq.setVisibility(0);
    this.ttr.setVisibility(8);
    AppMethodBeat.o(113086);
  }
  
  public final void cIn()
  {
    AppMethodBeat.i(113087);
    this.ttq.setVisibility(8);
    AppMethodBeat.o(113087);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113090);
    Integer localInteger2 = (Integer)am.cHx().getValue("key_share_card_show_type");
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    if ((this.ttp != null) && (b.cId()) && ((localInteger1.intValue() == 1) || (localInteger1.intValue() == 4)) && (b.cIa()))
    {
      this.tts.setVisibility(0);
      cIo();
    }
    do
    {
      AppMethodBeat.o(113090);
      return;
      this.tts.setVisibility(8);
      if (this.ttp == null) {
        break;
      }
      Log.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[] { Boolean.valueOf(b.cId()), Boolean.valueOf(b.cIe()) });
      if ((!b.cId()) || (!b.cIe()))
      {
        cIm();
        AppMethodBeat.o(113090);
        return;
      }
    } while ((!b.cId()) || (!b.cIe()));
    cIl();
    AppMethodBeat.o(113090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.e
 * JD-Core Version:    0.7.0.1
 */