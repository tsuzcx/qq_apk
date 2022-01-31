package com.tencent.mm.plugin.appbrand.v.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Collection;
import java.util.List;

abstract class a$b
{
  public final boolean aqB()
  {
    List localList = ae.getContext().getPackageManager().queryIntentActivities(aqC(), 0);
    if ((localList == null) || (localList.isEmpty())) {}
    for (int i = 1; (i == 0) && (((ResolveInfo)localList.get(0)).activityInfo.exported); i = 0) {
      return true;
    }
    return false;
  }
  
  protected abstract Intent aqC();
  
  public final void cC(Context paramContext)
  {
    Intent localIntent = aqC();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.a.b
 * JD-Core Version:    0.7.0.1
 */