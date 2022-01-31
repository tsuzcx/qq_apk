package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.cs;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedNoGamePlayTemplate
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView iCl;
  private d nvA;
  GameDownloadView nvw;
  private GameRoundImageView nyV;
  private ImageView nyW;
  private GameFeedTitleDescView nzi;
  private FrameLayout nzj;
  private RelativeLayout nzk;
  private TextView nzl;
  
  public GameFeedNoGamePlayTemplate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111944);
    if ((this.nvA == null) || (this.nvA.nmr == null) || (this.nvA.nmr.nrn == null))
    {
      AppMethodBeat.o(111944);
      return;
    }
    int i;
    if ((paramView.getId() == 2131824621) && (!bo.isNullOrNil(this.nvA.nmr.nrn.nrZ)))
    {
      i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvA.nmr.nrn.nrZ);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1024, this.nvA.position, i, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.V(this.nvA.nmr.nqt, "clickType", "middle"));
      AppMethodBeat.o(111944);
      return;
    }
    if (!bo.isNullOrNil(this.nvA.nmr.npR))
    {
      i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvA.nmr.npR);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1024, this.nvA.position, i, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.V(this.nvA.nmr.nqt, "clickType", "card"));
    }
    AppMethodBeat.o(111944);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(111942);
    super.onFinishInflate();
    this.nzi = ((GameFeedTitleDescView)findViewById(2131824608));
    this.nzj = ((FrameLayout)findViewById(2131824621));
    this.nyV = ((GameRoundImageView)findViewById(2131824622));
    this.nyW = ((ImageView)findViewById(2131824612));
    this.nzk = ((RelativeLayout)findViewById(2131824623));
    this.iCl = ((ImageView)findViewById(2131821573));
    this.nzl = ((TextView)findViewById(2131821575));
    this.nvw = ((GameDownloadView)findViewById(2131824446));
    setOnClickListener(this);
    this.nzj.setOnClickListener(this);
    AppMethodBeat.o(111942);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(111943);
    ab.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nrn == null))
    {
      setVisibility(8);
      AppMethodBeat.o(111943);
      return;
    }
    ab.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
    this.nvA = paramd;
    paramd = paramd.nmr;
    setVisibility(0);
    this.nzi.b(paramd.nrn.Title, paramd.nrn.Desc, paramd.nrn.ntS);
    this.nzj.setVisibility(0);
    if (!bo.isNullOrNil(paramd.nrn.npQ))
    {
      com.tencent.mm.plugin.game.f.e.bHE().a(this.nyV, paramd.nrn.npQ, getResources().getDimensionPixelSize(2131427728), getResources().getDimensionPixelSize(2131427727), com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (!bo.isNullOrNil(paramd.nrn.nrZ)) {
        this.nyW.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramd.nrn.npS != null)
      {
        this.nzk.setVisibility(0);
        com.tencent.mm.plugin.game.f.e.bHE().a(this.iCl, paramd.nrn.npS.npZ, com.tencent.mm.cb.a.getDensity(getContext()));
        this.nzl.setText(paramd.nrn.npS.Name);
        paramd = x.a(paramd.nrn.npS);
        paramd.scene = 10;
        paramd.cFj = 1024;
        paramd.position = this.nvA.position;
        this.nvw.setDownloadInfo(new k(paramd));
      }
      if (!this.nvA.nmt)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.nvA.position, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.lR(this.nvA.nmr.nqt));
        this.nvA.nmt = true;
      }
      AppMethodBeat.o(111943);
      return;
      this.nyW.setVisibility(8);
      continue;
      this.nzj.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedNoGamePlayTemplate
 * JD-Core Version:    0.7.0.1
 */