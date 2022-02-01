package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import java.util.ArrayList;
import java.util.List;

final class AppBrandMenuHeader$a
  extends RecyclerView.a<b>
{
  private List<a> bMf;
  
  public AppBrandMenuHeader$a(List<a> paramList)
  {
    AppMethodBeat.i(325053);
    this.bMf = new ArrayList();
    this.bMf.addAll(paramList);
    AppMethodBeat.o(325053);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(325056);
    int i = this.bMf.size();
    AppMethodBeat.o(325056);
    return i;
  }
  
  static final class a
  {
    View.OnClickListener fhU;
    String key;
    String value;
    
    public a(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      this.key = paramString1;
      this.value = paramString2;
      this.fhU = paramOnClickListener;
    }
  }
  
  static final class b
    extends RecyclerView.v
  {
    TextView tuf;
    TextView tug;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(324865);
      this.tuf = ((TextView)paramView.findViewById(ba.f.key));
      this.tug = ((TextView)paramView.findViewById(ba.f.value));
      AppMethodBeat.o(324865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader.a
 * JD-Core Version:    0.7.0.1
 */