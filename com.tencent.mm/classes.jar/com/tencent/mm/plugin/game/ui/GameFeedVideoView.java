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
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.cq;
import com.tencent.mm.plugin.game.d.ec;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedVideoView
  extends LinearLayout
  implements View.OnClickListener
{
  private d ulv;
  private GameFeedTitleDescView uoH;
  private FrameLayout uoK;
  private GameFeedSubscriptView uoU;
  private GameRoundImageView upr;
  private LinearLayout ups;
  private ImageView upt;
  private TextView upu;
  
  public GameFeedVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42143);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (this.ulv == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42143);
      return;
    }
    if (!bt.isNullOrNil(this.ulv.uaW.ueY))
    {
      int i = c.aB(getContext(), this.ulv.uaW.ueY);
      f.a(getContext(), 10, 1024, this.ulv.position, i, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.aj(this.ulv.uaW.ufG, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42143);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42140);
    super.onFinishInflate();
    this.uoH = ((GameFeedTitleDescView)findViewById(2131300441));
    this.uoK = ((FrameLayout)findViewById(2131306354));
    this.upr = ((GameRoundImageView)findViewById(2131306322));
    this.ups = ((LinearLayout)findViewById(2131306325));
    this.upt = ((ImageView)findViewById(2131306390));
    this.upu = ((TextView)findViewById(2131306326));
    this.uoU = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    AppMethodBeat.o(42140);
  }
  
  public void setLiveData(d paramd)
  {
    AppMethodBeat.i(42142);
    if ((paramd == null) || (paramd.uaW == null) || (paramd.uaW.ugC == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42142);
      return;
    }
    this.ulv = paramd;
    paramd = paramd.uaW;
    setVisibility(0);
    this.uoH.b(paramd.ugC.Title, paramd.ugC.Desc, null);
    if (!bt.isNullOrNil(paramd.ugC.ueX))
    {
      this.uoK.setVisibility(0);
      e.dav().a(this.upr, paramd.ugC.ueX, getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (bt.isNullOrNil(paramd.ugC.ujk)) {
        break label280;
      }
      this.ups.setVisibility(0);
      this.upt.setVisibility(0);
      this.upu.setText(paramd.ugC.ujk);
    }
    for (;;)
    {
      this.uoU.setData(paramd);
      if (!this.ulv.uaY)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.ulv.position, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(this.ulv.uaW.ufG));
        this.ulv.uaY = true;
      }
      AppMethodBeat.o(42142);
      return;
      this.uoK.setVisibility(8);
      break;
      label280:
      this.ups.setVisibility(8);
    }
  }
  
  public void setVideoData(d paramd)
  {
    AppMethodBeat.i(42141);
    if ((paramd == null) || (paramd.uaW == null) || (paramd.uaW.ugB == null) || (bt.isNullOrNil(paramd.uaW.ugB.ueX)))
    {
      setVisibility(8);
      AppMethodBeat.o(42141);
      return;
    }
    this.ulv = paramd;
    paramd = paramd.uaW;
    setVisibility(0);
    this.uoH.b(paramd.ugB.Title, paramd.ugB.Desc, null);
    e.dav().a(this.upr, paramd.ugB.ueX, getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    if (!bt.isNullOrNil(paramd.ugB.ukk))
    {
      this.ups.setVisibility(0);
      this.upt.setVisibility(8);
      this.upu.setText(paramd.ugB.ukk);
    }
    for (;;)
    {
      this.uoU.setData(paramd);
      AppMethodBeat.o(42141);
      return;
      this.ups.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedVideoView
 * JD-Core Version:    0.7.0.1
 */