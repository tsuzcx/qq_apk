package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMFormInputView;

final class RegByMobileRegAIOUI$9
  implements ai.a
{
  Bitmap bitmap;
  String nickname;
  
  RegByMobileRegAIOUI$9(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final boolean JS()
  {
    this.nickname = i.bI(this.fqF);
    this.bitmap = i.bJ(this.fqF);
    if ((this.bitmap != null) && (!this.bitmap.isRecycled())) {}
    try
    {
      c.a(this.bitmap, 100, Bitmap.CompressFormat.PNG, e.dzK + "temp.avatar", false);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.RegByMobileRegAIOUI", "save avatar fail." + localException.getMessage());
        y.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", localException, "", new Object[0]);
      }
    }
  }
  
  public final boolean JT()
  {
    if ((!bk.bl(this.nickname)) && (bk.bl(RegByMobileRegAIOUI.i(this.fqF).getText().trim()))) {
      RegByMobileRegAIOUI.i(this.fqF).setText(this.nickname);
    }
    if (!f.zF())
    {
      y.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
      return false;
    }
    if ((this.bitmap != null) && (!this.bitmap.isRecycled()) && (!RegByMobileRegAIOUI.l(this.fqF)))
    {
      RegByMobileRegAIOUI.m(this.fqF).setImageBitmap(this.bitmap);
      RegByMobileRegAIOUI.n(this.fqF).setVisibility(8);
      RegByMobileRegAIOUI.o(this.fqF);
    }
    return true;
  }
  
  public final String toString()
  {
    return super.toString() + "|initView2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.9
 * JD-Core Version:    0.7.0.1
 */