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
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.ca;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e.a;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class GameFeedImageTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private int kvn = 0;
  private d sfe;
  private GameRoundImageView siA;
  private GameRoundImageView siB;
  private GameRoundImageView siC;
  private TextView siD;
  private GameFeedSubscriptView siE;
  private int siF = 0;
  private int siG;
  private GameFeedTitleDescView sir;
  private GameRoundImageView siv;
  private LinearLayout siz;
  
  public GameFeedImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42107);
    if ((this.sfe == null) || (this.sfe.rVo == null))
    {
      AppMethodBeat.o(42107);
      return;
    }
    if (!bt.isNullOrNil(this.sfe.rVo.rZo))
    {
      int i = c.ax(getContext(), this.sfe.rVo.rZo);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.sfe.position, i, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ad(this.sfe.rVo.rZW, "clickType", "card"));
    }
    AppMethodBeat.o(42107);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42105);
    super.onFinishInflate();
    this.sir = ((GameFeedTitleDescView)findViewById(2131300441));
    this.siv = ((GameRoundImageView)findViewById(2131297217));
    this.siz = ((LinearLayout)findViewById(2131304854));
    this.siA = ((GameRoundImageView)findViewById(2131300110));
    this.siB = ((GameRoundImageView)findViewById(2131304460));
    this.siC = ((GameRoundImageView)findViewById(2131305770));
    this.siD = ((TextView)findViewById(2131302472));
    this.siE = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    this.kvn = (c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    this.siF = ((this.kvn - com.tencent.mm.cd.a.fromDPToPix(getContext(), 10) * 2) / 3);
    this.siG = com.tencent.mm.cd.a.fromDPToPix(getContext(), 105);
    if (this.siF < this.siG) {
      this.siG = this.siF;
    }
    ViewGroup.LayoutParams localLayoutParams = this.siA.getLayoutParams();
    localLayoutParams.width = this.siG;
    localLayoutParams.height = this.siG;
    this.siA.setLayoutParams(localLayoutParams);
    this.siB.setLayoutParams(localLayoutParams);
    this.siC.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(42105);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42106);
    if ((paramd == null) || (paramd.rVo == null) || (paramd.rVo.saL == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42106);
      return;
    }
    this.sfe = paramd;
    paramd = paramd.rVo;
    setVisibility(0);
    this.sir.b(paramd.saL.Title, paramd.saL.gKr, null);
    int i;
    if (!bt.gL(paramd.saL.scW))
    {
      i = paramd.saL.scW.size();
      if (i == 1)
      {
        this.siz.setVisibility(8);
        this.siv.setVisibility(0);
        com.tencent.mm.plugin.game.f.e.cEB().a(this.siv, (String)paramd.saL.scW.get(0), getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      }
    }
    for (;;)
    {
      this.siE.setData(paramd);
      if (!this.sfe.rVq)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.sfe.position, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.qh(this.sfe.rVo.rZW));
        this.sfe.rVq = true;
      }
      AppMethodBeat.o(42106);
      return;
      this.siv.setVisibility(8);
      this.siz.setVisibility(0);
      this.siD.setVisibility(8);
      Object localObject = new e.a.a();
      ((e.a.a)localObject).soD = true;
      localObject = ((e.a.a)localObject).cEC();
      com.tencent.mm.plugin.game.f.e.cEB().a(this.siA, (String)paramd.saL.scW.get(0), (e.a)localObject);
      com.tencent.mm.plugin.game.f.e.cEB().a(this.siB, (String)paramd.saL.scW.get(1), (e.a)localObject);
      if (i > 2)
      {
        com.tencent.mm.plugin.game.f.e.cEB().a(this.siC, (String)paramd.saL.scW.get(2), (e.a)localObject);
        this.siC.setVisibility(0);
        if (i > 3)
        {
          this.siD.setVisibility(0);
          this.siD.setText(String.format("共%d张", new Object[] { Integer.valueOf(i) }));
        }
      }
      else
      {
        this.siC.setVisibility(4);
        continue;
        this.siv.setVisibility(8);
        this.siz.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedImageTextView
 * JD-Core Version:    0.7.0.1
 */