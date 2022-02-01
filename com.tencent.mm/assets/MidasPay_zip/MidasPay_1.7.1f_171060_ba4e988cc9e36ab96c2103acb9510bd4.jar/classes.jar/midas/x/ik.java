package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class ik
  extends ig
{
  private static final long serialVersionUID = 1L;
  private Activity f = null;
  private hq g = null;
  
  public ik()
  {
    c();
  }
  
  private HashMap<String, String> g()
  {
    d();
    Object localObject = ed.b().n();
    if (a.a().j())
    {
      if (ed.b().n().d.e)
      {
        this.d.put("openId", ((ec)localObject).a.openId);
        this.d.put("openKey", ((ec)localObject).a.openKey);
        this.d.put("sessionId", ((ec)localObject).a.sessionId);
        this.d.put("sessionType", ((ec)localObject).a.sessionType);
      }
      else
      {
        this.d.put("openId", ((ec)localObject).e.a);
        this.d.put("openKey", ((ec)localObject).e.b);
        if (TextUtils.isEmpty(((ec)localObject).e.c))
        {
          this.d.put("sessionId", "uin");
          this.d.put("sessionType", "skey");
        }
        else
        {
          this.d.put("sessionId", ((ec)localObject).e.c);
          this.d.put("sessionType", ((ec)localObject).e.d);
        }
      }
    }
    else if ((d.a()) || (d.b()))
    {
      this.d.put("openId", ((ec)localObject).e.a);
      this.d.put("openKey", ((ec)localObject).e.b);
      if (TextUtils.isEmpty(((ec)localObject).e.c))
      {
        this.d.put("sessionId", "uin");
        this.d.put("sessionType", "skey");
      }
      else
      {
        this.d.put("sessionId", ((ec)localObject).e.c);
        this.d.put("sessionType", ((ec)localObject).e.d);
      }
    }
    this.d.put("page", hj.C);
    try
    {
      localObject = this.f.getIntent().getStringExtra("errCode");
      if (localObject != null) {
        this.d.put("errCode", localObject);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    String str = APAppDataInterface.singleton().e();
    if (str.equals("dev")) {
      this.d.put("sandbox", "2");
    } else if (str.equals("test")) {
      this.d.put("sandbox", "1");
    }
    return this.d;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, hq paramhq)
  {
    super.a(paramActivity, paramhq);
    this.f = paramActivity;
    this.g = paramhq;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    paramProgressDialog = this.g.d();
    ((TextView)paramProgressDialog.findViewById(2131099885)).setText("温馨提示");
    ((ImageButton)paramProgressDialog.findViewById(2131099802)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ik.a(ik.this).finish();
        APUICommonMethod.b(ik.a(ik.this));
      }
    });
    if (this.g != null) {
      this.g.b(b());
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
          this.f.finish();
          APUICommonMethod.b(this.f);
          return;
        }
        if (paramString.startsWith("midas://qblimit_nobalance=charge"))
        {
          this.f.finish();
          APUICommonMethod.b();
          paramString = new Intent();
          paramString.setClass(this.f, APQDQBRechargeActivity.class);
          this.f.startActivity(paramString);
          return;
        }
        if (paramString.startsWith("midas://qblimit_nobalance=close"))
        {
          this.f.finish();
          APUICommonMethod.b(this.f);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    this.f.finish();
    APUICommonMethod.b(this.f);
    return true;
  }
  
  public String b()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ik
 * JD-Core Version:    0.7.0.1
 */