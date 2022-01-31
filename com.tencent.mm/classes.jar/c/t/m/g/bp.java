package c.t.m.g;

import android.os.Build;
import android.os.Build.VERSION;

public final class bp
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public bp()
  {
    try
    {
      this.a = Build.MODEL;
      this.b = Build.VERSION.RELEASE;
      this.c = cm.a();
      this.d = cm.b();
      cm.e();
      this.e = cm.f();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.bp
 * JD-Core Version:    0.7.0.1
 */