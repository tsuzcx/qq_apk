package com.tencent.e.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.e.d.a.c;
import com.tencent.e.d.a.g;
import com.tencent.e.d.b.d.a;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public b BiQ;
  public Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(114469);
    this.mContext = null;
    this.mContext = paramContext;
    this.BiQ = new b(paramContext);
    AppMethodBeat.o(114469);
  }
  
  public static com.tencent.e.c.b.b a(Context paramContext, com.tencent.e.a.a parama, int paramInt)
  {
    AppMethodBeat.i(114471);
    if (parama == null)
    {
      AppMethodBeat.o(114471);
      return null;
    }
    com.tencent.e.c.b.b localb = new com.tencent.e.c.b.b();
    localb.Bjy = paramInt;
    localb.Bjz = null;
    localb.BjA = parama.bYA;
    localb.BjB = com.tencent.e.f.e.awF(parama.BiL);
    paramContext = com.tencent.e.f.a.ca(paramContext, parama.bYA);
    if (paramContext.size() > 1)
    {
      localb.BjQ = new ArrayList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramContext.next();
        localb.BjQ.add(arrayOfByte);
      }
    }
    localb.BjC = parama.fileSize;
    localb.BjD = parama.BiK;
    localb.BjE = parama.versionCode;
    localb.BjF = parama.versionName;
    localb.BjG = 0;
    if (parama.edl == 1) {
      localb.BjG |= 0x1;
    }
    localb.BjG |= 0x2;
    if ((!parama.BiM.startsWith("/data")) && (!parama.BiM.startsWith("/system"))) {
      localb.BjG |= 0x4;
    }
    localb.BjH = "";
    localb.BjI = 0;
    localb.BjJ = 0;
    localb.BjK = 0;
    localb.BjL = null;
    localb.BjM = 0;
    localb.BjN = false;
    localb.BjO = 0;
    localb.BjP = 0;
    AppMethodBeat.o(114471);
    return localb;
  }
  
  public static com.tencent.e.c.b.d dUv()
  {
    AppMethodBeat.i(114470);
    com.tencent.e.c.b.d locald = new com.tencent.e.c.b.d();
    for (;;)
    {
      try
      {
        locald.Bkg = Build.FINGERPRINT;
        locald.Bkh = com.tencent.e.f.d.dUR();
        locald.fwM = Build.BRAND;
        locald.model = Build.MODEL;
        locald.Bki = Build.VERSION.SDK_INT;
        locald.Bkj = Build.CPU_ABI;
        locald.platform = com.tencent.e.f.d.awE("ro.board.platform");
        if (!com.tencent.e.d.a.f.dUz()) {
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
      locald.Bkk = i;
      AppMethodBeat.o(114470);
      return locald;
      localObject2 = com.tencent.e.d.b.d.dUA();
      if (!((Collection)localObject2).isEmpty()) {
        continue;
      }
      i = 1;
      if (i != 0) {
        continue;
      }
      localObject1 = new ArrayList(3);
      ((List)localObject1).add(new g());
      ((List)localObject1).add(new com.tencent.e.d.a.d());
      if (com.tencent.e.d.b.f.dUB()) {
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
        if (((com.tencent.e.d.a.b)((Iterator)localObject1).next()).dUx())
        {
          i = 1;
          continue;
          if (com.tencent.e.d.a.e.dUy())
          {
            i = 1;
          }
          else
          {
            if (!com.tencent.e.d.a.a.awz("/system/bin/debuggerd"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.awz("/system/bin/debuggerd64"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.awz("/system/bin/ddexe"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.awA("/system/etc/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            if (!com.tencent.e.d.a.a.awA("/system/bin/install-recovery.sh"))
            {
              i = 1;
              continue;
            }
            h.dUT();
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
 * Qualified Name:     com.tencent.e.b.a
 * JD-Core Version:    0.7.0.1
 */