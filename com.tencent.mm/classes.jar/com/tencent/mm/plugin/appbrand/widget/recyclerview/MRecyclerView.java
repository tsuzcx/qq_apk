package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class MRecyclerView
  extends RecyclerView
{
  private View DR;
  protected a mmF;
  private a mmG;
  private b mmH;
  
  public MRecyclerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(131570);
    init();
    AppMethodBeat.o(131570);
  }
  
  public MRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131571);
    init();
    AppMethodBeat.o(131571);
  }
  
  public MRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(131572);
    init();
    AppMethodBeat.o(131572);
  }
  
  private void init()
  {
    AppMethodBeat.i(131573);
    this.mmF = new a();
    if (buJ()) {
      this.mmF.av(true);
    }
    super.setAdapter(this.mmF);
    this.mmF.a(new RecyclerView.c()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(131567);
        View localView;
        if (MRecyclerView.a(MRecyclerView.this) != null)
        {
          localView = MRecyclerView.a(MRecyclerView.this);
          if (!MRecyclerView.this.buI()) {
            break label46;
          }
        }
        label46:
        for (int i = 0;; i = 8)
        {
          localView.setVisibility(i);
          AppMethodBeat.o(131567);
          return;
        }
      }
    });
    AppMethodBeat.o(131573);
  }
  
  public final int S(RecyclerView.v paramv)
  {
    AppMethodBeat.i(131574);
    if (this.mmF == null)
    {
      AppMethodBeat.o(131574);
      return -1;
    }
    a locala = this.mmF;
    if (paramv == null)
    {
      AppMethodBeat.o(131574);
      return -1;
    }
    if (paramv.ln() == -1)
    {
      AppMethodBeat.o(131574);
      return -1;
    }
    int j = paramv.ln();
    if (locala.mmt.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      AppMethodBeat.o(131574);
      return j - i;
    }
  }
  
  public void addFooterView(View paramView)
  {
    AppMethodBeat.i(131578);
    this.mmF.addFooterView(paramView);
    AppMethodBeat.o(131578);
  }
  
  public final void addHeaderView(View paramView)
  {
    AppMethodBeat.i(131577);
    a locala = this.mmF;
    locala.mmt.add(paramView);
    locala.ao(0, 1);
    AppMethodBeat.o(131577);
  }
  
  protected boolean buI()
  {
    AppMethodBeat.i(131584);
    if (this.mmF.getItemCount() == 0)
    {
      AppMethodBeat.o(131584);
      return true;
    }
    AppMethodBeat.o(131584);
    return false;
  }
  
  protected boolean buJ()
  {
    return true;
  }
  
  public final void c(int paramInt, View paramView)
  {
    AppMethodBeat.i(131579);
    this.mmF.c(paramInt, paramView);
    AppMethodBeat.o(131579);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(131576);
    super.ca(paramInt);
    AppMethodBeat.o(131576);
  }
  
  public final void dq(View paramView)
  {
    AppMethodBeat.i(131580);
    this.mmF.dq(paramView);
    AppMethodBeat.o(131580);
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.mmF;
  }
  
  public View getEmptyView()
  {
    return this.DR;
  }
  
  public void setAdapter(RecyclerView.a parama)
  {
    AppMethodBeat.i(131575);
    a locala = this.mmF;
    if (locala.aaj != null)
    {
      if (!locala.aaj.equals(parama)) {
        locala.aaj.b(locala.mmx);
      }
    }
    else
    {
      locala.aaj = parama;
      if (locala.aaj != null) {
        locala.aaj.a(locala.mmx);
      }
    }
    AppMethodBeat.o(131575);
  }
  
  public void setEmptyView(View paramView)
  {
    AppMethodBeat.i(131581);
    if (this.DR == paramView)
    {
      AppMethodBeat.o(131581);
      return;
    }
    this.DR = paramView;
    if (this.DR != null)
    {
      paramView = this.DR;
      if (!buI()) {
        break label56;
      }
    }
    label56:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(131581);
      return;
    }
  }
  
  public void setOnItemClickListener(a parama)
  {
    AppMethodBeat.i(131582);
    this.mmG = parama;
    this.mmF.mmv = new b()
    {
      public final void Q(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(131568);
        if (MRecyclerView.b(MRecyclerView.this) != null) {
          MRecyclerView.b(MRecyclerView.this).S(paramAnonymousView, paramAnonymousInt);
        }
        AppMethodBeat.o(131568);
      }
    };
    AppMethodBeat.o(131582);
  }
  
  public void setOnItemLongClickListener(b paramb)
  {
    AppMethodBeat.i(131583);
    this.mmH = paramb;
    this.mmF.mmw = new c()
    {
      public final boolean R(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(131569);
        if (MRecyclerView.c(MRecyclerView.this) != null)
        {
          boolean bool = MRecyclerView.c(MRecyclerView.this).T(paramAnonymousView, paramAnonymousInt);
          AppMethodBeat.o(131569);
          return bool;
        }
        AppMethodBeat.o(131569);
        return false;
      }
    };
    AppMethodBeat.o(131583);
  }
  
  public static abstract interface a
  {
    public abstract void S(View paramView, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean T(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView
 * JD-Core Version:    0.7.0.1
 */