package c.t.m.c;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class n
  implements Thread.UncaughtExceptionHandler
{
  public static final String a;
  public static n b;
  public Context c;
  public Thread.UncaughtExceptionHandler d;
  public volatile boolean e;
  public CountDownLatch f;
  
  static
  {
    AppMethodBeat.i(39961);
    a = TencentLocation.class.getPackage().getName();
    b = null;
    AppMethodBeat.o(39961);
  }
  
  public n(Context paramContext)
  {
    AppMethodBeat.i(39959);
    this.e = false;
    this.c = paramContext;
    AppMethodBeat.o(39959);
  }
  
  public static n a(Context paramContext)
  {
    AppMethodBeat.i(39960);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new n(paramContext);
      }
      paramContext = b;
      AppMethodBeat.o(39960);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(39960);
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(39963);
    if (!this.e)
    {
      this.d = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(b);
      this.e = true;
    }
    AppMethodBeat.o(39963);
  }
  
  public final boolean a(Throwable paramThrowable)
  {
    AppMethodBeat.i(39964);
    Throwable localThrowable = paramThrowable;
    if (paramThrowable == null)
    {
      AppMethodBeat.o(39964);
      return false;
    }
    for (;;)
    {
      localThrowable = localThrowable.getCause();
      if (localThrowable == null) {
        break;
      }
      paramThrowable = localThrowable.getStackTrace();
      int j = paramThrowable.length;
      int i = 0;
      while (i < j)
      {
        if ("TL".equals(paramThrowable[i].getFileName()))
        {
          AppMethodBeat.o(39964);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(39964);
    return false;
  }
  
  public final String b(Throwable paramThrowable)
  {
    AppMethodBeat.i(39965);
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      StringWriter localStringWriter = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramThrowable.printStackTrace(localPrintWriter);
      for (paramThrowable = paramThrowable.getCause(); paramThrowable != null; paramThrowable = paramThrowable.getCause()) {
        paramThrowable.printStackTrace(localPrintWriter);
      }
      localPrintWriter.close();
      localStringBuffer.append(localStringWriter.toString());
    }
    catch (Throwable paramThrowable)
    {
      label74:
      break label74;
    }
    paramThrowable = localStringBuffer.toString();
    AppMethodBeat.o(39965);
    return paramThrowable;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    AppMethodBeat.i(39962);
    Object localObject;
    if ((a(paramThrowable)) && (this.c != null))
    {
      localObject = b(paramThrowable);
      if ((!((String)localObject).contains("onLocationChanged")) && (!((String)localObject).contains("onStatusUpdate")))
      {
        q.b(this.c, "__bad_dex_info__", q.d);
        q.b(this.c, "__loc_sdk_run_duration__", Long.valueOf(System.currentTimeMillis() - q.e));
        paramThrowable = "EXP:" + q.d + "," + (String)localObject;
        paramThread = paramThrowable;
        if (paramThrowable.contains("\n")) {
          paramThread = paramThrowable.replaceAll("\n", "$");
        }
        this.f = new CountDownLatch(1);
        new a(paramThread).start();
      }
    }
    try
    {
      this.f.await(3000L, TimeUnit.MILLISECONDS);
      label163:
      TencentLocationManager.getInstance(this.c).removeUpdates(null);
      AppMethodBeat.o(39962);
      return;
      localObject = this.d;
      if (localObject != null) {
        ((Thread.UncaughtExceptionHandler)localObject).uncaughtException(paramThread, paramThrowable);
      }
      AppMethodBeat.o(39962);
      return;
    }
    catch (InterruptedException paramThread)
    {
      break label163;
    }
  }
  
  public class a
    extends Thread
  {
    public String a;
    
    public a(String paramString)
    {
      AppMethodBeat.i(39957);
      this.a = paramString;
      AppMethodBeat.o(39957);
    }
    
    public void run()
    {
      AppMethodBeat.i(39958);
      e.a(n.a(n.this)).a(this.a);
      n.b(n.this).countDown();
      AppMethodBeat.o(39958);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.c.n
 * JD-Core Version:    0.7.0.1
 */