package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;

public final class h
{
  public static h mif;
  public int lrL = 0;
  public int[] mid = null;
  public int mie = -1;
  
  public static h.a buA()
  {
    AppMethodBeat.i(218);
    int i = f.mhY.buv();
    Object localObject = f.mhY.mhZ.mkf;
    if (((g)localObject).mic == null) {
      ab.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
    }
    for (localObject = null;; localObject = ((g)localObject).mic.engineGetCurrMotionData())
    {
      localObject = new h.a(i, (String)localObject);
      AppMethodBeat.o(218);
      return localObject;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(219);
    String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.mid) + '}';
    AppMethodBeat.o(219);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h
 * JD-Core Version:    0.7.0.1
 */