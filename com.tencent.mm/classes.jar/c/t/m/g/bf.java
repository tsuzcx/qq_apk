package c.t.m.g;

import android.os.Handler;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bf
  extends bc
  implements cd
{
  ad a = new ad();
  private List<Object> b = new ArrayList();
  
  public bf()
  {
    m.i().post(new bg(this));
  }
  
  public final String a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return this.a.a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5);
  }
  
  final void a()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    finally {}
  }
  
  public final void a(String paramString1, String arg2)
  {
    if ((!TextUtils.isEmpty(???)) && (!bk.a().b().equals(???))) {
      bk.a().a(???, true);
    }
    if (!TextUtils.isEmpty(paramString1)) {}
    synchronized (this.a)
    {
      this.a.b();
      this.a.a(paramString1);
      cj.a("settings_in_client", this.a.a());
      a();
      return;
    }
  }
  
  public final String b()
  {
    return "settings";
  }
  
  public final void c()
  {
    cf.d().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.g.bf
 * JD-Core Version:    0.7.0.1
 */