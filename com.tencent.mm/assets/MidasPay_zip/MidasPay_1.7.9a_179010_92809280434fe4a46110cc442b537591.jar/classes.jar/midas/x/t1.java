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

public class t1
{
  public s1 a;
  public String b;
  
  public static t1 b()
  {
    return d.a();
  }
  
  public void a()
  {
    v1.e().a("key_client_message");
    v1.e().a("key_test_message");
    if (v1.e().c() <= 0) {
      v1.e().a();
    }
  }
  
  public void a(final Context paramContext, final ResultReceiver paramResultReceiver)
  {
    v1.e().a("key_client_message", new a(paramContext, paramResultReceiver));
  }
  
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest, ResultReceiver paramResultReceiver)
  {
    if (r1.g())
    {
      a(paramContext, paramResultReceiver);
      v1.e().a(r1.e(), new c(new Handler()), paramAPBaseRequest);
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
  
  public void a(Context paramContext, s1 params1)
  {
    APLog.d("MidasPushClient", "receiveData() begin");
    i4 locali4 = new i4(new b());
    if (TextUtils.isEmpty(params1.c))
    {
      paramContext = new StringBuilder();
      paramContext.append("cloud decoded data = Null : ");
      paramContext.append(params1.c);
      APLog.e("MidasPushClient", paramContext.toString());
      return;
    }
    if (!locali4.a(params1))
    {
      APLog.e("MidasPushClient", "!saveAns.handleCloudJson(data) = false, return");
      return;
    }
    String str = locali4.A();
    if (this.a != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("receiveData() mOldData = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", mNewData = ");
      localStringBuilder.append(params1);
      APLog.d("MidasPushClient", localStringBuilder.toString());
      a(str, -3, 0, new Bundle());
    }
    this.b = ((String)APTools.i(locali4.h()).get("identify"));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveData() mMessageIdentify = ");
    localStringBuilder.append(this.b);
    APLog.d("MidasPushClient", localStringBuilder.toString());
    this.a = params1;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveData() mFromData <= data = ");
    localStringBuilder.append(params1);
    APLog.d("MidasPushClient", localStringBuilder.toString());
    e5.a(str).b(paramContext, locali4);
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
    paramString = APTools.b(localBundle);
    paramBundle = this.a.a;
    paramString = new s1(paramString, paramBundle.b, paramBundle.c, paramBundle.d);
    paramBundle = new StringBuilder();
    paramBundle.append("responseData()  mFromData = ");
    paramBundle.append(this.a);
    paramBundle.append(", MsgIdentify=");
    paramBundle.append(this.b);
    APLog.d("MidasPushClient", paramBundle.toString());
    this.a = null;
    this.b = "";
    v1.e().a(paramString);
  }
  
  public class a
    implements v1.d
  {
    public a(Context paramContext, ResultReceiver paramResultReceiver) {}
    
    public void a(int paramInt, String paramString) {}
    
    public void a(s1 params1)
    {
      if (params1.b() == 1)
      {
        v1.e().a(params1.c());
        return;
      }
      if (params1.b() == 3) {
        t1.this.a(paramContext, params1);
      }
    }
    
    public void a(t9 paramt9)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFailure response = ");
      localStringBuilder.append(paramt9);
      APLog.e("MidasPushClient", localStringBuilder.toString());
    }
    
    public void b(int paramInt, String paramString)
    {
      if (paramResultReceiver != null)
      {
        paramString = new Bundle();
        paramString.putInt("code", 0);
        paramString.putString("msg", "");
        paramResultReceiver.send(0, paramString);
      }
    }
  }
  
  public class b
    implements fc
  {
    public b() {}
    
    public void a(ob paramob) {}
    
    public void b(ob paramob) {}
    
    public void c(ob paramob) {}
  }
  
  public class c
    implements u9.d
  {
    public volatile long a;
    public volatile long b = 64L;
    public Handler c;
    public a d;
    
    public c(Handler paramHandler)
    {
      if (paramHandler != null)
      {
        this.c = paramHandler;
        this.d = new a(15);
        this.a = 0L;
        return;
      }
      throw new IllegalArgumentException("handler is Null");
    }
    
    public void a(Runnable paramRunnable)
    {
      try
      {
        this.d = new a(15);
        this.c.removeCallbacks(paramRunnable);
        this.a = 0L;
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
    
    public boolean b(Runnable paramRunnable)
    {
      try
      {
        this.a += 1L;
        if (this.b > 0L)
        {
          long l1 = this.a;
          long l2 = this.b;
          if (l1 > l2) {
            return false;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("retry() mRetryCount.next = ");
        localStringBuilder.append(this.a);
        APLog.d("DefaultRetryer", localStringBuilder.toString());
        this.c.postDelayed(paramRunnable, this.d.a() * 1000L);
        return true;
      }
      finally {}
    }
    
    public class a
    {
      public int a;
      public int b;
      public int c;
      
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
        int i = this.a;
        int j = this.b + i;
        if (j > this.c) {
          return i;
        }
        this.b = i;
        this.a = j;
        return this.a;
      }
      
      public void b()
      {
        this.a = 0;
        this.b = 0;
      }
    }
  }
  
  public static class d
  {
    public static t1 a = new t1(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.t1
 * JD-Core Version:    0.7.0.1
 */