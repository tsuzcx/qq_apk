package com.pay.ui.recoChannel;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.paychannel.unionpay.APUnionPayChannel;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.realname.APRealnameRegistActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.a;
import midas.x.c6;
import midas.x.d5;
import midas.x.e5;
import midas.x.h5;
import midas.x.i5;
import midas.x.j9;
import midas.x.m1;
import midas.x.o4;
import midas.x.p4;
import midas.x.r1;
import midas.x.v1;
import midas.x.z5;

public class APRecoChannelActivity
  extends APActivity
{
  public static j9 g;
  public static boolean h = false;
  public String d = "";
  public AP3PointsLoading e;
  public String f = "";
  
  public static boolean f()
  {
    return h;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        if (this.e != null) {
          this.e.a();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("from:");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(";to:");
        ((StringBuilder)localObject).append(paramInt2);
        APLog.i("APRecoChannelActivity refreshView22", ((StringBuilder)localObject).toString());
        if (paramInt2 == 3)
        {
          g = j9.a("getChannel");
          setContentView(g.a(this, this, paramBundle));
          this.e = ((AP3PointsLoading)findViewById(2131099699));
          this.e.c();
          return;
        }
        if (paramInt2 == 1)
        {
          if (!TextUtils.isEmpty(this.c.f.i)) {
            break label627;
          }
          localObject = "all";
          APDataReportManager.getInstance().insertData("sdk.channellist.show", this.a, p4.p().e().f.k, p4.p().e().f.e, (String)localObject);
          this.d = p4.p().e().f.e;
          g = j9.a(this);
          setContentView(g.a(this, this, paramBundle));
          return;
        }
        if (paramInt2 == 2)
        {
          APDataReportManager.getInstance().insertData("sdk.payexpress.show", p4.p().e().b.saveType, p4.p().e().f.k, p4.p().e().f.e, null);
          if (("hfpay".equals(this.d)) && (this.a == 4)) {
            this.f = p4.p().e().f.f;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("to Sure Page. bundle=");
          ((StringBuilder)localObject).append(paramBundle);
          APLog.d("APRecoChannelActivity", ((StringBuilder)localObject).toString());
          if (paramBundle != null)
          {
            boolean bool = paramBundle.getBoolean("fromBack", false);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("to Sure Page. fromBack=");
            ((StringBuilder)localObject).append(bool);
            APLog.d("APRecoChannelActivity", ((StringBuilder)localObject).toString());
            if (bool)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("to Sure Page. payChannel=");
              ((StringBuilder)localObject).append(p4.p().e().f.e);
              APLog.d("APRecoChannelActivity", ((StringBuilder)localObject).toString());
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("to Sure Page. curChannelId=");
              ((StringBuilder)localObject).append(this.d);
              APLog.d("APRecoChannelActivity", ((StringBuilder)localObject).toString());
              p4.p().e().f.e = this.d;
            }
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("curChannelId:");
          ((StringBuilder)localObject).append(this.d);
          APLog.i("APRecoChannelActivity refreshView", ((StringBuilder)localObject).toString());
          g = j9.a(p4.p().e().f.e);
          paramBundle = g.a(this, this, paramBundle);
          if (paramBundle != null)
          {
            setContentView(paramBundle);
            return;
          }
        }
      }
      finally
      {
        paramBundle.printStackTrace();
        localObject = APDataReportManager.getInstance();
        String str = p4.p().e().f.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("APRecoChannelActivity_refreshView_");
        localStringBuilder.append(APTools.d(paramBundle));
        ((APDataReportManager)localObject).a("sdk.err.view", str, localStringBuilder.toString());
      }
      return;
      label627:
      Object localObject = "change";
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    m1.d().a(paramInt1, paramInt2, paramIntent);
    APLog.i("APRecoChannelActivity onActivityResult", "arg0");
    e5.h();
    i5 locali5 = e5.a("wechat_quickpass");
    if ((locali5 != null) && ((locali5 instanceof APUnionPayChannel))) {
      ((APUnionPayChannel)locali5).a(paramInt1, paramInt2, paramIntent);
    }
    if (g.a(paramInt1, paramInt2, paramIntent)) {
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      if ((c6.s0().i()) && (a.r().d != null))
      {
        a.r().f = true;
        i = 0;
      }
    }
    finally
    {
      int i;
      label46:
      paramBundle.printStackTrace();
      localObject = APDataReportManager.getInstance();
      String str = p4.p().e().f.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APRecoChannelActivity_onCreate_");
      localStringBuilder.append(APTools.d(paramBundle));
      ((APDataReportManager)localObject).a("sdk.err.view", str, localStringBuilder.toString());
    }
    try
    {
      paramBundle = getIntent().getExtras();
    }
    catch (Exception paramBundle)
    {
      break label46;
      localObject = "change";
      break label200;
    }
    paramBundle = null;
    if (paramBundle != null) {
      i = paramBundle.getInt("to");
    }
    e();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("to:");
    ((StringBuilder)localObject).append(i);
    APLog.i("APRecoChannelActivity onCreate", ((StringBuilder)localObject).toString());
    if (i == 3)
    {
      APHFChannel.j();
      g = j9.a("getChannel");
      setContentView(g.a(this, this, paramBundle));
      this.e = ((AP3PointsLoading)findViewById(2131099699));
      this.e.setText("正在获取支付方式");
      this.e.c();
      e5.h().a(this, new a(), null);
      return;
    }
    if (i == 1)
    {
      if (TextUtils.isEmpty(this.c.f.i))
      {
        localObject = "all";
        label200:
        APDataReportManager.getInstance().insertData("sdk.channellist.show", this.a, p4.p().e().f.k, p4.p().e().f.e, (String)localObject);
        this.d = p4.p().e().f.e;
        g = j9.a(this);
        setContentView(g.a(this, this, paramBundle));
      }
    }
    else
    {
      APDataReportManager.getInstance().insertData("sdk.payexpress.show", p4.p().e().b.saveType, p4.p().e().f.k, p4.p().e().f.e, null);
      this.d = p4.p().e().f.e;
      if (("hfpay".equals(this.d)) && (this.a == 4)) {
        this.f = p4.p().e().f.f;
      }
      g = j9.a(this.d);
      paramBundle = g.a(this, this, paramBundle);
      if (paramBundle != null)
      {
        setContentView(paramBundle);
        return;
        finish();
        APUICommonMethod.a(this);
        return;
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    AP3PointsLoading localAP3PointsLoading = this.e;
    if (localAP3PointsLoading != null) {
      localAP3PointsLoading.a();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (f()) {
        return true;
      }
      j9 localj9 = g;
      if ((localj9 != null) && (localj9.a(this, paramInt, paramKeyEvent))) {
        return true;
      }
      paramKeyEvent = this.e;
      if ((paramKeyEvent != null) && (paramKeyEvent.b())) {
        this.e.d();
      }
      if (("hfpay".equals(this.d)) && (this.a == 4) && (!TextUtils.isEmpty(this.f))) {
        p4.p().e().f.f = this.f;
      }
      APDataReportManager.getInstance().insertData("sdk.payexpress.keyback", this.a);
      APUICommonMethod.f();
      z5.a(2, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    j9 localj9 = g;
    if (localj9 != null) {
      localj9.a();
    }
    if ((r1.i()) && (!r1.h())) {
      v1.e().d();
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public class a
    implements h5
  {
    public a() {}
    
    public void a()
    {
      APRecoChannelActivity.this.e.d();
    }
    
    public void a(int paramInt)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFinish resultCode=");
      ((StringBuilder)localObject).append(paramInt);
      APLog.e("APRecoChannelActivity", ((StringBuilder)localObject).toString());
      APRecoChannelActivity.this.e.d();
      if (paramInt == 1320)
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(APRecoChannelActivity.this, APRealnameRegistActivity.class);
        APRecoChannelActivity.this.startActivity((Intent)localObject);
        APRecoChannelActivity.this.finish();
        APUICommonMethod.a(APRecoChannelActivity.this);
        return;
      }
      if (paramInt == 1319)
      {
        APUICommonMethod.f();
        z5.a(paramInt, "");
        return;
      }
      localObject = p4.p().e().f.i;
      String str = p4.p().e().f.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("express:");
      localStringBuilder.append((String)localObject);
      APLog.e("Reco", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("payChannel:");
      localStringBuilder.append(str);
      APLog.e("Reco", localStringBuilder.toString());
      if ((!TextUtils.isEmpty(str)) && (str.equals(localObject)) && (("cft".equals(localObject)) || ("bank".equals(localObject))))
      {
        APRecoChannelActivity.this.finish();
        APUICommonMethod.a(APRecoChannelActivity.this);
      }
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      APRecoChannelActivity.this.e.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.recoChannel.APRecoChannelActivity
 * JD-Core Version:    0.7.0.1
 */