package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.tencentmap.lbssdk.service.e;
import org.json.JSONException;

final class dr$a
  extends Handler
{
  private long a = 0L;
  private boolean b = false;
  private boolean c = false;
  private int d = 0;
  
  dr$a(dr paramdr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(int paramInt)
  {
    if (dr.w(this.e) != null)
    {
      if (dr.h(this.e) != 0) {
        break label82;
      }
      dr.a(this.e, dr.g(this.e), dr.h(this.e), 3103);
    }
    for (;;)
    {
      dr.x(this.e);
      if (dr.d(this.e) == dr.b.c)
      {
        this.e.a();
        j.a("TxLocationManagerImpl", 6, "remove update!");
      }
      return;
      label82:
      dr.a(this.e, em.a, paramInt, 3103);
    }
  }
  
  private static void a(em paramem, String paramString)
  {
    j.a("TxLocCallback", 4, String.format("%s,%.6f,%.6f,%.1f", new Object[] { paramString, Double.valueOf(paramem.getLatitude()), Double.valueOf(paramem.getLongitude()), Float.valueOf(paramem.getAccuracy()) }));
  }
  
  private void b(int paramInt)
  {
    Object localObject1 = dr.y(this.e).a();
    Location localLocation;
    Object localObject2;
    double d2;
    double d1;
    if ((localObject1 != do.a) && (dr.j(this.e) == 0L) && (System.currentTimeMillis() - ((Location)localObject1).getTime() <= 120000L))
    {
      localLocation = new Location((Location)localObject1);
      localObject2 = localLocation.getExtras();
      if (localObject2 == null) {
        break label237;
      }
      d2 = ((Bundle)localObject2).getDouble("lat");
      d1 = ((Bundle)localObject2).getDouble("lng");
    }
    for (;;)
    {
      localObject2 = new em.a();
      ((em.a)localObject2).d = "network";
      localObject1 = ((em.a)localObject2).a((Location)localObject1).a();
      if (dr.l(this.e) == 1)
      {
        localLocation.setLatitude(d2);
        localLocation.setLongitude(d1);
        ((em)localObject1).a(localLocation);
      }
      if (!dr.s(this.e)) {
        dr.a(this.e, 0, (em)localObject1);
      }
      a(0);
      return;
      if ((dr.h(this.e) == 0) && (dr.g(this.e) != null) && (System.currentTimeMillis() - dr.g(this.e).getTime() < 60000L))
      {
        a(0);
        return;
      }
      dr.a(this.e, paramInt, em.a);
      a(paramInt);
      return;
      label237:
      d1 = 0.0D;
      d2 = 0.0D;
    }
  }
  
  public final void a()
  {
    this.d = 0;
    removeCallbacksAndMessages(null);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int k = 1;
    int j = 1;
    int i;
    int m;
    long l1;
    Object localObject2;
    synchronized (dr.b(this.e))
    {
      if (dr.c(this.e) == null) {
        break label1760;
      }
      i = 1;
      if ((i == 0) && (dr.d(this.e) == dr.b.a)) {
        return;
      }
      ??? = dr.e(this.e);
      m = ((TencentLocationRequest)???).getRequestLevel();
      l1 = dr.f(this.e);
      try
      {
        switch (paramMessage.what)
        {
        case 554: 
          paramMessage = paramMessage.getData();
          if (paramMessage == null) {
            break label1759;
          }
          paramMessage = paramMessage.getString("WIFIS");
          if (TextUtils.isEmpty(paramMessage)) {
            break label1759;
          }
          ??? = dr.o(this.e);
          try
          {
            if (TextUtils.isEmpty(paramMessage)) {
              break label1759;
            }
            localObject2 = j.b(paramMessage.getBytes("UTF-8"));
            e.o((byte[])localObject2, 2);
            localObject2 = new dv.a(3, (byte[])localObject2, "https://ue.indoorloc.map.qq.com/?wl", null);
            ((dv.a)localObject2).b = paramMessage;
            ((dv)???).a((dv.a)localObject2);
            return;
          }
          catch (Throwable paramMessage)
          {
            j.a("TxRequestSender", "", paramMessage);
            return;
          }
          paramMessage = finally;
        }
      }
      catch (Throwable paramMessage)
      {
        return;
      }
    }
    if ((dr.g(this.e) != null) && (((TencentLocationRequest)???).getInterval() > 0L))
    {
      dr.a(this.e, dr.g(this.e));
      dr.a(this.e, dr.g(this.e), dr.h(this.e), 3101);
      a(dr.g(this.e), "timed");
    }
    if (l1 > 0L)
    {
      sendEmptyMessageDelayed(11999, l1);
      return;
      if (dr.g(this.e) != null)
      {
        dr.a(this.e, dr.g(this.e));
        dr.a(this.e, dr.g(this.e), dr.h(this.e), 3101);
        a(dr.g(this.e), "direct");
        return;
        if (!dr.i(this.e))
        {
          l1 = Math.max(dr.e(this.e).getInterval(), 4000L);
          if ((dr.j(this.e) != 0L) && (System.currentTimeMillis() - dr.j(this.e) >= l1))
          {
            j.a("TxLocationManagerImpl", 4, "network connected --> prepare json");
            removeMessages(3999);
            if (dr.d(this.e) != dr.b.b)
            {
              dr.b();
              k = dr.l(this.e);
              paramMessage = dr.m(this.e);
              if ((!paramMessage.a()) || (System.currentTimeMillis() - this.a <= 60000L)) {
                break label776;
              }
              this.b = true;
              this.c = false;
              this.a = System.currentTimeMillis();
            }
            Object localObject3;
            label615:
            long l2;
            for (;;)
            {
              localObject2 = dr.n(this.e);
              localObject3 = dr.a(this.e);
              boolean bool2 = this.b;
              boolean bool3 = this.c;
              if (dr.d(this.e) != dr.b.b) {
                break label1766;
              }
              bool1 = true;
              localObject2 = paramMessage.a(m, (String)localObject2, (dg)localObject3, bool2, bool3, bool1);
              if (j.d((String)localObject2)) {
                break label1772;
              }
              i = j;
              label643:
              if (i == 0) {
                break label784;
              }
              j.a("TxLocationManagerImpl", 6, "handleMessage: bad json ");
              b(2);
              return;
              l2 = de.a().c("up_daemon_delay");
              l1 = l2;
              if (l2 < 120000L) {
                l1 = 120000L;
              }
              j.a("TxLocationManagerImpl", 6, "the daemonLocation,so we delay long time upload:" + l1 + "," + System.currentTimeMillis() + "," + dr.k(this.e));
              if (System.currentTimeMillis() - dr.k(this.e) < l1) {
                break label1759;
              }
              dr.a(this.e, System.currentTimeMillis());
              break;
              label776:
              this.b = false;
            }
            label784:
            if ((dr.d(this.e) == dr.b.a) && (TencentExtraKeys.isRequestRawData((TencentLocationRequest)???)))
            {
              paramMessage = new em.a();
              paramMessage.b = null;
              paramMessage.c = m;
              paramMessage = paramMessage.a();
              TencentExtraKeys.setRawData(paramMessage, ((String)localObject2).getBytes());
              dr.a(this.e, paramMessage);
              dr.a(this.e, paramMessage, 0, 3101);
              return;
            }
            if (TencentExtraKeys.MOCK_LOCATION_FILTER)
            {
              dr.o(this.e).a((String)localObject2, paramMessage, k);
              return;
              paramMessage = dr.m(this.e);
              ??? = paramMessage.a(m, dr.n(this.e), dr.a(this.e), false, false, false);
              if (j.d((String)???)) {
                break label1777;
              }
              i = k;
              label926:
              if (i != 0)
              {
                j.a("TxLocationManagerImpl", 6, "handleMessage: bad json " + (String)???);
                b(2);
                return;
              }
              dr.o(this.e).a((String)???, paramMessage, dr.l(this.e));
              return;
              if (dr.r(this.e).m == 0L)
              {
                l1 = System.currentTimeMillis();
                l2 = dr.r(this.e).l;
                dr.r(this.e).m = (l1 - l2);
              }
              removeMessages(4998);
              ??? = (Pair)paramMessage.obj;
              localObject2 = ((Pair)???).first.toString();
              localObject3 = (dv.a)((Pair)???).second;
              ec localec = (ec)((dv.a)localObject3).a;
              dr.a(this.e, localec.b);
              String str = ((dv.a)localObject3).b;
              if (!localec.a()) {
                break label1782;
              }
              ??? = "gps";
              try
              {
                label1108:
                em.a locala = new em.a();
                locala.a = ((String)localObject2);
                locala.c = m;
                locala.d = ((String)???);
                ??? = locala.a();
                ((em)???).getExtra().putString("resp_json", (String)localObject2);
                if (((em)???).isMockGps() == 1) {
                  this.c = true;
                }
                em.a((em)???);
              }
              catch (JSONException paramMessage)
              {
                label1201:
                j.a("TxLocationManagerImpl", 6, "handleMessage: location failed");
                label1315:
                b(404);
                return;
              }
              try
              {
                TencentExtraKeys.setRawQuery((TencentLocation)???, str);
                if (localec.c == null) {
                  break label1754;
                }
                i = localec.c.c;
                ((em)???).getExtra().putInt("sat_num", i);
                ((em)???).getExtra().putLong("req_cost", paramMessage.arg1);
                ((em)???).getExtra().putLong("req_start", ((dv.a)localObject3).c);
                if (de.a().d("callback_wifis"))
                {
                  ((em)???).getExtra().putLong("wifi_collect_time", ((dv.a)localObject3).c);
                  ((em)???).getExtra().putString("wlan", es.c(dr.a(this.e)));
                  ((em)???).getExtra().putString("wifis", dr.p(this.e).i);
                }
              }
              catch (Throwable paramMessage)
              {
                j.a("TxLocationManagerImpl", 6, paramMessage.toString());
                break label1315;
                dr.a(this.e, (em)???, 0, 3101);
                this.d = 0;
                break label1448;
              }
              dr.b(this.e, System.currentTimeMillis());
              if (TextUtils.isEmpty(((em)???).getIndoorBuildingId())) {
                break label1789;
              }
            }
          }
        }
      }
    }
    label1448:
    label1754:
    label1759:
    label1760:
    label1766:
    label1772:
    label1777:
    label1782:
    label1789:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((bool1) && (dr.q(this.e) == 1))
      {
        dr.p(this.e).a(0L);
        dr.p(this.e).j = 4000L;
        if (dr.e(this.e).getInterval() > 4000L) {
          dr.c(this.e, 4000L);
        }
        dr.a(this.e, 2);
        this.d = 0;
      }
      if (dr.q(this.e) == 2)
      {
        if (bool1) {
          break label1671;
        }
        this.d += 1;
        if (this.d >= 5)
        {
          dr.p(this.e).j = dr.r(this.e).k;
          j.a("TxLocationManagerImpl", 6, "indoor stop," + dr.e(this.e).getInterval());
          dr.c(this.e, dr.e(this.e).getInterval());
          dr.a(this.e, 1);
          this.d = 0;
        }
      }
      if ((!dr.s(this.e)) || ((bool1) && (dr.q(this.e) > 0)))
      {
        em.a((em)???, bool1);
        dr.a(this.e, 0, (em)???);
      }
      a(0);
      dr.b(this.e, (em)???);
      if ((dr.d(this.e) == dr.b.a) && (!dr.t(this.e)))
      {
        dd.a().b();
        dr.u(this.e);
        return;
        if (dr.r(this.e).m == 0L) {
          dr.r(this.e).m = -1L;
        }
        b(1);
        dr.b(this.e, -1L);
        return;
        dr.v(this.e);
        sendEmptyMessage(3999);
        return;
        i = 0;
        break label1201;
      }
      return;
      i = 0;
      break;
      return;
      bool1 = false;
      break label615;
      i = 0;
      break label643;
      i = 0;
      break label926;
      ??? = "network";
      break label1108;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.dr.a
 * JD-Core Version:    0.7.0.1
 */