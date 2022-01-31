package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$ak$a
  extends i.a<a.ak, a>
  implements a.al
{
  private int Ckr;
  private int CnG;
  private int CnH;
  private a.ak.b CnI = a.ak.b.CnN;
  private int CnJ;
  private int CnK;
  private a.ak.c CnL = a.ak.c.CnQ;
  
  private a Vh(int paramInt)
  {
    this.Ckr |= 0x1;
    this.CnG = paramInt;
    return this;
  }
  
  private a Vi(int paramInt)
  {
    this.Ckr |= 0x2;
    this.CnH = paramInt;
    return this;
  }
  
  private a Vj(int paramInt)
  {
    this.Ckr |= 0x8;
    this.CnJ = paramInt;
    return this;
  }
  
  private a Vk(int paramInt)
  {
    this.Ckr |= 0x10;
    this.CnK = paramInt;
    return this;
  }
  
  private a a(a.ak.b paramb)
  {
    AppMethodBeat.i(121011);
    if (paramb == null)
    {
      paramb = new NullPointerException();
      AppMethodBeat.o(121011);
      throw paramb;
    }
    this.Ckr |= 0x4;
    this.CnI = paramb;
    AppMethodBeat.o(121011);
    return this;
  }
  
  private a a(a.ak.c paramc)
  {
    AppMethodBeat.i(121012);
    if (paramc == null)
    {
      paramc = new NullPointerException();
      AppMethodBeat.o(121012);
      throw paramc;
    }
    this.Ckr |= 0x20;
    this.CnL = paramc;
    AppMethodBeat.o(121012);
    return this;
  }
  
  private a ekE()
  {
    AppMethodBeat.i(121007);
    a locala = new a().b(ekF());
    AppMethodBeat.o(121007);
    return locala;
  }
  
  private a.ak ekF()
  {
    int j = 1;
    AppMethodBeat.i(121008);
    a.ak localak = new a.ak(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.ak.a(localak, this.CnG);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      a.ak.b(localak, this.CnH);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      a.ak.a(localak, this.CnI);
      i = j;
      if ((k & 0x8) == 8) {
        i = j | 0x8;
      }
      a.ak.c(localak, this.CnJ);
      j = i;
      if ((k & 0x10) == 16) {
        j = i | 0x10;
      }
      a.ak.d(localak, this.CnK);
      i = j;
      if ((k & 0x20) == 32) {
        i = j | 0x20;
      }
      a.ak.a(localak, this.CnL);
      a.ak.e(localak, i);
      AppMethodBeat.o(121008);
      return localak;
      j = 0;
    }
  }
  
  /* Error */
  private a y(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 113
    //   2: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 117	a/j/b/a/c/e/a$ak:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 122 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$ak
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 82	a/j/b/a/c/e/a$ak$a:b	(La/j/b/a/c/e/a$ak;)La/j/b/a/c/e/a$ak$a;
    //   26: pop
    //   27: ldc 113
    //   29: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 126	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$ak
    //   42: astore_2
    //   43: ldc 113
    //   45: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 82	a/j/b/a/c/e/a$ak$a:b	(La/j/b/a/c/e/a$ak;)La/j/b/a/c/e/a$ak$a;
    //   60: pop
    //   61: ldc 113
    //   63: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: goto -20 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	parame	a.j.b.a.c.g.e
    //   0	74	2	paramg	a.j.b.a.c.g.g
    //   6	64	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   7	21	34	a/j/b/a/c/g/k
    //   43	50	50	finally
    //   7	21	68	finally
    //   35	43	68	finally
  }
  
  public final a b(a.ak paramak)
  {
    AppMethodBeat.i(121009);
    if (paramak == a.ak.ekx())
    {
      AppMethodBeat.o(121009);
      return this;
    }
    if (paramak.eky()) {
      Vh(paramak.CnG);
    }
    if (paramak.ekz()) {
      Vi(paramak.CnH);
    }
    if (paramak.ekA()) {
      a(paramak.CnI);
    }
    if (paramak.ekB()) {
      Vj(paramak.CnJ);
    }
    if (paramak.ekC()) {
      Vk(paramak.CnK);
    }
    if (paramak.ekD()) {
      a(paramak.CnL);
    }
    this.Ckp = this.Ckp.a(a.ak.a(paramak));
    AppMethodBeat.o(121009);
    return this;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.a.ak.a
 * JD-Core Version:    0.7.0.1
 */