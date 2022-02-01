package midas.x;

import android.os.Handler;
import android.os.Message;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;

public class e1
{
  public static volatile e1 n;
  public final String a = e1.class.getSimpleName();
  public Handler b;
  public d1 c = null;
  public d1 d = null;
  public String e;
  public b f;
  public int g = 0;
  public int h = 0;
  public String i = "release";
  public String j;
  public boolean k = false;
  public String l;
  public int m = 0;
  
  public static e1 e()
  {
    if (n == null) {
      try
      {
        if (n == null) {
          n = new e1();
        }
      }
      finally {}
    }
    return n;
  }
  
  public final void a()
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append(":inner stop");
    APLog.i(str, localStringBuilder.toString());
    d();
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void a(Message paramMessage)
  {
    paramMessage = (d1.a)paramMessage.obj;
    int i1 = paramMessage.a;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return;
          }
          b();
          return;
        }
        paramMessage = this.c;
        if (paramMessage != null)
        {
          paramMessage.c();
          this.c = null;
        }
        this.m = 27;
        return;
      }
      a();
      this.f.a(paramMessage.c);
      return;
    }
    a();
    if (paramMessage.b == -3)
    {
      this.f.c();
      return;
    }
    this.f.a();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, b paramb)
  {
    this.e = paramString3;
    this.f = paramb;
    this.b = new a(this);
    this.i = paramString4;
    this.j = paramString1;
    this.l = paramString2;
    this.m = 27;
  }
  
  public final void b()
  {
    a();
    this.f.a();
  }
  
  public void c()
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append(":start");
    APLog.i(str, localStringBuilder.toString());
    if (this.k)
    {
      str = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.j);
      localStringBuilder.append(":connecting return");
      APLog.i(str, localStringBuilder.toString());
      return;
    }
    a();
    this.k = true;
    this.m = 27;
    this.b.obtainMessage(1).sendToTarget();
  }
  
  public void d()
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append(":stop");
    APLog.i((String)localObject, localStringBuilder.toString());
    this.b.removeMessages(3);
    this.b.removeMessages(2);
    this.b.removeMessages(4);
    localObject = this.c;
    if (localObject != null)
    {
      ((d1)localObject).c();
      this.c = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((d1)localObject).c();
      this.d = null;
    }
    this.m = 27;
    this.k = false;
  }
  
  public static class a
    extends Handler
  {
    public final WeakReference<e1> a;
    
    public a(e1 parame1)
    {
      this.a = new WeakReference(parame1);
    }
    
    public void handleMessage(Message paramMessage)
    {
      e1 locale1 = (e1)this.a.get();
      if (locale1 == null) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2)
        {
          Object localObject;
          StringBuilder localStringBuilder;
          if (i != 3)
          {
            if (i == 4)
            {
              localObject = e1.c(locale1);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(e1.f(locale1));
              localStringBuilder.append(":MSG_RECONNECT");
              APLog.i((String)localObject, localStringBuilder.toString());
              e1.b(locale1, 1);
            }
          }
          else
          {
            localObject = e1.c(locale1);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(e1.f(locale1));
            localStringBuilder.append(":tick timer");
            APLog.i((String)localObject, localStringBuilder.toString());
            if ((e1.a(locale1) == e1.g(locale1)) && (e1.g(locale1) > 0))
            {
              paramMessage = e1.c(locale1);
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(e1.f(locale1));
              ((StringBuilder)localObject).append(":timeout");
              APLog.i(paramMessage, ((StringBuilder)localObject).toString());
              e1.h(locale1);
              e1.i(locale1).b();
              return;
            }
            if (e1.a(locale1) % e1.j(locale1) == 0)
            {
              localObject = e1.c(locale1);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(e1.f(locale1));
              localStringBuilder.append(":heart beat timer coming");
              APLog.i((String)localObject, localStringBuilder.toString());
              if (e1.k(locale1) != null) {
                e1.b(locale1, e1.k(locale1));
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(System.currentTimeMillis());
              ((StringBuilder)localObject).append("");
              e1.a(locale1, new d1(((StringBuilder)localObject).toString(), e1.l(locale1), locale1.b, e1.d(locale1), e1.e(locale1), 2));
              e1.k(locale1).d();
            }
            if (e1.a(locale1) == 2147483647) {
              e1.a(locale1, 0);
            }
            e1.b(locale1);
            localObject = Message.obtain();
            ((Message)localObject).what = 3;
            locale1.b.sendMessageDelayed((Message)localObject, 10000L);
          }
        }
        else
        {
          e1.a(locale1, paramMessage);
        }
      }
      else
      {
        e1.a(locale1, 0);
        locale1.b.sendEmptyMessage(3);
      }
      super.handleMessage(paramMessage);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(String paramString);
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.e1
 * JD-Core Version:    0.7.0.1
 */