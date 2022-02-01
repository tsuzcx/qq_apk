package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.c.d;
import java.util.List;

public abstract class RecyclerView$a<VH extends RecyclerView.v>
{
  public final RecyclerView.b alc = new RecyclerView.b();
  protected boolean ald = false;
  
  public void a(RecyclerView.c paramc)
  {
    this.alc.registerObserver(paramc);
  }
  
  public void a(VH paramVH, int paramInt, List<Object> paramList)
  {
    d(paramVH, paramInt);
  }
  
  public final void aE(int paramInt1, int paramInt2)
  {
    this.alc.aE(paramInt1, paramInt2);
  }
  
  public final void aF(int paramInt1, int paramInt2)
  {
    this.alc.aF(paramInt1, paramInt2);
  }
  
  public final void aG(int paramInt1, int paramInt2)
  {
    this.alc.aG(paramInt1, paramInt2);
  }
  
  public final void aH(int paramInt1, int paramInt2)
  {
    this.alc.aH(paramInt1, paramInt2);
  }
  
  public void aw(boolean paramBoolean)
  {
    if (this.alc.hasObservers()) {
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    this.ald = paramBoolean;
  }
  
  public abstract VH b(ViewGroup paramViewGroup, int paramInt);
  
  public void b(RecyclerView.c paramc)
  {
    this.alc.unregisterObserver(paramc);
  }
  
  public final VH c(ViewGroup paramViewGroup, int paramInt)
  {
    try
    {
      d.D("RV CreateView");
      paramViewGroup = b(paramViewGroup, paramInt);
      if (paramViewGroup.amk.getParent() != null) {
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      }
    }
    finally
    {
      d.gH();
    }
    paramViewGroup.amo = paramInt;
    d.gH();
    return paramViewGroup;
  }
  
  public final void cL(int paramInt)
  {
    this.alc.aE(paramInt, 1);
  }
  
  public final void cM(int paramInt)
  {
    this.alc.aG(paramInt, 1);
  }
  
  public final void cN(int paramInt)
  {
    this.alc.aH(paramInt, 1);
  }
  
  public final void d(int paramInt, Object paramObject)
  {
    this.alc.e(paramInt, 1, paramObject);
  }
  
  public abstract void d(VH paramVH, int paramInt);
  
  public void d(RecyclerView paramRecyclerView) {}
  
  public final void e(int paramInt1, int paramInt2, Object paramObject)
  {
    this.alc.e(paramInt1, paramInt2, paramObject);
  }
  
  public void e(RecyclerView paramRecyclerView) {}
  
  public abstract int getItemCount();
  
  public long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public void m(VH paramVH) {}
  
  public void n(VH paramVH) {}
  
  public final void notifyDataSetChanged()
  {
    this.alc.notifyChanged();
  }
  
  public void o(VH paramVH) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.a
 * JD-Core Version:    0.7.0.1
 */