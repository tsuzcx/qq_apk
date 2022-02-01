package com.tencent.mm.plugin.cast.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.b.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "()V", "audioConfig", "Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;", "getAudioConfig", "()Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;", "setAudioConfig", "(Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;)V", "canvasDirection", "", "getCanvasDirection", "()I", "setCanvasDirection", "(I)V", "ipAddress", "", "getIpAddress", "()Ljava/lang/String;", "setIpAddress", "(Ljava/lang/String;)V", "pcMacAddress", "getPcMacAddress", "setPcMacAddress", "phoneAddress", "getPhoneAddress", "setPhoneAddress", "port", "getPort", "()Ljava/lang/Integer;", "setPort", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "findDownFitVideoSolution", "", "setAudioChannelCntConfig", "cnt", "setAudioRecordAllow", "allow", "", "setAudioSampleRateConfig", "rate", "setVideoSize", "width", "height", "toString", "plugin-cast_release"})
public final class b
  extends d
{
  public String tIO;
  public Integer tIP;
  public a tIQ;
  public String tIR;
  public String tIS;
  public int tIT;
  
  public b()
  {
    AppMethodBeat.i(190593);
    this.tIQ = new a();
    AppMethodBeat.o(190593);
  }
  
  public final void setVideoSize(int paramInt1, int paramInt2)
  {
    this.targetHeight = (paramInt2 / 16 * 16);
    this.targetWidth = (paramInt1 / 16 * 16);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190590);
    String str = "mVideoWidth:" + this.targetWidth + ' ' + " mVideoHeight : " + this.targetHeight + ' ' + "mBitRate : " + this.bitrate + " , mFps : " + this.frameRate + ' ';
    AppMethodBeat.o(190590);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.b.b
 * JD-Core Version:    0.7.0.1
 */