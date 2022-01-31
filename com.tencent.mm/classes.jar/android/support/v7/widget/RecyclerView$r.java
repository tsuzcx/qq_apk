package android.support.v7.widget;

import android.view.View;
import android.view.animation.Interpolator;

public abstract class RecyclerView$r
{
  RecyclerView adt;
  RecyclerView.i ahB;
  public int ajQ = -1;
  boolean ajR;
  boolean ajS;
  View ajT;
  private final a ajU = new a();
  
  protected abstract void a(int paramInt1, int paramInt2, a parama);
  
  protected abstract void a(View paramView, a parama);
  
  protected final void bN(View paramView)
  {
    if (RecyclerView.br(paramView) == this.ajQ) {
      this.ajT = paramView;
    }
  }
  
  public final void cg(int paramInt)
  {
    this.ajQ = paramInt;
  }
  
  protected abstract void onStop();
  
  protected final void stop()
  {
    if (!this.ajS) {
      return;
    }
    this.ajS = false;
    onStop();
    this.adt.aiK.ajQ = -1;
    this.ajT = null;
    this.ajQ = -1;
    this.ajR = false;
    RecyclerView.i.a(this.ahB, this);
    this.ahB = null;
    this.adt = null;
  }
  
  public static final class a
  {
    private int ajV = 0;
    private int ajW = 0;
    int ajX = -1;
    private boolean ajY = false;
    private int ajZ = 0;
    private int mDuration = -2147483648;
    private Interpolator mInterpolator = null;
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte) {}
    
    private void validate()
    {
      if ((this.mInterpolator != null) && (this.mDuration <= 0)) {
        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
      }
      if (this.mDuration <= 0) {
        throw new IllegalStateException("Scroll duration must be a positive number");
      }
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      this.ajV = paramInt1;
      this.ajW = paramInt2;
      this.mDuration = paramInt3;
      this.mInterpolator = paramInterpolator;
      this.ajY = true;
    }
    
    final void h(RecyclerView paramRecyclerView)
    {
      if (this.ajX >= 0)
      {
        int i = this.ajX;
        this.ajX = -1;
        paramRecyclerView.bO(i);
        this.ajY = false;
        return;
      }
      if (this.ajY)
      {
        validate();
        if (this.mInterpolator == null) {
          if (this.mDuration == -2147483648) {
            paramRecyclerView.aiH.aC(this.ajV, this.ajW);
          }
        }
        for (;;)
        {
          this.ajZ += 1;
          this.ajY = false;
          return;
          paramRecyclerView.aiH.m(this.ajV, this.ajW, this.mDuration);
          continue;
          paramRecyclerView.aiH.b(this.ajV, this.ajW, this.mDuration, this.mInterpolator);
        }
      }
      this.ajZ = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.r
 * JD-Core Version:    0.7.0.1
 */