package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.widget.k.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a
  extends RecyclerView.a<RecyclerView.v>
{
  private static ViewGroup.LayoutParams hDE = new ViewGroup.LayoutParams(-1, -2);
  RecyclerView.a Sw;
  private ViewGroup hDF;
  private ViewGroup hDG;
  List<View> hDH = new LinkedList();
  private List<View> hDI = new LinkedList();
  b hDJ;
  c hDK;
  RecyclerView.c hDL = new a.1(this);
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    Iterator localIterator;
    if (paramInt == 2147483646)
    {
      if (this.hDF != null) {
        this.hDF.removeAllViews();
      }
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(k.b.support_footer_recycler_view_container, paramViewGroup, false);
      this.hDF = paramViewGroup;
      localIterator = this.hDI.iterator();
      while (localIterator.hasNext()) {
        paramViewGroup.addView((View)localIterator.next(), hDE);
      }
      return new a(paramViewGroup);
    }
    if (paramInt == 2147483647)
    {
      if (this.hDG != null) {
        this.hDG.removeAllViews();
      }
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(k.b.support_footer_recycler_view_container, paramViewGroup, false);
      this.hDG = paramViewGroup;
      localIterator = this.hDH.iterator();
      while (localIterator.hasNext()) {
        paramViewGroup.addView((View)localIterator.next(), hDE);
      }
      return new a(paramViewGroup);
    }
    return this.Sw.a(paramViewGroup, paramInt);
  }
  
  public final void a(int paramInt, View paramView)
  {
    this.hDI.add(paramInt, paramView);
    ah(getItemCount() - 1, 1);
  }
  
  public final void a(final RecyclerView.v paramv, final int paramInt)
  {
    if ((!this.hDH.isEmpty()) && (paramInt == 0)) {
      break label16;
    }
    label16:
    while ((!this.hDI.isEmpty()) && (paramInt == getItemCount() - 1)) {
      return;
    }
    if (this.hDH.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt -= i;
      this.Sw.a(paramv, paramInt);
      if (this.hDJ != null) {
        paramv.aie.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            if (a.b(a.this) != null)
            {
              paramAnonymousView = a.b(a.this);
              View localView = paramv.aie;
              int i = paramInt;
              long l = paramv.aih;
              paramAnonymousView.C(localView, i);
            }
          }
        });
      }
      if (this.hDK == null) {
        break;
      }
      paramv.aie.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          if (a.c(a.this) != null)
          {
            paramAnonymousView = a.c(a.this);
            View localView = paramv.aie;
            long l = paramv.aih;
            return paramAnonymousView.cw(localView);
          }
          return false;
        }
      });
      return;
    }
  }
  
  public final void a(final RecyclerView.v paramv, final int paramInt, List<Object> paramList)
  {
    if ((!this.hDH.isEmpty()) && (paramInt == 0)) {
      break label16;
    }
    label16:
    while ((!this.hDI.isEmpty()) && (paramInt == getItemCount() - 1)) {
      return;
    }
    if (this.hDH.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt -= i;
      this.Sw.a(paramv, paramInt, paramList);
      if (this.hDJ != null) {
        paramv.aie.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            if (a.b(a.this) != null)
            {
              paramAnonymousView = a.b(a.this);
              View localView = paramv.aie;
              int i = paramInt;
              long l = paramv.aih;
              paramAnonymousView.C(localView, i);
            }
          }
        });
      }
      if (this.hDK == null) {
        break;
      }
      paramv.aie.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          if (a.c(a.this) != null)
          {
            paramAnonymousView = a.c(a.this);
            View localView = paramv.aie;
            long l = paramv.aih;
            return paramAnonymousView.cw(localView);
          }
          return false;
        }
      });
      return;
    }
  }
  
  public final void addFooterView(View paramView)
  {
    this.hDI.add(paramView);
    ah(getItemCount() - 1, 1);
  }
  
  public final int atb()
  {
    return this.hDI.size();
  }
  
  public final void cv(View paramView)
  {
    this.hDI.remove(paramView);
    ah(getItemCount() - 1, 1);
  }
  
  public final int getItemCount()
  {
    int j = this.Sw.getItemCount();
    int i = j;
    if (!this.hDH.isEmpty()) {
      i = j + 1;
    }
    j = i;
    if (!this.hDI.isEmpty()) {
      j = i + 1;
    }
    return j;
  }
  
  public final long getItemId(int paramInt)
  {
    if (getItemViewType(paramInt) == 2147483647) {
      return "MRecyclerHeaderView".hashCode();
    }
    if (getItemViewType(paramInt) == 2147483646) {
      return "MRecyclerFooterView".hashCode();
    }
    if (!this.Sw.agM) {
      return paramInt;
    }
    RecyclerView.a locala = this.Sw;
    if (this.hDH.isEmpty()) {}
    for (int i = 0;; i = 1) {
      return locala.getItemId(paramInt - i);
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((!this.hDH.isEmpty()) && (paramInt == 0)) {
      return 2147483647;
    }
    if ((!this.hDI.isEmpty()) && (paramInt == getItemCount() - 1)) {
      return 2147483646;
    }
    RecyclerView.a locala = this.Sw;
    if (this.hDH.isEmpty()) {}
    for (int i = 0;; i = 1) {
      return locala.getItemViewType(paramInt - i);
    }
  }
  
  private static final class a
    extends RecyclerView.v
  {
    a(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.a
 * JD-Core Version:    0.7.0.1
 */