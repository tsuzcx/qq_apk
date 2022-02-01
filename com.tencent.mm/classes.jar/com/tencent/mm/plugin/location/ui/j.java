package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.a.d;

public final class j
{
  private d jhO;
  public Context mContext;
  public Resources mResources;
  a sSZ;
  
  public j(Context paramContext, a parama)
  {
    AppMethodBeat.i(55961);
    this.jhO = null;
    this.mContext = paramContext;
    this.sSZ = parama;
    this.mResources = this.mContext.getResources();
    AppMethodBeat.o(55961);
  }
  
  public final void cJV()
  {
    AppMethodBeat.i(55962);
    Object localObject = g.afB().afk().get(67590, null);
    if (localObject == null) {}
    for (boolean bool = false; !bool; bool = ((Boolean)localObject).booleanValue())
    {
      com.tencent.mm.ui.base.h.a(this.mContext, this.mResources.getString(2131760736), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(55957);
          if (j.this.sSZ != null) {
            j.this.sSZ.cJW();
          }
          AppMethodBeat.o(55957);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      g.afB().afk().set(67590, Boolean.TRUE);
      AppMethodBeat.o(55962);
      return;
    }
    if (this.sSZ != null) {
      this.sSZ.cJW();
    }
    AppMethodBeat.o(55962);
  }
  
  public static abstract interface a
  {
    public abstract void FG(int paramInt);
    
    public abstract void cJW();
    
    public abstract void cJX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.j
 * JD-Core Version:    0.7.0.1
 */