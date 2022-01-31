package com.tencent.mm.plugin.appbrand.menu;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.tools.j;
import java.util.Iterator;
import java.util.List;

final class d
  extends a
{
  d()
  {
    super(o.gPw.ordinal());
  }
  
  public final void a(Context paramContext, q paramq, l paraml, String paramString)
  {
    if (bl.csf()) {
      paraml.a(this.gPE, paramContext.getResources().getColor(y.d.red_text_color), paramContext.getString(y.j.app_brand_actionsheet_debug_entrance));
    }
  }
  
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    paramn = new j(paramContext);
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    if (paramContext != null)
    {
      paramString = (ActivityManager)paramContext.getSystemService("activity");
      if (paramString != null)
      {
        paramString = paramString.getRunningAppProcesses();
        if (paramString != null)
        {
          int i = Process.myPid();
          paramString = paramString.iterator();
          do
          {
            if (!paramString.hasNext()) {
              break;
            }
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramString.next();
          } while (localRunningAppProcessInfo.pid != i);
        }
      }
    }
    for (paramString = localRunningAppProcessInfo.processName;; paramString = null)
    {
      paramn.phH = new d.1(this, paramq, paramString);
      paramn.phI = new d.2(this, paramq, paramContext);
      paramn.bJQ();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.d
 * JD-Core Version:    0.7.0.1
 */