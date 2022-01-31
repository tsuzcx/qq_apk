package com.tencent.mm.plugin.facedetect.ui;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectUI$b
{
  private boolean mmh = true;
  boolean mmi = false;
  private boolean mmj = true;
  private final boolean mmk = true;
  
  private FaceDetectUI$b(FaceDetectUI paramFaceDetectUI) {}
  
  public final void bvm()
  {
    try
    {
      this.mmi = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void bvn()
  {
    try
    {
      AppMethodBeat.i(471);
      ab.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[] { toString() });
      if ((this.mmh) && (this.mmi) && (this.mmj)) {
        FaceDetectUI.m(this.mmb).setVisibility(0);
      }
      AppMethodBeat.o(471);
      return;
    }
    finally {}
  }
  
  final void reset()
  {
    try
    {
      this.mmi = false;
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
    AppMethodBeat.i(472);
    String str = "InitHandler{isCgiInitDone=" + this.mmh + ", isCameraInitDone=" + this.mmi + ", isLightInitDone=true, isLibraryInitDone=" + this.mmj + '}';
    AppMethodBeat.o(472);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.b
 * JD-Core Version:    0.7.0.1
 */