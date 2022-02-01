package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wu;
import com.tencent.mm.g.b.a.ko;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import org.apache.commons.b.a;
import org.apache.commons.b.g;

final class p
{
  boolean oep = false;
  private Intent oeq = null;
  long oer;
  ko oes = null;
  LinkedHashSet<AppBrandRecentTaskInfo> oet = null;
  IListener<wu> oeu;
  
  private static int T(Intent paramIntent)
  {
    AppMethodBeat.i(49282);
    if (paramIntent != null) {}
    try
    {
      int i;
      if (paramIntent.getComponent() != null)
      {
        String str = paramIntent.getComponent().getShortClassName();
        boolean bool = Util.isNullOrNil(str);
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
      Log.e("MicroMsg.AppBrand.RecentsReporter", "makeFromMainFrameExitReportLeaveType e=%s", new Object[] { paramIntent });
      AppMethodBeat.o(49282);
    }
    return 0;
  }
  
  final void U(Intent paramIntent)
  {
    this.oeq = paramIntent;
    this.oep = true;
  }
  
  final void a(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(49281);
    Log.d("MicroMsg.AppBrand.RecentsReporter", "reportExitAction reason[%s]", new Object[] { paramString });
    if (this.oes != null)
    {
      long l = paramActivity.getIntent().getLongExtra("extra_start_activity_click_timestamp_ms", this.oer);
      paramActivity = this.oes;
      paramActivity.eWq = l;
      paramActivity.eWr = Util.nowMilliSecond();
      LinkedList localLinkedList;
      ArrayList localArrayList;
      int i;
      if (paramActivity.eWs <= 0L)
      {
        if ("onDestroy".equals(paramString)) {
          paramActivity.eWs = 1L;
        }
      }
      else
      {
        paramString = new String[4];
        localLinkedList = new LinkedList();
        localArrayList = new ArrayList(this.oet);
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
            paramActivity.eWs = T(this.oeq);
            break;
          }
        }
        paramString[i] = g.a(localLinkedList, "|");
        i += 1;
      }
      label204:
      this.oes.xW(paramString[0]);
      this.oes.xX(paramString[1]);
      this.oes.xY(paramString[2]);
      this.oes.xZ(paramString[3]);
      paramActivity.bfK();
      this.oes = null;
    }
    if (this.oeu != null)
    {
      this.oeu.dead();
      this.oeu = null;
    }
    AppMethodBeat.o(49281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.p
 * JD-Core Version:    0.7.0.1
 */