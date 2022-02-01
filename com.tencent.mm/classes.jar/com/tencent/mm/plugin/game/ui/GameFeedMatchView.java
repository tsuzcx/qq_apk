package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.da;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedMatchView
  extends LinearLayout
  implements View.OnClickListener
{
  private d CTb;
  private GameFeedSubscriptView CWA;
  private GameRoundImageView CWD;
  private GameFeedTitleDescView CWn;
  
  public GameFeedMatchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42111);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.CTb == null) || (this.CTb.CIr == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42111);
      return;
    }
    if (!Util.isNullOrNil(this.CTb.CIr.CMD))
    {
      int i = c.aY(getContext(), this.CTb.CIr.CMD);
      g.a(getContext(), 10, 1024, this.CTb.position, i, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.am(this.CTb.CIr.CNA, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42111);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42109);
    super.onFinishInflate();
    this.CWn = ((GameFeedTitleDescView)findViewById(g.e.Cjh));
    this.CWD = ((GameRoundImageView)findViewById(g.e.Chr));
    this.CWA = ((GameFeedSubscriptView)findViewById(g.e.ClJ));
    setOnClickListener(this);
    AppMethodBeat.o(42109);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42110);
    if ((paramd == null) || (paramd.CIr == null) || (paramd.CIr.COz == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42110);
      return;
    }
    this.CTb = paramd;
    paramd = paramd.CIr;
    setVisibility(0);
    this.CWn.a(paramd.COz.fwr, paramd.COz.CMB, null);
    if (!Util.isNullOrNil(paramd.COz.CMC))
    {
      this.CWD.setVisibility(0);
      e.eAa().a(this.CWD, paramd.COz.CMC, getResources().getDimensionPixelSize(g.c.CgT), getResources().getDimensionPixelSize(g.c.CgS), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    }
    for (;;)
    {
      this.CWA.setData(paramd);
      if (!this.CTb.CIt)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.CTb.position, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(this.CTb.CIr.CNA));
        this.CTb.CIt = true;
      }
      AppMethodBeat.o(42110);
      return;
      setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMatchView
 * JD-Core Version:    0.7.0.1
 */