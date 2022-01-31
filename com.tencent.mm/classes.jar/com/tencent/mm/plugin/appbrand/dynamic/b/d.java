package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.z.a;
import com.tencent.mm.plugin.appbrand.appcache.z.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.e.f;
import java.util.ArrayList;
import java.util.Locale;

public final class d
  implements z.b
{
  public final z.a a(a parama)
  {
    AppMethodBeat.i(10787);
    if (bc.class == parama.getClass())
    {
      parama = new a((bc)parama, (byte)0);
      AppMethodBeat.o(10787);
      return parama;
    }
    AppMethodBeat.o(10787);
    return null;
  }
  
  static final class a
    implements z.a
  {
    private ArrayList<IDKey> gUI;
    private long gUJ = 0L;
    private long gUK = 0L;
    private final bc hoo;
    private d.a.a hop;
    
    private a(bc parambc)
    {
      this.hoo = parambc;
    }
    
    private void avA()
    {
      AppMethodBeat.i(10780);
      try
      {
        e.qrI.b(this.gUI, false);
        this.gUI.clear();
        AppMethodBeat.o(10780);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(10780);
      }
    }
    
    private void nF(int paramInt)
    {
      AppMethodBeat.i(10779);
      if (this.gUI == null) {
        this.gUI = new ArrayList();
      }
      this.gUI.add(new IDKey(640, paramInt, 1));
      AppMethodBeat.o(10779);
    }
    
    public final void a(m paramm)
    {
      int k = 1;
      int j = 2;
      AppMethodBeat.i(10784);
      long l = SystemClock.elapsedRealtime() - this.gUJ;
      if (l <= 1000L)
      {
        i = 0;
        label32:
        e.qrI.idkeyStat(665L, i, 1L, false);
        e.qrI.idkeyStat(665L, 6L, 1L, false);
        if ((paramm == null) || (paramm.status != 2)) {
          break label180;
        }
      }
      label180:
      for (int i = k;; i = 0) {
        switch (d.1.hon[this.hop.ordinal()])
        {
        default: 
          avA();
          AppMethodBeat.o(10784);
          return;
          if (l <= 2000L)
          {
            i = 1;
            break label32;
          }
          if (l <= 3000L)
          {
            i = 2;
            break label32;
          }
          if (l <= 4000L)
          {
            i = 3;
            break label32;
          }
          if (l <= 5000L)
          {
            i = 4;
            break label32;
          }
          i = 5;
          break label32;
        }
      }
      if (i != 0) {}
      for (i = j;; i = 3)
      {
        nF(i);
        break;
      }
      if (i != 0) {}
      for (i = 11;; i = 12)
      {
        nF(i);
        break;
      }
    }
    
    public final void avh()
    {
      int j = 0;
      AppMethodBeat.i(10781);
      Object localObject;
      if (j.a.nk(this.hoo.cvs))
      {
        if (((com.tencent.mm.plugin.appbrand.a.d)g.E(com.tencent.mm.plugin.appbrand.a.d.class)).we() == null) {
          i = 1;
        }
        while (i > 1)
        {
          localObject = d.a.a.hor;
          label48:
          this.hop = ((d.a.a)localObject);
          label53:
          switch (d.1.hon[this.hop.ordinal()])
          {
          default: 
            i = j;
            label90:
            nF(i);
            this.gUJ = SystemClock.elapsedRealtime();
            AppMethodBeat.o(10781);
            return;
            localObject = ((com.tencent.mm.plugin.appbrand.a.d)g.E(com.tencent.mm.plugin.appbrand.a.d.class)).we();
            String str1 = this.hoo.appId;
            i = this.hoo.cvs;
            String str2 = String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[] { "version", "AppBrandWxaPkgManifestRecord", "appId", "debugType" });
            localObject = ((ay)localObject).gWU.a(str2, new String[] { str1, String.valueOf(i) }, 2);
            if (localObject == null) {
              i = 0;
            } else {
              if (!((Cursor)localObject).moveToFirst()) {
                break label266;
              }
            }
            break;
          }
        }
      }
      label266:
      for (int i = ((Cursor)localObject).getInt(0);; i = 0)
      {
        ((Cursor)localObject).close();
        break;
        localObject = d.a.a.hoq;
        break label48;
        this.hop = d.a.a.hoq;
        break label53;
        i = 1;
        break label90;
        i = 10;
        break label90;
      }
    }
    
    public final void avi()
    {
      AppMethodBeat.i(10782);
      nF(32);
      AppMethodBeat.o(10782);
    }
    
    public final void avj()
    {
      AppMethodBeat.i(10783);
      nF(31);
      AppMethodBeat.o(10783);
    }
    
    public final void avk() {}
    
    public final void avl() {}
    
    public final void avm()
    {
      AppMethodBeat.i(10785);
      this.gUK = SystemClock.elapsedRealtime();
      switch (d.1.hon[this.hop.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(10785);
        return;
        nF(5);
        AppMethodBeat.o(10785);
        return;
        nF(14);
      }
    }
    
    public final void avn() {}
    
    public final void dG(boolean paramBoolean)
    {
      AppMethodBeat.i(10786);
      SystemClock.elapsedRealtime();
      int i;
      switch (d.1.hon[this.hop.ordinal()])
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        nF(i);
        avA();
        AppMethodBeat.o(10786);
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
    
    public final void dH(boolean paramBoolean) {}
    
    public final void nl(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.d
 * JD-Core Version:    0.7.0.1
 */