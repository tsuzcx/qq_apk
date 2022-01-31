package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.kh.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.al;

public final class a
{
  public static final void KP()
  {
    AppMethodBeat.i(137241);
    al.d(new a.1());
    AppMethodBeat.o(137241);
  }
  
  public static final void KQ()
  {
    AppMethodBeat.i(137242);
    al.d(new a.2());
    AppMethodBeat.o(137242);
  }
  
  public static final void a(e parame)
  {
    AppMethodBeat.i(137245);
    al.d(new a.5(parame));
    AppMethodBeat.o(137245);
  }
  
  public static c aiA()
  {
    AppMethodBeat.i(137253);
    Object localObject = new kh();
    ((kh)localObject).czU.action = 8;
    com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
    localObject = ((kh)localObject).czV.cAa;
    AppMethodBeat.o(137253);
    return localObject;
  }
  
  public static final void aiu()
  {
    AppMethodBeat.i(137243);
    al.d(new a.3());
    AppMethodBeat.o(137243);
  }
  
  public static final void aiv()
  {
    AppMethodBeat.i(137244);
    al.d(new a.4());
    AppMethodBeat.o(137244);
  }
  
  public static boolean aiw()
  {
    AppMethodBeat.i(137246);
    kh localkh = new kh();
    localkh.czU.action = -3;
    com.tencent.mm.sdk.b.a.ymk.l(localkh);
    boolean bool = localkh.czV.cmX;
    AppMethodBeat.o(137246);
    return bool;
  }
  
  public static boolean aix()
  {
    AppMethodBeat.i(137247);
    kh localkh = new kh();
    localkh.czU.action = 10;
    com.tencent.mm.sdk.b.a.ymk.l(localkh);
    boolean bool = localkh.czV.cmX;
    AppMethodBeat.o(137247);
    return bool;
  }
  
  public static boolean aiy()
  {
    AppMethodBeat.i(137248);
    kh localkh = new kh();
    localkh.czU.action = 9;
    com.tencent.mm.sdk.b.a.ymk.l(localkh);
    boolean bool = localkh.czV.cmX;
    AppMethodBeat.o(137248);
    return bool;
  }
  
  public static e aiz()
  {
    AppMethodBeat.i(137249);
    Object localObject = new kh();
    ((kh)localObject).czU.action = -2;
    com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
    localObject = ((kh)localObject).czV.czW;
    AppMethodBeat.o(137249);
    return localObject;
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(137250);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137237);
        kh localkh = new kh();
        localkh.czU.action = 0;
        localkh.czU.czW = this.fKa;
        com.tencent.mm.sdk.b.a.ymk.l(localkh);
        AppMethodBeat.o(137237);
      }
    });
    AppMethodBeat.o(137250);
  }
  
  public static void c(e parame)
  {
    AppMethodBeat.i(137251);
    al.d(new a.8(parame));
    AppMethodBeat.o(137251);
  }
  
  public static boolean d(e parame)
  {
    if (parame == null) {
      return false;
    }
    switch (parame.fKh)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean lN(int paramInt)
  {
    AppMethodBeat.i(137252);
    kh localkh = new kh();
    localkh.czU.action = 7;
    localkh.czU.position = paramInt;
    com.tencent.mm.sdk.b.a.ymk.l(localkh);
    boolean bool = localkh.czV.cmX;
    AppMethodBeat.o(137252);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.a
 * JD-Core Version:    0.7.0.1
 */