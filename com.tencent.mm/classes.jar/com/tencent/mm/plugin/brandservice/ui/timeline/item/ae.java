package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ae
  extends y
{
  public ImageView oic;
  public MMNeat7extView oip;
  public ImageView okW;
  public TextView olL;
  public ImageView olM;
  
  public final void a(int paramInt1, v paramv, final w paramw, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6045);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    label67:
    label84:
    boolean bool;
    if (bu.isNullOrNil(paramv.title))
    {
      this.oip.setVisibility(8);
      if (TextUtils.isEmpty(paramv.hGs)) {
        break label327;
      }
      this.olL.setVisibility(0);
      this.olL.setText(paramv.hGs);
      if (paramv.hGt != 2) {
        break label339;
      }
      this.olM.setImageResource(2131689903);
      a(this.okW, paramw, 0, paramv.hGe);
      a(this, paramw, paramv);
      Object localObject1 = this.oll;
      Object localObject2 = this.oio;
      if (paramInt1 <= 1) {
        break label351;
      }
      bool = true;
      label126:
      ((b)localObject1).a(paramv, paramw, paramInt2, paramu, (View)localObject2, bool, 0);
      if (!(paramw.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.bTw())) {
        break label357;
      }
      this.okW.setImageResource(2131689906);
      label182:
      this.oie.setVisibility(8);
      paramu = this.oll.ogi;
      long l = paramw.field_msgId;
      localObject1 = paramv.hGe;
      localObject2 = this.oic;
      int i = b.ofV;
      paramu.a(l, 0, paramv, (String)localObject1, (ImageView)localObject2, i, i, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6043);
          ae.this.oie.setVisibility(0);
          if ((paramw.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.bTw())) {
            ae.this.okW.setImageResource(2131231672);
          }
          for (;;)
          {
            ae.this.oll.ogi.p(paramw.field_msgId, paramInt2);
            AppMethodBeat.o(6043);
            return;
            ae.this.okW.setImageResource(2131231673);
          }
        }
        
        public final void onStart() {}
      }, paramInt3, 2.0F);
      if (paramInt1 != 1) {
        break label369;
      }
      this.oio.setBackgroundResource(2131231692);
    }
    for (;;)
    {
      paramv = this.oio;
      if (paramInt1 <= 1) {
        break label381;
      }
      paramInt1 = b.ofX;
      paramInt2 = b.ofX;
      paramv.setPadding(paramInt1, paramInt1, paramInt2, paramInt2);
      AppMethodBeat.o(6045);
      return;
      this.oip.setVisibility(0);
      this.oip.aq(paramv.title);
      break;
      label327:
      this.olL.setVisibility(8);
      break label67;
      label339:
      this.olM.setImageResource(2131689912);
      break label84;
      label351:
      bool = false;
      break label126;
      label357:
      this.okW.setImageResource(2131689909);
      break label182;
      label369:
      this.oio.setBackgroundResource(2131231693);
    }
    label381:
    paramInt1 = b.ofX;
    paramv.setPadding(paramInt1, paramInt1, b.ofX, b.ofW);
    AppMethodBeat.o(6045);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6044);
    super.a(paramView, paramb);
    if (this.oiV != null)
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
    this.oiV = paramView.findViewById(2131297343);
    this.oio = paramView.findViewById(2131298106);
    bPv();
    this.oic = ((ImageView)this.oiV.findViewById(2131298813));
    this.oip = ((MMNeat7extView)this.oiV.findViewById(2131305948));
    this.olL = ((TextView)this.oiV.findViewById(2131303307));
    this.okW = ((ImageView)this.oiV.findViewById(2131303284));
    this.olM = ((ImageView)this.oiV.findViewById(2131306868));
    this.oie = ((ImageView)this.oiV.findViewById(2131298826));
    AppMethodBeat.o(6044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ae
 * JD-Core Version:    0.7.0.1
 */