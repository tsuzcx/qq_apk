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
import com.tencent.mm.plugin.game.d.aw;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedGameTemplateView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView kPB;
  private d nvA;
  private int nvy;
  private ImageView nxA;
  private TextView nxB;
  private GameTagListView nyT;
  private FrameLayout nyU;
  private GameRoundImageView nyV;
  private ImageView nyW;
  private GameFeedSubscriptView nyX;
  private GameDownloadView nyY;
  
  public GameFeedGameTemplateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void d(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(111930);
    int i = getResources().getDimensionPixelSize(2131427728);
    int j = getResources().getDimensionPixelSize(2131427727);
    com.tencent.mm.plugin.game.f.e.bHE().a(paramImageView, paramString, i, j, com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    AppMethodBeat.o(111930);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(111927);
    super.onAttachedToWindow();
    AppMethodBeat.o(111927);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111929);
    if ((this.nvA == null) || (this.nvA.nmr == null))
    {
      AppMethodBeat.o(111929);
      return;
    }
    int i;
    if ((paramView.getId() == 2131824611) && (!bo.isNullOrNil(this.nvA.nmr.nrm.nrY)))
    {
      i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvA.nmr.nrm.nrY);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1024, this.nvA.position, i, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.V(this.nvA.nmr.nqt, "clickType", "middle"));
      AppMethodBeat.o(111929);
      return;
    }
    if (!bo.isNullOrNil(this.nvA.nmr.npR))
    {
      i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvA.nmr.npR);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1024, this.nvA.position, i, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.V(this.nvA.nmr.nqt, "clickType", "card"));
    }
    AppMethodBeat.o(111929);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(111926);
    super.onDetachedFromWindow();
    AppMethodBeat.o(111926);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111925);
    super.onFinishInflate();
    this.nxA = ((ImageView)findViewById(2131821573));
    this.nxB = ((TextView)findViewById(2131821575));
    this.nyT = ((GameTagListView)findViewById(2131824610));
    this.kPB = ((TextView)findViewById(2131821115));
    this.nyU = ((FrameLayout)findViewById(2131824611));
    this.nyV = ((GameRoundImageView)findViewById(2131820629));
    this.nyW = ((ImageView)findViewById(2131824612));
    this.nyX = ((GameFeedSubscriptView)findViewById(2131824613));
    this.nyY = ((GameDownloadView)findViewById(2131824446));
    setOnClickListener(this);
    this.nvy = (com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 175));
    AppMethodBeat.o(111925);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(111928);
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nrm == null))
    {
      setVisibility(8);
      AppMethodBeat.o(111928);
      return;
    }
    this.nvA = paramd;
    paramd = paramd.nmr;
    setVisibility(0);
    com.tencent.mm.plugin.game.f.e.bHE().a(this.nxA, paramd.nrm.npS.npZ, com.tencent.mm.cb.a.getDensity(getContext()));
    this.nxB.setText(paramd.nrm.npS.Name);
    this.nyT.f(paramd.nrm.npS.nqp, this.nvy);
    if (!bo.isNullOrNil(paramd.nrm.nrX))
    {
      this.kPB.setText(paramd.nrm.nrX);
      this.kPB.setVisibility(0);
      this.nyU.setVisibility(0);
      if (bo.isNullOrNil(paramd.nrm.nrZ)) {
        break label350;
      }
      d(this.nyV, paramd.nrm.npQ);
      this.nyW.setVisibility(0);
    }
    for (;;)
    {
      this.nyU.setOnClickListener(this);
      this.nyX.setData(paramd);
      paramd = x.a(this.nvA.nmr.nrm.npS);
      paramd.scene = 10;
      paramd.cFj = 1024;
      paramd.position = this.nvA.position;
      this.nyY.setDownloadInfo(new k(paramd));
      if (!this.nvA.nmt)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.nvA.position, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.lR(this.nvA.nmr.nqt));
        this.nvA.nmt = true;
      }
      AppMethodBeat.o(111928);
      return;
      this.kPB.setVisibility(8);
      break;
      label350:
      if (!bo.isNullOrNil(paramd.nrm.npQ))
      {
        d(this.nyV, paramd.nrm.npQ);
        this.nyW.setVisibility(8);
      }
      else
      {
        this.nyU.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedGameTemplateView
 * JD-Core Version:    0.7.0.1
 */