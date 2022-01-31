package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class WXBizEntryActivity$6
  implements d.a
{
  WXBizEntryActivity$6(WXBizEntryActivity paramWXBizEntryActivity) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    y.i("MicroMsg.WXBizEntryActivity", "offline pay, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    if ((paramm != null) && (paramInt1 != 0) && (paramInt2 != 0) && ((paramm instanceof aa)))
    {
      paramString = ((aa)paramm).QR();
      if ((paramString != null) && (!this.hSd.isFinishing()))
      {
        h.a(this.hSd, bk.pm(paramString.tOY), this.hSd.getString(R.l.app_tip), this.hSd.getString(R.l.app_ok), false, new WXBizEntryActivity.6.1(this));
        return;
      }
      this.hSd.finish();
      return;
    }
    this.hSd.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity.6
 * JD-Core Version:    0.7.0.1
 */