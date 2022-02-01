package com.tencent.mm.plugin.emoji.e;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.dc.a;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class b
{
  public static n.a appForegroundListener;
  public final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  public com.tencent.mm.plugin.emoji.c.a ouW;
  public com.tencent.mm.plugin.emoji.c.b ouX;
  public d ouY;
  public com.tencent.mm.plugin.emoji.c.c ouZ;
  public com.tencent.mm.sdk.b.c ova;
  public com.tencent.mm.sdk.b.c ovb;
  public com.tencent.mm.sdk.b.c ovc;
  public com.tencent.mm.sdk.b.c ovd;
  public com.tencent.mm.sdk.b.c ove;
  public com.tencent.mm.sdk.b.c ovf;
  public com.tencent.mm.sdk.b.c ovg;
  public com.tencent.mm.sdk.b.c ovh;
  public com.tencent.mm.sdk.b.c ovi;
  
  static
  {
    AppMethodBeat.i(108411);
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(108403);
        if ((g.afw()) && (g.afz().gcn))
        {
          g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new db();
            paramAnonymousString.dfk.state = 0;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(108403);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(108402);
        if ((g.afw()) && (g.afz().gcn))
        {
          g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new db();
            paramAnonymousString.dfk.state = 1;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(108402);
      }
    };
    AppMethodBeat.o(108411);
  }
  
  public b()
  {
    AppMethodBeat.i(108410);
    this.ouW = new com.tencent.mm.plugin.emoji.c.a();
    this.ouX = new com.tencent.mm.plugin.emoji.c.b();
    this.ouY = new d();
    this.ouZ = new com.tencent.mm.plugin.emoji.c.c();
    this.ova = new b.1(this);
    this.ovb = new b.4(this);
    this.ovc = new com.tencent.mm.sdk.b.c() {};
    this.ovd = new b.7(this);
    this.ove = new com.tencent.mm.sdk.b.c() {};
    this.checkLanguageChangeIListener = new com.tencent.mm.sdk.b.c() {};
    this.ovf = new com.tencent.mm.sdk.b.c() {};
    this.ovg = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(dc paramAnonymousdc)
      {
        AppMethodBeat.i(108408);
        if ((paramAnonymousdc != null) && ((paramAnonymousdc instanceof dc)))
        {
          boolean bool = paramAnonymousdc.dfl.enable;
          g.afB().afk().set(ae.a.Fgx, Boolean.valueOf(bool));
          k.bVd().owh = bool;
          if (bool) {
            break label95;
          }
          h.vKh.f(12953, new Object[] { Integer.valueOf(2), "" });
          Toast.makeText(aj.getContext(), 2131758240, 0).show();
        }
        for (;;)
        {
          AppMethodBeat.o(108408);
          return false;
          label95:
          Toast.makeText(aj.getContext(), 2131758242, 0).show();
        }
      }
    };
    this.ovh = new com.tencent.mm.sdk.b.c() {};
    this.ovi = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(108410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b
 * JD-Core Version:    0.7.0.1
 */