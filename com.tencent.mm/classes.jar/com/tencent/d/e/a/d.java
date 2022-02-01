package com.tencent.d.e.a;

import android.content.Context;
import com.tencent.d.e.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  long MMU;
  int Zpg;
  int action;
  Context context;
  long delayTime;
  int requestType;
  
  private d(a parama)
  {
    this.requestType = parama.requestType;
    this.Zpg = parama.Zpg;
    this.action = parama.action;
    this.MMU = parama.MMU;
    this.delayTime = parama.delayTime;
    this.context = parama.context;
  }
  
  public static final class a
  {
    public long MMU;
    int Zpg;
    int action;
    Context context;
    long delayTime;
    int requestType;
    
    private a(Context paramContext, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(138375);
      this.requestType = 0;
      this.Zpg = 0;
      this.action = 0;
      this.MMU = (f.Zpx * 12L);
      this.delayTime = 0L;
      if (paramInt1 < 0)
      {
        paramContext = new IllegalArgumentException("scenes invalid: ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(138375);
        throw paramContext;
      }
      this.context = paramContext.getApplicationContext();
      this.Zpg = paramInt1;
      this.action = paramInt2;
      AppMethodBeat.o(138375);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.d
 * JD-Core Version:    0.7.0.1
 */