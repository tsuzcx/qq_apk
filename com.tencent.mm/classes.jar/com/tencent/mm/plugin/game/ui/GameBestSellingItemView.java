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
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.f.e;
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
  AutoResizeTextView uln;
  ImageView ulo;
  TextView ulp;
  GameTagListView ulq;
  GameDownloadView ulr;
  View uls;
  private int ult;
  private ab ulu;
  private d ulv;
  
  public GameBestSellingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41892);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((this.ulu == null) || (bt.isNullOrNil(this.ulu.ueZ.ufb)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41892);
      return;
    }
    int i = com.tencent.mm.plugin.game.f.c.aB(getContext(), this.ulu.ueZ.ufb);
    com.tencent.mm.game.report.f.a(getContext(), 10, 1022, this.ulv.uaX + 1, i, this.ulu.ueZ.gsT, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(this.ulv.uaW.ufG));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41892);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41890);
    super.onFinishInflate();
    this.uln = ((AutoResizeTextView)findViewById(2131300534));
    this.ulo = ((ImageView)findViewById(2131300462));
    this.ulp = ((TextView)findViewById(2131300524));
    this.ulq = ((GameTagListView)findViewById(2131305629));
    this.ulr = ((GameDownloadView)findViewById(2131300354));
    this.uls = findViewById(2131305107);
    this.ult = (com.tencent.mm.plugin.game.f.c.getScreenWidth(getContext()) - com.tencent.mm.cc.a.fromDPToPix(getContext(), 190));
    setOnClickListener(this);
    AppMethodBeat.o(41890);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41891);
    if ((paramd == null) || (paramd.uaW == null) || (paramd.uaW.ugG == null) || (bt.hj(paramd.uaW.ugG.ufF)))
    {
      setVisibility(8);
      AppMethodBeat.o(41891);
      return;
    }
    this.ulv = paramd;
    ab localab = (ab)paramd.uaW.ugG.ufF.get(paramd.uaX);
    int i = paramd.uaX + 1;
    if ((localab == null) || (localab.ueZ == null)) {
      setVisibility(8);
    }
    for (;;)
    {
      if (!paramd.uaY)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1022, paramd.uaX + 1, localab.ueZ.gsT, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(paramd.uaW.ufG));
        paramd.uaY = true;
      }
      AppMethodBeat.o(41891);
      return;
      this.ulu = localab;
      com.tencent.mm.plugin.game.model.c localc = x.a(this.ulu.ueZ);
      localc.scene = 10;
      localc.dFG = 1022;
      localc.position = (this.ulv.uaX + 1);
      this.ulr.setDownloadInfo(new l(localc));
      setVisibility(0);
      this.uln.setText(String.valueOf(i));
      if (i == 1) {
        this.uln.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#EED157"));
      }
      for (;;)
      {
        e.dav().c(this.ulo, localab.ueZ.gsT, com.tencent.mm.cc.a.getDensity(getContext()));
        this.ulp.setText(localab.ueZ.Name);
        this.ulq.h(localab.ueZ.ufv, this.ult);
        if ((bt.hj(localab.ugp)) && (localab.ugq == null) && (localab.Desc == null)) {
          break label438;
        }
        if ((this.uls instanceof ViewStub)) {
          this.uls = ((ViewStub)this.uls).inflate();
        }
        ((GameFeedSocialInfoView)this.uls.findViewById(2131300550)).setData(localab);
        break;
        if (i == 2) {
          this.uln.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#BDC5CB"));
        } else if (i == 3) {
          this.uln.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#D4B897"));
        } else {
          this.uln.setTextColor(com.tencent.mm.plugin.game.f.c.parseColor("#B2B2B2"));
        }
      }
      label438:
      this.uls.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingItemView
 * JD-Core Version:    0.7.0.1
 */