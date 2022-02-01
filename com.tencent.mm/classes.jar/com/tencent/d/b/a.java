package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.d.d.a.c;
import com.tencent.d.d.a.g;
import com.tencent.d.d.b.d.a;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public b JRD;
  public Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(138310);
    this.mContext = null;
    this.mContext = paramContext;
    this.JRD = new b(paramContext);
    AppMethodBeat.o(138310);
  }
  
  public static com.tencent.d.c.b.b a(Context paramContext, com.tencent.d.a.a parama, int paramInt)
  {
    AppMethodBeat.i(138312);
    if (parama == null)
    {
      AppMethodBeat.o(138312);
      return null;
    }
    com.tencent.d.c.b.b localb = new com.tencent.d.c.b.b();
    localb.JSl = paramInt;
    localb.JSm = null;
    localb.JSn = parama.dtC;
    localb.JSo = com.tencent.d.f.e.aTn(parama.JRy);
    paramContext = com.tencent.d.f.a.cs(paramContext, parama.dtC);
    if (paramContext.size() > 1)
    {
      localb.JSD = new ArrayList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramContext.next();
        localb.JSD.add(arrayOfByte);
      }
    }
    localb.JSp = parama.fileSize;
    localb.JSq = parama.JRx;
    localb.JSr = parama.versionCode;
    localb.JSs = parama.versionName;
    localb.JSt = 0;
    if (parama.appType == 1) {
      localb.JSt |= 0x1;
    }
    localb.JSt |= 0x2;
    if ((!parama.JRz.startsWith("/data")) && (!parama.JRz.startsWith("/system"))) {
      localb.JSt |= 0x4;
    }
    localb.JSu = "";
    localb.JSv = 0;
    localb.JSw = 0;
    localb.JSx = 0;
    localb.JSy = null;
    localb.JSz = 0;
    localb.JSA = false;
    localb.JSB = 0;
    localb.JSC = 0;
    AppMethodBeat.o(138312);
    return localb;
  }
  
  public static com.tencent.d.c.b.d fCs()
  {
    AppMethodBeat.i(138311);
    com.tencent.d.c.b.d locald = new com.tencent.d.c.b.d();
    for (;;)
    {
      try
      {
        locald.JST = Build.FINGERPRINT;
        locald.JSU = com.tencent.d.f.d.fCM();
        locald.hym = Build.BRAND;
        locald.model = Build.MODEL;
        locald.JSV = Build.VERSION.SDK_INT;
        locald.JSW = Build.CPU_ABI;
        locald.platform = com.tencent.d.f.d.aTm("ro.board.platform");
        if (!com.tencent.d.d.a.f.fCw()) {
          continue;
        }
        i = 2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        Object localObject1;
        d.a locala;
        Iterator localIterator;
        continue;
        int i = 0;
        continue;
        if (i == 0) {
          continue;
        }
        i = 2;
        continue;
        i = 0;
        continue;
        if (i == 0) {
          continue;
        }
        i = 1;
        continue;
      }
      locald.JSX = i;
      AppMethodBeat.o(138311);
      return locald;
      localObject2 = com.tencent.d.d.b.d.fCx();
      if (!((Collection)localObject2).isEmpty()) {
        continue;
      }
      i = 1;
      if (i != 0) {
        continue;
      }
      localObject1 = new ArrayList(3);
      ((List)localObject1).add(new g());
      ((List)localObject1).add(new com.tencent.d.d.a.d());
      if (com.tencent.d.d.b.f.fCy()) {
        ((List)localObject1).add(new c());
      }
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        locala = (d.a)((Iterator)localObject2).next();
        if (locala != null)
        {
          localIterator = ((List)localObject1).iterator();
          if (localIterator.hasNext()) {
            ((com.tencent.d.d.a.b)localIterator.next()).a(locala);
          }
        }
      }
      else
      {
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        if (((com.tencent.d.d.a.b)((Iterator)localObject1).next()).fCu())
        {
          i = 1;
          continue;
          if (com.tencent.d.d.a.e.fCv())
          {
            i = 1;
          }
          else
          {
            if (!com.tencent.d.d.a.a.aTh("/system/bin/debuggerd"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aTh("/system/bin/debuggerd64"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aTh("/system/bin/ddexe"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aTi("/system/etc/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aTi("/system/bin/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            h.fCO();
            i = 0;
            continue;
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.b.a
 * JD-Core Version:    0.7.0.1
 */