package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.dc;
import com.tencent.mm.plugin.game.protobuf.eq;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedVideoView
  extends LinearLayout
  implements View.OnClickListener
{
  private d INr;
  private GameFeedTitleDescView IQE;
  private FrameLayout IQH;
  private GameFeedSubscriptView IQR;
  private GameRoundImageView IRn;
  private LinearLayout IRo;
  private ImageView IRp;
  private TextView IRq;
  
  public GameFeedVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42143);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.INr == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42143);
      return;
    }
    if (!Util.isNullOrNil(this.INr.ICB.IGI))
    {
      int i = c.ba(getContext(), this.INr.ICB.IGI);
      g.a(getContext(), 10, 1024, this.INr.position, i, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.aw(this.INr.ICB.IHI, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42143);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42140);
    super.onFinishInflate();
    this.IQE = ((GameFeedTitleDescView)findViewById(h.e.HVp));
    this.IQH = ((FrameLayout)findViewById(h.e.HYh));
    this.IRn = ((GameRoundImageView)findViewById(h.e.HYd));
    this.IRo = ((LinearLayout)findViewById(h.e.video_desc));
    this.IRp = ((ImageView)findViewById(h.e.HYj));
    this.IRq = ((TextView)findViewById(h.e.HYf));
    this.IQR = ((GameFeedSubscriptView)findViewById(h.e.HXR));
    setOnClickListener(this);
    AppMethodBeat.o(42140);
  }
  
  public void setLiveData(d paramd)
  {
    AppMethodBeat.i(42142);
    if ((paramd == null) || (paramd.ICB == null) || (paramd.ICB.III == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42142);
      return;
    }
    this.INr = paramd;
    paramd = paramd.ICB;
    setVisibility(0);
    this.IQE.a(paramd.III.hAP, paramd.III.IGG, null);
    if (!Util.isNullOrNil(paramd.III.IGH))
    {
      this.IQH.setVisibility(0);
      e.fIb().a(this.IRn, paramd.III.IGH, getResources().getDimensionPixelSize(h.c.HSZ), getResources().getDimensionPixelSize(h.c.HSY), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (Util.isNullOrNil(paramd.III.ILg)) {
        break label282;
      }
      this.IRo.setVisibility(0);
      this.IRp.setVisibility(0);
      this.IRq.setText(paramd.III.ILg);
    }
    for (;;)
    {
      this.IQR.setData(paramd);
      if (!this.INr.ICD)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.INr.position, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(this.INr.ICB.IHI));
        this.INr.ICD = true;
      }
      AppMethodBeat.o(42142);
      return;
      this.IQH.setVisibility(8);
      break;
      label282:
      this.IRo.setVisibility(8);
    }
  }
  
  public void setVideoData(d paramd)
  {
    AppMethodBeat.i(42141);
    if ((paramd == null) || (paramd.ICB == null) || (paramd.ICB.IIH == null) || (Util.isNullOrNil(paramd.ICB.IIH.IGH)))
    {
      setVisibility(8);
      AppMethodBeat.o(42141);
      return;
    }
    this.INr = paramd;
    paramd = paramd.ICB;
    setVisibility(0);
    this.IQE.a(paramd.IIH.hAP, paramd.IIH.IGG, null);
    e.fIb().a(this.IRn, paramd.IIH.IGH, getResources().getDimensionPixelSize(h.c.HSZ), getResources().getDimensionPixelSize(h.c.HSY), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    if (!Util.isNullOrNil(paramd.IIH.IMi))
    {
      this.IRo.setVisibility(0);
      this.IRp.setVisibility(8);
      this.IRq.setText(paramd.IIH.IMi);
    }
    for (;;)
    {
      this.IQR.setData(paramd);
      AppMethodBeat.o(42141);
      return;
      this.IRo.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedVideoView
 * JD-Core Version:    0.7.0.1
 */