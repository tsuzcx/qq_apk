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
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;

public final class av
  extends ak
{
  public ImageView bwJ;
  public ImageView sCR;
  public TextView sDo;
  public View sDp;
  public View sDq;
  private String sIe = "";
  
  public final void a(int paramInt, v paramv, z paramz)
  {
    AppMethodBeat.i(259179);
    super.a(paramInt, paramv, paramz);
    if ((this.sDe != null) && (this.sDe.getVisibility() == 0))
    {
      if (a.ez(this.mContext) >= 1.125F)
      {
        this.sDe.setMaxLines(1);
        AppMethodBeat.o(259179);
        return;
      }
      this.sDe.setMaxLines(2);
    }
    AppMethodBeat.o(259179);
  }
  
  public final void a(int paramInt1, v paramv, final z paramz, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6064);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    Object localObject1 = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.q(paramz);
    localObject1 = MPVideoPreviewMgr.sSn;
    localObject1 = this.sIe;
    Object localObject2 = paramv.vid;
    label170:
    boolean bool1;
    if ((!MPVideoPreviewMgr.sRX) || (Util.isNullOrNil(MPVideoPreviewMgr.sSg)) || (Util.isNullOrNil((String)localObject1)))
    {
      this.sIe = paramv.vid;
      this.mCount = paramInt1;
      this.sHc = false;
      this.sDf.setVisibility(8);
      paramz.Vec = g.apE(paramz.field_talker);
      Y(this.sDp, b.sAq);
      localObject1 = m.uD(paramv.lpO);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label623;
      }
      this.sDo.setVisibility(0);
      this.sDo.setText((CharSequence)localObject1);
      this.sDo.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
      this.sDo.setShadowLayer(10.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(d.b.BW_0_Alpha_0_5));
      this.sCR.setVisibility(0);
      this.sDe.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
      this.sDg.setBackgroundResource(d.d.mm_trans);
      this.sDl.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
      paramInt3 = this.sHf.sAc.getContentWidth();
      this.sHf.sAc.a(paramz.field_msgId, 0, paramv, paramv.lpK, this.sCR, paramInt3, b.sAq, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6062);
          av.this.sHc = true;
          av.this.sDl.setTextColor(av.this.mContext.getResources().getColor(d.b.BW_100_Alpha_0_9));
          if (av.this.sDf != null) {
            av.this.sDf.setVisibility(0);
          }
          if (av.this.mCount > 1) {
            av.this.sDe.setTextColor(av.this.mContext.getResources().getColor(d.b.white_text_color));
          }
          if (av.this.sHd > 0) {
            av.this.sDg.setBackgroundResource(d.d.dmA);
          }
          av.this.sDo.setTextColor(av.this.mContext.getResources().getColor(d.b.white_text_color));
          av.this.sHf.sAc.p(paramz.field_msgId, paramInt2);
          AppMethodBeat.o(6062);
        }
        
        public final void onStart() {}
      }, false, this.sHe);
      a(this.mCount, paramv, paramz);
      float f = 0.5F;
      if (this.sDe.getVisibility() != 0) {
        break label635;
      }
      this.sDe.measure(a.kr(this.mContext) - a.fromDPToPix(this.mContext, 48), 0);
      paramInt3 = this.sDp.getLayoutParams().height;
      int i = this.sDe.getMeasuredHeight();
      int j = b.sAA;
      f = 0.56F;
      paramInt3 = paramInt3 - i - j;
      label400:
      if (this.sDq != null) {
        ((RelativeLayout.LayoutParams)this.sDq.getLayoutParams()).topMargin = ((int)(paramInt3 * f - a.fromDPToPix(this.mContext, 48) / 2));
      }
      localObject1 = e.sKW;
      e.G(paramv.url, paramv.type, "");
      if (!a(paramInt1, paramv)) {
        a(this, paramz, paramv);
      }
      localObject1 = this.sHf;
      localObject2 = this.sDd;
      if (this.mCount <= 1) {
        break label650;
      }
      bool1 = true;
      label497:
      ((b)localObject1).a(paramv, paramz, paramInt2, paramu, (View)localObject2, bool1, 0);
      if (this.mCount != 1) {
        break label656;
      }
      this.sDd.setBackgroundResource(d.d.spE);
      this.sDd.setPadding(this.sDd.getPaddingLeft(), 0, this.sDd.getPaddingRight(), b.sAt);
    }
    for (;;)
    {
      this.sDf.setBackgroundResource(d.d.spC);
      AppMethodBeat.o(6064);
      return;
      bool1 = p.h(localObject1, localObject2);
      boolean bool2 = p.h(MPVideoPreviewMgr.sSg, localObject1);
      if ((!(bool1 ^ true)) || (!bool2)) {
        break;
      }
      Log.i("MicroMsg.MPVideoPreviewMgr", "checkSameTopVideo true");
      MPVideoPreviewMgr.sSf = false;
      MPVideoPreviewMgr.cEa();
      break;
      label623:
      this.sDo.setVisibility(8);
      break label170;
      label635:
      paramInt3 = this.sDp.getLayoutParams().height;
      break label400;
      label650:
      bool1 = false;
      break label497;
      label656:
      this.sDd.setBackgroundResource(d.d.spF);
      this.sDd.setPadding(this.sDd.getPaddingLeft(), 0, this.sDd.getPaddingRight(), 0);
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6063);
    super.a(paramView, paramb);
    if (this.sEi != null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.dZA);
    if (paramb == null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramb.inflate();
    this.sEi = paramView.findViewById(d.e.sqQ);
    this.sDd = paramView.findViewById(d.e.srA);
    cAo();
    this.sCR = ((ImageView)this.sEi.findViewById(d.e.cover));
    this.bwJ = ((ImageView)this.sEi.findViewById(d.e.video_icon));
    this.sDe = ((MMNeat7extView)this.sEi.findViewById(d.e.title_tv));
    this.sDo = ((TextView)this.sEi.findViewById(d.e.sss));
    this.sDp = this.sEi.findViewById(d.e.dzy);
    this.sDf = ((ImageView)this.sEi.findViewById(d.e.dRn));
    this.sDq = this.sEi.findViewById(d.e.stn);
    this.sDg = ((LinearLayout)this.sEi.findViewById(d.e.srq));
    this.sDh = ((LinearLayout)this.sEi.findViewById(d.e.ssV));
    this.sDi = ((MMNeat7extView)this.sEi.findViewById(d.e.ssT));
    this.sDj = ((MMNeat7extView)this.sEi.findViewById(d.e.dVp));
    this.sHa = this.sEi.findViewById(d.e.stb);
    this.sHb = ((TextView)this.sEi.findViewById(d.e.srU));
    paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
    if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      com.tencent.mm.plugin.brandservice.ui.b.d.e(this.sDe);
    }
    paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
    if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      com.tencent.mm.plugin.brandservice.ui.b.d.e(this.sDi);
    }
    AppMethodBeat.o(6063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.av
 * JD-Core Version:    0.7.0.1
 */