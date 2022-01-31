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
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.cj;
import com.tencent.mm.plugin.game.d.dn;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedVideoView
  extends LinearLayout
  implements View.OnClickListener
{
  private d nvA;
  private GameFeedTitleDescView nyR;
  private FrameLayout nyU;
  private GameRoundImageView nzB;
  private LinearLayout nzC;
  private ImageView nzD;
  private TextView nzE;
  private GameFeedSubscriptView nze;
  
  public GameFeedVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111960);
    if (this.nvA == null)
    {
      AppMethodBeat.o(111960);
      return;
    }
    if (!bo.isNullOrNil(this.nvA.nmr.npR))
    {
      int i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvA.nmr.npR);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1024, this.nvA.position, i, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), a.V(this.nvA.nmr.nqt, "clickType", "card"));
    }
    AppMethodBeat.o(111960);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111957);
    super.onFinishInflate();
    this.nyR = ((GameFeedTitleDescView)findViewById(2131824608));
    this.nyU = ((FrameLayout)findViewById(2131824611));
    this.nzB = ((GameRoundImageView)findViewById(2131824633));
    this.nzC = ((LinearLayout)findViewById(2131824634));
    this.nzD = ((ImageView)findViewById(2131824635));
    this.nzE = ((TextView)findViewById(2131824636));
    this.nze = ((GameFeedSubscriptView)findViewById(2131824613));
    setOnClickListener(this);
    AppMethodBeat.o(111957);
  }
  
  public void setLiveData(d paramd)
  {
    AppMethodBeat.i(111959);
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nrk == null))
    {
      setVisibility(8);
      AppMethodBeat.o(111959);
      return;
    }
    this.nvA = paramd;
    paramd = paramd.nmr;
    setVisibility(0);
    this.nyR.b(paramd.nrk.Title, paramd.nrk.Desc, null);
    if (!bo.isNullOrNil(paramd.nrk.npQ))
    {
      this.nyU.setVisibility(0);
      e.bHE().a(this.nzB, paramd.nrk.npQ, getResources().getDimensionPixelSize(2131427719), getResources().getDimensionPixelSize(2131427718), com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (bo.isNullOrNil(paramd.nrk.ntG)) {
        break label280;
      }
      this.nzC.setVisibility(0);
      this.nzD.setVisibility(0);
      this.nzE.setText(paramd.nrk.ntG);
    }
    for (;;)
    {
      this.nze.setData(paramd);
      if (!this.nvA.nmt)
      {
        a.a(getContext(), 10, 1024, this.nvA.position, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), a.lR(this.nvA.nmr.nqt));
        this.nvA.nmt = true;
      }
      AppMethodBeat.o(111959);
      return;
      this.nyU.setVisibility(8);
      break;
      label280:
      this.nzC.setVisibility(8);
    }
  }
  
  public void setVideoData(d paramd)
  {
    AppMethodBeat.i(111958);
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nrj == null) || (bo.isNullOrNil(paramd.nmr.nrj.npQ)))
    {
      setVisibility(8);
      AppMethodBeat.o(111958);
      return;
    }
    this.nvA = paramd;
    paramd = paramd.nmr;
    setVisibility(0);
    this.nyR.b(paramd.nrj.Title, paramd.nrj.Desc, null);
    e.bHE().a(this.nzB, paramd.nrj.npQ, getResources().getDimensionPixelSize(2131427719), getResources().getDimensionPixelSize(2131427718), com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    if (!bo.isNullOrNil(paramd.nrj.nun))
    {
      this.nzC.setVisibility(0);
      this.nzD.setVisibility(8);
      this.nzE.setText(paramd.nrj.nun);
    }
    for (;;)
    {
      this.nze.setData(paramd);
      AppMethodBeat.o(111958);
      return;
      this.nzC.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedVideoView
 * JD-Core Version:    0.7.0.1
 */