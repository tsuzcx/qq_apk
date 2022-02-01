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

public class jg
  extends jd
  implements View.OnClickListener
{
  public final int a = 1;
  private ImageButton b;
  private LinearLayout e;
  private Button f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private String k = "";
  private el l;
  private int m;
  private Context n;
  
  private void a(View paramView)
  {
    this.g = ((TextView)paramView.findViewById(2131100042));
    this.h = ((TextView)paramView.findViewById(2131100002));
    this.i = ((TextView)paramView.findViewById(2131100005));
    this.j = ((TextView)paramView.findViewById(2131100000));
  }
  
  private void a(String paramString)
  {
    this.k = paramString;
    this.g.setText(em.b().n().b.a);
    paramString = "";
    if (this.m == 0)
    {
      if (("hfpay".equals(this.k)) && (!TextUtils.isEmpty(APHFChannel.o))) {
        ((eu)this.l.b).b(this.l.e.g, APHFChannel.o);
      } else {
        this.l.b.a(this.l.e.g);
      }
    }
    else {
      this.l.b.a(this.l.e.g);
    }
    switch (this.m)
    {
    default: 
      break;
    case 5: 
      if (gc.a().f() == gc.a.a)
      {
        this.h.setVisibility(8);
        paramString = this.l.b.b;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(" × ");
        paramString.append(this.l.e.g);
        paramString = paramString.toString();
      }
      break;
    case 4: 
      if (gc.a().f() == gc.a.a)
      {
        this.h.setVisibility(8);
        paramString = this.l.b.b;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(this.n.getString(2131230829));
        paramString.append(" ");
        paramString.append(this.l.e.g);
        paramString.append(((ew)this.l.b).h());
        paramString = paramString.toString();
      }
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      paramString = new StringBuilder();
      paramString.append(this.n.getString(2131230829));
      paramString.append(this.l.e.g);
      paramString = paramString.toString();
    }
    this.h.setText(this.l.b.b);
    if ((this.m != 3) && (this.m != 2))
    {
      if (APUICommonMethod.h())
      {
        paramString = (eu)this.l.b;
        this.i.setText(paramString.h());
      }
      else
      {
        localObject = this.i;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(this.l.a.extendInfo.unit);
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
    }
    else {
      this.i.setText(paramString);
    }
    boolean bool = o.a().e();
    o.a().a(false);
    paramString = this.j;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.d.getString(2131230879));
    ((StringBuilder)localObject).append(em.b().n().b.a());
    paramString.setText(((StringBuilder)localObject).toString());
    if (!APAppDataInterface.singleton().h()) {
      this.i.setVisibility(8);
    }
    o.a().a(bool);
  }
  
  private void c()
  {
    fb.a().a(this.n, this.k, null, null, null);
  }
  
  private void d()
  {
    fy.a().e(true);
    APDataReportManager.getInstance().insertData("sdk.payexpress.change", this.m);
    new Bundle().putBoolean("isFromExpress", true);
    this.d.a(2, 1, null);
  }
  
  private void e()
  {
    this.l.e.j = null;
    APUICommonMethod.b();
    fv.a(2, "");
  }
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    this.d = paramAPRecoChannelActivity;
    this.n = paramContext;
    this.l = em.b().n();
    this.m = this.l.a.saveType;
    paramAPRecoChannelActivity = LayoutInflater.from(paramContext).inflate(2131165195, null);
    a(paramAPRecoChannelActivity);
    a(em.b().n().e.f);
    return paramAPRecoChannelActivity;
  }
  
  public void a()
  {
    super.a();
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = fy.a().g();
      if (paramKeyEvent.equals("APRechargeAccountActivity"))
      {
        APUICommonMethod.b(this.d);
        this.d.finish();
        return true;
      }
      if (paramKeyEvent.equals("AndroidPay"))
      {
        if (!"buytuan".equals(this.l.b.j))
        {
          APUICommonMethod.b();
          fv.a(2, "");
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
        if (!"buytuan".equals(this.l.b.j))
        {
          paramKeyEvent = new Intent();
          paramKeyEvent.setClass(paramContext, APPayStoreActivity.class);
          paramContext.startActivity(paramKeyEvent);
        }
      }
      else if (paramKeyEvent.equals("APWebBuyActivity"))
      {
        paramKeyEvent = new Intent();
        if (!"buytuan".equals(this.l.b.j))
        {
          if (id.b(paramContext))
          {
            APX5WebBuyActivity.a = hu.s;
            paramKeyEvent.setClass(paramContext, APX5WebBuyActivity.class);
          }
          else
          {
            APWebBuyActivity.a = hu.s;
            paramKeyEvent.setClass(paramContext, APWebBuyActivity.class);
          }
          paramContext.startActivity(paramKeyEvent);
        }
      }
      ((Activity)paramContext).finish();
      return true;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == this.b.getId())
    {
      e();
      return;
    }
    if (paramView.getId() == this.e.getId())
    {
      d();
      return;
    }
    if (paramView.getId() == this.f.getId()) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jg
 * JD-Core Version:    0.7.0.1
 */