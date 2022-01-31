package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.d.d.a.c;
import com.tencent.d.d.a.g;
import com.tencent.d.d.b.d.a;
import com.tencent.d.f.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public Context mContext = null;
  public b wLr;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.wLr = new b(paramContext);
  }
  
  public static com.tencent.d.c.b.b a(Context paramContext, com.tencent.d.a.a parama, int paramInt)
  {
    if (parama == null) {
      return null;
    }
    com.tencent.d.c.b.b localb = new com.tencent.d.c.b.b();
    localb.wMa = paramInt;
    localb.wMb = null;
    localb.wMc = parama.bwQ;
    localb.wMd = com.tencent.d.f.e.afK(parama.wLm);
    paramContext = com.tencent.d.f.a.bL(paramContext, parama.bwQ);
    if (paramContext.size() > 1)
    {
      localb.wMs = new ArrayList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramContext.next();
        localb.wMs.add(arrayOfByte);
      }
    }
    localb.wMe = parama.fileSize;
    localb.wMf = parama.wLl;
    localb.wMg = parama.versionCode;
    localb.wMh = parama.versionName;
    localb.wMi = 0;
    if (parama.dlO == 1) {
      localb.wMi |= 0x1;
    }
    localb.wMi |= 0x2;
    if ((!parama.wLn.startsWith("/data")) && (!parama.wLn.startsWith("/system"))) {
      localb.wMi |= 0x4;
    }
    localb.wMj = com.tencent.d.f.a.afI(parama.wLn);
    localb.wMk = 0;
    localb.wMl = 0;
    localb.wMm = 0;
    localb.wMn = null;
    localb.wMo = 0;
    localb.wMp = false;
    localb.wMq = 0;
    localb.wMr = 0;
    return localb;
  }
  
  public static com.tencent.d.c.b.d cOG()
  {
    com.tencent.d.c.b.d locald = new com.tencent.d.c.b.d();
    for (;;)
    {
      int i;
      try
      {
        locald.wMI = Build.FINGERPRINT;
        locald.wMJ = com.tencent.d.f.d.cPb();
        locald.egI = Build.BRAND;
        locald.model = Build.MODEL;
        locald.wMK = Build.VERSION.SDK_INT;
        locald.wML = Build.CPU_ABI;
        locald.platform = com.tencent.d.f.d.afJ("ro.board.platform");
        if (com.tencent.d.d.a.f.cOK())
        {
          i = 2;
          locald.root = i;
          return locald;
        }
        Object localObject2 = com.tencent.d.d.b.d.cOL();
        if (!((Collection)localObject2).isEmpty()) {
          break label358;
        }
        i = 1;
        if (i != 0) {
          break label372;
        }
        Object localObject1 = new ArrayList(3);
        ((List)localObject1).add(new g());
        ((List)localObject1).add(new com.tencent.d.d.a.d());
        if (com.tencent.d.d.b.f.cOM()) {
          ((List)localObject1).add(new c());
        }
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          d.a locala = (d.a)((Iterator)localObject2).next();
          if (locala == null) {
            continue;
          }
          Iterator localIterator = ((List)localObject1).iterator();
          if (localIterator.hasNext())
          {
            ((com.tencent.d.d.a.b)localIterator.next()).a(locala);
            continue;
          }
          continue;
        }
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label372;
        }
        if (!((com.tencent.d.d.a.b)((Iterator)localObject1).next()).cOI()) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        return locald;
      }
      if (com.tencent.d.d.a.e.cOJ())
      {
        i = 1;
      }
      else
      {
        if (!com.tencent.d.d.a.a.afD("/system/bin/debuggerd"))
        {
          i = 1;
        }
        else if (!com.tencent.d.d.a.a.afD("/system/bin/debuggerd64"))
        {
          i = 1;
        }
        else if (!com.tencent.d.d.a.a.afD("/system/bin/ddexe"))
        {
          i = 1;
        }
        else if (!com.tencent.d.d.a.a.afE("/system/etc/install-recovery.sh"))
        {
          i = 1;
        }
        else if (!com.tencent.d.d.a.a.afE("/system/bin/install-recovery.sh"))
        {
          i = 1;
        }
        else
        {
          h.i("BootScriptChecker : everything seems ok");
          i = 0;
          break label377;
          i = 0;
          continue;
          label358:
          i = 0;
          continue;
          for (;;)
          {
            if (i == 0) {
              break label375;
            }
            i = 2;
            break;
            label372:
            i = 0;
          }
          label375:
          continue;
        }
        label377:
        if (i != 0) {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.b.a
 * JD-Core Version:    0.7.0.1
 */