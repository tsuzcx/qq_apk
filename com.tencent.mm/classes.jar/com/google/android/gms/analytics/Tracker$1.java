package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsb;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.internal.zztb;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zztm;
import java.util.HashMap;
import java.util.Map;

class Tracker$1
  implements Runnable
{
  Tracker$1(Tracker paramTracker, Map paramMap, boolean paramBoolean1, String paramString1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString2) {}
  
  public void run()
  {
    boolean bool = true;
    if (Tracker.zza(this.zzacF).zzmV()) {
      this.zzacy.put("sc", "start");
    }
    zztm.zzd(this.zzacy, "cid", this.zzacF.zzmu().zzmy());
    Object localObject = (String)this.zzacy.get("sf");
    if (localObject != null)
    {
      double d = zztm.zza((String)localObject, 100.0D);
      if (zztm.zza(d, (String)this.zzacy.get("cid")))
      {
        this.zzacF.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d));
        return;
      }
    }
    localObject = Tracker.zzb(this.zzacF);
    if (this.zzacz)
    {
      zztm.zzb(this.zzacy, "ate", ((zzrx)localObject).zznw());
      zztm.zzc(this.zzacy, "adid", ((zzrx)localObject).zznG());
      localObject = Tracker.zzc(this.zzacF).zzoy();
      zztm.zzc(this.zzacy, "an", ((zzrk)localObject).zzmY());
      zztm.zzc(this.zzacy, "av", ((zzrk)localObject).zzmZ());
      zztm.zzc(this.zzacy, "aid", ((zzrk)localObject).zzke());
      zztm.zzc(this.zzacy, "aiid", ((zzrk)localObject).zzna());
      this.zzacy.put("v", "1");
      this.zzacy.put("_v", zzsb.zzadQ);
      zztm.zzc(this.zzacy, "ul", Tracker.zzd(this.zzacF).zzpB().getLanguage());
      zztm.zzc(this.zzacy, "sr", Tracker.zze(this.zzacF).zzpC());
      if ((!this.zzacA.equals("transaction")) && (!this.zzacA.equals("item"))) {
        break label383;
      }
    }
    label383:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (Tracker.zzf(this.zzacF).zzpV())) {
        break label388;
      }
      Tracker.zzg(this.zzacF).zzg(this.zzacy, "Too many hits sent too quickly, rate limiting invoked");
      return;
      this.zzacy.remove("ate");
      this.zzacy.remove("adid");
      break;
    }
    label388:
    long l2 = zztm.zzcf((String)this.zzacy.get("ht"));
    long l1 = l2;
    if (l2 == 0L) {
      l1 = this.zzacB;
    }
    if (this.zzacC)
    {
      localObject = new zzsz(this.zzacF, this.zzacy, l1, this.zzacD);
      Tracker.zzh(this.zzacF).zzc("Dry run enabled. Would have sent hit", localObject);
      return;
    }
    localObject = (String)this.zzacy.get("cid");
    HashMap localHashMap = new HashMap();
    zztm.zza(localHashMap, "uid", this.zzacy);
    zztm.zza(localHashMap, "an", this.zzacy);
    zztm.zza(localHashMap, "aid", this.zzacy);
    zztm.zza(localHashMap, "av", this.zzacy);
    zztm.zza(localHashMap, "aiid", this.zzacy);
    String str = this.zzacE;
    if (!TextUtils.isEmpty((CharSequence)this.zzacy.get("adid"))) {}
    for (;;)
    {
      localObject = new zzse(0L, (String)localObject, str, bool, 0L, localHashMap);
      l2 = Tracker.zzi(this.zzacF).zza((zzse)localObject);
      this.zzacy.put("_s", String.valueOf(l2));
      localObject = new zzsz(this.zzacF, this.zzacy, l1, this.zzacD);
      Tracker.zzj(this.zzacF).zza((zzsz)localObject);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.analytics.Tracker.1
 * JD-Core Version:    0.7.0.1
 */