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
import midas.x.el;
import midas.x.em;
import midas.x.fa;
import midas.x.fb;
import midas.x.gq;
import midas.x.gq.a;

public class APCloudWaitActivity
  extends APActivity
{
  private static ResultReceiver q;
  private String a;
  private long b = 6L;
  private long c = 0L;
  private long d = 1L;
  private gq e;
  private boolean r = true;
  private View.OnKeyListener s;
  
  private CharSequence a(String paramString, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramString = paramString.split("%s");
    localSpannableStringBuilder.append(paramString[0]);
    int i = 1;
    String str = String.format("%s", new Object[] { Integer.valueOf(paramInt) });
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#338aec")), 0, str.length(), 0);
    localSpannableStringBuilder.append(localSpannableString);
    paramInt = i;
    while (paramInt < paramString.length)
    {
      localSpannableStringBuilder.append(paramString[paramInt]);
      paramInt += 1;
    }
    return localSpannableStringBuilder;
  }
  
  public static void a()
  {
    Activity localActivity = APUICommonMethod.c();
    if ((localActivity != null) && ((localActivity instanceof APCloudWaitActivity)))
    {
      localActivity.finish();
      APUICommonMethod.b(localActivity);
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    if (q != null) {
      q.send(paramInt, paramBundle);
    }
  }
  
  private void a(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131100043);
    localTextView.setGravity(1);
    localTextView.setText(paramString);
  }
  
  private void a(String paramString, boolean paramBoolean, View.OnClickListener paramOnClickListener)
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
  
  private void a(boolean paramBoolean, View.OnKeyListener paramOnKeyListener)
  {
    this.r = paramBoolean;
    this.s = paramOnKeyListener;
  }
  
  private void b()
  {
    this.a = getIntent().getStringExtra("channelId");
    q = (ResultReceiver)getIntent().getParcelableExtra("receiver");
  }
  
  private void b(int paramInt, Bundle paramBundle)
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
    i();
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("cloudCallback_resultCode", paramInt);
    ((Bundle)localObject).putParcelable("cloudCallback_resultData", paramBundle);
    a(2, (Bundle)localObject);
  }
  
  private void b(String paramString, boolean paramBoolean, View.OnClickListener paramOnClickListener)
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
  
  private void c()
  {
    a("正在支付，请稍后...     ");
    a("已支付", false, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = APDataReportManager.getInstance();
        int i = APCloudWaitActivity.a(APCloudWaitActivity.this);
        String str = em.b().n().e.l;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("channelid=");
        localStringBuilder.append(APCloudWaitActivity.b(APCloudWaitActivity.this));
        paramAnonymousView.insertData("sdk.cloudgame.sure", i, str, null, localStringBuilder.toString());
        APCloudWaitActivity.a(APCloudWaitActivity.this, 0, null);
      }
    });
    b("取消", true, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = APDataReportManager.getInstance();
        int i = APCloudWaitActivity.c(APCloudWaitActivity.this);
        String str = em.b().n().e.l;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("channelid=");
        localStringBuilder.append(APCloudWaitActivity.b(APCloudWaitActivity.this));
        paramAnonymousView.insertData("sdk.cloudgame.cancel", i, str, null, localStringBuilder.toString());
        APCloudWaitActivity.d(APCloudWaitActivity.this);
      }
    });
    a(false, new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousView = APDataReportManager.getInstance();
        paramAnonymousInt = APCloudWaitActivity.e(APCloudWaitActivity.this);
        paramAnonymousKeyEvent = em.b().n().e.l;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("channelid=");
        localStringBuilder.append(APCloudWaitActivity.b(APCloudWaitActivity.this));
        paramAnonymousView.insertData("sdk.cloudgame.keyback", paramAnonymousInt, paramAnonymousKeyEvent, null, localStringBuilder.toString());
        APCloudWaitActivity.d(APCloudWaitActivity.this);
        return true;
      }
    });
    d();
  }
  
  private void d()
  {
    if (this.e == null)
    {
      final Button localButton1 = (Button)findViewById(2131099705);
      final Button localButton2 = (Button)findViewById(2131099703);
      localButton1.setEnabled(false);
      localButton1.setVisibility(0);
      localButton2.setEnabled(false);
      localButton2.setVisibility(0);
      this.r = false;
      final TextView localTextView = (TextView)findViewById(2131100043);
      this.e = new gq(this.b, this.c, this.d, new gq.a()
      {
        public void a(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3, long paramAnonymousLong4)
        {
          int i = (int)(paramAnonymousLong1 - paramAnonymousLong2);
          CharSequence localCharSequence = APCloudWaitActivity.a(APCloudWaitActivity.this, "正在支付，请稍后...(%ss)", i);
          localTextView.setText(localCharSequence, TextView.BufferType.SPANNABLE);
        }
        
        public void b(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3, long paramAnonymousLong4) {}
        
        public void c(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3, long paramAnonymousLong4)
        {
          localTextView.setText("正在支付，请稍后...     ");
          localButton1.setEnabled(true);
          localButton2.setEnabled(true);
          APCloudWaitActivity.a(APCloudWaitActivity.this, true);
        }
      });
    }
    this.e.a();
  }
  
  private void h()
  {
    if (this.e != null) {
      this.e.b();
    }
  }
  
  private void i()
  {
    finish();
    APUICommonMethod.b(this);
  }
  
  private void j()
  {
    APLog.d("APCloudWaitActivity", "callbackCancel()");
    i();
    a(1, null);
    fb.a(this.a);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131165188);
    b();
    c();
  }
  
  public void onDestroy()
  {
    h();
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int i = this.f;
    String str = em.b().n().e.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelid=");
    localStringBuilder.append(this.a);
    localAPDataReportManager.insertData("sdk.cloudgame.close", i, str, null, localStringBuilder.toString());
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.r) {
      return true;
    }
    if (this.s != null) {
      return this.s.onKey(null, paramInt, paramKeyEvent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int i = this.f;
    String str = em.b().n().e.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelid=");
    localStringBuilder.append(this.a);
    localAPDataReportManager.insertData("sdk.cloudgame.show", i, str, null, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.module.push.APCloudWaitActivity
 * JD-Core Version:    0.7.0.1
 */