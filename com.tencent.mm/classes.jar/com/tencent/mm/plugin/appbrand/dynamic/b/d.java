package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ae.a;
import com.tencent.mm.plugin.appbrand.appcache.ae.b;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.br;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.e.f;
import java.util.ArrayList;
import java.util.Locale;

public final class d
  implements ae.b
{
  public final ae.a b(a parama)
  {
    AppMethodBeat.i(121269);
    if (br.class == parama.getClass())
    {
      parama = new a((br)parama, (byte)0);
      AppMethodBeat.o(121269);
      return parama;
    }
    AppMethodBeat.o(121269);
    return null;
  }
  
  static final class a
    implements ae.a
  {
    private ArrayList<IDKey> jJn;
    private long jJo = 0L;
    private long jJp = 0L;
    private final br kjk;
    private a kjl;
    
    private a(br parambr)
    {
      this.kjk = parambr;
    }
    
    private void bau()
    {
      AppMethodBeat.i(121262);
      try
      {
        com.tencent.mm.plugin.report.e.ywz.b(this.jJn, false);
        this.jJn.clear();
        AppMethodBeat.o(121262);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(121262);
      }
    }
    
    private void sr(int paramInt)
    {
      AppMethodBeat.i(121261);
      if (this.jJn == null) {
        this.jJn = new ArrayList();
      }
      this.jJn.add(new IDKey(640, paramInt, 1));
      AppMethodBeat.o(121261);
    }
    
    public final void a(m paramm)
    {
      int k = 1;
      int j = 2;
      AppMethodBeat.i(121266);
      long l = SystemClock.elapsedRealtime() - this.jJo;
      if (l <= 1000L)
      {
        i = 0;
        label31:
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(665L, i, 1L, false);
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(665L, 6L, 1L, false);
        if ((paramm == null) || (paramm.status != 2)) {
          break label179;
        }
      }
      label179:
      for (int i = k;; i = 0) {
        switch (d.1.kjj[this.kjl.ordinal()])
        {
        default: 
          bau();
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
        sr(i);
        break;
      }
      if (i != 0) {}
      for (i = 11;; i = 12)
      {
        sr(i);
        break;
      }
    }
    
    public final void aZS()
    {
      int j = 0;
      AppMethodBeat.i(121263);
      Object localObject;
      if (j.a.rT(this.kjk.duK))
      {
        if (((com.tencent.mm.plugin.appbrand.api.e)g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP() == null) {
          i = 1;
        }
        while (i > 1)
        {
          localObject = a.kjn;
          label47:
          this.kjl = ((a)localObject);
          label52:
          switch (d.1.kjj[this.kjl.ordinal()])
          {
          default: 
            i = j;
            label86:
            sr(i);
            this.jJo = SystemClock.elapsedRealtime();
            AppMethodBeat.o(121263);
            return;
            localObject = ((com.tencent.mm.plugin.appbrand.api.e)g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP();
            String str1 = this.kjk.appId;
            i = this.kjk.duK;
            String str2 = String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[] { "version", "AppBrandWxaPkgManifestRecord", "appId", "debugType" });
            localObject = ((bh)localObject).jLK.a(str2, new String[] { str1, String.valueOf(i) }, 2);
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
        localObject = a.kjm;
        break label47;
        this.kjl = a.kjm;
        break label52;
        i = 1;
        break label86;
        i = 10;
        break label86;
      }
    }
    
    public final void aZT()
    {
      AppMethodBeat.i(121264);
      sr(32);
      AppMethodBeat.o(121264);
    }
    
    public final void aZU()
    {
      AppMethodBeat.i(121265);
      sr(31);
      AppMethodBeat.o(121265);
    }
    
    public final void aZV() {}
    
    public final void aZW() {}
    
    public final void aZX()
    {
      AppMethodBeat.i(121267);
      this.jJp = SystemClock.elapsedRealtime();
      switch (d.1.kjj[this.kjl.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(121267);
        return;
        sr(5);
        AppMethodBeat.o(121267);
        return;
        sr(14);
      }
    }
    
    public final void aZY() {}
    
    public final void fI(boolean paramBoolean)
    {
      AppMethodBeat.i(121268);
      SystemClock.elapsedRealtime();
      int i;
      switch (d.1.kjj[this.kjl.ordinal()])
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        sr(i);
        bau();
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
    
    public final void fJ(boolean paramBoolean) {}
    
    public final void rU(int paramInt) {}
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(121260);
        kjm = new a("DOWNLOAD", 0);
        kjn = new a("UPDATE", 1);
        kjo = new a[] { kjm, kjn };
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