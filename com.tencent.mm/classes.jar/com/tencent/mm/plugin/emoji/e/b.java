package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.c.d;

public final class b
{
  public static n.a appForegroundListener;
  public final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  public com.tencent.mm.sdk.b.c oYA;
  public com.tencent.mm.sdk.b.c oYB;
  public com.tencent.mm.sdk.b.c oYC;
  public com.tencent.mm.sdk.b.c oYD;
  public com.tencent.mm.sdk.b.c oYE;
  public com.tencent.mm.sdk.b.c oYF;
  public com.tencent.mm.sdk.b.c oYG;
  public com.tencent.mm.sdk.b.c oYH;
  public com.tencent.mm.sdk.b.c oYI;
  public a oYw;
  public com.tencent.mm.plugin.emoji.c.b oYx;
  public d oYy;
  public com.tencent.mm.plugin.emoji.c.c oYz;
  
  static
  {
    AppMethodBeat.i(108411);
    appForegroundListener = new b.6();
    AppMethodBeat.o(108411);
  }
  
  public b()
  {
    AppMethodBeat.i(108410);
    this.oYw = new a();
    this.oYx = new com.tencent.mm.plugin.emoji.c.b();
    this.oYy = new d();
    this.oYz = new com.tencent.mm.plugin.emoji.c.c();
    this.oYA = new b.1(this);
    this.oYB = new b.4(this);
    this.oYC = new b.5(this);
    this.oYD = new b.7(this);
    this.oYE = new com.tencent.mm.sdk.b.c() {};
    this.checkLanguageChangeIListener = new com.tencent.mm.sdk.b.c() {};
    this.oYF = new com.tencent.mm.sdk.b.c() {};
    this.oYG = new b.11(this);
    this.oYH = new com.tencent.mm.sdk.b.c() {};
    this.oYI = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(108410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b
 * JD-Core Version:    0.7.0.1
 */