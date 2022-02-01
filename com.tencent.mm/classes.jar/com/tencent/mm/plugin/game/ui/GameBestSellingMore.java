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
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.bf;
import com.tencent.mm.sdk.platformtools.Util;

public class GameBestSellingMore
  extends LinearLayout
  implements View.OnClickListener
{
  private d CTb;
  private TextView CTc;
  private ImageView CTd;
  
  public GameBestSellingMore(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41896);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.CTb == null) || (this.CTb.CIr == null) || (this.CTb.CIr.COC == null) || (Util.isNullOrNil(this.CTb.CIr.COC.CPo)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41896);
      return;
    }
    int i = c.aY(getContext(), this.CTb.CIr.COC.CPo);
    g.a(getContext(), 10, 1022, 999, i, null, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(this.CTb.CIr.CNA));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingMore", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41896);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41894);
    super.onFinishInflate();
    this.CTc = ((TextView)findViewById(g.e.CkN));
    this.CTd = ((ImageView)findViewById(g.e.CkM));
    setOnClickListener(this);
    AppMethodBeat.o(41894);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41895);
    this.CTb = paramd;
    if ((paramd == null) || (paramd.CIr == null) || (paramd.CIr.COC == null) || (Util.isNullOrNil(paramd.CIr.COC.COL)))
    {
      this.CTc.setVisibility(8);
      this.CTd.setVisibility(8);
      setPadding(0, 0, 0, 0);
      AppMethodBeat.o(41895);
      return;
    }
    setPadding(getResources().getDimensionPixelSize(g.c.CgR), 0, getResources().getDimensionPixelSize(g.c.CgR), getResources().getDimensionPixelSize(g.c.CgR));
    this.CTc.setVisibility(0);
    this.CTd.setVisibility(0);
    this.CTc.setText(paramd.CIr.COC.COL);
    AppMethodBeat.o(41895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingMore
 * JD-Core Version:    0.7.0.1
 */