package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.app.Activity;
import android.util.Base64;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bxp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;

final class BizTimeLineHotView$4
  implements w.a
{
  BizTimeLineHotView$4(BizTimeLineHotView paramBizTimeLineHotView) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.BizTimeLineHotList", "timeline_often_read_biz CGI return, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0)) {}
    do
    {
      return 0;
      paramString = (bxp)paramb.ecF.ecN;
    } while (((BizTimeLineHotView.d(this.ihA) instanceof Activity)) && (((Activity)BizTimeLineHotView.d(this.ihA)).isFinishing()));
    d.ihH = paramString;
    try
    {
      paramb = Base64.encodeToString(paramString.toByteArray(), 0);
      g.DP().Dz().c(ac.a.uzr, paramb);
      BizTimeLineHotView.a(this.ihA, paramString);
      return 0;
    }
    catch (IOException paramb)
    {
      for (;;)
      {
        y.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", new Object[] { paramb.getMessage() });
        g.DP().Dz().c(ac.a.uzr, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.4
 * JD-Core Version:    0.7.0.1
 */