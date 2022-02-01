package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ad.a;
import com.tencent.mm.plugin.appbrand.appcache.ad.b;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.e.f;
import java.util.ArrayList;
import java.util.Locale;

public final class d
  implements ad.b
{
  public final ad.a b(a parama)
  {
    AppMethodBeat.i(121269);
    if (bp.class == parama.getClass())
    {
      parama = new a((bp)parama, (byte)0);
      AppMethodBeat.o(121269);
      return parama;
    }
    AppMethodBeat.o(121269);
    return null;
  }
  
  static final class a
    implements ad.a
  {
    private ArrayList<IDKey> jGn;
    private long jGo = 0L;
    private long jGp = 0L;
    private final bp kfU;
    private a kfV;
    
    private a(bp parambp)
    {
      this.kfU = parambp;
    }
    
    private void aZV()
    {
      AppMethodBeat.i(121262);
      try
      {
        com.tencent.mm.plugin.report.e.ygI.b(this.jGn, false);
        this.jGn.clear();
        AppMethodBeat.o(121262);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(121262);
      }
    }
    
    private void so(int paramInt)
    {
      AppMethodBeat.i(121261);
      if (this.jGn == null) {
        this.jGn = new ArrayList();
      }
      this.jGn.add(new IDKey(640, paramInt, 1));
      AppMethodBeat.o(121261);
    }
    
    public final void a(m paramm)
    {
      int k = 1;
      int j = 2;
      AppMethodBeat.i(121266);
      long l = SystemClock.elapsedRealtime() - this.jGo;
      if (l <= 1000L)
      {
        i = 0;
        label31:
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(665L, i, 1L, false);
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(665L, 6L, 1L, false);
        if ((paramm == null) || (paramm.status != 2)) {
          break label179;
        }
      }
      label179:
      for (int i = k;; i = 0) {
        switch (d.1.kfT[this.kfV.ordinal()])
        {
        default: 
          aZV();
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
        so(i);
        break;
      }
      if (i != 0) {}
      for (i = 11;; i = 12)
      {
        so(i);
        break;
      }
    }
    
    public final void aZA()
    {
      AppMethodBeat.i(121267);
      this.jGp = SystemClock.elapsedRealtime();
      switch (d.1.kfT[this.kfV.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(121267);
        return;
        so(5);
        AppMethodBeat.o(121267);
        return;
        so(14);
      }
    }
    
    public final void aZB() {}
    
    public final void aZv()
    {
      int j = 0;
      AppMethodBeat.i(121263);
      Object localObject;
      if (j.a.rQ(this.kfU.dtF))
      {
        if (((com.tencent.mm.plugin.appbrand.api.e)g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu() == null) {
          i = 1;
        }
        while (i > 1)
        {
          localObject = a.kfX;
          label47:
          this.kfV = ((a)localObject);
          label52:
          switch (d.1.kfT[this.kfV.ordinal()])
          {
          default: 
            i = j;
            label86:
            so(i);
            this.jGo = SystemClock.elapsedRealtime();
            AppMethodBeat.o(121263);
            return;
            localObject = ((com.tencent.mm.plugin.appbrand.api.e)g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu();
            String str1 = this.kfU.appId;
            i = this.kfU.dtF;
            String str2 = String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[] { "version", "AppBrandWxaPkgManifestRecord", "appId", "debugType" });
            localObject = ((bg)localObject).jIJ.a(str2, new String[] { str1, String.valueOf(i) }, 2);
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
        localObject = a.kfW;
        break label47;
        this.kfV = a.kfW;
        break label52;
        i = 1;
        break label86;
        i = 10;
        break label86;
      }
    }
    
    public final void aZw()
    {
      AppMethodBeat.i(121264);
      so(32);
      AppMethodBeat.o(121264);
    }
    
    public final void aZx()
    {
      AppMethodBeat.i(121265);
      so(31);
      AppMethodBeat.o(121265);
    }
    
    public final void aZy() {}
    
    public final void aZz() {}
    
    public final void fJ(boolean paramBoolean)
    {
      AppMethodBeat.i(121268);
      SystemClock.elapsedRealtime();
      int i;
      switch (d.1.kfT[this.kfV.ordinal()])
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        so(i);
        aZV();
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
    
    public final void fK(boolean paramBoolean) {}
    
    public final void rR(int paramInt) {}
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(121260);
        kfW = new a("DOWNLOAD", 0);
        kfX = new a("UPDATE", 1);
        kfY = new a[] { kfW, kfX };
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