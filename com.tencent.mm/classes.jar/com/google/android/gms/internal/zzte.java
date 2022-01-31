package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzac;

class zzte
  extends BroadcastReceiver
{
  static final String zzagv = zzte.class.getName();
  private final zzsc zzadO;
  private boolean zzagw;
  private boolean zzagx;
  
  zzte(zzsc paramzzsc)
  {
    zzac.zzw(paramzzsc);
    this.zzadO = paramzzsc;
  }
  
  private Context getContext()
  {
    return this.zzadO.getContext();
  }
  
  private zzry zzmA()
  {
    return this.zzadO.zzmA();
  }
  
  private zztd zznS()
  {
    return this.zzadO.zznS();
  }
  
  private void zzpY()
  {
    zznS();
    zzmA();
  }
  
  public boolean isConnected()
  {
    if (!this.zzagw) {
      this.zzadO.zznS().zzbS("Connectivity unknown. Receiver not registered");
    }
    return this.zzagx;
  }
  
  public boolean isRegistered()
  {
    return this.zzagw;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    zzpY();
    paramContext = paramIntent.getAction();
    this.zzadO.zznS().zza("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = zzqa();
      if (this.zzagx != bool)
      {
        this.zzagx = bool;
        zzmA().zzW(bool);
      }
    }
    do
    {
      return;
      if (!"com.google.analytics.RADIO_POWERED".equals(paramContext)) {
        break;
      }
    } while (paramIntent.hasExtra(zzagv));
    zzmA().zznO();
    return;
    this.zzadO.zznS().zzd("NetworkBroadcastReceiver received unknown action", paramContext);
  }
  
  public void unregister()
  {
    if (!isRegistered()) {
      return;
    }
    this.zzadO.zznS().zzbP("Unregistering connectivity change receiver");
    this.zzagw = false;
    this.zzagx = false;
    Context localContext = getContext();
    try
    {
      localContext.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zznS().zze("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
  
  public void zzpX()
  {
    zzpY();
    if (this.zzagw) {
      return;
    }
    Context localContext = getContext();
    localContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    IntentFilter localIntentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
    localIntentFilter.addCategory(localContext.getPackageName());
    localContext.registerReceiver(this, localIntentFilter);
    this.zzagx = zzqa();
    this.zzadO.zznS().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzagx));
    this.zzagw = true;
  }
  
  public void zzpZ()
  {
    int i = Build.VERSION.SDK_INT;
    Context localContext = getContext();
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(localContext.getPackageName());
    localIntent.putExtra(zzagv, true);
    localContext.sendOrderedBroadcast(localIntent, null);
  }
  
  protected boolean zzqa()
  {
    Object localObject = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        boolean bool = ((NetworkInfo)localObject).isConnected();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (SecurityException localSecurityException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzte
 * JD-Core Version:    0.7.0.1
 */