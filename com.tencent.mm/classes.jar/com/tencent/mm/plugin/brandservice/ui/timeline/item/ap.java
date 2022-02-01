package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ap
  extends ah
{
  public View vJg;
  public TextView vNm;
  View vNn;
  public ImageView vNo;
  public ImageView[] vNp;
  public View[] vNq;
  
  public ap()
  {
    AppMethodBeat.i(6050);
    this.vNp = new ImageView[4];
    this.vNq = new View[4];
    AppMethodBeat.o(6050);
  }
  
  private boolean ddV()
  {
    return this.mCount == 1;
  }
  
  public final void a(int paramInt1, v paramv, final ab paramab, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6052);
    super.a(paramInt1, paramv, paramab, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.vMz = false;
    this.vIX.setVisibility(8);
    ah.ac(this.vJg, b.vGc);
    paramInt1 = 0;
    Object localObject1;
    if (paramInt1 < this.vNq.length)
    {
      localObject1 = this.vNq[paramInt1];
      if (localObject1 != null)
      {
        if (paramInt1 == 0) {
          break label101;
        }
        if (paramInt1 == this.vNq.length - 1) {}
        ((View)localObject1).setVisibility(8);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label101:
        ((View)localObject1).setVisibility(0);
        this.vNp[0] = ((ImageView)((View)localObject1).findViewById(d.e.biz_time_line_top_pic_image_1));
        this.vNp[1] = ((ImageView)((View)localObject1).findViewById(d.e.biz_time_line_top_pic_image_2));
        this.vNp[2] = ((ImageView)((View)localObject1).findViewById(d.e.biz_time_line_top_pic_image_3));
        this.vNp[3] = ((ImageView)((View)localObject1).findViewById(d.e.biz_time_line_top_pic_image_4));
      }
    }
    this.vNn.setBackgroundResource(d.d.mm_trans);
    this.vIZ.setVisibility(8);
    final boolean bool = ddV();
    Object localObject2;
    if (this.vNp.length > 0)
    {
      localObject1 = this.vNp[0];
      localObject2 = paramv.nUM;
      if ((localObject1 != null) && (!Util.isNullOrNil((String)localObject2)))
      {
        paramInt1 = b.vGc;
        a.ms(this.mContext);
        a.getDensity(this.mContext);
        Point localPoint = new Point((int)(paramInt1 * 1.777778F), paramInt1);
        ((ImageView)localObject1).getLayoutParams().width = localPoint.x;
        ((ImageView)localObject1).getLayoutParams().height = localPoint.y;
        paramInt1 = localPoint.x;
        paramInt3 = localPoint.y;
        ((ImageView)localObject1).setVisibility(0);
        this.vNo.setImageResource(d.h.biz_time_line_loading_pic_icon);
        this.vMC.vFN.a(paramab.field_msgId, 0, paramv, (String)localObject2, (ImageView)localObject1, paramInt1, paramInt3, false, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(6049);
            ap.this.vMz = true;
            if (ap.this.vNo != null) {
              ap.this.vNo.setImageResource(d.h.biz_time_line_pic_icon);
            }
            if (ap.this.vIX != null) {
              ap.this.vIX.setVisibility(0);
            }
            View localView;
            if (ap.this.vNn != null)
            {
              localView = ap.this.vNn;
              if (!bool) {
                break label156;
              }
            }
            label156:
            for (int i = d.d.biz_time_line_title_bottom_round_gradient_mask;; i = d.d.biz_time_line_title_gradient_mask)
            {
              localView.setBackgroundResource(i);
              if (this.vNs == 0)
              {
                ap.this.vJd.setTextColor(ap.this.mContext.getResources().getColor(d.b.white_text_color));
                ap.this.vMC.vFN.y(paramab.field_msgId, paramInt2);
              }
              AppMethodBeat.o(6049);
              return;
            }
          }
          
          public final void onStart() {}
        }, bool, this.vMB);
      }
    }
    if (paramv.nVc > 1)
    {
      this.vNm.setVisibility(0);
      this.vNm.setText(String.valueOf(paramv.nVc));
      if (this.mCount != 1) {
        break label554;
      }
      if (!bool) {
        break label528;
      }
      this.vIV.setBackgroundResource(d.d.mm_trans);
      this.vIV.setPadding(0, 0, 0, 0);
      label436:
      if (!ddV()) {
        break label578;
      }
      this.vIX.setBackgroundResource(d.d.biz_time_line_cover_bottom_round_mask_selector);
      label453:
      a(this, paramab, paramv);
      localObject1 = this.vMC;
      localObject2 = this.vIV;
      if (this.mCount <= 1) {
        break label591;
      }
    }
    label528:
    label554:
    label578:
    label591:
    for (bool = true;; bool = false)
    {
      ((b)localObject1).a(paramv, paramab, paramInt2, paramu, (View)localObject2, bool, 0);
      AppMethodBeat.o(6052);
      return;
      this.vNm.setText("");
      this.vNm.setVisibility(8);
      break;
      this.vIV.setBackgroundResource(d.d.biz_time_line_item_bottom_bg);
      this.vIV.setPadding(0, 0, 0, b.vGf);
      break label436;
      this.vIV.setBackgroundResource(d.d.biz_time_line_item_middle_bg);
      this.vIV.setPadding(0, 0, 0, 0);
      break label436;
      this.vIX.setBackgroundResource(d.d.biz_time_line_cover_mask_selector);
      break label453;
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6051);
    super.a(paramView, paramb);
    if (this.vJU != null)
    {
      AppMethodBeat.o(6051);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.viewstub_top_pic_slot_new);
    if (paramb == null)
    {
      AppMethodBeat.o(6051);
      return;
    }
    paramb.inflate();
    this.vJU = paramView.findViewById(d.e.biz_time_line_item_pic_new_slot);
    this.vIV = paramView.findViewById(d.e.chatting_item_biz_pic_click_view);
    this.vNq[0] = this.vJU.findViewById(d.e.pic_layout_for_one);
    this.vNq[1] = this.vJU.findViewById(d.e.pic_layout_for_two);
    this.vNq[2] = this.vJU.findViewById(d.e.pic_layout_for_three);
    this.vNq[3] = this.vJU.findViewById(d.e.pic_layout_for_four);
    ddp();
    this.vNm = ((TextView)this.vJU.findViewById(d.e.pic_num));
    this.vNo = ((ImageView)this.vJU.findViewById(d.e.pic_icon));
    this.vIX = ((ImageView)this.vJU.findViewById(d.e.press_mask_iv));
    this.vJg = this.vJU.findViewById(d.e.chatting_pic_cover_ll);
    this.vNn = this.vJU.findViewById(d.e.biz_time_line_pic_bottom_layout);
    this.vIZ = ((LinearLayout)this.vJU.findViewById(d.e.single_top_pic_slot_digest_layout));
    this.vJb = ((MMNeat7extView)this.vJU.findViewById(d.e.single_digest_tv));
    AppMethodBeat.o(6051);
  }
  
  public final void a(ab paramab, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6054);
    super.a(paramab, paramv, paramView, paramTextView, paramInt);
    paramTextView.setTextColor(this.mContext.getResources().getColor(d.b.white_text_color));
    paramab = String.format(this.mContext.getResources().getString(d.i.biz_timeline_pic_words), new Object[] { this.vJb.jPy(), paramTextView.getText(), paramv.nVc });
    this.vIV.setContentDescription(paramab);
    AppMethodBeat.o(6054);
  }
  
  public final void eH(View paramView)
  {
    AppMethodBeat.i(369885);
    ah.ac(paramView, b.vGc);
    AppMethodBeat.o(369885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ap
 * JD-Core Version:    0.7.0.1
 */