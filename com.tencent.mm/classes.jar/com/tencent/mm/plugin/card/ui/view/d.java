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
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends i
{
  private TextView oCI;
  private View oOq;
  private TextView oOr;
  private TextView oOs;
  
  public final void YX(String paramString)
  {
    AppMethodBeat.i(113668);
    this.oOs.setText(paramString);
    AppMethodBeat.o(113668);
  }
  
  public final void bYr()
  {
    AppMethodBeat.i(113667);
    this.oOq.setVisibility(8);
    AppMethodBeat.o(113667);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113665);
    this.oOq = findViewById(2131296509);
    this.oOr = ((TextView)findViewById(2131296510));
    this.oCI = ((TextView)findViewById(2131304741));
    this.oOs = ((TextView)findViewById(2131297880));
    this.oOr.setOnClickListener(this.oOB.bWp());
    this.oOq.setVisibility(8);
    AppMethodBeat.o(113665);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113666);
    b localb = this.oOB.bWl();
    Object localObject1 = this.oOB.bWo();
    this.oOq.setVisibility(0);
    if (!TextUtils.isEmpty(localb.bTN().FRJ))
    {
      this.oOr.setVisibility(0);
      this.oOr.setText(localb.bTN().FRJ);
      if ((localb.bTt()) || ((localb.bTs()) && (localb.bTv()))) {
        this.oOr.setTextColor(((MMActivity)localObject1).getResources().getColor(2131101182));
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = this.oOq.findViewById(2131297895);
      if (!this.oOB.bWq().bXP()) {
        break label529;
      }
      ((View)localObject2).setVisibility(0);
      this.oOs.setText(((MMActivity)localObject1).getString(2131756980));
      this.oOs.setTextColor(((MMActivity)localObject1).getResources().getColor(2131101182));
      int i = ((MMActivity)localObject1).getResources().getDimensionPixelOffset(2131165516);
      localObject2 = (Button)this.oOq.findViewById(2131297878);
      ShapeDrawable localShapeDrawable1 = l.f((Context)localObject1, ((MMActivity)localObject1).getResources().getColor(2131101179), i);
      ShapeDrawable localShapeDrawable2 = l.eU(((MMActivity)localObject1).getResources().getColor(2131101179), i);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localShapeDrawable2);
      localStateListDrawable.addState(new int[0], localShapeDrawable1);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      i = l.Zh(localb.bTN().hAD);
      int j = ((MMActivity)localObject1).getResources().getColor(2131101179);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      ((Button)localObject2).setOnClickListener(this.oOB.bWp());
      localObject1 = this.oOq.findViewById(2131302274);
      localObject2 = this.oOq.findViewById(2131297822);
      if (localb.bTN().FRX != 1) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      AppMethodBeat.o(113666);
      return;
      if ((localb.bTs()) && (localb.bTu()))
      {
        this.oOr.setTextColor(((MMActivity)localObject1).getResources().getColor(2131100082));
        this.oOq.setBackgroundColor(((MMActivity)localObject1).getResources().getColor(2131101179));
      }
      else
      {
        this.oOr.setTextColor(((MMActivity)localObject1).getResources().getColor(2131101182));
        continue;
        this.oOr.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.d
 * JD-Core Version:    0.7.0.1
 */