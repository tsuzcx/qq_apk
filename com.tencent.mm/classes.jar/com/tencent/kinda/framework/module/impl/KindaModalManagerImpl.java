package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.KindaModalManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaModalManagerImpl
  implements KindaModalManager
{
  public static final String TAG = "MicroMsg.KindaModalManagerImpl";
  
  public void addModalView(IUIModal paramIUIModal)
  {
    AppMethodBeat.i(144528);
    ActivityController.startNewUIModal(paramIUIModal);
    AppMethodBeat.o(144528);
  }
  
  public IUIPagePlatformDelegate getPlatformDelegate()
  {
    AppMethodBeat.i(144530);
    KindaModalManagerImpl.1 local1 = new KindaModalManagerImpl.1(this);
    AppMethodBeat.o(144530);
    return local1;
  }
  
  public void removeAllModalViews() {}
  
  public void removeModalView(IUIModal paramIUIModal)
  {
    AppMethodBeat.i(144529);
    ActivityController.remove(paramIUIModal);
    AppMethodBeat.o(144529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaModalManagerImpl
 * JD-Core Version:    0.7.0.1
 */