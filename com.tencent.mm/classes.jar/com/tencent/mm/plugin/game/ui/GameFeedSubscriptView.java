package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.e.e.a.a;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.s;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedSubscriptView
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView qyu;
  private TextView rMV;
  private ao xSA;
  private TextView xSF;
  private TextView xSG;
  private LinearLayout xSH;
  private TextView xSI;
  private TextView xSJ;
  
  public GameFeedSubscriptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void Ow(int paramInt)
  {
    AppMethodBeat.i(42134);
    if (paramInt == 1) {}
    for (String str = com.tencent.mm.plugin.game.d.a.as(this.xSA.xJt, "clickType", "leftCorner");; str = com.tencent.mm.plugin.game.d.a.as(this.xSA.xJt, "clickType", "rightCorner"))
    {
      f.a(getContext(), 10, 1024, this.xSA.xJv, 7, this.xSA.jfi, GameIndexListView.getSourceScene(), str);
      AppMethodBeat.o(42134);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42133);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.xSA == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42133);
      return;
    }
    if ((paramView.getId() == 2131303145) || (paramView.getId() == 2131303146) || (paramView.getId() == 2131297144)) {
      if ((this.xSA.xKz != null) && (!Util.isNullOrNil(this.xSA.xKz.xIy)))
      {
        c.aQ(getContext(), this.xSA.xKz.xIy);
        Ow(1);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42133);
      return;
      if ((paramView.getId() == 2131307110) && (this.xSA.xKA != null) && (!Util.isNullOrNil(this.xSA.xKA.xIy)))
      {
        c.aQ(getContext(), this.xSA.xKA.xIy);
        Ow(2);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42131);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494869, this, true);
    this.xSF = ((TextView)localView.findViewById(2131303145));
    this.xSG = ((TextView)localView.findViewById(2131303146));
    this.xSH = ((LinearLayout)localView.findViewById(2131297144));
    this.qyu = ((ImageView)localView.findViewById(2131297119));
    this.rMV = ((TextView)localView.findViewById(2131305431));
    this.xSI = ((TextView)localView.findViewById(2131309630));
    this.xSJ = ((TextView)localView.findViewById(2131307110));
    this.xSF.setOnClickListener(this);
    this.xSG.setOnClickListener(this);
    this.xSH.setOnClickListener(this);
    this.xSJ.setOnClickListener(this);
    AppMethodBeat.o(42131);
  }
  
  public void setData(ao paramao)
  {
    AppMethodBeat.i(42132);
    if ((paramao == null) || ((paramao.xKz == null) && (paramao.xKA == null)))
    {
      setVisibility(8);
      AppMethodBeat.o(42132);
      return;
    }
    this.xSA = paramao;
    setVisibility(0);
    this.xSF.setVisibility(8);
    this.xSG.setVisibility(8);
    this.xSH.setVisibility(8);
    if (paramao.xKz != null) {
      switch (paramao.xKz.xJF)
      {
      }
    }
    while (paramao.xKA != null)
    {
      this.xSJ.setText(paramao.xKA.Desc);
      this.xSJ.setVisibility(0);
      AppMethodBeat.o(42132);
      return;
      this.xSF.setVisibility(0);
      this.xSF.setText(paramao.xKz.Desc);
      continue;
      this.xSG.setVisibility(0);
      this.xSG.setText(paramao.xKz.Desc);
      continue;
      this.xSH.setVisibility(0);
      if (!Util.isNullOrNil(paramao.xKz.xJE))
      {
        e.a.a locala = new e.a.a();
        locala.iaT = true;
        e.dWR().a(this.qyu, paramao.xKz.xJE, locala.dWS());
        this.qyu.setVisibility(0);
      }
      this.rMV.setText(paramao.xKz.Name);
      this.xSI.setText(paramao.xKz.Desc);
    }
    this.xSJ.setVisibility(8);
    AppMethodBeat.o(42132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSubscriptView
 * JD-Core Version:    0.7.0.1
 */