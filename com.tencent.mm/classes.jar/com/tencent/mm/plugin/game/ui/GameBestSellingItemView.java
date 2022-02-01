package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public class GameBestSellingItemView
  extends LinearLayout
  implements View.OnClickListener
{
  AutoResizeTextView tmP;
  ImageView tmQ;
  TextView tmR;
  GameTagListView tmS;
  GameDownloadView tmT;
  View tmU;
  private int tmV;
  private aa tmW;
  private d tmX;
  
  public GameBestSellingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41892);
    if ((this.tmW == null) || (bs.isNullOrNil(this.tmW.thi.thk)))
    {
      AppMethodBeat.o(41892);
      return;
    }
    int i = com.tencent.mm.plugin.game.f.c.ay(getContext(), this.tmW.thi.thk);
    com.tencent.mm.game.report.e.a(getContext(), 10, 1022, this.tmX.tdh + 1, i, this.tmW.thi.fZx, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.tu(this.tmX.tdg.thP));
    AppMethodBeat.o(41892);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41890);
    super.onFinishInflate();
    this.tmP = ((AutoResizeTextView)findViewById(2131300534));
    this.tmQ = ((ImageView)findViewById(2131300462));
    this.tmR = ((TextView)findViewById(2131300524));
    this.tmS = ((GameTagListView)findViewById(2131305629));
    this.tmT = ((GameDownloadView)findViewById(2131300354));
    this.tmU = findViewById(2131305107);
    this.tmV = (com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - com.tencent.mm.cc.a.fromDPToPix(getContext(), 190));
    setOnClickListener(this);
    AppMethodBeat.o(41890);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41891);
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiL == null) || (bs.gY(paramd.tdg.tiL.thO)))
    {
      setVisibility(8);
      AppMethodBeat.o(41891);
      return;
    }
    this.tmX = paramd;
    aa localaa = (aa)paramd.tdg.tiL.thO.get(paramd.tdh);
    int i = paramd.tdh + 1;
    if ((localaa == null) || (localaa.thi == null)) {
      setVisibility(8);
    }
    for (;;)
    {
      if (!paramd.tdi)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1022, paramd.tdh + 1, localaa.thi.fZx, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.tu(paramd.tdg.thP));
        paramd.tdi = true;
      }
      AppMethodBeat.o(41891);
      return;
      this.tmW = localaa;
      com.tencent.mm.plugin.game.model.c localc = x.a(this.tmW.thi);
      localc.scene = 10;
      localc.dtF = 1022;
      localc.position = (this.tmX.tdh + 1);
      this.tmT.setDownloadInfo(new l(localc));
      setVisibility(0);
      this.tmP.setText(String.valueOf(i));
      if (i == 1) {
        this.tmP.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#EED157"));
      }
      for (;;)
      {
        com.tencent.mm.plugin.game.f.e.cRL().c(this.tmQ, localaa.thi.fZx, com.tencent.mm.cc.a.getDensity(getContext()));
        this.tmR.setText(localaa.thi.Name);
        this.tmS.h(localaa.thi.thE, this.tmV);
        if ((bs.gY(localaa.tiw)) && (localaa.tix == null) && (localaa.Desc == null)) {
          break label437;
        }
        if ((this.tmU instanceof ViewStub)) {
          this.tmU = ((ViewStub)this.tmU).inflate();
        }
        ((GameFeedSocialInfoView)this.tmU.findViewById(2131300550)).setData(localaa);
        break;
        if (i == 2) {
          this.tmP.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#BDC5CB"));
        } else if (i == 3) {
          this.tmP.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#D4B897"));
        } else {
          this.tmP.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#B2B2B2"));
        }
      }
      label437:
      this.tmU.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingItemView
 * JD-Core Version:    0.7.0.1
 */