package com.tencent.mm.ca.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mediabasic.data.MediaErrorInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaErrorInfo.a;
import com.tencent.mm.plugin.mediabasic.data.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/remux/chain/AbsRemuxChain;", "Lcom/tencent/mm/remux/chain/IRemuxChain;", "()V", "nextChain", "remux", "Lcom/tencent/mm/plugin/mediabasic/data/MediaErrorInfo;", "input", "Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;", "output", "Lcom/tencent/mm/plugin/mediabasic/data/MediaOutputInfo;", "(Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;Lcom/tencent/mm/plugin/mediabasic/data/MediaOutputInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remuxImpl", "setNextRemuxChain", "chain", "plugin-remux_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements b
{
  b aclj;
  
  public final b a(b paramb)
  {
    s.u(paramb, "chain");
    if (this.aclj == null)
    {
      this.aclj = paramb;
      return (b)this;
    }
    b localb = this.aclj;
    if (localb != null) {
      localb.a(paramb);
    }
    return (b)this;
  }
  
  public final Object a(com.tencent.mm.plugin.mediabasic.data.b paramb, c paramc, kotlin.d.d<? super MediaErrorInfo> paramd)
  {
    return a(this, paramb, paramc, paramd);
  }
  
  protected abstract Object b(com.tencent.mm.plugin.mediabasic.data.b paramb, c paramc, kotlin.d.d<? super MediaErrorInfo> paramd);
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mediabasic/data/MediaErrorInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super MediaErrorInfo>, Object>
  {
    int label;
    
    a(a parama, com.tencent.mm.plugin.mediabasic.data.b paramb, c paramc, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(231825);
      paramObject = (kotlin.d.d)new a(this.aclk, this.acll, this.aclm, paramd);
      AppMethodBeat.o(231825);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      int i = 1;
      AppMethodBeat.i(231821);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      c localc;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(231821);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.aclk;
        localObject = this.acll;
        localc = this.aclm;
        locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = paramObject.b((com.tencent.mm.plugin.mediabasic.data.b)localObject, localc, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(231821);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (MediaErrorInfo)paramObject;
        if (paramObject.KOG == com.tencent.mm.plugin.mediabasic.data.d.KOR)
        {
          if (i == 0) {
            break label251;
          }
          paramObject = this.aclk.aclj;
          if (paramObject != null) {
            break label182;
          }
        }
        break;
      }
      for (paramObject = null;; paramObject = (MediaErrorInfo)paramObject)
      {
        if (paramObject != null) {
          break label244;
        }
        paramObject = MediaErrorInfo.KOF;
        paramObject = MediaErrorInfo.a.cn(-1, "no chain handle video remux");
        AppMethodBeat.o(231821);
        return paramObject;
        i = 0;
        break;
        label182:
        localObject = this.acll;
        localc = this.aclm;
        locald = (kotlin.d.d)this;
        this.label = 2;
        localObject = paramObject.a((com.tencent.mm.plugin.mediabasic.data.b)localObject, localc, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(231821);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
      }
      label244:
      AppMethodBeat.o(231821);
      return paramObject;
      label251:
      AppMethodBeat.o(231821);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ca.b.a
 * JD-Core Version:    0.7.0.1
 */