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
  public b Miu;
  public Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(138310);
    this.mContext = null;
    this.mContext = paramContext;
    this.Miu = new b(paramContext);
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
    localb.Mjb = paramInt;
    localb.Mjc = null;
    localb.Mjd = parama.dGI;
    localb.Mje = com.tencent.d.f.e.baQ(parama.Mip);
    paramContext = com.tencent.d.f.a.cy(paramContext, parama.dGI);
    if (paramContext.size() > 1)
    {
      localb.Mjt = new ArrayList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramContext.next();
        localb.Mjt.add(arrayOfByte);
      }
    }
    localb.Mjf = parama.fileSize;
    localb.Mjg = parama.Mio;
    localb.Mjh = parama.versionCode;
    localb.Mji = parama.versionName;
    localb.Mjj = 0;
    if (parama.appType == 1) {
      localb.Mjj |= 0x1;
    }
    localb.Mjj |= 0x2;
    if ((!parama.Miq.startsWith("/data")) && (!parama.Miq.startsWith("/system"))) {
      localb.Mjj |= 0x4;
    }
    localb.Mjk = "";
    localb.Mjl = 0;
    localb.Mjm = 0;
    localb.Mjn = 0;
    localb.Mjo = null;
    localb.Mjp = 0;
    localb.Mjq = false;
    localb.Mjr = 0;
    localb.Mjs = 0;
    AppMethodBeat.o(138312);
    return localb;
  }
  
  public static com.tencent.d.c.b.d fYi()
  {
    AppMethodBeat.i(138311);
    com.tencent.d.c.b.d locald = new com.tencent.d.c.b.d();
    for (;;)
    {
      try
      {
        locald.MjJ = Build.FINGERPRINT;
        locald.MjK = com.tencent.d.f.d.fYE();
        locald.hTy = Build.BRAND;
        locald.model = Build.MODEL;
        locald.MjL = Build.VERSION.SDK_INT;
        locald.MjM = Build.CPU_ABI;
        locald.platform = com.tencent.d.f.d.baP("ro.board.platform");
        if (!com.tencent.d.d.a.f.fYm()) {
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
      locald.MjN = i;
      AppMethodBeat.o(138311);
      return locald;
      localObject2 = com.tencent.d.d.b.d.fYn();
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
      if (com.tencent.d.d.b.f.fYo()) {
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
        if (((com.tencent.d.d.a.b)((Iterator)localObject1).next()).fYk())
        {
          i = 1;
          continue;
          if (com.tencent.d.d.a.e.fYl())
          {
            i = 1;
          }
          else
          {
            if (!com.tencent.d.d.a.a.baK("/system/bin/debuggerd"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.baK("/system/bin/debuggerd64"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.baK("/system/bin/ddexe"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.baL("/system/etc/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.d.d.a.a.baL("/system/bin/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            h.fYF();
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