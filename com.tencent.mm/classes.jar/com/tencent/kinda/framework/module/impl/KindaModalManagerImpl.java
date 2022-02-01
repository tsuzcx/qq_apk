package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.KindaModalManager;
import com.tencent.kinda.gen.Platform;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class KindaModalManagerImpl
  implements KindaModalManager
{
  public static final String TAG = "MicroMsg.KindaModalManagerImpl";
  
  public void addModalView(IUIModal paramIUIModal)
  {
    AppMethodBeat.i(18642);
    ac.i("MicroMsg.KindaModalManagerImpl", "kinda call addModalView, modal: ".concat(String.valueOf(paramIUIModal)));
    ActivityController.startNewUIModal(paramIUIModal);
    AppMethodBeat.o(18642);
  }
  
  public IUIPagePlatformDelegate getPlatformDelegate()
  {
    AppMethodBeat.i(18644);
    IUIPagePlatformDelegate local1 = new IUIPagePlatformDelegate()
    {
      public Platform currentPlatform()
      {
        return Platform.ANDROID;
      }
    };
    AppMethodBeat.o(18644);
    return local1;
  }
  
  public void removeAllModalViews()
  {
    AppMethodBeat.i(185697);
    ActivityController.removeAll();
    AppMethodBeat.o(185697);
  }
  
  public void removeModalView(IUIModal paramIUIModal)
  {
    AppMethodBeat.i(18643);
    ac.i("MicroMsg.KindaModalManagerImpl", "kinda call reremoveModalView, modal: ".concat(String.valueOf(paramIUIModal)));
    ActivityController.remove(paramIUIModal);
    AppMethodBeat.o(18643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaModalManagerImpl
 * JD-Core Version:    0.7.0.1
 */