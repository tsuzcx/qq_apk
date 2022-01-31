package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.ca;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameFeedImageTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private int iiW = 0;
  private d nvA;
  private GameFeedTitleDescView nyR;
  private GameRoundImageView nyV;
  private LinearLayout nyZ;
  private GameRoundImageView nza;
  private GameRoundImageView nzb;
  private GameRoundImageView nzc;
  private TextView nzd;
  private GameFeedSubscriptView nze;
  private int nzf = 0;
  private int nzg;
  
  public GameFeedImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111933);
    if ((this.nvA == null) || (this.nvA.nmr == null))
    {
      AppMethodBeat.o(111933);
      return;
    }
    if (!bo.isNullOrNil(this.nvA.nmr.npR))
    {
      int i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvA.nmr.npR);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1024, this.nvA.position, i, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.V(this.nvA.nmr.nqt, "clickType", "card"));
    }
    AppMethodBeat.o(111933);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111931);
    super.onFinishInflate();
    this.nyR = ((GameFeedTitleDescView)findViewById(2131824608));
    this.nyV = ((GameRoundImageView)findViewById(2131824614));
    this.nyZ = ((LinearLayout)findViewById(2131824615));
    this.nza = ((GameRoundImageView)findViewById(2131824616));
    this.nzb = ((GameRoundImageView)findViewById(2131824617));
    this.nzc = ((GameRoundImageView)findViewById(2131824618));
    this.nzd = ((TextView)findViewById(2131824619));
    this.nze = ((GameFeedSubscriptView)findViewById(2131824613));
    setOnClickListener(this);
    this.iiW = (com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    this.nzf = ((this.iiW - com.tencent.mm.cb.a.fromDPToPix(getContext(), 10) * 2) / 3);
    this.nzg = com.tencent.mm.cb.a.fromDPToPix(getContext(), 105);
    if (this.nzf < this.nzg) {
      this.nzg = this.nzf;
    }
    ViewGroup.LayoutParams localLayoutParams = this.nza.getLayoutParams();
    localLayoutParams.width = this.nzg;
    localLayoutParams.height = this.nzg;
    this.nza.setLayoutParams(localLayoutParams);
    this.nzb.setLayoutParams(localLayoutParams);
    this.nzc.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(111931);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(111932);
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nri == null))
    {
      setVisibility(8);
      AppMethodBeat.o(111932);
      return;
    }
    this.nvA = paramd;
    paramd = paramd.nmr;
    setVisibility(0);
    this.nyR.b(paramd.nri.Title, paramd.nri.ntu, null);
    int i;
    if (!bo.es(paramd.nri.ntv))
    {
      i = paramd.nri.ntv.size();
      if (i == 1)
      {
        this.nyZ.setVisibility(8);
        this.nyV.setVisibility(0);
        e.bHE().a(this.nyV, (String)paramd.nri.ntv.get(0), getResources().getDimensionPixelSize(2131427719), getResources().getDimensionPixelSize(2131427718), com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      }
    }
    for (;;)
    {
      this.nze.setData(paramd);
      if (!this.nvA.nmt)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.nvA.position, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.lR(this.nvA.nmr.nqt));
        this.nvA.nmt = true;
      }
      AppMethodBeat.o(111932);
      return;
      this.nyV.setVisibility(8);
      this.nyZ.setVisibility(0);
      this.nzd.setVisibility(8);
      Object localObject = new e.a.a();
      ((e.a.a)localObject).nEu = true;
      localObject = ((e.a.a)localObject).bHF();
      e.bHE().a(this.nza, (String)paramd.nri.ntv.get(0), (e.a)localObject);
      e.bHE().a(this.nzb, (String)paramd.nri.ntv.get(1), (e.a)localObject);
      if (i > 2)
      {
        e.bHE().a(this.nzc, (String)paramd.nri.ntv.get(2), (e.a)localObject);
        this.nzc.setVisibility(0);
        if (i > 3)
        {
          this.nzd.setVisibility(0);
          this.nzd.setText(String.format("共%d张", new Object[] { Integer.valueOf(i) }));
        }
      }
      else
      {
        this.nzc.setVisibility(4);
        continue;
        this.nyV.setVisibility(8);
        this.nyZ.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedImageTextView
 * JD-Core Version:    0.7.0.1
 */