package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bt;

public class GameBestSellingMore
  extends LinearLayout
  implements View.OnClickListener
{
  private d ulv;
  private TextView ulw;
  private ImageView ulx;
  
  public GameBestSellingMore(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41896);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((this.ulv == null) || (this.ulv.uaW == null) || (this.ulv.uaW.ugG == null) || (bt.isNullOrNil(this.ulv.uaW.ugG.uhp)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41896);
      return;
    }
    int i = c.aB(getContext(), this.ulv.uaW.ugG.uhp);
    f.a(getContext(), 10, 1022, 999, i, null, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(this.ulv.uaW.ufG));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41896);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41894);
    super.onFinishInflate();
    this.ulw = ((TextView)findViewById(2131302471));
    this.ulx = ((ImageView)findViewById(2131302470));
    setOnClickListener(this);
    AppMethodBeat.o(41894);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41895);
    this.ulv = paramd;
    if ((paramd == null) || (paramd.uaW == null) || (paramd.uaW.ugG == null) || (bt.isNullOrNil(paramd.uaW.ugG.ugP)))
    {
      this.ulw.setVisibility(8);
      this.ulx.setVisibility(8);
      setPadding(0, 0, 0, 0);
      AppMethodBeat.o(41895);
      return;
    }
    setPadding(getResources().getDimensionPixelSize(2131165430), 0, getResources().getDimensionPixelSize(2131165430), getResources().getDimensionPixelSize(2131165430));
    this.ulw.setVisibility(0);
    this.ulx.setVisibility(0);
    this.ulw.setText(paramd.uaW.ugG.ugP);
    AppMethodBeat.o(41895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingMore
 * JD-Core Version:    0.7.0.1
 */