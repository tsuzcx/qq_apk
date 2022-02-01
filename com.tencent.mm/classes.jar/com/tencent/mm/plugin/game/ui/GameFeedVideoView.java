package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.cy;
import com.tencent.mm.plugin.game.d.el;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bu;

public class GameFeedVideoView
  extends LinearLayout
  implements View.OnClickListener
{
  private GameRoundImageView uAN;
  private LinearLayout uAO;
  private ImageView uAP;
  private TextView uAQ;
  private GameFeedTitleDescView uAd;
  private FrameLayout uAg;
  private GameFeedSubscriptView uAq;
  private d uwS;
  
  public GameFeedVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42143);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (this.uwS == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42143);
      return;
    }
    if (!bu.isNullOrNil(this.uwS.ulY.uqf))
    {
      int i = c.aD(getContext(), this.uwS.ulY.uqf);
      f.a(getContext(), 10, 1024, this.uwS.position, i, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ak(this.uwS.ulY.ura, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42143);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42140);
    super.onFinishInflate();
    this.uAd = ((GameFeedTitleDescView)findViewById(2131300441));
    this.uAg = ((FrameLayout)findViewById(2131306354));
    this.uAN = ((GameRoundImageView)findViewById(2131306322));
    this.uAO = ((LinearLayout)findViewById(2131306325));
    this.uAP = ((ImageView)findViewById(2131306390));
    this.uAQ = ((TextView)findViewById(2131306326));
    this.uAq = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    AppMethodBeat.o(42140);
  }
  
  public void setLiveData(d paramd)
  {
    AppMethodBeat.i(42142);
    if ((paramd == null) || (paramd.ulY == null) || (paramd.ulY.urZ == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42142);
      return;
    }
    this.uwS = paramd;
    paramd = paramd.ulY;
    setVisibility(0);
    this.uAd.b(paramd.urZ.Title, paramd.urZ.Desc, null);
    if (!bu.isNullOrNil(paramd.urZ.uqe))
    {
      this.uAg.setVisibility(0);
      e.ddh().a(this.uAN, paramd.urZ.uqe, getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (bu.isNullOrNil(paramd.urZ.uuI)) {
        break label280;
      }
      this.uAO.setVisibility(0);
      this.uAP.setVisibility(0);
      this.uAQ.setText(paramd.urZ.uuI);
    }
    for (;;)
    {
      this.uAq.setData(paramd);
      if (!this.uwS.uma)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.uwS.position, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(this.uwS.ulY.ura));
        this.uwS.uma = true;
      }
      AppMethodBeat.o(42142);
      return;
      this.uAg.setVisibility(8);
      break;
      label280:
      this.uAO.setVisibility(8);
    }
  }
  
  public void setVideoData(d paramd)
  {
    AppMethodBeat.i(42141);
    if ((paramd == null) || (paramd.ulY == null) || (paramd.ulY.urY == null) || (bu.isNullOrNil(paramd.ulY.urY.uqe)))
    {
      setVisibility(8);
      AppMethodBeat.o(42141);
      return;
    }
    this.uwS = paramd;
    paramd = paramd.ulY;
    setVisibility(0);
    this.uAd.b(paramd.urY.Title, paramd.urY.Desc, null);
    e.ddh().a(this.uAN, paramd.urY.uqe, getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    if (!bu.isNullOrNil(paramd.urY.uvH))
    {
      this.uAO.setVisibility(0);
      this.uAP.setVisibility(8);
      this.uAQ.setText(paramd.urY.uvH);
    }
    for (;;)
    {
      this.uAq.setData(paramd);
      AppMethodBeat.o(42141);
      return;
      this.uAO.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedVideoView
 * JD-Core Version:    0.7.0.1
 */