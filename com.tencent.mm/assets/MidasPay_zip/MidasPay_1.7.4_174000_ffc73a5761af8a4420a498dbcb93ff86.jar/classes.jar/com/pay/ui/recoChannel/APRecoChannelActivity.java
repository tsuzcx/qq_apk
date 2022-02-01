package com.pay.ui.recoChannel;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.realname.APRealnameRegistActivity;
import com.tencent.midas.comm.APLog;
import midas.x.a;
import midas.x.bl;
import midas.x.el;
import midas.x.em;
import midas.x.fa;
import midas.x.fb;
import midas.x.fe;
import midas.x.fv;
import midas.x.fy;
import midas.x.jd;

public class APRecoChannelActivity
  extends APActivity
{
  public static jd a;
  public static boolean b = false;
  public String c = "";
  AP3PointsLoading d;
  private String e = "";
  
  public static boolean a()
  {
    return b;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        if (this.d != null) {
          this.d.d();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("from:");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(";to:");
        ((StringBuilder)localObject).append(paramInt2);
        APLog.i("APRecoChannelActivity refreshView", ((StringBuilder)localObject).toString());
        if (paramInt2 == 3)
        {
          a = jd.b("getChannel");
          setContentView(a.a(this, this, paramBundle));
          this.d = ((AP3PointsLoading)findViewById(2131099699));
          this.d.b();
          return;
        }
        if (paramInt2 == 1)
        {
          if (!TextUtils.isEmpty(this.p.e.j)) {
            break label627;
          }
          localObject = "all";
          APDataReportManager.getInstance().insertData("sdk.channellist.show", this.f, em.b().n().e.l, em.b().n().e.f, (String)localObject);
          this.c = em.b().n().e.f;
          a = jd.a(this);
          setContentView(a.a(this, this, paramBundle));
          return;
        }
        if (paramInt2 == 2)
        {
          APDataReportManager.getInstance().insertData("sdk.payexpress.show", em.b().n().a.saveType, em.b().n().e.l, em.b().n().e.f, null);
          if (("hfpay".equals(this.c)) && (this.f == 4)) {
            this.e = em.b().n().e.g;
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
              ((StringBuilder)localObject).append(em.b().n().e.f);
              APLog.d("APRecoChannelActivity", ((StringBuilder)localObject).toString());
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("to Sure Page. curChannelId=");
              ((StringBuilder)localObject).append(this.c);
              APLog.d("APRecoChannelActivity", ((StringBuilder)localObject).toString());
              em.b().n().e.f = this.c;
            }
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("curChannelId:");
          ((StringBuilder)localObject).append(this.c);
          APLog.i("APRecoChannelActivity refreshView", ((StringBuilder)localObject).toString());
          a = jd.b(em.b().n().e.f);
          paramBundle = a.a(this, this, paramBundle);
          if (paramBundle != null)
          {
            setContentView(paramBundle);
            return;
          }
        }
      }
      catch (Throwable paramBundle)
      {
        paramBundle.printStackTrace();
        localObject = APDataReportManager.getInstance();
        String str = em.b().n().e.f;
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    bl.a().a(paramInt1, paramInt2, paramIntent);
    if (a.a(paramInt1, paramInt2, paramIntent)) {
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      if ((fy.a().f()) && (a.a().d != null))
      {
        a.a().f = true;
        i = 0;
      }
    }
    catch (Throwable paramBundle)
    {
      int i;
      label46:
      paramBundle.printStackTrace();
      localObject = APDataReportManager.getInstance();
      String str = em.b().n().e.f;
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
    g();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("to:");
    ((StringBuilder)localObject).append(i);
    APLog.i("APRecoChannelActivity onCreate", ((StringBuilder)localObject).toString());
    if (i == 3)
    {
      APHFChannel.f();
      a = jd.b("getChannel");
      setContentView(a.a(this, this, paramBundle));
      this.d = ((AP3PointsLoading)findViewById(2131099699));
      this.d.setText("正在获取支付方式");
      this.d.b();
      fb.a().a(this, new fe()
      {
        public void a()
        {
          APRecoChannelActivity.this.d.a();
        }
        
        public void a(int paramAnonymousInt)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onFinish resultCode=");
          ((StringBuilder)localObject).append(paramAnonymousInt);
          APLog.e("APRecoChannelActivity", ((StringBuilder)localObject).toString());
          APRecoChannelActivity.this.d.a();
          if (paramAnonymousInt == 1320)
          {
            localObject = new Intent();
            ((Intent)localObject).setClass(APRecoChannelActivity.this, APRealnameRegistActivity.class);
            APRecoChannelActivity.this.startActivity((Intent)localObject);
            APRecoChannelActivity.this.finish();
            APUICommonMethod.b(APRecoChannelActivity.this);
            return;
          }
          if (paramAnonymousInt == 1319)
          {
            APUICommonMethod.b();
            fv.a(paramAnonymousInt, "");
            return;
          }
          localObject = em.b().n().e.j;
          String str = em.b().n().e.f;
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
            APUICommonMethod.b(APRecoChannelActivity.this);
          }
        }
        
        public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          APRecoChannelActivity.this.d.a();
        }
      }, null);
      return;
    }
    if (i == 1)
    {
      if (TextUtils.isEmpty(this.p.e.j))
      {
        localObject = "all";
        label200:
        APDataReportManager.getInstance().insertData("sdk.channellist.show", this.f, em.b().n().e.l, em.b().n().e.f, (String)localObject);
        this.c = em.b().n().e.f;
        a = jd.a(this);
        setContentView(a.a(this, this, paramBundle));
      }
    }
    else
    {
      APDataReportManager.getInstance().insertData("sdk.payexpress.show", em.b().n().a.saveType, em.b().n().e.l, em.b().n().e.f, null);
      this.c = em.b().n().e.f;
      if (("hfpay".equals(this.c)) && (this.f == 4)) {
        this.e = em.b().n().e.g;
      }
      a = jd.b(this.c);
      paramBundle = a.a(this, this, paramBundle);
      if (paramBundle != null)
      {
        setContentView(paramBundle);
        return;
        finish();
        APUICommonMethod.b(this);
        return;
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.d != null) {
      this.d.d();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (a()) {
        return true;
      }
      if ((a != null) && (a.a(this, paramInt, paramKeyEvent))) {
        return true;
      }
      if ((this.d != null) && (this.d.c())) {
        this.d.a();
      }
      if (("hfpay".equals(this.c)) && (this.f == 4) && (!TextUtils.isEmpty(this.e))) {
        em.b().n().e.g = this.e;
      }
      APDataReportManager.getInstance().insertData("sdk.payexpress.keyback", this.f);
      APUICommonMethod.b();
      fv.a(2, "");
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
    if (a != null) {
      a.a();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.recoChannel.APRecoChannelActivity
 * JD-Core Version:    0.7.0.1
 */