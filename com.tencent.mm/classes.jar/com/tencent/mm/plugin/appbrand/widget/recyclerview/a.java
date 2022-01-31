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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a
  extends RecyclerView.a<RecyclerView.v>
{
  private static ViewGroup.LayoutParams jwe;
  RecyclerView.a Tg;
  private ViewGroup jwf;
  private ViewGroup jwg;
  List<View> jwh;
  private List<View> jwi;
  b jwj;
  c jwk;
  RecyclerView.c jwl;
  
  static
  {
    AppMethodBeat.i(77477);
    jwe = new ViewGroup.LayoutParams(-1, -2);
    AppMethodBeat.o(77477);
  }
  
  a()
  {
    AppMethodBeat.i(77466);
    this.jwh = new LinkedList();
    this.jwi = new LinkedList();
    this.jwl = new a.1(this);
    AppMethodBeat.o(77466);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(77472);
    Iterator localIterator;
    if (paramInt == 2147483646)
    {
      if (this.jwf != null) {
        this.jwf.removeAllViews();
      }
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970978, paramViewGroup, false);
      this.jwf = paramViewGroup;
      localIterator = this.jwi.iterator();
      while (localIterator.hasNext()) {
        paramViewGroup.addView((View)localIterator.next(), jwe);
      }
      paramViewGroup = new a(paramViewGroup);
      AppMethodBeat.o(77472);
      return paramViewGroup;
    }
    if (paramInt == 2147483647)
    {
      if (this.jwg != null) {
        this.jwg.removeAllViews();
      }
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970978, paramViewGroup, false);
      this.jwg = paramViewGroup;
      localIterator = this.jwh.iterator();
      while (localIterator.hasNext()) {
        paramViewGroup.addView((View)localIterator.next(), jwe);
      }
      paramViewGroup = new a(paramViewGroup);
      AppMethodBeat.o(77472);
      return paramViewGroup;
    }
    paramViewGroup = this.Tg.a(paramViewGroup, paramInt);
    AppMethodBeat.o(77472);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(77470);
    if ((!this.jwh.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(77470);
      return;
    }
    if ((!this.jwi.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(77470);
      return;
    }
    if (this.jwh.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt -= i;
      this.Tg.a(paramv, paramInt);
      if (this.jwj != null) {
        paramv.aku.setOnClickListener(new a.2(this, paramv, paramInt));
      }
      if (this.jwk != null) {
        paramv.aku.setOnLongClickListener(new a.3(this, paramv, paramInt));
      }
      AppMethodBeat.o(77470);
      return;
    }
  }
  
  public final void a(final RecyclerView.v paramv, final int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(77471);
    if ((!this.jwh.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(77471);
      return;
    }
    if ((!this.jwi.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(77471);
      return;
    }
    if (this.jwh.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt -= i;
      this.Tg.a(paramv, paramInt, paramList);
      if (this.jwj != null) {
        paramv.aku.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(77464);
            if (a.b(a.this) != null) {
              a.b(a.this).L(paramv.aku, paramInt);
            }
            AppMethodBeat.o(77464);
          }
        });
      }
      if (this.jwk != null) {
        paramv.aku.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(77465);
            if (a.c(a.this) != null)
            {
              boolean bool = a.c(a.this).M(paramv.aku, paramInt);
              AppMethodBeat.o(77465);
              return bool;
            }
            AppMethodBeat.o(77465);
            return false;
          }
        });
      }
      AppMethodBeat.o(77471);
      return;
    }
  }
  
  public final int aSl()
  {
    AppMethodBeat.i(77473);
    int i = this.jwi.size();
    AppMethodBeat.o(77473);
    return i;
  }
  
  public final void addFooterView(View paramView)
  {
    AppMethodBeat.i(77474);
    this.jwi.add(paramView);
    an(getItemCount() - 1, 1);
    AppMethodBeat.o(77474);
  }
  
  public final void b(int paramInt, View paramView)
  {
    AppMethodBeat.i(77475);
    this.jwi.add(paramInt, paramView);
    an(getItemCount() - 1, 1);
    AppMethodBeat.o(77475);
  }
  
  public final void cZ(View paramView)
  {
    AppMethodBeat.i(77476);
    this.jwi.remove(paramView);
    an(getItemCount() - 1, 1);
    AppMethodBeat.o(77476);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(77469);
    int j = this.Tg.getItemCount();
    int i = j;
    if (!this.jwh.isEmpty()) {
      i = j + 1;
    }
    j = i;
    if (!this.jwi.isEmpty()) {
      j = i + 1;
    }
    AppMethodBeat.o(77469);
    return j;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(77468);
    long l;
    if (getItemViewType(paramInt) == 2147483647)
    {
      l = "MRecyclerHeaderView".hashCode();
      AppMethodBeat.o(77468);
      return l;
    }
    if (getItemViewType(paramInt) == 2147483646)
    {
      l = "MRecyclerFooterView".hashCode();
      AppMethodBeat.o(77468);
      return l;
    }
    if (!this.Tg.ajc)
    {
      l = paramInt;
      AppMethodBeat.o(77468);
      return l;
    }
    RecyclerView.a locala = this.Tg;
    if (this.jwh.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      l = locala.getItemId(paramInt - i);
      AppMethodBeat.o(77468);
      return l;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(77467);
    if ((!this.jwh.isEmpty()) && (paramInt == 0))
    {
      AppMethodBeat.o(77467);
      return 2147483647;
    }
    if ((!this.jwi.isEmpty()) && (paramInt == getItemCount() - 1))
    {
      AppMethodBeat.o(77467);
      return 2147483646;
    }
    RecyclerView.a locala = this.Tg;
    if (this.jwh.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      paramInt = locala.getItemViewType(paramInt - i);
      AppMethodBeat.o(77467);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.a
 * JD-Core Version:    0.7.0.1
 */