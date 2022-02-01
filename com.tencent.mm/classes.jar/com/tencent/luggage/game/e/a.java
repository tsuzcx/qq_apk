package com.tencent.luggage.game.e;

import android.util.SparseIntArray;
import com.tencent.f.i;
import com.tencent.luggage.a.e;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.w.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private static a cxH;
  public String appId;
  public ArrayList<String> cxA;
  public boolean cxB;
  public int cxC;
  public double cxD;
  public int cxE;
  public CopyOnWriteArrayList<Long> cxF;
  private final a cxG;
  public h.c cxI;
  private int cxt;
  public long cxu;
  public long cxv;
  boolean cxw;
  public d cxx;
  public int cxy;
  private float cxz;
  
  public a()
  {
    AppMethodBeat.i(130697);
    this.cxt = 0;
    this.cxu = 0L;
    this.cxv = 0L;
    this.appId = "";
    this.cxw = false;
    this.cxy = -1;
    this.cxz = -1.0F;
    this.cxE = 1004;
    this.cxF = new CopyOnWriteArrayList();
    this.cxG = new a((byte)0);
    this.cxI = new h.c()
    {
      public final void a(h.d paramAnonymousd)
      {
        AppMethodBeat.i(130691);
        Log.i("MicroMsg.MBNiReporter", "hy: onPause");
        paramAnonymousd = a.this;
        if (paramAnonymousd.cxw)
        {
          Log.i("MicroMsg.MBNiReporter", "hy: hasReported!");
          AppMethodBeat.o(130691);
          return;
        }
        com.tencent.f.h.RTc.aX(new a.5(paramAnonymousd));
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
        com.tencent.mm.plugin.appbrand.h.b(locala.appId, locala.cxI);
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
  
  public static a Nn()
  {
    AppMethodBeat.i(130698);
    if (cxH == null) {}
    try
    {
      if (cxH == null) {
        cxH = new a();
      }
      a locala = cxH;
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
    final boolean hM(int paramInt)
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
    int cxM;
    long cxN;
    double cxO;
    
    b() {}
  }
  
  final class c
  {
    int cxM;
    long cxN;
    double cxO;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.e.a
 * JD-Core Version:    0.7.0.1
 */