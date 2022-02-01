package c.t.m.g;

import android.os.Bundle;

public abstract class be
  implements bi
{
  private String a;
  private String b;
  private boolean c;
  
  public be(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = true;
  }
  
  public final Object a(Bundle paramBundle)
  {
    if (!this.c) {
      return null;
    }
    return b(paramBundle);
  }
  
  public void a() {}
  
  protected abstract Object b(Bundle paramBundle);
  
  public String toString()
  {
    return "[name=" + this.a + ",desc=" + this.b + ",enabled=" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.be
 * JD-Core Version:    0.7.0.1
 */