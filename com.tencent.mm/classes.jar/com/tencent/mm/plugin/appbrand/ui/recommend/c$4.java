package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;

final class c$4
  implements MRecyclerView.a
{
  c$4(c paramc) {}
  
  public final void B(View paramView, int paramInt)
  {
    paramView = this.hkA.hkr.mu(paramInt);
    Object localObject = this.hkA;
    y.i("MicroMsg.AppBrandRecommendUILogic", "doReportClickNodeData");
    long l1 = bk.UX();
    long l2 = ((c)localObject).hkx;
    qm localqm = new qm();
    localqm.username = paramView.username;
    d.a(((c)localObject).aqa(), ((c)localObject).aqk(), localqm, ((c)localObject).aqj(), (int)(l1 - l2));
    ((c)localObject).aqm();
    localObject = new Bundle(1);
    ((Bundle)localObject).putString("key_start_from_recommend_recommend_note", String.format(Locale.US, "%s:%d", new Object[] { Long.valueOf(this.hkA.aqa()), Integer.valueOf(paramInt) }));
    AppBrandProfileUI.c(this.hkA.bMV, paramView.username, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c.4
 * JD-Core Version:    0.7.0.1
 */