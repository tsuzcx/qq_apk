package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public final class j
{
  private d kcp;
  public Context mContext;
  public Resources mResources;
  a vdU;
  
  public j(Context paramContext, a parama)
  {
    AppMethodBeat.i(55961);
    this.kcp = null;
    this.mContext = paramContext;
    this.vdU = parama;
    this.mResources = this.mContext.getResources();
    AppMethodBeat.o(55961);
  }
  
  public final void dgM()
  {
    AppMethodBeat.i(55962);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(67590, null);
    if (localObject == null) {}
    for (boolean bool = false; !bool; bool = ((Boolean)localObject).booleanValue())
    {
      h.a(this.mContext, this.mResources.getString(2131760736), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(55957);
          if (j.this.vdU != null) {
            j.this.vdU.dgN();
          }
          AppMethodBeat.o(55957);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      com.tencent.mm.kernel.g.ajC().ajl().set(67590, Boolean.TRUE);
      AppMethodBeat.o(55962);
      return;
    }
    if (this.vdU != null) {
      this.vdU.dgN();
    }
    AppMethodBeat.o(55962);
  }
  
  public static abstract interface a
  {
    public abstract void IX(int paramInt);
    
    public abstract void dgN();
    
    public abstract void dgO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.j
 * JD-Core Version:    0.7.0.1
 */