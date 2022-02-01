package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hs;
import java.util.List;

public final class AppBrandIDCardShowFrag$a
  extends RecyclerView.a<a>
{
  private List<hs> nZr;
  
  public AppBrandIDCardShowFrag$a(List<hs> paramList)
  {
    this.nZr = paramList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(48917);
    if (this.nZr == null)
    {
      AppMethodBeat.o(48917);
      return 0;
    }
    int i = this.nZr.size();
    AppMethodBeat.o(48917);
    return i;
  }
  
  public static final class a
    extends RecyclerView.v
  {
    public TextView gxs;
    public TextView nZs;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(48916);
      this.gxs = ((TextView)paramView.findViewById(2131296826));
      this.nZs = ((TextView)paramView.findViewById(2131296827));
      AppMethodBeat.o(48916);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.a
 * JD-Core Version:    0.7.0.1
 */