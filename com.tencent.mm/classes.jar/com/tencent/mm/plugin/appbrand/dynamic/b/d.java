package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ac.a;
import com.tencent.mm.plugin.appbrand.appcache.ac.b;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.pluginsdk.h.a.c.m;
import com.tencent.mm.sdk.e.f;
import java.util.ArrayList;
import java.util.Locale;

public final class d
  implements ac.b
{
  public final ac.a a(a parama)
  {
    AppMethodBeat.i(121269);
    if (bn.class == parama.getClass())
    {
      parama = new a((bn)parama, (byte)0);
      AppMethodBeat.o(121269);
      return parama;
    }
    AppMethodBeat.o(121269);
    return null;
  }
  
  static final class a
    implements ac.a
  {
    private final bn jLJ;
    private a jLK;
    private ArrayList<IDKey> jmr;
    private long jms = 0L;
    private long jmt = 0L;
    
    private a(bn parambn)
    {
      this.jLJ = parambn;
    }
    
    private void aWA()
    {
      AppMethodBeat.i(121262);
      try
      {
        com.tencent.mm.plugin.report.e.wTc.b(this.jmr, false);
        this.jmr.clear();
        AppMethodBeat.o(121262);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(121262);
      }
    }
    
    private void rM(int paramInt)
    {
      AppMethodBeat.i(121261);
      if (this.jmr == null) {
        this.jmr = new ArrayList();
      }
      this.jmr.add(new IDKey(640, paramInt, 1));
      AppMethodBeat.o(121261);
    }
    
    public final void a(m paramm)
    {
      int k = 1;
      int j = 2;
      AppMethodBeat.i(121266);
      long l = SystemClock.elapsedRealtime() - this.jms;
      if (l <= 1000L)
      {
        i = 0;
        label31:
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(665L, i, 1L, false);
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(665L, 6L, 1L, false);
        if ((paramm == null) || (paramm.status != 2)) {
          break label179;
        }
      }
      label179:
      for (int i = k;; i = 0) {
        switch (d.1.jLI[this.jLK.ordinal()])
        {
        default: 
          aWA();
          AppMethodBeat.o(121266);
          return;
          if (l <= 2000L)
          {
            i = 1;
            break label31;
          }
          if (l <= 3000L)
          {
            i = 2;
            break label31;
          }
          if (l <= 4000L)
          {
            i = 3;
            break label31;
          }
          if (l <= 5000L)
          {
            i = 4;
            break label31;
          }
          i = 5;
          break label31;
        }
      }
      if (i != 0) {}
      for (i = j;; i = 3)
      {
        rM(i);
        break;
      }
      if (i != 0) {}
      for (i = 11;; i = 12)
      {
        rM(i);
        break;
      }
    }
    
    public final void aWa()
    {
      int j = 0;
      AppMethodBeat.i(121263);
      Object localObject;
      if (j.a.rq(this.jLJ.dib))
      {
        if (((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aVa() == null) {
          i = 1;
        }
        while (i > 1)
        {
          localObject = a.jLM;
          label47:
          this.jLK = ((a)localObject);
          label52:
          switch (d.1.jLI[this.jLK.ordinal()])
          {
          default: 
            i = j;
            label86:
            rM(i);
            this.jms = SystemClock.elapsedRealtime();
            AppMethodBeat.o(121263);
            return;
            localObject = ((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aVa();
            String str1 = this.jLJ.appId;
            i = this.jLJ.dib;
            String str2 = String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[] { "version", "AppBrandWxaPkgManifestRecord", "appId", "debugType" });
            localObject = ((bf)localObject).joN.a(str2, new String[] { str1, String.valueOf(i) }, 2);
            if (localObject == null) {
              i = 0;
            } else {
              if (!((Cursor)localObject).moveToFirst()) {
                break label261;
              }
            }
            break;
          }
        }
      }
      label261:
      for (int i = ((Cursor)localObject).getInt(0);; i = 0)
      {
        ((Cursor)localObject).close();
        break;
        localObject = a.jLL;
        break label47;
        this.jLK = a.jLL;
        break label52;
        i = 1;
        break label86;
        i = 10;
        break label86;
      }
    }
    
    public final void aWb()
    {
      AppMethodBeat.i(121264);
      rM(32);
      AppMethodBeat.o(121264);
    }
    
    public final void aWc()
    {
      AppMethodBeat.i(121265);
      rM(31);
      AppMethodBeat.o(121265);
    }
    
    public final void aWd() {}
    
    public final void aWe() {}
    
    public final void aWf()
    {
      AppMethodBeat.i(121267);
      this.jmt = SystemClock.elapsedRealtime();
      switch (d.1.jLI[this.jLK.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(121267);
        return;
        rM(5);
        AppMethodBeat.o(121267);
        return;
        rM(14);
      }
    }
    
    public final void aWg() {}
    
    public final void fF(boolean paramBoolean)
    {
      AppMethodBeat.i(121268);
      SystemClock.elapsedRealtime();
      int i;
      switch (d.1.jLI[this.jLK.ordinal()])
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        rM(i);
        aWA();
        AppMethodBeat.o(121268);
        return;
        if (paramBoolean)
        {
          i = 6;
        }
        else
        {
          i = 7;
          continue;
          if (paramBoolean) {
            i = 15;
          } else {
            i = 16;
          }
        }
      }
    }
    
    public final void fG(boolean paramBoolean) {}
    
    public final void rr(int paramInt) {}
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(121260);
        jLL = new a("DOWNLOAD", 0);
        jLM = new a("UPDATE", 1);
        jLN = new a[] { jLL, jLM };
        AppMethodBeat.o(121260);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.d
 * JD-Core Version:    0.7.0.1
 */