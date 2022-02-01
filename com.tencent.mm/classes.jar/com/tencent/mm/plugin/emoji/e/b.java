package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.js;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.lr.a;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class b
{
  public static n.a appForegroundListener;
  public final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  public com.tencent.mm.plugin.emoji.c.a pCg;
  public com.tencent.mm.plugin.emoji.c.b pCh;
  public d pCi;
  public com.tencent.mm.plugin.emoji.c.c pCj;
  public com.tencent.mm.sdk.b.c pCk;
  public com.tencent.mm.sdk.b.c pCl;
  public com.tencent.mm.sdk.b.c pCm;
  public com.tencent.mm.sdk.b.c pCn;
  public com.tencent.mm.sdk.b.c pCo;
  public com.tencent.mm.sdk.b.c pCp;
  public com.tencent.mm.sdk.b.c pCq;
  public com.tencent.mm.sdk.b.c pCr;
  public com.tencent.mm.sdk.b.c pCs;
  
  static
  {
    AppMethodBeat.i(108411);
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(108403);
        if ((g.ajx()) && (g.ajA().gAD))
        {
          g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            paramAnonymousString = new df();
            paramAnonymousString.dob.state = 0;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(108403);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(108402);
        if ((g.ajx()) && (g.ajA().gAD))
        {
          g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            paramAnonymousString = new df();
            paramAnonymousString.dob.state = 1;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
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
    this.pCg = new com.tencent.mm.plugin.emoji.c.a();
    this.pCh = new com.tencent.mm.plugin.emoji.c.b();
    this.pCi = new d();
    this.pCj = new com.tencent.mm.plugin.emoji.c.c();
    this.pCk = new b.1(this);
    this.pCl = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(lr paramAnonymouslr)
      {
        AppMethodBeat.i(108399);
        if ((paramAnonymouslr != null) && ((paramAnonymouslr instanceof lr)))
        {
          ad.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
          if (paramAnonymouslr.dyQ.result)
          {
            g.ajC().ajl().set(al.a.Iqv, Boolean.TRUE);
            g.ajC().ajl().set(al.a.Iqw, Boolean.TRUE);
          }
        }
        AppMethodBeat.o(108399);
        return false;
      }
    };
    this.pCm = new com.tencent.mm.sdk.b.c() {};
    this.pCn = new b.7(this);
    this.pCo = new com.tencent.mm.sdk.b.c() {};
    this.checkLanguageChangeIListener = new com.tencent.mm.sdk.b.c() {};
    this.pCp = new com.tencent.mm.sdk.b.c() {};
    this.pCq = new b.11(this);
    this.pCr = new com.tencent.mm.sdk.b.c() {};
    this.pCs = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(108410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b
 * JD-Core Version:    0.7.0.1
 */