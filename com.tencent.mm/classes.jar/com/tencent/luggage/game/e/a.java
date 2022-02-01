package com.tencent.luggage.game.e;

import android.util.SparseIntArray;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.w.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private static a cwk;
  public String appId;
  public ArrayList<String> csC;
  public int csG;
  private int cwb;
  public long cwc;
  public long cwd;
  boolean cwe;
  public d cwf;
  public int cwg;
  private float cwh;
  public CopyOnWriteArrayList<Long> cwi;
  private final a cwj;
  public k.c cwl;
  
  public a()
  {
    AppMethodBeat.i(130697);
    this.cwb = 0;
    this.cwc = 0L;
    this.cwd = 0L;
    this.appId = "";
    this.cwe = false;
    this.cwg = -1;
    this.cwh = -1.0F;
    this.csG = 1004;
    this.cwi = new CopyOnWriteArrayList();
    this.cwj = new a((byte)0);
    this.cwl = new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(130691);
        Log.i("MicroMsg.MBNiReporter", "hy: onPause");
        paramAnonymousd = a.this;
        if (paramAnonymousd.cwe)
        {
          Log.i("MicroMsg.MBNiReporter", "hy: hasReported!");
          AppMethodBeat.o(130691);
          return;
        }
        h.ZvG.be(new a.5(paramAnonymousd));
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
        k.b(locala.appId, locala.cwl);
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
  
  public static a Qf()
  {
    AppMethodBeat.i(130698);
    if (cwk == null) {}
    try
    {
      if (cwk == null) {
        cwk = new a();
      }
      a locala = cwk;
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
    final boolean iM(int paramInt)
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
    int cwo;
    long cwp;
    double cwq;
    
    b() {}
  }
  
  final class c
  {
    int cwo;
    long cwp;
    double cwq;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.e.a
 * JD-Core Version:    0.7.0.1
 */