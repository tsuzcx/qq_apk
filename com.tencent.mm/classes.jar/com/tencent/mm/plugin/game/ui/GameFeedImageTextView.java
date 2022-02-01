package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.cg;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class GameFeedImageTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private int ltA = 0;
  private d ulv;
  private GameFeedTitleDescView uoH;
  private GameRoundImageView uoL;
  private LinearLayout uoP;
  private GameRoundImageView uoQ;
  private GameRoundImageView uoR;
  private GameRoundImageView uoS;
  private TextView uoT;
  private GameFeedSubscriptView uoU;
  private int uoV = 0;
  private int uoW;
  
  public GameFeedImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42107);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((this.ulv == null) || (this.ulv.uaW == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42107);
      return;
    }
    if (!bt.isNullOrNil(this.ulv.uaW.ueY))
    {
      int i = c.aB(getContext(), this.ulv.uaW.ueY);
      f.a(getContext(), 10, 1024, this.ulv.position, i, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.aj(this.ulv.uaW.ufG, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42107);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42105);
    super.onFinishInflate();
    this.uoH = ((GameFeedTitleDescView)findViewById(2131300441));
    this.uoL = ((GameRoundImageView)findViewById(2131297217));
    this.uoP = ((LinearLayout)findViewById(2131304854));
    this.uoQ = ((GameRoundImageView)findViewById(2131300110));
    this.uoR = ((GameRoundImageView)findViewById(2131304460));
    this.uoS = ((GameRoundImageView)findViewById(2131305770));
    this.uoT = ((TextView)findViewById(2131302472));
    this.uoU = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    this.ltA = (c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    this.uoV = ((this.ltA - com.tencent.mm.cc.a.fromDPToPix(getContext(), 10) * 2) / 3);
    this.uoW = com.tencent.mm.cc.a.fromDPToPix(getContext(), 105);
    if (this.uoV < this.uoW) {
      this.uoW = this.uoV;
    }
    ViewGroup.LayoutParams localLayoutParams = this.uoQ.getLayoutParams();
    localLayoutParams.width = this.uoW;
    localLayoutParams.height = this.uoW;
    this.uoQ.setLayoutParams(localLayoutParams);
    this.uoR.setLayoutParams(localLayoutParams);
    this.uoS.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(42105);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42106);
    if ((paramd == null) || (paramd.uaW == null) || (paramd.uaW.ugA == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42106);
      return;
    }
    this.ulv = paramd;
    paramd = paramd.uaW;
    setVisibility(0);
    this.uoH.b(paramd.ugA.Title, paramd.ugA.hDa, null);
    int i;
    if (!bt.hj(paramd.ugA.uiX))
    {
      i = paramd.ugA.uiX.size();
      if (i == 1)
      {
        this.uoP.setVisibility(8);
        this.uoL.setVisibility(0);
        e.dav().a(this.uoL, (String)paramd.ugA.uiX.get(0), getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      }
    }
    for (;;)
    {
      this.uoU.setData(paramd);
      if (!this.ulv.uaY)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.ulv.position, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(this.ulv.uaW.ufG));
        this.ulv.uaY = true;
      }
      AppMethodBeat.o(42106);
      return;
      this.uoL.setVisibility(8);
      this.uoP.setVisibility(0);
      this.uoT.setVisibility(8);
      Object localObject = new e.a.a();
      ((e.a.a)localObject).uvI = true;
      localObject = ((e.a.a)localObject).daw();
      e.dav().a(this.uoQ, (String)paramd.ugA.uiX.get(0), (e.a)localObject);
      e.dav().a(this.uoR, (String)paramd.ugA.uiX.get(1), (e.a)localObject);
      if (i > 2)
      {
        e.dav().a(this.uoS, (String)paramd.ugA.uiX.get(2), (e.a)localObject);
        this.uoS.setVisibility(0);
        if (i > 3)
        {
          this.uoT.setVisibility(0);
          this.uoT.setText(String.format("共%d张", new Object[] { Integer.valueOf(i) }));
        }
      }
      else
      {
        this.uoS.setVisibility(4);
        continue;
        this.uoL.setVisibility(8);
        this.uoP.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedImageTextView
 * JD-Core Version:    0.7.0.1
 */