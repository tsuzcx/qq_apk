package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.storage.ac.a;

public final class k
{
  private static k mjj = new k();
  public SightParams mjk;
  
  public static k bjA()
  {
    return mjj;
  }
  
  public static int bjC()
  {
    return j.mhB.videoBitrate;
  }
  
  public static int bjD()
  {
    return j.mhB.mgf;
  }
  
  public static String bjE()
  {
    switch (j.mhB.dys)
    {
    default: 
      return "";
    case 2: 
      return "ENCODER_MEDIACODEC";
    }
    return "RECORDER_TYPE_FFMPEG";
  }
  
  public static d d(VideoTransPara paramVideoTransPara)
  {
    switch (j.mhB.dys)
    {
    default: 
      return null;
    case 2: 
      return new n(paramVideoTransPara);
    }
    return new l(paramVideoTransPara);
  }
  
  public static boolean isDebug()
  {
    return CaptureMMProxy.getInstance().getInt(ac.a.utO, 0) == 1;
  }
  
  public final SightParams bjB()
  {
    return this.mjk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.k
 * JD-Core Version:    0.7.0.1
 */