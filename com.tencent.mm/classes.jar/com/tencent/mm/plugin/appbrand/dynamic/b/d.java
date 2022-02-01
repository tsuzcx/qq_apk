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
    private ArrayList<IDKey> iMk;
    private long iMl = 0L;
    private long iMm = 0L;
    private final bn jlw;
    private a jlx;
    
    private a(bn parambn)
    {
      this.jlw = parambn;
    }
    
    private void aPI()
    {
      AppMethodBeat.i(121262);
      try
      {
        com.tencent.mm.plugin.report.e.vIY.b(this.iMk, false);
        this.iMk.clear();
        AppMethodBeat.o(121262);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(121262);
      }
    }
    
    private void qZ(int paramInt)
    {
      AppMethodBeat.i(121261);
      if (this.iMk == null) {
        this.iMk = new ArrayList();
      }
      this.iMk.add(new IDKey(640, paramInt, 1));
      AppMethodBeat.o(121261);
    }
    
    public final void a(m paramm)
    {
      int k = 1;
      int j = 2;
      AppMethodBeat.i(121266);
      long l = SystemClock.elapsedRealtime() - this.iMl;
      if (l <= 1000L)
      {
        i = 0;
        label31:
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(665L, i, 1L, false);
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(665L, 6L, 1L, false);
        if ((paramm == null) || (paramm.status != 2)) {
          break label179;
        }
      }
      label179:
      for (int i = k;; i = 0) {
        switch (d.1.jlv[this.jlx.ordinal()])
        {
        default: 
          aPI();
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
        qZ(i);
        break;
      }
      if (i != 0) {}
      for (i = 11;; i = 12)
      {
        qZ(i);
        break;
      }
    }
    
    public final void aPi()
    {
      int j = 0;
      AppMethodBeat.i(121263);
      Object localObject;
      if (j.a.qD(this.jlw.dkC))
      {
        if (((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk() == null) {
          i = 1;
        }
        while (i > 1)
        {
          localObject = a.jlz;
          label47:
          this.jlx = ((a)localObject);
          label52:
          switch (d.1.jlv[this.jlx.ordinal()])
          {
          default: 
            i = j;
            label86:
            qZ(i);
            this.iMl = SystemClock.elapsedRealtime();
            AppMethodBeat.o(121263);
            return;
            localObject = ((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk();
            String str1 = this.jlw.appId;
            i = this.jlw.dkC;
            String str2 = String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[] { "version", "AppBrandWxaPkgManifestRecord", "appId", "debugType" });
            localObject = ((bf)localObject).iOE.a(str2, new String[] { str1, String.valueOf(i) }, 2);
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
        localObject = a.jly;
        break label47;
        this.jlx = a.jly;
        break label52;
        i = 1;
        break label86;
        i = 10;
        break label86;
      }
    }
    
    public final void aPj()
    {
      AppMethodBeat.i(121264);
      qZ(32);
      AppMethodBeat.o(121264);
    }
    
    public final void aPk()
    {
      AppMethodBeat.i(121265);
      qZ(31);
      AppMethodBeat.o(121265);
    }
    
    public final void aPl() {}
    
    public final void aPm() {}
    
    public final void aPn()
    {
      AppMethodBeat.i(121267);
      this.iMm = SystemClock.elapsedRealtime();
      switch (d.1.jlv[this.jlx.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(121267);
        return;
        qZ(5);
        AppMethodBeat.o(121267);
        return;
        qZ(14);
      }
    }
    
    public final void aPo() {}
    
    public final void fj(boolean paramBoolean)
    {
      AppMethodBeat.i(121268);
      SystemClock.elapsedRealtime();
      int i;
      switch (d.1.jlv[this.jlx.ordinal()])
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        qZ(i);
        aPI();
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
    
    public final void fk(boolean paramBoolean) {}
    
    public final void qE(int paramInt) {}
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(121260);
        jly = new a("DOWNLOAD", 0);
        jlz = new a("UPDATE", 1);
        jlA = new a[] { jly, jlz };
        AppMethodBeat.o(121260);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.d
 * JD-Core Version:    0.7.0.1
 */