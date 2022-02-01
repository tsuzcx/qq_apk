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
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.cr;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedMatchView
  extends LinearLayout
  implements View.OnClickListener
{
  private d ulv;
  private GameFeedTitleDescView uoH;
  private GameFeedSubscriptView uoU;
  private GameRoundImageView uoX;
  
  public GameFeedMatchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42111);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((this.ulv == null) || (this.ulv.uaW == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42111);
      return;
    }
    if (!bt.isNullOrNil(this.ulv.uaW.ueY))
    {
      int i = c.aB(getContext(), this.ulv.uaW.ueY);
      f.a(getContext(), 10, 1024, this.ulv.position, i, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.aj(this.ulv.uaW.ufG, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42111);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42109);
    super.onFinishInflate();
    this.uoH = ((GameFeedTitleDescView)findViewById(2131300441));
    this.uoX = ((GameRoundImageView)findViewById(2131297217));
    this.uoU = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    AppMethodBeat.o(42109);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42110);
    if ((paramd == null) || (paramd.uaW == null) || (paramd.uaW.ugD == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42110);
      return;
    }
    this.ulv = paramd;
    paramd = paramd.uaW;
    setVisibility(0);
    this.uoH.b(paramd.ugD.Title, paramd.ugD.Desc, null);
    if (!bt.isNullOrNil(paramd.ugD.ueX))
    {
      this.uoX.setVisibility(0);
      e.dav().a(this.uoX, paramd.ugD.ueX, getResources().getDimensionPixelSize(2131165434), getResources().getDimensionPixelSize(2131165433), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    }
    for (;;)
    {
      this.uoU.setData(paramd);
      if (!this.ulv.uaY)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.ulv.position, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(this.ulv.uaW.ufG));
        this.ulv.uaY = true;
      }
      AppMethodBeat.o(42110);
      return;
      setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMatchView
 * JD-Core Version:    0.7.0.1
 */