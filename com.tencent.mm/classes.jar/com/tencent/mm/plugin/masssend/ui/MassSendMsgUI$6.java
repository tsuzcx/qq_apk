package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class MassSendMsgUI$6
  implements c.a
{
  MassSendMsgUI$6(MassSendMsgUI paramMassSendMsgUI) {}
  
  public final void b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(153546);
    ab.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2 });
    if ((paramInt1 < 0) && (paramInt1 != -50002))
    {
      Toast.makeText(this.oCj, this.oCj.getString(2131304513), 0).show();
      if (MassSendMsgUI.d(this.oCj) != null)
      {
        MassSendMsgUI.d(this.oCj).dismiss();
        MassSendMsgUI.e(this.oCj);
        AppMethodBeat.o(153546);
      }
    }
    else
    {
      d.post(new MassSendMsgUI.6.1(this, paramString1, paramString2, paramInt2), "MassSend_Remux");
    }
    AppMethodBeat.o(153546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.6
 * JD-Core Version:    0.7.0.1
 */