package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class ch
  extends br
{
  public ch()
  {
    a("https", String.format("/v1/r/%s/mobile_get_key", new Object[] { ed.b().n().a.offerId }), "442");
    e();
  }
  
  private String I()
  {
    return b("type");
  }
  
  protected void a_()
  {
    super.a_();
    APLog.d("APGetKeyReq", "On encode start, add get key parameters");
    if (E())
    {
      APLog.d("APGetKeyReq", "On encode start, add encrypt type = secret");
      e("type", "secret");
    }
    else if (F())
    {
      APLog.d("APGetKeyReq", "On encode start, add encrypt type = crypto");
      e("type", "crypto");
    }
    else if (G())
    {
      APLog.e("APGetKeyReq", "On encode start, cannot use crypt key to encode get key request!");
    }
    else
    {
      APLog.e("APGetKeyReq", "On encode start, type error");
    }
    f("key", z());
  }
  
  boolean c()
  {
    return "secret".equals(I());
  }
  
  boolean d()
  {
    return "crypto".equals(I());
  }
  
  public void e()
  {
    Object localObject = fp.a();
    ec localec = ed.b().n();
    e("openid", localec.e.a);
    e("pf", localec.a.pf);
    e("pfkey", localec.a.pfKey);
    e("format", "json");
    e("session_token", localec.e.l);
    e("sdkversion", fm.c());
    e("user_uuid", APTools.a(((fp)localObject).q(), 1));
    e("user_imei", APTools.a(((fp)localObject).r(), 1));
    e("user_androidid", APTools.a(((fp)localObject).s(), 1));
    e("user_mac", APTools.a(((fp)localObject).t(), 1));
    f("extend", ((fp)localObject).y());
    localObject = localec.a;
    if (localObject == null) {
      APLog.e("GetKey", "Common info getter cannot get open id with null request!");
    }
    if ((a.a().j()) && ((((APBaseRequest)localObject).saveType == 2) || (((APBaseRequest)localObject).saveType == 3)))
    {
      localObject = localec.d;
      if (localObject == null) {
        APLog.e("GetKey", "Common info getter cannot get open id with null user info!");
      }
      if (!((eq)localObject).e)
      {
        e("openid", localec.e.a);
        f("openid", localec.e.a);
        f("openkey", localec.e.b);
        if (TextUtils.isEmpty(localec.e.c))
        {
          f("session_id", "uin");
          f("session_type", "skey");
        }
        else
        {
          f("session_id", localec.e.c);
          f("session_type", localec.e.d);
        }
      }
      else if ((ed.b().n().d.f) && (!TextUtils.isEmpty(localec.e.a)))
      {
        e("openid", localec.e.a);
        f("openid", localec.e.a);
        f("openkey", localec.e.b);
        if (TextUtils.isEmpty(localec.e.c))
        {
          f("session_id", "uin");
          f("session_type", "skey");
        }
        else
        {
          f("session_id", localec.e.c);
          f("session_type", localec.e.d);
        }
      }
      else
      {
        e("openid", localec.a.openId);
        f("openid", localec.a.openId);
        f("openkey", localec.a.openKey);
        f("session_id", localec.a.sessionId);
        f("session_type", localec.a.sessionType);
      }
    }
    else if ((d.a()) && ((((APBaseRequest)localObject).saveType == 2) || (((APBaseRequest)localObject).saveType == 3)))
    {
      e("openid", localec.e.a);
      f("openid", localec.e.a);
      f("openkey", localec.e.b);
      if (TextUtils.isEmpty(localec.e.c))
      {
        f("session_id", "uin");
        f("session_type", "skey");
      }
      else
      {
        f("session_id", localec.e.c);
        f("session_type", localec.e.d);
      }
    }
    else if ((d.b()) && ((((APBaseRequest)localObject).saveType == 2) || (((APBaseRequest)localObject).saveType == 3)))
    {
      e("openid", localec.e.a);
      f("openid", localec.e.a);
      f("openkey", localec.e.b);
      if (TextUtils.isEmpty(localec.e.c))
      {
        f("session_id", "uin");
        f("session_type", "skey");
      }
      else
      {
        f("session_id", localec.e.c);
        f("session_type", localec.e.d);
      }
    }
    else
    {
      e("openid", localec.a.openId);
      f("openid", localec.a.openId);
      f("openkey", localec.a.openKey);
      f("session_id", localec.a.sessionId);
      f("session_type", localec.a.sessionType);
    }
    e("vid", APAppDataInterface.singleton().b());
    e("xg_mid", APAppDataInterface.singleton().l());
    e("offer_id", ed.b().f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ch
 * JD-Core Version:    0.7.0.1
 */