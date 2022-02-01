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
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
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
    private ArrayList<IDKey> kLk;
    private long kLl = 0L;
    private long kLm = 0L;
    private final br lmS;
    private a lmT;
    
    private a(br parambr)
    {
      this.lmS = parambr;
    }
    
    private void bvI()
    {
      AppMethodBeat.i(121262);
      try
      {
        com.tencent.mm.plugin.report.e.Cxv.b(this.kLk, false);
        this.kLk.clear();
        AppMethodBeat.o(121262);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(121262);
      }
    }
    
    private void wn(int paramInt)
    {
      AppMethodBeat.i(121261);
      if (this.kLk == null) {
        this.kLk = new ArrayList();
      }
      this.kLk.add(new IDKey(640, paramInt, 1));
      AppMethodBeat.o(121261);
    }
    
    public final void a(m paramm)
    {
      int k = 1;
      int j = 2;
      AppMethodBeat.i(121266);
      long l = SystemClock.elapsedRealtime() - this.kLl;
      if (l <= 1000L)
      {
        i = 0;
        label31:
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(665L, i, 1L, false);
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(665L, 6L, 1L, false);
        if ((paramm == null) || (paramm.status != 2)) {
          break label179;
        }
      }
      label179:
      for (int i = k;; i = 0) {
        switch (d.1.lmR[this.lmT.ordinal()])
        {
        default: 
          bvI();
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
        wn(i);
        break;
      }
      if (i != 0) {}
      for (i = 11;; i = 12)
      {
        wn(i);
        break;
      }
    }
    
    public final void bvj()
    {
      int j = 0;
      AppMethodBeat.i(121263);
      Object localObject;
      if (j.a.vP(this.lmS.dMe))
      {
        if (((com.tencent.mm.plugin.appbrand.api.e)g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub() == null) {
          i = 1;
        }
        while (i > 1)
        {
          localObject = a.lmV;
          label47:
          this.lmT = ((a)localObject);
          label52:
          switch (d.1.lmR[this.lmT.ordinal()])
          {
          default: 
            i = j;
            label86:
            wn(i);
            this.kLl = SystemClock.elapsedRealtime();
            AppMethodBeat.o(121263);
            return;
            localObject = ((com.tencent.mm.plugin.appbrand.api.e)g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub();
            String str1 = this.lmS.appId;
            i = this.lmS.dMe;
            String str2 = String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[] { "version", "AppBrandWxaPkgManifestRecord", "appId", "debugType" });
            localObject = ((bh)localObject).kNJ.rawQuery(str2, new String[] { str1, String.valueOf(i) }, 2);
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
        localObject = a.lmU;
        break label47;
        this.lmT = a.lmU;
        break label52;
        i = 1;
        break label86;
        i = 10;
        break label86;
      }
    }
    
    public final void bvk()
    {
      AppMethodBeat.i(121264);
      wn(32);
      AppMethodBeat.o(121264);
    }
    
    public final void bvl()
    {
      AppMethodBeat.i(192518);
      wn(34);
      AppMethodBeat.o(192518);
    }
    
    public final void bvm() {}
    
    public final void bvn() {}
    
    public final void bvo()
    {
      AppMethodBeat.i(121267);
      this.kLm = SystemClock.elapsedRealtime();
      switch (d.1.lmR[this.lmT.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(121267);
        return;
        wn(5);
        AppMethodBeat.o(121267);
        return;
        wn(14);
      }
    }
    
    public final void bvp() {}
    
    public final void gE(boolean paramBoolean)
    {
      AppMethodBeat.i(121268);
      SystemClock.elapsedRealtime();
      int i;
      switch (d.1.lmR[this.lmT.ordinal()])
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        wn(i);
        bvI();
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
    
    public final void gF(boolean paramBoolean) {}
    
    public final void vQ(int paramInt) {}
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(121260);
        lmU = new a("DOWNLOAD", 0);
        lmV = new a("UPDATE", 1);
        lmW = new a[] { lmU, lmV };
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