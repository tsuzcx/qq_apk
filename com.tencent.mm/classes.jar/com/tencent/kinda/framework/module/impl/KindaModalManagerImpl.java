package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.KindaModalManager;
import com.tencent.kinda.gen.Platform;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class KindaModalManagerImpl
  implements KindaModalManager
{
  public static final String TAG = "MicroMsg.KindaModalManagerImpl";
  
  public void addModalView(IUIModal paramIUIModal)
  {
    AppMethodBeat.i(18642);
    Log.i("MicroMsg.KindaModalManagerImpl", "kinda call addModalView, modal: %s, %s", new Object[] { paramIUIModal.getReportUrl(), Integer.valueOf(paramIUIModal.hashCode()) });
    ActivityController.startNewUIModal(paramIUIModal);
    AppMethodBeat.o(18642);
  }
  
  public IUIPagePlatformDelegate getPlatformDelegate()
  {
    AppMethodBeat.i(18644);
    IUIPagePlatformDelegate local2 = new IUIPagePlatformDelegate()
    {
      public Platform currentPlatform()
      {
        return Platform.ANDROID;
      }
    };
    AppMethodBeat.o(18644);
    return local2;
  }
  
  public void removeAllModalViews()
  {
    AppMethodBeat.i(185697);
    ActivityController.removeAll();
    AppMethodBeat.o(185697);
  }
  
  public void removeModalViewImpl(IUIModal paramIUIModal, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(226664);
    Log.i("MicroMsg.KindaModalManagerImpl", "kinda call reremoveModalView, modal: %s, %s", new Object[] { paramIUIModal.getReportUrl(), Integer.valueOf(paramIUIModal.hashCode()) });
    ActivityController.remove(paramIUIModal);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(226668);
        paramVoidCallback.call();
        AppMethodBeat.o(226668);
      }
    });
    AppMethodBeat.o(226664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaModalManagerImpl
 * JD-Core Version:    0.7.0.1
 */