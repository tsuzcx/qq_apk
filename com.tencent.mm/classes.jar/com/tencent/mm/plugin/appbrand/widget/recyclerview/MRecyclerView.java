package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class MRecyclerView
  extends RecyclerView
{
  private View Xd;
  protected a rGa;
  private MRecyclerView.a rGb;
  private MRecyclerView.b rGc;
  
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
    this.rGa = new a();
    if (cqo()) {
      this.rGa.aw(true);
    }
    super.setAdapter(this.rGa);
    this.rGa.a(new RecyclerView.c()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(131567);
        View localView;
        if (MRecyclerView.a(MRecyclerView.this) != null)
        {
          localView = MRecyclerView.a(MRecyclerView.this);
          if (!MRecyclerView.this.cqn()) {
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
  
  public final int U(RecyclerView.v paramv)
  {
    AppMethodBeat.i(230931);
    if (this.rGa == null)
    {
      AppMethodBeat.o(230931);
      return -1;
    }
    a locala = this.rGa;
    if (paramv == null)
    {
      AppMethodBeat.o(230931);
      return -1;
    }
    if (paramv.md() == -1)
    {
      AppMethodBeat.o(230931);
      return -1;
    }
    int j = paramv.md();
    if (locala.rFO.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      AppMethodBeat.o(230931);
      return j - i;
    }
  }
  
  public final void c(int paramInt, View paramView)
  {
    AppMethodBeat.i(131579);
    this.rGa.c(paramInt, paramView);
    AppMethodBeat.o(131579);
  }
  
  protected boolean cqn()
  {
    AppMethodBeat.i(131584);
    if (this.rGa.getItemCount() == 0)
    {
      AppMethodBeat.o(131584);
      return true;
    }
    AppMethodBeat.o(131584);
    return false;
  }
  
  protected boolean cqo()
  {
    return true;
  }
  
  public void dG(View paramView)
  {
    AppMethodBeat.i(131578);
    this.rGa.dG(paramView);
    AppMethodBeat.o(131578);
  }
  
  public final void dH(View paramView)
  {
    AppMethodBeat.i(131580);
    this.rGa.dH(paramView);
    AppMethodBeat.o(131580);
  }
  
  public final void dI(View paramView)
  {
    AppMethodBeat.i(131577);
    a locala = this.rGa;
    locala.rFO.add(paramView);
    locala.aE(0, 1);
    AppMethodBeat.o(131577);
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.rGa;
  }
  
  public View getEmptyView()
  {
    return this.Xd;
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(131576);
    super.scrollToPosition(paramInt);
    AppMethodBeat.o(131576);
  }
  
  public void setAdapter(RecyclerView.a parama)
  {
    AppMethodBeat.i(230935);
    a locala = this.rGa;
    if (locala.afJ != null)
    {
      if (!locala.afJ.equals(parama)) {
        locala.afJ.b(locala.rFS);
      }
    }
    else
    {
      locala.afJ = parama;
      if (locala.afJ != null) {
        locala.afJ.a(locala.rFS);
      }
    }
    AppMethodBeat.o(230935);
  }
  
  public void setEmptyView(View paramView)
  {
    AppMethodBeat.i(131581);
    if (this.Xd == paramView)
    {
      AppMethodBeat.o(131581);
      return;
    }
    this.Xd = paramView;
    if (this.Xd != null)
    {
      paramView = this.Xd;
      if (!cqn()) {
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
  
  public void setOnItemClickListener(MRecyclerView.a parama)
  {
    AppMethodBeat.i(131582);
    this.rGb = parama;
    this.rGa.rFQ = new MRecyclerView.2(this);
    AppMethodBeat.o(131582);
  }
  
  public void setOnItemLongClickListener(MRecyclerView.b paramb)
  {
    AppMethodBeat.i(131583);
    this.rGc = paramb;
    this.rGa.rFR = new c()
    {
      public final boolean T(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(131569);
        if (MRecyclerView.c(MRecyclerView.this) != null)
        {
          boolean bool = MRecyclerView.c(MRecyclerView.this).V(paramAnonymousView, paramAnonymousInt);
          AppMethodBeat.o(131569);
          return bool;
        }
        AppMethodBeat.o(131569);
        return false;
      }
    };
    AppMethodBeat.o(131583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView
 * JD-Core Version:    0.7.0.1
 */