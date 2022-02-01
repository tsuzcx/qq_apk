package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.bn;
import com.tencent.mm.f.a.bs;
import com.tencent.mm.f.a.dm;
import com.tencent.mm.f.a.do;
import com.tencent.mm.f.a.kz;
import com.tencent.mm.f.a.rl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.c.c;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public final class b
{
  public static o.a appForegroundListener;
  public final IListener checkLanguageChangeIListener;
  public a uCg;
  public com.tencent.mm.plugin.emoji.c.b uCh;
  public d uCi;
  public c uCj;
  public IListener uCk;
  public IListener uCl;
  public IListener uCm;
  public IListener uCn;
  public IListener uCo;
  public IListener uCp;
  public IListener uCq;
  public IListener uCr;
  public IListener uCs;
  
  static
  {
    AppMethodBeat.i(108411);
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(108403);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          if (!com.tencent.mm.kernel.b.aGE())
          {
            paramAnonymousString = new do();
            paramAnonymousString.fzf.state = 0;
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(108403);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(108402);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          if (!com.tencent.mm.kernel.b.aGE())
          {
            paramAnonymousString = new do();
            paramAnonymousString.fzf.state = 1;
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
    this.uCg = new a();
    this.uCh = new com.tencent.mm.plugin.emoji.c.b();
    this.uCi = new d();
    this.uCj = new c();
    this.uCk = new b.1(this);
    this.uCl = new b.4(this);
    this.uCm = new IListener() {};
    this.uCn = new b.7(this);
    this.uCo = new IListener() {};
    this.checkLanguageChangeIListener = new IListener() {};
    this.uCp = new IListener() {};
    this.uCq = new b.11(this);
    this.uCr = new IListener() {};
    this.uCs = new IListener() {};
    AppMethodBeat.o(108410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b
 * JD-Core Version:    0.7.0.1
 */