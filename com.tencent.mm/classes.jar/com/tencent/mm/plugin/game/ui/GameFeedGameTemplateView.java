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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.bh;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedGameTemplateView
  extends LinearLayout
  implements View.OnClickListener
{
  private int CSZ;
  private d CTb;
  private ImageView CUW;
  private TextView CUX;
  private GameTagListView CWp;
  private FrameLayout CWq;
  private GameRoundImageView CWr;
  private ImageView CWs;
  private GameFeedSubscriptView CWt;
  private GameDownloadView CWu;
  private TextView mMA;
  
  public GameFeedGameTemplateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void k(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42103);
    int i = getResources().getDimensionPixelSize(g.c.CgT);
    int j = getResources().getDimensionPixelSize(g.c.CgS);
    e.eAa().a(paramImageView, paramString, i, j, c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
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
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.CTb == null) || (this.CTb.CIr == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42102);
      return;
    }
    int i;
    if ((paramView.getId() == g.e.ClZ) && (!Util.isNullOrNil(this.CTb.CIr.COA.CPr)))
    {
      i = c.aY(getContext(), this.CTb.CIr.COA.CPr);
      com.tencent.mm.game.report.g.a(getContext(), 10, 1024, this.CTb.position, i, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.am(this.CTb.CIr.CNA, "clickType", "middle"));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42102);
      return;
    }
    if (!Util.isNullOrNil(this.CTb.CIr.CMD))
    {
      i = c.aY(getContext(), this.CTb.CIr.CMD);
      com.tencent.mm.game.report.g.a(getContext(), 10, 1024, this.CTb.position, i, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.am(this.CTb.CIr.CNA, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.CUW = ((ImageView)findViewById(g.e.Cjt));
    this.CUX = ((TextView)findViewById(g.e.Cke));
    this.CWp = ((GameTagListView)findViewById(g.e.Ckw));
    this.mMA = ((TextView)findViewById(g.e.desc));
    this.CWq = ((FrameLayout)findViewById(g.e.ClZ));
    this.CWr = ((GameRoundImageView)findViewById(g.e.image));
    this.CWs = ((ImageView)findViewById(g.e.Cma));
    this.CWt = ((GameFeedSubscriptView)findViewById(g.e.ClJ));
    this.CWu = ((GameDownloadView)findViewById(g.e.Cje));
    setOnClickListener(this);
    this.CSZ = (c.getScreenWidth(getContext()) - com.tencent.mm.ci.a.fromDPToPix(getContext(), 175));
    AppMethodBeat.o(42098);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42101);
    if ((paramd == null) || (paramd.CIr == null) || (paramd.CIr.COA == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42101);
      return;
    }
    this.CTb = paramd;
    paramd = paramd.CIr;
    setVisibility(0);
    e.eAa().c(this.CUW, paramd.COA.CME.jUi, com.tencent.mm.ci.a.getDensity(getContext()));
    this.CUX.setText(paramd.COA.CME.CMP);
    this.CWp.i(paramd.COA.CME.CNd, this.CSZ);
    if (!Util.isNullOrNil(paramd.COA.CPq))
    {
      this.mMA.setText(paramd.COA.CPq);
      this.mMA.setVisibility(0);
      this.CWq.setVisibility(0);
      if (Util.isNullOrNil(paramd.COA.CPs)) {
        break label353;
      }
      k(this.CWr, paramd.COA.CMC);
      this.CWs.setVisibility(0);
    }
    for (;;)
    {
      this.CWq.setOnClickListener(this);
      this.CWt.setData(paramd);
      paramd = x.a(this.CTb.CIr.COA.CME);
      paramd.scene = 10;
      paramd.fSl = 1024;
      paramd.position = this.CTb.position;
      this.CWu.setDownloadInfo(new l(paramd));
      if (!this.CTb.CIt)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.CTb.position, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(this.CTb.CIr.CNA));
        this.CTb.CIt = true;
      }
      AppMethodBeat.o(42101);
      return;
      this.mMA.setVisibility(8);
      break;
      label353:
      if (!Util.isNullOrNil(paramd.COA.CMC))
      {
        k(this.CWr, paramd.COA.CMC);
        this.CWs.setVisibility(8);
      }
      else
      {
        this.CWq.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedGameTemplateView
 * JD-Core Version:    0.7.0.1
 */