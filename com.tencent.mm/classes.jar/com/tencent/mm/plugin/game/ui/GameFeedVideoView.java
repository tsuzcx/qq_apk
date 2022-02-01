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
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.cy;
import com.tencent.mm.plugin.game.protobuf.el;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedVideoView
  extends LinearLayout
  implements View.OnClickListener
{
  private d xOS;
  private GameRoundImageView xSL;
  private LinearLayout xSM;
  private ImageView xSN;
  private TextView xSO;
  private GameFeedTitleDescView xSc;
  private FrameLayout xSf;
  private GameFeedSubscriptView xSp;
  
  public GameFeedVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42143);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.xOS == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42143);
      return;
    }
    if (!Util.isNullOrNil(this.xOS.xEq.xIy))
    {
      int i = c.aQ(getContext(), this.xOS.xEq.xIy);
      f.a(getContext(), 10, 1024, this.xOS.position, i, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42143);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42140);
    super.onFinishInflate();
    this.xSc = ((GameFeedTitleDescView)findViewById(2131301964));
    this.xSf = ((FrameLayout)findViewById(2131309780));
    this.xSL = ((GameRoundImageView)findViewById(2131309741));
    this.xSM = ((LinearLayout)findViewById(2131309746));
    this.xSN = ((ImageView)findViewById(2131309819));
    this.xSO = ((TextView)findViewById(2131309747));
    this.xSp = ((GameFeedSubscriptView)findViewById(2131308745));
    setOnClickListener(this);
    AppMethodBeat.o(42140);
  }
  
  public void setLiveData(d paramd)
  {
    AppMethodBeat.i(42142);
    if ((paramd == null) || (paramd.xEq == null) || (paramd.xEq.xKr == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42142);
      return;
    }
    this.xOS = paramd;
    paramd = paramd.xEq;
    setVisibility(0);
    this.xSc.b(paramd.xKr.Title, paramd.xKr.Desc, null);
    if (!Util.isNullOrNil(paramd.xKr.xIx))
    {
      this.xSf.setVisibility(0);
      e.dWR().a(this.xSL, paramd.xKr.xIx, getResources().getDimensionPixelSize(2131165437), getResources().getDimensionPixelSize(2131165436), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (Util.isNullOrNil(paramd.xKr.xMJ)) {
        break label280;
      }
      this.xSM.setVisibility(0);
      this.xSN.setVisibility(0);
      this.xSO.setText(paramd.xKr.xMJ);
    }
    for (;;)
    {
      this.xSp.setData(paramd);
      if (!this.xOS.xEs)
      {
        com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
        this.xOS.xEs = true;
      }
      AppMethodBeat.o(42142);
      return;
      this.xSf.setVisibility(8);
      break;
      label280:
      this.xSM.setVisibility(8);
    }
  }
  
  public void setVideoData(d paramd)
  {
    AppMethodBeat.i(42141);
    if ((paramd == null) || (paramd.xEq == null) || (paramd.xEq.xKq == null) || (Util.isNullOrNil(paramd.xEq.xKq.xIx)))
    {
      setVisibility(8);
      AppMethodBeat.o(42141);
      return;
    }
    this.xOS = paramd;
    paramd = paramd.xEq;
    setVisibility(0);
    this.xSc.b(paramd.xKq.Title, paramd.xKq.Desc, null);
    e.dWR().a(this.xSL, paramd.xKq.xIx, getResources().getDimensionPixelSize(2131165437), getResources().getDimensionPixelSize(2131165436), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    if (!Util.isNullOrNil(paramd.xKq.xNI))
    {
      this.xSM.setVisibility(0);
      this.xSN.setVisibility(8);
      this.xSO.setText(paramd.xKq.xNI);
    }
    for (;;)
    {
      this.xSp.setData(paramd);
      AppMethodBeat.o(42141);
      return;
      this.xSM.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedVideoView
 * JD-Core Version:    0.7.0.1
 */