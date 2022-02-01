package androidx.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static final c afo;
  public static final c afp;
  public static final c afq;
  public static final c afr;
  public static final c afs;
  public static final c aft;
  final float[] afu;
  final float[] afv;
  final float[] afw;
  boolean afx;
  
  static
  {
    AppMethodBeat.i(243020);
    c localc = new c();
    afo = localc;
    c(localc);
    d(afo);
    localc = new c();
    afp = localc;
    b(localc);
    d(afp);
    localc = new c();
    afq = localc;
    a(localc);
    d(afq);
    localc = new c();
    afr = localc;
    c(localc);
    e(afr);
    localc = new c();
    afs = localc;
    b(localc);
    e(afs);
    localc = new c();
    aft = localc;
    a(localc);
    e(aft);
    AppMethodBeat.o(243020);
  }
  
  c()
  {
    AppMethodBeat.i(243019);
    this.afu = new float[3];
    this.afv = new float[3];
    this.afw = new float[3];
    this.afx = true;
    f(this.afu);
    f(this.afv);
    this.afw[0] = 0.24F;
    this.afw[1] = 0.52F;
    this.afw[2] = 0.24F;
    AppMethodBeat.o(243019);
  }
  
  private static void a(c paramc)
  {
    paramc.afv[1] = 0.26F;
    paramc.afv[2] = 0.45F;
  }
  
  private static void b(c paramc)
  {
    paramc.afv[0] = 0.3F;
    paramc.afv[1] = 0.5F;
    paramc.afv[2] = 0.7F;
  }
  
  private static void c(c paramc)
  {
    paramc.afv[0] = 0.55F;
    paramc.afv[1] = 0.74F;
  }
  
  private static void d(c paramc)
  {
    paramc.afu[0] = 0.35F;
    paramc.afu[1] = 1.0F;
  }
  
  private static void e(c paramc)
  {
    paramc.afu[1] = 0.3F;
    paramc.afu[2] = 0.4F;
  }
  
  private static void f(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = 0.0F;
    paramArrayOfFloat[1] = 0.5F;
    paramArrayOfFloat[2] = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.j.a.c
 * JD-Core Version:    0.7.0.1
 */