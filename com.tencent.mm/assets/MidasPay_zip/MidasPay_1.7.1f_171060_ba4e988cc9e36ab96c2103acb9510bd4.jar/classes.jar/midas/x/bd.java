package midas.x;

import android.os.Handler;
import android.os.Message;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;

public class bd
{
  private static volatile bd b;
  public Handler a;
  private final String c = bd.class.getSimpleName();
  private bc d = null;
  private bc e = null;
  private String f;
  private b g;
  private int h = 0;
  private int i = 0;
  private String j = "release";
  private String k;
  private boolean l = false;
  private boolean m = false;
  private String n;
  private int o = 0;
  
  public static bd a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new bd();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (bc.a)paramMessage.obj;
    switch (paramMessage.a)
    {
    case 2: 
    default: 
      return;
    case 4: 
      e();
      return;
    case 3: 
      if (this.d != null)
      {
        this.d.b();
        this.d = null;
      }
      this.o = 27;
      return;
    case 1: 
      d();
      this.g.a(paramMessage.c);
      return;
    }
    d();
    if (paramMessage.b == -3)
    {
      this.g.b();
      return;
    }
    this.g.c();
  }
  
  private void d()
  {
    String str = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.k);
    localStringBuilder.append(":inner stop");
    APLog.i(str, localStringBuilder.toString());
    c();
  }
  
  private void e()
  {
    d();
    this.g.c();
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, b paramb)
  {
    this.f = paramString3;
    this.g = paramb;
    this.a = new a(this);
    this.j = paramString4;
    this.k = paramString1;
    this.m = true;
    this.n = paramString2;
    this.o = 27;
  }
  
  public void b()
  {
    String str = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.k);
    localStringBuilder.append(":start");
    APLog.i(str, localStringBuilder.toString());
    if (this.l)
    {
      str = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.k);
      localStringBuilder.append(":connecting return");
      APLog.i(str, localStringBuilder.toString());
      return;
    }
    d();
    this.l = true;
    this.o = 27;
    this.a.obtainMessage(1).sendToTarget();
  }
  
  public void c()
  {
    String str = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.k);
    localStringBuilder.append(":stop");
    APLog.i(str, localStringBuilder.toString());
    this.a.removeMessages(3);
    this.a.removeMessages(2);
    this.a.removeMessages(4);
    if (this.d != null)
    {
      this.d.b();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.b();
      this.e = null;
    }
    this.o = 27;
    this.l = false;
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<bd> a;
    
    public a(bd parambd)
    {
      this.a = new WeakReference(parambd);
    }
    
    public void handleMessage(Message paramMessage)
    {
      bd localbd = (bd)this.a.get();
      if (localbd == null) {
        return;
      }
      Object localObject;
      StringBuilder localStringBuilder;
      switch (paramMessage.what)
      {
      default: 
        break;
      case 4: 
        localObject = bd.a(localbd);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(bd.b(localbd));
        localStringBuilder.append(":MSG_RECONNECT");
        APLog.i((String)localObject, localStringBuilder.toString());
        bd.b(localbd, 1);
        break;
      case 3: 
        localObject = bd.a(localbd);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(bd.b(localbd));
        localStringBuilder.append(":tick timer");
        APLog.i((String)localObject, localStringBuilder.toString());
        if ((bd.c(localbd) == bd.d(localbd)) && (bd.d(localbd) > 0))
        {
          paramMessage = bd.a(localbd);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(bd.b(localbd));
          ((StringBuilder)localObject).append(":timeout");
          APLog.i(paramMessage, ((StringBuilder)localObject).toString());
          bd.e(localbd);
          bd.f(localbd).a();
          return;
        }
        if (bd.c(localbd) % bd.g(localbd) == 0)
        {
          localObject = bd.a(localbd);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(bd.b(localbd));
          localStringBuilder.append(":heart beat timer coming");
          APLog.i((String)localObject, localStringBuilder.toString());
          if (bd.h(localbd) != null) {
            bd.a(localbd, bd.h(localbd));
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(System.currentTimeMillis());
          ((StringBuilder)localObject).append("");
          bd.b(localbd, new bc(((StringBuilder)localObject).toString(), bd.i(localbd), localbd.a, bd.j(localbd), bd.k(localbd), 2));
          bd.h(localbd).a();
        }
        if (bd.c(localbd) == 2147483647) {
          bd.a(localbd, 0);
        }
        bd.l(localbd);
        localObject = Message.obtain();
        ((Message)localObject).what = 3;
        localbd.a.sendMessageDelayed((Message)localObject, 10000L);
        break;
      case 2: 
        bd.a(localbd, paramMessage);
        break;
      case 1: 
        bd.a(localbd, 0);
        localbd.a.sendEmptyMessage(3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bd
 * JD-Core Version:    0.7.0.1
 */