package com.tencent.mm.plugin.finder.utils;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/SimpleAudioExtractor;", "", "()V", "TAG", "", "extract", "", "src", "dest", "plugin-finder_release"})
public final class am
{
  public static final am waD;
  
  static
  {
    AppMethodBeat.i(253821);
    waD = new am();
    AppMethodBeat.o(253821);
  }
  
  public static boolean hi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253820);
    p.h(paramString1, "src");
    p.h(paramString2, "dest");
    for (;;)
    {
      long l1;
      c localc;
      Object localObject1;
      try
      {
        if (!s.YS(paramString1))
        {
          Log.i("MicroMsg.SimpleAudioExtractor", "src empty :".concat(String.valueOf(paramString1)));
          AppMethodBeat.o(253820);
          return false;
        }
        s.deleteFile(paramString2);
        s.bpa(paramString2);
        l1 = s.boW(paramString1);
        localc = new c();
        localc.setDataSource(paramString1);
        int j = localc.getTrackCount();
        i = 0;
        if (i >= j) {
          break label462;
        }
        localObject1 = localc.getTrackFormat(i);
        p.g(localObject1, "extractor.getTrackFormat(trackIndex)");
        localObject1 = ((MediaFormat)localObject1).getString("mime");
        p.g(localObject1, "mime");
        if (!n.a((CharSequence)localObject1, (CharSequence)"audio", false)) {
          break label467;
        }
        if (i == -1)
        {
          AppMethodBeat.o(253820);
          return false;
        }
        Object localObject2 = localc.getTrackFormat(i);
        p.g(localObject2, "extractor.getTrackFormat(audioIndex)");
        localObject1 = s.k(paramString2, true);
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = new MediaMuxer((String)localObject1, 0);
        ((MediaMuxer)localObject1).addTrack((MediaFormat)localObject2);
        ((MediaMuxer)localObject1).start();
        Log.i("MicroMsg.SimpleAudioExtractor", "[extract] src = " + paramString1 + ",length:" + l1);
        paramString1 = ByteBuffer.allocate(1048576);
        localc.selectTrack(i);
        l1 = System.currentTimeMillis();
        localObject2 = new MediaCodec.BufferInfo();
        i = localc.readSampleData(paramString1, 0);
        if (i >= 0)
        {
          ((MediaCodec.BufferInfo)localObject2).offset = 0;
          ((MediaCodec.BufferInfo)localObject2).size = i;
          ((MediaCodec.BufferInfo)localObject2).presentationTimeUs = localc.getSampleTime();
          ((MediaCodec.BufferInfo)localObject2).flags = localc.getSampleFlags();
          Log.d("MicroMsg.SimpleAudioExtractor", "extract audio pts:" + ((MediaCodec.BufferInfo)localObject2).presentationTimeUs);
          ((MediaMuxer)localObject1).writeSampleData(0, paramString1, (MediaCodec.BufferInfo)localObject2);
          localc.advance();
          continue;
        }
        ((MediaMuxer)localObject1).stop();
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.SimpleAudioExtractor", "extract aac error:" + paramString1.getMessage());
        AppMethodBeat.o(253820);
        return false;
      }
      ((MediaMuxer)localObject1).release();
      localc.release();
      long l2 = System.currentTimeMillis();
      long l3 = s.boW(paramString2);
      Log.d("MicroMsg.SimpleAudioExtractor", "extract aac success:" + paramString2 + ", length:" + l3 + ", cost:" + (l2 - l1) + "ms");
      AppMethodBeat.o(253820);
      return true;
      label462:
      int i = -1;
      continue;
      label467:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.am
 * JD-Core Version:    0.7.0.1
 */