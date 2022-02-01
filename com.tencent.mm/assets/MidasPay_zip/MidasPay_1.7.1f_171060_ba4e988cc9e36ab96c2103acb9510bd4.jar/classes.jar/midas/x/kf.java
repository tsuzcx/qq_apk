package midas.x;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class kf
{
  private final jm a;
  private final km b;
  private String c;
  private kc.c d;
  private a e;
  private d f;
  private c g;
  private ki h;
  private b i;
  private kj j;
  private kk k;
  private AtomicBoolean l = new AtomicBoolean(false);
  private Context m;
  private String n;
  private boolean o = true;
  private boolean p = false;
  
  public kf(jj paramjj)
  {
    this.a = new jm(paramjj);
    this.b = new km();
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
  
  public jo a(jy paramjy)
  {
    return this.a.a(paramjy).a();
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
  
  void a(jn paramjn, jo paramjo)
  {
    if (this.h != null) {
      this.h.a(paramjn, paramjo);
    }
  }
  
  void a(jo paramjo)
  {
    if (paramjo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramjo.b)) {
      return;
    }
    if (this.j != null) {
      this.j.a(paramjo);
    }
  }
  
  void a(jy paramjy, ja paramja)
  {
    if (paramjy != null) {
      this.a.a(paramjy).b(paramja);
    }
  }
  
  public void a(jy paramjy, jw paramjw)
  {
    if (paramjw != null) {
      paramjw.a(paramjy);
    }
    this.a.a(paramjy).a(paramjw);
  }
  
  public void a(kc.c paramc)
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
  
  public void a(ki paramki)
  {
    this.h = paramki;
  }
  
  public void a(kj paramkj)
  {
    this.j = paramkj;
  }
  
  public void a(kk paramkk)
  {
    if (paramkk == null) {
      return;
    }
    this.k = paramkk;
  }
  
  boolean a()
  {
    return this.p;
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return this.b.b(paramContext, paramString1, paramString2, paramString3);
  }
  
  public boolean a(jn paramjn)
  {
    boolean bool2 = false;
    if (paramjn == null) {
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
    paramjn = paramjn.getClass().getSimpleName();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramjn))
    {
      bool1 = bool2;
      if (paramjn.equals(localObject)) {
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
  
  void b(jn paramjn, jo paramjo)
  {
    if (this.h != null) {
      this.h.b(paramjn, paramjo);
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
      jh.a("MidasNetworkManager", "Cannot set up second time");
      return;
    }
    this.a.a(2);
    if (this.o) {
      this.a.a(new kc(this.c, this.d));
    }
    this.a.a(new jv(this));
    this.a.a(new kh(this));
    this.a.a(new ka(this));
    this.a.a(new kb(this));
    this.a.a(new kd(this));
    this.a.a(new kg(this));
    this.a.a(new jt(this));
    this.a.a(new ke(this));
    this.a.a(new jq(this));
    this.a.b(new jp(this));
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
  
  jy e()
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
  
  public kk g()
  {
    return this.k;
  }
  
  public static abstract interface a
  {
    public abstract int a();
  }
  
  public static abstract interface b
  {
    public abstract jy a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.kf
 * JD-Core Version:    0.7.0.1
 */