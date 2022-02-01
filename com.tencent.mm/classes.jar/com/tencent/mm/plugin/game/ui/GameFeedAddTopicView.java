package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.v;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedAddTopicView
  extends LinearLayout
  implements View.OnClickListener
{
  private d INr;
  private GameFeedTitleDescView IQE;
  private TextView IQF;
  
  public GameFeedAddTopicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42096);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((this.INr == null) || (this.INr.ICB == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42096);
      return;
    }
    if (!Util.isNullOrNil(this.INr.ICB.IGI))
    {
      int i = c.ba(getContext(), this.INr.ICB.IGI);
      g.a(getContext(), 10, 1024, this.INr.position, i, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.aw(this.INr.ICB.IHI, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42096);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42094);
    super.onFinishInflate();
    this.IQE = ((GameFeedTitleDescView)findViewById(h.e.HVp));
    this.IQF = ((TextView)findViewById(h.e.HTx));
    setOnClickListener(this);
    AppMethodBeat.o(42094);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42095);
    if ((paramd == null) || (paramd.ICB == null) || (paramd.ICB.IIN == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42095);
      return;
    }
    this.INr = paramd;
    setVisibility(0);
    this.IQE.a(paramd.ICB.IIN.hAP, paramd.ICB.IIN.IGG, null);
    this.IQF.setText(paramd.ICB.IIN.IHY);
    if (!this.INr.ICD)
    {
      com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.INr.position, this.INr.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(this.INr.ICB.IHI));
      this.INr.ICD = true;
    }
    AppMethodBeat.o(42095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedAddTopicView
 * JD-Core Version:    0.7.0.1
 */