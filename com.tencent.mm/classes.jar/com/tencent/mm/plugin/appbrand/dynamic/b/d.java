package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.t.a;
import com.tencent.mm.plugin.appbrand.appcache.t.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.g.a.c.m;
import java.util.ArrayList;
import java.util.Locale;

public final class d
  implements t.b
{
  public final t.a a(a parama)
  {
    if (au.class == parama.getClass()) {
      return new a((au)parama, (byte)0);
    }
    return null;
  }
  
  private static final class a
    implements t.a
  {
    private ArrayList<IDKey> fCs;
    private long fCt = 0L;
    private long fCu = 0L;
    private final au fUM;
    private d.a.a fUN;
    
    private a(au paramau)
    {
      this.fUM = paramau;
    }
    
    private void abJ()
    {
      try
      {
        f.nEG.b(this.fCs, false);
        this.fCs.clear();
        return;
      }
      catch (Exception localException) {}
    }
    
    private void kH(int paramInt)
    {
      if (this.fCs == null) {
        this.fCs = new ArrayList();
      }
      this.fCs.add(new IDKey(640, paramInt, 1));
    }
    
    public final void a(m paramm)
    {
      int k = 1;
      int j = 2;
      long l = SystemClock.elapsedRealtime() - this.fCt;
      if (l <= 1000L)
      {
        i = 0;
        label26:
        f.nEG.a(665L, i, 1L, false);
        f.nEG.a(665L, 6L, 1L, false);
        if ((paramm == null) || (paramm.status != 2)) {
          break label166;
        }
      }
      label166:
      for (int i = k;; i = 0) {
        switch (d.1.fUL[this.fUN.ordinal()])
        {
        default: 
          abJ();
          return;
          if (l <= 2000L)
          {
            i = 1;
            break label26;
          }
          if (l <= 3000L)
          {
            i = 2;
            break label26;
          }
          if (l <= 4000L)
          {
            i = 3;
            break label26;
          }
          if (l <= 5000L)
          {
            i = 4;
            break label26;
          }
          i = 5;
          break label26;
        }
      }
      if (i != 0) {}
      for (i = j;; i = 3)
      {
        kH(i);
        break;
      }
      if (i != 0) {}
      for (i = 11;; i = 12)
      {
        kH(i);
        break;
      }
    }
    
    public final void abq()
    {
      int j = 0;
      Object localObject;
      if (com.tencent.mm.plugin.appbrand.appcache.d.a.kq(this.fUM.bOa))
      {
        if (((c)g.r(c.class)).aaG() == null) {
          i = 1;
        }
        while (i > 1)
        {
          localObject = d.a.a.fUP;
          label42:
          this.fUN = ((d.a.a)localObject);
          label47:
          switch (d.1.fUL[this.fUN.ordinal()])
          {
          default: 
            i = j;
            label82:
            kH(i);
            this.fCt = SystemClock.elapsedRealtime();
            return;
            localObject = ((c)g.r(c.class)).aaG();
            String str1 = this.fUM.appId;
            i = this.fUM.bOa;
            String str2 = String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[] { "version", "AppBrandWxaPkgManifestRecord", "appId", "debugType" });
            localObject = ((ar)localObject).fEC.a(str2, new String[] { str1, String.valueOf(i) }, 2);
            if (localObject == null) {
              i = 0;
            } else {
              if (!((Cursor)localObject).moveToFirst()) {
                break label250;
              }
            }
            break;
          }
        }
      }
      label250:
      for (int i = ((Cursor)localObject).getInt(0);; i = 0)
      {
        ((Cursor)localObject).close();
        break;
        localObject = d.a.a.fUO;
        break label42;
        this.fUN = d.a.a.fUO;
        break label47;
        i = 1;
        break label82;
        i = 10;
        break label82;
      }
    }
    
    public final void abr()
    {
      kH(32);
    }
    
    public final void abs()
    {
      kH(31);
    }
    
    public final void abt() {}
    
    public final void abu() {}
    
    public final void abv()
    {
      this.fCu = SystemClock.elapsedRealtime();
      switch (d.1.fUL[this.fUN.ordinal()])
      {
      default: 
        return;
      case 1: 
        kH(5);
        return;
      }
      kH(14);
    }
    
    public final void cG(boolean paramBoolean)
    {
      SystemClock.elapsedRealtime();
      int i;
      switch (d.1.fUL[this.fUN.ordinal()])
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        kH(i);
        abJ();
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
    
    public final void kr(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.d
 * JD-Core Version:    0.7.0.1
 */