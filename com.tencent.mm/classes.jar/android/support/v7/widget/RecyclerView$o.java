package android.support.v7.widget;

import android.support.v4.os.e;
import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecyclerView$o
{
  final ArrayList<RecyclerView.v> ajH = new ArrayList();
  ArrayList<RecyclerView.v> ajI = null;
  final ArrayList<RecyclerView.v> ajJ = new ArrayList();
  final List<RecyclerView.v> ajK = Collections.unmodifiableList(this.ajH);
  int ajL = 2;
  int ajM = 2;
  RecyclerView.n ajN;
  RecyclerView.t ajO;
  
  public RecyclerView$o(RecyclerView paramRecyclerView) {}
  
  private boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, long paramLong)
  {
    paramv.akK = this.aja;
    int i = paramv.aky;
    long l1 = this.aja.getNanoTime();
    if (paramLong != 9223372036854775807L)
    {
      long l2 = this.ajN.bZ(i).ajG;
      if ((l2 == 0L) || (l2 + l1 < paramLong)) {}
      for (i = 1; i == 0; i = 0) {
        return false;
      }
    }
    Object localObject = this.aja.Tg;
    paramv.mPosition = paramInt1;
    if (((RecyclerView.a)localObject).ajc) {
      paramv.akx = ((RecyclerView.a)localObject).getItemId(paramInt1);
    }
    paramv.setFlags(1, 519);
    e.beginSection("RV OnBindView");
    ((RecyclerView.a)localObject).a(paramv, paramInt1, paramv.jZ());
    paramv.jY();
    localObject = paramv.aku.getLayoutParams();
    if ((localObject instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)localObject).ajz = true;
    }
    e.endSection();
    paramLong = this.aja.getNanoTime();
    localObject = this.ajN.bZ(paramv.aky);
    ((RecyclerView.n.a)localObject).ajG = RecyclerView.n.c(((RecyclerView.n.a)localObject).ajG, paramLong - l1);
    if (this.aja.jb())
    {
      localObject = paramv.aku;
      if (t.S((View)localObject) == 0) {
        t.o((View)localObject, 1);
      }
      if (!t.P((View)localObject))
      {
        paramv.addFlags(16384);
        t.a((View)localObject, this.aja.aiR.akL);
      }
    }
    if (this.aja.aiK.akg) {
      paramv.akz = paramInt2;
    }
    return true;
  }
  
  private RecyclerView.v b(long paramLong, int paramInt)
  {
    int i = this.ajH.size() - 1;
    RecyclerView.v localv;
    while (i >= 0)
    {
      localv = (RecyclerView.v)this.ajH.get(i);
      if ((localv.akx == paramLong) && (!localv.jR()))
      {
        if (paramInt == localv.aky)
        {
          localv.addFlags(32);
          if ((localv.isRemoved()) && (!this.aja.aiK.akg)) {
            localv.setFlags(2, 14);
          }
          return localv;
        }
        this.ajH.remove(i);
        this.aja.removeDetachedView(localv.aku, false);
        bL(localv.aku);
      }
      i -= 1;
    }
    i = this.ajJ.size() - 1;
    while (i >= 0)
    {
      localv = (RecyclerView.v)this.ajJ.get(i);
      if (localv.akx == paramLong)
      {
        if (paramInt == localv.aky)
        {
          this.ajJ.remove(i);
          return localv;
        }
        cd(i);
        return null;
      }
      i -= 1;
    }
    return null;
  }
  
  private RecyclerView.v ce(int paramInt)
  {
    int j = 0;
    int k;
    if (this.ajI != null)
    {
      k = this.ajI.size();
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
      localv = (RecyclerView.v)this.ajI.get(i);
      if ((!localv.jR()) && (localv.jM() == paramInt))
      {
        localv.addFlags(32);
        return localv;
      }
      i += 1;
    }
    if (this.aja.Tg.ajc)
    {
      paramInt = this.aja.ahQ.J(paramInt, 0);
      if ((paramInt > 0) && (paramInt < this.aja.Tg.getItemCount()))
      {
        long l = this.aja.Tg.getItemId(paramInt);
        paramInt = j;
        while (paramInt < k)
        {
          localv = (RecyclerView.v)this.ajI.get(paramInt);
          if ((!localv.jR()) && (localv.akx == l))
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
  
  private RecyclerView.v cf(int paramInt)
  {
    int j = 0;
    int k = this.ajH.size();
    int i = 0;
    Object localObject1;
    while (i < k)
    {
      localObject1 = (RecyclerView.v)this.ajH.get(i);
      if ((!((RecyclerView.v)localObject1).jR()) && (((RecyclerView.v)localObject1).jM() == paramInt) && (!((RecyclerView.v)localObject1).jU()) && ((this.aja.aiK.akg) || (!((RecyclerView.v)localObject1).isRemoved())))
      {
        ((RecyclerView.v)localObject1).addFlags(32);
        return localObject1;
      }
      i += 1;
    }
    Object localObject2 = this.aja.ahR;
    k = ((s)localObject2).abU.size();
    i = 0;
    Object localObject3;
    if (i < k)
    {
      localObject1 = (View)((s)localObject2).abU.get(i);
      localObject3 = ((s)localObject2).abS.bb((View)localObject1);
      if ((((RecyclerView.v)localObject3).jM() != paramInt) || (((RecyclerView.v)localObject3).jU()) || (((RecyclerView.v)localObject3).isRemoved())) {}
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = RecyclerView.bp((View)localObject1);
        localObject3 = this.aja.ahR;
        paramInt = ((s)localObject3).abS.indexOfChild((View)localObject1);
        if (paramInt < 0)
        {
          throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localObject1)));
          i += 1;
          break;
          localObject1 = null;
          continue;
        }
        if (!((s)localObject3).abT.get(paramInt)) {
          throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(localObject1)));
        }
        ((s)localObject3).abT.clear(paramInt);
        ((s)localObject3).aZ((View)localObject1);
        paramInt = this.aja.ahR.indexOfChild((View)localObject1);
        if (paramInt == -1) {
          throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2 + this.aja.iM());
        }
        this.aja.ahR.detachViewFromParent(paramInt);
        bM((View)localObject1);
        ((RecyclerView.v)localObject2).addFlags(8224);
        return localObject2;
      }
    }
    k = this.ajJ.size();
    i = j;
    while (i < k)
    {
      localObject1 = (RecyclerView.v)this.ajJ.get(i);
      if ((!((RecyclerView.v)localObject1).jU()) && (((RecyclerView.v)localObject1).jM() == paramInt))
      {
        this.ajJ.remove(i);
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
  
  private void jG()
  {
    int i = this.ajJ.size() - 1;
    while (i >= 0)
    {
      cd(i);
      i -= 1;
    }
    this.ajJ.clear();
    if (RecyclerView.access$800()) {
      this.aja.aiJ.hI();
    }
  }
  
  private boolean q(RecyclerView.v paramv)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramv.isRemoved()) {
      bool1 = this.aja.aiK.akg;
    }
    do
    {
      do
      {
        return bool1;
        if ((paramv.mPosition < 0) || (paramv.mPosition >= this.aja.Tg.getItemCount())) {
          throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramv + this.aja.iM());
        }
        if (this.aja.aiK.akg) {
          break;
        }
        bool1 = bool2;
      } while (this.aja.Tg.getItemViewType(paramv.mPosition) != paramv.aky);
      if (!this.aja.Tg.ajc) {
        break;
      }
      bool1 = bool2;
    } while (paramv.akx != this.aja.Tg.getItemId(paramv.mPosition));
    return true;
    return true;
  }
  
  private void r(RecyclerView.v paramv)
  {
    if ((paramv.aku instanceof ViewGroup)) {
      d((ViewGroup)paramv.aku, false);
    }
  }
  
  private void u(RecyclerView.v paramv)
  {
    if (this.aja.Tg != null) {
      this.aja.Tg.a(paramv);
    }
    if (this.aja.aiK != null) {
      this.aja.ahS.L(paramv);
    }
  }
  
  final void a(RecyclerView.v paramv, boolean paramBoolean)
  {
    RecyclerView.h(paramv);
    if (paramv.ci(16384))
    {
      paramv.setFlags(0, 16384);
      t.a(paramv.aku, null);
    }
    if (paramBoolean) {
      u(paramv);
    }
    paramv.akK = null;
    getRecycledViewPool().p(paramv);
  }
  
  public final void bK(View paramView)
  {
    RecyclerView.v localv = RecyclerView.bp(paramView);
    if (localv.jW()) {
      this.aja.removeDetachedView(paramView, false);
    }
    if (localv.jP()) {
      localv.jQ();
    }
    for (;;)
    {
      s(localv);
      return;
      if (localv.jR()) {
        localv.jS();
      }
    }
  }
  
  final void bL(View paramView)
  {
    paramView = RecyclerView.bp(paramView);
    RecyclerView.v.w(paramView);
    RecyclerView.v.x(paramView);
    paramView.jS();
    s(paramView);
  }
  
  final void bM(View paramView)
  {
    paramView = RecyclerView.bp(paramView);
    int i;
    if ((!paramView.ci(12)) && (paramView.kb()))
    {
      RecyclerView localRecyclerView = this.aja;
      if ((localRecyclerView.aiv != null) && (!localRecyclerView.aiv.a(paramView, paramView.jZ()))) {
        break label112;
      }
      i = 1;
    }
    while (i != 0) {
      if ((paramView.jU()) && (!paramView.isRemoved()) && (!this.aja.Tg.ajc))
      {
        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.aja.iM());
        label112:
        i = 0;
      }
      else
      {
        paramView.a(this, false);
        this.ajH.add(paramView);
        return;
      }
    }
    if (this.ajI == null) {
      this.ajI = new ArrayList();
    }
    paramView.a(this, true);
    this.ajI.add(paramView);
  }
  
  public final int ca(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.aja.aiK.getItemCount())) {
      throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + this.aja.aiK.getItemCount() + this.aja.iM());
    }
    if (!this.aja.aiK.akg) {
      return paramInt;
    }
    return this.aja.ahQ.bl(paramInt);
  }
  
  public final View cb(int paramInt)
  {
    return cc(paramInt);
  }
  
  final View cc(int paramInt)
  {
    return e(paramInt, 9223372036854775807L).aku;
  }
  
  final void cd(int paramInt)
  {
    a((RecyclerView.v)this.ajJ.get(paramInt), true);
    this.ajJ.remove(paramInt);
  }
  
  public final void clear()
  {
    this.ajH.clear();
    jG();
  }
  
  final RecyclerView.v e(int paramInt, long paramLong)
  {
    boolean bool2 = true;
    if ((paramInt < 0) || (paramInt >= this.aja.aiK.getItemCount())) {
      throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + this.aja.aiK.getItemCount() + this.aja.iM());
    }
    Object localObject1;
    int i;
    if (this.aja.aiK.akg)
    {
      localObject1 = ce(paramInt);
      if (localObject1 != null) {
        i = 1;
      }
    }
    for (int j = i;; j = 0)
    {
      Object localObject2;
      if (localObject1 == null)
      {
        localObject2 = cf(paramInt);
        localObject1 = localObject2;
        i = j;
        if (localObject2 != null)
        {
          if (q((RecyclerView.v)localObject2)) {
            break label321;
          }
          ((RecyclerView.v)localObject2).addFlags(4);
          if (!((RecyclerView.v)localObject2).jP()) {
            break label305;
          }
          this.aja.removeDetachedView(((RecyclerView.v)localObject2).aku, false);
          ((RecyclerView.v)localObject2).jQ();
          label183:
          s((RecyclerView.v)localObject2);
          localObject1 = null;
          i = j;
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          int k = this.aja.ahQ.bl(paramInt);
          if ((k < 0) || (k >= this.aja.Tg.getItemCount()))
          {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + this.aja.aiK.getItemCount() + this.aja.iM());
            i = 0;
            break;
            label305:
            if (!((RecyclerView.v)localObject2).jR()) {
              break label183;
            }
            ((RecyclerView.v)localObject2).jS();
            break label183;
            label321:
            i = 1;
            localObject1 = localObject2;
            continue;
          }
          j = this.aja.Tg.getItemViewType(k);
          if (this.aja.Tg.ajc)
          {
            localObject2 = b(this.aja.Tg.getItemId(k), j);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              ((RecyclerView.v)localObject2).mPosition = k;
              i = 1;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = getRecycledViewPool().bY(j);
                localObject1 = localObject2;
                if (localObject2 != null)
                {
                  ((RecyclerView.v)localObject2).resetInternal();
                  localObject1 = localObject2;
                  if (RecyclerView.ahG)
                  {
                    r((RecyclerView.v)localObject2);
                    localObject1 = localObject2;
                  }
                }
              }
              localObject2 = localObject1;
              if (localObject1 == null)
              {
                long l1 = this.aja.getNanoTime();
                if ((paramLong != 9223372036854775807L) && (!this.ajN.a(j, l1, paramLong))) {
                  return null;
                }
                localObject2 = this.aja.Tg.c(this.aja, j);
                if (RecyclerView.access$800())
                {
                  localObject1 = RecyclerView.bt(((RecyclerView.v)localObject2).aku);
                  if (localObject1 != null) {
                    ((RecyclerView.v)localObject2).akv = new WeakReference(localObject1);
                  }
                }
                long l2 = this.aja.getNanoTime();
                this.ajN.d(j, l2 - l1);
              }
            }
          }
        }
        for (;;)
        {
          if ((i != 0) && (!this.aja.aiK.akg) && (((RecyclerView.v)localObject2).ci(8192)))
          {
            ((RecyclerView.v)localObject2).setFlags(0, 8192);
            if (this.aja.aiK.akj)
            {
              j = RecyclerView.f.l((RecyclerView.v)localObject2);
              localObject1 = this.aja.aiv.a(this.aja.aiK, (RecyclerView.v)localObject2, j | 0x1000, ((RecyclerView.v)localObject2).jZ());
              this.aja.a((RecyclerView.v)localObject2, (RecyclerView.f.c)localObject1);
            }
          }
          boolean bool1;
          if ((this.aja.aiK.akg) && (((RecyclerView.v)localObject2).isBound()))
          {
            ((RecyclerView.v)localObject2).akz = paramInt;
            bool1 = false;
          }
          for (;;)
          {
            localObject1 = ((RecyclerView.v)localObject2).aku.getLayoutParams();
            if (localObject1 == null)
            {
              localObject1 = (RecyclerView.LayoutParams)this.aja.generateDefaultLayoutParams();
              ((RecyclerView.v)localObject2).aku.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              label738:
              ((RecyclerView.LayoutParams)localObject1).ajy = ((RecyclerView.v)localObject2);
              if ((i == 0) || (!bool1)) {
                break label866;
              }
            }
            label866:
            for (bool1 = bool2;; bool1 = false)
            {
              ((RecyclerView.LayoutParams)localObject1).ajA = bool1;
              return localObject2;
              if ((((RecyclerView.v)localObject2).isBound()) && (!((RecyclerView.v)localObject2).jV()) && (!((RecyclerView.v)localObject2).jU())) {
                break label872;
              }
              bool1 = a((RecyclerView.v)localObject2, this.aja.ahQ.bl(paramInt), paramInt, paramLong);
              break;
              if (!this.aja.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
              {
                localObject1 = (RecyclerView.LayoutParams)this.aja.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                ((RecyclerView.v)localObject2).aku.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                break label738;
              }
              localObject1 = (RecyclerView.LayoutParams)localObject1;
              break label738;
            }
            label872:
            bool1 = false;
          }
          localObject2 = localObject1;
          break;
          localObject2 = localObject1;
        }
        i = j;
      }
      localObject1 = null;
    }
  }
  
  final RecyclerView.n getRecycledViewPool()
  {
    if (this.ajN == null) {
      this.ajN = new RecyclerView.n();
    }
    return this.ajN;
  }
  
  final void jF()
  {
    if (this.aja.ahW != null) {}
    for (int i = this.aja.ahW.ajt;; i = 0)
    {
      this.ajM = (i + this.ajL);
      i = this.ajJ.size() - 1;
      while ((i >= 0) && (this.ajJ.size() > this.ajM))
      {
        cd(i);
        i -= 1;
      }
    }
  }
  
  final void jo()
  {
    int j = this.ajJ.size();
    int i = 0;
    while (i < j)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((RecyclerView.v)this.ajJ.get(i)).aku.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.ajz = true;
      }
      i += 1;
    }
  }
  
  final void jq()
  {
    int j = 0;
    int k = this.ajJ.size();
    int i = 0;
    while (i < k)
    {
      ((RecyclerView.v)this.ajJ.get(i)).jJ();
      i += 1;
    }
    k = this.ajH.size();
    i = 0;
    while (i < k)
    {
      ((RecyclerView.v)this.ajH.get(i)).jJ();
      i += 1;
    }
    if (this.ajI != null)
    {
      k = this.ajI.size();
      i = j;
      while (i < k)
      {
        ((RecyclerView.v)this.ajI.get(i)).jJ();
        i += 1;
      }
    }
  }
  
  final void jr()
  {
    int j = this.ajJ.size();
    int i = 0;
    while (i < j)
    {
      RecyclerView.v localv = (RecyclerView.v)this.ajJ.get(i);
      if (localv != null)
      {
        localv.addFlags(6);
        localv.M(null);
      }
      i += 1;
    }
    if ((this.aja.Tg == null) || (!this.aja.Tg.ajc)) {
      jG();
    }
  }
  
  final void s(RecyclerView.v paramv)
  {
    int k = 1;
    if ((paramv.jP()) || (paramv.aku.getParent() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramv.jP()).append(" isAttached:");
      if (paramv.aku.getParent() != null) {}
      for (bool = true;; bool = false) {
        throw new IllegalArgumentException(bool + this.aja.iM());
      }
    }
    if (paramv.jW()) {
      throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramv + this.aja.iM());
    }
    if (paramv.jL()) {
      throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.aja.iM());
    }
    boolean bool = RecyclerView.v.v(paramv);
    int j;
    int i;
    if (paramv.ka()) {
      if ((this.ajM > 0) && (!paramv.ci(526)))
      {
        j = this.ajJ.size();
        i = j;
        if (j >= this.ajM)
        {
          i = j;
          if (j > 0)
          {
            cd(0);
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
            if (!this.aja.aiJ.bx(paramv.mPosition))
            {
              i -= 1;
              while (i >= 0)
              {
                j = ((RecyclerView.v)this.ajJ.get(i)).mPosition;
                if (!this.aja.aiJ.bx(j)) {
                  break;
                }
                i -= 1;
              }
              j = i + 1;
            }
          }
        }
        this.ajJ.add(j, paramv);
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
      this.aja.ahS.L(paramv);
      if ((i == 0) && (j == 0) && (bool)) {
        paramv.akK = null;
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
  
  final void t(RecyclerView.v paramv)
  {
    if (RecyclerView.v.y(paramv)) {
      this.ajI.remove(paramv);
    }
    for (;;)
    {
      RecyclerView.v.w(paramv);
      RecyclerView.v.x(paramv);
      paramv.jS();
      return;
      this.ajH.remove(paramv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.o
 * JD-Core Version:    0.7.0.1
 */