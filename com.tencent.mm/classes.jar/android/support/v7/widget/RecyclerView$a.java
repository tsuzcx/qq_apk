package android.support.v7.widget;

import android.support.v4.os.e;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public abstract class RecyclerView$a<VH extends RecyclerView.v>
{
  public final RecyclerView.b ajb = new RecyclerView.b();
  protected boolean ajc = false;
  
  public abstract VH a(ViewGroup paramViewGroup, int paramInt);
  
  public final void a(RecyclerView.c paramc)
  {
    this.ajb.registerObserver(paramc);
  }
  
  public void a(VH paramVH) {}
  
  public abstract void a(VH paramVH, int paramInt);
  
  public void a(VH paramVH, int paramInt, List<Object> paramList)
  {
    a(paramVH, paramInt);
  }
  
  public final void an(int paramInt1, int paramInt2)
  {
    this.ajb.an(paramInt1, paramInt2);
  }
  
  public final void ao(int paramInt1, int paramInt2)
  {
    this.ajb.ao(paramInt1, paramInt2);
  }
  
  public final void ap(int paramInt1, int paramInt2)
  {
    this.ajb.ap(paramInt1, paramInt2);
  }
  
  public final void aq(int paramInt1, int paramInt2)
  {
    this.ajb.aq(paramInt1, paramInt2);
  }
  
  public final void b(RecyclerView.c paramc)
  {
    this.ajb.unregisterObserver(paramc);
  }
  
  public final void bR(int paramInt)
  {
    this.ajb.an(paramInt, 1);
  }
  
  public final void bS(int paramInt)
  {
    this.ajb.ap(paramInt, 1);
  }
  
  public final void bT(int paramInt)
  {
    this.ajb.aq(paramInt, 1);
  }
  
  public final VH c(ViewGroup paramViewGroup, int paramInt)
  {
    try
    {
      e.beginSection("RV CreateView");
      paramViewGroup = a(paramViewGroup, paramInt);
      if (paramViewGroup.aku.getParent() != null) {
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      }
    }
    finally
    {
      e.endSection();
    }
    paramViewGroup.aky = paramInt;
    e.endSection();
    return paramViewGroup;
  }
  
  public final void c(int paramInt, Object paramObject)
  {
    this.ajb.e(paramInt, 1, paramObject);
  }
  
  public final void e(int paramInt1, int paramInt2, Object paramObject)
  {
    this.ajb.e(paramInt1, paramInt2, paramObject);
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
  
  public final void jv()
  {
    if (this.ajb.hasObservers()) {
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    this.ajc = true;
  }
  
  public void k(VH paramVH) {}
  
  public final void notifyDataSetChanged()
  {
    this.ajb.notifyChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.a
 * JD-Core Version:    0.7.0.1
 */