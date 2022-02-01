package midas.x;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class kw
  implements km
{
  private a a = new a(null);
  
  public void a(final kz paramkz, final kl paramkl)
  {
    if (paramkl == null) {
      return;
    }
    this.a.execute(new Runnable()
    {
      public void run()
      {
        paramkl.a_(paramkz);
      }
    });
  }
  
  static class a
    implements Executor
  {
    private final Handler a = new Handler(Looper.getMainLooper());
    
    public void execute(Runnable paramRunnable)
    {
      this.a.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.kw
 * JD-Core Version:    0.7.0.1
 */