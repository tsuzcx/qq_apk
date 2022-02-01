package midas.x;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.Map;

public class bs
{
  private br a;
  private String b;
  
  public static bs a()
  {
    return b.a();
  }
  
  public void a(final Context paramContext, final ResultReceiver paramResultReceiver)
  {
    bu.a().a("key_client_message", new bu.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void a(br paramAnonymousbr)
      {
        if (paramAnonymousbr.a() == 1)
        {
          bu.a().a(paramAnonymousbr.b());
          return;
        }
        if (paramAnonymousbr.a() == 3) {
          bs.this.a(paramContext, paramAnonymousbr);
        }
      }
      
      public void a(jn paramAnonymousjn)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFailure response = ");
        localStringBuilder.append(paramAnonymousjn);
        APLog.e("MidasPushClient", localStringBuilder.toString());
      }
      
      public void b(int paramAnonymousInt, String paramAnonymousString)
      {
        if (paramResultReceiver != null)
        {
          paramAnonymousString = new Bundle();
          paramAnonymousString.putInt("code", 0);
          paramAnonymousString.putString("msg", "");
          paramResultReceiver.send(0, paramAnonymousString);
        }
      }
    });
  }
  
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest, ResultReceiver paramResultReceiver)
  {
    if (bq.d())
    {
      a(paramContext, paramResultReceiver);
      bu.a().a(bq.h(), new a(new Handler()));
      return;
    }
    if (paramResultReceiver != null)
    {
      paramContext = new Bundle();
      paramContext.putInt("code", 0);
      paramContext.putString("msg", "");
      paramResultReceiver.send(0, paramContext);
    }
  }
  
  public void a(Context paramContext, br parambr)
  {
    APLog.d("MidasPushClient", "receiveData() begin");
    ef localef = new ef(new lw()
    {
      public void a(lh paramAnonymouslh) {}
      
      public void b(lh paramAnonymouslh) {}
      
      public void c(lh paramAnonymouslh) {}
    });
    if (TextUtils.isEmpty(parambr.c))
    {
      paramContext = new StringBuilder();
      paramContext.append("cloud decoded data = Null : ");
      paramContext.append(parambr.c);
      APLog.e("MidasPushClient", paramContext.toString());
      return;
    }
    if (!localef.a(parambr))
    {
      APLog.e("MidasPushClient", "!saveAns.handleCloudJson(data) = false, return");
      return;
    }
    String str = localef.a();
    if (this.a != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("receiveData() mOldData = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", mNewData = ");
      localStringBuilder.append(parambr);
      APLog.d("MidasPushClient", localStringBuilder.toString());
      a(str, -3, 0, new Bundle());
    }
    this.b = ((String)APTools.c(localef.b()).get("identify"));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveData() mMessageIdentify = ");
    localStringBuilder.append(this.b);
    APLog.d("MidasPushClient", localStringBuilder.toString());
    this.a = parambr;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveData() mFromData <= data = ");
    localStringBuilder.append(parambr);
    APLog.d("MidasPushClient", localStringBuilder.toString());
    fb.a(str).c(paramContext, localef);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    APLog.d("MidasPushClient", "responseData() begin");
    if (this.a == null)
    {
      APLog.w("MidasPushClient", "responseData() mFromData == null, return");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("cloudCallback_resultState", paramInt1);
    localBundle.putString("cloudCallback_resultChannel", paramString);
    localBundle.putInt("cloudCallback_resultCode", paramInt2);
    localBundle.putBundle("cloudCallback_resultData", paramBundle);
    localBundle.putString("cloudCallback_resultIdentify", this.b);
    paramString = new StringBuilder();
    paramString.append("responseData() bundle = ");
    paramString.append(localBundle);
    APLog.d("MidasPushClient", paramString.toString());
    paramString = new br(APTools.b(localBundle), this.a.a.b, this.a.a.c, this.a.a.d);
    paramBundle = new StringBuilder();
    paramBundle.append("responseData()  mFromData = ");
    paramBundle.append(this.a);
    paramBundle.append(", MsgIdentify=");
    paramBundle.append(this.b);
    APLog.d("MidasPushClient", paramBundle.toString());
    this.a = null;
    this.b = "";
    bu.a().a(paramString);
  }
  
  public void b()
  {
    bu.a().a("key_client_message");
    bu.a().a("key_test_message");
    if (bu.a().b() <= 0) {
      bu.a().e();
    }
  }
  
  class a
    implements jo.c
  {
    private volatile long b;
    private volatile long c = 64L;
    private Handler d;
    private a e;
    
    public a(Handler paramHandler)
    {
      if (paramHandler != null)
      {
        this.d = paramHandler;
        this.e = new a(15);
        this.b = 0L;
        return;
      }
      throw new IllegalArgumentException("handler is Null");
    }
    
    public boolean a(Runnable paramRunnable)
    {
      try
      {
        this.b += 1L;
        if (this.c > 0L)
        {
          long l1 = this.b;
          long l2 = this.c;
          if (l1 > l2) {
            return false;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("retry() mRetryCount.next = ");
        localStringBuilder.append(this.b);
        APLog.d("DefaultRetryer", localStringBuilder.toString());
        this.d.postDelayed(paramRunnable, this.e.a() * 1000L);
        return true;
      }
      finally {}
    }
    
    public void b(Runnable paramRunnable)
    {
      try
      {
        this.e = new a(15);
        this.d.removeCallbacks(paramRunnable);
        this.b = 0L;
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
    
    class a
    {
      int a;
      int b;
      int c;
      
      public a(int paramInt)
      {
        b();
        this.c = paramInt;
      }
      
      public int a()
      {
        if ((this.a == 0) && (this.b == 0))
        {
          this.a = 1;
          return 0;
        }
        int i = this.a + this.b;
        if (i > this.c) {
          return this.a;
        }
        this.b = this.a;
        this.a = i;
        return this.a;
      }
      
      public void b()
      {
        this.a = 0;
        this.b = 0;
      }
    }
  }
  
  static class b
  {
    private static bs a = new bs(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.bs
 * JD-Core Version:    0.7.0.1
 */