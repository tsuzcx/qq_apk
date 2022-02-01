package com.tencent.mm.media.f;

import android.media.MediaFormat;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "", "filePath", "", "(Ljava/lang/String;)V", "audioTrackForamt", "Landroid/media/MediaFormat;", "audioTrackIndex", "", "hasError", "", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "sampleSize", "sampleTime", "", "selectVideo", "videoBitrate", "videoTrackFormat", "videoTrackIndex", "getAudioFormat", "getAudioMIME", "getAudioTrackIndex", "getBitrate", "getCurrentSampleSize", "getDuration", "getFile", "getFilePath", "getSampleTime", "getSampleTrackIndex", "getVideoFormat", "getVideoHeight", "getVideoMIME", "getVideoWidth", "hasAudio", "isReleased", "isSelectVideo", "readNextSampleData", "byteBuffer", "Ljava/nio/ByteBuffer;", "offset", "release", "", "seek", "startTime", "selectAudio", "setBitrate", "bitrate", "toString", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a igm;
  public int audioTrackIndex;
  public final String filePath;
  public boolean ife;
  public final c igg;
  public MediaFormat igh;
  public MediaFormat igi;
  private boolean igj;
  private long igk;
  public boolean igl;
  public int sampleSize;
  public int videoBitrate;
  private int videoTrackIndex;
  
  static
  {
    AppMethodBeat.i(93679);
    igm = new a.a((byte)0);
    AppMethodBeat.o(93679);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(93678);
    this.filePath = paramString;
    this.igg = new c();
    this.videoTrackIndex = -1;
    this.audioTrackIndex = -1;
    int j;
    Object localObject;
    int i;
    try
    {
      this.igg.setDataSource(this.filePath);
      j = this.igg.getTrackCount();
      Log.i("MicroMsg.MediaExtractorWrapper", "trackCount :" + j + " filePath :" + this.filePath);
      paramString = new SparseArray();
      localObject = new SparseArray();
      i = 0;
      if (i < j)
      {
        MediaFormat localMediaFormat = this.igg.getTrackFormat(i);
        p.g(localMediaFormat, "mediaExtractor.getTrackFormat(track)");
        String str = localMediaFormat.getString("mime");
        p.g(str, "mime");
        if (n.e((CharSequence)str, (CharSequence)"video")) {
          paramString.put(i, localMediaFormat);
        } else if (n.e((CharSequence)str, (CharSequence)"audio")) {
          ((SparseArray)localObject).put(i, localMediaFormat);
        }
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramString, "", new Object[0]);
      this.igl = true;
      AppMethodBeat.o(93678);
      return;
    }
    Log.i("MicroMsg.MediaExtractorWrapper", "video track count:" + paramString.size() + ", audio track count:" + ((SparseArray)localObject).size());
    if (((SparseArray)localObject).size() > 0)
    {
      this.audioTrackIndex = ((SparseArray)localObject).keyAt(0);
      this.igi = ((MediaFormat)((SparseArray)localObject).get(this.audioTrackIndex));
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
            this.videoTrackIndex = n;
            this.igh = ((MediaFormat)localObject);
            i = k;
            break label586;
          }
        }
      }
      else
      {
        if (this.videoTrackIndex < 0)
        {
          this.videoTrackIndex = paramString.keyAt(0);
          this.igh = ((MediaFormat)paramString.get(this.videoTrackIndex));
        }
        Log.i("MicroMsg.MediaExtractorWrapper", "audio track index:" + this.audioTrackIndex + ", format:" + this.igi);
        Log.i("MicroMsg.MediaExtractorWrapper", "video track index: " + this.videoTrackIndex + ", format:" + this.igh);
        if (this.videoTrackIndex >= 0)
        {
          this.igg.selectTrack(this.videoTrackIndex);
          this.igj = true;
        }
        paramString = new d();
        paramString.setDataSource(this.filePath);
        this.videoBitrate = Integer.parseInt(paramString.extractMetadata(20));
        paramString.release();
        Log.d("MicroMsg.MediaExtractorWrapper", "current info :" + toString());
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
  
  private boolean j(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(218746);
    p.h(paramByteBuffer, "byteBuffer");
    try
    {
      if (this.ife)
      {
        Log.e("MicroMsg.MediaExtractorWrapper", "readNextSampleData already release");
        AppMethodBeat.o(218746);
        return false;
      }
      this.sampleSize = this.igg.readSampleData(paramByteBuffer, 0);
      this.igk = this.igg.getSampleTime();
      this.igg.advance();
      if (this.igj) {}
      for (int i = this.videoTrackIndex; this.igg.getSampleTrackIndex() != i; i = this.audioTrackIndex)
      {
        AppMethodBeat.o(218746);
        return false;
      }
      AppMethodBeat.o(218746);
      return true;
    }
    catch (Exception paramByteBuffer)
    {
      Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramByteBuffer, "readNextSampleData", new Object[0]);
      AppMethodBeat.o(218746);
    }
    return false;
  }
  
  public final boolean aMp()
  {
    return (this.igi != null) && (this.audioTrackIndex >= 0);
  }
  
  public final void aMq()
  {
    AppMethodBeat.i(93668);
    try
    {
      if (this.audioTrackIndex >= 0) {
        this.igg.unselectTrack(this.audioTrackIndex);
      }
      if (this.videoTrackIndex >= 0)
      {
        this.igj = true;
        this.igg.selectTrack(this.videoTrackIndex);
        this.sampleSize = 0;
        AppMethodBeat.o(93668);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "selectVideo error", new Object[0]);
      AppMethodBeat.o(93668);
    }
  }
  
  public final void aMr()
  {
    AppMethodBeat.i(93669);
    try
    {
      if (this.videoTrackIndex >= 0) {
        this.igg.unselectTrack(this.videoTrackIndex);
      }
      if (this.audioTrackIndex >= 0)
      {
        this.igj = false;
        this.igg.selectTrack(this.audioTrackIndex);
        this.sampleSize = 0;
        AppMethodBeat.o(93669);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "selectAudio error", new Object[0]);
      AppMethodBeat.o(93669);
    }
  }
  
  public final String aMs()
  {
    AppMethodBeat.i(93670);
    Object localObject = this.igh;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      AppMethodBeat.o(93670);
      return localObject;
    }
    AppMethodBeat.o(93670);
    return null;
  }
  
  public final String aMt()
  {
    AppMethodBeat.i(93671);
    Object localObject = this.igi;
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
    MediaFormat localMediaFormat = this.igh;
    int i;
    if (localMediaFormat != null)
    {
      i = (int)localMediaFormat.getLong("durationUs");
      if (i > 0) {
        break label63;
      }
      localMediaFormat = this.igi;
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
      long l = this.igk;
      AppMethodBeat.o(93672);
      return l;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "getSampleTime error", new Object[0]);
      AppMethodBeat.o(93672);
    }
    return -1L;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93675);
    this.igg.release();
    this.ife = true;
    AppMethodBeat.o(93675);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(93673);
    if (!this.ife)
    {
      this.igg.seekTo(paramLong, 0);
      AppMethodBeat.o(93673);
      return;
    }
    Log.e("MicroMsg.MediaExtractorWrapper", "seek error, mediaExtractor already release!");
    AppMethodBeat.o(93673);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93677);
    String str = "MediaExtractorWrapper(filePath='" + this.filePath + "', mediaExtractor=" + this.igg + ", videoTrackIndex=" + this.videoTrackIndex + ", audioTrackIndex=" + this.audioTrackIndex + ", videoTrackFormat=" + this.igh + ", audioTrackForamt=" + this.igi + ", videoBitrate=" + this.videoBitrate + ", selectVideo=" + this.igj + ", sampleSize=" + this.sampleSize + ", hasError=" + this.igl + ", isRelease=" + this.ife + ')';
    AppMethodBeat.o(93677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.f.a
 * JD-Core Version:    0.7.0.1
 */