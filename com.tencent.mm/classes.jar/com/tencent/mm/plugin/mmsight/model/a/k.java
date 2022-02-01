package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.storage.ah.a;

public final class k
{
  private static k uMW;
  public SightParams uMX;
  
  static
  {
    AppMethodBeat.i(89505);
    uMW = new k();
    AppMethodBeat.o(89505);
  }
  
  public static k ddS()
  {
    return uMW;
  }
  
  public static int ddU()
  {
    return com.tencent.mm.plugin.mmsight.model.k.uLk.videoBitrate;
  }
  
  public static int ddV()
  {
    return com.tencent.mm.plugin.mmsight.model.k.uLk.gXd;
  }
  
  public static boolean ddW()
  {
    AppMethodBeat.i(89504);
    if (CaptureMMProxy.getInstance().getInt(ah.a.GKg, 0) == 1)
    {
      AppMethodBeat.o(89504);
      return true;
    }
    AppMethodBeat.o(89504);
    return false;
  }
  
  public static String ddX()
  {
    switch (com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ)
    {
    default: 
      return "";
    case 2: 
      return "ENCODER_MEDIACODEC";
    }
    return "RECORDER_TYPE_FFMPEG";
  }
  
  public static d q(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89503);
    Object localObject = null;
    switch (com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ)
    {
    default: 
      paramVideoTransPara = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(89503);
      return paramVideoTransPara;
      paramVideoTransPara = new n(paramVideoTransPara);
      continue;
      paramVideoTransPara = new l(paramVideoTransPara);
    }
  }
  
  public final SightParams ddT()
  {
    return this.uMX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.k
 * JD-Core Version:    0.7.0.1
 */