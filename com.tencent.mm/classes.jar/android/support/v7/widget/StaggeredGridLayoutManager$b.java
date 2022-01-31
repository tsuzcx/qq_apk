package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

final class StaggeredGridLayoutManager$b
{
  ArrayList<View> akN;
  int akO;
  int akP;
  int akQ;
  final int mIndex;
  
  private int az(int paramInt1, int paramInt2)
  {
    int m = -1;
    int n = this.akB.akk.hh();
    int i1 = this.akB.akk.hi();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    for (;;)
    {
      int j = m;
      View localView;
      int i2;
      int i3;
      if (paramInt1 != paramInt2)
      {
        localView = (View)this.akN.get(paramInt1);
        i2 = this.akB.akk.aX(localView);
        i3 = this.akB.akk.aY(localView);
        if (i2 > i1) {
          break label143;
        }
        j = 1;
        label94:
        if (i3 < n) {
          break label149;
        }
      }
      label143:
      label149:
      for (int k = 1;; k = 0)
      {
        if ((j == 0) || (k == 0) || ((i2 >= n) && (i3 <= i1))) {
          break label155;
        }
        j = StaggeredGridLayoutManager.bl(localView);
        return j;
        i = -1;
        break;
        j = 0;
        break label94;
      }
      label155:
      paramInt1 += i;
    }
  }
  
  private void iL()
  {
    Object localObject = (View)this.akN.get(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
    this.akO = this.akB.akk.aX((View)localObject);
    if (localLayoutParams.akD)
    {
      localObject = this.akB.akp.cl(localLayoutParams.ahi.ic());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).akF == -1)) {
        this.akO -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cm(this.mIndex);
      }
    }
  }
  
  private void iN()
  {
    Object localObject = (View)this.akN.get(this.akN.size() - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
    this.akP = this.akB.akk.aY((View)localObject);
    if (localLayoutParams.akD)
    {
      localObject = this.akB.akp.cl(localLayoutParams.ahi.ic());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).akF == 1))
      {
        int i = this.akP;
        this.akP = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cm(this.mIndex) + i);
      }
    }
  }
  
  public final View aA(int paramInt1, int paramInt2)
  {
    View localView2 = null;
    View localView1 = null;
    if (paramInt2 == -1)
    {
      int i = this.akN.size();
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        localView2 = (View)this.akN.get(paramInt2);
        if (((this.akB.aeb) && (StaggeredGridLayoutManager.bl(localView2) <= paramInt1)) || ((!this.akB.aeb) && (StaggeredGridLayoutManager.bl(localView2) >= paramInt1)) || (!localView2.hasFocusable())) {
          break;
        }
        paramInt2 += 1;
        localView1 = localView2;
      }
      return localView1;
    }
    paramInt2 = this.akN.size() - 1;
    for (localView1 = localView2; paramInt2 >= 0; localView1 = localView2)
    {
      localView2 = (View)this.akN.get(paramInt2);
      if (((this.akB.aeb) && (StaggeredGridLayoutManager.bl(localView2) >= paramInt1)) || ((!this.akB.aeb) && (StaggeredGridLayoutManager.bl(localView2) <= paramInt1)) || (!localView2.hasFocusable())) {
        break;
      }
      paramInt2 -= 1;
    }
    return localView1;
  }
  
  final void by(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.akC = this;
    this.akN.add(0, paramView);
    this.akO = -2147483648;
    if (this.akN.size() == 1) {
      this.akP = -2147483648;
    }
    if ((localLayoutParams.ahi.isRemoved()) || (localLayoutParams.ahi.ip())) {
      this.akQ += this.akB.akk.bb(paramView);
    }
  }
  
  final void bz(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.akC = this;
    this.akN.add(paramView);
    this.akP = -2147483648;
    if (this.akN.size() == 1) {
      this.akO = -2147483648;
    }
    if ((localLayoutParams.ahi.isRemoved()) || (localLayoutParams.ahi.ip())) {
      this.akQ += this.akB.akk.bb(paramView);
    }
  }
  
  final void clear()
  {
    this.akN.clear();
    this.akO = -2147483648;
    this.akP = -2147483648;
    this.akQ = 0;
  }
  
  final int cn(int paramInt)
  {
    if (this.akO != -2147483648) {
      paramInt = this.akO;
    }
    while (this.akN.size() == 0) {
      return paramInt;
    }
    iL();
    return this.akO;
  }
  
  final int co(int paramInt)
  {
    if (this.akP != -2147483648) {
      paramInt = this.akP;
    }
    while (this.akN.size() == 0) {
      return paramInt;
    }
    iN();
    return this.akP;
  }
  
  final void cp(int paramInt)
  {
    this.akO = paramInt;
    this.akP = paramInt;
  }
  
  final void cq(int paramInt)
  {
    if (this.akO != -2147483648) {
      this.akO += paramInt;
    }
    if (this.akP != -2147483648) {
      this.akP += paramInt;
    }
  }
  
  final int iM()
  {
    if (this.akO != -2147483648) {
      return this.akO;
    }
    iL();
    return this.akO;
  }
  
  final int iO()
  {
    if (this.akP != -2147483648) {
      return this.akP;
    }
    iN();
    return this.akP;
  }
  
  final void iP()
  {
    int i = this.akN.size();
    View localView = (View)this.akN.remove(i - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
    localLayoutParams.akC = null;
    if ((localLayoutParams.ahi.isRemoved()) || (localLayoutParams.ahi.ip())) {
      this.akQ -= this.akB.akk.bb(localView);
    }
    if (i == 1) {
      this.akO = -2147483648;
    }
    this.akP = -2147483648;
  }
  
  final void iQ()
  {
    View localView = (View)this.akN.remove(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
    localLayoutParams.akC = null;
    if (this.akN.size() == 0) {
      this.akP = -2147483648;
    }
    if ((localLayoutParams.ahi.isRemoved()) || (localLayoutParams.ahi.ip())) {
      this.akQ -= this.akB.akk.bb(localView);
    }
    this.akO = -2147483648;
  }
  
  public final int iR()
  {
    if (this.akB.aeb) {
      return az(this.akN.size() - 1, -1);
    }
    return az(0, this.akN.size());
  }
  
  public final int iS()
  {
    if (this.akB.aeb) {
      return az(0, this.akN.size());
    }
    return az(this.akN.size() - 1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.b
 * JD-Core Version:    0.7.0.1
 */