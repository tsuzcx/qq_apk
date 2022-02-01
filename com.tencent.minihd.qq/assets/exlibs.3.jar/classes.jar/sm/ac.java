package sm;

import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.impl.SecureService.a;
import com.tencent.securemodule.service.ICallback;

public class ac
  implements Runnable
{
  public ac(SecureService.a parama, String paramString, ICallback paramICallback) {}
  
  public void run()
  {
    int i = SecureService.a(this.c.a, this.a);
    if (this.b != null) {
      this.b.onTaskFinished(i);
    }
    this.c.a.stopSelf();
    SecureService.a(this.c.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     sm.ac
 * JD-Core Version:    0.7.0.1
 */