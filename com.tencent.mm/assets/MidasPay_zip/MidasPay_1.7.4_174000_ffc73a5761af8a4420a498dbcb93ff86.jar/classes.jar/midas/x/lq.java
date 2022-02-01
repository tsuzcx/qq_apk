package midas.x;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class lq
{
  private final kx a;
  private final lx b;
  private String c;
  private ln.c d;
  private a e;
  private d f;
  private c g;
  private lt h;
  private b i;
  private lu j;
  private lv k;
  private AtomicBoolean l = new AtomicBoolean(false);
  private Context m;
  private String n;
  private boolean o = true;
  private boolean p = false;
  
  public lq(ku paramku)
  {
    this.a = new kx(paramku);
    this.b = new lx();
  }
  
  private void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 20000)) {
      this.a.a = paramInt;
    }
  }
  
  private void b(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 20000)) {
      this.a.b = paramInt;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.b.b(paramString1, paramString2);
  }
  
  public kz a(lj paramlj)
  {
    return this.a.a(paramlj).a();
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.m = paramContext;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.b(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.b.b(paramString1, paramString2, paramString3);
  }
  
  void a(ky paramky, kz paramkz)
  {
    if (this.h != null) {
      this.h.a(paramky, paramkz);
    }
  }
  
  void a(kz paramkz)
  {
    if (paramkz == null) {
      return;
    }
    if (TextUtils.isEmpty(paramkz.b)) {
      return;
    }
    if (this.j != null) {
      this.j.a(paramkz);
    }
  }
  
  void a(lj paramlj, kl paramkl)
  {
    if (paramlj != null) {
      this.a.a(paramlj).b(paramkl);
    }
  }
  
  public void a(lj paramlj, lh paramlh)
  {
    if (paramlh != null) {
      paramlh.a(paramlj);
    }
    this.a.a(paramlj).a(paramlh);
  }
  
  public void a(ln.c paramc)
  {
    this.d = paramc;
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
  
  public void a(lt paramlt)
  {
    this.h = paramlt;
  }
  
  public void a(lu paramlu)
  {
    this.j = paramlu;
  }
  
  public void a(lv paramlv)
  {
    if (paramlv == null) {
      return;
    }
    this.k = paramlv;
  }
  
  boolean a()
  {
    return this.p;
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return this.b.b(paramContext, paramString1, paramString2, paramString3);
  }
  
  public boolean a(ky paramky)
  {
    boolean bool2 = false;
    if (paramky == null) {
      return false;
    }
    Object localObject = e();
    if (localObject == null) {
      return false;
    }
    localObject = localObject.getClass().getSimpleName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    paramky = paramky.getClass().getSimpleName();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramky))
    {
      bool1 = bool2;
      if (paramky.equals(localObject)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  String b()
  {
    return this.n;
  }
  
  public String b(String paramString1, String paramString2)
  {
    return this.b.a(paramString1, paramString2);
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b.g(paramContext, paramString1, paramString2, paramString3);
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
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    this.b.a(paramString1, paramString2, paramString3);
  }
  
  void b(ky paramky, kz paramkz)
  {
    if (this.h != null) {
      this.h.b(paramky, paramkz);
    }
  }
  
  public String c(String paramString1, String paramString2)
  {
    return this.b.c(paramString1, paramString2);
  }
  
  public void c()
  {
    if (!this.l.compareAndSet(false, true))
    {
      ks.a("MidasNetworkManager", "Cannot set up second time");
      return;
    }
    this.a.a(2);
    if (this.o) {
      this.a.a(new ln(this.c, this.d));
    }
    this.a.a(new lg(this));
    this.a.a(new ls(this));
    this.a.a(new ll(this));
    this.a.a(new lm(this));
    this.a.a(new lo(this));
    this.a.a(new lr(this));
    this.a.a(new le(this));
    this.a.a(new lp(this));
    this.a.a(new lb(this));
    this.a.b(new la(this));
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b.f(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.c(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void c(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void c(String paramString1, String paramString2, String paramString3)
  {
    this.b.c(paramString1, paramString2, paramString3);
  }
  
  void d()
  {
    if (this.e != null) {
      a(this.e.a());
    }
    if (this.f != null) {
      b(this.f.a());
    }
  }
  
  public void d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  void d(String paramString)
  {
    if (this.g != null) {
      this.g.a(paramString);
    }
  }
  
  lj e()
  {
    if (this.i != null) {
      return this.i.a();
    }
    return null;
  }
  
  Context f()
  {
    if (this.m != null) {
      return this.m;
    }
    return null;
  }
  
  public lv g()
  {
    return this.k;
  }
  
  public static abstract interface a
  {
    public abstract int a();
  }
  
  public static abstract interface b
  {
    public abstract lj a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lq
 * JD-Core Version:    0.7.0.1
 */