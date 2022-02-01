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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.bi;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedGameTemplateView
  extends LinearLayout
  implements View.OnClickListener
{
  private int INp;
  private d INr;
  private ImageView IPo;
  private TextView IPp;
  private GameTagListView IQG;
  private FrameLayout IQH;
  private GameRoundImageView IQI;
  private ImageView IQJ;
  private GameFeedSubscriptView IQK;
  private GameDownloadView IQL;
  private TextView pJi;
  
  public GameFeedGameTemplateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void f(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42103);
    int i = getResources().getDimensionPixelSize(h.c.HTc);
    int j = getResources().getDimensionPixelSize(h.c.HTb);
    e.fIb().a(paramImageView, paramString, i, j, c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    AppMethodBeat.o(42103);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(42100);
    super.onAttachedToWindow();
    AppMethodBeat.o(42100);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42102);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((this.INr == null) || (this.INr.ICB == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42102);
      return;
    }
    int i;
    if ((paramView.getId() == h.e.HYh) && (!Util.isNullOrNil(this.INr.ICB.IIK.IJB)))
    {
      i = c.ba(getContext(), this.INr.ICB.IIK.IJB);
      com.tencent.mm.game.report.g.a(getContext(), 10, 1024, this.INr.position, i, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.aw(this.INr.ICB.IHI, "clickType", "middle"));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42102);
      return;
    }
    if (!Util.isNullOrNil(this.INr.ICB.IGI))
    {
      i = c.ba(getContext(), this.INr.ICB.IGI);
      com.tencent.mm.game.report.g.a(getContext(), 10, 1024, this.INr.position, i, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.aw(this.INr.ICB.IHI, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42102);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(42099);
    super.onDetachedFromWindow();
    AppMethodBeat.o(42099);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42098);
    super.onFinishInflate();
    this.IPo = ((ImageView)findViewById(h.e.HVB));
    this.IPp = ((TextView)findViewById(h.e.HWm));
    this.IQG = ((GameTagListView)findViewById(h.e.HWE));
    this.pJi = ((TextView)findViewById(h.e.desc));
    this.IQH = ((FrameLayout)findViewById(h.e.HYh));
    this.IQI = ((GameRoundImageView)findViewById(h.e.image));
    this.IQJ = ((ImageView)findViewById(h.e.HYi));
    this.IQK = ((GameFeedSubscriptView)findViewById(h.e.HXR));
    this.IQL = ((GameDownloadView)findViewById(h.e.HVm));
    setOnClickListener(this);
    this.INp = (c.getScreenWidth(getContext()) - com.tencent.mm.cd.a.fromDPToPix(getContext(), 175));
    AppMethodBeat.o(42098);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42101);
    if ((paramd == null) || (paramd.ICB == null) || (paramd.ICB.IIK == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42101);
      return;
    }
    this.INr = paramd;
    paramd = paramd.ICB;
    setVisibility(0);
    e.fIb().c(this.IPo, paramd.IIK.IGJ.muA, com.tencent.mm.cd.a.getDensity(getContext()));
    this.IPp.setText(paramd.IIK.IGJ.IGU);
    this.IQG.k(paramd.IIK.IGJ.IHi, this.INp);
    if (!Util.isNullOrNil(paramd.IIK.IJA))
    {
      this.pJi.setText(paramd.IIK.IJA);
      this.pJi.setVisibility(0);
      this.IQH.setVisibility(0);
      if (Util.isNullOrNil(paramd.IIK.IJC)) {
        break label353;
      }
      f(this.IQI, paramd.IIK.IGH);
      this.IQJ.setVisibility(0);
    }
    for (;;)
    {
      this.IQH.setOnClickListener(this);
      this.IQK.setData(paramd);
      paramd = x.a(this.INr.ICB.IIK.IGJ);
      paramd.scene = 10;
      paramd.hYi = 1024;
      paramd.position = this.INr.position;
      this.IQL.setDownloadInfo(new l(paramd));
      if (!this.INr.ICD)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.INr.position, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(this.INr.ICB.IHI));
        this.INr.ICD = true;
      }
      AppMethodBeat.o(42101);
      return;
      this.pJi.setVisibility(8);
      break;
      label353:
      if (!Util.isNullOrNil(paramd.IIK.IGH))
      {
        f(this.IQI, paramd.IIK.IGH);
        this.IQJ.setVisibility(8);
      }
      else
      {
        this.IQH.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedGameTemplateView
 * JD-Core Version:    0.7.0.1
 */