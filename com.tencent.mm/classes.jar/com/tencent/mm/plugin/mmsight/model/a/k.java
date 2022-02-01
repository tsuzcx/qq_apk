package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.storage.ar.a;

public final class k
{
  private static k FbI;
  public SightParams FbJ;
  
  static
  {
    AppMethodBeat.i(89505);
    FbI = new k();
    AppMethodBeat.o(89505);
  }
  
  public static boolean No()
  {
    AppMethodBeat.i(89504);
    if (CaptureMMProxy.getInstance().getInt(ar.a.VmY, 0) == 1)
    {
      AppMethodBeat.o(89504);
      return true;
    }
    AppMethodBeat.o(89504);
    return false;
  }
  
  public static k eTI()
  {
    return FbI;
  }
  
  public static int eTK()
  {
    return j.EZX.videoBitrate;
  }
  
  public static int eTL()
  {
    return j.EZX.laT;
  }
  
  public static String eTM()
  {
    switch (j.EZX.jth)
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
    switch (j.EZX.jth)
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
  
  public final SightParams eTJ()
  {
    return this.FbJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.k
 * JD-Core Version:    0.7.0.1
 */