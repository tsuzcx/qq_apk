package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.ck;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedMatchView
  extends LinearLayout
  implements View.OnClickListener
{
  private d nvA;
  private GameFeedTitleDescView nyR;
  private GameFeedSubscriptView nze;
  private GameRoundImageView nzh;
  
  public GameFeedMatchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111936);
    if ((this.nvA == null) || (this.nvA.nmr == null))
    {
      AppMethodBeat.o(111936);
      return;
    }
    if (!bo.isNullOrNil(this.nvA.nmr.npR))
    {
      int i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvA.nmr.npR);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1024, this.nvA.position, i, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), a.V(this.nvA.nmr.nqt, "clickType", "card"));
    }
    AppMethodBeat.o(111936);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111934);
    super.onFinishInflate();
    this.nyR = ((GameFeedTitleDescView)findViewById(2131824608));
    this.nzh = ((GameRoundImageView)findViewById(2131824614));
    this.nze = ((GameFeedSubscriptView)findViewById(2131824613));
    setOnClickListener(this);
    AppMethodBeat.o(111934);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(111935);
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nrl == null))
    {
      setVisibility(8);
      AppMethodBeat.o(111935);
      return;
    }
    this.nvA = paramd;
    paramd = paramd.nmr;
    setVisibility(0);
    this.nyR.b(paramd.nrl.Title, paramd.nrl.Desc, null);
    if (!bo.isNullOrNil(paramd.nrl.npQ))
    {
      this.nzh.setVisibility(0);
      e.bHE().a(this.nzh, paramd.nrl.npQ, getResources().getDimensionPixelSize(2131427728), getResources().getDimensionPixelSize(2131427727), com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    }
    for (;;)
    {
      this.nze.setData(paramd);
      if (!this.nvA.nmt)
      {
        a.a(getContext(), 10, 1024, this.nvA.position, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), a.lR(this.nvA.nmr.nqt));
        this.nvA.nmt = true;
      }
      AppMethodBeat.o(111935);
      return;
      setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMatchView
 * JD-Core Version:    0.7.0.1
 */