package c.t.m.sapp.c;

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
    AppMethodBeat.i(190441);
    this.c = "DexAsynchHandler";
    this.i = new SimpleDateFormat("HHmmss");
    this.j = new SimpleDateFormat("yyyyMMdd-HHmmss");
    this.g = paramContext.getApplicationContext();
    this.h = new k(this.g);
    AppMethodBeat.o(190441);
  }
  
  public static e a(Context paramContext)
  {
    AppMethodBeat.i(190442);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new e(paramContext);
      }
      paramContext = b;
      AppMethodBeat.o(190442);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(190442);
    }
  }
  
  public static e b()
  {
    return b;
  }
  
  public void a()
  {
    AppMethodBeat.i(190445);
    if (this.g == null)
    {
      AppMethodBeat.o(190445);
      return;
    }
    a(10005, null);
    AppMethodBeat.o(190445);
  }
  
  public final void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(190447);
    a locala = this.e;
    if (locala != null)
    {
      Message localMessage = locala.obtainMessage();
      localMessage.obj = paramString;
      localMessage.what = paramInt;
      o.a(locala, localMessage);
    }
    AppMethodBeat.o(190447);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(190444);
    try
    {
      if ((this.g != null) && (this.e != null) && (paramString != null) && (paramString.length() != 0))
      {
        p.a = 3000;
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = localStringBuilder1.append("LOC_CORE").append(',').append(this.j.format(new Date())).append(',').append(q.h(this.g)).append(',').append(q.l(this.g)).append(',').append(q.e()).append(',').append(q.f()).append(',').append(q.b()).append(',');
        paramString = localStringBuilder2.append("COMP").append(paramString);
        paramString.append("$");
        a(localStringBuilder1.toString().getBytes());
        AppMethodBeat.o(190444);
        return;
      }
      AppMethodBeat.o(190444);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(190444);
    }
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public boolean a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190446);
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
              AppMethodBeat.o(190446);
              return false;
            }
          }
          AppMethodBeat.o(190446);
          return true;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        AppMethodBeat.o(190446);
        return false;
      }
    }
    AppMethodBeat.o(190446);
    return true;
  }
  
  public final byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(190448);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      paramArrayOfByte = m.b(q.b(paramArrayOfByte), paramString);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        paramString = new byte[paramArrayOfByte.length + 2];
        System.arraycopy(q.a(paramArrayOfByte.length), 0, paramString, 0, 2);
        System.arraycopy(paramArrayOfByte, 0, paramString, 2, paramArrayOfByte.length);
        AppMethodBeat.o(190448);
        return paramString;
      }
      paramArrayOfByte = a;
      AppMethodBeat.o(190448);
      return paramArrayOfByte;
    }
    paramArrayOfByte = a;
    AppMethodBeat.o(190448);
    return paramArrayOfByte;
  }
  
  public void c()
  {
    AppMethodBeat.i(190443);
    if (this.f)
    {
      AppMethodBeat.o(190443);
      return;
    }
    this.d = new HandlerThread("d_thread");
    this.d.start();
    this.e = new a(this.d.getLooper());
    this.f = true;
    AppMethodBeat.o(190443);
  }
  
  public void d() {}
  
  public class a
    extends Handler
  {
    public StringBuilder a;
    
    public a(Looper paramLooper)
    {
      super();
      AppMethodBeat.i(190438);
      this.a = new StringBuilder(1024);
      this.a.setLength(0);
      AppMethodBeat.o(190438);
    }
    
    public void a(Message paramMessage)
    {
      AppMethodBeat.i(190440);
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        default: 
          AppMethodBeat.o(190440);
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        AppMethodBeat.o(190440);
        return;
      }
      q.a(e.a(e.this));
      AppMethodBeat.o(190440);
      return;
      AppMethodBeat.o(190440);
      return;
      AppMethodBeat.o(190440);
      return;
      g.a(e.a(e.this));
      AppMethodBeat.o(190440);
      return;
      AppMethodBeat.o(190440);
      return;
      AppMethodBeat.o(190440);
      return;
      AppMethodBeat.o(190440);
      return;
      AppMethodBeat.o(190440);
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(190439);
      super.handleMessage(paramMessage);
      a(paramMessage);
      AppMethodBeat.o(190439);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.sapp.c.e
 * JD-Core Version:    0.7.0.1
 */