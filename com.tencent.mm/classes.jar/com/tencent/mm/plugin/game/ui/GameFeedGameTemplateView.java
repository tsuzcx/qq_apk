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
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.d.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bu;

public class GameFeedGameTemplateView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView lHT;
  private GameTagListView uAf;
  private FrameLayout uAg;
  private GameRoundImageView uAh;
  private ImageView uAi;
  private GameFeedSubscriptView uAj;
  private GameDownloadView uAk;
  private int uwQ;
  private d uwS;
  private ImageView uyN;
  private TextView uyO;
  
  public GameFeedGameTemplateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void g(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42103);
    int i = getResources().getDimensionPixelSize(2131165434);
    int j = getResources().getDimensionPixelSize(2131165433);
    e.ddh().a(paramImageView, paramString, i, j, c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((this.uwS == null) || (this.uwS.ulY == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42102);
      return;
    }
    int i;
    if ((paramView.getId() == 2131306354) && (!bu.isNullOrNil(this.uwS.ulY.usb.usQ)))
    {
      i = c.aD(getContext(), this.uwS.ulY.usb.usQ);
      f.a(getContext(), 10, 1024, this.uwS.position, i, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ak(this.uwS.ulY.ura, "clickType", "middle"));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42102);
      return;
    }
    if (!bu.isNullOrNil(this.uwS.ulY.uqf))
    {
      i = c.aD(getContext(), this.uwS.ulY.uqf);
      f.a(getContext(), 10, 1024, this.uwS.position, i, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ak(this.uwS.ulY.ura, "clickType", "card"));
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
    this.uyN = ((ImageView)findViewById(2131300462));
    this.uyO = ((TextView)findViewById(2131300524));
    this.uAf = ((GameTagListView)findViewById(2131300553));
    this.lHT = ((TextView)findViewById(2131298996));
    this.uAg = ((FrameLayout)findViewById(2131306354));
    this.uAh = ((GameRoundImageView)findViewById(2131300914));
    this.uAi = ((ImageView)findViewById(2131306363));
    this.uAj = ((GameFeedSubscriptView)findViewById(2131305528));
    this.uAk = ((GameDownloadView)findViewById(2131300435));
    setOnClickListener(this);
    this.uwQ = (c.getScreenWidth(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 175));
    AppMethodBeat.o(42098);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42101);
    if ((paramd == null) || (paramd.ulY == null) || (paramd.ulY.usb == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42101);
      return;
    }
    this.uwS = paramd;
    paramd = paramd.ulY;
    setVisibility(0);
    e.ddh().c(this.uyN, paramd.usb.uqg.gvv, com.tencent.mm.cb.a.getDensity(getContext()));
    this.uyO.setText(paramd.usb.uqg.Name);
    this.uAf.i(paramd.usb.uqg.uqF, this.uwQ);
    if (!bu.isNullOrNil(paramd.usb.usP))
    {
      this.lHT.setText(paramd.usb.usP);
      this.lHT.setVisibility(0);
      this.uAg.setVisibility(0);
      if (bu.isNullOrNil(paramd.usb.usR)) {
        break label350;
      }
      g(this.uAh, paramd.usb.uqe);
      this.uAi.setVisibility(0);
    }
    for (;;)
    {
      this.uAg.setOnClickListener(this);
      this.uAj.setData(paramd);
      paramd = x.a(this.uwS.ulY.usb.uqg);
      paramd.scene = 10;
      paramd.dGL = 1024;
      paramd.position = this.uwS.position;
      this.uAk.setDownloadInfo(new l(paramd));
      if (!this.uwS.uma)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.uwS.position, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(this.uwS.ulY.ura));
        this.uwS.uma = true;
      }
      AppMethodBeat.o(42101);
      return;
      this.lHT.setVisibility(8);
      break;
      label350:
      if (!bu.isNullOrNil(paramd.usb.uqe))
      {
        g(this.uAh, paramd.usb.uqe);
        this.uAi.setVisibility(8);
      }
      else
      {
        this.uAg.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedGameTemplateView
 * JD-Core Version:    0.7.0.1
 */