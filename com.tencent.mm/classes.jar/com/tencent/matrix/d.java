package com.tencent.matrix;

import android.app.Application;
import com.tencent.matrix.d.a;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.report.l;
import com.tencent.matrix.report.l.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public final class d
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
    if (Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().hx("clicfg_matrix_boot_enable", "1"), 1) != 1)
    {
      com.tencent.matrix.e.c.e("MicroMsg.MatrixDelegate", "[onBoot] disabled by clicfg_matrix_boot_enable", new Object[0]);
      return;
    }
    Objects.requireNonNull(parama);
    parama.b(paramApplication);
    c.a(parama.avX());
    AppForegroundDelegate.heY.a(parama.awb());
    MrsLogic.setStrategyCaller(new com.tencent.matrix.strategy.b());
    Object localObject = parama.avZ();
    l locall = parama.avY();
    locall.eYP = parama.awa();
    c.a locala = new c.a(paramApplication);
    locala.pluginListener = locall;
    parama.a(paramApplication, locala, (g)localObject);
    if (locala.pluginListener == null) {
      locala.pluginListener = new a(locala.application);
    }
    c.a(new c(locala.application, locala.pluginListener, locala.efL, (byte)0));
    paramApplication = c.avW().efL.iterator();
    while (paramApplication.hasNext())
    {
      localObject = (com.tencent.matrix.d.b)paramApplication.next();
      Log.i("MicroMsg.MatrixDelegate", "[onInitialize] start plugin: ".concat(String.valueOf(localObject)));
      ((com.tencent.matrix.d.b)localObject).start();
    }
    c.avW();
    parama.awc();
  }
  
  public static abstract interface a
  {
    public abstract void a(Application paramApplication, c.a parama, g paramg);
    
    public abstract com.tencent.matrix.e.c.a avX();
    
    public abstract l avY();
    
    public abstract g avZ();
    
    public abstract l.c awa();
    
    public abstract q awb();
    
    public abstract void awc();
    
    public abstract void b(Application paramApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.d
 * JD-Core Version:    0.7.0.1
 */