package com.tencent.mm.media.f;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "", "filePath", "", "(Ljava/lang/String;)V", "audioTrackForamt", "Landroid/media/MediaFormat;", "audioTrackIndex", "", "hasError", "", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "sampleSize", "sampleTime", "", "selectVideo", "videoBitrate", "videoTrackFormat", "videoTrackIndex", "getAudioFormat", "getAudioMIME", "getAudioTrackIndex", "getBitrate", "getCurrentSampleSize", "getDuration", "getFile", "getFilePath", "getSampleTime", "getSampleTrackIndex", "getVideoFormat", "getVideoHeight", "getVideoMIME", "getVideoWidth", "hasAudio", "isReleased", "isSelectVideo", "readNextSampleData", "byteBuffer", "Ljava/nio/ByteBuffer;", "offset", "release", "", "seek", "startTime", "selectAudio", "setBitrate", "bitrate", "toString", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a nAq;
  public int audioTrackIndex;
  public final String filePath;
  public boolean hasError;
  public final c nAr;
  public MediaFormat nAs;
  public MediaFormat nAt;
  private boolean nAu;
  private long nAv;
  public boolean nzB;
  public int sampleSize;
  public int videoBitrate;
  private int videoTrackIndex;
  
  static
  {
    AppMethodBeat.i(93679);
    nAq = new a.a((byte)0);
    AppMethodBeat.o(93679);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(93678);
    this.filePath = paramString;
    this.nAr = new c();
    this.videoTrackIndex = -1;
    this.audioTrackIndex = -1;
    for (;;)
    {
      int k;
      int i;
      int j;
      label190:
      int n;
      label285:
      int m;
      try
      {
        this.nAr.setDataSource(this.filePath);
        k = this.nAr.lZm.getTrackCount();
        Log.i("MicroMsg.MediaExtractorWrapper", "trackCount :" + k + " filePath :" + this.filePath);
        paramString = new SparseArray();
        Object localObject = new SparseArray();
        MediaFormat localMediaFormat;
        String str;
        if (k > 0)
        {
          i = 0;
          j = i + 1;
          localMediaFormat = this.nAr.getTrackFormat(i);
          s.s(localMediaFormat, "mediaExtractor.getTrackFormat(track)");
          str = localMediaFormat.getString("mime");
          s.checkNotNull(str);
          s.s(str, "trackFormat.getString(MediaFormat.KEY_MIME)!!");
          if (n.i((CharSequence)str, (CharSequence)"video"))
          {
            paramString.put(i, localMediaFormat);
            break label604;
          }
        }
        else
        {
          Log.i("MicroMsg.MediaExtractorWrapper", "video track count:" + paramString.size() + ", audio track count:" + ((SparseArray)localObject).size());
          if (((SparseArray)localObject).size() > 0)
          {
            this.audioTrackIndex = ((SparseArray)localObject).keyAt(0);
            this.nAt = ((MediaFormat)((SparseArray)localObject).get(this.audioTrackIndex));
          }
          if (paramString.size() > 0)
          {
            n = paramString.size();
            if (n > 0)
            {
              k = 0;
              i = 2147483647;
              m = k + 1;
              int i1 = paramString.keyAt(k);
              localObject = (MediaFormat)paramString.get(i1);
              j = i;
              if (!((MediaFormat)localObject).containsKey("frame-rate")) {
                break label613;
              }
              k = ((MediaFormat)localObject).getInteger("frame-rate");
              j = i;
              if (k >= i) {
                break label613;
              }
              this.videoTrackIndex = i1;
              this.nAs = ((MediaFormat)localObject);
              j = k;
              break label613;
            }
            if (this.videoTrackIndex < 0)
            {
              this.videoTrackIndex = paramString.keyAt(0);
              this.nAs = ((MediaFormat)paramString.get(this.videoTrackIndex));
            }
          }
          Log.i("MicroMsg.MediaExtractorWrapper", "audio track index:" + this.audioTrackIndex + ", format:" + this.nAt);
          Log.i("MicroMsg.MediaExtractorWrapper", "video track index: " + this.videoTrackIndex + ", format:" + this.nAs);
          if (this.videoTrackIndex >= 0)
          {
            this.nAr.selectTrack(this.videoTrackIndex);
            this.nAu = true;
          }
          paramString = new d();
          paramString.setDataSource(this.filePath);
          this.videoBitrate = Integer.parseInt(paramString.extractMetadata(20));
          paramString.release();
          Log.d("MicroMsg.MediaExtractorWrapper", s.X("current info :", this));
          AppMethodBeat.o(93678);
          return;
        }
        if (n.i((CharSequence)str, (CharSequence)"audio")) {
          ((SparseArray)localObject).put(i, localMediaFormat);
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramString, "", new Object[0]);
        this.hasError = true;
        AppMethodBeat.o(93678);
        return;
      }
      label604:
      label613:
      do
      {
        k = m;
        i = j;
        break label285;
        do
        {
          i = j;
          break;
        } while (j < k);
        break label190;
      } while (m < n);
    }
  }
  
  private boolean m(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(236881);
    s.u(paramByteBuffer, "byteBuffer");
    try
    {
      if (this.nzB)
      {
        Log.e("MicroMsg.MediaExtractorWrapper", "readNextSampleData already release");
        AppMethodBeat.o(236881);
        return false;
      }
      this.sampleSize = this.nAr.readSampleData(paramByteBuffer, 0);
      this.nAv = this.nAr.lZm.getSampleTime();
      this.nAr.lZm.advance();
      if (this.nAu) {}
      for (int i = this.videoTrackIndex; this.nAr.lZm.getSampleTrackIndex() != i; i = this.audioTrackIndex)
      {
        AppMethodBeat.o(236881);
        return false;
      }
      AppMethodBeat.o(236881);
      return true;
    }
    catch (Exception paramByteBuffer)
    {
      Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", (Throwable)paramByteBuffer, "readNextSampleData", new Object[0]);
      AppMethodBeat.o(236881);
    }
    return false;
  }
  
  public final boolean bpm()
  {
    return (this.nAt != null) && (this.audioTrackIndex >= 0);
  }
  
  public final void bpn()
  {
    AppMethodBeat.i(93668);
    try
    {
      if (this.audioTrackIndex >= 0) {
        this.nAr.unselectTrack(this.audioTrackIndex);
      }
      if (this.videoTrackIndex >= 0)
      {
        this.nAu = true;
        this.nAr.selectTrack(this.videoTrackIndex);
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
  
  public final void bpo()
  {
    AppMethodBeat.i(93669);
    try
    {
      if (this.videoTrackIndex >= 0) {
        this.nAr.unselectTrack(this.videoTrackIndex);
      }
      if (this.audioTrackIndex >= 0)
      {
        this.nAu = false;
        this.nAr.selectTrack(this.audioTrackIndex);
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
  
  public final String bpp()
  {
    AppMethodBeat.i(93670);
    Object localObject = this.nAs;
    if (localObject == null)
    {
      AppMethodBeat.o(93670);
      return null;
    }
    localObject = ((MediaFormat)localObject).getString("mime");
    AppMethodBeat.o(93670);
    return localObject;
  }
  
  public final String bpq()
  {
    AppMethodBeat.i(93671);
    Object localObject = this.nAt;
    if (localObject == null)
    {
      AppMethodBeat.o(93671);
      return null;
    }
    localObject = ((MediaFormat)localObject).getString("mime");
    AppMethodBeat.o(93671);
    return localObject;
  }
  
  public final int getDuration()
  {
    int j = 0;
    AppMethodBeat.i(93676);
    MediaFormat localMediaFormat = this.nAs;
    int i;
    if (localMediaFormat == null)
    {
      i = 0;
      if (i > 0) {
        break label66;
      }
      localMediaFormat = this.nAt;
      if (localMediaFormat != null) {
        break label54;
      }
      i = j;
    }
    label54:
    label66:
    for (;;)
    {
      AppMethodBeat.o(93676);
      return i;
      i = (int)localMediaFormat.getLong("durationUs");
      break;
      i = (int)localMediaFormat.getLong("durationUs");
    }
  }
  
  public final long getSampleTime()
  {
    AppMethodBeat.i(93672);
    try
    {
      long l = this.nAv;
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
    this.nAr.lZm.release();
    this.nzB = true;
    AppMethodBeat.o(93675);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(93673);
    if (!this.nzB)
    {
      this.nAr.seekTo(paramLong, 0);
      AppMethodBeat.o(93673);
      return;
    }
    Log.e("MicroMsg.MediaExtractorWrapper", "seek error, mediaExtractor already release!");
    AppMethodBeat.o(93673);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93677);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MediaExtractorWrapper(filePath='").append(this.filePath).append("', mediaExtractor=").append(this.nAr).append(", videoTrackIndex=").append(this.videoTrackIndex).append(", audioTrackIndex=").append(this.audioTrackIndex).append(", videoTrackFormat=").append(this.nAs).append(", audioTrackForamt=").append(this.nAt).append(", videoBitrate=").append(this.videoBitrate).append(", selectVideo=").append(this.nAu).append(", sampleSize=").append(this.sampleSize).append(", hasError=").append(this.hasError).append(", isRelease=").append(this.nzB).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(93677);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.f.a
 * JD-Core Version:    0.7.0.1
 */