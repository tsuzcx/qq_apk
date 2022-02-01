package com.tencent.mm.plugin.emoji.e;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.dk.a;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.g.a.yx;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.c.c;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class b
{
  public static o.a appForegroundListener;
  public final IListener checkLanguageChangeIListener;
  public com.tencent.mm.plugin.emoji.c.a qZf;
  public com.tencent.mm.plugin.emoji.c.b qZg;
  public d qZh;
  public c qZi;
  public IListener qZj;
  public IListener qZk;
  public IListener qZl;
  public IListener qZm;
  public IListener qZn;
  public IListener qZo;
  public IListener qZp;
  public IListener qZq;
  public IListener qZr;
  
  static
  {
    AppMethodBeat.i(108411);
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(108403);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          if (!com.tencent.mm.kernel.a.azj())
          {
            paramAnonymousString = new dj();
            paramAnonymousString.dGu.state = 0;
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(108403);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(108402);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          if (!com.tencent.mm.kernel.a.azj())
          {
            paramAnonymousString = new dj();
            paramAnonymousString.dGu.state = 1;
            EventCenter.instance.publish(paramAnonymousString);
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
    this.qZf = new com.tencent.mm.plugin.emoji.c.a();
    this.qZg = new com.tencent.mm.plugin.emoji.c.b();
    this.qZh = new d();
    this.qZi = new c();
    this.qZj = new IListener() {};
    this.qZk = new b.4(this);
    this.qZl = new IListener() {};
    this.qZm = new IListener() {};
    this.qZn = new IListener() {};
    this.checkLanguageChangeIListener = new IListener() {};
    this.qZo = new IListener() {};
    this.qZp = new IListener()
    {
      private static boolean a(dk paramAnonymousdk)
      {
        AppMethodBeat.i(108408);
        if ((paramAnonymousdk != null) && ((paramAnonymousdk instanceof dk)))
        {
          boolean bool = paramAnonymousdk.dGv.enable;
          g.aAh().azQ().set(ar.a.NSY, Boolean.valueOf(bool));
          k.cGj().ray = bool;
          if (bool) {
            break label95;
          }
          h.CyF.a(12953, new Object[] { Integer.valueOf(2), "" });
          Toast.makeText(MMApplicationContext.getContext(), 2131758528, 0).show();
        }
        for (;;)
        {
          AppMethodBeat.o(108408);
          return false;
          label95:
          Toast.makeText(MMApplicationContext.getContext(), 2131758530, 0).show();
        }
      }
    };
    this.qZq = new IListener() {};
    this.qZr = new IListener() {};
    AppMethodBeat.o(108410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b
 * JD-Core Version:    0.7.0.1
 */