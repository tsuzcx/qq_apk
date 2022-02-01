package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.t;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedAddTopicView
  extends LinearLayout
  implements View.OnClickListener
{
  private d xOS;
  private GameFeedTitleDescView xSc;
  private TextView xSd;
  
  public GameFeedAddTopicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42096);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((this.xOS == null) || (this.xOS.xEq == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42096);
      return;
    }
    if (!Util.isNullOrNil(this.xOS.xEq.xIy))
    {
      int i = c.aQ(getContext(), this.xOS.xEq.xIy);
      f.a(getContext(), 10, 1024, this.xOS.position, i, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedAddTopicView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42096);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42094);
    super.onFinishInflate();
    this.xSc = ((GameFeedTitleDescView)findViewById(2131301964));
    this.xSd = ((TextView)findViewById(2131296539));
    setOnClickListener(this);
    AppMethodBeat.o(42094);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42095);
    if ((paramd == null) || (paramd.xEq == null) || (paramd.xEq.xKw == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42095);
      return;
    }
    this.xOS = paramd;
    setVisibility(0);
    this.xSc.b(paramd.xEq.xKw.Title, paramd.xEq.xKw.Desc, null);
    this.xSd.setText(paramd.xEq.xKw.xJG);
    if (!this.xOS.xEs)
    {
      com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
      this.xOS.xEs = true;
    }
    AppMethodBeat.o(42095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedAddTopicView
 * JD-Core Version:    0.7.0.1
 */