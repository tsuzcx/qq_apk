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
import com.tencent.mm.sdk.platformtools.bs;

public class GameFeedVideoView
  extends LinearLayout
  implements View.OnClickListener
{
  private d tmX;
  private GameRoundImageView tqU;
  private LinearLayout tqV;
  private ImageView tqW;
  private TextView tqX;
  private GameFeedTitleDescView tqk;
  private FrameLayout tqn;
  private GameFeedSubscriptView tqx;
  
  public GameFeedVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42143);
    if (this.tmX == null)
    {
      AppMethodBeat.o(42143);
      return;
    }
    if (!bs.isNullOrNil(this.tmX.tdg.thh))
    {
      int i = c.ay(getContext(), this.tmX.tdg.thh);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.tmX.position, i, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), a.ae(this.tmX.tdg.thP, "clickType", "card"));
    }
    AppMethodBeat.o(42143);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42140);
    super.onFinishInflate();
    this.tqk = ((GameFeedTitleDescView)findViewById(2131300441));
    this.tqn = ((FrameLayout)findViewById(2131306354));
    this.tqU = ((GameRoundImageView)findViewById(2131306322));
    this.tqV = ((LinearLayout)findViewById(2131306325));
    this.tqW = ((ImageView)findViewById(2131306390));
    this.tqX = ((TextView)findViewById(2131306326));
    this.tqx = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    AppMethodBeat.o(42140);
  }
  
  public void setLiveData(d paramd)
  {
    AppMethodBeat.i(42142);
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiH == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42142);
      return;
    }
    this.tmX = paramd;
    paramd = paramd.tdg;
    setVisibility(0);
    this.tqk.b(paramd.tiH.Title, paramd.tiH.Desc, null);
    if (!bs.isNullOrNil(paramd.tiH.thg))
    {
      this.tqn.setVisibility(0);
      com.tencent.mm.plugin.game.f.e.cRL().a(this.tqU, paramd.tiH.thg, getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (bs.isNullOrNil(paramd.tiH.tlb)) {
        break label280;
      }
      this.tqV.setVisibility(0);
      this.tqW.setVisibility(0);
      this.tqX.setText(paramd.tiH.tlb);
    }
    for (;;)
    {
      this.tqx.setData(paramd);
      if (!this.tmX.tdi)
      {
        a.a(getContext(), 10, 1024, this.tmX.position, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), a.tu(this.tmX.tdg.thP));
        this.tmX.tdi = true;
      }
      AppMethodBeat.o(42142);
      return;
      this.tqn.setVisibility(8);
      break;
      label280:
      this.tqV.setVisibility(8);
    }
  }
  
  public void setVideoData(d paramd)
  {
    AppMethodBeat.i(42141);
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiG == null) || (bs.isNullOrNil(paramd.tdg.tiG.thg)))
    {
      setVisibility(8);
      AppMethodBeat.o(42141);
      return;
    }
    this.tmX = paramd;
    paramd = paramd.tdg;
    setVisibility(0);
    this.tqk.b(paramd.tiG.Title, paramd.tiG.Desc, null);
    com.tencent.mm.plugin.game.f.e.cRL().a(this.tqU, paramd.tiG.thg, getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    if (!bs.isNullOrNil(paramd.tiG.tlL))
    {
      this.tqV.setVisibility(0);
      this.tqW.setVisibility(8);
      this.tqX.setText(paramd.tiG.tlL);
    }
    for (;;)
    {
      this.tqx.setData(paramd);
      AppMethodBeat.o(42141);
      return;
      this.tqV.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedVideoView
 * JD-Core Version:    0.7.0.1
 */