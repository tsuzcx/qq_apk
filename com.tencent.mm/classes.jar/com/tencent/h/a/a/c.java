package com.tencent.h.a.a;

import android.content.Context;
import com.tencent.h.a.a.a.a;
import com.tencent.h.a.j;
import com.tencent.h.a.m;
import com.tencent.h.a.m.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public m ZSq;
  public com.tencent.h.a.a.b.b ZSr;
  public com.tencent.g.a.b ZSs;
  public e ZSt;
  public com.tencent.h.a.d.b ZSu;
  public a ZSv;
  public Context mAppContext;
  
  public c(Context paramContext, m paramm)
  {
    AppMethodBeat.i(207594);
    Context localContext = paramContext;
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    this.mAppContext = localContext;
    this.ZSr = new com.tencent.h.a.a.b.b();
    this.ZSu = new com.tencent.h.a.d.b(this);
    this.ZSv = new a(this);
    this.ZSq = paramm;
    if (paramm == null)
    {
      paramContext = new m.a();
      paramContext.ZSm = new j();
      this.ZSq = paramContext.itG();
    }
    AppMethodBeat.o(207594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.a.c
 * JD-Core Version:    0.7.0.1
 */