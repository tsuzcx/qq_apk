package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.ui.aw;

final class SmartGalleryUI$f$b
  extends RecyclerView.v
{
  private TextView wyA;
  
  SmartGalleryUI$f$b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(111694);
    this.wyA = ((TextView)paramView.findViewById(b.e.category_title));
    aw.a(this.wyA.getPaint(), 0.8F);
    AppMethodBeat.o(111694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.f.b
 * JD-Core Version:    0.7.0.1
 */