package com.tencent.luggage.game.e;

import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private static a clM;
  public String appId;
  public long clA;
  boolean clB;
  public c clC;
  public int clD;
  private float clE;
  public ArrayList<String> clF;
  public boolean clG;
  public int clH;
  public double clI;
  public int clJ;
  public CopyOnWriteArrayList<Long> clK;
  private final a.a clL;
  public h.c clN;
  private int cly;
  public long clz;
  
  public a()
  {
    AppMethodBeat.i(130697);
    this.cly = 0;
    this.clz = 0L;
    this.clA = 0L;
    this.appId = "";
    this.clB = false;
    this.clD = -1;
    this.clE = -1.0F;
    this.clJ = 1004;
    this.clK = new CopyOnWriteArrayList();
    this.clL = new a.a((byte)0);
    this.clN = new h.c()
    {
      public final void a(h.d paramAnonymousd)
      {
        AppMethodBeat.i(130691);
        ae.i("MicroMsg.MBNiReporter", "hy: onPause");
        paramAnonymousd = a.this;
        if (paramAnonymousd.clB)
        {
          ae.i("MicroMsg.MBNiReporter", "hy: hasReported!");
          AppMethodBeat.o(130691);
          return;
        }
        com.tencent.e.h.MqF.aO(new a.5(paramAnonymousd));
        AppMethodBeat.o(130691);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(130689);
        ae.i("MicroMsg.MBNiReporter", "hy: onCreate");
        a.e(a.this);
        AppMethodBeat.o(130689);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(130692);
        ae.i("MicroMsg.MBNiReporter", "hy: onDestroy");
        a locala = a.this;
        ae.i("MicroMsg.MBNiReporter", "hy: release!");
        com.tencent.mm.plugin.appbrand.h.b(locala.appId, locala.clN);
        AppMethodBeat.o(130692);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(130690);
        ae.i("MicroMsg.MBNiReporter", "hy: onResume");
        AppMethodBeat.o(130690);
      }
    };
    AppMethodBeat.o(130697);
  }
  
  public static a DR()
  {
    AppMethodBeat.i(130698);
    if (clM == null) {}
    try
    {
      if (clM == null) {
        clM = new a();
      }
      a locala = clM;
      AppMethodBeat.o(130698);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(130698);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.e.a
 * JD-Core Version:    0.7.0.1
 */