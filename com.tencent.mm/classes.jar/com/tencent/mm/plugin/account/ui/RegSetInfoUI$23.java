package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class RegSetInfoUI$23
  implements ai.a
{
  String fsv;
  Bitmap mBitmap;
  
  RegSetInfoUI$23(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final boolean JS()
  {
    try
    {
      this.fsv = i.bI(this.fso);
      this.mBitmap = i.bJ(this.fso);
      if ((this.mBitmap == null) || (this.mBitmap.isRecycled())) {}
    }
    catch (Exception localException1)
    {
      try
      {
        c.a(this.mBitmap, 100, Bitmap.CompressFormat.PNG, e.dzK + "temp.avatar", false);
        return true;
        localException1 = localException1;
        y.e("MiroMsg.RegSetInfoUI", "getName or getBitmap err : " + localException1.getMessage());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.e("MiroMsg.RegSetInfoUI", "save avatar fail." + localException2.getMessage());
          y.printErrStackTrace("MiroMsg.RegSetInfoUI", localException2, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean JT()
  {
    if ((!bk.bl(this.fsv)) && (bk.bl(RegSetInfoUI.b(this.fso).getText().trim()))) {
      RegSetInfoUI.b(this.fso).setText(this.fsv);
    }
    if (!f.zF())
    {
      y.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
      return false;
    }
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()) && (!RegSetInfoUI.j(this.fso)))
    {
      RegSetInfoUI.i(this.fso).setImageBitmap(this.mBitmap);
      RegSetInfoUI.k(this.fso);
      RegSetInfoUI.l(this.fso).setVisibility(0);
    }
    return true;
  }
  
  public final String toString()
  {
    return super.toString() + "|initView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.23
 * JD-Core Version:    0.7.0.1
 */