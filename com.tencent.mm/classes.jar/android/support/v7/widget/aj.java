package android.support.v7.widget;

import android.graphics.Rect;
import android.view.View;

public abstract class aj
{
  protected final RecyclerView.i ahB;
  int ahC = -2147483648;
  final Rect hV = new Rect();
  
  private aj(RecyclerView.i parami)
  {
    this.ahB = parami;
  }
  
  public static aj d(RecyclerView.i parami)
  {
    return new aj.1(parami);
  }
  
  public static aj e(RecyclerView.i parami)
  {
    return new aj.2(parami);
  }
  
  public abstract void bN(int paramInt);
  
  public abstract int bh(View paramView);
  
  public abstract int bi(View paramView);
  
  public abstract int bj(View paramView);
  
  public abstract int bk(View paramView);
  
  public abstract int bl(View paramView);
  
  public abstract int bm(View paramView);
  
  public abstract int getEnd();
  
  public abstract int getEndPadding();
  
  public final RecyclerView.i getLayoutManager()
  {
    return this.ahB;
  }
  
  public abstract int getMode();
  
  public final int iH()
  {
    if (-2147483648 == this.ahC) {
      return 0;
    }
    return iK() - this.ahC;
  }
  
  public abstract int iI();
  
  public abstract int iJ();
  
  public abstract int iK();
  
  public abstract int iL();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.aj
 * JD-Core Version:    0.7.0.1
 */