package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.b.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aq
  extends ah
{
  public ImageView vIK;
  public RelativeLayout vNu;
  
  public final void a(int paramInt1, final v paramv, final ab paramab, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6058);
    super.a(paramInt1, paramv, paramab, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.vMz = false;
    this.vIX.setVisibility(8);
    eH(this.vNu);
    eH(this.vIK);
    this.vIK.setVisibility(0);
    this.vIW.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
    this.vIY.setBackgroundResource(d.d.mm_trans);
    this.vJd.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
    paramInt3 = this.vMC.vFN.getContentWidth();
    this.vMC.vFN.a(paramab.field_msgId, 0, paramv, paramv.nUM, this.vIK, paramInt3, b.vGa, false, new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6056);
        aq.this.vMz = true;
        aq.this.vJd.setTextColor(aq.this.mContext.getResources().getColor(d.b.BW_100_Alpha_0_9));
        if (aq.this.vIX != null) {
          aq.this.vIX.setVisibility(0);
        }
        if (!aq.a(aq.this.mCount, paramv))
        {
          aq.this.vIW.setTextColor(aq.this.mContext.getResources().getColor(d.b.white_text_color));
          if (aq.this.b(paramv)) {
            aq.this.vIY.setBackgroundResource(d.d.biz_time_line_title_bottom_round_gradient_mask);
          }
        }
        for (;;)
        {
          aq.this.vMC.vFN.y(paramab.field_msgId, paramInt2);
          AppMethodBeat.o(6056);
          return;
          aq.this.vIY.setBackgroundResource(d.d.biz_time_line_title_gradient_mask);
          continue;
          if (aq.this.vMA > 0) {
            aq.this.vIY.setBackgroundResource(d.d.biz_time_line_title_gradient_mask);
          }
        }
      }
      
      public final void onStart() {}
    }, b(paramv), this.vMB);
    a(this.mCount, paramv, paramab);
    label249:
    b localb;
    View localView;
    if (a(this.mCount, paramv))
    {
      this.vIV.setPadding(this.vIV.getPaddingLeft(), 0, this.vIV.getPaddingRight(), b.vGf);
      if (!b(paramv)) {
        break label334;
      }
      this.vIX.setBackgroundResource(d.d.biz_time_line_cover_bottom_round_mask_selector);
      this.vIV.setBackgroundResource(d.d.biz_time_line_item_bottom_bg);
      if (!a(paramInt1, paramv)) {
        a(this, paramab, paramv);
      }
      localb = this.vMC;
      localView = this.vIV;
      if (paramInt1 <= 1) {
        break label381;
      }
    }
    label334:
    label381:
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramv, paramab, paramInt2, paramu, localView, bool, 0);
      AppMethodBeat.o(6058);
      return;
      this.vIV.setPadding(this.vIV.getPaddingLeft(), 0, this.vIV.getPaddingRight(), 0);
      break;
      this.vIX.setBackgroundResource(d.d.biz_time_line_cover_mask_selector);
      if (a(this.mCount, paramv))
      {
        this.vIV.setBackgroundResource(d.d.biz_time_line_item_bottom_bg);
        break label249;
      }
      this.vIV.setBackgroundResource(d.d.biz_time_line_item_middle_bg);
      break label249;
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6057);
    super.a(paramView, paramb);
    if (this.vJU != null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.viewstub_top_slot);
    if (paramb == null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramb.inflate();
    this.vJU = paramView.findViewById(d.e.biz_time_line_item_top_slot);
    this.vIV = paramView.findViewById(d.e.topSlot_click_view);
    ddp();
    this.vIK = ((ImageView)this.vJU.findViewById(d.e.cover_iv));
    this.vNu = ((RelativeLayout)this.vJU.findViewById(d.e.cover_layout));
    this.vIW = ((MMNeat7extView)this.vJU.findViewById(d.e.title_tv));
    this.vIM = ((ImageView)this.vJU.findViewById(d.e.cover_mask_iv));
    this.vIX = ((ImageView)this.vJU.findViewById(d.e.press_mask_iv));
    this.vIY = ((LinearLayout)this.vJU.findViewById(d.e.biz_time_line_top_title_layout));
    this.vIZ = ((LinearLayout)this.vJU.findViewById(d.e.single_top_slot_title_layout));
    this.vJa = ((MMNeat7extView)this.vJU.findViewById(d.e.single_title_tv));
    this.vJb = ((MMNeat7extView)this.vJU.findViewById(d.e.single_digest_tv));
    this.vMx = this.vJU.findViewById(d.e.stat_layout_bottom);
    this.vMy = ((TextView)this.vJU.findViewById(d.e.friends_read_tv_bottom));
    paramView = e.vYK;
    if (e.dhV())
    {
      paramView = e.vYK;
      e.e(this.vIW);
    }
    paramView = e.vYK;
    if (e.dhV())
    {
      paramView = e.vYK;
      e.e(this.vJa);
    }
    AppMethodBeat.o(6057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aq
 * JD-Core Version:    0.7.0.1
 */