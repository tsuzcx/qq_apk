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
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bu;

public class GameFeedMoreGameEntranceView
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView Wf;
  private d uwS;
  
  public GameFeedMoreGameEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42118);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedMoreGameEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((this.uwS == null) || (this.uwS.ulY == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedMoreGameEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42118);
      return;
    }
    if (!bu.isNullOrNil(this.uwS.ulY.uqf))
    {
      int i = c.aD(getContext(), this.uwS.ulY.uqf);
      f.a(getContext(), 10, 1024, this.uwS.position, i, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ak(this.uwS.ulY.ura, "clickType", "card"));
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
    if ((paramd == null) || (paramd.ulY == null) || (paramd.ulY.usf == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42117);
      return;
    }
    this.uwS = paramd;
    setVisibility(0);
    this.Wf.setText(paramd.ulY.usf.Desc);
    if (!this.uwS.uma)
    {
      com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.uwS.position, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(this.uwS.ulY.ura));
      this.uwS.uma = true;
    }
    AppMethodBeat.o(42117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMoreGameEntranceView
 * JD-Core Version:    0.7.0.1
 */