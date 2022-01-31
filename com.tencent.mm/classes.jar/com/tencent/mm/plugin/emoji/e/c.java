package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.c.b;
import com.tencent.mm.plugin.emoji.c.d;

public final class c
{
  public static j.a appForegroundListener;
  public final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  public com.tencent.mm.sdk.b.c lfA;
  public a lfo;
  public b lfp;
  public d lfq;
  public com.tencent.mm.plugin.emoji.c.c lfr;
  public com.tencent.mm.sdk.b.c lfs;
  public com.tencent.mm.sdk.b.c lft;
  public com.tencent.mm.sdk.b.c lfu;
  public com.tencent.mm.sdk.b.c lfv;
  public com.tencent.mm.sdk.b.c lfw;
  public com.tencent.mm.sdk.b.c lfx;
  public com.tencent.mm.sdk.b.c lfy;
  public com.tencent.mm.sdk.b.c lfz;
  
  static
  {
    AppMethodBeat.i(139669);
    appForegroundListener = new c.6();
    AppMethodBeat.o(139669);
  }
  
  public c()
  {
    AppMethodBeat.i(52848);
    this.lfo = new a();
    this.lfp = new b();
    this.lfq = new d();
    this.lfr = new com.tencent.mm.plugin.emoji.c.c();
    this.lfs = new c.1(this);
    this.lft = new c.4(this);
    this.lfu = new c.5(this);
    this.lfv = new c.7(this);
    this.lfw = new c.8(this);
    this.checkLanguageChangeIListener = new c.9(this);
    this.lfx = new c.10(this);
    this.lfy = new c.11(this);
    this.lfz = new c.2(this);
    this.lfA = new c.3(this);
    AppMethodBeat.o(52848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c
 * JD-Core Version:    0.7.0.1
 */