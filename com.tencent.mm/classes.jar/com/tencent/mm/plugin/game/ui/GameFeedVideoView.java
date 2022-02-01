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
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.cj;
import com.tencent.mm.plugin.game.d.do;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedVideoView
  extends LinearLayout
  implements View.OnClickListener
{
  private d sfe;
  private GameFeedSubscriptView siE;
  private GameFeedTitleDescView sir;
  private FrameLayout siu;
  private GameRoundImageView sjb;
  private LinearLayout sjc;
  private ImageView sjd;
  private TextView sje;
  
  public GameFeedVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42143);
    if (this.sfe == null)
    {
      AppMethodBeat.o(42143);
      return;
    }
    if (!bt.isNullOrNil(this.sfe.rVo.rZo))
    {
      int i = c.ax(getContext(), this.sfe.rVo.rZo);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.sfe.position, i, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), a.ad(this.sfe.rVo.rZW, "clickType", "card"));
    }
    AppMethodBeat.o(42143);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42140);
    super.onFinishInflate();
    this.sir = ((GameFeedTitleDescView)findViewById(2131300441));
    this.siu = ((FrameLayout)findViewById(2131306354));
    this.sjb = ((GameRoundImageView)findViewById(2131306322));
    this.sjc = ((LinearLayout)findViewById(2131306325));
    this.sjd = ((ImageView)findViewById(2131306390));
    this.sje = ((TextView)findViewById(2131306326));
    this.siE = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    AppMethodBeat.o(42140);
  }
  
  public void setLiveData(d paramd)
  {
    AppMethodBeat.i(42142);
    if ((paramd == null) || (paramd.rVo == null) || (paramd.rVo.saN == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42142);
      return;
    }
    this.sfe = paramd;
    paramd = paramd.rVo;
    setVisibility(0);
    this.sir.b(paramd.saN.Title, paramd.saN.Desc, null);
    if (!bt.isNullOrNil(paramd.saN.rZn))
    {
      this.siu.setVisibility(0);
      com.tencent.mm.plugin.game.f.e.cEB().a(this.sjb, paramd.saN.rZn, getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (bt.isNullOrNil(paramd.saN.sdh)) {
        break label280;
      }
      this.sjc.setVisibility(0);
      this.sjd.setVisibility(0);
      this.sje.setText(paramd.saN.sdh);
    }
    for (;;)
    {
      this.siE.setData(paramd);
      if (!this.sfe.rVq)
      {
        a.a(getContext(), 10, 1024, this.sfe.position, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), a.qh(this.sfe.rVo.rZW));
        this.sfe.rVq = true;
      }
      AppMethodBeat.o(42142);
      return;
      this.siu.setVisibility(8);
      break;
      label280:
      this.sjc.setVisibility(8);
    }
  }
  
  public void setVideoData(d paramd)
  {
    AppMethodBeat.i(42141);
    if ((paramd == null) || (paramd.rVo == null) || (paramd.rVo.saM == null) || (bt.isNullOrNil(paramd.rVo.saM.rZn)))
    {
      setVisibility(8);
      AppMethodBeat.o(42141);
      return;
    }
    this.sfe = paramd;
    paramd = paramd.rVo;
    setVisibility(0);
    this.sir.b(paramd.saM.Title, paramd.saM.Desc, null);
    com.tencent.mm.plugin.game.f.e.cEB().a(this.sjb, paramd.saM.rZn, getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    if (!bt.isNullOrNil(paramd.saM.sdR))
    {
      this.sjc.setVisibility(0);
      this.sjd.setVisibility(8);
      this.sje.setText(paramd.saM.sdR);
    }
    for (;;)
    {
      this.siE.setData(paramd);
      AppMethodBeat.o(42141);
      return;
      this.sjc.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedVideoView
 * JD-Core Version:    0.7.0.1
 */