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
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bu;

public class GameBestSellingMore
  extends LinearLayout
  implements View.OnClickListener
{
  private d uwS;
  private TextView uwT;
  private ImageView uwU;
  
  public GameBestSellingMore(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41896);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((this.uwS == null) || (this.uwS.ulY == null) || (this.uwS.ulY.usd == null) || (bu.isNullOrNil(this.uwS.ulY.usd.usN)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41896);
      return;
    }
    int i = c.aD(getContext(), this.uwS.ulY.usd.usN);
    f.a(getContext(), 10, 1022, 999, i, null, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(this.uwS.ulY.ura));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41896);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41894);
    super.onFinishInflate();
    this.uwT = ((TextView)findViewById(2131302471));
    this.uwU = ((ImageView)findViewById(2131302470));
    setOnClickListener(this);
    AppMethodBeat.o(41894);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41895);
    this.uwS = paramd;
    if ((paramd == null) || (paramd.ulY == null) || (paramd.ulY.usd == null) || (bu.isNullOrNil(paramd.ulY.usd.usm)))
    {
      this.uwT.setVisibility(8);
      this.uwU.setVisibility(8);
      setPadding(0, 0, 0, 0);
      AppMethodBeat.o(41895);
      return;
    }
    setPadding(getResources().getDimensionPixelSize(2131165430), 0, getResources().getDimensionPixelSize(2131165430), getResources().getDimensionPixelSize(2131165430));
    this.uwT.setVisibility(0);
    this.uwU.setVisibility(0);
    this.uwT.setText(paramd.ulY.usd.usm);
    AppMethodBeat.o(41895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingMore
 * JD-Core Version:    0.7.0.1
 */