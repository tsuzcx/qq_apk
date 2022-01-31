package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.af.p;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class o
  extends c
{
  public MMNeat7extView jXI;
  public ImageView jXy;
  public TextView jYR;
  public MMNeat7extView jYS;
  
  public final void a(int paramInt1, com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(152650);
    super.a(paramInt1, paramq, paramq1, paramInt2, paramp);
    this.mCount = paramInt1;
    this.jXN = true;
    label117:
    label253:
    boolean bool;
    if (bo.isNullOrNil(paramq.title))
    {
      this.jXI.af(this.mContext.getResources().getString(2131297708));
      if ((bo.isNullOrNil(paramq.fjL)) || (this.mCount != 1)) {
        break label392;
      }
      Object localObject = com.tencent.mm.plugin.brandservice.ui.b.c.Hv(paramq.fjL);
      this.jYS.setVisibility(0);
      this.jYS.setMaxLines(2);
      this.jYS.setEllipsize(TextUtils.TruncateAt.END);
      this.jYS.af((CharSequence)localObject);
      localObject = l.kq(paramq.fjN);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label404;
      }
      this.jYR.setVisibility(0);
      this.jYR.setText((CharSequence)localObject);
      label151:
      localObject = this.jXy.getDrawable();
      if (((localObject instanceof AnimationDrawable)) && (((AnimationDrawable)localObject).isRunning())) {
        ((AnimationDrawable)localObject).stop();
      }
      if (!(paramq1.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.aZX())) {
        break label416;
      }
      this.jXy.setImageResource(2130837975);
      if ((this.jXy.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)this.jXy.getDrawable()).start();
      }
      a(this.jXy, paramq1, 0, paramq.fjJ);
      a(this, paramq1, paramq);
      localObject = this.jXV;
      View localView = this.jXW;
      if (this.mCount <= 1) {
        break label428;
      }
      bool = true;
      label298:
      ((a)localObject).a(paramq, paramq1, paramInt2, paramp, localView, bool, 0);
      if (this.mCount != 1) {
        break label434;
      }
      this.jXW.setBackgroundResource(2130837960);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramq.fjL)) {
        break label446;
      }
      this.jXW.setPadding(this.jXW.getPaddingLeft(), 0, this.jXW.getPaddingRight(), 0);
      AppMethodBeat.o(152650);
      return;
      this.jXI.setVisibility(0);
      this.jXI.af(paramq.title);
      break;
      label392:
      this.jYS.setVisibility(8);
      break label117;
      label404:
      this.jYR.setVisibility(8);
      break label151;
      label416:
      this.jXy.setImageResource(2130837974);
      break label253;
      label428:
      bool = false;
      break label298;
      label434:
      this.jXW.setBackgroundResource(2130837966);
    }
    label446:
    this.jXW.setPadding(this.jXW.getPaddingLeft(), a.jVz, this.jXW.getPaddingRight(), a.jVw);
    AppMethodBeat.o(152650);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(14277);
    super.a(paramView, parama);
    if (this.jXr != null)
    {
      AppMethodBeat.o(14277);
      return;
    }
    parama = (ViewStub)paramView.findViewById(2131821882);
    if (parama == null)
    {
      AppMethodBeat.o(14277);
      return;
    }
    parama.inflate();
    this.jXr = paramView.findViewById(2131821942);
    this.jXW = paramView.findViewById(2131821943);
    aWY();
    this.jXI = ((MMNeat7extView)this.jXr.findViewById(2131821212));
    this.jYR = ((TextView)this.jXr.findViewById(2131821940));
    this.jXy = ((ImageView)this.jXr.findViewById(2131821944));
    this.jYS = ((MMNeat7extView)this.jXr.findViewById(2131821945));
    AppMethodBeat.o(14277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.o
 * JD-Core Version:    0.7.0.1
 */