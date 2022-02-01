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
import com.tencent.mm.sdk.platformtools.bs;

public class GameFeedGameTemplateView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView lgw;
  private int tmV;
  private d tmX;
  private ImageView toU;
  private TextView toV;
  private GameTagListView tqm;
  private FrameLayout tqn;
  private GameRoundImageView tqo;
  private ImageView tqp;
  private GameFeedSubscriptView tqq;
  private GameDownloadView tqr;
  
  public GameFeedGameTemplateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void g(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42103);
    int i = getResources().getDimensionPixelSize(2131165434);
    int j = getResources().getDimensionPixelSize(2131165433);
    com.tencent.mm.plugin.game.f.e.cRL().a(paramImageView, paramString, i, j, c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
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
    if ((this.tmX == null) || (this.tmX.tdg == null))
    {
      AppMethodBeat.o(42102);
      return;
    }
    int i;
    if ((paramView.getId() == 2131306354) && (!bs.isNullOrNil(this.tmX.tdg.tiJ.tjs)))
    {
      i = c.ay(getContext(), this.tmX.tdg.tiJ.tjs);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.tmX.position, i, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ae(this.tmX.tdg.thP, "clickType", "middle"));
      AppMethodBeat.o(42102);
      return;
    }
    if (!bs.isNullOrNil(this.tmX.tdg.thh))
    {
      i = c.ay(getContext(), this.tmX.tdg.thh);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.tmX.position, i, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ae(this.tmX.tdg.thP, "clickType", "card"));
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
    this.toU = ((ImageView)findViewById(2131300462));
    this.toV = ((TextView)findViewById(2131300524));
    this.tqm = ((GameTagListView)findViewById(2131300553));
    this.lgw = ((TextView)findViewById(2131298996));
    this.tqn = ((FrameLayout)findViewById(2131306354));
    this.tqo = ((GameRoundImageView)findViewById(2131300914));
    this.tqp = ((ImageView)findViewById(2131306363));
    this.tqq = ((GameFeedSubscriptView)findViewById(2131305528));
    this.tqr = ((GameDownloadView)findViewById(2131300435));
    setOnClickListener(this);
    this.tmV = (c.getScreenWidth(getContext()) - com.tencent.mm.cc.a.fromDPToPix(getContext(), 175));
    AppMethodBeat.o(42098);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42101);
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiJ == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42101);
      return;
    }
    this.tmX = paramd;
    paramd = paramd.tdg;
    setVisibility(0);
    com.tencent.mm.plugin.game.f.e.cRL().c(this.toU, paramd.tiJ.thi.fZx, com.tencent.mm.cc.a.getDensity(getContext()));
    this.toV.setText(paramd.tiJ.thi.Name);
    this.tqm.h(paramd.tiJ.thi.thE, this.tmV);
    if (!bs.isNullOrNil(paramd.tiJ.tjr))
    {
      this.lgw.setText(paramd.tiJ.tjr);
      this.lgw.setVisibility(0);
      this.tqn.setVisibility(0);
      if (bs.isNullOrNil(paramd.tiJ.tjt)) {
        break label350;
      }
      g(this.tqo, paramd.tiJ.thg);
      this.tqp.setVisibility(0);
    }
    for (;;)
    {
      this.tqn.setOnClickListener(this);
      this.tqq.setData(paramd);
      paramd = x.a(this.tmX.tdg.tiJ.thi);
      paramd.scene = 10;
      paramd.dtF = 1024;
      paramd.position = this.tmX.position;
      this.tqr.setDownloadInfo(new l(paramd));
      if (!this.tmX.tdi)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.tmX.position, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.tu(this.tmX.tdg.thP));
        this.tmX.tdi = true;
      }
      AppMethodBeat.o(42101);
      return;
      this.lgw.setVisibility(8);
      break;
      label350:
      if (!bs.isNullOrNil(paramd.tiJ.thg))
      {
        g(this.tqo, paramd.tiJ.thg);
        this.tqp.setVisibility(8);
      }
      else
      {
        this.tqn.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedGameTemplateView
 * JD-Core Version:    0.7.0.1
 */