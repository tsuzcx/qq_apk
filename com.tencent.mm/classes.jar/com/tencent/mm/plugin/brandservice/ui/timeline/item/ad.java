package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ad
  extends x
{
  public MMNeat7extView ocA;
  public ImageView ocn;
  public ImageView oeW;
  public TextView ofN;
  public ImageView ofO;
  
  public final void a(int paramInt1, v paramv, final w paramw, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6045);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    label67:
    label84:
    boolean bool;
    if (bt.isNullOrNil(paramv.title))
    {
      this.ocA.setVisibility(8);
      if (TextUtils.isEmpty(paramv.hDA)) {
        break label327;
      }
      this.ofN.setVisibility(0);
      this.ofN.setText(paramv.hDA);
      if (paramv.hDB != 2) {
        break label339;
      }
      this.ofO.setImageResource(2131689903);
      a(this.oeW, paramw, 0, paramv.hDm);
      a(this, paramw, paramv);
      Object localObject1 = this.ofm;
      Object localObject2 = this.ocz;
      if (paramInt1 <= 1) {
        break label351;
      }
      bool = true;
      label126:
      ((b)localObject1).a(paramv, paramw, paramInt2, paramu, (View)localObject2, bool, 0);
      if (!(paramw.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.bSj())) {
        break label357;
      }
      this.oeW.setImageResource(2131689906);
      label182:
      this.ocp.setVisibility(8);
      paramu = this.ofm.oas;
      long l = paramw.field_msgId;
      localObject1 = paramv.hDm;
      localObject2 = this.ocn;
      int i = b.oaf;
      paramu.a(l, 0, paramv, (String)localObject1, (ImageView)localObject2, i, i, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6043);
          ad.this.ocp.setVisibility(0);
          if ((paramw.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.bSj())) {
            ad.this.oeW.setImageResource(2131231672);
          }
          for (;;)
          {
            ad.this.ofm.oas.p(paramw.field_msgId, paramInt2);
            AppMethodBeat.o(6043);
            return;
            ad.this.oeW.setImageResource(2131231673);
          }
        }
        
        public final void onStart() {}
      }, paramInt3, 2.0F);
      if (paramInt1 != 1) {
        break label369;
      }
      this.ocz.setBackgroundResource(2131231692);
    }
    for (;;)
    {
      paramv = this.ocz;
      if (paramInt1 <= 1) {
        break label381;
      }
      paramInt1 = b.oah;
      paramInt2 = b.oah;
      paramv.setPadding(paramInt1, paramInt1, paramInt2, paramInt2);
      AppMethodBeat.o(6045);
      return;
      this.ocA.setVisibility(0);
      this.ocA.ar(paramv.title);
      break;
      label327:
      this.ofN.setVisibility(8);
      break label67;
      label339:
      this.ofO.setImageResource(2131689912);
      break label84;
      label351:
      bool = false;
      break label126;
      label357:
      this.oeW.setImageResource(2131689909);
      break label182;
      label369:
      this.ocz.setBackgroundResource(2131231693);
    }
    label381:
    paramInt1 = b.oah;
    paramv.setPadding(paramInt1, paramInt1, b.oah, b.oag);
    AppMethodBeat.o(6045);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6044);
    super.a(paramView, paramb);
    if (this.odh != null)
    {
      AppMethodBeat.o(6044);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131306450);
    if (paramb == null)
    {
      AppMethodBeat.o(6044);
      return;
    }
    paramb.inflate();
    this.odh = paramView.findViewById(2131297343);
    this.ocz = paramView.findViewById(2131298106);
    bOx();
    this.ocn = ((ImageView)this.odh.findViewById(2131298813));
    this.ocA = ((MMNeat7extView)this.odh.findViewById(2131305948));
    this.ofN = ((TextView)this.odh.findViewById(2131303307));
    this.oeW = ((ImageView)this.odh.findViewById(2131303284));
    this.ofO = ((ImageView)this.odh.findViewById(2131306868));
    this.ocp = ((ImageView)this.odh.findViewById(2131298826));
    AppMethodBeat.o(6044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
 * JD-Core Version:    0.7.0.1
 */