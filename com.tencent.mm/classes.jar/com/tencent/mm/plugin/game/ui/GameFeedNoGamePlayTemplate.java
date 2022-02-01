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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.dm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedNoGamePlayTemplate
  extends LinearLayout
  implements View.OnClickListener
{
  GameDownloadView INn;
  private d INr;
  private GameRoundImageView IQI;
  private ImageView IQJ;
  private GameFeedTitleDescView IQV;
  private FrameLayout IQW;
  private RelativeLayout IQX;
  private TextView IQY;
  private ImageView rIe;
  
  public GameFeedNoGamePlayTemplate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42122);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((this.INr == null) || (this.INr.ICB == null) || (this.INr.ICB.IIL == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42122);
      return;
    }
    int i;
    if ((paramView.getId() == h.e.HWK) && (!Util.isNullOrNil(this.INr.ICB.IIL.IJC)))
    {
      i = c.ba(getContext(), this.INr.ICB.IIL.IJC);
      com.tencent.mm.game.report.g.a(getContext(), 10, 1024, this.INr.position, i, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.aw(this.INr.ICB.IHI, "clickType", "middle"));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42122);
      return;
    }
    if (!Util.isNullOrNil(this.INr.ICB.IGI))
    {
      i = c.ba(getContext(), this.INr.ICB.IGI);
      com.tencent.mm.game.report.g.a(getContext(), 10, 1024, this.INr.position, i, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.aw(this.INr.ICB.IHI, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42122);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42120);
    super.onFinishInflate();
    this.IQV = ((GameFeedTitleDescView)findViewById(h.e.HVp));
    this.IQW = ((FrameLayout)findViewById(h.e.HWK));
    this.IQI = ((GameRoundImageView)findViewById(h.e.HTJ));
    this.IQJ = ((ImageView)findViewById(h.e.HYi));
    this.IQX = ((RelativeLayout)findViewById(h.e.HUj));
    this.rIe = ((ImageView)findViewById(h.e.HVB));
    this.IQY = ((TextView)findViewById(h.e.HWm));
    this.INn = ((GameDownloadView)findViewById(h.e.HVm));
    setOnClickListener(this);
    this.IQW.setOnClickListener(this);
    AppMethodBeat.o(42120);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42121);
    Log.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
    if ((paramd == null) || (paramd.ICB == null) || (paramd.ICB.IIL == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42121);
      return;
    }
    Log.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
    this.INr = paramd;
    paramd = paramd.ICB;
    setVisibility(0);
    this.IQV.a(paramd.IIL.hAP, paramd.IIL.IGG, paramd.IIL.ILu);
    this.IQW.setVisibility(0);
    if (!Util.isNullOrNil(paramd.IIL.IGH))
    {
      e.fIb().a(this.IQI, paramd.IIL.IGH, getResources().getDimensionPixelSize(h.c.HTc), getResources().getDimensionPixelSize(h.c.HTb), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (!Util.isNullOrNil(paramd.IIL.IJC)) {
        this.IQJ.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramd.IIL.IGJ != null)
      {
        this.IQX.setVisibility(0);
        e.fIb().c(this.rIe, paramd.IIL.IGJ.muA, com.tencent.mm.cd.a.getDensity(getContext()));
        this.IQY.setText(paramd.IIL.IGJ.IGU);
        paramd = x.a(paramd.IIL.IGJ);
        paramd.scene = 10;
        paramd.hYi = 1024;
        paramd.position = this.INr.position;
        this.INn.setDownloadInfo(new l(paramd));
      }
      if (!this.INr.ICD)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.INr.position, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(this.INr.ICB.IHI));
        this.INr.ICD = true;
      }
      AppMethodBeat.o(42121);
      return;
      this.IQJ.setVisibility(8);
      continue;
      this.IQW.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedNoGamePlayTemplate
 * JD-Core Version:    0.7.0.1
 */