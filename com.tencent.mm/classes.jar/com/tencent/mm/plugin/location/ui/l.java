package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class l
{
  private c fTk = null;
  l.a lGZ;
  public Context mContext;
  public Resources mResources;
  
  public l(Context paramContext, l.a parama)
  {
    this.mContext = paramContext;
    this.lGZ = parama;
    this.mResources = this.mContext.getResources();
  }
  
  public final void beB()
  {
    Object localObject = g.DP().Dz().get(67590, null);
    boolean bool;
    if (localObject == null)
    {
      bool = false;
      if (bool) {
        break label87;
      }
      h.a(this.mContext, this.mResources.getString(a.h.location_sharing_go_on_tips), "", false, new DialogInterface.OnClickListener()new l.2
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (l.this.lGZ != null) {
            l.this.lGZ.beC();
          }
        }
      }, new l.2(this));
      g.DP().Dz().o(67590, Boolean.valueOf(true));
    }
    label87:
    while (this.lGZ == null)
    {
      return;
      bool = ((Boolean)localObject).booleanValue();
      break;
    }
    this.lGZ.beC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.l
 * JD-Core Version:    0.7.0.1
 */