package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.b.a.gx;
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
  boolean mMj = false;
  private Intent mMk = null;
  long mMl;
  gx mMm = null;
  LinkedHashSet<AppBrandRecentTaskInfo> mMn = null;
  c<vq> mMo;
  
  private static int U(Intent paramIntent)
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
  
  final void V(Intent paramIntent)
  {
    this.mMk = paramIntent;
    this.mMj = true;
  }
  
  final void a(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(49281);
    ad.d("MicroMsg.AppBrand.RecentsReporter", "reportExitAction reason[%s]", new Object[] { paramString });
    if (this.mMm != null)
    {
      long l = paramActivity.getIntent().getLongExtra("extra_start_activity_click_timestamp_ms", this.mMl);
      paramActivity = this.mMm;
      paramActivity.eqI = l;
      paramActivity.eqJ = bt.flT();
      LinkedList localLinkedList;
      ArrayList localArrayList;
      int i;
      if (paramActivity.eqK <= 0L)
      {
        if ("onDestroy".equals(paramString)) {
          paramActivity.eqK = 1L;
        }
      }
      else
      {
        paramString = new String[4];
        localLinkedList = new LinkedList();
        localArrayList = new ArrayList(this.mMn);
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
            paramActivity.eqK = U(this.mMk);
            break;
          }
        }
        paramString[i] = g.a(localLinkedList, "|");
        i += 1;
      }
      label204:
      this.mMm.pP(paramString[0]);
      this.mMm.pQ(paramString[1]);
      this.mMm.pR(paramString[2]);
      this.mMm.pS(paramString[3]);
      paramActivity.aLk();
      this.mMm = null;
    }
    if (this.mMo != null)
    {
      this.mMo.dead();
      this.mMo = null;
    }
    AppMethodBeat.o(49281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.p
 * JD-Core Version:    0.7.0.1
 */