package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.MMFormInputView;

final class RegByMobileRegAIOUI$7
  implements al.a
{
  String nickname;
  
  RegByMobileRegAIOUI$7(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(152589);
    this.nickname = i.cp(this.gIh);
    RegByMobileRegAIOUI.a(this.gIh, i.cq(this.gIh));
    if ((RegByMobileRegAIOUI.p(this.gIh) != null) && (!RegByMobileRegAIOUI.p(this.gIh).isRecycled())) {}
    try
    {
      d.a(RegByMobileRegAIOUI.p(this.gIh), 100, Bitmap.CompressFormat.PNG, e.esy + "temp.avatar", false);
      AppMethodBeat.o(152589);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.RegByMobileRegAIOUI", "save avatar fail." + localException.getMessage());
        ab.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", localException, "", new Object[0]);
      }
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(152588);
    if ((!bo.isNullOrNil(this.nickname)) && (bo.isNullOrNil(RegByMobileRegAIOUI.m(this.gIh).getText().trim()))) {
      RegByMobileRegAIOUI.m(this.gIh).setText(this.nickname);
    }
    if (!f.Mi())
    {
      ab.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
      AppMethodBeat.o(152588);
      return false;
    }
    if ((RegByMobileRegAIOUI.p(this.gIh) != null) && (!RegByMobileRegAIOUI.p(this.gIh).isRecycled()) && (!RegByMobileRegAIOUI.q(this.gIh)))
    {
      RegByMobileRegAIOUI.r(this.gIh).setImageBitmap(RegByMobileRegAIOUI.p(this.gIh));
      RegByMobileRegAIOUI.s(this.gIh).setVisibility(8);
      RegByMobileRegAIOUI.t(this.gIh);
    }
    AppMethodBeat.o(152588);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152590);
    String str = super.toString() + "|initView2";
    AppMethodBeat.o(152590);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.7
 * JD-Core Version:    0.7.0.1
 */