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
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.bg;
import com.tencent.mm.plugin.game.protobuf.g;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedGameTemplateView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView jVn;
  private int xOQ;
  private d xOS;
  private ImageView xQM;
  private TextView xQN;
  private GameTagListView xSe;
  private FrameLayout xSf;
  private GameRoundImageView xSg;
  private ImageView xSh;
  private GameFeedSubscriptView xSi;
  private GameDownloadView xSj;
  
  public GameFeedGameTemplateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void j(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42103);
    int i = getResources().getDimensionPixelSize(2131165450);
    int j = getResources().getDimensionPixelSize(2131165449);
    e.dWR().a(paramImageView, paramString, i, j, c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
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
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((this.xOS == null) || (this.xOS.xEq == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42102);
      return;
    }
    int i;
    if ((paramView.getId() == 2131309780) && (!Util.isNullOrNil(this.xOS.xEq.xKt.xLj)))
    {
      i = c.aQ(getContext(), this.xOS.xEq.xKt.xLj);
      f.a(getContext(), 10, 1024, this.xOS.position, i, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "middle"));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedGameTemplateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42102);
      return;
    }
    if (!Util.isNullOrNil(this.xOS.xEq.xIy))
    {
      i = c.aQ(getContext(), this.xOS.xEq.xIy);
      f.a(getContext(), 10, 1024, this.xOS.position, i, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "card"));
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
    this.xQM = ((ImageView)findViewById(2131301985));
    this.xQN = ((TextView)findViewById(2131302051));
    this.xSe = ((GameTagListView)findViewById(2131302085));
    this.jVn = ((TextView)findViewById(2131299495));
    this.xSf = ((FrameLayout)findViewById(2131309780));
    this.xSg = ((GameRoundImageView)findViewById(2131302526));
    this.xSh = ((ImageView)findViewById(2131309792));
    this.xSi = ((GameFeedSubscriptView)findViewById(2131308745));
    this.xSj = ((GameDownloadView)findViewById(2131301958));
    setOnClickListener(this);
    this.xOQ = (c.getScreenWidth(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 175));
    AppMethodBeat.o(42098);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42101);
    if ((paramd == null) || (paramd.xEq == null) || (paramd.xEq.xKt == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42101);
      return;
    }
    this.xOS = paramd;
    paramd = paramd.xEq;
    setVisibility(0);
    e.dWR().c(this.xQM, paramd.xKt.xIz.hik, com.tencent.mm.cb.a.getDensity(getContext()));
    this.xQN.setText(paramd.xKt.xIz.Name);
    this.xSe.h(paramd.xKt.xIz.xIX, this.xOQ);
    if (!Util.isNullOrNil(paramd.xKt.xLi))
    {
      this.jVn.setText(paramd.xKt.xLi);
      this.jVn.setVisibility(0);
      this.xSf.setVisibility(0);
      if (Util.isNullOrNil(paramd.xKt.xLk)) {
        break label350;
      }
      j(this.xSg, paramd.xKt.xIx);
      this.xSh.setVisibility(0);
    }
    for (;;)
    {
      this.xSf.setOnClickListener(this);
      this.xSi.setData(paramd);
      paramd = x.a(this.xOS.xEq.xKt.xIz);
      paramd.scene = 10;
      paramd.dYu = 1024;
      paramd.position = this.xOS.position;
      this.xSj.setDownloadInfo(new l(paramd));
      if (!this.xOS.xEs)
      {
        com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
        this.xOS.xEs = true;
      }
      AppMethodBeat.o(42101);
      return;
      this.jVn.setVisibility(8);
      break;
      label350:
      if (!Util.isNullOrNil(paramd.xKt.xIx))
      {
        j(this.xSg, paramd.xKt.xIx);
        this.xSh.setVisibility(8);
      }
      else
      {
        this.xSf.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedGameTemplateView
 * JD-Core Version:    0.7.0.1
 */