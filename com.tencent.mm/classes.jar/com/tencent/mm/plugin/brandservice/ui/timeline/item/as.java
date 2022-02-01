package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.message.m;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.s;

public final class as
  extends ah
{
  public ImageView dpM;
  public ImageView vIK;
  public TextView vJf;
  public View vJg;
  public View vJh;
  public View vJi;
  private String vNA = "";
  
  public final void a(int paramInt, v paramv, ab paramab)
  {
    AppMethodBeat.i(302830);
    super.a(paramInt, paramv, paramab);
    if ((this.vIW != null) && (this.vIW.getVisibility() == 0))
    {
      if (a.getScaleSize(this.mContext) >= 1.125F)
      {
        this.vIW.setMaxLines(1);
        AppMethodBeat.o(302830);
        return;
      }
      this.vIW.setMaxLines(2);
    }
    AppMethodBeat.o(302830);
  }
  
  public final void a(int paramInt1, v paramv, final ab paramab, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6064);
    super.a(paramInt1, paramv, paramab, paramInt2, paramu, paramInt3);
    MPVideoPreviewMgr.vXs.p(paramab);
    Object localObject1 = MPVideoPreviewMgr.vXs;
    localObject1 = this.vNA;
    Object localObject2 = paramv.vid;
    label176:
    boolean bool;
    if ((!MPVideoPreviewMgr.vXt) || (Util.isNullOrNil(MPVideoPreviewMgr.vXC)) || (Util.isNullOrNil((String)localObject1)))
    {
      this.vNA = paramv.vid;
      this.mCount = paramInt1;
      this.vMz = false;
      this.vIX.setVisibility(8);
      paramab.acFw = g.ajf(paramab.field_talker);
      ac(this.vJg, b.vGc);
      localObject1 = m.uD(paramv.nUQ);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label649;
      }
      this.vJi.setVisibility(0);
      this.vJf.setVisibility(0);
      this.vJf.setText((CharSequence)localObject1);
      this.vJf.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      com.tencent.mm.plugin.brandservice.ui.b.e.l(this.vJf);
      this.vJf.setShadowLayer(10.0F, 0.0F, 1.0F, this.mContext.getResources().getColor(d.b.BW_0_Alpha_0_3));
      this.vIK.setVisibility(0);
      this.vIW.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
      this.vIY.setBackgroundResource(d.d.mm_trans);
      this.vJd.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
      paramInt3 = this.vMC.vFN.getContentWidth();
      this.vMC.vFN.a(paramab.field_msgId, 0, paramv, paramv.nUM, this.vIK, paramInt3, b.vGc, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6062);
          as.this.vMz = true;
          as.this.vJd.setTextColor(as.this.mContext.getResources().getColor(d.b.BW_100_Alpha_0_9));
          if (as.this.vIX != null) {
            as.this.vIX.setVisibility(0);
          }
          if (as.this.mCount > 1) {
            as.this.vIW.setTextColor(as.this.mContext.getResources().getColor(d.b.white_text_color));
          }
          if (as.this.vMA > 0) {
            as.this.vIY.setBackgroundResource(d.d.biz_time_line_title_gradient_mask);
          }
          as.this.vJf.setTextColor(as.this.mContext.getResources().getColor(d.b.white_text_color));
          as.this.vMC.vFN.y(paramab.field_msgId, paramInt2);
          AppMethodBeat.o(6062);
        }
        
        public final void onStart() {}
      }, false, this.vMB);
      a(this.mCount, paramv, paramab);
      float f = 0.5F;
      if (this.vIW.getVisibility() != 0) {
        break label679;
      }
      this.vIW.measure(a.ms(this.mContext) - a.fromDPToPix(this.mContext, 48), 0);
      paramInt3 = this.vJg.getLayoutParams().height;
      int i = this.vIW.getMeasuredHeight();
      int j = b.vGm;
      f = 0.56F;
      paramInt3 = paramInt3 - i - j;
      label418:
      if (this.vJh != null) {
        ((RelativeLayout.LayoutParams)this.vJh.getLayoutParams()).topMargin = ((int)(paramInt3 * f - a.fromDPToPix(this.mContext, 48) / 2));
      }
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(paramv.url, paramv.type, "");
      if (!a(paramInt1, paramv)) {
        a(this, paramab, paramv);
      }
      localObject1 = this.vMC;
      localObject2 = this.vIV;
      if (this.mCount <= 1) {
        break label694;
      }
      bool = true;
      label515:
      ((b)localObject1).a(paramv, paramab, paramInt2, paramu, (View)localObject2, bool, 0);
      if (this.mCount != 1) {
        break label700;
      }
      this.vIV.setBackgroundResource(d.d.biz_time_line_item_bottom_bg);
      this.vIV.setPadding(this.vIV.getPaddingLeft(), 0, this.vIV.getPaddingRight(), b.vGf);
    }
    for (;;)
    {
      this.vIX.setBackgroundResource(d.d.biz_time_line_cover_mask_selector);
      AppMethodBeat.o(6064);
      return;
      if (!s.p(localObject1, localObject2)) {}
      for (paramInt3 = 1;; paramInt3 = 0)
      {
        bool = s.p(MPVideoPreviewMgr.vXC, localObject1);
        if ((paramInt3 == 0) || (!bool)) {
          break;
        }
        Log.i("MicroMsg.MPVideoPreviewMgr", "checkSameTopVideo true");
        MPVideoPreviewMgr.vXB = false;
        MPVideoPreviewMgr.dhC();
        break;
      }
      label649:
      this.vJf.setText("");
      this.vJi.setVisibility(8);
      this.vJf.setVisibility(8);
      break label176;
      label679:
      paramInt3 = this.vJg.getLayoutParams().height;
      break label418;
      label694:
      bool = false;
      break label515;
      label700:
      this.vIV.setBackgroundResource(d.d.biz_time_line_item_middle_bg);
      this.vIV.setPadding(this.vIV.getPaddingLeft(), 0, this.vIV.getPaddingRight(), 0);
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6063);
    super.a(paramView, paramb);
    if (this.vJU != null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.viewstub_top_video_slot);
    if (paramb == null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramb.inflate();
    this.vJU = paramView.findViewById(d.e.biz_time_line_item_video_slot);
    this.vIV = paramView.findViewById(d.e.chatting_item_biz_video_click_view);
    ddp();
    this.vIK = ((ImageView)this.vJU.findViewById(d.e.cover));
    this.dpM = ((ImageView)this.vJU.findViewById(d.e.video_icon));
    this.vIW = ((MMNeat7extView)this.vJU.findViewById(d.e.title_tv));
    this.vJf = ((TextView)this.vJU.findViewById(d.e.play_time_tv));
    this.vJi = this.vJU.findViewById(d.e.play_time_tv_shadow);
    this.vJg = this.vJU.findViewById(d.e.chatting_video_cover_ll);
    this.vIX = ((ImageView)this.vJU.findViewById(d.e.press_mask_iv));
    this.vJh = this.vJU.findViewById(d.e.video_icon_container);
    this.vIY = ((LinearLayout)this.vJU.findViewById(d.e.biz_time_line_top_title_layout));
    this.vIZ = ((LinearLayout)this.vJU.findViewById(d.e.single_top_video_slot_title_layout));
    this.vJa = ((MMNeat7extView)this.vJU.findViewById(d.e.single_title_tv));
    this.vJb = ((MMNeat7extView)this.vJU.findViewById(d.e.single_digest_tv));
    this.vMx = this.vJU.findViewById(d.e.stat_layout_bottom);
    this.vMy = ((TextView)this.vJU.findViewById(d.e.friends_read_tv_bottom));
    paramView = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
    if (com.tencent.mm.plugin.brandservice.ui.b.e.dhV())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      com.tencent.mm.plugin.brandservice.ui.b.e.e(this.vIW);
    }
    paramView = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
    if (com.tencent.mm.plugin.brandservice.ui.b.e.dhV())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      com.tencent.mm.plugin.brandservice.ui.b.e.e(this.vJa);
    }
    AppMethodBeat.o(6063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.as
 * JD-Core Version:    0.7.0.1
 */