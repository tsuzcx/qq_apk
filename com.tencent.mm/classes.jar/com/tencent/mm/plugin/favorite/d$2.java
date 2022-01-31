package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.a.c.a.b;

final class d$2
  implements c.a.b
{
  d$2(g paramg, Context paramContext) {}
  
  public final void aSe()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_Msg_content", this.jYv.field_favProto.desc);
    d.e(this.val$context, ".ui.transmit.RetransmitPreviewUI", localIntent);
    b.gJ(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d.2
 * JD-Core Version:    0.7.0.1
 */