package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.c.d;

public final class b
{
  public static o.a appForegroundListener;
  public final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  public a pIK;
  public com.tencent.mm.plugin.emoji.c.b pIL;
  public d pIM;
  public com.tencent.mm.plugin.emoji.c.c pIN;
  public com.tencent.mm.sdk.b.c pIO;
  public com.tencent.mm.sdk.b.c pIP;
  public com.tencent.mm.sdk.b.c pIQ;
  public com.tencent.mm.sdk.b.c pIR;
  public com.tencent.mm.sdk.b.c pIS;
  public com.tencent.mm.sdk.b.c pIT;
  public com.tencent.mm.sdk.b.c pIU;
  public com.tencent.mm.sdk.b.c pIV;
  public com.tencent.mm.sdk.b.c pIW;
  
  static
  {
    AppMethodBeat.i(108411);
    appForegroundListener = new b.6();
    AppMethodBeat.o(108411);
  }
  
  public b()
  {
    AppMethodBeat.i(108410);
    this.pIK = new a();
    this.pIL = new com.tencent.mm.plugin.emoji.c.b();
    this.pIM = new d();
    this.pIN = new com.tencent.mm.plugin.emoji.c.c();
    this.pIO = new b.1(this);
    this.pIP = new b.4(this);
    this.pIQ = new b.5(this);
    this.pIR = new b.7(this);
    this.pIS = new com.tencent.mm.sdk.b.c() {};
    this.checkLanguageChangeIListener = new com.tencent.mm.sdk.b.c() {};
    this.pIT = new com.tencent.mm.sdk.b.c() {};
    this.pIU = new b.11(this);
    this.pIV = new b.2(this);
    this.pIW = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(108410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b
 * JD-Core Version:    0.7.0.1
 */