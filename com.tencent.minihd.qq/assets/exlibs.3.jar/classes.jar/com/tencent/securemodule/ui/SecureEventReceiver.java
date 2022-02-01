package com.tencent.securemodule.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.securemodule.impl.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import sm.ay;

public class SecureEventReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d("", "dafsdjflkjewoqiruoeiuroiqjdfklajsdlkj");
    if ("1000020".equals(paramIntent.getAction())) {
      ay.a(paramContext);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if ("1000021".equals(paramIntent.getAction()))
              {
                ay.b(paramContext);
                return;
              }
              if (!"1000022".equals(paramIntent.getAction())) {
                break;
              }
              paramIntent = (ArrayList)paramIntent.getSerializableExtra("data");
              if ((paramIntent != null) && (paramIntent.size() > 0))
              {
                ay.a(paramContext, paramIntent.size());
                paramIntent = paramIntent.iterator();
                while (paramIntent.hasNext()) {
                  ay.a(paramContext, (AppInfo)paramIntent.next());
                }
              }
            }
            if ("1000023".equals(paramIntent.getAction()))
            {
              ay.c(paramContext);
              return;
            }
            if (!"1000024".equals(paramIntent.getAction())) {
              break;
            }
          } while (paramIntent.getBooleanExtra("key_download_listener", false));
          ay.f(paramContext);
          return;
          if (!"1000025".equals(paramIntent.getAction())) {
            break;
          }
        } while (paramIntent.getBooleanExtra("key_download_listener", false));
        ay.a(paramContext, paramIntent.getBundleExtra("data"));
        return;
        if (!"1000027".equals(paramIntent.getAction())) {
          break;
        }
      } while (paramIntent.getBooleanExtra("key_download_listener", false));
      ay.b(paramContext, paramIntent.getBundleExtra("data"));
      return;
    } while ((!"1000026".equals(paramIntent.getAction())) || (paramIntent.getBooleanExtra("key_download_listener", false)));
    ay.e(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.securemodule.ui.SecureEventReceiver
 * JD-Core Version:    0.7.0.1
 */