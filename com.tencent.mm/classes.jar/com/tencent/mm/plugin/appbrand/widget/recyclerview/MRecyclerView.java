package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class MRecyclerView
  extends RecyclerView
{
  protected a jwt;
  private MRecyclerView.a jwu;
  private MRecyclerView.b jwv;
  private View xy;
  
  public MRecyclerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(77494);
    init();
    AppMethodBeat.o(77494);
  }
  
  public MRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(77495);
    init();
    AppMethodBeat.o(77495);
  }
  
  public MRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77496);
    init();
    AppMethodBeat.o(77496);
  }
  
  private void init()
  {
    AppMethodBeat.i(77497);
    this.jwt = new a();
    if (aSn()) {
      this.jwt.jv();
    }
    super.setAdapter(this.jwt);
    this.jwt.a(new MRecyclerView.1(this));
    AppMethodBeat.o(77497);
  }
  
  public final int S(RecyclerView.v paramv)
  {
    AppMethodBeat.i(77498);
    if (this.jwt == null)
    {
      AppMethodBeat.o(77498);
      return -1;
    }
    a locala = this.jwt;
    if (paramv == null)
    {
      AppMethodBeat.o(77498);
      return -1;
    }
    if (paramv.jN() == -1)
    {
      AppMethodBeat.o(77498);
      return -1;
    }
    int j = paramv.jN();
    if (locala.jwh.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      AppMethodBeat.o(77498);
      return j - i;
    }
  }
  
  protected boolean aSm()
  {
    AppMethodBeat.i(77508);
    if (this.jwt.getItemCount() == 0)
    {
      AppMethodBeat.o(77508);
      return true;
    }
    AppMethodBeat.o(77508);
    return false;
  }
  
  protected boolean aSn()
  {
    return true;
  }
  
  public void addFooterView(View paramView)
  {
    AppMethodBeat.i(77502);
    this.jwt.addFooterView(paramView);
    AppMethodBeat.o(77502);
  }
  
  public final void addHeaderView(View paramView)
  {
    AppMethodBeat.i(77501);
    a locala = this.jwt;
    locala.jwh.add(paramView);
    locala.an(0, 1);
    AppMethodBeat.o(77501);
  }
  
  public final void b(int paramInt, View paramView)
  {
    AppMethodBeat.i(77503);
    this.jwt.b(paramInt, paramView);
    AppMethodBeat.o(77503);
  }
  
  public final void bJ(int paramInt)
  {
    AppMethodBeat.i(77500);
    super.bJ(paramInt);
    AppMethodBeat.o(77500);
  }
  
  public final void cZ(View paramView)
  {
    AppMethodBeat.i(77504);
    this.jwt.cZ(paramView);
    AppMethodBeat.o(77504);
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.jwt;
  }
  
  public View getEmptyView()
  {
    return this.xy;
  }
  
  public void setAdapter(RecyclerView.a parama)
  {
    AppMethodBeat.i(77499);
    a locala = this.jwt;
    if (locala.Tg != null)
    {
      if (!locala.Tg.equals(parama)) {
        locala.Tg.b(locala.jwl);
      }
    }
    else
    {
      locala.Tg = parama;
      if (locala.Tg != null) {
        locala.Tg.a(locala.jwl);
      }
    }
    AppMethodBeat.o(77499);
  }
  
  public void setEmptyView(View paramView)
  {
    AppMethodBeat.i(77505);
    if (this.xy == paramView)
    {
      AppMethodBeat.o(77505);
      return;
    }
    this.xy = paramView;
    if (this.xy != null)
    {
      paramView = this.xy;
      if (!aSm()) {
        break label56;
      }
    }
    label56:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(77505);
      return;
    }
  }
  
  public void setOnItemClickListener(MRecyclerView.a parama)
  {
    AppMethodBeat.i(77506);
    this.jwu = parama;
    this.jwt.jwj = new MRecyclerView.2(this);
    AppMethodBeat.o(77506);
  }
  
  public void setOnItemLongClickListener(MRecyclerView.b paramb)
  {
    AppMethodBeat.i(77507);
    this.jwv = paramb;
    this.jwt.jwk = new MRecyclerView.3(this);
    AppMethodBeat.o(77507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView
 * JD-Core Version:    0.7.0.1
 */