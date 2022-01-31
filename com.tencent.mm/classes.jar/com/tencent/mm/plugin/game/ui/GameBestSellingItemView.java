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
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.y;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameBestSellingItemView
  extends LinearLayout
  implements View.OnClickListener
{
  private d nvA;
  AutoResizeTextView nvs;
  ImageView nvt;
  TextView nvu;
  GameTagListView nvv;
  GameDownloadView nvw;
  View nvx;
  private int nvy;
  private y nvz;
  
  public GameBestSellingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111731);
    if ((this.nvz == null) || (bo.isNullOrNil(this.nvz.npS.npU)))
    {
      AppMethodBeat.o(111731);
      return;
    }
    int i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvz.npS.npU);
    com.tencent.mm.game.report.c.a(getContext(), 10, 1022, this.nvA.nms + 1, i, this.nvz.npS.npZ, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.lR(this.nvA.nmr.nqt));
    AppMethodBeat.o(111731);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111729);
    super.onFinishInflate();
    this.nvs = ((AutoResizeTextView)findViewById(2131824424));
    this.nvt = ((ImageView)findViewById(2131821573));
    this.nvu = ((TextView)findViewById(2131821575));
    this.nvv = ((GameTagListView)findViewById(2131824426));
    this.nvw = ((GameDownloadView)findViewById(2131824425));
    this.nvx = findViewById(2131824427);
    this.nvy = (com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 190));
    setOnClickListener(this);
    AppMethodBeat.o(111729);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(111730);
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nro == null) || (bo.es(paramd.nmr.nro.nqs)))
    {
      setVisibility(8);
      AppMethodBeat.o(111730);
      return;
    }
    this.nvA = paramd;
    y localy = (y)paramd.nmr.nro.nqs.get(paramd.nms);
    int i = paramd.nms + 1;
    if ((localy == null) || (localy.npS == null)) {
      setVisibility(8);
    }
    for (;;)
    {
      if (!paramd.nmt)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1022, paramd.nms + 1, localy.npS.npZ, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.lR(paramd.nmr.nqt));
        paramd.nmt = true;
      }
      AppMethodBeat.o(111730);
      return;
      this.nvz = localy;
      com.tencent.mm.plugin.game.model.c localc = x.a(this.nvz.npS);
      localc.scene = 10;
      localc.cFj = 1022;
      localc.position = (this.nvA.nms + 1);
      this.nvw.setDownloadInfo(new k(localc));
      setVisibility(0);
      this.nvs.setText(String.valueOf(i));
      if (i == 1) {
        this.nvs.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#EED157"));
      }
      for (;;)
      {
        com.tencent.mm.plugin.game.f.e.bHE().a(this.nvt, localy.npS.npZ, com.tencent.mm.cb.a.getDensity(getContext()));
        this.nvu.setText(localy.npS.Name);
        this.nvv.f(localy.npS.nqp, this.nvy);
        if ((bo.es(localy.nqZ)) && (localy.nra == null) && (localy.Desc == null)) {
          break label437;
        }
        if ((this.nvx instanceof ViewStub)) {
          this.nvx = ((ViewStub)this.nvx).inflate();
        }
        ((GameFeedSocialInfoView)this.nvx.findViewById(2131824770)).setData(localy);
        break;
        if (i == 2) {
          this.nvs.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#BDC5CB"));
        } else if (i == 3) {
          this.nvs.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#D4B897"));
        } else {
          this.nvs.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#B2B2B2"));
        }
      }
      label437:
      this.nvx.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingItemView
 * JD-Core Version:    0.7.0.1
 */