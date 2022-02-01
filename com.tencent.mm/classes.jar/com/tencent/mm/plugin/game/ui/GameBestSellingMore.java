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
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.be;
import com.tencent.mm.sdk.platformtools.Util;

public class GameBestSellingMore
  extends LinearLayout
  implements View.OnClickListener
{
  private d xOS;
  private TextView xOT;
  private ImageView xOU;
  
  public GameBestSellingMore(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41896);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((this.xOS == null) || (this.xOS.xEq == null) || (this.xOS.xEq.xKv == null) || (Util.isNullOrNil(this.xOS.xEq.xKv.xLg)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41896);
      return;
    }
    int i = c.aQ(getContext(), this.xOS.xEq.xKv.xLg);
    f.a(getContext(), 10, 1022, 999, i, null, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41896);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41894);
    super.onFinishInflate();
    this.xOT = ((TextView)findViewById(2131304881));
    this.xOU = ((ImageView)findViewById(2131304880));
    setOnClickListener(this);
    AppMethodBeat.o(41894);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41895);
    this.xOS = paramd;
    if ((paramd == null) || (paramd.xEq == null) || (paramd.xEq.xKv == null) || (Util.isNullOrNil(paramd.xEq.xKv.xKE)))
    {
      this.xOT.setVisibility(8);
      this.xOU.setVisibility(8);
      setPadding(0, 0, 0, 0);
      AppMethodBeat.o(41895);
      return;
    }
    setPadding(getResources().getDimensionPixelSize(2131165442), 0, getResources().getDimensionPixelSize(2131165442), getResources().getDimensionPixelSize(2131165442));
    this.xOT.setVisibility(0);
    this.xOU.setVisibility(0);
    this.xOT.setText(paramd.xEq.xKv.xKE);
    AppMethodBeat.o(41895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingMore
 * JD-Core Version:    0.7.0.1
 */