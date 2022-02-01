package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.model.t.c;
import com.tencent.mm.ui.aw;
import java.util.Map;

final class SmartGalleryUI$b
  extends RecyclerView.a<a>
{
  t.c HQD;
  SmartGalleryUI.c HQu;
  private Context mContext;
  
  SmartGalleryUI$b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111686);
    if (this.HQD == null)
    {
      AppMethodBeat.o(111686);
      return 0;
    }
    int i = this.HQD.HIG.size();
    AppMethodBeat.o(111686);
    return i;
  }
  
  static final class a
    extends RecyclerView.v
  {
    RecyclerView HQE;
    TextView wyA;
    
    a(View paramView)
    {
      super();
      AppMethodBeat.i(111685);
      this.wyA = ((TextView)paramView.findViewById(b.e.category_title));
      aw.a(this.wyA.getPaint(), 0.8F);
      this.HQE = ((RecyclerView)paramView.findViewById(b.e.category_detail));
      AppMethodBeat.o(111685);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.b
 * JD-Core Version:    0.7.0.1
 */