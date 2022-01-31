package com.facebook.appevents;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppEventsLogger$3
  implements Runnable
{
  AppEventsLogger$3(AppEventsLogger paramAppEventsLogger) {}
  
  public final void run()
  {
    AppMethodBeat.i(71908);
    Bundle localBundle = new Bundle();
    try
    {
      Class.forName("com.facebook.core.Core");
      localBundle.putInt("core_lib_included", 1);
      try
      {
        label26:
        Class.forName("com.facebook.login.Login");
        localBundle.putInt("login_lib_included", 1);
        try
        {
          label39:
          Class.forName("com.facebook.share.Share");
          localBundle.putInt("share_lib_included", 1);
          try
          {
            label52:
            Class.forName("com.facebook.places.Places");
            localBundle.putInt("places_lib_included", 1);
            try
            {
              label65:
              Class.forName("com.facebook.messenger.Messenger");
              localBundle.putInt("messenger_lib_included", 1);
              try
              {
                label78:
                Class.forName("com.facebook.applinks.AppLinks");
                localBundle.putInt("applinks_lib_included", 1);
                try
                {
                  label91:
                  Class.forName("com.facebook.marketing.Marketing");
                  localBundle.putInt("marketing_lib_included", 1);
                  try
                  {
                    label104:
                    Class.forName("com.facebook.all.All");
                    localBundle.putInt("all_lib_included", 1);
                    try
                    {
                      label117:
                      Class.forName("com.android.billingclient.api.BillingClient");
                      localBundle.putInt("billing_client_lib_included", 1);
                      try
                      {
                        label130:
                        Class.forName("com.android.vending.billing.IInAppBillingService");
                        localBundle.putInt("billing_service_lib_included", 1);
                        label143:
                        this.val$logger.logSdkEvent("fb_sdk_initialize", null, localBundle);
                        AppMethodBeat.o(71908);
                        return;
                      }
                      catch (ClassNotFoundException localClassNotFoundException1)
                      {
                        break label143;
                      }
                    }
                    catch (ClassNotFoundException localClassNotFoundException2)
                    {
                      break label130;
                    }
                  }
                  catch (ClassNotFoundException localClassNotFoundException3)
                  {
                    break label117;
                  }
                }
                catch (ClassNotFoundException localClassNotFoundException4)
                {
                  break label104;
                }
              }
              catch (ClassNotFoundException localClassNotFoundException5)
              {
                break label91;
              }
            }
            catch (ClassNotFoundException localClassNotFoundException6)
            {
              break label78;
            }
          }
          catch (ClassNotFoundException localClassNotFoundException7)
          {
            break label65;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException8)
        {
          break label52;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException9)
      {
        break label39;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException10)
    {
      break label26;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.appevents.AppEventsLogger.3
 * JD-Core Version:    0.7.0.1
 */