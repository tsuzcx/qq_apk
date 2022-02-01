package com.tencent.maas.instamovie;

import com.tencent.maas.instamovie.mediafoundation.FrameRate;
import com.tencent.maas.instamovie.mediafoundation.a;
import com.tencent.maas.instamovie.mediafoundation.b;
import com.tencent.maas.instamovie.mediafoundation.c;
import com.tencent.maas.instamovie.mediafoundation.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class MJExportSettings
{
  private a audioCodecId;
  private int averageAudioBitRate;
  private FrameRate frameRate;
  private int maxKeyframeInterval;
  private c mediaContainerType;
  private Map<String, String> metadata;
  private int videoBitsPerFrame;
  private d videoCodecId;
  private b videoDimensionLevel;
  
  public MJExportSettings(FrameRate paramFrameRate, int paramInt1, int paramInt2, d paramd, a parama, c paramc, b paramb, int paramInt3)
  {
    this.frameRate = paramFrameRate;
    this.videoBitsPerFrame = paramInt1;
    this.averageAudioBitRate = paramInt2;
    this.videoCodecId = paramd;
    this.audioCodecId = parama;
    this.mediaContainerType = paramc;
    this.videoDimensionLevel = paramb;
    this.maxKeyframeInterval = paramInt3;
    this.metadata = null;
  }
  
  public MJExportSettings(FrameRate paramFrameRate, int paramInt1, int paramInt2, d paramd, a parama, c paramc, b paramb, int paramInt3, Map<String, String> paramMap)
  {
    this.frameRate = paramFrameRate;
    this.videoBitsPerFrame = paramInt1;
    this.averageAudioBitRate = paramInt2;
    this.videoCodecId = paramd;
    this.audioCodecId = parama;
    this.mediaContainerType = paramc;
    this.videoDimensionLevel = paramb;
    this.maxKeyframeInterval = paramInt3;
    this.metadata = paramMap;
  }
  
  public static MJExportSettings getDefault1080pSettings()
  {
    AppMethodBeat.i(216899);
    MJExportSettings localMJExportSettings = new MJExportSettings(FrameRate.FrameRate30, 300000, 128000, d.eGm, a.eFy, c.eGg, b.eGa, 30);
    AppMethodBeat.o(216899);
    return localMJExportSettings;
  }
  
  public int getAudioCodecID()
  {
    return this.audioCodecId.id;
  }
  
  public int getAverageAudioBitRate()
  {
    return this.averageAudioBitRate;
  }
  
  public FrameRate getFrameRate()
  {
    return this.frameRate;
  }
  
  public int getMaxKeyframeInterval()
  {
    return this.maxKeyframeInterval;
  }
  
  public int getMediaContainerType()
  {
    return this.mediaContainerType.type;
  }
  
  public Map<String, String> getMetadata()
  {
    return this.metadata;
  }
  
  public int getVideoBitsPerFrame()
  {
    return this.videoBitsPerFrame;
  }
  
  public int getVideoCodecID()
  {
    return this.videoCodecId.id;
  }
  
  public int getVideoDimensionLevel()
  {
    return this.videoDimensionLevel.id;
  }
  
  public void setAudioCodecId(a parama)
  {
    this.audioCodecId = parama;
  }
  
  public void setAverageAudioBitRate(int paramInt)
  {
    this.averageAudioBitRate = paramInt;
  }
  
  public void setFrameRate(FrameRate paramFrameRate)
  {
    this.frameRate = paramFrameRate;
  }
  
  public void setMaxKeyframeInterval(int paramInt)
  {
    this.maxKeyframeInterval = paramInt;
  }
  
  public void setMediaContainerType(c paramc)
  {
    this.mediaContainerType = paramc;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    this.metadata = paramMap;
  }
  
  public void setVideoBitsPerFrame(int paramInt)
  {
    this.videoBitsPerFrame = paramInt;
  }
  
  public void setVideoCodecId(d paramd)
  {
    this.videoCodecId = paramd;
  }
  
  public void setVideoDimensionLevel(b paramb)
  {
    this.videoDimensionLevel = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJExportSettings
 * JD-Core Version:    0.7.0.1
 */