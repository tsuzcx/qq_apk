package com.tencent.mm.plugin.appbrand.menu.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.List;

public final class d$b
  extends RecyclerView.a<a>
{
  private final List<String> tlg;
  private final d.a tlh;
  
  public d$b(List<String> paramList, d.a parama)
  {
    AppMethodBeat.i(134923);
    this.tlg = new ArrayList(paramList);
    this.tlh = parama;
    AppMethodBeat.o(134923);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(134924);
    int i = this.tlg.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.a.d.b
 * JD-Core Version:    0.7.0.1
 */