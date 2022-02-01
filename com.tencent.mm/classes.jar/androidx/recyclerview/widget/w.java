package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a;
import androidx.core.g.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class w
  extends a
{
  final a amB;
  final RecyclerView mRecyclerView;
  
  public w(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(262762);
    this.mRecyclerView = paramRecyclerView;
    this.amB = new a(this);
    AppMethodBeat.o(262762);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(262766);
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!this.mRecyclerView.lG()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().onInitializeAccessibilityEvent(paramAccessibilityEvent);
      }
    }
    AppMethodBeat.o(262766);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
  {
    AppMethodBeat.i(262765);
    super.onInitializeAccessibilityNodeInfo(paramView, paramd);
    paramd.t(RecyclerView.class.getName());
    if ((!this.mRecyclerView.lG()) && (this.mRecyclerView.getLayoutManager() != null)) {
      this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(paramd);
    }
    AppMethodBeat.o(262765);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(262763);
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
    {
      AppMethodBeat.o(262763);
      return true;
    }
    if ((!this.mRecyclerView.lG()) && (this.mRecyclerView.getLayoutManager() != null))
    {
      boolean bool = this.mRecyclerView.getLayoutManager().performAccessibilityAction(paramInt, paramBundle);
      AppMethodBeat.o(262763);
      return bool;
    }
    AppMethodBeat.o(262763);
    return false;
  }
  
  public static final class a
    extends a
  {
    final w amC;
    
    public a(w paramw)
    {
      this.amC = paramw;
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
    {
      AppMethodBeat.i(262759);
      super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      if ((!this.amC.mRecyclerView.lG()) && (this.amC.mRecyclerView.getLayoutManager() != null)) {
        this.amC.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(paramView, paramd);
      }
      AppMethodBeat.o(262759);
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(262760);
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      {
        AppMethodBeat.o(262760);
        return true;
      }
      if ((!this.amC.mRecyclerView.lG()) && (this.amC.mRecyclerView.getLayoutManager() != null))
      {
        boolean bool = this.amC.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(paramView, paramInt, paramBundle);
        AppMethodBeat.o(262760);
        return bool;
      }
      AppMethodBeat.o(262760);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.recyclerview.widget.w
 * JD-Core Version:    0.7.0.1
 */