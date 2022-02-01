package com.tencent.h.a.a;

import android.content.Context;
import com.tencent.h.a.a.a.a;
import com.tencent.h.a.j;
import com.tencent.h.a.m;
import com.tencent.h.a.m.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public m ahWO;
  public com.tencent.h.a.a.b.b ahWP;
  public com.tencent.g.a.b ahWQ;
  public f ahWR;
  public com.tencent.h.a.d.b ahWS;
  public a ahWT;
  public Context mAppContext;
  
  public c(Context paramContext, m paramm)
  {
    AppMethodBeat.i(212102);
    Context localContext = paramContext;
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    this.mAppContext = localContext;
    this.ahWP = new com.tencent.h.a.a.b.b();
    this.ahWS = new com.tencent.h.a.d.b(this);
    this.ahWT = new a(this);
    this.ahWO = paramm;
    if (paramm == null)
    {
      paramContext = new m.a();
      paramContext.ahWJ = new j();
      this.ahWO = paramContext.kdb();
    }
    AppMethodBeat.o(212102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.a.c
 * JD-Core Version:    0.7.0.1
 */