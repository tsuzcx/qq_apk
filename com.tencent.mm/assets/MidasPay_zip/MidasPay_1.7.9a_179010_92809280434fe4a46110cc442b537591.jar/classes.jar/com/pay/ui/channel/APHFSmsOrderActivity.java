package com.pay.ui.channel;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.permission.APPermissionActivity;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.ArrayList;
import java.util.Iterator;
import midas.x.a;
import midas.x.c6;
import midas.x.c7;
import midas.x.d5;
import midas.x.o4;
import midas.x.p4;
import midas.x.w4;

public class APHFSmsOrderActivity
  extends APActivity
  implements View.OnClickListener
{
  public TextView d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public boolean m = false;
  public Button n;
  
  public final void a(String paramString)
  {
    APAlertDialog.f localf = new APAlertDialog.f(this);
    localf.b("提示");
    localf.a(paramString);
    localf.a("查看短信", new e());
    localf.b("已回复", new f());
    localf.b(new g());
    try
    {
      localf.b();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final void a(String paramString1, String paramString2)
  {
    SmsManager localSmsManager = SmsManager.getDefault();
    Object localObject1 = new Intent("MIDAS_SENT_SMS_ACTION");
    localObject1 = PendingIntent.getBroadcast(getApplicationContext(), 0, (Intent)localObject1, 0);
    Object localObject2 = new Intent("MIDAS_DELIVERED_SMS_ACTION");
    localObject2 = PendingIntent.getBroadcast(getApplicationContext(), 0, (Intent)localObject2, 0);
    if (paramString2.getBytes().length > 140)
    {
      paramString2 = localSmsManager.divideMessage(paramString2).iterator();
      while (paramString2.hasNext()) {
        localSmsManager.sendTextMessage(paramString1, null, (String)paramString2.next(), (PendingIntent)localObject1, null);
      }
    }
    localSmsManager.sendTextMessage(paramString1, null, paramString2, (PendingIntent)localObject1, (PendingIntent)localObject2);
  }
  
  public final void b(String paramString1, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smsto:");
      localStringBuilder.append(paramString1);
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse(localStringBuilder.toString()));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("sendSMSIntent:");
      paramString2.append(paramString1.toString());
      APLog.e("APHFPqayActivity", paramString2.toString());
    }
  }
  
  public final void f()
  {
    Intent localIntent = new Intent(this, APPayProgressActivity.class);
    localIntent.putExtra("channel", 9);
    startActivity(localIntent);
  }
  
  public final void g()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131099810);
    localLinearLayout = (LinearLayout)findViewById(2131099812);
    localLinearLayout = (LinearLayout)findViewById(2131099814);
    localLinearLayout = (LinearLayout)findViewById(2131099816);
    this.d = ((TextView)findViewById(2131100009));
    this.n = ((Button)findViewById(2131099967));
    this.n.setOnClickListener(this);
    ((ImageButton)findViewById(2131099802)).setOnClickListener(new a());
  }
  
  public final void h()
  {
    Object localObject1 = getIntent().getExtras();
    this.e = ((Bundle)localObject1).getString("phoneNum");
    this.f = ((Bundle)localObject1).getString("operator");
    this.g = ((Bundle)localObject1).getString("area");
    this.h = ((Bundle)localObject1).getString("accessnum");
    this.i = ((Bundle)localObject1).getString("accessmsg");
    this.j = ((Bundle)localObject1).getString("hfFeeType");
    this.l = ((Bundle)localObject1).getString("hfWarmTips");
    Object localObject2 = this.d;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("手机话费支付 ");
    ((StringBuilder)localObject3).append(this.e);
    ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    int i1 = this.a;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if ((i1 != 2) && (i1 != 3)) {
          if (i1 != 4)
          {
            if (i1 == 5) {}
          }
          else
          {
            ((Bundle)localObject1).getString("hfPrice");
            this.k = ((Bundle)localObject1).getString("hfTime");
            ((LinearLayout)findViewById(2131099814)).setVisibility(0);
            Object localObject4 = (TextView)findViewById(2131099815);
            localObject3 = (TextView)findViewById(2131099711);
            localObject1 = (TextView)findViewById(2131099712);
            localObject2 = (TextView)findViewById(2131099713);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.g);
            localStringBuilder.append(this.f);
            ((TextView)localObject4).setText(localStringBuilder.toString());
            if ("2".equals(this.k))
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("第一步:发送");
              ((StringBuilder)localObject4).append(this.i);
              ((StringBuilder)localObject4).append("\n到");
              ((StringBuilder)localObject4).append(this.h);
              ((StringBuilder)localObject4).append(",您将收到系统回复短信");
              ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
              ((TextView)localObject1).setText("第二步:按短信指引回复，即可完成支付");
            }
            else
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("发送");
              ((StringBuilder)localObject4).append(this.i);
              ((StringBuilder)localObject4).append("\n到");
              ((StringBuilder)localObject4).append(this.h);
              ((StringBuilder)localObject4).append("即可完成本次支付");
              ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("您将订购腾讯");
              ((StringBuilder)localObject3).append(this.c.c.b);
              ((StringBuilder)localObject3).append("业务，发送短信将立即扣费");
              ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
            }
            if (!TextUtils.isEmpty(this.l)) {
              localObject1 = this.l;
            } else if ("1".equals(this.j)) {
              localObject1 = getString(2131230794);
            } else {
              localObject1 = getString(2131230793);
            }
            ((TextView)localObject2).setText((CharSequence)localObject1);
            return;
          }
        }
        ((LinearLayout)findViewById(2131099816)).setVisibility(0);
        localObject1 = (TextView)findViewById(2131099817);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.g);
        ((StringBuilder)localObject2).append(this.f);
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        localObject1 = (TextView)findViewById(2131099714);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("发送");
        ((StringBuilder)localObject2).append(this.i);
        ((StringBuilder)localObject2).append("\n到");
        ((StringBuilder)localObject2).append(this.h);
        ((StringBuilder)localObject2).append("即可完成本次支付");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        return;
      }
      ((LinearLayout)findViewById(2131099812)).setVisibility(0);
      localObject1 = (TextView)findViewById(2131099813);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.g);
      ((StringBuilder)localObject2).append(this.f);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      localObject2 = (TextView)findViewById(2131099709);
      localObject1 = (TextView)findViewById(2131099710);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("发送");
      ((StringBuilder)localObject3).append(this.i);
      ((StringBuilder)localObject3).append("\n到");
      ((StringBuilder)localObject3).append(this.h);
      ((StringBuilder)localObject3).append("即可完成本次支付");
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("您将充值");
      ((StringBuilder)localObject2).append(this.c.c.a);
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(this.c.c.b);
      ((StringBuilder)localObject2).append("，发送短信将立即扣费");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      return;
    }
    ((LinearLayout)findViewById(2131099810)).setVisibility(0);
    localObject1 = (TextView)findViewById(2131099811);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.g);
    ((StringBuilder)localObject2).append(this.f);
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    localObject2 = (TextView)findViewById(2131099707);
    localObject1 = (TextView)findViewById(2131099708);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("发送");
    ((StringBuilder)localObject3).append(this.i);
    ((StringBuilder)localObject3).append("\n到");
    ((StringBuilder)localObject3).append(this.h);
    ((StringBuilder)localObject3).append("即可完成本次支付");
    ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("您将充值");
    ((StringBuilder)localObject2).append(this.c.c.a);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(this.c.c.b);
    ((StringBuilder)localObject2).append("，发送短信将立即扣费");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
  
  public final void i()
  {
    APLog.e("APOldHF", "isSendMsgDialog show Dialog");
    APDataReportManager.getInstance().insertData("sdk.ask.show", this.a);
    APAlertDialog.f localf = new APAlertDialog.f(this);
    localf.b("提示");
    localf.a("你是否已发送短信？");
    localf.b("已发送", new b());
    localf.a("还没有", new c());
    localf.b(new d());
    try
    {
      localf.b();
      APDataReportManager.getInstance().insertData("sdk.ask.show", this.a, p4.p().e().f.k, p4.p().e().f.e, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == this.n.getId())
    {
      if ((APPermissionActivity.c(this, "android.permission.SEND_SMS")) && ("1".equals(APHFChannel.r)))
      {
        a(this.h, this.i);
        this.m = true;
        paramView = new StringBuilder();
        paramView.append("onClick 1 isFromSysSMS:");
        paramView.append(this.m);
        APLog.e("APOldHF", paramView.toString());
        APDataReportManager.getInstance().insertData("sdk.hf.sendsms.sure", this.a, p4.p().e().f.l, "", "sendmethod=background");
        if (this.a == 4)
        {
          if (this.k.equals("2"))
          {
            a("短信已发送成功,运营商会再次下发确认短信给您,请按照指令进行回复。");
            return;
          }
          f();
          return;
        }
        f();
        return;
      }
      b(this.h, this.i);
      this.m = true;
      paramView = new StringBuilder();
      paramView.append("onClick 2 isFromSysSMS:");
      paramView.append(this.m);
      APLog.e("APOldHF", paramView.toString());
      APDataReportManager.getInstance().insertData("sdk.hf.sendsms.sure", this.a, p4.p().e().f.l, "", "sendmethod=foreground");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      this.a = this.c.b.saveType;
      setContentView(2131165206);
      if (paramBundle != null) {
        this.m = paramBundle.getBoolean("isFromSysSMS");
      }
      g();
      h();
      a.r().f = true;
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      APDataReportManager.getInstance().insertData("sdk.hf.sendsms.keyback", this.a, p4.p().e().f.k, p4.p().e().f.e, null);
      finish();
      APUICommonMethod.a(this);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData("sdk.hf.sendsms.show", this.a, p4.p().e().f.k, p4.p().e().f.e, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume isFromSysSMS:");
    localStringBuilder.append(this.m);
    APLog.e("APOldHF", localStringBuilder.toString());
    if (this.m)
    {
      if ((APPermissionActivity.c(this, "android.permission.SEND_SMS")) && ("1".equals(APHFChannel.r)))
      {
        if (this.a == 4)
        {
          if (this.k.equals("2"))
          {
            a("发送短信成功后,运营商会再次下发确认短信给您,请按照指令进行回复。");
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onResume 2 isFromSysSMS:");
          localStringBuilder.append(this.m);
          APLog.e("APOldHF", localStringBuilder.toString());
          f();
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResume 3 isFromSysSMS:");
        localStringBuilder.append(this.m);
        APLog.e("APOldHF", localStringBuilder.toString());
        f();
        return;
      }
      if (this.a == 4)
      {
        if (this.k.equals("2"))
        {
          a("发送短信成功后,运营商会再次下发确认短信给您,请按照指令进行回复。");
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResume 2 isFromSysSMS:");
        localStringBuilder.append(this.m);
        APLog.e("APOldHF", localStringBuilder.toString());
        i();
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume 3 isFromSysSMS:");
      localStringBuilder.append(this.m);
      APLog.e("APOldHF", localStringBuilder.toString());
      i();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("isFromSysSMS", this.m);
    super.onSaveInstanceState(paramBundle);
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.hf.sendsms.back", APHFSmsOrderActivity.a(APHFSmsOrderActivity.this), p4.p().e().f.k, p4.p().e().f.e, null);
      APHFSmsOrderActivity.this.finish();
      APUICommonMethod.a(APHFSmsOrderActivity.this);
    }
  }
  
  public class b
    implements c7
  {
    public b() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, false);
      APDataReportManager.getInstance().insertData("sdk.ask.sent", APHFSmsOrderActivity.c(APHFSmsOrderActivity.this), p4.p().e().f.k, p4.p().e().f.e, null);
      paramAPAlertDialog.f();
      APHFSmsOrderActivity.d(APHFSmsOrderActivity.this);
    }
  }
  
  public class c
    implements c7
  {
    public c() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, false);
      APDataReportManager.getInstance().insertData("sdk.ask.nonsent", APHFSmsOrderActivity.e(APHFSmsOrderActivity.this), p4.p().e().f.k, p4.p().e().f.e, null);
      paramAPAlertDialog.f();
    }
  }
  
  public class d
    implements c7
  {
    public d() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOnKeyListener keyCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" getAction:");
      localStringBuilder.append(paramKeyEvent.getAction());
      APLog.e("APOldHF", localStringBuilder.toString());
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        paramKeyEvent = new StringBuilder();
        paramKeyEvent.append("isSendMsgDialog cancel1 isFromSysSMS:");
        paramKeyEvent.append(APHFSmsOrderActivity.b(APHFSmsOrderActivity.this));
        APLog.e("APOldHF", paramKeyEvent.toString());
        APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, false);
        paramAPAlertDialog.f();
        paramAPAlertDialog = new StringBuilder();
        paramAPAlertDialog.append("isSendMsgDialog cancel2 isFromSysSMS:");
        paramAPAlertDialog.append(APHFSmsOrderActivity.b(APHFSmsOrderActivity.this));
        APLog.e("APOldHF", paramAPAlertDialog.toString());
        APDataReportManager.getInstance().insertData("sdk.ask.keyback", APHFSmsOrderActivity.f(APHFSmsOrderActivity.this), p4.p().e().f.k, p4.p().e().f.e, null);
      }
    }
  }
  
  public class e
    implements c7
  {
    public e() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, true);
      paramKeyEvent = new Intent("android.intent.action.MAIN");
      paramKeyEvent.addCategory("android.intent.category.DEFAULT");
      paramKeyEvent.setType("vnd.android-dir/mms-sms");
      APHFSmsOrderActivity.this.startActivity(paramKeyEvent);
      paramAPAlertDialog.f();
    }
  }
  
  public class f
    implements c7
  {
    public f() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, false);
      paramAPAlertDialog.f();
      APHFSmsOrderActivity.d(APHFSmsOrderActivity.this);
    }
  }
  
  public class g
    implements c7
  {
    public g() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, false);
        paramAPAlertDialog.f();
        APDataReportManager.getInstance().insertData("sdk.ask.month.keyback", APHFSmsOrderActivity.g(APHFSmsOrderActivity.this), p4.p().e().f.k, p4.p().e().f.e, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APHFSmsOrderActivity
 * JD-Core Version:    0.7.0.1
 */