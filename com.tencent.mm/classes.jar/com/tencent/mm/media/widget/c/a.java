package com.tencent.mm.media.widget.c;

import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/recorder/AACMediaCodecBufIdRecorder;", "Lcom/tencent/mm/plugin/mmsight/model/encode/MMSightAACMediaCodecRecorder;", "sampleRate", "", "bitrate", "channelCount", "useFFMpegMuxer", "", "(IIIZ)V", "TAG", "", "bufIDs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addShareBufID", "", "bufID", "init", "bufferId", "tempPath", "isIgnoreCodecConfig", "processOutPutBuffer", "outputBuffer", "Ljava/nio/ByteBuffer;", "info", "Landroid/media/MediaCodec$BufferInfo;", "processOutputBufferWithADTS", "profile", "freqIdx", "chanCfg", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends h
{
  private final String TAG;
  private ArrayList<Integer> nLk;
  
  public a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, paramBoolean);
    AppMethodBeat.i(94371);
    this.TAG = "MicroMsg.MMSightAACMediaCodecBufIdRecorder";
    this.nLk = new ArrayList();
    AppMethodBeat.o(94371);
  }
  
  public final int L(int paramInt, String paramString)
  {
    AppMethodBeat.i(94367);
    s.u(paramString, "tempPath");
    Log.d(this.TAG, "bufferId:" + paramInt + " ,tempPath:" + paramString);
    this.nLk.clear();
    this.nLk.add(Integer.valueOf(paramInt));
    paramInt = super.L(paramInt, paramString);
    AppMethodBeat.o(94367);
    return paramInt;
  }
  
  public final void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94370);
    s.u(paramBufferInfo, "info");
    if ((this.nLk.size() >= 0) && (paramByteBuffer != null) && (!this.KXb))
    {
      Log.d(this.TAG, "writeAACDataWithADTSLock  ,bufferInfo.size : " + paramBufferInfo.size + ", pts: " + paramBufferInfo.presentationTimeUs);
      Iterator localIterator = ((Iterable)this.nLk).iterator();
      while (localIterator.hasNext()) {
        SightVideoJNI.writeAACDataWithADTSLock(((Number)localIterator.next()).intValue(), paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramInt1, paramInt2, paramInt3);
      }
    }
    AppMethodBeat.o(94370);
  }
  
  public final boolean boY()
  {
    return true;
  }
  
  public final void h(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(94369);
    s.u(paramByteBuffer, "outputBuffer");
    s.u(paramBufferInfo, "info");
    if ((this.nLk.size() >= 0) && (!this.KXb))
    {
      Iterator localIterator = ((Iterable)this.nLk).iterator();
      while (localIterator.hasNext())
      {
        int i = ((Number)localIterator.next()).intValue();
        Log.d(this.TAG, "writeAACDataLock  ,bufferInfo.size : " + paramBufferInfo.size + ", pts: " + paramBufferInfo.presentationTimeUs);
        SightVideoJNI.writeAACDataLock(i, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
      }
    }
    AppMethodBeat.o(94369);
  }
  
  public final void uu(int paramInt)
  {
    AppMethodBeat.i(94368);
    this.nLk.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(94368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.a
 * JD-Core Version:    0.7.0.1
 */