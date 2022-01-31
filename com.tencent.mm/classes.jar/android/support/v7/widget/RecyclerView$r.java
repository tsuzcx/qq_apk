package android.support.v7.widget;

import android.view.View;

public abstract class RecyclerView$r
{
  RecyclerView acI;
  RecyclerView.i afm;
  public int ahA = -1;
  boolean ahB;
  boolean ahC;
  View ahD;
  private final RecyclerView.r.a ahE = new RecyclerView.r.a();
  
  protected abstract void a(int paramInt1, int paramInt2, RecyclerView.r.a parama);
  
  public abstract void a(View paramView, RecyclerView.r.a parama);
  
  public abstract void onStop();
  
  protected final void stop()
  {
    if (!this.ahC) {
      return;
    }
    this.ahC = false;
    onStop();
    this.acI.agu.ahA = -1;
    this.ahD = null;
    this.ahA = -1;
    this.ahB = false;
    RecyclerView.i.a(this.afm, this);
    this.afm = null;
    this.acI = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.r
 * JD-Core Version:    0.7.0.1
 */