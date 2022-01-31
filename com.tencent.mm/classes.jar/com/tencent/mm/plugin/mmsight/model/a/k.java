package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.storage.ac.a;

public final class k
{
  private static k oJq;
  public SightParams oJr;
  
  static
  {
    AppMethodBeat.i(76593);
    oJq = new k();
    AppMethodBeat.o(76593);
  }
  
  public static k bRq()
  {
    return oJq;
  }
  
  public static int bRs()
  {
    return j.oHG.videoBitrate;
  }
  
  public static int bRt()
  {
    return j.oHG.eZQ;
  }
  
  public static String bRu()
  {
    switch (j.oHG.eqK)
    {
    default: 
      return "";
    case 2: 
      return "ENCODER_MEDIACODEC";
    }
    return "RECORDER_TYPE_FFMPEG";
  }
  
  public static boolean isDebug()
  {
    AppMethodBeat.i(76592);
    if (CaptureMMProxy.getInstance().getInt(ac.a.yDR, 0) == 1)
    {
      AppMethodBeat.o(76592);
      return true;
    }
    AppMethodBeat.o(76592);
    return false;
  }
  
  public static d q(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76591);
    Object localObject = null;
    switch (j.oHG.eqK)
    {
    default: 
      paramVideoTransPara = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(76591);
      return paramVideoTransPara;
      paramVideoTransPara = new n(paramVideoTransPara);
      continue;
      paramVideoTransPara = new l(paramVideoTransPara);
    }
  }
  
  public final SightParams bRr()
  {
    return this.oJr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.k
 * JD-Core Version:    0.7.0.1
 */