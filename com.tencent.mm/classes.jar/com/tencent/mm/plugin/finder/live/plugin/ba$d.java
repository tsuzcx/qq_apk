package com.tencent.mm.plugin.finder.live.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.cgi.r;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class ba$d
  extends kotlin.d.b.a.k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  ba$d(Integer paramInteger, ba paramba, d<? super d> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(356117);
    paramObject = (d)new d(this.Der, this.Dem, paramd);
    AppMethodBeat.o(356117);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    boolean bool2 = false;
    AppMethodBeat.i(356111);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(356111);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
    }
    for (;;)
    {
      try
      {
        i = this.Der.intValue();
        long l = ((f)this.Dem.business(f.class)).hKN;
        paramObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramObject == null)
        {
          paramObject = null;
          paramObject = com.tencent.mm.bx.b.cX(paramObject);
          localObject = z.bAW();
          s.s(localObject, "getMyFinderUsername()");
          paramObject = (com.tencent.mm.am.b)new r(i, l, paramObject, (String)localObject);
          localObject = (d)this;
          this.label = 1;
          paramObject = com.tencent.mm.af.b.a(paramObject, (d)localObject);
          localObject = paramObject;
          if (paramObject == locala)
          {
            AppMethodBeat.o(356111);
            return locala;
          }
        }
        else
        {
          paramObject = (f)paramObject.business(f.class);
          if (paramObject == null)
          {
            paramObject = null;
            continue;
          }
          paramObject = paramObject.mZp;
          continue;
          ResultKt.throwOnFailure(paramObject);
          localObject = paramObject;
        }
        paramObject = (bff)localObject;
        Log.i("FinderLiveLotteryBubblePlugin", s.X("#finallyRequestAttendLotteryWithFollowCondition resp ", Integer.valueOf(paramObject.ZPl)));
        boolean bool3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.Dem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).isRunning();
        Object localObject = aj.CGT;
        localObject = aj.elL();
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
          if ((localObject != null) && (((i)localObject).bep() == true))
          {
            i = 1;
            localObject = new StringBuilder("finallyRequestAttendLotteryWithFollowCondition isRunning:");
            if (!bool3) {
              break label435;
            }
            bool1 = true;
            localObject = ((StringBuilder)localObject).append(bool1).append(",normalMode:");
            bool1 = bool2;
            if (i != 0) {
              bool1 = true;
            }
            Log.i("FinderLiveLotteryBubblePlugin", bool1);
            if ((bool3) && (paramObject.ZPl == 1))
            {
              if (i == 0) {
                break label440;
              }
              ba.a(this.Dem);
            }
            paramObject = ah.aiuX;
            AppMethodBeat.o(356111);
            return paramObject;
          }
        }
      }
      catch (com.tencent.mm.af.a paramObject)
      {
        Log.i("FinderLiveLotteryBubblePlugin", "#finallyRequestAttendLotteryWithFollowCondition errorCode=" + paramObject.errorCode + " errorType=" + paramObject.hDx + " error.message " + paramObject.getMessage());
        paramObject = ah.aiuX;
        AppMethodBeat.o(356111);
        return paramObject;
      }
      int i = 0;
      continue;
      label435:
      boolean bool1 = false;
      continue;
      label440:
      paramObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.Dem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
      paramObject.Egv = paramObject.Egp;
      Log.i("MMFinder.LiveLotterySlice", s.X("cacheLotteryInfo:", paramObject.Egv));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ba.d
 * JD-Core Version:    0.7.0.1
 */