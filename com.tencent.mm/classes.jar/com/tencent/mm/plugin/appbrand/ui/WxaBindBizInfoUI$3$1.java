package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.c.ani;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class WxaBindBizInfoUI$3$1
  implements w.a
{
  WxaBindBizInfoUI$3$1(WxaBindBizInfoUI.3 param3) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      y.e("MicroMsg.WxaBindBizInfoUI", "onResp, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    do
    {
      return 0;
      paramString = (ani)paramb.ecF.ecN;
      paramb = paramString.tjr;
      boolean bool = paramString.tjs;
      WxaBindBizInfoUI.a(this.heK.heJ, paramString.tjq);
      if (bool)
      {
        WxaBindBizInfoUI.c(this.heK.heJ).dZ(false);
        WxaBindBizInfoUI.d(this.heK.heJ).cKc();
        this.heK.heJ.heG.heM = true;
        WxaBindBizInfoUI.e(this.heK.heJ).setVisibility(0);
      }
    } while ((paramb == null) || (paramb.isEmpty()));
    paramString = new LinkedList();
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      paramm = (hp)paramb.next();
      if (paramm != null)
      {
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
        localWxaEntryInfo.title = paramm.nickname;
        localWxaEntryInfo.iconUrl = paramm.iQn;
        localWxaEntryInfo.username = paramm.username;
        paramString.add(localWxaEntryInfo);
      }
    }
    this.heK.heJ.heG.aA(paramString);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI.3.1
 * JD-Core Version:    0.7.0.1
 */