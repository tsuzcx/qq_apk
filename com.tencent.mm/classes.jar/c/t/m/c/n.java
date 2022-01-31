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
  private static final String a;
  private static n d;
  private Context b;
  private Thread.UncaughtExceptionHandler c;
  private volatile boolean e = false;
  private CountDownLatch f;
  
  static
  {
    AppMethodBeat.i(136394);
    a = TencentLocation.class.getPackage().getName();
    d = null;
    AppMethodBeat.o(136394);
  }
  
  private n(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static n a(Context paramContext)
  {
    AppMethodBeat.i(136389);
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new n(paramContext);
      }
      paramContext = d;
      AppMethodBeat.o(136389);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(136389);
    }
  }
  
  private boolean a(Throwable paramThrowable)
  {
    AppMethodBeat.i(136391);
    Throwable localThrowable = paramThrowable;
    if (paramThrowable == null)
    {
      AppMethodBeat.o(136391);
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
          AppMethodBeat.o(136391);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(136391);
    return false;
  }
  
  private String b(Throwable paramThrowable)
  {
    AppMethodBeat.i(136393);
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
    AppMethodBeat.o(136393);
    return paramThrowable;
  }
  
  public void a()
  {
    AppMethodBeat.i(136392);
    if (!this.e)
    {
      this.c = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(d);
      this.e = true;
    }
    AppMethodBeat.o(136392);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    AppMethodBeat.i(136390);
    if ((a(paramThrowable)) && (this.b != null))
    {
      String str = b(paramThrowable);
      if ((!str.contains("onLocationChanged")) && (!str.contains("onStatusUpdate")))
      {
        q.a(this.b, "__bad_dex_info__", q.b);
        q.a(this.b, "__loc_sdk_run_duration__", Long.valueOf(System.currentTimeMillis() - q.c));
        paramThrowable = "EXP:" + q.b + "," + str;
        paramThread = paramThrowable;
        if (paramThrowable.contains("\n")) {
          paramThread = paramThrowable.replaceAll("\n", "$");
        }
        this.f = new CountDownLatch(1);
        new n.a(this, paramThread).start();
      }
    }
    try
    {
      this.f.await(3000L, TimeUnit.MILLISECONDS);
      label163:
      TencentLocationManager.getInstance(this.b).removeUpdates(null);
      AppMethodBeat.o(136390);
      return;
      if (this.c != null) {
        this.c.uncaughtException(paramThread, paramThrowable);
      }
      AppMethodBeat.o(136390);
      return;
    }
    catch (InterruptedException paramThread)
    {
      break label163;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.c.n
 * JD-Core Version:    0.7.0.1
 */