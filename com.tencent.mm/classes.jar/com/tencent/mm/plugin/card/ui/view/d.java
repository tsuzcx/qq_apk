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
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends i
{
  private View kAW;
  private TextView kAX;
  private TextView kAY;
  private TextView kqV;
  
  public final void Ir(String paramString)
  {
    AppMethodBeat.i(88741);
    this.kAY.setText(paramString);
    AppMethodBeat.o(88741);
  }
  
  public final void bfq()
  {
    AppMethodBeat.i(88740);
    this.kAW.setVisibility(8);
    AppMethodBeat.o(88740);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(88738);
    this.kAW = findViewById(2131822093);
    this.kAX = ((TextView)findViewById(2131822094));
    this.kqV = ((TextView)findViewById(2131822098));
    this.kAY = ((TextView)findViewById(2131821986));
    this.kAX.setOnClickListener(this.kBh.bdz());
    this.kAW.setVisibility(8);
    AppMethodBeat.o(88738);
  }
  
  public final void update()
  {
    AppMethodBeat.i(88739);
    b localb = this.kBh.bdv();
    Object localObject1 = this.kBh.bdy();
    this.kAW.setVisibility(0);
    if (!TextUtils.isEmpty(localb.bbd().wGk))
    {
      this.kAX.setVisibility(0);
      this.kAX.setText(localb.bbd().wGk);
      if ((localb.baK()) || ((localb.baJ()) && (localb.baM()))) {
        this.kAX.setTextColor(((MMActivity)localObject1).getResources().getColor(2131690709));
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = this.kAW.findViewById(2131822095);
      if (!this.kBh.bdA().bfb()) {
        break label529;
      }
      ((View)localObject2).setVisibility(0);
      this.kAY.setText(((MMActivity)localObject1).getString(2131298038));
      this.kAY.setTextColor(((MMActivity)localObject1).getResources().getColor(2131690709));
      int i = ((MMActivity)localObject1).getResources().getDimensionPixelOffset(2131427808);
      localObject2 = (Button)this.kAW.findViewById(2131821987);
      ShapeDrawable localShapeDrawable1 = l.b((Context)localObject1, ((MMActivity)localObject1).getResources().getColor(2131690709), i);
      ShapeDrawable localShapeDrawable2 = l.dR(((MMActivity)localObject1).getResources().getColor(2131690709), i);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localShapeDrawable2);
      localStateListDrawable.addState(new int[0], localShapeDrawable1);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      i = l.IB(localb.bbd().color);
      int j = ((MMActivity)localObject1).getResources().getColor(2131690709);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      ((Button)localObject2).setOnClickListener(this.kBh.bdz());
      localObject1 = this.kAW.findViewById(2131822096);
      localObject2 = this.kAW.findViewById(2131822097);
      if (localb.bbd().wGy != 1) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      AppMethodBeat.o(88739);
      return;
      if ((localb.baJ()) && (localb.baL()))
      {
        this.kAX.setTextColor(((MMActivity)localObject1).getResources().getColor(2131689822));
        this.kAW.setBackgroundColor(((MMActivity)localObject1).getResources().getColor(2131689824));
      }
      else
      {
        this.kAX.setTextColor(((MMActivity)localObject1).getResources().getColor(2131690709));
        continue;
        this.kAX.setVisibility(8);
      }
    }
    ((View)localObject1).setVisibility(8);
    ((View)localObject2).setVisibility(8);
    AppMethodBeat.o(88739);
    return;
    label529:
    ((View)localObject2).setVisibility(8);
    AppMethodBeat.o(88739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.d
 * JD-Core Version:    0.7.0.1
 */