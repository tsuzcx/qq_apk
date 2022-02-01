package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class cn
  extends bx
{
  public cn()
  {
    a("https", String.format("/v1/r/%s/mobile_get_key", new Object[] { em.b().n().a.offerId }), "442");
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
    Object localObject = fy.a();
    el localel = em.b().n();
    e("openid", localel.e.a);
    e("pf", localel.a.pf);
    e("pfkey", localel.a.pfKey);
    e("format", "json");
    e("session_token", localel.e.l);
    e("sdkversion", fv.c());
    e("user_uuid", APTools.a(((fy)localObject).q(), 1));
    e("user_imei", APTools.a(((fy)localObject).r(), 1));
    e("user_androidid", APTools.a(((fy)localObject).s(), 1));
    e("user_mac", APTools.a(((fy)localObject).t(), 1));
    f("extend", ((fy)localObject).y());
    localObject = localel.a;
    if (localObject == null) {
      APLog.e("GetKey", "Common info getter cannot get open id with null request!");
    }
    if ((a.a().j()) && ((((APBaseRequest)localObject).saveType == 2) || (((APBaseRequest)localObject).saveType == 3)))
    {
      localObject = localel.d;
      if (localObject == null) {
        APLog.e("GetKey", "Common info getter cannot get open id with null user info!");
      }
      if (!((ez)localObject).e)
      {
        e("openid", localel.e.a);
        f("openid", localel.e.a);
        f("openkey", localel.e.b);
        if (TextUtils.isEmpty(localel.e.c))
        {
          f("session_id", "uin");
          f("session_type", "skey");
        }
        else
        {
          f("session_id", localel.e.c);
          f("session_type", localel.e.d);
        }
      }
      else if ((em.b().n().d.f) && (!TextUtils.isEmpty(localel.e.a)))
      {
        e("openid", localel.e.a);
        f("openid", localel.e.a);
        f("openkey", localel.e.b);
        if (TextUtils.isEmpty(localel.e.c))
        {
          f("session_id", "uin");
          f("session_type", "skey");
        }
        else
        {
          f("session_id", localel.e.c);
          f("session_type", localel.e.d);
        }
      }
      else
      {
        e("openid", localel.a.openId);
        f("openid", localel.a.openId);
        f("openkey", localel.a.openKey);
        f("session_id", localel.a.sessionId);
        f("session_type", localel.a.sessionType);
      }
    }
    else if ((d.a()) && ((((APBaseRequest)localObject).saveType == 2) || (((APBaseRequest)localObject).saveType == 3)))
    {
      e("openid", localel.e.a);
      f("openid", localel.e.a);
      f("openkey", localel.e.b);
      if (TextUtils.isEmpty(localel.e.c))
      {
        f("session_id", "uin");
        f("session_type", "skey");
      }
      else
      {
        f("session_id", localel.e.c);
        f("session_type", localel.e.d);
      }
    }
    else if ((d.b()) && ((((APBaseRequest)localObject).saveType == 2) || (((APBaseRequest)localObject).saveType == 3)))
    {
      e("openid", localel.e.a);
      f("openid", localel.e.a);
      f("openkey", localel.e.b);
      if (TextUtils.isEmpty(localel.e.c))
      {
        f("session_id", "uin");
        f("session_type", "skey");
      }
      else
      {
        f("session_id", localel.e.c);
        f("session_type", localel.e.d);
      }
    }
    else
    {
      e("openid", localel.a.openId);
      f("openid", localel.a.openId);
      f("openkey", localel.a.openKey);
      f("session_id", localel.a.sessionId);
      f("session_type", localel.a.sessionType);
    }
    e("vid", APAppDataInterface.singleton().b());
    e("xg_mid", APAppDataInterface.singleton().l());
    e("offer_id", em.b().f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cn
 * JD-Core Version:    0.7.0.1
 */