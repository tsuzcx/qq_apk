package com.tencent.mm.media.e;

import android.media.MediaFormat;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.n.n;
import java.nio.ByteBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "", "filePath", "", "(Ljava/lang/String;)V", "audioTrackForamt", "Landroid/media/MediaFormat;", "audioTrackIndex", "", "hasError", "", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "sampleSize", "sampleTime", "", "selectVideo", "videoBitrate", "videoTrackFormat", "videoTrackIndex", "getAudioFormat", "getAudioMIME", "getAudioTrackIndex", "getBitrate", "getCurrentSampleSize", "getDuration", "getFile", "getFilePath", "getSampleTime", "getSampleTrackIndex", "getVideoFormat", "getVideoHeight", "getVideoMIME", "getVideoWidth", "hasAudio", "isReleased", "isSelectVideo", "readNextSampleData", "byteBuffer", "Ljava/nio/ByteBuffer;", "release", "", "seek", "startTime", "selectAudio", "setBitrate", "bitrate", "toString", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a grf;
  public final String filePath;
  public final c gqX;
  private int gqY;
  public int gqZ;
  public boolean gqu;
  public MediaFormat gra;
  public MediaFormat grb;
  private boolean grc;
  private long grd;
  public boolean gre;
  public int sampleSize;
  private int videoBitrate;
  
  static
  {
    AppMethodBeat.i(93679);
    grf = new a((byte)0);
    AppMethodBeat.o(93679);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(93678);
    this.filePath = paramString;
    this.gqX = new c();
    this.gqY = -1;
    this.gqZ = -1;
    int j;
    Object localObject;
    int i;
    try
    {
      ad.m("MicroMsg.MediaExtractorWrapper", "filePath :" + this.filePath, new Object[0]);
      this.gqX.setDataSource(this.filePath);
      j = this.gqX.getTrackCount();
      ad.m("MicroMsg.MediaExtractorWrapper", "trackCount :".concat(String.valueOf(j)), new Object[0]);
      paramString = new SparseArray();
      localObject = new SparseArray();
      i = 0;
      if (i < j)
      {
        MediaFormat localMediaFormat = this.gqX.getTrackFormat(i);
        k.g(localMediaFormat, "mediaExtractor.getTrackFormat(track)");
        String str = localMediaFormat.getString("mime");
        k.g(str, "mime");
        if (n.f((CharSequence)str, (CharSequence)"video")) {
          paramString.put(i, localMediaFormat);
        } else if (n.f((CharSequence)str, (CharSequence)"audio")) {
          ((SparseArray)localObject).put(i, localMediaFormat);
        }
      }
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramString, "", new Object[0]);
      this.gre = true;
      AppMethodBeat.o(93678);
      return;
    }
    ad.i("MicroMsg.MediaExtractorWrapper", "video track count:" + paramString.size() + ", audio track count:" + ((SparseArray)localObject).size());
    if (((SparseArray)localObject).size() > 0)
    {
      this.gqZ = ((SparseArray)localObject).keyAt(0);
      this.grb = ((MediaFormat)((SparseArray)localObject).get(this.gqZ));
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
            this.gqY = n;
            this.gra = ((MediaFormat)localObject);
            i = k;
            break label599;
          }
        }
      }
      else
      {
        if (this.gqY < 0)
        {
          this.gqY = paramString.keyAt(0);
          this.gra = ((MediaFormat)paramString.get(this.gqY));
        }
        ad.i("MicroMsg.MediaExtractorWrapper", "audio track index:" + this.gqZ + ", format:" + this.grb);
        ad.i("MicroMsg.MediaExtractorWrapper", "video track index: " + this.gqY + ", format:" + this.gra);
        if (this.gqY >= 0)
        {
          this.gqX.selectTrack(this.gqY);
          this.grc = true;
        }
        paramString = new d();
        paramString.setDataSource(this.filePath);
        this.videoBitrate = Integer.parseInt(paramString.extractMetadata(20));
        paramString.release();
        ad.d("MicroMsg.MediaExtractorWrapper", "current info :" + toString());
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
  
  public final boolean ajL()
  {
    return (this.grb != null) && (this.gqZ >= 0);
  }
  
  public final void ajM()
  {
    AppMethodBeat.i(93668);
    try
    {
      if (this.gqZ >= 0) {
        this.gqX.unselectTrack(this.gqZ);
      }
      if (this.gqY >= 0)
      {
        this.grc = true;
        this.gqX.selectTrack(this.gqY);
        this.sampleSize = 0;
        AppMethodBeat.o(93668);
        return;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "selectVideo error", new Object[0]);
      AppMethodBeat.o(93668);
    }
  }
  
  public final void ajN()
  {
    AppMethodBeat.i(93669);
    try
    {
      if (this.gqY >= 0) {
        this.gqX.unselectTrack(this.gqY);
      }
      if (this.gqZ >= 0)
      {
        this.grc = false;
        this.gqX.selectTrack(this.gqZ);
        this.sampleSize = 0;
        AppMethodBeat.o(93669);
        return;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "selectAudio error", new Object[0]);
      AppMethodBeat.o(93669);
    }
  }
  
  public final String ajO()
  {
    AppMethodBeat.i(93670);
    Object localObject = this.gra;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      AppMethodBeat.o(93670);
      return localObject;
    }
    AppMethodBeat.o(93670);
    return null;
  }
  
  public final String ajP()
  {
    AppMethodBeat.i(93671);
    Object localObject = this.grb;
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
    MediaFormat localMediaFormat = this.gra;
    int i;
    if (localMediaFormat != null)
    {
      i = (int)localMediaFormat.getLong("durationUs");
      if (i > 0) {
        break label63;
      }
      localMediaFormat = this.grb;
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
      long l = this.grd;
      AppMethodBeat.o(93672);
      return l;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)localException, "getSampleTime error", new Object[0]);
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
      if (this.gqu)
      {
        ad.e("MicroMsg.MediaExtractorWrapper", "readNextSampleData already release");
        AppMethodBeat.o(93674);
        return false;
      }
      this.sampleSize = this.gqX.j(paramByteBuffer);
      this.grd = this.gqX.getSampleTime();
      this.gqX.advance();
      if (this.grc) {}
      for (int i = this.gqY; this.gqX.getSampleTrackIndex() != i; i = this.gqZ)
      {
        AppMethodBeat.o(93674);
        return false;
      }
      AppMethodBeat.o(93674);
      return true;
    }
    catch (Exception paramByteBuffer)
    {
      ad.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramByteBuffer, "readNextSampleData", new Object[0]);
      AppMethodBeat.o(93674);
    }
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93675);
    this.gqX.release();
    this.gqu = true;
    AppMethodBeat.o(93675);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(93673);
    if (!this.gqu)
    {
      this.gqX.seekTo(paramLong, 0);
      AppMethodBeat.o(93673);
      return;
    }
    ad.e("MicroMsg.MediaExtractorWrapper", "seek error, mediaExtractor already release!");
    AppMethodBeat.o(93673);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93677);
    String str = "MediaExtractorWrapper(filePath='" + this.filePath + "', mediaExtractor=" + this.gqX + ", videoTrackIndex=" + this.gqY + ", audioTrackIndex=" + this.gqZ + ", videoTrackFormat=" + this.gra + ", audioTrackForamt=" + this.grb + ", videoBitrate=" + this.videoBitrate + ", selectVideo=" + this.grc + ", sampleSize=" + this.sampleSize + ", hasError=" + this.gre + ", isRelease=" + this.gqu + ')';
    AppMethodBeat.o(93677);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/extractor/MediaExtractorWrapper$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.e.a
 * JD-Core Version:    0.7.0.1
 */