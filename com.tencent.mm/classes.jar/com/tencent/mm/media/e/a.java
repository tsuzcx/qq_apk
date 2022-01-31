package com.tencent.mm.media.e;

import a.f.b.j;
import a.l;
import a.l.m;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "", "filePath", "", "(Ljava/lang/String;)V", "audioTrackForamt", "Landroid/media/MediaFormat;", "audioTrackIndex", "", "hasError", "", "isRelease", "mediaExtractor", "Landroid/media/MediaExtractor;", "sampleSize", "sampleTime", "", "selectVideo", "videoBitrate", "videoTrackFormat", "videoTrackIndex", "getAudioFormat", "getAudioMIME", "getAudioTrackIndex", "getBitrate", "getCurrentSampleSize", "getDuration", "getFile", "getFilePath", "getSampleTime", "getSampleTrackIndex", "getVideoFormat", "getVideoHeight", "getVideoMIME", "getVideoWidth", "isReleased", "isSelectVideo", "readNextSampleData", "byteBuffer", "Ljava/nio/ByteBuffer;", "release", "", "seek", "startTime", "selectAudio", "setBitrate", "bitrate", "toString", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a eUZ;
  private int eUR;
  public int eUS;
  public MediaFormat eUT;
  public MediaFormat eUU;
  private boolean eUV;
  private long eUW;
  public boolean eUX;
  public boolean eUY;
  public final String filePath;
  public final MediaExtractor mediaExtractor;
  public int sampleSize;
  private int videoBitrate;
  
  static
  {
    AppMethodBeat.i(12981);
    eUZ = new a.a((byte)0);
    AppMethodBeat.o(12981);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(12980);
    this.filePath = paramString;
    this.mediaExtractor = new MediaExtractor();
    this.eUR = -1;
    this.eUS = -1;
    for (;;)
    {
      int i;
      try
      {
        ab.b("MicroMsg.MediaExtractorWrapper", "filePath :" + this.filePath, new Object[0]);
        this.mediaExtractor.setDataSource(this.filePath);
        int j = this.mediaExtractor.getTrackCount();
        ab.b("MicroMsg.MediaExtractorWrapper", "trackCount :".concat(String.valueOf(j)), new Object[0]);
        i = 0;
        if (i < j)
        {
          paramString = this.mediaExtractor.getTrackFormat(i);
          String str = paramString.getString("mime");
          j.p(str, "mime");
          if (m.d((CharSequence)str, (CharSequence)"video"))
          {
            this.eUT = paramString;
            this.eUR = i;
          }
          else if (m.d((CharSequence)str, (CharSequence)"audio"))
          {
            this.eUU = paramString;
            this.eUS = i;
          }
        }
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramString, "", new Object[0]);
        this.eUX = true;
        AppMethodBeat.o(12980);
        return;
      }
      if (this.eUR >= 0)
      {
        this.mediaExtractor.selectTrack(this.eUR);
        this.eUV = true;
      }
      paramString = new MediaMetadataRetriever();
      paramString.setDataSource(this.filePath);
      this.videoBitrate = Integer.parseInt(paramString.extractMetadata(20));
      paramString.release();
      ab.d("MicroMsg.MediaExtractorWrapper", "current info :" + toString());
      AppMethodBeat.o(12980);
      return;
      i += 1;
    }
  }
  
  public final void UT()
  {
    AppMethodBeat.i(12970);
    try
    {
      if (this.eUS >= 0) {
        this.mediaExtractor.unselectTrack(this.eUS);
      }
      if (this.eUR >= 0)
      {
        this.eUV = true;
        this.mediaExtractor.selectTrack(this.eUR);
        this.sampleSize = 0;
        AppMethodBeat.o(12970);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "selectVideo error", new Object[0]);
      AppMethodBeat.o(12970);
    }
  }
  
  public final void UU()
  {
    AppMethodBeat.i(12971);
    try
    {
      if (this.eUR >= 0) {
        this.mediaExtractor.unselectTrack(this.eUR);
      }
      if (this.eUS >= 0)
      {
        this.eUV = false;
        this.mediaExtractor.selectTrack(this.eUS);
        this.sampleSize = 0;
        AppMethodBeat.o(12971);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "selectAudio error", new Object[0]);
      AppMethodBeat.o(12971);
    }
  }
  
  public final String UV()
  {
    AppMethodBeat.i(12972);
    Object localObject = this.eUT;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      AppMethodBeat.o(12972);
      return localObject;
    }
    AppMethodBeat.o(12972);
    return null;
  }
  
  public final String UW()
  {
    AppMethodBeat.i(12973);
    Object localObject = this.eUU;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      AppMethodBeat.o(12973);
      return localObject;
    }
    AppMethodBeat.o(12973);
    return null;
  }
  
  public final boolean g(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(12976);
    j.q(paramByteBuffer, "byteBuffer");
    try
    {
      if (this.eUY)
      {
        ab.e("MicroMsg.MediaExtractorWrapper", "readNextSampleData already release");
        AppMethodBeat.o(12976);
        return false;
      }
      this.sampleSize = this.mediaExtractor.readSampleData(paramByteBuffer, 0);
      this.eUW = this.mediaExtractor.getSampleTime();
      this.mediaExtractor.advance();
      if (this.eUV) {}
      for (int i = this.eUR; this.mediaExtractor.getSampleTrackIndex() != i; i = this.eUS)
      {
        AppMethodBeat.o(12976);
        return false;
      }
      AppMethodBeat.o(12976);
      return true;
    }
    catch (Exception paramByteBuffer)
    {
      ab.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramByteBuffer, "readNextSampleData", new Object[0]);
      AppMethodBeat.o(12976);
    }
    return false;
  }
  
  public final int getDuration()
  {
    int j = 0;
    AppMethodBeat.i(12978);
    MediaFormat localMediaFormat = this.eUT;
    int i;
    if (localMediaFormat != null)
    {
      i = (int)localMediaFormat.getLong("durationUs");
      if (i > 0) {
        break label63;
      }
      localMediaFormat = this.eUU;
      i = j;
      if (localMediaFormat != null) {
        i = (int)localMediaFormat.getLong("durationUs");
      }
    }
    label63:
    for (;;)
    {
      AppMethodBeat.o(12978);
      return i;
      i = 0;
      break;
    }
  }
  
  public final long getSampleTime()
  {
    AppMethodBeat.i(12974);
    try
    {
      long l = this.eUW;
      AppMethodBeat.o(12974);
      return l;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "getSampleTime error", new Object[0]);
      AppMethodBeat.o(12974);
    }
    return -1L;
  }
  
  public final void release()
  {
    AppMethodBeat.i(12977);
    this.mediaExtractor.release();
    this.eUY = true;
    AppMethodBeat.o(12977);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(12975);
    this.mediaExtractor.seekTo(paramLong, 0);
    AppMethodBeat.o(12975);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12979);
    String str = "MediaExtractorWrapper(filePath='" + this.filePath + "', mediaExtractor=" + this.mediaExtractor + ", videoTrackIndex=" + this.eUR + ", audioTrackIndex=" + this.eUS + ", videoTrackFormat=" + this.eUT + ", audioTrackForamt=" + this.eUU + ", videoBitrate=" + this.videoBitrate + ", selectVideo=" + this.eUV + ", sampleSize=" + this.sampleSize + ", hasError=" + this.eUX + ", isRelease=" + this.eUY + ')';
    AppMethodBeat.o(12979);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.e.a
 * JD-Core Version:    0.7.0.1
 */