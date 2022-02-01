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
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends i
{
  private TextView pWY;
  private View qjM;
  private TextView qjN;
  private TextView qjO;
  
  public final void ajU(String paramString)
  {
    AppMethodBeat.i(113668);
    this.qjO.setText(paramString);
    AppMethodBeat.o(113668);
  }
  
  public final void cxw()
  {
    AppMethodBeat.i(113667);
    this.qjM.setVisibility(8);
    AppMethodBeat.o(113667);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113665);
    this.qjM = findViewById(2131296583);
    this.qjN = ((TextView)findViewById(2131296584));
    this.pWY = ((TextView)findViewById(2131307803));
    this.qjO = ((TextView)findViewById(2131298197));
    this.qjN.setOnClickListener(this.qjX.cvu());
    this.qjM.setVisibility(8);
    AppMethodBeat.o(113665);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113666);
    b localb = this.qjX.cvq();
    Object localObject1 = this.qjX.cvt();
    this.qjM.setVisibility(0);
    if (!TextUtils.isEmpty(localb.csQ().LeL))
    {
      this.qjN.setVisibility(0);
      this.qjN.setText(localb.csQ().LeL);
      if ((localb.csw()) || ((localb.csv()) && (localb.csy()))) {
        this.qjN.setTextColor(((MMActivity)localObject1).getResources().getColor(2131101427));
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = this.qjM.findViewById(2131298213);
      if (!this.qjX.cvv().cwU()) {
        break label529;
      }
      ((View)localObject2).setVisibility(0);
      this.qjO.setText(((MMActivity)localObject1).getString(2131757150));
      this.qjO.setTextColor(((MMActivity)localObject1).getResources().getColor(2131101427));
      int i = ((MMActivity)localObject1).getResources().getDimensionPixelOffset(2131165534);
      localObject2 = (Button)this.qjM.findViewById(2131298195);
      ShapeDrawable localShapeDrawable1 = l.e((Context)localObject1, ((MMActivity)localObject1).getResources().getColor(2131101424), i);
      ShapeDrawable localShapeDrawable2 = l.fi(((MMActivity)localObject1).getResources().getColor(2131101424), i);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localShapeDrawable2);
      localStateListDrawable.addState(new int[0], localShapeDrawable1);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      i = l.ake(localb.csQ().ixw);
      int j = ((MMActivity)localObject1).getResources().getColor(2131101424);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      ((Button)localObject2).setOnClickListener(this.qjX.cvu());
      localObject1 = this.qjM.findViewById(2131304667);
      localObject2 = this.qjM.findViewById(2131298138);
      if (localb.csQ().LeZ != 1) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      AppMethodBeat.o(113666);
      return;
      if ((localb.csv()) && (localb.csx()))
      {
        this.qjN.setTextColor(((MMActivity)localObject1).getResources().getColor(2131100113));
        this.qjM.setBackgroundColor(((MMActivity)localObject1).getResources().getColor(2131101424));
      }
      else
      {
        this.qjN.setTextColor(((MMActivity)localObject1).getResources().getColor(2131101427));
        continue;
        this.qjN.setVisibility(8);
      }
    }
    ((View)localObject1).setVisibility(8);
    ((View)localObject2).setVisibility(8);
    AppMethodBeat.o(113666);
    return;
    label529:
    ((View)localObject2).setVisibility(8);
    AppMethodBeat.o(113666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.d
 * JD-Core Version:    0.7.0.1
 */