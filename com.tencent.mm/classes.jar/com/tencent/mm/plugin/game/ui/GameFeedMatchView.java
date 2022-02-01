package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.cz;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bu;

public class GameFeedMatchView
  extends LinearLayout
  implements View.OnClickListener
{
  private GameFeedTitleDescView uAd;
  private GameFeedSubscriptView uAq;
  private GameRoundImageView uAt;
  private d uwS;
  
  public GameFeedMatchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42111);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((this.uwS == null) || (this.uwS.ulY == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42111);
      return;
    }
    if (!bu.isNullOrNil(this.uwS.ulY.uqf))
    {
      int i = c.aD(getContext(), this.uwS.ulY.uqf);
      f.a(getContext(), 10, 1024, this.uwS.position, i, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ak(this.uwS.ulY.ura, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42111);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42109);
    super.onFinishInflate();
    this.uAd = ((GameFeedTitleDescView)findViewById(2131300441));
    this.uAt = ((GameRoundImageView)findViewById(2131297217));
    this.uAq = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    AppMethodBeat.o(42109);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42110);
    if ((paramd == null) || (paramd.ulY == null) || (paramd.ulY.usa == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42110);
      return;
    }
    this.uwS = paramd;
    paramd = paramd.ulY;
    setVisibility(0);
    this.uAd.b(paramd.usa.Title, paramd.usa.Desc, null);
    if (!bu.isNullOrNil(paramd.usa.uqe))
    {
      this.uAt.setVisibility(0);
      e.ddh().a(this.uAt, paramd.usa.uqe, getResources().getDimensionPixelSize(2131165434), getResources().getDimensionPixelSize(2131165433), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    }
    for (;;)
    {
      this.uAq.setData(paramd);
      if (!this.uwS.uma)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.uwS.position, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(this.uwS.ulY.ura));
        this.uwS.uma = true;
      }
      AppMethodBeat.o(42110);
      return;
      setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMatchView
 * JD-Core Version:    0.7.0.1
 */