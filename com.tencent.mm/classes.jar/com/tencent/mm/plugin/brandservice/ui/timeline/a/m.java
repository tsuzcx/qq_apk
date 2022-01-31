package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class m
  extends c
{
  private MMNeat7extView jYN;
  
  public final void a(int paramInt1, com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt2, p paramp)
  {
    boolean bool = true;
    AppMethodBeat.i(152647);
    super.a(paramInt1, paramq, paramq1, paramInt2, paramp);
    paramq1.ywB = d.GO(paramq1.field_talker);
    Object localObject;
    if (bo.isNullOrNil(paramq.title))
    {
      this.jYN.setVisibility(8);
      i = com.tencent.mm.cb.a.gw(this.mContext);
      int j = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 72);
      localObject = this.jYN.Sa(i - j);
      if (localObject == null) {
        break label234;
      }
    }
    label130:
    label228:
    label234:
    for (int i = ((com.tencent.neattextview.textview.layout.a)localObject).dTo();; i = 0)
    {
      this.jYN.setMaxLines(3);
      localObject = (LinearLayout.LayoutParams)this.jYN.getLayoutParams();
      View localView;
      if (i == 1)
      {
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        this.jYN.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jXW.setBackgroundResource(2130837960);
        localObject = this.jXV;
        localView = this.jXW;
        if (paramInt1 <= 1) {
          break label228;
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a)localObject).a(paramq, paramq1, paramInt2, paramp, localView, bool, 0);
        AppMethodBeat.o(152647);
        return;
        this.jYN.setVisibility(0);
        this.jYN.setMaxLines(2147483647);
        this.jYN.af(paramq.title);
        break;
        ((LinearLayout.LayoutParams)localObject).gravity = 19;
        break label130;
        bool = false;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(14274);
    super.a(paramView, parama);
    if (this.jXr != null)
    {
      AppMethodBeat.o(14274);
      return;
    }
    parama = (ViewStub)paramView.findViewById(2131821884);
    if (parama == null)
    {
      AppMethodBeat.o(14274);
      return;
    }
    parama.inflate();
    this.jXr = paramView.findViewById(2131821932);
    this.jXW = paramView.findViewById(2131821933);
    aWY();
    this.jYN = ((MMNeat7extView)paramView.findViewById(2131821903));
    AppMethodBeat.o(14274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.m
 * JD-Core Version:    0.7.0.1
 */