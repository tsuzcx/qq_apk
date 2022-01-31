package com.tencent.mm.plugin.appbrand.v.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.y;

final class b
  implements e
{
  private final IntentFilter bcd = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  private final d hlN = new d();
  Intent hlO = null;
  final e hlP = this;
  private b.a hlQ;
  protected Context mContext;
  
  public final c aqx()
  {
    boolean bool2 = true;
    int j = -1;
    for (;;)
    {
      boolean bool1;
      try
      {
        if (this.mContext == null)
        {
          y.e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no context");
          localObject1 = a.hlK;
          return localObject1;
        }
        Object localObject1 = this.mContext;
        if (this.hlO != null)
        {
          localObject1 = this.hlO;
          if (localObject1 == null)
          {
            y.e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no intent got");
            localObject1 = a.hlK;
          }
        }
        else
        {
          this.hlQ = new b.a(this, (byte)0);
          localObject1 = ((Context)localObject1).getApplicationContext().registerReceiver(this.hlQ, this.bcd);
          this.hlO = ((Intent)localObject1);
          continue;
        }
        c localc = new c();
        if (localObject1 == null)
        {
          i = j;
          localc.hlT = i;
          if (localObject1 == null) {
            break label279;
          }
          i = ((Intent)localObject1).getIntExtra("status", -1);
          j = ((Intent)localObject1).getIntExtra("plugged", 0);
          bool1 = bool2;
          if (i != 2)
          {
            bool1 = bool2;
            if (j != 1)
            {
              bool1 = bool2;
              if (j != 2)
              {
                if ((Build.VERSION.SDK_INT < 17) || (j != 4)) {
                  break label279;
                }
                bool1 = bool2;
              }
            }
          }
          localc.hlS = bool1;
          localObject1 = localc;
          continue;
        }
        k = localObject2.getIntExtra("level", -1);
      }
      finally {}
      int k;
      int m = localObject2.getIntExtra("scale", -1);
      int i = j;
      if (m > 0)
      {
        i = j;
        if (k >= 0)
        {
          i = Math.min(Math.max((int)Math.floor(k * 100.0F / m), 0), 100);
          continue;
          label279:
          bool1 = false;
        }
      }
    }
  }
  
  public final void init(Context paramContext)
  {
    try
    {
      this.hlO = null;
      this.mContext = paramContext.getApplicationContext();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void release()
  {
    try
    {
      if (this.mContext != null)
      {
        if (this.hlQ != null) {
          this.mContext.unregisterReceiver(this.hlQ);
        }
        this.mContext = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a.b
 * JD-Core Version:    0.7.0.1
 */