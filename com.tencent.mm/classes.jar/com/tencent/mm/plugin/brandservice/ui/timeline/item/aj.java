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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.g.b.p;
import d.z;
import java.util.HashSet;
import java.util.LinkedList;

public final class aj
  extends y
{
  public ImageView ka;
  public View oiA;
  public View oiB;
  public ImageView oic;
  public TextView oiz;
  private String omd = "";
  
  public final void a(int paramInt, v paramv)
  {
    AppMethodBeat.i(6065);
    super.a(paramInt, paramv);
    if ((this.oip != null) && (this.oip.getVisibility() == 0))
    {
      if (com.tencent.mm.cb.a.ef(this.mContext) >= 1.125F)
      {
        this.oip.setMaxLines(1);
        AppMethodBeat.o(6065);
        return;
      }
      this.oip.setMaxLines(2);
    }
    AppMethodBeat.o(6065);
  }
  
  public final void a(int paramInt1, v paramv, final w paramw, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6064);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    Object localObject1 = MPVideoPreviewMgr.ovZ;
    p.h(paramw, "info");
    if (MPVideoPreviewMgr.bSZ()) {
      localObject1 = (d.g.a.b)MPVideoPreviewMgr.e.own;
    }
    label108:
    float f;
    label209:
    boolean bool1;
    switch (paramw.field_type)
    {
    default: 
      localObject1 = MPVideoPreviewMgr.ovZ;
      localObject1 = this.omd;
      ??? = paramv.hCa;
      if ((!MPVideoPreviewMgr.bSZ()) || (bu.isNullOrNil(MPVideoPreviewMgr.ovU)) || (bu.isNullOrNil((String)localObject1)))
      {
        this.omd = paramv.hCa;
        this.mCount = paramInt1;
        this.olc = false;
        this.oiq.setVisibility(8);
        paramw.IIE = e.XT(paramw.field_talker);
        X(this.oiA, com.tencent.mm.plugin.brandservice.ui.timeline.b.ofU);
        localObject1 = m.ol(paramv.hGi);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label793;
        }
        this.oiz.setVisibility(0);
        this.oiz.setText((CharSequence)localObject1);
        this.oiz.setTextColor(this.mContext.getResources().getColor(2131100541));
        this.oiz.setShadowLayer(10.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131099662));
        this.oic.setVisibility(0);
        this.oip.setTextColor(this.mContext.getResources().getColor(2131100541));
        this.oir.setBackgroundResource(2131233299);
        this.oiw.setTextColor(this.mContext.getResources().getColor(2131100541));
        paramInt1 = bPK();
        this.oll.ogi.a(paramw.field_msgId, 0, paramv, paramv.hGe, this.oic, paramInt1, com.tencent.mm.plugin.brandservice.ui.timeline.b.ofU, false, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(6062);
            aj.this.olc = true;
            aj.this.oiw.setTextColor(aj.this.mContext.getResources().getColor(2131099674));
            if (aj.this.oiq != null) {
              aj.this.oiq.setVisibility(0);
            }
            if (aj.this.mCount > 1) {
              aj.this.oip.setTextColor(aj.this.mContext.getResources().getColor(2131101182));
            }
            if (aj.this.old > 0) {
              aj.this.oir.setBackgroundResource(2131231282);
            }
            aj.this.oiz.setTextColor(aj.this.mContext.getResources().getColor(2131101182));
            aj.this.oll.ogi.p(paramw.field_msgId, paramInt2);
            AppMethodBeat.o(6062);
          }
          
          public final void onStart() {}
        }, false, this.ole);
        a(this.mCount, paramv);
        if (this.oip.getVisibility() != 0) {
          break label805;
        }
        this.oip.measure(com.tencent.mm.cb.a.iu(this.mContext) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48), 0);
        paramInt1 = this.oiA.getLayoutParams().height - this.oip.getMeasuredHeight() - com.tencent.mm.plugin.brandservice.ui.timeline.b.ogd;
        f = 0.56F;
        label409:
        if (this.oiB != null) {
          ((RelativeLayout.LayoutParams)this.oiB.getLayoutParams()).topMargin = ((int)(f * paramInt1 - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48) / 2));
        }
        localObject1 = this.oll;
        ??? = this.oio;
        if (this.mCount <= 1) {
          break label824;
        }
        bool1 = true;
        label471:
        ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a(paramv, paramw, paramInt2, paramu, (View)???, bool1, 0);
        if (this.mCount != 1) {
          break label830;
        }
        this.oio.setBackgroundResource(2131231256);
        this.oio.setPadding(this.oio.getPaddingLeft(), 0, this.oio.getPaddingRight(), com.tencent.mm.plugin.brandservice.ui.timeline.b.ofW);
      }
      break;
    }
    for (;;)
    {
      v localv;
      for (;;)
      {
        this.oiq.setBackgroundResource(2131231253);
        AppMethodBeat.o(6064);
        return;
        ??? = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramw.field_msgId, paramw.field_content);
        if ((??? == null) || (??? == null)) {
          break;
        }
        ??? = ((u)???).hFT;
        if (??? == null) {
          break;
        }
        localv = (v)((LinkedList)???).get(0);
        if ((localv == null) || (localv.type != 5)) {
          break;
        }
        synchronized (MPVideoPreviewMgr.ovZ)
        {
          if (MPVideoPreviewMgr.ovY.contains(localv.hCa))
          {
            ae.i("MicroMsg.MPVideoPreviewMgr", "cgiPlayUrl cgiQueue contain");
            break;
          }
          z localz = z.Nhr;
          if (!bu.isNullOrNil(MPVideoPreviewMgr.YI(localv.hCa))) {
            ae.i("MicroMsg.MPVideoPreviewMgr", "cgiPlayUrl getPlayUrl success");
          }
        }
      }
      MPVideoPreviewMgr.ovY.add(localv.hCa);
      ae.i("MicroMsg.MPVideoPreviewMgr", "cgiPlayUrl add cgiQueue");
      p.g(localv, "top");
      ((d.g.a.b)localObject1).invoke(localv);
      break;
      bool1 = p.i(localObject1, ???);
      boolean bool2 = p.i(MPVideoPreviewMgr.ovU, localObject1);
      if ((!(bool1 ^ true)) || (!bool2)) {
        break label108;
      }
      ae.i("MicroMsg.MPVideoPreviewMgr", "checkSameTopVideo true");
      MPVideoPreviewMgr.ovT = false;
      MPVideoPreviewMgr.bTa();
      break label108;
      label793:
      this.oiz.setVisibility(8);
      break label209;
      label805:
      paramInt1 = this.oiA.getLayoutParams().height;
      f = 0.5F;
      break label409;
      label824:
      bool1 = false;
      break label471;
      label830:
      this.oio.setBackgroundResource(2131231262);
      this.oio.setPadding(this.oio.getPaddingLeft(), 0, this.oio.getPaddingRight(), 0);
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6063);
    super.a(paramView, paramb);
    if (this.oiV != null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131306455);
    if (paramb == null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramb.inflate();
    this.oiV = paramView.findViewById(2131297348);
    this.oio = paramView.findViewById(2131298112);
    bPv();
    this.oic = ((ImageView)this.oiV.findViewById(2131298813));
    this.ka = ((ImageView)this.oiV.findViewById(2131306344));
    this.oip = ((MMNeat7extView)this.oiV.findViewById(2131305948));
    this.oiz = ((TextView)this.oiV.findViewById(2131303288));
    this.oiA = this.oiV.findViewById(2131298187);
    this.oiq = ((ImageView)this.oiV.findViewById(2131303387));
    this.oiB = this.oiV.findViewById(2131306345);
    this.oir = ((LinearLayout)this.oiV.findViewById(2131297367));
    this.ois = ((LinearLayout)this.oiV.findViewById(2131304832));
    this.oit = ((MMNeat7extView)this.oiV.findViewById(2131304829));
    this.oiu = ((MMNeat7extView)this.oiV.findViewById(2131304827));
    AppMethodBeat.o(6063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
 * JD-Core Version:    0.7.0.1
 */