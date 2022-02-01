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
  private View bEx;
  protected a uRm;
  private MRecyclerView.a uRn;
  private MRecyclerView.b uRo;
  
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
    this.uRm = new a();
    if (cSV()) {
      this.uRm.bf(true);
    }
    super.setAdapter(this.uRm);
    this.uRm.a(new RecyclerView.c()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(131567);
        View localView;
        if (MRecyclerView.a(MRecyclerView.this) != null)
        {
          localView = MRecyclerView.a(MRecyclerView.this);
          if (!MRecyclerView.this.cSU()) {
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
  
  public final int P(RecyclerView.v paramv)
  {
    AppMethodBeat.i(323994);
    if (this.uRm == null)
    {
      AppMethodBeat.o(323994);
      return -1;
    }
    a locala = this.uRm;
    if (paramv == null)
    {
      AppMethodBeat.o(323994);
      return -1;
    }
    if (paramv.KJ() == -1)
    {
      AppMethodBeat.o(323994);
      return -1;
    }
    int j = paramv.KJ();
    if (locala.uRa.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      AppMethodBeat.o(323994);
      return j - i;
    }
  }
  
  protected boolean cSU()
  {
    AppMethodBeat.i(131584);
    if (this.uRm.getItemCount() == 0)
    {
      AppMethodBeat.o(131584);
      return true;
    }
    AppMethodBeat.o(131584);
    return false;
  }
  
  protected boolean cSV()
  {
    return true;
  }
  
  public final void e(int paramInt, View paramView)
  {
    AppMethodBeat.i(131579);
    this.uRm.e(paramInt, paramView);
    AppMethodBeat.o(131579);
  }
  
  public void et(View paramView)
  {
    AppMethodBeat.i(131578);
    this.uRm.et(paramView);
    AppMethodBeat.o(131578);
  }
  
  public final void eu(View paramView)
  {
    AppMethodBeat.i(131580);
    this.uRm.eu(paramView);
    AppMethodBeat.o(131580);
  }
  
  public final void ev(View paramView)
  {
    AppMethodBeat.i(131577);
    a locala = this.uRm;
    locala.uRa.add(paramView);
    locala.by(0, 1);
    AppMethodBeat.o(131577);
  }
  
  public RecyclerView.a<?> getAdapter()
  {
    return this.uRm;
  }
  
  public View getEmptyView()
  {
    return this.bEx;
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(131576);
    super.scrollToPosition(paramInt);
    AppMethodBeat.o(131576);
  }
  
  public void setAdapter(RecyclerView.a parama)
  {
    AppMethodBeat.i(323997);
    a locala = this.uRm;
    if (locala.bUp != null)
    {
      if (!locala.bUp.equals(parama)) {
        locala.bUp.b(locala.uRe);
      }
    }
    else
    {
      locala.bUp = parama;
      if (locala.bUp != null) {
        locala.bUp.a(locala.uRe);
      }
    }
    AppMethodBeat.o(323997);
  }
  
  public void setEmptyView(View paramView)
  {
    AppMethodBeat.i(131581);
    if (this.bEx == paramView)
    {
      AppMethodBeat.o(131581);
      return;
    }
    this.bEx = paramView;
    if (this.bEx != null)
    {
      paramView = this.bEx;
      if (!cSU()) {
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
    this.uRn = parama;
    this.uRm.uRc = new b()
    {
      public final void onItemClick(View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(323991);
        if (MRecyclerView.b(MRecyclerView.this) != null) {
          MRecyclerView.b(MRecyclerView.this).onItemClick(MRecyclerView.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(323991);
      }
    };
    AppMethodBeat.o(131582);
  }
  
  public void setOnItemLongClickListener(MRecyclerView.b paramb)
  {
    AppMethodBeat.i(131583);
    this.uRo = paramb;
    this.uRm.uRd = new c()
    {
      public final boolean a(View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(323992);
        if (MRecyclerView.c(MRecyclerView.this) != null)
        {
          boolean bool = MRecyclerView.c(MRecyclerView.this).onItemLongClick(MRecyclerView.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(323992);
          return bool;
        }
        AppMethodBeat.o(323992);
        return false;
      }
    };
    AppMethodBeat.o(131583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView
 * JD-Core Version:    0.7.0.1
 */