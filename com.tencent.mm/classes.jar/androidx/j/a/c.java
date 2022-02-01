package androidx.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static final c bTt;
  public static final c bTu;
  public static final c bTv;
  public static final c bTw;
  public static final c bTx;
  public static final c bTy;
  final float[] bTA;
  final float[] bTB;
  boolean bTC;
  final float[] bTz;
  
  static
  {
    AppMethodBeat.i(192786);
    c localc = new c();
    bTt = localc;
    c(localc);
    d(bTt);
    localc = new c();
    bTu = localc;
    b(localc);
    d(bTu);
    localc = new c();
    bTv = localc;
    a(localc);
    d(bTv);
    localc = new c();
    bTw = localc;
    c(localc);
    e(bTw);
    localc = new c();
    bTx = localc;
    b(localc);
    e(bTx);
    localc = new c();
    bTy = localc;
    a(localc);
    e(bTy);
    AppMethodBeat.o(192786);
  }
  
  c()
  {
    AppMethodBeat.i(192711);
    this.bTz = new float[3];
    this.bTA = new float[3];
    this.bTB = new float[3];
    this.bTC = true;
    o(this.bTz);
    o(this.bTA);
    this.bTB[0] = 0.24F;
    this.bTB[1] = 0.52F;
    this.bTB[2] = 0.24F;
    AppMethodBeat.o(192711);
  }
  
  private static void a(c paramc)
  {
    paramc.bTA[1] = 0.26F;
    paramc.bTA[2] = 0.45F;
  }
  
  private static void b(c paramc)
  {
    paramc.bTA[0] = 0.3F;
    paramc.bTA[1] = 0.5F;
    paramc.bTA[2] = 0.7F;
  }
  
  private static void c(c paramc)
  {
    paramc.bTA[0] = 0.55F;
    paramc.bTA[1] = 0.74F;
  }
  
  private static void d(c paramc)
  {
    paramc.bTz[0] = 0.35F;
    paramc.bTz[1] = 1.0F;
  }
  
  private static void e(c paramc)
  {
    paramc.bTz[1] = 0.3F;
    paramc.bTz[2] = 0.4F;
  }
  
  private static void o(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = 0.0F;
    paramArrayOfFloat[1] = 0.5F;
    paramArrayOfFloat[2] = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.j.a.c
 * JD-Core Version:    0.7.0.1
 */