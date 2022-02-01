package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.dd;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedMatchView
  extends LinearLayout
  implements View.OnClickListener
{
  private d INr;
  private GameFeedTitleDescView IQE;
  private GameFeedSubscriptView IQR;
  private GameRoundImageView IQU;
  
  public GameFeedMatchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42111);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((this.INr == null) || (this.INr.ICB == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42111);
      return;
    }
    if (!Util.isNullOrNil(this.INr.ICB.IGI))
    {
      int i = c.ba(getContext(), this.INr.ICB.IGI);
      g.a(getContext(), 10, 1024, this.INr.position, i, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.aw(this.INr.ICB.IHI, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMatchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42111);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42109);
    super.onFinishInflate();
    this.IQE = ((GameFeedTitleDescView)findViewById(h.e.HVp));
    this.IQU = ((GameRoundImageView)findViewById(h.e.HTA));
    this.IQR = ((GameFeedSubscriptView)findViewById(h.e.HXR));
    setOnClickListener(this);
    AppMethodBeat.o(42109);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42110);
    if ((paramd == null) || (paramd.ICB == null) || (paramd.ICB.IIJ == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42110);
      return;
    }
    this.INr = paramd;
    paramd = paramd.ICB;
    setVisibility(0);
    this.IQE.a(paramd.IIJ.hAP, paramd.IIJ.IGG, null);
    if (!Util.isNullOrNil(paramd.IIJ.IGH))
    {
      this.IQU.setVisibility(0);
      e.fIb().a(this.IQU, paramd.IIJ.IGH, getResources().getDimensionPixelSize(h.c.HTc), getResources().getDimensionPixelSize(h.c.HTb), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    }
    for (;;)
    {
      this.IQR.setData(paramd);
      if (!this.INr.ICD)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.INr.position, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(this.INr.ICB.IHI));
        this.INr.ICD = true;
      }
      AppMethodBeat.o(42110);
      return;
      setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMatchView
 * JD-Core Version:    0.7.0.1
 */