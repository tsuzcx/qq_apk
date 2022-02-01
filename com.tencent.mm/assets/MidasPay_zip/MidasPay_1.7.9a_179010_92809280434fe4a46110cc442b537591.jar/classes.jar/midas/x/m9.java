package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APPayStoreActivity;
import com.pay.ui.payWeb.APWebBuyActivity;
import com.pay.ui.payWeb.APX5WebBuyActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.plugin.APPluginActivity;

public class m9
  extends j9
  implements View.OnClickListener
{
  public ImageButton c;
  public LinearLayout d;
  public Button e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  public String j = "";
  public o4 k;
  public int l;
  public Context m;
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    this.a = paramAPRecoChannelActivity;
    this.m = paramContext;
    this.k = p4.p().e();
    this.l = this.k.b.saveType;
    paramAPRecoChannelActivity = LayoutInflater.from(paramContext).inflate(2131165195, null);
    a(paramAPRecoChannelActivity);
    b(p4.p().e().f.e);
    return paramAPRecoChannelActivity;
  }
  
  public void a()
  {
    super.a();
  }
  
  public final void a(View paramView)
  {
    this.f = ((TextView)paramView.findViewById(2131100042));
    this.g = ((TextView)paramView.findViewById(2131100002));
    this.h = ((TextView)paramView.findViewById(2131100005));
    this.i = ((TextView)paramView.findViewById(2131100000));
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = c6.s0().Q();
      if (paramKeyEvent.equals("APRechargeAccountActivity"))
      {
        APUICommonMethod.a(this.a);
        this.a.finish();
        return true;
      }
      if (paramKeyEvent.equals("AndroidPay"))
      {
        if (!"buytuan".equals(this.k.c.g))
        {
          APUICommonMethod.f();
          z5.a(2, "");
        }
      }
      else if (paramKeyEvent.equals("APPayGameInputNumActivity"))
      {
        paramKeyEvent = new Intent();
        paramKeyEvent.setClass(paramContext, APPayStoreActivity.class);
        paramContext.startActivity(paramKeyEvent);
      }
      else if (paramKeyEvent.equals("APPayGameListNumActivity"))
      {
        if (!"buytuan".equals(this.k.c.g))
        {
          paramKeyEvent = new Intent();
          paramKeyEvent.setClass(paramContext, APPayStoreActivity.class);
          paramContext.startActivity(paramKeyEvent);
        }
      }
      else if (paramKeyEvent.equals("APWebBuyActivity"))
      {
        paramKeyEvent = new Intent();
        if (!"buytuan".equals(this.k.c.g))
        {
          if (h8.d(paramContext))
          {
            APX5WebBuyActivity.q = y7.q;
            paramKeyEvent.setClass(paramContext, APX5WebBuyActivity.class);
          }
          else
          {
            APWebBuyActivity.q = y7.q;
            paramKeyEvent.setClass(paramContext, APWebBuyActivity.class);
          }
          paramContext.startActivity(paramKeyEvent);
        }
      }
      ((Activity)paramContext).finish();
    }
    return true;
  }
  
  public final void b(String paramString)
  {
    this.j = paramString;
    this.f.setText(p4.p().e().c.a);
    if (this.l == 0)
    {
      if (("hfpay".equals(this.j)) && (!TextUtils.isEmpty(APHFChannel.v)))
      {
        paramString = this.k;
        ((x4)paramString.c).b(paramString.f.f, APHFChannel.v);
      }
      else
      {
        paramString = this.k;
        paramString.c.a(paramString.f.f);
      }
    }
    else
    {
      paramString = this.k;
      paramString.c.a(paramString.f.f);
    }
    int n = this.l;
    if ((n != 0) && (n != 1) && (n != 2) && (n != 3))
    {
      if (n != 4)
      {
        if (n != 5)
        {
          paramString = "";
        }
        else if (g6.k().e() == g6.a.a)
        {
          this.g.setVisibility(8);
          paramString = this.k.c.b;
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append(" × ");
          paramString.append(this.k.f.f);
          paramString = paramString.toString();
        }
      }
      else if (g6.k().e() == g6.a.a)
      {
        this.g.setVisibility(8);
        paramString = this.k.c.b;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(this.m.getString(2131230829));
        paramString.append(" ");
        paramString.append(this.k.f.f);
        paramString.append(((z4)this.k.c).h());
        paramString = paramString.toString();
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append(this.m.getString(2131230829));
      paramString.append(this.k.f.f);
      paramString = paramString.toString();
    }
    this.g.setText(this.k.c.b);
    n = this.l;
    if ((n != 3) && (n != 2))
    {
      if (APUICommonMethod.e())
      {
        paramString = (x4)this.k.c;
        this.h.setText(paramString.h());
      }
      else
      {
        localObject = this.h;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(this.k.b.extendInfo.unit);
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
    }
    else {
      this.h.setText(paramString);
    }
    boolean bool = p.o().g();
    p.o().a(false);
    paramString = this.i;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.getString(2131230879));
    ((StringBuilder)localObject).append(p4.p().e().c.a());
    paramString.setText(((StringBuilder)localObject).toString());
    if (!APAppDataInterface.singleton().n()) {
      this.h.setVisibility(8);
    }
    p.o().a(bool);
  }
  
  public final void c()
  {
    this.k.f.i = null;
    APUICommonMethod.f();
    z5.a(2, "");
  }
  
  public final void d()
  {
    c6.s0().x(true);
    APDataReportManager.getInstance().insertData("sdk.payexpress.change", this.l);
    new Bundle().putBoolean("isFromExpress", true);
    this.a.a(2, 1, null);
  }
  
  public final void e()
  {
    e5.h().a(this.m, this.j, null, null, null);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == this.c.getId())
    {
      c();
      return;
    }
    if (paramView.getId() == this.d.getId())
    {
      d();
      return;
    }
    if (paramView.getId() == this.e.getId()) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.m9
 * JD-Core Version:    0.7.0.1
 */