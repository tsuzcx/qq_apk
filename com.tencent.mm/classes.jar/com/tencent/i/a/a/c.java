package com.tencent.i.a.a;

import android.content.Context;
import com.tencent.i.a.a.a.a;
import com.tencent.i.a.j;
import com.tencent.i.a.m;
import com.tencent.i.a.m.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public m SqN;
  public com.tencent.i.a.a.b.b SqO;
  public com.tencent.h.a.b SqP;
  public e SqQ;
  public com.tencent.i.a.d.b SqR;
  public a SqS;
  public Context mAppContext;
  
  public c(Context paramContext, m paramm)
  {
    AppMethodBeat.i(214683);
    Context localContext = paramContext;
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    this.mAppContext = localContext;
    this.SqO = new com.tencent.i.a.a.b.b();
    this.SqR = new com.tencent.i.a.d.b(this);
    this.SqS = new a(this);
    this.SqN = paramm;
    if (paramm == null)
    {
      paramContext = new m.a();
      paramContext.SqJ = new j();
      this.SqN = paramContext.hqb();
    }
    AppMethodBeat.o(214683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.a.c
 * JD-Core Version:    0.7.0.1
 */