package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.storage.ae.a;

public final class k
{
  private static k tEB;
  public SightParams tEC;
  
  static
  {
    AppMethodBeat.i(89505);
    tEB = new k();
    AppMethodBeat.o(89505);
  }
  
  public static k cQk()
  {
    return tEB;
  }
  
  public static int cQm()
  {
    return com.tencent.mm.plugin.mmsight.model.k.tCN.videoBitrate;
  }
  
  public static int cQn()
  {
    return com.tencent.mm.plugin.mmsight.model.k.tCN.gwG;
  }
  
  public static boolean cQo()
  {
    AppMethodBeat.i(89504);
    if (CaptureMMProxy.getInstance().getInt(ae.a.Fmr, 0) == 1)
    {
      AppMethodBeat.o(89504);
      return true;
    }
    AppMethodBeat.o(89504);
    return false;
  }
  
  public static String cQp()
  {
    switch (com.tencent.mm.plugin.mmsight.model.k.tCN.fEc)
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
    switch (com.tencent.mm.plugin.mmsight.model.k.tCN.fEc)
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
  
  public final SightParams cQl()
  {
    return this.tEC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.k
 * JD-Core Version:    0.7.0.1
 */