package com.tencent.mm.ca.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.a.c;
import com.tencent.mm.videocomposition.b;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/remux/audio/AudioResampler;", "Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "destSampleRate", "", "destChannelCount", "(II)V", "TAG", "", "getDestChannelCount", "()I", "getDestSampleRate", "createResampleProcessor", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "plugin-remux_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  final String TAG;
  final int acld;
  final int acle;
  
  public a(int paramInt1, int paramInt2)
  {
    this.acld = paramInt1;
    this.acle = paramInt2;
    this.TAG = "MicroMsg.AudioResampler";
  }
  
  public final TAVAudioProcessorNode.TAVAudioProcessorEffect b(final b paramb)
  {
    AppMethodBeat.i(231817);
    s.u(paramb, "track");
    paramb = (TAVAudioProcessorNode.TAVAudioProcessorEffect)new a(this, paramb);
    AppMethodBeat.o(231817);
    return paramb;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/remux/audio/AudioResampler$createResampleProcessor$1", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "getByteBuffer", "()Ljava/nio/ByteBuffer;", "setByteBuffer", "(Ljava/nio/ByteBuffer;)V", "destAudio", "Lcom/tencent/tav/decoder/AudioInfo;", "getDestAudio", "()Lcom/tencent/tav/decoder/AudioInfo;", "processor", "Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;", "getProcessor", "()Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;", "setProcessor", "(Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;)V", "getDestAudioInfo", "processAudioPCM", "time", "Lcom/tencent/tav/coremedia/CMTime;", "pcmBuffer", "audioInfo", "release", "", "plugin-remux_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements TAVAudioProcessorNode.TAVAudioProcessorEffect
  {
    private g aclf;
    private final AudioInfo aclg;
    private ByteBuffer byteBuffer;
    private byte[] piN;
    
    a(a parama, b paramb)
    {
      AppMethodBeat.i(231814);
      this.piN = new byte[0];
      this.aclg = new AudioInfo();
      this.aclg.sampleRate = this.aclh.acld;
      this.aclg.channelCount = this.aclh.acle;
      this.aclg.pcmEncoding = 2;
      AppMethodBeat.o(231814);
    }
    
    public final AudioInfo getDestAudioInfo()
    {
      return this.aclg;
    }
    
    public final ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
    {
      AppMethodBeat.i(231818);
      s.u(paramCMTime, "time");
      s.u(paramByteBuffer, "pcmBuffer");
      s.u(paramAudioInfo, "audioInfo");
      if (this.aclf == null)
      {
        this.aclf = new g(paramb.path, paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding, this.aclg.sampleRate, this.aclg.channelCount, this.aclg.pcmEncoding);
        Log.i(this.aclh.TAG, "processAudioPCM, create convert processor, src:" + paramAudioInfo + ", dst:" + this.aclg);
      }
      if (this.piN.length != paramByteBuffer.limit()) {
        this.piN = new byte[paramByteBuffer.limit()];
      }
      paramByteBuffer.position(0);
      paramByteBuffer.get(this.piN);
      paramByteBuffer.position(0);
      paramCMTime = this.aclf;
      if (paramCMTime == null) {}
      for (paramCMTime = null; paramCMTime == null; paramCMTime = paramCMTime.ae(this.piN))
      {
        AppMethodBeat.o(231818);
        return paramByteBuffer;
      }
      paramByteBuffer = this.byteBuffer;
      if ((paramByteBuffer != null) && (paramByteBuffer.capacity() == paramCMTime.length)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramByteBuffer = ByteBuffer.allocateDirect(paramCMTime.length).order(ByteOrder.LITTLE_ENDIAN);
        paramByteBuffer.put(paramCMTime);
        this.byteBuffer = paramByteBuffer;
        paramCMTime = this.byteBuffer;
        if (paramCMTime != null) {
          paramCMTime.position(0);
        }
        s.s(paramByteBuffer, "newBuffer");
        AppMethodBeat.o(231818);
        return paramByteBuffer;
      }
      paramByteBuffer = this.byteBuffer;
      if (paramByteBuffer != null) {
        paramByteBuffer.position(0);
      }
      paramByteBuffer = this.byteBuffer;
      if (paramByteBuffer != null) {
        paramByteBuffer.put(paramCMTime);
      }
      paramCMTime = this.byteBuffer;
      if (paramCMTime != null) {
        paramCMTime.position(0);
      }
      paramCMTime = this.byteBuffer;
      s.checkNotNull(paramCMTime);
      AppMethodBeat.o(231818);
      return paramCMTime;
    }
    
    public final void release()
    {
      AppMethodBeat.i(231815);
      g localg = this.aclf;
      if (localg != null) {
        localg.release();
      }
      AppMethodBeat.o(231815);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ca.a.a
 * JD-Core Version:    0.7.0.1
 */