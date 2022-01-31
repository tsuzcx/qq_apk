package com.tencent.luggage.game.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private static a bCu;
  public String appId;
  private int bCm;
  public long bCn;
  public long bCo;
  boolean bCp;
  public int bCq;
  private float bCr;
  public CopyOnWriteArrayList<Long> bCs;
  private final a.a bCt;
  public e.c bCv;
  public com.tencent.magicbrush.a mbInspector;
  
  public a()
  {
    AppMethodBeat.i(140547);
    this.bCm = 0;
    this.bCn = 0L;
    this.bCo = 0L;
    this.appId = "";
    this.bCp = false;
    this.bCq = -1;
    this.bCr = -1.0F;
    this.bCs = new CopyOnWriteArrayList();
    this.bCt = new a.a((byte)0);
    this.bCv = new e.c()
    {
      public final void a(e.d paramAnonymousd)
      {
        AppMethodBeat.i(140542);
        ab.i("MicroMsg.MBNiReporter", "hy: onPause");
        paramAnonymousd = a.this;
        if (paramAnonymousd.bCp)
        {
          ab.i("MicroMsg.MBNiReporter", "hy: hasReported!");
          AppMethodBeat.o(140542);
          return;
        }
        d.ysm.execute(new a.5(paramAnonymousd));
        AppMethodBeat.o(140542);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(140540);
        ab.i("MicroMsg.MBNiReporter", "hy: onCreate");
        a.e(a.this);
        AppMethodBeat.o(140540);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(140543);
        ab.i("MicroMsg.MBNiReporter", "hy: onDestroy");
        a locala = a.this;
        ab.i("MicroMsg.MBNiReporter", "hy: release!");
        com.tencent.mm.plugin.appbrand.e.b(locala.appId, locala.bCv);
        AppMethodBeat.o(140543);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(140541);
        ab.i("MicroMsg.MBNiReporter", "hy: onResume");
        AppMethodBeat.o(140541);
      }
    };
    AppMethodBeat.o(140547);
  }
  
  public static a vN()
  {
    AppMethodBeat.i(140548);
    if (bCu == null) {}
    try
    {
      if (bCu == null) {
        bCu = new a();
      }
      a locala = bCu;
      AppMethodBeat.o(140548);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(140548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.f.a
 * JD-Core Version:    0.7.0.1
 */