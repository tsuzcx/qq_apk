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
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.u;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedAddTopicView
  extends LinearLayout
  implements View.OnClickListener
{
  private d CTb;
  private GameFeedTitleDescView CWn;
  private TextView CWo;
  
  public GameFeedAddTopicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42096);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.CTb == null) || (this.CTb.CIr == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42096);
      return;
    }
    if (!Util.isNullOrNil(this.CTb.CIr.CMD))
    {
      int i = c.aY(getContext(), this.CTb.CIr.CMD);
      g.a(getContext(), 10, 1024, this.CTb.position, i, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.am(this.CTb.CIr.CNA, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42096);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42094);
    super.onFinishInflate();
    this.CWn = ((GameFeedTitleDescView)findViewById(g.e.Cjh));
    this.CWo = ((TextView)findViewById(g.e.Cho));
    setOnClickListener(this);
    AppMethodBeat.o(42094);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42095);
    if ((paramd == null) || (paramd.CIr == null) || (paramd.CIr.COD == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42095);
      return;
    }
    this.CTb = paramd;
    setVisibility(0);
    this.CWn.a(paramd.CIr.COD.fwr, paramd.CIr.COD.CMB, null);
    this.CWo.setText(paramd.CIr.COD.CNO);
    if (!this.CTb.CIt)
    {
      com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.CTb.position, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(this.CTb.CIr.CNA));
      this.CTb.CIt = true;
    }
    AppMethodBeat.o(42095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedAddTopicView
 * JD-Core Version:    0.7.0.1
 */