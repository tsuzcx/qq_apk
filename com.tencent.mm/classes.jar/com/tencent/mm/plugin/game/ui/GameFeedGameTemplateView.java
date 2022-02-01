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
import com.tencent.mm.plugin.game.d.aw;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedGameTemplateView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView kFd;
  private int sfc;
  private d sfe;
  private ImageView sha;
  private TextView shb;
  private GameTagListView sit;
  private FrameLayout siu;
  private GameRoundImageView siv;
  private ImageView siw;
  private GameFeedSubscriptView six;
  private GameDownloadView siy;
  
  public GameFeedGameTemplateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void g(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42103);
    int i = getResources().getDimensionPixelSize(2131165434);
    int j = getResources().getDimensionPixelSize(2131165433);
    com.tencent.mm.plugin.game.f.e.cEB().a(paramImageView, paramString, i, j, c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    AppMethodBeat.o(42103);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(42100);
    super.onAttachedToWindow();
    AppMethodBeat.o(42100);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42102);
    if ((this.sfe == null) || (this.sfe.rVo == null))
    {
      AppMethodBeat.o(42102);
      return;
    }
    int i;
    if ((paramView.getId() == 2131306354) && (!bt.isNullOrNil(this.sfe.rVo.saP.sby)))
    {
      i = c.ax(getContext(), this.sfe.rVo.saP.sby);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.sfe.position, i, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ad(this.sfe.rVo.rZW, "clickType", "middle"));
      AppMethodBeat.o(42102);
      return;
    }
    if (!bt.isNullOrNil(this.sfe.rVo.rZo))
    {
      i = c.ax(getContext(), this.sfe.rVo.rZo);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.sfe.position, i, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ad(this.sfe.rVo.rZW, "clickType", "card"));
    }
    AppMethodBeat.o(42102);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(42099);
    super.onDetachedFromWindow();
    AppMethodBeat.o(42099);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42098);
    super.onFinishInflate();
    this.sha = ((ImageView)findViewById(2131300462));
    this.shb = ((TextView)findViewById(2131300524));
    this.sit = ((GameTagListView)findViewById(2131300553));
    this.kFd = ((TextView)findViewById(2131298996));
    this.siu = ((FrameLayout)findViewById(2131306354));
    this.siv = ((GameRoundImageView)findViewById(2131300914));
    this.siw = ((ImageView)findViewById(2131306363));
    this.six = ((GameFeedSubscriptView)findViewById(2131305528));
    this.siy = ((GameDownloadView)findViewById(2131300435));
    setOnClickListener(this);
    this.sfc = (c.getScreenWidth(getContext()) - com.tencent.mm.cd.a.fromDPToPix(getContext(), 175));
    AppMethodBeat.o(42098);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42101);
    if ((paramd == null) || (paramd.rVo == null) || (paramd.rVo.saP == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42101);
      return;
    }
    this.sfe = paramd;
    paramd = paramd.rVo;
    setVisibility(0);
    com.tencent.mm.plugin.game.f.e.cEB().c(this.sha, paramd.saP.rZp.fVC, com.tencent.mm.cd.a.getDensity(getContext()));
    this.shb.setText(paramd.saP.rZp.Name);
    this.sit.h(paramd.saP.rZp.rZL, this.sfc);
    if (!bt.isNullOrNil(paramd.saP.sbx))
    {
      this.kFd.setText(paramd.saP.sbx);
      this.kFd.setVisibility(0);
      this.siu.setVisibility(0);
      if (bt.isNullOrNil(paramd.saP.sbz)) {
        break label350;
      }
      g(this.siv, paramd.saP.rZn);
      this.siw.setVisibility(0);
    }
    for (;;)
    {
      this.siu.setOnClickListener(this);
      this.six.setData(paramd);
      paramd = x.a(this.sfe.rVo.saP.rZp);
      paramd.scene = 10;
      paramd.dvS = 1024;
      paramd.position = this.sfe.position;
      this.siy.setDownloadInfo(new l(paramd));
      if (!this.sfe.rVq)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.sfe.position, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.qh(this.sfe.rVo.rZW));
        this.sfe.rVq = true;
      }
      AppMethodBeat.o(42101);
      return;
      this.kFd.setVisibility(8);
      break;
      label350:
      if (!bt.isNullOrNil(paramd.saP.rZn))
      {
        g(this.siv, paramd.saP.rZn);
        this.siw.setVisibility(8);
      }
      else
      {
        this.siu.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedGameTemplateView
 * JD-Core Version:    0.7.0.1
 */