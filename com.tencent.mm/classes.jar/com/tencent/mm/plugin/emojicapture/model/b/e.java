package com.tencent.mm.plugin.emojicapture.model.b;

import a.d.a.a;
import a.d.a.b;
import a.d.b.g;
import a.h.l;
import a.n;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

public final class e
{
  final String TAG;
  private final Surface avf;
  private MediaFormat eIG;
  private MediaCodec.BufferInfo eIJ;
  MediaExtractor eIP;
  MediaCodec eIT;
  private String jkV;
  final long jkW;
  private final long jkX;
  final int jkY;
  b<? super Long, n> jkZ;
  a<n> jla;
  private final Object jlb;
  private final String videoPath;
  
  public e(String paramString, Surface paramSurface)
  {
    this.videoPath = paramString;
    this.avf = paramSurface;
    this.TAG = "MicroMsg.EmojiMixVideoDecoder";
    this.eIP = new MediaExtractor();
    this.jkV = "";
    this.jkW = 30000L;
    this.jkX = 10000L;
    this.jkY = 5;
    this.eIJ = new MediaCodec.BufferInfo();
    this.jlb = new Object();
    for (;;)
    {
      try
      {
        y.i(this.TAG, "create decoder with path: " + this.videoPath);
        this.eIP.setDataSource(this.videoPath);
        int k = this.eIP.getTrackCount();
        int j = 0;
        if (j < k)
        {
          paramString = this.eIP.getTrackFormat(j);
          paramSurface = paramString.getString("mime");
          g.j(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
          paramSurface = (CharSequence)paramSurface;
          Object localObject = (CharSequence)"video";
          g.k(paramSurface, "$receiver");
          g.k(localObject, "other");
          if ((localObject instanceof String))
          {
            if (a.h.e.b(paramSurface, (String)localObject, 0, 2) < 0) {
              break label374;
            }
            i = 1;
            if (i == 1)
            {
              paramSurface = paramString.getString("mime");
              g.j(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
              this.jkV = paramSurface;
              g.j(paramString, "trackFormat");
              this.eIG = paramString;
              paramString = this.TAG;
              paramSurface = new StringBuilder("find video format ");
              localObject = this.eIG;
              if (localObject == null) {
                g.ahh("mediaFormat");
              }
              y.i(paramString, localObject + ", mime: " + this.jkV);
              this.eIP.selectTrack(j);
            }
          }
          else
          {
            i = l.a(paramSurface, (CharSequence)localObject, 0, paramSurface.length());
            if (i >= 0)
            {
              i = 1;
              continue;
            }
            i = 0;
            continue;
          }
          j += 1;
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
      }
      label374:
      int i = 0;
    }
  }
  
  final boolean ST()
  {
    Object localObject1 = this.eIT;
    if (localObject1 == null) {
      g.ahh("decoder");
    }
    int i = ((MediaCodec)localObject1).dequeueOutputBuffer(this.eIJ, this.jkX);
    localObject1 = this.eIT;
    if (localObject1 == null) {
      g.ahh("decoder");
    }
    localObject1 = ((MediaCodec)localObject1).getOutputBuffers();
    if (i == -1) {
      y.d(this.TAG, "drainDecoder try again later");
    }
    label67:
    Object localObject4;
    for (;;)
    {
      return false;
      if (i != -2) {
        break;
      }
      localObject1 = this.TAG;
      ??? = new StringBuilder("drainDecoder output format change: ");
      localObject4 = this.eIT;
      if (localObject4 == null) {
        g.ahh("decoder");
      }
      y.i((String)localObject1, ((MediaCodec)localObject4).getOutputFormat());
      localObject1 = this.eIT;
      if (localObject1 == null) {
        g.ahh("decoder");
      }
      localObject1 = ((MediaCodec)localObject1).getOutputFormat();
      g.j(localObject1, "decoder.outputFormat");
      this.eIG = ((MediaFormat)localObject1);
    }
    if (i == -3)
    {
      ??? = this.eIT;
      if (??? == null) {
        g.ahh("decoder");
      }
      if (((MediaCodec)???).getOutputBuffers() == null) {
        break label646;
      }
      localObject1 = this.eIT;
      if (localObject1 == null) {
        g.ahh("decoder");
      }
      localObject1 = ((MediaCodec)localObject1).getOutputBuffers();
    }
    label646:
    for (;;)
    {
      ??? = this.eIT;
      if (??? == null) {
        g.ahh("decoder");
      }
      int j = ((MediaCodec)???).dequeueOutputBuffer(this.eIJ, this.jkX);
      i = j;
      if (j >= 0) {
        break;
      }
      break label67;
      if (i < 0)
      {
        y.i(this.TAG, "drainDecoder loop outputBufferIndex:" + i + ", break");
        break label67;
      }
      ??? = localObject1[i];
      long l = this.eIJ.presentationTimeUs;
      if ((this.eIJ.flags & 0x4) != 0)
      {
        y.i(this.TAG, "drainDecoder loop reach eof");
        localObject1 = this.eIT;
        if (localObject1 == null) {
          g.ahh("decoder");
        }
        ((MediaCodec)localObject1).releaseOutputBuffer(i, true);
        return true;
      }
      if ((??? != null) && (this.eIJ.size != 0))
      {
        ((ByteBuffer)???).position(this.eIJ.offset);
        ((ByteBuffer)???).limit(this.eIJ.offset + this.eIJ.size);
        ??? = this.eIT;
        if (??? == null) {
          g.ahh("decoder");
        }
        ((MediaCodec)???).releaseOutputBuffer(i, true);
        ??? = this.eIJ;
        y.i(this.TAG, "processDecodeBuffer pts: " + ((MediaCodec.BufferInfo)???).presentationTimeUs + ", size: " + ((MediaCodec.BufferInfo)???).size);
        localObject4 = this.jkZ;
        if (localObject4 != null) {
          ((b)localObject4).W(Long.valueOf(((MediaCodec.BufferInfo)???).presentationTimeUs * 1000L));
        }
        synchronized (this.jlb)
        {
          try
          {
            this.jlb.wait(50L);
            localObject4 = n.xoh;
            if ((this.eIJ.flags & 0x4) == 0) {
              continue;
            }
            try
            {
              localObject1 = this.eIT;
              if (localObject1 == null) {
                g.ahh("decoder");
              }
              ((MediaCodec)localObject1).stop();
              localObject1 = this.eIT;
              if (localObject1 == null) {
                g.ahh("decoder");
              }
              ((MediaCodec)localObject1).release();
            }
            catch (Exception localException1)
            {
              label582:
              break label582;
            }
            return true;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              y.printErrStackTrace(this.TAG, (Throwable)localException2, "", new Object[0]);
            }
          }
        }
      }
      else
      {
        ??? = this.eIT;
        if (??? == null) {
          g.ahh("decoder");
        }
        ((MediaCodec)???).releaseOutputBuffer(i, true);
        continue;
      }
    }
  }
  
  public final void aKk()
  {
    synchronized (this.jlb)
    {
      try
      {
        this.jlb.notifyAll();
        n localn = n.xoh;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  public final int init()
  {
    if ((((e)this).eIG != null) && (!bk.bl(this.jkV))) {
      try
      {
        MediaCodec localMediaCodec = MediaCodec.createDecoderByType(this.jkV);
        g.j(localMediaCodec, "MediaCodec.createDecoderByType(mime)");
        this.eIT = localMediaCodec;
        localMediaCodec = this.eIT;
        if (localMediaCodec == null) {
          g.ahh("decoder");
        }
        MediaFormat localMediaFormat = this.eIG;
        if (localMediaFormat == null) {
          g.ahh("mediaFormat");
        }
        localMediaCodec.configure(localMediaFormat, this.avf, null, 0);
        localMediaCodec = this.eIT;
        if (localMediaCodec == null) {
          g.ahh("decoder");
        }
        localMediaCodec.start();
        return 0;
      }
      catch (Exception localException)
      {
        y.e(this.TAG, "init decoder error " + localException.getMessage());
        return -1;
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.e
 * JD-Core Version:    0.7.0.1
 */