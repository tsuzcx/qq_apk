package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends i
{
  private View tFI;
  private TextView tFJ;
  private TextView tFK;
  private TextView tsV;
  
  public final void arH(String paramString)
  {
    AppMethodBeat.i(113668);
    this.tFK.setText(paramString);
    AppMethodBeat.o(113668);
  }
  
  public final void cKY()
  {
    AppMethodBeat.i(113667);
    this.tFI.setVisibility(8);
    AppMethodBeat.o(113667);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113665);
    this.tFI = findViewById(a.d.taD);
    this.tFJ = ((TextView)findViewById(a.d.taE));
    this.tsV = ((TextView)findViewById(a.d.tgF));
    this.tFK = ((TextView)findViewById(a.d.tdj));
    this.tFJ.setOnClickListener(this.tFT.cIW());
    this.tFI.setVisibility(8);
    AppMethodBeat.o(113665);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113666);
    b localb = this.tFT.cIS();
    Object localObject1 = this.tFT.cIV();
    this.tFI.setVisibility(0);
    if (!TextUtils.isEmpty(localb.cGs().SfZ))
    {
      this.tFJ.setVisibility(0);
      this.tFJ.setText(localb.cGs().SfZ);
      if ((localb.cFX()) || ((localb.cFW()) && (localb.cFZ()))) {
        this.tFJ.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.white_text_color));
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = this.tFI.findViewById(a.d.tdu);
      if (!this.tFT.cIX().cKx()) {
        break label543;
      }
      ((View)localObject2).setVisibility(0);
      this.tFK.setText(((MMActivity)localObject1).getString(a.g.tlA));
      this.tFK.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.white_text_color));
      int i = ((MMActivity)localObject1).getResources().getDimensionPixelOffset(a.b.NormalPadding);
      localObject2 = (Button)this.tFI.findViewById(a.d.tdh);
      ShapeDrawable localShapeDrawable1 = l.e((Context)localObject1, ((MMActivity)localObject1).getResources().getColor(a.a.white), i);
      ShapeDrawable localShapeDrawable2 = l.fF(((MMActivity)localObject1).getResources().getColor(a.a.white), i);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localShapeDrawable2);
      localStateListDrawable.addState(new int[0], localShapeDrawable1);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      i = l.arR(localb.cGs().lmL);
      int j = ((MMActivity)localObject1).getResources().getColor(a.a.white);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      ((Button)localObject2).setOnClickListener(this.tFT.cIW());
      localObject1 = this.tFI.findViewById(a.d.tgh);
      localObject2 = this.tFI.findViewById(a.d.tcv);
      if (localb.cGs().Sgn != 1) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      AppMethodBeat.o(113666);
      return;
      if ((localb.cFW()) && (localb.cFY()))
      {
        this.tFJ.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.sZr));
        this.tFI.setBackgroundColor(((MMActivity)localObject1).getResources().getColor(a.a.white));
      }
      else
      {
        this.tFJ.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.white_text_color));
        continue;
        this.tFJ.setVisibility(8);
      }
    }
    ((View)localObject1).setVisibility(8);
    ((View)localObject2).setVisibility(8);
    AppMethodBeat.o(113666);
    return;
    label543:
    ((View)localObject2).setVisibility(8);
    AppMethodBeat.o(113666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.d
 * JD-Core Version:    0.7.0.1
 */