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
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedMatchView
  extends LinearLayout
  implements View.OnClickListener
{
  private d sfe;
  private GameFeedSubscriptView siE;
  private GameRoundImageView siH;
  private GameFeedTitleDescView sir;
  
  public GameFeedMatchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42111);
    if ((this.sfe == null) || (this.sfe.rVo == null))
    {
      AppMethodBeat.o(42111);
      return;
    }
    if (!bt.isNullOrNil(this.sfe.rVo.rZo))
    {
      int i = c.ax(getContext(), this.sfe.rVo.rZo);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.sfe.position, i, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), a.ad(this.sfe.rVo.rZW, "clickType", "card"));
    }
    AppMethodBeat.o(42111);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42109);
    super.onFinishInflate();
    this.sir = ((GameFeedTitleDescView)findViewById(2131300441));
    this.siH = ((GameRoundImageView)findViewById(2131297217));
    this.siE = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    AppMethodBeat.o(42109);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42110);
    if ((paramd == null) || (paramd.rVo == null) || (paramd.rVo.saO == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42110);
      return;
    }
    this.sfe = paramd;
    paramd = paramd.rVo;
    setVisibility(0);
    this.sir.b(paramd.saO.Title, paramd.saO.Desc, null);
    if (!bt.isNullOrNil(paramd.saO.rZn))
    {
      this.siH.setVisibility(0);
      com.tencent.mm.plugin.game.f.e.cEB().a(this.siH, paramd.saO.rZn, getResources().getDimensionPixelSize(2131165434), getResources().getDimensionPixelSize(2131165433), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    }
    for (;;)
    {
      this.siE.setData(paramd);
      if (!this.sfe.rVq)
      {
        a.a(getContext(), 10, 1024, this.sfe.position, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), a.qh(this.sfe.rVo.rZW));
        this.sfe.rVq = true;
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