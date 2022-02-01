package com.tencent.d.e.a;

import android.content.Context;
import com.tencent.d.e.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  long BFC;
  int LNa;
  long Lgo;
  int action;
  Context context;
  int requestType;
  
  private d(a parama)
  {
    this.requestType = parama.requestType;
    this.LNa = parama.LNa;
    this.action = parama.action;
    this.BFC = parama.BFC;
    this.Lgo = parama.Lgo;
    this.context = parama.context;
  }
  
  public static final class a
  {
    public long BFC;
    int LNa;
    long Lgo;
    int action;
    Context context;
    int requestType;
    
    private a(Context paramContext, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(138375);
      this.requestType = 0;
      this.LNa = 0;
      this.action = 0;
      this.BFC = (f.LNs * 12L);
      this.Lgo = 0L;
      if (paramInt1 < 0)
      {
        paramContext = new IllegalArgumentException("scenes invalid: ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(138375);
        throw paramContext;
      }
      this.context = paramContext.getApplicationContext();
      this.LNa = paramInt1;
      this.action = paramInt2;
      AppMethodBeat.o(138375);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.d
 * JD-Core Version:    0.7.0.1
 */