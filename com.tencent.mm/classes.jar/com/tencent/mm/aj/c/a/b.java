package com.tencent.mm.aj.c.a;

import androidx.compose.a.a.u;
import androidx.compose.a.a.w;
import androidx.compose.foundation.lazy.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.q;
import kotlin.g.b.s;
import kotlin.h.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/widget/page_snapper/LazyListSnapperLayoutInfo;", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutInfo;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "snapOffsetForItem", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "layoutInfo", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutItemInfo;", "item", "", "endContentPadding", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function2;I)V", "currentItem", "getCurrentItem", "()Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutItemInfo;", "<set-?>", "getEndContentPadding$compose_base_release", "()I", "setEndContentPadding$compose_base_release", "(I)V", "endContentPadding$delegate", "Landroidx/compose/runtime/MutableState;", "endScrollOffset", "getEndScrollOffset", "itemCount", "getItemCount", "startScrollOffset", "getStartScrollOffset", "visibleItems", "Lkotlin/sequences/Sequence;", "getVisibleItems", "()Lkotlin/sequences/Sequence;", "calculateItemSpacing", "canScrollTowardsEnd", "", "canScrollTowardsStart", "determineTargetIndex", "velocity", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "maximumFlingDistance", "distanceToIndexSnap", "index", "estimateDistancePerItem", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends h
{
  private final aa afi;
  private final kotlin.g.a.m<h, i, Integer> ohq;
  private final int ohr;
  private final an ohs;
  
  private b(aa paramaa, kotlin.g.a.m<? super h, ? super i, Integer> paramm)
  {
    AppMethodBeat.i(238865);
    this.afi = paramaa;
    this.ohq = paramm;
    this.ohs = bj.T(Integer.valueOf(0));
    AppMethodBeat.o(238865);
  }
  
  private kotlin.m.h<i> bzb()
  {
    AppMethodBeat.i(238875);
    kotlin.m.h localh = kotlin.m.k.d(kotlin.a.p.A((Iterable)this.afi.mQ().mE()), (kotlin.g.a.b)a.oht);
    AppMethodBeat.o(238875);
    return localh;
  }
  
  private final int bze()
  {
    AppMethodBeat.i(238879);
    androidx.compose.foundation.lazy.p localp = this.afi.mQ();
    if (localp.mE().size() >= 2)
    {
      androidx.compose.foundation.lazy.m localm = (androidx.compose.foundation.lazy.m)localp.mE().get(0);
      int i = ((androidx.compose.foundation.lazy.m)localp.mE().get(1)).getOffset();
      int j = localm.getSize();
      int k = localm.getOffset();
      AppMethodBeat.o(238879);
      return i - (k + j);
    }
    AppMethodBeat.o(238879);
    return 0;
  }
  
  private final float bzf()
  {
    AppMethodBeat.i(238885);
    androidx.compose.foundation.lazy.p localp = this.afi.mQ();
    if (localp.mE().isEmpty())
    {
      AppMethodBeat.o(238885);
      return -1.0F;
    }
    Object localObject3 = ((Iterable)localp.mE()).iterator();
    Object localObject1;
    if (!((Iterator)localObject3).hasNext()) {
      localObject1 = null;
    }
    do
    {
      localObject3 = (androidx.compose.foundation.lazy.m)localObject1;
      if (localObject3 != null) {
        break;
      }
      AppMethodBeat.o(238885);
      return -1.0F;
      localObject1 = ((Iterator)localObject3).next();
    } while (!((Iterator)localObject3).hasNext());
    int i = ((androidx.compose.foundation.lazy.m)localObject1).getOffset();
    label120:
    Object localObject2 = ((Iterator)localObject3).next();
    int j = ((androidx.compose.foundation.lazy.m)localObject2).getOffset();
    if (i > j)
    {
      localObject1 = localObject2;
      i = j;
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext())
      {
        break;
        Iterator localIterator = ((Iterable)localp.mE()).iterator();
        if (!localIterator.hasNext()) {
          localObject1 = null;
        }
        do
        {
          localObject1 = (androidx.compose.foundation.lazy.m)localObject1;
          if (localObject1 != null) {
            break;
          }
          AppMethodBeat.o(238885);
          return -1.0F;
          localObject1 = localIterator.next();
        } while (!localIterator.hasNext());
        localObject2 = (androidx.compose.foundation.lazy.m)localObject1;
        i = ((androidx.compose.foundation.lazy.m)localObject2).getOffset() + ((androidx.compose.foundation.lazy.m)localObject2).getSize();
        label259:
        localObject2 = localIterator.next();
        androidx.compose.foundation.lazy.m localm = (androidx.compose.foundation.lazy.m)localObject2;
        j = localm.getOffset();
        j = localm.getSize() + j;
        if (i < j)
        {
          localObject1 = localObject2;
          i = j;
        }
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            break;
            i = Math.min(((androidx.compose.foundation.lazy.m)localObject3).getOffset(), ((androidx.compose.foundation.lazy.m)localObject1).getOffset());
            j = ((androidx.compose.foundation.lazy.m)localObject3).getOffset();
            int k = ((androidx.compose.foundation.lazy.m)localObject3).getSize();
            int m = ((androidx.compose.foundation.lazy.m)localObject1).getOffset();
            i = Math.max(k + j, ((androidx.compose.foundation.lazy.m)localObject1).getSize() + m) - i;
            if (i == 0)
            {
              AppMethodBeat.o(238885);
              return -1.0F;
            }
            float f = (i + bze()) / localp.mE().size();
            AppMethodBeat.o(238885);
            return f;
          }
          break label259;
        }
      }
      break label120;
    }
  }
  
  private final int getItemCount()
  {
    AppMethodBeat.i(238872);
    int i = this.afi.mQ().mG();
    AppMethodBeat.o(238872);
    return i;
  }
  
  public final int a(float paramFloat1, u<Float> paramu, float paramFloat2)
  {
    AppMethodBeat.i(238908);
    s.u(paramu, "decayAnimationSpec");
    i locali = bza();
    if (locali == null)
    {
      AppMethodBeat.o(238908);
      return -1;
    }
    float f3 = bzf();
    if (f3 <= 0.0F)
    {
      i = locali.getIndex();
      AppMethodBeat.o(238908);
      return i;
    }
    float f4 = kotlin.k.k.C(w.a(paramu, paramFloat1), -paramFloat2, paramFloat2);
    int i = uQ(locali.getIndex() + 1);
    int j = uQ(locali.getIndex());
    if (((f4 >= 0.0F) && (f4 < i)) || ((f4 < 0.0F) && (f4 > j)))
    {
      if (i < -j)
      {
        i = kotlin.k.k.bQ(locali.getIndex() + 1, 0, getItemCount() - 1);
        AppMethodBeat.o(238908);
        return i;
      }
      i = locali.getIndex();
      AppMethodBeat.o(238908);
      return i;
    }
    float f2;
    float f1;
    if (paramFloat1 > 0.0F)
    {
      f2 = (f4 - i) / f3;
      f1 = f2;
      if (!Float.isNaN(f2))
      {
        if (!Float.isInfinite(f2)) {
          break label331;
        }
        f1 = f2;
      }
      label217:
      if (paramFloat1 <= 0.0F) {
        break label362;
      }
    }
    label331:
    label362:
    for (i = (int)f1 + 1;; i = (int)f1)
    {
      Log.i("SnapperLazyList", "current item: " + locali + ", distancePerChild: " + f3 + ", maximumFlingDistance: " + paramFloat2 + ", flingDistance: " + f4 + ", indexDelta: " + i);
      i = kotlin.k.k.bQ(i + locali.getIndex(), 0, getItemCount() - 1);
      AppMethodBeat.o(238908);
      return i;
      i = j;
      break;
      if (f2 > 0.0F)
      {
        f1 = (float)Math.floor(f2);
        break label217;
      }
      f1 = (float)Math.ceil(f2);
      break label217;
    }
  }
  
  public final int byY()
  {
    return this.ohr;
  }
  
  public final int byZ()
  {
    AppMethodBeat.i(238889);
    int i = this.afi.mQ().mF();
    int j = ((Number)((bm)this.ohs).getValue()).intValue();
    AppMethodBeat.o(238889);
    return i - j;
  }
  
  public final i bza()
  {
    AppMethodBeat.i(238892);
    Object localObject2 = bzb();
    Object localObject1 = null;
    Iterator localIterator = ((kotlin.m.h)localObject2).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      i locali = (i)localObject2;
      if (locali.getOffset() <= ((Number)this.ohq.invoke(this, locali)).intValue())
      {
        i = 1;
        label73:
        if (i == 0) {
          break label100;
        }
        localObject1 = localObject2;
      }
    }
    label100:
    for (;;)
    {
      break;
      i = 0;
      break label73;
      localObject1 = (i)localObject1;
      AppMethodBeat.o(238892);
      return localObject1;
    }
  }
  
  public final boolean bzc()
  {
    AppMethodBeat.i(238899);
    androidx.compose.foundation.lazy.m localm = (androidx.compose.foundation.lazy.m)kotlin.a.p.oL(this.afi.mQ().mE());
    if (localm == null)
    {
      AppMethodBeat.o(238899);
      return false;
    }
    if ((localm.getIndex() > 0) || (localm.getOffset() < this.ohr))
    {
      AppMethodBeat.o(238899);
      return true;
    }
    AppMethodBeat.o(238899);
    return false;
  }
  
  public final boolean bzd()
  {
    AppMethodBeat.i(238902);
    androidx.compose.foundation.lazy.m localm = (androidx.compose.foundation.lazy.m)kotlin.a.p.oN(this.afi.mQ().mE());
    if (localm == null)
    {
      AppMethodBeat.o(238902);
      return false;
    }
    if (localm.getIndex() >= getItemCount() - 1)
    {
      int i = localm.getOffset();
      if (localm.getSize() + i <= byZ()) {}
    }
    else
    {
      AppMethodBeat.o(238902);
      return true;
    }
    AppMethodBeat.o(238902);
    return false;
  }
  
  public final void uP(int paramInt)
  {
    AppMethodBeat.i(238888);
    this.ohs.setValue(Integer.valueOf(paramInt));
    AppMethodBeat.o(238888);
  }
  
  public final int uQ(int paramInt)
  {
    AppMethodBeat.i(238896);
    Iterator localIterator = bzb().iterator();
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((i)localObject).getIndex() == paramInt)
      {
        i = 1;
        label50:
        if (i == 0) {
          break label104;
        }
      }
    }
    for (;;)
    {
      localObject = (i)localObject;
      if (localObject == null) {
        break label112;
      }
      paramInt = ((i)localObject).getOffset();
      i = ((Number)this.ohq.invoke(this, localObject)).intValue();
      AppMethodBeat.o(238896);
      return paramInt - i;
      i = 0;
      break label50;
      label104:
      break;
      localObject = null;
    }
    label112:
    Object localObject = bza();
    if (localObject == null)
    {
      AppMethodBeat.o(238896);
      return 0;
    }
    paramInt = a.eH((paramInt - ((i)localObject).getIndex()) * bzf());
    int i = ((i)localObject).getOffset();
    int j = ((Number)this.ohq.invoke(this, localObject)).intValue();
    AppMethodBeat.o(238896);
    return paramInt + i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.a.b
 * JD-Core Version:    0.7.0.1
 */