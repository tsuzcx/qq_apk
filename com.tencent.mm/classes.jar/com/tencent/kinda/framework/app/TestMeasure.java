package com.tencent.kinda.framework.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TestMeasure
{
  public static final String TAG = "TestMeasure";
  public long valLayout = 0L;
  public long valMeasure = 0L;
  
  public void reset()
  {
    this.valMeasure = 0L;
    this.valLayout = 0L;
  }
  
  public String result()
  {
    AppMethodBeat.i(18567);
    String str = String.format("result valMeasure:%s valLayout:%s total:%s", new Object[] { Long.valueOf(this.valMeasure), Long.valueOf(this.valLayout), Long.valueOf(this.valLayout + this.valMeasure) });
    AppMethodBeat.o(18567);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.TestMeasure
 * JD-Core Version:    0.7.0.1
 */