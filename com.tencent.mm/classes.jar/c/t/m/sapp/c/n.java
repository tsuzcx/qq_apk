package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
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
    AppMethodBeat.i(186148);
    a = TencentLocation.class.getPackage().getName();
    b = null;
    AppMethodBeat.o(186148);
  }
  
  public n(Context paramContext)
  {
    AppMethodBeat.i(186140);
    this.e = false;
    this.c = paramContext;
    AppMethodBeat.o(186140);
  }
  
  public static n a(Context paramContext)
  {
    AppMethodBeat.i(186143);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new n(paramContext);
      }
      paramContext = b;
      AppMethodBeat.o(186143);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(186143);
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(186233);
    if (!this.e)
    {
      this.d = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(b);
      this.e = true;
    }
    AppMethodBeat.o(186233);
  }
  
  public final boolean a(Throwable paramThrowable)
  {
    AppMethodBeat.i(186235);
    Throwable localThrowable = paramThrowable;
    if (paramThrowable == null)
    {
      AppMethodBeat.o(186235);
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
        if ("TLSAPP".equals(paramThrowable[i].getFileName()))
        {
          AppMethodBeat.o(186235);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(186235);
    return false;
  }
  
  public final String b(Throwable paramThrowable)
  {
    AppMethodBeat.i(186239);
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
    finally
    {
      label74:
      break label74;
    }
    paramThrowable = localStringBuffer.toString();
    AppMethodBeat.o(186239);
    return paramThrowable;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    AppMethodBeat.i(186232);
    Object localObject;
    if ((a(paramThrowable)) && (this.c != null))
    {
      localObject = b(paramThrowable);
      if ((!((String)localObject).contains("onLocationChanged")) && (!((String)localObject).contains("onStatusUpdate")))
      {
        r.c(this.c, "__bad_dex_info___sapp", r.d);
        r.b(this.c, "__loc_sdk_run_duration___sapp", Long.valueOf(System.currentTimeMillis() - r.e));
        paramThrowable = "EXP:" + r.d + "," + (String)localObject;
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
      AppMethodBeat.o(186232);
      return;
      localObject = this.d;
      if (localObject != null) {
        ((Thread.UncaughtExceptionHandler)localObject).uncaughtException(paramThread, paramThrowable);
      }
      AppMethodBeat.o(186232);
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
      AppMethodBeat.i(186215);
      this.a = paramString;
      AppMethodBeat.o(186215);
    }
    
    public void run()
    {
      AppMethodBeat.i(186218);
      e.a(n.a(n.this)).a(this.a);
      n.b(n.this).countDown();
      AppMethodBeat.o(186218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.sapp.c.n
 * JD-Core Version:    0.7.0.1
 */