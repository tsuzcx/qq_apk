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
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.Iterator;
import midas.x.a;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.fa;
import midas.x.fy;
import midas.x.gy;

public class APHFSmsOrderActivity
  extends APActivity
  implements View.OnClickListener
{
  private Button A;
  private LinearLayout a;
  private LinearLayout b;
  private LinearLayout c;
  private LinearLayout d;
  private TextView e;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private String y;
  private boolean z = false;
  
  private void a()
  {
    this.a = ((LinearLayout)findViewById(2131099810));
    this.b = ((LinearLayout)findViewById(2131099812));
    this.c = ((LinearLayout)findViewById(2131099814));
    this.d = ((LinearLayout)findViewById(2131099816));
    this.e = ((TextView)findViewById(2131100009));
    this.A = ((Button)findViewById(2131099967));
    this.A.setOnClickListener(this);
    ((ImageButton)findViewById(2131099802)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.hf.sendsms.back", APHFSmsOrderActivity.a(APHFSmsOrderActivity.this), em.b().n().e.l, em.b().n().e.f, null);
        APHFSmsOrderActivity.this.finish();
        APUICommonMethod.b(APHFSmsOrderActivity.this);
      }
    });
  }
  
  private void a(String paramString)
  {
    APAlertDialog.a locala = new APAlertDialog.a(this);
    locala.b("提示");
    locala.a(paramString);
    locala.b("查看短信", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, true);
        paramAnonymousKeyEvent = new Intent("android.intent.action.MAIN");
        paramAnonymousKeyEvent.addCategory("android.intent.category.DEFAULT");
        paramAnonymousKeyEvent.setType("vnd.android-dir/mms-sms");
        APHFSmsOrderActivity.this.startActivity(paramAnonymousKeyEvent);
        paramAnonymousAPAlertDialog.a();
      }
    });
    locala.a("已回复", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, false);
        paramAnonymousAPAlertDialog.a();
        APHFSmsOrderActivity.c(APHFSmsOrderActivity.this);
      }
    });
    locala.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 4)
        {
          APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, false);
          paramAnonymousAPAlertDialog.a();
          APDataReportManager.getInstance().insertData("sdk.ask.month.keyback", APHFSmsOrderActivity.g(APHFSmsOrderActivity.this), em.b().n().e.l, em.b().n().e.f, null);
        }
      }
    });
    try
    {
      locala.c();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(String paramString1, String paramString2)
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
  
  private void b()
  {
    Object localObject1 = getIntent().getExtras();
    this.q = ((Bundle)localObject1).getString("phoneNum");
    this.r = ((Bundle)localObject1).getString("operator");
    this.s = ((Bundle)localObject1).getString("area");
    this.t = ((Bundle)localObject1).getString("accessnum");
    this.u = ((Bundle)localObject1).getString("accessmsg");
    this.v = ((Bundle)localObject1).getString("hfFeeType");
    this.y = ((Bundle)localObject1).getString("hfWarmTips");
    Object localObject2 = this.e;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("手机话费支付 ");
    ((StringBuilder)localObject3).append(this.q);
    ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    switch (this.f)
    {
    default: 
      return;
    case 4: 
      this.w = ((Bundle)localObject1).getString("hfPrice");
      this.x = ((Bundle)localObject1).getString("hfTime");
      ((LinearLayout)findViewById(2131099814)).setVisibility(0);
      Object localObject4 = (TextView)findViewById(2131099815);
      localObject3 = (TextView)findViewById(2131099711);
      localObject1 = (TextView)findViewById(2131099712);
      localObject2 = (TextView)findViewById(2131099713);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.s);
      localStringBuilder.append(this.r);
      ((TextView)localObject4).setText(localStringBuilder.toString());
      if ("2".equals(this.x))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("第一步:发送");
        ((StringBuilder)localObject4).append(this.u);
        ((StringBuilder)localObject4).append("\n到");
        ((StringBuilder)localObject4).append(this.t);
        ((StringBuilder)localObject4).append(",您将收到系统回复短信");
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
        ((TextView)localObject1).setText("第二步:按短信指引回复，即可完成支付");
      }
      else
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("发送");
        ((StringBuilder)localObject4).append(this.u);
        ((StringBuilder)localObject4).append("\n到");
        ((StringBuilder)localObject4).append(this.t);
        ((StringBuilder)localObject4).append("即可完成本次支付");
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("您将订购腾讯");
        ((StringBuilder)localObject3).append(this.p.b.b);
        ((StringBuilder)localObject3).append("业务，发送短信将立即扣费");
        ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
      }
      if (!TextUtils.isEmpty(this.y)) {
        localObject1 = this.y;
      } else if ("1".equals(this.v)) {
        localObject1 = getString(2131230794);
      } else {
        localObject1 = getString(2131230793);
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      return;
    case 2: 
    case 3: 
    case 5: 
      ((LinearLayout)findViewById(2131099816)).setVisibility(0);
      localObject1 = (TextView)findViewById(2131099817);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.s);
      ((StringBuilder)localObject2).append(this.r);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      localObject1 = (TextView)findViewById(2131099714);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("发送");
      ((StringBuilder)localObject2).append(this.u);
      ((StringBuilder)localObject2).append("\n到");
      ((StringBuilder)localObject2).append(this.t);
      ((StringBuilder)localObject2).append("即可完成本次支付");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      return;
    case 1: 
      ((LinearLayout)findViewById(2131099812)).setVisibility(0);
      localObject1 = (TextView)findViewById(2131099813);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.s);
      ((StringBuilder)localObject2).append(this.r);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      localObject2 = (TextView)findViewById(2131099709);
      localObject1 = (TextView)findViewById(2131099710);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("发送");
      ((StringBuilder)localObject3).append(this.u);
      ((StringBuilder)localObject3).append("\n到");
      ((StringBuilder)localObject3).append(this.t);
      ((StringBuilder)localObject3).append("即可完成本次支付");
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("您将充值");
      ((StringBuilder)localObject2).append(this.p.b.a);
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(this.p.b.b);
      ((StringBuilder)localObject2).append("，发送短信将立即扣费");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      return;
    }
    ((LinearLayout)findViewById(2131099810)).setVisibility(0);
    localObject1 = (TextView)findViewById(2131099811);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.s);
    ((StringBuilder)localObject2).append(this.r);
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    localObject2 = (TextView)findViewById(2131099707);
    localObject1 = (TextView)findViewById(2131099708);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("发送");
    ((StringBuilder)localObject3).append(this.u);
    ((StringBuilder)localObject3).append("\n到");
    ((StringBuilder)localObject3).append(this.t);
    ((StringBuilder)localObject3).append("即可完成本次支付");
    ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("您将充值");
    ((StringBuilder)localObject2).append(this.p.b.a);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(this.p.b.b);
    ((StringBuilder)localObject2).append("，发送短信将立即扣费");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
  
  private void b(String paramString1, String paramString2)
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
  
  private void c()
  {
    APLog.e("APOldHF", "isSendMsgDialog show Dialog");
    APDataReportManager.getInstance().insertData("sdk.ask.show", this.f);
    APAlertDialog.a locala = new APAlertDialog.a(this);
    locala.b("提示");
    locala.a("你是否已发送短信？");
    locala.a("已发送", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, false);
        APDataReportManager.getInstance().insertData("sdk.ask.sent", APHFSmsOrderActivity.b(APHFSmsOrderActivity.this), em.b().n().e.l, em.b().n().e.f, null);
        paramAnonymousAPAlertDialog.a();
        APHFSmsOrderActivity.c(APHFSmsOrderActivity.this);
      }
    });
    locala.b("还没有", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, false);
        APDataReportManager.getInstance().insertData("sdk.ask.nonsent", APHFSmsOrderActivity.d(APHFSmsOrderActivity.this), em.b().n().e.l, em.b().n().e.f, null);
        paramAnonymousAPAlertDialog.a();
      }
    });
    locala.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setOnKeyListener keyCode:");
        localStringBuilder.append(paramAnonymousInt);
        localStringBuilder.append(" getAction:");
        localStringBuilder.append(paramAnonymousKeyEvent.getAction());
        APLog.e("APOldHF", localStringBuilder.toString());
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousKeyEvent = new StringBuilder();
          paramAnonymousKeyEvent.append("isSendMsgDialog cancel1 isFromSysSMS:");
          paramAnonymousKeyEvent.append(APHFSmsOrderActivity.e(APHFSmsOrderActivity.this));
          APLog.e("APOldHF", paramAnonymousKeyEvent.toString());
          APHFSmsOrderActivity.a(APHFSmsOrderActivity.this, false);
          paramAnonymousAPAlertDialog.a();
          paramAnonymousAPAlertDialog = new StringBuilder();
          paramAnonymousAPAlertDialog.append("isSendMsgDialog cancel2 isFromSysSMS:");
          paramAnonymousAPAlertDialog.append(APHFSmsOrderActivity.e(APHFSmsOrderActivity.this));
          APLog.e("APOldHF", paramAnonymousAPAlertDialog.toString());
          APDataReportManager.getInstance().insertData("sdk.ask.keyback", APHFSmsOrderActivity.f(APHFSmsOrderActivity.this), em.b().n().e.l, em.b().n().e.f, null);
        }
      }
    });
    try
    {
      locala.c();
      APDataReportManager.getInstance().insertData("sdk.ask.show", this.f, em.b().n().e.l, em.b().n().e.f, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this, APPayProgressActivity.class);
    localIntent.putExtra("channel", 9);
    startActivity(localIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == this.A.getId())
    {
      if ((APPermissionActivity.a(this, "android.permission.SEND_SMS")) && ("1".equals(APHFChannel.k)))
      {
        b(this.t, this.u);
        this.z = true;
        paramView = new StringBuilder();
        paramView.append("onClick 1 isFromSysSMS:");
        paramView.append(this.z);
        APLog.e("APOldHF", paramView.toString());
        APDataReportManager.getInstance().insertData("sdk.hf.sendsms.sure", this.f, em.b().n().e.m, "", "sendmethod=background");
        if (this.f == 4)
        {
          if (this.x.equals("2"))
          {
            a("短信已发送成功,运营商会再次下发确认短信给您,请按照指令进行回复。");
            return;
          }
          d();
          return;
        }
        d();
        return;
      }
      a(this.t, this.u);
      this.z = true;
      paramView = new StringBuilder();
      paramView.append("onClick 2 isFromSysSMS:");
      paramView.append(this.z);
      APLog.e("APOldHF", paramView.toString());
      APDataReportManager.getInstance().insertData("sdk.hf.sendsms.sure", this.f, em.b().n().e.m, "", "sendmethod=foreground");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      this.f = this.p.a.saveType;
      setContentView(2131165206);
      if (paramBundle != null) {
        this.z = paramBundle.getBoolean("isFromSysSMS");
      }
      a();
      b();
      a.a().f = true;
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      APDataReportManager.getInstance().insertData("sdk.hf.sendsms.keyback", this.f, em.b().n().e.l, em.b().n().e.f, null);
      finish();
      APUICommonMethod.b(this);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData("sdk.hf.sendsms.show", this.f, em.b().n().e.l, em.b().n().e.f, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume isFromSysSMS:");
    localStringBuilder.append(this.z);
    APLog.e("APOldHF", localStringBuilder.toString());
    if (this.z)
    {
      if ((APPermissionActivity.a(this, "android.permission.SEND_SMS")) && ("1".equals(APHFChannel.k)))
      {
        if (this.f == 4)
        {
          if (this.x.equals("2"))
          {
            a("发送短信成功后,运营商会再次下发确认短信给您,请按照指令进行回复。");
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onResume 2 isFromSysSMS:");
          localStringBuilder.append(this.z);
          APLog.e("APOldHF", localStringBuilder.toString());
          d();
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResume 3 isFromSysSMS:");
        localStringBuilder.append(this.z);
        APLog.e("APOldHF", localStringBuilder.toString());
        d();
        return;
      }
      if (this.f == 4)
      {
        if (this.x.equals("2"))
        {
          a("发送短信成功后,运营商会再次下发确认短信给您,请按照指令进行回复。");
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResume 2 isFromSysSMS:");
        localStringBuilder.append(this.z);
        APLog.e("APOldHF", localStringBuilder.toString());
        c();
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume 3 isFromSysSMS:");
      localStringBuilder.append(this.z);
      APLog.e("APOldHF", localStringBuilder.toString());
      c();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("isFromSysSMS", this.z);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APHFSmsOrderActivity
 * JD-Core Version:    0.7.0.1
 */