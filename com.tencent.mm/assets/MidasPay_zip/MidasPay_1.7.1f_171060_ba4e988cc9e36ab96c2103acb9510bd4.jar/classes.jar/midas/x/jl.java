package midas.x;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class jl
  implements jb
{
  private a a = new a(null);
  
  public void a(final jo paramjo, final ja paramja)
  {
    if (paramja == null) {
      return;
    }
    this.a.execute(new Runnable()
    {
      public void run()
      {
        paramja.a_(paramjo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jl
 * JD-Core Version:    0.7.0.1
 */