package com.tencent.luggage.game.e;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private static a clK;
  public String appId;
  public c clA;
  public int clB;
  private float clC;
  public ArrayList<String> clD;
  public boolean clE;
  public int clF;
  public double clG;
  public int clH;
  public CopyOnWriteArrayList<Long> clI;
  private final a.a clJ;
  public g.c clL;
  private int clw;
  public long clx;
  public long cly;
  boolean clz;
  
  public a()
  {
    AppMethodBeat.i(130697);
    this.clw = 0;
    this.clx = 0L;
    this.cly = 0L;
    this.appId = "";
    this.clz = false;
    this.clB = -1;
    this.clC = -1.0F;
    this.clH = 1004;
    this.clI = new CopyOnWriteArrayList();
    this.clJ = new a.a((byte)0);
    this.clL = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(130691);
        ad.i("MicroMsg.MBNiReporter", "hy: onPause");
        paramAnonymousd = a.this;
        if (paramAnonymousd.clz)
        {
          ad.i("MicroMsg.MBNiReporter", "hy: hasReported!");
          AppMethodBeat.o(130691);
          return;
        }
        h.LTJ.aR(new a.5(paramAnonymousd));
        AppMethodBeat.o(130691);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(130689);
        ad.i("MicroMsg.MBNiReporter", "hy: onCreate");
        a.e(a.this);
        AppMethodBeat.o(130689);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(130692);
        ad.i("MicroMsg.MBNiReporter", "hy: onDestroy");
        a locala = a.this;
        ad.i("MicroMsg.MBNiReporter", "hy: release!");
        g.b(locala.appId, locala.clL);
        AppMethodBeat.o(130692);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(130690);
        ad.i("MicroMsg.MBNiReporter", "hy: onResume");
        AppMethodBeat.o(130690);
      }
    };
    AppMethodBeat.o(130697);
  }
  
  public static a DO()
  {
    AppMethodBeat.i(130698);
    if (clK == null) {}
    try
    {
      if (clK == null) {
        clK = new a();
      }
      a locala = clK;
      AppMethodBeat.o(130698);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(130698);
    }
  }
  
  final class b
  {
    int clP;
    long clQ;
    double clR;
    
    b() {}
  }
  
  final class c
  {
    int clP;
    long clQ;
    double clR;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.e.a
 * JD-Core Version:    0.7.0.1
 */