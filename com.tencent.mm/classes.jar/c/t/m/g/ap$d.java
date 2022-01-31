package c.t.m.g;

import java.util.ArrayList;
import java.util.List;

final class ap$d
  extends ap.a
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d = false;
  public List<az.a> e;
  int f;
  
  public ap$d(ap paramap, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramap, (byte)0);
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
  
  public final void run()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int k = 0;
    this.a = false;
    ap.a(x.a.a("report_max_report_count", 10, 100, 20));
    if (this.b)
    {
      int m = ap.e(this.g).size();
      if (m == 0) {}
      for (;;)
      {
        this.e = ((List)localObject1);
        if ((this.e != null) && (this.e.size() != 0)) {
          break;
        }
        ap.g(this.g);
        return;
        localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        i = 0;
        int j = 0;
        while ((i < m) && (j < ap.d()))
        {
          String str = (String)ap.e(this.g).get(i);
          ((List)localObject1).add(new az.a(0L, str));
          ((List)localObject2).add(str);
          j += 1;
          i += 1;
        }
        i = 0;
        while (i < ((List)localObject2).size())
        {
          ap.e(this.g).remove(((List)localObject2).get(i));
          i += 1;
        }
        if (ap.e(this.g).size() == 0) {
          this.a = true;
        }
      }
    }
    int i = x.a.a("report_clear_db_num", 1, 10000, 1000);
    if (az.a(this.g.b()).a(i)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      this.e = ((List)localObject1);
      break;
      localObject1 = az.a(this.g.b()).b(ap.d() + 1);
      if (((List)localObject1).size() <= ap.d())
      {
        this.a = true;
        ap.a(this.g, true);
      }
      else
      {
        ((List)localObject1).remove(((List)localObject1).size() - 1);
      }
    }
    localObject1 = new StringBuilder();
    i = k;
    while (i < this.e.size())
    {
      ((StringBuilder)localObject1).append(((az.a)this.e.get(i)).b).append("\n");
      i += 1;
    }
    localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (this.b)
    {
      localObject1 = localObject2;
      if (((String)localObject2).contains("client_report_time")) {
        localObject1 = ((String)localObject2).replace("client_report_time", cm.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
      }
    }
    localObject1 = ((String)localObject1).getBytes();
    i = localObject1.length;
    this.f = i;
    localObject1 = x.a.a((byte[])localObject1);
    ap.b(localObject1.length);
    ap.i(this.g).a((byte[])localObject1, i, this.b, this, ap.h(this.g));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.ap.d
 * JD-Core Version:    0.7.0.1
 */