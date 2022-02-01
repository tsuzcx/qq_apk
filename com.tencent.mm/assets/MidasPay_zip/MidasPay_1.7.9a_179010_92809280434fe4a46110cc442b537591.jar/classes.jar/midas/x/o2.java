package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class o2
  extends y1
{
  public o2()
  {
    a("https", String.format("/v1/r/%s/mobile_get_key", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void D()
  {
    super.D();
    APLog.d("APGetKeyReq", "On encode start, add get key parameters");
    if (z())
    {
      APLog.d("APGetKeyReq", "On encode start, add encrypt type = secret");
      b("type", "secret");
    }
    else if (B())
    {
      APLog.d("APGetKeyReq", "On encode start, add encrypt type = crypto");
      b("type", "crypto");
    }
    else if (A())
    {
      APLog.e("APGetKeyReq", "On encode start, cannot use crypt key to encode get key request!");
    }
    else
    {
      APLog.e("APGetKeyReq", "On encode start, type error");
    }
    e("key", v());
  }
  
  public void G()
  {
    Object localObject = c6.s0();
    o4 localo4 = p4.p().e();
    b("openid", localo4.f.a);
    b("pf", localo4.b.pf);
    b("pfkey", localo4.b.pfKey);
    b("format", "json");
    b("session_token", localo4.f.k);
    b("sdkversion", z5.c());
    b("user_uuid", APTools.b(((c6)localObject).Y(), 1));
    b("user_imei", APTools.b(((c6)localObject).W(), 1));
    b("user_androidid", APTools.b(((c6)localObject).V(), 1));
    b("user_mac", APTools.b(((c6)localObject).X(), 1));
    e("extend", ((c6)localObject).e());
    localObject = localo4.b;
    if (localObject == null) {
      APLog.e("GetKey", "Common info getter cannot get open id with null request!");
    }
    int i;
    if (a.r().e())
    {
      i = ((APBaseRequest)localObject).saveType;
      if ((i == 2) || (i == 3))
      {
        localObject = localo4.e;
        if (localObject == null) {
          APLog.e("GetKey", "Common info getter cannot get open id with null user info!");
        }
        if (!((c5)localObject).e)
        {
          b("openid", localo4.f.a);
          e("openid", localo4.f.a);
          e("openkey", localo4.f.b);
          if (TextUtils.isEmpty(localo4.f.c))
          {
            e("session_id", "uin");
            e("session_type", "skey");
            break label812;
          }
          e("session_id", localo4.f.c);
          e("session_type", localo4.f.d);
          break label812;
        }
        if ((p4.p().e().e.f) && (!TextUtils.isEmpty(localo4.f.a)))
        {
          b("openid", localo4.f.a);
          e("openid", localo4.f.a);
          e("openkey", localo4.f.b);
          if (TextUtils.isEmpty(localo4.f.c))
          {
            e("session_id", "uin");
            e("session_type", "skey");
            break label812;
          }
          e("session_id", localo4.f.c);
          e("session_type", localo4.f.d);
          break label812;
        }
        b("openid", localo4.b.openId);
        e("openid", localo4.b.openId);
        e("openkey", localo4.b.openKey);
        e("session_id", localo4.b.sessionId);
        e("session_type", localo4.b.sessionType);
        break label812;
      }
    }
    if (d.a())
    {
      i = ((APBaseRequest)localObject).saveType;
      if ((i == 2) || (i == 3))
      {
        b("openid", localo4.f.a);
        e("openid", localo4.f.a);
        e("openkey", localo4.f.b);
        if (TextUtils.isEmpty(localo4.f.c))
        {
          e("session_id", "uin");
          e("session_type", "skey");
          break label812;
        }
        e("session_id", localo4.f.c);
        e("session_type", localo4.f.d);
        break label812;
      }
    }
    if (d.b())
    {
      i = ((APBaseRequest)localObject).saveType;
      if ((i == 2) || (i == 3))
      {
        b("openid", localo4.f.a);
        e("openid", localo4.f.a);
        e("openkey", localo4.f.b);
        if (TextUtils.isEmpty(localo4.f.c))
        {
          e("session_id", "uin");
          e("session_type", "skey");
          break label812;
        }
        e("session_id", localo4.f.c);
        e("session_type", localo4.f.d);
        break label812;
      }
    }
    b("openid", localo4.b.openId);
    e("openid", localo4.b.openId);
    e("openkey", localo4.b.openKey);
    e("session_id", localo4.b.sessionId);
    e("session_type", localo4.b.sessionType);
    label812:
    b("vid", APAppDataInterface.singleton().A());
    b("xg_mid", APAppDataInterface.singleton().C());
    b("offer_id", p4.p().c());
  }
  
  public final String H()
  {
    return a("type");
  }
  
  public boolean I()
  {
    return "crypto".equals(H());
  }
  
  public boolean J()
  {
    return "secret".equals(H());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.o2
 * JD-Core Version:    0.7.0.1
 */