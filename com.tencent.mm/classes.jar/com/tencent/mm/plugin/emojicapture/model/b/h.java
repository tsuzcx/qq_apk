package com.tencent.mm.plugin.emojicapture.model.b;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoder;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;Landroid/view/Surface;)V", "TAG", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "waitInputQueueMaxCount", "", "waitInputQueueTimeout", "", "waitOutputQueueTimeout", "drainDecoder", "", "init", "inputDecoder", "processDecodeBuffer", "", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "startDecodeImpl", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends k
{
  final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  private String cBw;
  private MediaFormat mediaFormat;
  aa nyz;
  c pcp;
  private final Surface surface;
  private final String videoPath;
  final long yih;
  private final long yii;
  final int yij;
  private final Object yik;
  
  public h(String paramString, Surface paramSurface)
  {
    AppMethodBeat.i(288);
    this.videoPath = paramString;
    this.surface = paramSurface;
    this.TAG = "MicroMsg.MixVideoDecoder";
    this.pcp = new c();
    this.cBw = "";
    this.yih = 60000L;
    this.yii = 10000L;
    this.yij = 10;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.yik = new Object();
    for (;;)
    {
      int j;
      try
      {
        Log.i(this.TAG, s.X("create decoder with path: ", this.videoPath));
        this.pcp.setDataSource(this.videoPath);
        int k = this.pcp.lZm.getTrackCount();
        if (k > 0)
        {
          i = 0;
          j = i + 1;
          paramString = this.pcp.getTrackFormat(i);
          s.s(paramString, "extractor.getTrackFormat(i)");
          paramSurface = paramString.getString("mime");
          s.checkNotNull(paramSurface);
          s.s(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)!!");
          if (n.i((CharSequence)paramSurface, (CharSequence)"video") == true)
          {
            paramSurface = paramString.getString("mime");
            s.checkNotNull(paramSurface);
            s.s(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)!!");
            this.cBw = paramSurface;
            this.mediaFormat = paramString;
            String str = this.TAG;
            StringBuilder localStringBuilder = new StringBuilder("find video format ");
            paramSurface = this.mediaFormat;
            paramString = paramSurface;
            if (paramSurface == null)
            {
              s.bIx("mediaFormat");
              paramString = null;
            }
            Log.i(str, paramString + ", mime: " + this.cBw);
            this.pcp.selectTrack(i);
            AppMethodBeat.o(288);
            return;
          }
          if (j < k) {
            break label338;
          }
          AppMethodBeat.o(288);
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
        AppMethodBeat.o(288);
        return;
      }
      label338:
      int i = j;
    }
  }
  
  final boolean boW()
  {
    Object localObject5 = null;
    String str = null;
    Object localObject4 = null;
    AppMethodBeat.i(286);
    ??? = this.nyz;
    Object localObject1 = ???;
    if (??? == null)
    {
      s.bIx("decoder");
      localObject1 = null;
    }
    int i = ((aa)localObject1).dequeueOutputBuffer(this.bufferInfo, this.yii);
    ??? = this.nyz;
    localObject1 = ???;
    if (??? == null)
    {
      s.bIx("decoder");
      localObject1 = null;
    }
    localObject1 = ((aa)localObject1).aPE();
    if (i == -1)
    {
      Log.i(this.TAG, "drainDecoder try again later");
      label96:
      AppMethodBeat.o(286);
      return false;
    }
    if (i == -2)
    {
      str = this.TAG;
      ??? = this.nyz;
      localObject1 = ???;
      if (??? == null)
      {
        s.bIx("decoder");
        localObject1 = null;
      }
      Log.i(str, s.X("drainDecoder output format change: ", ((aa)localObject1).getOutputFormat()));
      localObject1 = this.nyz;
      if (localObject1 == null)
      {
        s.bIx("decoder");
        localObject1 = localObject4;
      }
      for (;;)
      {
        localObject1 = ((aa)localObject1).getOutputFormat();
        s.s(localObject1, "decoder.outputFormat");
        this.mediaFormat = ((MediaFormat)localObject1);
        break;
      }
    }
    Object localObject6;
    if (i == -3)
    {
      localObject6 = this.nyz;
      ??? = localObject6;
      if (localObject6 == null)
      {
        s.bIx("decoder");
        ??? = null;
      }
      if (((aa)???).aPE() == null) {
        break label748;
      }
      ??? = this.nyz;
      localObject1 = ???;
      if (??? == null)
      {
        s.bIx("decoder");
        localObject1 = null;
      }
      localObject1 = ((aa)localObject1).aPE();
    }
    label715:
    label748:
    for (;;)
    {
      localObject6 = this.nyz;
      ??? = localObject6;
      if (localObject6 == null)
      {
        s.bIx("decoder");
        ??? = null;
      }
      i = ((aa)???).dequeueOutputBuffer(this.bufferInfo, this.yii);
      if (i < 0) {
        break label96;
      }
      break;
      if (i < 0)
      {
        Log.i(this.TAG, "drainDecoder loop outputBufferIndex:" + i + ", break");
        break label96;
      }
      ??? = localObject1[i];
      long l = this.bufferInfo.presentationTimeUs;
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        Log.i(this.TAG, "drainDecoder loop reach eof");
        localObject1 = this.nyz;
        if (localObject1 == null)
        {
          s.bIx("decoder");
          localObject1 = localObject5;
        }
        for (;;)
        {
          ((aa)localObject1).releaseOutputBuffer(i, true);
          AppMethodBeat.o(286);
          return true;
        }
      }
      if ((??? != null) && (this.bufferInfo.size != 0))
      {
        ((ByteBuffer)???).position(this.bufferInfo.offset);
        ((ByteBuffer)???).limit(this.bufferInfo.offset + this.bufferInfo.size);
        localObject6 = this.nyz;
        ??? = localObject6;
        if (localObject6 == null)
        {
          s.bIx("decoder");
          ??? = null;
        }
        ((aa)???).releaseOutputBuffer(i, true);
        ??? = this.bufferInfo;
        Log.i(this.TAG, "processDecodeBuffer pts: " + ((MediaCodec.BufferInfo)???).presentationTimeUs + ", size: " + ((MediaCodec.BufferInfo)???).size);
        localObject6 = this.yiC;
        if (localObject6 != null) {
          ((b)localObject6).invoke(Long.valueOf(((MediaCodec.BufferInfo)???).presentationTimeUs * 1000L));
        }
      }
      for (;;)
      {
        synchronized (this.yik)
        {
          try
          {
            this.yik.wait(50L);
            localObject6 = ah.aiuX;
            if ((this.bufferInfo.flags & 0x4) == 0) {
              break;
            }
            try
            {
              ??? = this.nyz;
              localObject1 = ???;
              if (??? == null)
              {
                s.bIx("decoder");
                localObject1 = null;
              }
              ((aa)localObject1).stop();
              localObject1 = this.nyz;
              if (localObject1 != null) {
                break label715;
              }
              s.bIx("decoder");
              localObject1 = str;
              ((aa)localObject1).release();
            }
            catch (Exception localException1)
            {
              aa localaa;
              continue;
            }
            AppMethodBeat.o(286);
            return true;
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace(this.TAG, (Throwable)localException2, "", new Object[0]);
            continue;
          }
        }
        continue;
        localaa = this.nyz;
        ??? = localaa;
        if (localaa == null)
        {
          s.bIx("decoder");
          ??? = null;
        }
        ((aa)???).releaseOutputBuffer(i, true);
      }
    }
  }
  
  public final void dEv()
  {
    AppMethodBeat.i(285);
    synchronized (this.yik)
    {
      try
      {
        this.yik.notifyAll();
        ah localah = ah.aiuX;
        AppMethodBeat.o(285);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  final void dEw()
  {
    Object localObject2 = null;
    AppMethodBeat.i(287);
    Log.i(this.TAG, "sendDecoderEos");
    aa localaa = this.nyz;
    Object localObject1 = localaa;
    if (localaa == null)
    {
      s.bIx("decoder");
      localObject1 = null;
    }
    int j = ((aa)localObject1).dequeueInputBuffer(this.yih);
    int i = 0;
    while ((j < 0) && (i < this.yij))
    {
      if (!boW())
      {
        AppMethodBeat.o(287);
        return;
      }
      localaa = this.nyz;
      localObject1 = localaa;
      if (localaa == null)
      {
        s.bIx("decoder");
        localObject1 = null;
      }
      j = ((aa)localObject1).dequeueInputBuffer(this.yih);
      i += 1;
    }
    if (j >= 0)
    {
      localaa = this.nyz;
      localObject1 = localaa;
      if (localaa == null)
      {
        s.bIx("decoder");
        localObject1 = null;
      }
      localObject1 = localObject1.aPD()[j];
      ((ByteBuffer)localObject1).clear();
      this.pcp.readSampleData((ByteBuffer)localObject1, 0);
      ((ByteBuffer)localObject1).position(0);
      localObject1 = this.nyz;
      if (localObject1 != null) {
        break label204;
      }
      s.bIx("decoder");
      localObject1 = localObject2;
    }
    label204:
    for (;;)
    {
      ((aa)localObject1).a(j, 0, 0L, 4);
      boW();
      AppMethodBeat.o(287);
      return;
    }
  }
  
  public final int init()
  {
    Object localObject2 = null;
    AppMethodBeat.i(283);
    if ((this.mediaFormat != null) && (!Util.isNullOrNil(this.cBw))) {
      try
      {
        Object localObject1 = aa.Dw(this.cBw);
        s.s(localObject1, "createDecoderByType(mime)");
        this.nyz = ((aa)localObject1);
        localObject1 = this.nyz;
        if (localObject1 == null)
        {
          s.bIx("decoder");
          localObject1 = null;
          MediaFormat localMediaFormat2 = this.mediaFormat;
          MediaFormat localMediaFormat1 = localMediaFormat2;
          if (localMediaFormat2 == null)
          {
            s.bIx("mediaFormat");
            localMediaFormat1 = null;
          }
          ((aa)localObject1).a(localMediaFormat1, this.surface, 0);
          localObject1 = this.nyz;
          if (localObject1 != null) {
            break label123;
          }
          s.bIx("decoder");
          localObject1 = localObject2;
        }
        label123:
        for (;;)
        {
          ((aa)localObject1).start();
          AppMethodBeat.o(283);
          return 0;
          break;
        }
        AppMethodBeat.o(283);
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, s.X("init decoder error ", localException.getMessage()));
        AppMethodBeat.o(283);
        return -1;
      }
    }
    return -1;
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(284);
    d.b("EmojiMixVideoDecoder_decodeThread", true, (a)new a(this));
    AppMethodBeat.o(284);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.h
 * JD-Core Version:    0.7.0.1
 */