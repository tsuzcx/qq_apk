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
  public b LLv;
  public Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(138310);
    this.mContext = null;
    this.mContext = paramContext;
    this.LLv = new b(paramContext);
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
    localb.LMc = paramInt;
    localb.LMd = null;
    localb.LMe = parama.dFD;
    localb.LMf = com.tencent.d.f.e.aZn(parama.LLq);
    paramContext = com.tencent.d.f.a.cx(paramContext, parama.dFD);
    if (paramContext.size() > 1)
    {
      localb.LMu = new ArrayList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramContext.next();
        localb.LMu.add(arrayOfByte);
      }
    }
    localb.LMg = parama.fileSize;
    localb.LMh = parama.LLp;
    localb.LMi = parama.versionCode;
    localb.LMj = parama.versionName;
    localb.LMk = 0;
    if (parama.appType == 1) {
      localb.LMk |= 0x1;
    }
    localb.LMk |= 0x2;
    if ((!parama.LLr.startsWith("/data")) && (!parama.LLr.startsWith("/system"))) {
      localb.LMk |= 0x4;
    }
    localb.LMl = "";
    localb.LMm = 0;
    localb.LMn = 0;
    localb.LMo = 0;
    localb.LMp = null;
    localb.LMq = 0;
    localb.LMr = false;
    localb.LMs = 0;
    localb.LMt = 0;
    AppMethodBeat.o(138312);
    return localb;
  }
  
  public static com.tencent.d.c.b.d fTI()
  {
    AppMethodBeat.i(138311);
    com.tencent.d.c.b.d locald = new com.tencent.d.c.b.d();
    for (;;)
    {
      try
      {
        locald.LMK = Build.FINGERPRINT;
        locald.LML = com.tencent.d.f.d.fUe();
        locald.hQG = Build.BRAND;
        locald.model = Build.MODEL;
        locald.LMM = Build.VERSION.SDK_INT;
        locald.LMN = Build.CPU_ABI;
        locald.platform = com.tencent.d.f.d.aZm("ro.board.platform");
        if (!com.tencent.d.d.a.f.fTM()) {
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
      locald.LMO = i;
      AppMethodBeat.o(138311);
      return locald;
      localObject2 = com.tencent.d.d.b.d.fTN();
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
      if (com.tencent.d.d.b.f.fTO()) {
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
        if (((com.tencent.d.d.a.b)((Iterator)localObject1).next()).fTK())
        {
          i = 1;
          continue;
          if (com.tencent.d.d.a.e.fTL())
          {
            i = 1;
          }
          else
          {
            if (!com.tencent.d.d.a.a.aZh("/system/bin/debuggerd"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aZh("/system/bin/debuggerd64"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aZh("/system/bin/ddexe"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aZi("/system/etc/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.aZi("/system/bin/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            h.fUg();
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