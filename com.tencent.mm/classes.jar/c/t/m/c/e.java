package c.t.m.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class e
{
  public static final byte[] a = new byte[0];
  public static e b;
  public final String c;
  public HandlerThread d;
  public a e;
  public boolean f;
  public Context g;
  public k h;
  public SimpleDateFormat i;
  public SimpleDateFormat j;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(39906);
    this.c = "DexAsynchHandler";
    this.i = new SimpleDateFormat("HHmmss");
    this.j = new SimpleDateFormat("yyyyMMdd-HHmmss");
    this.g = paramContext.getApplicationContext();
    this.h = new k(this.g);
    AppMethodBeat.o(39906);
  }
  
  public static e a(Context paramContext)
  {
    AppMethodBeat.i(39907);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new e(paramContext);
      }
      paramContext = b;
      AppMethodBeat.o(39907);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(39907);
    }
  }
  
  public static e b()
  {
    return b;
  }
  
  public void a()
  {
    AppMethodBeat.i(39910);
    if (this.g == null)
    {
      AppMethodBeat.o(39910);
      return;
    }
    a(10005, null);
    AppMethodBeat.o(39910);
  }
  
  public final void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(39912);
    a locala = this.e;
    if (locala != null)
    {
      Message localMessage = locala.obtainMessage();
      localMessage.obj = paramString;
      localMessage.what = paramInt;
      o.a(locala, localMessage);
    }
    AppMethodBeat.o(39912);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(39909);
    try
    {
      if ((this.g != null) && (this.e != null) && (paramString != null) && (paramString.length() != 0))
      {
        p.a = 3000;
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = localStringBuilder1.append("LOC_CORE").append(',').append(this.j.format(new Date())).append(',').append(q.g(this.g)).append(',').append(q.k(this.g)).append(',').append(q.d()).append(',').append(q.e()).append(',').append(q.b()).append(',');
        paramString = localStringBuilder2.append("COMP").append(paramString);
        paramString.append("$");
        a(localStringBuilder1.toString().getBytes());
        AppMethodBeat.o(39909);
        return;
      }
      AppMethodBeat.o(39909);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(39909);
    }
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public boolean a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39911);
    if (paramArrayOfByte != null) {
      try
      {
        int k = paramArrayOfByte.length;
        if (k != 0)
        {
          paramArrayOfByte = a(paramArrayOfByte, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
          if (paramArrayOfByte != null)
          {
            k = paramArrayOfByte.length;
            if (k != 0)
            {
              if (p.a("https://analytics.map.qq.com/tr?mllc", paramArrayOfByte) == null) {
                this.h.a(paramArrayOfByte);
              }
              AppMethodBeat.o(39911);
              return false;
            }
          }
          AppMethodBeat.o(39911);
          return true;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        AppMethodBeat.o(39911);
        return false;
      }
    }
    AppMethodBeat.o(39911);
    return true;
  }
  
  public final byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(39913);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      paramArrayOfByte = m.b(q.b(paramArrayOfByte), paramString);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        paramString = new byte[paramArrayOfByte.length + 2];
        System.arraycopy(q.a(paramArrayOfByte.length), 0, paramString, 0, 2);
        System.arraycopy(paramArrayOfByte, 0, paramString, 2, paramArrayOfByte.length);
        AppMethodBeat.o(39913);
        return paramString;
      }
      paramArrayOfByte = a;
      AppMethodBeat.o(39913);
      return paramArrayOfByte;
    }
    paramArrayOfByte = a;
    AppMethodBeat.o(39913);
    return paramArrayOfByte;
  }
  
  public void c()
  {
    AppMethodBeat.i(39908);
    if (this.f)
    {
      AppMethodBeat.o(39908);
      return;
    }
    this.d = new HandlerThread("d_thread");
    this.d.start();
    this.e = new a(this.d.getLooper());
    this.f = true;
    AppMethodBeat.o(39908);
  }
  
  public void d() {}
  
  public class a
    extends Handler
  {
    public StringBuilder a;
    
    public a(Looper paramLooper)
    {
      super();
      AppMethodBeat.i(39903);
      this.a = new StringBuilder(1024);
      this.a.setLength(0);
      AppMethodBeat.o(39903);
    }
    
    public void a(Message paramMessage)
    {
      AppMethodBeat.i(39905);
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        default: 
          AppMethodBeat.o(39905);
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        AppMethodBeat.o(39905);
        return;
      }
      q.a(e.a(e.this));
      AppMethodBeat.o(39905);
      return;
      AppMethodBeat.o(39905);
      return;
      AppMethodBeat.o(39905);
      return;
      g.a(e.a(e.this));
      AppMethodBeat.o(39905);
      return;
      AppMethodBeat.o(39905);
      return;
      AppMethodBeat.o(39905);
      return;
      AppMethodBeat.o(39905);
      return;
      AppMethodBeat.o(39905);
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(39904);
      super.handleMessage(paramMessage);
      a(paramMessage);
      AppMethodBeat.o(39904);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.c.e
 * JD-Core Version:    0.7.0.1
 */