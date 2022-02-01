package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a;
import androidx.core.g.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class u
  extends a
{
  final a cbb;
  final RecyclerView mRecyclerView;
  
  public u(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(194843);
    this.mRecyclerView = paramRecyclerView;
    this.cbb = new a(this);
    AppMethodBeat.o(194843);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(194869);
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!this.mRecyclerView.Kq()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().onInitializeAccessibilityEvent(paramAccessibilityEvent);
      }
    }
    AppMethodBeat.o(194869);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
  {
    AppMethodBeat.i(194860);
    super.onInitializeAccessibilityNodeInfo(paramView, paramd);
    paramd.v(RecyclerView.class.getName());
    if ((!this.mRecyclerView.Kq()) && (this.mRecyclerView.getLayoutManager() != null)) {
      this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(paramd);
    }
    AppMethodBeat.o(194860);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(194848);
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
    {
      AppMethodBeat.o(194848);
      return true;
    }
    if ((!this.mRecyclerView.Kq()) && (this.mRecyclerView.getLayoutManager() != null))
    {
      boolean bool = this.mRecyclerView.getLayoutManager().performAccessibilityAction(paramInt, paramBundle);
      AppMethodBeat.o(194848);
      return bool;
    }
    AppMethodBeat.o(194848);
    return false;
  }
  
  public static class a
    extends a
  {
    final u cbc;
    
    public a(u paramu)
    {
      this.cbc = paramu;
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
    {
      AppMethodBeat.i(195248);
      super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      if ((!this.cbc.mRecyclerView.Kq()) && (this.cbc.mRecyclerView.getLayoutManager() != null)) {
        this.cbc.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(paramView, paramd);
      }
      AppMethodBeat.o(195248);
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(195253);
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      {
        AppMethodBeat.o(195253);
        return true;
      }
      if ((!this.cbc.mRecyclerView.Kq()) && (this.cbc.mRecyclerView.getLayoutManager() != null))
      {
        boolean bool = this.cbc.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(paramView, paramInt, paramBundle);
        AppMethodBeat.o(195253);
        return bool;
      }
      AppMethodBeat.o(195253);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.u
 * JD-Core Version:    0.7.0.1
 */