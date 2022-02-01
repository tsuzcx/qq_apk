package com.tencent.luggage.game.e;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.u.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private static a cew;
  public String appId;
  private int cei;
  public long cej;
  public long cek;
  boolean cel;
  public c cem;
  public int cen;
  private float ceo;
  public ArrayList<String> cep;
  public boolean ceq;
  public int cer;
  public double ces;
  public int cet;
  public CopyOnWriteArrayList<Long> ceu;
  private final a.a cev;
  public g.c cex;
  
  public a()
  {
    AppMethodBeat.i(130697);
    this.cei = 0;
    this.cej = 0L;
    this.cek = 0L;
    this.appId = "";
    this.cel = false;
    this.cen = -1;
    this.ceo = -1.0F;
    this.cet = 1004;
    this.ceu = new CopyOnWriteArrayList();
    this.cev = new a.a((byte)0);
    this.cex = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(130691);
        ad.i("MicroMsg.MBNiReporter", "hy: onPause");
        paramAnonymousd = a.this;
        if (paramAnonymousd.cel)
        {
          ad.i("MicroMsg.MBNiReporter", "hy: hasReported!");
          AppMethodBeat.o(130691);
          return;
        }
        h.Iye.aP(new a.5(paramAnonymousd));
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
        g.b(locala.appId, locala.cex);
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
  
  public static a CL()
  {
    AppMethodBeat.i(130698);
    if (cew == null) {}
    try
    {
      if (cew == null) {
        cew = new a();
      }
      a locala = cew;
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
    int ceB;
    long ceC;
    double ceD;
    
    b() {}
  }
  
  final class c
  {
    int ceB;
    long ceC;
    double ceD;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.e.a
 * JD-Core Version:    0.7.0.1
 */