package com.tencent.mm.plugin.facedetect.ui;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class FaceDetectUI$b
{
  private boolean rtu = true;
  boolean rtv = false;
  private boolean rtw = true;
  private final boolean rtx = true;
  
  private FaceDetectUI$b(FaceDetectUI paramFaceDetectUI) {}
  
  public final void cvu()
  {
    try
    {
      this.rtv = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void cvv()
  {
    try
    {
      AppMethodBeat.i(103990);
      ae.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[] { toString() });
      if ((this.rtu) && (this.rtv) && (this.rtw)) {
        FaceDetectUI.m(this.rtn).setVisibility(0);
      }
      AppMethodBeat.o(103990);
      return;
    }
    finally {}
  }
  
  final void reset()
  {
    try
    {
      this.rtv = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103991);
    String str = "InitHandler{isCgiInitDone=" + this.rtu + ", isCameraInitDone=" + this.rtv + ", isLightInitDone=true, isLibraryInitDone=" + this.rtw + '}';
    AppMethodBeat.o(103991);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.b
 * JD-Core Version:    0.7.0.1
 */