package com.tencent.mm.plugin.choosemsgfile.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.choosemsgfile.a.h;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

final class ChooseMsgFileShowUI$4$2$1
  implements ExportFileUtil.a
{
  ChooseMsgFileShowUI$4$2$1(ChooseMsgFileShowUI.4.2 param2) {}
  
  public final void cg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(262569);
    Toast.makeText(this.wRd.wRc.wRa, this.wRd.wRc.wRa.getString(a.h.toast_file_saved_fmt, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramString2) }), 1).show();
    AppMethodBeat.o(262569);
  }
  
  public final void ch(String paramString1, String paramString2)
  {
    AppMethodBeat.i(262570);
    Toast.makeText(this.wRd.wRc.wRa, this.wRd.wRc.wRa.getString(a.h.toast_file_saved_fail), 1).show();
    AppMethodBeat.o(262570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.4.2.1
 * JD-Core Version:    0.7.0.1
 */