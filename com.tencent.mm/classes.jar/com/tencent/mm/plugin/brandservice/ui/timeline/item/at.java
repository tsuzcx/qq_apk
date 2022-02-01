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
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;

public final class at
  extends ai
{
  public ImageView kc;
  public ImageView ptE;
  public TextView pub;
  public View puc;
  public View pud;
  private String pyB = "";
  
  public final void a(int paramInt, v paramv, z paramz)
  {
    AppMethodBeat.i(194976);
    super.a(paramInt, paramv, paramz);
    if ((this.ptR != null) && (this.ptR.getVisibility() == 0))
    {
      if (a.ez(this.mContext) >= 1.125F)
      {
        this.ptR.setMaxLines(1);
        AppMethodBeat.o(194976);
        return;
      }
      this.ptR.setMaxLines(2);
    }
    AppMethodBeat.o(194976);
  }
  
  public final void a(int paramInt1, v paramv, final z paramz, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6064);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    Object localObject1 = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.q(paramz);
    localObject1 = MPVideoPreviewMgr.pJz;
    localObject1 = this.pyB;
    Object localObject2 = paramv.vid;
    label169:
    boolean bool1;
    if ((!MPVideoPreviewMgr.pJj) || (Util.isNullOrNil(MPVideoPreviewMgr.pJs)) || (Util.isNullOrNil((String)localObject1)))
    {
      this.pyB = paramv.vid;
      this.mCount = paramInt1;
      this.pxB = false;
      this.ptS.setVisibility(8);
      paramz.NQk = f.ahR(paramz.field_talker);
      W(this.puc, b.prs);
      localObject1 = m.rJ(paramv.iAs);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label612;
      }
      this.pub.setVisibility(0);
      this.pub.setText((CharSequence)localObject1);
      this.pub.setTextColor(this.mContext.getResources().getColor(2131100679));
      this.pub.setShadowLayer(10.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131099665));
      this.ptE.setVisibility(0);
      this.ptR.setTextColor(this.mContext.getResources().getColor(2131100679));
      this.ptT.setBackgroundResource(2131233974);
      this.ptY.setTextColor(this.mContext.getResources().getColor(2131100679));
      paramInt3 = cnf();
      this.pxE.prc.a(paramz.field_msgId, 0, paramv, paramv.iAo, this.ptE, paramInt3, b.prs, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6062);
          at.this.pxB = true;
          at.this.ptY.setTextColor(at.this.mContext.getResources().getColor(2131099681));
          if (at.this.ptS != null) {
            at.this.ptS.setVisibility(0);
          }
          if (at.this.mCount > 1) {
            at.this.ptR.setTextColor(at.this.mContext.getResources().getColor(2131101427));
          }
          if (at.this.pxC > 0) {
            at.this.ptT.setBackgroundResource(2131231342);
          }
          at.this.pub.setTextColor(at.this.mContext.getResources().getColor(2131101427));
          at.this.pxE.prc.m(paramz.field_msgId, paramInt2);
          AppMethodBeat.o(6062);
        }
        
        public final void onStart() {}
      }, false, this.pxD);
      a(this.mCount, paramv, paramz);
      float f = 0.5F;
      if (this.ptR.getVisibility() != 0) {
        break label624;
      }
      this.ptR.measure(a.jn(this.mContext) - a.fromDPToPix(this.mContext, 48), 0);
      paramInt3 = this.puc.getLayoutParams().height;
      int i = this.ptR.getMeasuredHeight();
      int j = b.prC;
      f = 0.56F;
      paramInt3 = paramInt3 - i - j;
      label389:
      if (this.pud != null) {
        ((RelativeLayout.LayoutParams)this.pud.getLayoutParams()).topMargin = ((int)(paramInt3 * f - a.fromDPToPix(this.mContext, 48) / 2));
      }
      localObject1 = e.pAN;
      e.F(paramv.url, paramv.type, "");
      if (!a(paramInt1, paramv)) {
        a(this, paramz, paramv);
      }
      localObject1 = this.pxE;
      localObject2 = this.ptQ;
      if (this.mCount <= 1) {
        break label639;
      }
      bool1 = true;
      label486:
      ((b)localObject1).a(paramv, paramz, paramInt2, paramu, (View)localObject2, bool1, 0);
      if (this.mCount != 1) {
        break label645;
      }
      this.ptQ.setBackgroundResource(2131231316);
      this.ptQ.setPadding(this.ptQ.getPaddingLeft(), 0, this.ptQ.getPaddingRight(), b.prv);
    }
    for (;;)
    {
      this.ptS.setBackgroundResource(2131231313);
      AppMethodBeat.o(6064);
      return;
      bool1 = p.j(localObject1, localObject2);
      boolean bool2 = p.j(MPVideoPreviewMgr.pJs, localObject1);
      if ((!(bool1 ^ true)) || (!bool2)) {
        break;
      }
      Log.i("MicroMsg.MPVideoPreviewMgr", "checkSameTopVideo true");
      MPVideoPreviewMgr.pJr = false;
      MPVideoPreviewMgr.cqK();
      break;
      label612:
      this.pub.setVisibility(8);
      break label169;
      label624:
      paramInt3 = this.puc.getLayoutParams().height;
      break label389;
      label639:
      bool1 = false;
      break label486;
      label645:
      this.ptQ.setBackgroundResource(2131231322);
      this.ptQ.setPadding(this.ptQ.getPaddingLeft(), 0, this.ptQ.getPaddingRight(), 0);
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6063);
    super.a(paramView, paramb);
    if (this.puO != null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131309898);
    if (paramb == null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramb.inflate();
    this.puO = paramView.findViewById(2131297559);
    this.ptQ = paramView.findViewById(2131298462);
    cmH();
    this.ptE = ((ImageView)this.puO.findViewById(2131299277));
    this.kc = ((ImageView)this.puO.findViewById(2131309770));
    this.ptR = ((MMNeat7extView)this.puO.findViewById(2131309249));
    this.pub = ((TextView)this.puO.findViewById(2131305961));
    this.puc = this.puO.findViewById(2131298568);
    this.ptS = ((ImageView)this.puO.findViewById(2131306101));
    this.pud = this.puO.findViewById(2131309771);
    this.ptT = ((LinearLayout)this.puO.findViewById(2131297585));
    this.ptU = ((LinearLayout)this.puO.findViewById(2131307918));
    this.ptV = ((MMNeat7extView)this.puO.findViewById(2131307915));
    this.ptW = ((MMNeat7extView)this.puO.findViewById(2131307913));
    this.pxz = this.puO.findViewById(2131308375);
    this.pxA = ((TextView)this.puO.findViewById(2131301797));
    paramView = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
    if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
      com.tencent.mm.plugin.brandservice.ui.b.d.c(this.ptR);
    }
    paramView = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
    if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
      com.tencent.mm.plugin.brandservice.ui.b.d.c(this.ptV);
    }
    AppMethodBeat.o(6063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.at
 * JD-Core Version:    0.7.0.1
 */