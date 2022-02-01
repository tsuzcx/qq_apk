package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;

public final class j
{
  a Kgw;
  public Context mContext;
  public Resources mResources;
  private e reR;
  
  public j(Context paramContext, a parama)
  {
    AppMethodBeat.i(55961);
    this.reR = null;
    this.mContext = paramContext;
    this.Kgw = parama;
    this.mResources = this.mContext.getResources();
    AppMethodBeat.o(55961);
  }
  
  public final void fjO()
  {
    AppMethodBeat.i(55962);
    Object localObject = h.baE().ban().d(67590, null);
    if (localObject == null) {}
    for (boolean bool = false; !bool; bool = ((Boolean)localObject).booleanValue())
    {
      k.a(this.mContext, this.mResources.getString(a.i.location_sharing_go_on_tips), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(55957);
          if (j.this.Kgw != null) {
            j.this.Kgw.fVk();
          }
          AppMethodBeat.o(55957);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      h.baE().ban().B(67590, Boolean.TRUE);
      AppMethodBeat.o(55962);
      return;
    }
    if (this.Kgw != null) {
      this.Kgw.fVk();
    }
    AppMethodBeat.o(55962);
  }
  
  public static abstract interface a
  {
    public abstract void ZD(int paramInt);
    
    public abstract void fVk();
    
    public abstract void fVl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.j
 * JD-Core Version:    0.7.0.1
 */