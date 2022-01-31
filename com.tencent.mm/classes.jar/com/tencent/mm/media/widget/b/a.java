package com.tencent.mm.media.widget.b;

import a.f.b.j;
import a.l;
import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/recorder/AACMediaCodecBufIdRecorder;", "Lcom/tencent/mm/plugin/mmsight/model/encode/MMSightAACMediaCodecRecorder;", "sampleRate", "", "bitrate", "channelCount", "(III)V", "TAG", "", "bufId", "init", "bufferId", "tempPath", "isIgnoreCodecConfig", "", "processOutputBuffer", "", "outputBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "plugin-mediaeditor_release"})
@TargetApi(16)
public final class a
  extends h
{
  private final String TAG = "MicroMsg.MMSightAACMediaCodecBufIdRecorder";
  private int eRm = -1;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public final boolean Xp()
  {
    return true;
  }
  
  public final void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(13316);
    if ((this.eRm >= 0) && (paramByteBuffer != null) && (paramBufferInfo != null) && (!this.oJd))
    {
      ab.d(this.TAG, "writeAACData  ,bufferInfo.size : " + paramBufferInfo.size);
      SightVideoJNI.writeAACDataLock(this.eRm, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(13316);
  }
  
  public final int t(int paramInt, String paramString)
  {
    AppMethodBeat.i(13315);
    j.q(paramString, "tempPath");
    ab.d(this.TAG, "bufferId:" + paramInt + " ,tempPath:" + paramString);
    this.eRm = paramInt;
    paramInt = super.t(paramInt, paramString);
    AppMethodBeat.o(13315);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a
 * JD-Core Version:    0.7.0.1
 */