package com.tencent.maas.camerafun;

import com.tencent.maas.model.time.MJTimeRange;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class MJAudioFrame
{
  private final ByteBuffer audioData;
  private final int channelCount;
  private final int sampleCountPerChannel;
  private final int sampleFormat;
  private final int sampleRate;
  private final MJTimeRange timeRange;
  
  public MJAudioFrame(MJAudioFrame.b paramb, int paramInt1, MJAudioFrame.a parama, int paramInt2, MJTimeRange paramMJTimeRange, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(216823);
    this.sampleFormat = MJAudioFrame.b.a(paramb);
    this.sampleRate = paramInt1;
    this.channelCount = MJAudioFrame.a.a(parama);
    this.sampleCountPerChannel = paramInt2;
    this.timeRange = paramMJTimeRange;
    this.audioData = paramByteBuffer;
    AppMethodBeat.o(216823);
  }
  
  public ByteBuffer getAudioData()
  {
    return this.audioData;
  }
  
  public int getChannelCount()
  {
    return this.channelCount;
  }
  
  public int getSampleCountPerChannel()
  {
    return this.sampleCountPerChannel;
  }
  
  public int getSampleFormat()
  {
    return this.sampleFormat;
  }
  
  public int getSampleRate()
  {
    return this.sampleRate;
  }
  
  public MJTimeRange getTimeRange()
  {
    return this.timeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJAudioFrame
 * JD-Core Version:    0.7.0.1
 */