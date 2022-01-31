package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

public final class l
{
  private c hmL;
  public Context mContext;
  public Resources mResources;
  l.a oem;
  
  public l(Context paramContext, l.a parama)
  {
    AppMethodBeat.i(113558);
    this.hmL = null;
    this.mContext = paramContext;
    this.oem = parama;
    this.mResources = this.mContext.getResources();
    AppMethodBeat.o(113558);
  }
  
  public final void bLU()
  {
    AppMethodBeat.i(113559);
    Object localObject = g.RL().Ru().get(67590, null);
    if (localObject == null) {}
    for (boolean bool = false; !bool; bool = ((Boolean)localObject).booleanValue())
    {
      h.a(this.mContext, this.mResources.getString(2131301112), "", false, new DialogInterface.OnClickListener()new l.2
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(113554);
          if (l.this.oem != null) {
            l.this.oem.bLV();
          }
          AppMethodBeat.o(113554);
        }
      }, new l.2(this));
      g.RL().Ru().set(67590, Boolean.TRUE);
      AppMethodBeat.o(113559);
      return;
    }
    if (this.oem != null) {
      this.oem.bLV();
    }
    AppMethodBeat.o(113559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.l
 * JD-Core Version:    0.7.0.1
 */