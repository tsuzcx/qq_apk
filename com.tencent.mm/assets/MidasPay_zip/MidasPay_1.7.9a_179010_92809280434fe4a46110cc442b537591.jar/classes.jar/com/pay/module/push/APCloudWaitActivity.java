package com.pay.module.push;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.d5;
import midas.x.e5;
import midas.x.o4;
import midas.x.p4;
import midas.x.u6;
import midas.x.u6.b;

public class APCloudWaitActivity
  extends APActivity
{
  public static ResultReceiver k;
  public String d;
  public long e = 6L;
  public long f = 0L;
  public long g = 1L;
  public u6 h;
  public boolean i = true;
  public View.OnKeyListener j;
  
  public static void l()
  {
    Activity localActivity = APUICommonMethod.c();
    if ((localActivity != null) && ((localActivity instanceof APCloudWaitActivity)))
    {
      localActivity.finish();
      APUICommonMethod.a(localActivity);
    }
  }
  
  public final CharSequence a(String paramString, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramString = paramString.split("%s");
    localSpannableStringBuilder.append(paramString[0]);
    int m = 1;
    String str = String.format("%s", new Object[] { Integer.valueOf(paramInt) });
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#338aec")), 0, str.length(), 0);
    localSpannableStringBuilder.append(localSpannableString);
    paramInt = m;
    while (paramInt < paramString.length)
    {
      localSpannableStringBuilder.append(paramString[paramInt]);
      paramInt += 1;
    }
    return localSpannableStringBuilder;
  }
  
  public final void a(int paramInt, Bundle paramBundle)
  {
    ResultReceiver localResultReceiver = k;
    if (localResultReceiver != null) {
      localResultReceiver.send(paramInt, paramBundle);
    }
  }
  
  public final void a(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131100043);
    localTextView.setGravity(1);
    localTextView.setText(paramString);
  }
  
  public final void a(String paramString, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    Button localButton = (Button)findViewById(2131099703);
    if (!TextUtils.isEmpty(paramString))
    {
      localButton.setVisibility(0);
      localButton.setEnabled(paramBoolean);
      localButton.setText(paramString);
      localButton.setOnClickListener(paramOnClickListener);
      return;
    }
    localButton.setVisibility(8);
  }
  
  public final void a(boolean paramBoolean, View.OnKeyListener paramOnKeyListener)
  {
    this.i = paramBoolean;
    this.j = paramOnKeyListener;
  }
  
  public final void b(int paramInt, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callbackSuccess() resultCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", resultData=");
    if (paramBundle == null) {
      localObject = "Null";
    } else {
      localObject = paramBundle.toString();
    }
    localStringBuilder.append((String)localObject);
    APLog.d("APCloudWaitActivity", localStringBuilder.toString());
    g();
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("cloudCallback_resultCode", paramInt);
    ((Bundle)localObject).putParcelable("cloudCallback_resultData", paramBundle);
    a(2, (Bundle)localObject);
  }
  
  public final void b(String paramString, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    Button localButton = (Button)findViewById(2131099705);
    if (!TextUtils.isEmpty(paramString))
    {
      localButton.setVisibility(0);
      localButton.setEnabled(paramBoolean);
      localButton.setText(paramString);
      localButton.setOnClickListener(paramOnClickListener);
      return;
    }
    localButton.setVisibility(8);
  }
  
  public final void f()
  {
    APLog.d("APCloudWaitActivity", "callbackCancel()");
    g();
    a(1, null);
    e5.a(this.d);
  }
  
  public final void g()
  {
    finish();
    APUICommonMethod.a(this);
  }
  
  public final void h()
  {
    this.d = getIntent().getStringExtra("channelId");
    k = (ResultReceiver)getIntent().getParcelableExtra("receiver");
  }
  
  public final void i()
  {
    a("正在支付，请稍后...     ");
    b("已支付", false, new a());
    a("取消", true, new b());
    a(false, new c());
    j();
  }
  
  public final void j()
  {
    if (this.h == null)
    {
      final Button localButton1 = (Button)findViewById(2131099705);
      final Button localButton2 = (Button)findViewById(2131099703);
      localButton1.setEnabled(false);
      localButton1.setVisibility(0);
      localButton2.setEnabled(false);
      localButton2.setVisibility(0);
      this.i = false;
      final TextView localTextView = (TextView)findViewById(2131100043);
      this.h = new u6(this.e, this.f, this.g, new d(localTextView, localButton1, localButton2));
    }
    this.h.b();
  }
  
  public final void k()
  {
    u6 localu6 = this.h;
    if (localu6 != null) {
      localu6.c();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131165188);
    h();
    i();
  }
  
  public void onDestroy()
  {
    k();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.i) {
      return true;
    }
    View.OnKeyListener localOnKeyListener = this.j;
    if (localOnKeyListener != null) {
      return localOnKeyListener.onKey(null, paramInt, paramKeyEvent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int m = this.a;
    String str = p4.p().e().f.k;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelid=");
    localStringBuilder.append(this.d);
    localAPDataReportManager.insertData("sdk.cloudgame.show", m, str, null, localStringBuilder.toString());
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      paramView = APDataReportManager.getInstance();
      int i = APCloudWaitActivity.a(APCloudWaitActivity.this);
      String str = p4.p().e().f.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("channelid=");
      localStringBuilder.append(APCloudWaitActivity.b(APCloudWaitActivity.this));
      paramView.insertData("sdk.cloudgame.sure", i, str, null, localStringBuilder.toString());
      APCloudWaitActivity.a(APCloudWaitActivity.this, 0, null);
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    public b() {}
    
    public void onClick(View paramView)
    {
      paramView = APDataReportManager.getInstance();
      int i = APCloudWaitActivity.c(APCloudWaitActivity.this);
      String str = p4.p().e().f.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("channelid=");
      localStringBuilder.append(APCloudWaitActivity.b(APCloudWaitActivity.this));
      paramView.insertData("sdk.cloudgame.cancel", i, str, null, localStringBuilder.toString());
      APCloudWaitActivity.d(APCloudWaitActivity.this);
    }
  }
  
  public class c
    implements View.OnKeyListener
  {
    public c() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      paramView = APDataReportManager.getInstance();
      paramInt = APCloudWaitActivity.e(APCloudWaitActivity.this);
      paramKeyEvent = p4.p().e().f.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("channelid=");
      localStringBuilder.append(APCloudWaitActivity.b(APCloudWaitActivity.this));
      paramView.insertData("sdk.cloudgame.keyback", paramInt, paramKeyEvent, null, localStringBuilder.toString());
      APCloudWaitActivity.d(APCloudWaitActivity.this);
      return true;
    }
  }
  
  public class d
    implements u6.b
  {
    public d(TextView paramTextView, Button paramButton1, Button paramButton2) {}
    
    public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {}
    
    public void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      localTextView.setText("正在支付，请稍后...     ");
      localButton1.setEnabled(true);
      localButton2.setEnabled(true);
      APCloudWaitActivity.a(APCloudWaitActivity.this, true);
    }
    
    public void c(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      int i = (int)(paramLong1 - paramLong2);
      CharSequence localCharSequence = APCloudWaitActivity.a(APCloudWaitActivity.this, "正在支付，请稍后...(%ss)", i);
      localTextView.setText(localCharSequence, TextView.BufferType.SPANNABLE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.module.push.APCloudWaitActivity
 * JD-Core Version:    0.7.0.1
 */