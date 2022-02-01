package com.tencent.mm.plugin.appbrand.keylogger.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract interface IKeyStepAnalyser
{
  public static abstract interface a
  {
    public abstract void bM(List<IKeyStepAnalyser.b> paramList);
  }
  
  public static final class b
  {
    public ArrayList<IKeyStepAnalyser.StepLogInfo> mPu;
    public StringBuilder mPv;
    
    public b()
    {
      AppMethodBeat.i(221320);
      this.mPu = new ArrayList();
      this.mPv = new StringBuilder();
      AppMethodBeat.o(221320);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser
 * JD-Core Version:    0.7.0.1
 */