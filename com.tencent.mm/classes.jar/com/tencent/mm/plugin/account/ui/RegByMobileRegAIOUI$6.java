package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;

final class RegByMobileRegAIOUI$6
  implements MMHandlerThread.IWaitWorkThread
{
  String nickname;
  
  RegByMobileRegAIOUI$6(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final boolean doInBackground()
  {
    AppMethodBeat.i(169150);
    AppMethodBeat.o(169150);
    return true;
  }
  
  public final boolean onPostExecute()
  {
    AppMethodBeat.i(169149);
    if ((!Util.isNullOrNil(this.nickname)) && (Util.isNullOrNil(RegByMobileRegAIOUI.n(this.nic).getText().trim()))) {
      RegByMobileRegAIOUI.n(this.nic).setText(this.nickname);
    }
    if (!e.avA())
    {
      Log.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
      AppMethodBeat.o(169149);
      return false;
    }
    if ((RegByMobileRegAIOUI.q(this.nic) != null) && (!RegByMobileRegAIOUI.q(this.nic).isRecycled()) && (!RegByMobileRegAIOUI.r(this.nic)))
    {
      RegByMobileRegAIOUI.s(this.nic).setImageBitmap(RegByMobileRegAIOUI.q(this.nic));
      RegByMobileRegAIOUI.t(this.nic).setVisibility(8);
      RegByMobileRegAIOUI.u(this.nic);
    }
    AppMethodBeat.o(169149);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169151);
    String str = super.toString() + "|initView2";
    AppMethodBeat.o(169151);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.6
 * JD-Core Version:    0.7.0.1
 */