package com.tencent.e.e.a;

import android.content.Context;
import com.tencent.e.e.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  long Tzj;
  int action;
  int ahtO;
  Context context;
  long delayTime;
  int requestType;
  
  private d(a parama)
  {
    this.requestType = parama.requestType;
    this.ahtO = parama.ahtO;
    this.action = parama.action;
    this.Tzj = parama.Tzj;
    this.delayTime = parama.delayTime;
    this.context = parama.context;
  }
  
  public static final class a
  {
    public long Tzj;
    int action;
    int ahtO;
    Context context;
    long delayTime;
    int requestType;
    
    private a(Context paramContext, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(138375);
      this.requestType = 0;
      this.ahtO = 0;
      this.action = 0;
      this.Tzj = (f.ahuf * 12L);
      this.delayTime = 0L;
      if (paramInt1 < 0)
      {
        paramContext = new IllegalArgumentException("scenes invalid: ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(138375);
        throw paramContext;
      }
      this.context = paramContext.getApplicationContext();
      this.ahtO = paramInt1;
      this.action = paramInt2;
      AppMethodBeat.o(138375);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.d
 * JD-Core Version:    0.7.0.1
 */