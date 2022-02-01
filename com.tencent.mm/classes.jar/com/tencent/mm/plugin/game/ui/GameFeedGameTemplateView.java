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
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedGameTemplateView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView lDu;
  private int ult;
  private d ulv;
  private ImageView unr;
  private TextView uns;
  private GameTagListView uoJ;
  private FrameLayout uoK;
  private GameRoundImageView uoL;
  private ImageView uoM;
  private GameFeedSubscriptView uoN;
  private GameDownloadView uoO;
  
  public GameFeedGameTemplateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void g(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42103);
    int i = getResources().getDimensionPixelSize(2131165434);
    int j = getResources().getDimensionPixelSize(2131165433);
    e.dav().a(paramImageView, paramString, i, j, c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
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
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((this.ulv == null) || (this.ulv.uaW == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42102);
      return;
    }
    int i;
    if ((paramView.getId() == 2131306354) && (!bt.isNullOrNil(this.ulv.uaW.ugE.uhs)))
    {
      i = c.aB(getContext(), this.ulv.uaW.ugE.uhs);
      com.tencent.mm.game.report.f.a(getContext(), 10, 1024, this.ulv.position, i, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.aj(this.ulv.uaW.ufG, "clickType", "middle"));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42102);
      return;
    }
    if (!bt.isNullOrNil(this.ulv.uaW.ueY))
    {
      i = c.aB(getContext(), this.ulv.uaW.ueY);
      com.tencent.mm.game.report.f.a(getContext(), 10, 1024, this.ulv.position, i, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.aj(this.ulv.uaW.ufG, "clickType", "card"));
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
    this.unr = ((ImageView)findViewById(2131300462));
    this.uns = ((TextView)findViewById(2131300524));
    this.uoJ = ((GameTagListView)findViewById(2131300553));
    this.lDu = ((TextView)findViewById(2131298996));
    this.uoK = ((FrameLayout)findViewById(2131306354));
    this.uoL = ((GameRoundImageView)findViewById(2131300914));
    this.uoM = ((ImageView)findViewById(2131306363));
    this.uoN = ((GameFeedSubscriptView)findViewById(2131305528));
    this.uoO = ((GameDownloadView)findViewById(2131300435));
    setOnClickListener(this);
    this.ult = (c.getScreenWidth(getContext()) - com.tencent.mm.cc.a.fromDPToPix(getContext(), 175));
    AppMethodBeat.o(42098);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42101);
    if ((paramd == null) || (paramd.uaW == null) || (paramd.uaW.ugE == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42101);
      return;
    }
    this.ulv = paramd;
    paramd = paramd.uaW;
    setVisibility(0);
    e.dav().c(this.unr, paramd.ugE.ueZ.gsT, com.tencent.mm.cc.a.getDensity(getContext()));
    this.uns.setText(paramd.ugE.ueZ.Name);
    this.uoJ.h(paramd.ugE.ueZ.ufv, this.ult);
    if (!bt.isNullOrNil(paramd.ugE.uhr))
    {
      this.lDu.setText(paramd.ugE.uhr);
      this.lDu.setVisibility(0);
      this.uoK.setVisibility(0);
      if (bt.isNullOrNil(paramd.ugE.uht)) {
        break label350;
      }
      g(this.uoL, paramd.ugE.ueX);
      this.uoM.setVisibility(0);
    }
    for (;;)
    {
      this.uoK.setOnClickListener(this);
      this.uoN.setData(paramd);
      paramd = x.a(this.ulv.uaW.ugE.ueZ);
      paramd.scene = 10;
      paramd.dFG = 1024;
      paramd.position = this.ulv.position;
      this.uoO.setDownloadInfo(new l(paramd));
      if (!this.ulv.uaY)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.ulv.position, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(this.ulv.uaW.ufG));
        this.ulv.uaY = true;
      }
      AppMethodBeat.o(42101);
      return;
      this.lDu.setVisibility(8);
      break;
      label350:
      if (!bt.isNullOrNil(paramd.ugE.ueX))
      {
        g(this.uoL, paramd.ugE.ueX);
        this.uoM.setVisibility(8);
      }
      else
      {
        this.uoK.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedGameTemplateView
 * JD-Core Version:    0.7.0.1
 */