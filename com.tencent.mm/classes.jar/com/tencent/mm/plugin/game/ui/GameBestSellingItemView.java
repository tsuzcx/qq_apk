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
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.protobuf.aj;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.bg;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameBestSellingItemView
  extends LinearLayout
  implements View.OnClickListener
{
  AutoResizeTextView INj;
  ImageView INk;
  TextView INl;
  GameTagListView INm;
  GameDownloadView INn;
  View INo;
  private int INp;
  private aj INq;
  private d INr;
  
  public GameBestSellingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41892);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((this.INq == null) || (Util.isNullOrNil(this.INq.IGJ.IGL)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41892);
      return;
    }
    int i = com.tencent.mm.plugin.game.d.c.ba(getContext(), this.INq.IGJ.IGL);
    com.tencent.mm.game.report.g.a(getContext(), 10, 1022, this.INr.ICC + 1, i, this.INq.IGJ.muA, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(this.INr.ICB.IHI));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41892);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41890);
    super.onFinishInflate();
    this.INj = ((AutoResizeTextView)findViewById(h.e.HWo));
    this.INk = ((ImageView)findViewById(h.e.HVB));
    this.INl = ((TextView)findViewById(h.e.HWm));
    this.INm = ((GameTagListView)findViewById(h.e.HXX));
    this.INn = ((GameDownloadView)findViewById(h.e.HUc));
    this.INo = findViewById(h.e.HXP);
    this.INp = (com.tencent.mm.plugin.game.d.c.getScreenWidth(getContext()) - com.tencent.mm.cd.a.fromDPToPix(getContext(), 190));
    setOnClickListener(this);
    AppMethodBeat.o(41890);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41891);
    if ((paramd == null) || (paramd.ICB == null) || (paramd.ICB.IIM == null) || (Util.isNullOrNil(paramd.ICB.IIM.IHH)))
    {
      setVisibility(8);
      AppMethodBeat.o(41891);
      return;
    }
    this.INr = paramd;
    aj localaj = (aj)paramd.ICB.IIM.IHH.get(paramd.ICC);
    int i = paramd.ICC + 1;
    if ((localaj == null) || (localaj.IGJ == null)) {
      setVisibility(8);
    }
    for (;;)
    {
      if (!paramd.ICD)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1022, paramd.ICC + 1, localaj.IGJ.muA, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(paramd.ICB.IHI));
        paramd.ICD = true;
      }
      AppMethodBeat.o(41891);
      return;
      this.INq = localaj;
      com.tencent.mm.plugin.game.model.c localc = x.a(this.INq.IGJ);
      localc.scene = 10;
      localc.hYi = 1022;
      localc.position = (this.INr.ICC + 1);
      this.INn.setDownloadInfo(new l(localc));
      setVisibility(0);
      this.INj.setText(String.valueOf(i));
      if (i == 1) {
        this.INj.setTextColor(com.tencent.mm.plugin.game.d.c.aHm("#EED157"));
      }
      for (;;)
      {
        e.fIb().c(this.INk, localaj.IGJ.muA, com.tencent.mm.cd.a.getDensity(getContext()));
        this.INl.setText(localaj.IGJ.IGU);
        this.INm.k(localaj.IGJ.IHi, this.INp);
        if ((Util.isNullOrNil(localaj.IIv)) && (localaj.IIw == null) && (localaj.IGG == null)) {
          break label438;
        }
        if ((this.INo instanceof ViewStub)) {
          this.INo = ((ViewStub)this.INo).inflate();
        }
        ((GameFeedSocialInfoView)this.INo.findViewById(h.e.HWz)).setData(localaj);
        break;
        if (i == 2) {
          this.INj.setTextColor(com.tencent.mm.plugin.game.d.c.aHm("#BDC5CB"));
        } else if (i == 3) {
          this.INj.setTextColor(com.tencent.mm.plugin.game.d.c.aHm("#D4B897"));
        } else {
          this.INj.setTextColor(com.tencent.mm.plugin.game.d.c.aHm("#B2B2B2"));
        }
      }
      label438:
      this.INo.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingItemView
 * JD-Core Version:    0.7.0.1
 */