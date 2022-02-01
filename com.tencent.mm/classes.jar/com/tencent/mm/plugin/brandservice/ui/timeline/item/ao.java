package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.storage.ab;

public final class ao
  extends ah
{
  public ImageView dpM;
  public ImageView vIK;
  public View vJg;
  
  public final void a(int paramInt1, v paramv, final ab paramab, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6048);
    super.a(paramInt1, paramv, paramab, paramInt2, paramu, paramInt3);
    eH(this.vJg);
    this.vIM.setVisibility(8);
    this.vJd.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
    this.dpM.setBackgroundResource(d.h.chatting_item_biz_pic_loading_icon);
    Object localObject3 = this.vMC.vFN;
    long l = paramab.field_msgId;
    String str = paramv.nUM;
    Object localObject1 = this.vIK;
    int k = b.vGa;
    Object localObject2 = new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6046);
        ao.this.vIM.setVisibility(0);
        ao.this.vJd.setTextColor(ao.this.mContext.getResources().getColor(d.b.white_text_color));
        ao.this.dpM.setBackgroundResource(d.h.biz_time_line_pic_icon);
        ao.this.vMC.vFN.y(paramab.field_msgId, paramInt2);
        AppMethodBeat.o(6046);
      }
      
      public final void onStart() {}
    };
    int i;
    label163:
    int j;
    if (paramInt1 == 1)
    {
      bool = true;
      str = d.Om(str);
      Object localObject4 = g.Ybp;
      if (g.awm(1))
      {
        localObject4 = com.tencent.mm.pluginsdk.model.e.XQp;
        com.tencent.mm.pluginsdk.model.e.o(l, 0, paramv.url);
      }
      if (!bool) {
        break label409;
      }
      i = d.d.biz_time_line_bottom_round_mask_bg;
      if (!bool) {
        break label415;
      }
      j = d.d.biz_time_line_cover_bottom_round_default_bg;
      label173:
      float f = a.fromDPToPix(((d)localObject3).vFF, 8);
      int m = ((d)localObject3).getContentWidth();
      localObject3 = f.XQM;
      localObject3 = new c.a();
      ((c.a)localObject3).oKE = j;
      ((c.a)localObject3).oKp = true;
      localObject3 = ((c.a)localObject3).eG(m, k);
      ((c.a)localObject3).oKG = String.valueOf(i);
      ((c.a)localObject3).oKe = new n(1);
      ((c.a)localObject3).oKN = new com.tencent.mm.pluginsdk.ui.applet.e(1);
      ((c.a)localObject3).oKO = new l();
      ((c.a)localObject3).fullPath = y.bpF(str);
      f.a(l, 0, paramv, str, (ImageView)localObject1, paramInt3, false, ((c.a)localObject3).bKx(), new m(1, m, k, false, bool, f, (m.a)localObject2));
      a(this, paramab, paramv);
      localObject1 = this.vMC;
      localObject2 = this.vIV;
      if (paramInt1 <= 1) {
        break label423;
      }
    }
    label409:
    label415:
    label423:
    for (boolean bool = true;; bool = false)
    {
      ((b)localObject1).a(paramv, paramab, paramInt2, paramu, (View)localObject2, bool, 0);
      if (paramInt1 != 1) {
        break label429;
      }
      this.vIX.setBackgroundResource(d.d.biz_time_line_cover_bottom_round_mask_selector);
      this.vIM.setBackgroundResource(d.d.biz_time_line_pic_cover_bottom_round_gradient_mask);
      AppMethodBeat.o(6048);
      return;
      bool = false;
      break;
      i = 0;
      break label163;
      j = d.d.biz_time_line_cover_default_bg;
      break label173;
    }
    label429:
    this.vIX.setBackgroundResource(d.d.biz_time_line_cover_mask_selector);
    this.vIM.setBackgroundResource(d.d.biz_time_line_pic_cover_gradient_mask);
    AppMethodBeat.o(6048);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6047);
    super.a(paramView, paramb);
    if (this.vJU != null)
    {
      AppMethodBeat.o(6047);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.viewstub_top_pic_slot);
    if (paramb == null)
    {
      AppMethodBeat.o(6047);
      return;
    }
    paramb.inflate();
    this.vJU = paramView.findViewById(d.e.biz_time_line_item_pic_slot);
    this.vIV = paramView.findViewById(d.e.chatting_item_biz_pic_click_view);
    ddp();
    this.vIK = ((ImageView)this.vJU.findViewById(d.e.cover));
    this.vIM = ((ImageView)this.vJU.findViewById(d.e.cover_mask_iv));
    this.dpM = ((ImageView)this.vJU.findViewById(d.e.pic_icon));
    this.vJg = this.vJU.findViewById(d.e.chatting_pic_cover_ll);
    this.vIX = ((ImageView)this.vJU.findViewById(d.e.press_mask_iv));
    AppMethodBeat.o(6047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ao
 * JD-Core Version:    0.7.0.1
 */