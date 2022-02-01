package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class y$1
  implements n.c
{
  y$1(boolean paramBoolean, Context paramContext) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(182097);
    if (this.fsJ)
    {
      paraml.c(0, this.val$context.getString(2131757054));
      AppMethodBeat.o(182097);
      return;
    }
    paraml.a(0, this.val$context.getResources().getColor(2131099803), this.val$context.getString(2131757053));
    AppMethodBeat.o(182097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.y.1
 * JD-Core Version:    0.7.0.1
 */