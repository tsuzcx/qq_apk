package com.tencent.mm.plugin.base.stub;

import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

final class WXCustomSchemeEntryActivity$1
  implements d.a
{
  WXCustomSchemeEntryActivity$1(WXCustomSchemeEntryActivity paramWXCustomSchemeEntryActivity) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    y.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    if ((paramm != null) && (paramInt1 != 0) && (paramInt2 != 0) && ((paramm instanceof aa)))
    {
      paramString = ((aa)paramm).QR();
      if ((paramString != null) && (!this.hSA.isFinishing())) {
        s.makeText(this.hSA, this.hSA.getString(R.l.app_tip) + " : " + bk.pm(paramString.tOY), 0).show();
      }
    }
    this.hSA.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity.1
 * JD-Core Version:    0.7.0.1
 */