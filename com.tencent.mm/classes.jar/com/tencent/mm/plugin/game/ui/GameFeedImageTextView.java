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
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.e.e.a;
import com.tencent.mm.plugin.game.e.e.a.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.cn;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameFeedImageTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private int mEX = 0;
  private d xOS;
  private GameFeedTitleDescView xSc;
  private GameRoundImageView xSg;
  private LinearLayout xSk;
  private GameRoundImageView xSl;
  private GameRoundImageView xSm;
  private GameRoundImageView xSn;
  private TextView xSo;
  private GameFeedSubscriptView xSp;
  private int xSq = 0;
  private int xSr;
  
  public GameFeedImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42107);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((this.xOS == null) || (this.xOS.xEq == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42107);
      return;
    }
    if (!Util.isNullOrNil(this.xOS.xEq.xIy))
    {
      int i = c.aQ(getContext(), this.xOS.xEq.xIy);
      f.a(getContext(), 10, 1024, this.xOS.position, i, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42107);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42105);
    super.onFinishInflate();
    this.xSc = ((GameFeedTitleDescView)findViewById(2131301964));
    this.xSg = ((GameRoundImageView)findViewById(2131297372));
    this.xSk = ((LinearLayout)findViewById(2131307940));
    this.xSl = ((GameRoundImageView)findViewById(2131301550));
    this.xSm = ((GameRoundImageView)findViewById(2131307436));
    this.xSn = ((GameRoundImageView)findViewById(2131309044));
    this.xSo = ((TextView)findViewById(2131304882));
    this.xSp = ((GameFeedSubscriptView)findViewById(2131308745));
    setOnClickListener(this);
    this.mEX = (c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    this.xSq = ((this.mEX - com.tencent.mm.cb.a.fromDPToPix(getContext(), 10) * 2) / 3);
    this.xSr = com.tencent.mm.cb.a.fromDPToPix(getContext(), 105);
    if (this.xSq < this.xSr) {
      this.xSr = this.xSq;
    }
    ViewGroup.LayoutParams localLayoutParams = this.xSl.getLayoutParams();
    localLayoutParams.width = this.xSr;
    localLayoutParams.height = this.xSr;
    this.xSl.setLayoutParams(localLayoutParams);
    this.xSm.setLayoutParams(localLayoutParams);
    this.xSn.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(42105);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42106);
    if ((paramd == null) || (paramd.xEq == null) || (paramd.xEq.xKp == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42106);
      return;
    }
    this.xOS = paramd;
    paramd = paramd.xEq;
    setVisibility(0);
    this.xSc.b(paramd.xKp.Title, paramd.xKp.iAc, null);
    int i;
    if (!Util.isNullOrNil(paramd.xKp.xMw))
    {
      i = paramd.xKp.xMw.size();
      if (i == 1)
      {
        this.xSk.setVisibility(8);
        this.xSg.setVisibility(0);
        e.dWR().a(this.xSg, (String)paramd.xKp.xMw.get(0), getResources().getDimensionPixelSize(2131165437), getResources().getDimensionPixelSize(2131165436), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      }
    }
    for (;;)
    {
      this.xSp.setData(paramd);
      if (!this.xOS.xEs)
      {
        com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
        this.xOS.xEs = true;
      }
      AppMethodBeat.o(42106);
      return;
      this.xSg.setVisibility(8);
      this.xSk.setVisibility(0);
      this.xSo.setVisibility(8);
      Object localObject = new e.a.a();
      ((e.a.a)localObject).xZt = true;
      localObject = ((e.a.a)localObject).dWS();
      e.dWR().a(this.xSl, (String)paramd.xKp.xMw.get(0), (e.a)localObject);
      e.dWR().a(this.xSm, (String)paramd.xKp.xMw.get(1), (e.a)localObject);
      if (i > 2)
      {
        e.dWR().a(this.xSn, (String)paramd.xKp.xMw.get(2), (e.a)localObject);
        this.xSn.setVisibility(0);
        if (i > 3)
        {
          this.xSo.setVisibility(0);
          this.xSo.setText(String.format("共%d张", new Object[] { Integer.valueOf(i) }));
        }
      }
      else
      {
        this.xSn.setVisibility(4);
        continue;
        this.xSg.setVisibility(8);
        this.xSk.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedImageTextView
 * JD-Core Version:    0.7.0.1
 */