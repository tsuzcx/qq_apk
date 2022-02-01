package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.protocal.protobuf.hi;
import java.util.List;

public final class AppBrandIDCardShowFrag$a
  extends RecyclerView.a<a>
{
  private List<hi> rbc;
  
  public AppBrandIDCardShowFrag$a(List<hi> paramList)
  {
    this.rbc = paramList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(48917);
    if (this.rbc == null)
    {
      AppMethodBeat.o(48917);
      return 0;
    }
    int i = this.rbc.size();
    AppMethodBeat.o(48917);
    return i;
  }
  
  public static final class a
    extends RecyclerView.v
  {
    public TextView jbF;
    public TextView rbd;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(48916);
      this.jbF = ((TextView)paramView.findViewById(au.f.app_brand_idcard_show_item_name));
      this.rbd = ((TextView)paramView.findViewById(au.f.app_brand_idcard_show_item_value));
      AppMethodBeat.o(48916);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.a
 * JD-Core Version:    0.7.0.1
 */