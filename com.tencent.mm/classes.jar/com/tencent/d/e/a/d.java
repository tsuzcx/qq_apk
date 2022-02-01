package com.tencent.d.e.a;

import android.content.Context;
import com.tencent.d.e.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  long BXa;
  long LCQ;
  int MjZ;
  int action;
  Context context;
  int requestType;
  
  private d(a parama)
  {
    this.requestType = parama.requestType;
    this.MjZ = parama.MjZ;
    this.action = parama.action;
    this.BXa = parama.BXa;
    this.LCQ = parama.LCQ;
    this.context = parama.context;
  }
  
  public static final class a
  {
    public long BXa;
    long LCQ;
    int MjZ;
    int action;
    Context context;
    int requestType;
    
    private a(Context paramContext, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(138375);
      this.requestType = 0;
      this.MjZ = 0;
      this.action = 0;
      this.BXa = (f.Mkr * 12L);
      this.LCQ = 0L;
      if (paramInt1 < 0)
      {
        paramContext = new IllegalArgumentException("scenes invalid: ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(138375);
        throw paramContext;
      }
      this.context = paramContext.getApplicationContext();
      this.MjZ = paramInt1;
      this.action = paramInt2;
      AppMethodBeat.o(138375);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.d
 * JD-Core Version:    0.7.0.1
 */