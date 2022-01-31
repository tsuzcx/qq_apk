package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class h$8
  implements n.c
{
  h$8(h paramh) {}
  
  public final void a(l paraml)
  {
    if (this.lKp.lKC) {
      paraml.a(1, this.lKp.getString(a.h.location_street_view), 0);
    }
    Object localObject1 = this.lKp;
    Object localObject2 = this.lKp.lHY;
    Object localObject3 = this.lKp.lHZ;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("com.tencent.map");
    localArrayList.add("com.google.android.apps.maps");
    localArrayList.add("com.baidu.BaiduMap");
    localArrayList.add("com.autonavi.minimap");
    localArrayList.add("com.sogou.map.android.maps");
    Object localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Double.valueOf(((LocationInfo)localObject3).lCJ), Double.valueOf(((LocationInfo)localObject3).lCK) })));
    Object localObject5 = ((d)localObject2).context.getPackageManager();
    localObject3 = new HashMap();
    localObject4 = ((PackageManager)localObject5).queryIntentActivities((Intent)localObject4, 65536).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (ResolveInfo)((Iterator)localObject4).next();
      if (localArrayList.contains(((ResolveInfo)localObject5).activityInfo.packageName)) {
        ((Map)localObject3).put(((ResolveInfo)localObject5).activityInfo.packageName, ((ResolveInfo)localObject5).activityInfo.loadLabel(((d)localObject2).context.getPackageManager()).toString());
      }
    }
    ((h)localObject1).lKn = ((Map)localObject3);
    if ((!e.cqq()) && ((this.lKp.lKo < 4) || (h.a(this.lKp)))) {
      paraml.ak(2, a.h.tencent_map_label, 0);
    }
    localObject1 = this.lKp.lKn.entrySet().iterator();
    int i = 3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (!((String)((Map.Entry)localObject2).getKey()).equals("com.tencent.map")) {
        paraml.a(i, (CharSequence)((Map.Entry)localObject2).getValue(), 0);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.8
 * JD-Core Version:    0.7.0.1
 */