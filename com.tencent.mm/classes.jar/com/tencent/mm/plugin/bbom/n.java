package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  implements f
{
  static n hSV;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 4) && (!au.Dk().foreground)) {}
    switch (paramInt2)
    {
    default: 
      return;
    case -311: 
    case -310: 
    case -205: 
    case -72: 
    case -9: 
    case -6: 
    case -4: 
    case -3: 
      au.getNotification().ex(ae.getContext().getString(R.l.main_err_relogin));
      au.hold();
      return;
    case -140: 
      y.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", new Object[] { paramString });
      if (!bk.bl(paramString)) {
        au.getNotification().ex(paramString);
      }
      for (;;)
      {
        au.hold();
        return;
        au.getNotification().ex(ae.getContext().getString(R.l.main_err_relogin));
      }
    case -100: 
      au.getNotification().ex(ae.getContext().getString(R.l.main_err_another_place));
      w.bM(ae.getContext());
      au.hold();
      return;
    case -999999: 
      new ah().post(new n.1(this));
      return;
    }
    paramString = ae.getContext().getSharedPreferences("system_config_prefs", 0);
    long l = paramString.getLong("recomended_update_ignore", -1L);
    if ((l != -1L) && (bk.cn(l) < 86400L))
    {
      y.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=" + l);
      return;
    }
    paramm = au.getNotification();
    if (paramInt2 == -17) {}
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      paramm.fS(paramInt1);
      paramString.edit().putLong("recomended_update_ignore", bk.UX()).commit();
      h.nFQ.a(405L, 27L, 1L, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.n
 * JD-Core Version:    0.7.0.1
 */