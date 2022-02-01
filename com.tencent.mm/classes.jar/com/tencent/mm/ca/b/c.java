package com.tencent.mm.ca.b;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mediabasic.data.MediaDurationInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaErrorInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaErrorInfo.a;
import com.tencent.mm.plugin.mediabasic.data.MediaSingleInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.j.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/remux/chain/VideoCompositionRemuxChain;", "Lcom/tencent/mm/remux/chain/AbsRemuxChain;", "()V", "remuxImpl", "Lcom/tencent/mm/plugin/mediabasic/data/MediaErrorInfo;", "input", "Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;", "output", "Lcom/tencent/mm/plugin/mediabasic/data/MediaOutputInfo;", "(Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;Lcom/tencent/mm/plugin/mediabasic/data/MediaOutputInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-remux_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public static final c.a acln;
  
  static
  {
    AppMethodBeat.i(231823);
    acln = new c.a((byte)0);
    AppMethodBeat.o(231823);
  }
  
  protected final Object b(com.tencent.mm.plugin.mediabasic.data.b paramb, final com.tencent.mm.plugin.mediabasic.data.c paramc, d<? super MediaErrorInfo> paramd)
  {
    AppMethodBeat.i(231828);
    paramb = l.a((kotlin.d.f)bg.kCi(), (m)new b(paramb, paramc, null), paramd);
    AppMethodBeat.o(231828);
    return paramb;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mediabasic/data/MediaErrorInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super MediaErrorInfo>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    b(com.tencent.mm.plugin.mediabasic.data.b paramb, com.tencent.mm.plugin.mediabasic.data.c paramc, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(231831);
      paramObject = (d)new b(this.acll, paramc, paramd);
      AppMethodBeat.o(231831);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(231827);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(231827);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject4 = this.acll;
        Object localObject2 = paramc;
        this.L$0 = localObject4;
        this.Uf = localObject2;
        this.label = 1;
        paramObject = new h(kotlin.d.a.b.au((d)this));
        Object localObject1 = (d)paramObject;
        Object localObject3 = new ArrayList();
        localObject4 = ((Iterable)((com.tencent.mm.plugin.mediabasic.data.b)localObject4).KOI).iterator();
        Object localObject6;
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (MediaSingleInfo)((Iterator)localObject4).next();
          localObject6 = ((MediaSingleInfo)localObject5).KON;
          if (b.$EnumSwitchMapping$0[localObject6.ordinal()] == 1)
          {
            localObject6 = new com.tencent.mm.videocomposition.b(((MediaSingleInfo)localObject5).path, 2);
            ((com.tencent.mm.videocomposition.b)localObject6).setVolume(1.0F);
            ((com.tencent.mm.videocomposition.b)localObject6).wB(((MediaSingleInfo)localObject5).KOO.startMs);
            ((com.tencent.mm.videocomposition.b)localObject6).wC(Math.min(((MediaSingleInfo)localObject5).KOO.endMs, ((com.tencent.mm.videocomposition.b)localObject6).UjZ));
            ((com.tencent.mm.videocomposition.b)localObject6).setStartTimeMs(0L);
            ((com.tencent.mm.videocomposition.b)localObject6).wA(((com.tencent.mm.videocomposition.b)localObject6).TDx - ((com.tencent.mm.videocomposition.b)localObject6).TDw);
            ((ArrayList)localObject3).add(localObject6);
          }
        }
        localObject4 = new com.tencent.mm.videocomposition.j((List)localObject3);
        ((com.tencent.mm.videocomposition.j)localObject4).agDT = ((com.tencent.mm.videocomposition.a.b)new com.tencent.mm.videocomposition.a.a((com.tencent.mm.videocomposition.a.c)new com.tencent.mm.ca.a.a(((com.tencent.mm.plugin.mediabasic.data.c)localObject2).nLH.audioSampleRate, ((com.tencent.mm.plugin.mediabasic.data.c)localObject2).nLH.audioChannelCount)));
        Object localObject5 = com.tencent.mm.plugin.sight.base.f.aVY(((com.tencent.mm.videocomposition.b)((ArrayList)localObject3).get(0)).path);
        if (localObject5 == null)
        {
          localObject2 = MediaErrorInfo.KOF;
          localObject2 = MediaErrorInfo.a.cn(-1, "remux error");
          localObject3 = Result.Companion;
          ((d)localObject1).resumeWith(Result.constructor-impl(localObject2));
          localObject1 = paramObject.kli();
          if (localObject1 == kotlin.d.a.a.aiwj) {
            s.u((d)this, "frame");
          }
          paramObject = localObject1;
          if (localObject1 == locala)
          {
            AppMethodBeat.o(231827);
            return locala;
          }
        }
        else
        {
          int i;
          if ((((com.tencent.mm.plugin.sight.base.b)localObject5).hYK == 0) || (((com.tencent.mm.plugin.sight.base.b)localObject5).hYK == 180))
          {
            i = ((com.tencent.mm.plugin.sight.base.b)localObject5).width;
            if ((((com.tencent.mm.plugin.sight.base.b)localObject5).hYK != 0) && (((com.tencent.mm.plugin.sight.base.b)localObject5).hYK != 180)) {
              break label657;
            }
          }
          label657:
          for (int j = ((com.tencent.mm.plugin.sight.base.b)localObject5).height;; j = ((com.tencent.mm.plugin.sight.base.b)localObject5).width)
          {
            ((com.tencent.mm.videocomposition.j)localObject4).pk(i, j);
            ((com.tencent.mm.videocomposition.j)localObject4).L(new Rect(0, 0, i, j));
            ((com.tencent.mm.videocomposition.j)localObject4).FO(true);
            localObject5 = new j.b(new Size(((com.tencent.mm.plugin.mediabasic.data.c)localObject2).nLH.width, ((com.tencent.mm.plugin.mediabasic.data.c)localObject2).nLH.height), ((com.tencent.mm.plugin.mediabasic.data.c)localObject2).nLH.videoBitrate, ((com.tencent.mm.plugin.mediabasic.data.c)localObject2).nLH.fps, ((com.tencent.mm.plugin.mediabasic.data.c)localObject2).nLH.nCd, ((com.tencent.mm.plugin.mediabasic.data.c)localObject2).nLH.audioBitrate, ((com.tencent.mm.plugin.mediabasic.data.c)localObject2).nLH.audioSampleRate, ((com.tencent.mm.plugin.mediabasic.data.c)localObject2).nLH.audioChannelCount, true, false, (byte)0);
            localObject6 = com.tencent.mm.util.j.agtw;
            com.tencent.mm.util.j.a(((com.tencent.mm.videocomposition.b)((ArrayList)localObject3).get(0)).path, (j.b)localObject5);
            localObject1 = (m)new a(Util.currentTicks(), new ah.a(), (com.tencent.mm.videocomposition.j)localObject4, (d)localObject1);
            localObject2 = ((com.tencent.mm.plugin.mediabasic.data.c)localObject2).getVideoPath();
            s.checkNotNull(localObject2);
            com.tencent.mm.videocomposition.j.a((com.tencent.mm.videocomposition.j)localObject4, (String)localObject2, (j.b)localObject5, (m)localObject1);
            break;
            i = ((com.tencent.mm.plugin.sight.base.b)localObject5).height;
            break label436;
          }
        }
        break;
      case 1: 
        label436:
        ResultKt.throwOnFailure(paramObject);
      }
      AppMethodBeat.o(231827);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<Boolean, Integer, ah>
    {
      a(long paramLong, ah.a parama, com.tencent.mm.videocomposition.j paramj, d<? super MediaErrorInfo> paramd)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ca.b.c
 * JD-Core Version:    0.7.0.1
 */