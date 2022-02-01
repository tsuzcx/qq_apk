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
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class GameBestSellingItemView
  extends LinearLayout
  implements View.OnClickListener
{
  AutoResizeTextView seW;
  ImageView seX;
  TextView seY;
  GameTagListView seZ;
  GameDownloadView sfa;
  View sfb;
  private int sfc;
  private aa sfd;
  private d sfe;
  
  public GameBestSellingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41892);
    if ((this.sfd == null) || (bt.isNullOrNil(this.sfd.rZp.rZr)))
    {
      AppMethodBeat.o(41892);
      return;
    }
    int i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.sfd.rZp.rZr);
    com.tencent.mm.game.report.e.a(getContext(), 10, 1022, this.sfe.rVp + 1, i, this.sfd.rZp.fVC, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.qh(this.sfe.rVo.rZW));
    AppMethodBeat.o(41892);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41890);
    super.onFinishInflate();
    this.seW = ((AutoResizeTextView)findViewById(2131300534));
    this.seX = ((ImageView)findViewById(2131300462));
    this.seY = ((TextView)findViewById(2131300524));
    this.seZ = ((GameTagListView)findViewById(2131305629));
    this.sfa = ((GameDownloadView)findViewById(2131300354));
    this.sfb = findViewById(2131305107);
    this.sfc = (com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - com.tencent.mm.cd.a.fromDPToPix(getContext(), 190));
    setOnClickListener(this);
    AppMethodBeat.o(41890);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41891);
    if ((paramd == null) || (paramd.rVo == null) || (paramd.rVo.saR == null) || (bt.gL(paramd.rVo.saR.rZV)))
    {
      setVisibility(8);
      AppMethodBeat.o(41891);
      return;
    }
    this.sfe = paramd;
    aa localaa = (aa)paramd.rVo.saR.rZV.get(paramd.rVp);
    int i = paramd.rVp + 1;
    if ((localaa == null) || (localaa.rZp == null)) {
      setVisibility(8);
    }
    for (;;)
    {
      if (!paramd.rVq)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1022, paramd.rVp + 1, localaa.rZp.fVC, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.qh(paramd.rVo.rZW));
        paramd.rVq = true;
      }
      AppMethodBeat.o(41891);
      return;
      this.sfd = localaa;
      com.tencent.mm.plugin.game.model.c localc = x.a(this.sfd.rZp);
      localc.scene = 10;
      localc.dvS = 1022;
      localc.position = (this.sfe.rVp + 1);
      this.sfa.setDownloadInfo(new l(localc));
      setVisibility(0);
      this.seW.setText(String.valueOf(i));
      if (i == 1) {
        this.seW.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#EED157"));
      }
      for (;;)
      {
        com.tencent.mm.plugin.game.f.e.cEB().c(this.seX, localaa.rZp.fVC, com.tencent.mm.cd.a.getDensity(getContext()));
        this.seY.setText(localaa.rZp.Name);
        this.seZ.h(localaa.rZp.rZL, this.sfc);
        if ((bt.gL(localaa.saC)) && (localaa.saD == null) && (localaa.Desc == null)) {
          break label437;
        }
        if ((this.sfb instanceof ViewStub)) {
          this.sfb = ((ViewStub)this.sfb).inflate();
        }
        ((GameFeedSocialInfoView)this.sfb.findViewById(2131300550)).setData(localaa);
        break;
        if (i == 2) {
          this.seW.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#BDC5CB"));
        } else if (i == 3) {
          this.seW.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#D4B897"));
        } else {
          this.seW.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#B2B2B2"));
        }
      }
      label437:
      this.sfb.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingItemView
 * JD-Core Version:    0.7.0.1
 */