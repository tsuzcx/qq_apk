package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a
  extends RecyclerView.a<RecyclerView.v>
{
  private static ViewGroup.LayoutParams oEc;
  RecyclerView.a adj;
  private ViewGroup oEd;
  private ViewGroup oEe;
  List<View> oEf;
  private List<View> oEg;
  b oEh;
  c oEi;
  RecyclerView.c oEj;
  
  static
  {
    AppMethodBeat.i(131553);
    oEc = new ViewGroup.LayoutParams(-1, -2);
    AppMethodBeat.o(131553);
  }
  
  a()
  {
    AppMethodBeat.i(131542);
    this.oEf = new LinkedList();
    this.oEg = new LinkedList();
    this.oEj = new RecyclerView.c()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(131532);
        a.this.atj.notifyChanged();
        AppMethodBeat.o(131532);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131533);
        if (a.a(a.this).isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          a.this.aq(i + paramAnonymousInt1, paramAnonymousInt2);
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
          a.this.as(i + paramAnonymousInt1, paramAnonymousInt2);
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
            locala.ar(paramAnonymousInt3 + paramAnonymousInt1, i + paramAnonymousInt2);
            AppMethodBeat.o(169241);
            return;
            paramAnonymousInt3 = 1;
            break;
            label72:
            i = 1;
          }
        }
        a.this.atj.notifyChanged();
        AppMethodBeat.o(169241);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131536);
        if (a.a(a.this).isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          a.this.at(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(131536);
          return;
        }
      }
    };
    AppMethodBeat.o(131542);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(131548);
    Iterator localIterator;
    if (paramInt == 2147483646)
    {
      if (this.oEd != null) {
        this.oEd.removeAllViews();
      }
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496639, paramViewGroup, false);
      this.oEd = paramViewGroup;
      localIterator = this.oEg.iterator();
      while (localIterator.hasNext()) {
        paramViewGroup.addView((View)localIterator.next(), oEc);
      }
      paramViewGroup = new a(paramViewGroup);
      AppMethodBeat.o(131548);
      return paramViewGroup;
    }
    if (paramInt == 2147483647)
    {
      if (this.oEe != null) {
        this.oEe.removeAllViews();
      }
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496639, paramViewGroup, false);
      this.oEe = paramViewGroup;
      localIterator = this.oEf.iterator();
      while (localIterator.hasNext()) {
        paramViewGroup.addView((View)localIterator.next(), oEc);
      }
      paramViewGroup = new a(paramViewGroup);
      AppMethodBeat.o(131548);
      return paramViewGroup;
    }
    paramViewGroup = this.adj.a(paramViewGroup, paramInt);
    AppMethodBeat.o(131548);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.v paramv, final int paramInt)
  {
    AppMethodBeat.i(131546);
    if ((!this.oEf.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(131546);
      return;
    }
    if ((!this.oEg.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(131546);
      return;
    }
    if (this.oEf.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt -= i;
      this.adj.a(paramv, paramInt);
      if (this.oEh != null) {
        paramv.aus.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131538);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (a.b(a.this) != null) {
              a.b(a.this).Q(paramv.aus, paramInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131538);
          }
        });
      }
      if (this.oEi != null) {
        paramv.aus.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131539);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
            if (a.c(a.this) != null)
            {
              boolean bool = a.c(a.this).R(paramv.aus, paramInt);
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
      AppMethodBeat.o(131546);
      return;
    }
  }
  
  public final void a(final RecyclerView.v paramv, final int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(131547);
    if ((!this.oEf.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(131547);
      return;
    }
    if ((!this.oEg.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(131547);
      return;
    }
    if (this.oEf.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt -= i;
      this.adj.a(paramv, paramInt, paramList);
      if (this.oEh != null) {
        paramv.aus.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131540);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (a.b(a.this) != null) {
              a.b(a.this).Q(paramv.aus, paramInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131540);
          }
        });
      }
      if (this.oEi != null) {
        paramv.aus.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131541);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
            if (a.c(a.this) != null)
            {
              boolean bool = a.c(a.this).R(paramv.aus, paramInt);
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
      AppMethodBeat.o(131547);
      return;
    }
  }
  
  public final void addFooterView(View paramView)
  {
    AppMethodBeat.i(131550);
    this.oEg.add(paramView);
    aq(getItemCount() - 1, 1);
    AppMethodBeat.o(131550);
  }
  
  public final void c(int paramInt, View paramView)
  {
    AppMethodBeat.i(131551);
    this.oEg.add(paramInt, paramView);
    aq(getItemCount() - 1, 1);
    AppMethodBeat.o(131551);
  }
  
  public final int cda()
  {
    AppMethodBeat.i(131549);
    int i = this.oEg.size();
    AppMethodBeat.o(131549);
    return i;
  }
  
  public final void dl(View paramView)
  {
    AppMethodBeat.i(131552);
    this.oEg.remove(paramView);
    aq(getItemCount() - 1, 1);
    AppMethodBeat.o(131552);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(131545);
    if (this.adj == null) {}
    for (int j = 0;; j = this.adj.getItemCount())
    {
      int i = j;
      if (!this.oEf.isEmpty()) {
        i = j + 1;
      }
      j = i;
      if (!this.oEg.isEmpty()) {
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
    if (!this.adj.atk)
    {
      l = paramInt;
      AppMethodBeat.o(131544);
      return l;
    }
    RecyclerView.a locala = this.adj;
    if (this.oEf.isEmpty()) {}
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
    if ((!this.oEf.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(131543);
      return 2147483647;
    }
    if ((!this.oEg.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(131543);
      return 2147483646;
    }
    RecyclerView.a locala = this.adj;
    if (this.oEf.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt = locala.getItemViewType(paramInt - i);
      AppMethodBeat.o(131543);
      return paramInt;
    }
  }
  
  static final class a
    extends RecyclerView.v
  {
    a(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.a
 * JD-Core Version:    0.7.0.1
 */