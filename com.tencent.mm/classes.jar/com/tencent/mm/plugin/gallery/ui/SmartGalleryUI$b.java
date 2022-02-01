package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.s.c;
import com.tencent.mm.ui.aj;
import java.util.Map;

final class SmartGalleryUI$b
  extends RecyclerView.a<a>
{
  private Context mContext;
  SmartGalleryUI.c sTl;
  s.c sTv;
  
  SmartGalleryUI$b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111686);
    if (this.sTv == null)
    {
      AppMethodBeat.o(111686);
      return 0;
    }
    int i = this.sTv.sLf.size();
    AppMethodBeat.o(111686);
    return i;
  }
  
  static final class a
    extends RecyclerView.w
  {
    TextView oay;
    RecyclerView sTw;
    
    a(View paramView)
    {
      super();
      AppMethodBeat.i(111685);
      this.oay = ((TextView)paramView.findViewById(2131297928));
      aj.a(this.oay.getPaint(), 0.8F);
      this.sTw = ((RecyclerView)paramView.findViewById(2131297927));
      AppMethodBeat.o(111685);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.b
 * JD-Core Version:    0.7.0.1
 */