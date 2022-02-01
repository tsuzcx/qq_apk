package com.tencent.mm.media.widget.c;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/recorder/AACMediaCodecBufIdRecorder;", "Lcom/tencent/mm/plugin/mmsight/model/encode/MMSightAACMediaCodecRecorder;", "sampleRate", "", "bitrate", "channelCount", "useFFMpegMuxer", "", "(IIIZ)V", "TAG", "", "bufIDs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addShareBufID", "", "bufID", "init", "bufferId", "tempPath", "isIgnoreCodecConfig", "processOutPutBuffer", "outputBuffer", "Ljava/nio/ByteBuffer;", "info", "Landroid/media/MediaCodec$BufferInfo;", "processOutputBufferWithADTS", "profile", "freqIdx", "chanCfg", "plugin-mediaeditor_release"})
@TargetApi(16)
public final class a
  extends h
{
  private final String TAG;
  private ArrayList<Integer> huK;
  
  public a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, null, paramBoolean);
    AppMethodBeat.i(94371);
    this.TAG = "MicroMsg.MMSightAACMediaCodecBufIdRecorder";
    this.huK = new ArrayList();
    AppMethodBeat.o(94371);
  }
  
  public final int E(int paramInt, String paramString)
  {
    AppMethodBeat.i(94367);
    p.h(paramString, "tempPath");
    ad.d(this.TAG, "bufferId:" + paramInt + " ,tempPath:" + paramString);
    this.huK.clear();
    this.huK.add(Integer.valueOf(paramInt));
    paramInt = super.E(paramInt, paramString);
    AppMethodBeat.o(94367);
    return paramInt;
  }
  
  public final void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94370);
    p.h(paramBufferInfo, "info");
    if ((this.huK.size() >= 0) && (paramByteBuffer != null) && (!this.vPO))
    {
      ad.d(this.TAG, "writeAACDataWithADTSLock  ,bufferInfo.size : " + paramBufferInfo.size + ", pts: " + paramBufferInfo.presentationTimeUs);
      Iterator localIterator = ((Iterable)this.huK).iterator();
      while (localIterator.hasNext()) {
        SightVideoJNI.writeAACDataWithADTSLock(((Number)localIterator.next()).intValue(), paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramInt1, paramInt2, paramInt3);
      }
    }
    AppMethodBeat.o(94370);
  }
  
  public final boolean axM()
  {
    return true;
  }
  
  public final void h(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(94369);
    p.h(paramByteBuffer, "outputBuffer");
    p.h(paramBufferInfo, "info");
    if ((this.huK.size() >= 0) && (!this.vPO))
    {
      Iterator localIterator = ((Iterable)this.huK).iterator();
      while (localIterator.hasNext())
      {
        int i = ((Number)localIterator.next()).intValue();
        ad.d(this.TAG, "writeAACDataLock  ,bufferInfo.size : " + paramBufferInfo.size + ", pts: " + paramBufferInfo.presentationTimeUs);
        SightVideoJNI.writeAACDataLock(i, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
      }
    }
    AppMethodBeat.o(94369);
  }
  
  public final void ob(int paramInt)
  {
    AppMethodBeat.i(94368);
    this.huK.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(94368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.a
 * JD-Core Version:    0.7.0.1
 */