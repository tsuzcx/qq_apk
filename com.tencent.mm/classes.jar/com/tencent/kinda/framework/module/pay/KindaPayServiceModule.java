package com.tencent.kinda.framework.module.pay;

import com.tencent.kinda.framework.module.impl.TenpayCgiImpl;
import com.tencent.kinda.framework.widget.base.MMMoneyInputText;
import com.tencent.kinda.modularize.KindaModule;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaPayServiceModule
  extends KindaModule
{
  public void configModule()
  {
    AppMethodBeat.i(144594);
    registerView("kMoneyInputText", MMMoneyInputText.class);
    registerNativeModule("TenpayCgi", TenpayCgiImpl.class);
    AppMethodBeat.o(144594);
  }
  
  public void onAppCreate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.pay.KindaPayServiceModule
 * JD-Core Version:    0.7.0.1
 */