package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class MassSendMsgUI$5
  implements c.a
{
  MassSendMsgUI$5(MassSendMsgUI paramMassSendMsgUI) {}
  
  public final void b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    y.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2 });
    if ((paramInt1 < 0) && (paramInt1 != -50002))
    {
      Toast.makeText(this.mbI, this.mbI.getString(R.l.video_export_file_error), 0).show();
      if (MassSendMsgUI.e(this.mbI) != null)
      {
        MassSendMsgUI.e(this.mbI).dismiss();
        MassSendMsgUI.f(this.mbI);
      }
      return;
    }
    e.post(new MassSendMsgUI.5.1(this, paramString1, paramString2, paramInt2), "MassSend_Remux");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.5
 * JD-Core Version:    0.7.0.1
 */