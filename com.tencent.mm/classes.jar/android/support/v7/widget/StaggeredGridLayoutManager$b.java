package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

final class StaggeredGridLayoutManager$b
{
  ArrayList<View> ang;
  int anh;
  int ani;
  int anj;
  final int mIndex;
  
  private int aM(int paramInt1, int paramInt2)
  {
    int m = -1;
    int n = this.amU.amD.iI();
    int i1 = this.amU.amD.iJ();
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
        localView = (View)this.ang.get(paramInt1);
        i2 = this.amU.amD.bh(localView);
        i3 = this.amU.amD.bi(localView);
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
        j = StaggeredGridLayoutManager.bv(localView);
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
  
  private void fs()
  {
    this.anh = -2147483648;
    this.ani = -2147483648;
  }
  
  private void kB()
  {
    Object localObject = (View)this.ang.get(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
    this.anh = this.amU.amD.bh((View)localObject);
    if (localLayoutParams.amW)
    {
      localObject = this.amU.amI.cB(localLayoutParams.ajy.jM());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).amY == -1)) {
        this.anh -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cC(this.mIndex);
      }
    }
  }
  
  private void kD()
  {
    Object localObject = (View)this.ang.get(this.ang.size() - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
    this.ani = this.amU.amD.bi((View)localObject);
    if (localLayoutParams.amW)
    {
      localObject = this.amU.amI.cB(localLayoutParams.ajy.jM());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).amY == 1))
      {
        int i = this.ani;
        this.ani = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cC(this.mIndex) + i);
      }
    }
  }
  
  public final View aN(int paramInt1, int paramInt2)
  {
    View localView2 = null;
    View localView1 = null;
    if (paramInt2 == -1)
    {
      int i = this.ang.size();
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        localView2 = (View)this.ang.get(paramInt2);
        if (((this.amU.ago) && (StaggeredGridLayoutManager.bv(localView2) <= paramInt1)) || ((!this.amU.ago) && (StaggeredGridLayoutManager.bv(localView2) >= paramInt1)) || (!localView2.hasFocusable())) {
          break;
        }
        paramInt2 += 1;
        localView1 = localView2;
      }
      return localView1;
    }
    paramInt2 = this.ang.size() - 1;
    for (localView1 = localView2; paramInt2 >= 0; localView1 = localView2)
    {
      localView2 = (View)this.ang.get(paramInt2);
      if (((this.amU.ago) && (StaggeredGridLayoutManager.bv(localView2) >= paramInt1)) || ((!this.amU.ago) && (StaggeredGridLayoutManager.bv(localView2) <= paramInt1)) || (!localView2.hasFocusable())) {
        break;
      }
      paramInt2 -= 1;
    }
    return localView1;
  }
  
  final void bQ(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.amV = this;
    this.ang.add(0, paramView);
    this.anh = -2147483648;
    if (this.ang.size() == 1) {
      this.ani = -2147483648;
    }
    if ((localLayoutParams.ajy.isRemoved()) || (localLayoutParams.ajy.kb())) {
      this.anj += this.amU.amD.bl(paramView);
    }
  }
  
  final void bR(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.amV = this;
    this.ang.add(paramView);
    this.ani = -2147483648;
    if (this.ang.size() == 1) {
      this.anh = -2147483648;
    }
    if ((localLayoutParams.ajy.isRemoved()) || (localLayoutParams.ajy.kb())) {
      this.anj += this.amU.amD.bl(paramView);
    }
  }
  
  final int cD(int paramInt)
  {
    if (this.anh != -2147483648) {
      paramInt = this.anh;
    }
    while (this.ang.size() == 0) {
      return paramInt;
    }
    kB();
    return this.anh;
  }
  
  final int cE(int paramInt)
  {
    if (this.ani != -2147483648) {
      paramInt = this.ani;
    }
    while (this.ang.size() == 0) {
      return paramInt;
    }
    kD();
    return this.ani;
  }
  
  final void cF(int paramInt)
  {
    this.anh = paramInt;
    this.ani = paramInt;
  }
  
  final void cG(int paramInt)
  {
    if (this.anh != -2147483648) {
      this.anh += paramInt;
    }
    if (this.ani != -2147483648) {
      this.ani += paramInt;
    }
  }
  
  final void clear()
  {
    this.ang.clear();
    fs();
    this.anj = 0;
  }
  
  final int kC()
  {
    if (this.anh != -2147483648) {
      return this.anh;
    }
    kB();
    return this.anh;
  }
  
  final int kE()
  {
    if (this.ani != -2147483648) {
      return this.ani;
    }
    kD();
    return this.ani;
  }
  
  final void kF()
  {
    int i = this.ang.size();
    View localView = (View)this.ang.remove(i - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
    localLayoutParams.amV = null;
    if ((localLayoutParams.ajy.isRemoved()) || (localLayoutParams.ajy.kb())) {
      this.anj -= this.amU.amD.bl(localView);
    }
    if (i == 1) {
      this.anh = -2147483648;
    }
    this.ani = -2147483648;
  }
  
  final void kG()
  {
    View localView = (View)this.ang.remove(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
    localLayoutParams.amV = null;
    if (this.ang.size() == 0) {
      this.ani = -2147483648;
    }
    if ((localLayoutParams.ajy.isRemoved()) || (localLayoutParams.ajy.kb())) {
      this.anj -= this.amU.amD.bl(localView);
    }
    this.anh = -2147483648;
  }
  
  public final int kH()
  {
    if (this.amU.ago) {
      return aM(this.ang.size() - 1, -1);
    }
    return aM(0, this.ang.size());
  }
  
  public final int kI()
  {
    if (this.amU.ago) {
      return aM(0, this.ang.size());
    }
    return aM(this.ang.size() - 1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.b
 * JD-Core Version:    0.7.0.1
 */