package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.ck;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bs;

public class GameFeedMatchView
  extends LinearLayout
  implements View.OnClickListener
{
  private d tmX;
  private GameRoundImageView tqA;
  private GameFeedTitleDescView tqk;
  private GameFeedSubscriptView tqx;
  
  public GameFeedMatchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42111);
    if ((this.tmX == null) || (this.tmX.tdg == null))
    {
      AppMethodBeat.o(42111);
      return;
    }
    if (!bs.isNullOrNil(this.tmX.tdg.thh))
    {
      int i = c.ay(getContext(), this.tmX.tdg.thh);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.tmX.position, i, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), a.ae(this.tmX.tdg.thP, "clickType", "card"));
    }
    AppMethodBeat.o(42111);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42109);
    super.onFinishInflate();
    this.tqk = ((GameFeedTitleDescView)findViewById(2131300441));
    this.tqA = ((GameRoundImageView)findViewById(2131297217));
    this.tqx = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    AppMethodBeat.o(42109);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42110);
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiI == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42110);
      return;
    }
    this.tmX = paramd;
    paramd = paramd.tdg;
    setVisibility(0);
    this.tqk.b(paramd.tiI.Title, paramd.tiI.Desc, null);
    if (!bs.isNullOrNil(paramd.tiI.thg))
    {
      this.tqA.setVisibility(0);
      com.tencent.mm.plugin.game.f.e.cRL().a(this.tqA, paramd.tiI.thg, getResources().getDimensionPixelSize(2131165434), getResources().getDimensionPixelSize(2131165433), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    }
    for (;;)
    {
      this.tqx.setData(paramd);
      if (!this.tmX.tdi)
      {
        a.a(getContext(), 10, 1024, this.tmX.position, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), a.tu(this.tmX.tdg.thP));
        this.tmX.tdi = true;
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