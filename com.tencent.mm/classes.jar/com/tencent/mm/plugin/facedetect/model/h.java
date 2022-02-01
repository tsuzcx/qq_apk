package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Arrays;

public final class h
{
  public static h pOT;
  public int oIf = 0;
  public int[] pOR = null;
  public int pOS = -1;
  
  public static h.a cfU()
  {
    AppMethodBeat.i(103743);
    int i = f.pOM.cfP();
    Object localObject = f.pOM.pON.pQQ;
    if (((g)localObject).pOQ == null) {
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
    }
    for (localObject = null;; localObject = ((g)localObject).pOQ.engineGetCurrMotionData())
    {
      localObject = new h.a(i, (String)localObject);
      AppMethodBeat.o(103743);
      return localObject;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103744);
    String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.pOR) + '}';
    AppMethodBeat.o(103744);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h
 * JD-Core Version:    0.7.0.1
 */