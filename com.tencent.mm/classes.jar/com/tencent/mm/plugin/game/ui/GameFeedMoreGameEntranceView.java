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
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.cu;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedMoreGameEntranceView
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView Wf;
  private d ulv;
  
  public GameFeedMoreGameEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42118);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedMoreGameEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((this.ulv == null) || (this.ulv.uaW == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMoreGameEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42118);
      return;
    }
    if (!bt.isNullOrNil(this.ulv.uaW.ueY))
    {
      int i = c.aB(getContext(), this.ulv.uaW.ueY);
      f.a(getContext(), 10, 1024, this.ulv.position, i, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.aj(this.ulv.uaW.ufG, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMoreGameEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42118);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42116);
    super.onFinishInflate();
    this.Wf = ((TextView)findViewById(2131302471));
    setOnClickListener(this);
    AppMethodBeat.o(42116);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42117);
    if ((paramd == null) || (paramd.uaW == null) || (paramd.uaW.ugI == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42117);
      return;
    }
    this.ulv = paramd;
    setVisibility(0);
    this.Wf.setText(paramd.uaW.ugI.Desc);
    if (!this.ulv.uaY)
    {
      com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.ulv.position, this.ulv.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(this.ulv.uaW.ufG));
      this.ulv.uaY = true;
    }
    AppMethodBeat.o(42117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMoreGameEntranceView
 * JD-Core Version:    0.7.0.1
 */