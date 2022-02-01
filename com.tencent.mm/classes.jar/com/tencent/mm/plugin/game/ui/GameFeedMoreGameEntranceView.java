package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.dc;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedMoreGameEntranceView
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView Ws;
  private d xOS;
  
  public GameFeedMoreGameEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42118);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedMoreGameEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((this.xOS == null) || (this.xOS.xEq == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMoreGameEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42118);
      return;
    }
    if (!Util.isNullOrNil(this.xOS.xEq.xIy))
    {
      int i = c.aQ(getContext(), this.xOS.xEq.xIy);
      f.a(getContext(), 10, 1024, this.xOS.position, i, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMoreGameEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42118);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42116);
    super.onFinishInflate();
    this.Ws = ((TextView)findViewById(2131304881));
    setOnClickListener(this);
    AppMethodBeat.o(42116);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42117);
    if ((paramd == null) || (paramd.xEq == null) || (paramd.xEq.xKx == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42117);
      return;
    }
    this.xOS = paramd;
    setVisibility(0);
    this.Ws.setText(paramd.xEq.xKx.Desc);
    if (!this.xOS.xEs)
    {
      com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
      this.xOS.xEs = true;
    }
    AppMethodBeat.o(42117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMoreGameEntranceView
 * JD-Core Version:    0.7.0.1
 */