package midas.x;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class db
  implements sa
{
  public b a = new b(null);
  
  public void a(final gb paramgb, final ra paramra)
  {
    if (paramra == null) {
      return;
    }
    this.a.execute(new a(paramra, paramgb));
  }
  
  public class a
    implements Runnable
  {
    public a(ra paramra, gb paramgb) {}
    
    public void run()
    {
      paramra.a(paramgb);
    }
  }
  
  public static class b
    implements Executor
  {
    public final Handler a = new Handler(Looper.getMainLooper());
    
    public void execute(Runnable paramRunnable)
    {
      this.a.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.db
 * JD-Core Version:    0.7.0.1
 */