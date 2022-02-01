package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.widget.a.d;

public final class j
{
  private d ljp;
  public Context mContext;
  public Resources mResources;
  a yJV;
  
  public j(Context paramContext, a parama)
  {
    AppMethodBeat.i(55961);
    this.ljp = null;
    this.mContext = paramContext;
    this.yJV = parama;
    this.mResources = this.mContext.getResources();
    AppMethodBeat.o(55961);
  }
  
  public final void edw()
  {
    AppMethodBeat.i(55962);
    Object localObject = g.aAh().azQ().get(67590, null);
    if (localObject == null) {}
    for (boolean bool = false; !bool; bool = ((Boolean)localObject).booleanValue())
    {
      com.tencent.mm.ui.base.h.a(this.mContext, this.mResources.getString(2131762477), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(55957);
          if (j.this.yJV != null) {
            j.this.yJV.edx();
          }
          AppMethodBeat.o(55957);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      g.aAh().azQ().set(67590, Boolean.TRUE);
      AppMethodBeat.o(55962);
      return;
    }
    if (this.yJV != null) {
      this.yJV.edx();
    }
    AppMethodBeat.o(55962);
  }
  
  public static abstract interface a
  {
    public abstract void Py(int paramInt);
    
    public abstract void edx();
    
    public abstract void edy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.j
 * JD-Core Version:    0.7.0.1
 */