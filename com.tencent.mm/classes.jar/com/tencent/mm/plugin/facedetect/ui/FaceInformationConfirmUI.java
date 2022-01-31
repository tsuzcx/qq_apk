package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class FaceInformationConfirmUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(505);
    super.onCreate(paramBundle);
    AppMethodBeat.o(505);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceInformationConfirmUI
 * JD-Core Version:    0.7.0.1
 */