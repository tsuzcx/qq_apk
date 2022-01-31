package com.tencent.mm.plugin.facedetect.ui;

import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectUI$b
{
  private boolean jRL = true;
  boolean jRM = false;
  private boolean jRN = true;
  private final boolean jRO = true;
  
  private FaceDetectUI$b(FaceDetectUI paramFaceDetectUI) {}
  
  public final void aPh()
  {
    try
    {
      this.jRM = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void aPi()
  {
    try
    {
      y.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[] { toString() });
      if ((this.jRL) && (this.jRM) && (this.jRN)) {
        FaceDetectUI.m(this.jRF).setVisibility(0);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void reset()
  {
    try
    {
      this.jRM = false;
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
    return "InitHandler{isCgiInitDone=" + this.jRL + ", isCameraInitDone=" + this.jRM + ", isLightInitDone=true, isLibraryInitDone=" + this.jRN + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.b
 * JD-Core Version:    0.7.0.1
 */