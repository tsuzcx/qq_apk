package com.tencent.mm.media.f;

import android.media.MediaFormat;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.n;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "", "filePath", "", "(Ljava/lang/String;)V", "audioTrackForamt", "Landroid/media/MediaFormat;", "audioTrackIndex", "", "hasError", "", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "sampleSize", "sampleTime", "", "selectVideo", "videoBitrate", "videoTrackFormat", "videoTrackIndex", "getAudioFormat", "getAudioMIME", "getAudioTrackIndex", "getBitrate", "getCurrentSampleSize", "getDuration", "getFile", "getFilePath", "getSampleTime", "getSampleTrackIndex", "getVideoFormat", "getVideoHeight", "getVideoMIME", "getVideoWidth", "hasAudio", "isReleased", "isSelectVideo", "readNextSampleData", "byteBuffer", "Ljava/nio/ByteBuffer;", "release", "", "seek", "startTime", "selectAudio", "setBitrate", "bitrate", "toString", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a hmT;
  public final String filePath;
  public final c hmL;
  private int hmM;
  public int hmN;
  public MediaFormat hmO;
  public MediaFormat hmP;
  private boolean hmQ;
  private long hmR;
  public boolean hmS;
  public boolean hmi;
  public int sampleSize;
  public int videoBitrate;
  
  static
  {
    AppMethodBeat.i(93679);
    hmT = new a.a((byte)0);
    AppMethodBeat.o(93679);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(93678);
    this.filePath = paramString;
    this.hmL = new c();
    this.hmM = -1;
    this.hmN = -1;
    int j;
    Object localObject;
    int i;
    try
    {
      this.hmL.setDataSource(this.filePath);
      j = this.hmL.getTrackCount();
      ae.i("MicroMsg.MediaExtractorWrapper", "trackCount :" + j + " filePath :" + this.filePath);
      paramString = new SparseArray();
      localObject = new SparseArray();
      i = 0;
      if (i < j)
      {
        MediaFormat localMediaFormat = this.hmL.getTrackFormat(i);
        p.g(localMediaFormat, "mediaExtractor.getTrackFormat(track)");
        String str = localMediaFormat.getString("mime");
        p.g(str, "mime");
        if (n.f((CharSequence)str, (CharSequence)"video")) {
          paramString.put(i, localMediaFormat);
        } else if (n.f((CharSequence)str, (CharSequence)"audio")) {
          ((SparseArray)localObject).put(i, localMediaFormat);
        }
      }
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramString, "", new Object[0]);
      this.hmS = true;
      AppMethodBeat.o(93678);
      return;
    }
    ae.i("MicroMsg.MediaExtractorWrapper", "video track count:" + paramString.size() + ", audio track count:" + ((SparseArray)localObject).size());
    if (((SparseArray)localObject).size() > 0)
    {
      this.hmN = ((SparseArray)localObject).keyAt(0);
      this.hmP = ((MediaFormat)((SparseArray)localObject).get(this.hmN));
    }
    int m;
    if (paramString.size() > 0)
    {
      i = 2147483647;
      m = paramString.size();
      j = 0;
    }
    for (;;)
    {
      if (j < m)
      {
        int n = paramString.keyAt(j);
        localObject = (MediaFormat)paramString.get(n);
        if (((MediaFormat)localObject).containsKey("frame-rate"))
        {
          int k = ((MediaFormat)localObject).getInteger("frame-rate");
          if (k < i)
          {
            this.hmM = n;
            this.hmO = ((MediaFormat)localObject);
            i = k;
            break label586;
          }
        }
      }
      else
      {
        if (this.hmM < 0)
        {
          this.hmM = paramString.keyAt(0);
          this.hmO = ((MediaFormat)paramString.get(this.hmM));
        }
        ae.i("MicroMsg.MediaExtractorWrapper", "audio track index:" + this.hmN + ", format:" + this.hmP);
        ae.i("MicroMsg.MediaExtractorWrapper", "video track index: " + this.hmM + ", format:" + this.hmO);
        if (this.hmM >= 0)
        {
          this.hmL.selectTrack(this.hmM);
          this.hmQ = true;
        }
        paramString = new d();
        paramString.setDataSource(this.filePath);
        this.videoBitrate = Integer.parseInt(paramString.extractMetadata(20));
        paramString.release();
        ae.d("MicroMsg.MediaExtractorWrapper", "current info :" + toString());
        AppMethodBeat.o(93678);
        return;
      }
      break label586;
      i += 1;
      break;
      label586:
      j += 1;
    }
  }
  
  public final boolean atN()
  {
    return (this.hmP != null) && (this.hmN >= 0);
  }
  
  public final void atO()
  {
    AppMethodBeat.i(93668);
    try
    {
      if (this.hmN >= 0) {
        this.hmL.unselectTrack(this.hmN);
      }
      if (this.hmM >= 0)
      {
        this.hmQ = true;
        this.hmL.selectTrack(this.hmM);
        this.sampleSize = 0;
        AppMethodBeat.o(93668);
        return;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "selectVideo error", new Object[0]);
      AppMethodBeat.o(93668);
    }
  }
  
  public final void atP()
  {
    AppMethodBeat.i(93669);
    try
    {
      if (this.hmM >= 0) {
        this.hmL.unselectTrack(this.hmM);
      }
      if (this.hmN >= 0)
      {
        this.hmQ = false;
        this.hmL.selectTrack(this.hmN);
        this.sampleSize = 0;
        AppMethodBeat.o(93669);
        return;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "selectAudio error", new Object[0]);
      AppMethodBeat.o(93669);
    }
  }
  
  public final String atQ()
  {
    AppMethodBeat.i(93670);
    Object localObject = this.hmO;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      AppMethodBeat.o(93670);
      return localObject;
    }
    AppMethodBeat.o(93670);
    return null;
  }
  
  public final String atR()
  {
    AppMethodBeat.i(93671);
    Object localObject = this.hmP;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      AppMethodBeat.o(93671);
      return localObject;
    }
    AppMethodBeat.o(93671);
    return null;
  }
  
  public final int getDuration()
  {
    int j = 0;
    AppMethodBeat.i(93676);
    MediaFormat localMediaFormat = this.hmO;
    int i;
    if (localMediaFormat != null)
    {
      i = (int)localMediaFormat.getLong("durationUs");
      if (i > 0) {
        break label63;
      }
      localMediaFormat = this.hmP;
      i = j;
      if (localMediaFormat != null) {
        i = (int)localMediaFormat.getLong("durationUs");
      }
    }
    label63:
    for (;;)
    {
      AppMethodBeat.o(93676);
      return i;
      i = 0;
      break;
    }
  }
  
  public final long getSampleTime()
  {
    AppMethodBeat.i(93672);
    try
    {
      long l = this.hmR;
      AppMethodBeat.o(93672);
      return l;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "getSampleTime error", new Object[0]);
      AppMethodBeat.o(93672);
    }
    return -1L;
  }
  
  public final boolean j(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(93674);
    p.h(paramByteBuffer, "byteBuffer");
    try
    {
      if (this.hmi)
      {
        ae.e("MicroMsg.MediaExtractorWrapper", "readNextSampleData already release");
        AppMethodBeat.o(93674);
        return false;
      }
      this.sampleSize = this.hmL.readSampleData(paramByteBuffer, 0);
      this.hmR = this.hmL.getSampleTime();
      this.hmL.advance();
      if (this.hmQ) {}
      for (int i = this.hmM; this.hmL.getSampleTrackIndex() != i; i = this.hmN)
      {
        AppMethodBeat.o(93674);
        return false;
      }
      AppMethodBeat.o(93674);
      return true;
    }
    catch (Exception paramByteBuffer)
    {
      ae.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramByteBuffer, "readNextSampleData", new Object[0]);
      AppMethodBeat.o(93674);
    }
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93675);
    this.hmL.release();
    this.hmi = true;
    AppMethodBeat.o(93675);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(93673);
    if (!this.hmi)
    {
      this.hmL.seekTo(paramLong, 0);
      AppMethodBeat.o(93673);
      return;
    }
    ae.e("MicroMsg.MediaExtractorWrapper", "seek error, mediaExtractor already release!");
    AppMethodBeat.o(93673);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93677);
    String str = "MediaExtractorWrapper(filePath='" + this.filePath + "', mediaExtractor=" + this.hmL + ", videoTrackIndex=" + this.hmM + ", audioTrackIndex=" + this.hmN + ", videoTrackFormat=" + this.hmO + ", audioTrackForamt=" + this.hmP + ", videoBitrate=" + this.videoBitrate + ", selectVideo=" + this.hmQ + ", sampleSize=" + this.sampleSize + ", hasError=" + this.hmS + ", isRelease=" + this.hmi + ')';
    AppMethodBeat.o(93677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.f.a
 * JD-Core Version:    0.7.0.1
 */