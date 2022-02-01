package com.tencent.luggage.game.e;

import com.tencent.luggage.a.e;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private static a eoj;
  public String appId;
  public int ekA;
  public ArrayList<String> ekw;
  private int enZ;
  public long eoa;
  public long eob;
  boolean eoc;
  public d eod;
  public int eoe;
  private float eog;
  public CopyOnWriteArrayList<Long> eoh;
  private final a.a eoi;
  public k.c eok;
  
  public a()
  {
    AppMethodBeat.i(130697);
    this.enZ = 0;
    this.eoa = 0L;
    this.eob = 0L;
    this.appId = "";
    this.eoc = false;
    this.eoe = -1;
    this.eog = -1.0F;
    this.ekA = 1004;
    this.eoh = new CopyOnWriteArrayList();
    this.eoi = new a.a((byte)0);
    this.eok = new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(130691);
        Log.i("MicroMsg.MBNiReporter", "hy: onPause");
        paramAnonymousd = a.this;
        if (paramAnonymousd.eoc)
        {
          Log.i("MicroMsg.MBNiReporter", "hy: hasReported!");
          AppMethodBeat.o(130691);
          return;
        }
        h.ahAA.bm(new a.5(paramAnonymousd));
        AppMethodBeat.o(130691);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(130689);
        Log.i("MicroMsg.MBNiReporter", "hy: onCreate");
        a.e(a.this);
        AppMethodBeat.o(130689);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(130692);
        Log.i("MicroMsg.MBNiReporter", "hy: onDestroy");
        a locala = a.this;
        Log.i("MicroMsg.MBNiReporter", "hy: release!");
        k.b(locala.appId, locala.eok);
        AppMethodBeat.o(130692);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(130690);
        Log.i("MicroMsg.MBNiReporter", "hy: onResume");
        AppMethodBeat.o(130690);
      }
    };
    AppMethodBeat.o(130697);
  }
  
  public static a aqp()
  {
    AppMethodBeat.i(130698);
    if (eoj == null) {}
    try
    {
      if (eoj == null) {
        eoj = new a();
      }
      a locala = eoj;
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
    int eon;
    long eoo;
    double eop;
    
    b() {}
  }
  
  final class c
  {
    int eon;
    long eoo;
    double eop;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.e.a
 * JD-Core Version:    0.7.0.1
 */