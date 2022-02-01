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
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends i
{
  private View wJh;
  private TextView wJi;
  private TextView wJj;
  private TextView wxs;
  
  public final void all(String paramString)
  {
    AppMethodBeat.i(113668);
    this.wJj.setText(paramString);
    AppMethodBeat.o(113668);
  }
  
  public final void doE()
  {
    AppMethodBeat.i(113667);
    this.wJh.setVisibility(8);
    AppMethodBeat.o(113667);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113665);
    this.wJh = findViewById(a.d.weM);
    this.wJi = ((TextView)findViewById(a.d.weN));
    this.wxs = ((TextView)findViewById(a.d.wle));
    this.wJj = ((TextView)findViewById(a.d.whx));
    this.wJi.setOnClickListener(this.wJs.dmo());
    this.wJh.setVisibility(8);
    AppMethodBeat.o(113665);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113666);
    b localb = this.wJs.dmk();
    Object localObject1 = this.wJs.dmn();
    this.wJh.setVisibility(0);
    if (!TextUtils.isEmpty(localb.djK().ZdU))
    {
      this.wJi.setVisibility(0);
      this.wJi.setText(localb.djK().ZdU);
      if ((localb.djp()) || ((localb.djo()) && (localb.djr()))) {
        this.wJi.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.white_text_color));
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = this.wJh.findViewById(a.d.whI);
      if (!this.wJs.dmp().dnN()) {
        break label543;
      }
      ((View)localObject2).setVisibility(0);
      this.wJj.setText(((MMActivity)localObject1).getString(a.g.wpZ));
      this.wJj.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.white_text_color));
      int i = ((MMActivity)localObject1).getResources().getDimensionPixelOffset(a.b.NormalPadding);
      localObject2 = (Button)this.wJh.findViewById(a.d.whv);
      ShapeDrawable localShapeDrawable1 = l.e((Context)localObject1, ((MMActivity)localObject1).getResources().getColor(a.a.white), i);
      ShapeDrawable localShapeDrawable2 = l.gx(((MMActivity)localObject1).getResources().getColor(a.a.white), i);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localShapeDrawable2);
      localStateListDrawable.addState(new int[0], localShapeDrawable1);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      i = l.alv(localb.djK().nRQ);
      int j = ((MMActivity)localObject1).getResources().getColor(a.a.white);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      ((Button)localObject2).setOnClickListener(this.wJs.dmo());
      localObject1 = this.wJh.findViewById(a.d.wkD);
      localObject2 = this.wJh.findViewById(a.d.wgI);
      if (localb.djK().Zei != 1) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      AppMethodBeat.o(113666);
      return;
      if ((localb.djo()) && (localb.djq()))
      {
        this.wJi.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.wdA));
        this.wJh.setBackgroundColor(((MMActivity)localObject1).getResources().getColor(a.a.white));
      }
      else
      {
        this.wJi.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.white_text_color));
        continue;
        this.wJi.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.d
 * JD-Core Version:    0.7.0.1
 */