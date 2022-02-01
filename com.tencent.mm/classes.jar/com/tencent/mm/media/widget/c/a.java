package com.tencent.mm.media.widget.c;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/recorder/AACMediaCodecBufIdRecorder;", "Lcom/tencent/mm/plugin/mmsight/model/encode/MMSightAACMediaCodecRecorder;", "sampleRate", "", "bitrate", "channelCount", "useFFMpegMuxer", "", "(IIIZ)V", "TAG", "", "bufIDs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addShareBufID", "", "bufID", "init", "bufferId", "tempPath", "isIgnoreCodecConfig", "processOutPutBuffer", "outputBuffer", "Ljava/nio/ByteBuffer;", "info", "Landroid/media/MediaCodec$BufferInfo;", "processOutputBufferWithADTS", "profile", "freqIdx", "chanCfg", "plugin-mediaeditor_release"})
@TargetApi(16)
public final class a
  extends h
{
  private final String TAG;
  private ArrayList<Integer> gCe;
  
  public a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, paramBoolean);
    AppMethodBeat.i(94371);
    this.TAG = "MicroMsg.MMSightAACMediaCodecBufIdRecorder";
    this.gCe = new ArrayList();
    AppMethodBeat.o(94371);
  }
  
  public final int D(int paramInt, String paramString)
  {
    AppMethodBeat.i(94367);
    k.h(paramString, "tempPath");
    ad.d(this.TAG, "bufferId:" + paramInt + " ,tempPath:" + paramString);
    this.gCe.clear();
    this.gCe.add(Integer.valueOf(paramInt));
    paramInt = super.D(paramInt, paramString);
    AppMethodBeat.o(94367);
    return paramInt;
  }
  
  public final void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94370);
    k.h(paramBufferInfo, "info");
    if ((this.gCe.size() >= 0) && (paramByteBuffer != null) && (!this.tEm))
    {
      ad.d(this.TAG, "writeAACDataWithADTSLock  ,bufferInfo.size : " + paramBufferInfo.size + ", pts: " + paramBufferInfo.presentationTimeUs);
      Iterator localIterator = ((Iterable)this.gCe).iterator();
      while (localIterator.hasNext()) {
        SightVideoJNI.writeAACDataWithADTSLock(((Number)localIterator.next()).intValue(), paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramInt1, paramInt2, paramInt3);
      }
    }
    AppMethodBeat.o(94370);
  }
  
  public final boolean aoi()
  {
    return true;
  }
  
  public final void h(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(94369);
    k.h(paramByteBuffer, "outputBuffer");
    k.h(paramBufferInfo, "info");
    if ((this.gCe.size() >= 0) && (!this.tEm))
    {
      Iterator localIterator = ((Iterable)this.gCe).iterator();
      while (localIterator.hasNext())
      {
        int i = ((Number)localIterator.next()).intValue();
        ad.d(this.TAG, "writeAACDataLock  ,bufferInfo.size : " + paramBufferInfo.size + ", pts: " + paramBufferInfo.presentationTimeUs);
        SightVideoJNI.writeAACDataLock(i, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
      }
    }
    AppMethodBeat.o(94369);
  }
  
  public final void mO(int paramInt)
  {
    AppMethodBeat.i(94368);
    this.gCe.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(94368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.a
 * JD-Core Version:    0.7.0.1
 */