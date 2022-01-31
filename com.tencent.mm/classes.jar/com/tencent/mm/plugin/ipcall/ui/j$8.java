package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.ui.g;
import com.tencent.mm.sdk.platformtools.ae;

final class j$8
  implements View.OnClickListener
{
  j$8(j paramj) {}
  
  public final void onClick(View arg1)
  {
    c localc = i.bcl();
    synchronized (localc.jYz)
    {
      if (i.bck().bca())
      {
        if (localc.loo)
        {
          localc.bbI();
          return;
        }
        localc.loo = true;
        Toast.makeText(ae.getContext(), R.l.multitalk_mini_toast, 0).show();
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.setClass(ae.getContext(), IPCallTalkUI.class);
        localIntent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        b.bPy().a(localIntent, localc.lop);
        localc.bbI();
        if (localc.lof != null) {
          localc.lof.bbP();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.8
 * JD-Core Version:    0.7.0.1
 */