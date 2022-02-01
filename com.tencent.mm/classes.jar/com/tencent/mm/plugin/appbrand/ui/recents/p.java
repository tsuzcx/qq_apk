package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.g.b.a.gz;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import org.apache.commons.b.a;
import org.apache.commons.b.g;

final class p
{
  boolean mRm = false;
  private Intent mRn = null;
  long mRo;
  gz mRp = null;
  LinkedHashSet<AppBrandRecentTaskInfo> mRq = null;
  c<vu> mRr;
  
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
        boolean bool = bu.isNullOrNil(str);
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
      ae.e("MicroMsg.AppBrand.RecentsReporter", "makeFromMainFrameExitReportLeaveType e=%s", new Object[] { paramIntent });
      AppMethodBeat.o(49282);
    }
    return 0;
  }
  
  final void V(Intent paramIntent)
  {
    this.mRn = paramIntent;
    this.mRm = true;
  }
  
  final void a(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(49281);
    ae.d("MicroMsg.AppBrand.RecentsReporter", "reportExitAction reason[%s]", new Object[] { paramString });
    if (this.mRp != null)
    {
      long l = paramActivity.getIntent().getLongExtra("extra_start_activity_click_timestamp_ms", this.mRo);
      paramActivity = this.mRp;
      paramActivity.esp = l;
      paramActivity.esq = bu.fpO();
      LinkedList localLinkedList;
      ArrayList localArrayList;
      int i;
      if (paramActivity.esr <= 0L)
      {
        if ("onDestroy".equals(paramString)) {
          paramActivity.esr = 1L;
        }
      }
      else
      {
        paramString = new String[4];
        localLinkedList = new LinkedList();
        localArrayList = new ArrayList(this.mRq);
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
            paramActivity.esr = U(this.mRn);
            break;
          }
        }
        paramString[i] = g.a(localLinkedList, "|");
        i += 1;
      }
      label204:
      this.mRp.qk(paramString[0]);
      this.mRp.ql(paramString[1]);
      this.mRp.qm(paramString[2]);
      this.mRp.qn(paramString[3]);
      paramActivity.aLH();
      this.mRp = null;
    }
    if (this.mRr != null)
    {
      this.mRr.dead();
      this.mRr = null;
    }
    AppMethodBeat.o(49281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.p
 * JD-Core Version:    0.7.0.1
 */