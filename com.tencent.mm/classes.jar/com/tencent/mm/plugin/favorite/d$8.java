package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.ui.widget.b.c.a.b;

final class d$8
  implements c.a.b
{
  d$8(g paramg, aca paramaca, Context paramContext) {}
  
  public final void byw()
  {
    AppMethodBeat.i(20506);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", this.msP.field_localId);
    localIntent.putExtra("key_detail_data_id", this.msQ.mBq);
    localIntent.putExtra("show_share", false);
    b.b(this.val$context, ".ui.FavImgGalleryUI", localIntent);
    AppMethodBeat.o(20506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d.8
 * JD-Core Version:    0.7.0.1
 */