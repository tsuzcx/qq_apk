package com.tencent.mm.plugin.finder.live.olympic;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.live.olympic.certificate.data.a.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e;
import com.tencent.mm.plugin.finder.utils.bi;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.dz;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ay;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$c
  extends kotlin.d.b.a.k
  implements m<aq, d<? super Object>, Object>
{
  Object L$0;
  int label;
  
  c$c(c paramc, ay<ah> paramay, String paramString, boolean paramBoolean1, boolean paramBoolean2, d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(360363);
    paramObject = (d)new c(this.CNu, this.CNv, this.CNw, this.CNx, this.CNy, paramd);
    AppMethodBeat.o(360363);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(360355);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(360355);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
    }
    label513:
    label529:
    for (;;)
    {
      int i;
      boolean bool2;
      boolean bool3;
      boolean bool1;
      try
      {
        paramObject = (n.e)((n)this.CNu.getBuContext().business(n.class)).Ehd.getValue();
        Object localObject2;
        if ((paramObject != null) && (paramObject.EhI == true))
        {
          i = 1;
          break label497;
          Log.i("FinderLiveOlympicCardPl", s.X("addTorchLive ", Boolean.valueOf(bool2)));
          paramObject = com.tencent.mm.ui.component.k.aeZF;
          g localg = (g)com.tencent.mm.ui.component.k.cn(cn.class).cq(g.class);
          localObject1 = com.tencent.mm.plugin.finder.live.olympic.certificate.data.a.CPi;
          paramObject = bi.GlP;
          localObject2 = new dz();
          paramObject = this.CNu;
          String str = this.CNw;
          bool2 = this.CNx;
          bool3 = this.CNy;
          paramObject = ((n)paramObject.getBuContext().business(n.class)).Ehe;
          if (paramObject == null)
          {
            paramObject = null;
            ((dz)localObject2).YGd = paramObject;
            ((dz)localObject2).name = str;
            if (!bool2) {
              break label529;
            }
            bool2 = true;
            ((dz)localObject2).YGe = bool2;
            if (!bool1) {
              break label513;
            }
            ((dz)localObject2).longitude = ((Number)localg.dUh().bsC).floatValue();
            ((dz)localObject2).latitude = ((Number)localg.dUh().bsD).floatValue();
            break label513;
            ((dz)localObject2).YGf = bool1;
            paramObject = ah.aiuX;
            paramObject = (d)this;
            this.L$0 = localObject1;
            this.label = 2;
            paramObject = bi.a((dz)localObject2, paramObject);
            localObject1 = paramObject;
            if (paramObject != locala) {
              continue;
            }
            AppMethodBeat.o(360355);
            return locala;
          }
        }
        else
        {
          i = 0;
          break label497;
          paramObject = this.CNu;
          localObject1 = this.CNv;
          localObject2 = (d)this;
          this.label = 1;
          paramObject = c.a(paramObject, (ay)localObject1, (d)localObject2);
          localObject1 = paramObject;
          if (paramObject == locala)
          {
            AppMethodBeat.o(360355);
            return locala;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
          }
          bool1 = ((Boolean)localObject1).booleanValue();
          break label503;
        }
        paramObject = paramObject.finderUsername;
        continue;
        ResultKt.throwOnFailure(paramObject);
        Object localObject1 = paramObject;
        localObject1 = (ea)localObject1;
        if (localObject1 == null)
        {
          paramObject = null;
          if (paramObject == null)
          {
            AppMethodBeat.o(360355);
            return null;
          }
        }
        else
        {
          paramObject = ((ea)localObject1).YGh;
          continue;
        }
        paramObject = ((ea)localObject1).YGh;
        s.checkNotNull(paramObject);
        s.s(paramObject, "respose.torch_cert!!");
        paramObject = new com.tencent.mm.plugin.finder.live.olympic.certificate.data.a(a.a.a(paramObject), ((ea)localObject1).YGi);
        AppMethodBeat.o(360355);
        return paramObject;
      }
      catch (o paramObject)
      {
        AppMethodBeat.o(360355);
        return paramObject;
      }
      label497:
      if (i != 0)
      {
        bool1 = false;
        label503:
        if (bool1)
        {
          bool2 = true;
          continue;
          if (bool3)
          {
            bool1 = true;
            continue;
          }
        }
        else
        {
          bool2 = false;
          continue;
          bool2 = false;
          continue;
        }
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.c.c
 * JD-Core Version:    0.7.0.1
 */