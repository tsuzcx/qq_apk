package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.n.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a
  extends RecyclerView.a<RecyclerView.v>
{
  private static ViewGroup.LayoutParams rFL;
  RecyclerView.a afJ;
  private ViewGroup rFM;
  private ViewGroup rFN;
  List<View> rFO;
  private List<View> rFP;
  b rFQ;
  c rFR;
  RecyclerView.c rFS;
  
  static
  {
    AppMethodBeat.i(131553);
    rFL = new ViewGroup.LayoutParams(-1, -2);
    AppMethodBeat.o(131553);
  }
  
  a()
  {
    AppMethodBeat.i(131542);
    this.rFO = new LinkedList();
    this.rFP = new LinkedList();
    this.rFS = new RecyclerView.c()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(131532);
        a.this.alc.notifyChanged();
        AppMethodBeat.o(131532);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131533);
        if (a.a(a.this).isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          a.this.aE(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(131533);
          return;
        }
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(131534);
        if (a.a(a.this).isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          a.this.e(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
          AppMethodBeat.o(131534);
          return;
        }
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131535);
        if (a.a(a.this).isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          a.this.aG(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(131535);
          return;
        }
      }
      
      public final void onItemRangeMoved(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        int i = 0;
        AppMethodBeat.i(169241);
        if (paramAnonymousInt3 == 1)
        {
          a locala = a.this;
          if (a.a(locala).isEmpty())
          {
            paramAnonymousInt3 = 0;
            if (!a.a(a.this).isEmpty()) {
              break label72;
            }
          }
          for (;;)
          {
            locala.aF(paramAnonymousInt3 + paramAnonymousInt1, i + paramAnonymousInt2);
            AppMethodBeat.o(169241);
            return;
            paramAnonymousInt3 = 1;
            break;
            label72:
            i = 1;
          }
        }
        a.this.alc.notifyChanged();
        AppMethodBeat.o(169241);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131536);
        if (a.a(a.this).isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          a.this.aH(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(131536);
          return;
        }
      }
    };
    AppMethodBeat.o(131542);
  }
  
  public final void a(final RecyclerView.v paramv, final int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(230452);
    if ((!this.rFO.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(230452);
      return;
    }
    if ((!this.rFP.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(230452);
      return;
    }
    if (this.rFO.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt -= i;
      this.afJ.a(paramv, paramInt, paramList);
      if (this.rFQ != null) {
        paramv.amk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131540);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (a.b(a.this) != null) {
              a.b(a.this).S(paramv.amk, paramInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131540);
          }
        });
      }
      if (this.rFR != null) {
        paramv.amk.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131541);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
            if (a.c(a.this) != null)
            {
              boolean bool = a.c(a.this).T(paramv.amk, paramInt);
              com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(131541);
              return bool;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(131541);
            return false;
          }
        });
      }
      AppMethodBeat.o(230452);
      return;
    }
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(230457);
    Iterator localIterator;
    if (paramInt == 2147483646)
    {
      if (this.rFM != null) {
        this.rFM.removeAllViews();
      }
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(n.d.support_footer_recycler_view_container, paramViewGroup, false);
      this.rFM = paramViewGroup;
      localIterator = this.rFP.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if ((localView.getParent() instanceof ViewGroup)) {
          ((ViewGroup)localView.getParent()).removeView(localView);
        }
        paramViewGroup.addView(localView, rFL);
      }
      paramViewGroup = new a.a(paramViewGroup);
      AppMethodBeat.o(230457);
      return paramViewGroup;
    }
    if (paramInt == 2147483647)
    {
      if (this.rFN != null) {
        this.rFN.removeAllViews();
      }
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(n.d.support_footer_recycler_view_container, paramViewGroup, false);
      this.rFN = paramViewGroup;
      localIterator = this.rFO.iterator();
      while (localIterator.hasNext()) {
        paramViewGroup.addView((View)localIterator.next(), rFL);
      }
      paramViewGroup = new a.a(paramViewGroup);
      AppMethodBeat.o(230457);
      return paramViewGroup;
    }
    paramViewGroup = this.afJ.b(paramViewGroup, paramInt);
    AppMethodBeat.o(230457);
    return paramViewGroup;
  }
  
  public final void c(int paramInt, View paramView)
  {
    AppMethodBeat.i(131551);
    this.rFP.add(paramInt, paramView);
    aE(getItemCount() - 1, 1);
    AppMethodBeat.o(131551);
  }
  
  public final int cqm()
  {
    AppMethodBeat.i(131549);
    int i = this.rFP.size();
    AppMethodBeat.o(131549);
    return i;
  }
  
  public final void d(final RecyclerView.v paramv, final int paramInt)
  {
    AppMethodBeat.i(230449);
    if ((!this.rFO.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(230449);
      return;
    }
    if ((!this.rFP.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(230449);
      return;
    }
    if (this.rFO.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt -= i;
      this.afJ.d(paramv, paramInt);
      if (this.rFQ != null) {
        paramv.amk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131538);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (a.b(a.this) != null) {
              a.b(a.this).S(paramv.amk, paramInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131538);
          }
        });
      }
      if (this.rFR != null) {
        paramv.amk.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131539);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
            if (a.c(a.this) != null)
            {
              boolean bool = a.c(a.this).T(paramv.amk, paramInt);
              com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(131539);
              return bool;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(131539);
            return false;
          }
        });
      }
      AppMethodBeat.o(230449);
      return;
    }
  }
  
  public final void dG(View paramView)
  {
    AppMethodBeat.i(131550);
    this.rFP.add(paramView);
    aE(getItemCount() - 1, 1);
    AppMethodBeat.o(131550);
  }
  
  public final void dH(View paramView)
  {
    AppMethodBeat.i(131552);
    this.rFP.remove(paramView);
    aE(getItemCount() - 1, 1);
    AppMethodBeat.o(131552);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(131545);
    if (this.afJ == null) {}
    for (int j = 0;; j = this.afJ.getItemCount())
    {
      int i = j;
      if (!this.rFO.isEmpty()) {
        i = j + 1;
      }
      j = i;
      if (!this.rFP.isEmpty()) {
        j = i + 1;
      }
      AppMethodBeat.o(131545);
      return j;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(131544);
    long l;
    if (getItemViewType(paramInt) == 2147483647)
    {
      l = "MRecyclerHeaderView".hashCode();
      AppMethodBeat.o(131544);
      return l;
    }
    if (getItemViewType(paramInt) == 2147483646)
    {
      l = "MRecyclerFooterView".hashCode();
      AppMethodBeat.o(131544);
      return l;
    }
    if (!this.afJ.ald)
    {
      l = paramInt;
      AppMethodBeat.o(131544);
      return l;
    }
    RecyclerView.a locala = this.afJ;
    if (this.rFO.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      l = locala.getItemId(paramInt - i);
      AppMethodBeat.o(131544);
      return l;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(131543);
    if ((!this.rFO.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(131543);
      return 2147483647;
    }
    if ((!this.rFP.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(131543);
      return 2147483646;
    }
    RecyclerView.a locala = this.afJ;
    if (this.rFO.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt = locala.getItemViewType(paramInt - i);
      AppMethodBeat.o(131543);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.a
 * JD-Core Version:    0.7.0.1
 */