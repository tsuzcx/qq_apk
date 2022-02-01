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
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.co;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameFeedImageTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private d CTb;
  private GameFeedSubscriptView CWA;
  private int CWB = 0;
  private int CWC;
  private GameFeedTitleDescView CWn;
  private GameRoundImageView CWr;
  private LinearLayout CWv;
  private GameRoundImageView CWw;
  private GameRoundImageView CWx;
  private GameRoundImageView CWy;
  private TextView CWz;
  private int pEj = 0;
  
  public GameFeedImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42107);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.CTb == null) || (this.CTb.CIr == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42107);
      return;
    }
    if (!Util.isNullOrNil(this.CTb.CIr.CMD))
    {
      int i = c.aY(getContext(), this.CTb.CIr.CMD);
      g.a(getContext(), 10, 1024, this.CTb.position, i, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.am(this.CTb.CIr.CNA, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42107);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42105);
    super.onFinishInflate();
    this.CWn = ((GameFeedTitleDescView)findViewById(g.e.Cjh));
    this.CWr = ((GameRoundImageView)findViewById(g.e.Chr));
    this.CWv = ((LinearLayout)findViewById(g.e.ClG));
    this.CWw = ((GameRoundImageView)findViewById(g.e.ChJ));
    this.CWx = ((GameRoundImageView)findViewById(g.e.Cly));
    this.CWy = ((GameRoundImageView)findViewById(g.e.ClQ));
    this.CWz = ((TextView)findViewById(g.e.CkO));
    this.CWA = ((GameFeedSubscriptView)findViewById(g.e.ClJ));
    setOnClickListener(this);
    this.pEj = (c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    this.CWB = ((this.pEj - com.tencent.mm.ci.a.fromDPToPix(getContext(), 10) * 2) / 3);
    this.CWC = com.tencent.mm.ci.a.fromDPToPix(getContext(), 105);
    if (this.CWB < this.CWC) {
      this.CWC = this.CWB;
    }
    ViewGroup.LayoutParams localLayoutParams = this.CWw.getLayoutParams();
    localLayoutParams.width = this.CWC;
    localLayoutParams.height = this.CWC;
    this.CWw.setLayoutParams(localLayoutParams);
    this.CWx.setLayoutParams(localLayoutParams);
    this.CWy.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(42105);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42106);
    if ((paramd == null) || (paramd.CIr == null) || (paramd.CIr.COw == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42106);
      return;
    }
    this.CTb = paramd;
    paramd = paramd.CIr;
    setVisibility(0);
    this.CWn.a(paramd.COw.fwr, paramd.COw.lpy, null);
    int i;
    if (!Util.isNullOrNil(paramd.COw.CQF))
    {
      i = paramd.COw.CQF.size();
      if (i == 1)
      {
        this.CWv.setVisibility(8);
        this.CWr.setVisibility(0);
        e.eAa().a(this.CWr, (String)paramd.COw.CQF.get(0), getResources().getDimensionPixelSize(g.c.CgQ), getResources().getDimensionPixelSize(g.c.CgP), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      }
    }
    for (;;)
    {
      this.CWA.setData(paramd);
      if (!this.CTb.CIt)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.CTb.position, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(this.CTb.CIr.CNA));
        this.CTb.CIt = true;
      }
      AppMethodBeat.o(42106);
      return;
      this.CWr.setVisibility(8);
      this.CWv.setVisibility(0);
      this.CWz.setVisibility(8);
      Object localObject = new e.a.a();
      ((e.a.a)localObject).Dea = true;
      localObject = ((e.a.a)localObject).eAb();
      e.eAa().a(this.CWw, (String)paramd.COw.CQF.get(0), (e.a)localObject);
      e.eAa().a(this.CWx, (String)paramd.COw.CQF.get(1), (e.a)localObject);
      if (i > 2)
      {
        e.eAa().a(this.CWy, (String)paramd.COw.CQF.get(2), (e.a)localObject);
        this.CWy.setVisibility(0);
        if (i > 3)
        {
          this.CWz.setVisibility(0);
          this.CWz.setText(String.format("共%d张", new Object[] { Integer.valueOf(i) }));
        }
      }
      else
      {
        this.CWy.setVisibility(4);
        continue;
        this.CWr.setVisibility(8);
        this.CWv.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedImageTextView
 * JD-Core Version:    0.7.0.1
 */