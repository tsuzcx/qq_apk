package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;

public final class h
{
  public static h jNT;
  public int[] jNR = null;
  public int jNS = -1;
  public int jiU = 0;
  
  public static h.a aOx()
  {
    int i = f.jNM.aOt();
    Object localObject = f.jNM.jNN.jPP;
    if (((g)localObject).jNQ == null) {
      y.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
    }
    for (localObject = null;; localObject = ((g)localObject).jNQ.engineGetCurrMotionData()) {
      return new h.a(i, (String)localObject);
    }
  }
  
  public final String toString()
  {
    return "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.jNR) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h
 * JD-Core Version:    0.7.0.1
 */