package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.storage.ar.a;

public final class l
{
  private static l zwj;
  public SightParams zwk;
  
  static
  {
    AppMethodBeat.i(89505);
    zwj = new l();
    AppMethodBeat.o(89505);
  }
  
  public static boolean KB()
  {
    AppMethodBeat.i(89504);
    if (CaptureMMProxy.getInstance().getInt(ar.a.NYY, 0) == 1)
    {
      AppMethodBeat.o(89504);
      return true;
    }
    AppMethodBeat.o(89504);
    return false;
  }
  
  public static l ekc()
  {
    return zwj;
  }
  
  public static int eke()
  {
    return k.zuy.videoBitrate;
  }
  
  public static int ekf()
  {
    return k.zuy.ilT;
  }
  
  public static String ekg()
  {
    switch (k.zuy.gIP)
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
    switch (k.zuy.gIP)
    {
    default: 
      paramVideoTransPara = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(89503);
      return paramVideoTransPara;
      paramVideoTransPara = new o(paramVideoTransPara);
      continue;
      paramVideoTransPara = new m(paramVideoTransPara);
    }
  }
  
  public final SightParams ekd()
  {
    return this.zwk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l
 * JD-Core Version:    0.7.0.1
 */