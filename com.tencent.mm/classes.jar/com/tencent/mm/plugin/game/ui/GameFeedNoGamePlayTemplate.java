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
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.cz;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedNoGamePlayTemplate
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView kAX;
  GameDownloadView ulr;
  private d ulv;
  private GameRoundImageView uoL;
  private ImageView uoM;
  private GameFeedTitleDescView uoY;
  private FrameLayout uoZ;
  private RelativeLayout upa;
  private TextView upb;
  
  public GameFeedNoGamePlayTemplate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42122);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((this.ulv == null) || (this.ulv.uaW == null) || (this.ulv.uaW.ugF == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42122);
      return;
    }
    int i;
    if ((paramView.getId() == 2131300951) && (!bt.isNullOrNil(this.ulv.uaW.ugF.uht)))
    {
      i = c.aB(getContext(), this.ulv.uaW.ugF.uht);
      com.tencent.mm.game.report.f.a(getContext(), 10, 1024, this.ulv.position, i, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.aj(this.ulv.uaW.ufG, "clickType", "middle"));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42122);
      return;
    }
    if (!bt.isNullOrNil(this.ulv.uaW.ueY))
    {
      i = c.aB(getContext(), this.ulv.uaW.ueY);
      com.tencent.mm.game.report.f.a(getContext(), 10, 1024, this.ulv.position, i, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.aj(this.ulv.uaW.ufG, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42122);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42120);
    super.onFinishInflate();
    this.uoY = ((GameFeedTitleDescView)findViewById(2131300441));
    this.uoZ = ((FrameLayout)findViewById(2131300951));
    this.uoL = ((GameRoundImageView)findViewById(2131298822));
    this.uoM = ((ImageView)findViewById(2131306363));
    this.upa = ((RelativeLayout)findViewById(2131300373));
    this.kAX = ((ImageView)findViewById(2131300462));
    this.upb = ((TextView)findViewById(2131300524));
    this.ulr = ((GameDownloadView)findViewById(2131300435));
    setOnClickListener(this);
    this.uoZ.setOnClickListener(this);
    AppMethodBeat.o(42120);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42121);
    ad.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
    if ((paramd == null) || (paramd.uaW == null) || (paramd.uaW.ugF == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42121);
      return;
    }
    ad.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
    this.ulv = paramd;
    paramd = paramd.uaW;
    setVisibility(0);
    this.uoY.b(paramd.ugF.Title, paramd.ugF.Desc, paramd.ugF.ujw);
    this.uoZ.setVisibility(0);
    if (!bt.isNullOrNil(paramd.ugF.ueX))
    {
      e.dav().a(this.uoL, paramd.ugF.ueX, getResources().getDimensionPixelSize(2131165434), getResources().getDimensionPixelSize(2131165433), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (!bt.isNullOrNil(paramd.ugF.uht)) {
        this.uoM.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramd.ugF.ueZ != null)
      {
        this.upa.setVisibility(0);
        e.dav().c(this.kAX, paramd.ugF.ueZ.gsT, com.tencent.mm.cc.a.getDensity(getContext()));
        this.upb.setText(paramd.ugF.ueZ.Name);
        paramd = x.a(paramd.ugF.ueZ);
        paramd.scene = 10;
        paramd.dFG = 1024;
        paramd.position = this.ulv.position;
        this.ulr.setDownloadInfo(new l(paramd));
      }
      if (!this.ulv.uaY)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.ulv.position, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(this.ulv.uaW.ufG));
        this.ulv.uaY = true;
      }
      AppMethodBeat.o(42121);
      return;
      this.uoM.setVisibility(8);
      continue;
      this.uoZ.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedNoGamePlayTemplate
 * JD-Core Version:    0.7.0.1
 */