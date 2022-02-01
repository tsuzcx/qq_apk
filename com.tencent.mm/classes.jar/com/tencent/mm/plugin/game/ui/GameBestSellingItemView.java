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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.protobuf.ai;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.bf;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameBestSellingItemView
  extends LinearLayout
  implements View.OnClickListener
{
  AutoResizeTextView CST;
  ImageView CSU;
  TextView CSV;
  GameTagListView CSW;
  GameDownloadView CSX;
  View CSY;
  private int CSZ;
  private ai CTa;
  private d CTb;
  
  public GameBestSellingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41892);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.CTa == null) || (Util.isNullOrNil(this.CTa.CME.CMG)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41892);
      return;
    }
    int i = com.tencent.mm.plugin.game.d.c.aY(getContext(), this.CTa.CME.CMG);
    com.tencent.mm.game.report.g.a(getContext(), 10, 1022, this.CTb.CIs + 1, i, this.CTa.CME.jUi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(this.CTb.CIr.CNA));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41892);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41890);
    super.onFinishInflate();
    this.CST = ((AutoResizeTextView)findViewById(g.e.Ckg));
    this.CSU = ((ImageView)findViewById(g.e.Cjt));
    this.CSV = ((TextView)findViewById(g.e.Cke));
    this.CSW = ((GameTagListView)findViewById(g.e.ClP));
    this.CSX = ((GameDownloadView)findViewById(g.e.ChU));
    this.CSY = findViewById(g.e.ClH);
    this.CSZ = (com.tencent.mm.plugin.game.d.c.getScreenWidth(getContext()) - com.tencent.mm.ci.a.fromDPToPix(getContext(), 190));
    setOnClickListener(this);
    AppMethodBeat.o(41890);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41891);
    if ((paramd == null) || (paramd.CIr == null) || (paramd.CIr.COC == null) || (Util.isNullOrNil(paramd.CIr.COC.CNz)))
    {
      setVisibility(8);
      AppMethodBeat.o(41891);
      return;
    }
    this.CTb = paramd;
    ai localai = (ai)paramd.CIr.COC.CNz.get(paramd.CIs);
    int i = paramd.CIs + 1;
    if ((localai == null) || (localai.CME == null)) {
      setVisibility(8);
    }
    for (;;)
    {
      if (!paramd.CIt)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1022, paramd.CIs + 1, localai.CME.jUi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(paramd.CIr.CNA));
        paramd.CIt = true;
      }
      AppMethodBeat.o(41891);
      return;
      this.CTa = localai;
      com.tencent.mm.plugin.game.model.c localc = x.a(this.CTa.CME);
      localc.scene = 10;
      localc.fSl = 1022;
      localc.position = (this.CTb.CIs + 1);
      this.CSX.setDownloadInfo(new l(localc));
      setVisibility(0);
      this.CST.setText(String.valueOf(i));
      if (i == 1) {
        this.CST.setTextColor(com.tencent.mm.plugin.game.d.c.aIQ("#EED157"));
      }
      for (;;)
      {
        e.eAa().c(this.CSU, localai.CME.jUi, com.tencent.mm.ci.a.getDensity(getContext()));
        this.CSV.setText(localai.CME.CMP);
        this.CSW.i(localai.CME.CNd, this.CSZ);
        if ((Util.isNullOrNil(localai.COl)) && (localai.COm == null) && (localai.CMB == null)) {
          break label438;
        }
        if ((this.CSY instanceof ViewStub)) {
          this.CSY = ((ViewStub)this.CSY).inflate();
        }
        ((GameFeedSocialInfoView)this.CSY.findViewById(g.e.Ckr)).setData(localai);
        break;
        if (i == 2) {
          this.CST.setTextColor(com.tencent.mm.plugin.game.d.c.aIQ("#BDC5CB"));
        } else if (i == 3) {
          this.CST.setTextColor(com.tencent.mm.plugin.game.d.c.aIQ("#D4B897"));
        } else {
          this.CST.setTextColor(com.tencent.mm.plugin.game.d.c.aIQ("#B2B2B2"));
        }
      }
      label438:
      this.CSY.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingItemView
 * JD-Core Version:    0.7.0.1
 */