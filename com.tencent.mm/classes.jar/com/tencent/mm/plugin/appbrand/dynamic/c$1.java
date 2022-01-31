package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.h.b.a.r;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.j.b.b;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.uo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements b.a
{
  c$1(c paramc) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.b paramb)
  {
    y.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    g localg = this.fTM.fTE;
    long l;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      h.nFQ.a(638L, 0L, 1L, false);
      if ((this.fTM.fTC == 1) && (!this.fTM.fTI))
      {
        v.jdMethod_if(18);
        paramString = new r();
        paramString.cjv = u.jy(this.fTM.dIX);
        paramString.cjw = u.jx(this.fTM.dIX);
        paramString.cjs = 10L;
        paramString.cju = 2L;
        paramString.cjr = this.fTM.dIX;
        paramString.cjt = System.currentTimeMillis();
        paramString.cjy = aq.fH(ae.getContext());
        paramString.QX();
      }
      if (localg != null)
      {
        l = localg.field_interval;
        b.h(this.fTM.fTL, l * 1000L);
        if ((this.fTM.fTE == null) || (TextUtils.isEmpty(this.fTM.fTE.field_data))) {
          j.aeZ().C(this.fTM.dIX, 627, 2);
        }
      }
    }
    label425:
    label511:
    do
    {
      return;
      l = 10L;
      break;
      if ((this.fTM.fTC == 1) && (!this.fTM.fTI))
      {
        this.fTM.fTI = true;
        v.jdMethod_if(17);
        paramString = new r();
        paramString.cjv = u.jy(this.fTM.dIX);
        paramString.cjw = u.jx(this.fTM.dIX);
        paramString.cjs = 10L;
        paramString.cju = 1L;
        paramString.cjr = this.fTM.dIX;
        paramString.cjt = System.currentTimeMillis();
        paramString.cjy = aq.fH(ae.getContext());
        paramString.QX();
      }
      paramb = (uo)paramb.ecF.ecN;
      if (paramb.sRj != null)
      {
        paramString = paramb.sRj.coM();
        if (localg == null) {
          break label511;
        }
        if (bk.bl(paramString)) {
          break label513;
        }
        localg.field_data = paramString;
      }
      for (;;)
      {
        localg.field_interval = paramb.dDr;
        localg.field_updateTime = System.currentTimeMillis();
        paramString = (Bundle)f.a("com.tencent.mm", localg.vf(), b.b.class);
        if (paramString != null) {
          paramString.getBoolean("result", false);
        }
        if (this.fTM.ahC) {
          break label559;
        }
        y.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
        return;
        paramString = "";
        break label425;
        break;
        if ((this.fTM.fTE == null) || (TextUtils.isEmpty(this.fTM.fTE.field_data))) {
          j.aeZ().C(this.fTM.dIX, 627, 4);
        }
      }
      this.fTM.a(this.fTM.dIU, localg);
      if ((this.fTM.fTC == 1) && (!this.fTM.fTJ)) {
        this.fTM.fTJ = true;
      }
    } while (localg.field_interval <= 0);
    label513:
    label559:
    this.fTM.aeT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c.1
 * JD-Core Version:    0.7.0.1
 */