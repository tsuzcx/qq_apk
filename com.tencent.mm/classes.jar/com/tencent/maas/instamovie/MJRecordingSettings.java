package com.tencent.maas.instamovie;

import com.tencent.maas.instamovie.mediafoundation.a;
import com.tencent.maas.instamovie.mediafoundation.b;
import com.tencent.maas.instamovie.mediafoundation.c;
import com.tencent.maas.instamovie.mediafoundation.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJRecordingSettings
{
  private a audioCodecId;
  private int averageAudioBitRate;
  private int maxKeyframeInterval;
  private c mediaContainerType;
  private int videoBitsPerFrame;
  private d videoCodecId;
  private b videoDimensionLevel;
  
  public MJRecordingSettings(d paramd, a parama, c paramc, b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    this.videoCodecId = paramd;
    this.audioCodecId = parama;
    this.mediaContainerType = paramc;
    this.videoDimensionLevel = paramb;
    this.videoBitsPerFrame = paramInt1;
    this.averageAudioBitRate = paramInt2;
    this.maxKeyframeInterval = paramInt3;
  }
  
  public static MJRecordingSettings getDefault1080pSettings()
  {
    AppMethodBeat.i(216895);
    MJRecordingSettings localMJRecordingSettings = new MJRecordingSettings(d.eGm, a.eFy, c.eGg, b.eGa, 300000, 128000, 30);
    AppMethodBeat.o(216895);
    return localMJRecordingSettings;
  }
  
  public int getAudioCodecID()
  {
    return this.audioCodecId.id;
  }
  
  public int getAverageAudioBitRate()
  {
    return this.averageAudioBitRate;
  }
  
  public int getMaxKeyframeInterval()
  {
    return this.maxKeyframeInterval;
  }
  
  public int getMediaContainerType()
  {
    return this.mediaContainerType.type;
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
  
  public void setMaxKeyframeInterval(int paramInt)
  {
    this.maxKeyframeInterval = paramInt;
  }
  
  public void setMediaContainerType(c paramc)
  {
    this.mediaContainerType = paramc;
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
 * Qualified Name:     com.tencent.maas.instamovie.MJRecordingSettings
 * JD-Core Version:    0.7.0.1
 */