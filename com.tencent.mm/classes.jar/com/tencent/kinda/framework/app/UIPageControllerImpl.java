package com.tencent.kinda.framework.app;

import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.IUIPage;
import com.tencent.kinda.gen.IUIPageController;
import com.tencent.kinda.gen.TransitionStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UIPageControllerImpl
  implements IUIPageController
{
  private static String TAG = "kinda UIPageControllerImpl";
  
  public void startModalPageUI(IUIPage paramIUIPage, TransitionStyle paramTransitionStyle, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(144461);
    ActivityController.startNewUIPage(paramIUIPage);
    AppMethodBeat.o(144461);
  }
  
  public void startPageUI(IUIPage paramIUIPage, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(144460);
    ActivityController.startNewUIPage(paramIUIPage);
    AppMethodBeat.o(144460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.app.UIPageControllerImpl
 * JD-Core Version:    0.7.0.1
 */