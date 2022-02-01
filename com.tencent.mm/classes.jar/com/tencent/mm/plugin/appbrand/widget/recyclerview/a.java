package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.w;
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
  extends RecyclerView.a<RecyclerView.w>
{
  private static ViewGroup.LayoutParams mOr;
  RecyclerView.a abe;
  private ViewGroup mOs;
  private ViewGroup mOt;
  List<View> mOu;
  private List<View> mOv;
  b mOw;
  c mOx;
  RecyclerView.c mOy;
  
  static
  {
    AppMethodBeat.i(131553);
    mOr = new ViewGroup.LayoutParams(-1, -2);
    AppMethodBeat.o(131553);
  }
  
  a()
  {
    AppMethodBeat.i(131542);
    this.mOu = new LinkedList();
    this.mOv = new LinkedList();
    this.mOy = new RecyclerView.c()
    {
      public final void as(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131533);
        if (a.a(a.this).isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          a.this.ao(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(131533);
          return;
        }
      }
      
      public final void at(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131535);
        if (a.a(a.this).isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          a.this.aq(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(131535);
          return;
        }
      }
      
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131536);
        if (a.a(a.this).isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          a.this.ar(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(131536);
          return;
        }
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
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
      
      public final void l(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
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
            locala.ap(paramAnonymousInt3 + paramAnonymousInt1, i + paramAnonymousInt2);
            AppMethodBeat.o(169241);
            return;
            paramAnonymousInt3 = 1;
            break;
            label72:
            i = 1;
          }
        }
        a.this.arg.notifyChanged();
        AppMethodBeat.o(169241);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(131532);
        a.this.arg.notifyChanged();
        AppMethodBeat.o(131532);
      }
    };
    AppMethodBeat.o(131542);
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(131548);
    Iterator localIterator;
    if (paramInt == 2147483646)
    {
      if (this.mOs != null) {
        this.mOs.removeAllViews();
      }
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495734, paramViewGroup, false);
      this.mOs = paramViewGroup;
      localIterator = this.mOv.iterator();
      while (localIterator.hasNext()) {
        paramViewGroup.addView((View)localIterator.next(), mOr);
      }
      paramViewGroup = new a(paramViewGroup);
      AppMethodBeat.o(131548);
      return paramViewGroup;
    }
    if (paramInt == 2147483647)
    {
      if (this.mOt != null) {
        this.mOt.removeAllViews();
      }
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495734, paramViewGroup, false);
      this.mOt = paramViewGroup;
      localIterator = this.mOu.iterator();
      while (localIterator.hasNext()) {
        paramViewGroup.addView((View)localIterator.next(), mOr);
      }
      paramViewGroup = new a(paramViewGroup);
      AppMethodBeat.o(131548);
      return paramViewGroup;
    }
    paramViewGroup = this.abe.a(paramViewGroup, paramInt);
    AppMethodBeat.o(131548);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.w paramw, final int paramInt)
  {
    AppMethodBeat.i(131546);
    if ((!this.mOu.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(131546);
      return;
    }
    if ((!this.mOv.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(131546);
      return;
    }
    if (this.mOu.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt -= i;
      this.abe.a(paramw, paramInt);
      if (this.mOw != null) {
        paramw.asD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131538);
            if (a.b(a.this) != null) {
              a.b(a.this).R(paramw.asD, paramInt);
            }
            AppMethodBeat.o(131538);
          }
        });
      }
      if (this.mOx != null) {
        paramw.asD.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131539);
            if (a.c(a.this) != null)
            {
              boolean bool = a.c(a.this).S(paramw.asD, paramInt);
              AppMethodBeat.o(131539);
              return bool;
            }
            AppMethodBeat.o(131539);
            return false;
          }
        });
      }
      AppMethodBeat.o(131546);
      return;
    }
  }
  
  public final void a(final RecyclerView.w paramw, final int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(131547);
    if ((!this.mOu.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(131547);
      return;
    }
    if ((!this.mOv.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(131547);
      return;
    }
    if (this.mOu.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt -= i;
      this.abe.a(paramw, paramInt, paramList);
      if (this.mOw != null) {
        paramw.asD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131540);
            if (a.b(a.this) != null) {
              a.b(a.this).R(paramw.asD, paramInt);
            }
            AppMethodBeat.o(131540);
          }
        });
      }
      if (this.mOx != null) {
        paramw.asD.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131541);
            if (a.c(a.this) != null)
            {
              boolean bool = a.c(a.this).S(paramw.asD, paramInt);
              AppMethodBeat.o(131541);
              return bool;
            }
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
    this.mOv.add(paramView);
    ao(getItemCount() - 1, 1);
    AppMethodBeat.o(131550);
  }
  
  public final int bBE()
  {
    AppMethodBeat.i(131549);
    int i = this.mOv.size();
    AppMethodBeat.o(131549);
    return i;
  }
  
  public final void c(int paramInt, View paramView)
  {
    AppMethodBeat.i(131551);
    this.mOv.add(paramInt, paramView);
    ao(getItemCount() - 1, 1);
    AppMethodBeat.o(131551);
  }
  
  public final void ds(View paramView)
  {
    AppMethodBeat.i(131552);
    this.mOv.remove(paramView);
    ao(getItemCount() - 1, 1);
    AppMethodBeat.o(131552);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(131545);
    if (this.abe == null) {}
    for (int j = 0;; j = this.abe.getItemCount())
    {
      int i = j;
      if (!this.mOu.isEmpty()) {
        i = j + 1;
      }
      j = i;
      if (!this.mOv.isEmpty()) {
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
    if (!this.abe.arh)
    {
      l = paramInt;
      AppMethodBeat.o(131544);
      return l;
    }
    RecyclerView.a locala = this.abe;
    if (this.mOu.isEmpty()) {}
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
    if ((!this.mOu.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(131543);
      return 2147483647;
    }
    if ((!this.mOv.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(131543);
      return 2147483646;
    }
    RecyclerView.a locala = this.abe;
    if (this.mOu.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt = locala.getItemViewType(paramInt - i);
      AppMethodBeat.o(131543);
      return paramInt;
    }
  }
  
  static final class a
    extends RecyclerView.w
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