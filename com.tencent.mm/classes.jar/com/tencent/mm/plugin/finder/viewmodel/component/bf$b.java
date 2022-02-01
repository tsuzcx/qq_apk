package com.tencent.mm.plugin.finder.viewmodel.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class bf$b
  extends k
  implements m<kotlinx.coroutines.aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  bf$b(bf parambf, boolean paramBoolean, kotlin.d.d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(337652);
    paramObject = (kotlin.d.d)new b(this.GWl, this.GWm, paramd);
    AppMethodBeat.o(337652);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    boolean bool2 = false;
    AppMethodBeat.i(337646);
    Object localObject = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(337646);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = this.GWl;
    boolean bool1 = this.GWm;
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    int j = ((Number)com.tencent.mm.plugin.finder.storage.d.eWN().bmg()).intValue();
    if (j == 0) {
      Log.i("FinderWifiHintUIC", "[checkShowNotWifiHint]: timesLimit is 0, hint not show");
    }
    for (;;)
    {
      paramObject = ah.aiuX;
      AppMethodBeat.o(337646);
      return paramObject;
      if (NetStatusUtil.isMobile(MMApplicationContext.getContext())) {
        break;
      }
      Log.i("FinderWifiHintUIC", "[checkShowNotWifiHint]: is not mobile data");
    }
    label177:
    label227:
    int i;
    if (bool1)
    {
      if (j == 2147483647)
      {
        Log.i("FinderWifiHintUIC", "[checkShowNotWifiHint]: timesLimit is Int.MAX_VALUE");
        h.baE().ban().set(at.a.adeD, Integer.valueOf(0));
        h.baE().ban().set(at.a.adeE, Long.valueOf(0L));
      }
    }
    else
    {
      localObject = new ah.d();
      ((ah.d)localObject).aixb = e.h.finder_not_wifi_hint;
      j = ((com.tencent.mm.plugin.misc.a.a)h.ax(com.tencent.mm.plugin.misc.a.a.class)).gbv();
      if (!((com.tencent.mm.plugin.misc.a.a)h.ax(com.tencent.mm.plugin.misc.a.a.class) instanceof com.tencent.mm.plugin.misc.b.b)) {
        break label482;
      }
      bool1 = com.tencent.mm.plugin.misc.b.b.gbx();
      if (!bool1) {
        break label493;
      }
      if (j != 0) {
        break label488;
      }
      i = h.baE().ban().getInt(at.a.adeF, 0);
    }
    for (;;)
    {
      bool1 = bool2;
      if (i == 3) {
        bool1 = true;
      }
      Log.i("FinderWifiHintUIC", "[isFreeSimCard] result: " + bool1 + ", wkType: " + i + " getWkType:" + j);
      if (bool1) {
        ((ah.d)localObject).aixb = e.h.finder_da_wang_card_hint;
      }
      j.a(paramObject.getMainScope(), null, null, (m)new bf.e(paramObject, (ah.d)localObject, 3000L, null), 3);
      break;
      i = h.baE().ban().getInt(at.a.adeD, 0);
      long l1 = h.baE().ban().a(at.a.adeE, 0L);
      long l2 = System.currentTimeMillis();
      bool1 = Util.isSameDay(l1, l2);
      if (!bool1) {
        i = 0;
      }
      Log.i("FinderWifiHintUIC", "[checkShowNotWifiHint]: shownTimes = " + i + ", timesLimit = " + j + ", isSameDay = " + bool1);
      if (i >= j) {
        break;
      }
      h.baE().ban().set(at.a.adeE, Long.valueOf(l2));
      h.baE().ban().set(at.a.adeD, Integer.valueOf(i + 1));
      break label177;
      label482:
      bool1 = false;
      break label227;
      label488:
      i = j;
      continue;
      label493:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.bf.b
 * JD-Core Version:    0.7.0.1
 */