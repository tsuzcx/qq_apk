package c.t.m.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import java.util.Iterator;
import java.util.List;

final class dr$c
  extends Handler
{
  public dr$c(dr paramdr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message arg1)
  {
    Object localObject2 = ???.getData();
    if (localObject2 == null) {
      return;
    }
    int i;
    em localem;
    switch (???.what)
    {
    default: 
      return;
    case 3101: 
    case 3103: 
      i = ((Bundle)localObject2).getInt("error_code");
      localem = em.a;
      if (i == 0) {
        localem = (em)((Bundle)localObject2).getParcelable("tx_location");
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          if (???.what == 3101) {
            synchronized (dr.b(this.a))
            {
              localObject2 = dr.c(this.a);
              if (localObject2 == null) {
                break;
              }
              ((TencentLocationListener)localObject2).onLocationChanged(localem, i, (String)dr.c().get(i));
              return;
            }
          }
        }
        if ((???.what != 3103) || (dr.w(this.a) == null)) {
          break;
        }
        ??? = dr.w(this.a).iterator();
        while (???.hasNext())
        {
          localObject2 = (TencentLocationListener)???.next();
          if (localObject2 != null) {
            ((TencentLocationListener)localObject2).onLocationChanged(localTencentLocation, i, (String)dr.c().get(i));
          }
        }
        dr.w(this.a).clear();
        return;
        ??? = ((Bundle)localObject2).getString("name");
        i = ((Bundle)localObject2).getInt("status");
        localObject2 = ((Bundle)localObject2).getString("desc");
        synchronized (dr.b(this.a))
        {
          TencentLocationListener localTencentLocationListener = dr.c(this.a);
          if (localTencentLocationListener == null) {
            break;
          }
          localTencentLocationListener.onStatusUpdate(???, i, (String)localObject2);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.g.dr.c
 * JD-Core Version:    0.7.0.1
 */