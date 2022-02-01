package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.widget.a.d;

public final class j
{
  a EnO;
  public Context mContext;
  public Resources mResources;
  private d odY;
  
  public j(Context paramContext, a parama)
  {
    AppMethodBeat.i(55961);
    this.odY = null;
    this.mContext = paramContext;
    this.EnO = parama;
    this.mResources = this.mContext.getResources();
    AppMethodBeat.o(55961);
  }
  
  public final void ehJ()
  {
    AppMethodBeat.i(55962);
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().b(67590, null);
    if (localObject == null) {}
    for (boolean bool = false; !bool; bool = ((Boolean)localObject).booleanValue())
    {
      com.tencent.mm.ui.base.h.a(this.mContext, this.mResources.getString(a.i.location_sharing_go_on_tips), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(55957);
          if (j.this.EnO != null) {
            j.this.EnO.eMR();
          }
          AppMethodBeat.o(55957);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      com.tencent.mm.kernel.h.aHG().aHp().i(67590, Boolean.TRUE);
      AppMethodBeat.o(55962);
      return;
    }
    if (this.EnO != null) {
      this.EnO.eMR();
    }
    AppMethodBeat.o(55962);
  }
  
  public static abstract interface a
  {
    public abstract void VH(int paramInt);
    
    public abstract void eMR();
    
    public abstract void eMS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.j
 * JD-Core Version:    0.7.0.1
 */