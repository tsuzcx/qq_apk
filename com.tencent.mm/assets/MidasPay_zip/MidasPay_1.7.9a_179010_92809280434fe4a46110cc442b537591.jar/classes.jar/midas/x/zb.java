package midas.x;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class zb
{
  public final eb a;
  public final gc b;
  public String c;
  public ub.e d;
  public a e;
  public d f;
  public c g;
  public cc h;
  public b i;
  public dc j;
  public ec k;
  public AtomicBoolean l = new AtomicBoolean(false);
  public Context m;
  public String n;
  public boolean o = true;
  public boolean p = false;
  
  public zb(ab paramab)
  {
    this.a = new eb(paramab);
    this.b = new gc();
  }
  
  public String a()
  {
    return this.n;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.b.b(paramString1, paramString2);
  }
  
  public gb a(qb paramqb)
  {
    return this.a.a(paramqb).a();
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 20000)) {
      this.a.h = paramInt;
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.m = paramContext;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.b(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.b.b(paramString1, paramString2, paramString3);
  }
  
  public void a(cc paramcc)
  {
    this.h = paramcc;
  }
  
  public void a(dc paramdc)
  {
    this.j = paramdc;
  }
  
  public void a(ec paramec)
  {
    if (paramec == null) {
      return;
    }
    this.k = paramec;
  }
  
  public void a(fb paramfb, gb paramgb)
  {
    cc localcc = this.h;
    if (localcc != null) {
      localcc.a(paramfb, paramgb);
    }
  }
  
  public void a(gb paramgb)
  {
    if (paramgb == null) {
      return;
    }
    if (TextUtils.isEmpty(paramgb.b)) {
      return;
    }
    dc localdc = this.j;
    if (localdc != null) {
      localdc.a(paramgb);
    }
  }
  
  public void a(qb paramqb, ob paramob)
  {
    if (paramob != null) {
      paramob.a(paramqb);
    }
    this.a.a(paramqb).a(paramob);
  }
  
  public void a(qb paramqb, ra paramra)
  {
    if (paramqb != null) {
      this.a.a(paramqb).b(paramra);
    }
  }
  
  public void a(ub.e parame)
  {
    this.d = parame;
  }
  
  public void a(a parama)
  {
    this.e = parama;
  }
  
  public void a(b paramb)
  {
    this.i = paramb;
  }
  
  public void a(c paramc)
  {
    this.g = paramc;
  }
  
  public void a(d paramd)
  {
    this.f = paramd;
  }
  
  public boolean a(fb paramfb)
  {
    boolean bool2 = false;
    if (paramfb == null) {
      return false;
    }
    Object localObject = c();
    if (localObject == null) {
      return false;
    }
    localObject = localObject.getClass().getSimpleName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    paramfb = paramfb.getClass().getSimpleName();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramfb))
    {
      bool1 = bool2;
      if (paramfb.equals(localObject)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Context b()
  {
    Context localContext = this.m;
    if (localContext != null) {
      return localContext;
    }
    return null;
  }
  
  public String b(String paramString1, String paramString2)
  {
    return this.b.a(paramString1, paramString2);
  }
  
  public final void b(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 20000)) {
      this.a.i = paramInt;
    }
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b.b(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.a(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.n = paramString;
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    this.b.a(paramString1, paramString2, paramString3);
  }
  
  public void b(fb paramfb, gb paramgb)
  {
    cc localcc = this.h;
    if (localcc != null) {
      localcc.b(paramfb, paramgb);
    }
  }
  
  public String c(String paramString1, String paramString2)
  {
    return this.b.c(paramString1, paramString2);
  }
  
  public qb c()
  {
    b localb = this.i;
    if (localb != null) {
      return localb.a();
    }
    return null;
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b.c(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.c(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public void c(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    this.b.c(paramString1, paramString2, paramString3);
  }
  
  public ec d()
  {
    return this.k;
  }
  
  public void d(String paramString)
  {
    c localc = this.g;
    if (localc != null) {
      localc.a(paramString);
    }
  }
  
  public boolean d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return this.b.d(paramContext, paramString1, paramString2, paramString3);
  }
  
  public boolean e()
  {
    return this.p;
  }
  
  public void f()
  {
    if (!this.l.compareAndSet(false, true))
    {
      ya.b("MidasNetworkManager", "Cannot set up second time");
      return;
    }
    this.a.a(2);
    if (this.o) {
      this.a.a(new ub(this.c, this.d));
    }
    this.a.a(new nb(this));
    this.a.a(new bc(this));
    this.a.a(new sb(this));
    this.a.a(new tb(this));
    this.a.a(new xb(this));
    this.a.a(new ac(this));
    this.a.a(new lb(this));
    this.a.a(new yb(this));
    this.a.a(new ib(this));
    this.a.b(new hb(this));
  }
  
  public void g()
  {
    Object localObject = this.e;
    if (localObject != null) {
      a(((a)localObject).a());
    }
    localObject = this.f;
    if (localObject != null) {
      b(((d)localObject).a());
    }
  }
  
  public static abstract interface a
  {
    public abstract int a();
  }
  
  public static abstract interface b
  {
    public abstract qb a();
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString);
  }
  
  public static abstract interface d
  {
    public abstract int a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.zb
 * JD-Core Version:    0.7.0.1
 */