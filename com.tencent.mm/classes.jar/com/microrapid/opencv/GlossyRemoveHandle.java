package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.MRect;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GlossyRemoveHandle
{
  private final long blO;
  private boolean blP;
  
  public GlossyRemoveHandle()
  {
    AppMethodBeat.i(86259);
    this.blP = false;
    this.blO = nativeHighLightRemoval();
    this.blP = true;
    AppMethodBeat.o(86259);
  }
  
  private static native void nativeDispose(long paramLong);
  
  private static native long nativeHighLightRemoval();
  
  private static native void nativeProcess(long paramLong, float paramFloat);
  
  private static native void nativeProcessNew(long paramLong, QImage paramQImage1, QImage paramQImage2, float paramFloat);
  
  private static native void nativeRest(long paramLong);
  
  private static native void nativeSetFaceInfo(long paramLong, MRect paramMRect1, MRect paramMRect2, MRect paramMRect3, MRect paramMRect4);
  
  private static native void nativeSetImage(long paramLong, QImage paramQImage);
  
  private static native void nativeSetNeedUpdate(long paramLong);
  
  private static native void nativeSetSkinYCbCrModel(long paramLong, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.microrapid.opencv.GlossyRemoveHandle
 * JD-Core Version:    0.7.0.1
 */