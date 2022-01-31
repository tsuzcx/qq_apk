package com.google.android.gms.tagmanager;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

class zza$1
  implements zza.zza
{
  zza$1(zza paramzza) {}
  
  public AdvertisingIdClient.Info zzPZ()
  {
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza.zza(this.zzbEO));
      return localInfo;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      zzbo.zzc("IllegalStateException getting Advertising Id Info", localIllegalStateException);
      return null;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      zzbo.zzc("GooglePlayServicesRepairableException getting Advertising Id Info", localGooglePlayServicesRepairableException);
      return null;
    }
    catch (IOException localIOException)
    {
      zzbo.zzc("IOException getting Ad Id Info", localIOException);
      return null;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      zzbo.zzc("GooglePlayServicesNotAvailableException getting Advertising Id Info", localGooglePlayServicesNotAvailableException);
      return null;
    }
    catch (Exception localException)
    {
      zzbo.zzc("Unknown exception. Could not get the Advertising Id Info.", localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zza.1
 * JD-Core Version:    0.7.0.1
 */