package android.support.v7.widget;

import android.graphics.Rect;
import android.view.View;

public abstract class aj
{
  protected final RecyclerView.i afm;
  int afn = -2147483648;
  final Rect hc = new Rect();
  
  private aj(RecyclerView.i parami)
  {
    this.afm = parami;
  }
  
  public static aj a(RecyclerView.i parami)
  {
    return new aj.1(parami);
  }
  
  public static aj b(RecyclerView.i parami)
  {
    return new aj.2(parami);
  }
  
  public abstract int aX(View paramView);
  
  public abstract int aY(View paramView);
  
  public abstract int aZ(View paramView);
  
  public abstract void bI(int paramInt);
  
  public abstract int ba(View paramView);
  
  public abstract int bb(View paramView);
  
  public abstract int bc(View paramView);
  
  public abstract int getEnd();
  
  public abstract int getEndPadding();
  
  public final RecyclerView.i getLayoutManager()
  {
    return this.afm;
  }
  
  public abstract int getMode();
  
  public final int hg()
  {
    if (-2147483648 == this.afn) {
      return 0;
    }
    return hj() - this.afn;
  }
  
  public abstract int hh();
  
  public abstract int hi();
  
  public abstract int hj();
  
  public abstract int hk();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.aj
 * JD-Core Version:    0.7.0.1
 */