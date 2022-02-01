package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;

final class RegSetInfoUI$23
  implements MMHandlerThread.IWaitWorkThread
{
  Bitmap mBitmap;
  String njH;
  
  RegSetInfoUI$23(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final boolean doInBackground()
  {
    AppMethodBeat.i(128690);
    AppMethodBeat.o(128690);
    return true;
  }
  
  public final boolean onPostExecute()
  {
    AppMethodBeat.i(128689);
    if ((!Util.isNullOrNil(this.njH)) && (Util.isNullOrNil(RegSetInfoUI.b(this.njA).getText().trim()))) {
      RegSetInfoUI.b(this.njA).setText(this.njH);
    }
    if (!e.avA())
    {
      Log.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
      AppMethodBeat.o(128689);
      return false;
    }
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()) && (!RegSetInfoUI.j(this.njA)))
    {
      RegSetInfoUI.i(this.njA).setImageBitmap(this.mBitmap);
      RegSetInfoUI.k(this.njA);
      RegSetInfoUI.l(this.njA).setVisibility(0);
    }
    AppMethodBeat.o(128689);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(128691);
    String str = super.toString() + "|initView";
    AppMethodBeat.o(128691);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.23
 * JD-Core Version:    0.7.0.1
 */