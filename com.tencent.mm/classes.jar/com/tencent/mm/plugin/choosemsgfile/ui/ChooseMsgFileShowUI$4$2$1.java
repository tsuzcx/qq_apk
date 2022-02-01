package com.tencent.mm.plugin.choosemsgfile.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.choosemsgfile.a.h;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

final class ChooseMsgFileShowUI$4$2$1
  implements p.a
{
  ChooseMsgFileShowUI$4$2$1(ChooseMsgFileShowUI.4.2 param2) {}
  
  public final void bT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243482);
    Toast.makeText(this.tNN.tNM.tNK, this.tNN.tNM.tNK.getString(a.h.toast_file_saved_fmt, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramString2) }), 1).show();
    AppMethodBeat.o(243482);
  }
  
  public final void bU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243484);
    Toast.makeText(this.tNN.tNM.tNK, this.tNN.tNM.tNK.getString(a.h.toast_file_saved_fail), 1).show();
    AppMethodBeat.o(243484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.4.2.1
 * JD-Core Version:    0.7.0.1
 */