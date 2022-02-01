package com.tencent.matrix;

import android.app.Application;
import com.tencent.matrix.d.a;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.report.k;
import com.tencent.matrix.report.k.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public final class c
{
  public static final boolean ENABLE_MATRIX;
  public static final boolean ENABLE_MATRIX_TRACE;
  
  static
  {
    boolean bool2 = false;
    if ((BuildInfo.ENABLE_MATRIX) || (BuildInfo.DEBUG)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ENABLE_MATRIX = bool1;
      if (!BuildInfo.ENABLE_MATRIX_TRACE)
      {
        bool1 = bool2;
        if (!BuildInfo.DEBUG) {}
      }
      else
      {
        bool1 = true;
      }
      ENABLE_MATRIX_TRACE = bool1;
      return;
    }
  }
  
  public static void a(Application paramApplication, a parama)
  {
    com.tencent.matrix.e.c.i("MicroMsg.MatrixDelegate", "[onBoot] ENABLE_MATRIX=" + ENABLE_MATRIX + ", ENABLE_MATRIX_TRACE=" + ENABLE_MATRIX_TRACE, new Object[0]);
    if (!ENABLE_MATRIX) {
      return;
    }
    if (Util.getInt(d.dgX().gO("clicfg_matrix_boot_enable", "1"), 1) != 1)
    {
      com.tencent.matrix.e.c.e("MicroMsg.MatrixDelegate", "[onBoot] disabled by clicfg_matrix_boot_enable", new Object[0]);
      return;
    }
    Objects.requireNonNull(parama);
    parama.b(paramApplication);
    b.a(parama.Vv());
    AppForegroundDelegate.fby.a(parama.Vz());
    MrsLogic.setStrategyCaller(new com.tencent.matrix.strategy.b());
    Object localObject = parama.Vx();
    k localk = parama.Vw();
    localk.dap = parama.Vy();
    b.a locala = new b.a(paramApplication);
    locala.pluginListener = localk;
    parama.a(paramApplication, locala, (f)localObject);
    if (locala.pluginListener == null) {
      locala.pluginListener = new a(locala.application);
    }
    b.a(new b(locala.application, locala.pluginListener, locala.coE, (byte)0));
    paramApplication = b.Vu().coE.iterator();
    while (paramApplication.hasNext())
    {
      localObject = (com.tencent.matrix.d.b)paramApplication.next();
      Log.i("MicroMsg.MatrixDelegate", "[onInitialize] start plugin: ".concat(String.valueOf(localObject)));
      ((com.tencent.matrix.d.b)localObject).start();
    }
    b.Vu();
    parama.VA();
  }
  
  public static abstract interface a
  {
    public abstract void VA();
    
    public abstract com.tencent.matrix.e.c.a Vv();
    
    public abstract k Vw();
    
    public abstract f Vx();
    
    public abstract k.c Vy();
    
    public abstract o Vz();
    
    public abstract void a(Application paramApplication, b.a parama, f paramf);
    
    public abstract void b(Application paramApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.c
 * JD-Core Version:    0.7.0.1
 */