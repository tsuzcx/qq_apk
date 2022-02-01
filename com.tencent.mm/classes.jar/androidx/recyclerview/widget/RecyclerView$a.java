package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.c.g;
import java.util.List;

public abstract class RecyclerView$a<VH extends RecyclerView.v>
{
  public final RecyclerView.b bZE = new RecyclerView.b();
  protected boolean bZF = false;
  
  public static boolean Ks()
  {
    return false;
  }
  
  public void a(RecyclerView.c paramc)
  {
    this.bZE.registerObserver(paramc);
  }
  
  public void a(VH paramVH, int paramInt, List<Object> paramList)
  {
    d(paramVH, paramInt);
  }
  
  public abstract VH b(ViewGroup paramViewGroup, int paramInt);
  
  public void b(RecyclerView.c paramc)
  {
    this.bZE.unregisterObserver(paramc);
  }
  
  public final void bA(int paramInt1, int paramInt2)
  {
    this.bZE.bA(paramInt1, paramInt2);
  }
  
  public final void bB(int paramInt1, int paramInt2)
  {
    this.bZE.bB(paramInt1, paramInt2);
  }
  
  public void bf(boolean paramBoolean)
  {
    if (this.bZE.hasObservers()) {
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    this.bZF = paramBoolean;
  }
  
  public final void by(int paramInt1, int paramInt2)
  {
    this.bZE.by(paramInt1, paramInt2);
  }
  
  public final void bz(int paramInt1, int paramInt2)
  {
    this.bZE.bz(paramInt1, paramInt2);
  }
  
  public final VH c(ViewGroup paramViewGroup, int paramInt)
  {
    try
    {
      g.ax("RV CreateView");
      paramViewGroup = b(paramViewGroup, paramInt);
      if (paramViewGroup.caK.getParent() != null) {
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      }
    }
    finally
    {
      g.DS();
    }
    paramViewGroup.caO = paramInt;
    g.DS();
    return paramViewGroup;
  }
  
  public abstract void d(VH paramVH, int paramInt);
  
  public void d(RecyclerView paramRecyclerView) {}
  
  public final void e(int paramInt1, int paramInt2, Object paramObject)
  {
    this.bZE.e(paramInt1, paramInt2, paramObject);
  }
  
  public void e(RecyclerView paramRecyclerView) {}
  
  public final void fV(int paramInt)
  {
    this.bZE.by(paramInt, 1);
  }
  
  public final void fW(int paramInt)
  {
    this.bZE.bA(paramInt, 1);
  }
  
  public final void fX(int paramInt)
  {
    this.bZE.bB(paramInt, 1);
  }
  
  public abstract int getItemCount();
  
  public long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public void n(VH paramVH) {}
  
  public void o(VH paramVH) {}
  
  public void p(VH paramVH) {}
  
  public final void t(int paramInt, Object paramObject)
  {
    this.bZE.e(paramInt, 1, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.a
 * JD-Core Version:    0.7.0.1
 */