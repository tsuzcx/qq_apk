package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.BindCardContext;
import com.tencent.kinda.gen.KAddPayCardService;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaAddPayCardServiceImpl
  implements KAddPayCardService
{
  public boolean clearBindCardProcess()
  {
    return false;
  }
  
  public BindCardContext enterBindCardProcess(int paramInt)
  {
    AppMethodBeat.i(18383);
    BindCardContext localBindCardContext = new BindCardContext();
    AppMethodBeat.o(18383);
    return localBindCardContext;
  }
  
  public String getBanBindCardTitle()
  {
    return "todo: @zhihongwang";
  }
  
  public boolean isBanBindCard()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaAddPayCardServiceImpl
 * JD-Core Version:    0.7.0.1
 */