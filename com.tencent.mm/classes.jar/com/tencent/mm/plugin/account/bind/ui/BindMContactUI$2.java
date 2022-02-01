package com.tencent.mm.plugin.account.bind.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;

final class BindMContactUI$2
  implements MMHandlerThread.IWaitWorkThread
{
  String num;
  
  BindMContactUI$2(BindMContactUI paramBindMContactUI) {}
  
  public final boolean doInBackground()
  {
    AppMethodBeat.i(109888);
    AppMethodBeat.o(109888);
    return true;
  }
  
  public final boolean onPostExecute()
  {
    AppMethodBeat.i(109887);
    if (Util.isNullOrNil(BindMContactUI.b(this.mSx).getText().trim()))
    {
      if (Util.isNullOrNil(this.num)) {
        break label85;
      }
      BindMContactUI.b(this.mSx).setText(this.num);
      BindMContactUI.b(this.mSx).setSelection(this.num.length());
    }
    for (;;)
    {
      AppMethodBeat.o(109887);
      return true;
      label85:
      BindMContactUI.b(this.mSx).setText("");
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(109889);
    String str = super.toString() + "|initView";
    AppMethodBeat.o(109889);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI.2
 * JD-Core Version:    0.7.0.1
 */