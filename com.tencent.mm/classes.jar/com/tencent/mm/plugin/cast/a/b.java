package com.tencent.mm.plugin.cast.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.b.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "()V", "audioConfig", "Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;", "getAudioConfig", "()Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;", "setAudioConfig", "(Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;)V", "canvasDirection", "", "getCanvasDirection", "()I", "setCanvasDirection", "(I)V", "ipAddress", "", "getIpAddress", "()Ljava/lang/String;", "setIpAddress", "(Ljava/lang/String;)V", "pcMacAddress", "getPcMacAddress", "setPcMacAddress", "phoneAddress", "getPhoneAddress", "setPhoneAddress", "port", "getPort", "()Ljava/lang/Integer;", "setPort", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "findDownFitVideoSolution", "", "setAudioChannelCntConfig", "cnt", "setAudioRecordAllow", "allow", "", "setAudioSampleRateConfig", "rate", "setVideoSize", "width", "height", "toString", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends d
{
  public int wMA;
  public String wMv;
  public Integer wMw;
  public a wMx;
  public String wMy;
  public String wMz;
  
  public b()
  {
    AppMethodBeat.i(274043);
    this.wMx = new a();
    AppMethodBeat.o(274043);
  }
  
  public final void setVideoSize(int paramInt1, int paramInt2)
  {
    this.nxP = (paramInt2 / 16 * 16);
    this.nxO = (paramInt1 / 16 * 16);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(274050);
    String str = "mVideoWidth:" + this.nxO + "  mVideoHeight : " + this.nxP + " mBitRate : " + this.bitrate + " , mFps : " + this.frameRate + ' ';
    AppMethodBeat.o(274050);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.a.b
 * JD-Core Version:    0.7.0.1
 */