package c.t.m.g;

import android.text.TextUtils;

final class bg
  implements Runnable
{
  bg(bf parambf) {}
  
  public final void run()
  {
    String str = cj.b("settings_in_client", "");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.a.a.a(str);
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      cj.a("settings_in_client", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.bg
 * JD-Core Version:    0.7.0.1
 */