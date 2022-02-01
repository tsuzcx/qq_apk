package com.tencent.mm.ca.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mediabasic.data.MediaDurationInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaErrorInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaErrorInfo.a;
import com.tencent.mm.plugin.mediabasic.data.MediaSingleInfo;
import com.tencent.mm.plugin.mediabasic.data.c;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/remux/chain/VideoJumpRemuxChain;", "Lcom/tencent/mm/remux/chain/AbsRemuxChain;", "()V", "checkSingleVideo", "", "info", "Lcom/tencent/mm/plugin/mediabasic/data/MediaSingleInfo;", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "remuxImpl", "Lcom/tencent/mm/plugin/mediabasic/data/MediaErrorInfo;", "input", "Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;", "output", "Lcom/tencent/mm/plugin/mediabasic/data/MediaOutputInfo;", "(Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;Lcom/tencent/mm/plugin/mediabasic/data/MediaOutputInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-remux_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public static final d.a aclo;
  
  static
  {
    AppMethodBeat.i(231820);
    aclo = new d.a((byte)0);
    AppMethodBeat.o(231820);
  }
  
  protected final Object b(com.tencent.mm.plugin.mediabasic.data.b paramb, c paramc, kotlin.d.d<? super MediaErrorInfo> paramd)
  {
    AppMethodBeat.i(231826);
    int i = 0;
    paramd = ((Iterable)paramb.KOI).iterator();
    while (paramd.hasNext())
    {
      Object localObject = (MediaSingleInfo)paramd.next();
      if (((MediaSingleInfo)localObject).KON != com.tencent.mm.plugin.mediabasic.data.a.KOz)
      {
        Log.i("MicroMsg.VideoJumpRemuxChain", "refuse by audio or image");
        paramb = MediaErrorInfo.KOF;
        paramb = MediaErrorInfo.a.gaF();
        AppMethodBeat.o(231826);
        return paramb;
      }
      int j = i;
      if (((MediaSingleInfo)localObject).KON == com.tencent.mm.plugin.mediabasic.data.a.KOz)
      {
        j = i + 1;
        if (j > 1)
        {
          Log.i("MicroMsg.VideoJumpRemuxChain", "refuse by multi video");
          paramb = MediaErrorInfo.KOF;
          paramb = MediaErrorInfo.a.gaF();
          AppMethodBeat.o(231826);
          return paramb;
        }
        VideoTransPara localVideoTransPara = paramc.nLH;
        if (((MediaSingleInfo)localObject).KOO.startMs > 0L)
        {
          Log.i("MicroMsg.VideoJumpRemuxChain", "refuse by video crop");
          i = 0;
        }
        while (i == 0)
        {
          paramb = MediaErrorInfo.KOF;
          paramb = MediaErrorInfo.a.gaF();
          AppMethodBeat.o(231826);
          return paramb;
          localObject = f.aVX(((MediaSingleInfo)localObject).path);
          if (((com.tencent.mm.plugin.sight.base.b)localObject).videoDuration > localVideoTransPara.duration * 1000)
          {
            Log.i("MicroMsg.VideoJumpRemuxChain", "refuse by video crop");
            i = 0;
          }
          else if ((((com.tencent.mm.plugin.sight.base.b)localObject).width > localVideoTransPara.width + 50) || (((com.tencent.mm.plugin.sight.base.b)localObject).height > localVideoTransPara.height + 50))
          {
            Log.i("MicroMsg.VideoJumpRemuxChain", "refuse by video size limit");
            i = 0;
          }
          else if (((com.tencent.mm.plugin.sight.base.b)localObject).videoBitrate > localVideoTransPara.videoBitrate * 1.2D)
          {
            Log.i("MicroMsg.VideoJumpRemuxChain", "refuse by video bitrate limit");
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
      }
      i = j;
    }
    y.O(((MediaSingleInfo)p.oK((List)paramb.KOI)).path, paramc.getVideoPath(), false);
    paramb = MediaErrorInfo.KOF;
    paramb = MediaErrorInfo.a.cn(0, "jump remux");
    AppMethodBeat.o(231826);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ca.b.d
 * JD-Core Version:    0.7.0.1
 */