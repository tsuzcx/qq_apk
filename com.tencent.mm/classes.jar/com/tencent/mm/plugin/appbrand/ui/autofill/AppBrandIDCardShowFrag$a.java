package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hf;
import java.util.List;

public final class AppBrandIDCardShowFrag$a
  extends RecyclerView.a<a>
{
  private List<hf> mHf;
  
  public AppBrandIDCardShowFrag$a(List<hf> paramList)
  {
    this.mHf = paramList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(48917);
    if (this.mHf == null)
    {
      AppMethodBeat.o(48917);
      return 0;
    }
    int i = this.mHf.size();
    AppMethodBeat.o(48917);
    return i;
  }
  
  public static final class a
    extends RecyclerView.w
  {
    public TextView fQd;
    public TextView mHg;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(48916);
      this.fQd = ((TextView)paramView.findViewById(2131296745));
      this.mHg = ((TextView)paramView.findViewById(2131296746));
      AppMethodBeat.o(48916);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.a
 * JD-Core Version:    0.7.0.1
 */