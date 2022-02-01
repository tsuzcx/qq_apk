package com.tencent.luggage.game.e;

import android.util.SparseIntArray;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private static a cbt;
  public String appId;
  private int cbf;
  public long cbg;
  public long cbh;
  boolean cbi;
  public c cbj;
  public int cbk;
  private float cbl;
  public ArrayList<String> cbm;
  public boolean cbn;
  public int cbo;
  public double cbp;
  public int cbq;
  public CopyOnWriteArrayList<Long> cbr;
  private final a cbs;
  public g.c cbu;
  
  public a()
  {
    AppMethodBeat.i(130697);
    this.cbf = 0;
    this.cbg = 0L;
    this.cbh = 0L;
    this.appId = "";
    this.cbi = false;
    this.cbk = -1;
    this.cbl = -1.0F;
    this.cbq = 1004;
    this.cbr = new CopyOnWriteArrayList();
    this.cbs = new a((byte)0);
    this.cbu = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(130691);
        ac.i("MicroMsg.MBNiReporter", "hy: onPause");
        paramAnonymousd = a.this;
        if (paramAnonymousd.cbi)
        {
          ac.i("MicroMsg.MBNiReporter", "hy: hasReported!");
          AppMethodBeat.o(130691);
          return;
        }
        h.JZN.aS(new a.5(paramAnonymousd));
        AppMethodBeat.o(130691);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(130689);
        ac.i("MicroMsg.MBNiReporter", "hy: onCreate");
        a.e(a.this);
        AppMethodBeat.o(130689);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(130692);
        ac.i("MicroMsg.MBNiReporter", "hy: onDestroy");
        a locala = a.this;
        ac.i("MicroMsg.MBNiReporter", "hy: release!");
        g.b(locala.appId, locala.cbu);
        AppMethodBeat.o(130692);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(130690);
        ac.i("MicroMsg.MBNiReporter", "hy: onResume");
        AppMethodBeat.o(130690);
      }
    };
    AppMethodBeat.o(130697);
  }
  
  public static a Cp()
  {
    AppMethodBeat.i(130698);
    if (cbt == null) {}
    try
    {
      if (cbt == null) {
        cbt = new a();
      }
      a locala = cbt;
      AppMethodBeat.o(130698);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(130698);
    }
  }
  
  static final class a
    extends SparseIntArray
  {
    final boolean gu(int paramInt)
    {
      AppMethodBeat.i(130696);
      if (super.indexOfKey(paramInt) >= 0)
      {
        AppMethodBeat.o(130696);
        return true;
      }
      AppMethodBeat.o(130696);
      return false;
    }
  }
  
  final class b
  {
    double cbA;
    int cby;
    long cbz;
    
    b() {}
  }
  
  final class c
  {
    double cbA;
    int cby;
    long cbz;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.e.a
 * JD-Core Version:    0.7.0.1
 */