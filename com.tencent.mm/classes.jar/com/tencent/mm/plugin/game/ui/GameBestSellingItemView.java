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
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.g;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public class GameBestSellingItemView
  extends LinearLayout
  implements View.OnClickListener
{
  AutoResizeTextView uwK;
  ImageView uwL;
  TextView uwM;
  GameTagListView uwN;
  GameDownloadView uwO;
  View uwP;
  private int uwQ;
  private ag uwR;
  private d uwS;
  
  public GameBestSellingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41892);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((this.uwR == null) || (bu.isNullOrNil(this.uwR.uqg.uqi)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41892);
      return;
    }
    int i = com.tencent.mm.plugin.game.f.c.aD(getContext(), this.uwR.uqg.uqi);
    f.a(getContext(), 10, 1022, this.uwS.ulZ + 1, i, this.uwR.uqg.gvv, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(this.uwS.ulY.ura));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41892);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41890);
    super.onFinishInflate();
    this.uwK = ((AutoResizeTextView)findViewById(2131300534));
    this.uwL = ((ImageView)findViewById(2131300462));
    this.uwM = ((TextView)findViewById(2131300524));
    this.uwN = ((GameTagListView)findViewById(2131305629));
    this.uwO = ((GameDownloadView)findViewById(2131300354));
    this.uwP = findViewById(2131305107);
    this.uwQ = (com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 190));
    setOnClickListener(this);
    AppMethodBeat.o(41890);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41891);
    if ((paramd == null) || (paramd.ulY == null) || (paramd.ulY.usd == null) || (bu.ht(paramd.ulY.usd.uqZ)))
    {
      setVisibility(8);
      AppMethodBeat.o(41891);
      return;
    }
    this.uwS = paramd;
    ag localag = (ag)paramd.ulY.usd.uqZ.get(paramd.ulZ);
    int i = paramd.ulZ + 1;
    if ((localag == null) || (localag.uqg == null)) {
      setVisibility(8);
    }
    for (;;)
    {
      if (!paramd.uma)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1022, paramd.ulZ + 1, localag.uqg.gvv, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(paramd.ulY.ura));
        paramd.uma = true;
      }
      AppMethodBeat.o(41891);
      return;
      this.uwR = localag;
      com.tencent.mm.plugin.game.model.c localc = x.a(this.uwR.uqg);
      localc.scene = 10;
      localc.dGL = 1022;
      localc.position = (this.uwS.ulZ + 1);
      this.uwO.setDownloadInfo(new l(localc));
      setVisibility(0);
      this.uwK.setText(String.valueOf(i));
      if (i == 1) {
        this.uwK.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#EED157"));
      }
      for (;;)
      {
        e.ddh().c(this.uwL, localag.uqg.gvv, com.tencent.mm.cb.a.getDensity(getContext()));
        this.uwM.setText(localag.uqg.Name);
        this.uwN.i(localag.uqg.uqF, this.uwQ);
        if ((bu.ht(localag.urM)) && (localag.urN == null) && (localag.Desc == null)) {
          break label438;
        }
        if ((this.uwP instanceof ViewStub)) {
          this.uwP = ((ViewStub)this.uwP).inflate();
        }
        ((GameFeedSocialInfoView)this.uwP.findViewById(2131300550)).setData(localag);
        break;
        if (i == 2) {
          this.uwK.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#BDC5CB"));
        } else if (i == 3) {
          this.uwK.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#D4B897"));
        } else {
          this.uwK.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#B2B2B2"));
        }
      }
      label438:
      this.uwP.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingItemView
 * JD-Core Version:    0.7.0.1
 */