package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.d.d.a.c;
import com.tencent.d.d.a.f;
import com.tencent.d.d.b.e.a;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public b ZnC;
  public Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(138310);
    this.mContext = null;
    this.mContext = paramContext;
    this.ZnC = new b(paramContext);
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
    localb.Zoj = paramInt;
    localb.Zok = null;
    localb.Zol = parama.pkgName;
    localb.Zom = com.tencent.d.f.e.bCW(parama.Znx);
    paramContext = com.tencent.d.f.a.dd(paramContext, parama.pkgName);
    if (paramContext.size() > 1)
    {
      localb.ZoB = new ArrayList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramContext.next();
        localb.ZoB.add(arrayOfByte);
      }
    }
    localb.Zon = parama.fileSize;
    localb.Zoo = parama.Znw;
    localb.Zop = parama.versionCode;
    localb.Zoq = parama.versionName;
    localb.Zor = 0;
    if (parama.appType == 1) {
      localb.Zor |= 0x1;
    }
    localb.Zor |= 0x2;
    if ((!parama.Zny.startsWith("/data")) && (!parama.Zny.startsWith("/system"))) {
      localb.Zor |= 0x4;
    }
    localb.Zos = "";
    localb.Zot = 0;
    localb.Zou = 0;
    localb.Zov = 0;
    localb.Zow = null;
    localb.Zox = 0;
    localb.Zoy = false;
    localb.Zoz = 0;
    localb.ZoA = 0;
    AppMethodBeat.o(138312);
    return localb;
  }
  
  public static com.tencent.d.c.b.d inS()
  {
    AppMethodBeat.i(138311);
    com.tencent.d.c.b.d locald = new com.tencent.d.c.b.d();
    for (;;)
    {
      try
      {
        locald.ZoR = Build.FINGERPRINT;
        locald.ZoS = com.tencent.d.f.d.ioo();
        locald.brand = Build.BRAND;
        locald.model = Build.MODEL;
        locald.ZoT = Build.VERSION.SDK_INT;
        locald.ZoU = Build.CPU_ABI;
        locald.platform = com.tencent.d.f.d.bCV("ro.board.platform");
        if (!f.inW()) {
          continue;
        }
        i = 2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        Object localObject1;
        e.a locala;
        Iterator localIterator;
        continue;
        if (i == 0) {
          continue;
        }
        int i = 2;
        continue;
        i = 0;
        continue;
        if (i == 0) {
          continue;
        }
        i = 1;
        continue;
      }
      locald.root = i;
      AppMethodBeat.o(138311);
      return locald;
      localObject2 = com.tencent.d.d.b.e.inX();
      if (com.tencent.d.d.b.a.isEmpty((Collection)localObject2)) {
        continue;
      }
      localObject1 = new ArrayList(3);
      ((List)localObject1).add(new com.tencent.d.d.a.g());
      ((List)localObject1).add(new com.tencent.d.d.a.d());
      if (com.tencent.d.d.b.g.inY()) {
        ((List)localObject1).add(new c());
      }
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        locala = (e.a)((Iterator)localObject2).next();
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
        if (((com.tencent.d.d.a.b)((Iterator)localObject1).next()).inU())
        {
          i = 1;
          continue;
          if (com.tencent.d.d.a.e.inV())
          {
            i = 1;
          }
          else
          {
            if (!com.tencent.d.d.a.a.bCR("/system/bin/debuggerd"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.bCR("/system/bin/debuggerd64"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.bCR("/system/bin/ddexe"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.bCS("/system/etc/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.bCS("/system/bin/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            h.iop();
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