package com.tencent.e.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.e.d.a.c;
import com.tencent.e.d.a.f;
import com.tencent.e.d.b.e.a;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public b RKV;
  public Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(138310);
    this.mContext = null;
    this.mContext = paramContext;
    this.RKV = new b(paramContext);
    AppMethodBeat.o(138310);
  }
  
  public static com.tencent.e.c.b.b a(Context paramContext, com.tencent.e.a.a parama, int paramInt)
  {
    AppMethodBeat.i(138312);
    if (parama == null)
    {
      AppMethodBeat.o(138312);
      return null;
    }
    com.tencent.e.c.b.b localb = new com.tencent.e.c.b.b();
    localb.RLC = paramInt;
    localb.RLD = null;
    localb.RLE = parama.pkgName;
    localb.RLF = com.tencent.e.f.e.bqe(parama.RKQ);
    paramContext = com.tencent.e.f.a.cS(paramContext, parama.pkgName);
    if (paramContext.size() > 1)
    {
      localb.RLU = new ArrayList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramContext.next();
        localb.RLU.add(arrayOfByte);
      }
    }
    localb.RLG = parama.fileSize;
    localb.RLH = parama.RKP;
    localb.RLI = parama.versionCode;
    localb.RLJ = parama.versionName;
    localb.RLK = 0;
    if (parama.appType == 1) {
      localb.RLK |= 0x1;
    }
    localb.RLK |= 0x2;
    if ((!parama.RKR.startsWith("/data")) && (!parama.RKR.startsWith("/system"))) {
      localb.RLK |= 0x4;
    }
    localb.RLL = "";
    localb.RLM = 0;
    localb.RLN = 0;
    localb.RLO = 0;
    localb.RLP = null;
    localb.RLQ = 0;
    localb.RLR = false;
    localb.RLS = 0;
    localb.RLT = 0;
    AppMethodBeat.o(138312);
    return localb;
  }
  
  public static com.tencent.e.c.b.d hku()
  {
    AppMethodBeat.i(138311);
    com.tencent.e.c.b.d locald = new com.tencent.e.c.b.d();
    for (;;)
    {
      try
      {
        locald.RMk = Build.FINGERPRINT;
        locald.RMl = com.tencent.e.f.d.hkQ();
        locald.brand = Build.BRAND;
        locald.model = Build.MODEL;
        locald.RMm = Build.VERSION.SDK_INT;
        locald.RMn = Build.CPU_ABI;
        locald.platform = com.tencent.e.f.d.bqd("ro.board.platform");
        if (!f.hky()) {
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
      locald.RMo = i;
      AppMethodBeat.o(138311);
      return locald;
      localObject2 = com.tencent.e.d.b.e.hkz();
      if (com.tencent.e.d.b.a.isEmpty((Collection)localObject2)) {
        continue;
      }
      localObject1 = new ArrayList(3);
      ((List)localObject1).add(new com.tencent.e.d.a.g());
      ((List)localObject1).add(new com.tencent.e.d.a.d());
      if (com.tencent.e.d.b.g.hkA()) {
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
            ((com.tencent.e.d.a.b)localIterator.next()).a(locala);
          }
        }
      }
      else
      {
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        if (((com.tencent.e.d.a.b)((Iterator)localObject1).next()).hkw())
        {
          i = 1;
          continue;
          if (com.tencent.e.d.a.e.hkx())
          {
            i = 1;
          }
          else
          {
            if (!com.tencent.e.d.a.a.bpZ("/system/bin/debuggerd"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.bpZ("/system/bin/debuggerd64"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.bpZ("/system/bin/ddexe"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.bqa("/system/etc/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.bqa("/system/bin/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            h.hkR();
            i = 0;
            continue;
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.b.a
 * JD-Core Version:    0.7.0.1
 */