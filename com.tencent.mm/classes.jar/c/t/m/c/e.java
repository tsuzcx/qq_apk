package c.t.m.c;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class e
{
  private static final byte[] b = new byte[0];
  private static e j;
  private final String a;
  private HandlerThread c;
  private e.a d;
  private boolean e;
  private Context f;
  private k g;
  private SimpleDateFormat h;
  private SimpleDateFormat i;
  
  private e(Context paramContext)
  {
    AppMethodBeat.i(136346);
    this.a = "DexAsynchHandler";
    this.h = new SimpleDateFormat("HHmmss");
    this.i = new SimpleDateFormat("yyyyMMdd-HHmmss");
    this.f = paramContext.getApplicationContext();
    this.g = new k(this.f);
    AppMethodBeat.o(136346);
  }
  
  public static e a()
  {
    return j;
  }
  
  public static e a(Context paramContext)
  {
    AppMethodBeat.i(136347);
    if (j == null) {}
    try
    {
      if (j == null) {
        j = new e(paramContext);
      }
      paramContext = j;
      AppMethodBeat.o(136347);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(136347);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(136351);
    e.a locala = this.d;
    if (locala != null)
    {
      Message localMessage = locala.obtainMessage();
      localMessage.obj = paramString;
      localMessage.what = paramInt;
      o.a(locala, localMessage);
    }
    AppMethodBeat.o(136351);
  }
  
  private byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(136353);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramArrayOfByte = b;
      AppMethodBeat.o(136353);
      return paramArrayOfByte;
    }
    paramArrayOfByte = m.a(q.b(paramArrayOfByte), paramString);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramArrayOfByte = b;
      AppMethodBeat.o(136353);
      return paramArrayOfByte;
    }
    paramString = new byte[paramArrayOfByte.length + 2];
    System.arraycopy(q.a(paramArrayOfByte.length), 0, paramString, 0, 2);
    System.arraycopy(paramArrayOfByte, 0, paramString, 2, paramArrayOfByte.length);
    AppMethodBeat.o(136353);
    return paramString;
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(136349);
    try
    {
      if ((this.f != null) && (this.d != null) && (paramString != null))
      {
        int k = paramString.length();
        if (k != 0) {}
      }
      else
      {
        AppMethodBeat.o(136349);
        return;
      }
      p.a = 3000;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LOC_CORE,").append(this.i.format(new Date())).append(',').append(q.e(this.f)).append(',').append(q.d(this.f)).append(',').append(q.b()).append(',').append(q.a()).append(',').append(q.c()).append(',').append("COMP").append(paramString).append("$");
      a(localStringBuilder.toString().getBytes());
      AppMethodBeat.o(136349);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(136349);
    }
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public boolean a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136352);
    if (paramArrayOfByte != null) {}
    try
    {
      int k = paramArrayOfByte.length;
      if (k == 0)
      {
        AppMethodBeat.o(136352);
        return true;
      }
      paramArrayOfByte = a(paramArrayOfByte, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
      if (paramArrayOfByte != null)
      {
        k = paramArrayOfByte.length;
        if (k != 0) {}
      }
      else
      {
        AppMethodBeat.o(136352);
        return true;
      }
      if (p.a("https://analytics.map.qq.com/tr?mllc", paramArrayOfByte) == null) {
        this.g.a(paramArrayOfByte);
      }
      AppMethodBeat.o(136352);
      return false;
    }
    catch (Throwable paramArrayOfByte)
    {
      AppMethodBeat.o(136352);
    }
    return false;
  }
  
  public void b()
  {
    AppMethodBeat.i(136348);
    if (this.e)
    {
      AppMethodBeat.o(136348);
      return;
    }
    this.c = new HandlerThread("d_thread");
    this.c.start();
    this.d = new e.a(this, this.c.getLooper());
    this.e = true;
    AppMethodBeat.o(136348);
  }
  
  public void c() {}
  
  public void d()
  {
    AppMethodBeat.i(136350);
    if (this.f == null)
    {
      AppMethodBeat.o(136350);
      return;
    }
    a(10005, null);
    AppMethodBeat.o(136350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.c.e
 * JD-Core Version:    0.7.0.1
 */