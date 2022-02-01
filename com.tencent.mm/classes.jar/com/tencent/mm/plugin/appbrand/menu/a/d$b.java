package com.tencent.mm.plugin.appbrand.menu.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class d$b
  extends RecyclerView.a<a>
{
  private final List<String> kST;
  private final d.a kSU;
  
  public d$b(List<String> paramList, d.a parama)
  {
    AppMethodBeat.i(134923);
    this.kST = new ArrayList(paramList);
    this.kSU = parama;
    AppMethodBeat.o(134923);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(134924);
    int i = this.kST.size();
    AppMethodBeat.o(134924);
    return i;
  }
  
  public final class a
    extends RecyclerView.v
  {
    public TextView titleTv;
    
    public a(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.a.d.b
 * JD-Core Version:    0.7.0.1
 */