package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APQDQBRechargeActivity;
import com.tencent.midas.comm.APLog;
import java.net.URLDecoder;
import java.util.HashMap;

public class z8
  extends v8
{
  public static final long serialVersionUID = 1L;
  public Activity e = null;
  public f8 f = null;
  
  public z8()
  {
    c();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, f8 paramf8, Bundle paramBundle)
  {
    super.a(paramActivity, paramf8, paramBundle);
    this.e = paramActivity;
    this.f = paramf8;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    paramProgressDialog = this.f.c();
    ((TextView)paramProgressDialog.findViewById(2131099885)).setText("温馨提示");
    ((ImageButton)paramProgressDialog.findViewById(2131099802)).setOnClickListener(new a());
    paramProgressDialog = this.f;
    if (paramProgressDialog != null) {
      paramProgressDialog.b(f());
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("webCallBack=");
      localStringBuilder.append(paramString);
      APLog.d("APWebQbLimitNoBalancePage", localStringBuilder.toString());
      if (paramString.startsWith("midas://qblimit_nobalance="))
      {
        if (paramString.endsWith("midas://qblimit_nobalance=change"))
        {
          this.e.finish();
          APUICommonMethod.a(this.e);
          return;
        }
        if (paramString.startsWith("midas://qblimit_nobalance=charge"))
        {
          this.e.finish();
          APUICommonMethod.f();
          paramString = new Intent();
          paramString.setClass(this.e, APQDQBRechargeActivity.class);
          this.e.startActivity(paramString);
          return;
        }
        if (paramString.startsWith("midas://qblimit_nobalance=close"))
        {
          this.e.finish();
          APUICommonMethod.a(this.e);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean e()
  {
    this.e.finish();
    APUICommonMethod.a(this.e);
    return true;
  }
  
  public String f()
  {
    String str = APTools.a(g());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://pay.qq.com/h5/active/qb_limit.shtml");
    localStringBuilder.append("?");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    APLog.i("constructUrl", str);
    return str;
  }
  
  public final HashMap<String, String> g()
  {
    b();
    Object localObject = p4.p().e();
    if (a.r().e())
    {
      if (p4.p().e().e.e)
      {
        this.c.put("openId", ((o4)localObject).b.openId);
        this.c.put("openKey", ((o4)localObject).b.openKey);
        this.c.put("sessionId", ((o4)localObject).b.sessionId);
        this.c.put("sessionType", ((o4)localObject).b.sessionType);
      }
      else
      {
        this.c.put("openId", ((o4)localObject).f.a);
        this.c.put("openKey", ((o4)localObject).f.b);
        if (TextUtils.isEmpty(((o4)localObject).f.c))
        {
          this.c.put("sessionId", "uin");
          this.c.put("sessionType", "skey");
        }
        else
        {
          this.c.put("sessionId", ((o4)localObject).f.c);
          this.c.put("sessionType", ((o4)localObject).f.d);
        }
      }
    }
    else if ((d.a()) || (d.b()))
    {
      this.c.put("openId", ((o4)localObject).f.a);
      this.c.put("openKey", ((o4)localObject).f.b);
      if (TextUtils.isEmpty(((o4)localObject).f.c))
      {
        this.c.put("sessionId", "uin");
        this.c.put("sessionType", "skey");
      }
      else
      {
        this.c.put("sessionId", ((o4)localObject).f.c);
        this.c.put("sessionType", ((o4)localObject).f.d);
      }
    }
    this.c.put("page", y7.z);
    try
    {
      localObject = this.e.getIntent().getStringExtra("errCode");
      if (localObject != null) {
        this.c.put("errCode", localObject);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    String str = APAppDataInterface.singleton().h();
    if (str.equals("dev")) {
      this.c.put("sandbox", "2");
    } else if (str.equals("test")) {
      this.c.put("sandbox", "1");
    }
    return this.c;
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      z8.a(z8.this).finish();
      APUICommonMethod.a(z8.a(z8.this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.z8
 * JD-Core Version:    0.7.0.1
 */