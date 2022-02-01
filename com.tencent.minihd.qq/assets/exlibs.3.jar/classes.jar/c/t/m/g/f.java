package c.t.m.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
{
  public String a;
  public String b;
  public String c;
  public int d;
  public String e;
  public String f;
  public String g;
  public ArrayList h;
  public int i;
  public int j;
  public int k;
  public String l;
  public String m;
  public r n;
  public boolean o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  
  public final g a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = new bc();
    aw.b();
    if (!aw.e())
    {
      this.k = -4;
      this.l = "Network fail before schedule";
      return null;
    }
    Object localObject2 = new ae(this.a, this.b, this.h, this.e, this.c, this.d, this.i, this.j, this.g);
    ((bc)localObject1).b("#halley-proxy.HalleyDispatchService");
    ((bc)localObject1).a("srvDispatch");
    ((bc)localObject1).a("request", localObject2);
    this.f = ay.b(this.h.toString());
    localObject1 = i.a((bc)localObject1);
    ((aq)localObject1).b();
    this.o = aw.e();
    this.n = ((aq)localObject1).e();
    this.p = ((aq)localObject1).h();
    this.q = ((aq)localObject1).f();
    this.r = ((aq)localObject1).i();
    this.s = ((aq)localObject1).g();
    if ((((aq)localObject1).c() == 0) && (((aq)localObject1).a() != null))
    {
      localObject1 = ((aq)localObject1).a();
      localObject2 = new af();
      try
      {
        localObject1 = (af)((bc)localObject1).b("response", localObject2);
        if (localObject1 == null)
        {
          this.k = -8;
          this.l = "Response is Null";
          return null;
        }
      }
      catch (Exception localException)
      {
        ax.a("ScheduleRequestImpl", "wup decode fail.", localException);
        this.k = -8;
        this.m = localException.getClass().getSimpleName();
        this.l = ay.a(localException);
        return null;
      }
      localObject2 = new g();
      Object localObject3 = aw.a();
      long l2 = System.currentTimeMillis();
      if ((!((String)localObject3).equals("unkonwn")) && (((String)localObject3).equals(this.g)))
      {
        localObject3 = localException.a;
        if ((localObject3 != null) && (((Map)localObject3).size() > 0))
        {
          s locals = new s(this.g);
          Iterator localIterator = ((Map)localObject3).keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject4 = (String)localIterator.next();
            if (((Map)localObject3).get(localObject4) != null)
            {
              Object localObject5 = ((ag)((Map)localObject3).get(localObject4)).a;
              localObject4 = new s.a((String)localObject4, l2, ((ag)localException.a.get(localObject4)).b);
              localObject5 = ((ArrayList)localObject5).iterator();
              while (((Iterator)localObject5).hasNext())
              {
                String str = (String)((Iterator)localObject5).next();
                r localr = new r();
                if (localr.a(str)) {
                  ((s.a)localObject4).c.add(localr);
                } else {
                  ax.c("ScheduleRequestImpl", "parse ipPort fail. ipPort:" + str);
                }
              }
              locals.a((s.a)localObject4);
            }
          }
          ((g)localObject2).a = locals;
        }
      }
      for (;;)
      {
        if (localException.c != null) {
          ((g)localObject2).b = new d(localException.c);
        }
        if (localException.b != null) {
          ((g)localObject2).c = new c(localException.b);
        }
        this.t = ((int)(System.currentTimeMillis() - l1));
        return localObject2;
        ((g)localObject2).a = null;
        this.k = -9;
        this.l = ("req apn:" + this.g + ",current apn:" + (String)localObject3);
      }
    }
    this.k = localException.c();
    this.m = localException.d();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.f
 * JD-Core Version:    0.7.0.1
 */