package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.storage.am.a;

public final class l
{
  private static l wch;
  public SightParams wci;
  
  static
  {
    AppMethodBeat.i(89505);
    wch = new l();
    AppMethodBeat.o(89505);
  }
  
  public static boolean cLB()
  {
    AppMethodBeat.i(89504);
    if (CaptureMMProxy.getInstance().getInt(am.a.IQW, 0) == 1)
    {
      AppMethodBeat.o(89504);
      return true;
    }
    AppMethodBeat.o(89504);
    return false;
  }
  
  public static l dqm()
  {
    return wch;
  }
  
  public static int dqo()
  {
    return k.wat.videoBitrate;
  }
  
  public static int dqp()
  {
    return k.wat.hrX;
  }
  
  public static String dqq()
  {
    switch (k.wat.gdr)
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
    switch (k.wat.gdr)
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
  
  public final SightParams dqn()
  {
    return this.wci;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l
 * JD-Core Version:    0.7.0.1
 */