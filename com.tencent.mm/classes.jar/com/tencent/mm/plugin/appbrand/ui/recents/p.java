package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.b.a.ee;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import org.apache.commons.b.a;
import org.apache.commons.b.g;

final class p
{
  boolean lJK = false;
  private Intent lJL = null;
  long lJM;
  ee lJN = null;
  LinkedHashSet<AppBrandRecentTaskInfo> lJO = null;
  c<un> lJP;
  
  private static int S(Intent paramIntent)
  {
    AppMethodBeat.i(49282);
    if (paramIntent != null) {}
    try
    {
      int i;
      if (paramIntent.getComponent() != null)
      {
        String str = paramIntent.getComponent().getShortClassName();
        boolean bool = bt.isNullOrNil(str);
        if (bool)
        {
          AppMethodBeat.o(49282);
          return 0;
        }
        str = str.substring(str.lastIndexOf('.') + 1);
        bool = a.contains(new String[] { "AppBrandNearbyEmptyUI", "AppBrandNearbyWebViewUI" }, str);
        if (bool)
        {
          AppMethodBeat.o(49282);
          return 3;
        }
        bool = a.contains(new String[] { "AppBrandSearchUI" }, str);
        if (bool)
        {
          AppMethodBeat.o(49282);
          return 5;
        }
        if ("AppBrandLauncherFolderUI".equals(str)) {
          i = paramIntent.getIntExtra("KEY_MODE", 0);
        }
      }
      switch (i)
      {
      default: 
        AppMethodBeat.o(49282);
        return 0;
      }
      AppMethodBeat.o(49282);
      return 4;
    }
    catch (Exception paramIntent)
    {
      ad.e("MicroMsg.AppBrand.RecentsReporter", "makeFromMainFrameExitReportLeaveType e=%s", new Object[] { paramIntent });
      AppMethodBeat.o(49282);
    }
    return 0;
  }
  
  final void T(Intent paramIntent)
  {
    this.lJL = paramIntent;
    this.lJK = true;
  }
  
  final void a(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(49281);
    ad.d("MicroMsg.AppBrand.RecentsReporter", "reportExitAction reason[%s]", new Object[] { paramString });
    if (this.lJN != null)
    {
      long l = paramActivity.getIntent().getLongExtra("extra_start_activity_click_timestamp_ms", this.lJM);
      paramActivity = this.lJN;
      paramActivity.dYh = l;
      paramActivity.dYi = bt.eGO();
      LinkedList localLinkedList;
      ArrayList localArrayList;
      int i;
      if (paramActivity.dYj <= 0L)
      {
        if ("onDestroy".equals(paramString)) {
          paramActivity.dYj = 1L;
        }
      }
      else
      {
        paramString = new String[4];
        localLinkedList = new LinkedList();
        localArrayList = new ArrayList(this.lJO);
        i = 0;
      }
      for (;;)
      {
        if (i >= 4) {
          break label204;
        }
        localLinkedList.clear();
        int j = i * 5;
        for (;;)
        {
          if (j < Math.min(localArrayList.size(), (i + 1) * 5))
          {
            localLinkedList.addLast(((AppBrandRecentTaskInfo)localArrayList.get(j)).appId);
            j += 1;
            continue;
            paramActivity.dYj = S(this.lJL);
            break;
          }
        }
        paramString[i] = g.a(localLinkedList, "|");
        i += 1;
      }
      label204:
      this.lJN.ky(paramString[0]);
      this.lJN.kz(paramString[1]);
      this.lJN.kA(paramString[2]);
      this.lJN.kB(paramString[3]);
      paramActivity.aBj();
      this.lJN = null;
    }
    if (this.lJP != null)
    {
      this.lJP.dead();
      this.lJP = null;
    }
    AppMethodBeat.o(49281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.p
 * JD-Core Version:    0.7.0.1
 */