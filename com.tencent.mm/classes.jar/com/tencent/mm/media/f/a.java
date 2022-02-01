package com.tencent.mm.media.f;

import android.media.MediaFormat;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "", "filePath", "", "(Ljava/lang/String;)V", "audioTrackForamt", "Landroid/media/MediaFormat;", "audioTrackIndex", "", "hasError", "", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "sampleSize", "sampleTime", "", "selectVideo", "videoBitrate", "videoTrackFormat", "videoTrackIndex", "getAudioFormat", "getAudioMIME", "getAudioTrackIndex", "getBitrate", "getCurrentSampleSize", "getDuration", "getFile", "getFilePath", "getSampleTime", "getSampleTrackIndex", "getVideoFormat", "getVideoHeight", "getVideoMIME", "getVideoWidth", "hasAudio", "isReleased", "isSelectVideo", "readNextSampleData", "byteBuffer", "Ljava/nio/ByteBuffer;", "release", "", "seek", "startTime", "selectAudio", "setBitrate", "bitrate", "toString", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a hkf;
  public final String filePath;
  public final c hjX;
  private int hjY;
  public int hjZ;
  public boolean hju;
  public MediaFormat hka;
  public MediaFormat hkb;
  private boolean hkc;
  private long hkd;
  public boolean hke;
  public int sampleSize;
  public int videoBitrate;
  
  static
  {
    AppMethodBeat.i(93679);
    hkf = new a.a((byte)0);
    AppMethodBeat.o(93679);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(93678);
    this.filePath = paramString;
    this.hjX = new c();
    this.hjY = -1;
    this.hjZ = -1;
    int j;
    Object localObject;
    int i;
    try
    {
      this.hjX.setDataSource(this.filePath);
      j = this.hjX.getTrackCount();
      ad.i("MicroMsg.MediaExtractorWrapper", "trackCount :" + j + " filePath :" + this.filePath);
      paramString = new SparseArray();
      localObject = new SparseArray();
      i = 0;
      if (i < j)
      {
        MediaFormat localMediaFormat = this.hjX.getTrackFormat(i);
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
      ad.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramString, "", new Object[0]);
      this.hke = true;
      AppMethodBeat.o(93678);
      return;
    }
    ad.i("MicroMsg.MediaExtractorWrapper", "video track count:" + paramString.size() + ", audio track count:" + ((SparseArray)localObject).size());
    if (((SparseArray)localObject).size() > 0)
    {
      this.hjZ = ((SparseArray)localObject).keyAt(0);
      this.hkb = ((MediaFormat)((SparseArray)localObject).get(this.hjZ));
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
            this.hjY = n;
            this.hka = ((MediaFormat)localObject);
            i = k;
            break label586;
          }
        }
      }
      else
      {
        if (this.hjY < 0)
        {
          this.hjY = paramString.keyAt(0);
          this.hka = ((MediaFormat)paramString.get(this.hjY));
        }
        ad.i("MicroMsg.MediaExtractorWrapper", "audio track index:" + this.hjZ + ", format:" + this.hkb);
        ad.i("MicroMsg.MediaExtractorWrapper", "video track index: " + this.hjY + ", format:" + this.hka);
        if (this.hjY >= 0)
        {
          this.hjX.selectTrack(this.hjY);
          this.hkc = true;
        }
        paramString = new d();
        paramString.setDataSource(this.filePath);
        this.videoBitrate = Integer.parseInt(paramString.extractMetadata(20));
        paramString.release();
        ad.d("MicroMsg.MediaExtractorWrapper", "current info :" + toString());
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
  
  public final void atA()
  {
    AppMethodBeat.i(93669);
    try
    {
      if (this.hjY >= 0) {
        this.hjX.unselectTrack(this.hjY);
      }
      if (this.hjZ >= 0)
      {
        this.hkc = false;
        this.hjX.selectTrack(this.hjZ);
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
  
  public final String atB()
  {
    AppMethodBeat.i(93670);
    Object localObject = this.hka;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      AppMethodBeat.o(93670);
      return localObject;
    }
    AppMethodBeat.o(93670);
    return null;
  }
  
  public final String atC()
  {
    AppMethodBeat.i(93671);
    Object localObject = this.hkb;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      AppMethodBeat.o(93671);
      return localObject;
    }
    AppMethodBeat.o(93671);
    return null;
  }
  
  public final boolean aty()
  {
    return (this.hkb != null) && (this.hjZ >= 0);
  }
  
  public final void atz()
  {
    AppMethodBeat.i(93668);
    try
    {
      if (this.hjZ >= 0) {
        this.hjX.unselectTrack(this.hjZ);
      }
      if (this.hjY >= 0)
      {
        this.hkc = true;
        this.hjX.selectTrack(this.hjY);
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
  
  public final int getDuration()
  {
    int j = 0;
    AppMethodBeat.i(93676);
    MediaFormat localMediaFormat = this.hka;
    int i;
    if (localMediaFormat != null)
    {
      i = (int)localMediaFormat.getLong("durationUs");
      if (i > 0) {
        break label63;
      }
      localMediaFormat = this.hkb;
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
      long l = this.hkd;
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
  
  public final boolean j(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(93674);
    p.h(paramByteBuffer, "byteBuffer");
    try
    {
      if (this.hju)
      {
        ad.e("MicroMsg.MediaExtractorWrapper", "readNextSampleData already release");
        AppMethodBeat.o(93674);
        return false;
      }
      this.sampleSize = this.hjX.readSampleData(paramByteBuffer, 0);
      this.hkd = this.hjX.getSampleTime();
      this.hjX.advance();
      if (this.hkc) {}
      for (int i = this.hjY; this.hjX.getSampleTrackIndex() != i; i = this.hjZ)
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
    this.hjX.release();
    this.hju = true;
    AppMethodBeat.o(93675);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(93673);
    if (!this.hju)
    {
      this.hjX.seekTo(paramLong, 0);
      AppMethodBeat.o(93673);
      return;
    }
    ad.e("MicroMsg.MediaExtractorWrapper", "seek error, mediaExtractor already release!");
    AppMethodBeat.o(93673);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93677);
    String str = "MediaExtractorWrapper(filePath='" + this.filePath + "', mediaExtractor=" + this.hjX + ", videoTrackIndex=" + this.hjY + ", audioTrackIndex=" + this.hjZ + ", videoTrackFormat=" + this.hka + ", audioTrackForamt=" + this.hkb + ", videoBitrate=" + this.videoBitrate + ", selectVideo=" + this.hkc + ", sampleSize=" + this.sampleSize + ", hasError=" + this.hke + ", isRelease=" + this.hju + ')';
    AppMethodBeat.o(93677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.f.a
 * JD-Core Version:    0.7.0.1
 */