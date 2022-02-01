package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Arrays;

public final class h
{
  public static h qxB;
  public int plF = 0;
  public int qxA = -1;
  public int[] qxz = null;
  
  public static h.a cnB()
  {
    AppMethodBeat.i(103743);
    int i = f.qxu.cnw();
    Object localObject = f.qxu.qxv.qzy;
    if (((g)localObject).qxy == null) {
      ac.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
    }
    for (localObject = null;; localObject = ((g)localObject).qxy.engineGetCurrMotionData())
    {
      localObject = new h.a(i, (String)localObject);
      AppMethodBeat.o(103743);
      return localObject;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103744);
    String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.qxz) + '}';
    AppMethodBeat.o(103744);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h
 * JD-Core Version:    0.7.0.1
 */