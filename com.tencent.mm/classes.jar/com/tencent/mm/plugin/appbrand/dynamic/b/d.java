package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ag.a;
import com.tencent.mm.plugin.appbrand.appcache.ag.b;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.by;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.res.downloader.model.l;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import java.util.ArrayList;
import java.util.Locale;

public final class d
  implements ag.b
{
  public final ag.a b(a parama)
  {
    AppMethodBeat.i(121269);
    if (by.class == parama.getClass())
    {
      parama = new a((by)parama, (byte)0);
      AppMethodBeat.o(121269);
      return parama;
    }
    AppMethodBeat.o(121269);
    return null;
  }
  
  static final class a
    implements ag.a
  {
    private ArrayList<IDKey> qEZ;
    private long qFa = 0L;
    private long qFb = 0L;
    private final by rlg;
    private a rlh;
    
    private a(by paramby)
    {
      this.rlg = paramby;
    }
    
    private void cgn()
    {
      AppMethodBeat.i(121262);
      try
      {
        f.Ozc.b(this.qEZ, false);
        this.qEZ.clear();
        AppMethodBeat.o(121262);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(121262);
      }
    }
    
    private void zQ(int paramInt)
    {
      AppMethodBeat.i(121261);
      if (this.qEZ == null) {
        this.qEZ = new ArrayList();
      }
      this.qEZ.add(new IDKey(640, paramInt, 1));
      AppMethodBeat.o(121261);
    }
    
    public final void a(l paraml)
    {
      int k = 1;
      int j = 2;
      AppMethodBeat.i(121266);
      long l = SystemClock.elapsedRealtime() - this.qFa;
      if (l <= 1000L)
      {
        i = 0;
        label31:
        f.Ozc.idkeyStat(665L, i, 1L, false);
        f.Ozc.idkeyStat(665L, 6L, 1L, false);
        if ((paraml == null) || (paraml.status != 2)) {
          break label179;
        }
      }
      label179:
      for (int i = k;; i = 0) {
        switch (d.1.rlf[this.rlh.ordinal()])
        {
        default: 
          cgn();
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
        zQ(i);
        break;
      }
      if (i != 0) {}
      for (i = 11;; i = 12)
      {
        zQ(i);
        break;
      }
    }
    
    public final void cfP()
    {
      int j = 0;
      AppMethodBeat.i(121263);
      Object localObject;
      if (k.a.zn(this.rlg.hJK))
      {
        if (((e)h.ax(e.class)).ceo() == null) {
          i = 1;
        }
        while (i > 1)
        {
          localObject = a.rlj;
          label47:
          this.rlh = ((a)localObject);
          label52:
          switch (d.1.rlf[this.rlh.ordinal()])
          {
          default: 
            i = j;
            label86:
            zQ(i);
            this.qFa = SystemClock.elapsedRealtime();
            AppMethodBeat.o(121263);
            return;
            localObject = ((e)h.ax(e.class)).ceo();
            String str1 = this.rlg.appId;
            i = this.rlg.hJK;
            String str2 = String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[] { "version", "AppBrandWxaPkgManifestRecord", "appId", "debugType" });
            localObject = ((bm)localObject).qHv.rawQuery(str2, new String[] { str1, String.valueOf(i) }, 2);
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
        localObject = a.rli;
        break label47;
        this.rlh = a.rli;
        break label52;
        i = 1;
        break label86;
        i = 10;
        break label86;
      }
    }
    
    public final void cfQ()
    {
      AppMethodBeat.i(121264);
      zQ(32);
      AppMethodBeat.o(121264);
    }
    
    public final void cfR()
    {
      AppMethodBeat.i(324805);
      zQ(34);
      AppMethodBeat.o(324805);
    }
    
    public final void cfS() {}
    
    public final void cfT() {}
    
    public final void cfU()
    {
      AppMethodBeat.i(121267);
      this.qFb = SystemClock.elapsedRealtime();
      switch (d.1.rlf[this.rlh.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(121267);
        return;
        zQ(5);
        AppMethodBeat.o(121267);
        return;
        zQ(14);
      }
    }
    
    public final void cfV() {}
    
    public final void ig(boolean paramBoolean)
    {
      AppMethodBeat.i(121268);
      SystemClock.elapsedRealtime();
      int i;
      switch (d.1.rlf[this.rlh.ordinal()])
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        zQ(i);
        cgn();
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
    
    public final void ih(boolean paramBoolean) {}
    
    public final void zo(int paramInt) {}
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(121260);
        rli = new a("DOWNLOAD", 0);
        rlj = new a("UPDATE", 1);
        rlk = new a[] { rli, rlj };
        AppMethodBeat.o(121260);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.d
 * JD-Core Version:    0.7.0.1
 */