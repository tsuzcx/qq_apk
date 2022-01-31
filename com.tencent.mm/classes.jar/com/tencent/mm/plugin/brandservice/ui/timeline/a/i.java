package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class i
  extends c
{
  public MMNeat7extView jXI;
  public ImageView jXx;
  public ImageView jXy;
  public TextView jYx;
  public ImageView jYy;
  
  public final void a(int paramInt1, com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(152637);
    super.a(paramInt1, paramq, paramq1, paramInt2, paramp);
    label64:
    label81:
    boolean bool;
    if (bo.isNullOrNil(paramq.title))
    {
      this.jXI.setVisibility(8);
      if (TextUtils.isEmpty(paramq.fjX)) {
        break label307;
      }
      this.jYx.setVisibility(0);
      this.jYx.setText(paramq.fjX);
      if (paramq.fjY != 2) {
        break label319;
      }
      this.jYy.setImageResource(2131231109);
      a(this.jXy, paramq1, 0, paramq.fjJ);
      a(this, paramq1, paramq);
      Object localObject = this.jXV;
      View localView = this.jXW;
      if (paramInt1 <= 1) {
        break label331;
      }
      bool = true;
      label123:
      ((a)localObject).a(paramq, paramq1, paramInt2, paramp, localView, bool, 0);
      if (!(paramq1.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.aZX())) {
        break label337;
      }
      this.jXy.setImageResource(2131231112);
      label179:
      this.jXG.setVisibility(8);
      paramp = this.jXV.jVJ;
      paramq = paramq.fjJ;
      localObject = this.jXx;
      int i = a.jVv;
      paramp.a(paramq, (ImageView)localObject, i, i, new i.1(this, paramq1, paramInt2));
      if (paramInt1 != 1) {
        break label349;
      }
      this.jXW.setBackgroundResource(2130838334);
    }
    for (;;)
    {
      paramq = this.jXW;
      if (paramInt1 <= 1) {
        break label361;
      }
      paramInt1 = a.jVx;
      paramInt2 = a.jVx;
      paramq.setPadding(paramInt1, paramInt1, paramInt2, paramInt2);
      AppMethodBeat.o(152637);
      return;
      this.jXI.setVisibility(0);
      this.jXI.af(paramq.title);
      break;
      label307:
      this.jYx.setVisibility(8);
      break label64;
      label319:
      this.jYy.setImageResource(2131231118);
      break label81;
      label331:
      bool = false;
      break label123;
      label337:
      this.jXy.setImageResource(2131231115);
      break label179;
      label349:
      this.jXW.setBackgroundResource(2130838335);
    }
    label361:
    paramInt1 = a.jVx;
    paramq.setPadding(paramInt1, paramInt1, a.jVx, a.jVw);
    AppMethodBeat.o(152637);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(14269);
    super.a(paramView, parama);
    if (this.jXr != null)
    {
      AppMethodBeat.o(14269);
      return;
    }
    parama = (ViewStub)paramView.findViewById(2131821883);
    if (parama == null)
    {
      AppMethodBeat.o(14269);
      return;
    }
    parama.inflate();
    this.jXr = paramView.findViewById(2131821913);
    this.jXW = paramView.findViewById(2131821914);
    aWY();
    this.jXx = ((ImageView)this.jXr.findViewById(2131821438));
    this.jXI = ((MMNeat7extView)this.jXr.findViewById(2131821212));
    this.jYx = ((TextView)this.jXr.findViewById(2131821915));
    this.jXy = ((ImageView)this.jXr.findViewById(2131821895));
    this.jYy = ((ImageView)this.jXr.findViewById(2131821916));
    this.jXG = ((ImageView)this.jXr.findViewById(2131821917));
    AppMethodBeat.o(14269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.i
 * JD-Core Version:    0.7.0.1
 */