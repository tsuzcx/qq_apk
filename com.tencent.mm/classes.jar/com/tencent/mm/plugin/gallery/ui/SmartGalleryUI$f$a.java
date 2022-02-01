package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SmartGalleryUI$f$a
  extends RecyclerView.w
{
  private ImageView sTs;
  private TextView sTt;
  private TextView sTu;
  
  SmartGalleryUI$f$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(111693);
    this.sTs = ((ImageView)paramView.findViewById(2131296565));
    this.sTt = ((TextView)paramView.findViewById(2131296593));
    this.sTu = ((TextView)paramView.findViewById(2131296542));
    AppMethodBeat.o(111693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.f.a
 * JD-Core Version:    0.7.0.1
 */