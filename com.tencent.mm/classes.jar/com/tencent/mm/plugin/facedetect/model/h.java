package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Arrays;

public final class h
{
  public static h rpv;
  public int pVK = 0;
  public int[] rpt = null;
  public int rpu = -1;
  
  public static h.a cuH()
  {
    AppMethodBeat.i(103743);
    int i = f.rpo.cuC();
    Object localObject = f.rpo.rpp.rrr;
    if (((g)localObject).rps == null) {
      ae.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
    }
    for (localObject = null;; localObject = ((g)localObject).rps.engineGetCurrMotionData())
    {
      localObject = new h.a(i, (String)localObject);
      AppMethodBeat.o(103743);
      return localObject;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103744);
    String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.rpt) + '}';
    AppMethodBeat.o(103744);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h
 * JD-Core Version:    0.7.0.1
 */