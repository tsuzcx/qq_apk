package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.ui.widget.a.d.a.b;

final class d$6
  implements d.a.b
{
  d$6(ahe paramahe, Context paramContext) {}
  
  public final void crN()
  {
    AppMethodBeat.i(24576);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 1);
    if (this.qVe != null)
    {
      localIntent.putExtra("kwebmap_slat", this.qVe.lat);
      localIntent.putExtra("kwebmap_lng", this.qVe.lng);
      localIntent.putExtra("Kwebmap_locaion", this.qVe.label);
    }
    localIntent.putExtra("kShowshare", false);
    d.b(this.val$context, "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(24576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d.6
 * JD-Core Version:    0.7.0.1
 */