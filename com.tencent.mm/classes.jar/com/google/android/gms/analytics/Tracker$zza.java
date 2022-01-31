package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zztl;
import java.util.HashMap;
import java.util.Map;

class Tracker$zza
  extends zzsa
  implements GoogleAnalytics.zza
{
  private boolean zzacG;
  private int zzacH;
  private long zzacI = -1L;
  private boolean zzacJ;
  private long zzacK;
  
  protected Tracker$zza(Tracker paramTracker, zzsc paramzzsc)
  {
    super(paramzzsc);
  }
  
  private void zzmW()
  {
    if ((this.zzacI >= 0L) || (this.zzacG))
    {
      zzmu().zza(Tracker.zza(this.zzacF));
      return;
    }
    zzmu().zzb(Tracker.zza(this.zzacF));
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    this.zzacG = paramBoolean;
    zzmW();
  }
  
  public void setSessionTimeout(long paramLong)
  {
    this.zzacI = paramLong;
    zzmW();
  }
  
  protected void zzmS() {}
  
  public boolean zzmV()
  {
    try
    {
      boolean bool = this.zzacJ;
      this.zzacJ = false;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean zzmX()
  {
    return zznR().elapsedRealtime() >= this.zzacK + Math.max(1000L, this.zzacI);
  }
  
  public void zzo(Activity paramActivity)
  {
    if ((this.zzacH == 0) && (zzmX())) {
      this.zzacJ = true;
    }
    this.zzacH += 1;
    HashMap localHashMap;
    Tracker localTracker;
    if (this.zzacG)
    {
      localObject = paramActivity.getIntent();
      if (localObject != null) {
        this.zzacF.setCampaignParamsOnNextHit(((Intent)localObject).getData());
      }
      localHashMap = new HashMap();
      localHashMap.put("&t", "screenview");
      localTracker = this.zzacF;
      if (Tracker.zzk(this.zzacF) == null) {
        break label159;
      }
    }
    label159:
    for (Object localObject = Tracker.zzk(this.zzacF).zzr(paramActivity);; localObject = paramActivity.getClass().getCanonicalName())
    {
      localTracker.set("&cd", (String)localObject);
      if (TextUtils.isEmpty((CharSequence)localHashMap.get("&dr")))
      {
        paramActivity = Tracker.zzq(paramActivity);
        if (!TextUtils.isEmpty(paramActivity)) {
          localHashMap.put("&dr", paramActivity);
        }
      }
      this.zzacF.send(localHashMap);
      return;
    }
  }
  
  public void zzp(Activity paramActivity)
  {
    this.zzacH -= 1;
    this.zzacH = Math.max(0, this.zzacH);
    if (this.zzacH == 0) {
      this.zzacK = zznR().elapsedRealtime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.analytics.Tracker.zza
 * JD-Core Version:    0.7.0.1
 */