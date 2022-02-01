package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;

final class y$1
  implements o.f
{
  y$1(boolean paramBoolean, Context paramContext) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(182097);
    if (this.gsy)
    {
      paramm.d(0, this.val$context.getString(2131757251));
      AppMethodBeat.o(182097);
      return;
    }
    paramm.a(0, this.val$context.getResources().getColor(2131099818), this.val$context.getString(2131757250));
    AppMethodBeat.o(182097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.y.1
 * JD-Core Version:    0.7.0.1
 */