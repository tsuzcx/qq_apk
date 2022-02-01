package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class q$2
  implements o.f
{
  q$2(q paramq, s params, double paramDouble1, double paramDouble2) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(226850);
    Object localObject1 = this.lXn;
    Object localObject2 = this.lsQ.ay(Activity.class);
    double d1 = this.iVE;
    double d2 = this.iVF;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("com.tencent.map");
    localArrayList.add("com.google.android.apps.maps");
    localArrayList.add("com.baidu.BaiduMap");
    localArrayList.add("com.autonavi.minimap");
    localArrayList.add("com.sogou.map.android.maps");
    Object localObject3 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) })));
    Object localObject4 = ((Context)localObject2).getPackageManager();
    HashMap localHashMap = new HashMap();
    localObject3 = ((PackageManager)localObject4).queryIntentActivities((Intent)localObject3, 65536).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (ResolveInfo)((Iterator)localObject3).next();
      if (localArrayList.contains(((ResolveInfo)localObject4).activityInfo.packageName)) {
        localHashMap.put(((ResolveInfo)localObject4).activityInfo.packageName, ((ResolveInfo)localObject4).activityInfo.loadLabel(((Context)localObject2).getPackageManager()).toString());
      }
    }
    ((q)localObject1).lXj = localHashMap;
    if (!ChannelUtil.isGPVersion()) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (i == 0)
      {
        j = i;
        if (q.a(this.lXn)) {
          j = 1;
        }
      }
      if (j != 0) {
        paramm.aS(2, 2131766704, 0);
      }
      localObject1 = this.lXn.lXj.entrySet().iterator();
      i = 3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (!((String)((Map.Entry)localObject2).getKey()).equals("com.tencent.map")) {
          paramm.b(i, (CharSequence)((Map.Entry)localObject2).getValue(), 0);
        }
        i += 1;
      }
      AppMethodBeat.o(226850);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.q.2
 * JD-Core Version:    0.7.0.1
 */