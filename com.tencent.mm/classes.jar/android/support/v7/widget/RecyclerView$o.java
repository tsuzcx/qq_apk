package android.support.v7.widget;

import android.support.v4.os.f;
import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecyclerView$o
{
  final ArrayList<RecyclerView.v> ahr = new ArrayList();
  ArrayList<RecyclerView.v> ahs = null;
  final ArrayList<RecyclerView.v> aht = new ArrayList();
  final List<RecyclerView.v> ahu = Collections.unmodifiableList(this.ahr);
  int ahv = 2;
  int ahw = 2;
  RecyclerView.n ahx;
  RecyclerView.t ahy;
  
  public RecyclerView$o(RecyclerView paramRecyclerView) {}
  
  private RecyclerView.v b(long paramLong, int paramInt)
  {
    int i = this.ahr.size() - 1;
    RecyclerView.v localv;
    while (i >= 0)
    {
      localv = (RecyclerView.v)this.ahr.get(i);
      if ((localv.aih == paramLong) && (!localv.ig()))
      {
        if (paramInt == localv.aii)
        {
          localv.addFlags(32);
          if ((localv.isRemoved()) && (!this.agK.agu.ahQ)) {
            localv.setFlags(2, 14);
          }
          return localv;
        }
        this.ahr.remove(i);
        this.agK.removeDetachedView(localv.aie, false);
        bw(localv.aie);
      }
      i -= 1;
    }
    i = this.aht.size() - 1;
    while (i >= 0)
    {
      localv = (RecyclerView.v)this.aht.get(i);
      if (localv.aih == paramLong)
      {
        if (paramInt == localv.aii)
        {
          this.aht.remove(i);
          return localv;
        }
        bW(i);
        return null;
      }
      i -= 1;
    }
    return null;
  }
  
  private RecyclerView.v bX(int paramInt)
  {
    int j = 0;
    int k;
    if (this.ahs != null)
    {
      k = this.ahs.size();
      if (k != 0) {}
    }
    else
    {
      return null;
    }
    int i = 0;
    RecyclerView.v localv;
    while (i < k)
    {
      localv = (RecyclerView.v)this.ahs.get(i);
      if ((!localv.ig()) && (localv.ic() == paramInt))
      {
        localv.addFlags(32);
        return localv;
      }
      i += 1;
    }
    if (this.agK.Sw.agM)
    {
      paramInt = this.agK.afA.G(paramInt, 0);
      if ((paramInt > 0) && (paramInt < this.agK.Sw.getItemCount()))
      {
        long l = this.agK.Sw.getItemId(paramInt);
        paramInt = j;
        while (paramInt < k)
        {
          localv = (RecyclerView.v)this.ahs.get(paramInt);
          if ((!localv.ig()) && (localv.aih == l))
          {
            localv.addFlags(32);
            return localv;
          }
          paramInt += 1;
        }
      }
    }
    return null;
  }
  
  private RecyclerView.v bY(int paramInt)
  {
    int j = 0;
    int k = this.ahr.size();
    int i = 0;
    Object localObject1;
    while (i < k)
    {
      localObject1 = (RecyclerView.v)this.ahr.get(i);
      if ((!((RecyclerView.v)localObject1).ig()) && (((RecyclerView.v)localObject1).ic() == paramInt) && (!((RecyclerView.v)localObject1).ij()) && ((this.agK.agu.ahQ) || (!((RecyclerView.v)localObject1).isRemoved())))
      {
        ((RecyclerView.v)localObject1).addFlags(32);
        return localObject1;
      }
      i += 1;
    }
    Object localObject2 = this.agK.afB;
    k = ((u)localObject2).abj.size();
    i = 0;
    Object localObject3;
    if (i < k)
    {
      localObject1 = (View)((u)localObject2).abj.get(i);
      localObject3 = ((u)localObject2).abh.aT((View)localObject1);
      if ((((RecyclerView.v)localObject3).ic() != paramInt) || (((RecyclerView.v)localObject3).ij()) || (((RecyclerView.v)localObject3).isRemoved())) {}
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = RecyclerView.bf((View)localObject1);
        localObject3 = this.agK.afB;
        paramInt = ((u)localObject3).abh.indexOfChild((View)localObject1);
        if (paramInt < 0)
        {
          throw new IllegalArgumentException("view is not a child, cannot hide " + localObject1);
          i += 1;
          break;
          localObject1 = null;
          continue;
        }
        if (!((u)localObject3).abi.get(paramInt)) {
          throw new RuntimeException("trying to unhide a view that was not hidden" + localObject1);
        }
        ((u)localObject3).abi.clear(paramInt);
        ((u)localObject3).aR((View)localObject1);
        paramInt = this.agK.afB.indexOfChild((View)localObject1);
        if (paramInt == -1) {
          throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2 + this.agK.hl());
        }
        this.agK.afB.detachViewFromParent(paramInt);
        bx((View)localObject1);
        ((RecyclerView.v)localObject2).addFlags(8224);
        return localObject2;
      }
    }
    k = this.aht.size();
    i = j;
    while (i < k)
    {
      localObject1 = (RecyclerView.v)this.aht.get(i);
      if ((!((RecyclerView.v)localObject1).ij()) && (((RecyclerView.v)localObject1).ic() == paramInt))
      {
        this.aht.remove(i);
        return localObject1;
      }
      i += 1;
    }
    return null;
  }
  
  private void d(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        d((ViewGroup)localView, true);
      }
      i -= 1;
    }
    if (!paramBoolean) {
      return;
    }
    if (paramViewGroup.getVisibility() == 4)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setVisibility(4);
      return;
    }
    i = paramViewGroup.getVisibility();
    paramViewGroup.setVisibility(4);
    paramViewGroup.setVisibility(i);
  }
  
  final void a(RecyclerView.v paramv, boolean paramBoolean)
  {
    RecyclerView.h(paramv);
    if (paramv.ca(16384))
    {
      paramv.setFlags(0, 16384);
      q.a(paramv.aie, null);
    }
    if (paramBoolean)
    {
      if (this.agK.afH != null) {
        localObject = this.agK.afH;
      }
      if (this.agK.Sw != null) {
        this.agK.Sw.a(paramv);
      }
      if (this.agK.agu != null) {
        this.agK.afC.F(paramv);
      }
    }
    paramv.aiu = null;
    Object localObject = getRecycledViewPool();
    int i = paramv.aii;
    ArrayList localArrayList = ((RecyclerView.n)localObject).bT(i).ahn;
    if (((RecyclerView.n.a)((RecyclerView.n)localObject).ahl.get(i)).aho > localArrayList.size())
    {
      paramv.resetInternal();
      localArrayList.add(paramv);
    }
  }
  
  public final int bU(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.agK.agu.getItemCount())) {
      throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + this.agK.agu.getItemCount() + this.agK.hl());
    }
    if (!this.agK.agu.ahQ) {
      return paramInt;
    }
    return this.agK.afA.bn(paramInt);
  }
  
  public final View bV(int paramInt)
  {
    return d(paramInt, 9223372036854775807L).aie;
  }
  
  final void bW(int paramInt)
  {
    a((RecyclerView.v)this.aht.get(paramInt), true);
    this.aht.remove(paramInt);
  }
  
  public final void bv(View paramView)
  {
    RecyclerView.v localv = RecyclerView.bf(paramView);
    if (localv.il()) {
      this.agK.removeDetachedView(paramView, false);
    }
    if (localv.ie()) {
      localv.jdMethod_if();
    }
    for (;;)
    {
      o(localv);
      return;
      if (localv.ig()) {
        localv.ih();
      }
    }
  }
  
  final void bw(View paramView)
  {
    paramView = RecyclerView.bf(paramView);
    RecyclerView.v.r(paramView);
    RecyclerView.v.s(paramView);
    paramView.ih();
    o(paramView);
  }
  
  final void bx(View paramView)
  {
    paramView = RecyclerView.bf(paramView);
    int i;
    if ((!paramView.ca(12)) && (paramView.ip()))
    {
      RecyclerView localRecyclerView = this.agK;
      if ((localRecyclerView.agf != null) && (!localRecyclerView.agf.a(paramView, paramView.in()))) {
        break label112;
      }
      i = 1;
    }
    while (i != 0) {
      if ((paramView.ij()) && (!paramView.isRemoved()) && (!this.agK.Sw.agM))
      {
        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.agK.hl());
        label112:
        i = 0;
      }
      else
      {
        paramView.a(this, false);
        this.ahr.add(paramView);
        return;
      }
    }
    if (this.ahs == null) {
      this.ahs = new ArrayList();
    }
    paramView.a(this, true);
    this.ahs.add(paramView);
  }
  
  public final void clear()
  {
    this.ahr.clear();
    hX();
  }
  
  final RecyclerView.v d(int paramInt, long paramLong)
  {
    if ((paramInt < 0) || (paramInt >= this.agK.agu.getItemCount())) {
      throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + this.agK.agu.getItemCount() + this.agK.hl());
    }
    int j = 0;
    Object localObject2 = null;
    int i;
    Object localObject1;
    boolean bool;
    if (this.agK.agu.ahQ)
    {
      localObject2 = bX(paramInt);
      if (localObject2 != null) {
        j = 1;
      }
    }
    else
    {
      i = j;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = bY(paramInt);
        i = j;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          if (!((RecyclerView.v)localObject2).isRemoved()) {
            break label328;
          }
          bool = this.agK.agu.ahQ;
          label169:
          if (bool) {
            break label497;
          }
          ((RecyclerView.v)localObject2).addFlags(4);
          if (!((RecyclerView.v)localObject2).ie()) {
            break label481;
          }
          this.agK.removeDetachedView(((RecyclerView.v)localObject2).aie, false);
          ((RecyclerView.v)localObject2).jdMethod_if();
          label206:
          o((RecyclerView.v)localObject2);
          localObject1 = null;
          i = j;
        }
      }
    }
    label328:
    label481:
    label497:
    int k;
    long l1;
    long l2;
    for (;;)
    {
      if (localObject1 == null)
      {
        j = this.agK.afA.bn(paramInt);
        if ((j < 0) || (j >= this.agK.Sw.getItemCount()))
        {
          throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + j + ").state:" + this.agK.agu.getItemCount() + this.agK.hl());
          j = 0;
          break;
          if ((((RecyclerView.v)localObject2).mPosition < 0) || (((RecyclerView.v)localObject2).mPosition >= this.agK.Sw.getItemCount())) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + localObject2 + this.agK.hl());
          }
          if ((!this.agK.agu.ahQ) && (this.agK.Sw.getItemViewType(((RecyclerView.v)localObject2).mPosition) != ((RecyclerView.v)localObject2).aii))
          {
            bool = false;
            break label169;
          }
          if ((this.agK.Sw.agM) && (((RecyclerView.v)localObject2).aih != this.agK.Sw.getItemId(((RecyclerView.v)localObject2).mPosition)))
          {
            bool = false;
            break label169;
          }
          bool = true;
          break label169;
          if (!((RecyclerView.v)localObject2).ig()) {
            break label206;
          }
          ((RecyclerView.v)localObject2).ih();
          break label206;
          i = 1;
          localObject1 = localObject2;
          continue;
        }
        k = this.agK.Sw.getItemViewType(j);
        if (this.agK.Sw.agM)
        {
          localObject2 = b(this.agK.Sw.getItemId(j), k);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            ((RecyclerView.v)localObject2).mPosition = j;
            i = 1;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = (RecyclerView.n.a)getRecycledViewPool().ahl.get(k);
              if ((localObject1 == null) || (((RecyclerView.n.a)localObject1).ahn.isEmpty())) {
                break label762;
              }
              localObject1 = ((RecyclerView.n.a)localObject1).ahn;
              localObject2 = (RecyclerView.v)((ArrayList)localObject1).remove(((ArrayList)localObject1).size() - 1);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                ((RecyclerView.v)localObject2).resetInternal();
                localObject1 = localObject2;
                if (RecyclerView.afq)
                {
                  localObject1 = localObject2;
                  if ((((RecyclerView.v)localObject2).aie instanceof ViewGroup))
                  {
                    d((ViewGroup)((RecyclerView.v)localObject2).aie, false);
                    localObject1 = localObject2;
                  }
                }
              }
            }
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              l1 = this.agK.getNanoTime();
              if (paramLong != 9223372036854775807L)
              {
                l2 = this.ahx.bT(k).ahp;
                if ((l2 == 0L) || (l2 + l1 < paramLong)) {}
                for (j = 1;; j = 0)
                {
                  if (j != 0) {
                    break label774;
                  }
                  return null;
                  label762:
                  localObject2 = null;
                  break;
                }
              }
              label774:
              localObject2 = this.agK.Sw.d(this.agK, k);
              if (RecyclerView.access$800())
              {
                localObject1 = RecyclerView.bj(((RecyclerView.v)localObject2).aie);
                if (localObject1 != null) {
                  ((RecyclerView.v)localObject2).aif = new WeakReference(localObject1);
                }
              }
              l2 = this.agK.getNanoTime();
              localObject1 = this.ahx.bT(k);
              ((RecyclerView.n.a)localObject1).ahp = RecyclerView.n.c(((RecyclerView.n.a)localObject1).ahp, l2 - l1);
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i != 0) && (!this.agK.agu.ahQ) && (((RecyclerView.v)localObject2).ca(8192)))
      {
        ((RecyclerView.v)localObject2).setFlags(0, 8192);
        if (this.agK.agu.ahT)
        {
          j = RecyclerView.f.k((RecyclerView.v)localObject2);
          localObject1 = this.agK.agf.a(this.agK.agu, (RecyclerView.v)localObject2, j | 0x1000, ((RecyclerView.v)localObject2).in());
          this.agK.a((RecyclerView.v)localObject2, (RecyclerView.f.c)localObject1);
        }
      }
      if ((this.agK.agu.ahQ) && (((RecyclerView.v)localObject2).isBound()))
      {
        ((RecyclerView.v)localObject2).aij = paramInt;
        paramInt = 0;
      }
      for (;;)
      {
        localObject1 = ((RecyclerView.v)localObject2).aie.getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = (RecyclerView.LayoutParams)this.agK.generateDefaultLayoutParams();
          ((RecyclerView.v)localObject2).aie.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          label1032:
          ((RecyclerView.LayoutParams)localObject1).ahi = ((RecyclerView.v)localObject2);
          if ((i == 0) || (paramInt == 0)) {
            break label1455;
          }
        }
        label1165:
        label1181:
        label1455:
        for (bool = true;; bool = false)
        {
          ((RecyclerView.LayoutParams)localObject1).ahk = bool;
          return localObject2;
          if ((((RecyclerView.v)localObject2).isBound()) && (!((RecyclerView.v)localObject2).ik()) && (!((RecyclerView.v)localObject2).ij())) {
            break label1461;
          }
          k = this.agK.afA.bn(paramInt);
          ((RecyclerView.v)localObject2).aiu = this.agK;
          j = ((RecyclerView.v)localObject2).aii;
          l1 = this.agK.getNanoTime();
          if (paramLong != 9223372036854775807L)
          {
            l2 = this.ahx.bT(j).ahq;
            if ((l2 == 0L) || (l2 + l1 < paramLong))
            {
              j = 1;
              if (j != 0) {
                break label1181;
              }
            }
          }
          for (paramInt = 0;; paramInt = 1)
          {
            break;
            j = 0;
            break label1165;
            localObject1 = this.agK.Sw;
            ((RecyclerView.v)localObject2).mPosition = k;
            if (((RecyclerView.a)localObject1).agM) {
              ((RecyclerView.v)localObject2).aih = ((RecyclerView.a)localObject1).getItemId(k);
            }
            ((RecyclerView.v)localObject2).setFlags(1, 519);
            f.beginSection("RV OnBindView");
            ((RecyclerView.a)localObject1).a((RecyclerView.v)localObject2, k, ((RecyclerView.v)localObject2).in());
            ((RecyclerView.v)localObject2).im();
            localObject1 = ((RecyclerView.v)localObject2).aie.getLayoutParams();
            if ((localObject1 instanceof RecyclerView.LayoutParams)) {
              ((RecyclerView.LayoutParams)localObject1).ahj = true;
            }
            f.endSection();
            paramLong = this.agK.getNanoTime();
            localObject1 = this.ahx.bT(((RecyclerView.v)localObject2).aii);
            ((RecyclerView.n.a)localObject1).ahq = RecyclerView.n.c(((RecyclerView.n.a)localObject1).ahq, paramLong - l1);
            if (this.agK.hA())
            {
              localObject1 = ((RecyclerView.v)localObject2).aie;
              if (q.P((View)localObject1) == 0) {
                q.n((View)localObject1, 1);
              }
              if (!q.M((View)localObject1))
              {
                ((RecyclerView.v)localObject2).addFlags(16384);
                q.a((View)localObject1, this.agK.agB.aiv);
              }
            }
            if (this.agK.agu.ahQ) {
              ((RecyclerView.v)localObject2).aij = paramInt;
            }
          }
          if (!this.agK.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
          {
            localObject1 = (RecyclerView.LayoutParams)this.agK.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
            ((RecyclerView.v)localObject2).aie.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            break label1032;
          }
          localObject1 = (RecyclerView.LayoutParams)localObject1;
          break label1032;
        }
        label1461:
        paramInt = 0;
      }
      localObject2 = localObject1;
      break;
      localObject2 = localObject1;
    }
  }
  
  final RecyclerView.n getRecycledViewPool()
  {
    if (this.ahx == null) {
      this.ahx = new RecyclerView.n();
    }
    return this.ahx;
  }
  
  final void hW()
  {
    if (this.agK.afG != null) {}
    for (int i = this.agK.afG.ahd;; i = 0)
    {
      this.ahw = (i + this.ahv);
      i = this.aht.size() - 1;
      while ((i >= 0) && (this.aht.size() > this.ahw))
      {
        bW(i);
        i -= 1;
      }
    }
  }
  
  final void hX()
  {
    int i = this.aht.size() - 1;
    while (i >= 0)
    {
      bW(i);
      i -= 1;
    }
    this.aht.clear();
    if (RecyclerView.access$800()) {
      this.agK.agt.gH();
    }
  }
  
  final void o(RecyclerView.v paramv)
  {
    int k = 1;
    Object localObject;
    if ((paramv.ie()) || (paramv.aie.getParent() != null))
    {
      localObject = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramv.ie()).append(" isAttached:");
      if (paramv.aie.getParent() != null) {}
      for (bool = true;; bool = false) {
        throw new IllegalArgumentException(bool + this.agK.hl());
      }
    }
    if (paramv.il()) {
      throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramv + this.agK.hl());
    }
    if (paramv.ib()) {
      throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.agK.hl());
    }
    boolean bool = RecyclerView.v.q(paramv);
    if ((this.agK.Sw != null) && (bool)) {
      localObject = this.agK.Sw;
    }
    int j;
    int i;
    if (paramv.io()) {
      if ((this.ahw > 0) && (!paramv.ca(526)))
      {
        j = this.aht.size();
        i = j;
        if (j >= this.ahw)
        {
          i = j;
          if (j > 0)
          {
            bW(0);
            i = j - 1;
          }
        }
        j = i;
        if (RecyclerView.access$800())
        {
          j = i;
          if (i > 0)
          {
            j = i;
            if (!this.agK.agt.bx(paramv.mPosition))
            {
              i -= 1;
              while (i >= 0)
              {
                j = ((RecyclerView.v)this.aht.get(i)).mPosition;
                if (!this.agK.agt.bx(j)) {
                  break;
                }
                i -= 1;
              }
              j = i + 1;
            }
          }
        }
        this.aht.add(j, paramv);
        i = 1;
        if (i == 0)
        {
          a(paramv, true);
          j = k;
        }
      }
    }
    for (;;)
    {
      this.agK.afC.F(paramv);
      if ((i == 0) && (j == 0) && (bool)) {
        paramv.aiu = null;
      }
      return;
      j = 0;
      continue;
      i = 0;
      break;
      j = 0;
      i = 0;
    }
  }
  
  final void p(RecyclerView.v paramv)
  {
    if (RecyclerView.v.t(paramv)) {
      this.ahs.remove(paramv);
    }
    for (;;)
    {
      RecyclerView.v.r(paramv);
      RecyclerView.v.s(paramv);
      paramv.ih();
      return;
      this.ahr.remove(paramv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.o
 * JD-Core Version:    0.7.0.1
 */