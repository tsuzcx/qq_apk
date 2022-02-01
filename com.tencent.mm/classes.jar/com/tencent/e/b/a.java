package com.tencent.e.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.e.d.a.c;
import com.tencent.e.d.a.f;
import com.tencent.e.d.b.e.a;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public b ahsk;
  public Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(138310);
    this.mContext = null;
    this.mContext = paramContext;
    this.ahsk = new b(paramContext);
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
    localb.ahsR = paramInt;
    localb.ahsS = null;
    localb.ahsT = parama.pkgName;
    localb.ahsU = com.tencent.e.f.e.bFB(parama.ahsf);
    paramContext = com.tencent.e.f.a.dm(paramContext, parama.pkgName);
    if ((paramContext != null) && (paramContext.size() > 1))
    {
      localb.ahtj = new ArrayList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramContext.next();
        localb.ahtj.add(arrayOfByte);
      }
    }
    localb.ahsV = parama.fileSize;
    localb.ahsW = parama.ahse;
    localb.ahsX = parama.versionCode;
    localb.ahsY = parama.versionName;
    localb.ahsZ = 0;
    if (parama.appType == 1) {
      localb.ahsZ |= 0x1;
    }
    localb.ahsZ |= 0x2;
    if ((!parama.ahsg.startsWith("/data")) && (!parama.ahsg.startsWith("/system"))) {
      localb.ahsZ |= 0x4;
    }
    localb.ahta = "";
    localb.ahtb = 0;
    localb.ahtc = 0;
    localb.ahtd = 0;
    localb.ahte = null;
    localb.ahtf = 0;
    localb.ahtg = false;
    localb.ahth = 0;
    localb.ahti = 0;
    AppMethodBeat.o(138312);
    return localb;
  }
  
  public static com.tencent.e.c.b.d jXd()
  {
    AppMethodBeat.i(138311);
    com.tencent.e.c.b.d locald = new com.tencent.e.c.b.d();
    for (;;)
    {
      try
      {
        locald.ahtz = Build.FINGERPRINT;
        locald.ahtA = com.tencent.e.f.d.jXB();
        locald.brand = Build.BRAND;
        locald.model = q.aPo();
        locald.ahtB = Build.VERSION.SDK_INT;
        locald.ahtC = Build.CPU_ABI;
        locald.platform = com.tencent.e.f.d.bFA("ro.board.platform");
        if (!f.jXh()) {
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
      localObject2 = com.tencent.e.d.b.e.jXi();
      if (com.tencent.e.d.b.a.isEmpty((Collection)localObject2)) {
        continue;
      }
      localObject1 = new ArrayList(3);
      ((List)localObject1).add(new com.tencent.e.d.a.g());
      ((List)localObject1).add(new com.tencent.e.d.a.d());
      if (com.tencent.e.d.b.g.jXj()) {
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
        if (((com.tencent.e.d.a.b)((Iterator)localObject1).next()).jXf())
        {
          i = 1;
          continue;
          if (com.tencent.e.d.a.e.jXg())
          {
            i = 1;
          }
          else
          {
            if (!com.tencent.e.d.a.a.bFw("/system/bin/debuggerd"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.bFw("/system/bin/debuggerd64"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.bFw("/system/bin/ddexe"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.bFx("/system/etc/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.bFx("/system/bin/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            h.jXC();
            i = 0;
            continue;
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.b.a
 * JD-Core Version:    0.7.0.1
 */