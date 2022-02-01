package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.b.a.fu;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import org.apache.commons.b.a;
import org.apache.commons.b.g;

final class p
{
  boolean mlH = false;
  private Intent mlI = null;
  long mlJ;
  fu mlK = null;
  LinkedHashSet<AppBrandRecentTaskInfo> mlL = null;
  c<ux> mlM;
  
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
        boolean bool = bs.isNullOrNil(str);
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
      ac.e("MicroMsg.AppBrand.RecentsReporter", "makeFromMainFrameExitReportLeaveType e=%s", new Object[] { paramIntent });
      AppMethodBeat.o(49282);
    }
    return 0;
  }
  
  final void T(Intent paramIntent)
  {
    this.mlI = paramIntent;
    this.mlH = true;
  }
  
  final void a(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(49281);
    ac.d("MicroMsg.AppBrand.RecentsReporter", "reportExitAction reason[%s]", new Object[] { paramString });
    if (this.mlK != null)
    {
      long l = paramActivity.getIntent().getLongExtra("extra_start_activity_click_timestamp_ms", this.mlJ);
      paramActivity = this.mlK;
      paramActivity.eaa = l;
      paramActivity.eab = bs.eWj();
      LinkedList localLinkedList;
      ArrayList localArrayList;
      int i;
      if (paramActivity.eac <= 0L)
      {
        if ("onDestroy".equals(paramString)) {
          paramActivity.eac = 1L;
        }
      }
      else
      {
        paramString = new String[4];
        localLinkedList = new LinkedList();
        localArrayList = new ArrayList(this.mlL);
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
            paramActivity.eac = S(this.mlI);
            break;
          }
        }
        paramString[i] = g.a(localLinkedList, "|");
        i += 1;
      }
      label204:
      this.mlK.nq(paramString[0]);
      this.mlK.nr(paramString[1]);
      this.mlK.ns(paramString[2]);
      this.mlK.nt(paramString[3]);
      paramActivity.aHZ();
      this.mlK = null;
    }
    if (this.mlM != null)
    {
      this.mlM.dead();
      this.mlM = null;
    }
    AppMethodBeat.o(49281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.p
 * JD-Core Version:    0.7.0.1
 */