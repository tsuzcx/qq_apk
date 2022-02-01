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
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.cq;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameFeedImageTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private d INr;
  private GameFeedTitleDescView IQE;
  private GameRoundImageView IQI;
  private LinearLayout IQM;
  private GameRoundImageView IQN;
  private GameRoundImageView IQO;
  private GameRoundImageView IQP;
  private TextView IQQ;
  private GameFeedSubscriptView IQR;
  private int IQS = 0;
  private int IQT;
  private int sJv = 0;
  
  public GameFeedImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42107);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((this.INr == null) || (this.INr.ICB == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42107);
      return;
    }
    if (!Util.isNullOrNil(this.INr.ICB.IGI))
    {
      int i = c.ba(getContext(), this.INr.ICB.IGI);
      g.a(getContext(), 10, 1024, this.INr.position, i, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.aw(this.INr.ICB.IHI, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42107);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42105);
    super.onFinishInflate();
    this.IQE = ((GameFeedTitleDescView)findViewById(h.e.HVp));
    this.IQI = ((GameRoundImageView)findViewById(h.e.HTA));
    this.IQM = ((LinearLayout)findViewById(h.e.HXO));
    this.IQN = ((GameRoundImageView)findViewById(h.e.HTR));
    this.IQO = ((GameRoundImageView)findViewById(h.e.HXG));
    this.IQP = ((GameRoundImageView)findViewById(h.e.HXY));
    this.IQQ = ((TextView)findViewById(h.e.HWW));
    this.IQR = ((GameFeedSubscriptView)findViewById(h.e.HXR));
    setOnClickListener(this);
    this.sJv = (c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    this.IQS = ((this.sJv - com.tencent.mm.cd.a.fromDPToPix(getContext(), 10) * 2) / 3);
    this.IQT = com.tencent.mm.cd.a.fromDPToPix(getContext(), 105);
    if (this.IQS < this.IQT) {
      this.IQT = this.IQS;
    }
    ViewGroup.LayoutParams localLayoutParams = this.IQN.getLayoutParams();
    localLayoutParams.width = this.IQT;
    localLayoutParams.height = this.IQT;
    this.IQN.setLayoutParams(localLayoutParams);
    this.IQO.setLayoutParams(localLayoutParams);
    this.IQP.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(42105);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42106);
    if ((paramd == null) || (paramd.ICB == null) || (paramd.ICB.IIG == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42106);
      return;
    }
    this.INr = paramd;
    paramd = paramd.ICB;
    setVisibility(0);
    this.IQE.a(paramd.IIG.hAP, paramd.IIG.nUB, null);
    int i;
    if (!Util.isNullOrNil(paramd.IIG.IKR))
    {
      i = paramd.IIG.IKR.size();
      if (i == 1)
      {
        this.IQM.setVisibility(8);
        this.IQI.setVisibility(0);
        e.fIb().a(this.IQI, (String)paramd.IIG.IKR.get(0), getResources().getDimensionPixelSize(h.c.HSZ), getResources().getDimensionPixelSize(h.c.HSY), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      }
    }
    for (;;)
    {
      this.IQR.setData(paramd);
      if (!this.INr.ICD)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.INr.position, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(this.INr.ICB.IHI));
        this.INr.ICD = true;
      }
      AppMethodBeat.o(42106);
      return;
      this.IQI.setVisibility(8);
      this.IQM.setVisibility(0);
      this.IQQ.setVisibility(8);
      Object localObject = new e.a.a();
      ((e.a.a)localObject).IYr = true;
      localObject = ((e.a.a)localObject).fIc();
      e.fIb().a(this.IQN, (String)paramd.IIG.IKR.get(0), (e.a)localObject);
      e.fIb().a(this.IQO, (String)paramd.IIG.IKR.get(1), (e.a)localObject);
      if (i > 2)
      {
        e.fIb().a(this.IQP, (String)paramd.IIG.IKR.get(2), (e.a)localObject);
        this.IQP.setVisibility(0);
        if (i > 3)
        {
          this.IQQ.setVisibility(0);
          this.IQQ.setText(String.format("共%d张", new Object[] { Integer.valueOf(i) }));
        }
      }
      else
      {
        this.IQP.setVisibility(4);
        continue;
        this.IQI.setVisibility(8);
        this.IQM.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedImageTextView
 * JD-Core Version:    0.7.0.1
 */