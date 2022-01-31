package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.b.c.a.b;

final class d$4
  implements c.a.b
{
  d$4(g paramg, Context paramContext) {}
  
  public final void byw()
  {
    AppMethodBeat.i(20502);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_Msg_content", this.msP.field_favProto.desc);
    d.f(this.val$context, ".ui.transmit.RetransmitPreviewUI", localIntent);
    b.jdMethod_if(this.val$context);
    AppMethodBeat.o(20502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d.4
 * JD-Core Version:    0.7.0.1
 */