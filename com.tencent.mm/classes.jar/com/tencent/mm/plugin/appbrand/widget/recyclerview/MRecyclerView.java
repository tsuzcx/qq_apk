package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class MRecyclerView
  extends RecyclerView
{
  protected a hDT;
  private MRecyclerView.a hDU;
  private MRecyclerView.b hDV;
  private View hrf;
  
  public MRecyclerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.hDT = new a();
    if (atd()) {
      this.hDT.hO();
    }
    super.setAdapter(this.hDT);
    this.hDT.a(new RecyclerView.c()
    {
      public final void onChanged()
      {
        View localView;
        if (MRecyclerView.a(MRecyclerView.this) != null)
        {
          localView = MRecyclerView.a(MRecyclerView.this);
          if (!MRecyclerView.this.atc()) {
            break label36;
          }
        }
        label36:
        for (int i = 0;; i = 8)
        {
          localView.setVisibility(i);
          return;
        }
      }
    });
  }
  
  public final int N(RecyclerView.v paramv)
  {
    if (this.hDT == null) {}
    a locala;
    do
    {
      return -1;
      locala = this.hDT;
    } while ((paramv == null) || (paramv.id() == -1));
    int j = paramv.id();
    if (locala.hDH.isEmpty()) {}
    for (int i = 0;; i = 1) {
      return j - i;
    }
  }
  
  public final void a(int paramInt, View paramView)
  {
    this.hDT.a(paramInt, paramView);
  }
  
  public void addFooterView(View paramView)
  {
    this.hDT.addFooterView(paramView);
  }
  
  public final void addHeaderView(View paramView)
  {
    a locala = this.hDT;
    locala.hDH.add(paramView);
    locala.ah(0, 1);
  }
  
  protected boolean atc()
  {
    return this.hDT.getItemCount() == 0;
  }
  
  public boolean atd()
  {
    return true;
  }
  
  public final void bE(int paramInt)
  {
    super.bE(paramInt);
  }
  
  public final void cv(View paramView)
  {
    this.hDT.cv(paramView);
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.hDT;
  }
  
  public View getEmptyView()
  {
    return this.hrf;
  }
  
  public void setAdapter(RecyclerView.a parama)
  {
    a locala = this.hDT;
    if (locala.Sw != null)
    {
      if (!locala.Sw.equals(parama)) {
        locala.Sw.b(locala.hDL);
      }
    }
    else
    {
      locala.Sw = parama;
      if (locala.Sw != null) {
        locala.Sw.a(locala.hDL);
      }
    }
  }
  
  public void setEmptyView(View paramView)
  {
    if (this.hrf == paramView) {}
    do
    {
      return;
      this.hrf = paramView;
    } while (this.hrf == null);
    paramView = this.hrf;
    if (atc()) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return;
    }
  }
  
  public void setOnItemClickListener(MRecyclerView.a parama)
  {
    this.hDU = parama;
    this.hDT.hDJ = new MRecyclerView.2(this);
  }
  
  public void setOnItemLongClickListener(MRecyclerView.b paramb)
  {
    this.hDV = paramb;
    this.hDT.hDK = new MRecyclerView.3(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView
 * JD-Core Version:    0.7.0.1
 */