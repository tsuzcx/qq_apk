package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.af.a;
import com.tencent.mm.plugin.appbrand.appcache.af.b;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bz;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import java.util.ArrayList;
import java.util.Locale;

public final class d
  implements af.b
{
  public final af.a b(a parama)
  {
    AppMethodBeat.i(121269);
    if (bz.class == parama.getClass())
    {
      parama = new a((bz)parama, (byte)0);
      AppMethodBeat.o(121269);
      return parama;
    }
    AppMethodBeat.o(121269);
    return null;
  }
  
  static final class a
    implements af.a
  {
    private ArrayList<IDKey> nFd;
    private long nFe = 0L;
    private long nFf = 0L;
    private final bz ohE;
    private a ohF;
    
    private a(bz parambz)
    {
      this.ohE = parambz;
    }
    
    private void bGP()
    {
      AppMethodBeat.i(121262);
      try
      {
        f.Iyx.b(this.nFd, false);
        this.nFd.clear();
        AppMethodBeat.o(121262);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(121262);
      }
    }
    
    private void zA(int paramInt)
    {
      AppMethodBeat.i(121261);
      if (this.nFd == null) {
        this.nFd = new ArrayList();
      }
      this.nFd.add(new IDKey(640, paramInt, 1));
      AppMethodBeat.o(121261);
    }
    
    public final void a(l paraml)
    {
      int k = 1;
      int j = 2;
      AppMethodBeat.i(121266);
      long l = SystemClock.elapsedRealtime() - this.nFe;
      if (l <= 1000L)
      {
        i = 0;
        label31:
        f.Iyx.idkeyStat(665L, i, 1L, false);
        f.Iyx.idkeyStat(665L, 6L, 1L, false);
        if ((paraml == null) || (paraml.status != 2)) {
          break label179;
        }
      }
      label179:
      for (int i = k;; i = 0) {
        switch (d.1.ohD[this.ohF.ordinal()])
        {
        default: 
          bGP();
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
        zA(i);
        break;
      }
      if (i != 0) {}
      for (i = 11;; i = 12)
      {
        zA(i);
        break;
      }
    }
    
    public final void bGp()
    {
      int j = 0;
      AppMethodBeat.i(121263);
      Object localObject;
      if (j.a.za(this.ohE.fES))
      {
        if (((e)h.ae(e.class)).bFb() == null) {
          i = 1;
        }
        while (i > 1)
        {
          localObject = a.ohH;
          label47:
          this.ohF = ((a)localObject);
          label52:
          switch (d.1.ohD[this.ohF.ordinal()])
          {
          default: 
            i = j;
            label86:
            zA(i);
            this.nFe = SystemClock.elapsedRealtime();
            AppMethodBeat.o(121263);
            return;
            localObject = ((e)h.ae(e.class)).bFb();
            String str1 = this.ohE.appId;
            i = this.ohE.fES;
            String str2 = String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[] { "version", "AppBrandWxaPkgManifestRecord", "appId", "debugType" });
            localObject = ((bm)localObject).nHI.rawQuery(str2, new String[] { str1, String.valueOf(i) }, 2);
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
        localObject = a.ohG;
        break label47;
        this.ohF = a.ohG;
        break label52;
        i = 1;
        break label86;
        i = 10;
        break label86;
      }
    }
    
    public final void bGq()
    {
      AppMethodBeat.i(121264);
      zA(32);
      AppMethodBeat.o(121264);
    }
    
    public final void bGr()
    {
      AppMethodBeat.i(246311);
      zA(34);
      AppMethodBeat.o(246311);
    }
    
    public final void bGs() {}
    
    public final void bGt() {}
    
    public final void bGu()
    {
      AppMethodBeat.i(121267);
      this.nFf = SystemClock.elapsedRealtime();
      switch (d.1.ohD[this.ohF.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(121267);
        return;
        zA(5);
        AppMethodBeat.o(121267);
        return;
        zA(14);
      }
    }
    
    public final void bGv() {}
    
    public final void hp(boolean paramBoolean)
    {
      AppMethodBeat.i(121268);
      SystemClock.elapsedRealtime();
      int i;
      switch (d.1.ohD[this.ohF.ordinal()])
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        zA(i);
        bGP();
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
    
    public final void hq(boolean paramBoolean) {}
    
    public final void zb(int paramInt) {}
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(121260);
        ohG = new a("DOWNLOAD", 0);
        ohH = new a("UPDATE", 1);
        ohI = new a[] { ohG, ohH };
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