package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.map.tools.sheet.listener.ModuleUncaughtListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class n
  implements Thread.UncaughtExceptionHandler
{
  private static final String c;
  public volatile boolean a = false;
  public ModuleUncaughtListener b;
  private Context d;
  private CountDownLatch e;
  
  static
  {
    AppMethodBeat.i(180832);
    c = n.class.getSimpleName();
    AppMethodBeat.o(180832);
  }
  
  public n(Context paramContext)
  {
    this.d = paramContext;
  }
  
  private static String a(Throwable paramThrowable)
  {
    AppMethodBeat.i(180831);
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
      label70:
      break label70;
    }
    paramThrowable = localStringBuffer.toString();
    AppMethodBeat.o(180831);
    return paramThrowable;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    boolean bool = false;
    AppMethodBeat.i(180830);
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    if (paramThrowable != null)
    {
      localObject1 = paramThrowable;
      if (localObject1 != null)
      {
        localObject2 = ((Throwable)localObject1).getStackTrace();
        j = localObject2.length;
        i = 0;
        label34:
        if (i < j) {
          if ("TMS".equals(localObject2[i].getFileName())) {
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.d != null))
      {
        localObject1 = a(paramThrowable);
        if ((a.g != null) && (a.g.length > 0))
        {
          j = 0;
          i = 0;
          for (;;)
          {
            k = i;
            if (j >= a.g.length) {
              break;
            }
            if (((String)localObject1).contains(a.g[j])) {
              i = 1;
            }
            j += 1;
          }
          i += 1;
          break label34;
          localObject1 = ((Throwable)localObject1).getCause();
          break;
          i = 0;
          continue;
        }
        int k = 0;
        if (k == 0)
        {
          y.a(this.d, u.v, y.f);
          y.a(this.d, u.y, Long.valueOf(System.currentTimeMillis() - z.a));
          if (this.b != null) {
            bool = this.b.onModuleSDKCrashed(paramThrowable);
          }
          if (bool)
          {
            AppMethodBeat.o(180830);
            return;
          }
          localObject2 = "EXP:" + y.f + "," + (String)localObject1;
          localObject1 = localObject2;
          if (((String)localObject2).contains("\n")) {
            localObject1 = ((String)localObject2).replaceAll("\\n", "\\$");
          }
          this.e = new CountDownLatch(1);
          new a((String)localObject1).start();
        }
      }
    }
    try
    {
      this.e.await(3000L, TimeUnit.MILLISECONDS);
      label316:
      if (this.b != null) {
        this.b.uncaughtException(paramThread, paramThrowable);
      }
      AppMethodBeat.o(180830);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label316;
    }
  }
  
  final class a
    extends Thread
  {
    private String b;
    
    public a(String paramString)
    {
      AppMethodBeat.i(180826);
      this.b = (paramString + a());
      AppMethodBeat.o(180826);
    }
    
    private String a()
    {
      AppMethodBeat.i(180828);
      try
      {
        Object localObject = new StringBuffer();
        String str1 = y.c(n.a(n.this));
        String str2 = y.b() + "_" + y.a();
        int i = y.c();
        ((StringBuffer)localObject).append(str1).append(",").append(str2).append(",").append(i).append(",").append("").append(",").append(a.b).append(".").append(a.c).append(',').append(a.e).append(",").append(a.d);
        localObject = ((StringBuffer)localObject).toString();
        AppMethodBeat.o(180828);
        return localObject;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(180828);
      }
      return "";
    }
    
    public final void run()
    {
      AppMethodBeat.i(180827);
      Object localObject2 = g.a(n.a(n.this));
      Object localObject1 = this.b;
      if ((a.h) && (((g)localObject2).e != null))
      {
        localObject2 = ((g)localObject2).e;
        localObject1 = ((String)localObject1).getBytes();
        if (a.h) {
          ((k)localObject2).b.a((byte[])localObject1);
        }
      }
      n.b(n.this).countDown();
      AppMethodBeat.o(180827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.n
 * JD-Core Version:    0.7.0.1
 */