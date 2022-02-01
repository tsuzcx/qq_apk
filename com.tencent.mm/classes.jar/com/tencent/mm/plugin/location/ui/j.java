package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public final class j
{
  private d jId;
  public Context mContext;
  public Resources mResources;
  a ubl;
  
  public j(Context paramContext, a parama)
  {
    AppMethodBeat.i(55961);
    this.jId = null;
    this.mContext = paramContext;
    this.ubl = parama;
    this.mResources = this.mContext.getResources();
    AppMethodBeat.o(55961);
  }
  
  public final void cXA()
  {
    AppMethodBeat.i(55962);
    Object localObject = g.agR().agA().get(67590, null);
    if (localObject == null) {}
    for (boolean bool = false; !bool; bool = ((Boolean)localObject).booleanValue())
    {
      h.a(this.mContext, this.mResources.getString(2131760736), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(55957);
          if (j.this.ubl != null) {
            j.this.ubl.cXB();
          }
          AppMethodBeat.o(55957);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      g.agR().agA().set(67590, Boolean.TRUE);
      AppMethodBeat.o(55962);
      return;
    }
    if (this.ubl != null) {
      this.ubl.cXB();
    }
    AppMethodBeat.o(55962);
  }
  
  public static abstract interface a
  {
    public abstract void HB(int paramInt);
    
    public abstract void cXB();
    
    public abstract void cXC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.j
 * JD-Core Version:    0.7.0.1
 */