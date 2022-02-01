package com.tencent.mm.media.e;

import android.media.MediaFormat;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.n.n;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "", "filePath", "", "(Ljava/lang/String;)V", "audioTrackForamt", "Landroid/media/MediaFormat;", "audioTrackIndex", "", "hasError", "", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "sampleSize", "sampleTime", "", "selectVideo", "videoBitrate", "videoTrackFormat", "videoTrackIndex", "getAudioFormat", "getAudioMIME", "getAudioTrackIndex", "getBitrate", "getCurrentSampleSize", "getDuration", "getFile", "getFilePath", "getSampleTime", "getSampleTrackIndex", "getVideoFormat", "getVideoHeight", "getVideoMIME", "getVideoWidth", "hasAudio", "isReleased", "isSelectVideo", "readNextSampleData", "byteBuffer", "Ljava/nio/ByteBuffer;", "release", "", "seek", "startTime", "selectAudio", "setBitrate", "bitrate", "toString", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a gRN;
  public final String filePath;
  public final c gRF;
  private int gRG;
  public int gRH;
  public MediaFormat gRI;
  public MediaFormat gRJ;
  private boolean gRK;
  private long gRL;
  public boolean gRM;
  public boolean gRc;
  public int sampleSize;
  private int videoBitrate;
  
  static
  {
    AppMethodBeat.i(93679);
    gRN = new a.a((byte)0);
    AppMethodBeat.o(93679);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(93678);
    this.filePath = paramString;
    this.gRF = new c();
    this.gRG = -1;
    this.gRH = -1;
    int j;
    Object localObject;
    int i;
    try
    {
      ac.m("MicroMsg.MediaExtractorWrapper", "filePath :" + this.filePath, new Object[0]);
      this.gRF.setDataSource(this.filePath);
      j = this.gRF.getTrackCount();
      ac.m("MicroMsg.MediaExtractorWrapper", "trackCount :".concat(String.valueOf(j)), new Object[0]);
      paramString = new SparseArray();
      localObject = new SparseArray();
      i = 0;
      if (i < j)
      {
        MediaFormat localMediaFormat = this.gRF.getTrackFormat(i);
        k.g(localMediaFormat, "mediaExtractor.getTrackFormat(track)");
        String str = localMediaFormat.getString("mime");
        k.g(str, "mime");
        if (n.e((CharSequence)str, (CharSequence)"video")) {
          paramString.put(i, localMediaFormat);
        } else if (n.e((CharSequence)str, (CharSequence)"audio")) {
          ((SparseArray)localObject).put(i, localMediaFormat);
        }
      }
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramString, "", new Object[0]);
      this.gRM = true;
      AppMethodBeat.o(93678);
      return;
    }
    ac.i("MicroMsg.MediaExtractorWrapper", "video track count:" + paramString.size() + ", audio track count:" + ((SparseArray)localObject).size());
    if (((SparseArray)localObject).size() > 0)
    {
      this.gRH = ((SparseArray)localObject).keyAt(0);
      this.gRJ = ((MediaFormat)((SparseArray)localObject).get(this.gRH));
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
            this.gRG = n;
            this.gRI = ((MediaFormat)localObject);
            i = k;
            break label599;
          }
        }
      }
      else
      {
        if (this.gRG < 0)
        {
          this.gRG = paramString.keyAt(0);
          this.gRI = ((MediaFormat)paramString.get(this.gRG));
        }
        ac.i("MicroMsg.MediaExtractorWrapper", "audio track index:" + this.gRH + ", format:" + this.gRJ);
        ac.i("MicroMsg.MediaExtractorWrapper", "video track index: " + this.gRG + ", format:" + this.gRI);
        if (this.gRG >= 0)
        {
          this.gRF.selectTrack(this.gRG);
          this.gRK = true;
        }
        paramString = new d();
        paramString.setDataSource(this.filePath);
        this.videoBitrate = Integer.parseInt(paramString.extractMetadata(20));
        paramString.release();
        ac.d("MicroMsg.MediaExtractorWrapper", "current info :" + toString());
        AppMethodBeat.o(93678);
        return;
      }
      break label599;
      i += 1;
      break;
      label599:
      j += 1;
    }
  }
  
  public final boolean aqK()
  {
    return (this.gRJ != null) && (this.gRH >= 0);
  }
  
  public final void aqL()
  {
    AppMethodBeat.i(93668);
    try
    {
      if (this.gRH >= 0) {
        this.gRF.unselectTrack(this.gRH);
      }
      if (this.gRG >= 0)
      {
        this.gRK = true;
        this.gRF.selectTrack(this.gRG);
        this.sampleSize = 0;
        AppMethodBeat.o(93668);
        return;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "selectVideo error", new Object[0]);
      AppMethodBeat.o(93668);
    }
  }
  
  public final void aqM()
  {
    AppMethodBeat.i(93669);
    try
    {
      if (this.gRG >= 0) {
        this.gRF.unselectTrack(this.gRG);
      }
      if (this.gRH >= 0)
      {
        this.gRK = false;
        this.gRF.selectTrack(this.gRH);
        this.sampleSize = 0;
        AppMethodBeat.o(93669);
        return;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "selectAudio error", new Object[0]);
      AppMethodBeat.o(93669);
    }
  }
  
  public final String aqN()
  {
    AppMethodBeat.i(93670);
    Object localObject = this.gRI;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      AppMethodBeat.o(93670);
      return localObject;
    }
    AppMethodBeat.o(93670);
    return null;
  }
  
  public final String aqO()
  {
    AppMethodBeat.i(93671);
    Object localObject = this.gRJ;
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
    MediaFormat localMediaFormat = this.gRI;
    int i;
    if (localMediaFormat != null)
    {
      i = (int)localMediaFormat.getLong("durationUs");
      if (i > 0) {
        break label63;
      }
      localMediaFormat = this.gRJ;
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
      long l = this.gRL;
      AppMethodBeat.o(93672);
      return l;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "getSampleTime error", new Object[0]);
      AppMethodBeat.o(93672);
    }
    return -1L;
  }
  
  public final boolean k(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(93674);
    k.h(paramByteBuffer, "byteBuffer");
    try
    {
      if (this.gRc)
      {
        ac.e("MicroMsg.MediaExtractorWrapper", "readNextSampleData already release");
        AppMethodBeat.o(93674);
        return false;
      }
      this.sampleSize = this.gRF.j(paramByteBuffer);
      this.gRL = this.gRF.getSampleTime();
      this.gRF.advance();
      if (this.gRK) {}
      for (int i = this.gRG; this.gRF.getSampleTrackIndex() != i; i = this.gRH)
      {
        AppMethodBeat.o(93674);
        return false;
      }
      AppMethodBeat.o(93674);
      return true;
    }
    catch (Exception paramByteBuffer)
    {
      ac.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramByteBuffer, "readNextSampleData", new Object[0]);
      AppMethodBeat.o(93674);
    }
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93675);
    this.gRF.release();
    this.gRc = true;
    AppMethodBeat.o(93675);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(93673);
    if (!this.gRc)
    {
      this.gRF.seekTo(paramLong, 0);
      AppMethodBeat.o(93673);
      return;
    }
    ac.e("MicroMsg.MediaExtractorWrapper", "seek error, mediaExtractor already release!");
    AppMethodBeat.o(93673);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93677);
    String str = "MediaExtractorWrapper(filePath='" + this.filePath + "', mediaExtractor=" + this.gRF + ", videoTrackIndex=" + this.gRG + ", audioTrackIndex=" + this.gRH + ", videoTrackFormat=" + this.gRI + ", audioTrackForamt=" + this.gRJ + ", videoBitrate=" + this.videoBitrate + ", selectVideo=" + this.gRK + ", sampleSize=" + this.sampleSize + ", hasError=" + this.gRM + ", isRelease=" + this.gRc + ')';
    AppMethodBeat.o(93677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.e.a
 * JD-Core Version:    0.7.0.1
 */