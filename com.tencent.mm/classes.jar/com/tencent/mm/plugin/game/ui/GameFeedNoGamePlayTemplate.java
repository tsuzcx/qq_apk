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
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.dh;
import com.tencent.mm.plugin.game.d.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class GameFeedNoGamePlayTemplate
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView kEm;
  private GameRoundImageView uAh;
  private ImageView uAi;
  private GameFeedTitleDescView uAu;
  private FrameLayout uAv;
  private RelativeLayout uAw;
  private TextView uAx;
  GameDownloadView uwO;
  private d uwS;
  
  public GameFeedNoGamePlayTemplate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42122);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((this.uwS == null) || (this.uwS.ulY == null) || (this.uwS.ulY.usc == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42122);
      return;
    }
    int i;
    if ((paramView.getId() == 2131300951) && (!bu.isNullOrNil(this.uwS.ulY.usc.usR)))
    {
      i = c.aD(getContext(), this.uwS.ulY.usc.usR);
      f.a(getContext(), 10, 1024, this.uwS.position, i, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ak(this.uwS.ulY.ura, "clickType", "middle"));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42122);
      return;
    }
    if (!bu.isNullOrNil(this.uwS.ulY.uqf))
    {
      i = c.aD(getContext(), this.uwS.ulY.uqf);
      f.a(getContext(), 10, 1024, this.uwS.position, i, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ak(this.uwS.ulY.ura, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42122);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42120);
    super.onFinishInflate();
    this.uAu = ((GameFeedTitleDescView)findViewById(2131300441));
    this.uAv = ((FrameLayout)findViewById(2131300951));
    this.uAh = ((GameRoundImageView)findViewById(2131298822));
    this.uAi = ((ImageView)findViewById(2131306363));
    this.uAw = ((RelativeLayout)findViewById(2131300373));
    this.kEm = ((ImageView)findViewById(2131300462));
    this.uAx = ((TextView)findViewById(2131300524));
    this.uwO = ((GameDownloadView)findViewById(2131300435));
    setOnClickListener(this);
    this.uAv.setOnClickListener(this);
    AppMethodBeat.o(42120);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42121);
    ae.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
    if ((paramd == null) || (paramd.ulY == null) || (paramd.ulY.usc == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42121);
      return;
    }
    ae.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
    this.uwS = paramd;
    paramd = paramd.ulY;
    setVisibility(0);
    this.uAu.b(paramd.usc.Title, paramd.usc.Desc, paramd.usc.uuU);
    this.uAv.setVisibility(0);
    if (!bu.isNullOrNil(paramd.usc.uqe))
    {
      e.ddh().a(this.uAh, paramd.usc.uqe, getResources().getDimensionPixelSize(2131165434), getResources().getDimensionPixelSize(2131165433), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (!bu.isNullOrNil(paramd.usc.usR)) {
        this.uAi.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramd.usc.uqg != null)
      {
        this.uAw.setVisibility(0);
        e.ddh().c(this.kEm, paramd.usc.uqg.gvv, com.tencent.mm.cb.a.getDensity(getContext()));
        this.uAx.setText(paramd.usc.uqg.Name);
        paramd = x.a(paramd.usc.uqg);
        paramd.scene = 10;
        paramd.dGL = 1024;
        paramd.position = this.uwS.position;
        this.uwO.setDownloadInfo(new l(paramd));
      }
      if (!this.uwS.uma)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.uwS.position, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(this.uwS.ulY.ura));
        this.uwS.uma = true;
      }
      AppMethodBeat.o(42121);
      return;
      this.uAi.setVisibility(8);
      continue;
      this.uAv.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedNoGamePlayTemplate
 * JD-Core Version:    0.7.0.1
 */