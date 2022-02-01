package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;

final class SmartGalleryUI$f$b
  extends RecyclerView.w
{
  private TextView oay;
  
  SmartGalleryUI$f$b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(111694);
    this.oay = ((TextView)paramView.findViewById(2131297928));
    aj.a(this.oay.getPaint(), 0.8F);
    AppMethodBeat.o(111694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.f.b
 * JD-Core Version:    0.7.0.1
 */