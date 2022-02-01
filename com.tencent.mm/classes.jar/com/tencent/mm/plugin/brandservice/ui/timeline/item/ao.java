package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ao
  extends ai
{
  public ImageView ptE;
  public MMNeat7extView ptR;
  public ImageView pxu;
  public TextView pyj;
  public ImageView pyk;
  
  public final void a(int paramInt1, v paramv, final z paramz, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6045);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    label67:
    label84:
    boolean bool;
    if (Util.isNullOrNil(paramv.title))
    {
      this.ptR.setVisibility(8);
      if (TextUtils.isEmpty(paramv.iAA)) {
        break label327;
      }
      this.pyj.setVisibility(0);
      this.pyj.setText(paramv.iAA);
      if (paramv.iAB != 2) {
        break label339;
      }
      this.pyk.setImageResource(2131689918);
      a(this.pxu, paramz, 0, paramv.iAo);
      a(this, paramz, paramv);
      Object localObject1 = this.pxE;
      Object localObject2 = this.ptQ;
      if (paramInt1 <= 1) {
        break label351;
      }
      bool = true;
      label126:
      ((b)localObject1).a(paramv, paramz, paramInt2, paramu, (View)localObject2, bool, 0);
      if (!(paramz.field_msgId + "_0").equals(c.crh())) {
        break label357;
      }
      this.pxu.setImageResource(2131689921);
      label182:
      this.ptG.setVisibility(8);
      paramu = this.pxE.prc;
      long l = paramz.field_msgId;
      localObject1 = paramv.iAo;
      localObject2 = this.ptE;
      int i = b.pru;
      paramu.a(l, 0, paramv, (String)localObject1, (ImageView)localObject2, i, i, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6043);
          ao.this.ptG.setVisibility(0);
          if ((paramz.field_msgId + "_0").equals(c.crh())) {
            ao.this.pxu.setImageResource(2131231738);
          }
          for (;;)
          {
            ao.this.pxE.prc.m(paramz.field_msgId, paramInt2);
            AppMethodBeat.o(6043);
            return;
            ao.this.pxu.setImageResource(2131231739);
          }
        }
        
        public final void onStart() {}
      }, paramInt3, 2.0F);
      if (paramInt1 != 1) {
        break label369;
      }
      this.ptQ.setBackgroundResource(2131231759);
    }
    for (;;)
    {
      paramv = this.ptQ;
      if (paramInt1 <= 1) {
        break label381;
      }
      paramInt1 = b.prw;
      paramInt2 = b.prw;
      paramv.setPadding(paramInt1, paramInt1, paramInt2, paramInt2);
      AppMethodBeat.o(6045);
      return;
      this.ptR.setVisibility(0);
      this.ptR.aw(paramv.title);
      break;
      label327:
      this.pyj.setVisibility(8);
      break label67;
      label339:
      this.pyk.setImageResource(2131689927);
      break label84;
      label351:
      bool = false;
      break label126;
      label357:
      this.pxu.setImageResource(2131689924);
      break label182;
      label369:
      this.ptQ.setBackgroundResource(2131231760);
    }
    label381:
    paramInt1 = b.prw;
    paramv.setPadding(paramInt1, paramInt1, b.prw, b.prv);
    AppMethodBeat.o(6045);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6044);
    super.a(paramView, paramb);
    if (this.puO != null)
    {
      AppMethodBeat.o(6044);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131309893);
    if (paramb == null)
    {
      AppMethodBeat.o(6044);
      return;
    }
    paramb.inflate();
    this.puO = paramView.findViewById(2131297554);
    this.ptQ = paramView.findViewById(2131298456);
    cmH();
    this.ptE = ((ImageView)this.puO.findViewById(2131299277));
    this.ptR = ((MMNeat7extView)this.puO.findViewById(2131309249));
    this.pyj = ((TextView)this.puO.findViewById(2131305980));
    this.pxu = ((ImageView)this.puO.findViewById(2131305957));
    this.pyk = ((ImageView)this.puO.findViewById(2131310335));
    this.ptG = ((ImageView)this.puO.findViewById(2131299291));
    paramView = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
    if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
      com.tencent.mm.plugin.brandservice.ui.b.d.c(this.ptR);
    }
    AppMethodBeat.o(6044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ao
 * JD-Core Version:    0.7.0.1
 */