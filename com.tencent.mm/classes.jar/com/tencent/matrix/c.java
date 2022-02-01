package com.tencent.matrix;

import android.app.Application;
import com.tencent.matrix.e.a;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.report.h;
import com.tencent.matrix.report.h.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
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
    com.tencent.matrix.g.c.i("MicroMsg.MatrixDelegate", "[onBoot] ENABLE_MATRIX=" + ENABLE_MATRIX + ", ENABLE_MATRIX_TRACE=" + ENABLE_MATRIX_TRACE, new Object[0]);
    if (!ENABLE_MATRIX) {
      return;
    }
    Objects.requireNonNull(parama);
    parama.a(paramApplication);
    b.a(parama.RH());
    AppForegroundDelegate.djR.a(parama.RL());
    MrsLogic.setStrategyCaller(new com.tencent.matrix.strategy.b());
    Object localObject = parama.RJ();
    h localh = parama.RI();
    localh.cWu = parama.RK();
    b.a locala = new b.a(paramApplication);
    locala.pluginListener = localh;
    parama.a(paramApplication, locala, (f)localObject);
    if (locala.pluginListener == null) {
      locala.pluginListener = new a(locala.application);
    }
    b.a(new b(locala.application, locala.pluginListener, locala.cqP, (byte)0));
    paramApplication = b.RG().cqP.iterator();
    while (paramApplication.hasNext())
    {
      localObject = (com.tencent.matrix.e.b)paramApplication.next();
      Log.i("MicroMsg.MatrixDelegate", "[onInitialize] start plugin: ".concat(String.valueOf(localObject)));
      ((com.tencent.matrix.e.b)localObject).start();
    }
    parama.b(b.RG());
  }
  
  public static abstract interface a
  {
    public abstract com.tencent.matrix.g.c.a RH();
    
    public abstract h RI();
    
    public abstract f RJ();
    
    public abstract h.b RK();
    
    public abstract o RL();
    
    public abstract void a(Application paramApplication);
    
    public abstract void a(Application paramApplication, b.a parama, f paramf);
    
    public abstract void b(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.c
 * JD-Core Version:    0.7.0.1
 */