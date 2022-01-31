package com.tencent.mm.plugin.ipcall.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class e$6
  implements Runnable
{
  e$6(e parame) {}
  
  public final void run()
  {
    au.Hx();
    if (((Boolean)c.Dz().get(ac.a.uqf, Boolean.valueOf(false))).booleanValue()) {
      this.lup.luo.setVisibility(0);
    }
    String str2;
    for (;;)
    {
      au.Hx();
      String str1 = (String)c.Dz().get(ac.a.uqh, "");
      au.Hx();
      str2 = (String)c.Dz().get(ac.a.uqi, "");
      if (bk.bl(str1)) {
        break;
      }
      this.lup.lun.setText(str1);
      this.lup.lum.setVisibility(0);
      return;
      this.lup.luo.setVisibility(8);
    }
    if (!bk.bl(str2))
    {
      this.lup.lun.setText(str2);
      this.lup.lum.setVisibility(0);
      return;
    }
    this.lup.lun.setText("");
    this.lup.lum.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.6
 * JD-Core Version:    0.7.0.1
 */