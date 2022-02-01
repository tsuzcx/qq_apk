package c.t.m.g;

public final class ac
  implements Runnable
{
  private aa a;
  private boolean b;
  private boolean c;
  private String d;
  
  public ac(w paramw, aa paramaa, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    this.a = paramaa;
    this.b = paramBoolean1;
    this.d = paramString;
    this.c = paramBoolean2;
  }
  
  public final void run()
  {
    int j = 1;
    Object localObject = this.e;
    localObject = this.a;
    boolean bool1 = this.b;
    String str = this.d;
    boolean bool2 = this.c;
    aj localaj = new aj();
    localaj.a = o.b();
    localaj.b = o.c();
    localaj.c = o.d();
    localaj.d = o.f();
    localaj.e = o.e();
    localaj.h = aw.c();
    if (localaj.h == 1)
    {
      localaj.g = aw.a();
      localaj.i = aw.d();
      if (!aw.e()) {
        break label410;
      }
      i = 1;
      label121:
      localaj.l = i;
      if (localObject != null)
      {
        localaj.j = ((aa)localObject).b;
        localaj.k = ((aa)localObject).a;
        localaj.m = ((aa)localObject).h;
        localaj.n = ((aa)localObject).o;
        localaj.o = ((aa)localObject).n;
        localaj.p = 0;
        localaj.q = ((aa)localObject).f;
        localaj.r = 0;
        localaj.s = ((aa)localObject).g;
        localaj.v = ((aa)localObject).i;
        localaj.t = ((aa)localObject).k;
        localaj.y = ((aa)localObject).m;
        localaj.z = ((aa)localObject).c;
        localaj.u = ((aa)localObject).l;
        localaj.F = ((aa)localObject).e;
        localaj.w = ((aa)localObject).j;
      }
      localaj.D = ((aa)localObject).q;
      localaj.x = ((aa)localObject).p;
      if (!bool1) {
        break label415;
      }
      i = 0;
      label336:
      localaj.A = i;
      if (!bool2) {
        break label420;
      }
      i = 0;
      label349:
      localaj.B = i;
      if (!h.a) {
        break label425;
      }
    }
    label410:
    label415:
    label420:
    label425:
    for (int i = j;; i = 0)
    {
      localaj.C = i;
      localaj.E = str;
      if (q.a() != null)
      {
        q.a();
        q.a(localaj);
      }
      ax.b("HttpAccessClientImpl", "finish report");
      return;
      localaj.f = aw.a();
      break;
      i = 0;
      break label121;
      i = 1;
      break label336;
      i = 1;
      break label349;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.ac
 * JD-Core Version:    0.7.0.1
 */