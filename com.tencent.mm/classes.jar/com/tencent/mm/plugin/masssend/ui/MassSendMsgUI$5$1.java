package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.p;

final class MassSendMsgUI$5$1
  implements Runnable
{
  MassSendMsgUI$5$1(MassSendMsgUI.5 param5, String paramString1, String paramString2, int paramInt) {}
  
  public final void run()
  {
    if (MassSendMsgUI.a(this.mbL.mbI, this.eIv, this.mbK))
    {
      ai.d(new MassSendMsgUI.5.1.1(this));
      return;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        Toast.makeText(MassSendMsgUI.5.1.this.mbL.mbI, MassSendMsgUI.5.1.this.mbL.mbI.getString(R.l.video_export_file_too_big), 0).show();
        if (MassSendMsgUI.e(MassSendMsgUI.5.1.this.mbL.mbI) != null)
        {
          MassSendMsgUI.e(MassSendMsgUI.5.1.this.mbL.mbI).dismiss();
          MassSendMsgUI.f(MassSendMsgUI.5.1.this.mbL.mbI);
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.5.1
 * JD-Core Version:    0.7.0.1
 */