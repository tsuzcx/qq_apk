package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.ui.widget.b.c.a.b;

final class d$5
  implements c.a.b
{
  d$5(ach paramach, Context paramContext) {}
  
  public final void byw()
  {
    AppMethodBeat.i(20503);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 1);
    localIntent.putExtra("kwebmap_slat", this.mEG.lat);
    localIntent.putExtra("kwebmap_lng", this.mEG.lng);
    localIntent.putExtra("Kwebmap_locaion", this.mEG.label);
    localIntent.putExtra("kShowshare", false);
    d.b(this.val$context, "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(20503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d.5
 * JD-Core Version:    0.7.0.1
 */