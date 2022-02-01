package com.tencent.mm.ca.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mediabasic.data.MediaErrorInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaErrorInfo.a;
import com.tencent.mm.plugin.mediabasic.data.MediaSingleInfo;
import com.tencent.mm.plugin.mediabasic.data.c;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.d.d;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/remux/chain/VideoNotCropRemuxChain;", "Lcom/tencent/mm/remux/chain/AbsRemuxChain;", "()V", "TAG", "", "remuxImpl", "Lcom/tencent/mm/plugin/mediabasic/data/MediaErrorInfo;", "input", "Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;", "output", "Lcom/tencent/mm/plugin/mediabasic/data/MediaOutputInfo;", "(Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;Lcom/tencent/mm/plugin/mediabasic/data/MediaOutputInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-remux_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  private final String TAG = "MicroMsg.VideoNotCropRemuxChain";
  
  protected final Object b(com.tencent.mm.plugin.mediabasic.data.b paramb, c paramc, d<? super MediaErrorInfo> paramd)
  {
    AppMethodBeat.i(231824);
    paramb = f.aVX(((MediaSingleInfo)p.oK((List)paramb.KOI)).path);
    int i;
    int k;
    int j;
    if (paramb != null)
    {
      i = paramb.width;
      k = paramb.height;
      if ((paramb.hYK != 90) && (paramb.hYK != 270)) {
        break label180;
      }
      j = 1;
      if (j != 0)
      {
        i = paramb.height;
        k = paramb.width;
      }
      if (i <= k) {
        break label186;
      }
      j = k.qv(i, paramc.nLH.height);
      i = paramb.height * j / i;
      paramc.nLH.width = j;
      paramc.nLH.height = i;
      Log.i(this.TAG, "VideoNotCropRemuxChain make size:" + j + ' ' + i);
    }
    for (;;)
    {
      paramb = MediaErrorInfo.KOF;
      paramb = MediaErrorInfo.a.gaF();
      AppMethodBeat.o(231824);
      return paramb;
      label180:
      j = 0;
      break;
      label186:
      j = k.qv(k, paramc.nLH.height);
      i = i * j / k;
      paramc.nLH.width = i;
      paramc.nLH.height = j;
      Log.i(this.TAG, "VideoNotCropRemuxChain make size:" + i + ' ' + j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ca.b.e
 * JD-Core Version:    0.7.0.1
 */