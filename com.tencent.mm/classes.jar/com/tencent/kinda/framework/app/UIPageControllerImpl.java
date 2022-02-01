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
    AppMethodBeat.i(18569);
    ActivityController.startNewUIPage(paramIUIPage, paramITransmitKvData);
    AppMethodBeat.o(18569);
  }
  
  public void startPageUI(IUIPage paramIUIPage, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18568);
    ActivityController.startNewUIPage(paramIUIPage, paramITransmitKvData);
    AppMethodBeat.o(18568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.UIPageControllerImpl
 * JD-Core Version:    0.7.0.1
 */