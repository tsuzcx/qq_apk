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
  public b IpT;
  public Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(138310);
    this.mContext = null;
    this.mContext = paramContext;
    this.IpT = new b(paramContext);
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
    localb.IqB = paramInt;
    localb.IqC = null;
    localb.IqD = parama.dvP;
    localb.IqE = com.tencent.d.f.e.aNK(parama.IpO);
    paramContext = com.tencent.d.f.a.cs(paramContext, parama.dvP);
    if (paramContext.size() > 1)
    {
      localb.IqT = new ArrayList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramContext.next();
        localb.IqT.add(arrayOfByte);
      }
    }
    localb.IqF = parama.fileSize;
    localb.IqG = parama.IpN;
    localb.IqH = parama.versionCode;
    localb.IqI = parama.versionName;
    localb.IqJ = 0;
    if (parama.appType == 1) {
      localb.IqJ |= 0x1;
    }
    localb.IqJ |= 0x2;
    if ((!parama.IpP.startsWith("/data")) && (!parama.IpP.startsWith("/system"))) {
      localb.IqJ |= 0x4;
    }
    localb.IqK = "";
    localb.IqL = 0;
    localb.IqM = 0;
    localb.IqN = 0;
    localb.IqO = null;
    localb.IqP = 0;
    localb.IqQ = false;
    localb.IqR = 0;
    localb.IqS = 0;
    AppMethodBeat.o(138312);
    return localb;
  }
  
  public static com.tencent.d.c.b.d fmb()
  {
    AppMethodBeat.i(138311);
    com.tencent.d.c.b.d locald = new com.tencent.d.c.b.d();
    for (;;)
    {
      try
      {
        locald.Irj = Build.FINGERPRINT;
        locald.Irk = com.tencent.d.f.d.fmw();
        locald.gXN = Build.BRAND;
        locald.model = Build.MODEL;
        locald.Irl = Build.VERSION.SDK_INT;
        locald.Irm = Build.CPU_ABI;
        locald.platform = com.tencent.d.f.d.aNJ("ro.board.platform");
        if (!com.tencent.d.d.a.f.fmf()) {
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
      locald.Irn = i;
      AppMethodBeat.o(138311);
      return locald;
      localObject2 = com.tencent.d.d.b.d.fmg();
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
      if (com.tencent.d.d.b.f.fmh()) {
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
        if (((com.tencent.d.d.a.b)((Iterator)localObject1).next()).fmd())
        {
          i = 1;
          continue;
          if (com.tencent.d.d.a.e.fme())
          {
            i = 1;
          }
          else
          {
            if (!com.tencent.d.d.a.a.aNE("/system/bin/debuggerd"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aNE("/system/bin/debuggerd64"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aNE("/system/bin/ddexe"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aNF("/system/etc/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aNF("/system/bin/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            h.fmy();
            i = 0;
            continue;
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.b.a
 * JD-Core Version:    0.7.0.1
 */